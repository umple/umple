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

public interface IModelingConstructorDefinitionsConstants {
	
	public static String CONSTRUCTOR_FILTER="cpp.constructor.filter";  //$NON-NLS-1$
	public static String COPY_CONSTRUCTOR_FILTER="cpp.copy.constructor.filter";  //$NON-NLS-1$
	
	public final static String CONSTRUCTOR_IMPLEMENTATION_BEFORE= "cpp.constructor.implementation.before"; //$NON-NLS-1$
	public final static String CONSTRUCTOR_IMPLEMENTATION_AFTER= "cpp.constructor.implementation.after"; //$NON-NLS-1$
		
	public static String CONSTRUCTOR_GENERATION_BODY= "cpp.constructor.generation.body";  //$NON-NLS-1$
	public static String CONSTRUCTOR_GENERATION_POINT= "cpp.constructor.generation.point";  //$NON-NLS-1$
	public static String COPY_CONSTRUCTOR_GENERATION_POINT= "cpp.copy.constructor.generation.point";  //$NON-NLS-1$
	public static String COPY_CONSTRUCTOR_CAN_COPY= "cpp.copy.constructor.can.copy";  //$NON-NLS-1$
	public static String CONSTRUCTOR_PARAMETERS_GENERATION_POINT= "cpp.constructor.parameters.generation.point";  //$NON-NLS-1$
	public static String CONSTRUCTOR_IMPLEMENTATION_CONDITION= "class.constructor.implementation.condition";  //$NON-NLS-1$
	public static String CONSTRUCTOR_IMPLEMENTATION_ARGUMENT= "class.constructor.implementation.argument";  //$NON-NLS-1$
	
	public static String CONSTRUCTOR_STREAM_DECLARATION= "cpp.constructor.stream.generation.body";  //$NON-NLS-1$
	public static String CONSTRUCTOR_STREAM_HELPER_DECLARATION= "cpp.constructor.helper.stream.generation.body";  //$NON-NLS-1$
	public static String CONSTRUCTOR_STREAM_CAN_PRINT= "cpp.stream.constructor.can.print";  //$NON-NLS-1$
	public static String STREAM_PRIMITIVE_ATTRIBUTE="cpp.constructor.stream.attribute";  //$NON-NLS-1$
	public static String STREAM_CONST_GETTER="cpp.stream.const.getter";  //$NON-NLS-1$
	public static String STREAM_ATTRIBUTE="cpp.constructor.stream.assoicaition.variable";  //$NON-NLS-1$
	public static String STREAM_IDENTIFIER="cpp.stream.idnetifier";  //$NON-NLS-1$
	public static String STREAM_NEW_LINE="cpp.constructor.stream.new.line";  //$NON-NLS-1$
	public static String STREAM_VALUE="cpp.constructor.stream.value";  //$NON-NLS-1$
	public static String CONSTRUCTOR_STREAM_GENERATION_POINT= "cpp.constructor.stream.generation.point";  //$NON-NLS-1$
	public static String CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION_BEFORE="cpp.copy.constructor.stream.helper.implementation.before";  //$NON-NLS-1$
	public static String CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION="cpp.copy.constructor.stream.helper.implementation";  //$NON-NLS-1$
	public static String CONSTRUCTOR_STREAM_HELPER_METHOD_NAME="cpp.copy.constructor.stream.helper.method.name";  //$NON-NLS-1$
	public static String CONSTRUCTOR_STREAM_IMPLEMENTATION="cpp.copy.constructor.stream.implementation";  //$NON-NLS-1$
	
	public static String CONSTRUCTOR_DECLARATION="cpp.constructor.declartion";  //$NON-NLS-1$
	public static String CONSTRUCTOR_PARAMETERS_IMPLEMENTATION="cpp.constructor.parameters.implementation";  //$NON-NLS-1$
	public static String CONSTRUCTOR_PRE_IMPLEMENTATION="cpp.constructor.pre.implementation";  //$NON-NLS-1$
	public static String CONSTRUCTOR_IMPLEMENTATION="cpp.constructor.implementation";  //$NON-NLS-1$
	public static String DESTRUCTOR_IMPLEMENTATION="cpp.destructor.implementation";  //$NON-NLS-1$
	public static String DESTRUCTOR_DECLARATION="cpp.destructor.declaration";  //$NON-NLS-1$
	public static String COPY_CONSTRUCTOR_DECLARATION	="cpp.copy.constructor.declaration";  //$NON-NLS-1$
	public static String COPY_CONSTRUCTOR_IMPLEMENTATION="cpp.copy.constructor.implementation";  //$NON-NLS-1$
	
	public static String CONSTRUCTOR_NO_IMPLEMENTATION="cpp.constructor.no.implementation";  //$NON-NLS-1$
	
	public static String CONSTRUCTOR_PARAMETERS= "class.header.public.constructor.parameters"; //$NON-NLS-1$
	
	public static String COPY_ATTRIBUTE="cpp.constructor.copy.attribute";  //$NON-NLS-1$
	public static String COPY_COLLECTION="cpp.constructor.copy.collection";  //$NON-NLS-1$
	
	public static String CONSTRUCTOR_ASSIGN_DIRECTLY= "cpp.constructor.assign.directly";  //$NON-NLS-1$
	
	public static String SET_AND_CHECK= "cpp.constructor.definition.setAndCheck"; //$NON-NLS-1$
	public static String SET_NEW_ARRAY= "cpp.constructor.definition.setNewArray"; //$NON-NLS-1$
	public static String SET_CHECK_OTHER= "cpp.constructor.definition.setCheckOther"; //$NON-NLS-1$
	public static String DEFAULT_ASSIGN= "cpp.constructor.definition.default.assign"; //$NON-NLS-1$
	
	
	public static String CONSTRUCTOR_FILTER_DEFAULT_ASSIGN= "cpp.constructor.filter.default.assign";  //$NON-NLS-1$
	public static String CONSTRUCTOR_IGNORE_INITILIAZATION_DECISION_POINT= "cpp.constructor.generation.ignore.intilization";  //$NON-NLS-1$
	public static String CONSTRUCTOR_FILTER_BODY_DECISION_POINT= "cpp.constructor.generation.point.has.body";  //$NON-NLS-1$
	public static String CONSTRUCTOR_FILTER_PARAMETER_DECISION_POINT= "cpp.constructor.generation.point.has.parameter";  //$NON-NLS-1$
	
}
