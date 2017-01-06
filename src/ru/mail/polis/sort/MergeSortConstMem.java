package ru.mail.polis.sort;

/**
 * Created by Игорь on 05.01.2017.
 */
public class MergeSortConstMem {

    // сляние двух групп элементов одинокового размера
    private static void mergegroup(int a[], int n, int st1, int st2, int st3) {
        swapgroup(a, n, st1, st3);
        int take1 = 0;
        int take2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            if ((take2 == n) || ((take1 < n) && (a[take1 + st3] < a[take2 + st2]))) {
                int t = a[st1 + i];
                a[st1 + i] = a[take1 + st3];
                a[take1 + st3] = t;
                take1++;
            } else {
                int t = a[st1 + i];
                a[st1 + i] = a[take2 + st2];
                a[take2 + st2] = t;
                take2++;
            }
        }
    }

    // обмен местами двух групп элементов одинакового размера
    private static void swapgroup(int a[], int n, int st1, int st2) {
        for (int i = 0; i < n; i++) {
            Helper.swap(a, st1 + i, st2 + i);
        }
    }

    //слияние
    private static void merge(int[] a, int l, int r, int m) {
        int n = r - l;
        if (n <= 16) {
            InsertionSort.insertionSort(a, l, r);
            return;
        }

        // разрез на группы длиной корень из n
        int sizegroup = (int) Math.sqrt(n);
        int s = n % sizegroup;
        int numofgrp = n / sizegroup - 1;

        // обмен группы содержащей конец первого массива  с последней и обьединение с остатком
        swapgroup(a, sizegroup, l + numofgrp * sizegroup, m - (m - l)
                % sizegroup);
        s += sizegroup;

        // сортировка групп по первому элементу(в случае равенства по последнему)
        for (int i = 0; i < numofgrp - 1; i++) {
            int min = i;
            for (int j = i + 1; j < numofgrp; j++)
                if ((a[l + j * sizegroup] < a[l + min * sizegroup])
                        || ((a[l + j * sizegroup] == a[l + min * sizegroup])
                        && (a[l + (j + 1) * sizegroup - 1] < a[l + (min + 1) * sizegroup - 1])))
                    min = j;
            swapgroup(a, sizegroup, l + i * sizegroup, l + min * sizegroup);
        }

        // поочередное слияние групп
        for (int i = 0; i < numofgrp - 1; i++) {
            mergegroup(a, sizegroup, l + i * sizegroup, l + (i + 1) * sizegroup, l + numofgrp * sizegroup);
        }

        // сортировка конца массива
        InsertionSort.insertionSort(a, r - (s << 1), r);

        // поочередное слияние групп в обратную сторону
        for (int i = r - (s << 1); i >= l + s; i -= s)
            mergegroup(a, s, i - s, i, r - s);

        // сортировка начала и конца массива
        InsertionSort.insertionSort(a, l, l + (s << 1));
        InsertionSort.insertionSort(a, r - s, r);
    }

    public static int[] sort(int[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) >> 1;

            sort(array, l, m);
            sort(array, m + 1, r);

            merge(array, l, r + 1, m);
        }
        return array;
    }
}
