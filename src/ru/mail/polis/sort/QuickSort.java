package ru.mail.polis.sort;

import java.util.Random;

/**
 * Created by Игорь on 22.11.2016.
 */
public class QuickSort {
    private static final Random random = new Random();

    public static int[] quickSort(int[] a,int l,int r){
        if(l<r) {
            int q = randomPartition(a, l, r);
            quickSort(a, l, q);
            quickSort(a,q+1, r);
        }
        return a;
    }
    static void swap(int[] a, int fir, int sec){
        int tmp = a[fir];
        a[fir]=a[sec];
        a[sec]=tmp;
    }

    public static int randomPartition(int arr[], int l, int r) {
        int pivot = random.nextInt(r - l + 1);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

    static int partition(int[]a, int l, int r){

        int v = a[l+(r-l+1)/2];
        int i = l;
        int j = r;
        while (i <=j) {
            while (a[i]<v) i++;
            while (a[j]>v) j--;
            if (i<=j) swap(a,i++,j--);
        }
        return j;
    }
}
