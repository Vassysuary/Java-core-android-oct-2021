package ru.geekbrains.jca.lessons.l9;

public class Homework9 {
    public static void main(String[] args) {


// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого
//    размера необходимо бросить исключение MyArraySizeException.
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то
//    элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
//    должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
//    MyArrayDataException и вывести результат расчета.
//

//        Scanner scanner = new Scanner();
        String[][] arr0 =  {
            {"21","8","12","09"},
            {"1","51","14","91"},
            {"73","56","2","109"},
            {"90","50","112","74"}
        };
        String[][] arr1 =  {
                {"21","8","12","09"},
                {"1","51","14","91"},
                {"73","5f6","2","109"},
                {"90","50","112","74"}
        };
        String[][] arr2 =  {
                {"21","8","12","09"},
                {"1","51","14","91"},
                {"73","5f6","2","109"},
                {"90","50","112"}
        };
        System.out.println();
        try {
            arrayConvertSum(arr0);
        } catch (MyArraySizeException e){
            e.printStackTrace();
        } catch (MyArrayDataException e){
            e.printStackTrace();
        }
        System.out.println();
        try {
            arrayConvertSum(arr1);
        } catch (MyArraySizeException e){
            e.printStackTrace();
        } catch (MyArrayDataException e){
            e.printStackTrace();
        }
        try {
            arrayConvertSum(arr2);
        } catch (MyArraySizeException e){
            e.printStackTrace();
        } catch (MyArrayDataException e){
            e.printStackTrace();
        }
    }

    private static void arrayConvertSum(String[][] array){

        int sum = 0, prompt = 0;
        int maxSizeArray = 4;
        for (int i = 0; i < 4; i++) {
            if (array.length != maxSizeArray || array[i].length != maxSizeArray) {
                throw new MyArraySizeException("Out of range array length " + maxSizeArray + ". Error!");
            }
        }
        for (int i = 0; i < maxSizeArray; i++) {
            for (int j = 0; j < maxSizeArray; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Array contents invalid character '" + array[i][j] + "' at address: " + (i+1) + "," + (j+1) + ". Error!");
                }
            }
        }
        System.out.println("The conversion was successful. Sum of all array elements = " + sum + ".");
    }
}
