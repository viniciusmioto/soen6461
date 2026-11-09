package org.example;

interface Measure {
    int getValue();
}

abstract class AbstractMeasure {
    public final int getValue() {
        System.out.println("Before...");
        return this.getRealValue();
    }

    abstract int getRealValue();
    // need a factory...
}

class Size extends AbstractMeasure implements Measure {
    int getRealValue() {
        return 2;
    }
}

class Length extends AbstractMeasure implements Measure {
    int getRealValue() {
        return 1;
    }
}

class MeasureExample {
    static void main(String[] args) {
        Length length = new Length();
        Size size = new Size();

        System.out.println(length.getValue());
        System.out.println(size.getValue());
    }
}
