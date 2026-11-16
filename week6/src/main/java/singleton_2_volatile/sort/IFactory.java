package singleton_2_volatile.sort;

public interface IFactory {
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm();
}
