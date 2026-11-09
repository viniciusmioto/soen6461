package compiler3;

public interface IVisitor {
    public void open(CompilationUnit aCompilationUnit);
    public void close(CompilationUnit aCompilationUnit);

    public void open(Class aClass);
    public void close(Class aClass);

    public void open(Method aMethod);
    public void close(Method aMethod);

    public void visit(Field aField);
    public void visit(Statement aStatement);

}
