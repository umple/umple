
package cruise.umple.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class UmpleCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public UmpleCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("cruise::umple::validation::UmpleFastChecks", CheckType.FAST);
		addCheckFile("cruise::umple::validation::UmpleChecks", CheckType.NORMAL);
		addCheckFile("cruise::umple::validation::UmpleExpensiveChecks", CheckType.EXPENSIVE);
	}
	
@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(cruise.umple.umple.UmplePackage.eINSTANCE);
		return result;
	}
	
}
