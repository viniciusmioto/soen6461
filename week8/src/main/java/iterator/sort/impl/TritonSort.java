package iterator.sort.impl;

import iterator.sort.ISort;

import java.util.List;

class TritonSort<E extends Comparable<? super E>> extends ExternalSort<E> implements ISort<E> {
    // NOTE: this does not really implement the TritonSort algorithm (no disk operations).
    // We use QuickSort instead, just for the class example to work.
    private final ISort<E> delegate = new QuickSort<E>();

    @Override
    public List<E> sort(final List<E> aList) {
        return delegate.sort(aList);
    }
}
