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
import cruise.umple.core.IPoliciesProcessor;
import cruise.umple.cpp.core.ContentsDescriptor;
import cruise.umple.cpp.core.IGenerationCommonConstants;
import cruise.umple.cpp.jet.CppHeader;
import cruise.umple.cpp.jet.CppStatemachine;
import cruise.umple.cpp.jet.util.CppAddHandler;
import cruise.umple.cpp.jet.util.CppAttributeGetterImpl;
import cruise.umple.cpp.jet.util.CppAttributeSetterImpl;
import cruise.umple.cpp.jet.util.CppConstructor;
import cruise.umple.cpp.jet.util.CppNameHelper;
import cruise.umple.cpp.jet.util.CppStlTemplateHelper;
import cruise.umple.cpp.jet.util.CppTemplateHelper;
import cruise.umple.modeling.handlers.IModelingPriorityHandler;
import cruise.umple.modeling.handlers.IModelingStatemachinePriorityHandler;
import cruise.umple.modeling.handlers.ModelingAssociationsGenerationPointsHandler;
import cruise.umple.modeling.handlers.ModelingBaseDecisionPointsHandler;
import cruise.umple.modeling.handlers.ModelingBaseGenerationPointsHandler;
import cruise.umple.modeling.handlers.ModelingConstructorPointsHandler;
import cruise.umple.modeling.handlers.cpp.CPPBaseGenerationPointsHandler;
import cruise.umple.modeling.handlers.cpp.CPPContentsPointsHandler;
import cruise.umple.modeling.handlers.cpp.CPPDependsPointsHandler;
import cruise.umple.modeling.handlers.cpp.CppCustomGetterFunctionsPointsHandler;
import cruise.umple.modeling.handlers.cpp.CppStatemachinePointsHandler;
import cruise.umple.modeling.handlers.cpp.ICppModelingPriorityHandler;
import cruise.umple.modeling.handlers.cpp.StlGenerationPointsHandler;


abstract public class CppPoliciesProcessor implements IPoliciesProcessor{
	
	private GenerationPolicyRegistry generationPolicyRegistry = new GenerationPolicyRegistry();
	
	public void generateRootElement(Object rootElement) throws Exception {
		this.getGenerationPolicyRegistry().process(rootElement);
		this.handleGeneratedContents(getContentDescriptors());
	}
	
	abstract public void handleGeneratedContents(List<ContentsDescriptor> contentsDescriptor);

	public CppPoliciesProcessor() {
		registerTypesPolicies();
		registerGenerationPoints();
		registerHelperTemplates();
	}

	public void registerHelperTemplates(){
		new CppTemplateHelper().init(this.getGenerationPolicyRegistry());
		new CppAttributeGetterImpl().init(this.getGenerationPolicyRegistry());
		new CppNameHelper().init(this.getGenerationPolicyRegistry());
		new CppAddHandler().init(this.getGenerationPolicyRegistry());
		new CppAttributeSetterImpl().init(this.getGenerationPolicyRegistry());
		new CppHeader().init(this.getGenerationPolicyRegistry());
		new CppStatemachine().init(this.getGenerationPolicyRegistry());
		new CppConstructor().init(this.getGenerationPolicyRegistry());
		new CppStlTemplateHelper().init(this.getGenerationPolicyRegistry());
	}
	
	public void registerGenerationPoints(){
		this.getGenerationPolicyRegistry().register(IModelingPriorityHandler.class);
		this.getGenerationPolicyRegistry().register(ICppModelingPriorityHandler.class);
		this.getGenerationPolicyRegistry().register(IModelingStatemachinePriorityHandler.class);
		
		this.getGenerationPolicyRegistry().register(new ModelingConstructorPointsHandler());
		this.getGenerationPolicyRegistry().register(new ModelingAssociationsGenerationPointsHandler());
		this.getGenerationPolicyRegistry().register(new ModelingBaseDecisionPointsHandler());
		this.getGenerationPolicyRegistry().register(new ModelingBaseGenerationPointsHandler());
		
		this.getGenerationPolicyRegistry().register(new CPPBaseGenerationPointsHandler());
		this.getGenerationPolicyRegistry().register(new StlGenerationPointsHandler());
		this.getGenerationPolicyRegistry().register(new CppCustomGetterFunctionsPointsHandler());
		this.getGenerationPolicyRegistry().register(new CPPDependsPointsHandler());
		this.getGenerationPolicyRegistry().register(new CPPContentsPointsHandler());
		
		this.getGenerationPolicyRegistry().register(new CppStatemachinePointsHandler());
		
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
