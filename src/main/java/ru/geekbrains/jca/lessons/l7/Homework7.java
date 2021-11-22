package ru.geekbrains.jca.lessons.l7;

import java.util.Random;

public class Homework7 {
    public static void main(String[] args){
        Random random = new Random();
        Bowl bowl = new Bowl();
        Cat[] cats = {
                new Cat("Vas'ka", random.nextInt(100), false),
                new Cat("Manya", random.nextInt(100), false),
                new Cat("Pet'ka", random.nextInt(100), false),
                new Cat("Ryzhik", random.nextInt(100), false),
                new Cat("Maksik", random.nextInt(100), false),
        };
        bowl.putFoodBowl(random.nextInt(500)); // добавляем еду в чашку
        for (Cat cat: cats) {
            cat.eatCat(bowl);                       // коты едят
        }
        for (Cat cat: cats) {
            if (cat.isSatiety()){                   // проверяем сытость котов
                System.out.printf("%s the cat is fed.\n",cat.getName());
            } else {
                System.out.printf("%s the cat is hungry.\n",cat.getName());
            }
        }
    }
}
