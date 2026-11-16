package singleton_4_ps_mem_class.sort.impl1;

import singleton_4_ps_mem_class.sort.IFactory;
import singleton_4_ps_mem_class.sort.ISort;

public class FactoryImpl1 implements IFactory {
    private static class FactoryUniqueInstanceHolder {
        private static final IFactory THE_UNIQUE_FACTORY = new FactoryImpl1();
    }

    public static IFactory getInstance() {
        return FactoryUniqueInstanceHolder.THE_UNIQUE_FACTORY;
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
