class ScopeTest {
    void increment(int a) {
        a = a + 1;
        System.out.println("Incremented: " + a); // 56
    }
}

public class Main {

    static void main() {
        ScopeTest scopeTest = new ScopeTest();
        int a = 55;

        scopeTest.increment(a);

        System.out.println(a); // 55
    }
}
