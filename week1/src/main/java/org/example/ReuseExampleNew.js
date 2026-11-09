class CommonCode {
    // No instance variables

    foo() {
        console.log("foo()");
    }
}

class Reuse1 extends CommonCode {
    // No instance variables

    method1() {
        this.foo();
        console.log("in method1()");
    }
}

const commonCode = new CommonCode();
console.log("commonCode.foo()");
commonCode.foo();

const reuse1 = new Reuse1();
console.log("reuse1.method1()");
reuse1.method1();
