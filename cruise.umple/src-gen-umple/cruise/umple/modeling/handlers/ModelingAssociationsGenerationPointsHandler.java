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
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.modeling.handlers.cpp.ICppAssociationsDefinitionsConstants;

public class ModelingAssociationsGenerationPointsHandler{
	
	/////////////////////////////////////////OPTIONAL HANDLERS//////////////////////////////////
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesOptionalToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CHECK_NULLIFY_BY_SETTER_DEFINITION, Boolean.FALSE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_OPTIONAL_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesOptionalToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_UNBOUND_DECLARATION, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesOptionalToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_USE_DELETE_DEFINITION);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_ONE_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesOptionalToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_REMOVE_OR_NULLIFY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_RANGED_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesOptionalToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_REMOVE_OR_NULLIFY);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesOptionalToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CHECK_USE_DELETE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesOptionalToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_UNBOUND_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	/////////////////////////////////////////////////Ranged Optional Handler//////////////////////////////////////////////////////////////////////////////
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesRangedOptionalToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_ALL_BY_SETTER);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesRangedOptionalToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesRangedOptionalToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesRangedOptionalToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesRangedOptionalToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesRangedOptionalToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesRangedOptionalToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	///////////////////////////////////////////////////One///////////////////////////////////////////////////////////////
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_ONE, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesOneToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CHECK_NULLIFY_BY_SETTER_DEFINITION, Boolean.TRUE);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_USE_EXISTING_SETTER_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_AND_CHECK, typeParameterName);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_ONE, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesOneToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MAXIMUM_MANY_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_AND_CHECK, typeParameterName);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_ONE, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesOneToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_AND_CHECK, typeParameterName);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_USE_DELETE_DEFINITION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_CHECK_OTHER, typeParameterName);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_ONE, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesOneToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MAXIMUM_MANY_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_AND_CHECK, typeParameterName);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_ONE, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesOneToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MAXIMUM_MANY_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_AND_CHECK, typeParameterName);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_ONE, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesOneToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MAXIMUM_MANY_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_AND_CHECK, typeParameterName);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_ONE, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesOneToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_USE_EXISTING_REMOVE_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_AND_CHECK, typeParameterName);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
		
	///////////////////////////////////////////////////Ranged Unbound///////////////////////////////////////////////////////////////
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesRangedUnboundToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HASH_MAP_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_USE_FRIEND_SETTER);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesRangedUnboundToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesRangedUnboundToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesRangedUnboundToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesRangedUnboundToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
			
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesRangedUnboundToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesRangedUnboundToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	///////////////////////////////////////////////////Ranged Mandatory///////////////////////////////////////////////////////////////
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesRangedMandatoryToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_USE_FRIEND_SETTER);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HASH_MAP_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesRangedMandatoryToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesRangedMandatoryToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesRangedMandatoryToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesRangedMandatoryToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesRangedMandatoryToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesRangedMandatoryToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	///////////////////////////////////////////////////Fixed///////////////////////////////////////////////////////////////
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_FIXED, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesFixedToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_USE_FRIEND_SETTER);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MINIMUM_FIXED_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_FIXED, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesFixedToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_FIXED, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesFixedToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_FIXED, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesFixedToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_FIXED, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesFixedToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_FIXED, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesFixedToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_FIXED, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesFixedToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	///////////////////////////////////////////////////Unbound///////////////////////////////////////////////////////////////
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesUnboundToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_ALL_BY_SETTER);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesUnboundToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesUnboundToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
		
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE);
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesUnboundToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesUnboundToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesUnboundToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
		}
		
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {IModelingDecisions.ATTRIBUTE_IS_UNBOUND, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesUnboundToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	}, aspect= LoopAspectConstants.BEFORE)
	public static void attributesHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName){
		
		//If many, then do not add the attribute to the parameters as it will be considered optional
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.TRUE,
				isMany?null:IModelingConstructorDefinitionsConstants.CONSTRUCTOR_ASSIGN_DIRECTLY, isMany?null:typeParameterName, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
				ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION);
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
					id= ICppAssociationsDefinitionsConstants.ADD_CHECK_NEW_OTHER_EXSITING;
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