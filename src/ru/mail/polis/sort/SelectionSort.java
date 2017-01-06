package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by Игорь on 05.01.2017.
 */
public  class SelectionSort {

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }
}
