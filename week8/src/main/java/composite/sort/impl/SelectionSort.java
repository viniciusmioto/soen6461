package composite.sort.impl;

import composite.sort.ISort;

import java.util.ArrayList;
import java.util.List;

class SelectionSort<E extends Comparable<? super E>> extends InternalSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        final List<E> temporaryList = new ArrayList<>(aList);

        for (int i = 0; i < temporaryList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < temporaryList.size(); j++) {
                if (temporaryList.get(j).compareTo(temporaryList.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                final E tmp = temporaryList.get(i);
                temporaryList.set(i, temporaryList.get(minIndex));
                temporaryList.set(minIndex, tmp);
            }
        }
        return temporaryList;
    }
}
