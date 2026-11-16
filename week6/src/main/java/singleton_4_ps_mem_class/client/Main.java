package singleton_4_ps_mem_class.client;

import singleton_4_ps_mem_class.sort.IFactory;
import singleton_4_ps_mem_class.sort.ISort;
import singleton_4_ps_mem_class.sort.impl1.FactoryImpl1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Each thread asks for "the unique" factory and prints which object it got.
        Runnable task = () -> {
            IFactory factory = FactoryImpl1.getInstance();
            System.out.println(Thread.currentThread().getName()
                    + " got factory @" + System.identityHashCode(factory));
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start(); // start() runs the task on a NEW thread (run() would not)
        t2.start();
        t3.start();

        t1.join();  // wait for the threads to finish before going on
        t2.join();
        t3.join();

        final ISort<Integer> s = FactoryImpl1.getInstance().getSortAlgorithm();
        final List<Integer> list = Arrays.asList(7, 8, 2, 4, 6, 5, 1);

        List<Integer> sorted = s.sort(list);

        System.out.println("Sorted list: " + sorted);
    }
}
