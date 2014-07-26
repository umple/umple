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

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationArguments;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationCallback.GenerationStringSegment;
import cruise.umple.core.GenerationLoopAnnotation.GenerationLoopAnnotationFilter;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationPolicyRegistryPriorities;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.OperatorConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.IModelingPriorityHandler;
import cruise.umple.modeling.handlers.IStructureConstants;
import cruise.umple.modeling.handlers.IUmpleModelingPriorities;
import cruise.umple.modeling.handlers.VisibilityConstants;


public class UmpleBaseGenerationPointsHandler{
	
	private static final String NAME = "NAME"; //$NON-NLS-1$

	@GenerationPoint(generationPoint = IModelingConstants.COPY_RIGHT)
	public static String getClassComment(@GenerationElementParameter(id = IModelingElementDefinitions.VERSION_NUMBER) String version){
		StringBuffer buffer= new StringBuffer();
		buffer.append("//PLEASE DO NOT EDIT THIS CODE"); //$NON-NLS-1$
		buffer.append(CommonConstants.NEW_LINE);
		buffer.append("//This code was generated using the UMPLE "+version +" modeling language"); //$NON-NLS-1$ //$NON-NLS-2$
		buffer.append(CommonConstants.NEW_LINE);
		return buffer.toString();
	}
	
	//////////////////////////////////TODO Must be moved to other specific handler////////////////////////////////////////////////////////////////////////////////////////////////
	private static final String MAIN_EXTRACTOR_REGULAR_EXPRESSION = ".*(static)[ |\\t]+(void)[ |\\t]+(main)[ |\\t]*[(][ |\\t]*(int)[ |\\t]+[a-z|A-Z|0-9|_]+(,)[ |\\t]*(char)[ |\\t]*(\\*).*"; //$NON-NLS-1$
	
	@LoopProcessorAnnotation(aspect= LoopAspectConstants.TERMINATE, priority= GenerationPolicyRegistryPriorities.HIEGHEST, aspectGroup= 400)
	public static void modelPathsAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object model){
		
		Map<Object, String> mainMap= new HashMap<Object, String>();
		for(Object umpleClass: generationValueGetter.getList(model, IModelingElementDefinitions.CLASSES)){
			String regularExpression= MAIN_EXTRACTOR_REGULAR_EXPRESSION;
			String generate = generationValueGetter.generationPointString(umpleClass, "extractMain", regularExpression); //$NON-NLS-1$
			if(generate!= null&& !generate.isEmpty()){
				mainMap.put(umpleClass, generate);
			}
		}
		
		
		if(!mainMap.isEmpty()){
			String mainCalls= CommonConstants.BLANK;
			for(Object umpleClass: mainMap.keySet()){
				String string = generationValueGetter.getString(umpleClass, IModelingElementDefinitions.NAMESPACE);
				string = normalizeNamespace(string);
				mainCalls= mainCalls+ generationValueGetter.generate(ICppDefinitions.MAIN_METHOD_CALL, umpleClass, string);
				
			}
			generationValueGetter.addUniqueValue(ICppDefinitions.MAIN_CONTENTS, mainCalls);
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.POST)
	public static void searchAndRegisterExtraMains(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		String generate = generationValueGetter.generationPointString(element, "extractMain", MAIN_EXTRACTOR_REGULAR_EXPRESSION); //$NON-NLS-1$
		if(generate!= null&& !generate.isEmpty()){
			generationValueGetter.generationPointString(element, IModelingConstants.METHOD_REGISTER,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, "int argc, char *argv[]"), //$NON-NLS-1$
					GenerationArgumentDescriptor.arg(IModelingConstants.CODY_BODY, generate),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, "main"), //$NON-NLS-1$
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_COMMENT, CommonConstants.BLANK),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, IModelingConstants.OPERATIONS_IMPLEMENTATION),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_IDENTIFIER, "main"), //$NON-NLS-1$
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_OPERATIONS_GROUP),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_OBJECT, element),
					GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_VIRTUAL, Boolean.FALSE),
					GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_PURE, Boolean.FALSE),
					GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_STATIC, Boolean.TRUE),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_DEFAULTED_IMPLEMENTATION, Boolean.FALSE));
		}
	}
	
	private static String normalizeNamespace(String object) {
		return object.replace(CommonConstants.UNDERSCORE, CPPCommonConstants.DECLARATION_COMMON_PREFIX).
				replace(CommonConstants.DOT, CPPCommonConstants.DECLARATION_COMMON_PREFIX);
	}
	
	@GenerationPoint(generationPoint = "extractMain")
	public static String extractMain(@GenerationArgument String regularExpression, @GenerationElementParameter(id = IModelingElementDefinitions.CODE) String code){
		StringBuilder sb = new StringBuilder();
		final Pattern openBrace = Pattern.compile("\\{"); //$NON-NLS-1$
		final Pattern closeBrace = Pattern.compile("\\}"); //$NON-NLS-1$
		int brkCnt = 0;
		boolean mainClass = false;
		String processingString = code.replace("{", "{\n"); //$NON-NLS-1$ //$NON-NLS-2$
		processingString= processingString.replace("}", "}\n"); //$NON-NLS-1$ //$NON-NLS-2$
		for(String line:processingString.split("\n")){ //$NON-NLS-1$
	        if(mainClass) {
	        	for(Matcher mtch=openBrace.matcher(line);mtch.find();brkCnt++);
	        	for(Matcher mtch=closeBrace.matcher(line);mtch.find();brkCnt--);
	        	if(brkCnt <= 0 )  {mainClass = false;} else {
	        	sb.append(line);
	        	sb.append("\n"); //$NON-NLS-1$
	        	}
	        }
	        if(line.matches(regularExpression))
	        {
	        	mainClass = true;
	        	brkCnt++;
	        }
		}
		String string = sb.toString();
		if(string.isEmpty()){
			return null;
		}
		
		String trim = string.trim();
		if(trim.startsWith("{")){ //$NON-NLS-1$
			trim= trim.substring(1);
		}
		
		if(trim.endsWith("}")){ //$NON-NLS-1$
			trim= trim.substring(0, trim.length()-2);
		}
		
		return trim.trim();
	}
	
	//TODO: Still needs better job than this
	@GenerationPoint(generationPoint = ICppDefinitions.VISIBILITY_BASED_CONTENTS,  
			priority= IGenerationPointPriorityConstants.LOWEST, group= IModelingPriorityHandler.PUBLIC_DETAILS)
	public static String extraCode(@GenerationElementParameter(id = IModelingElementDefinitions.CODE) String code){
		if(code== null|| code.isEmpty()|| extractMain(MAIN_EXTRACTOR_REGULAR_EXPRESSION, code)!= null){
			return null;
		}
		
		return StringUtil.indent(CommonConstants.NEW_LINE+ code+ CommonConstants.NEW_LINE, 1);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GenerationPoint(generationPoint = IModelingConstants.MULTILINE_COMMENTS_STRING, priority= IGenerationPointPriorityConstants.LOWEST)
	public static String lineNumbers(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationStringSegment String currentString,
			@GenerationBaseElement Object element){
		List<Object> values = generationValueGetter.getValues(IModelingConstants.GENERATION_LANGUAGE);
		if(values.isEmpty()){
			return null;
		}
		Object language = values.get(0);
		List<?> lineNumbers= generationValueGetter.getList(element, IModelingElementDefinitions.LINE_NUMBERS, language);
		if(lineNumbers.isEmpty()){
			return null;
		}
		List<String> comments= new ArrayList<String>();
		
		for(Object object: lineNumbers){
			if(object instanceof String == false){
				continue;
			}
			comments.add((String) object);
		}
		String listToGeneratedString = GenerationUtil.listToGeneratedString(0, 0, comments);
		if(currentString!= null&& !currentString.isEmpty()){
			listToGeneratedString= CommonConstants.NEW_LINE+ listToGeneratedString;
		}
		return listToGeneratedString; 
	}
	
	@DecisionPoint(watchIf= {IModelingDecisions.ATTRIBUTE_GENERATION_POINT,
			IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, IModelingDecisions.DELETE_GENERATION_POINT,
			IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT})
	public static boolean filterAttributes(@GenerationElementParameter(id = IModelingElementDefinitions.IS_DERIVED) boolean isDerived) {
		//Disable getters for the internal attributes
		//Use GETTER_GENERATION_POINT_FILTER for extensibility
		return !isDerived;
	}
	
	@DecisionPoint(watchIf= {IModelingDecisions.ATTRIBUTE_GENERATION_POINT,
			IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, IModelingDecisions.DELETE_GENERATION_POINT,
			IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, IModelingDecisions.GETTER_GENERATION_POINT_FILTER,
			IModelingDecisions.GETTER_SINGLE_GENERATION_POINT})
	public static boolean filterSortedAttributes(@GenerationElementParameter(id = IModelingElementDefinitions.IS_SORTED) boolean isSorted) {
		return !isSorted;
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.GETTER_GENERATION_POINT, unique= true, ifConditionIds= {IModelingElementDefinitions.IS_DERIVED}, 
			priority= IGenerationPointPriorityConstants.HIGHEST)
	public static boolean getter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_DEFAULT_VALUE) String defaultValue,
			@GenerationProcedureParameter(id = IModelingConstants.GETTER_METHOD_NAME) String getterMethodName,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(defaultValue== null|| defaultValue.isEmpty()){
			return false;
		}
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put(IModelingConstants.METHOD_RETURN_TYPE, normalizedType);
		map.put(IModelingConstants.METHOD_PARAMETERS_STRING, CPPTypesConstants.VOID);
		
		map.put(IModelingConstants.CODY_BODY, StringUtil.indent(generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, 
				defaultValue), 1));
		
		map.put(IModelingConstants.METHOD_NAME, getterMethodName);
		map.put(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_INCOMING_GROUP);
		map.put(IModelingConstants.METHOD_OBJECT, element);
		map.put(ICppDefinitions.METHOD_CONST, Boolean.FALSE);
		generationValueGetter.addValue(ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION, map, parent, VisibilityConstants.PUBLIC);
		
		//Getter identifing information
		generationValueGetter.addValue(ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION, map, name, parent, VisibilityConstants.PUBLIC);
		
		String stream = generationValueGetter.generate(IModelingConstructorDefinitionsConstants.STREAM_CONST_GETTER, element, name, getterMethodName);
		generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_IMPLEMENTATION, stream, parent, Boolean.TRUE);
		
		String pointerDelegator = generationValueGetter.generate(ICppDefinitions.THIS_POINTER, element, generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		generationValueGetter.addUniqueValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION_BEFORE, 
				StringUtil.indent(pointerDelegator, 1), parent);
		
		return true;
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION_BEFORE, 
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
	
	@GenerationPoint(generationPoint = IModelingConstants.GENERATION_DIRECTORY)
	public static String generationDirectory(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.GENERATION_LANGUAGE) String generationLanguage,
			@GenerationBaseElement Object element) {
		
		if(CPPCommonConstants.CPP_LANGUAGE.equals(generationLanguage)){
			return generationValueGetter.getString(element, IModelingElementDefinitions.GENERATES, ICppUmpleDefinitions.CPP_GENERATION_ID);
		}
		
		return null;
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
	public static void classAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		String singelton = generationValueGetter.use(ICppUmpleDefinitions.SINGLETON_TEMPLATE_DEFINITION);
		generationValueGetter.addUniqueValue(ICppDefinitions.PREDEFINED_FUNCTIONS, singelton);
		generationValueGetter.addUniqueValue(ICppDefinitions.TEMPLATES_DEFINITIONS, generationValueGetter.use(ICppDefinitions.THREAD_IMPLEMENTATION), modelPackage);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.CLASS_DECLARATIONS_EXTENSION, ifConditionIds= {IModelingElementDefinitions.IS_SINGLETON})
	public static void signletonExtension(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument List<String> calls,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		//Filter singelton;
		calls.add(generationValueGetter.generate(ICppUmpleDefinitions.SINGLETON_CALL, parent));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_IMPLEMENTATION_BEFORE)
	public static String before(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument(id= IModelingConstants.METHOD_NAME) String methodName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		List<?> list = generationValueGetter.getList(parent, IModelingElementDefinitions.CODE_INJECTION, methodName, Boolean.FALSE,
				CPPCommonConstants.CPP_LANGUAGE);
		if(list.isEmpty()){
			return null;
		}
		return GenerationUtil.listToGeneratedString(0, 1, list)+ CommonConstants.NEW_LINE;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_IMPLEMENTATION_AFTER)
	public static String after(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument(id= IModelingConstants.METHOD_NAME) String methodName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		List<?> list = generationValueGetter.getList(parent, IModelingElementDefinitions.CODE_INJECTION, methodName, Boolean.TRUE, 
				CPPCommonConstants.CPP_LANGUAGE);
		if(list.isEmpty()){
			return null;
		}
		return CommonConstants.NEW_LINE+ GenerationUtil.listToGeneratedString(0, 1, list);
	}

	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_BEFORE)
	public static String beforeConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		List<?> list = generationValueGetter.getList(parent, IModelingElementDefinitions.CODE_INJECTION, "constructor", Boolean.FALSE,  //$NON-NLS-1$
				CPPCommonConstants.CPP_LANGUAGE);
		if(list.isEmpty()){
			return null;
		}
		return GenerationUtil.listToGeneratedString(0, 1, list)+ CommonConstants.NEW_LINE;
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_AFTER)
	public static String afterConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		List<?> list = generationValueGetter.getList(parent, IModelingElementDefinitions.CODE_INJECTION, "constructor", Boolean.TRUE,  //$NON-NLS-1$
				CPPCommonConstants.CPP_LANGUAGE);
		if(list.isEmpty()){
			return null;
		}
		return CommonConstants.NEW_LINE+ GenerationUtil.listToGeneratedString(0, 1, list);
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
			@GenerationArgument(id= IModelingConstants.METHOD_ID) String methodId,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_IMMUTABLE) boolean isImmutable,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy) {
		if(!ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION.equals(methodId)){
			return null;
		}
		if(isLazy&& isImmutable|| generationValueGetter.getBoolean(parent, IModelingElementDefinitions.IS_IMMUTABLE)){
			String canSet = generationValueGetter.use(ICppNameConstants.CAN_SET, name);
			
			//And, then update the setter method to have the lazy check code segment
			return StringUtil.indent(generationValueGetter.use(ICppUmpleDefinitions.SETTER_CAN_SET_CHECK, canSet), 1)+ CommonConstants.NEW_LINE;
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, ifConditionIds= IModelingDecisions.ATTRIBUTE_IS_SETTABLE, 
			priority= IGenerationPointPriorityConstants.LOWEST)
	public static void setSetterDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationArgument(id= ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID) String id, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_IMMUTABLE) boolean isImmutable,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy) {
		
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
			generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, 
					new SimpleEntry<Object, String>(element, constructorCall), parent, Boolean.TRUE);
		}
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_BODY)
	public static String constructorDefaulted(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_DEFAULT_VALUE) String defaultValue,
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
					normalizedType, CPPTypesConstants.VOID, returnStatement, parent, element, defaultGetterMethod, 
					VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP, name);
			
			//Reset extra method for the defaulted attributes
			String resetImplementationBody = generationValueGetter.use(ICppUmpleDefinitions.RESET_IMPLEMENTATION, name, defaultGetterMethod);
			addMethodDetails(generationValueGetter, ICppUmpleDefinitions.RESET_IMPLEMENTATION, 
					CPPTypesConstants.BOOL, CPPTypesConstants.VOID, resetImplementationBody, parent, element, resetCall, 
					VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP, name);
			
			
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
		generationValueGetter.addValue(ICppDefinitions.ATTRIBUTE_EQUALITY_ENTRY, equalityDeclaration, parent);
		
		return true;
	}
	
	@GenerationPoint(generationPoint = ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION_CONDITION)
	public static String setterImplementation(
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingConstants.MODELING_DEFAULT_NEW_PARAMETER_NAME) String instnace,
			@GenerationArgument(id= ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION_ARGUMENT) String contents) {
		Map<Object, String> constraintVariables = new HashMap<Object, String>();
		constraintVariables.put(element, instnace);
		String all= generationValueGetter.generationPointString(element, IModelingElementDefinitions.CONSTRAINTS_EXPRESSIONS_CONTENTS, constraintVariables, 
				OperatorConstants.AND);
		if(all.isEmpty()){
			return null;
		}
		return StringUtil.indent(generationValueGetter.use(ICppDefinitions.IF_CONDITION_BLOCK, all, CommonConstants.NEW_LINE+ contents), 1);
	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.CONSTRAINTS_EXPRESSIONS_CONTENTS)
	public static String constraintsExpressions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.CONSTRAINTS) List<?> constraints,
			@GenerationArgument Map<Object, String> constraintVariables,
			@GenerationArgument String operator) {
		return processConstraintsExpressions(generationValueGetter, constraints, constraintVariables, operator);
	}

	@GenerationPoint(generationPoint = IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS)
	public static String processConstraintsExpressions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument Object constraint, @GenerationArgument Map<Object, String> constraintVariables,
			@GenerationArgument String operator) {
		List<?> list= constraint instanceof List? (List<?>) constraint: Arrays.asList(new Object[]{constraint});
		Map<Object, StringBuffer> processedConstraints= new HashMap<Object, StringBuffer>();
		processConstraintsExpressions(generationValueGetter, processedConstraints, list, constraintVariables, null);
		
		String normalizedOperator= operator== null? OperatorConstants.OR: operator;
		
		String contraintString= CommonConstants.BLANK;
		for(StringBuffer stringBuffer: processedConstraints.values()){
			if(stringBuffer.toString().trim().isEmpty()){
				continue;
			}
			if(!contraintString.isEmpty()){
				contraintString= contraintString+ normalizedOperator;
			}
			
			contraintString= contraintString+ CommonConstants.OPEN_BRACKET+ stringBuffer+ CommonConstants.CLOSE_BRACKET;
		}
		return contraintString;
	}
	
	private static void processConstraintsExpressions(GenerationPolicyRegistry generationValueGetter, Map<Object, StringBuffer> processedConstraints, 
			List<?> constraints, Map<Object, String> constraintVariables, Object parentConstraint) {
		for(Object constraint: constraints){
			StringBuffer stringBuffer = processedConstraints.get(constraint);
			if(stringBuffer== null){
				stringBuffer = processedConstraints.get(parentConstraint);
			}
			
			if(stringBuffer== null){
				stringBuffer = new StringBuffer();
				processedConstraints.put(constraint, stringBuffer);
			}
			
			List<?> expressions= generationValueGetter.getList(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS);
			if(expressions== null){
				continue;
			}
			
			String type= null;
			String value= null;
			
			for(Object expr: expressions){
				String newType= generationValueGetter.getString(expr, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_TYPE);
				String newValue= generationValueGetter.getString(expr, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_VALUE);
				
				//////////////////////////////////////////////
				checkMissingOperatorWorkaround: {
					//FIXME: The >= operator is omitted by the parser, so we need to check and add the >= if necessary
					if(NAME.equals(type)){
						if( (!NAME.equals(newType))){
							try {
								Object parseObject = NumberFormat.getInstance().parseObject(newValue);
								if(parseObject== null){
									break checkMissingOperatorWorkaround;
								}
							} catch (ParseException e) {
								break checkMissingOperatorWorkaround;
							}
						}
						
						stringBuffer.append(OperatorConstants.MORE_THAN);
						stringBuffer.append(OperatorConstants.EQUAL);
					}
				}
				//////////////////////////////////////////////
				
				type= newType;
				value= newValue;
				
				if (type.equals(NAME)) {
					List<?> subConstraints = generationValueGetter.getList(expr, IModelingElementDefinitions.CONSTRAINTS);
					if(subConstraints== null){
						continue;
					}
					processConstraintsExpressions(generationValueGetter, processedConstraints, subConstraints, constraintVariables, constraint);
					continue;
				}
				
				boolean isAttribute= generationValueGetter.getBoolean(expr, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_IS_ATTRIBUTE);
				
				if (isAttribute) {
					if(constraintVariables!= null){
						Object attribute = generationValueGetter.getObject(expr, IModelingElementDefinitions.ATTRIBUTE);
						String paramValue = constraintVariables.get(attribute);
						if(paramValue!= null){
							value= paramValue;
						}
					}
					
					stringBuffer.append(value);
					continue;
				} 
				
				if (value.equals(CommonConstants.DOT)) {
					//TODO: To be looked upon
					stringBuffer.append(value);
					continue;
				}
				
				boolean isOperator= generationValueGetter.getBoolean(expr, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_IS_OPERATOR);
				
				if (isOperator){
					boolean isPrimitive= generationValueGetter.getBoolean(expr, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_IS_PRIMITIVE);
					if (!isPrimitive) {
						//TODO: To be looked upon
						stringBuffer.append(value);
					} else{
						stringBuffer.append(value);
					}
				}else {
					stringBuffer.append(value);
				}
			}
		}
	}
	
	@LoopProcessorAnnotations(priority= IGenerationPointPriorityConstants.HIGHEST, aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void setConstructorConstraints(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.CONSTRAINTS) List<?> constraints,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		Map<Object, String> constraintVariables = getConstraintVariableParameters(generationValueGetter, constraints);
		
		String all= generationValueGetter.generationPointString(element, IModelingElementDefinitions.CONSTRAINTS_EXPRESSIONS_CONTENTS, constraintVariables, 
				OperatorConstants.OR);
		if(all.isEmpty()){
			return;
		}
		
		String constraintCondition = generationValueGetter.generationPointString(element, IModelingElementDefinitions.CONSTRAINT_CHECK_THROW, all, Boolean.TRUE);
		if(!constraintCondition.isEmpty()){
			generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, 
					new SimpleEntry<Object, String>(element, constraintCondition+ CommonConstants.NEW_LINE), parent, Boolean.TRUE);
		}
	}

	private static Map<Object, String> getConstraintVariableParameters(GenerationPolicyRegistry generationValueGetter, List<?> constraints) {
		Map<Object, String> constraintVariables= new HashMap<Object, String>();
		for(Object constraint: constraints){
			List<?> expressions= generationValueGetter.getList(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS);
			if(expressions== null){
				continue;
			}
			
			for(Object expr: expressions){
				String type= generationValueGetter.getString(expr, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_TYPE);
				if (!type.equals(NAME)) { //$NON-NLS-1$
					continue;
				}
				
				boolean isAttribute= generationValueGetter.getBoolean(expr, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_IS_ATTRIBUTE);
				
				if(!isAttribute){
					continue;
				}
				
				Object attribute = generationValueGetter.getObject(expr, IModelingElementDefinitions.ATTRIBUTE);
				String parameterName = generationValueGetter.generationPointString(attribute, IModelingElementDefinitions.TYPE_PARAMETER_NAME);
				constraintVariables.put(attribute, parameterName);
			}
		}
		return constraintVariables;
	}
	
	
//	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_CONDITION)
//	public static String constructor(
//			@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
//			@GenerationArgument(id= IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_ARGUMENT) String contents) {
//		
//		String all= generationValueGetter.generationPointString(element, IModelingElementDefinitions.CONSTRAINTS_EXPRESSIONS_CONTENTS, OperatorConstants.OR);
//		if(all.isEmpty()){
//			return null;
//		}
//		
//		String constraintCondition = generationValueGetter.generationPointString(element, IModelingElementDefinitions.CONSTRAINT_CHECK_THROW, all, Boolean.TRUE);
//		return constraintCondition+ CommonConstants.NEW_LINE+ contents;
//	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.CONSTRAINT_CHECK_THROW)
	public static String constraintCheck(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.CONSTRAINTS) List<?> constraints,
			@GenerationBaseElement Object element,
			@GenerationArgument String conditions,
			@GenerationArgument Boolean invert) {
		Map<Object, String> constraintVariables = constraints== null? new HashMap<Object, String>():getConstraintVariableParameters(generationValueGetter, constraints);
		
		Boolean isMany;
		String asStringParameters;
		
		if(constraints== null){
			Set<String> params= new HashSet<String>();
			List<?> list = generationValueGetter.getList(element, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS);
			for(Object obj: list){
				String type= generationValueGetter.getString(obj, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_TYPE);
				if(!NAME.equals(type)){
					continue;
				}
				
				String value= generationValueGetter.getString(obj, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_VALUE);
				
				generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME, 
						GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_STRING, value));
				
				
				params.add(value);
			}
			
			asStringParameters = GenerationUtil.asStringParameters(new ArrayList<String>(params), "and");
			
			int size = params.size();
			if(size>1){
				isMany= Boolean.TRUE;
			}else if(params.isEmpty()){
				isMany= Boolean.FALSE;
			}else/* if(size==1)*/{
				//FIXME: shall have external dictionary for it
				@SuppressWarnings("nls")
				List<String> uncountableNouns= Arrays.asList(new String[]{"data", "information"});
				
				isMany= Boolean.valueOf(uncountableNouns.contains(params.iterator().next()));
			}
		}else{
			isMany = Boolean.valueOf(constraintVariables.size()>1);
			asStringParameters = GenerationUtil.asStringParameters(new ArrayList<String>(constraintVariables.values()), "and");
		}
		
		String throwStatement = generationValueGetter.use(ICppDefinitions.THROW_STATEMENET, generationValueGetter.use(ICppUmpleDefinitions.CONSTRAINT_MESSAGE, 
				asStringParameters, isMany));
		String constraintCondition = generationValueGetter.use(ICppDefinitions.IF_CONDITION_BLOCK, conditions, 
				StringUtil.indent(CommonConstants.NEW_LINE+ throwStatement, 1), invert);
		return constraintCondition;
	}
	
	
	@GenerationPoint(generationPoint = ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, unique= true, priority= IGenerationPointPriorityConstants.HIGH)
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
			String codeBody, Object parent, Object element, String name, String visibility, String groupId, String identifier){
		Map<String, Object> map= new HashMap<String, Object>();
		map.put(IModelingConstants.METHOD_RETURN_TYPE, returnType);
		map.put(IModelingConstants.METHOD_PARAMETERS_STRING, parametersString);
		map.put(IModelingConstants.CODY_BODY, codeBody);
		map.put(IModelingConstants.METHOD_NAME, name);
		map.put(IModelingConstants.METHOD_ID, identifier);
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
	
	
	/////////////////////////////////Extern keyword/////////////////////////////////////////
	
	@DecisionPoint(watchIf= {IModelingDecisions.DEPENDS_GENERATION_POINT})
	public static boolean filterDependExternals(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
	@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object dependObject) {
		return !generationValueGetter.getBoolean(dependObject, IModelingElementDefinitions.EXTERNAL);
	}
	
	@GenerationLoopAnnotationFilter(id = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static boolean filterExternals(@GenerationElementParameter(id =IModelingElementDefinitions.EXTERNAL) boolean isExternal){
		return isExternal;
	}
}