package org.example;

public class RubberDuck extends Duck {
    public RubberDuck() {
        this.flyBehaviour = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("RubberDuck: " + this);
    }
}
