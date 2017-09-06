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
package cruise.umple.cpp.generator;

import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.cpp.processors.CppPoliciesProcessor;
import cruise.umple.modeling.handlers.cpp.FixmlPointsHandler;

public abstract class UmpleCppPoliciesProcessor extends CppPoliciesProcessor{

	@Override
	public void registerTypesPolicies(){
		GenerationPolicyRegistry generationPolicyRegistry = this.getGenerationPolicyRegistry();
		
		generationPolicyRegistry.registerGenerationPolicy(new UmpleModelGenerationPolicy());
		generationPolicyRegistry.registerGenerationPolicy(new UmpleStatemachineGenerationPolicy());
		generationPolicyRegistry.registerGenerationPolicy(new UmpleStructureGenerationPolicy());
	}
	
	@Override
	public void registerGenerationPoints(){
		GenerationPolicyRegistry generationPolicyRegistry = this.getGenerationPolicyRegistry();
		super.registerGenerationPoints();
		
		
		generationPolicyRegistry.register(new FixmlPointsHandler());
	}


}
