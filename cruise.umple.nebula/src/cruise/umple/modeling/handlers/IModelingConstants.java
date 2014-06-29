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

public interface IModelingConstants {
	
	public final static String COPY_RIGHT= "copy.right";  //$NON-NLS-1$
	public final static String ROOT_PATH= "rootPath"; //$NON-NLS-1$
	public final static String ROOT_NAME= "rootName"; //$NON-NLS-1$
	
	public final static String PARENT_INTERFACES= "parentInterfaces"; //$NON-NLS-1$
	public final static String PARENT_CLASS= "parentClass"; //$NON-NLS-1$
	
	public final static String IS_INSTANCE_OF= "is.instance.of"; //$NON-NLS-1$
	public final static String IS_PARENT= "is.parent"; //$NON-NLS-1$
	public static final String INSTANCE_OF_ELEMENT_ARGUMENT= "interna;.instance.of.element.argument"; //$NON-NLS-1$
	
	public final static String NORMALIZED_DEFAULT_VALUE= "normalized.defaultValue"; //$NON-NLS-1$
	
	public final static String GENERATION_HELPER_TYPE= "generation.helper.type"; //$NON-NLS-1$
	public final static String TYPES_TRACKER= "cpp.types.tracker"; //$NON-NLS-1$
	public final static String NAMESPACES_TRACKER= "cpp.namespaces.tracker"; //$NON-NLS-1$
	public final static String TYPES_BY_NAMESPACES_TRACKER= "cpp.types.by.namespaces.tracker"; //$NON-NLS-1$

	
	public final static String DEFAULT_VALUE_INTERCEPTOR= "default.value.interceptor"; //$NON-NLS-1$
	
	public final static String CLASS_DECLARATIONS= "class.declarations"; //$NON-NLS-1$
	public final static String CLASS_DECLARATIONS_EXTENSION= "class.declarations.extension"; //$NON-NLS-1$
	
	public final static String SET_ATTRIBUTE_PREFIXES= "modeling.set.attribute.prefix";  //$NON-NLS-1$
	public final static String ATTRIBUTE_PREFIXES_ARGUMENT= "modeling.attribute.prefixes.argument";  //$NON-NLS-1$
	public final static String ATTRIBUTE_VALUE_ARGUMENT= "modeling.attribute.value.argument";  //$NON-NLS-1$
	public final static String ATTRIBUTE_TYPE_ARGUMENT= "modeling.attribute.type.argument";  //$NON-NLS-1$
	public final static String ATTRIBUTE_NAME_ARGUMENT= "modeling.attribute.name.argument";  //$NON-NLS-1$
	public final static String ATTRIBUTES_GROUPS= "modeling.attributes.groups";  //$NON-NLS-1$
	public final static String ATTRIBUTES_GROUP_PRIORITY= "modeling.register.attributes.group.priority";  //$NON-NLS-1$
	public final static String GROUP_ID_ARGUMENT= "modeling.attributes.group.id.argument";  //$NON-NLS-1$
	public final static String ATTRIBUTES_GROUP_VISIBILITY_ARGUMENT= "modeling.attributes.group.visibility.argument";  //$NON-NLS-1$
	
	public final static String ATTRIBUTE_SEEK_TYPE_ARGUMENT= "modeling.attribute.seek.type.argument";  //$NON-NLS-1$
	public final static String ATTRIBUTE_IGNORE_ROLE_ARGUMENT= "modeling.attribute.ignore.role.argument";  //$NON-NLS-1$
	public final static String ATTRIBUTE_SEEK_NAME_ARGUMENT= "modeling.attribute.seek.name.argument";  //$NON-NLS-1$
	public final static String ATTRIBUTE_IS_ATTRIBUTE_ARGUMENT= "modeling.attribute.is.attribute.argument";  //$NON-NLS-1$
	public final static String ATTRIBUTE_SEEK_OTHER_END_ARGUMENT= "modeling.attribute.seek.other.end.argument";  //$NON-NLS-1$
	
	public final static String SETTER_METHOD_NAME= "modeling.setter.method.name";  //$NON-NLS-1$
	public final static String GETTER_METHOD_NAME= "modeling.getter.method.name";  //$NON-NLS-1$
	public final static String GETTER_BY_INDEX_METHOD_NAME= "modeling.getter.by.index.method.name";  //$NON-NLS-1$
	public final static String NUMBER_OF_METHOD_NAME= "modeling.number.of.method.name";  //$NON-NLS-1$
	public final static String CONTAINS_METHOD_NAME= "modeling.contains.method.name";  //$NON-NLS-1$
	public final static String INDEX_OF_METHOD_NAME= "modeling.index.of.method.name";  //$NON-NLS-1$
	public final static String REMOVE_AT_METHOD_NAME= "modeling.remove.at.method.name";  //$NON-NLS-1$
	public final static String REMOVE_METHOD_NAME= "modeling.remove.method.name";  //$NON-NLS-1$
	public final static String ADD_METHOD_NAME= "modeling.add.method.name";  //$NON-NLS-1$
	public final static String ADD_OR_MOVE_METHOD_NAME= "modeling.add.or.move.method.name";  //$NON-NLS-1$
	public final static String ADD_AT_METHOD_NAME= "modeling.add.at.method.name";  //$NON-NLS-1$
	
	public final static String OPERATIONS_IMPLEMENTATION= "modeling.operations.implementation";  //$NON-NLS-1$
	
	public static final String MINIMUM_NUMBER_OF= "minimum.numberOf.method.name"; //$NON-NLS-1$
	public static final String MAXIMUM_NUMBER_OF= "maximum.numberOf.method.name"; //$NON-NLS-1$
	
	public final static String REMOVE_ASSOCIATED_OBJECTS= "modeling.remove.associated.objects"; //$NON-NLS-1$
	
	public final static String NORMALIZED_ROLE_NAME= "modeling.normalized.role.name";  //$NON-NLS-1$
	
	public final static String MODELING_DEFAULT_NEW_PARAMETER_NAME= "modeling.setter.method.new.parameter.name";  //$NON-NLS-1$
	public final static String MODELING_DEFAULT_PARAMETER_NAME= "modeling.setter.method.default.parameter.name";  //$NON-NLS-1$
	public final static String MODELING_DEFAULT_SINGLE_PARAMETER_NAME= "modeling.setter.method.default.single.parameter.name";  //$NON-NLS-1$
	
	public final static String METHOD_CONTENTS_REGISTER= "method.contents.register"; //$NON-NLS-1$
	
	public final static String METHOD_REGISTER= "method.register"; //$NON-NLS-1$
	public final static String METHOD_DETAILS= "method.details"; //$NON-NLS-1$
	public final static String METHOD_CONTENTS= "method.contents"; //$NON-NLS-1$
	public final static String METHOD_DECLARATION= "modeling.method.declaration"; //$NON-NLS-1$
	public final static String METHOD_IMPLEMENTATION= "modeling.method.implementation"; //$NON-NLS-1$
	public final static String METHOD_ID_ARGUMENT= "method.id.argument"; //$NON-NLS-1$
	public final static String METHOD_VISIBILITY_ARGUMENT= "method.visibility.argument"; //$NON-NLS-1$
	public final static String METHOD_SEPARATOR_ARGUMENT= "method.separator.argument"; //$NON-NLS-1$
	public final static String METHOD_OBJECT= "method.object"; //$NON-NLS-1$
	public final static String METHOD_COMMENT= "method.comment"; //$NON-NLS-1$
	public final static String METHOD_ID= "method.id"; //$NON-NLS-1$
	public final static String METHOD_NAME= "method.name"; //$NON-NLS-1$
	public final static String METHOD_IDENTIFIER= "method.identifier"; //$NON-NLS-1$
	public final static String METHOD_RETURN_TYPE= "method.return.type"; //$NON-NLS-1$
	public final static String METHOD_PARAMETERS_STRING= "parameters.string"; //$NON-NLS-1$
	public final static String METHOD_DEFAULTED_IMPLEMENTATION= "method.defaulted.implementation"; //$NON-NLS-1$
	public final static String METHOD_GROUP= "method.group"; //$NON-NLS-1$
	public final static String METHODS_GROUPS= "method.groups"; //$NON-NLS-1$
	public final static String METHODS_OBJECTS= "method.objects"; //$NON-NLS-1$
	public final static String CODY_BODY= "code.body"; //$NON-NLS-1$
	
	public final static String METHOD_IDS= "method.ids"; //$NON-NLS-1$
	
	public final static String METHODS_GROUP_PRIORITY= "modeling.methods.group.priority";  //$NON-NLS-1$
	public final static String METHOD_DEFAUT_GROUP= "modeling.method.group.default";  //$NON-NLS-1$
	public final static String METHOD_PRE_DEFINED_GROUP= "modeling.method.group.pre.defined";  //$NON-NLS-1$
	public final static String METHOD_INCOMING_GROUP= "modeling.method.group.incoming";  //$NON-NLS-1$
	public final static String METHOD_OUTGOING_GROUP= "modeling.method.group.outgoing";  //$NON-NLS-1$
	public final static String METHOD_OPERATIONS_GROUP= "modeling.method.group.operations";  //$NON-NLS-1$
	public final static String METHOD_FINALIZE_GROUP= "modeling.method.finalize.defined";  //$NON-NLS-1$
	
	public final static String FULL_PATH= "modeling.full.path"; //$NON-NLS-1$
	
	public final static String NORMALIZED_NAME= "modeling.normalized.name"; //$NON-NLS-1$
	public final static String NORMALIZED_TYPE_NAME= "modeling.normalizedTypeName"; //$NON-NLS-1$
	public final static String NORMALIZED_TYPE_STRING= "modeling.normalizedTypeString"; //$NON-NLS-1$
	public final static String NORMALIZED_VISIBILITY= "modeling.normalized.visibility"; //$NON-NLS-1$
	public final static String NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT= "modeling.normalizedTypeName.is.construction.argument"; //$NON-NLS-1$
	public final static String NORMALIZED_TYPE_CRUD_TYPE_ARGUMENT= "modeling.normalizedTypeName.crud.type.argument"; //$NON-NLS-1$
	public final static String NORMALIZED_TYPE_AS_PARAMETER_ARGUMENT= "modeling.normalizedTypeName.as.parameter.argument"; //$NON-NLS-1$
	public final static String NORMALIZED_RETURN_TYPE= "modeling.normalized.return.type"; //$NON-NLS-1$
	
	public final static String GENERATION_DIRECTORY= "modeling.generation.directory"; //$NON-NLS-1$
	public final static String GENERATION_LANGUAGE= "modeling.generation.language"; //$NON-NLS-1$
	
	public final static String MULTILINE_COMMENTS_STRING= "modeling.multitline.comments.string"; //$NON-NLS-1$
	
	public final static String NO_IMPLEMENTATION= "no.implementation";  //$NON-NLS-1$
	
	public final static String WAS_ADDED= "wasAdded"; //$NON-NLS-1$
	public final static String WAS_SET= "wasSet"; //$NON-NLS-1$
	public final static String WAS_REMOVED= "wasRemoved"; //$NON-NLS-1$
	
	public final static String DEPENDS_LIST= "dependsList"; //$NON-NLS-1$
	
}
