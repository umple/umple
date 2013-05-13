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
package cruise.umple.templates;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.IGenerationProcdure;


public class GenerationTemplateDelegator implements IGenerationTemplateRegistry{
	
	private GenerationPolicyRegistry fRegistry;
	private Map<String, List<GenerationCallback>> invocations= new WeakHashMap<String, List<GenerationCallback>>();
	private List<Class<?>> scanned= new ArrayList<Class<?>>();
	
	private Map<String, List<IGenerationProcdure>> procedureInvocations= new WeakHashMap<String, List<IGenerationProcdure>>();
	
	public GenerationTemplateDelegator(GenerationPolicyRegistry registry) {
		this.fRegistry= registry;
	}

	@Override
	public void define(IGenerationTemplateRegistry generationTemplateRegistry, String id, GenerationCallback callback){
		List<GenerationCallback> list = this.invocations.get(id);
		if(list== null){
			list= new ArrayList<GenerationCallback>();
			this.invocations.put(id, list);
		}else{
			//FIXME
			if(this.scanned.contains(generationTemplateRegistry.getClass())){
				return;
			}
		}
		list.add(callback);
		this.scanned.add(generationTemplateRegistry.getClass());
	}
	
	@Override
	public String generate(String id, Object element, Object... arguments) {
		List<IGenerationProcdure> list = this.procedureInvocations.get(id);
		if(list== null){
			return CommonConstants.BLANK;
		}
		
		StringBuffer results= new StringBuffer();
		for(IGenerationProcdure procedure: list){
			results.append(procedure.doExecute(element, this.fRegistry, arguments));
		}
		return results.toString();
	}
	
	@Override
	public String use(String id, Object... arguments) {
		return generate(id, null, arguments);
	}
	
	@Override
	public void define(String id, IGenerationProcdure... callback) {
		List<IGenerationProcdure> list = this.procedureInvocations.get(id);
		if(list== null){
			list= new ArrayList<IGenerationProcdure>();
			this.procedureInvocations.put(id, list);
		}else{
			//FIXME
			if(this.scanned.contains(callback.getClass())){
				return;
			}
		}
		for(IGenerationProcdure entry: callback){
			list.add(entry);
		}
		
		this.scanned.add(callback.getClass());		
	}
	
	@Override
	public void define(String id, GenerationCallback callback) {
		// TODO Auto-generated method stub
	}


}
