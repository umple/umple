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
package cruise.umple.cpp.processors;

import java.util.ArrayList;
import java.util.List;

import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.Generator;
import cruise.umple.core.IPoliciesProcessor;
import cruise.umple.cpp.core.ContentsDescriptor;
import cruise.umple.cpp.core.IGenerationCommonConstants;
import cruise.umple.modeling.handlers.ModelingAssociationsGenerationPointsHandler;
import cruise.umple.modeling.handlers.ModelingBaseGenerationPointsHandler;
import cruise.umple.modeling.handlers.cpp.CPPContentsPointsHandler;
import cruise.umple.modeling.handlers.cpp.CppStatemachinePointsHandler;
import cruise.umple.modeling.handlers.cpp.StructurePointsHandler;

abstract public class CppPoliciesProcessor implements IPoliciesProcessor{
	
	
	private GenerationPolicyRegistry generationPolicyRegistry = new GenerationPolicyRegistry();
	private Generator generator;
	
	public void generateRootElement(Object rootElement) {
		this.getGenerationPolicyRegistry().rootElement= rootElement;
		this.getGenerationPolicyRegistry().process(rootElement);
		this.handleGeneratedContents(getContentDescriptors());
		//this.generationPolicyRegistry.getGenerationLogger().showLogDetails();
	}
	
	abstract public void handleGeneratedContents(List<ContentsDescriptor> contentsDescriptor);
	
	public CppPoliciesProcessor() {
		generator= new Generator(generationPolicyRegistry);
		generationPolicyRegistry.generator= generator;
		
		registerTypesPolicies();
		registerGenerationPoints();
	}
	
	@Override
	public void registerGenerationPoints(){
		this.getGenerationPolicyRegistry().register(new ModelingAssociationsGenerationPointsHandler());
		this.getGenerationPolicyRegistry().register(new ModelingBaseGenerationPointsHandler());
		
		this.getGenerationPolicyRegistry().register(new CPPContentsPointsHandler());
		
		this.getGenerationPolicyRegistry().register(new CppStatemachinePointsHandler());
		this.getGenerationPolicyRegistry().register(new StructurePointsHandler());
		
		//this.getGenerationPolicyRegistry().register(new CppTestsPointsHandler());
	}
	
	public List<ContentsDescriptor> getContentDescriptors(){
		List<Object> values = this.generationPolicyRegistry.getValues(IGenerationCommonConstants.CONTENTS_DESCRIPTORS);
		List<ContentsDescriptor> descriptors= new ArrayList<ContentsDescriptor>();
		if(values!= null){
			for(Object obj: values){
				if(obj instanceof ContentsDescriptor){
					descriptors.add((ContentsDescriptor) obj);
				}
			}
			return descriptors;
		}
		
		return descriptors;
	}
	
	@Override
	public GenerationPolicyRegistry getGenerationPolicyRegistry() {
		return this.generationPolicyRegistry;
	}

}
