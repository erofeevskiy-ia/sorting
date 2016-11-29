package ru.mail.polis.sort;

/**
 * Created by Игорь on 22.11.2016.
 */
public class InsertionSort {

    public static int[] insertionSort(int[] a)  {

        for (int i=0;i<a.length;i++) {
            for(int j=i;j>0&&a[j]<a[j-1];j--) {
                int tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
            }
        }
        return a;
    }
}
