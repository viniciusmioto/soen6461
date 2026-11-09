package sorting2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final ISort<Integer> s = new InsertionSort<>();
        final List<Integer> myList = Arrays.asList(9, 3, 5, 7, 8, 2);
        List<Integer> sortedList = s.sort(myList);

        System.out.println(sortedList);
    }
}
