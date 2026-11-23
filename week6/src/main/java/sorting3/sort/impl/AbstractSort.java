package sorting3.sort.impl;

import java.util.List;

abstract class AbstractSort<E> {
    public abstract List<E> sort(final List<E> aList);

    protected void someOtherHelperMethod() {
        // some implementation
    }
}
