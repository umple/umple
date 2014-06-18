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
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;

public class ModelingConstructorPointsHandler{
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	})
	public static void associationsVairablesConstructorsHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OPTIONAL) boolean isOptional,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL) boolean isRangedOptional,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_ONE) boolean isOne,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND) boolean isRangedUnbound,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY) boolean isRangedMandatory,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_FIXED) boolean isFixed,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_UNBOUND) boolean isUnbound,
			
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL) boolean isOtherEndOptional,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL) boolean isOtherEndRangedOptional,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE) boolean isOtherEndOne,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND) boolean isOtherEndRangedUnbound,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY) boolean isOtherEndRangedMandatory,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED) boolean isOtherEndFixed,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND) boolean isOtherEndUnbound,
			
			@GenerationBaseElement Object element){
		
		if(isOptional){
			if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
				generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
						IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN);
			}
		}else if(isRangedOptional){
			if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
				generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
						IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
			}
		}else if(isOne){
			if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
				generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
						IModelingConstructorDefinitionsConstants.SET_AND_CHECK, typeParameterName);
			}else if(isOtherEndOne){
				if(isDirected){
					generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
							IModelingConstructorDefinitionsConstants.SET_AND_CHECK, typeParameterName);
				}else{
					generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
							IModelingConstructorDefinitionsConstants.SET_CHECK_OTHER, typeParameterName);
				}
			}
		}else if(isRangedUnbound){
			if(isOtherEndOptional){
				generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
						IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			}else if(isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
				if(isDirected){
					generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
							IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
				}else{
					generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
							IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
				}
			}
		}else if(isRangedMandatory){
			if(isOtherEndOptional|| isOtherEndUnbound){
				generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
						IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			}else if(isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed){
				if(isDirected){
					generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
							IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
				}else{
					generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
							IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
				}
			}
		}else if(isFixed){
			if(isOtherEndOptional|| isOtherEndUnbound){
				generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
						IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			}else if(isOtherEndOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed){
				if(isDirected){
					generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
							IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
				}else{
					generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
							IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
				}
			}
		}else if(isUnbound){
			if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndOne|| isRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
				generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
						IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
			}
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void attributesHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName){
		
		//If many, then do not add the attribute to the parameters as it will be considered optional
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.TRUE,
				isMany?null:IModelingConstructorDefinitionsConstants.CONSTRUCTOR_ASSIGN_DIRECTLY, isMany?null:typeParameterName, Boolean.FALSE);
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS_GENERATION_POINT)
	public static void constructorParameters(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationBaseElement Object element,
			@GenerationArgument boolean isAttribute,
			@GenerationArgument String typeParameterName) {
		SimpleEntry<String, String> simpleEntry = new SimpleEntry<String, String>(normalizedType, typeParameterName);
		SimpleEntry<String, String> simpleEntryKey = new SimpleEntry<String, String>(name, typeName);
		SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>> entry= new SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>(
				simpleEntryKey, simpleEntry);
		
		SimpleEntry<Object, SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>> result= 
				new SimpleEntry<Object, SimpleEntry<SimpleEntry<String,String>,SimpleEntry<String,String>>>(element, entry);
		
		generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS, result, parent, Boolean.valueOf(isAttribute));
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT)
	public static void setConstructorDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IGNORE_INITILIAZATION_DECISION_POINT) boolean ignoreInitilization,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_BODY) String constructorBody,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_BODY_DECISION_POINT) boolean bodyFiltered,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_DEFAULT_ASSIGN) boolean filterDefaultAssign,
			@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT) boolean parameterFiltered,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_SETTABLE) boolean isSettable,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument boolean isAttribute,
			@GenerationArgument String constructId,
			@GenerationArgument String typeParameterName,
			@GenerationArgument Object constructorArguments) {
		
		String contents= constructorBody!= null? constructorBody: CommonConstants.BLANK;
		String id= bodyFiltered|| constructId.isEmpty()|| parameterFiltered? IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN: constructId;
		
		if(isSettable){
			//If no body is allowed, then just nullify the attribute, otherwise, we can get compiler error for undefined values. Then, the actual value will be set by
			//other call
			
			//Languages such as C++ require initliazing objects, and if we did not do that in the constructor, this will yield to an error. We have this flag, when we rely
			if(!ignoreInitilization|| constructorBody== null|| constructorBody.isEmpty()){
			//on the constructorBody segment to do that, but it will be the responsability for the caller to make sure that their body will initilaize the variable
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
				generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_AS_PARAMETER_ARGUMENT, Boolean.TRUE),
						Boolean.valueOf(isAttribute),
						typeParameterName);
			}
		}
		
		if(!contents.isEmpty()){
			if(IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN.equals(id)){
				generationValueGetter.addUniqueValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PRE_IMPLEMENTATION, 
						new SimpleEntry<Object, String>(element, contents), parent);
			}else{
				generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, 
						new SimpleEntry<Object, String>(element, contents), parent, Boolean.valueOf(isAttribute));
			}
		}
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT)
	public static boolean hasConstructorParameter(
			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE 
			/*Must not be IModelingConstants.NORMALIZED_DEFAULT_VALUE */) String defaultValue) {
		//When there is a default value, then we do not put the attribute in the constructor
		return defaultValue!= null&& !defaultValue.isEmpty();
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_BODY_DECISION_POINT)
	public static boolean hasConstructorBody(
			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue
			/*Must not be IModelingConstants.NORMALIZED_DEFAULT_VALUE */) {
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