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

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.modeling.handlers.cpp.ICppDecisions;


public class ModelingConstructorPointsHandler{
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS_GENERATION_POINT)
	public static void constructorParameters(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument boolean isAttribute,
			@GenerationArgument String typeParameterName) {
		SimpleEntry<String, String> simpleEntry = new AbstractMap.SimpleEntry<String, String>(normalizedType, typeParameterName);
		SimpleEntry<String, SimpleEntry<String, String>> entry= new SimpleEntry<String, AbstractMap.SimpleEntry<String,String>>(typeName, simpleEntry);
		generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS, entry, parent, Boolean.valueOf(isAttribute));
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT)
	public static void setConstructorDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IGNORE_INITILIAZATION_DECISION_POINT) boolean ignoreInitilization,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_BODY) String constructorBody,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_BODY_DECISION_POINT) boolean bodyFiltered,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_DEFAULT_ASSIGN) boolean filterDefaultAssign,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT) boolean parameterFiltered,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_SETTABLE) boolean isSettable,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument boolean isAttribute,
			@GenerationArgument String constructId,
			@GenerationArgument String typeParameterName,
			@GenerationArgument Object constructorArguments) {
		
		String contents= constructorBody!= null? constructorBody: CommonConstants.BLANK;
		
		if(isSettable){
			//If no body is allowed, then just nullify the attribute, otherwise, we can get compiler error for undefined values. Then, the actual value will be set by
			//other call
			
			//Languages such as C++ require initliazing objects, and if we did not do that in the constructor, this will yield to an error. We have this flag, when we rely
			//on the constructorBody segment to do that, but it will be the responsability for the caller to make sure that their body will initilaize the variable
			if(!ignoreInitilization|| constructorBody== null|| constructorBody.isEmpty()){
				String id= bodyFiltered|| constructId.isEmpty()|| parameterFiltered? IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN: constructId;
				
				if(!(filterDefaultAssign&& IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN.equals(id))){
					contents= contents+ generationValueGetter.generate(id, element, typeParameterName, constructorArguments);
					
					String extra= generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_CONDITION, 
							GenerationArgumentDescriptor.arg(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_ARGUMENT, contents));
					if(extra!= null&& !extra.isEmpty()){
						contents= extra;
					}
				}
			}
			
			if(typeParameterName!= null&&!typeParameterName.isEmpty()&& !parameterFiltered){
				generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS_GENERATION_POINT, Boolean.valueOf(isAttribute),
						typeParameterName);
			}
		}
		
		if(!contents.isEmpty()){
			generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, contents, parent, Boolean.valueOf(isAttribute));
		}
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT)
	public static boolean hasConstructorParameter(@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue) {
		//When there is a default value, then we do not put the attribute in the constructor
		return defaultValue!= null&& !defaultValue.isEmpty();
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_BODY_DECISION_POINT)
	public static boolean hasConstructorBody(@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue) {
		//When there is a default value, then we have to use that value, so, no body means that we will use the default id that will assign the default value
		return defaultValue!= null&& !defaultValue.isEmpty();
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT)
	public static boolean filterAttributeParameter(@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic) {
		//constant/Static attributes are not meant to be passed in the constructor
		return isConstant|| isStatic;
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_CAN_COPY)
	public static boolean canCopy(@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic) {
		//constant/Static attributes must not be part of the copy constructor
		return !isConstant&& !isStatic;
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_BODY_DECISION_POINT)
	public static boolean filterAttributeBody(@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic) {
		//Static and constants cannot be set in the constructor
		return isConstant|| isStatic;
	}
	
}