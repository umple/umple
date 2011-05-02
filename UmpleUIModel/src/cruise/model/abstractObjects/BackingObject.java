package cruise.model.abstractObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cruise.exception.GeneratorException;
import cruise.model.util.AssociationsResolver;
import cruise.ui.interfaces.UIProvider;
import cruise.umple.compiler.AssociationVariable;
import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.Depend;
import cruise.umple.compiler.UmpleClass;

public class BackingObject {

	public boolean isInitialized() {
		return initialized;
	}

	private boolean initialized;
	private String packageName;
	private String className;
	private String constructorSignature;
	private List<String> imports;
	private List<Attribute> attVariables = new ArrayList<Attribute>();
	private ArrayList<Attribute> keysAttributes = new ArrayList<Attribute>();
	private UmpleClass uClazz;
	private UIProvider fragmentProvider;
	private List<AssociationVariable> constructorOneAssociations;
	private List<AssociationVariable> zeroOrOneAssociations;
	private List<AssociationVariable> zeroManyToOptionalAssociations;
	private List<AssociationVariable> nManyToOptionalAssociations;
	private List<AssociationVariable> manyToOneAssociations;
	private List<AssociationVariable> mandatoryToSingletonAssociations;
	private List<AssociationVariable> optionalToSingletonAssociations;
	private List<AssociationVariable> manyToOneSingletonAssociations;
	private boolean hasKey = false;
	private String[] keys = new String[0];
	private String DAOTable;

	public boolean isHasKey() {
		return hasKey;
	}

	public String[] getKeys() {
		return keys;
	}

	public UmpleClass getUClazz() {
		return uClazz;
	}

	public List<AssociationVariable> getManyToOneAssociations() {
		return manyToOneAssociations;
	}

	public BackingObject(UmpleClass clazz) {
		this.uClazz = clazz;
		this.setClassName(clazz.getName());
		this.setPackageName(clazz.getPackageName());
		if (clazz.getKey() != null) {
			keys = clazz.getKey().getMembers().clone();
			Arrays.sort(keys);
			hasKey = true;
		}
		Map<String, Attribute> completeAttVariables = new HashMap<String, Attribute>();
		UmpleClass parent = clazz;
		while (parent != null) {

			for (Attribute attVrParent : parent.getAttributes()) {
				if (completeAttVariables.get(attVrParent.getName()) == null)
					completeAttVariables
							.put(attVrParent.getName(), attVrParent);
			}

			DAOTable = parent.getPackageName() + "." + parent.getName();
			parent = parent.getExtendsClass();

		}
		ArrayList<Attribute> compAttVriables = new ArrayList<Attribute>(
				completeAttVariables.values());
		for (Attribute attVr : compAttVriables) {
			if (this.isKey(attVr)) {
				attVr.setModifier("key");
				keysAttributes.add(attVr);
			} else {
				attVariables.add(attVr);
			}
			completeAttVariables.put(attVr.getName(), attVr);
		}

		List<String> imports = new ArrayList<String>();
		
		for (Depend d:clazz.getDepends()){
			imports.add(d.getName());
		}
	//	imports.addAll(Arrays.asList(clazz.getDepends()));
		imports.addAll(Arrays.asList(clazz.getGeneratedClass().getMultiLookup(
				cruise.model.Constants.UMPLE_MULTILOOKUP_IMPORT)));
		this.setConstructorSignature(clazz.getGeneratedClass().getLookup(
				cruise.model.Constants.UMPLE_CONSTRUCTOR_SIGNATURE));
		imports.add(clazz.getPackageName() + ".*");
		this.setImports(imports);

	}

	public void initialize(UIProvider fragmentProvider) {
		this.fragmentProvider = fragmentProvider;
		AssociationsResolver assocResolver = new AssociationsResolver(this
				.getUClazz(), this.fragmentProvider.getClassMap());
		constructorOneAssociations = assocResolver
				.getConstructorOneAssociations();
		zeroOrOneAssociations = assocResolver.getZeroOrOneAssociations();
		zeroManyToOptionalAssociations = assocResolver
				.getZeroManyToOptionalAssociations();
		nManyToOptionalAssociations = assocResolver
				.getNManyToOptionalAssociations();
		manyToOneAssociations = assocResolver.getManyToOneAssociations();
		mandatoryToSingletonAssociations = assocResolver.getMandatoryToSingletonAssociations();
		optionalToSingletonAssociations = assocResolver.getOptionalToSingletonAssociations();
		manyToOneSingletonAssociations = assocResolver.getManyToOneSingletonAssociations();
		initialized = true;
	}

	public ArrayList<Attribute> getKeysAttributes() {
		return keysAttributes;
	}

	public void setKeysAttributes(ArrayList<Attribute> keysAttributes) {
		this.keysAttributes = keysAttributes;
	}

	public boolean isKey(Attribute attribute) {
		if (hasKey) {
			return Arrays.binarySearch(keys, attribute.getName()) >= 0;
		}
		return false;
	}

	public boolean hasParent() {
		return this.uClazz.getExtendsClass() != null;

	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<String> getImports() {
		return imports;
	}

	public void setImports(List<String> imports) {
		this.imports = imports;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setConstructorSignature(String constructorSignature) {
		this.constructorSignature = constructorSignature;
	}

	public String getConstructorSignature() {
		return constructorSignature;
	}

	public void setAttVariables(List<Attribute> attVariables) {
		this.attVariables = attVariables;
	}

	public List<Attribute> getAttVariables() {
		return attVariables;
	}

	public UIProvider getFragmentProvider() {
		if (!initialized)
			throw new GeneratorException("BackingObject "+uClazz.getName()+ " not initialized");
		return fragmentProvider;
	}

	public void setDAOTable(String dAOTable) {
		DAOTable = dAOTable;
	}

	public String getDAOTable() {
		return DAOTable;
	}

	public List<AssociationVariable> getConstructorOneAsociations() {
		if (!initialized)
			throw new GeneratorException("BackingObject "+uClazz.getName()+ " not initialized");
		return constructorOneAssociations;
	}

	public List<AssociationVariable> getZeroOrOneAsociations() {
		if (!initialized)
			throw new GeneratorException("BackingObject "+uClazz.getName()+ " not initialized");
		return zeroOrOneAssociations;
	}

	public List<AssociationVariable> getZeroManyToOptionalAssociations() {
		if (!initialized)
			throw new GeneratorException("BackingObject "+uClazz.getName()+ " not initialized");
		return zeroManyToOptionalAssociations;
	}

	public List<AssociationVariable> getNManyToOptionalAssociations() {
		if (!initialized)
			throw new GeneratorException("BackingObject "+uClazz.getName()+ " not initialized");
		return nManyToOptionalAssociations;
	}

	public List<AssociationVariable> getMandatoryToSingletonAssociations() {
		if (!initialized)
			throw new GeneratorException("BackingObject "+uClazz.getName()+ " not initialized");
		return mandatoryToSingletonAssociations;
	}

	public List<AssociationVariable> getOptionalToSingletonAssociations() {
		if (!initialized)
			throw new GeneratorException("BackingObject "+uClazz.getName()+ " not initialized");
		return optionalToSingletonAssociations;
	}

	public List<AssociationVariable> getManyToOneSingletonAssociations() {
		if (!initialized)
			throw new GeneratorException("BackingObject "+uClazz.getName()+ " not initialized");
		return manyToOneSingletonAssociations;
	}

}
