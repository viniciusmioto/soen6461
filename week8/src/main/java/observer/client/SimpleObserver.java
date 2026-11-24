package observer.client;

import observer.sort.observer.ComparisonEvent;
import observer.sort.observer.ISortObserver;
import observer.sort.observer.SwapEvent;

// ConcreteObserver used on slide 37 (its code is not shown): prints every event it receives.
// It lives on the client side: the sort algorithms (subjects) only know the ISortObserver interface.
public class SimpleObserver<E extends Comparable<E>> implements ISortObserver<E> {
    @Override
    public void valuesCompared(final ComparisonEvent<E> comparisonEvent) {
        System.out.println(comparisonEvent);
    }

    @Override
    public void valuesSwapped(final SwapEvent<E> swapEvent) {
        System.out.println(swapEvent);
    }
}
