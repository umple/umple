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

import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.modeling.handlers.cpp.ICppAssociationsDefinitionsConstants;

public class ModelingAssociationsGenerationPointsHandler{
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	})
	public static void associationsVairablesHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
			
			@GenerationProcedureParameter(id = IModelingConstants.MODELING_DEFAULT_NEW_PARAMETER_NAME) String instnace,
			
			@GenerationBaseElement Object element){
		
		if(isOptional){
			if(isDirected){
				if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION));
				}
			}else{
				if(isOtherEndOptional){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_OPTIONAL_DECLARATION));
				}else if(isOtherEndRangedOptional){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_UNBOUND_DECLARATION),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.CHECK,Boolean.TRUE));
				}else if(isOtherEndOne){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_ONE_DECLARATION));
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedMandatory){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_RANGED_DECLARATION));
				}else if(isOtherEndFixed){
					/*Do Nothing */
				}else if(isOtherEndUnbound){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_UNBOUND_DECLARATION));
				}
			}
		}else if(isRangedOptional){
			if(isDirected){
				if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION), 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.COPY_DIRECTLY,Boolean.TRUE));
				}
			}else{
				if(isOtherEndUnbound){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION));
				}
			}
		}else if(isOne){
			if(isDirected){
				if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION), 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.CHECK,Boolean.TRUE));
				}
			}else{
				if(isOtherEndOptional){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_USE_EXISTING_SETTER_DECLARATION));
				}else if(isOtherEndOne){
					/*Do Nothing */
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndRangedOptional){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MAXIMUM_MANY_DECLARATION));
				}else if(isOtherEndUnbound){	
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_USE_EXISTING_REMOVE_DECLARATION));
				}
			}
		}else if(isRangedUnbound|| isRangedMandatory){
			if(isDirected){
				if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION), 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.COPY_DIRECTLY,Boolean.TRUE));
				}
			}else{
				if(isOtherEndOptional){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HASH_MAP_DECLARATION));
				}else if(isOtherEndOne){
					/*Do Nothing */
				}else if(isOtherEndRangedOptional|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION));
				}
			}
		}else if(isFixed){
			if(isDirected){
				if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION), 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.COPY_DIRECTLY,Boolean.TRUE));
				}
			}else{
				if(isOtherEndOptional){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MINIMUM_FIXED_DECLARATION));
				}else if(isOtherEndRangedOptional){
					/*Do Nothing */
				}else if(isOtherEndOne){
					/*Do Nothing */
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
						GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION));
				}
			}
		}else if(isUnbound){
			/*Empty Block */
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	})
	public static void associationsVairablesRemoveAssociatedObjectsHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			
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
		
		if(isDirected){
			//if(isOtherEndOptional|| isOtherEndRangedOptional|| isOtherEndOne|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
					ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY));
		}else{
			if(isOptional){
				if(isOtherEndOptional){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_CHECK_NULLIFY_BY_SETTER_DEFINITION));
				}else if(isOtherEndRangedOptional|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION),
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.CHECK, Boolean.TRUE));
				}else if(isOtherEndOne){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_USE_DELETE_DEFINITION));
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedMandatory){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_REMOVE_OR_NULLIFY));
				}else if(isOtherEndFixed){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_CHECK_USE_DELETE));
				}
			}else if(isRangedOptional){
				if(isOtherEndOptional){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_ALL_BY_SETTER));
				}else if(isOtherEndRangedOptional|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE));
				}else if(isOtherEndOne){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE));
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE));
				}
			}else if(isOne){
				if(isOtherEndOptional){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_CHECK_NULLIFY_BY_SETTER_DEFINITION),
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.NULLIFY, Boolean.TRUE));
				}else if(isOtherEndRangedOptional|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION));
				}else if(isOtherEndOne){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_USE_DELETE_DEFINITION));
				}
			}else if(isRangedUnbound|| isRangedMandatory|| isFixed){
				if(isOtherEndOptional){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_USE_FRIEND_SETTER));
				}else if(isOtherEndRangedOptional|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE));
				}else if(isOtherEndOne){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE));
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE));
				}
			}else if(isUnbound){
				if(isOtherEndOptional){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_ALL_BY_SETTER));
				}else if(isOtherEndRangedOptional|| isOtherEndUnbound){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE));
				}else if(isOtherEndOne){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE));
				}else if(isRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed){
					generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.RemoveMessages.HANDLE_ID,
							ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE));
				}
			}
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void attributesHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingConstants.MODELING_DEFAULT_NEW_PARAMETER_NAME) String instnace,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.VARIABLE_NAME, instnace),
				GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID, 
						ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION));
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.GETTER_GENERATION_POINT)
	public static void setGetterDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = ICppAssociationsDefinitionsConstants.REMOVE_FILTER_DECISION) boolean filterRemove,
			@GenerationProcedureParameter(id = IModelingDecisions.IS_BOOLEAN) boolean isBoolean,
			@GenerationProcedureParameter(id = IModelingDecisions.REMOVE_AT_FILTER_DECISION) boolean filterRemoveAt,
			@GenerationBaseElement Object element) {
		if(!isMany){
			//Single Getter
			generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_SINGLE_GENERATION_POINT);
			
			if(isBoolean){
				generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.IS_A_GETTER_IMPLEMENTATION);
			}
			return;
		}
		
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_MANY_GENERATION_POINT);		//Many Getter method
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_BY_INDEX_GENERATION_POINT);	//Getter by index methods
		generationValueGetter.generationPointString(element, IModelingDecisions.NUMBER_OF_GENERATION_POINT);		//NumberOf methods
		generationValueGetter.generationPointString(element, IModelingDecisions.CONTAINS_GENERATION_POINT);			//Contains methods
		generationValueGetter.generationPointString(element, IModelingDecisions.INDEX_OF_GENERATION_POINT);			//IndexOf methods
		
		if(!filterRemove){
			generationValueGetter.generationPointString(element, IModelingDecisions.REMOVE_GENERATION_POINT);				//Remove methods
			if(!filterRemoveAt){
				generationValueGetter.generationPointString(element, IModelingDecisions.REMOVE_AT_GENERATION_POINT);
			}
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	})
	public static void associationsVairablesAddHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ADD_AT_FILTER_DECISION) boolean filterAddAt,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL) boolean isRangedOptional,
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
		
		String id= null;
		boolean check= false;
		
		if(isRangedOptional){
			if(isDirected){
				id= ICppAssociationsDefinitionsConstants.ADD_DIRECTLY; 
			}else{
				if(isOtherEndOptional){
					id= ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING_OR_THIS;
				}else if(isOtherEndOne){
					id= ICppAssociationsDefinitionsConstants.ADD_CHECK_NEW_OTHER_EXSITING;
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedOptional|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					id= ICppAssociationsDefinitionsConstants.ADD_DIRECTLY;
					check= true;
				}
			}
			
		}else if(isRangedUnbound){
			if(isDirected){
				id= ICppAssociationsDefinitionsConstants.ADD_DIRECTLY; 
			}else{
				if(isOtherEndOptional){
					id= ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING;
					check= true;
				}else if(isOtherEndOne){
					id= ICppAssociationsDefinitionsConstants.ADD_SET_IF_NEW;
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedOptional|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					id= ICppAssociationsDefinitionsConstants.ADD_DIRECTLY;
					check= true;
				}
			}
		}else if(isRangedMandatory){
			if(isDirected){
				id= ICppAssociationsDefinitionsConstants.ADD_DIRECTLY; 
			}else{
				if(isOtherEndOptional){
					id= ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING;
					check= true;
				}else if(isOtherEndOne){
					id= ICppAssociationsDefinitionsConstants.ADD_SET_IF_NEW;
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedOptional|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					id= ICppAssociationsDefinitionsConstants.ADD_DIRECTLY;
					check= true;
				}
			}
		}else if(isFixed){
			if(isDirected){
				//None 
			}else{
				if(isOtherEndOptional){
					//None
				}else if(isOtherEndOne){
					id= ICppAssociationsDefinitionsConstants.ADD_SET_IF_NEW;
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedOptional|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					id= ICppAssociationsDefinitionsConstants.ADD_DIRECTLY;
					check= true;
				}
			}
		}else if(isUnbound){
			if(isDirected){
				id= ICppAssociationsDefinitionsConstants.ADD_DIRECTLY; 
			}else{
				if(isOtherEndOptional){
					id= ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING_OR_THIS;
				}else if(isOtherEndOne){
					id= ICppAssociationsDefinitionsConstants.ADD_CHECK_NEW_OTHER_EXSITING;
				}else if(isOtherEndRangedUnbound|| isOtherEndRangedOptional|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound){
					id= ICppAssociationsDefinitionsConstants.ADD_DIRECTLY;
					check= true;
				}
			}
		} 
		
		if(id== null){
			return;
		}
		
		Boolean valueOfCheck = Boolean.valueOf(check);
		generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, id, valueOfCheck);
		
		if(!filterAddAt){
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_AT_GENERATION_POINT, id, valueOfCheck);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_OR_MOVE_GENERATION_POINT, id, valueOfCheck);
		}
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.POST, loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.CAN_CONSTRUCT})
	public static void associationsVairablesUnboundToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingDecisions.ADD_INSTANCE_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void manyAttributesAddHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany){
		
		if(isMany){
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_AT_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_OR_MOVE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ADD_AT_FILTER_DECISION)
	public static boolean filterAddAt(){
		//For extensibility
		return false;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.REMOVE_AT_FILTER_DECISION)
	public static boolean filterRemoveAt(){
		//For extensibility
		return false;
	}
	
	////////////////////////////////////////////////////////Remove Decisions/////////////////////////////////////////////////////////////////////////////////////
	@DecisionPoint(decisionPoint = ICppAssociationsDefinitionsConstants.REMOVE_CHECK_OTHER_END_DECISION, ifNotConditionIds= {IModelingDecisions.ATTRIBUTE_IS_DIRECTED})
	public static boolean removeCheckOtherEnd(@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL) boolean isRangedOptional,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND) boolean rangedUnbound,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_FIXED) boolean fixed,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_UNBOUND) boolean Unbound,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL) boolean isOtherEndRangedOptional,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND) boolean isOtherEndRangedUnbound,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY) boolean isOtherEndRangedMandatory,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED) boolean isOtherEndFixed,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND) boolean isOtherEndUnbound){
		if(isRangedOptional|| rangedUnbound|| fixed|| Unbound){
			return isOtherEndRangedOptional|| isOtherEndRangedUnbound|| isOtherEndRangedMandatory|| isOtherEndFixed|| isOtherEndUnbound;
		}
		return false;
	}
	
	@DecisionPoint(decisionPoint = ICppAssociationsDefinitionsConstants.REMOVE_MINIMUM_CHECK_DECISION, ifNotConditionIds= {IModelingDecisions.ATTRIBUTE_IS_DIRECTED})
	public static boolean removeCheckMinimum(@GenerationProcedureParameter(id = IModelingDecisions.HAS_MINIMUM_GETTER) boolean checkForMinimum,
			@GenerationLoopElement(id= {IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR, 
					IModelingElementDefinitions.ASSOCIATION_VARIABLES_PROCESSOR}) Object item){
		return checkForMinimum&& item!= null;
	}
	
	@DecisionPoint(decisionPoint = ICppAssociationsDefinitionsConstants.REMOVE_SELF_CHECK_DECISION, ifNotConditionIds= {IModelingDecisions.ATTRIBUTE_IS_DIRECTED})
	public static boolean removeSelfCheck(@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE) boolean isOtherEndOne){
		return isOtherEndOne;
	}
	
	@DecisionPoint(decisionPoint = ICppAssociationsDefinitionsConstants.REMOVE_NULLIFY_DECISION, ifNotConditionIds= {IModelingDecisions.ATTRIBUTE_IS_DIRECTED})
	public static boolean removeNullify(@GenerationProcedureParameter(
			id = ICppAssociationsDefinitionsConstants.REMOVE_CHECK_OTHER_END_DECISION) boolean checkOtherEnd,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_UNBOUND) boolean unbound,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL) boolean rangedOptional,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL) boolean isOtherEndOptional){
		if(checkOtherEnd){
			return false;
		}
		
		if(rangedOptional|| unbound){
			return isOtherEndOptional;
		}
		return false;
	}
	
	@DecisionPoint(decisionPoint = ICppAssociationsDefinitionsConstants.REMOVE_NULLIFY_INTERNALLY_DECISION, ifNotConditionIds= {IModelingDecisions.ATTRIBUTE_IS_DIRECTED})
	public static boolean removeNullifyInternally(@GenerationProcedureParameter(
			id = ICppAssociationsDefinitionsConstants.REMOVE_NULLIFY_DECISION) boolean nullify,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND) boolean rangedUnbound,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY) boolean rangedMandatory,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL) boolean isOtherEndOptional){
		if(nullify){
			return false;
		}
		
		if(rangedUnbound|| rangedMandatory){
			return isOtherEndOptional;
		}
		return false;
	}
	
	@DecisionPoint(decisionPoint = ICppAssociationsDefinitionsConstants.REMOVE_FILTER_DECISION)
	public static boolean filterRemove(@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_FIXED) boolean fixed,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL) boolean isOtherEndOptional){
		if(fixed){
			if(isDirected){
				return true;
			}
			return isOtherEndOptional;
		}
		return false;
	}
	
}