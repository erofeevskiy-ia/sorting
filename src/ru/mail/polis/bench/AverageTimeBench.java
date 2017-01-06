package ru.mail.polis.bench;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import ru.mail.polis.sort.*;

/**
 * Created by Nechaev Mikhail
 * Since 20/11/16.
 */

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class AverageTimeBench {

    int[][] data;
    int[] curr;
    int index;

    @Param({"100", "1000","10000", "50000", "100000"})
    static int arg;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new int[10][100];
        for (int i = 0; i < 10; i++) {
            //define arrays here
            data[i] = Helper.genSortBack(arg);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

   // @Benchmark
   // public void measureBubbleSort() {
    //    BubbleSort.sort(curr);
    //}

    @Benchmark
    public void measureInsertionSort(Blackhole bh) {
        bh.consume(InsertionSort.insertionSort(curr));
    }

    @Benchmark
    public void measureInsertionModSort(Blackhole bh) {
        bh.consume(InsertionSortMod.insertionSortMod(curr));
    }

    @Benchmark
    public void measureShellSort(Blackhole bh) {
        bh.consume(ShellSort.shellSort(curr));
    }

//    @Benchmark
//    public void measureSelectionSort(Blackhole bh) {
//        bh.consume(SelectionSort.selectionSort(curr));
//    }

//    @Benchmark
//    public void measureMergeSort(Blackhole bh) {
//        bh.consume(MergeSort.sort(curr));
//    }

//    @Benchmark
//    public void measureMergeSortConstMem(Blackhole bh) {
//        bh.consume(MergeSortConstMem.sort(curr,0,curr.length-1));
//    }

    @Benchmark
    public void measureQuickSort(Blackhole bh) {
        bh.consume(QuickSort.quickSort(curr,0,curr.length-1));
    }

    @Benchmark
    public void measureQuickSortThree(Blackhole bh) {
        bh.consume(QuickSortThree.quickSortThree(curr,0,curr.length-1));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AverageTimeBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
