package sorting4.client;

import sorting4.sort.IFactory;
import sorting4.sort.ISort;
import sorting4.sort.impl1.FactoryImpl1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

//@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException  {

        final List<Integer> list = Arrays.asList(8, 9, 6, 3, 2, 4, 5, 1);
        IFactory<Integer> factory;

        // Original Implementation
        factory = new FactoryImpl1<>();
        final ISort<Integer> s1 = factory.getSortAlgorithm();
        List<Integer> sortedList = s1.sort(list);
        System.out.println(sortedList);
        System.out.println(s1.getClass().getName());

        // Instropective/reflective implementation
        final String factoryFQN = "sorting4.sort.impl2.FactoryImpl2";
        final Class<?> factoryClass = Class.forName(factoryFQN);
        final Constructor<?> factoryConstructor = factoryClass.getDeclaredConstructor();
        factory = (IFactory<Integer>) factoryConstructor.newInstance();
        final ISort<Integer> s2 = factory.getSortAlgorithm();
        List sortedList2 = s2.sort(list);
        System.out.println(sortedList2);
        System.out.println(s2.getClass().getName());

    }
}
