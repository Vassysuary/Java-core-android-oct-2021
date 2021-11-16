package ru.geekbrains.jca.lessons.l6;

import java.util.Random;

public class Homework6 {

//    1. Создать классы Собака и Кот с наследованием от класса Животное.
//    2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//    Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//    3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).


    private static int catRunLimit = 200;
    private static int dogRunLimit = 500;
    private static int dogSwimLimit = 10;

    public static void main(String[] args) {

        Random random = new Random();

        Animals cat0 = new Cat("Vas'ka");
        Animals cat1 = new Cat("Manya");
        Animals dog0 = new Dog("Hunter");
        Animals dog1 = new Dog("Dik");
        Animals dog2 = new Dog("White Fang");
        Animals other = new Animals("WhoIsIt");     // здесь втиснулось непонятно что ))

        int distRunCat = random.nextInt(catRunLimit * 2);
        int distRunDog = random.nextInt(dogRunLimit * 2);
        int distSwim = random.nextInt(dogSwimLimit * 2);
        System.out.println();
        if (distRunCat > catRunLimit) System.out.printf("%d meters is too much distance for a %s. Limit: %d.\n", distRunCat, cat0.getNickname(),catRunLimit);
        else if (distRunCat == 0) System.out.printf("Too small distance for a %s.\n", cat0.getNickname());
        else cat0.animalRun(distRunCat);
        if (distRunDog > dogRunLimit) System.out.printf("%d meters is too much distance for a %s. Limit: %d.\n", distRunDog, dog0.getNickname(), dogRunLimit);
        else if (distRunDog == 0) System.out.printf("Too small distance for a %s.\n", dog0.getNickname());
        else dog0.animalRun(distRunDog);
        if (distSwim > dogSwimLimit) System.out.printf("%d meters is too much distance for a %s. Limit: %d.\n", distSwim, dog0.getNickname(), dogSwimLimit);
        else if (distSwim == 0) System.out.printf("Too small distance for a %s.\n", dog0.getNickname());
        else {
            dog0.animalSwim(distSwim);
            System.out.printf("A %s cannot swim.\n", cat0.getNickname());
        }
//    4. * Добавить подсчет созданных котов, собак и животных.
        System.out.printf("Тоtal animals: %d.\n", cat0.getCount());          // Всё посчитано при обращению к конструктору класса:
        System.out.printf("Total cats: %d.\n", ((Cat) cat0).getCountCats()); // в каждом классе сидит static счётчик.
        System.out.printf("Total dogs: %d.\n", ((Dog) dog0).getCountDogs()); // Остаётся только вывести его в конце программы.
    }
}
