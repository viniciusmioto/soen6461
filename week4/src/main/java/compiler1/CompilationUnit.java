package compiler1;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class CompilationUnit {
    private Set<Class> classes = new LinkedHashSet<>();

    public void addClass(final Class aClass){
        this.classes.add(aClass);
    }

    public void removeClass(final Class aClass){
        this.classes.remove(aClass);
    }

    public Class getClass(final String aClassName){
        final Iterator iterator = this.classes.iterator();
        while(iterator.hasNext()){
            final Class aClass = (Class) iterator.next();
            if(aClass.getName().equals(aClassName)){
                return aClass;
            }
        }
        return null;
    }

    public String generateCode() {
        String generatedCode = "; MyLinux v0.0.1\n";
//        Do something at the beginning
        final Iterator iterator = this.classes.iterator();
        while(iterator.hasNext()){
            final Class aClass = (Class) iterator.next();
            generatedCode += aClass.generateCode();
        }
//        Do something at the end;
        return generatedCode;
    }
}
