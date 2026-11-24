package observer.sort.impl;

import observer.sort.ISort;

import java.util.Arrays;
import java.util.List;

class SelectionSort<E extends Comparable<E>> extends InternalSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        final E[] array = this.convertListToArray(aList);

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (this.compareValues(array, j, minIndex) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                this.swapValues(array, i, minIndex);
            }
        }
        return Arrays.asList(array);
    }
}
