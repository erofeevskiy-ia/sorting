package ru.mail.polis.sort;

/**
 * Created by Игорь on 05.01.2017.
 */
public class ShellSort {


    public static int[] shellSort(int array[]) {
        for (int t = array.length >> 1; t > 0; t >>= 1) {
            for (int i = t; i < array.length; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= t && array[j - t] > temp; j -= t) {
                    array[j] = array[j - t];
                }
                array[j] = temp;
            }
        }
        return array;
    }
}
