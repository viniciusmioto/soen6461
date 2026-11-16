package sorting4.sort;

public interface IFactory<E extends Comparable<? super E>> {
    public ISort<E> getSortAlgorithm();
}
