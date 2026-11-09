package sorting3.sort.impl;

import sorting3.sort.ISort;

public class Factory {
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm() {
        return new InsertionSort<E>();
    }
}
