package org.example;

public class MallardDuck extends Duck {
    public MallardDuck() {
        this.flyBehaviour = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("MallardDuck: " + this);
    }
}
