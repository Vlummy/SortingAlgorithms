# Sorting algorithms

## And some measurements

All classes implement SorterInterface and
uses generic types. These classes sorts ArrayList's
and is capable of comparing objects who implements
the Comparable interface.

The class TimeMeasure to test efficiency.
Each algorithm is run on its own thread,
and the first to finish will print first with
the time it took in seconds. Its measured in nano
time but converted to seconds with two decimal places. 
