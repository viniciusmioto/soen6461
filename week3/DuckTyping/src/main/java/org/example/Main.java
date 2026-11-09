package org.example;

public class Main {
    static void main() {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.quack();
        mallardDuck.performFly();
        mallardDuck.swim();

        System.out.println("---");

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.quack();
        rubberDuck.performFly();
        rubberDuck.swim();
    }
}
