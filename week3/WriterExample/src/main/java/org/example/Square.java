package org.example;

public class Square implements IShape {
    @Override
    public void printOn(final IWriter aWriter) {
        System.out.println("IWriter Square printOn");
        aWriter.print(this);
    }

    // ...
}
