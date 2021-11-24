package ru.geekbrains.jca.lessons.l8;

import java.util.Random;

public class Homework8 {
    public static void main(String[] args) {

// 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь
//    бегать и прыгать (методы просто выводят информацию о действии в консоль).
// 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
//    соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
// 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
// 4. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если
//    участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

        String[] names=  {"Ivan", "Petr","Kolya","Sergey","Viktor"};
        String[] nickNamesCats = {"Ryzhik", "Murzik","Manya","Maksik","Chernysh"};
        String[] nickNamesRobots= {"T-800", "T-900","T-1000","T-1100","T-1200"};
        Random random = new Random();
// Инициализация участников забега
        Moving[] compet = new Moving[5];
        for (int i = 0; i < 5; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    compet[i] = new Cat(nickNamesCats[i], random.nextInt(50), random.nextInt(30), true);
                    break;
                case 1:
                    compet[i] = new Robot(nickNamesRobots[i], random.nextInt(70), random.nextInt(50), true);
                    break;
                case 2:
                    compet[i] = new Human(names[i], random.nextInt(60), random.nextInt(40), true);
                    break;
            }
        }
        Difficulty[] diff = new Difficulty[6];
        for (int i = 0; i < 5; i += 2) {
            diff[i] = new RunningTrack(random.nextInt(50));
            diff[i+1] = new Obstacles(random.nextInt(30));
        }
        for (Moving mov : compet) {
            for (Difficulty dif : diff) {
                if (mov.getsuccessFlag()) {
                    dif.Overcoming(mov);
                }
            }
        }
        System.out.println();
        for (Moving mov : compet) {
            if (mov.getsuccessFlag()) {
                System.out.printf("%s %s successfully passed the distance.\n", mov.getClass().getSimpleName(),mov.getName());
            }
        }
    }
}
