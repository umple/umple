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
package cruise.umple.cpp.core;

public class ContentsDescriptor{

	private String fContents;
	private String fFileName;
	private String fPath;
	
	public ContentsDescriptor(String contents, String fileName, String path) {
		this.fContents = contents;
		this.fFileName = fileName;
		this.fPath = path;
	}

	public String getContents() {
		return this.fContents;
	}

	public String getFileName() {
		return this.fFileName;
	}


	public String getPath() {
		return this.fPath;
	}

}
