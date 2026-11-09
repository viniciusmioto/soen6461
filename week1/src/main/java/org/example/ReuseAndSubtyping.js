function AbstractMeasure() {
}

AbstractMeasure.prototype.getValue = function getValue() {
    console.log("Some code before...");
    return this.getRealValue();
};

AbstractMeasure.prototype.getRealValue = function getRealValue() {
    throw new Error("Abstract method!");
};

function Length() {
}

Length.prototype = new AbstractMeasure();
Length.prototype.constructor = Length;
Length.prototype.getRealValue = function getRealValue() {
    console.log("Specific code.");
    return 1;
};

function Size() {
}

Size.prototype = new AbstractMeasure();
Size.prototype.constructor = Size;
Size.prototype.getRealValue = function getRealValue() {
    console.log("Specific code.");
    return 2;
};

var length = new Length();
console.log("length.getValue()");
console.log(length.getValue());

var size = new Size();
console.log("size.getValue()");
console.log(size.getValue());
