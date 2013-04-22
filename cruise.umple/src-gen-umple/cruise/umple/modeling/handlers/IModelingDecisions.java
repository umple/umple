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

public interface IModelingDecisions {

	public final static String PARENT_CLASS_EXTENDS= "modeling.class.extends";  //$NON-NLS-1$
	public final static String INTERFACES_IMPLEMENTS= "modeling.interfaces.implements";  //$NON-NLS-1$
	
	public final static String GETTER_GENERATION_POINT= "getter.generation.point";  //$NON-NLS-1$
	public final static String SETTER_GENERATION_POINT= "setter.generation.point";  //$NON-NLS-1$
	
	public final static String SETTER_GENERATION_ID= "setter.generation.id";  //$NON-NLS-1$
	
	public final static String GETTER_SINGLE_GENERATION_POINT= "getter.single.generation.point";  //$NON-NLS-1$
	public final static String GETTER_MANY_GENERATION_POINT= "getter.many.generation.point";  //$NON-NLS-1$
	public final static String GETTER_BY_INDEX_GENERATION_POINT= "getter.by.index.generation.point";  //$NON-NLS-1$
	public final static String NUMBER_OF_GENERATION_POINT= "number.of.index.generation.point";  //$NON-NLS-1$
	public final static String CONTAINS_GENERATION_POINT= "contains.index.generation.point";  //$NON-NLS-1$
	public final static String INDEX_OF_GENERATION_POINT= "index.of.generation.point";  //$NON-NLS-1$
	public final static String REMOVE_AT_GENERATION_POINT= "remove.at.generation.point";  //$NON-NLS-1$
	public final static String REMOVE_GENERATION_POINT= "remove.generation.point";  //$NON-NLS-1$
	public final static String MINIMUM_NUMBER_GENERATION_POINT= "minimum.number.generation.point";  //$NON-NLS-1$
	public final static String MAXIMUM_NUMBER_GENERATION_POINT= "maximum.number.generation.point";  //$NON-NLS-1$
	
	public final static String OPERATIONS_GENERATION_POINT= "modeling.operations.generation.point";  //$NON-NLS-1$
	public final static String OPERATION_PARAMETERS_ARGUMENT= "modeling.operation.parameters.argument";  //$NON-NLS-1$
	public final static String OPERATION_PARAMETER_ARGUMENT= "modeling.operation.parameter.argument";  //$NON-NLS-1$
	
	public final static String IS_BOOLEAN= "is.boolean.generation.point";  //$NON-NLS-1$
	public final static String DEPENDS_GENERATION_POINT= "depends.generation.point";  //$NON-NLS-1$
	public final static String ADD_GENERATION_POINT= "add.generation.point";  //$NON-NLS-1$
	public final static String DELETE_GENERATION_POINT= "delete.generation.point";  //$NON-NLS-1$
	public final static String DELETE_DECISION_ID_ARGUMENT= "delete.decision.id.argument";  //$NON-NLS-1$
	public final static String SETTER_GENERATION_POINT_FILTER= "setter.generation.point.filter";  //$NON-NLS-1$
	public final static String GETTER_GENERATION_POINT_FILTER= "getter.generation.point.filter";  //$NON-NLS-1$
	public final static String ATTRIBUTE_GENERATION_POINT= "modeling.attribute.generation.point";  //$NON-NLS-1$
	
	public final static String IS_LANGUAGE_PRIMITIVE_TYPE= "is.primitive.type.decision.point";  //$NON-NLS-1$
	
	public final static String MODEL_PATH= "model.path"; //$NON-NLS-1$
	public String DEFAULT_LANGUAGE_TYPE_VALUE= "default.language.parameter.value"; //$NON-NLS-1$
	
	public final static String DEPENDS_PRIORITY= "depends.priority.object.argument";  //$NON-NLS-1$
	public final static String DEPENDS_TYPE_OBJECT_ARGUMENT= "depends.type.object.argument";  //$NON-NLS-1$
	public final static String DEPENDS_IS_ROOT_ARGUMENT= "depends.is.root.object.argument";  //$NON-NLS-1$
	public final static String DEPENDS_IS_CUSTOM_ARGUMENT= "depends.is.custom.argument";  //$NON-NLS-1$
	public final static String DEPENDS_INCLUDE_ID_ARGUMENT= "depends.include.id.argument";  //$NON-NLS-1$
	public final static String DEPENDS_OUTSIDE_ARGUMENT= "depends.outside.argument";  //$NON-NLS-1$
	public final static String DEPENDS_CHECK_CIRCULARITY_ARGUMENT= "depends.check.circulairy.argument";  //$NON-NLS-1$
}
