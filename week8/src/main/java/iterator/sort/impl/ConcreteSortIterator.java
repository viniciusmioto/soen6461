package iterator.sort.impl;

import iterator.sort.ISort;
import iterator.sort.ISortIterator;

import java.util.List;

public class ConcreteSortIterator<E extends Comparable<? super E>> implements ISortIterator<E> {
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
