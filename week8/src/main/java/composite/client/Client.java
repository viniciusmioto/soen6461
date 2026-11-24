package composite.client;

import composite.sort.ISort;
import composite.sort.ITypeOfSort;
import composite.sort.impl.Factory;

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
        final List<ISort<String>> i = compositeOfSortAlgorithms.getSortAlgorithms();

        System.out.println("Quantity of Sort Algorithms: " + i.size());
        // Accessing the list of Sort Algorithms directly
        for (ISort<String> stringISort : i) {
            System.out.println(stringISort);
        }

        i.clear();
        System.out.println("\nAfter removing all algorithms from the list...\n");

        // Exception - Type of sort 'Internal Sorts' has no sort algorithm
        // System.out.println(sortAlgorithms.sort(listOfNames));
        for (ISort<String> stringISort : i) {
            System.out.println(stringISort);
        }

        i.stream().forEach(System.out::println); // Stream version
        System.out.println("Quantity of Sort Algorithms: " + i.size());

    }
}
