package sorting4.sort.impl2;

import sorting4.sort.IFactory;
import sorting4.sort.ISort;

public class FactoryImpl2<E extends Comparable<? super E>> implements IFactory<E> {
    public ISort<E> getSortAlgorithm() {
        return new SelectionSort<E>();
    }
}
