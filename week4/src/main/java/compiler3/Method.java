package compiler3;

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

    public String getName() {
        return this.name;
    }

    public void addStatement(final Statement aStatement) {
        this.statements.add(aStatement);
    }

    public void accept(IVisitor aVisitor) {
        aVisitor.open(this);
        final Iterator iterator = this.statements.iterator();
        while (iterator.hasNext()) {
            final Statement aStatement = (Statement) iterator.next();
            aStatement.accept(aVisitor);
        }

        aVisitor.close(this);
    }
}
