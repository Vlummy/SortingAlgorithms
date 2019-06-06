package main.java.Sorters;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort<T extends Comparable<? super T>> implements SorterInterface<T> {

    private ArrayList<T> theArray;

    public SelectionSort(ArrayList<T> theArray) {
        this.theArray = theArray;
    }

    @Override
    public ArrayList<T> sort() {
        if (this.theArray.size() > 1) {
            for (int i = 0; i < theArray.size(); i++) {
                T leftEntry = theArray.get(i);
                T rightEntry = theArray.get(i);
                int rightIndex = i;
                for(int j = i; j < theArray.size(); j++) {
                    if(theArray.get(j).compareTo(rightEntry) < 0) {
                        rightEntry = theArray.get(j);
                        rightIndex = j;
                    }
                }
                theArray.set(i, rightEntry);
                theArray.set(rightIndex, leftEntry);
            }
        }
        return theArray;
    }
}
