package org.example;

import java.awt.*;

public class Main {
    static void main() {
        IShape shape = null;


        final IWriter systemWriter = new SystemWriter();
        final IWriter htmlWriter = new HTMLWriter();

        shape = new Rect();
        shape.printOn(systemWriter);
        shape.printOn(htmlWriter);

        shape = new Square();
        shape.printOn(systemWriter);
        shape.printOn(htmlWriter);

//      --------------------
//        htmlWriter.print(shape); // Error: Cannot solve method print(IShape)
//         Rect rect = new Rect();
//         htmlWriter.print(rect);


    }
}
