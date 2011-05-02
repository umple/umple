package cruise.ui.interfaces;

import java.util.Map;

import cruise.model.abstractObjects.BackingObject;
import cruise.umple.compiler.Attribute;


public interface UIProvider {

	public String getSetFragment(Attribute var, String... args);

	public String getGetFragment(Attribute var, String... args);

	public String getDeclarationFragment(Attribute var, String... args);

	public String getAsignationFragment(Attribute var, String... args);
	
	public String getCopyFragment(Attribute var, String... args);
	
	public String getPreConstructorFragment(Attribute var, String... args);
	
	public String getReverseCopyFragment(Attribute var, String... args);
	
	public String getGUICreateFragment(Attribute var, String... args);
	
	public String getGUIEditFragment(Attribute var, String... args);
	
	public String getGUIGridFragment(Attribute var, String... args);
	
	public String getGUIGridHeaderFragment(Attribute var, String... args);

	public Map<String,BackingObject> getClassMap();
	
}
