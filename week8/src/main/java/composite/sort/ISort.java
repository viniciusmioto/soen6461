package composite.sort;

import java.util.List;

public interface ISort<E extends Comparable<? super E>> {
    List<E> sort(final List<E> aList);
}
