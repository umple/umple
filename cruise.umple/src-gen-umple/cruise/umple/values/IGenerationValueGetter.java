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

import java.util.List;

public interface IGenerationValueGetter {

	public boolean getBoolean(Object classObject, String fieldName, Object... arguments);
	
	public Object getObject(Object classObject, String fieldName, Object... arguments);
	
	public int getInt(Object classObject, String fieldName, Object... arguments);
	
	public String getString(Object classObject, String fieldName, Object... arguments);
	
	public List<?> getList(Object classObject, String fieldName, Object... arguments);
	
	public void register(Object handler);
	
}
