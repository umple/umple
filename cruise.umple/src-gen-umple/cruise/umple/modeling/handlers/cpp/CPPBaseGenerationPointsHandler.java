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
import cruise.umple.core.GenerationLoopAnnotation;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationLoopPath;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationCallback.WatchedObjectValue;
import cruise.umple.core.GenerationPoint.InterceptorResponse;
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
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		if(prefixes!= null&& prefixes.contains(CPPCommonConstants.STATIC_MODIFIER)){
			String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
			String implementation = generationValueGetter.generate(ICppDefinitions.DECLARE_IMPLEMENTATION, element,type, parentName, name, attributeValue);
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
			generationValueGetter.addValue(ICppDefinitions.ATTRIBUTE_EQUALITY_DECLARATION, equalityDeclaration, parent);
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
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_MANY) boolean isMany){
		return generationValueGetter.use(ICppDefinitions.ATTRIBUTE_EQUALITY_DECLARATION, 
				name, Boolean.valueOf(isMany));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ATTRIBUTE_EQUALITY,ifConditionIds=IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE, ifNotConditionIds=
			ICppDecisions.ATTRIBUTE_IS_MANY, unique= true)
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
	
	@GenerationPoint(generationPoint = ICppHandlerDefinitions.CLASS_DECLARATIONS)
	public static String getClassDeclarations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element){
		List<Object> all = generationValueGetter.getValues(IModelingDecisions.PARENT_CLASS_EXTENDS, element);
		if(all.isEmpty()){
			all= generationValueGetter.getValues(IModelingDecisions.INTERFACES_IMPLEMENTS, element);
		}else{
			all.addAll(generationValueGetter.getValues(IModelingDecisions.INTERFACES_IMPLEMENTS, element));
		}
		
		generationValueGetter.generationPointString(element, ICppHandlerDefinitions.CLASS_DECLARATIONS_EXTENSION, all);
		String parametersString= GenerationUtil.asStringParameters(all);
		
		return generationValueGetter.use(ICppDefinitions.CLASS_DEFINITION, name, parametersString);
	}
	
	@GenerationPoint(generationPoint = ICppHandlerDefinitions.PRE_PROCESSING_DEFINITION_NAME, priority=IGenerationPointPriorityConstants.LOWEST)
	public static String getDefinitionName(@GenerationProcedureParameter(id = IModelingConstants.FULL_PATH) String fullPath){
		return fullPath.replace(CommonConstants.DOT, CommonConstants.UNDERSCORE).
				replace(CommonConstants.FORWARD_SLASH, CommonConstants.UNDERSCORE).toUpperCase();
	}
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.TYPE_PARAMETER_NAME)
	public static String typeParameterName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_MANY) boolean isMany){
		return isMany? generationValueGetter.use(ICppNameConstants.VARIABLE_PARAMETER,name, Boolean.TRUE):
			generationValueGetter.use(ICppNameConstants.VARIABLE_PARAMETER, name);
	}
	
	@LoopProcessorAnnotation(aspect= LoopAspectConstants.FINALIZE)
	public static void modelAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object model){
		String contents = generationValueGetter.generate(ICppDefinitions.PACKAGE_HEADER, model);
		
		String modelPath = generationValueGetter.generationPointString(model, IModelingConstants.ROOT_PATH);
		String modelName= generationValueGetter.generationPointString(model, CPPCommonConstants.PACKAGE_SUFFIX);
		
		String fileName= modelName+	CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		ContentsDescriptor contentsDescriptor = new ContentsDescriptor(contents, fileName, modelPath);
		
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, contentsDescriptor);
	}
	
	@LoopProcessorAnnotation(aspect= LoopAspectConstants.FINALIZE)
	public static void modelPathsAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object model){
		
		String modelPath = generationValueGetter.generationPointString(model, IModelingConstants.ROOT_PATH);
		String implementationDetails = GenerationUtil.getImplementationDetails(generationValueGetter, CPPDependsPointsHandler.ALL_MODEL_INCLUDES_TRACKER, "Main"); //$NON-NLS-1$
		String generate = generationValueGetter.generate(ICppDefinitions.MAIN, model, implementationDetails);
		
		String fileName= "Main" +CommonConstants.DOT +CPPCommonConstants.BODY_FILE_EXTENSION; //$NON-NLS-1$
		ContentsDescriptor contentsDescriptor = new ContentsDescriptor(generate, fileName, modelPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, contentsDescriptor);
	}
	
	@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}, aspect= LoopAspectConstants.FINALIZE)
	public static void classAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingDecisions.MODEL_PATH) String path){
		
		String implementationContents = generationValueGetter.generate(ICppDefinitions.CLASS_BODY, element, Boolean.TRUE);
		String implementationFileName= name + CommonConstants.DOT +CPPCommonConstants.BODY_FILE_EXTENSION;
		
		ContentsDescriptor implementationContentsDescriptor = new ContentsDescriptor(implementationContents, implementationFileName, path);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, implementationContentsDescriptor);
		
		String headerContents = generationValueGetter.generate(ICppDefinitions.HEADER, element, Boolean.TRUE);
		String headerFileName= name + CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		
		ContentsDescriptor headerContentsDescriptor = new ContentsDescriptor(headerContents, headerFileName, path);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, headerContentsDescriptor);
	}
	
	
	@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR}, aspect= LoopAspectConstants.FINALIZE)
	public static void interfacesAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement Object modelPackage){
		String modelPath = generationValueGetter.generationPointString(modelPackage, IModelingDecisions.MODEL_PATH);
		String path= modelPath;
		
		String headerContents = generationValueGetter.generate(ICppDefinitions.HEADER, element);
		String headerFileName= name + CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		
		ContentsDescriptor headerContentsDescriptor = new ContentsDescriptor(headerContents, headerFileName, path);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, headerContentsDescriptor);
	
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
		
		
		Iterator<List<String>> iterator = namespaces.iterator();
		while(iterator.hasNext()){
			List<String> next = iterator.next();
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
					
					if(compareNamespace!= null&& !compareNamespace.isEmpty()){
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
		
		for(int index=0; index<roots.size(); index++){
			generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACES_ROOTS, 
					new SimpleEntry<Object, Object>(roots.get(index), objects.get(index)), model);
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
			normalizedNamespace= namespace.replace(CommonConstants.DOT, CPPCommonConstants.DECLARATION_COMMON_PREFIX);
			normalizedNamespace= normalizedNamespace+ CPPCommonConstants.DECLARATION_COMMON_PREFIX+ name;
		}else{
			normalizedNamespace= name;
		}
		return normalizedNamespace;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.DEFNIED_NAMESPACES_MACROS)
	public static String incompleteDefinitions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element) {
		return setPredefinedTypes(generationValueGetter, element);
	}

	private static String setPredefinedTypes(GenerationPolicyRegistry generationValueGetter, Object element) {
		List<Object> values = generationValueGetter.getAllValues(ICppDefinitions.INCOMPLETE_NAMESPACES_DEFNITION);
		
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
				namespaceEntries= new LinkedHashSet<SimpleEntry<?,?>>();
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
		if(namespace.isEmpty()){
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
			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue){
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
	
	@GenerationPoint(generationPoint = IModelingElementDefinitions.DEFAULT_VALUE)
	public static String setterFilters(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element) {
		return generationValueGetter.getString(element,IModelingElementDefinitions.DEFAULT_VALUE, CPPCommonConstants.CPP_LANGUAGE);
		
	}
	
	@GenerationPoint(generationPoint = CPPCommonConstants.PACKAGE_SUFFIX)
	public static String addIncludeStatement(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		return generationValueGetter.generationPointString(modelPackage, IModelingConstants.ROOT_NAME)+ CPPCommonConstants.PACKAGE_SUFFIX;
	}
	
	@SuppressWarnings("unused")
	@GenerationPoint(generationPoint = IModelingConstants.ROOT_PATH)
	public static String rootPath(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		return CommonConstants.BLANK;
//		return generationValueGetter.generationPointString(modelPackage, IModelingConstants.ROOT_NAME);
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
			@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object type){
		
		if((type!= null&& CPPTypesConstants.BASE_TYPES.contains(type))|| CPPTypesConstants.BASE_TYPES.contains(typeName)){
			return true;
		}
		return false;
	}
	
	@DecisionPoint(decisionPoint = ICppDefinitions.IS_POINTER_TYPE)
	public static boolean isPointer(@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType){
		//To be extended by clients for more cases
		return !isPrimitiveType;
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_TYPE_NAME)
	public static String typeName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = ICppDefinitions.IS_POINTER_TYPE) boolean isPointer,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationArgument boolean asType){
		
		String normalizedType= typeName;
		if(isPointer){
			normalizedType= normalizedType+ CommonConstants.ASTERISK;
		}
		
		//For primitive types (string, int, etc), we do not have pointer, but if they are many, we wrap the type in a vector and this vector must be a pointer
		//Therefore, enable pointer for the isMany case as well in order to handle that condition
		if(isMany&& !asType){
			normalizedType = generationValueGetter.use(ICppDefinitions.TYPE_AS_VECTOR, normalizedType, Boolean.TRUE);
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
	public static String operationBody(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element){
		return generationValueGetter.getString(element, IModelingElementDefinitions.OPERATION_BODY, CPPCommonConstants.CPP_LANGUAGE);
	}
	
	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_RETURN_TYPE, unique= true)
	public static String getNormalizedReturnType(@GenerationElementParameter(id = IModelingElementDefinitions.RETURN_TYPE) String returnType){
		return returnType==null? CPPTypesConstants.VOID: returnType; 
	}
	
	@GenerationPoint(intercept = {IModelingElementDefinitions.RETURN_TYPE})
	public static InterceptorResponse returnTypeName(@WatchedObjectValue String typeName){
		if(typeName== null){
			return new InterceptorResponse(CPPTypesConstants.VOID);
		}
		return typeName(typeName);
	}
	
	@GenerationPoint(intercept = {IModelingElementDefinitions.TYPE_NAME, IModelingElementDefinitions.OTHER_END_TYPE_NAME})
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
		}else if(CommonTypesConstants.BOOLEAN.equals(typeName)){
			return new InterceptorResponse(CPPTypesConstants.BOOL);
		} 
		return null;
	}
	
	
	@GenerationPoint(generationPoint = IModelingConstants.METHOD_CONTENTS_REGISTER, unique= true)
	public static void setMethodsDeclaraionDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationArgument(id= IModelingConstants.METHOD_ID_ARGUMENT) String id, 
			@GenerationArgument(id= IModelingConstants.METHOD_VISIBILITY_ARGUMENT) String visibility) {
		List<Object> values = generationValueGetter.getValues(id, element, visibility);
		for(Object entry: values){
			if(entry instanceof Map== false){
				continue;
			}
			
			@SuppressWarnings("unchecked")
			Map<String, Object> map= (Map<String, Object>) entry;
			Object returnType = map.get(IModelingConstants.RETURN_TYPE);
			Object parametersString = map.get(IModelingConstants.PARAMETERS_STRING);
			Object name = map.get(IModelingConstants.METHOD_NAME);
			Object codeBody = map.get(IModelingConstants.CODY_BODY);
			Object comments = map.get(IModelingConstants.METHOD_COMMENT);
			Object object = map.get(IModelingConstants.METHOD_OBJECT);
			Object isConstant = map.get(IModelingConstants.METHOD_CONST);
			
			if(object== null){
				object= CommonConstants.BLANK;
			}
			Object group = map.get(IModelingConstants.METHOD_GROUP);
			if(group== null){
				group= IModelingConstants.METHOD_DEFAUT_GROUP;
			}
			generationValueGetter.addUniqueValue(IModelingConstants.METHODS_GROUPS, group, element, visibility);
			generationValueGetter.addUniqueValue(IModelingConstants.METHODS_OBJECTS, object, element, visibility);
			
			generationValueGetter.generate(ICppDefinitions.METHOD_IMPLEMENTATION_BEFORE, element,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, id),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONST, isConstant),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, name));
			
			String before= generationValueGetter.generationPointString(object, ICppDefinitions.METHOD_IMPLEMENTATION_BEFORE,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, id),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONST, isConstant),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, name));
			
			String after= generationValueGetter.generationPointString(object, ICppDefinitions.METHOD_IMPLEMENTATION_AFTER,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, id),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONST, isConstant),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, name));
			
			if(after.contains("numberOfIds());")){
				System.out.println();
			}
			
			String contents= before;
			contents= contents+ codeBody;
			contents= contents+ after;
			
			if(!after.isEmpty()|| !before.isEmpty()){
				isConstant=Boolean.FALSE;
			}
			
			String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
			
			String qualifiedMethodName = generationValueGetter.use(ICppDefinitions.QUALIFIED_METHOD_NAME, parentName, name);
			String implementation = generationValueGetter.generate(ICppDefinitions.METHOD_IMPLEMENTATION, object, returnType, 
					qualifiedMethodName, parametersString, contents,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, id),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONST, isConstant),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, name));
			if(comments instanceof String&& !((String)comments).isEmpty()){
				implementation= comments+ CommonConstants.NEW_LINE+ implementation;
			}
			generationValueGetter.addUniqueValue(ICppDefinitions.BODY_CONTENTS, implementation, element, group, object, visibility);
			
			String declaration = generationValueGetter.use(ICppDefinitions.METHOD_DECLARATION, returnType, name, parametersString,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONST, isConstant));
			generationValueGetter.addUniqueValue(ICppDefinitions.HEADER_CONTENTS, declaration, element, group, object, visibility);
		}
	}
	
	
	@GenerationPoint(generationPoint = IModelingConstants.METHOD_DETAILS, unique= true)
	public static String methodDetails(@GenerationRegistry final GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationArgument(id= IModelingConstants.METHOD_ID_ARGUMENT) String id, 
			@GenerationArgument(id= IModelingConstants.METHOD_VISIBILITY_ARGUMENT) String visibility,
			@GenerationArgument(id= IModelingConstants.METHOD_SEPARATOR_ARGUMENT) boolean separator) {
		String declarationsContents= CommonConstants.BLANK;
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
		while(iterator.hasNext()){
			Object group = iterator.next();
			
			String newContents= CommonConstants.BLANK;
			List<Object> baseDeclarations = generationValueGetter.getValues(id, element, group, visibility);
			for(Object declaration: baseDeclarations){
				newContents= newContents+ declaration+ CommonConstants.NEW_LINE;
			}
			
			for(Object object: objects){
				List<Object> declarations = generationValueGetter.getValues(id, element, group, object, visibility);
				for(Object declaration: declarations){
					if(declaration instanceof String== false){
						continue;
					}
					
					String value= (String) declaration;
					if(value.isEmpty()){
						continue;
					}
					newContents= newContents+ value+ CommonConstants.NEW_LINE;
					if(separator){
						newContents= newContents+ CommonConstants.NEW_LINE;
					}
				}
			}
			if(!newContents.isEmpty()){
				declarationsContents= declarationsContents+ newContents;
				
				if(iterator.hasNext()&& !separator){
					declarationsContents= declarationsContents+ CommonConstants.NEW_LINE;
				}
			}
		}
		return declarationsContents;
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
			
			Object returnType = map.get(IModelingConstants.RETURN_TYPE);
			Object parametersString = map.get(IModelingConstants.PARAMETERS_STRING);
			Object codeBody = map.get(IModelingConstants.CODY_BODY);
			Object name = map.get(IModelingConstants.METHOD_NAME);
			Object comment = map.get(IModelingConstants.METHOD_COMMENT);
			Object isConstant = map.get(IModelingConstants.METHOD_CONST);
			
			String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
			
			String qualifiedMethodName = (String) (isinline? name: generationValueGetter.use(ICppDefinitions.QUALIFIED_METHOD_NAME, parentName, name));
			contents = contents+ generationValueGetter.generate(ICppDefinitions.METHOD_IMPLEMENTATION, element, returnType, 
					qualifiedMethodName, parametersString, codeBody,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, name),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONST, isConstant))+ CommonConstants.NEW_LINE;
			
			if(comment instanceof String&& !((String)comment).isEmpty()){
				contents= comment+ CommonConstants.NEW_LINE+ contents;
			}
		}
		
		return contents;
	}
	
}