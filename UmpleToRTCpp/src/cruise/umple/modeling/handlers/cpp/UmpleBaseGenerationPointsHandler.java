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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.cpp.ICppAssociationsDefinitionsConstants;
import cruise.umple.modeling.handlers.cpp.ICppDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppHandlerDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;
import cruise.umple.modeling.handlers.cpp.ICppUmpleDefinitions;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.IModelingPriorityHandler;
import cruise.umple.modeling.handlers.IUmpleModelingPriorities;
import cruise.umple.modeling.handlers.VisibilityConstants;


public class UmpleBaseGenerationPointsHandler{
	
	@GenerationPoint(generationPoint = IModelingConstants.COPY_RIGHT)
	public static String getClassComment(){
		StringBuffer buffer= new StringBuffer();
		buffer.append("//PLEASE DO NOT EDIT THIS CODE"); //$NON-NLS-1$
		buffer.append(CommonConstants.NEW_LINE);
		buffer.append("//This code was generated using the UMPLE 1.16.0.2388 modeling language"); //$NON-NLS-1$
		buffer.append(CommonConstants.NEW_LINE);
		return buffer.toString();
	}
	
	@DecisionPoint(watchIf= {IModelingDecisions.ATTRIBUTE_GENERATION_POINT,
			IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, IModelingDecisions.DELETE_GENERATION_POINT,
			IModelingDecisions.ADD_GENERATION_POINT, IModelingDecisions.SETTER_GENERATION_POINT})
	public static boolean filterAttributes(@GenerationElementParameter(id = IModelingElementDefinitions.IS_DERIVED) boolean isDerived) {
		//Disable getters for the internal attributes
		//Use GETTER_GENERATION_POINT_FILTER for extensibility
		return !isDerived;
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.GETTER_GENERATION_POINT, unique= true, ifConditionIds= {IModelingElementDefinitions.IS_DERIVED}, 
			priority= IGenerationPointPriorityConstants.HIGHEST)
	public static boolean getter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue,
			@GenerationProcedureParameter(id = IModelingConstants.GETTER_METHOD_NAME) String getterMethodName,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(defaultValue== null|| defaultValue.isEmpty()){
			return false;
		}
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put(IModelingConstants.RETURN_TYPE, normalizedType);
		map.put(IModelingConstants.PARAMETERS_STRING, CPPTypesConstants.VOID);
		
		map.put(IModelingConstants.CODY_BODY, StringUtil.indent(generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, 
				defaultValue), 1));
		
		map.put(IModelingConstants.METHOD_NAME, getterMethodName);
		map.put(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_INCOMING_GROUP);
		map.put(IModelingConstants.METHOD_OBJECT, element);
		map.put(IModelingConstants.METHOD_CONST, Boolean.FALSE);
		generationValueGetter.addValue(ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION, map, parent, VisibilityConstants.PUBLIC);
		
		
		String stream = generationValueGetter.generate(IModelingConstructorDefinitionsConstants.STREAM_CONST_GETTER, element, name, getterMethodName);
		generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_IMPLEMENTATION, stream, parent, Boolean.TRUE);
		
		String pointerDelegator = generationValueGetter.generate(ICppDefinitions.THIS_POINTER, element, generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		generationValueGetter.addUniqueValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION_BEFORE, 
				StringUtil.indent(pointerDelegator, 1), parent);
		
		return true;
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION_BEFORE, unique= true, ifConditionIds= {IModelingElementDefinitions.IS_DERIVED}, 
			priority= IGenerationPointPriorityConstants.HIGHEST)
	public static String thisPointerCopyConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element) {
		
		String implementationDetails = GenerationUtil.getImplementationDetails(generationValueGetter, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION_BEFORE, 
						element);
		if(implementationDetails.isEmpty()){
			return implementationDetails;
		}
		return implementationDetails+ CommonConstants.NEW_LINE;
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, priority= IGenerationPointPriorityConstants.HIGHEST,
			unique= true)
	public static boolean filterConstructorForSingleton(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		//Filter singelton;
		return generationValueGetter.getBoolean(parent, IModelingElementDefinitions.IS_SINGLETON);
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER)
	public static boolean filterConstructorForSingletonDecision(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		//Filter singelton;
		return generationValueGetter.getBoolean(parent, IModelingElementDefinitions.IS_SINGLETON);
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_FILTER)
	public static boolean filterCopyConstructorForSingletonDecision(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		//Filter singelton;
		return generationValueGetter.getBoolean(parent, IModelingElementDefinitions.IS_SINGLETON);
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_GENERATION_POINT, 
			priority= IGenerationPointPriorityConstants.HIGHEST, unique= true)
	public static boolean filterCopyConstructorForSingleton(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		//Filter singelton;
		return generationValueGetter.getBoolean(parent, IModelingElementDefinitions.IS_SINGLETON);
	}
	
	@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}, ifConditionIds= {IModelingElementDefinitions.IS_SINGLETON})
	public static void classAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter){
		String singelton = generationValueGetter.use(ICppUmpleDefinitions.SINGLETON_TEMPLATE_DEFINITION);
		generationValueGetter.addUniqueValue(ICppDefinitions.PREDEFINED_FUNCTIONS, singelton);
	}
	
	@GenerationPoint(generationPoint = ICppHandlerDefinitions.CLASS_DECLARATIONS_EXTENSION, ifConditionIds= {IModelingElementDefinitions.IS_SINGLETON})
	public static void signletonExtension(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument List<String> calls,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		//Filter singelton;
		calls.add(generationValueGetter.generate(ICppUmpleDefinitions.SINGLETON_CALL, parent));
	}
	
	//TODO: Still needs better job than this
	@GenerationPoint(generationPoint = ICppDefinitions.VISIBILITY_BASED_CONTENTS,  
			priority= IGenerationPointPriorityConstants.LOWEST, group= IModelingPriorityHandler.PUBLIC_DETAILS)
	public static String extraCode(@GenerationElementParameter(id = IModelingElementDefinitions.CODE) String code){
		if(code== null|| code.isEmpty()){
			return null;
		}
		return StringUtil.indent(CommonConstants.NEW_LINE+ code+ CommonConstants.NEW_LINE, 1);
	}
	
	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_IMPLEMENTATION_BEFORE)
	public static String before(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument(id= IModelingConstants.METHOD_NAME) String methodName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		List<?> list = generationValueGetter.getList(parent, IModelingElementDefinitions.CODE_INJECTION, methodName, Boolean.FALSE,
				CPPCommonConstants.CPP_LANGUAGE);
		if(list.isEmpty()){
			return null;
		}
		return GenerationUtil.listToGeneratedString(0, 1, (List<Object>) list)+ CommonConstants.NEW_LINE;
	}
	
	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_IMPLEMENTATION_AFTER)
	public static String after(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument(id= IModelingConstants.METHOD_NAME) String methodName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		List<?> list = generationValueGetter.getList(parent, IModelingElementDefinitions.CODE_INJECTION, methodName, Boolean.TRUE, 
				CPPCommonConstants.CPP_LANGUAGE);
		if(list.isEmpty()){
			return null;
		}
		return CommonConstants.NEW_LINE+ GenerationUtil.listToGeneratedString(0, 1, (List<Object>) list);
	}

	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_BEFORE)
	public static String beforeConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		List<?> list = generationValueGetter.getList(parent, IModelingElementDefinitions.CODE_INJECTION, "constructor", Boolean.FALSE,  //$NON-NLS-1$
				CPPCommonConstants.CPP_LANGUAGE);
		if(list.isEmpty()){
			return null;
		}
		return GenerationUtil.listToGeneratedString(0, 1, (List<Object>) list)+ CommonConstants.NEW_LINE;
	}
	
	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_AFTER)
	public static String afterConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		List<?> list = generationValueGetter.getList(parent, IModelingElementDefinitions.CODE_INJECTION, "constructor", Boolean.TRUE,  //$NON-NLS-1$
				CPPCommonConstants.CPP_LANGUAGE);
		if(list.isEmpty()){
			return null;
		}
		return CommonConstants.NEW_LINE+ GenerationUtil.listToGeneratedString(0, 1, (List<Object>) list);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_DECLARATIONS, group= IUmpleModelingPriorities.AUTOUNIQUE_ATTRIBUTES)
	public static String publicHelperAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppUmpleDefinitions.AUTOUNIQUE_ATTRIBUTE_DECLARATIONS, VisibilityConstants.PRIVATE);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IUmpleModelingPriorities.RESET)
	public static void removeAtDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppUmpleDefinitions.RESET_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IUmpleModelingPriorities.DEFAULT_GETTER)
	public static void defaultGetter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppUmpleDefinitions.DEFAULT_GETTER_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_IMPLEMENTATION_BEFORE)
	public static String before(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationArgument(id= IModelingConstants.METHOD_ID) String methodId,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_IMMUTABLE) boolean isImmutable,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy) {
		if(!ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION.equals(methodId)){
			return null;
		}
		if(isLazy&& isImmutable|| generationValueGetter.getBoolean(parent, IModelingElementDefinitions.IS_IMMUTABLE)){
			String canSet = generationValueGetter.use(ICppNameConstants.CAN_SET, name);
			
			String attributeDeclaration = generationValueGetter.generate(ICppDefinitions.DECLARE_STATEMENET, element,
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_NAME_ARGUMENT, canSet),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_TYPE_ARGUMENT, CPPTypesConstants.BOOL),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT, new ArrayList<Object>()),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT, Boolean.TRUE));
			generationValueGetter.addValue(ICppDefinitions.HELPER_ATTRIBUTES_DECLARATION, attributeDeclaration, VisibilityConstants.PRIVATE, parent);
			
			//Must be able to track the given visibility values
			generationValueGetter.addUniqueValue(VisibilityConstants.VISIBILITY_TRACKER, VisibilityConstants.PRIVATE, parent);
			
			//Assign constructor value
			String thisCanSet = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, canSet, Boolean.TRUE);
			String constructorCall= generationValueGetter.use(ICppDefinitions.ASSIGN_STATEMENET, thisCanSet, Boolean.TRUE.toString());
			generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, constructorCall, parent, Boolean.TRUE);
			
			//And, then update the setter method to have the lazy check code segment
			return StringUtil.indent(generationValueGetter.use(ICppAssociationsDefinitionsConstants.SETTER_CAN_SET_CHECK, canSet), 1);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_BODY)
	public static String constructorDefaulted(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue,
			@GenerationProcedureParameter(id = ICppUmpleDefinitions.RESET_NAME) String resetCall,
			@GenerationProcedureParameter(id = ICppUmpleDefinitions.DEFAULT_NAME) String defaultGetterMethod,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_DEFAULTED) boolean isDefaulted,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(isDefaulted){
			//Default getter extra method for the defaulted attributes
			String returnStatement= generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, defaultValue);
			returnStatement= StringUtil.indent(returnStatement, 1);
			addMethodDetails(generationValueGetter, ICppUmpleDefinitions.DEFAULT_GETTER_IMPLEMENTATION, 
					normalizedType, CPPTypesConstants.VOID, returnStatement, parent, element, defaultGetterMethod, VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP);
			
			//Reset extra method for the defaulted attributes
			String resetImplementationBody = generationValueGetter.use(ICppUmpleDefinitions.RESET_IMPLEMENTATION, name, defaultGetterMethod);
			addMethodDetails(generationValueGetter, ICppUmpleDefinitions.RESET_IMPLEMENTATION, 
					CPPTypesConstants.BOOL, CPPTypesConstants.VOID, resetImplementationBody, parent, element, resetCall, VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP);
			
			
			return generationValueGetter.use(ICppDefinitions.METHOD_INVOCATION, resetCall, CommonConstants.BLANK, Boolean.TRUE);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_BODY)
	public static String constructorAutoUnique(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_AUTO_UNIQUE) boolean isAutoUnique) {
		
		if(isAutoUnique){
			String nextName= generationValueGetter.use(ICppUmpleDefinitions.NEXT_NAME, name);
			String nextNameThis = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, nextName, Boolean.TRUE);
			String nameThis = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, name, Boolean.TRUE);
			String increment= generationValueGetter.use(ICppDefinitions.INCREMENT, nextNameThis);
			return generationValueGetter.use(ICppDefinitions.ASSIGN_STATEMENET, nameThis, increment);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ATTRIBUTE_GENERATION_POINT, unique= true)
	public static String autoUniqueAttributeDeclaration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_VISIBILITY) String normalizedVisibility,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_AUTO_UNIQUE) boolean isAutoUnique,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT) List<String> prefixes,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT) String attributeValue,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(isAutoUnique){
			String attributeDeclaration = generationValueGetter.generate(ICppDefinitions.DECLARE_STATEMENET, element,
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_NAME_ARGUMENT, name),
					GenerationUtil.safeSpcae(prefixes),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_TYPE_ARGUMENT, typeName),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT, prefixes),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT, attributeValue));
			generationValueGetter.addValue(ICppUmpleDefinitions.AUTOUNIQUE_ATTRIBUTE_DECLARATIONS, attributeDeclaration, normalizedVisibility, parent);
			
			//Add the helper private static helper for the autounique
			String nextName= generationValueGetter.use(ICppUmpleDefinitions.NEXT_NAME, name);
			String autouniqueHelperStaticDeclaration = generationValueGetter.generate(ICppDefinitions.DECLARE_STATEMENET,element, 
					CPPCommonConstants.STATIC_MODIFIER,
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT, Arrays.asList(new String[]{CPPCommonConstants.STATIC_MODIFIER})),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_TYPE_ARGUMENT, typeName),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_NAME_ARGUMENT, nextName),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT, String.valueOf(1)));
			generationValueGetter.addValue(ICppDefinitions.STATIC_ATTRIBUTE_DECLARATIONS, autouniqueHelperStaticDeclaration, normalizedVisibility, parent);
			
			return ICppUmpleDefinitions.AUTOUNIQUE_ATTRIBUTE_DECLARATIONS;
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.ATTRIBUTES_GROUP_PRIORITY)
	public static Integer staticGroupPriority(@GenerationArgument(id= IModelingConstants.GROUP_ID_ARGUMENT) String groupId){
		if(ICppUmpleDefinitions.AUTOUNIQUE_ATTRIBUTE_DECLARATIONS.equals(groupId)){
			return Integer.valueOf(IGenerationPointPriorityConstants.LOW); 
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ATTRIBUTE_EQUALITY_GENERATION_POINT, unique= true, priority= IGenerationPointPriorityConstants.HIGH)
	public static boolean umpleKeyAttributeEquality(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		boolean hasKey = generationValueGetter.getBoolean(parent, IModelingElementDefinitions.HAS_KEY_MEMBERS, element);
		if(!hasKey){
			return false;
		}
		
		boolean isKeyMemeber = generationValueGetter.getBoolean(parent,IModelingElementDefinitions.IS_KEY_MEMBER, element);
		if(!isKeyMemeber){
			//Do not add the members to the equality implementation; however, also prevent it from being added to the default implementation as we need to only rely on
			//the key members in case there are
			return true;
		}
		
		String equalityDeclaration = generationValueGetter.generationPointString(element, ICppDefinitions.ATTRIBUTE_EQUALITY);
		generationValueGetter.addValue(ICppDefinitions.ATTRIBUTE_EQUALITY_DECLARATION, equalityDeclaration, parent);
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION_CONDITION)
	public static String setterImplementation(
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument(id= ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION_ARGUMENT) String contents) {
		List<?> constraints= generationValueGetter.getList(parent, IModelingElementDefinitions.CONSTRAINTS, element);
		if(constraints.isEmpty()){
			return null;
		}
		
		String all= CommonConstants.BLANK;
		Iterator<?> iterator = constraints.iterator();
		while(iterator.hasNext()){
			if(iterator.hasNext()){
				if(!all.isEmpty()){
					all= all+ CommonConstants.SPACE+ CPPCommonConstants.AND;
				}
				
				Object next = iterator.next();
				List<Object> list = (List<Object>) next;
				String condition= CommonConstants.BLANK;
				for(Object obj: list){
					if(!condition.isEmpty()){
						condition= condition+ CommonConstants.SPACE;
					}
					condition= condition+ obj;
				}
				all= all+ condition;
			}
		}
		
		return StringUtil.indent(generationValueGetter.use(ICppDefinitions.IF_CONDITION_BLOCK, all, CommonConstants.NEW_LINE+ contents), 1);
	}
	
	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_CONDITION)
	public static String constructor(
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument(id= IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_ARGUMENT) String contents) {
		List<?> constraints= generationValueGetter.getList(parent, IModelingElementDefinitions.CONSTRAINTS, element);
		
		if(constraints.isEmpty()){
			return null;
		}
		
		String all= CommonConstants.BLANK;
		Iterator<?> iterator = constraints.iterator();
		while(iterator.hasNext()){
			if(iterator.hasNext()){
				if(!all.isEmpty()){
					all= all+ CommonConstants.SPACE+ CPPCommonConstants.AND;
				}
				
				Object next = iterator.next();
				List<Object> list = (List<Object>) next;
				String condition= CommonConstants.BLANK;
				for(Object obj: list){
					if(!condition.isEmpty()){
						condition= condition+ CommonConstants.SPACE;
					}
					condition= condition+ obj;
				}
				all= all+ condition;
			}
		}
		
		String throwStatement = generationValueGetter.use(ICppDefinitions.THROW_STATEMENET, generationValueGetter.use(ICppUmpleDefinitions.CONSTRAINT_MESSAGE, name));
		String constraintCondition = generationValueGetter.use(ICppDefinitions.IF_CONDITION_BLOCK, all, StringUtil.indent(CommonConstants.NEW_LINE+ throwStatement, 1));
		return constraintCondition+ CommonConstants.NEW_LINE+ contents;
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.SETTER_GENERATION_POINT, unique= true, priority= IGenerationPointPriorityConstants.HIGH)
	public static boolean setterFilters(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		//Prevent key members from being set
		return generationValueGetter.getBoolean(parent,IModelingElementDefinitions.IS_KEY_MEMBER, element);
		
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IGNORE_INITILIAZATION_DECISION_POINT)
	public static boolean isDefaultedIgnore(@GenerationElementParameter(id = IModelingElementDefinitions.IS_DEFAULTED) boolean isDefaulted){
		//Disable initliazation for defaulted attributes, and rely on the generation body for it
		return isDefaulted;
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IGNORE_INITILIAZATION_DECISION_POINT)
	public static boolean isAutoUniqueIgnore(@GenerationElementParameter(id = IModelingElementDefinitions.IS_AUTO_UNIQUE) boolean isAutoUnique){
		//Disable initliazation for auto unique attributes, and rely on the generation body for it
		return isAutoUnique;
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT)
	public static boolean filterAttributeParameter(@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_AUTO_UNIQUE) boolean isAutoUnique) {
		//Lazy/constant/Static/Auto Unique attributes are not meant to be passed in the constructor
		return isLazy|| isAutoUnique;
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT)
	public static boolean filterSotedAttribute(@GenerationElementParameter(id = IModelingElementDefinitions.IS_SORTED) boolean isSorted) {
		//Sorted items are not meant to be passed in the constructor
		return isSorted;
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_BODY_DECISION_POINT)
	public static boolean filterAttributeBody(@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_AUTO_UNIQUE) boolean isAutoUnique) {
		//Immutable attributes cannot be set in the constructor, and shall be only be the setter
		//AutoUnique attributes does not have default constructor setter way
		return isLazy|| isAutoUnique;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.SETTER_GENERATION_POINT_FILTER)
	public static boolean filterLazyImmutableAttributeSetter(@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_IMMUTABLE) boolean isImmutable) {
		//Immutable attributes cannot be set in the constructor, and shall be only be the setter
		return !isLazy&&isImmutable;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.SETTER_GENERATION_POINT_FILTER)
	public static boolean filterStaticConstantAttributeSetter(@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic) {
		//Constant or static attributes cannot have setters
		return isConstant|| isStatic;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.SETTER_GENERATION_POINT_FILTER)
	public static boolean filterAutoUniqueAttributeSetter(@GenerationElementParameter(id = IModelingElementDefinitions.IS_AUTO_UNIQUE) boolean isAutoUnique) {
		//Auto unique attribute must not be altered externally
		return isAutoUnique;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.SETTER_GENERATION_POINT_FILTER)
	public static boolean filterInternalAttributeSetter(@GenerationElementParameter(id = IModelingElementDefinitions.IS_INTERNAL) boolean isInternal) {
		return isInternal;
	}
	
	@GenerationPoint(generationPoint = ICppUmpleDefinitions.RESET_NAME)
	public static String setterMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		String normalizedRoleName= generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_ROLE_NAME, Boolean.TRUE);
		return generationValueGetter.use(ICppUmpleDefinitions.RESET_NAME, normalizedRoleName);
	}
	
	@GenerationPoint(generationPoint = ICppUmpleDefinitions.DEFAULT_NAME)
	public static String defaultGetterMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		String normalizedRoleName= generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_ROLE_NAME, Boolean.TRUE);
		return generationValueGetter.use(ICppUmpleDefinitions.DEFAULT_NAME, normalizedRoleName);
	}
	
	private static void addMethodDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, String id, String returnType, String parametersString,
			String codeBody, Object parent, Object element, String name, String visibility, String groupId){
		Map<String, Object> map= new HashMap<String, Object>();
		map.put(IModelingConstants.RETURN_TYPE, returnType);
		map.put(IModelingConstants.PARAMETERS_STRING, parametersString);
		map.put(IModelingConstants.CODY_BODY, codeBody);
		map.put(IModelingConstants.METHOD_NAME, name);
		map.put(IModelingConstants.METHOD_GROUP, groupId);
		map.put(IModelingConstants.METHOD_OBJECT, element);
		generationValueGetter.addValue(id, map, parent, visibility);
	}
	
	private static String getAttributesDeclaraionDetails(GenerationPolicyRegistry generationValueGetter, Object element,String id, String visibility) {
		List<Object> values = generationValueGetter.getValues(id, visibility, element);
		
		String contents= CommonConstants.BLANK;
		for(Object entry: values){
			contents = contents+ entry+ CommonConstants.NEW_LINE;
		}
		
		if(!contents.isEmpty()){
			String comments = generationValueGetter.use(id+ ICppDefinitions.COMMENTS_SUFFIX);
			if(!comments.isEmpty()){
				contents= comments+ CommonConstants.NEW_LINE+ contents;
			}
			contents= contents+ CommonConstants.NEW_LINE;
		}
		
		return contents;
	}
}