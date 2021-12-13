package ru.geekbrains.jca.lessons.l14;

import java.util.Arrays;

public class Homework14 {
    public static void main(String[] args) {
// 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод
//    должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после
//    последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить
//    RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
        int[][] arr = new int[][]{
                {1, 3, 4, 5, 4, 3, 6},
                {3, 6, 3, 1, 0},
                {3, 2, 4, 6, 1, 0, 8, 6}
        };
        for (int i = 0; i < arr.length; i++) {
            checkArr(arr[i]);
        }

        int[][] arr14 = new int[][]{
                {1, 1, 4, 1, 4, 1, 1},
                {4, 4, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {4, 4, 4, 4, 4, 4, 4, 4},
        };
        for (int i = 0; i < arr14.length; i++) {
            System.out.println("Test " + i + " " + check1And4InArray(arr14[i]));
        }
    }
    public static int[] checkArr(int[] array) {
        boolean have4InArr = false;
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                have4InArr = true;
                pos = i;
            }
        }
        if (pos == 0) {
            throw new RuntimeException("Array does not contain 4.");
        }
        else {
            int[] retArray = new int[array.length - pos - 1];
            for (int i = 0; i < array.length - pos - 1; i++) {
                retArray[i] = array[i + pos + 1];
            }
            for (int r : retArray) {
                System.out.printf(" %d", r);
            }
            System.out.println();
            return Arrays.copyOf(retArray, retArray.length);
        }
    }
// 2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
//    то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//    [ 1 1 1 4 4 1 4 4 ] -> true [ 1 1 1 1 1 1 ] -> false [ 4 4 4 4 ] -> false [ 1 4 4 1 1 4 3 ] -> false

    public static boolean check1And4InArray(int[] array){
        boolean is4Present = false;
        boolean is1Present = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1 && array[i] != 4) return false;
            else if (array[i] == 4) is4Present = true;
            else if (array[i] == 1) is1Present = true;
        }
        if (is1Present && is4Present) return true;
        else return false;
    }
}
