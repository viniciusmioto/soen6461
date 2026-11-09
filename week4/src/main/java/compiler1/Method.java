package compiler1;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Method {
    private Set<Statement> statements = new LinkedHashSet<>();
    String name;

    public Method(String name) {
        this.name = name;
    }

    public Method(String name, Set<Statement> statements) {
        this.name = name;
        this.statements = statements;
    }

    public void addStatement(final Statement aStatement){
        this.statements.add(aStatement);
    }

    public void removeStatement(final Statement aStatement){
        this.statements.remove(aStatement);
    }

    public String generateCode() {
        String generatedCode = "\tMETHOD " + this.name + "\n";
//        Do something at the beginning
        final Iterator iterator = this.statements.iterator();
        while (iterator.hasNext()) {
            final Statement aStatement = (Statement) iterator.next();
            generatedCode += aStatement.generateCode();
        }
        generatedCode += "\tEND METHOD\n";

        return generatedCode;
    }
}
