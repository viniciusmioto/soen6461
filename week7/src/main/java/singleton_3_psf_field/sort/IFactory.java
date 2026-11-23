package singleton_3_psf_field.sort;

public interface IFactory {
    public <E extends Comparable<? super E>> ISort<E> getSortAlgorithm();
}
