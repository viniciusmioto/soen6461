package observer.sort.impl;

import observer.sort.ISort;

import java.util.Arrays;
import java.util.List;

// In-place quick sort (Lomuto partition, middle element as pivot), so observers see comparisons and swaps.
class QuickSort<E extends Comparable<E>> extends InternalSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        final E[] array = this.convertListToArray(aList);
        this.quickSort(array, 0, array.length - 1);
        return Arrays.asList(array);
    }

    private void quickSort(final E[] array, final int low, final int high) {
        if (low >= high) {
            return;
        }
        final int middle = (low + high) / 2;
        if (middle != high) {
            this.swapValues(array, middle, high); // move the pivot to the end
        }

        int boundary = low; // everything before boundary is smaller than the pivot
        for (int k = low; k < high; k++) {
            if (this.compareValues(array, k, high) < 0) {
                if (k != boundary) {
                    this.swapValues(array, boundary, k);
                }
                boundary++;
            }
        }
        if (boundary != high) {
            this.swapValues(array, boundary, high); // put the pivot in its final place
        }

        this.quickSort(array, low, boundary - 1);
        this.quickSort(array, boundary + 1, high);
    }
}
