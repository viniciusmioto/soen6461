package iterator.sort.impl;

import java.util.List;

abstract class AbstractSort<E> {
    abstract List<E> sort(final List<E> aList);

    protected void someOtherHelperMethod() {
        // some implementation
    }
}
