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
	public static final String MAP= "map"; //$NON-NLS-1$
	public static final String MEMORY= "memory"; //$NON-NLS-1$
	public static final String BINARY_FUNCTION= "binary_function"; //$NON-NLS-1$
	public static final String IO_STREAM= "iostream"; //$NON-NLS-1$
	public static final String TIME_INCLUDE= "time.h"; //$NON-NLS-1$
	public static final String C_TYPE= "ctype.h"; //$NON-NLS-1$
	public static final String STUDIO= "stdio.h"; //$NON-NLS-1$
	
	public static final String VECTOR= "vector"; //$NON-NLS-1$
	public static final String SET= "set"; //$NON-NLS-1$
	public static final String OSTREAM= "ostream"; //$NON-NLS-1$
	public static final String HASH_MAP= "hash_map"; //$NON-NLS-1$
	public static final String STRING= "string"; //$NON-NLS-1$
	public static final String CSTRING= "cstring"; //$NON-NLS-1$
	public static final String EXCEPTION= "exception"; //$NON-NLS-1$
	public static final String STD_EXCEPTION= "stdexcept"; //$NON-NLS-1$
	
	
	public static final String DATE= "tm"; //$NON-NLS-1$
	public static final String TIME= "time_t"; //$NON-NLS-1$
	
	public static final String DEFAULT_TIME_ASSIGN= "default.time.assign"; //$NON-NLS-1$
	public static final String DEFAULT_DATE_ASSIGN= "default.date.assign"; //$NON-NLS-1$
	public static final String DATE_ASSIGN= "date.assign"; //$NON-NLS-1$
	public static final String TIME_ASSIGN= "time.assign"; //$NON-NLS-1$
	public static final String CURRENT_TIME_REFERENCE= "current.time.reference"; //$NON-NLS-1$
	
	public final static String NEW_LIST_DEFINITION= "cpp.new.list.definition"; //$NON-NLS-1$
	public final static String TYPE_AS_LIST= "type.as.list"; //$NON-NLS-1$
	
	public final static String TYPE_AS_SET= "type.as.set"; //$NON-NLS-1$
	public final static String TYPE_AS_SET_COMPARATOR_ARGUMENT= "type.as.set.comparator.argument"; //$NON-NLS-1$
	
	public final static String DESTRUCT_VECTOR_DEFINITION= "cpp.desctruct.vector.definition"; //$NON-NLS-1$
	
	public final static String REMOVE_VECTOR_ELEMENT= "cpp.remove.vector.element"; //$NON-NLS-1$
	public final static String REMOVE_SET_ELEMENT= "cpp.remove.set.element"; //$NON-NLS-1$
	
	public final static String REMOVE_ALL_VECTOR_ELEMENTS= "cpp.remove.all.vector.elements"; //$NON-NLS-1$
	public final static String REMOVE_ALL_SET_ELEMENTS= "cpp.remove.all.set.elements"; //$NON-NLS-1$
	
	public final static String ADD_VECTOR_ELEMENT= "cpp.add.vector.element"; //$NON-NLS-1$
	public final static String ADD_SET_ELEMENT= "cpp.add.set.element"; //$NON-NLS-1$
	
	public final static String GET_VECTOR_ELEMENT= "cpp.get.vector.element"; //$NON-NLS-1$
	public final static String GET_SET_ELEMENT= "cpp.get.set.element"; //$NON-NLS-1$
	public final static String GET_SET_ELEMENT_TEMPLATE_IMPLEMENTATION= "cpp.get.set.element.template.implementation"; //$NON-NLS-1$
	
	public final static String GET_VECTOR_ELEMENT_RETURN= "cpp.get.vector.element.return"; //$NON-NLS-1$
	public final static String GET_SET_ELEMENT_RETURN= "cpp.get.set.element.return"; //$NON-NLS-1$
	
	public final static String COPY_SET_ELEMENT_TEMPLATE_IMPLEMENTATION= "cpp.copy.set.element.template.implementation"; //$NON-NLS-1$
	public final static String COPY_VECTOR_ELEMENT_TEMPLATE_IMPLEMENTATION= "cpp.copy.vector.element.template.implementation"; //$NON-NLS-1$
	
	public final static String STL_DEFINED_TEMPLATES_IMPLEMENTATION= "cpp.stl.defined.templates.implementation"; //$NON-NLS-1$
	
	public final static String COPY_VECTOR_ELEMENT= "cpp.copy.vector.element"; //$NON-NLS-1$
	public final static String COPY_SET_ELEMENT= "cpp.copy.set.element"; //$NON-NLS-1$
}