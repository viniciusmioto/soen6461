function CommonCode() {
    // No instance variables
}

CommonCode.prototype.foo = function foo() {
    console.log('foo()');
}

function Reuse1() {
    // No instance variables
}

Reuse1.prototype = new CommonCode();
Reuse1.prototype.constructor = Reuse1;
Reuse1.prototype.method1 = function method1() {
    this.foo();
    console.log('in method1()');
}

var commonCode = new CommonCode();
console.log(commonCode.foo());

var reuse1 = new Reuse1();
console.log(reuse1.method1());