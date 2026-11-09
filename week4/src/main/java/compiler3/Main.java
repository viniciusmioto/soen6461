package compiler3;

public class Main {
    public static void main(String[] args) {
        IVisitor myLinuxVisitor = new MyLinuxVisitor();
        IVisitor myAppleVisitor = new MyAppleVisitor();
        System.out.println("Compiler 3");

        CompilationUnit compilationUnit = new CompilationUnit();

        Class myClass = new Class("Person");

        Field myField = new Field("age", "25");
        myClass.addField(myField);

        Method myMethod = new Method("showAge");
        myClass.addMethod(myMethod);

        Statement myStatement = new Statement("Print", myField);
        myMethod.addStatement(myStatement);

        compilationUnit.addClass(myClass);

        compilationUnit.accept(myLinuxVisitor);
        System.out.println("-------------------------------------");
        compilationUnit.accept(myAppleVisitor);
    }
}
