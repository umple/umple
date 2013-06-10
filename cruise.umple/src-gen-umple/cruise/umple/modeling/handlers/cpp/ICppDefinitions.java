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

public interface ICppDefinitions {
	
	public final static String DEEP_COPY_METHOD_NAME= "deepCopy"; //$NON-NLS-1$
	public final static String DEEP_COPY_METHOD_DECLARATION= "cpp.deepCopy.method.declaration"; //$NON-NLS-1$
	public final static String DEEP_COPY_METHOD_IMPLEMENTATION= "cpp.deepCopy.method.implementation"; //$NON-NLS-1$
	
	public final static String METHOD_CONST= "method.const"; //$NON-NLS-1$
	public final static String METHOD_STATIC= "method.static"; //$NON-NLS-1$
	public final static String METHOD_INLINE= "method.inline"; //$NON-NLS-1$
	public final static String METHOD_INIT= "method.init"; //$NON-NLS-1$
	public final static String METHOD_VIRTUAL= "method.virtual"; //$NON-NLS-1$
	public final static String METHOD_PURE= "method.pure"; //$NON-NLS-1$
	
	public final static String FULL_QUALIFIED_NAME="cpp.full.qualified.name";  //$NON-NLS-1$
	
	public final static String COPY_STRING_ATTRIBUTE="cpp.constructor.copy.string.attribute";  //$NON-NLS-1$
	public final static String COPY_PRIMITIVE_ATTRIBUTE="cpp.constructor.copy.primitive.attribute";  //$NON-NLS-1$
	
	public final static String HASH_CDOE_METHOD_NAME= "modeling.hash.code.method.name"; //$NON-NLS-1$
	public final static String HASH_CDOE_DECLARATION= "modeling.hash.code.declaration"; //$NON-NLS-1$
	public final static String HASH_CDOE_IMPLEMENTATION= "modeling.hash.code.implementation"; //$NON-NLS-1$
	
	public final static String PRE_PROCESSORS_INCUDES_DEFINITIONS="cpp.pre.processors.includes.definition";  //$NON-NLS-1$
	public final static String GNUC_DEFINITION="cpp.gnuc.definition";  //$NON-NLS-1$
	
	public final static String IS_POINTER_TYPE= "is.pointer.type.decision.point";  //$NON-NLS-1$
	public final static String IS_CONST_TYPE_PARAMETER= "is.const.parameter";  //$NON-NLS-1$
	public final static String GENERIC_TYPE= "cpp.generic.point";  //$NON-NLS-1$
	
	public final static String ATTRIBUTE_DECLARATIONS= "cpp.attribute.declarations"; //$NON-NLS-1$
	public final static String STATIC_ATTRIBUTE_DECLARATIONS= "cpp.static.attribute.declarations"; //$NON-NLS-1$
	public final static String ASSOCIATIONS_DECLARATION= "cpp.associations.declaration";  //$NON-NLS-1$
	
	public final static String ATTRIBUTE_EQUALITY_GENERATION_POINT= "modeling.attribute.equality.generation.point";  //$NON-NLS-1$
	
	public final static String DELETE_FUNCTION= "cpp.associations.delete.function"; //$NON-NLS-1$
	public final static String DELETE_METHOD_NAME=	"cpp.associations.delete.signatrue";  //$NON-NLS-1$
	
	public final static String CLASS_GLOBAL="cpp.class.global";  //$NON-NLS-1$
	public final static String VISIBILITY_PART="cpp.visibility.part";  //$NON-NLS-1$
	public final static String VISIBILITY_BASED_CONTENTS="cpp.visibility.based.contents";  //$NON-NLS-1$
	public final static String PACKAGE_VISIBILITY_CONTENTS=	"class.header.package.visibility.contents"; //$NON-NLS-1$
	
	public final static String ATTRIBUTES_IMPLEMENTATION= "cpp.attributes.implementation"; //$NON-NLS-1$
	public final static String ATTRIBUTES_IMPLEMENTATIONS= "cpp.attributes.implementations"; //$NON-NLS-1$
	public final static String PUBLIC_CONTENTS= "cpp.public.contents"; //$NON-NLS-1$
	public final static String PACKAGE_CONTENTS=	"cpp.package.contents";  //$NON-NLS-1$
	public final static String PROTECTED_CONTENTS=	"cpp.protected.contents"; //$NON-NLS-1$
	public final static String PRIVATE_CONTENTS=	"cpp.private.contents"; //$NON-NLS-1$
	public final static String PUBLIC_DECLARATIONS= "cpp.public.declarations"; //$NON-NLS-1$
	public final static String PACKAGE_DECLARATIONS=	"cpp.package.declarations";  //$NON-NLS-1$
	public final static String PROTECTED_DECLARATIONS=	"cpp.protected.declarations"; //$NON-NLS-1$
	public final static String PRIVATE_DECLARATIONS=	"cpp.private.declarations"; //$NON-NLS-1$
	public final static String PUBLIC_IMPLEMENTATION= "cpp.public.implementation"; //$NON-NLS-1$
	public final static String PACKAGE_IMPLEMENTATION=	"cpp.package.implementation";  //$NON-NLS-1$
	public final static String PUBLIC_INLINE_CONTENTS= "cpp.public.inline.contents"; //$NON-NLS-1$
	public final static String PROTECTED_INLINE_CONTENTS= "cpp.protected.inline.contents"; //$NON-NLS-1$
	public final static String PACKAGE_INLINE_CONTENTS= "cpp.package.inline.contents"; //$NON-NLS-1$
	public final static String PRIVATE_INLINE_CONTENTS= "cpp.private.inline.contents"; //$NON-NLS-1$
	
	public final static String MAIN= "cpp.main"; //$NON-NLS-1$
	public final static String MAIN_PRE_CONTENTS= "cpp.main.extra.pre.contents"; //$NON-NLS-1$
	public final static String ALIAS= "cpp.alias"; //$NON-NLS-1$
	public final static String ROOT_ALIAS= "cpp.root.alias"; //$NON-NLS-1$
	public final static String ALIASES= "cpp.aliases"; //$NON-NLS-1$
	
	public final static String HEADER_CONTENTS= "cpp.header.contents"; //$NON-NLS-1$
	public final static String BODY_CONTENTS= "cpp.body.contents"; //$NON-NLS-1$
	
	public final static String ADD_IMPLEMENTATION= "cpp.add.implementation"; //$NON-NLS-1$
	
	public final static String CLASS_BODY="cpp.body.definition";  //$NON-NLS-1$
	
	public final static String DEFINITION_DECLARATION="cpp.definition.declaration";  //$NON-NLS-1$
	
	public final static String HEADER= "cpp.header.definition"; //$NON-NLS-1$
	public final static String PACKAGE_HEADER= "cpp.header.definition.package"; //$NON-NLS-1$
	
	public final static String PREDEFINED_FUNCTIONS= "cpp.core.predefined.functions"; //$NON-NLS-1$
	public final static String CLASSES_DECLARATIONS= "cpp.classes.declarations"; //$NON-NLS-1$
	public final static String CLASS_DECLARATION= "cpp.class.declaration"; //$NON-NLS-1$
	public final static String CLASS_PREFIX= "method.method.caller.prefix"; //$NON-NLS-1$
	public final static String INCLUDE_STATEMENT= "class.include"; //$NON-NLS-1$
	public final static String BUILTIN_INCLUDE_STATEMENT= "class.builtin.include"; //$NON-NLS-1$
	
	public final static String INCLUDES_DECLARATIONS= "cpp.includes.declartions"; //$NON-NLS-1$
	
	public final static String METHOD_PARENT_CALL= "cpp.method.parent.call"; //$NON-NLS-1$
	public final static String METHOD_PARAMAETERS_ARGUMENT= "cpp.method.parameters.arguments"; //$NON-NLS-1$
	public final static String METHOD_NAME_ARGUMENT= "cpp.method.name.argument"; //$NON-NLS-1$
	
	
	public final static String DEFINE= "cpp.define"; //$NON-NLS-1$
	public final static String INCOMPLETE_NAMESPACES_DEFNITION= "cpp.incomplete.namespaces.definitions"; //$NON-NLS-1$
	public final static String INCOMPLETE_EXTERNAL_NAMESPACES_DEFNITION= "cpp.incomplete.external.namespaces.definitions"; //$NON-NLS-1$
	public final static String INCOMPLETE_TYPES_DEFNITION= "cpp.incomplete.types.definitions"; //$NON-NLS-1$
	public final static String EXTERNAL_NAMESPACES= "cpp.external.namespaces"; //$NON-NLS-1$
	public final static String NAMESPACE= "cpp.namespace"; //$NON-NLS-1$
	public final static String CLASS_DEFINITION= "cpp.class.definition"; //$NON-NLS-1$
	public final static String IF_CONDITION_BLOCK= "cpp.if.condition.block"; //$NON-NLS-1$
	public final static String THROW_STATEMENET= "cpp.throw.statemenet"; //$NON-NLS-1$
	public final static String TYPE_DEF= "cpp.type.def"; //$NON-NLS-1$
	public final static String THIS_POINTER= "cpp.this.pointer"; //$NON-NLS-1$
	public final static String RETURN_STATEMENET= "cpp.return.statemenet"; //$NON-NLS-1$
	public final static String ELSE_CONDITION_BLOCK= "cpp.else.condition.block"; //$NON-NLS-1$
	public final static String ATTRIBUTE_USE= "cpp.attribute.use"; //$NON-NLS-1$
	public final static String ASSIGN_STATEMENET= "cpp.assign.statement"; //$NON-NLS-1$
	public final static String DECLARE_STATEMENET= "cpp.declare.statement"; //$NON-NLS-1$
	public final static String DECLARE_IMPLEMENTATION= "cpp.declare.implementation"; //$NON-NLS-1$
	public final static String PARAMETER_ASSIGN_STATEMENET= "cpp.parameter.assign.statement"; //$NON-NLS-1$
	public final static String METHOD_TODO_STATEMENET= "cpp.method.todo.statement"; //$NON-NLS-1$
	public final static String METHOD_IMPLEMENTATION= "cpp.method.implementation"; //$NON-NLS-1$
	public final static String METHOD_IMPLEMENTATION_BEFORE= "cpp.method.implementation.before"; //$NON-NLS-1$
	public final static String METHOD_IMPLEMENTATION_AFTER= "cpp.method.implementation.after"; //$NON-NLS-1$
	public final static String METHOD_DECLARATION= "cpp.method.declaration"; //$NON-NLS-1$
	public final static String METHOD_INVOCATION= "cpp.method.invocation"; //$NON-NLS-1$
	public final static String NOT_EQUAL= "cpp.not.equal"; //$NON-NLS-1$
	public final static String DESTRUCT_ATTRIBUTE= "cpp.destruct.attribute"; //$NON-NLS-1$
	public final static String INCREMENT= "cpp.attribute.increment"; //$NON-NLS-1$
	public final static String QUALIFIED_METHOD_NAME= "cpp.method.qualified.name"; //$NON-NLS-1$
	public final static String CONSTANT_PARAMETER= "cpp.constant.parameter"; //$NON-NLS-1$
	
	public final static String METHOD_IMPLEMENTATIONS= "cpp.method.implementations"; //$NON-NLS-1$
	
	public final static String ATTRIBUTE_GETTER= "class.associations.attributes.methods";  //$NON-NLS-1$
	public final static String ATTRIBUTE_GETTER_IMPLEMENTATION= ATTRIBUTE_GETTER+ ".implementation";  //$NON-NLS-1$
	
	public final static String ATTRIBUTE_DISABLE_DELETE= "cpp.attribute.disable.delete";  //$NON-NLS-1$
	public final static String ATTRIBUTE_EQUALITY= "cpp.attribute.equality";  //$NON-NLS-1$
	public final static String ATTRIBUTE_EQUALITY_ENTRY= "cpp.attribute.equality.entry";  //$NON-NLS-1$
	public final static String ATTRIBUTES_DECLARATION= "cpp.attributes.declaration";  //$NON-NLS-1$
	public final static String HELPER_ATTRIBUTES_DECLARATION= "cpp.helper.attributes.declaration";  //$NON-NLS-1$
	
	public final static String STRING_ATTRIBUTE_EQUALITY= "cpp.string.attribute.equality";  //$NON-NLS-1$
	public final static String PRIMITIVE_ATTRIBUTE_EQUALITY= "cpp.primitive.attribute.equality";  //$NON-NLS-1$
	
	public final static String COMMENTS_SUFFIX= ".comments";  //$NON-NLS-1$
	
	public final static String HEADER_INCLUDES_TRACKER= "headerIncludesTracker"; //$NON-NLS-1$
	public final static String BODY_INCLUDES_TRACKER= "bodyIncludesTracker"; //$NON-NLS-1$
	public final static String USE_NAMESPACE= "cpp.core.namespace.use"; //$NON-NLS-1$
	
	public final static String METHOD_INLINE_ARGUMENT= "method.inline.argument"; //$NON-NLS-1$
	
	public final static String DEFNIED_NAMESPACES_MACROS= "cpp.defined.namespaces.macros"; //$NON-NLS-1$
	public final static String NAMESPACES_MACROS= "cpp.namespaces.macros"; //$NON-NLS-1$
	public final static String NAMESPACES_ROOTS= "cpp.namespaces.roots"; //$NON-NLS-1$
	public final static String MACROS_TYPE_DEF= "cpp.type.def"; //$NON-NLS-1$
	public final static String NAMESPACE_OPENING= "cpp.namespace.opening"; //$NON-NLS-1$
	public final static String NAMESPACE_CLOSING= "cpp.namespace.closing"; //$NON-NLS-1$
	public final static String NAMESPACE_CALL= "cpp.namespace.call"; //$NON-NLS-1$
	public final static String SET_NAMESPACE_SUFFIX= "cpp.namespace.set.suffix"; //$NON-NLS-1$
	public final static String NAMESPACE_SUFFIX_QUALIFIED_PATH= "cpp.namespace.suffix.qualified.path"; //$NON-NLS-1$
	
	public final static String OWING_NAMESPACE_OBJECT= "cpp.owing.namespace.object"; //$NON-NLS-1$
	
	public final static String HELPER_CODES= "cpp.helper.codes"; //$NON-NLS-1$
	public final static String HELPER_INCLUDES= "cpp.helper.includes"; //$NON-NLS-1$
	public final static String TIME_HELPER_CODE= "cpp.time.helper.code"; //$NON-NLS-1$
	
	public final static String GETTER_BY_INDEX_INVOCATION= "cpp.getter.by.index.invocation"; //$NON-NLS-1$
	public final static String GETTER_BY_INDEX_ASSIGNEE_ARGUMENT= "cpp.getter.by.index.assignee.argument"; //$NON-NLS-1$
	public final static String GETTER_BY_INDEX_VARIABLE_ARGUMENT= "cpp.getter.by.index.variable.argument"; //$NON-NLS-1$
	public final static String GETTER_BY_INDEX_TYPE_ARGUMENT= "cpp.getter.by.index.type.argument"; //$NON-NLS-1$
	public final static String GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT= "cpp.getter.by.index.index.argument"; //$NON-NLS-1$
	
	public final static String REMOVE_INVOCATION= "cpp.remove.invocation"; //$NON-NLS-1$
	public final static String REMOVE_INDEX_ARGUMENT= "cpp.remove.index.argument"; //$NON-NLS-1$
	public final static String REMOVE_VARIABLE_ARGUMENT= "cpp.remove.variable.argument"; //$NON-NLS-1$
	
	public final static String REMOVE_ALL_INVOCATION= "cpp.remove.all.invocation"; //$NON-NLS-1$
	public final static String REMOVE_ALL_TYPE_ARGUMENT= "cpp.remove.all.type.argument"; //$NON-NLS-1$
	public final static String REMOVE_ALL_VARIABLE_ARGUMENT= "cpp.remove.all.variable.argument"; //$NON-NLS-1$
	public final static String REMOVE_ALL_REMOVE_LIST_ARGUMENT= "cpp.remove.all.remove.listvariable.argument"; //$NON-NLS-1$
	
	public final static String ADD_INVOCATION= "cpp.add.invocation"; //$NON-NLS-1$
	public final static String ADD_PARAMETER_ARGUMENT= "cpp.add.parameter.argument"; //$NON-NLS-1$
	public final static String ADD_INDEX_ARGUMENT= "cpp.add.index.argument"; //$NON-NLS-1$
	public final static String ADD_VARIABLE_ARGUMENT= "cpp.add.variable.argument"; //$NON-NLS-1$
	
	public final static String COPY_INVOCATION= "cpp.copy.invocation"; //$NON-NLS-1$
	public final static String COPY_SOURCE_ARGUMENT= "cpp.copy.source.argument"; //$NON-NLS-1$
	public final static String COPY_TARGET_ARGUMENT= "cpp.copy.target.argument"; //$NON-NLS-1$
	public final static String COPY_IS_INITIALIZED_ARGUMENT= "cpp.copy.initiliazed.argument"; //$NON-NLS-1$
	
	public final static String BASE_COMPARATOR= "cpp.base.comparator"; //$NON-NLS-1$
	public final static String BASE_COMPARATOR_DEFAULT_NAME= "cpp.base.comparator.default.name"; //$NON-NLS-1$
	public final static String COMPARATORS_DETAILS= "cpp.comparators.details"; //$NON-NLS-1$
	
	public final static String FUNCTION_OPERATORS= "cpp.function.operators"; //$NON-NLS-1$
	
	public final static String CLASS_INCOMPLETE_DECLARATION= "cpp.class.incomplete.declaration"; //$NON-NLS-1$
	public final static String STRUCT_INCOMPLETE_DECLARATION= "cpp.struct.incomplete.declaration"; //$NON-NLS-1$
	public final static String INCOMPLETE_DECLARATIONS= "cpp.class.inline.declarations"; //$NON-NLS-1$
	
	public final static String PREDEFINED_TEMPLATES_FILE= "cpp.predefined.templates.definitions.file"; //$NON-NLS-1$
	public final static String PREDEFINED_TEMPLATES_DEFINITIONS= "cpp.predefined.templates.definitions"; //$NON-NLS-1$
	
	public final static String FULL_PATH_ARGUMENT= "cpp.full.path.argument"; //$NON-NLS-1$
	
	public final static String TEMPLATES_DEFINITIONS= "cpp.templates.definitions"; //$NON-NLS-1$
	public final static String THREAD_IMPLEMENTATION= "cpp.thread.implementation"; //$NON-NLS-1$
	
	public final static String PREDEFINED_OPERATORS_REGISTER= "cpp.predefined.operators.register"; //$NON-NLS-1$
	public final static String PREDEFINED_OPERATORS_DECLARATION= "cpp.predefined.operators.declaration"; //$NON-NLS-1$
	public final static String PREDEFINED_OPERATORS_IMPLEMENTATION= "cpp.predefined.operators.implementation"; //$NON-NLS-1$
	
	public final static String ASSIGNMENT_OPERATOR_DECLARATION= "cpp.assignment.operator.declaration"; //$NON-NLS-1$
	public final static String ASSIGNMENT_OPERATOR_IMPLEMENTATION= "cpp.assignment.operator.implementation"; //$NON-NLS-1$
	
	public final static String ATTRIBUTE_EQUALITY_OPERATOR_DECLARATION= "cpp.attribute.operator.equality.declaration";  //$NON-NLS-1$
	public final static String ATTRIBUTE_EQUALITY_OPERATOR_IMPLEMENTATION= "cpp.attribute.operator.equality.implementation";  //$NON-NLS-1$
	
	public final static String PRE_PROCESSING_DEFINITION_NAME= "cpp.pre.processing.name"; //$NON-NLS-1$
	public final static String PREDEFINED_PACKAGE_CONTENTS= "cpp.package.prdefined.contents";   //$NON-NLS-1$
	
	public final static String POINTER_STRING= "cpp.pointer.string"; //$NON-NLS-1$
	public final static String REFERENCE_STRING= "cpp.reference.string"; //$NON-NLS-1$
	
	public final static String INCLUDES= "class.header.includes"; //$NON-NLS-1$
	public final static String BODY_INCLUDES= "class.body.includes"; //$NON-NLS-1$
	
	public final static String GLOBAL_DEFINITIONS= "package.definitions"; //$NON-NLS-1$
	public final static String PACKAGE_INCLUDES= "package.header.includes"; //$NON-NLS-1$
	
	public final static String CONSTRUCTOR_IMPLEMENATION= "class.header.constructor.impl"; //$NON-NLS-1$
	public final static String HEADER_INLINE_FUNCTION_CONTENTS= "class.header.inline.function.contents"; //$NON-NLS-1$
	
	public final static String FRIEND_SETTER_DECLARATION= "cpp.friend.setter.declaration";	 //$NON-NLS-1$
	public final static String FRIEND_SETTER_IMPLEMENTATION= "cpp.friend.setter.implementation";	 //$NON-NLS-1$
	
	public final static String CONSTRUCTOR_PARAMETERS_LIST= "cpp.constructor.parameters.list";	 //$NON-NLS-1$
	public final static String CONSTRUCTOR_PARENT_PARAMETERS_LIST= "cpp.constructor.parent.parameters.list";	 //$NON-NLS-1$
	public final static String CONSTRUCTOR_ALL_PARAMETERS_LIST= "cpp.constructor.all.parameters.list";	 //$NON-NLS-1$
	
	public final static String CONSTRUCTOR_EXTENDED_USED_PARAMETERS_LIST= "cpp.constructor.extended.used.all.parameters.list";	 //$NON-NLS-1$
	
	public final static String MAIN_CONTENTS= "cpp.main.contents";	 //$NON-NLS-1$
}
