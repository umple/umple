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
package cruise.umple.modeling.handlers;

import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.cpp.utils.CPPTypesConstants;

public class ModelingBaseDecisionPointsHandler{
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_MANY)
	public static boolean isMany(@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound){
		return upperBound==-1|| upperBound>1;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_MANY)
	public static boolean isOtherEndMany(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int otherEndUpperBound){
		return otherEndUpperBound==-1|| otherEndUpperBound>1;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND)
	public static boolean isOtherEndUnbound(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int otherEndUpperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_LOWER_BOUND) int otherEndLowerBound){
		return otherEndUpperBound==-1&& otherEndLowerBound==0;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_UNBOUND)
	public static boolean isUnbound(@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound){
		return upperBound==-1&& lowerBound==0;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_OPTIONAL)
	public static boolean isOptional(@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound){
		return upperBound==1&& lowerBound==0;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_ONE)
	public static boolean isOne(@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound){
		return upperBound==1&& lowerBound==1;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_FIXED)
	public static boolean isFixed(@GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound,
								  @GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound){
		//Looking for whatever -- 4; whatever -- 8
		//Not: whatever -- 1; whatever -- *
		return upperBound>1&& lowerBound== upperBound;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED)
	public static boolean isOtherEndFixed(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int otherEndUpperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_LOWER_BOUND) int otherEndLowerBound){
		return otherEndUpperBound>1&& otherEndLowerBound== otherEndUpperBound;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL)
	public static boolean isOtherEndOptional(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int otherEndUpperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_LOWER_BOUND) int otherEndLowerBound){
		return otherEndUpperBound==1&& otherEndLowerBound==0;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL)
	public static boolean isOtherEndRangedOptional(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int otherEndUpperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_LOWER_BOUND) int otherEndLowerBound){
		
		//0.4 -- 0..1 Relation1;
		return otherEndUpperBound>1&& otherEndUpperBound!=-1&& otherEndLowerBound==0;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL)
	public static boolean isRangedOptional(@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound){
		
		//0..1 -- 0..4 Relation1;
		return upperBound>1&& upperBound!=-1&& lowerBound==0&& upperBound!=lowerBound;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY)
	public static boolean isRangedMandatory(@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound){
		
		//Is: 0..1 -- 1..4 Relation5;	0..1 -- 2..4 Relation7;
		//Not:	0..1 -- 1..* Relation6; 
		return upperBound>1&& upperBound!=-1&& lowerBound>0&& upperBound!=lowerBound;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY)
	public static boolean isOtherEndRangedMandatory(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int otherEndUpperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_LOWER_BOUND) int otherEndLowerBound){
		
		//Is: 1..4 -- 0..1 Relation5;	2..4 -- 0..1 Relation7;
		//Not:	1..* -- 0..1 Relation6; 
		return otherEndUpperBound>1&& otherEndUpperBound!=-1&& otherEndLowerBound>0&& otherEndUpperBound!=otherEndLowerBound;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND)
	public static boolean isRangedUnbound(@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound){
		
		//Is:	0..1 -- 1..* Relation6; 
		return upperBound==-1&& lowerBound>=1;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND)
	public static boolean isOtherEndRangedUnbound(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int otherEndUpperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_LOWER_BOUND) int otherEndLowerBound){
		
		//Is:	1..* -- 0..1 Relation6; 
		return otherEndUpperBound==-1&& otherEndLowerBound>=1;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE)
	public static boolean isOtherEndOne(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int otherEndUpperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_LOWER_BOUND) int otherEndLowerBound){
		return otherEndUpperBound==1&& otherEndLowerBound==1;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.HAS_MAXIMUM_GETTER)
	public static boolean hasMaximumFunction(@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound){
		
		//Unbound "*" relations do not have "maximum number" of function.
		return upperBound>1 && upperBound!=-1;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.HAS_MINIMUM_GETTER)
	public static boolean hasMinimumFunction(@GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound){
		return lowerBound>0;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.IS_BOOLEAN)
	public static boolean isBoolean(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName){
		return CPPTypesConstants.BOOL.equals(typeName);
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.HAS_OTHER_MAXIMUM_GETTER)
	public static boolean hasOtherMaximumFunction(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int upperBound){
		
		//Unbound "*" relations do not have "maximum number" of function.
		return upperBound>1 && upperBound!=-1;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.HAS_OTHER_MINIMUM_GETTER)
	public static boolean hasOtherMinimumFunction(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_LOWER_BOUND) int lowerBound){
		return lowerBound>0;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_DIRECTED)
	public static boolean isDirected(@GenerationElementParameter(id = IModelingElementDefinitions.IS_OTHER_END_NAVIGABLE) boolean otherEndNavigable){
		return !otherEndNavigable;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.CAN_CONSTRUCT)
	public static boolean canConstruct(@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_UPPER_BOUND) int otherEndUpperBound, 
			  @GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_LOWER_BOUND) int otherEndLowerBound,
			  @GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany){
		//Only accepted if from many (different kinds, even optional many) to one and only one.
		//Examples:   1 -- 2 M; 1 -- 2..4 H; 1 -- 1..3 Y;  1 -- 2..* X;  1 -- 0..* U;  1 -- 1..* W; 1 -- 5..5 F; 1 -- 2..4 H;
		//  		 1 -- 1..3 Y; 1 -- 2..* X; 1 -- 1..* W; 1 -- 5 Q;1 -- * T;
		if(!isMany){
			return false;
		}
		
		return otherEndUpperBound== otherEndLowerBound&& otherEndUpperBound==1;
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.ATTRIBUTE_IS_SETTABLE)
	public static boolean isSettable(@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic){
		//Disable having direct set method for the constat/static attributes, and avoid setting values for them at the construction time
		return !isConstant&& !isStatic;
	}
	
}