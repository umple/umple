package cruise.ui.interfaces;

import cruise.model.abstractObjects.BackingObject;

public interface ValidationProvider {
	public String getPreValidateCode(BackingObject bckObject);
	public String getPostValidateCode(BackingObject bckObject);
	public String getValidationCode(BackingObject bckObject);
	
}
