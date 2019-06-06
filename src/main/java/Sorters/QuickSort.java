package main.java.Sorters;

import java.util.ArrayList;
import java.util.Random;

/**
 * QuickSort algorithm for any comparable object
 * @param <T>
 */
public class QuickSort<T extends Comparable<? super T>> implements SorterInterface<T> {
    private ArrayList<T> theArray;

    /**
     * Constructor for this QuickSort class
     * @param theArray to be sorted
     */
    public QuickSort(ArrayList<T> theArray) {
        this.theArray = theArray;
    }

    @Override
    public ArrayList<T> sort() {
        sort(0, (theArray.size() - 1));
        return theArray;
    }

    /**
     * Handles the partition of an array
     * Everything left of the pivot should be smaller than pivot,
     * and everything right of the pivot should be bigger than pivot
     * @param left Pointer
     * @param right Pointer
     */
    private Integer partition(Integer left, Integer right) {
        swap(left, getPivot(left, right));
        Integer border = left + 1;
        for(int i = border; i <= right; i++) {
            if(theArray.get(i).compareTo(theArray.get(left)) < 0) {
                swap(i, border++);
            }
        }
        swap(left, border - 1);
        return border - 1;
    }

    /**
     * Private call to start the quick sorting
     * @param left Left index, always 0 at start
     * @param right Right index, always the array size - 1 at start
     */
    private void sort(Integer left, Integer right) {
        if(left < right + 1) {
            Integer partition = partition(left, right);
            sort(left, (partition - 1));
            sort((partition + 1), right);
        }
    }

    private Integer getPivot(Integer left, Integer right) {
        return new Random().nextInt((right - left) + 1) + left;
    }

    private void swap(Integer leftIndex, Integer rightIndex) {
        T temp = theArray.get(leftIndex);
        theArray.set(leftIndex, theArray.get(rightIndex));
        theArray.set(rightIndex, temp);

    }
}
