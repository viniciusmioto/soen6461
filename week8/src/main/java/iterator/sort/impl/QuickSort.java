package iterator.sort.impl;

import iterator.sort.ISort;

import java.util.ArrayList;
import java.util.List;

class QuickSort<E extends Comparable<? super E>> extends InternalSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        if (aList.size() <= 1) {
            return new ArrayList<>(aList);
        }
        final E pivot = aList.get(aList.size() / 2);
        final List<E> smaller = new ArrayList<>();
        final List<E> equal = new ArrayList<>();
        final List<E> greater = new ArrayList<>();

        for (final E element : aList) {
            final int comparison = element.compareTo(pivot);
            if (comparison < 0) {
                smaller.add(element);
            } else if (comparison > 0) {
                greater.add(element);
            } else {
                equal.add(element);
            }
        }

        final List<E> result = new ArrayList<>(aList.size());
        result.addAll(sort(smaller));
        result.addAll(equal);
        result.addAll(sort(greater));
        return result;
    }
}
