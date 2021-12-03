package ru.geekbrains.jca.lessons.l11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransfomToArrayList <T extends Object> {

    private T[] arrList;

    public TransfomToArrayList(T[] arrList) {
        this.arrList = arrList;
    }

    public T[] getArrList() {
        return arrList;
    }

    @Override
    public String toString() {
        return "TransfomToArrayList{" +
                "arrList=" + Arrays.toString(arrList) +
                '}';
    }

    public void Transform(T[] array){
        List<Object> arrLst = new ArrayList<>();
        arrLst = Arrays.asList(array);
        System.out.println("ArrayList: " + arrLst);
        return;
    }
}
