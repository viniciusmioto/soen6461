package org.example;

class SuperClass {
    Object getSomething() {
        return new Object();
    }
}
class SubClass extends SuperClass {
    String getSomething() {
        return new String();
    }
}
public class CovarianceOfReturnTypes {
    public static void main(final String[] args) {
        final SuperClass superClass = new SubClass();
        System.out.println(
                Object.class.isAssignableFrom(superClass.getSomething().getClass()));

//        final String result1 = superClass.getSomething(); // Compile Error: Object is not a String

        final String result2 = ((String) superClass.getSomething());
        System.out.println(result2.getClass());

        final SubClass subClass = new SubClass();
        final String result3 = subClass.getSomething();
        System.out.println(result3.getClass());
    }
}