package org.example;

public class HTMLWriter implements IWriter {
    @Override
    public void print(Rect aRectangle) {
        System.out.println("Printing rectangle: " + this);
    }

    @Override
    public void print(final Square aSquare) {
        System.out.println("Printing square: " + this);
    }
}
