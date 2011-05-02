package cruise.generator;

import cruise.model.abstractObjects.BackingObject;
import cruise.ui.interfaces.ValidationProvider;
import cruise.umple.compiler.AssociationVariable;

public abstract class AbstractValidationProvider implements ValidationProvider {

	private String generateValidationCode(BackingObject bckObject){
	
		return "";
	}
	public String getValidationCode(BackingObject bckObject){
		
		return "";
	}
}
