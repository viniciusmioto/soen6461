class Object {
    public boolean equals(
            final Object anObject) {
        return false;
    }
}

class Point extends Object {
    @Override
    public boolean equals(final Object anObject) {
        System.out.println("One implementation.");
        return false;
    }
    public boolean equals(final Point aPoint) {
        System.out.println("Another implementation.");
        return false;
    }
}

public class Overloading {
     static void main(final String[] args) {
        final Point p1 = new Point();
        final Point p2 = new Point();
        final Object o = p1;
        System.out.println(p1.equals(p2)); // Another implementation - false
        System.out.println(o.equals(p2)); // One implementation - false
        System.out.println(p1.equals(o)); // One implementation - false
    }
}