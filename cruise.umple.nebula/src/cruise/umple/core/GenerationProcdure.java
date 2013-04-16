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
package cruise.umple.core;

import cruise.umple.cpp.CppGenerationTemplate;

public abstract class GenerationProcdure implements IGenerationProcdure{

	private CppGenerationTemplate fGenerationTemplate;
	
	public GenerationProcdure(CppGenerationTemplate generationTemplate) {
		this.fGenerationTemplate= generationTemplate;
	}
	
	@Override
	public StringBuffer doExecute(Object element, GenerationPolicyRegistry registry, Object... arguments) {
		registry.setFieldsParameters(this, element, this.getClass().getDeclaredFields(), arguments);
		return execute(element, arguments);
	}
	
	abstract public StringBuffer execute(Object element, Object... arguments);
	
	/* (non-Javadoc)
	 * @see umple.core.IGenerationProcdure#getGenerationTemplate()
	 */
	public CppGenerationTemplate getGenerationTemplate() {
		return this.fGenerationTemplate;
	}
	
	/* (non-Javadoc)
	 * @see umple.core.IGenerationProcdure#enabled()
	 */
	@Override
	public boolean enabled() {
		return true;
	}
	
}
