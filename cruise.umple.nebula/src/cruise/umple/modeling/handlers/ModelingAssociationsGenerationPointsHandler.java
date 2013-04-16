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

import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.modeling.handlers.cpp.ICppAssociationsDefinitionsConstants;
import cruise.umple.modeling.handlers.cpp.ICppDecisions;

public class ModelingAssociationsGenerationPointsHandler{
	
	/////////////////////////////////////////OPTIONAL HANDLERS//////////////////////////////////
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesOptionalToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesOptionalToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesOptionalToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesOptionalToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesOptionalToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesOptionalToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesOptionalToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesRangedOptionalToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_ALL_BY_SETTER);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING_OR_THIS);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesRangedOptionalToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesRangedOptionalToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_CHECK_NEW_OTHER_EXSITING);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesRangedOptionalToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesRangedOptionalToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesRangedOptionalToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL, ICppDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesRangedOptionalToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_ONE, ICppDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesOneToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_ONE, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesOneToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_ONE, ICppDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesOneToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_ONE, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesOneToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_ONE, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesOneToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_ONE, ICppDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesOneToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_ONE, ICppDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesOneToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesRangedUnboundToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HASH_MAP_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_USE_FRIEND_SETTER);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesRangedUnboundToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesRangedUnboundToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_SET_IF_NEW);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesRangedUnboundToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesRangedUnboundToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesRangedUnboundToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,null, Boolean.FALSE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesRangedUnboundToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	///////////////////////////////////////////////////Ranged Mandatory///////////////////////////////////////////////////////////////
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, ICppDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesRangedMandatoryToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_USE_FRIEND_SETTER);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING, Boolean.TRUE);
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesRangedMandatoryToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, ICppDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesRangedMandatoryToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_SET_IF_NEW);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesRangedMandatoryToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesRangedMandatoryToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, ICppDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesRangedMandatoryToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY,typeParameterName, Boolean.TRUE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
					IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_RANGED_MANDATORY, ICppDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesRangedMandatoryToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, Boolean.TRUE);
			
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_FIXED, ICppDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesFixedToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_FIXED, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesFixedToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_FIXED, ICppDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesFixedToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_CHECK_NEW_OTHER_EXSITING);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_FIXED, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesFixedToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_FIXED, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesFixedToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_FIXED, ICppDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesFixedToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_FIXED, ICppDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesFixedToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
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
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
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
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL})
	public static void associationsVairablesUnboundToOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_ALL_BY_SETTER);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING_OR_THIS);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL})
	public static void associationsVairablesUnboundToRangedOptionalHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_ONE})
	public static void associationsVairablesUnboundToOneHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_CHECK_NEW_OTHER_EXSITING);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND})
	public static void associationsVairablesUnboundToRangedUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY})
	public static void associationsVairablesUnboundToRangedMandatoryHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_FIXED})
	public static void associationsVairablesUnboundToFixedHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, 
					ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, ifConditionIds= {ICppDecisions.ATTRIBUTE_IS_UNBOUND, ICppDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND})
	public static void associationsVairablesUnboundToUnboundHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_DIRECTED) boolean isDirected,
			@GenerationBaseElement Object element){
		
		if(isDirected){
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}else{
			generationValueGetter.generationPointString(element, IModelingDecisions.DELETE_GENERATION_POINT, ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE);
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, Boolean.TRUE);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.FALSE, 
				IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, null, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
	}
	
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void attributesHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_PARAMETER_NAME) String typeParameterName){
		
		//If many, then do not add the attribute to the parameters as it will be considered optional
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, Boolean.TRUE,
				isMany?null:IModelingConstructorDefinitionsConstants.CONSTRUCTOR_ASSIGN_DIRECTLY, isMany?null:typeParameterName, Boolean.FALSE);
		generationValueGetter.generationPointString(element, IModelingDecisions.SETTER_GENERATION_POINT, 
				ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION);
		generationValueGetter.generationPointString(element, IModelingDecisions.GETTER_GENERATION_POINT);
		
		if(isMany){
			generationValueGetter.generationPointString(element, IModelingDecisions.ADD_GENERATION_POINT, ICppAssociationsDefinitionsConstants.ADD_DIRECTLY);
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.GETTER_GENERATION_POINT)
	public static void setGetterDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingDecisions.IS_BOOLEAN) boolean isBoolean,
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
		generationValueGetter.generationPointString(element, IModelingDecisions.NUMBER_OF_GENERATION_POINT);			//NumberOf methods
		generationValueGetter.generationPointString(element, IModelingDecisions.CONTAINS_GENERATION_POINT);			//Contains methods
		generationValueGetter.generationPointString(element, IModelingDecisions.INDEX_OF_GENERATION_POINT);			//IndexOf methods
		generationValueGetter.generationPointString(element, IModelingDecisions.REMOVE_AT_GENERATION_POINT);			//Remove At methods
		generationValueGetter.generationPointString(element, IModelingDecisions.REMOVE_GENERATION_POINT);				//Remove methods
	}
	
}