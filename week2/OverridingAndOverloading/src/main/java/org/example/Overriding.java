class SuperClass {
    public void foo() {
        System.out.println("One implementation.");
    }
}
class SubClass extends SuperClass {
    public void foo() {
        super.foo(); // Calls super class foo
        System.out.println("Another implementation.");
    }
}

public class Overriding {
     static void main(final String[] args) throws InstantiationException, IllegalAccessException {
        final SuperClass superClass = new SubClass();
        superClass.foo();

        final SubClass subClass = new SubClass();
        ((SuperClass) subClass).foo();

        ((SuperClass) subClass.getClass().getSuperclass().newInstance()).foo();
    }
}
