package compiler3;


public class MyLinuxVisitor implements IVisitor {

    @Override
    public void open(CompilationUnit aCompilationUnit) {
        String generatedCode = "; MyLinux v0.0.3\n";
        System.out.print(generatedCode);
    }

    @Override
    public void close(CompilationUnit aCompilationUnit) {
        System.out.print("\n; End of MyLinux program.\n");

    }

    @Override
    public void open(Class aClass) {
        String generatedCode = "CLASS " + aClass.getName() + "\n";
        System.out.print(generatedCode);
    }

    @Override
    public void close(Class aClass) {

    }

    @Override
    public void open(Method aMethod) {
        String generatedCode = "\tMETHOD " + aMethod.getName() + "\n";
        System.out.print(generatedCode);
    }

    @Override
    public void close(Method aMethod) {
        String generatedCode = "\tEND METHOD\n";
        System.out.print(generatedCode);
    }

    @Override
    public void visit(Statement aStatement) {
        String generatedCode = "\t\t" + aStatement.getInstruction().toUpperCase() + " "
                + aStatement.getField().getName().toLowerCase() + "\n";
        System.out.print(generatedCode);
    }

    @Override
    public void visit(Field aField) {
        String generatedCode = "\tField "+ aField.getName().toUpperCase() + " = " + aField.getValue() + "\n\n";
        System.out.print(generatedCode);
    }
}
