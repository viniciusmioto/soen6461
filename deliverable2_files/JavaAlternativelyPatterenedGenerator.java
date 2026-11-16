// Path (from the ptidej-Ptidej root): alternative-visitor/src/main/java/padl/alternativeVisitor/JavaAlternativelyPatterenedGenerator.java
package padl.alternativeVisitor;

import java.util.Iterator;
import padl.kernel.IAbstractModel;
import padl.kernel.IAggregation;
import padl.kernel.IAssociation;
import padl.kernel.IClass;
import padl.kernel.IComposition;
import padl.kernel.IConstituent;
import padl.kernel.IConstructor;
import padl.kernel.IContainer;
import padl.kernel.IContainerAggregation;
import padl.kernel.IContainerComposition;
import padl.kernel.ICreation;
import padl.kernel.IDelegatingMethod;
import padl.kernel.IField;
import padl.kernel.IFirstClassEntity;
import padl.kernel.IGetter;
import padl.kernel.IGhost;
import padl.kernel.IInterface;
import padl.kernel.IMemberClass;
import padl.kernel.IMemberGhost;
import padl.kernel.IMemberInterface;
import padl.kernel.IMethod;
import padl.kernel.IMethodInvocation;
import padl.kernel.IOperation;
import padl.kernel.IPackage;
import padl.kernel.IPackageDefault;
import padl.kernel.IPackageGhost;
import padl.kernel.IParameter;
import padl.kernel.IPrimitiveEntity;
import padl.kernel.ISetter;
import padl.kernel.IUseRelationship;
import padl.visitor.IGenerator;
import padl.visitor.repository.JavaGenerator;

/**
 * SOEN 6461, Deliverable 2, Question 3: a Visitor that does its own traversal.
 * It never calls accept(): it walks the model depth-first with the getters of
 * the model and dispatches with a type-pattern switch instead of reflection.
 * The rendering is delegated to a JavaGenerator (composition), so both
 * generators produce the same code.
 *
 * @author Ali Maher, Timéo Klein, and Vinicius Mioto
 */
public class JavaAlternativelyPatterenedGenerator implements IGenerator {
	private final JavaGenerator renderer = new JavaGenerator();

	// Subclasses can prune a subtree, which accept() does not allow.
	protected boolean shouldTraverse(final IConstituent aConstituent) {
		return true;
	}

	private void traverse(final IConstituent aConstituent) {
		if (!this.shouldTraverse(aConstituent)) {
			return;
		}
		if (aConstituent instanceof IPackage || aConstituent instanceof IFirstClassEntity
				|| aConstituent instanceof IOperation) {
			this.dispatchOpen(aConstituent);
			this.traverseConstituentsOf((IContainer) aConstituent);
			this.dispatchClose(aConstituent);
		}
		else {
			this.dispatchVisit(aConstituent);
		}
	}

	// Same iterators as accept(): entities and operations use the concurrent
	// iterator, which does not return the constituents in the same order.
	private void traverseConstituentsOf(final IContainer aContainer) {
		final Iterator iterator = aContainer instanceof IFirstClassEntity || aContainer instanceof IOperation
				? aContainer.getConcurrentIteratorOnConstituents()
				: aContainer.getIteratorOnConstituents();
		while (iterator.hasNext()) {
			this.traverse((IConstituent) iterator.next());
		}
	}

	// Most specific types first. IMethod must precede IConstructor because
	// padl.kernel.impl.Method extends padl.kernel.impl.Constructor.
	private void dispatchOpen(final IConstituent aConstituent) {
		switch (aConstituent) {
			case IPackageGhost p -> this.open(p);
			case IPackageDefault p -> this.open(p);
			case IPackage p -> this.open(p);
			case IMemberClass c -> this.open(c);
			case IClass c -> this.open(c);
			case IMemberInterface i -> this.open(i);
			case IInterface i -> this.open(i);
			case IMemberGhost g -> this.open(g);
			case IGhost g -> this.open(g);
			case IDelegatingMethod m -> this.open(m);
			case IGetter m -> this.open(m);
			case ISetter m -> this.open(m);
			case IMethod m -> this.open(m);
			case IConstructor c -> this.open(c);
			default -> this.unknownConstituentHandler("open", aConstituent);
		}
	}

	private void dispatchClose(final IConstituent aConstituent) {
		switch (aConstituent) {
			case IPackageGhost p -> this.close(p);
			case IPackageDefault p -> this.close(p);
			case IPackage p -> this.close(p);
			case IMemberClass c -> this.close(c);
			case IClass c -> this.close(c);
			case IMemberInterface i -> this.close(i);
			case IInterface i -> this.close(i);
			case IMemberGhost g -> this.close(g);
			case IGhost g -> this.close(g);
			case IDelegatingMethod m -> this.close(m);
			case IGetter m -> this.close(m);
			case ISetter m -> this.close(m);
			case IMethod m -> this.close(m);
			case IConstructor c -> this.close(c);
			default -> this.unknownConstituentHandler("close", aConstituent);
		}
	}

	private void dispatchVisit(final IConstituent aConstituent) {
		switch (aConstituent) {
			case IContainerComposition r -> this.visit(r);
			case IContainerAggregation r -> this.visit(r);
			case IComposition r -> this.visit(r);
			case IAggregation r -> this.visit(r);
			case IAssociation r -> this.visit(r);
			case ICreation r -> this.visit(r);
			case IUseRelationship r -> this.visit(r);
			case IField f -> this.visit(f);
			case IParameter p -> this.visit(p);
			case IMethodInvocation m -> this.visit(m);
			case IPrimitiveEntity e -> this.visit(e);
			default -> this.unknownConstituentHandler("visit", aConstituent);
		}
	}

	public void open(final IAbstractModel anAbstractModel) {
		this.renderer.open(anAbstractModel);
		this.traverseConstituentsOf(anAbstractModel);
	}

	public void close(final IAbstractModel anAbstractModel) {
		this.renderer.close(anAbstractModel);
	}

	public String getCode() {
		return this.renderer.getCode();
	}

	public String getName() {
		return "Java (self-traversing)";
	}

	public void reset() {
		this.renderer.reset();
	}

	public void unknownConstituentHandler(final String aCalledMethodName, final IConstituent aConstituent) {
		this.renderer.unknownConstituentHandler(aCalledMethodName, aConstituent);
	}

	// The remaining methods only delegate the rendering to the JavaGenerator.

	public void open(final IPackage aPackage) { this.renderer.open(aPackage); }
	public void open(final IPackageDefault aPackage) { this.renderer.open(aPackage); }
	public void open(final IPackageGhost aPackageGhost) { this.renderer.open(aPackageGhost); }
	public void open(final IClass aClass) { this.renderer.open(aClass); }
	public void open(final IMemberClass aMemberClass) { this.renderer.open(aMemberClass); }
	public void open(final IInterface anInterface) { this.renderer.open(anInterface); }
	public void open(final IMemberInterface aMemberInterface) { this.renderer.open(aMemberInterface); }
	public void open(final IGhost aGhost) { this.renderer.open(aGhost); }
	public void open(final IMemberGhost aMemberGhost) { this.renderer.open(aMemberGhost); }
	public void open(final IConstructor aConstructor) { this.renderer.open(aConstructor); }
	public void open(final IMethod aMethod) { this.renderer.open(aMethod); }
	public void open(final IDelegatingMethod aDelegatingMethod) { this.renderer.open(aDelegatingMethod); }
	public void open(final IGetter aGetter) { this.renderer.open(aGetter); }
	public void open(final ISetter aSetter) { this.renderer.open(aSetter); }

	public void close(final IPackage aPackage) { this.renderer.close(aPackage); }
	public void close(final IPackageDefault aPackage) { this.renderer.close(aPackage); }
	public void close(final IPackageGhost aPackageGhost) { this.renderer.close(aPackageGhost); }
	public void close(final IClass aClass) { this.renderer.close(aClass); }
	public void close(final IMemberClass aMemberClass) { this.renderer.close(aMemberClass); }
	public void close(final IInterface anInterface) { this.renderer.close(anInterface); }
	public void close(final IMemberInterface aMemberInterface) { this.renderer.close(aMemberInterface); }
	public void close(final IGhost aGhost) { this.renderer.close(aGhost); }
	public void close(final IMemberGhost aMemberGhost) { this.renderer.close(aMemberGhost); }
	public void close(final IConstructor aConstructor) { this.renderer.close(aConstructor); }
	public void close(final IMethod aMethod) { this.renderer.close(aMethod); }
	public void close(final IDelegatingMethod aDelegatingMethod) { this.renderer.close(aDelegatingMethod); }
	public void close(final IGetter aGetter) { this.renderer.close(aGetter); }
	public void close(final ISetter aSetter) { this.renderer.close(aSetter); }

	public void visit(final IAggregation anAggregation) { this.renderer.visit(anAggregation); }
	public void visit(final IAssociation anAssociation) { this.renderer.visit(anAssociation); }
	public void visit(final IComposition aComposition) { this.renderer.visit(aComposition); }
	public void visit(final IContainerAggregation aContainerAggregation) { this.renderer.visit(aContainerAggregation); }
	public void visit(final IContainerComposition aContainerComposition) { this.renderer.visit(aContainerComposition); }
	public void visit(final ICreation aCreation) { this.renderer.visit(aCreation); }
	public void visit(final IField aField) { this.renderer.visit(aField); }
	public void visit(final IMethodInvocation aMethodInvocation) { this.renderer.visit(aMethodInvocation); }
	public void visit(final IParameter aParameter) { this.renderer.visit(aParameter); }
	public void visit(final IPrimitiveEntity aPrimitiveEntity) { this.renderer.visit(aPrimitiveEntity); }
	public void visit(final IUseRelationship aUse) { this.renderer.visit(aUse); }
}
