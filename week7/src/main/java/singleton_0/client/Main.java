package singleton_0.client;

import singleton_0.sort.IFactory;
import singleton_0.sort.ISort;
import singleton_0.sort.impl1.FactoryImpl1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IFactory mySortFactory = FactoryImpl1.getInstance();
        IFactory mySortFactory2 = FactoryImpl1.getInstance();

        System.out.println(mySortFactory == mySortFactory2); // true: same instance

        final ISort<Integer> s = mySortFactory.getSortAlgorithm();
        final List<Integer> list = Arrays.asList(7, 8, 2, 4, 6, 5, 1);


        List<Integer> sorted = s.sort(list);

        System.out.println("Sorted list: " + sorted);

    }
}
