package observer.sort.impl;

import observer.sort.ISort;

import java.util.Arrays;
import java.util.List;

// Merge sort does not swap: it copies values into place. Observers only see its comparisons.
class MergeSort<E extends Comparable<E>> extends InternalSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        final E[] array = this.convertListToArray(aList);
        final E[] buffer = this.convertListToArray(aList); // just an E[] of the same size
        this.mergeSort(array, buffer, 0, array.length - 1);
        return Arrays.asList(array);
    }

    private void mergeSort(final E[] array, final E[] buffer, final int low, final int high) {
        if (low >= high) {
            return;
        }
        final int middle = (low + high) / 2;
        this.mergeSort(array, buffer, low, middle);
        this.mergeSort(array, buffer, middle + 1, high);
        this.merge(array, buffer, low, middle, high);
    }

    private void merge(final E[] array, final E[] buffer, final int low, final int middle, final int high) {
        System.arraycopy(array, low, buffer, low, high - low + 1);

        int left = low;
        int right = middle + 1;
        for (int k = low; k <= high; k++) {
            if (left > middle) {
                array[k] = buffer[right++];
            } else if (right > high) {
                array[k] = buffer[left++];
            } else if (this.compareValues(buffer, left, right) <= 0) {
                array[k] = buffer[left++];
            } else {
                array[k] = buffer[right++];
            }
        }
    }
}
