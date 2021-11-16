package ru.geekbrains.jca.lessons.l6;

public class Cat extends Animals {

    private static int countCats;
    public Cat(String nickname) {
        super(nickname);
        countCats++;                // общий счётчик котов
    }
    public int getCountCats(){
        return countCats;
    }
}
