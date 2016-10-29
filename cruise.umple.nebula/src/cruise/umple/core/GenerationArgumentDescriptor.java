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

import java.util.Objects;

public class GenerationArgumentDescriptor{
	private String fId;
	private Object fValue;
	
	public static GenerationArgumentDescriptor arg(String id, Object value){
		return new GenerationArgumentDescriptor(id, value);
	}
	
	private GenerationArgumentDescriptor(String id, Object value) {
		this.fId= id;
		this.fValue= value;
	}
	
	public String id(){
		return this.fId;
	}
	
	public Object value(){
		return this.fValue;
	}
	
	@Override
	public String toString() {
		String value= this.getClass().getName() + "@" + Integer.toHexString(Objects.hashCode(this));
		return this.id()+ CommonConstants.UNDERSCORE+ value;
	}
}