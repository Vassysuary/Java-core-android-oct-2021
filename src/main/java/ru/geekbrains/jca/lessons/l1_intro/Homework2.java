package ru.geekbrains.jca.lessons.l1_intro;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.xml.transform.SourceLocator;
import java.net.SocketOption;

public class Homework2 {
    public static void main (String[] args){
// 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;
        byte arr[] = {1,0,0,1,1,0,1,1,1,0,0,0};
        System.out.println("Task 1.");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
// 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
        System.out.print("Task 2. ");
        int arr1[] = new int[8];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i * 3;
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
// 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2.
        byte arr2[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Task 3.");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 6) arr2[i] *= 2;
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
// 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
//    цикла(-ов) заполнить его диагональные элементы единицами
        System.out.println("Task 4.");
        int dim = 5;
        byte arr3[][] = new byte[dim][dim];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i][i] = 1;
            int lastY = arr3.length - 1 - i;
            arr3[i][lastY] = 1;
            }
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
// 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета).
        System.out.println("Task 5. ");
        byte arr4[] = {1, 6, -5, 10, -12, 9, 0, 43,-44, 7, 17};
        byte maxValue = 0, minValue = 0, maxNumb = 0, minNumb = 0;
        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i] + " ");
            if (arr4[i] > maxValue) {
                maxValue = arr4[i];
                maxNumb = (byte) i;
            }
            if (arr4[i] < minValue) {
                minValue = arr4[i];
                minNumb = (byte) i;
            }
        }
        System.out.println();
        minNumb += 1;
        maxNumb += 1;
        System.out.println("minNumb - " + minNumb + ". minValue = " + minValue + ". maxNumb - " + maxNumb +
                ". maxValue = " + maxValue + ".");
// 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
// если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
// граница показана символами ||, эти символы в массив не входят.
        System.out.println("Task 6.");
        byte arr5[] = {6, 2, 2, 2, 2, 3, 10, 1};
        for (int i = 0; i < arr5.length; i++) {
            System.out.print(arr5[i] + " ");
        }
        System.out.println();
        if (checkBalance(arr5)){
            System.out.println("Good massive! )");
        }
        else {
            System.out.println("Bad massive. (");
        }

// 7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
// отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один
// вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону
// сдвиг можете выбирать сами.
        System.out.println("Task 7.");
        byte arr6[] = {6, 2, 5, 1, 4, 3, 10, 8, 9, 7};
        int shiftLR = 12;
        for (int i = 0; i < arr6.length; i++) {
            System.out.print(arr6[i] + " ");
        }
        System.out.println("Shift = " + shiftLR);
        shiftLeftRight(arr6, shiftLR);
    }
// Task 6 method
    static boolean checkBalance(byte arr[]) {
        int sum = 0, sum1, marker;
// Первый этап - проверка на чётность
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) return false;
// Второй этап - непосредственный перебор сумм
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            sum1 = 0;
            marker = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j <= i) sum += arr[j];
                else {
                    marker = i;
                    sum1 += arr[j];
                }
            }
            if (sum == sum1) {
                for (int j = 0; j <= marker; j++) {
                    if (j == marker) System.out.print(arr[j] + " = ");
                    else System.out.print(arr[j] + " + ");
                    }
                marker += 1;
                for (int j = marker; marker < arr.length; marker++) {
                    if (marker  == arr.length - 1) {
                        System.out.print(arr[marker] + " = ");
                    }
                    else {
                        System.out.print(arr[marker] + " + ");
                    }
                }
                System.out.println(sum);
                    return true;
            }
        }
        return false;
    }

// Task 7 method
    static void shiftLeftRight(byte[] arr, int shift) {
        byte tempVar;
// Проверка на "лишние" транзакции при сдвиге больше длины массива
        if (Math.abs(shift) >= arr.length) {
            if (Math.abs(shift) % arr.length == 0) {
                System.out.println("No shift!");
                return;
            }
            else shift = shift % arr.length;
        }
// Начинаем сдвигать туда-сюда
        if (shift > 0) {
            for (int i = 1; i <= shift ; i++) {
                tempVar = arr[arr.length - 1];
                for (int j = arr.length; j > 1; j--) {
                    arr[j - 1] = arr[j - 2];
                }
                arr[0] = tempVar;
            }
        } else if (shift < 0) {
                shift = -shift;
                for (int i = 1; i <= shift ; i++) {
                    tempVar = arr[0];
                    for (int j = 0; j < arr.length - 1; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[arr.length - 1] = tempVar;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}