package ru.mail.polis.sort;

import static ru.mail.polis.sort.QuickSort.*;

/**
 * Created by Игорь on 05.01.2017.
 */
public class KAverageO1 {
    static int kth(int array[], int k) {
        if (k > 0 && k <= array.length) {
            int left = 0, right = array.length - 1;
            while (true) {
                int mid = partition(array, left, right);

                if (mid - left == k - 1) {
                    return array[mid];
                } else if (k - 1 < mid - left) {
                    right = mid - left;
                } else {
                    k = k - mid + left - 1;
                    left = mid + 1;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String args[]) {
        int a[] = {1, 2, 3, 45, 54, 18, 5};
        int k = 5;
        System.out.println(KAverageO1.kth(a, k));
    }


}
