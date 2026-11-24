package iterator.sort;

public interface ISortIterator<E extends Comparable<? super E>> {
    boolean hasNext();

    ISort<E> getNext();
}
