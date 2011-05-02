package cruise.ui.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import cruise.model.abstractObjects.BackingObject;
import cruise.umple.compiler.UmpleModel;


public interface UIGenerator {

	public UIProvider getUIProvider();
	
	public void setProperties(Properties prop);
	
	public Properties getProperties();
	
	public Map<String,BackingObject> getClassMap();

	public void initialize(UmpleModel us);

	public List<BackingObject> getAllClasses();

	public List<BackingObject> getSingletons();

	public List<BackingObject> getClasses();

	public boolean isInitialized();
}
