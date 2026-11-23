package sorting4.sort.impl1;

import sorting4.sort.IFactory;
import sorting4.sort.ISort;

public class FactoryImpl1<E extends Comparable<? super E>> implements IFactory<E> {
    public ISort<E> getSortAlgorithm() {
        return new InsertionSort<E>();
    }
}
