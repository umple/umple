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

/**
 * The common  STL return type constants 
 */
public interface ISTLConstants {
	
	public static String STD_LIBRARY = "std";  //$NON-NLS-1$
	public static final String ASSERT_LIBRARY= "cassert"; //$NON-NLS-1$
	public static final String C_TIME= "ctime"; //$NON-NLS-1$
	
	public static final String LIST= "list"; //$NON-NLS-1$
	public static final String ALGORITHM= "algorithm"; //$NON-NLS-1$
	public static final String MEMORY= "memory"; //$NON-NLS-1$
	
	public static final String VECTOR= "vector"; //$NON-NLS-1$
	public static final String OSTREAM= "ostream"; //$NON-NLS-1$
	public static final String HASH_MAP= "hash_map"; //$NON-NLS-1$
	public static final String STRING= "string"; //$NON-NLS-1$
	
	public static final String DATE= "tm"; //$NON-NLS-1$
	public static final String TIME= "time_t"; //$NON-NLS-1$
	
	public static final String DEFAULT_TIME_ASSIGN= "default.time.assign"; //$NON-NLS-1$
	public static final String DEFAULT_DATE_ASSIGN= "default.date.assign"; //$NON-NLS-1$
	public static final String DATE_ASSIGN= "date.assign"; //$NON-NLS-1$
	public static final String TIME_ASSIGN= "time.assign"; //$NON-NLS-1$
	public static final String CURRENT_TIME_REFERENCE= "current.time.reference"; //$NON-NLS-1$
	
	public final static String NEW_VECTOR_DEFINITION= "cpp.new.vector.definition"; //$NON-NLS-1$
	
	public final static String DESTRUCT_VECTOR_DEFINITION= "cpp.desctruct.vector.definition"; //$NON-NLS-1$
}