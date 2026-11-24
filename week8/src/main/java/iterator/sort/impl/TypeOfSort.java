package iterator.sort.impl;

import iterator.sort.ISort;
import iterator.sort.ISortIterator;
import iterator.sort.ITypeOfSort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TypeOfSort<E extends Comparable<? super E>> extends AbstractSort<E> implements ITypeOfSort<E> {
    private final List<ISort<E>> listOfSortAlgorithms;
    private final String typeName;

    public TypeOfSort(final String aTypeName) {
        this.listOfSortAlgorithms = new ArrayList<ISort<E>>();
        this.typeName = aTypeName;
    }

    public void addSortAlgorithm(final ISort<E> aSortAlgorithm) {
        this.listOfSortAlgorithms.add(aSortAlgorithm);
    }

    public String getTypeName() {
        return this.typeName;
    }

    public List<E> sort(final List<E> aList) {
        // Call each sort algorithm of this type one after the other
        final Iterator<ISort<E>> iterator = this.listOfSortAlgorithms.iterator();
        List<E> sortedList = null;

        if (this.listOfSortAlgorithms.isEmpty()) {
            throw new IllegalStateException("Type of sort '" + this.typeName + "' has no sort algorithm");
        }

        while (iterator.hasNext()) {
            final ISort<E> sortAlgorithm = (ISort<E>) iterator.next();
            sortedList = sortAlgorithm.sort(aList);
        }
        return sortedList;
    }

    public ISortIterator<E> getSortAlgorithms() {
        return new ConcreteSortIterator<E>(this.listOfSortAlgorithms);
    }

}
