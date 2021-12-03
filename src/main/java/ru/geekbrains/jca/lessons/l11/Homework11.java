package ru.geekbrains.jca.lessons.l11;

import java.util.ArrayList;
import java.util.List;

public class Homework11 {
    public static void main(String[] args) {

// 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
// 2. Написать метод, который преобразует массив в ArrayList;
// 3. Задача:
//      a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//      b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну
//          коробку нельзя сложить и яблоки, и апельсины;
//      c. Для хранения фруктов внутри коробки можно использовать ArrayList;
//      d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
//          вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//      e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
//          подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//          Можно сравнивать коробки с яблоками и апельсинами;
//      f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку
//          фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не
//          остается, а в другую перекидываются объекты, которые были в первой;
//      g. Не забываем про метод добавления фрукта в коробку.

// ==============================================================================> Задание № 1.

        String[] arr = new String[]{"We", "all", "live", "in","a","yellow","submarine"};
        ArrBox<String> workArr = new ArrBox<>(arr);
        System.out.println("Task # 1.");
        System.out.println(workArr);
        workArr.changeElemensArray(workArr);
        System.out.println(workArr);

// ==============================================================================> Задание № 2.
        System.out.println("Task # 2.");
        TransfomToArrayList<String> arrayList = new TransfomToArrayList<>(arr);
        arrayList.Transform(arr);

// ==============================================================================> Задание № 3.
        System.out.println("Task # 3.");
        List<Apple> numberApples = new ArrayList<>();
        numberApples.add(new Apple(5));
        numberApples.add(new Apple(6));
        numberApples.add(new Apple(7));
        List<Orange> numberOranges = new ArrayList<>();
        numberOranges.add(new Orange(4));
        numberOranges.add(new Orange(6));
        numberOranges.add(new Orange(5));
        Box<Apple> numberApplesBox = new Box<>(numberApples);
        Box<Orange> numberOrangesBox = new Box<>(numberOranges);
// d. GetWeight()
        System.out.println("Total weight of apples: " + numberApplesBox.getWeight() + ".");
        System.out.println("Total weight of oranges: " + numberOrangesBox.getWeight() + ".");
        System.out.println();
// e. Compare()
        if (numberApplesBox.CompareBoxes(numberOrangesBox)){
            System.out.println("The weight of the boxes is equal.");
        } else System.out.println("The weight of the boxes is different.");
        System.out.println();
// f. Shift apples
        List<Apple> numberApples1 = new ArrayList<>();
        numberApples1.add(new Apple(8));
        Box<Apple> numberApplesBox1 = new Box<>(numberApples1);
        numberApplesBox1.ShiftFruits(numberApplesBox);
        System.out.println("Total weight of apples: " + numberApplesBox.getWeight() + ".");
    }
}
