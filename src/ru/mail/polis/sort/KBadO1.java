package ru.mail.polis.sort;

import java.util.Arrays;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by Игорь on 05.01.2017.
 */
public class KBadO1 {
    private static int findMedian(int array[], int fromIndex, int n) {
        Arrays.sort(array, fromIndex, fromIndex + n);
        return array[fromIndex + n / 2];
    }

    private static int partition(int array[], int l, int r, int x) {
        int i = l;

        while (i < r && array[i] != x) {
            i++;
        }

        swap(array, i, r);

        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (array[j] <= x) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, r);

        return i;
    }

    private static int kth(int array[], int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int n = r - l + 1;

            int[] median = new int[(n + 4) / 5];

            int i;
            for (i = 0; i < n / 5; i++)
                median[i] = findMedian(array, l + i * 5, 5);

            if (i * 5 < n) {
                median[i] = findMedian(array, l + i * 5, n % 5);
                i++;
            }

            int medOfMed = median[0];
            if (i > 1) {
                medOfMed = kth(median, 0, i - 1, i / 2);
            }

            int pos = partition(array, l, r, medOfMed);

            if (pos - l == k - 1)
                return array[pos];
            if (pos - l > k - 1)
                return kth(array, l, pos - 1, k);

            return kth(array, pos + 1, r, k - pos + l - 1);
        }

        return Integer.MAX_VALUE;
    }

    static int kth(int array[], int k) {
        return kth(array, 0, array.length - 1, k);
    }

    public static void main(String[] args) {
        int a[] = Helper.gen(100);
        int k = 9;
        System.out.println(kth(a, k));
    }
}
