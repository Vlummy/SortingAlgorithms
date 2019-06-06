package main.java.Sorters;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class TimeMeasure {
    public static void main(String[] args) {
        ArrayList<Integer> theArray1 = new ArrayList<>();
        ArrayList<Integer> theArray2 = new ArrayList<>();
        ArrayList<Integer> theArray3 = new ArrayList<>();
        for(int i = 0; i < 100000; i++) {
            theArray1.add(new Random().nextInt(1000));
            theArray2.add(new Random().nextInt(1000));
            theArray3.add(new Random().nextInt(1000));
        }

        TimeMeasure.measureTimeOn(new SelectionSort<>(theArray1), "SelectionSort");
        TimeMeasure.measureTimeOn(new InsertionSort<>(theArray2), "InsertionSort");
        TimeMeasure.measureTimeOn(new QuickSort<>(theArray3), "QuickSort");
    }

    public static <T> void measureTimeOn(SorterInterface<T> sorterInterface, String sorterName) {
        new Thread(() -> {
            long start = System.nanoTime();
            sorterInterface.sort();
            long end = System.nanoTime();
            DecimalFormat df = new DecimalFormat("####0.00");
            System.out.println(sorterName + " used " + df.format((double)(end - start) / 1_000_000_000.0) + " seconds to finish");
        }).start();
    }
}
