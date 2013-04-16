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

import cruise.umple.core.GenerationGroupDefinition;

public interface IModelingPriorityHandler{
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@GenerationGroupDefinition(priority = 1000)
	public static final String PUBLIC_DETAILS= "modeling.priority.public.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 950)
	public static final String PROTECTED_DETAILS= "modeling.priority.protected.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 900)
	public static final String PRIVATE_DETAILS= "modeling.priority.private.details"; //$NON-NLS-1$
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@GenerationGroupDefinition(priority = 1000)
	public static final String STATC_ATTRIBUTES= "modeling.priority.static.attributes"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 950)
	public static final String ATTRIBUTES= "modeling.priority.attributes"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 900)
	public static final String ASSOCIATIONS_ATTRIBUTES= "modeling.priority.associations.attributes"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 850)
	public static final String HELPER_ATTRIBUTES= "modeling.priority.helper.attributes"; //$NON-NLS-1$
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@GenerationGroupDefinition(priority = 1000)
	public static final String PRE_DEFINED_DETAILS= "modeling.priority.pre.defined.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 900, after= IModelingPriorityHandler.PRE_DEFINED_DETAILS)
	public static final String CONSTRUCTOR_DETAILS= "modeling.priority.constructor.details"; //$NON-NLS-1$
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////ATTRIBUTES PRIORITIES/////////////////////////////////////////////////////////////////
	@GenerationGroupDefinition(priority = 700, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String GETTER= "modeling.priority.getter.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 690, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String GETTER_BY_INDEX= "modeling.priority.getter.by.index.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 680, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String NUMBER_OF= "modeling.priority.number.of.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 670, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String CONTAINS= "modeling.priority.contains.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 660, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String INDEX_OF= "modeling.priority.index.of.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 650, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String MINIMUM_NUMBER= "modeling.priority.minimum.number.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 640, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String MAXIMUM_NUMBER= "modeling.priority.maximum.number.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 630, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String SETTER= "modeling.priority.setter.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 620, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String REMOVE= "modeling.priority.remove.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 610, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String REMOVE_AT= "modeling.priority.remove.at.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 500, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String REMOVE_ASSOCIATED_OBJECTS= "modeling.priority.remove.associated.objects.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 700, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String ADD= "modeling.priority.add.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 690, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String ADD_AT= "modeling.priority.add.at.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 680, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String ADD_OR_MOVE_AT= "modeling.priority.add.or.move.at.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 680, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String OPERATIONS= "modeling.priority.operations.details"; //$NON-NLS-1$
}