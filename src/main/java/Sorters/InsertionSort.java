package main.java.Sorters;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSort<T extends Comparable<? super T>> implements SorterInterface<T> {
    private ArrayList<T> theArray;

    public InsertionSort(ArrayList<T> theArray) {
        this.theArray = theArray;
    }

    @Override
    public ArrayList sort() {
        T k, temp;
        for(int i = 1; i < theArray.size(); i++) {
            k = theArray.get(i);
            int j = i - 1;
            while (j >= 0 && k.compareTo(theArray.get(j)) < 0) {
                temp = theArray.get(j);
                theArray.set(j, theArray.get(j + 1));
                theArray.set(j + 1, temp);
                j--;
            }
        }
        return theArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> theArray = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            theArray.add(new Random().nextInt(10));
        }

        theArray.forEach(System.out::print);
        System.out.println();

        ArrayList<Integer> sorted = new InsertionSort(theArray).sort();

        sorted.forEach(System.out::print);
    }
}
