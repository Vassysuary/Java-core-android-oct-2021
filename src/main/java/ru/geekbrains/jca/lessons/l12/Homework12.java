package ru.geekbrains.jca.lessons.l12;

public class Homework12 {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;                                   // инициализация массива единицами
        }
//=============================================================> Метод № 1, однопоточный
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Time for one thread: " + (System.currentTimeMillis() - startTime));
//=============================================================> Метод № 2, многопоточный
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        float[] arr3 = new float[SIZE];
        startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1.0f;                                   // инициализация массива единицами
            arr2[i] = 1.0f;
        }
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < arr2.length; j++) {
                    arr2[j] = (float) (arr2[j] * Math.sin(0.2f + (j + HALF) / 5) * Math.cos(0.2f + (j + HALF) / 5) * Math.cos(0.4f + (j + HALF) / 2));
//                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        t0.start();
        t1.start();
        try {
            t0.join();
            t1.join();
            System.arraycopy(arr1, 0, arr3, 0, HALF);
            System.arraycopy(arr2, 0, arr3, HALF, HALF);
            System.out.println("Time for two thread: " + (System.currentTimeMillis() - startTime));
//            if(arr3.equals(arr)) System.out.println("arr == arr3");
//            else System.out.println("arr != arr3");
//            for (int i = 0; i < arr3.length; i++) {
//                System.out.printf("%f %f %d ", arr[i], arr3[i], i);
//                if ( Math.abs(arr[i] - arr3[i]) > 0.0001f ){
//                    System.out.printf("arr[i]= %f arr3[i] = %f i= %d", arr[i], arr3[i], i);
//                    break;
//                }
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//=============================================================> Метод № 3, многопоточный
        float[] arr4 = new float[SIZE];
        float[] arr5 = new float[SIZE];
        float[] arr6 = new float[SIZE];
        float[] arr7 = new float[SIZE];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = 1.0f;                                   // инициализация массива единицами
        }
        startTime = System.currentTimeMillis();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr5.length; i++) {
                    arr5[i] = (float) (Math.sin(0.2f + i / 5));
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr6.length; i++) {
                    arr6[i] = (float) (Math.cos(0.2f + i / 5));
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr7.length; i++) {
                    arr7[i] = (float) (Math.cos(0.4f + i / 2));
                }
            }
        });
        t2.start();
        t3.start();
        t4.start();
        try {
            t2.join();
            t3.join();
            t4.join();
            for (int i = 0; i < arr4.length; i++) {
                arr4[i] = arr4[i] * arr5[i] * arr6[i] * arr7[i];
            }
            System.out.println("Time for three thread: " + (System.currentTimeMillis() - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}