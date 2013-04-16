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

public interface ICppUmpleDefinitions {
	
	public final String RESET_NAME= "reset.method.name"; //$NON-NLS-1$
	public final String SINGLETON_CALL= "singleton.call"; //$NON-NLS-1$
	public final String DEFAULT_NAME= "default.method.name"; //$NON-NLS-1$
	public final String NEXT_NAME= "next.attribute.name"; //$NON-NLS-1$
	public final String RESET_IMPLEMENTATION= "reset.method.implementation"; //$NON-NLS-1$
	public final String DEFAULT_GETTER_IMPLEMENTATION= "default.getter.method.implementation"; //$NON-NLS-1$
	
	public final static String AUTOUNIQUE_ATTRIBUTE_DECLARATIONS= "cpp.umple.autounique.attribute.declarations"; //$NON-NLS-1$
	public final static String SINGLETON_TEMPLATE_DEFINITION= "cpp.template.definition"; //$NON-NLS-1$
	
	public final String CONSTRAINT_MESSAGE= "constraint message"; //$NON-NLS-1$
}
