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

public interface ICppHandlerDefinitions {

	public String PRE_PROCESSING_DEFINITION_NAME= "cpp.pre.processing.name"; //$NON-NLS-1$
	public String PREDEFINED_PACKAGE_CONTENTS= "cpp.package.prdefined.contents";   //$NON-NLS-1$
	
	public String POINTER_STRING= "cpp.pointer.string"; //$NON-NLS-1$
	public String REFERENCE_STRING= "cpp.reference.string"; //$NON-NLS-1$
	
	public String INCLUDES= "class.header.includes"; //$NON-NLS-1$
	public String BODY_INCLUDES= "class.body.includes"; //$NON-NLS-1$
	
	public String GLOBAL_DEFINITIONS= "package.definitions"; //$NON-NLS-1$
	public String PACKAGE_INCLUDES= "package.header.includes"; //$NON-NLS-1$
	
	public String CONSTRUCTOR_IMPLEMENATION= "class.header.constructor.impl"; //$NON-NLS-1$
	public String HEADER_INLINE_FUNCTION_CONTENTS= "class.header.inline.function.contents"; //$NON-NLS-1$
	
	public String PREDEFINED_OPERATORS_IMPLEMENTATION= "cpp.predefined.operators.implementation"; //$NON-NLS-1$
	
	public String CLASS_DECLARATIONS= "class.declarations"; //$NON-NLS-1$
	public String CLASS_DECLARATIONS_EXTENSION= "class.declarations.extension"; //$NON-NLS-1$
	
	public String FRIEND_SETTER_DECLARATION= "cpp.friend.setter.declaration";	 //$NON-NLS-1$
	public String FRIEND_SETTER_IMPLEMENTATION= "cpp.friend.setter.implementation";	 //$NON-NLS-1$
	
}
