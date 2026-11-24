package observer.sort.impl;

import observer.sort.ISort;
import observer.sort.observer.ISortObserver;

import java.util.List;

class TritonSort<E extends Comparable<E>> extends ExternalSort<E> implements ISort<E> {
    // NOTE: this does not really implement the TritonSort algorithm (no disk operations).
    // We use QuickSort instead, just for the class example to work.
    private final ISort<E> delegate = new QuickSort<E>();

    // The delegate does the comparisons and swaps, so it is the delegate that must notify the observers.
    @Override
    public void addObserver(final ISortObserver<E> anObserver) {
        this.delegate.addObserver(anObserver);
    }

    @Override
    public List<E> sort(final List<E> aList) {
        return this.delegate.sort(aList);
    }
}
