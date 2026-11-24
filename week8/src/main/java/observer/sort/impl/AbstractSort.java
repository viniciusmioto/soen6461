package observer.sort.impl;

import observer.sort.observer.ComparisonEvent;
import observer.sort.observer.ISortObserver;
import observer.sort.observer.SwapEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// The Subject of the Observer DP: knows its observers and notifies them of comparisons and swaps.
abstract class AbstractSort<E extends Comparable<E>> {
    private final List<ISortObserver<E>> listOfObservers;

    // Runs for every sort algorithm (and TypeOfSort) when it is instantiated.
    // getClass() is safe here: unlike an overridable method reading a field, it never sees uninitialized state.
    AbstractSort() {
        System.out.println(this.getClass().getSimpleName() + " created");
        this.listOfObservers = new ArrayList<ISortObserver<E>>();
    }

    public void addObserver(final ISortObserver<E> anObserver) {
        this.listOfObservers.add(anObserver);
    }

    abstract List<E> sort(final List<E> aList);

    // Returns a NEW array with the elements of the list, so sorting it never changes the caller's list.
    // Java cannot create an E[] directly (generic array creation), but E is erased to Comparable,
    // so a Comparable[] is a valid E[] at runtime. (aList.toArray() would return an Object[],
    // which fails with a ClassCastException as soon as it is used as an E[].)
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected E[] convertListToArray(final List<E> aList) {
        return aList.toArray((E[]) new Comparable[aList.size()]);
    }

    // All sort algorithms benefit from these two methods: by using them instead of
    // compareTo() and a manual swap, every algorithm notifies the observers for free.
    protected int compareValues(final E[] values, final int position1, final int position2) {
        this.notifyObserversOfAComparison(values,
                position1, values[position1],
                position2, values[position2]);
        return values[position1].compareTo(values[position2]);
    }

    protected void swapValues(final E[] array, final int i, final int j) {
        // Notify BEFORE swapping, so the event shows the values as they were compared
        // (slide 39: "Comparison of Venus with Earth" then "Swap of Venus with Earth").
        this.notifyObserversOfASwap(array, i, array[i], j, array[j]);
        final E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void notifyObserversOfAComparison(
            final E[] values, final int position1, final E value1,
            final int position2, final E value2) {
        final ComparisonEvent<E> event =
                new ComparisonEvent<E>(values, position1, value1, position2, value2);

        final Iterator<ISortObserver<E>> iterator = this.listOfObservers.iterator();
        while (iterator.hasNext()) {
            final ISortObserver<E> sortObserver = iterator.next();
            sortObserver.valuesCompared(event);
        }
    }

    // Not shown in the slides: the swap counterpart of notifyObserversOfAComparison().
    private void notifyObserversOfASwap(
            final E[] values, final int position1, final E value1,
            final int position2, final E value2) {
        final SwapEvent<E> event =
                new SwapEvent<E>(values, position1, value1, position2, value2);

        final Iterator<ISortObserver<E>> iterator = this.listOfObservers.iterator();
        while (iterator.hasNext()) {
            final ISortObserver<E> sortObserver = iterator.next();
            sortObserver.valuesSwapped(event);
        }
    }
}
