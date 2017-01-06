package ru.mail.polis.sort;

import java.util.Random;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by Игорь on 05.01.2017.
 */
public class QuickSortThree {

    private static final Random random = new Random();

    public static int [] quickSortThree(int array[], int l, int r) {
        if (r <= l) return array;

        int i = l - 1, j = r;
        int p = l - 1, q = r;

        int pivot = random.nextInt(r - l + 1);
        swap(array, l + pivot, r);

        int v = array[r];

        while (true) {
            while (array[++i] < v) ;
            while (j != l && v < array[--j]) ;

            if (i >= j) {
                break;
            }

            swap(array, i, j);

            if (array[i] == v) {
                p++;
                swap(array, p, i);
            }

            if (array[j] == v) {
                q--;
                swap(array, j, q);
            }
        }

        swap(array, i, r);

        j = i - 1;
        for (int k = l; k < p; k++, j--) {
            swap(array, k, j);
        }

        i = i + 1;
        for (int k = r - 1; k > q; k--, i++) {
            swap(array, i, k);
        }

        quickSortThree(array, l, j);
        quickSortThree(array, i, r);
        return array;
    }

}
