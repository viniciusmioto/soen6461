package observer.sort;

import observer.sort.observer.ISortObserver;

import java.util.List;

public interface ISort<E extends Comparable<E>> {
    List<E> sort(final List<E> aList);

    void addObserver(final ISortObserver<E> anObserver);
}
