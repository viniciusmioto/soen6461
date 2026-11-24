package observer.sort.impl;

import observer.sort.ISort;
import observer.sort.ISortIterator;
import observer.sort.ITypeOfSort;
import observer.sort.observer.ISortObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TypeOfSort<E extends Comparable<E>> extends AbstractSort<E> implements ITypeOfSort<E> {
    private final List<ISort<E>> listOfSortAlgorithms;
    private final String typeName;

    public TypeOfSort(final String aTypeName) {
        this.listOfSortAlgorithms = new ArrayList<ISort<E>>();
        this.typeName = aTypeName;
    }

    // Slide 36: the Composite overrides addObserver() and forwards the observer to its children.
    // Limitation (as in the slides): only the children present NOW get the observer;
    // a sort algorithm added later with addSortAlgorithm() will not be observed.
    @Override
    public void addObserver(final ISortObserver<E> anObserver) {
        final Iterator<ISort<E>> iterator = this.listOfSortAlgorithms.iterator();
        while (iterator.hasNext()) {
            final ISort<E> sortAlgorithm = iterator.next();
            sortAlgorithm.addObserver(anObserver);
        }
    }

    @Override
    public void addSortAlgorithm(final ISort<E> aSortAlgorithm) {
        this.listOfSortAlgorithms.add(aSortAlgorithm);
    }

    @Override
    public String getTypeName() {
        return this.typeName;
    }

    @Override
    public List<E> sort(final List<E> aList) {
        if (this.listOfSortAlgorithms.isEmpty()) {
            throw new IllegalStateException("Type of sort '" + this.typeName + "' has no sort algorithm");
        }

        // Call each sort algorithm of this type one after the other
        final Iterator<ISort<E>> iterator = this.listOfSortAlgorithms.iterator();
        List<E> sortedList = null;
        while (iterator.hasNext()) {
            final ISort<E> sortAlgorithm = iterator.next();
            sortedList = sortAlgorithm.sort(aList);
        }
        return sortedList;
    }

    @Override
    public ISortIterator<E> getSortAlgorithms() {
        return new ConcreteSortIterator<E>(this.listOfSortAlgorithms);
    }
}
