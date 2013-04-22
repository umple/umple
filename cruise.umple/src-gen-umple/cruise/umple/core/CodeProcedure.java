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

import cruise.umple.templates.IGenerationTemplateRegistry;

public abstract class CodeProcedure implements ICodeProcedure{
	
	public StringBuffer stringBuffer = new StringBuffer();
	private IGenerationProcdure generationProcdure;
	protected Object element;

	public CodeProcedure(IGenerationProcdure generationProcdure, Object element, Object... arguments) {
		try {
			this.generationProcdure= generationProcdure;
			this.element= element;
			
			getRegistry().setFieldsParameters(this, this.element, this.getClass().getDeclaredFields(), arguments);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CodeProcedure(IGenerationProcdure generationProcdure) {
		this.generationProcdure= generationProcdure;
		this.element= null;
	}
	
	public GenerationPolicyRegistry getRegistry(){
		return this.generationProcdure.getGenerationTemplate().getRegistry();
	}
	
	public IGenerationTemplateRegistry getInternalRegistry(){
		return this.generationProcdure.getGenerationTemplate();
	}
	
	public IGenerationProcdure getGenerationProcedure(){
		return this.generationProcdure;
	}
	
	public StringBuffer generate(){
		//TODO: Seems not thread safe
		this.stringBuffer= new StringBuffer();
		preExecute();
		execute();
		postExecute();
		return this.stringBuffer;
	}
	
	public static StringBuffer generate(CodeProcedure codeProcedure){
		return codeProcedure.generate();
	}
	
	public void preExecute(){
		//To be implemented if required
	}
	
	public void postExecute(){
		//To be implemented if required
	}
	
	abstract public void execute();
	
	
}