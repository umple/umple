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
package cruise.umple.values;

import java.lang.reflect.Method;

import cruise.umple.core.GenerationPolicyRegistry;


public class MethodDescriptor{
	private Method fMethod;
	private Object fInstance;
	
	public MethodDescriptor(Method method, Object instance) {
		this.fMethod = method;
		this.fInstance= instance;
	}

	public Object invoke(Object element, GenerationPolicyRegistry generationValueGetter, Object... arguments){
		Object[] parameters = GenerationPolicyRegistry.getParametersValues(element, generationValueGetter, null, this.fMethod, true, null, arguments);
		if(parameters== null){
			return null;
		}
		try {
			return this.fMethod.invoke(this.fInstance, parameters);
		}catch (Exception e) {
			generationValueGetter.getGenerationLogger().addError(e);
			return null;
		}
	}
	
}