package ru.geekbrains.jca.lessons.l14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Homework14Test {

    int[] arrRes0 = new int[]{3, 6};
    int[] arrRes1 = new int[]{6, 1, 0, 8, 6};
    int[] arrRes2 = new int[]{0};

    @Test
    void CheckArrayExeption(){
            Assertions.assertThrows(RuntimeException.class, () -> Homework14.checkArr(new int[] {3,6,3,1,0}));
            }

    @Test
    void CheckArrayAfterChanges(){
        Assertions.assertArrayEquals(Arrays.copyOf(arrRes0,arrRes0.length), Homework14.checkArr(new int[]{1, 3, 4, 5, 4, 3, 6}));
        Assertions.assertArrayEquals(Arrays.copyOf(arrRes1,arrRes1.length), Homework14.checkArr(new int[]{3, 2, 4, 6, 1, 0, 8, 6}));
        Assertions.assertArrayEquals(Arrays.copyOf(arrRes2,arrRes2.length), Homework14.checkArr(new int[]{0, 1, 7, 9, 4, 4, 4, 0}));
    }
    @Test
    void Check1And4Arr(){
        Assertions.assertTrue(Homework14.check1And4InArray(new int[]{1, 1, 4, 1, 4, 1, 1}));
        Assertions.assertTrue(!Homework14.check1And4InArray(new int[]{4, 4, 1, 1, 0}));
        Assertions.assertTrue(!Homework14.check1And4InArray(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        Assertions.assertTrue(!Homework14.check1And4InArray(new int[]{4, 4, 4, 4, 4, 4, 4, 4}));
    }
}