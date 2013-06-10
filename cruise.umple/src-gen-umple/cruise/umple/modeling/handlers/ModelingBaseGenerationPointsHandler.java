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

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationCallback.WatchedObjectValue;
import cruise.umple.core.GenerationLoopAnnotation;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPoint.InterceptorResponse;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.cpp.ICppDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;


public class ModelingBaseGenerationPointsHandler {

	@GenerationLoopAnnotation(id = IModelingElementDefinitions.CLASSES_PROCESSOR)
	public static List<?> getClasses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object model){
		return generationValueGetter.getList(model, IModelingElementDefinitions.CLASSES);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.INTERFACES_PROCESSOR)
	public static List<?> getInterfaces(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object model){
		return generationValueGetter.getList(model, IModelingElementDefinitions.INTERFACES);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void classInterfaceParentTypesProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingConstants.PARENT_CLASS) Object parentClass,
			@GenerationElementParameter(id = IModelingConstants.PARENT_INTERFACES) List<?> parentInterfaces){
		
		if(parentClass!= null){
			String name= generationValueGetter.getString(parentClass, IModelingElementDefinitions.NAME);
			
			//Track the parent class name
			generationValueGetter.addValue(IModelingDecisions.PARENT_CLASS_EXTENDS, name, element);
		}
		
		if(parentInterfaces!= null){
			for(Object obj: parentInterfaces){
				String name= generationValueGetter.getString(obj, IModelingElementDefinitions.NAME);
				
				//Track each used interface name
				generationValueGetter.addValue(IModelingDecisions.INTERFACES_IMPLEMENTS, name, element);
			}
		}
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.ASSOCIATION_VARIABLES_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getAssociationVariables(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.ASSOCIATION_VARIABLES);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getNavigableAssociationVariables(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.ATTRIBUTES_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getAttributes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.ATTRIBUTES);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.OPERATIONS_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getOperations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.OPERATIONS);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.DEPENDS_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getDepends(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.DEPENDS);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.OPERATIONS_PARAMETERS_PROCESSOR, 
			processes= {IModelingElementDefinitions.OPERATIONS_PROCESSOR})
	public static List<?> getOperationsParameters(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object operationObject){
		return generationValueGetter.getList(operationObject, IModelingElementDefinitions.OPERATION_PARAMETERS);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void trackAllTypes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAMESPACE) String namespace,
			@GenerationLoopElement Object modelPackage){
		generationValueGetter.addUniqueValue(IModelingConstants.TYPES_TRACKER, element, modelPackage, name);	//Enable Retrieving by name
		generationValueGetter.addUniqueValue(IModelingConstants.TYPES_BY_NAMESPACES_TRACKER, element, modelPackage, namespace);	//Enable Retrieving by name
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void trackNamespaces(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAMESPACE) String namespace,
			@GenerationLoopElement Object modelPackage){
		
		if(namespace!=null&& !namespace.isEmpty()){
			generationValueGetter.addUniqueValue(IModelingConstants.NAMESPACES_TRACKER, namespace, modelPackage);	//Track all namespaces
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operation parameters paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, 
					IModelingElementDefinitions.OPERATIONS_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PARAMETERS_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, 
					IModelingElementDefinitions.OPERATIONS_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PARAMETERS_PROCESSOR})
	})
	public static void operationsParametersProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationLoopElement(id= {IModelingElementDefinitions.OPERATIONS_PROCESSOR}) Object operationObject,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		SimpleEntry<String, String> simpleEntry = new SimpleEntry<String, String>(type, name);
		generationValueGetter.addValue(IModelingDecisions.OPERATION_PARAMETER_ARGUMENT, simpleEntry, operationObject, parent);	//Add to be used in other places
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PROCESSOR})
	}, aspect= LoopAspectConstants.PRE)
	public static void operationsProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_VISIBILITY) String normalizedVisibility,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		//Must be able to track the given visiblity values
		generationValueGetter.addUniqueValue(VisibilityConstants.VISIBILITY_TRACKER, normalizedVisibility, parent);
		generationValueGetter.generationPointString(element, IModelingDecisions.OPERATIONS_GENERATION_POINT);
		
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	})
	public static void attributesAndAssociationsProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.HAS_MINIMUM_GETTER) boolean hasMinimumGetter,
			@GenerationProcedureParameter(id = IModelingDecisions.HAS_MAXIMUM_GETTER) boolean hasMaximumGetter,
			@GenerationBaseElement Object element){
		
		if(hasMinimumGetter|| hasMaximumGetter){
			generationValueGetter.generationPointString(element, IModelingDecisions.MINIMUM_NUMBER_GENERATION_POINT);
		}
		
		if(hasMaximumGetter){
			generationValueGetter.generationPointString(element, IModelingDecisions.MAXIMUM_NUMBER_GENERATION_POINT);
		}
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void attributesAndAssociationsDeclarationProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_DEFAULT_VALUE) String defaultValue,
			@GenerationLoopElement(id= {IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}) Object attribute,
			@GenerationBaseElement Object element){
		
		List<String> prefixes= new ArrayList<String>();
		
		generationValueGetter.generationPointString(element, IModelingConstants.SET_ATTRIBUTE_PREFIXES, 
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT, prefixes));
		
		String attributeValue= null;
		
		if(isStatic|| isConstant){
			//Only assign values directly to your attributes when it is constant or static
			attributeValue= defaultValue;
		}
		
		generationValueGetter.generationPointString(element, IModelingDecisions.ATTRIBUTE_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_NAME_ARGUMENT, Boolean.valueOf(attribute== null)),
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_IS_ATTRIBUTE_ARGUMENT, Boolean.valueOf(attribute!= null)),
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT, attributeValue),
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT, prefixes));
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void classInterfaceParentTypesProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element){
		String deleteDelcaration = generationValueGetter.use(ICppDefinitions.METHOD_DECLARATION, CPPTypesConstants.VOID, 
				generationValueGetter.use(ICppDefinitions.DELETE_METHOD_NAME));
		
		//Classes and interfaces can have delete function
		generationValueGetter.addValue(ICppDefinitions.DELETE_METHOD_NAME, deleteDelcaration, element);
	}
	
	
	@GenerationPoint(generationPoint = IModelingConstants.ATTRIBUTES_GROUP_PRIORITY)
	public static Integer staticGroupPriority(@GenerationArgument(id= IModelingConstants.GROUP_ID_ARGUMENT) String groupId){
		if(ICppDefinitions.STATIC_ATTRIBUTE_DECLARATIONS.equals(groupId)){
			return Integer.valueOf(IGenerationPointPriorityConstants.MEDIUM); 
		}
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GenerationPoint(generationPoint = IModelingConstants.SETTER_METHOD_NAME)
	public static String setterMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_MANY) boolean isOtherEndMany,
			@GenerationBaseElement Object element){
		String roleName= generationValueGetter.getString(element, (seekOtherEnd?isOtherEndMany:isMany)?IModelingElementDefinitions.PLURAL_NAME
				:IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(roleName== null||roleName.isEmpty()){
			roleName= seekOtherEnd?otherEndName:name;
		}
		return generationValueGetter.use(ICppNameConstants.SET, roleName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.ADD_INSTANCE)
	public static String addInstanceMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String roleName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(roleName== null||roleName.isEmpty()){
			roleName= seekOtherEnd?otherEndName:name;
		}
		return generationValueGetter.use(ICppNameConstants.ADD_INSTANCE, roleName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.SET)
	public static String setter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_MANY) boolean isOtherEndMany,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany){
		String roleName= generationValueGetter.getString(element, (seekOtherEnd?isOtherEndMany:isMany)?IModelingElementDefinitions.PLURAL_NAME
				:IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(roleName== null||roleName.isEmpty()){
			roleName= seekOtherEnd?otherEndName:name;
		}
		return generationValueGetter.use(ICppNameConstants.SET, roleName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.MINIMUM_NUMBER_OF)
	public static String minimumNumberOf(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String pluralName= generationValueGetter.getString(element, IModelingElementDefinitions.PLURAL_NAME, seekOtherEnd?otherEndName:name);
		if(pluralName.isEmpty()){
			pluralName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(IModelingConstants.MINIMUM_NUMBER_OF, pluralName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.MAXIMUM_NUMBER_OF)
	public static String maximumNumberOf(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String pluralName= generationValueGetter.getString(element, IModelingElementDefinitions.PLURAL_NAME, seekOtherEnd?otherEndName:name);
		if(pluralName.isEmpty()){
			pluralName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(IModelingConstants.MAXIMUM_NUMBER_OF, pluralName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.GETTER_METHOD_NAME)
	public static String singleGetterMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_MANY) boolean isOtherEndMany,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String roleName= generationValueGetter.getString(element, (seekOtherEnd?isOtherEndMany:isMany)?IModelingElementDefinitions.PLURAL_NAME
				:IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(roleName== null||roleName.isEmpty()){
			roleName= seekOtherEnd?otherEndName:name;
		}
		return generationValueGetter.use(ICppNameConstants.GET, roleName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.GET)
	public static String getter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_MANY) boolean isOtherEndMany,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String roleName= generationValueGetter.getString(element, (seekOtherEnd?isOtherEndMany:isMany)?IModelingElementDefinitions.PLURAL_NAME
				:IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(roleName== null||roleName.isEmpty()){
			roleName= seekOtherEnd?otherEndName:name;
		}
		return generationValueGetter.use(ICppNameConstants.GET, roleName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.GETTER_BY_INDEX_METHOD_NAME)
	public static String getterMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.GET, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.NUMBER_OF_METHOD_NAME)
	public static String numberOfMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String pluralName= generationValueGetter.getString(element, IModelingElementDefinitions.PLURAL_NAME, seekOtherEnd?otherEndName:name);
		if(pluralName.isEmpty()){
			pluralName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.NUMBER_OF, pluralName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.CONTAINS_METHOD_NAME)
	public static String containsMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String pluralName= generationValueGetter.getString(element, IModelingElementDefinitions.PLURAL_NAME, seekOtherEnd?otherEndName:name);
		if(pluralName.isEmpty()){
			pluralName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.CONTAINS, pluralName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.INDEX_OF_METHOD_NAME)
	public static String indexOfMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.INDEX_OF, singularName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.IS_A)
	public static String isAMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.IS_A, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.REMOVE_AT_METHOD_NAME)
	public static String removeAtMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.REMOVE_AT, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.REMOVE_METHOD_NAME)
	public static String removeMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.REMOVE, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.ADD_METHOD_NAME)
	public static String addMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.ADD_METHOD, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.ADD_OR_MOVE_METHOD_NAME)
	public static String addOrMoveMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.ADD_OR_MOVE_AT, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.ADD_AT_METHOD_NAME)
	public static String addAtMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.ADD_AT, singularName);
	}
	
	
	@GenerationPoint(generationPoint = ICppNameConstants.EXISTING)
	public static String existing(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_MANY) boolean isOtherEndMany,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationBaseElement Object element){
		String roleName= generationValueGetter.getString(element, (seekOtherEnd?isOtherEndMany:isMany)?IModelingElementDefinitions.PLURAL_NAME
				:IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(roleName== null||roleName.isEmpty()){
			roleName= seekOtherEnd?otherEndName:name;
		}
		return generationValueGetter.use(ICppNameConstants.EXISTING, roleName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.ADD_METHOD)
	public static String add(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.ADD_METHOD, singularName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.ADD_AT)
	public static String addAt(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.ADD_AT, singularName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.REMOVE)
	public static String remove(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.REMOVE, singularName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.PLACE_HOLDER)
	public static String placeHolder(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.PLACE_HOLDER, singularName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.NUMBER_OF)
	public static String numberOf(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName){
		String pluralName= generationValueGetter.getString(element, IModelingElementDefinitions.PLURAL_NAME, seekOtherEnd?otherEndName:name);
		if(pluralName.isEmpty()){
			pluralName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.NUMBER_OF, pluralName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.COPY_OF)
	public static String copyOf(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_MANY) boolean isOtherEndMany){
		String roleName= generationValueGetter.getString(element, (seekOtherEnd?isOtherEndMany:isMany)?IModelingElementDefinitions.PLURAL_NAME
				:IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(roleName== null||roleName.isEmpty()){
			roleName= seekOtherEnd?otherEndName:name;
		}
		return generationValueGetter.use(ICppNameConstants.COPY_OF, roleName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.INDEX_OF)
	public static String indexOf(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.INDEX_OF, singularName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.IS_NEW)
	public static String isNew(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.IS_NEW, singularName);
	}
	
	@GenerationPoint(generationPoint = ICppNameConstants.NEW_INSTANCE)
	public static String newInstance(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		return generationValueGetter.use(ICppNameConstants.NEW_INSTANCE, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.MODELING_DEFAULT_NEW_PARAMETER_NAME)
	public static String defaultNewParamaeterName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.NEW_INSTANCE, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.MODELING_DEFAULT_PARAMETER_NAME)
	public static String setterDefaultParameterName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.VARIABLE_PARAMETER, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.MODELING_DEFAULT_SINGLE_PARAMETER_NAME)
	public static String singleDefaultParameterName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName){
		String singularName= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, seekOtherEnd?otherEndName:name);
		if(singularName.isEmpty()){
			singularName= seekOtherEnd?otherEndName:name;
		}
		
		return generationValueGetter.use(ICppNameConstants.VARIABLE_PARAMETER, singularName);
	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.ROLE_NAME)
	public static String roleName(@GenerationElementParameter(id = IModelingElementDefinitions.ROLE_NAME) String roleName,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_ROLE_NAME) String otherEndRoleName,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd){
		
		return seekOtherEnd?otherEndRoleName: roleName;
	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.TYPE_PARAMETER_NAME)
	public static String typeParameterName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany){
		return isMany? generationValueGetter.use(ICppNameConstants.VARIABLE_PARAMETER,name, Boolean.TRUE):
			generationValueGetter.use(ICppNameConstants.VARIABLE_PARAMETER, name);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_ROLE_NAME)
	public static String normalizedRoleName(@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.ROLE_NAME) String roleName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_MANY) boolean isOtherEndMany,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT) boolean seekOtherEnd,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndType,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationProcedureParameter(id= IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_TYPE_ARGUMENT) boolean seekType,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_IGNORE_ROLE_ARGUMENT) boolean ignoreRole,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_SEEK_NAME_ARGUMENT) boolean seekName){
		
		String normalizedRoleName = roleName(name, otherEndName, roleName, isMany, isOtherEndMany, seekOtherEnd, otherEndType, type, isPrimitiveType, seekType, seekName, ignoreRole);
		return StringUtil.firstCharacterToLowerCase(normalizedRoleName);
	}

	private static String roleName(String name, String otherEndName, String roleName, boolean isMany, boolean isOtherEndMany,
			boolean seekOtherEnd, String otherEndType, String type, boolean isPrimitiveType, boolean seekType, boolean seekName, boolean ignoreRole) {
		if(roleName!= null&& !roleName.isEmpty()&& !ignoreRole){
			return roleName;
		}
		
		if(isPrimitiveType){
			return name;
		}
		
		String returnType, returnName;
		boolean isManyCompare;
		
		if(seekOtherEnd){
			returnType= otherEndType;
			returnName= otherEndName;
			isManyCompare= isOtherEndMany;
		}else{
			returnType= type;
			returnName= name;
			isManyCompare= isMany;
		}
		
		if(seekType){
			return returnType;
		}
		
		if(seekName){
			return returnName;
		}
		
		return isManyCompare?returnName: returnType;
	}

	@DecisionPoint(watchIf= {IModelingDecisions.SETTER_GENERATION_POINT}, ifNotConditionIds= {IModelingDecisions.SETTER_GENERATION_POINT_FILTER})
	public static boolean filterAttributeSetter(@GenerationElementParameter(id = IModelingElementDefinitions.IS_INTERNAL) boolean isInternal) {
		//Disable setters for the internal attributes
		//Use SETTER_GENERATION_POINT_FILTER for extensibility
		return !isInternal;
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_CAN_PRINT)
	public static boolean canPrint(){
		//To be extended by clients for more cases
		return true;
	}
	
	@DecisionPoint(watchIf= {IModelingDecisions.GETTER_GENERATION_POINT}, ifNotConditionIds= {IModelingDecisions.GETTER_GENERATION_POINT_FILTER})
	public static boolean filterAttributeGetter(@GenerationElementParameter(id = IModelingElementDefinitions.IS_INTERNAL) boolean isInternal) {
		//Disable getters for the internal attributes
		//Use GETTER_GENERATION_POINT_FILTER for extensibility
		return !isInternal;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.MULTILINE_COMMENTS_STRING, priority= IGenerationPointPriorityConstants.HIGH)
	public static String getNormalizedReturnType(@GenerationElementParameter(id = IModelingElementDefinitions.COMMENTS) List<String> comments){
		return GenerationUtil.multiLineComment(comments); 
	}
	
	@GenerationPoint(intercept = IModelingElementDefinitions.NAME)
	public static InterceptorResponse typeName(@WatchedObjectValue String name, 
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName){
		if(name!=null&& typeName!= null&& Character.isUpperCase(name.charAt(0))&& typeName.equals(name)){
			return new InterceptorResponse(StringUtil.firstCharacterToLowerCase(name));
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.METHODS_GROUP_PRIORITY)
	public static Integer coreMethodsGroupsPriorities(@GenerationArgument(id= IModelingConstants.GROUP_ID_ARGUMENT) String groupId){
		if(IModelingConstants.METHOD_INCOMING_GROUP.equals(groupId)){
			return Integer.valueOf(IGenerationPointPriorityConstants.MEDIUM); 
		}else if(IModelingConstants.METHOD_OUTGOING_GROUP.equals(groupId)){
			return Integer.valueOf(IGenerationPointPriorityConstants.HIGH); 
		}else if(IModelingConstants.METHOD_OPERATIONS_GROUP.equals(groupId)){
			return Integer.valueOf(IGenerationPointPriorityConstants.LOW); 
		}else if(IModelingConstants.METHOD_PRE_DEFINED_GROUP.equals(groupId)){
			return Integer.valueOf(IGenerationPointPriorityConstants.HIGHEST); 
		}else if(IModelingConstants.METHOD_FINALIZE_GROUP.equals(groupId)){
			return Integer.valueOf(IGenerationPointPriorityConstants.LOWEST); 
		}

		return null;
	}
	
}
