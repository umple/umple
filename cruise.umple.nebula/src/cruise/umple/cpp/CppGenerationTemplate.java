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
package cruise.umple.cpp;

import cruise.umple.core.GenerationCallback;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.IGenerationProcdure;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppHandlerDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppMethods;
import cruise.umple.templates.GenerationTemplateDelegator;
import cruise.umple.templates.IGenerationTemplate;
import cruise.umple.templates.IGenerationTemplateRegistry;

public abstract class CppGenerationTemplate implements IGenerationTemplate, IGenerationTemplateRegistry, 
						ICppHandlerDefinitions, IModelingElementDefinitions, ICppMethods, ICppDefinitions{
	
	private GenerationPolicyRegistry instance;
	private GenerationTemplateDelegator generationTemplateDelegator;
	
	public void init(GenerationPolicyRegistry generationPolicyRegistry){
		this.instance= generationPolicyRegistry;
		this.generationTemplateDelegator= new GenerationTemplateDelegator(this.instance);
		this.define();
	}
	
	@Override
	public GenerationPolicyRegistry getRegistry() {
		return this.instance;
	}
	
	public void define(String id, GenerationCallback callback){
		this.generationTemplateDelegator.define(this, id, callback);
	}
	
	public void define(IGenerationTemplateRegistry generationTemplateRegistry, String id, GenerationCallback callback){
		this.generationTemplateDelegator.define(generationTemplateRegistry, id, callback);
	}
	
	@Override
	public void define(String id, IGenerationProcdure... callback) {
		this.generationTemplateDelegator.define(id, callback);
	}
	
	@Override
	public String generate(String id, Object element, Object... arguments) {
		return this.generationTemplateDelegator.generate(id, element, arguments);
	}
	
	@Override
	public String use(String id, Object... arguments) {
		return this.generationTemplateDelegator.use(id, arguments);
	}
	
	@Override
	public String indent(String string, int level) {
		return StringUtil.indent(string, level);
	}
	
	/** Must be protected and only protected as it is designed to be implemented by sub classes, but not to be called externally */
	protected abstract String define();

}