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

import cruise.umple.core.CommonConstants;

/**
 * The common  constants for C++ code generation 
 */
public interface CPPCommonConstants {
	
	public static String HEADER_FILE_EXTENSION = "h"; // default value //$NON-NLS-1$
	public static String BODY_FILE_EXTENSION = "cpp"; // default value //$NON-NLS-1$
	
	public static final String DECLARATION_PREFIX= " : "; //$NON-NLS-1$
	public static final String DECLARATION_COMMON_PREFIX= "::"; //$NON-NLS-1$
	public static final String UNDEFINED= "undefined"; //There is no keyword in C++ such undefined, but we use this as a way to indicate badly undefined types, etc on the code generation //$NON-NLS-1$
	public static final String BODY= "body"; //$NON-NLS-1$
	public static final String HEADER= "header"; //$NON-NLS-1$
	public static final String NAME= "name"; //$NON-NLS-1$
	public static final String VISIBILITY= "visibility"; //$NON-NLS-1$
	public static final String QUALIFIED_NAME= "qualified_name"; //$NON-NLS-1$
	
	public static final String CPP_LANGUAGE= "Cpp"; //$NON-NLS-1$
	public static final String C_LANGUAGE= "C"; //$NON-NLS-1$
	public static final String C_CPP_LANGUAGES= CPPCommonConstants.C_LANGUAGE+ 
			CommonConstants.FORWARD_SLASH+CPPCommonConstants.CPP_LANGUAGE;
	
	public static final String FUNCTION_INITAILISATION= "initialisation"; //$NON-NLS-1$
	
	public static final String NIL= "NIL"; //$NON-NLS-1$
	public static final String NULL= "NULL"; //$NON-NLS-1$
	public static final String THIS= "this"; //$NON-NLS-1$
	public static final String AND= "&&"; 	//$NON-NLS-1$
	
	public static final String BEGIN= "begin"; //$NON-NLS-1$
	public static final String END= "end"; //$NON-NLS-1$
	
	public static final String ENUM= "enum"; //$NON-NLS-1$
	
}
