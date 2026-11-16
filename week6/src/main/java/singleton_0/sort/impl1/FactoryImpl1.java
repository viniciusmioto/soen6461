package singleton_0.sort.impl1;

import singleton_0.sort.IFactory;
import singleton_0.sort.ISort;

public class FactoryImpl1 implements IFactory {
    private static IFactory TheUniqueFactory;

    public static IFactory getInstance() {
        if (FactoryImpl1.TheUniqueFactory == null) {
            FactoryImpl1.TheUniqueFactory = new FactoryImpl1();
        }
        return FactoryImpl1.TheUniqueFactory;
    }

    private FactoryImpl1() {
        System.out.println("Singleton: Create FactoryImpl1 instance " + Thread.currentThread().getName());
    }

    @Override
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm() {
        return new InsertionSort<E>();
    }
}
