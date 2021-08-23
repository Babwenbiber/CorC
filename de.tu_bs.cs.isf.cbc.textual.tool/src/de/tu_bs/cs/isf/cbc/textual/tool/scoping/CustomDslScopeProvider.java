package de.tu_bs.cs.isf.cbc.textual.tool.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import com.google.common.base.Objects;
import de.tu_bs.cs.isf.cbc.cbcmodel.BlockStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbcmodelPackage;

public class CustomDslScopeProvider extends AbstractDslScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
    // We want to define the Scope for the Element's superElement cross-reference
	    if (context instanceof BlockStatement
	//            && reference == CbcmodelPackage.Literals.ELEMENT__SUPER_ELEMENT
	            && reference == CbcmodelPackage.Literals.ABSTRACT_STATEMENT__REFERENCES
	            ) {
	        // Collect a list of candidates by going through the model
	        // EcoreUtil2 provides useful functionality to do that
	        // For example searching for all elements within the root Object's tree
	        EObject rootElement = EcoreUtil2.getRootContainer(context);
	        List<BlockStatement> candidates = EcoreUtil2.getAllContentsOfType(rootElement, BlockStatement.class);
	        IScope existingScope = Scopes.scopeFor(candidates);
	
	        return new FilteringScope(existingScope, (e) -> !Objects.equal(e.getEObjectOrProxy(), context));
	        // Create IEObjectDescriptions and puts them into an IScope instance
	//        return Scopes.scopeFor(candidates);
	    }
	    return super.getScope(context, reference);
	}
}
