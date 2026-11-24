package observer.sort.impl;

import observer.sort.ISort;
import observer.sort.observer.ISortObserver;

import java.util.List;

class PSort<E extends Comparable<E>> extends ExternalSort<E> implements ISort<E> {
    // NOTE: this does not really implement the pSort algorithm (no disk operations).
    // We use MergeSort instead, just for the class example to work.
    private final ISort<E> delegate = new MergeSort<E>();

    // The delegate does the comparisons, so it is the delegate that must notify the observers.
    @Override
    public void addObserver(final ISortObserver<E> anObserver) {
        this.delegate.addObserver(anObserver);
    }

    @Override
    public List<E> sort(final List<E> aList) {
        return this.delegate.sort(aList);
    }
}
