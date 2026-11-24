package composite.sort.impl;

import java.util.List;

abstract class AbstractSort<E> {
    // Runs for every sort algorithm (and TypeOfSort) when it is instantiated.
    AbstractSort() {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    abstract List<E> sort(final List<E> aList);

    protected void someOtherHelperMethod() {
        // some implementation
    }
}
