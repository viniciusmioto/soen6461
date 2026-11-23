package singleton_0_threads.sort.impl1;

import singleton_0_threads.sort.IFactory;
import singleton_0_threads.sort.ISort;

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

        // DEMO ONLY: pretend construction is slow. TheUniqueFactory stays null until
        // this constructor returns, so other threads can still pass the null check.
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm() {
        return new InsertionSort<E>();
    }
}
