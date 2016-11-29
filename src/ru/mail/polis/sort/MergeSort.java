package ru.mail.polis.sort;

/**
 * Created by Игорь on 22.11.2016.
 */
public class MergeSort {
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    // copy to aux[]
        for (int k = lo; k <= hi; k++) {
        aux[k] = a[k];
    }

    // merge back to a[]
    int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
        if      (i > mid){
            a[k] = aux[j];

            j++;
        }
        else if (j > hi){
            a[k] = aux[i];
            i++;
        }
        else if (aux[j]<aux[i]){
            a[k] = aux[j];
            j++;
        }
        else {
            a[k] = aux[i];
            i++;
        }
    }
}

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    public static int[] sort(int[] a) {
        int [] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
        return a;

    }
}
