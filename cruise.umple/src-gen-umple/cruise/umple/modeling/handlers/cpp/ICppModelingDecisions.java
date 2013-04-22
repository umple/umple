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

public interface ICppModelingDecisions {

	public final static String CPP_USED_LIBRARIES= "cpp.used.libraries";  //$NON-NLS-1$
	
	public final static String CPP_LIBRARY_DEPENDS_GENERATION_POINT= "cpp.library.depends.generation.point";  //$NON-NLS-1$
	
	public final static String CPP_LIBRARY_DEPENDS= "modeling.cpp.library.depends";  //$NON-NLS-1$
	public final static String CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT= "depends.library.depends.library.arguments";  //$NON-NLS-1$
	public final static String CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT= "depends.include.depends.library.arguments";  //$NON-NLS-1$
	
}
