package ru.mail.polis.sort;

/**
 * Created by Игорь on 22.11.2016.
 */
public class QuickSort {
    public static int[] quickSort(int[] a,int l,int r){
        if(l<r) {
            int q = partition(a, l, r);
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
