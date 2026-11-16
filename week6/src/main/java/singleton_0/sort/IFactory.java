package singleton_0.sort;

public interface IFactory {
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm();
}
