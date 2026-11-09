package compiler2;

public class Statement {
    String instruction;
    final private Field field;

    public Statement(String instruction, Field field) {
        this.instruction = instruction;
        this.field = field;
    }

    public String generateCodeForMyLinux() {
        String generatedCode = "\t\t" + this.instruction.toUpperCase() + " " + field.getName().toLowerCase() + "\n";
        return generatedCode;
    }

    public String generateCodeForMyApple() {
        String generatedCode = "\t\t" + this.instruction.toLowerCase() + " " + field.getName().toUpperCase() + "\n";
        return generatedCode;
    }
}
