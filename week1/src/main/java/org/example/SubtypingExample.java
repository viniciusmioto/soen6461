package org.example;


interface Type {
    void foo1();
    void bar1();
}

class SubType implements Type {
    public void foo1() {
        System.out.println("SubType foo1");
    }
    public void bar1() {
        System.out.println("SubType bar1");
    }
}

public class SubtypingExample {
    static void main() {
        SubType subType = new SubType();
        subType.foo1();
        subType.bar1();
    }
}
