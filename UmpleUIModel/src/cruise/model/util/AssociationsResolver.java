package cruise.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cruise.model.abstractObjects.BackingObject;
import cruise.umple.compiler.AssociationVariable;
import cruise.umple.compiler.UmpleClass;

public class AssociationsResolver {

	private List<AssociationVariable> zeroManyToOptionalAssociations;
	private List<AssociationVariable> nManyToOptionalAssociations;
	private List<AssociationVariable> constructorOneAssociations;
	private List<AssociationVariable> zeroOrOneAssociations;
	private List<AssociationVariable> manyToOneAssociations;
	private List<AssociationVariable> mandatoryToSingletonAssociations;
	private List<AssociationVariable> optionalToSingletonAssociations;
	private List<AssociationVariable> manyToOneSingletonAssociations;
	

	public AssociationsResolver(UmpleClass clazz, Map<String,BackingObject> classMap) {

		constructorOneAssociations = new ArrayList<AssociationVariable>();
		zeroOrOneAssociations = new ArrayList<AssociationVariable>();
		zeroManyToOptionalAssociations = new ArrayList<AssociationVariable>();
		nManyToOptionalAssociations = new ArrayList<AssociationVariable>();
		manyToOneAssociations = new ArrayList<AssociationVariable>();
		mandatoryToSingletonAssociations = new ArrayList<AssociationVariable>();
		optionalToSingletonAssociations = new ArrayList<AssociationVariable>();
		manyToOneSingletonAssociations = new ArrayList<AssociationVariable>();
		Map<String, AssociationVariable> completeAssociationVariable = new HashMap<String, AssociationVariable>();
		UmpleClass parent = clazz;
		while (parent != null) {
			for (AssociationVariable assVrParent : parent
					.getAssociationVariables()) {
				if (completeAssociationVariable.get(assVrParent.getName()) == null)
					completeAssociationVariable.put(assVrParent.getName(),
							assVrParent);
			}
			parent = parent.getExtendsClass();
		}
		ArrayList<AssociationVariable> associations = new ArrayList<AssociationVariable>(
				completeAssociationVariable.values());

		for (AssociationVariable assoc : associations) {
			BackingObject bckAssocObj=classMap.get(assoc.getType());
			BackingObject relatedBckAssocObj=classMap.get(assoc.getRelatedAssociation().getType());
			if (assoc.getIsNavigable()) {
				if (assoc.isOnlyOne()) {
					if(bckAssocObj.getUClazz().getIsSingleton())
						mandatoryToSingletonAssociations.add(assoc);
					else
						constructorOneAssociations.add(assoc);
				} else if (assoc.isOptionalOne()) {
					if(bckAssocObj.getUClazz().getIsSingleton())
						optionalToSingletonAssociations.add(assoc);
					else
						zeroOrOneAssociations.add(assoc);
					
				} else if ((assoc.getMultiplicity().getUpperBound() > 1 || assoc.getMultiplicity().getUpperBound() == -1)
						&& assoc.getMultiplicity().getUpperBound()== 0
						&& ((assoc.getRelatedAssociation().getMultiplicity().getUpperBound() > 1 || assoc
								.getRelatedAssociation().getMultiplicity().getUpperBound() == -1) || (assoc
								.getRelatedAssociation().getMultiplicity().getUpperBound() == 1 && assoc
								.getRelatedAssociation().getMultiplicity().getLowerBound() == 0))) {
					zeroManyToOptionalAssociations.add(assoc);
				} else if ((assoc.getMultiplicity().getUpperBound() > 1 || assoc.getMultiplicity().getUpperBound() == -1)
						&& assoc.getMultiplicity().getLowerBound() > 0
						&& ((assoc.getRelatedAssociation().getMultiplicity().getUpperBound() > 1 || assoc
								.getRelatedAssociation().getMultiplicity().getUpperBound() == -1) || (assoc
								.getRelatedAssociation().getMultiplicity().getUpperBound() == 1 && assoc
								.getRelatedAssociation().getMultiplicity().getLowerBound() == 0))) {
					nManyToOptionalAssociations.add(assoc);
				}
			}
			if (assoc.isMany() && assoc.getRelatedAssociation().isOnlyOne()) {
				if(assoc.getRelatedAssociation().getIsNavigable()){
					if(relatedBckAssocObj.getUClazz().getIsSingleton())
						manyToOneSingletonAssociations.add(assoc);
					else
						manyToOneAssociations.add(assoc);
				} else{
					if(relatedBckAssocObj.getUClazz().getIsSingleton())
						optionalToSingletonAssociations.add(assoc);
					else
						zeroManyToOptionalAssociations.add(assoc);
				}
			}
		}

	}

	public List<AssociationVariable> getMandatoryToSingletonAssociations() {
		return mandatoryToSingletonAssociations;
	}

	public List<AssociationVariable> getOptionalToSingletonAssociations() {
		return optionalToSingletonAssociations;
	}

	public List<AssociationVariable> getManyToOneSingletonAssociations() {
		return manyToOneSingletonAssociations;
	}
	public List<AssociationVariable> getZeroManyToOptionalAssociations() {
		return zeroManyToOptionalAssociations;
	}

	public List<AssociationVariable> getNManyToOptionalAssociations() {
		return nManyToOptionalAssociations;
	}

	public List<AssociationVariable> getConstructorOneAssociations() {
		return constructorOneAssociations;
	}

	public List<AssociationVariable> getZeroOrOneAssociations() {
		return zeroOrOneAssociations;
	}

	public List<AssociationVariable> getManyToOneAssociations() {
		return manyToOneAssociations;
	}
}
