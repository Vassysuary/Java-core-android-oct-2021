package ru.geekbrains.jca.lessons.l1_intro;

public class Homework1 {
    public static void main (String[] args){
// Домашка на метод, возвращающий a * (b + (c/d)) float
        float a = 1.022f, b = 3.25f, c = -15.256f, d = 25.165f;
        float result = summaryMethod (a,b,c,d);
        System.out.println("Task 1. a * (b + (c / d)) = " + result);
// Домашка на метод, принимающий на вход два целых числа и проверяющий,
// что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
        byte numb1 = 9, numb2 = 9;
        boolean res = checkInt (numb1, numb2);
        if (res) System.out.println("Task 2. Sum num1+num1 in interval between 10 and 20.");
        else System.out.println("Task 2. Sum num1+num1 is out of range.");
// Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
// положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
        int numb3 = -1;
        checkSign (numb3);
// Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число
// отрицательное, и вернуть false если положительное.
        int numb4 = 12;
        boolean res1 = checkSign1 (numb4);
        if (res1) System.out.println("Task 4. Number is negative.");
        else System.out.println("Task 4. Number is positive.");
// Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль
// сообщение «Привет, указанное_имя!».
        String name = "Ivan";
        helloName (name);
// *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год
// является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        int yearIn = 2000;
        leapYear (yearIn);
    }

    static float summaryMethod(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }
     static boolean checkInt(byte a, byte b) {
        return a + b >= 10 && a + b <= 20 ;
    }
    static void checkSign(int a) {
        if (a < 0) System.out.println("Task 3. Number is negative.");
        else System.out.println("Task 3. Number is positive.");
    }
    static boolean checkSign1(int a) {
        return a < 0;
    }
    static void helloName (String n) {
        System.out.println("Task 5. Привет, " + n +"!");
    }
    static  void leapYear (int y) {
        if ( y % 4 == 0 && y % 100 != 0 || y % 400 == 0) System.out.println("Task 6. Leap year: " + y + ".");
        else System.out.println("Task 6. No leap year: " + y + ".");
    }
}

