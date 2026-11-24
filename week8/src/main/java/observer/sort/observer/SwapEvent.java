package observer.sort.observer;

// Not shown in the slides (only used by ISortObserver.valuesSwapped); same shape as ComparisonEvent.
public final class SwapEvent<E extends Comparable<E>> {
    private final E[] values;
    private final int position1;
    private final E value1;
    private final int position2;
    private final E value2;

    public SwapEvent(final E[] values, final int position1, final E value1,
                     final int position2, final E value2) {
        this.values = values;
        this.position1 = position1;
        this.value1 = value1;
        this.position2 = position2;
        this.value2 = value2;
    }

    // Returns a copy, so observers cannot modify the array being sorted.
    public E[] getValues() {
        return this.values.clone();
    }

    public int getPosition1() {
        return this.position1;
    }

    public E getValue1() {
        return this.value1;
    }

    public int getPosition2() {
        return this.position2;
    }

    public E getValue2() {
        return this.value2;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Swap of ");
        builder.append(this.value1);
        builder.append(" with ");
        builder.append(this.value2);
        return builder.toString();
    }
}
