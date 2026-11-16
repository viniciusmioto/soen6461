package singleton_5_enum.sort.impl1;

import singleton_5_enum.sort.IFactory;
import singleton_5_enum.sort.ISort;

// 5th solution (slide 40): Simplest Eager Initialisation, using an enum.
// No synchronized, no volatile: the JVM creates THE_UNIQUE_FACTORY exactly once,
// when the enum class is initialised, and the class loader makes that thread safe.
public enum FactoryImpl1 implements IFactory {
    THE_UNIQUE_FACTORY;

    // Enum constructors are always private: no one can call "new FactoryImpl1()".
    FactoryImpl1() {
        System.out.println("Singleton: Create FactoryImpl1 instance " + Thread.currentThread().getName());

        // DEMO ONLY: pretend construction is slow, to give the threads a chance to race.
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
