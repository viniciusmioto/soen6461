class Type {
    foo() {
        throw new Error("This is an abstract method!");
    }

    bar() {
        throw new Error("This is an abstract method!");
    }
}

class SubType extends Type {
    foo() {
        console.log("foo()");
    }

    bar() {
        console.log("bar()");
    }
}

// Abstract methods throw, so catch the error to let the script keep running
function attempt(label, call) {
    console.log(label);
    try {
        call();
    } catch (error) {
        console.log(`Error: ${error.message}`);
    }
}

const type = new Type();
attempt("type.foo()", () => type.foo());
attempt("type.bar()", () => type.bar());

const subType = new SubType();
attempt("subType.foo()", () => subType.foo());
attempt("subType.bar()", () => subType.bar());
