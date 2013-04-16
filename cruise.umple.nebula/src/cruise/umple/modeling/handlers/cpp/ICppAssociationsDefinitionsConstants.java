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

public interface ICppAssociationsDefinitionsConstants {

	public static final String DELETE_ASSIGN_REMOVE_DEFINITION= "cpp.delete.assign.remove.definition";  //$NON-NLS-1$
	public static final String DELETE_CHECK_NULLIFY_BY_SETTER_DEFINITION= "cpp.delete.check.nullify.setter.definition";  //$NON-NLS-1$
	public static final String DELETE_USE_DELETE_DEFINITION= "cpp.delete.use.delete";  //$NON-NLS-1$
	public static final String DELETE_REMOVE_OR_NULLIFY= "delete.remove.or.nullify.name"; //$NON-NLS-1$
	public static final String DELETE_CLEAR_THEN_DELETE_OR_REMOVE= "delete.clear.then.delete.or.remove"; //$NON-NLS-1$
	public static final String DELETE_CHECK_USE_DELETE= "delete.check.use.delete"; //$NON-NLS-1$
	public static final String DELETE_NULLIFY_ALL_BY_SETTER= "delete.nullify.all.by.setter"; //$NON-NLS-1$
	public static final String DELETE_NULLIFY_USE_DELETE= "delete.nullify.use.all.delete."; //$NON-NLS-1$
	public static final String DELETE_SAFELY_CLEAR_AND_REMOVE= "delete.saely.clear.and.remove"; //$NON-NLS-1$
	public static final String DELETE_USE_FRIEND_SETTER= "delete.use.friend.setter"; //$NON-NLS-1$
	public static final String DELETE_DIRECTLY= "delete.directly"; //$NON-NLS-1$
	
	public static final String MANY_GETTER_METHOD= "many.getter.method.definiion"; //$NON-NLS-1$
	
	public String ADD_IMPLEMENTATION= "cpp.associations.add.function"; //$NON-NLS-1$
	public String GETTER_IMPLEMENTATION=	"cpp.associations.getter.implementation";  //$NON-NLS-1$
	public String IS_A_GETTER_IMPLEMENTATION=	"cpp.associations.is.a.getter.implementation";  //$NON-NLS-1$
	public String GETTER_BY_INDEX_IMPLEMENTATION=	"cpp.associations.getter.by.index.implementation";  //$NON-NLS-1$
	public String NUMBER_OF_IMPLEMENTATION=	"cpp.associations.getter.number.of.implementation";  //$NON-NLS-1$
	public String CONTAINS_IMPLEMENTATION=	"cpp.associations.getter.contains.implementation";  //$NON-NLS-1$
	public String INDEX_OF_IMPLEMENTATION=	"cpp.associations.getter.index.of.implementation";  //$NON-NLS-1$
	public String REMOVE_IMPLEMENTATION=	"cpp.associations.remove.implementation";  //$NON-NLS-1$
	public String REMOVE_AT_IMPLEMENTATION=	"cpp.associations.remove.at.implementation";  //$NON-NLS-1$
	public String ADD_AT_IMPLEMENTATION=	"cpp.associations.add.by.index.implementation";  //$NON-NLS-1$
	public String ADD_OR_MOVE_AT_IMPLEMENTATION=	"cpp.associations.add.or.move.at.implementation";  //$NON-NLS-1$
	
	public String SETTER_IMPLEMENTATION= "class.associations.attributes.setter.implementation";  //$NON-NLS-1$
	public String SETTER_IMPLEMENTATION_END= "class.associations.attributes.setter.implementation.end";  //$NON-NLS-1$
	public String SETTER_IMPLEMENTATION_ARGUMENT= "class.setter.implementation.argument";  //$NON-NLS-1$
	public String SETTER_IMPLEMENTATION_CONDITION= "class.associations.attributes.setter.implementation.condition";  //$NON-NLS-1$
	
	//TODO:
	public String SETTER_CAN_SET_CHECK= "class.setter.can.set.check";  //$NON-NLS-1$
	
	public static final String ADD_CHECK_EXISTING= "add.check.existing"; //$NON-NLS-1$
	public static final String ADD_CHECK_NEW_OTHER_EXSITING= "add.check.new.other.existing"; //$NON-NLS-1$
	public static final String ADD_SET_IF_NEW= "add.set.if.new"; //$NON-NLS-1$
	public static final String ADD_REMOVE_EXISTING= "add.remove.existing"; //$NON-NLS-1$
	public static final String ADD_REMOVE_EXISTING_OR_THIS= "add.remove.existing.or.this"; //$NON-NLS-1$
	public static final String ADD_DIRECTLY= "add.directly"; //$NON-NLS-1$
	public static final String ADD_MAXIMUM_CHECK= "add.maximum.check"; //$NON-NLS-1$
	
	
	public String ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION= "cpp.attribute.setter.assign.directly.declaration";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_HANDLE_OPTIONAL_DECLARATION= "cpp.attribute.setter.handleOptional";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_HANDLE_ONE_DECLARATION= "cpp.attribute.setter.handleOne";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_HANDLE_UNBOUND_DECLARATION= "cpp.attribute.setter.handleUnbound";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_RANGED_DECLARATION= "cpp.attribute.setter.ranged.declaration";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_MAXIMUM_MANY_DECLARATION= "cpp.attribute.setter.maximum.many.declaration";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_MINIMUM_FIXED_DECLARATION= "cpp.attribute.setter.minimum.fixed.declaration";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION= "cpp.attribute.setter.verified.list.declaration";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_HASH_MAP_DECLARATION= "cpp.attribute.setter.hash.map.declaration";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_USE_EXISTING_SETTER_DECLARATION= "cpp.attribute.setter.use.existing.setter";  //$NON-NLS-1$
	public String ATTRIBUTE_SETTER_USE_EXISTING_REMOVE_DECLARATION= "cpp.attribute.setter.use.existing.remove";  //$NON-NLS-1$
}
