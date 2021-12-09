package ru.geekbrains.jca.lessons.l13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;
    private CyclicBarrier barrier;
    private static int win = 0;
    private static String winName;
    private boolean flag = true;
    public static final int CARS_COUNT = 4;

    public CyclicBarrier barrierFunc() {
        return new CyclicBarrier(CARS_COUNT, () -> {
            if (flag) {
                flag = false;
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            } else {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                System.out.println("Победил " + winName.toLowerCase() + "! Поздравляем!");
            }
        });
    }
    public void goRace() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(this, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
    }
    public CyclicBarrier getBarrier(){
        return barrier;
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.barrier = barrierFunc();
    }

    public synchronized void winner(Car car) {
        if (win == 0) {
            win++;
            winName = car.getName();
        }
    }
}
