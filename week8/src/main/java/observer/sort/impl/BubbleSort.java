package observer.sort.impl;

import observer.sort.ISort;

import java.util.Arrays;
import java.util.List;

// Slide 24 (refactored version): compareValues() and swapValues() instead of compareTo() and a manual swap.
class BubbleSort<E extends Comparable<E>> extends InternalSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        final int listSize = aList.size();
        final E[] array = this.convertListToArray(aList);

        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - 1; j++) {
                if (this.compareValues(array, j, j + 1) > 0) {
                    this.swapValues(array, j, j + 1);
                }
            }
        }
        return Arrays.asList(array);
    }
}
