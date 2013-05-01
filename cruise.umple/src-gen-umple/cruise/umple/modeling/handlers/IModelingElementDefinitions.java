/*******************************************************************************
* Copyright (c) 2013 Ahmed M.Orabi, Mahmoud M.Orabi.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Ahmed M.Orabi
*     Mahmoud M.Orabi
*
* Please refer to the code authors before making any changes. 
* For any code reuse or copy, contact the authors and it is a MUST 
* to refer author names.
*
* @author -Ahmed M.Orabi {@link ahmedvc@hotmail.com}
* @author Mahmoud M.Orabi {@link mahmoud_3rabi@hotmail.com}
*******************************************************************************/
package cruise.umple.modeling.handlers;

public interface IModelingElementDefinitions {
	
	//TODO: Move
	public String IS_LAZY= "isLazy"; //$NON-NLS-1$
	public String IS_IMMUTABLE= "isImmutable"; //$NON-NLS-1$
	public String IS_SINGLETON= "isSingleton"; //$NON-NLS-1$
	public String IS_DEFAULTED= "isDefaulted"; //$NON-NLS-1$
	public String IS_AUTO_UNIQUE= "isAutoUnique"; //$NON-NLS-1$
	public String IS_SORTED= "isSorted"; //$NON-NLS-1$
	public String IS_DERIVED= "isDerived"; //$NON-NLS-1$
	public String IS_INTERNAL= "isInternal"; //$NON-NLS-1$
	public String DEFAULTED_MODIFIER= "defaulted"; //$NON-NLS-1$
	public String INTERNAL= "internal"; //$NON-NLS-1$
	public String HAS_KEY_MEMBERS= "key"; //$NON-NLS-1$
	public String IS_KEY_MEMBER= "isKeyMemeber"; //$NON-NLS-1$
	public String CONSTRAINTS= "constraints"; //$NON-NLS-1$
	public String CODE= "code"; //$NON-NLS-1$
	public String CODE_INJECTION= "codeInjection"; //$NON-NLS-1$
	public String PRIORITY= "priority"; //$NON-NLS-1$
	
	public String TYPE_NAME= "typeName"; //$NON-NLS-1$
	public String IS_ABSTRACT= "isAbstract"; //$NON-NLS-1$
	public String MANY_TYPE_NAME= "manyTypeName"; //$NON-NLS-1$
	
	public String DEFAULT_VALUE= "defaultValue"; //$NON-NLS-1$
	public String NAME= "name"; //$NON-NLS-1$
	public String SINGULAR_NAME= "singularName"; //$NON-NLS-1$
	public String PLURAL_NAME= "pluralName"; //$NON-NLS-1$
	public String USE= "use"; //$NON-NLS-1$
	public String OWNER_NAME= "ownerName"; //$NON-NLS-1$
	public String RETURN_TYPE= "returnType"; //$NON-NLS-1$
	public String OPERATION_PARAMETERS= "operationParameters"; //$NON-NLS-1$
	public String OPERATION_BODY= "operationBody"; //$NON-NLS-1$
	public String PARENT_INTERFACES= "parentInterfaces"; //$NON-NLS-1$
	public String PARENT_CLASS= "parentClass"; //$NON-NLS-1$
	
	public String NAMESPACE= "namespace"; //$NON-NLS-1$
	public String FILE= "file"; //$NON-NLS-1$
	
	public String TYPE_PARAMETER_NAME= "type.parameter.name.normalizedTypeName"; //$NON-NLS-1$
	
	public String OTHER_END_UPPER_BOUND= "otherEndUpperBound"; //$NON-NLS-1$
	public String OTHER_END_LOWER_BOUND= "otherEndLowerBound"; //$NON-NLS-1$
	public String IS_OTHER_END_NAVIGABLE= "isOtherEndNavigable"; //$NON-NLS-1$
	public String IS_NAVIGABLE= "isNavigable"; //$NON-NLS-1$
	public String IS_STATIC= "isStatic"; //$NON-NLS-1$
	public String IS_CONSTANT= "isConstant"; //$NON-NLS-1$
	public String COMMENTS= "comments"; //$NON-NLS-1$
	
	public String UPPER_BOUND= "upperBound"; //$NON-NLS-1$
	public String LOWER_BOUND= "lowerBound"; //$NON-NLS-1$
	public String ROLE_NAME= "roleName"; //$NON-NLS-1$
	public String OTHER_END_ROLE_NAME= "otherEndRoleName"; //$NON-NLS-1$
	
	public String ASSOCIATION_VARIABLES= "associationVariables"; //$NON-NLS-1$
	public String NAVIGABLE_ASSOCIATION_VARIABLES= "navigableAssociationVariables"; //$NON-NLS-1$
	public String ATTRIBUTES= "ownedAttributes"; //$NON-NLS-1$
	public String OPERATIONS= "ownedOperations"; //$NON-NLS-1$
	public String DEPENDS= "ownedDepends"; //$NON-NLS-1$
	public String ELEMENT_VISIBILITY= "elementVisibility"; //$NON-NLS-1$
	
	public String OTHER_END_NAME= "otherEndName"; //$NON-NLS-1$
	public String OTHER_END_TYPE_NAME= "otherEndTypeName"; //$NON-NLS-1$
	public String OTHER_END_TYPE= "otherEndType"; //$NON-NLS-1$
	public String TYPE= "type"; //$NON-NLS-1$
	public String ROOT_NAME= "rootName"; //$NON-NLS-1$
	
	public String CLASSES= "classes"; //$NON-NLS-1$
	public String INTERFACES= "interfaces"; //$NON-NLS-1$
	
	public String MODELS_PROCESSOR= "modelsProcessor"; //$NON-NLS-1$
	public String CLASSES_PROCESSOR= "classesProcessor"; //$NON-NLS-1$
	public String INTERFACES_PROCESSOR= "interfacesProcessor"; //$NON-NLS-1$
	public String DEPENDS_PROCESSOR= "dependsProcessor"; //$NON-NLS-1$
	public String ASSOCIATION_VARIABLES_PROCESSOR= "associationVariablesProcessor"; //$NON-NLS-1$
	public String NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR= "navigableAssociationVariablesProcessor"; //$NON-NLS-1$
	
	public String ATTRIBUTES_PROCESSOR= "attributesProcessor"; //$NON-NLS-1$
	public String OPERATIONS_PROCESSOR= "operationsProcessor"; //$NON-NLS-1$
	public String OPERATIONS_PARAMETERS_PROCESSOR= "operationsParametersProcessor"; //$NON-NLS-1$
	
}
