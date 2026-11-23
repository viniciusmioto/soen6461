package singleton_4_ps_mem_class.sort.impl1;

import java.util.List;

abstract class AbstractSort<E> {
    abstract List<E> sort(final List<E> aList);

    protected void someOtherHelperMethod() {
        // some implementation
    }
}
