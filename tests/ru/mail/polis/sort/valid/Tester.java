package ru.mail.polis.sort.valid;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ru.mail.polis.sort.*;

@RunWith(value = Parameterized.class)
public class Tester {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
            {0},
            {0, 0, 0, 0},
            {4, 3, 2, 1},
            {0, 1, 1, 0},
            {1},
            {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
            Helper.gen(1),
            Helper.gen(10),
            Helper.gen(100),
            Helper.gen(1000),
            Helper.gen(10000),
        });
    }

    private boolean isSorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkBubbleSort() throws IOException {
        Assert.assertTrue(isSorted(BubbleSort.sort(array)));
    }
    @Test
    public void test01_checkQuickSort() throws IOException {
        Assert.assertTrue(isSorted(QuickSort.quickSort(array,0,array.length-1)));
    }

    @Test
    public void test01_checkQuickSortThree() throws IOException {
        Assert.assertTrue(isSorted(QuickSortThree.quickSortThree(array,0,array.length-1)));
    }

    @Test
    public void test01_checkMergeSort() throws IOException {
        Assert.assertTrue(isSorted(MergeSort.sort(array)));
    }

    @Test
    public void test01_checkMergeSortConstMem() throws IOException {
        Assert.assertTrue(isSorted(MergeSortConstMem.sort(array,0,array.length-1)));
    }

    @Test
    public void test01_checkInsertionSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionSort.insertionSort(array)));
    }

    @Test
    public void test01_checkShellSort() throws IOException {
        Assert.assertTrue(isSorted(ShellSort.shellSort(array)));
    }

    @Test
    public void test01_checkInsertionModSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionSortMod.insertionSortMod(array)));
    }

    @Test
    public void test01_checkSelectionSort() throws IOException {
        Assert.assertTrue(isSorted(SelectionSort.selectionSort(array)));
    }



}
