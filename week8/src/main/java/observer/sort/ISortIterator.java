package observer.sort;

public interface ISortIterator<E extends Comparable<E>> {
    boolean hasNext();

    ISort<E> getNext();
}
