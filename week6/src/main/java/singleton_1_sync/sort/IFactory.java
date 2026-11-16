package singleton_1_sync.sort;


public interface IFactory {
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm();
}
