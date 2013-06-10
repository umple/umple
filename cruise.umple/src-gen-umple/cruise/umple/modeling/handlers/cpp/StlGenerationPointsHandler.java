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
package cruise.umple.modeling.handlers.cpp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationCallback.GenerationArguments;
import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationCallback.WatchedObjectValue;
import cruise.umple.core.GenerationPoint.InterceptorResponse;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.CommonTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.VisibilityConstants;

public class StlGenerationPointsHandler{
	
	@DecisionPoint(decisionPoint = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE)
	public static boolean isPrimitiveType(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object type){
		
		List<String> list = Arrays.asList(new String[]{ISTLConstants.STRING, ISTLConstants.TIME, ISTLConstants.DATE});
		if((type!= null&& list.contains(type))|| list.contains(typeName)){
			return true;
		}
		return false;
	}
	
	@DecisionPoint(decisionPoint = ICppDefinitions.IS_CONST_TYPE_PARAMETER)
	public static boolean isConstParameter(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object type){
		List<String> list = Arrays.asList(new String[]{ISTLConstants.STRING});
		if((type!= null&& list.contains(type))|| list.contains(typeName)){
			return true;
		}
		return false;
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_DEFAULT_ASSIGN)
	public static boolean avoidStringNullify(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue){
		return ISTLConstants.STRING.equals(typeName)&& (defaultValue== null|| defaultValue.isEmpty());
	}
	
	@DecisionPoint(decisionPoint = ICppDefinitions.IS_POINTER_TYPE, optimistic= true)
	public static boolean enableDateTimePointer(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName){
		return Arrays.asList(new String[]{ISTLConstants.TIME, ISTLConstants.DATE}).contains(typeName);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ATTRIBUTE_EQUALITY, priority=IGenerationPointPriorityConstants.HIGH,  unique= true)
	public static String attributeEquality(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		
		if(!ISTLConstants.STRING.equals(typeName)|| isMany){
			return null;
		}
		
		return generationValueGetter.use(ICppDefinitions.STRING_ATTRIBUTE_EQUALITY,name);
	}
	
	@DecisionPoint(decisionPoint = ICppDefinitions.ATTRIBUTE_DISABLE_DELETE)
	public static boolean disableDelete(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type) {
		return ISTLConstants.STRING.equals(type);
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_GENERATION_POINT, priority= IGenerationPointPriorityConstants.HIGHEST,  
			unique= true)
	public static String copyConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		if(!ISTLConstants.STRING.equals(typeName)){
			return null;
		}
		
		//Now, we are using STD library
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING), 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		return generationValueGetter.use(ICppDefinitions.COPY_STRING_ATTRIBUTE, name);
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_GENERATION_POINT, priority= IGenerationPointPriorityConstants.HIGHEST,  
			unique= true)
	public static void dataTimeConditionsCopyConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName){
		if(!Arrays.asList(new String[] {ISTLConstants.TIME, ISTLConstants.DATE}).contains(typeName)){
			return;
		}
		
		//Now, we are using STD library
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.C_TIME), 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.C_TIME), 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.DEFAULT_LANGUAGE_TYPE_VALUE, priority=IGenerationPointPriorityConstants.HIGHEST, unique= true)
	public static String defaultCPPParameterValue(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_DEFAULT_VALUE) String defaultValue,
			@GenerationLoopElement Object modelPackage,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName){
		
		if(ISTLConstants.DATE.equals(typeName)|| ISTLConstants.TIME.equals(typeName)){
			if(defaultValue!= null&& !defaultValue.isEmpty()){
				
				//Add time code helper
				generationValueGetter.addUniqueValue(ICppDefinitions.HELPER_CODES, generationValueGetter.use(ICppDefinitions.TIME_HELPER_CODE), modelPackage);
				
				generationValueGetter.generationPointString(modelPackage, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
						GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.TIME_INCLUDE), 
						GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
				
				generationValueGetter.generationPointString(modelPackage, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
						GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.C_TYPE), 
						GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
				
				return defaultValue;
			}
			return generationValueGetter.use(ISTLConstants.DATE.equals(typeName)?ISTLConstants.DEFAULT_DATE_ASSIGN: ISTLConstants.DEFAULT_TIME_ASSIGN);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, unique= true)
	public static boolean filterClassInlineDeclarationForDateTime(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type) {
		
		if(Arrays.asList(new String[] {ISTLConstants.TIME, ISTLConstants.DATE}).contains(type)){
			return true;
		}
		
		return false;
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.DEFAULT_LANGUAGE_TYPE_VALUE, unique= true)
	public static String defaultVectorValue(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_DEFAULT_VALUE) String defaultValue){
		if(defaultValue== null|| defaultValue.isEmpty()){
			if(isMany){
				return generationValueGetter.generate(ISTLConstants.NEW_LIST_DEFINITION, element);
			}
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT)
	public static void constructorAutoUnique(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		if(isLazy&& ISTLConstants.TIME.equals(typeName)){
			generationValueGetter.addUniqueValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PRE_IMPLEMENTATION, 
					generationValueGetter.use(ISTLConstants.CURRENT_TIME_REFERENCE), parent);
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ATTRIBUTE_GENERATION_POINT, priority= IGenerationPointPriorityConstants.HIGH)
	public static void basicAttributeDeclaration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(!ISTLConstants.STRING.equals(typeName)){
			return;
		}
		
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING),
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING),
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
	}
	
	
	@GenerationPoint(intercept = {IModelingElementDefinitions.RETURN_TYPE})
	public static InterceptorResponse returnTypeName(@WatchedObjectValue String typeName){
		if(typeName== null){
			return new InterceptorResponse(CPPTypesConstants.VOID);
		}
		return typeName(typeName);
	}
	
	@GenerationPoint(intercept = {IModelingElementDefinitions.DEFAULT_VALUE})
	public static InterceptorResponse normalizedDateDefaultValue(@WatchedObjectValue String defaultValue,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter){
		if(defaultValue== null|| defaultValue.isEmpty()){
			return null;
		}
		
		if(ISTLConstants.DATE.equals(typeName)){
			return new InterceptorResponse(generationValueGetter.use(ISTLConstants.DATE_ASSIGN, defaultValue));
		}else if(ISTLConstants.TIME.equals(typeName)){
			return new InterceptorResponse(generationValueGetter.use(ISTLConstants.TIME_ASSIGN, defaultValue));
		}
		
		return null;
	}
	
//	@GenerationPoint(intercept = {ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT})
//	public static InterceptorResponse vector(@WatchedObjectValue String include){
//		if(ISTLConstants.VECTOR.equals(include)){
//			return new InterceptorResponse(ISTLConstants.SET);
//		}
//		
//		return null;
//	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ADD_AT_FILTER_DECISION)
	public static boolean filterAddAt(@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName){
		//If many type is "Set", then disable add at method. IT does not make any sense since the set is sortable, and also will yield an error with the STL Set API
		return ISTLConstants.SET.equals(manyTypeName);
	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.MANY_TYPE_NAME, priority= IGenerationPointPriorityConstants.HIGHEST, unique= true)
	public static String manyTypeName(@GenerationElementParameter(id = IModelingElementDefinitions.PRIORITY) String key){
		if(key!= null&& !key.isEmpty()){
			return ISTLConstants.SET;
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.MANY_TYPE_NAME)
	public static String manyTypeName(){
		return ISTLConstants.VECTOR;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.REMOVE_ALL_INVOCATION, priority= IGenerationPointPriorityConstants.HIGHEST,  
			unique= true)
	public static String removeAllSetCall(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName,
			@GenerationArguments Object... arguments){
		if(ISTLConstants.SET.equals(manyTypeName)){
			return generationValueGetter.generate(ISTLConstants.REMOVE_ALL_SET_ELEMENTS, element, arguments);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.REMOVE_ALL_INVOCATION)
	public static String removeAllCall(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,@GenerationBaseElement Object element,
			@GenerationArguments Object... arguments) {
		return generationValueGetter.generate(ISTLConstants.REMOVE_ALL_VECTOR_ELEMENTS, element, arguments);
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.REMOVE_AT_FILTER_DECISION)
	public static boolean filterRemoveAt(){
		//For extensibility
		return false;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.REMOVE_INVOCATION, priority= IGenerationPointPriorityConstants.HIGHEST,  
			unique= true)
	public static String removeSetCall(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName,
			@GenerationBaseElement Object element,@GenerationArguments Object... arguments){
		if(ISTLConstants.SET.equals(manyTypeName)){
			return generationValueGetter.generate(ISTLConstants.REMOVE_SET_ELEMENT, element, arguments);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.REMOVE_INVOCATION)
	public static String removeCall(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,@GenerationArguments Object... arguments){
		return generationValueGetter.generate(ISTLConstants.REMOVE_VECTOR_ELEMENT, element, arguments);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.COPY_INVOCATION, priority= IGenerationPointPriorityConstants.HIGHEST,  
			unique= true)
	public static String copySetCall(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName,
			@GenerationBaseElement Object element,@GenerationArguments Object... arguments){
		if(ISTLConstants.SET.equals(manyTypeName)){
			return generationValueGetter.generate(ISTLConstants.COPY_SET_ELEMENT, element, arguments);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.COPY_INVOCATION)
	public static String copyCall(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,@GenerationArguments Object... arguments){
		return generationValueGetter.generate(ISTLConstants.COPY_VECTOR_ELEMENT, element, arguments);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ADD_INVOCATION, priority = IGenerationPointPriorityConstants.HIGHEST, unique = true)
	public static String addSetCall(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName,
			@GenerationArguments Object... arguments) {
		if(ISTLConstants.SET.equals(manyTypeName)){
			return generationValueGetter.generate(ISTLConstants.ADD_SET_ELEMENT, element, arguments);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ADD_INVOCATION)
	public static String addCall(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,@GenerationArguments Object... arguments){
		return generationValueGetter.generate(ISTLConstants.ADD_VECTOR_ELEMENT, element, arguments);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.GETTER_BY_INDEX_INVOCATION, priority= IGenerationPointPriorityConstants.HIGHEST,  
			unique= true)
	public static String setGetterByIndex(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationElementParameter(id = IModelingElementDefinitions.PRIORITY) String key,
			@GenerationLoopElement Object modelPackage,
			@GenerationBaseElement Object element,
			@GenerationArguments Object... arguments){
		//return generationValueGetter.generate(ISTLConstants.GET_VECTOR_ELEMENT, element, arguments);
		String setTemplateGetByIndex = generationValueGetter.use(ISTLConstants.GET_SET_ELEMENT_TEMPLATE_IMPLEMENTATION);
		generationValueGetter.addUniqueValue(ISTLConstants.GET_SET_ELEMENT_TEMPLATE_IMPLEMENTATION, setTemplateGetByIndex);
		
		String setTemplateCopy = generationValueGetter.use(ISTLConstants.COPY_SET_ELEMENT_TEMPLATE_IMPLEMENTATION);
		generationValueGetter.addUniqueValue(ISTLConstants.COPY_SET_ELEMENT_TEMPLATE_IMPLEMENTATION, setTemplateCopy);
		
		
		generationValueGetter.generationPointString(modelPackage, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.SET), 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		
		if(key!= null&& !key.isEmpty()){
			List<Object> types = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName);
			if(!types.isEmpty()){
				Object typeObject = types.get(0);
				List<Object> values = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION, key, typeObject, 
						VisibilityConstants.PUBLIC);
				if(!values.isEmpty()){
					String typeObjectName= generationValueGetter.getString(typeObject, IModelingElementDefinitions.NAME);
					String defaultName = generationValueGetter.use(ICppDefinitions.BASE_COMPARATOR_DEFAULT_NAME, typeObjectName, key);
					
					Object object = values.get(0);
					String fieldGetter= null;
					fieldGetter: {
						if(object instanceof HashMap){
							HashMap<?, ?> map= (HashMap<?, ?>) object;
							Object methodName = map.get(IModelingConstants.METHOD_NAME);
							if(methodName instanceof String){
								fieldGetter= (String) methodName;
								fieldGetter= generationValueGetter.use(ICppDefinitions.METHOD_INVOCATION, fieldGetter);
								break fieldGetter;
							}
						}
					}
							
					String baseComparator = generationValueGetter.generate(ICppDefinitions.BASE_COMPARATOR, element, defaultName, typeName, fieldGetter);
					generationValueGetter.addUniqueValue(ICppDefinitions.BASE_COMPARATOR, baseComparator, typeObject);
				}
				return generationValueGetter.generate(ISTLConstants.GET_SET_ELEMENT, element, arguments);
			}
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.GETTER_BY_INDEX_INVOCATION)
	public static String getterByIndex(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,@GenerationArguments Object... arguments){
		return generationValueGetter.generate(ISTLConstants.GET_VECTOR_ELEMENT, element, arguments);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_TYPE_NAME, priority= IGenerationPointPriorityConstants.HIGH, unique= true)
	public static String typeName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.PRIORITY) String key,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationBaseElement Object element,
			@GenerationLoopElement Object modelPackage,
			@GenerationArgument(id = IModelingConstants.NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT) boolean isConstruction,
			@GenerationArgument boolean asType){
		
		if(key== null|| key.isEmpty()|| !isMany|| asType){
			return null;
		}
		
		List<Object> types = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName);
		if(!types.isEmpty()){
			Object typeObject = types.get(0);
			List<Object> values = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION, key, typeObject, 
					VisibilityConstants.PUBLIC);
			if(!values.isEmpty()){
				String typeObjectName= generationValueGetter.getString(typeObject, IModelingElementDefinitions.NAME);
				String comparatorName= generationValueGetter.use(ICppDefinitions.BASE_COMPARATOR_DEFAULT_NAME, typeObjectName, key);
				
				String inlineClassDelcaration = generationValueGetter.use(ICppDefinitions.STRUCT_INCOMPLETE_DECLARATION, comparatorName);
				SimpleEntry<String, String> incompleteDeclaration= new SimpleEntry<String, String>(typeName, inlineClassDelcaration);
				generationValueGetter.addUniqueValue(ICppDefinitions.INCOMPLETE_DECLARATIONS, incompleteDeclaration, parent);
				return generationValueGetter.generate(ISTLConstants.TYPE_AS_SET, element, Boolean.valueOf(!isConstruction),
					   GenerationArgumentDescriptor.arg(ISTLConstants.TYPE_AS_SET_COMPARATOR_ARGUMENT, comparatorName));
			}
		}
		return null;
		
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.FUNCTION_OPERATORS, priority= IGenerationPointPriorityConstants.LOW)
	public static String enumsImplementation(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		String implementationAndSeparateDetails = GenerationUtil.getImplementationAndSeparateDetails(generationValueGetter,ICppDefinitions.BASE_COMPARATOR, 1, element);
		if(implementationAndSeparateDetails.isEmpty()){
			return implementationAndSeparateDetails;
		}
		
		return CommonConstants.NEW_LINE+ generationValueGetter.use(ICppDefinitions.COMPARATORS_DETAILS, implementationAndSeparateDetails)+ CommonConstants.NEW_LINE;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PREDEFINED_PACKAGE_CONTENTS)
	public static String getSetTemplateImplementation(@GenerationRegistry GenerationPolicyRegistry generationValueGetter){
		return GenerationUtil.getImplementationDetails(generationValueGetter, ISTLConstants.GET_SET_ELEMENT_TEMPLATE_IMPLEMENTATION);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PREDEFINED_PACKAGE_CONTENTS)
	public static String copySetTemplate(@GenerationRegistry GenerationPolicyRegistry generationValueGetter){
		return GenerationUtil.getImplementationDetails(generationValueGetter, ISTLConstants.COPY_SET_ELEMENT_TEMPLATE_IMPLEMENTATION);
	}
	
	@GenerationPoint(intercept = IModelingElementDefinitions.TYPE_NAME)
	public static InterceptorResponse typeName(@WatchedObjectValue String typeName){
		if(CommonTypesConstants.TIME.equals(typeName)){
			return new InterceptorResponse(ISTLConstants.TIME);
		}else if(CommonTypesConstants.DATE.equals(typeName)){
			return new InterceptorResponse(ISTLConstants.DATE);
		}else if(CommonTypesConstants.STRING.equals(typeName)){
			return new InterceptorResponse(ISTLConstants.STRING);
		}
		return null;
	}
	
}