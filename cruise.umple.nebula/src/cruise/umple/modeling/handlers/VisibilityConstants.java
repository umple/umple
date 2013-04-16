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

import java.util.Arrays;
import java.util.List;

/**
* The common  visibility constants for CPP different declarations
*/
public interface VisibilityConstants {
	
	public static final String VISIBILITY_TRACKER= "cpp.visiblity.tracker"; //$NON-NLS-1$
	
	public static final String PACKAGE= "package"; 		//$NON-NLS-1$
	public static final String PUBLIC= "public"; 		//$NON-NLS-1$
	public static final String PROTECTED= "protected"; 	//$NON-NLS-1$
	public static final String PRIVATE= "private"; 		//$NON-NLS-1$
	
	public static List<String> PREDEFINED_VISIBILITIES= Arrays.asList(new String[]{VisibilityConstants.PUBLIC,
			VisibilityConstants.PROTECTED, VisibilityConstants.PRIVATE, VisibilityConstants.PACKAGE});
}