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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationArguments;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationLoopPath;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationCallback.WatchedObjectValue;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPoint.InterceptorResponse;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationPolicyRegistryPriorities;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.core.ContentsDescriptor;
import cruise.umple.cpp.core.IGenerationCommonConstants;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.CommonTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.VisibilityConstants;

public class CPPBaseGenerationPointsHandler{
	
	private static final int MAIN_ASPECT_GROUP_PRIORITY= 400;
	
	@LoopProcessorAnnotation
	public static void modelProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAMESPACE) String namespace,
			@GenerationBaseElement Object model){
		
		addNamespace(generationValueGetter, namespace, model, model);
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void classInterfaceParentTypesProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAMESPACE) String namespace,
			@GenerationLoopElement Object modelPackage,
			@GenerationBaseElement Object element){
		
		String modelNamespace= generationValueGetter.getString(modelPackage, IModelingElementDefinitions.NAMESPACE);
		if(!addNamespace(generationValueGetter, namespace, element, modelPackage)){
			addNamespace(generationValueGetter, modelNamespace, element, modelPackage);
		}else{
			//Must use the core namespace in other places
			//i.e: using namespace rootNamespace::core;
			generationValueGetter.generationPointString(element, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, modelNamespace), 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	private static boolean addNamespace(GenerationPolicyRegistry generationValueGetter, String namespace, Object element, Object model) {
		if(namespace== null|| namespace.isEmpty()){
			return false;
		}
		
		String normalized= namespace.replace(CommonConstants.UNDERSCORE, CommonConstants.DOT).replace(CommonConstants.FORWARD_SLASH, CommonConstants.DOT);
		String[] splits = normalized.split("\\."); //$NON-NLS-1$
		
		String open= CommonConstants.BLANK;
		String close= CommonConstants.BLANK;
		String defineBaseString= CommonConstants.BLANK;
		String defineBegin= CommonConstants.BLANK;
		for(String split: splits){
			open= open+ generationValueGetter.use(ICppDefinitions.NAMESPACE, split)+ CommonConstants.SPACE+ CommonConstants.OPEN_BRACE+ CommonConstants.SPACE;
			close= close+ CommonConstants.CLOSE_BRACE+ CommonConstants.SPACE;
			defineBaseString= defineBaseString+ CommonConstants.UNDERSCORE+ split;
		}
		
		String begin = defineBaseString+ CommonConstants.UNDERSCORE+ CPPCommonConstants.BEGIN.toUpperCase();
		defineBegin = generationValueGetter.use(ICppDefinitions.DEFINE, begin, open);
		
		String end = defineBaseString+ CommonConstants.UNDERSCORE+ CPPCommonConstants.END.toUpperCase();
		String defineEnd = generationValueGetter.use(ICppDefinitions.DEFINE, end, close);
		
		generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACES_MACROS, defineBegin, model);
		generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACES_MACROS, defineEnd, model);
		
		generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACE_OPENING, defineBaseString, element);
		generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACE_CLOSING, defineBaseString, element);
		
		if(!element.equals(model)){
			SimpleEntry<Object, SimpleEntry<String, String>> entry = 
					new SimpleEntry<Object, SimpleEntry<String, String>>(element, new SimpleEntry<String, String>(begin, end));
			generationValueGetter.addUniqueValue(ICppDefinitions.INCOMPLETE_NAMESPACES_DEFNITION, entry, element, model);
		}
		
		return true;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.FULL_PATH)
	public static String fullPath(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement Object rootElement,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingDecisions.MODEL_PATH) String path){
		if(rootElement== element){	//Do not use equality
			return path+ CommonConstants.FORWARD_SLASH+ generationValueGetter.generationPointString(element, CPPCommonConstants.PACKAGE_SUFFIX);
		}
		return path+ CommonConstants.FORWARD_SLASH+ name;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.SET_ATTRIBUTE_PREFIXES)
	public static void addPrefix(@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT) List<String> prefixes){
		if(isStatic){
			prefixes.add(CPPCommonConstants.STATIC_MODIFIER);
		}
		
		if(isConstant){
			prefixes.add(CPPCommonConstants.CONST_MODIFIER);
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ATTRIBUTE_GENERATION_POINT, unique= true, priority= IGenerationPointPriorityConstants.LOWEST)
	public static void basicAttributeDeclaration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_ROLE_NAME) String roleName,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_VISIBILITY) String normalizedVisibility,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT) List<String> prefixes,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT) String attributeValue,
			@GenerationProcedureParameter(id = IModelingConstants.MULTILINE_COMMENTS_STRING) String commentsString,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_INTERNAL) boolean isInternal,
			@GenerationLoopElement(id= {IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}) Object attribute,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String prefix= GenerationUtil.safeSpcae(prefixes);
		String id;
		if(attribute!= null){
			if(isStatic){
				id= ICppDefinitions.STATIC_ATTRIBUTE_DECLARATIONS; 
			}else{
				id= ICppDefinitions.ATTRIBUTES_DECLARATION;
			}
		}else{
			id= ICppDefinitions.ASSOCIATIONS_DECLARATION;
		}
		
		String attributeDeclaration = generationValueGetter.generate(ICppDefinitions.DECLARE_STATEMENET, element, prefix,
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_TYPE_ARGUMENT, normalizedType),
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_NAME_ARGUMENT, attribute==null?roleName: name),
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT, prefixes),
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT, attributeValue));
		
		if(isInternal&& commentsString!= null && !commentsString.isEmpty()){
			attributeDeclaration= CommonConstants.NEW_LINE+ commentsString+ CommonConstants.NEW_LINE+ attributeDeclaration;
		}
		
		generationValueGetter.addValue(id, attributeDeclaration, normalizedVisibility, parent);
		generationValueGetter.generationPointString(element, ICppDefinitions.ATTRIBUTE_EQUALITY_GENERATION_POINT);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.DECLARE_IMPLEMENTATION)
	public static void declareImplementation(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_NAME_ARGUMENT) String name,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_VISIBILITY) String normalizedVisibility,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT) List<String> prefixes,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT) String attributeValue,
			@GenerationArgument(id= IModelingConstants.ATTRIBUTE_TYPE_ARGUMENT) String type,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isConst,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		if(prefixes!= null&& prefixes.contains(CPPCommonConstants.STATIC_MODIFIER)){
			String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
			String implementation = generationValueGetter.generate(ICppDefinitions.DECLARE_IMPLEMENTATION, element,type, parentName, name, attributeValue,
					GenerationArgumentDescriptor.arg(IModelingElementDefinitions.IS_CONSTANT, Boolean.valueOf(isConst)));
			generationValueGetter.addValue(ICppDefinitions.DECLARE_IMPLEMENTATION, implementation, normalizedVisibility, parent);
		}
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ATTRIBUTE_EQUALITY_GENERATION_POINT, priority= IGenerationPointPriorityConstants.LOWEST)
	public static void basicAttributeEquality(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		//Equality
		if(!isStatic){
			String equalityDeclaration = generationValueGetter.generationPointString(element, ICppDefinitions.ATTRIBUTE_EQUALITY);
			generationValueGetter.addValue(ICppDefinitions.ATTRIBUTE_EQUALITY_ENTRY, equalityDeclaration, parent);
		}
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_PARENT_CALL, unique= true, priority= IGenerationPointPriorityConstants.LOWEST)
	public static String methodParentCall(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingConstants.PARENT_CLASS) Object parentClass,
			@GenerationArgument(id= ICppDefinitions.METHOD_PARAMAETERS_ARGUMENT) String parameters,
			@GenerationArgument(id= IModelingConstants.METHOD_NAME) String methodName) {
		
		if(parentClass!= null){
			String parentClassName= generationValueGetter.getString(parentClass, IModelingElementDefinitions.NAME);
			return generationValueGetter.use(ICppDefinitions.METHOD_PARENT_CALL, parentClassName, methodName, parameters);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ATTRIBUTE_EQUALITY, priority= IGenerationPointPriorityConstants.LOWEST,  unique= true)
	public static String attributeEquality(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany){
		return generationValueGetter.use(ICppDefinitions.ATTRIBUTE_EQUALITY_ENTRY, 
				name, Boolean.valueOf(isMany));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ATTRIBUTE_EQUALITY,ifConditionIds=IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE, ifNotConditionIds=
			IModelingDecisions.ATTRIBUTE_IS_MANY, unique= true)
	public static String primitiveattributeEquality(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		return generationValueGetter.use(ICppDefinitions.PRIMITIVE_ATTRIBUTE_EQUALITY, name);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ALIASES)
	public static String aliases(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object model){
		
		String implementationDetails = GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.ALIAS, model, Boolean.TRUE);
		
		String uses = GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.ALIAS, model);
		if(!uses.isEmpty()){
			if(!implementationDetails.isEmpty()){
				implementationDetails= implementationDetails+ CommonConstants.NEW_LINE;
			}
			implementationDetails= implementationDetails+ uses;
		}
		
		if(implementationDetails.isEmpty()){
			return implementationDetails;
		}
		
		return CommonConstants.NEW_LINE+ implementationDetails+ CommonConstants.NEW_LINE;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.CLASS_DECLARATIONS)
	public static String getClassDeclarations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element){
		List<Object> all = generationValueGetter.getValues(IModelingDecisions.PARENT_CLASS_EXTENDS, element);
		if(all.isEmpty()){
			all= generationValueGetter.getValues(IModelingDecisions.INTERFACES_IMPLEMENTS, element);
		}else{
			all.addAll(generationValueGetter.getValues(IModelingDecisions.INTERFACES_IMPLEMENTS, element));
		}
		
		generationValueGetter.generationPointString(element, IModelingConstants.CLASS_DECLARATIONS_EXTENSION, all);
		
		List<String> asPublic= new ArrayList<String>();
		for(Object current: all){
			asPublic.add(generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, VisibilityConstants.PUBLIC, current));
		}
		String parametersString= GenerationUtil.asStringParameters(asPublic);
		
		return generationValueGetter.use(ICppDefinitions.CLASS_DEFINITION, name, parametersString);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRE_PROCESSING_DEFINITION_NAME, priority=IGenerationPointPriorityConstants.LOWEST)
	public static String getDefinitionName(@GenerationProcedureParameter(id = IModelingConstants.FULL_PATH) String fullPath,
			@GenerationArgument(id= ICppDefinitions.FULL_PATH_ARGUMENT) String fullPathAsArgument){
		
		String compareObject= fullPathAsArgument;
		if(compareObject== null|| compareObject.isEmpty()){
			compareObject= fullPath;
		}
		
		return compareObject.replace(CommonConstants.DOT, CommonConstants.UNDERSCORE).
				replace(CommonConstants.FORWARD_SLASH, CommonConstants.UNDERSCORE).toUpperCase();
	}
	
	@LoopProcessorAnnotation
	public static void modelCodeIncludes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object modelPackage){
		
		for(String include: new String[]{ISTLConstants.VECTOR, ISTLConstants.ALGORITHM, ISTLConstants.IO_STREAM, ISTLConstants.STRING,
				ISTLConstants.EXCEPTION, ISTLConstants.STD_EXCEPTION, ISTLConstants.ASSERT_LIBRARY, ISTLConstants.STUDIO}){
			generationValueGetter.generationPointString(modelPackage, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, include), 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	@LoopProcessorAnnotation(aspect= LoopAspectConstants.FINALIZE, priority= GenerationPolicyRegistryPriorities.HIEGHEST)
	public static void modelAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object model){
		String contents = generationValueGetter.generate(ICppDefinitions.PACKAGE_HEADER, model);
		
		String modelPath = generationValueGetter.generationPointString(model, IModelingConstants.ROOT_PATH,
				GenerationArgumentDescriptor.arg(IModelingConstants.GENERATION_LANGUAGE, CPPCommonConstants.CPP_LANGUAGE));
		String modelName= generationValueGetter.generationPointString(model, CPPCommonConstants.PACKAGE_SUFFIX);
		
		String fileName= modelName+	CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		ContentsDescriptor contentsDescriptor = new ContentsDescriptor(contents, fileName, modelPath);
		
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, contentsDescriptor);
	}
	
	@LoopProcessorAnnotation(aspect= LoopAspectConstants.TERMINATE, priority= GenerationPolicyRegistryPriorities.LOWEST, aspectGroup= MAIN_ASPECT_GROUP_PRIORITY)
	public static void modelPathsAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.FILE_PATH) String filePath,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object model){
		
		String modelPath = generationValueGetter.generationPointString(model, IModelingConstants.ROOT_PATH,
				GenerationArgumentDescriptor.arg(IModelingConstants.GENERATION_LANGUAGE, CPPCommonConstants.CPP_LANGUAGE));
		String fileName= name+"_Main" +CommonConstants.DOT +CPPCommonConstants.BODY_FILE_EXTENSION; //$NON-NLS-1$
		
		String useAllNamespaces= CommonConstants.BLANK;
		Iterator<Object> namespacesIterator = generationValueGetter.getAllValues(IModelingConstants.NAMESPACES_TRACKER, model).iterator();
		while(namespacesIterator.hasNext()){
			String object = namespacesIterator.next().toString();
			object = normalizeNamespace(object);
			useAllNamespaces= useAllNamespaces+ generationValueGetter.use(ICppDefinitions.USE_NAMESPACE, CPPCommonConstants.DECLARATION_COMMON_PREFIX+object);
			
			if(namespacesIterator.hasNext()){
				useAllNamespaces= useAllNamespaces+ CommonConstants.NEW_LINE;
			}
		}
		
		
		String implementationDetails = GenerationUtil.getImplementationDetails(generationValueGetter, CPPDependsPointsHandler.ALL_MODEL_INCLUDES_TRACKER, "Main"); //$NON-NLS-1$
		if(!useAllNamespaces.isEmpty()){
			if(!implementationDetails.isEmpty()){
				implementationDetails= implementationDetails+ CommonConstants.NEW_LINE;
			}
			implementationDetails= implementationDetails+ useAllNamespaces;
		}
		
		implementationDetails = bundleMain(filePath, modelPath, fileName, implementationDetails);
		
		Map<Object, List<String>> mainBlocks = getMainBlocks(generationValueGetter, model);
		
		if(!mainBlocks.isEmpty()){
			String mainCalls= CommonConstants.BLANK;
			for(Object umpleClass: mainBlocks.keySet()){
				List<String> list = mainBlocks.get(umpleClass);
				if(list.isEmpty()){	//Impossible to happen
					continue;
				}
				String string = generationValueGetter.getString(umpleClass, IModelingElementDefinitions.NAMESPACE);
				string = normalizeNamespace(string);
				mainCalls= mainCalls+ generationValueGetter.generate(ICppDefinitions.MAIN_METHOD_CALL, umpleClass, string);
				
			}
			
			generationValueGetter.addUniqueValue(ICppDefinitions.MAIN_CONTENTS, mainCalls);
		}
		
		String mainContents = GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.MAIN_CONTENTS);
		
		String generate = generationValueGetter.generate(ICppDefinitions.MAIN, model, implementationDetails, mainContents);
		
		ContentsDescriptor contentsDescriptor = new ContentsDescriptor(generate, fileName, modelPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, contentsDescriptor);
	}

	private static String normalizeNamespace(String object) {
		return object.replace(CommonConstants.UNDERSCORE, CPPCommonConstants.DECLARATION_COMMON_PREFIX).
				replace(CommonConstants.DOT, CPPCommonConstants.DECLARATION_COMMON_PREFIX);
	}

	private static Map<Object, List<String>> getMainBlocks(GenerationPolicyRegistry generationValueGetter, Object model) {
		Map<Object, List<String>> mainMap= new HashMap<Object, List<String>>();
		for(Object umpleClass: generationValueGetter.getList(model, IModelingElementDefinitions.CLASSES)){
			for(Object operation: generationValueGetter.getList(umpleClass, IModelingElementDefinitions.OPERATIONS)){
				
				String methodName = generationValueGetter.getString(operation, IModelingElementDefinitions.NAME);
				if("main".equals(methodName)){ //$NON-NLS-1$
					List<?> methodParameters = generationValueGetter.getList(operation, IModelingElementDefinitions.OPERATION_PARAMETERS);
	    			if(methodParameters.size()!= 2){
	    				continue;
	    			}
	    			
	    			Object parameter1 = methodParameters.get(0);
	    			
	    			String parameter1Type = generationValueGetter.getString(parameter1, IModelingElementDefinitions.TYPE_NAME);
	    			if(!"int".equals(parameter1Type)){ //$NON-NLS-1$
						continue;
					}
	    			
	    			String parameter1Name = generationValueGetter.getString(parameter1, IModelingElementDefinitions.NAME);
	    			
					if(parameter1Name== null|| parameter1Name.trim().startsWith("*")){ //$NON-NLS-1$
						continue;
					}
					
					Object parameter2 = methodParameters.get(1);
					
					String parameter2Type = generationValueGetter.getString(parameter2, IModelingElementDefinitions.TYPE_NAME);
	    			if(!"char".equals(parameter2Type)){ //$NON-NLS-1$
						continue;
					}
	    			
	    			String parameter2Name = generationValueGetter.getString(parameter2, IModelingElementDefinitions.NAME);
	    			
					if(parameter2Name== null|| !parameter2Name.trim().startsWith("*")){ //$NON-NLS-1$
						continue;
					}
					
					
					String code = generationValueGetter.getString(operation, IModelingElementDefinitions.OPERATION_BODY, CPPCommonConstants.CPP_LANGUAGE);
					if(!CommonConstants.BLANK.equals(code.trim())){
						List<String> list = mainMap.get(umpleClass);
						if(list== null){
							list= new ArrayList<String>();
							mainMap.put(umpleClass, list);
						}
						list.add(code);
					}
	    		}
			}
		}
		
		return mainMap;
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.FINALIZE, priority= GenerationPolicyRegistryPriorities.MEDIUM)
	public static void classAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingDecisions.MODEL_PATH) String path){
		
		String fullPath = generationValueGetter.generationPointString(element, IModelingConstants.ROOT_PATH,
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, path),
				GenerationArgumentDescriptor.arg(IModelingConstants.GENERATION_LANGUAGE, CPPCommonConstants.CPP_LANGUAGE));
				
		String implementationContents = generationValueGetter.generate(ICppDefinitions.CLASS_BODY, element, Boolean.TRUE);
		String implementationFileName= name + CommonConstants.DOT +CPPCommonConstants.BODY_FILE_EXTENSION;
		
		String headerContents = generationValueGetter.generate(ICppDefinitions.HEADER, element, Boolean.TRUE);
		String headerFileName= name + CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		
		ContentsDescriptor headerContentsDescriptor = new ContentsDescriptor(headerContents, headerFileName, fullPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, headerContentsDescriptor);
		
		ContentsDescriptor implementationContentsDescriptor = new ContentsDescriptor(implementationContents, implementationFileName, fullPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, implementationContentsDescriptor);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.PRE)
	public static void registerPredefinedOperators(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, ICppDefinitions.PREDEFINED_OPERATORS_REGISTER);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void setNamespaceDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement Object model){
		
		List<Object> values = generationValueGetter.getValues(ICppDefinitions.DEFNIED_NAMESPACES_MACROS, element, model);
		if(values.isEmpty()){
			return;
		}
		
		List<List<String>> roots= new ArrayList<List<String>>();
		List<Object> objects= new ArrayList<Object>();
		
		List<List<String>> namespaces= new ArrayList<List<String>>();
		String namespace= generationValueGetter.getString(model, IModelingElementDefinitions.NAMESPACE);
		
		
		String compareNamespace= null;
		
		if(namespace!= null){
			compareNamespace= namespace.replace(CommonConstants.DOT, CommonConstants.UNDERSCORE);
			if(compareNamespace.startsWith(CommonConstants.UNDERSCORE)){
				compareNamespace= compareNamespace.substring(1, compareNamespace.length());
			}
			
			if(compareNamespace.endsWith(CommonConstants.UNDERSCORE)){
				compareNamespace= compareNamespace.substring(0, compareNamespace.length()-1);
			}
		}
		
		String elementValue = CommonConstants.BLANK;
		List<Object> openings = generationValueGetter.getValues(ICppDefinitions.NAMESPACE_OPENING, element);
		Iterator<Object> elementsIterator = openings.iterator();
		while(elementsIterator.hasNext()){
			Object obj= elementsIterator.next();
			if(obj instanceof String== false){
				continue;
			}
			String compareObject= (String) obj;
			if(compareObject.startsWith(CommonConstants.UNDERSCORE)){
				compareObject= compareObject.substring(1, compareObject.length());
			}
			
			if(compareObject.endsWith(CommonConstants.UNDERSCORE)){
				compareObject= compareObject.substring(0, compareObject.length()-1);
			}
			
			if(compareObject.equals(compareNamespace)){
				continue;
			}
			elementValue= elementValue+ obj;
			if(elementsIterator.hasNext()){
				elementValue= CommonConstants.UNDERSCORE+ elementValue;
			}
		}
		
		for(Object object: values){
			Object objectValue = generationValueGetter.getValues(ICppDefinitions.NAMESPACE_OPENING, object).get(0);
			List<String> root= new ArrayList<String>();
			
			if(!elementValue.isEmpty()){
				root.add(elementValue);
			}
			
			namespaces.add(new ArrayList<String>(root));
			root.add((String) objectValue);
			roots.add(root);
			objects.add(object);
		}
		
		
		for(int index=0; index<namespaces.size(); index++){
			List<String> next = namespaces.get(index);
			
			Object object= objects.get(index);
			
			String definitionString= CommonConstants.BLANK;
			
			Iterator<String> nestedIterator = next.iterator();
			while(nestedIterator.hasNext()){
				String string = nestedIterator.next();
				if(!definitionString.isEmpty()){
					definitionString= definitionString+ CommonConstants.UNDERSCORE;
				}
				definitionString= definitionString+ string;
				
				if(!nestedIterator.hasNext()){
					String namepaceUse = generationValueGetter.use(ICppDefinitions.NAMESPACE, string)+ CommonConstants.OPEN_BRACE;
					String beginDefinition = definitionString+CommonConstants.UNDERSCORE+ CPPCommonConstants.BEGIN.toUpperCase();
					String endDefinition = definitionString+CommonConstants.UNDERSCORE+ CPPCommonConstants.END.toUpperCase();
					
					if(compareNamespace!= null&& !compareNamespace.isEmpty()&& object== element){
						beginDefinition= CommonConstants.UNDERSCORE+ compareNamespace+ CommonConstants.UNDERSCORE+ beginDefinition;
						endDefinition= CommonConstants.UNDERSCORE+ compareNamespace+ CommonConstants.UNDERSCORE+ endDefinition;
					}
					beginDefinition= beginDefinition.replace(CommonConstants.UNDERSCORE+ CommonConstants.UNDERSCORE, 
							CommonConstants.UNDERSCORE);
					endDefinition= endDefinition.replace(CommonConstants.UNDERSCORE+ CommonConstants.UNDERSCORE, 
							CommonConstants.UNDERSCORE);
					
					if(!beginDefinition.startsWith(CommonConstants.UNDERSCORE)){
						beginDefinition= CommonConstants.UNDERSCORE+ beginDefinition;
					}
					String begin = generationValueGetter.use(ICppDefinitions.DEFINE, beginDefinition, 
							namepaceUse);
					
					if(!endDefinition.startsWith(CommonConstants.UNDERSCORE)){
						endDefinition= CommonConstants.UNDERSCORE+ endDefinition;
					}
					String end = generationValueGetter.use(ICppDefinitions.DEFINE, endDefinition, 
							CommonConstants.CLOSE_BRACE);
					
					generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACES_MACROS, begin, model);
					generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACES_MACROS, end, model);
					
					SimpleEntry<Object, SimpleEntry<String, String>> entry = 
							new SimpleEntry<Object, SimpleEntry<String, String>>(element, new SimpleEntry<String, String>(beginDefinition, endDefinition));
					generationValueGetter.addUniqueValue(ICppDefinitions.INCOMPLETE_NAMESPACES_DEFNITION, entry, element, model);
				}
			}
		}
		
		List<Object> visited= new ArrayList<Object>();
		for(int index=0; index<roots.size(); index++){
			List<String> list = roots.get(index);
			if(visited.contains(list)){
				continue;
			}
			visited.add(list);
			generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACES_ROOTS, 
					new SimpleEntry<Object, Object>(list, objects.get(index)), model);
		}
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.PRE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void useNamespaceDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element, @GenerationLoopElement Object model){
		processNamespaceDetails(generationValueGetter, element, model);
	}

	private static void processNamespaceDetails(GenerationPolicyRegistry generationValueGetter,
			Object element, Object model) {
		List<Object> values = generationValueGetter.getValues(ICppDefinitions.DEFNIED_NAMESPACES_MACROS, element, model);
		if(values.isEmpty()){
			return;
		}
		
		List<Object> roots = generationValueGetter.getValues(ICppDefinitions.NAMESPACES_ROOTS, model);
		
		Collections.sort(roots, new Comparator<Object>() {

			@SuppressWarnings("unchecked")
			@Override
			public int compare(Object object1, Object object2) {
				List<Object> list1= (List<Object>) ((SimpleEntry<?, ?>)object1).getKey();
				List<Object> list2= (List<Object>) ((SimpleEntry<?, ?>)object2).getKey();
				
				if(list1.size()> list2.size()){
					return 1;
				}else if(list1.size()< list2.size()){
					return -1;
				}
				
				return 0;
			}
		});
		
		
		List<List<String>> shortened= new ArrayList<List<String>>();
		for(Object object: roots){
			SimpleEntry<?, ?> simple= (SimpleEntry<?, ?>) object;
			@SuppressWarnings("unchecked")
			List<String> qualified = (List<String>) simple.getKey();
			List<String> list= qualified;
			
			while(true){
				List<String> subList = list.subList(1, list.size());
				if(shortened.contains(subList)){
					break;
				}
				if(list.size()==1){
					break;
				}
				
				list = subList;
			}
			
			String qualifiedNamespaceCallDeclaration= CommonConstants.BLANK;
			Iterator<String> namespacesIterator = qualified.iterator();
			while(namespacesIterator.hasNext()){
				String segment = namespacesIterator.next();
				if(!namespacesIterator.hasNext()){
					segment= CommonConstants.UNDERSCORE+ segment;
				}
				
				qualifiedNamespaceCallDeclaration= qualifiedNamespaceCallDeclaration+ CPPCommonConstants.DECLARATION_COMMON_PREFIX+ segment;
			}
			
			String modelNamespace = generationValueGetter.getString(model, IModelingElementDefinitions.NAMESPACE);
			String namespace = modelNamespace!= null?modelNamespace.replace(CommonConstants.UNDERSCORE, CPPCommonConstants.DECLARATION_COMMON_PREFIX): CommonConstants.BLANK;
			namespace= namespace.replace(CommonConstants.DOT, CommonConstants.UNDERSCORE);
			if(namespace.startsWith(CommonConstants.UNDERSCORE)){
				namespace= namespace.substring(1, namespace.length());
			}
			
			if(namespace.endsWith(CommonConstants.UNDERSCORE)){
				namespace= namespace.substring(0, namespace.length()-1);
			}
			
			if(namespace.contains(CommonConstants.UNDERSCORE)){
				namespace= namespace.replace(CommonConstants.UNDERSCORE, CPPCommonConstants.DECLARATION_COMMON_PREFIX);
				if(!namespace.startsWith(CPPCommonConstants.DECLARATION_COMMON_PREFIX)){
					namespace= CPPCommonConstants.DECLARATION_COMMON_PREFIX+ namespace;
				}
			}
			
			qualifiedNamespaceCallDeclaration= namespace+ qualifiedNamespaceCallDeclaration;
			
			String shortenedCallDeclaration= CommonConstants.BLANK;
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext()){
				String segment = iterator.next();
				shortenedCallDeclaration= shortenedCallDeclaration+ segment;
				
				if(iterator.hasNext()){
					shortenedCallDeclaration= segment+ CommonConstants.UNDERSCORE;
				}
			}
			
			if(qualifiedNamespaceCallDeclaration.startsWith(CommonConstants.UNDERSCORE)){
				qualifiedNamespaceCallDeclaration= qualifiedNamespaceCallDeclaration.substring(1, qualifiedNamespaceCallDeclaration.length());
			}
			
			if(!qualifiedNamespaceCallDeclaration.startsWith(CPPCommonConstants.DECLARATION_COMMON_PREFIX)){
				qualifiedNamespaceCallDeclaration= CPPCommonConstants.DECLARATION_COMMON_PREFIX+ 
						qualifiedNamespaceCallDeclaration;
			}
			
			String define = generationValueGetter.use(ICppDefinitions.DEFINE, shortenedCallDeclaration, qualifiedNamespaceCallDeclaration);
			
			
			generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACES_MACROS, define, model);
			
			generationValueGetter.addUniqueValue(ICppDefinitions.MACROS_TYPE_DEF, new SimpleEntry<String, List<String>>(shortenedCallDeclaration, qualified), 
					simple.getValue(), qualified.get(qualified.size()-1), element);
			
			shortened.add(list);
		}
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.DEFNIED_NAMESPACES_MACROS)
	public static String definedMacros(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element){
		String implementationDetails = GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.NAMESPACES_MACROS, element);
		
		if(implementationDetails.isEmpty()){
			return implementationDetails;
		}
		return implementationDetails+ CommonConstants.NEW_LINE;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.FULL_QUALIFIED_NAME)
	public static String fullQualifiedName(@GenerationElementParameter(id = IModelingElementDefinitions.NAMESPACE) String namespace,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		String normalizedNamespace= CommonConstants.BLANK;
		if(!namespace.isEmpty()){
			normalizedNamespace= namespace.replace(CommonConstants.DOT, CPPCommonConstants.DECLARATION_COMMON_PREFIX).replace(CommonConstants.UNDERSCORE, CPPCommonConstants.DECLARATION_COMMON_PREFIX);
			normalizedNamespace= normalizedNamespace+ CPPCommonConstants.DECLARATION_COMMON_PREFIX+ name;
		}else{
			normalizedNamespace= name;
		}
		return normalizedNamespace;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.DEFNIED_NAMESPACES_MACROS, priority= IGenerationPointPriorityConstants.LOWEST)
	public static String incompleteDefinitions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element) {
		return setPredefinedTypes(generationValueGetter, element);
	}

	private static String setPredefinedTypes(GenerationPolicyRegistry generationValueGetter, Object element) {
		List<Object> values = generationValueGetter.getById(ICppDefinitions.INCOMPLETE_NAMESPACES_DEFNITION);
		
		Map<Object, List<Object>> groups= new HashMap<Object, List<Object>>();
		Set<Object> keys= new LinkedHashSet<Object>();	//Preserve order
		for(Object obj: values){
			if(obj instanceof SimpleEntry){
				SimpleEntry<?,?> entry= (SimpleEntry<?, ?>) obj;
				Object key = entry.getKey();
				Object value = entry.getValue();
				
				List<Object> list = groups.get(key);
				if(list== null){
					list= new ArrayList<Object>();
					groups.put(key, list);
				}
				list.add(value);
				keys.add(key);
			}
		}
		
		Map<Object, LinkedHashSet<SimpleEntry<?, ?>>> entries= new HashMap<Object, LinkedHashSet<SimpleEntry<?, ?>>>();
		Map<Object, LinkedHashSet<Object>> types= new HashMap<Object, LinkedHashSet<Object>>();
		
		for(Object obj: keys){
			List<Object> list = groups.get(obj);
			
			String namespace = generationValueGetter.getString(obj, IModelingElementDefinitions.NAMESPACE);
			List<String> normalized= new ArrayList<String>();
			for(String segment: namespace.split(CommonConstants.UNDERSCORE)){
				if(!segment.equals(CommonConstants.BLANK)){
					normalized.add(segment);
				}
			}
			
			LinkedHashSet<SimpleEntry<?, ?>> namespaceEntries = entries.get(namespace);
			if(namespaceEntries== null){
				namespaceEntries= new LinkedHashSet<SimpleEntry<?, ?>>();
				entries.put(namespace, namespaceEntries);
			}
			
			LinkedHashSet<Object> namespaceTypes = types.get(namespace);
			if(namespaceTypes== null){
				namespaceTypes= new LinkedHashSet<Object>();
				types.put(namespace, namespaceTypes);
			}
			
			for(Object object: list){
				if(object instanceof SimpleEntry){
					namespaceEntries.add((SimpleEntry<?, ?>) object);
				}else{
					namespaceTypes.add(object);
				}
			}
		}
		
		String all= CommonConstants.BLANK;
		for(Object key: entries.keySet()){
			
			LinkedHashSet<SimpleEntry<?, ?>> linkedHashSet = entries.get(key);
			
			for(SimpleEntry<?, ?> entry: linkedHashSet){
				String contents= CommonConstants.BLANK;
				String begin = (String) entry.getKey();
				if(!begin.isEmpty()){
					contents= begin;
				}
				
				String end = (String) entry.getValue();
				if(!end.isEmpty()){
					if(contents.isEmpty()){
						contents= end;
					}else{
						contents= contents+ CommonConstants.NEW_LINE+ end;
					}
				}
				if(!contents.isEmpty()){
					if(!all.isEmpty()){
						all= all+ CommonConstants.NEW_LINE;
					}
					all= all+ contents;
				}
			}
		}
		
		if(all.isEmpty()){
			return all;
		}
		
		return generationValueGetter.generate(ICppDefinitions.INCOMPLETE_NAMESPACES_DEFNITION, element, all);
	}

	@GenerationPoint(generationPoint = ICppDefinitions.NAMESPACE_OPENING)
	public static Object openingNamespace(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopPath TreeMap<String, Object> path,
			@GenerationLoopElement Object modelPackage,
			@GenerationBaseElement Object element,
			@GenerationArgument boolean root){
		String namespace = namespace(generationValueGetter, path, modelPackage, element, root, CPPCommonConstants.BEGIN);
		
		if(namespace== null|| namespace.isEmpty()){
			return namespace;
		}
		return namespace+ CommonConstants.NEW_LINE;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.NAMESPACE_CLOSING)
	public static Object closingNamespace(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopPath TreeMap<String, Object> path,
			@GenerationLoopElement Object modelPackage,
			@GenerationBaseElement Object element,
			@GenerationArgument boolean root){
		return namespace(generationValueGetter, path, modelPackage, element, root, CPPCommonConstants.END);
	}

	private static String namespace(GenerationPolicyRegistry generationValueGetter,TreeMap<String, Object> path, Object modelPackage, 
			Object element, boolean root, String identifier) {
		if(root){
			String elementNamespace = generationValueGetter.getString(modelPackage, IModelingElementDefinitions.NAMESPACE);
			String modelNamespace = generationValueGetter.getString(element, IModelingElementDefinitions.NAMESPACE);
			
			if(elementNamespace== null){
				elementNamespace= CommonConstants.BLANK;
			}
			
			Object retrieeObject= elementNamespace.equals(modelNamespace)? modelPackage: element;
			
			List<Object> values = generationValueGetter.getValues(ICppDefinitions.NAMESPACE_OPENING, retrieeObject);
			if(values.isEmpty()){
				return null;
			}
			return values.get(0)+  CommonConstants.UNDERSCORE+ identifier.toUpperCase();
		}
		
		String definition= CommonConstants.BLANK;
		List<String> segments= new ArrayList<String>();
		for(String key: path.keySet()){
			Object object = path.get(key);
			if(modelPackage== object){
				continue;
			}
			List<Object> values = generationValueGetter.getValues(ICppDefinitions.NAMESPACE_OPENING, object);
			if(values.isEmpty()){
				continue;
			}
			segments.add((String) values.get(0));
		}
		
		Iterator<String> iterator = segments.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			
			if(iterator.hasNext()){
				next= next+ CommonConstants.UNDERSCORE;
			}
			definition= definition+ next;
		}
		
		if(definition.isEmpty()){
			return definition;
		}
		
		if(!definition.startsWith(CommonConstants.UNDERSCORE)){
			definition= CommonConstants.UNDERSCORE+ definition;
		}
		
		return definition+ CommonConstants.UNDERSCORE+ identifier.toUpperCase();
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.MODEL_PATH)
	public static String modelPath(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAMESPACE) String namespace,
			@GenerationLoopPath TreeMap<String, Object> loopPath,
			@GenerationLoopElement Object model){
		
		
		String expectedNamespace= namespace;
		if(expectedNamespace== null|| expectedNamespace.isEmpty()){
			expectedNamespace= generationValueGetter.getString(model, IModelingElementDefinitions.NAMESPACE);
		}
		
		List<String> list = new ArrayList<String>(loopPath.keySet());
		if(list.isEmpty()){
			if(expectedNamespace== null|| expectedNamespace.isEmpty()){
				return name.replace(CommonConstants.DOT, CommonConstants.FORWARD_SLASH);
			}
			return expectedNamespace;
		}
		
		if(expectedNamespace== null|| expectedNamespace.isEmpty()){
			expectedNamespace= generationValueGetter.getString(loopPath.get(list.get(0)), IModelingElementDefinitions.NAME);
		}
		
		String path= expectedNamespace;
		
		for(int index=1; index<list.size()-1; index++){
			Object object = loopPath.get(list.get(index));
			path= path+ CommonConstants.FORWARD_SLASH+ generationValueGetter.getString(object, IModelingElementDefinitions.NAME);
		}
		
		return path.replace(CommonConstants.DOT, CommonConstants.FORWARD_SLASH);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.DEFAULT_LANGUAGE_TYPE_VALUE, priority=IGenerationPointPriorityConstants.LOWEST, unique= true)
	public static String defaultCPPParameterValue(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_DEFAULT_VALUE) String defaultValue){
		if(defaultValue== null|| defaultValue.isEmpty()){
			if(CPPTypesConstants.BOOL.equals(typeName)){
				return Boolean.FALSE.toString();
			}else if(CPPTypesConstants.INTEGER.equals(typeName)){
				return String.valueOf(0);
			}
			return CPPCommonConstants.NULL;
		}
		return defaultValue;
	}
	
	@GenerationPoint(generationPoint= IModelingConstants.DEFAULT_VALUE_INTERCEPTOR, 
			intercept = {IModelingElementDefinitions.DEFAULT_VALUE}, priority=IGenerationPointPriorityConstants.LOWEST)
	public static InterceptorResponse normalizedDateDefaultValue(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@WatchedObjectValue String defaultValue){
		if(defaultValue!= null&& !defaultValue.isEmpty()){
			return null;
		}
		if(CPPTypesConstants.BOOL.equals(typeName)){
			return new InterceptorResponse(CPPTypesConstants.FALSE);
		}else if(CPPTypesConstants.INTEGER.equals(typeName)||CPPTypesConstants.LONG.equals(typeName)||CPPTypesConstants.FLOAT.equals(typeName)||
				CPPTypesConstants.DOUBLE.equals(typeName)){
			return new InterceptorResponse(String.valueOf(0));
		}
		return new InterceptorResponse(CPPCommonConstants.NULL);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_DEFAULT_VALUE)
	public static String normalizedDefaultValue(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationArguments Object... arguments) {
		return generationValueGetter.getString(element,IModelingElementDefinitions.DEFAULT_VALUE, CPPCommonConstants.CPP_LANGUAGE, arguments);
	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.DEFAULT_VALUE)
	public static String defaultValue(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationArguments Object... arguments) {
		return generationValueGetter.getString(element,true, IModelingElementDefinitions.DEFAULT_VALUE, 
				CPPCommonConstants.CPP_LANGUAGE, arguments);
	}
	
	@GenerationPoint(generationPoint = CPPCommonConstants.PACKAGE_SUFFIX)
	public static String addIncludeStatement(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		return generationValueGetter.generationPointString(modelPackage, IModelingConstants.ROOT_NAME)+ CPPCommonConstants.PACKAGE_SUFFIX;
	}
	
	@SuppressWarnings("unused")
	@GenerationPoint(generationPoint = IModelingConstants.ROOT_PATH)
	public static String rootPath(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingConstants.GENERATION_DIRECTORY) String generaionDirectory,
			@GenerationArgument(id= IModelingDecisions.MODEL_PATH) Object modelPath,
			@GenerationLoopElement Object modelPackage){
		
		String root= CommonConstants.BLANK;	//generationValueGetter.generationPointString(modelPackage, IModelingConstants.ROOT_NAME)
		if(generaionDirectory!= null&& !generaionDirectory.isEmpty()){
			if(!root.isEmpty()){
				root= root+ CommonConstants.FORWARD_SLASH;
			}
			root= root+ generaionDirectory;
		}
		
		if(modelPath!= null){
			if(!root.isEmpty()){
				root= root+ CommonConstants.FORWARD_SLASH;
			}
			root= root+ modelPath;
		}
		
		return root;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.ROOT_NAME)
	public static String rootName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		return generationValueGetter.getString(modelPackage, IModelingElementDefinitions.FILE);
//		String namespace = generationValueGetter.getString(modelPackage, ICppElementDefinitions.NAMESPACE);
//		if(namespace!= null&& !namespace.isEmpty()){
//			String[] split = namespace.split("\\."); //$NON-NLS-1$
//			if(split.length>0){
//				return split[0];
//			}
//			return namespace;
//		}
//		return generationValueGetter.getString(modelPackage, ICppElementDefinitions.NAME);
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE)
	public static boolean isPrimitiveType(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationArgument(id= IModelingConstants.NORMALIZED_TYPE_CRUD_TYPE_ARGUMENT) Object type,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object dependType){
		
		if((CPPTypesConstants.BASE_TYPES.contains(type)|| CPPTypesConstants.BASE_TYPES.contains(dependType)||
				CPPTypesConstants.BASE_TYPES.contains(typeName))){
			return true;
		}
		return false;
	}
	
	@DecisionPoint(decisionPoint = ICppDefinitions.IS_CONST_TYPE_PARAMETER)
	public static boolean isConstParameter(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationArgument(id= IModelingConstants.NORMALIZED_TYPE_CRUD_TYPE_ARGUMENT) Object type,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object dependType){
		return isPrimitiveType(typeName, type, dependType);
	}
	
	@DecisionPoint(decisionPoint = ICppDefinitions.IS_POINTER_TYPE)
	public static boolean isPointer(@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationArgument(id = IModelingConstants.NORMALIZED_TYPE_STRING) String typeString,
			@GenerationArgument(id= IModelingConstants.NORMALIZED_TYPE_CRUD_TYPE_ARGUMENT) Object type,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object dependType,
			@GenerationLoopElement Object modelPackage){
		
		//To be extended by clients for more cases
		if(!isPrimitiveType){
			//Only set pointers for the defined classes; otherwise, it will be the user's responsability to add custom primitive types or so to get it defined as pointers
			return !generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName).isEmpty()||
					(typeString!= null&& !typeString.isEmpty()&& !generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeString).isEmpty())||
					!generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, type).isEmpty()||
					!generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, dependType).isEmpty();
		}
		return !isPrimitiveType;
	}
	
	//For extension purposes
	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_NAME, priority= IGenerationPointPriorityConstants.LOWEST)
	public static String normalizedName(@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		return name;
	}
			
	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_TYPE_NAME)
	public static String typeName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationArgument(id = IModelingConstants.NORMALIZED_TYPE_STRING) String typeString,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = ICppDefinitions.IS_POINTER_TYPE) boolean isPointer,
			@GenerationBaseElement Object element,
			@GenerationArgument(id = IModelingConstants.NORMALIZED_TYPE_CRUD_TYPE_ARGUMENT) String crudType,
			@GenerationArgument(id = IModelingConstants.NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT) boolean isConstruction,
			@GenerationProcedureParameter(id = ICppDefinitions.IS_CONST_TYPE_PARAMETER) boolean _isConstParameter,
			@GenerationArgument(id = IModelingConstants.NORMALIZED_TYPE_AS_PARAMETER_ARGUMENT) boolean asParameter,
			@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationArgument boolean asType,
			@GenerationLoopElement Object modelPackage,
			@GenerationArguments Object... arguments){
		
		String normalizedType= typeString!= null&& !typeString.isEmpty()?typeString: typeName;
		boolean isConstParameter= false;
		
		setParameters: {
			if(crudType!=null && !crudType.isEmpty()){
				if(isPrimitiveType){
					normalizedType= crudType;
					break setParameters;
				}
				List<Object> allValues = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, crudType);
				if(!allValues.isEmpty()){
					Object object = allValues.get(0);
					isConstParameter= generationValueGetter.decisionPoint(object, ICppDefinitions.IS_CONST_TYPE_PARAMETER, arguments);
					break setParameters;
				}
				normalizedType= crudType;
			}
			isConstParameter= _isConstParameter;
		}
		
		//For primitive types (string, int, etc), we do not have pointer, but if they are many, we wrap the type in a vector and this vector must be a pointer
		//Therefore, enable pointer for the isMany case as well in order to handle that condition
		if(isMany&& !asType){
			//If type is for construction (i.e. new Type()), then, avoid pointer in the type string
			normalizedType = generationValueGetter.generate(ISTLConstants.TYPE_AS_LIST, element, Boolean.valueOf(!isConstruction));
		}else if(isPointer){
			normalizedType= normalizedType+ CommonConstants.ASTERISK;
		}
		
		if(asParameter&& isConstParameter){
			normalizedType= CPPCommonConstants.CONST_MODIFIER+ CommonConstants.SPACE+ normalizedType+ CPPCommonConstants.REFERENCE_OPERATOR;
		}
		
		return normalizedType;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_VISIBILITY, unique= true)
	public static String getNormalizedVisibility(@GenerationElementParameter(id = IModelingElementDefinitions.ELEMENT_VISIBILITY) String visibility){
		if(visibility== null|| !VisibilityConstants.PREDEFINED_VISIBILITIES.contains(visibility)){
			return VisibilityConstants.PRIVATE;
		}
		
		return visibility;
	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.OPERATION_BODY)
	public static String operationBody(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String all= CommonConstants.BLANK;
		
		all = all+ getContraintString(generationValueGetter, parent, element);
		
		if(!all.isEmpty()){
			all= all+ CommonConstants.NEW_LINE;
		}
		
		all= all+ generationValueGetter.getString(element, IModelingElementDefinitions.OPERATION_BODY, CPPCommonConstants.CPP_LANGUAGE);
		return all;
	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.CONSTRAINT_BODY)
	public static String getContraintString(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationBaseElement Object element) {
		String all= CommonConstants.BLANK;
		List<?> constraints= generationValueGetter.getList(element, IModelingElementDefinitions.CONSTRAINTS,
				GenerationArgumentDescriptor.arg(IModelingConstants.ROOT, parent));
		List<String> conditions= new ArrayList<String>();
		for(Object constraint: constraints){
			String current= generationValueGetter.generationPointString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS,constraint);
			if(current.isEmpty()){
				continue;
			}
			conditions.add(generationValueGetter.generationPointString(constraint, IModelingElementDefinitions.CONSTRAINT_CHECK_THROW, current, Boolean.TRUE));
		}
		
		Iterator<String> iterator = conditions.iterator();
		while(iterator.hasNext()){
			String condition = iterator.next();
			all+= condition;
			
			all= all+ CommonConstants.NEW_LINE;
			if(iterator.hasNext()){
				all= all+ CommonConstants.NEW_LINE;
			}
		}
		return all;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_RETURN_TYPE, unique= true)
	public static String getNormalizedReturnType(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.RETURN_TYPE) String returnType){
		return returnType==null? CPPTypesConstants.VOID:  
			generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME); 
	}
	
	@GenerationPoint(intercept = {IModelingElementDefinitions.RETURN_TYPE})
	public static InterceptorResponse returnTypeName(@WatchedObjectValue String typeName){
		if(typeName== null){
			return new InterceptorResponse(CPPTypesConstants.VOID);
		}
		return typeName(typeName);
	}
	
	@GenerationPoint(intercept = {IModelingElementDefinitions.TYPE_NAME, IModelingElementDefinitions.OTHER_END_TYPE_NAME, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_VALUE})
	public static InterceptorResponse typeName(@WatchedObjectValue String typeName){
		if(typeName== null){
			return new InterceptorResponse(CPPTypesConstants.VOID);
		}else if(CommonTypesConstants.CHARACTER.equals(typeName)){
			return new InterceptorResponse(CPPTypesConstants.CHAR);
		}else if(CommonTypesConstants.DOUBLE.equals(typeName)){
			return new InterceptorResponse(CPPTypesConstants.DOUBLE);
		}else if(CommonTypesConstants.FLOAT.equals(typeName)){
			return new InterceptorResponse(CPPTypesConstants.FLOAT);
		}else if(CommonTypesConstants.INTEGER.equals(typeName)){
			return new InterceptorResponse(CPPTypesConstants.INTEGER);
		}else if(CommonTypesConstants.BOOLEAN.toUpperCase().equals(typeName.toUpperCase())){
			return new InterceptorResponse(CPPTypesConstants.BOOL);
		} else if(typeName.equals("null")){ //$NON-NLS-1$
			return new InterceptorResponse(CPPCommonConstants.NULL);
		}
		
		return null;
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.DEPENDS_GENERATION_POINT, unique= true)
	public static boolean filterVoidAsIncludeStatement(@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object type) {
		if(CPPTypesConstants.VOID.equals(type)){
			//Filter "void" as it is a keyword in C++, and we should not have types defined by that keyword
			return true;
		}
		return false;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.TEMPLATES_DEFINITIONS)
	public static String threadImplementation(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object model) {
		return GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.TEMPLATES_DEFINITIONS, model);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.METHOD_CONTENTS_REGISTER, unique= true)
	public static void setMethodsDeclaraionDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_ABSTRACT) boolean isAbstract,
			@GenerationArgument(id= IModelingConstants.METHOD_ID_ARGUMENT) String id, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationArgument(id= IModelingConstants.METHOD_VISIBILITY_ARGUMENT) String visibility) {
		List<Object> values = generationValueGetter.getValues(id, element, visibility);
		for(Object entry: values){
			if(entry instanceof Map== false){
				continue;
			}
			
			@SuppressWarnings("unchecked")
			Map<String, Object> map= (Map<String, Object>) entry;
			
			Set<MethodDes> incomplete= new LinkedHashSet<MethodDes>();
			Set<MethodDes> complete= new LinkedHashSet<MethodDes>();
			boolean foundNonAbstract = inheritedCall(incomplete,complete, generationValueGetter, element, id, visibility);
			
			Object group = map.get(IModelingConstants.METHOD_GROUP);
			if(group== null){
				group= IModelingConstants.METHOD_DEFAUT_GROUP;
			}
			
			setOperation(id, map, generationValueGetter, complete, element, visibility, false);
			
			if(interfaceObject== null&& !isAbstract&& !foundNonAbstract){
				for(MethodDes descriptor: incomplete){
					setOperation(id, descriptor.fMap, generationValueGetter, complete, element, visibility, true);
				}
			}
		}
	}
	
	private static void setOperation(String id, Map<String, Object> map, GenerationPolicyRegistry generationValueGetter, Set<MethodDes> complete, Object element,
			String visibility, boolean isConcluded){
		Object returnType = map.get(IModelingConstants.METHOD_RETURN_TYPE);
		Object parametersString = map.get(IModelingConstants.METHOD_PARAMETERS_STRING);
		Object name = map.get(IModelingConstants.METHOD_NAME);
		
		Object codeBody = map.get(IModelingConstants.CODY_BODY);
		Object comments = map.get(IModelingConstants.METHOD_COMMENT);
		Object object = map.get(IModelingConstants.METHOD_OBJECT);
		Object isConstant = map.get(ICppDefinitions.METHOD_CONST);
		Object isVirtual = map.get(ICppDefinitions.METHOD_VIRTUAL);
		Object isPure = map.get(ICppDefinitions.METHOD_PURE);
		Object isStatic = map.get(ICppDefinitions.METHOD_STATIC);
		
		
		if(complete.contains(new MethodDes((String)returnType, (String)parametersString, (String)name, map))|| isConcluded){
			isVirtual= Boolean.TRUE;
		}
		
		if(object== null){
			object= CommonConstants.BLANK;
		}
		Object group = map.get(IModelingConstants.METHOD_GROUP);
		if(group== null){
			group= IModelingConstants.METHOD_DEFAUT_GROUP;
		}
		
		generationValueGetter.addUniqueValue(IModelingConstants.METHODS_GROUPS, group, element, visibility);
		
		generationValueGetter.addUniqueValue(IModelingConstants.METHODS_OBJECTS, object, element, visibility);
		
		String contents= CommonConstants.BLANK;
		if(!isConcluded){
			String before= generationValueGetter.generationPointString(object, ICppDefinitions.METHOD_IMPLEMENTATION_BEFORE,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, id),
					GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_CONST, isConstant),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, name));
			
			String after= generationValueGetter.generationPointString(object, ICppDefinitions.METHOD_IMPLEMENTATION_AFTER,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, id),
					GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_CONST, isConstant),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, name));
						
			if(!after.isEmpty()|| !before.isEmpty()){
				isConstant=Boolean.FALSE;
			}
			
			if(!after.isEmpty()){
				if(codeBody.toString().isEmpty()){
					if(after.startsWith(CommonConstants.NEW_LINE)){
						after= after.substring(CommonConstants.NEW_LINE.length());
					}
				}
			}
			
			contents= before;
			contents= contents+ codeBody;
			contents= contents+ after;
		}else{
			isPure= Boolean.FALSE;
			contents= contents+ codeBody;
		}
		
		String declaration = generationValueGetter.use(ICppDefinitions.METHOD_DECLARATION, returnType, name, parametersString,
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_STATIC, isStatic),
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_PURE, isPure),
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_VIRTUAL, isVirtual),
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_CONST, isConstant));
		
		if(isPure instanceof Boolean&& ((Boolean)isPure).booleanValue()){
			if(comments instanceof String&& !((String)comments).isEmpty()){
				declaration= comments+ CommonConstants.NEW_LINE+ declaration;
			}
			
			//Pure does not have implementation
			generationValueGetter.addUniqueValue(ICppDefinitions.HEADER_CONTENTS, new SimpleEntry<Object, Object>(map, declaration), 
					element, group, object, visibility);
			return;
		}
		
		generationValueGetter.addUniqueValue(ICppDefinitions.HEADER_CONTENTS, new SimpleEntry<Object, Object>(map, declaration), 
				element, group, object, visibility);
		
		String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		
		String qualifiedMethodName = generationValueGetter.use(ICppDefinitions.QUALIFIED_METHOD_NAME, parentName, name);
		String implementation = generationValueGetter.generate(ICppDefinitions.METHOD_IMPLEMENTATION, object,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONTENTS, contents),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, parametersString),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, id),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, returnType),
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_CONST, isConstant),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, qualifiedMethodName));
		if(comments instanceof String&& !((String)comments).isEmpty()){
			implementation= comments+ CommonConstants.NEW_LINE+ implementation;
		}
		
		generationValueGetter.addUniqueValue(ICppDefinitions.BODY_CONTENTS, new SimpleEntry<Object, Object>(map, implementation), element, group, object, visibility);
	}
	
	
	private static boolean inheritedCall(Set<MethodDes> incomplete, Set<MethodDes> complete, 
			GenerationPolicyRegistry generationValueGetter,
			Object element, String id, String visibility) {
		
		boolean foundNonAbstract= false;
		
		Set<Object> all= new LinkedHashSet<Object>();
		findAllParents(generationValueGetter, element, all);
		
		
		List<?> parentInterfaces= generationValueGetter.getList(element, IModelingConstants.PARENT_INTERFACES);
		
		for(Object parentObject: parentInterfaces){
			foundNonAbstract= foundNonAbstract| searchUnimplementedMethods(incomplete, complete, generationValueGetter, id, visibility, parentObject);
		}
		
		Object parentClass= generationValueGetter.getObject(element, IModelingConstants.PARENT_CLASS);
		boolean isAbstract = generationValueGetter.getBoolean(parentClass, IModelingElementDefinitions.IS_ABSTRACT);
		if(isAbstract){
			foundNonAbstract= foundNonAbstract|searchUnimplementedMethods(incomplete,complete, generationValueGetter, id, visibility, parentClass);
		}
		
		for(MethodDes des: complete){
			if(incomplete.contains(des)){
				incomplete.remove(des);
			}
		}
		
		return foundNonAbstract;
	}

	private static boolean searchUnimplementedMethods(Set<MethodDes> incomplete, Set<MethodDes> complete,
			GenerationPolicyRegistry generationValueGetter, String id,
			String visibility, Object current) {
		
		Set<Object> all= new LinkedHashSet<Object>();
		all.add(current);
		findAllParents(generationValueGetter, current, all);
		
		boolean foundNonAbstract= false;
		
		for(Object parentObject: all){
			List<Object> values = generationValueGetter.getValues(id, parentObject, visibility);
			for(Object entry: values){
				if(entry instanceof Map== false){
					continue;
				}
				
				@SuppressWarnings("unchecked")
				Map<String, Object> parentMap= (Map<String, Object>) entry;
				Object parentReturnType = parentMap.get(IModelingConstants.METHOD_RETURN_TYPE);
				Object parentParametersString = parentMap.get(IModelingConstants.METHOD_PARAMETERS_STRING);
				Object parentName = parentMap.get(IModelingConstants.METHOD_NAME);
				
				
				TreeMap<String, Object> pathMap = generationValueGetter.getPathMap(parentObject);
				boolean isClass= pathMap!= null&& pathMap.get(IModelingElementDefinitions.CLASSES_PROCESSOR)!= null;
				boolean isAbstract = generationValueGetter.getBoolean(parentObject, IModelingElementDefinitions.IS_ABSTRACT);
				
				if(isClass){
					if(!isAbstract){
						foundNonAbstract= true;
					}
				}
				
				
				MethodDes currentMethodDestricptor= new MethodDes((String)parentReturnType, 
						(String)parentParametersString, (String)parentName, parentMap);
				
				Object object = parentMap.get(IModelingConstants.METHOD_DEFAULTED_IMPLEMENTATION);
				if(object instanceof Boolean&& ((Boolean)object).booleanValue()){
					incomplete.add(currentMethodDestricptor);
				}else{
					complete.add(currentMethodDestricptor);
					
					if(incomplete.contains(currentMethodDestricptor)){
						incomplete.remove(currentMethodDestricptor);
					}
				}
			}
		}
		
		for(MethodDes des: complete){
			if(incomplete.contains(des)){
				incomplete.remove(des);
			}
		}
		return foundNonAbstract;
	}
	
	private static void findAllParents(GenerationPolicyRegistry generationValueGetter, Object element, Set<Object> all) {
		Object parentClass= generationValueGetter.getObject(element, IModelingConstants.PARENT_CLASS);
		List<?> parentInterfaces= generationValueGetter.getList(element, IModelingConstants.PARENT_INTERFACES);
		
		if(parentClass!= null){
			all.add(parentClass);
			findAllParents(generationValueGetter, parentClass, all);
		}
		
		if(!parentInterfaces.isEmpty()){
			all.addAll(parentInterfaces);
			for(Object parentInterface: parentInterfaces){
				findAllParents(generationValueGetter, parentInterface, all);
			}
		}
	}
	
	private static class MethodDes{
		String fReturnType;
		String fParametersString;
		String fMethodName;
		Map<String, Object> fMap;
		
		public MethodDes(String returnType, String parametersString, String methodName, Map<String, Object> map) {
			this.fReturnType= returnType;
			this.fParametersString= parametersString;
			this.fMethodName= methodName;
			
			this.fMap= map;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof MethodDes== false){
				return false;
			}
			
			MethodDes target= (MethodDes) obj;
			return this.fReturnType.equals(target.fReturnType)&& this.fParametersString.equals(target.fParametersString)&& this.fMethodName.equals(target.fMethodName);
		}
		
		@Override
		public int hashCode() {
			String all= this.fReturnType+ this.fParametersString+ this.fMethodName;
			return all.hashCode();
		}
	}

	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = IModelingConstants.METHOD_DETAILS, unique= true)
	public static String methodDetails(@GenerationRegistry final GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationArgument(id= IModelingConstants.METHOD_ID_ARGUMENT) String id, 
			@GenerationArgument(id= IModelingConstants.METHOD_VISIBILITY_ARGUMENT) String visibility,
			@GenerationArgument(id= IModelingConstants.METHOD_SEPARATOR_ARGUMENT) boolean separator) {
		List<Object> groups = generationValueGetter.getValues(IModelingConstants.METHODS_GROUPS, element, visibility);
		
		Collections.sort(groups, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				Integer priority1Object = generationValueGetter.generationPointInteger(o1, IModelingConstants.METHODS_GROUP_PRIORITY, 
						GenerationArgumentDescriptor.arg(IModelingConstants.GROUP_ID_ARGUMENT, o1));
				
				Integer priority2Object = generationValueGetter.generationPointInteger(o2, IModelingConstants.METHODS_GROUP_PRIORITY, 
						GenerationArgumentDescriptor.arg(IModelingConstants.GROUP_ID_ARGUMENT, o2));
				
				int priority1= priority1Object== null? -1: priority1Object.intValue();
				int priority2= priority2Object== null? -1: priority2Object.intValue();
				
				if(priority1== priority2){
					return 0;
				}
				
				return priority1>priority2?-1: 1;
			}
		});
		
		List<Object> objects = generationValueGetter.getValues(IModelingConstants.METHODS_OBJECTS, element, visibility);
		
		Iterator<Object> iterator = groups.iterator();
		List<String> strings= new ArrayList<String>();
		int totalLength= 0;
		while(iterator.hasNext()){
			Object group = iterator.next();
			List<Object> baseDeclarations = generationValueGetter.getValues(id, element, group, visibility);
			for(Object declaration: baseDeclarations){
				String newString = declaration+ CommonConstants.NEW_LINE;
				strings.add(newString);
				totalLength= totalLength+ newString.length();
			}
			
			Collections.sort(objects, new Comparator<Object>() {

				@Override
				public int compare(Object element1, Object element2) {
					TreeMap<String, Object> pathMap1 = generationValueGetter.getPathMap(element1);
					Object p1 = pathMap1== null? null: pathMap1.get(IModelingElementDefinitions.CLASSES_PROCESSOR);
					TreeMap<String, Object> pathMap2 = generationValueGetter.getPathMap(element2);
					Object p2 = pathMap2== null? null: pathMap2.get(IModelingElementDefinitions.CLASSES_PROCESSOR);
					return p1== p2?0: (p1== null? 1: -1);
				}
			});
			
			List<Object> visitedIds= new ArrayList<Object>();
			List<String> declarationValues= new ArrayList<String>();
			for(Object object: objects){
				List<Object> declarations = generationValueGetter.getValues(id, element, group, object, visibility);
				for(Object declaration: declarations){
					if(declaration instanceof String){
						declarationValues.add((String) declaration);
						continue;
					}
					
					if(declaration instanceof SimpleEntry== false){
						continue;
					}
					
					SimpleEntry<Object, Object> simpleEntry= (SimpleEntry<Object, Object>) declaration;
					
					HashMap<Object, Object> hashMap= (HashMap<Object, Object>) simpleEntry.getKey();
					
					Object currentMethodId = hashMap.get(IModelingConstants.METHOD_NAME).toString()+ hashMap.get(IModelingConstants.METHOD_PARAMETERS_STRING);
					if(visitedIds.contains(currentMethodId)){
						continue;
					}
					visitedIds.add(currentMethodId);
					declarationValues.add((String) simpleEntry.getValue());
				}
			}
			
			for(String value: declarationValues){
				if(value.isEmpty()){
					continue;
				}
				String newString = value+ CommonConstants.NEW_LINE;
				strings.add(newString);
				totalLength= totalLength+ newString.length();
				
				if(separator){
					strings.add(CommonConstants.NEW_LINE);
					totalLength= totalLength+ CommonConstants.NEW_LINE.length();
				}
			}
			
			if(!strings.isEmpty()){
				if(iterator.hasNext()&& !separator){
					strings.add(CommonConstants.NEW_LINE);
					totalLength= totalLength+ CommonConstants.NEW_LINE.length();
				}
			}
		}
		
		StringBuffer contents= new StringBuffer(totalLength);
		for(String string: strings){
			contents.append(string);
		}
		
		return contents.toString();
	}
	
	
	@GenerationPoint(generationPoint = IModelingConstants.METHOD_CONTENTS, unique= true)
	public static String getImplementationDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationArgument(id= IModelingConstants.METHOD_ID_ARGUMENT) String id, 
			@GenerationArgument(id= ICppDefinitions.METHOD_INLINE_ARGUMENT) boolean isinline,
			@GenerationArgument(id= IModelingConstants.METHOD_VISIBILITY_ARGUMENT) String visibility) {
		List<Object> values = generationValueGetter.getValues(id, element, visibility);
		String contents= CommonConstants.BLANK;
		
		Iterator<Object> iterator = values.iterator();
		while(iterator.hasNext()){
			Object entry = iterator.next();
			
			if(entry instanceof Map== false){
				continue;
			}
			
			@SuppressWarnings("unchecked")
			Map<String, Object> map= (Map<String, Object>) entry;
			
			Object returnType = map.get(IModelingConstants.METHOD_RETURN_TYPE);
			Object parametersString = map.get(IModelingConstants.METHOD_PARAMETERS_STRING);
			Object codeBody = map.get(IModelingConstants.CODY_BODY);
			Object name = map.get(IModelingConstants.METHOD_NAME);
			Object comment = map.get(IModelingConstants.METHOD_COMMENT);
			Object isConstant = map.get(ICppDefinitions.METHOD_CONST);
			
			String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
			
			String qualifiedMethodName = (String) (isinline? name: generationValueGetter.use(ICppDefinitions.QUALIFIED_METHOD_NAME, parentName, name));
			contents = contents+ generationValueGetter.generate(ICppDefinitions.METHOD_IMPLEMENTATION, element,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, returnType),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONTENTS, codeBody),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, parametersString),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, qualifiedMethodName),
					GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_CONST, isConstant))+ CommonConstants.NEW_LINE;
			
			if(comment instanceof String&& !((String)comment).isEmpty()){
				contents= comment+ CommonConstants.NEW_LINE+ contents;
			}
		}
		
		return contents;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.INCOMPLETE_TYPES_DEFNITION, priority= IGenerationPointPriorityConstants.HIGH)
	public static String enumsImplementation(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		String implementationAndSeparateDetails = GenerationUtil.getImplementationAndSeparateDetails(generationValueGetter,ICppDefinitions.ENUM_IMPLEMENTATION, 0, element);
		if(implementationAndSeparateDetails.isEmpty()){
			return implementationAndSeparateDetails;
		}
		return CommonConstants.NEW_LINE+ implementationAndSeparateDetails+ CommonConstants.NEW_LINE;
	}
	
	//////////////////////////////////////////////////////////////Experimental////////////////////////////////////////////////////////////////////////
	@LoopProcessorAnnotation(aspect= LoopAspectConstants.AFTER)
	public static void helperInclude(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = ICppDefinitions.PREDEFINED_TEMPLATES_FILE) String templateFile,
			@GenerationBaseElement Object model){
		if(templateFile== null|| templateFile.isEmpty()){
			return;
		}
		
		String fileName= templateFile +CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		
		String modelPath = generationValueGetter.generationPointString(model, IModelingConstants.ROOT_PATH,
				GenerationArgumentDescriptor.arg(IModelingConstants.GENERATION_LANGUAGE, CPPCommonConstants.CPP_LANGUAGE));
		
		String fullPath= !modelPath.isEmpty()? modelPath+ CommonConstants.FORWARD_SLASH+ templateFile: templateFile;
		
		String predefinedTemplatesContents = generationValueGetter.generate(ICppDefinitions.PREDEFINED_TEMPLATES_DEFINITIONS, model,
				GenerationArgumentDescriptor.arg(ICppDefinitions.FULL_PATH_ARGUMENT, fullPath));
		ContentsDescriptor contentsDescriptor = new ContentsDescriptor(predefinedTemplatesContents, 
				fileName, modelPath);
		generationValueGetter.addUniqueValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, contentsDescriptor);
		
		generationValueGetter.generationPointString(model, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, templateFile),
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, modelPath),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void classAndInterfaceProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = ICppDefinitions.PREDEFINED_TEMPLATES_FILE) String templateFile,
			@GenerationBaseElement Object model){
		
		if(templateFile.isEmpty()){
			return;
		}
		
		//Include template helper in both body and header files
		String modelPath = generationValueGetter.generationPointString(model, IModelingConstants.ROOT_PATH,
				GenerationArgumentDescriptor.arg(IModelingConstants.GENERATION_LANGUAGE, CPPCommonConstants.CPP_LANGUAGE));
		
		generationValueGetter.generationPointString(element, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, templateFile),
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, modelPath),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(element, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, templateFile),
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, modelPath),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
	}
	
	private static String bundleMain(String filePath, String modelPath, String fileName, String implementationDetailsNewContents) {
		String implementationDetails= implementationDetailsNewContents;
		if(GenerationUtil.SEPARATE_TEMPLATES_DEFINITIONS){
			try {
				String owingFolder= modelPath;
				String path = filePath + "/"; //$NON-NLS-1$
				 owingFolder= owingFolder.replace(".", "::").replace("::", "/"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				 String qualifiedPath = path+ owingFolder;
				 File folder = new File(qualifiedPath);
				 if (folder.exists()) {
					 File folderFile = new File(qualifiedPath+ "/"+ fileName); 	 //$NON-NLS-1$
					 if (folderFile.exists()) {
						 BufferedReader in = new BufferedReader(new FileReader(qualifiedPath+ "/"+ fileName)); //$NON-NLS-1$
						 String str;
						 while ((str = in.readLine()) != null) {
						     if (str.startsWith("#include")) {  //$NON-NLS-1$
						    	 if(!implementationDetails.isEmpty()){
						    		 implementationDetails= implementationDetails+ CommonConstants.NEW_LINE;
						    	 }
						    	 implementationDetails= implementationDetails+ str;
						     }
						 }
						 in.close();
					 }
				 }
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return implementationDetails;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PREDEFINED_TEMPLATES_FILE)
	public static String predefinedTemplateFile(){
		if(!GenerationUtil.SEPARATE_TEMPLATES_DEFINITIONS){
			return null;
		}
		
		return "TemplatesDefinitions"; //$NON-NLS-1$
	}
}