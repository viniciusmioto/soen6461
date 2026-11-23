package iterator.client;

import iterator.sort.ISort;
import iterator.sort.impl.Factory;

import java.util.Arrays;
import java.util.List;

public class Client {
    static void main(final String[] args) {
        final List<String> l = Arrays.asList("Marcos", "Alexandre", "Thiago", "Renato", "Luiz");

        final ISort<String> s = Factory.getInstance().getSortAlgorithm();
        System.out.println(s.sort(l));

        final ISort<String> t = Factory.getInstance().getInternalSortAlgorithms();
        System.out.println(t.sort(l));
    }
}
