package cruise.generator;

import java.io.IOException;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import cruise.exception.GeneratorException;
import cruise.model.FragmentLoader;
import cruise.model.FragmentResolver;
import cruise.model.ParameterManager;
import cruise.model.GUI.GUIFragmentLoader;
import cruise.model.GUI.GUIFragmentResolver;
import cruise.model.abstractObjects.BackingObject;
import cruise.model.fragments.AttributteFragmentProvider;
import cruise.model.fragments.GUIFragmentProvider;
import cruise.ui.interfaces.UIGenerator;
import cruise.ui.interfaces.UIProvider;
import cruise.ui.interfaces.ValidationProvider;
import cruise.umple.compiler.Attribute;


public abstract class AbstractProvider implements UIProvider {

	private FragmentResolver fragmentResolver;
	private GUIFragmentResolver guiFragmentResolver;
	private boolean initialized;
	private Map<String, BackingObject> classMap;
	private List<BackingObject> allClasses;
	private List<BackingObject> singletons;
	private List<BackingObject> classes;
	public static Properties properties;
	public ValidationProvider validationProvider;
	
	public void initialize(UIGenerator generator){
		this.classMap=generator.getClassMap();
		this.allClasses=generator.getAllClasses();
		this.singletons=generator.getSingletons();
		this.classes=generator.getClasses();
		properties=generator.getProperties();
		initialized=true;
		
	}
	
	public AbstractProvider(String xmlFile, String xmlGUIFile) {
		Map<String, AttributteFragmentProvider> attfragmentProviderMap = new HashMap<String, AttributteFragmentProvider>();
		Map<String, GUIFragmentProvider> guifragmentProviderMap = new HashMap<String, GUIFragmentProvider>();
		try {
			XMLReader parser = XMLReaderFactory.createXMLReader();
			parser
					.setContentHandler(new FragmentLoader(
							attfragmentProviderMap));
			InputSource inputSource = new InputSource();
			inputSource.setByteStream(getClass().getClassLoader()
					.getResourceAsStream(xmlFile));
			parser.parse(inputSource);
			fragmentResolver = new FragmentResolver(attfragmentProviderMap);

			parser = XMLReaderFactory.createXMLReader();
			parser.setContentHandler(new GUIFragmentLoader(
					guifragmentProviderMap));
			inputSource = new InputSource();
			inputSource.setByteStream(getClass().getClassLoader()
					.getResourceAsStream(xmlGUIFile));
			parser.parse(inputSource);
			guiFragmentResolver = new GUIFragmentResolver(
					guifragmentProviderMap);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		}
	}

	public String getSetFragment(Attribute var, String... args) {
		String fragment = fragmentResolver.getFragmentProvider(var)
				.getSetFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;
	}

	public String getGetFragment(Attribute var, String... args) {
		String fragment = fragmentResolver.getFragmentProvider(var)
				.getGetFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;
	}

	public String getDeclarationFragment(Attribute var, String... args) {
		String fragment = fragmentResolver.getFragmentProvider(var)
				.getDeclarationFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;
	}

	public String getAsignationFragment(Attribute var, String... args) {
		String fragment = fragmentResolver.getFragmentProvider(var)
				.getAsignationFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;

	}

	public String getCopyFragment(Attribute var, String... args) {
		String fragment = fragmentResolver.getFragmentProvider(var)
				.getCopyFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;

	}

	public String getPreConstructorFragment(Attribute var,
			String... args) {
		String fragment = fragmentResolver.getFragmentProvider(var)
				.getPreConstructorFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;

	}

	public String getReverseCopyFragment(Attribute var, String... args) {
		String fragment = fragmentResolver.getFragmentProvider(var)
				.getReverseCopyFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;

	}

	@Override
	public String getGUICreateFragment(Attribute var, String... args) {
		String fragment = guiFragmentResolver.getFragmentProvider(var)
				.getCreateFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;
	}

	public String getGUIEditFragment(Attribute var, String... args) {
		String fragment = guiFragmentResolver.getFragmentProvider(var)
				.getEditFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;
	}

	public String getGUIGridFragment(Attribute var, String... args) {
		String fragment = guiFragmentResolver.getFragmentProvider(var)
				.getGridFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;
	}

	@Override
	public String getGUIGridHeaderFragment(Attribute var,
			String... args) {
		String fragment = guiFragmentResolver.getFragmentProvider(var)
				.getGridHeaderFragment(var);
		if (args.length > 0) {
			return ParameterManager.replace(fragment, args);
		}
		return fragment;
	}

	public List<BackingObject> getAllClasses() {
		if (!initialized)
			throw new GeneratorException("AbstractProvider not initialized");
		return allClasses;
	}

	public List<BackingObject> getSingletons() {
		if (!initialized)
			throw new GeneratorException("AbstractProvider not initialized");
		return singletons;
	}

	public List<BackingObject> getClasses() {
		if (!initialized)
			throw new GeneratorException("AbstractProvider not initialized");
		return classes;
	}

	public Map<String, BackingObject> getClassMap() {
		if (!initialized)
			throw new GeneratorException("AbstractProvider not initialized");
		return classMap;
	}

	public ValidationProvider getValidationProvider() {
		return validationProvider;
	}

	public void setValidationProvider(ValidationProvider validationProvider) {
		if (!initialized)
			throw new GeneratorException("AbstractProvider not initialized");
		this.validationProvider = validationProvider;
	}
	
	public boolean isInitialized() {
		return initialized;
	}

}
