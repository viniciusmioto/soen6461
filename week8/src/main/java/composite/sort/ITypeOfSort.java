package composite.sort;

import java.util.List;

// A "sort" that contains other sort algorithms.
// So it plays the `Composite` role.
public interface ITypeOfSort<E extends Comparable<? super E>> extends ISort<E> {
    List<ISort<E>> getSortAlgorithms();

    String getTypeName();

    void addSortAlgorithm(final ISort<E> aSortAlgorithm);
}
