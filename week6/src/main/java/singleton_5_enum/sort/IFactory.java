package singleton_5_enum.sort;

public interface IFactory {
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm();
}
