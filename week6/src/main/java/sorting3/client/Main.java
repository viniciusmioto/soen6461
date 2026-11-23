package sorting3.client;

import sorting3.sort.ISort;
import sorting3.sort.impl.Factory;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final ISort<Integer> s = new Factory().getSortAlgorithm();
        final List<Integer> list = Arrays.asList(7, 8, 9, 1, 2, 6, 4, 2, 1);
        List<Integer> sorted = s.sort(list);

        System.out.println("Sorted list: " + sorted);
    }
}
