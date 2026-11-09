package compiler2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Class {
    private String name;
    private Set<Method> methods =  new LinkedHashSet<Method>();
    private Set<Field> fields = new LinkedHashSet<Field>();


    public Class(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addMethod(final Method aMethod) {
        this.methods.add(aMethod);
    }

    public void addField(final Field aField) {
        this.fields.add(aField);
    }

    public String generateCodeForMyLinux() {
        String generatedCode = "CLASS " + this.name + "\n";

        final Iterator iteratorOnFields = this.fields.iterator();
        while (iteratorOnFields.hasNext()) {
            final Field aField = (Field) iteratorOnFields.next();
            generatedCode += aField.generateCodeForMyLinux();
        }
        final Iterator iteratorOnMethods = this.methods.iterator();
        while (iteratorOnMethods.hasNext()) {
            final Method aMethod = (Method) iteratorOnMethods.next();
            generatedCode += aMethod.generateCodeForMyLinux();
        }

        generatedCode += "END CLASS\n\n";
        return generatedCode;
    }


    public String generateCodeForMyApple() {
        String generatedCode = "Class " + this.name.toUpperCase() + "\n";

        final Iterator iteratorOnFields = this.fields.iterator();
        while (iteratorOnFields.hasNext()) {
            final Field aField = (Field) iteratorOnFields.next();
            generatedCode += aField.generateCodeForMyApple();
        }
        final Iterator iteratorOnMethods = this.methods.iterator();
        while (iteratorOnMethods.hasNext()) {
            final Method aMethod = (Method) iteratorOnMethods.next();
            generatedCode += aMethod.generateCodeForMyApple();
        }

        generatedCode += "End Class\n\n";
        return generatedCode;
    }
}
