package composite.sort;

import java.util.List;

// a "sort" that contains other sort algorithms
public interface ITypeOfSort<E extends Comparable<? super E>> extends ISort<E> {
    List<ISort<E>> getSortAlgorithms();

    String getTypeName();

    void addSortAlgorithm(final ISort<E> aSortAlgorithm);
}
