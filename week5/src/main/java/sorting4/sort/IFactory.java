package sorting4.sort;

public interface IFactory<E> {
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm();
}
