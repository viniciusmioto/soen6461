package org.example;

class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }

    void meet(Animal a) {
        System.out.println("Animal meets Animal");
    }

    void meet(Dog g) {
        System.out.println("Animal meets Dog");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Dog speaks");
    }

    @Override
    void meet(Animal a) {
        System.out.println("Dog meets Animal");
    }

    @Override
    void meet(Dog g) {
        System.out.println("Dog meets Dog");
    }

    void fetch() {
        System.out.println("Dog fetches");
    }
}

public class OverridingAndOverloading {
    static void main(String[] args) {
        Animal a = new Dog();
        Dog d = new Dog();
        Animal plain = new Animal();


        // 1
        a.speak(); // Dog barks

        // 2
        plain.speak(); // Animal speaks

        // 3
//        a.fetch();
//        Compilation error -- java: cannot find symbol "method fetch()" -- location: variable a of type Animal

        // 4
        ((Dog) a).fetch(); // Dog fetches

        // 5
//        ((Dog) plain).fetch(); // Run-time error
//        Exception in thread "main" java.lang.ClassCastException: class Animal cannot be cast to class Dog (Animal and Dog are in unnamed module of loader 'app')
//	at OverridingAndOverloading.main(OverridingAndOverloading.java:57)

        // 6
        a.meet(d); // Dog meets Dog

        // 7!!!!!!!
        d.meet(a); // Dog meets Animal

        // 8
        plain.meet(a); // Animal meets Animal
    }
}
