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
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.IModelingPriorityHandler;
import cruise.umple.modeling.handlers.VisibilityConstants;


public class CPPContentsPointsHandler{

	@LoopProcessorAnnotations(aspect= LoopAspectConstants.AFTER, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void classInterfaceParentTypesProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, ICppDefinitions.PUBLIC_CONTENTS);
		generationValueGetter.generationPointString(element, ICppDefinitions.PRIVATE_CONTENTS);
		generationValueGetter.generationPointString(element, ICppDefinitions.PACKAGE_CONTENTS);
		generationValueGetter.generationPointString(element, ICppDefinitions.PROTECTED_CONTENTS);
	}
	
	////////////////////////////////////////////////////////////////OPERATIONS REGISTRY////////////////////////////////////////////////////////
	@GenerationPoint(generationPoint = ICppDefinitions.ATTRIBUTES_IMPLEMENTATION)
	public static String attributesImplementations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		String all= CommonConstants.BLANK;
		for(String visibility: VisibilityConstants.PREDEFINED_VISIBILITIES){
			String implementationDetails = GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.DECLARE_IMPLEMENTATION, 
					visibility, element);
			if(!all.isEmpty()&& !implementationDetails.isEmpty()){
				all= all+ CommonConstants.NEW_LINE;
			}
			all= all+ implementationDetails;
		}
		if(all.isEmpty()){
			return all;
		}
		
		return generationValueGetter.use(ICppDefinitions.ATTRIBUTES_IMPLEMENTATIONS, all);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS)
	public static void publicOperationsDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, IModelingConstants.OPERATIONS_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PROTECTED_CONTENTS)
	public static void protectedOperationsDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, IModelingConstants.OPERATIONS_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PROTECTED));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_CONTENTS)
	public static void privateOperationsDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, IModelingConstants.OPERATIONS_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PRIVATE));
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GenerationPoint(generationPoint = ICppDefinitions.VISIBILITY_BASED_CONTENTS, priority=IGenerationPointPriorityConstants.HIGHEST,
			group= IModelingPriorityHandler.PUBLIC_DETAILS)
	public static String getPublicContents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return visibilityContents(generationValueGetter, element, VisibilityConstants.PUBLIC, ICppDefinitions.PUBLIC_DECLARATIONS, 
				ICppDefinitions.PUBLIC_INLINE_CONTENTS);
	}

	@GenerationPoint(generationPoint = ICppDefinitions.VISIBILITY_BASED_CONTENTS, priority=IGenerationPointPriorityConstants.HIGHEST,
			group= IModelingPriorityHandler.PROTECTED_DETAILS)
	public static String getProtectedContents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return visibilityContents(generationValueGetter, element, VisibilityConstants.PROTECTED, ICppDefinitions.PROTECTED_DECLARATIONS, 
				ICppDefinitions.PROTECTED_INLINE_CONTENTS);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.VISIBILITY_BASED_CONTENTS, priority=IGenerationPointPriorityConstants.HIGHEST,
			group= IModelingPriorityHandler.PRIVATE_DETAILS)
	public static String getPrivateContents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return visibilityContents(generationValueGetter, element, VisibilityConstants.PRIVATE, ICppDefinitions.PRIVATE_DECLARATIONS, 
				ICppDefinitions.PRIVATE_INLINE_CONTENTS);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PACKAGE_VISIBILITY_CONTENTS, priority=IGenerationPointPriorityConstants.HIGHEST,
			group= IModelingPriorityHandler.PRIVATE_DETAILS)
	public static String getPackageContents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return generationValueGetter.use(ICppDefinitions.PACKAGE_DECLARATIONS,
				generationValueGetter.generationPointString(element, ICppDefinitions.PACKAGE_CONTENTS));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, priority=IGenerationPointPriorityConstants.HIGHEST, 
			group= IModelingPriorityHandler.CONSTRUCTOR_DETAILS, ifNotConditionIds= {IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER})
	public static void getClassConstructorDeclaration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationBaseElement Object element){
		
		
		if(interfaceObject!= null){
			String declaration= generationValueGetter.use(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_NO_IMPLEMENTATION); 

			generationValueGetter.addUniqueValue(ICppDefinitions.HEADER_CONTENTS, declaration, element, 
					IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PUBLIC);
			return;
		}
		
		List<Object> parametersObjects = getParametersObjects(generationValueGetter, element);
		List<Object> parentParameters = getParametersRecursively(generationValueGetter, generationValueGetter.getObject(element, IModelingConstants.PARENT_CLASS));
		
		
		Set<Object> filtered= new LinkedHashSet<Object>(parentParameters);
		filtered.addAll(parametersObjects);
		
		
		List<Object> all= new ArrayList<Object>(filtered);
		
		String allParameters= generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS_IMPLEMENTATION, all);
		
		String declaration = generationValueGetter.use(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_DECLARATION, name, allParameters);
		
		String allContents = GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PRE_IMPLEMENTATION, 0, 0, element);
		
		String parentParametersString= GenerationUtil.asStringParameters(getParametersAsStringList(parentParameters));
		String parentClassName= null;
		Object parentClass = generationValueGetter.getObject(element, IModelingConstants.PARENT_CLASS);
		if(parentClass!= null){
			parentClassName= generationValueGetter.getString(parentClass, IModelingElementDefinitions.NAME);
		}
		String attributesImplementation = GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, 0, 0, element, Boolean.TRUE);
		if(!attributesImplementation.isEmpty()){
			if(!allContents.isEmpty()){
				allContents= allContents+ CommonConstants.NEW_LINE;
			}
			allContents = allContents+ attributesImplementation;
		}
		
		String associationsImplementation = GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, 0, 0, element, Boolean.FALSE);
		if(!associationsImplementation.isEmpty()){
			if(!allContents.isEmpty()){
				allContents= allContents+ CommonConstants.NEW_LINE;
			}
			allContents = allContents+ associationsImplementation;
		}
		
		if(!allContents.isEmpty()){
			allContents= StringUtil.indent(allContents, 1);
		}
		
		String constructor = generationValueGetter.generate(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION,element, 
				name, allParameters, allContents, parentClassName, parentParametersString);
		
		addBaseDeclaration(generationValueGetter, element, IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PUBLIC, 
				declaration, constructor);
	}

	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, priority=IGenerationPointPriorityConstants.HIGH, 
			group= IModelingPriorityHandler.CONSTRUCTOR_DETAILS, ifNotConditionIds= {IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_FILTER})
	public static void getClassCopyConstructorDeclaration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationBaseElement Object element){
		
		String deepCopyDeclaration = generationValueGetter.generate(ICppDefinitions.DEEP_COPY_METHOD_DECLARATION, element);
		String deepCopyImplementation= generationValueGetter.generate(ICppDefinitions.DEEP_COPY_METHOD_IMPLEMENTATION, element);
		
		if(interfaceObject!= null){
			String declaration= generationValueGetter.use(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_NO_IMPLEMENTATION); 

			generationValueGetter.addUniqueValue(ICppDefinitions.HEADER_CONTENTS, declaration, element, 
					IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PUBLIC);
			
			addBaseDeclaration(generationValueGetter, element, IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PRIVATE, 
					deepCopyDeclaration, deepCopyImplementation);
			
			return;
		}
		
		String copy = generationValueGetter.use(IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_DECLARATION, name);
		String contents = GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_IMPLEMENTATION, 0, 1, element);
		
		String parentClassName= null;
		Object parentClass = generationValueGetter.getObject(element, IModelingConstants.PARENT_CLASS);
		if(parentClass!= null){
			parentClassName= generationValueGetter.getString(parentClass, IModelingElementDefinitions.NAME);
		}
		
		String copyConstructor = generationValueGetter.generate(IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_IMPLEMENTATION, element,
				name, parentClassName);
		
		deepCopyImplementation= generationValueGetter.generate(ICppDefinitions.DEEP_COPY_METHOD_IMPLEMENTATION, element, contents);
		
		addBaseDeclaration(generationValueGetter, element, IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PRIVATE, 
				deepCopyDeclaration, deepCopyImplementation);
		
		addBaseDeclaration(generationValueGetter, element, IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PUBLIC, 
				copy, copyConstructor);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static void getClassConstructorPrintDeclaration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationBaseElement Object element){
		String print = generationValueGetter.use(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_DECLARATION, name);
		String printImplementation = generationValueGetter.use(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_IMPLEMENTATION, name);
		addBaseDeclaration(generationValueGetter, element, IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PUBLIC, 
				print, printImplementation);
		
		
		List<Object> values = generationValueGetter.getValues(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_IMPLEMENTATION, element, Boolean.TRUE);
		
		String parentClassName= null;
		Object parentClass = generationValueGetter.getObject(element, IModelingConstants.PARENT_CLASS);
		if(parentClass!= null){
			parentClassName= generationValueGetter.getString(parentClass, IModelingElementDefinitions.NAME);
		}
		
		String all= CommonConstants.BLANK;
		
		//Interfaces will have empty print stream.
		if(interfaceObject== null){
			all = values.isEmpty()? CommonConstants.BLANK: getValues(generationValueGetter, values, false);
			
			List<Object> properties = generationValueGetter.getValues(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_IMPLEMENTATION, element, Boolean.FALSE);
			if(!properties.isEmpty()){
				all= all+ CommonConstants.NEW_LINE+ CommonConstants.NEW_LINE;
			}
			
			Iterator<Object> iterator = properties.iterator();
			while(iterator.hasNext()){
				Object property = iterator.next();
				all= all+ getValues(generationValueGetter, Arrays.asList(new Object[]{property}), true);
				if(iterator.hasNext()){
					all= all+ CommonConstants.NEW_LINE;
				}
			}
			
			String helperMethodName= generationValueGetter.use(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_METHOD_NAME);
			
			String implementationDetails= generationValueGetter.generationPointString(element, ICppDefinitions.METHOD_PARENT_CALL, 
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, helperMethodName),
					GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_PARAMAETERS_ARGUMENT, 
					generationValueGetter.use(IModelingConstructorDefinitionsConstants.STREAM_IDENTIFIER)));
			
			if(!implementationDetails.isEmpty()){
				all= implementationDetails+ CommonConstants.NEW_LINE+ all;
			}
		}
		
		
		String helperDeclaration = generationValueGetter.use(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_DECLARATION);
		String helperImplementation = generationValueGetter.generate(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION, element,
				name, all, parentClassName);
		
		addBaseDeclaration(generationValueGetter, element, IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PROTECTED, 
				helperDeclaration, helperImplementation);
	}

	private static String getValues(GenerationPolicyRegistry generationValueGetter, List<Object> values, boolean isProprty) {
		List<Object> allValues= new ArrayList<Object>();
		
		String begin= generationValueGetter.use(IModelingConstructorDefinitionsConstants.STREAM_IDENTIFIER); 
		
		if(!isProprty){
			begin= begin+ generationValueGetter.use(IModelingConstructorDefinitionsConstants.STREAM_VALUE, 
					CommonConstants.OPEN_BRACKET, Boolean.TRUE, Boolean.TRUE)+ CommonConstants.SPACE;
		}else{
			begin= generationValueGetter.use(IModelingConstructorDefinitionsConstants.STREAM_VALUE, begin,
					Boolean.FALSE, Boolean.TRUE, Boolean.TRUE)+ CommonConstants.SPACE;
		}
		
		allValues.add(begin);
		allValues.addAll(values);
		
		int length=0;
		int max= 2;
		String all= CommonConstants.BLANK;
		
		Iterator<Object> iterator = allValues.iterator();
		while(iterator.hasNext()){
			String content= (String) iterator.next();
			
			if(iterator.hasNext()&& !all.isEmpty()){
				content= content+ generationValueGetter.use(IModelingConstructorDefinitionsConstants.STREAM_VALUE, CommonConstants.COMMA_SEPARATOR, 
						Boolean.TRUE, Boolean.TRUE); 
			}
			
			if(length== max){
				content= content+ CommonConstants.NEW_LINE;
				length= 0;
			}else{
				length++;
			}
			all= all+ content;
		}
		
		if(values.size()>1){
			all= all+ generationValueGetter.use(IModelingConstructorDefinitionsConstants.STREAM_VALUE, CommonConstants.CLOSE_BRACKET, Boolean.TRUE, Boolean.FALSE);
		}
		
		if(!isProprty){
			all= all+ generationValueGetter.use(IModelingConstructorDefinitionsConstants.STREAM_NEW_LINE);
			all= all+ CommonConstants.SEMI_COLON;
		}
		
		return all;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, priority=IGenerationPointPriorityConstants.MEDIUM, 
			group= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static void getClassDestructorDeclaration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationBaseElement Object element){
		
		Boolean isPure= Boolean.valueOf(interfaceObject!= null);
		
		String destructor = generationValueGetter.use(IModelingConstructorDefinitionsConstants.DESTRUCTOR_DECLARATION, name,
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_PURE, isPure));
		
		String parentClassName= null;
		Object parentClass = generationValueGetter.getObject(element, IModelingConstants.PARENT_CLASS);
		if(parentClass!= null){
			parentClassName= generationValueGetter.getString(parentClass, IModelingElementDefinitions.NAME);
		}
		
		String contents= isPure.booleanValue()?generationValueGetter.use(IModelingConstants.NO_IMPLEMENTATION):
			GenerationUtil.getImplementationAndIndentDetails(generationValueGetter,  IModelingConstructorDefinitionsConstants.DESTRUCTOR_IMPLEMENTATION, 0, 1, element);
		
		String implementationContents = generationValueGetter.use(IModelingConstructorDefinitionsConstants.DESTRUCTOR_IMPLEMENTATION, 
				name, parentClassName, contents, isPure);
		
		addBaseDeclaration(generationValueGetter, element, IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PUBLIC, 
				destructor, implementationContents);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////PREDEFINED OPERATORS////////////////////////////////////////////////////////////////////////////////
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, priority=IGenerationPointPriorityConstants.HIGHEST, 
			group= IModelingPriorityHandler.PRE_DEFINED_DETAILS)
	public static void predefinedCalls(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		List<Object> declarations= new ArrayList<Object>();
		List<Object> implementations= new ArrayList<Object>();
		
		
		for(Object object: generationValueGetter.getValues(ICppDefinitions.PREDEFINED_OPERATORS_REGISTER, element)){
			if(object instanceof SimpleEntry== false){
				continue;
			}
			SimpleEntry<?, ?> entry= (SimpleEntry<?, ?>) object;
			declarations.add(entry.getKey());
			implementations.add(entry.getValue());
		}
		
		String declaration= GenerationUtil.listToGeneratedString(1, 0, declarations);
		String implementation= GenerationUtil.listToGeneratedString(1, 0, implementations);
		
		declaration= generationValueGetter.use(ICppDefinitions.PREDEFINED_OPERATORS_DECLARATION, declaration);
		implementation= generationValueGetter.use(ICppDefinitions.PREDEFINED_OPERATORS_IMPLEMENTATION, implementation);
		
		generationValueGetter.addUniqueValue(ICppDefinitions.HEADER_CONTENTS, declaration, element, 
				IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PUBLIC);

		generationValueGetter.addUniqueValue(ICppDefinitions.BODY_CONTENTS, implementation, element, 
				IModelingConstants.METHOD_PRE_DEFINED_GROUP, VisibilityConstants.PUBLIC);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PREDEFINED_OPERATORS_REGISTER, priority=IGenerationPointPriorityConstants.HIGHEST)
	public static void predefineOperatorRegister(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String typeName,
			@GenerationBaseElement Object element){
		
		String operators = generationValueGetter.generate(ICppDefinitions.ATTRIBUTE_EQUALITY_OPERATOR_DECLARATION, element);
		
		String results= GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.ATTRIBUTE_EQUALITY_ENTRY, element);
		String predefined = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_EQUALITY_OPERATOR_IMPLEMENTATION, typeName, results);
		
		generationValueGetter.addUniqueValue(ICppDefinitions.PREDEFINED_OPERATORS_REGISTER, 
				new SimpleEntry<String, String>(operators, predefined), element);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PREDEFINED_OPERATORS_REGISTER, priority=IGenerationPointPriorityConstants.HIGHEST)
	public static void assignmentOperatorRegister(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		String assignmentDeclaration= generationValueGetter.generate(ICppDefinitions.ASSIGNMENT_OPERATOR_DECLARATION, element);
		String assignmentImplementation= generationValueGetter.generate(ICppDefinitions.ASSIGNMENT_OPERATOR_IMPLEMENTATION, element);
		
		generationValueGetter.addUniqueValue(ICppDefinitions.PREDEFINED_OPERATORS_REGISTER, 
				new SimpleEntry<String, String>(assignmentDeclaration, assignmentImplementation), element);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.HELPER_CODES)
	public static String getPredefinedContents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		return GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.HELPER_CODES, modelPackage);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.HELPER_INCLUDES)
	public static String helperIncludes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		return GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.HELPER_INCLUDES, modelPackage);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PACKAGE_INCLUDES)
	public static String packageIncludes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		return generationValueGetter.generationPointString(modelPackage, ICppDefinitions.BODY_INCLUDES);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////DELETED ASSOCIATED OBJECTS/////////////////////////////////////////////////////////////////////////
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_CONTENTS, priority=IGenerationPointPriorityConstants.LOWEST,
			group= IModelingPriorityHandler.REMOVE_ASSOCIATED_OBJECTS)
	public static void getDeleteAssociatedObjects(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationBaseElement Object element){
		Boolean isPure= Boolean.valueOf(interfaceObject!= null);
		
		String deleteMethodName = generationValueGetter.use(ICppNameConstants.DELETE_METHOD);
		
		String implementationDetails;
		
		if(isPure.booleanValue()){
			implementationDetails= StringUtil.indent(generationValueGetter.use(IModelingConstants.NO_IMPLEMENTATION), 1);
		}else{
			List<Object> values = generationValueGetter.getValues(IModelingConstants.REMOVE_ASSOCIATED_OBJECTS, element);
			implementationDetails= generationValueGetter.generationPointString(element, ICppDefinitions.METHOD_PARENT_CALL, 
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, deleteMethodName),
					GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_PARAMAETERS_ARGUMENT, CommonConstants.BLANK));
			
			if(!implementationDetails.isEmpty()){
				implementationDetails= StringUtil.indent(implementationDetails, 1);
			}
					
			implementationDetails= implementationDetails+ GenerationUtil.listToGeneratedString(0, 1, values);
		}
		
		String declaration = generationValueGetter.use(ICppDefinitions.METHOD_DECLARATION, CPPTypesConstants.VOID, deleteMethodName, CPPTypesConstants.VOID,
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_PURE, isPure),
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_VIRTUAL, Boolean.TRUE));
		
		String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		
		String qualifiedMethodName = generationValueGetter.use(ICppDefinitions.QUALIFIED_METHOD_NAME, parentName, deleteMethodName);
		String implementation = generationValueGetter.generate(ICppDefinitions.METHOD_IMPLEMENTATION, element, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONTENTS, implementationDetails),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, CPPTypesConstants.VOID),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, qualifiedMethodName));
		
		addBaseDeclaration(generationValueGetter, element, IModelingConstants.METHOD_FINALIZE_GROUP, VisibilityConstants.PUBLIC, 
				declaration, implementation);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_CONTENTS, priority=IGenerationPointPriorityConstants.LOWEST,
			group= ICppModelingPriorityHandler.HASH_CODE)
	public static void hashcode(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationBaseElement Object element){
		
		Boolean isVirtual= Boolean.valueOf(interfaceObject!= null);
		
		String hashCodeMethodName = generationValueGetter.use(ICppDefinitions.HASH_CDOE_METHOD_NAME);
		
		String implementationDetails= isVirtual.booleanValue()?generationValueGetter.use(IModelingConstants.NO_IMPLEMENTATION):
			generationValueGetter.use(ICppDefinitions.HASH_CDOE_IMPLEMENTATION);
		implementationDetails= StringUtil.indent(implementationDetails, 1);
				
		String declaration = generationValueGetter.use(ICppDefinitions.METHOD_DECLARATION, CPPTypesConstants.SIZE_T, hashCodeMethodName, 
				CPPTypesConstants.VOID,
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_PURE, isVirtual),
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_VIRTUAL, Boolean.TRUE));
		String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		
		String qualifiedMethodName = generationValueGetter.use(ICppDefinitions.QUALIFIED_METHOD_NAME, parentName, hashCodeMethodName);
		
		String implementation = isVirtual.booleanValue()?null:CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppDefinitions.METHOD_IMPLEMENTATION, element,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.SIZE_T),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONTENTS, implementationDetails),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, CPPTypesConstants.VOID),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, qualifiedMethodName));
		addBaseDeclaration(generationValueGetter, element, IModelingConstants.METHOD_FINALIZE_GROUP, VisibilityConstants.PUBLIC, 
				declaration, implementation);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@GenerationPoint(generationPoint = ICppDefinitions.PREDEFINED_PACKAGE_CONTENTS)
	public static String predefined(@GenerationRegistry GenerationPolicyRegistry generationValueGetter){
		return generationValueGetter.use(ICppDefinitions.PREDEFINED_FUNCTIONS);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PREDEFINED_PACKAGE_CONTENTS)
	public static String singletonHelper(@GenerationRegistry GenerationPolicyRegistry generationValueGetter){
		return GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.PREDEFINED_FUNCTIONS);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.CLASS_GLOBAL)
	public static String friendSetterDeclarations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.FRIEND_SETTER_DECLARATION, element);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.CONSTRUCTOR_ALL_PARAMETERS_LIST)
	public static List<Object> getParametersRecursively(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element) {
		Object current= element;
		List<Object> all= new ArrayList<Object>();
		List<Object> path= new ArrayList<Object>(); 
		while(current!= null){
			path.add(current);
			current= generationValueGetter.getObject(current, IModelingConstants.PARENT_CLASS);
		}
		
		Collections.reverse(path);
		
		for(Object object: path){
			List<Object> parametersObjects = getParametersObjects(generationValueGetter, object);
			if(!parametersObjects.isEmpty()){
				all.addAll(parametersObjects);
			}
		}
		
		return all;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.CONSTRUCTOR_PARAMETERS_LIST)
	public static List<Object> getParametersObjects(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element) {
		List<Object> values = generationValueGetter.getValues(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS, element, Boolean.TRUE);
		List<Object> all = new ArrayList<Object>(values);
		if(all.isEmpty()){
			all= generationValueGetter.getValues(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS, element, Boolean.FALSE);
		}else{
			all.addAll(generationValueGetter.getValues(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS, element, Boolean.FALSE));
		}
		return all;
	}
	
	private static String getAttributesDeclaraionDetails(GenerationPolicyRegistry generationValueGetter, Object element,String id, String visibility) {
		List<Object> values = generationValueGetter.getValues(id, visibility, element);
		
		String contents= CommonConstants.BLANK;
		for(Object entry: values){
			contents = contents+ entry+ CommonConstants.NEW_LINE;
		}
		
		if(!contents.isEmpty()){
			String comments = generationValueGetter.generate(id+ ICppDefinitions.COMMENTS_SUFFIX, element);
			if(!comments.isEmpty()){
				contents= comments+ CommonConstants.NEW_LINE+ contents;
			}
			contents= contents+ CommonConstants.NEW_LINE;
		}
		
		return contents;
	}
	
	//////////////////////////////////////////////////////PUBLIC DECLARATIONS/////////////////////////////////////////////////////////////////////////////////////////
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_DECLARATIONS, group= IModelingPriorityHandler.STATC_ATTRIBUTES)
	public static String publicStaicAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.STATIC_ATTRIBUTE_DECLARATIONS, VisibilityConstants.PUBLIC);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_DECLARATIONS, group= IModelingPriorityHandler.ASSOCIATIONS_ATTRIBUTES)
	public static String publicAssociationAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.ASSOCIATIONS_DECLARATION, VisibilityConstants.PUBLIC);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_DECLARATIONS, group= IModelingPriorityHandler.HELPER_ATTRIBUTES)
	public static String publicHelperAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.HELPER_ATTRIBUTES_DECLARATION, VisibilityConstants.PUBLIC);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_DECLARATIONS, group= IModelingPriorityHandler.STATC_ATTRIBUTES)
	public static String privateStaicAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.STATIC_ATTRIBUTE_DECLARATIONS, VisibilityConstants.PRIVATE);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_DECLARATIONS, group= IModelingPriorityHandler.ASSOCIATIONS_ATTRIBUTES)
	public static String privateAssociationAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.ASSOCIATIONS_DECLARATION, VisibilityConstants.PRIVATE);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_DECLARATIONS, group= IModelingPriorityHandler.HELPER_ATTRIBUTES)
	public static String privateHelperAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.HELPER_ATTRIBUTES_DECLARATION, VisibilityConstants.PRIVATE);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_DECLARATIONS, group= IModelingPriorityHandler.ATTRIBUTES)
	public static String privateAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.ATTRIBUTES_DECLARATION, VisibilityConstants.PRIVATE);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PROTECTED_DECLARATIONS, group= IModelingPriorityHandler.STATC_ATTRIBUTES)
	public static String protectedStaicAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.STATIC_ATTRIBUTE_DECLARATIONS, VisibilityConstants.PROTECTED);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PROTECTED_DECLARATIONS, group= IModelingPriorityHandler.ASSOCIATIONS_ATTRIBUTES)
	public static String protectedAssociationAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.ASSOCIATIONS_DECLARATION, VisibilityConstants.PROTECTED);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PROTECTED_DECLARATIONS, group= IModelingPriorityHandler.HELPER_ATTRIBUTES)
	public static String protectedHelperAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.HELPER_ATTRIBUTES_DECLARATION, VisibilityConstants.PROTECTED);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PROTECTED_DECLARATIONS, group= IModelingPriorityHandler.ATTRIBUTES)
	public static String protectedAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.ATTRIBUTES_DECLARATION, VisibilityConstants.PROTECTED);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_INLINE_CONTENTS, priority= IGenerationPointPriorityConstants.HIGHEST, 
			group= ICppModelingPriorityHandler.INLINE_FUNCTIONS)
	public static String minimumNumberOf(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, IModelingConstants.MINIMUM_NUMBER_OF),
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_INLINE_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}

	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_INLINE_CONTENTS, priority= IGenerationPointPriorityConstants.HIGHEST, 
			group= ICppModelingPriorityHandler.INLINE_FUNCTIONS)
	public static String maximumNumberOf(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS,
				GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_INLINE_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, IModelingConstants.MAXIMUM_NUMBER_OF),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_DECLARATIONS, group= IModelingPriorityHandler.ATTRIBUTES)
	public static String publicAttributesDeclarations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppDefinitions.ATTRIBUTES_DECLARATION, VisibilityConstants.PUBLIC);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.ADD)
	public static void addDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.ADD_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.ADD_AT)
	public static void addAtDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.ADD_AT_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.ADD_OR_MOVE_AT)
	public static void addOrMoveAtDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.ADD_OR_MOVE_AT_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.SETTER)
	public static void setterDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.GETTER)
	public static void getterDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.GETTER)
	public static void getterManyDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.GETTER_MANY_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.GETTER_BY_INDEX)
	public static void getterByIndexDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.GETTER_BY_INDEX_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.NUMBER_OF)
	public static void numberOfDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.NUMBER_OF_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.CONTAINS)
	public static void containsDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.CONTAINS_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.INDEX_OF)
	public static void indexOfDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.INDEX_OF_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.REMOVE)
	public static void removeDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.REMOVE_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingPriorityHandler.REMOVE_AT)
	public static void removeAtDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppAssociationsDefinitionsConstants.REMOVE_AT_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_IMPLEMENTATION, priority= IGenerationPointPriorityConstants.HIGHEST)
	public static String friendSetterImplementations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.FRIEND_SETTER_IMPLEMENTATION, element);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_IMPLEMENTATION)
	public static String publicImplementation(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return generationValueGetter.generationPointString(element, IModelingConstants.METHOD_DETAILS,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppDefinitions.BODY_CONTENTS),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_SEPARATOR_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_IMPLEMENTATION)
	public static String protectedImplementation(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return generationValueGetter.generationPointString(element, IModelingConstants.METHOD_DETAILS,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppDefinitions.BODY_CONTENTS),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_SEPARATOR_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PROTECTED));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_IMPLEMENTATION)
	public static String privateImplementation(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return generationValueGetter.generationPointString(element, IModelingConstants.METHOD_DETAILS,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppDefinitions.BODY_CONTENTS),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_SEPARATOR_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PRIVATE));
	}
	
	private static String visibilityContents(final GenerationPolicyRegistry generationValueGetter, Object element,
			String visibility, String attributesDeclarationdId, String inlineContentsId) {
		
		String declarationsContents= CommonConstants.BLANK;
		
		String attributes = generationValueGetter.generationPointString(element, attributesDeclarationdId);
		if(!attributes.isEmpty()){
			declarationsContents= declarationsContents+ attributes;
		}
		
		String inlineContents = generationValueGetter.generationPointString(element, inlineContentsId);
		
		if(!inlineContents.isEmpty()){
			if(!declarationsContents.isEmpty()){
				declarationsContents= declarationsContents+ CommonConstants.NEW_LINE;
			}
			declarationsContents= declarationsContents+ inlineContents;
		}
		
		if(!declarationsContents.isEmpty()){
			declarationsContents= declarationsContents+ CommonConstants.NEW_LINE;
		}
		
		declarationsContents = declarationsContents+ generationValueGetter.generationPointString(element, IModelingConstants.METHOD_DETAILS, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppDefinitions.HEADER_CONTENTS),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, visibility));
		
		String visibilityContents = generationValueGetter.use(ICppDefinitions.VISIBILITY_PART, visibility, declarationsContents);
		if(visibilityContents.isEmpty()){
			return visibilityContents;
		}
		
		return visibilityContents+ CommonConstants.NEW_LINE;
	}

	private static void addBaseDeclaration(GenerationPolicyRegistry generationValueGetter, Object element,
			String group, String visiblity, String declaration, String body) {
		generationValueGetter.addUniqueValue(ICppDefinitions.HEADER_CONTENTS, declaration, element, group, visiblity);
		
		if(body!= null){
			generationValueGetter.addUniqueValue(ICppDefinitions.BODY_CONTENTS, body, element, group, visiblity);
		}
		
		generationValueGetter.addUniqueValue(IModelingConstants.METHODS_GROUPS, group, element, visiblity);
	}
	
	private static List<String> getParametersAsStringList(List<Object> items) {
		List<String> parameterStrings= new ArrayList<String>();
		
		for(Object item: items){
			@SuppressWarnings("unchecked")
			SimpleEntry<String, SimpleEntry<String, String>> simpleEntry= (SimpleEntry<String, SimpleEntry<String, String>>) item;
			SimpleEntry<String, String> value = simpleEntry.getValue();
			parameterStrings.add(value.getValue());			
		}
		return parameterStrings;
	}
	
}