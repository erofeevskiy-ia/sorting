package ru.mail.polis.sort;

/**
 * Created by Игорь on 05.01.2017.
 */
public class InsertionSortMod {

    static int binarySearch(int arr[], int x, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x) {
                return m;
            }

            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return (x > arr[l]) ? (l + 1) : l;
    }

    public static int[] insertionSortMod(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int j = i - 1;

            int index = binarySearch(array, array[i], 0, j);

            int key = array[i];
            System.arraycopy(array, index, array, index + 1, i - index);
            array[index] = key;
        }
        return array;
    }
}
