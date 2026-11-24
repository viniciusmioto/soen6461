package observer.client;

import observer.sort.ISort;
import observer.sort.ISortIterator;
import observer.sort.ITypeOfSort;
import observer.sort.impl.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    static void main(final String[] args) {
        // Slide 37: the Client can observe the algorithms
        final List<String> l = Arrays.asList("Venus", "Earth", "Mars");
        final SimpleObserver<String> observer = new SimpleObserver<String>();

        final ISort<String> s = Factory.getInstance().getBubbleSortAlgorithm();
        s.addObserver(observer);
        System.out.println(s.sort(l));

        final ISort<String> t = Factory.getInstance().getInternalSortAlgorithms();
        t.addObserver(observer); // the Composite forwards the observer to each of its algorithms
        final ITypeOfSort<String> c = (ITypeOfSort<String>) t;

        // Use one specific sort algorithm...
        final ISortIterator<String> i = c.getSortAlgorithms();
        System.out.println(i.getNext().sort(l));
        // Use all sort algorithms...
        System.out.println(t.sort(l));

        // Slide 39 (right): count the comparisons and swaps of each algorithm
        System.out.println("\n--- Counting comparisons and swaps ---\n");
        final List<String> names = Arrays.asList(
                "Rick Deckard", "Roy Batty", "Harry Bryant", "Hannibal Chew", "Gaff", "Holden",
                "Leon Kowalski", "Taffey Lewis", "Pris", "Rachael", "J.F. Sebastian",
                "Dr. Eldon Tyrell", "Zhora", "Hodge", "Mary");

        final ISort<String> allSorts = Factory.getInstance().getInternalSortAlgorithms();
        final ISortIterator<String> algorithms = ((ITypeOfSort<String>) allSorts).getSortAlgorithms();
        final List<CountingObserver<String>> counters = new ArrayList<CountingObserver<String>>();
        while (algorithms.hasNext()) {
            final ISort<String> algorithm = algorithms.getNext();
            final CountingObserver<String> counter =
                    new CountingObserver<String>(algorithm.getClass().getSimpleName());
            algorithm.addObserver(counter); // one observer per algorithm, to count them separately
            counters.add(counter);
        }

        final List<String> sortedNames = allSorts.sort(names);
        for (final CountingObserver<String> counter : counters) {
            System.out.println(counter);
        }
        System.out.println(sortedNames);
    }
}
