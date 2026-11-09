package org.example;

public abstract class Duck {
    FlyBehaviour flyBehaviour;

    public void display() {
        System.out.println("Duck: " + this);
    }

    public void quack() {
        System.out.println("Quack");
    }

    public void swim() {
        System.out.println("Swim");
    }

    public void performFly() {
        this.flyBehaviour.fly();
    }
}
