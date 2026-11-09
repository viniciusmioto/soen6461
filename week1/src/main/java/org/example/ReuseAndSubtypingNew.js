class AbstractMeasure {
    getValue() {
        console.log("Some code before...");
        return this.getRealValue();
    }

    getRealValue() {
        throw new Error("Abstract method!");
    }
}

class Length extends AbstractMeasure {
    getRealValue() {
        console.log("Specific code.");
        return 1;
    }
}

class Size extends AbstractMeasure {
    getRealValue() {
        console.log("Specific code.");
        return 2;
    }
}

const length = new Length();
console.log("length.getValue()");
console.log(length.getValue());

const size = new Size();
console.log("size.getValue()");
console.log(size.getValue());

// The base class is abstract by convention only: getValue() runs, then getRealValue() throws
const measure = new AbstractMeasure();
console.log("measure.getValue()");
try {
    measure.getValue();
} catch (error) {
    console.log(`Error: ${error.message}`);
}
