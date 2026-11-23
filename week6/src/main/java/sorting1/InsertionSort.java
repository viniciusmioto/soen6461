package sorting1;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public <E extends Comparable<? super E>> List<E> sort(final List<E> aList) {
        final List<E> temporaryList = new ArrayList<>(aList);

        for (int i = 1; i < temporaryList.size(); i++) {
            final E current = temporaryList.get(i);
            // previous index
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
