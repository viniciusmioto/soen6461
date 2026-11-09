function Type() {
}

Type.prototype.foo = function foo() {
    console.log("Error: This is an abstract method!");
}

Type.prototype.bar = function bar() {
    console.log("Error: This is an abstract method!");
}

function SubType() {
}

SubType.prototype = new Type();
SubType.prototype.constructor = SubType;
SubType.prototype.foo = function foo() {
    console.log("foo() <br>")
}
SubType.prototype.bar = function bar() {
    console.log("bar() <br>")
}

var type = new Type();
console.log("type.foo()")
type.foo();
console.log("type.bar()");
type.bar();

var subType = new SubType();
console.log("subType.foo()")
subType.foo();
console.log("subType.bar()");
subType.bar();
