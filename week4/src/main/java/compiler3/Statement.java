package compiler3;

public class Statement {
    private String instruction;
    final private Field field;

    public Statement(String instruction, Field field) {
        this.instruction = instruction;
        this.field = field;
    }

    public String getInstruction() {
        return instruction;
    }

    public Field getField() {
        return field;
    }

    public void accept(IVisitor aVisitor){
        aVisitor.visit(this);
    }

}
