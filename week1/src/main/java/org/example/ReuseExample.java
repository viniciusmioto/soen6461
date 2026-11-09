package org.example;

class CommonCode {
    protected void foo() {
        System.out.println("foo");
    }
}

class Reuse1 extends CommonCode {
    public void method1() {
        this.foo();
    }
}

class Reuse2 extends CommonCode {
    public void method2() {
        this.foo();
    }
}

public class ReuseExample {
    static void main() {
        Reuse1 reuse1 = new Reuse1();
        Reuse2 reuse2 = new Reuse2();

        reuse1.method1();
        reuse2.method2();
    }
}
