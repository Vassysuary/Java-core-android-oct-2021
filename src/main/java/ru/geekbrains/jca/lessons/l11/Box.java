package ru.geekbrains.jca.lessons.l11;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private List<T> numberInBox;


    public Box(List<T> numberInBox) {
        this.numberInBox = new ArrayList<>(numberInBox);
    }

    public void AddFruitsInBox(T fruit) {
        this.numberInBox.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;
        System.out.printf("Weights in boxes:");
        for (T numb : numberInBox) {
            System.out.printf(" %f,", numb.getWeight());
            weight += numb.getWeight();
        }
        System.out.printf("\n");
        return weight;
    }

    public boolean CompareBoxes(Box <?> anyBox) {
        return Math.abs(getWeight()- anyBox.getWeight()) < 0.0001f;
    }

    public void ShiftFruits(Box <? super T> anyBox) {
        anyBox.numberInBox.addAll(numberInBox);
        numberInBox.clear();
    }
}
