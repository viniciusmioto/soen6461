package iterator.sort.impl;

import iterator.sort.ISort;

import java.util.List;

class PSort<E extends Comparable<? super E>> extends ExternalSort<E> implements ISort<E> {
    // NOTE: this does not really implement the pSort algorithm (no disk operations).
    // We use MergeSort instead, just for the class example to work.
    private final ISort<E> delegate = new MergeSort<E>();

    @Override
    public List<E> sort(final List<E> aList) {
        return delegate.sort(aList);
    }
}
