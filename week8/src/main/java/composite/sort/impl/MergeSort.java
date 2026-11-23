package composite.sort.impl;

import composite.sort.ISort;

import java.util.ArrayList;
import java.util.List;

class MergeSort<E extends Comparable<? super E>> extends InternalSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        if (aList.size() <= 1) {
            return new ArrayList<>(aList);
        }
        final int middle = aList.size() / 2;
        final List<E> left = sort(aList.subList(0, middle));
        final List<E> right = sort(aList.subList(middle, aList.size()));

        final List<E> merged = new ArrayList<>(aList.size());
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }
        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        while (j < right.size()) {
            merged.add(right.get(j++));
        }
        return merged;
    }
}
