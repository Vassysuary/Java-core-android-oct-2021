package ru.geekbrains.jca.lessons.l11;

import java.util.Arrays;
import java.util.Random;

public class ArrBox <T extends String> {
    private T[] array;

    public ArrBox(T... string) {
        this.array = string;
    }

    public void changeElemensArray(ArrBox<?> another){
        Random random = new Random();
        String tempValue;
        int firstElement = random.nextInt(another.getString().length);
        int secondElement = random.nextInt(another.getString().length);
        tempValue = array[firstElement];
        System.out.println("firstElement: " + firstElement + " secondElement: " + secondElement + " tempValue: " + tempValue);
        array[firstElement] = array[secondElement];
        array[secondElement] = (T) tempValue;
    }

    public T[] getString() {
        return array;
    }

    public void setString(T[] string) {
        array = string;
    }

    @Override
    public String toString() {
        return "ArrBox{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
