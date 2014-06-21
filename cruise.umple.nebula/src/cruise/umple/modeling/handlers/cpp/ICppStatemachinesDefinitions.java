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
	
	public final static String STATEMACHINE_FULL_PATH= "statemachine.full.path"; //$NON-NLS-1$
	public final static String STATEMACHINE_FULL_PATH_IMPLEMENTATION= "statemachine.full.path.implementation"; //$NON-NLS-1$
	public final static String STATEMACHINE_FULL_PATH_SEGMENT= "statemachine.full.path.segment"; //$NON-NLS-1$
	
	public final static String DO_ACTIVITY_BODY_WRAP= "statemachine.do.activity.body.wrap"; //$NON-NLS-1$
	
	public final static String THREAD= "Thread"; //$NON-NLS-1$
	public final static String THREAD_INSTANCE= "statemachine.thread.instance"; //$NON-NLS-1$
	public final static String VOID_POINTER_NAME= "statemachine.void.pointer.name"; //$NON-NLS-1$
	public final static String DO_ACTIVITY_METHOD_INSTANCE= "statemachine.do.activity.method"; //$NON-NLS-1$
	public final static String DO_ACTIVITY_IMPLEMENTATION= "cpp.do.activity.implementation";  //$NON-NLS-1$
	public final static String DO_ACTIVITY_MEDIATOR_IMPLEMENTATION= "cpp.do.activity.mediator.implementation";  //$NON-NLS-1$
	public final static String DO_ACTIVITY_FUNCTION_POINTER_IMPLEMENTATION= "cpp.do.activity.function.pointer.implementation";  //$NON-NLS-1$
	
	public final static String STATEMACHINE_METHOD_IMPLEMENTATION= "cpp.statemachine.events.implementation"; //$NON-NLS-1$
	
	public final static String STATES_SETTER_NAME_DEFINITION= "cpp.statemachine.states.setter.name.definition"; //$NON-NLS-1$
	public final static String INVOKE_STATES_SETTER_DEFINITION= "cpp.statemachine.invoke.states.setter.definition"; //$NON-NLS-1$
	
	public final static String EVENT_STATUS= "cpp.statemachine.event.status"; //$NON-NLS-1$
	public final static String EVENT_STATES= "cpp.statemachine.event.states"; //$NON-NLS-1$
	
	public final static String ENUM= "cpp.statemachine.enum"; //$NON-NLS-1$
	public final static String STATEMCHAINE_EXIT_PROCEDURE_NAME= "cpp.statemachine.exit.procedure.name"; //$NON-NLS-1$
	public final static String STATEMCHAINE_ENTER_PROCEDURE_NAME= "cpp.statemachine.enter.procedure.name"; //$NON-NLS-1$
	public final static String STATEMCHAINE_EXIT_PROCEDURE_DECLARATION= "cpp.statemachine.exit.procedure.declaration"; //$NON-NLS-1$
	public final static String PROCEDURE_CALL_DECLARATION= "cpp.statemachine.procedure.call.declaration"; //$NON-NLS-1$
	public final static String PROCEDURE_CALL_AND_CHECK_DECLARATION= "cpp.statemachine.procedure.call.check.declaration"; //$NON-NLS-1$
	public final static String ENUM_VARIABLE_ASSIGMENT_DEFINITION= "cpp.statemachine.enum.variable.assignment.definition"; //$NON-NLS-1$
	
	public final static String VARIABLE_INSTANCE= "cpp.statemachine.variable.instance"; //$NON-NLS-1$
	public final static String STATUS_SETTER_DEFINITION= "cpp.statemachine.status.setter.definition"; //$NON-NLS-1$
	public final static String ENUM_VARIABLE_PLACEHOLDER_DECLARATION= "cpp.enum.variable.placeholder.declaration"; //$NON-NLS-1$
	public final static String STATEMACHINE_SWITCH_CASE_DECLARATION= "cpp.statemachine.switch.case"; //$NON-NLS-1$
	public final static String STATEMACHINE_PROCESSED_CASE= "cpp.statemachine.processed.case"; //$NON-NLS-1$
	
	public final static String NESTED_STATEMACHINES= "nestedStatemachine"; //$NON-NLS-1$
	public final static String IS_START_STATE= "isStartState"; //$NON-NLS-1$
	public final static String STATES= "states"; //$NON-NLS-1$
	public final static String TRANSITIONS= "transitions"; //$NON-NLS-1$
	public final static String EVENTS= "events"; //$NON-NLS-1$
	public final static String ENUM_VALUES= "cpp.statemachine.enum.values"; //$NON-NLS-1$
	public final static String ENUM_CASES_STRING= "cpp.statemachine.enum.cases.strings"; //$NON-NLS-1$
	public final static String ALL_STATES= "cpp.statemachine.all.states"; //$NON-NLS-1$
	public final static String STATEMCHAINE_EXIT_PROCEDURE_IMPLEMENTATION= "cpp.statemachine.exit.procedure.implementation"; //$NON-NLS-1$
	public final static String STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION= "cpp.statemachine.exit.procedure.state.implementation"; //$NON-NLS-1$
	public final static String STATEMCHAINE_ENTRY_PROCEDURE_STATE_CONTENTS= "cpp.statemachine.entry.procedure.state.contents"; //$NON-NLS-1$
	public final static String STATEMCHAINE_NESTED_STATE_BODY= "cpp.statemachine.nested.state.body"; //$NON-NLS-1$
	public final static String SETTER_SWITCH_COMMENT= "cpp.setter.switch.comment"; //$NON-NLS-1$
	public final static String ENUM_USE= "cpp.enum.use"; //$NON-NLS-1$
	
	// entry actions and do activities
	
	public final static String ENUM_GLOBAL_VARIABLE_NAME= "enumGlobalVariableName"; //$NON-NLS-1$
	
	public final static String STATEMACHINES= "statemachines"; //$NON-NLS-1$
	public final static String ALL_STATEMACHINES= "allStatemachines"; //$NON-NLS-1$
	public final static String STATEMACHINE= "statemachine"; //$NON-NLS-1$
	public final static String OWING_STATEMACHINE= "owingSstatemachine"; //$NON-NLS-1$
	public final static String OWING_STATE= "parentState"; //$NON-NLS-1$
	public final static String START_STATE= "startState"; //$NON-NLS-1$
	public final static String EVENT_STATEMACHINES= "eventStatemachine"; //$NON-NLS-1$
	public final static String EVENT_TRANSITIONS= "eventTransitions"; //$NON-NLS-1$
	public final static String TRANSITION_TARGET_STATE= "transitionTargetState"; //$NON-NLS-1$
	public final static String TRANSITION_SOURCE_STATE= "transitionSourceState"; //$NON-NLS-1$
	public final static String TRANSITION_EFFECT_CODE_BODY= "transitionEffect"; //$NON-NLS-1$
	public final static String TRANSITION_GUARD_CODE_BODY= "transitionGuard"; //$NON-NLS-1$
	public final static String EXITABLE_STATEMACHINE= "exitableStateMachine"; //$NON-NLS-1$
	public final static String IS_SAME_STATE= "isSameState"; //$NON-NLS-1$
	public final static String EVENT_PARAMETERS= "eventParameters"; //$NON-NLS-1$
	
	public final static String EVENT_IS_INTERNAL= "isInternalEvent"; //$NON-NLS-1$
	public final static String TRANSITION_IS_AUTO= "isAutoTransition"; //$NON-NLS-1$
	public final static String EVENT_IS_AUTO= "isAutoEvent"; //$NON-NLS-1$
	public final static String EVENT_IS_TIMER= "isTimerEvent"; //$NON-NLS-1$
	
	public final static String STATE_ENTRY_CODE_BODY= "stateEntry"; //$NON-NLS-1$
	public final static String STATE_EXIT_CODE_BODY= "stateExit"; //$NON-NLS-1$
	public final static String STATE_DO_ACTIVITY_CODE_BODY= "stateDoActivity"; //$NON-NLS-1$
	public final static String STATE_DO_ACTIVITY_ON_COMPLETION_EVENT= "stateDoActivityOnCompletion"; //$NON-NLS-1$
	
	public final static String STATEMCHAINE_THREAD_USE_DECLARATION= "cpp.statemachine.thread.use.declaration"; //$NON-NLS-1$
	public final static String STATEMCHAINE_THREAD_CONSTRUCTOR_DECLARATION= "cpp.statemachine.thread.constructor.declaration"; //$NON-NLS-1$
	
	public final static String STATEMACHINES_PROCESSOR= "statemachinesProcessor"; //$NON-NLS-1$
}
