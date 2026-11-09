package sorting4.sort.impl1;

import sorting4.sort.ISort;

import java.util.ArrayList;
import java.util.List;

class InsertionSort<E extends Comparable<? super E>> extends AbstractSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        final List<E> temporaryList = new ArrayList<>(aList);

        for (int i = 1; i < temporaryList.size(); i++) {
            final E current = temporaryList.get(i);
            int j = i - 1;

            while (j >= 0 && temporaryList.get(j).compareTo(current) > 0) {
                temporaryList.set(j + 1, temporaryList.get(j));
                j--;
            }

            temporaryList.set(j + 1, current);
        }

        return temporaryList;
    }
}
