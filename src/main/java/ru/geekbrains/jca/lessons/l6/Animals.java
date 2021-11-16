package ru.geekbrains.jca.lessons.l6;

public class Animals {
    private String nickname;
    private static int countAnimals;

    public Animals(String nickname) {
        this.nickname = nickname;
        countAnimals++;                 // общий счётчик всех животных
    }

    public int getCount(){
        return countAnimals;
    }

    public void animalRun(int distance) {
        System.out.printf("%s ran %d meters.\n", nickname, distance);
    }

    public void animalSwim(int distance){
        System.out.printf("%s swam %d meters.\n", nickname, distance);
    }

    public String getNickname() {
        return nickname;
    }
}
