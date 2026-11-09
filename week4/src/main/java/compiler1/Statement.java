package compiler1;

public class Statement {
    String instruction;
    final private Field field;

    public Statement(String instruction, Field field) {
        this.instruction = instruction;
        this.field = field;
    }

//    To be implemented
    public String generateCode() {
        String generatedCode = "\t\t" + this.instruction + " " + field.getName() + "\n";
//        Do something cool
        return generatedCode;
    }
}
