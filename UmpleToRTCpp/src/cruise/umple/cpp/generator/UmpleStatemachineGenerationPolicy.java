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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cruise.umple.compiler.Action;
import cruise.umple.compiler.Activity;
import cruise.umple.compiler.ConstraintTree;
import cruise.umple.compiler.Event;
import cruise.umple.compiler.Guard;
import cruise.umple.compiler.Position;
import cruise.umple.compiler.State;
import cruise.umple.compiler.StateMachine;
import cruise.umple.compiler.Transition;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationValueAnnotation;
import cruise.umple.cpp.util.UmpleCPPGenerationUtil;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppStatemachinesDefinitions;

public class UmpleStatemachineGenerationPolicy{
	
	private static final String EXIT = "exit"; //$NON-NLS-1$
	private static final String ENTRY = "entry"; //$NON-NLS-1$
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.STATEMACHINES)
	public static List<?> getStatemachines(@GenerationBaseElement UmpleClass umpleClass){
		return umpleClass.getStateMachines();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.ALL_STATEMACHINES)
	public static List<?> getAllStatemachines(@GenerationBaseElement UmpleClass umpleClass){
		return umpleClass.getAllStateMachines();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.EVENT_STATEMACHINES)
	public static List<?> getStatemachines(@GenerationBaseElement UmpleClass umpleClass, 
			Event event){
		return umpleClass.getStateMachines(event);
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.EVENTS)
	public static List<?> getAllEvents(@GenerationBaseElement UmpleClass umpleClass){
		return umpleClass.getEvents();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.NAME)
	public static String getName(@GenerationBaseElement Object element){
		if(element instanceof State){
			return ((State)element).getName();
		}else if(element instanceof Transition){
			//TODO: Do we need to have an explicit name for transition?
			//Mostly yes, as this is the behaviour in normal UML models as the transition
			//is an instance of NamedElement
			//Return the event name for now
			return ((Transition)element).getEvent().getName();
		}else if(element instanceof StateMachine){
			return ((StateMachine)element).getName();
		}else if(element instanceof Event){
			return ((Event)element).getName();
		}
		return null;
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.TRANSITIONS)
	public static List<?> getTransitions(@GenerationBaseElement State element){
		return element.getTransitions();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.NESTED_STATEMACHINES)
	public static List<?> getNestedStateMachines(@GenerationBaseElement State element){
		return element.getNestedStateMachines();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.STATEMACHINE)
	public static StateMachine getStateMachine(@GenerationBaseElement State element){
		return element.getStateMachine();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.IS_START_STATE)
	public static boolean isStartState(@GenerationBaseElement State element){
		return element.isIsStartState();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.EVENT_TRANSITIONS)
	public static List<Transition> getEventTransitions(@GenerationBaseElement State element, 
			Event event){
		return element.getTransitionsFor(event);
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.EXITABLE_STATEMACHINE)
	public static StateMachine getExitableStatemachine(@GenerationBaseElement State element,
			State nextState){
		return element.exitableStateMachine(nextState);
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.IS_HISTORY_STATE)
	public static boolean isHistory(@GenerationBaseElement State state){
		return state.isIsHistoryState();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.IS_SAME_STATE)
	public static boolean isSameState(@GenerationBaseElement State element,
			State state, StateMachine relativeTo){
		return element.isSameState(state, relativeTo);
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.EVENTS)
	public static List<?> getEvents(@GenerationBaseElement Transition element){
		//TODO: It would be better for a transition to have multi-events
		return Arrays.asList(new Object[]{element.getEvent()});
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.TRANSITION_IS_AUTO)
	public static boolean isAuto(@GenerationBaseElement Transition element){
		return element.isAutoTransition();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.TRANSITION_TARGET_STATE)
	public static State getTransitionTargetState(@GenerationBaseElement Transition element){
		return element.getNextState();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.TRANSITION_SOURCE_STATE)
	public static State getTransitionSourceState(@GenerationBaseElement Transition element){
		return element.getFromState();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.TRANSITION_EFFECT_CODE_BODY)
	public static String getTransitionEffectCodeBody(@GenerationBaseElement Transition element,
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			String language){
		Action action = element.getAction();
		if(action== null){
			return CommonConstants.BLANK;
		}
		String code = action.getCodeblock().getCode(language);
		if(code== null|| code.isEmpty()){
			code = action.getActionCode();
		}
		
		if(code== null|| code.isEmpty()|| code.equals("null")){ //$NON-NLS-1$
			return CommonConstants.BLANK;
		}
		
		code = addLineNumbersInformation(generationValueGetter, language,  element.getFromState().getStateMachine(), action.getPosition(), code);
		
		return code;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS)
	public static List<ConstraintTree> constraints(@GenerationBaseElement Transition element){
		Guard guard = element.getGuard();
		if(guard== null){
			return Collections.emptyList();
		}
		return Arrays.asList(new ConstraintTree[]{guard});
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.LINE_NUMBERS)
	public static List<String> getLineNumbers(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Transition element,
			@GenerationElementParameter(id = ICppStatemachinesDefinitions.TRANSITION_GUARD_CODE_BODY) String guardBody,
			String language) {
		
		if(guardBody== null|| guardBody.isEmpty()){
			return null;
		}
		
		Guard guard = element.getGuard();
		if(guard== null){
			return null;
		}
		
		String lineInformation = addLineNumbersInformation(generationValueGetter, language,  element.getFromState().getStateMachine(), guard.getPosition());
		return Arrays.asList(new String[]{lineInformation});
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY)
	public static String getStateDoActivityCode(@GenerationBaseElement State element, 
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter,String language){
		Activity activity = element.getActivity();
		if(activity== null){
			return CommonConstants.BLANK;
		}
		
		String code = activity.getCodeblock().getCode(language);
		if(code!= null&& !code.isEmpty()){
			return code;
		}
		
		String activityCode = activity.getActivityCode();
		activityCode = addLineNumbersInformation(generationValueGetter, language,  element.getStateMachine(), activity.getPosition(), activityCode);
		
		return activityCode;
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_ON_COMPLETION_EVENT)
	public static String getStateDoActivityOnCompletionEvent(@GenerationBaseElement State element){
		Activity activity = element.getActivity();
		if(activity== null){
			return CommonConstants.BLANK;
		}
		
		Event onCompletionEvent = activity.getOnCompletionEvent();
		if(onCompletionEvent== null){
			return null;
		}
		
		return onCompletionEvent.getName();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.STATE_ENTRY_CODE_BODY)
	public static String getStateEntryCode(@GenerationBaseElement State element,
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter, String language){
		return getStateActionCode(element, generationValueGetter, language, ENTRY);
	}

	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.STATE_EXIT_CODE_BODY)
	public static String getStateExitCode(@GenerationBaseElement State element, @GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			String language){
		return getStateActionCode(element, generationValueGetter, language, EXIT);
	}
	
	private static String getStateActionCode(State element,	GenerationPolicyRegistry generationValueGetter, String language, String actionID) {
		String entries= CommonConstants.BLANK;
		for(Action action: element.getActions()){
			if(actionID.equals(action.getActionType())){
				String code = action.getCodeblock().getCode(language);
				
				String actionCode = getActionCode(action, code);
				actionCode = addLineNumbersInformation(generationValueGetter, language,  element.getStateMachine(), action.getPosition(), actionCode);
				
				if(!entries.isEmpty()){
					entries= entries+ CommonConstants.NEW_LINE;
				}
				entries= entries+ actionCode;
			}
		}
		return entries;
	}
	
	private static String getPositionString(String language,
			UmpleClass umpleClass, UmpleModel modelPackage, Position position) {
		String positionString= CommonConstants.BLANK;
		if(modelPackage!= null){
			List<String> positions = UmpleCPPGenerationUtil.getPositions(Arrays.asList(new Position[]{position}), 
					language, umpleClass, modelPackage);
			positionString = positions.get(0);
		}
		return positionString;
	}

	private static String getActionCode(Action action, String code) {
		if(code!= null&& !code.isEmpty()){
			return code;
		}
		return action.getActionCode();
	}
	
	private static String addLineNumbersInformation(GenerationPolicyRegistry generationValueGetter, 
			String language, StateMachine statemachine, Position position) {
		return getPositionString(generationValueGetter, language, statemachine, position, CommonConstants.BLANK);
	}
	
	private static String addLineNumbersInformation(GenerationPolicyRegistry generationValueGetter, 
			String language, StateMachine statemachine, Position position, String actionCode) {
		String extended= actionCode;
		
		String positionString = getPositionString(generationValueGetter,
				language, statemachine, position, extended);
		
		if(positionString!= null && !positionString.isEmpty()&& extended!= null&& !extended.isEmpty()){
			extended= positionString+ CommonConstants.NEW_LINE+ extended;
		}
		return extended;
	}

	private static String getPositionString(GenerationPolicyRegistry generationValueGetter, String language,
			StateMachine statemachine, Position position, String extended) {
		UmpleClass umpleClass= null;
		StateMachine statemachineSearch= statemachine;
		while(umpleClass== null&& statemachineSearch!= null){
			umpleClass = statemachineSearch.getUmpleClass();
			State parentState = statemachineSearch.getParentState();
			if(parentState== null){
				break;
			}
			statemachineSearch= parentState.getStateMachine();
		}
		
		if(umpleClass== null){
			return extended;
		}
		
		Object object = generationValueGetter.getPathMap(umpleClass).get(CommonConstants.BLANK);
		UmpleModel modelPackage= object instanceof UmpleModel?(UmpleModel) object: null;
		
		String positionString = getPositionString(language, umpleClass, modelPackage, position);
		return positionString;
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.STATES)
	public static List<?> getStatemachines(@GenerationBaseElement StateMachine element){
		return element.getStates();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.OWING_STATEMACHINE)
	public static StateMachine getOwingStateMachine(@GenerationBaseElement StateMachine element){
		State parentState = element.getParentState();
		if(parentState== null){
			return null;
		}
		return parentState.getStateMachine();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.OWING_STATE)
	public static State getOwingState(@GenerationBaseElement StateMachine element){
		return element.getParentState();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.START_STATE)
	public static State getStartState(@GenerationBaseElement StateMachine element){
		return element.getStartState();
	}
	

	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.EVENT_IS_INTERNAL)
	public static boolean isInternalEvent(@GenerationBaseElement Event element){
		return element.isIsInternal();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.EVENT_IS_AUTO)
	public static boolean isAuto(@GenerationBaseElement Event element){
		return element.isAutoTransition();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.EVENT_IS_TIMER)
	public static boolean isTimer(@GenerationBaseElement Event element){
		return element.getIsTimer();
	}
	
	@GenerationValueAnnotation(fieldName= ICppStatemachinesDefinitions.EVENT_PARAMETERS)
	public static List<String> getEventParameters(@GenerationBaseElement Event element){
		String args = element.getArgs();
		if(args== null|| args.isEmpty()){
			return Collections.emptyList();
		}
		return Arrays.asList(args.split(CommonConstants.COMMA_SEPARATOR));
	}
	
}
