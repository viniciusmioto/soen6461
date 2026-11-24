package observer.sort;

// a "sort" that contains other sort algorithms
public interface ITypeOfSort<E extends Comparable<E>> extends ISort<E> {
    ISortIterator<E> getSortAlgorithms();

    String getTypeName();

    void addSortAlgorithm(final ISort<E> aSortAlgorithm);
}
