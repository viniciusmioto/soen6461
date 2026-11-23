package sorting4.sort.impl2;

import sorting4.sort.ISort;

import java.util.ArrayList;
import java.util.List;

class SelectionSort<E extends Comparable<? super E>> extends AbstractSort<E> implements ISort<E> {
    @Override
    public List<E> sort(final List<E> aList) {
        final List<E> temporaryList = new ArrayList<>(aList);

        for (int i = 0; i < temporaryList.size() - 1; i++) {
            int minimumIndex = i;

            for (int j = i + 1; j < temporaryList.size(); j++) {
                if (temporaryList.get(j).compareTo(temporaryList.get(minimumIndex)) < 0) {
                    minimumIndex = j;
                }
            }

            if (minimumIndex != i) {
                final E current = temporaryList.get(i);
                temporaryList.set(i, temporaryList.get(minimumIndex));
                temporaryList.set(minimumIndex, current);
            }
        }

        return temporaryList;
    }
}
