package observer.sort.impl;

import observer.sort.ISort;
import observer.sort.ISortIterator;

import java.util.List;

public class ConcreteSortIterator<E extends Comparable<E>> implements ISortIterator<E> {
    private final List<ISort<E>> referenceToOriginalList;
    private int cursor;

    public ConcreteSortIterator(final List<ISort<E>> aListOfItems) {
        this.referenceToOriginalList = aListOfItems;
    }

    public boolean hasNext() {
        return this.cursor <= this.referenceToOriginalList.size() - 1;
    }

    public ISort<E> getNext() {
        final ISort<E> currentSortAlgorithm = this.referenceToOriginalList.get(this.cursor);
        this.cursor++;
        return currentSortAlgorithm;
    }
}
