package ru.geekbrains.jca.lessons.l13;

import java.util.concurrent.BrokenBarrierException;

public class Car implements Runnable {

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                System.out.println(this.name + " готов");
                race.getBarrier().await();
                for (int i = 0; i < race.getStages().size(); i++) {
                    race.getStages().get(i).go(this);
                }
                race.winner(this);
                race.getBarrier().await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
    }
}
