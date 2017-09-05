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
package cruise.umple.modeling.handlers.cpp;

public interface ICppStatemachinesDefinitions {
	
	public static final String THREAD= "Thread"; //$NON-NLS-1$
	public static final String DO_ACTIVITY_IMPLEMENTATION= "cpp.do.activity.implementation";  //$NON-NLS-1$
	
	public static final String EVENT_STATUS= "cpp.statemachine.event.status"; //$NON-NLS-1$
	public static final String EVENT_STATES= "cpp.statemachine.event.states"; //$NON-NLS-1$
	
	public static final String NESTED_STATEMACHINES= "nestedStatemachine"; //$NON-NLS-1$
	public static final String IS_START_STATE= "isStartState"; //$NON-NLS-1$
	public static final String IS_HISTORY_STATE= "isHistoryState"; //$NON-NLS-1$
	public static final String STATES= "states"; //$NON-NLS-1$
	public static final String TRANSITIONS= "transitions"; //$NON-NLS-1$
	public static final String EVENTS= "events"; //$NON-NLS-1$
	public static final String ENUM_VALUES= "cpp.statemachine.enum.values"; //$NON-NLS-1$
	public static final String ENUM_CASES_STRING= "cpp.statemachine.enum.cases.strings"; //$NON-NLS-1$
	public static final String ALL_STATES= "cpp.statemachine.all.states"; //$NON-NLS-1$
	
	// entry actions and do activities
	
	public static final String ENUM_GLOBAL_VARIABLE_NAME= "enumGlobalVariableName"; //$NON-NLS-1$
	
	public static final String STATEMACHINES= "statemachines"; //$NON-NLS-1$
	public static final String ALL_STATEMACHINES= "allStatemachines"; //$NON-NLS-1$
	public static final String STATEMACHINE= "statemachine"; //$NON-NLS-1$
	public static final String PARENT_STATEMACHINE= "parentStatemachine"; //$NON-NLS-1$
	public static final String PARENT_STATE= "parentState"; //$NON-NLS-1$
	public static final String START_STATE= "startState"; //$NON-NLS-1$
	public static final String EVENT_STATEMACHINES= "eventStatemachine"; //$NON-NLS-1$
	public static final String EVENT_TRANSITIONS= "eventTransitions"; //$NON-NLS-1$
	public static final String TRANSITION_TARGET_STATE= "transitionTargetState"; //$NON-NLS-1$
	public static final String TRANSITION_SOURCE_STATE= "transitionSourceState"; //$NON-NLS-1$
	public static final String TRANSITION_EFFECT_CODE_BODY= "transitionEffect"; //$NON-NLS-1$
	public static final String TRANSITION_GUARD_CODE_BODY= "transitionGuard"; //$NON-NLS-1$
	public static final String EXITABLE_STATEMACHINE= "exitableStateMachine"; //$NON-NLS-1$
	public static final String IS_SAME_STATE= "isSameState"; //$NON-NLS-1$
	public static final String EVENT_PARAMETERS= "eventParameters"; //$NON-NLS-1$
	
	public static final String EVENT_IS_INTERNAL= "isInternalEvent"; //$NON-NLS-1$
	public static final String TRANSITION_IS_AUTO= "isAutoTransition"; //$NON-NLS-1$
	public static final String EVENT_IS_AUTO= "isAutoEvent"; //$NON-NLS-1$
	public static final String EVENT_IS_TIMER= "isTimerEvent"; //$NON-NLS-1$
	
	public static final String STATE_ENTRY_CODE_BODY= "stateEntry"; //$NON-NLS-1$
	public static final String STATE_EXIT_CODE_BODY= "stateExit"; //$NON-NLS-1$
	public static final String STATE_DO_ACTIVITY_CODE_BODY= "stateDoActivity"; //$NON-NLS-1$
	public static final String STATE_DO_ACTIVITY_ON_COMPLETION_EVENT= "stateDoActivityOnCompletion"; //$NON-NLS-1$
	
	public static final String STATEMACHINES_PROCESSOR= "statemachinesProcessor"; //$NON-NLS-1$
	
}
