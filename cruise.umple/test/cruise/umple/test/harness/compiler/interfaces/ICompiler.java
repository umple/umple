/*******************************************************************************
* Copyright (c) 2016 Ahmed M.Orabi, Mahmoud M.Orabi.
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
package cruise.umple.test.harness.compiler.interfaces;


public interface ICompiler {
	String getlanguage();
	boolean isEnabled();
	
	IMemoryLanguageObjectBuilder<?> getObjectBuiler();
	void addFile(String fullyQualifiedName, String code);
	
	void compile();
	String run(String mainClass, int timeout);
	void clean();
	void close();
	
	void setTempPath(String path);
}
