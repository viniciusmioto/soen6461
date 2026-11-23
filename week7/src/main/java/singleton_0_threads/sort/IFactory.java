package singleton_0_threads.sort;

public interface IFactory {
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm();
}
