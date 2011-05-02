package cruise.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import cruise.exception.GeneratorException;
import cruise.model.abstractObjects.BackingObject;
import cruise.ui.interfaces.UIGenerator;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleModel;

public abstract class AbstractUIGenerator implements UIGenerator {

	private boolean initialized;
	private Properties properties;
	private Map<String, BackingObject> classMap;
	private List<BackingObject> allClasses;
	private List<BackingObject> singletons;
	private List<BackingObject> classes;
	

	public void initialize(UmpleModel us) {
		allClasses = new ArrayList<BackingObject>();
		singletons = new ArrayList<BackingObject>();
		classes = new ArrayList<BackingObject>();
		Iterator<UmpleClass> umpleClassIterator = us.getUmpleClasses().iterator();
		classMap = new HashMap<String, BackingObject>();

		while (umpleClassIterator.hasNext()) {
			UmpleClass clazz = umpleClassIterator.next();
			BackingObject bck = new BackingObject(clazz);
			allClasses.add(bck);
			classMap.put(clazz.getName(), bck);
			if (clazz.getIsSingleton()) {
				singletons.add(bck);
			} else {
				classes.add(bck);
			}
			initialized = true;
		}
	}

	public List<BackingObject> getAllClasses() {
		if (!initialized)
			throw new GeneratorException("UIGenerator not initialized");
		return allClasses;
	}

	public List<BackingObject> getSingletons() {
		if (!initialized)
			throw new GeneratorException("UIGenerator not initialized");
		return singletons;
	}

	public List<BackingObject> getClasses() {
		if (!initialized)
			throw new GeneratorException("UIGenerator not initialized");
		return classes;
	}

	public Map<String, BackingObject> getClassMap() {
		if (!initialized)
			throw new GeneratorException("UIGenerator not initialized");
		return classMap;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
