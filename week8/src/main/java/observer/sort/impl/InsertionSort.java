package observer.sort.impl;

import observer.sort.ISort;

import java.util.Arrays;
import java.util.List;

// Insertion sort with adjacent swaps, so observers see every comparison and swap.
class InsertionSort<E extends Comparable<E>> extends InternalSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        final E[] array = this.convertListToArray(aList);

        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && this.compareValues(array, j - 1, j) > 0) {
                this.swapValues(array, j - 1, j);
                j--;
            }
        }
        return Arrays.asList(array);
    }
}
