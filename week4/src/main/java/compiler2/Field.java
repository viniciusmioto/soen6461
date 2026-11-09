package compiler2;

public class Field {
    String name;
    String value;

    public Field(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }
    public String getValue() {
        return value;
    }

    public String generateCodeForMyLinux() {
        String generatedCode = "\tFIELD "+ this.name + " = " + this.value + "\n\n";
        return generatedCode;
    }

    public String generateCodeForMyApple() {
        String generatedCode = "\tField "+ this.name.toUpperCase() + " = " + this.value + "\n\n";
        return generatedCode;
    }
}
