package iterator.client;

import iterator.sort.ISort;
import iterator.sort.ISortIterator;
import iterator.sort.ITypeOfSort;
import iterator.sort.impl.Factory;

import java.util.Arrays;
import java.util.List;

public class Client {
    static void main(final String[] args) {
        final List<String> listOfNames = Arrays.asList("Marcos", "Alexandre", "Thiago", "Renato", "Luiz");

        final ISort<String> sortAlgorithm = Factory.getInstance().getSortAlgorithm();
        System.out.println(sortAlgorithm.sort(listOfNames));

        final ISort<String> sortAlgorithms = Factory.getInstance().getInternalSortAlgorithms();
        System.out.println(sortAlgorithms.sort(listOfNames));

        final ITypeOfSort<String> compositeOfSortAlgorithms = (ITypeOfSort<String>) sortAlgorithms;
        final ISortIterator<String> i = compositeOfSortAlgorithms.getSortAlgorithms();

        // i.remove(0); // annot find symbol:   method remove(int)

        // Accessing the sort algorithms sequentially, without seeing the underlying list:
        // there is no size(), remove() or clear() to call here
        while (i.hasNext()) {
            System.out.println(i.getNext());
        }
        System.out.println("Has next after the last one? " + i.hasNext());

    }
}
