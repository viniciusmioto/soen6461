package compiler2;

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

    public String generateCodeForMyLinux() {
        String generatedCode = "; MyLinux v0.0.2\n";
        final Iterator iterator = this.classes.iterator();
        while(iterator.hasNext()){
            final Class aClass = (Class) iterator.next();
            generatedCode += aClass.generateCodeForMyLinux();
        }

        generatedCode += "; End of MyLinux program.\n\n";
        return generatedCode;
    }


    public String generateCodeForMyApple() {
        String generatedCode = "; MyApple v0.2.2\n";
        final Iterator iterator = this.classes.iterator();
        while(iterator.hasNext()){
            final Class aClass = (Class) iterator.next();
            generatedCode += aClass.generateCodeForMyApple();
        }

        generatedCode += "; End of MyApple program.\n\n";
        return generatedCode;
    }
}
