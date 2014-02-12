package cruise.umple.validator;

import java.util.List;

public interface CodeGenValidator {
	public boolean validateGeneratedCode (String uFile);
	public boolean validateGeneratedCode (List<String> uFiles);
}
