package compiler3;

public class MyAppleVisitor implements IVisitor {
    @Override
    public void open(CompilationUnit aCompilationUnit) {
        String generatedCode = "; MyApple v0.3.3\n";
        System.out.print(generatedCode);
    }

    @Override
    public void close(CompilationUnit aCompilationUnit) {
        String generatedCode = "; End of MyApple program.\n\n";
        System.out.print(generatedCode);
    }

    @Override
    public void open(Class aClass) {
        String generatedCode = "Class " + aClass.getName().toUpperCase() + "\n";
        System.out.print(generatedCode);
    }

    @Override
    public void close(Class aClass) {
    }

    @Override
    public void open(Method aMethod) {
        String generatedCode = "\tMethod " + aMethod.getName() + "\n";
        System.out.print(generatedCode);
    }

    @Override
    public void close(Method aMethod) {
        String generatedCode = "\tEnd Method\n";
        System.out.print(generatedCode);
    }

    @Override
    public void visit(Field aField) {
        String generatedCode = "\tField "+ aField.getName().toUpperCase() + " = " + aField.getValue() + "\n\n";
        System.out.print(generatedCode);
    }

    @Override
    public void visit(Statement aStatement) {
        String generatedCode = "\t\t" + aStatement.getInstruction().toLowerCase() + " "
                + aStatement.getField().getName().toUpperCase() + "\n";
        System.out.print(generatedCode);
    }
}
