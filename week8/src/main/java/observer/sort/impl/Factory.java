package observer.sort.impl;

import observer.sort.ISort;
import observer.sort.ITypeOfSort;

public class Factory {
    private static class FactoryUniqueInstanceHolder {
        private static final Factory THE_UNIQUE_FACTORY = new Factory();
    }

    public static Factory getInstance() {
        return FactoryUniqueInstanceHolder.THE_UNIQUE_FACTORY;
    }

    private Factory() {
        // Some implementation if needed
        System.out.println("Week 8 - Singleton: Create Factory instance " + Thread.currentThread().getName());
    }

    public <E extends Comparable<E>> ISort<E> getSortAlgorithm() {
        return new InsertionSort<E>();
    }

    public <E extends Comparable<E>> ISort<E> getBubbleSortAlgorithm() {
        return new BubbleSort<E>();
    }

    public <E extends Comparable<E>> ISort<E> getInsertionSortAlgorithm() {
        return new InsertionSort<E>();
    }

    public <E extends Comparable<E>> ISort<E> getQuickSortAlgorithm() {
        return new QuickSort<E>();
    }

    public <E extends Comparable<E>> ISort<E> getMergeSortAlgorithm() {
        return new MergeSort<E>();
    }

    public <E extends Comparable<E>> ISort<E> getSelectionSortAlgorithm() {
        return new SelectionSort<E>();
    }

    public <E extends Comparable<E>> ISort<E> getInternalSortAlgorithms() {
        final ITypeOfSort<E> internalSorts = new TypeOfSort<E>("Internal Sorts");

        final ISort<E> bubbleSortAlgorithm = this.getBubbleSortAlgorithm();
        internalSorts.addSortAlgorithm(bubbleSortAlgorithm);
        final ISort<E> insertionSortAlgorithm = this.getInsertionSortAlgorithm();
        internalSorts.addSortAlgorithm(insertionSortAlgorithm);
        final ISort<E> selectionSortAlgorithm = this.getSelectionSortAlgorithm();
        internalSorts.addSortAlgorithm(selectionSortAlgorithm);
        final ISort<E> mergeSortAlgorithm = this.getMergeSortAlgorithm();
        internalSorts.addSortAlgorithm(mergeSortAlgorithm);
        final ISort<E> quickSortAlgorithm = this.getQuickSortAlgorithm();
        internalSorts.addSortAlgorithm(quickSortAlgorithm);

        return internalSorts;
    }
}
