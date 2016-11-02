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

import java.util.ArrayList;
import java.util.List;

public class GenerationLogger {

	private List<LogDescriptor> errors;
	private List<LogDescriptor> infos;
	private List<LogDescriptor> warnings;
	
	public GenerationLogger() {
		this.errors= new ArrayList<LogDescriptor>();
		this.infos= new ArrayList<LogDescriptor>();
		this.warnings= new ArrayList<LogDescriptor>();
	}
	
	public void showLogDetails(){
		StringBuffer contents= new StringBuffer();
		contents.append("Errors:"+ CommonConstants.NEW_LINE); //$NON-NLS-1$
		for(LogDescriptor descriptor: this.errors){
			descriptor.fException.printStackTrace();
			//contents.append(CommonConstants.NEW_LINE+ descriptor.getMessage());
			//contents.append(CommonConstants.NEW_LINE+ descriptor.getExceptionDetails());
		}
		contents.append("-----------------------------------------------------"+ CommonConstants.NEW_LINE); //$NON-NLS-1$
		
		contents.append("Warnings:"+ CommonConstants.NEW_LINE); //$NON-NLS-1$
		for(LogDescriptor descriptor: this.warnings){
			contents.append(CommonConstants.NEW_LINE+ descriptor.getMessage());
			contents.append(CommonConstants.NEW_LINE+ descriptor.getExceptionDetails());
		}
		contents.append("-----------------------------------------------------"+ CommonConstants.NEW_LINE); //$NON-NLS-1$
		
		contents.append("Infos:"+ CommonConstants.NEW_LINE); //$NON-NLS-1$
		for(LogDescriptor descriptor: this.infos){
			contents.append(CommonConstants.NEW_LINE+ descriptor.getMessage());
		}
		System.out.println(contents);
	}
	
	
	public void addError(String error){
		this.errors.add(new LogDescriptor(error));
	}
	
	public void addError(String error, Exception exception){
		this.errors.add(new LogDescriptor(error, exception));
	}
	
	public void addError(Exception exception){
		if(exception== null){
			return;
		}
		this.errors.add(new LogDescriptor(exception));
	}
	
	public void addWarning(String warning){
		this.warnings.add(new LogDescriptor(warning));
	}
	
	public void addWarning(String warning, Exception exception){
		this.warnings.add(new LogDescriptor(warning, exception));
	}
	
	public void addWarning(Exception exception){
		if(exception== null){
			return;
		}
		this.warnings.add(new LogDescriptor(exception));
	}
	
	public void addInfo(String info){
		this.infos.add(new LogDescriptor(info));
	}
	
	private class LogDescriptor{
		String fMessage;
		Exception fException;
		
		public LogDescriptor(String message) {
			this.fMessage= message;
		}
		
		public LogDescriptor(String message, Exception exception) {
			this.fMessage= message;
			this.fException= exception;
		}
		
		public LogDescriptor(Exception exception) {
			this.fMessage= exception.getMessage();
			this.fException= exception;
		}
		
		protected String getMessage(){
			return this.fMessage== null? "[No Message]": this.fMessage; //$NON-NLS-1$
		}
		
		protected String getExceptionDetails(){
			if(this.fException== null){
				return CommonConstants.BLANK;
			}
			
			return this.fException.getStackTrace().toString();
		}
	}
	
}
