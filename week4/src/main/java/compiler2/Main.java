package compiler2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Compiler 2");

        CompilationUnit compilationUnit = new CompilationUnit();

        Class myClass = new Class("Person");

        Field myField = new Field("age", "25");
        myClass.addField(myField);

        Method myMethod = new Method("showAge");
        myClass.addMethod(myMethod);

        Statement myStatement = new Statement("Print", myField);
        myMethod.addStatement(myStatement);

        compilationUnit.addClass(myClass);

        System.out.print(compilationUnit.generateCodeForMyLinux());
        System.out.println("-------------------------------------");
        System.out.print(compilationUnit.generateCodeForMyApple());
    }
}
