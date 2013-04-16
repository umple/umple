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

import cruise.umple.core.GenerationGroupDefinition;
import cruise.umple.modeling.handlers.IModelingPriorityHandler;

public interface ICppModelingPriorityHandler{
	
	@GenerationGroupDefinition(priority = 900, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String INLINE_FUNCTIONS= "modeling.priority.getter.details"; //$NON-NLS-1$
	
	@GenerationGroupDefinition(priority = 400, after= IModelingPriorityHandler.CONSTRUCTOR_DETAILS)
	public static final String HASH_CODE= "modeling.priority.hash.code.details"; //$NON-NLS-1$
	
}