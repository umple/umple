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
package cruise.umple.cpp.utils;

import java.util.Arrays;
import java.util.List;

/**
 * The common  return type constants 
 */
public interface CPPTypesConstants {
	
	public static final List<String> BASE_TYPES= Arrays.asList(new String[]{CPPTypesConstants.DOUBLE, CPPTypesConstants.FLOAT,CPPTypesConstants.LONG, 
			CPPTypesConstants.INTEGER, CPPTypesConstants.BOOL, CPPTypesConstants.CHAR});
			
	public static final String VOID= "void"; //$NON-NLS-1$
	public static final String SIZE_T= "size_t"; //$NON-NLS-1$
	public static final String INTEGER= "int"; //$NON-NLS-1$
	public static final String LONG= "long"; //$NON-NLS-1$
	public static final String UNSIGNED_INTEGER= "unsigned int"; //$NON-NLS-1$
	public static final String DOUBLE= "double"; //$NON-NLS-1$
	public static final String FLOAT= "float"; //$NON-NLS-1$
	public static final String BOOL= "bool"; //$NON-NLS-1$
	public static final String CHAR= "char"; //$NON-NLS-1$
	
	public static final String FALSE= "false"; //$NON-NLS-1$
	public static final String TRUE= "true"; //$NON-NLS-1$
}