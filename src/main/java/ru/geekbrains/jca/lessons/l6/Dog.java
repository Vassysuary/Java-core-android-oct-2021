package ru.geekbrains.jca.lessons.l6;

public class Dog extends Animals {

    private static int countDogs;
    public Dog(String nickname) {
        super(nickname);
        countDogs++;                // общий счётчик собак
    }
    public int getCountDogs(){
        return countDogs;
    }
}
