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

public interface IUmpleModelingPriorities {
	
	@GenerationGroupDefinition(priority = 625, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String RESET= "modeling.umple.priority.reset.priority"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 695, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String DEFAULT_GETTER= "modeling.umple.priority.default.getter.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 840)
	public static final String AUTOUNIQUE_ATTRIBUTES= "modeling.priority.auto.unique.attributes"; //$NON-NLS-1$
}
