package observer.client;

import observer.sort.observer.ComparisonEvent;
import observer.sort.observer.ISortObserver;
import observer.sort.observer.SwapEvent;

// ConcreteObserver for the right-hand output of slide 39 (its code is not shown):
// keeps state (counters) consistent with what the observed algorithm does.
public class CountingObserver<E extends Comparable<E>> implements ISortObserver<E> {
    private final String name;
    private int numberOfComparisons;
    private int numberOfSwaps;

    public CountingObserver(final String aName) {
        this.name = aName;
    }

    @Override
    public void valuesCompared(final ComparisonEvent<E> comparisonEvent) {
        this.numberOfComparisons++;
    }

    @Override
    public void valuesSwapped(final SwapEvent<E> swapEvent) {
        this.numberOfSwaps++;
    }

    @Override
    public String toString() {
        return String.format("%-14s Comparisons: %d%n%-14s Swaps : %d",
                this.name, this.numberOfComparisons, "", this.numberOfSwaps);
    }
}
