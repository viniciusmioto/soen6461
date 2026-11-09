package org.example;

public class SystemWriter implements IWriter {
    @Override
    public void print(final Rect rect) {
        System.out.println("Printing rect: " + this);
    }

    @Override
    public void print(final Square aSquare) {
        System.out.println("Printing square: " + this);
    }
}
