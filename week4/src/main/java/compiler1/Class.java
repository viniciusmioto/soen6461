package compiler1;

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

    public void removeMethod(final Method aMethod) {
        if (this.methods.contains(aMethod)) {
            this.methods.remove(aMethod);
        }
    }

    public void removeField(final Field aField) {
        if (fields.contains(aField)) {
            this.fields.remove(aField);
        }
    }

    public String generateCode() {
        String generatedCode = "CLASS " + this.name + "\n";
//        Do something at the beginning
        final Iterator iteratorOnFields = this.fields.iterator();
        while (iteratorOnFields.hasNext()) {
            final Field aField = (Field) iteratorOnFields.next();
            generatedCode += aField.generateCode();
        }
        final Iterator iteratorOnMethods = this.methods.iterator();
        while (iteratorOnMethods.hasNext()) {
            final Method aMethod = (Method) iteratorOnMethods.next();
            generatedCode += aMethod.generateCode();
        }

        generatedCode += "END CLASS\n\n";
        return generatedCode;
    }
}
