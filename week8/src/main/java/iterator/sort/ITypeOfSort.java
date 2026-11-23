package iterator.sort;

import java.util.List;

// a "sort" that contains other sort algorithms
public interface ITypeOfSort<E extends Comparable<? super E>> extends ISort<E> {
    List<ISort<E>> getSortAlgorithms();

    String getTypeName();

    List<E> sort(final List<E> aList);

    void addSortAlgorithm(final ISort<E> aSortAlgorithm);
}
