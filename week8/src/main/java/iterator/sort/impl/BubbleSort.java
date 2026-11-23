package iterator.sort.impl;

import iterator.sort.ISort;

import java.util.ArrayList;
import java.util.List;

class BubbleSort<E extends Comparable<? super E>> extends InternalSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        final List<E> temporaryList = new ArrayList<>(aList);
        boolean swapped;

        for (int end = temporaryList.size() - 1; end > 0; end--) {
            swapped = false;
            for (int i = 0; i < end; i++) {
                if (temporaryList.get(i).compareTo(temporaryList.get(i + 1)) > 0) {
                    final E tmp = temporaryList.get(i);
                    temporaryList.set(i, temporaryList.get(i + 1));
                    temporaryList.set(i + 1, tmp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return temporaryList;
    }
}
