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
import java.util.List;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;

public class FixmlPointsHandler{
	
	private static final String FIXML = "fixml"; //$NON-NLS-1$
	private static final String FIXML_CONSTRUCTOR_CONTENTS= "fixml.constructor.contents"; //$NON-NLS-1$
	private static final String FIXML_CONSTRUCTOR_GENERATION_POINT= "fixml.constructor"; //$NON-NLS-1$
	
//	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT)
//	public static boolean hasConstructorParameter(
//			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE 
//			/*Must not be IModelingConstants.NORMALIZED_DEFAULT_VALUE */) String defaultValue) {
//		//When there is a default value, then we do not put the attribute in the constructor
//		return defaultValue!= null&& !defaultValue.isEmpty();
//	}
//	
//	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT, priority= 100)
//	public static ReturnDecisionObject filterAllConstructorParametersForFixml(@GenerationElementParameter(id = IModelingElementDefinitions.MODIFIER) String modifier,
//			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE 
//					/*Must not be IModelingConstants.NORMALIZED_DEFAULT_VALUE */) String defaultValue) {
//		return reconcileDefaultValue(modifier, defaultValue);
//	}
//
//	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_BODY_DECISION_POINT, priority= 100)
//	public static ReturnDecisionObject filterDefaultBodyInBaseConstructor(@GenerationElementParameter(id = IModelingElementDefinitions.MODIFIER) String modifier,
//			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue
//			/*Must not be IModelingConstants.NORMALIZED_DEFAULT_VALUE */) {
//		return reconcileDefaultValue(modifier, defaultValue);
//	}
//	
//	private static ReturnDecisionObject reconcileDefaultValue(String modifier,
//			String defaultValue) {
//		//Disable getters for the internal attributes
//		//Use GETTER_GENERATION_POINT_FILTER for extensibility
//		if(modifier== null||!modifier.startsWith(FIXML)){
//			return null;
//		}
//		
//		if(defaultValue!= null&& !defaultValue.isEmpty()){
//			//Allow creating constructor parameters even if there is a default value. This case is a part of fixml where the default value (including derived attributes)
//			//will be a part of the fixml constructor, while the base constructor will rely on reciving the value from the user
//			return new ReturnDecisionObject(false, true);
//		}
//		
//		//Take care of it on other places
//		return null;
//	}

	//@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.PROCESS_CONSTRUCTOR_CONTENTS, priority= IGenerationPointPriorityConstants.HIGHEST)
	public static void processConstructorDetails(@GenerationBaseElement Object element,
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationArgument List<String> allDeclarations, 
			@GenerationArgument List<String> allImplementations) {
		List<Object> fixmlConstructors = generationValueGetter.getValues(FIXML_CONSTRUCTOR_CONTENTS, element);
		if(fixmlConstructors.isEmpty()){
			return;
		}
		
		List<Object> filtered= new ArrayList<Object>();
		
		for(Object obj: fixmlConstructors){
			if(obj instanceof String== false|| ((String)obj).isEmpty()){
				continue;
			}
			
			filtered.add(obj);
		}
		
//		String fixmlDeclaration = generationValueGetter.generate(Generator.CONSTRUCTOR_DECLARATION, name);
//		
//		allDeclarations.add(fixmlDeclaration);
//		
//		String normal= GenerationUtil.listToGeneratedString(0, 1, filtered);
//		
//		
//		String constructor = generationValueGetter.generate(Generator.CONSTRUCTOR_IMPLEMENTATION,element, 
//				name, CommonConstants.BLANK, normal);
//		
//		allImplementations.add(constructor);
		
	}
	
//	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
//			/*Association paths*/
//			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
//			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
//	})
//	public static void attributesHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
//			@GenerationBaseElement Object element,
//			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
//			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName){
//		
//		//If many, then do not add the attribute to the parameters as it will be considered optional
//		generationValueGetter.generationPointString(element, FIXML_CONSTRUCTOR_GENERATION_POINT, Boolean.TRUE,
//				/*isMany?null:Generator.CONSTRUCTOR_ASSIGN_DIRECTLY, isMany?null:*/typeParameterName, Boolean.FALSE);
//	}
	
	@GenerationPoint(generationPoint = FIXML_CONSTRUCTOR_GENERATION_POINT)
	public static void setFixmlConstructorDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			
			@GenerationElementParameter(id = IModelingElementDefinitions.MODIFIER) String modifier,
			
//			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IGNORE_INITILIAZATION_DECISION_POINT) boolean ignoreInitilization,
//			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_BODY) String constructorBody,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument boolean isAttribute,
			@GenerationArgument String typeParameterName,
			@GenerationArgument Object constructorArguments) {
		
		//TODO: Not designed to be generic. 
		//Awaiting discussion to have a generic keyword (such as eager as opposed to lazy) instead of hard coding stereotypes to handle fixml conditions
		if(!isAttribute|| modifier== null|| !modifier.contains(FIXML)){
			return;
		}
		
		String defaultValue= generationValueGetter.getString(element,IModelingElementDefinitions.DEFAULT_VALUE, CPPCommonConstants.CPP_LANGUAGE);
		if(defaultValue== null|| defaultValue.isEmpty()){
			generationValueGetter.addValue(FIXML_CONSTRUCTOR_CONTENTS, CommonConstants.BLANK, parent);
			return;
		}
		
//		String contents= constructorBody!= null? constructorBody: CommonConstants.BLANK;
//		String id= Generator.DEFAULT_ASSIGN;
		
		//If no body is allowed, then just nullify the attribute, otherwise, we can get compiler error for undefined values. Then, the actual value will be set by
		//other call
		
		//Languages such as C++ require initliazing objects, and if we did not do that in the constructor, this will yield to an error. We have this flag, when we rely
		//on the constructorBody segment to do that, but it will be the responsability for the caller to make sure that their body will initilaize the variable
//		if(!ignoreInitilization|| constructorBody== null|| constructorBody.isEmpty()){
//			contents= contents+ generationValueGetter.generate(id, element, typeParameterName, constructorArguments);
//		}
//		
//		if(!contents.isEmpty()){
//			generationValueGetter.addValue(FIXML_CONSTRUCTOR_CONTENTS, contents, parent);
//		}
	}
	
}