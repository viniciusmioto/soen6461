package org.example;

public class Rect implements IShape{
    @Override
    public void printOn(final IWriter aWriter) {
        System.out.println("IWriter Rect printOn");
        aWriter.print(this);
    }

    // ...
}

