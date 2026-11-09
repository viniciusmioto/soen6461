package compiler1;

public class Main {
    public static void main(String[] args) {
        CompilationUnit compilationUnit = new CompilationUnit();

        Class myClass = new Class("Person");

        Field myField = new Field("age", "25");
        myClass.addField(myField);

        Method myMethod = new Method("showAge");
        myClass.addMethod(myMethod);

        Statement myStatement = new Statement("PRINT", myField);
        myMethod.addStatement(myStatement);

        compilationUnit.addClass(myClass);

        System.out.print(compilationUnit.generateCode());
    }
}
