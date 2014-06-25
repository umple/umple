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

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationLoopAnnotation;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationPolicyRegistryPriorities;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.IModelingStatemachinePriorityHandler;
import cruise.umple.modeling.handlers.VisibilityConstants;

public class CppStatemachinePointsHandler{
	
	private final static String EXIT_IMPLEMENTATION= "cpp.exit.implementation"; //$NON-NLS-1$
	private static final String EXIT_IMPLEMENTATION_STATE = EXIT_IMPLEMENTATION+ "state"; //$NON-NLS-1$
	private final static String EVENTS_IMPLEMENTATION= "cpp.events.implementation"; //$NON-NLS-1$
	private final static String ENTER_IMPLEMENTATION= "cpp.enter.implementation"; //$NON-NLS-1$
	private final static String SETTERS_IMPLEMENTATION= "cpp.setters.implementation"; //$NON-NLS-1$
	private final static String FULL_NAME_IMPLEMENTATION= "cpp.full.name.implementation"; //$NON-NLS-1$
	
	private final static String AUTO_STATES= "cpp.auto.states.internal"; //$NON-NLS-1$
	
	private final static String TIMER_STATES= "cpp.timer.states.internal"; //$NON-NLS-1$
	
	private final static String STATEMACHINE_VALUES= "cpp.statemachine.values"; //$NON-NLS-1$
	private final static String STATEMACHINE_VARIABLE_VALUES= "cpp.statemachine.variables.values"; //$NON-NLS-1$
	
	@GenerationLoopAnnotation(id = ICppStatemachinesDefinitions.STATEMACHINES_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getNavigableAssociationVariables(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object classInterface){
		return getAllStateMachines(generationValueGetter, classInterface);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, ICppStatemachinesDefinitions.STATEMACHINES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, ICppStatemachinesDefinitions.STATEMACHINES_PROCESSOR})
	})
	public static void setNamespaceDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object statemachine,
			@GenerationLoopElement Object model,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String statemachineQualifiedTypeName = getQualifiedTypeName(generationValueGetter, statemachine);
		
		String enumDefinition = generationValueGetter.getString(parent, IModelingElementDefinitions.NAME)+ 
				CommonConstants.UNDERSCORE + CPPCommonConstants.ENUM.toUpperCase();
		generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACE_OPENING,
				enumDefinition, parent);
		
		generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACE_OPENING, statemachineQualifiedTypeName, statemachine);
		generationValueGetter.addUniqueValue(ICppDefinitions.DEFNIED_NAMESPACES_MACROS,statemachine, parent, model);
	}
	
	@LoopProcessorAnnotation(priority= GenerationPolicyRegistryPriorities.HIEGHEST, aspect= LoopAspectConstants.AFTER, processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	public static void classProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object uClass,
			@GenerationLoopElement Object model,
			@GenerationElementParameter(id = ICppStatemachinesDefinitions.STATEMACHINES) List<?> statemachines){
		elementProcessor(generationValueGetter, statemachines, uClass, model);
	}

	@LoopProcessorAnnotation(priority= GenerationPolicyRegistryPriorities.HIEGHEST, aspect= LoopAspectConstants.AFTER, processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static void interfaceProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationLoopElement Object model,
			@GenerationElementParameter(id = ICppStatemachinesDefinitions.STATEMACHINES) List<?> statemachines){
		elementProcessor(generationValueGetter, statemachines, element, model);
	}
	
	private static void elementProcessor(GenerationPolicyRegistry generationValueGetter, List<?> statemachines, Object element, Object model) {
		if(statemachines==null|| statemachines.isEmpty()){
			return;
		}
		
		generationValueGetter.addUniqueValue(ICppDefinitions.TEMPLATES_DEFINITIONS, generationValueGetter.use(ICppDefinitions.THREAD_IMPLEMENTATION), model);
		generationValueGetter.generationPointString(element, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.ASSERT_LIBRARY),
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		//Locate nested first in order to build nested switch cases
		findNestedExitDetails(generationValueGetter, element);
		
		findEnumVariables(generationValueGetter, element);
		findEventsDetails(generationValueGetter, element);
		findSetterDetails(generationValueGetter, element);
		
		findExitDetails(generationValueGetter, element);
		findEnterImplementations(generationValueGetter, element);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingStatemachinePriorityHandler.STATEMACHINE_EVENTS)
	public static void registerExit(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHODS_GROUPS, IModelingConstants.METHOD_OUTGOING_GROUP),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, EXIT_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PRIVATE));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingStatemachinePriorityHandler.STATEMACHINE_EVENTS)
	public static void registerEnter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHODS_GROUPS, IModelingConstants.METHOD_OUTGOING_GROUP),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ENTER_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PRIVATE));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingStatemachinePriorityHandler.STATEMACHINE_EVENTS)
	public static void registerSetters(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHODS_GROUPS, IModelingConstants.METHOD_OUTGOING_GROUP),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, SETTERS_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PRIVATE));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingStatemachinePriorityHandler.STATEMACHINE_EVENTS)
	public static void registerFullNames(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHODS_GROUPS, IModelingConstants.METHOD_OUTGOING_GROUP),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, FULL_NAME_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_CONTENTS, group= IModelingStatemachinePriorityHandler.STATEMACHINE_EVENTS)
	public static void registerEvents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHODS_GROUPS, IModelingConstants.METHOD_OUTGOING_GROUP),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, EVENTS_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_CONTENTS)
	public static void privateOperationsDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_CONTENTS_REGISTER, 
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID_ARGUMENT, ICppStatemachinesDefinitions.DO_ACTIVITY_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PRIVATE));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_DECLARATIONS, group= IModelingStatemachinePriorityHandler.ENUM_ATTRIBUTES)
	public static String publicStaicAttributesDeclaraions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return getAttributesDeclaraionDetails(generationValueGetter, element, ICppStatemachinesDefinitions.ENUM, VisibilityConstants.PRIVATE);
	}
	
	private static void findEnumVariables(GenerationPolicyRegistry generationValueGetter, Object uClass) {
		List<Object> allStateMachines = getAllStateMachines(generationValueGetter, uClass);
		for(Object statemachine: allStateMachines){
			String statemachineQualifiedTypeName = getQualifiedTypeName(generationValueGetter, statemachine);
			String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(statemachineQualifiedTypeName);
			String languageStatemachineQualifiedTypeName = getEnumQualifiedName(generationValueGetter, uClass, statemachine, statemachineQualifiedTypeName);
			
			List<?> states= generationValueGetter.getList(statemachine, ICppStatemachinesDefinitions.STATES);
			String first= CommonConstants.BLANK;
			String second= CommonConstants.BLANK;
			
			Object parentState = generationValueGetter.getObject(statemachine, ICppStatemachinesDefinitions.OWING_STATE);
			boolean isNested = parentState!= null;
			int comparingSize = states.size();
			
			if(isNested){
				comparingSize++;
			}
			
			if(comparingSize==1){
				if(isNested){
					first= CPPCommonConstants.NIL;
					second= CPPCommonConstants.NIL;
				}else{
					first= generationValueGetter.getString(states.get(0), IModelingElementDefinitions.NAME);
					second= generationValueGetter.getString(states.get(0), IModelingElementDefinitions.NAME);
				}
			}else if(comparingSize>1){
				if(isNested){
					first= CPPCommonConstants.NIL;
				}else{
					first= generationValueGetter.getString(states.get(0), IModelingElementDefinitions.NAME);
				}
				second= generationValueGetter.getString(states.get(states.size()-1), IModelingElementDefinitions.NAME);
			}
			
			String enumValues = generationValueGetter.generationPointString(statemachine, ICppStatemachinesDefinitions.ENUM_VALUES,
					Boolean.valueOf(isNested));
			
			@SuppressWarnings("unchecked")
			List<Object> statesModified= applyStatesHack(generationValueGetter, (List<Object>) states);
			
			if(!isNested){
				
				String getSMFullName= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_FULL_PATH,statemachineQualifiedTypeName);
				//languageStatemachineQualifiedTypeName
				
				String body= CommonConstants.BLANK;
				
				for(Object nested: allStateMachines){
					if(nested.equals(statemachine)){
						continue;
					}
					
					Object nestedParentState = generationValueGetter.getObject(nested, ICppStatemachinesDefinitions.OWING_STATE);
					if(nestedParentState== null){
						continue;
					}
					
					while(nestedParentState!= null){
						Object nestedSM= generationValueGetter.getObject(nestedParentState, ICppStatemachinesDefinitions.STATEMACHINE);
						if(statemachine.equals(nestedSM)){
							String nestedQualifiedTypeName = getQualifiedTypeName(generationValueGetter, nested);
							String nestedQualifiedName= StringUtil.firstCharacterToLowerCase(nestedQualifiedTypeName);
							String nestedLanguageQualifiedTypeName = getEnumQualifiedName(generationValueGetter, uClass, nested, nestedQualifiedTypeName);
							
							String use = generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_FULL_PATH_SEGMENT, nestedLanguageQualifiedTypeName,
									nestedQualifiedName);
							if(!body.isEmpty()){
								body= body+ CommonConstants.NEW_LINE;
							}
							body= body+ use;
							break;
						}
						nestedParentState = generationValueGetter.getObject(nestedSM, ICppStatemachinesDefinitions.OWING_STATE);
					}
				}
				
				//if(!body.isEmpty()){
				body= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_FULL_PATH_IMPLEMENTATION,statemachineQualifiedName, body);
				
				addMethodDetails(generationValueGetter, FULL_NAME_IMPLEMENTATION, 
						ISTLConstants.STRING, CPPTypesConstants.VOID, StringUtil.indent(body, 1), uClass, null, getSMFullName, 
						VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP);
				//}
			}
			
			List<String> values= new ArrayList<String>();
			for(Object s: statesModified){
				values.add(generationValueGetter.getString(s, IModelingElementDefinitions.NAME));
			}
			generationValueGetter.addValue(STATEMACHINE_VALUES, values, statemachineQualifiedTypeName, uClass);
			
			String stringValues = generationValueGetter.generationPointString(statemachine, ICppStatemachinesDefinitions.ENUM_CASES_STRING,
					Boolean.valueOf(isNested));
			
			String enumImplementation = generationValueGetter.generate(ICppDefinitions.ENUM_IMPLEMENTATION, uClass,
					CommonConstants.UNDERSCORE+ statemachineQualifiedTypeName, 
					enumValues, first, second,stringValues, GenerationArgumentDescriptor.arg(ICppDefinitions.OWING_NAMESPACE_OBJECT, uClass));
			
			generationValueGetter.generationPointString(uClass, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING),
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
			
			generationValueGetter.addValue(ICppDefinitions.ENUM_IMPLEMENTATION, enumImplementation, uClass);
			
			String declaration = generationValueGetter.generate(ICppDefinitions.DECLARE_STATEMENET, statemachine,
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_TYPE_ARGUMENT, languageStatemachineQualifiedTypeName),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_NAME_ARGUMENT, statemachineQualifiedName),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT, new ArrayList<Object>()),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT, null));
			
			generationValueGetter.addUniqueValue(STATEMACHINE_VARIABLE_VALUES, statemachineQualifiedName, uClass);
			generationValueGetter.addUniqueValue(ICppStatemachinesDefinitions.ENUM, declaration, VisibilityConstants.PRIVATE, uClass);
		}
	}

	@SuppressWarnings("unchecked")
	public static void findNestedExitDetails(final GenerationPolicyRegistry generationValueGetter, Object uClass) {
		Map<Object, Object> exitableStatemachines= new HashMap<Object, Object>();
		locateExitableClass(generationValueGetter, exitableStatemachines, uClass);
		findNestedExitDetails(generationValueGetter, uClass, exitableStatemachines);
		
		List<Object> values = generationValueGetter.getValues(AUTO_STATES, uClass);
		if(values== null){
			return;
		}
		
		for(Object item: values){
			if(item instanceof Map== false){
				continue;
			}
			
			Map<Object, Object> map = (Map<Object, Object>) item;
			for(Object sm: map.keySet()){
				List<Object> states = (List<Object>) map.get(sm);
				findExitDetails(generationValueGetter, uClass, exitableStatemachines, sm, states, generationValueGetter.getValues(TIMER_STATES, uClass), true);
			}
		}
	}

	private static void findNestedExitDetails(final GenerationPolicyRegistry generationValueGetter, Object uClass, Map<Object, Object> exitableStatemachines) {
		Map<String,List<Object>> statesMap=new WeakHashMap<String, List<Object>>();
		
		for(Object key: exitableStatemachines.keySet()){
			Object state= exitableStatemachines.get(key);
			String stateName = generationValueGetter.getString(state, IModelingElementDefinitions.NAME);
			List<Object> list = statesMap.get(stateName);
			if(list==null){
				list=new ArrayList<Object>();
				statesMap.put(stateName, list);
			}
			list.add(key);
		}
		
		List<String> orderedNames= new ArrayList<String>(statesMap.keySet());
		Collections.sort(orderedNames, new Comparator<String>() {

			@Override
			public int compare(String string1, String string2) {
				return string1.compareTo(string2);
			}
		});
		
		for(String stateName: orderedNames){
			String allDeclarations = CommonConstants.BLANK;
			String swtichCalls= CommonConstants.BLANK;
			
			List<Object> statesList = statesMap.get(stateName);
			Collections.sort(statesList, new Comparator<Object>() {

				@Override
				public int compare(Object object1, Object object2) {
					int level1= getLevel(object1);
					int level2= getLevel(object2);
					
					if(level1<level2){
						return -1;
					}else if(level1>level2){
						return 1;
					}
					
					String sm1 = generationValueGetter.getString(object1, IModelingElementDefinitions.NAME);
					String sm2 = generationValueGetter.getString(object2, IModelingElementDefinitions.NAME);
					
					return sm1.compareTo(sm2);
				}

				private int getLevel(Object object) {
					int level=0;
					Object sm= generationValueGetter.getObject(object, ICppStatemachinesDefinitions.STATEMACHINE);
					if(sm== null){
						return level;
					}
					
					while (true) {
						sm = generationValueGetter.getObject(sm,ICppStatemachinesDefinitions.OWING_STATEMACHINE);
						if (sm == null) {
							break;
						}
						level++;
					}
					
					return level;
				}
			});
			
			for(Object state:statesList){
				String switchCases = CommonConstants.BLANK;
				
				List<?> list = generationValueGetter.getList(state, ICppStatemachinesDefinitions.NESTED_STATEMACHINES);
				
				for (Object nestedStateMachine : list) {
					List<?> nestedStates = generationValueGetter.getList(nestedStateMachine, ICppStatemachinesDefinitions.STATES);
					if (nestedStates.isEmpty()) {
						continue;
					}
					switchCases= CommonConstants.BLANK;
					String statemachineQualifiedTypeName = getQualifiedTypeName(generationValueGetter, nestedStateMachine);
					String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(statemachineQualifiedTypeName);
					String shortendedQualifiedTypeName= getEnumQualifiedName(generationValueGetter, uClass, nestedStateMachine, statemachineQualifiedTypeName);
					
					allDeclarations = allDeclarations+ generationValueGetter.use(ICppStatemachinesDefinitions.ENUM_VARIABLE_PLACEHOLDER_DECLARATION,
							shortendedQualifiedTypeName, statemachineQualifiedTypeName, statemachineQualifiedName);
					
					String instanceName = generationValueGetter.use(ICppStatemachinesDefinitions.VARIABLE_INSTANCE, statemachineQualifiedTypeName);
					
					for(Object nestedState: nestedStates){
						String nestedStateName = generationValueGetter.getString(nestedState, IModelingElementDefinitions.NAME);
						
						String setter= generationValueGetter.use(ICppStatemachinesDefinitions.STATES_SETTER_NAME_DEFINITION, 
								statemachineQualifiedTypeName);
						
						String body = generationValueGetter.use(
								ICppStatemachinesDefinitions.INVOKE_STATES_SETTER_DEFINITION, setter, shortendedQualifiedTypeName, 
								CPPCommonConstants.NIL);
						
						body= body+ CommonConstants.NEW_LINE+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_PROCESSED_CASE);
						
						switchCases = switchCases+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_SWITCH_CASE_DECLARATION,
								shortendedQualifiedTypeName, nestedStateName, CommonConstants.NEW_LINE+ body);
					}
					
					String use = generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
							instanceName, switchCases);
					
					generationValueGetter.addValue(EXIT_IMPLEMENTATION_STATE, use, state);
					swtichCalls= swtichCalls+ use;
				}
				
				if(!list.isEmpty()){
					allDeclarations = allDeclarations + CommonConstants.NEW_LINE;
				}
			}
			
			String output= allDeclarations+ swtichCalls;
			
			if(!output.trim().isEmpty()){
				String exitProcedureName= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_EXIT_PROCEDURE_NAME, stateName, IModelingElementDefinitions.NAME);
				String body= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_METHOD_IMPLEMENTATION,output);
				
				addMethodDetails(generationValueGetter, EXIT_IMPLEMENTATION, 
						CPPTypesConstants.BOOL, CPPTypesConstants.VOID, StringUtil.indent(body, 1), uClass, null, exitProcedureName, 
						VisibilityConstants.PRIVATE, IModelingConstants.METHOD_OUTGOING_GROUP);
			}
		}
	}

	public static void findEventsDetails(GenerationPolicyRegistry generationValueGetter, Object uClass) {
		List<?> events = generationValueGetter.getList(uClass, ICppStatemachinesDefinitions.EVENTS);
		
		Map<Object, Object> exitableStatemachines= new HashMap<Object, Object>();
		locateExitableClass(generationValueGetter, exitableStatemachines, uClass);
		
		Map<Object, List<Object>> autoStates= new HashMap<Object, List<Object>>();
		Map<Object, List<Object>> timerStates= new HashMap<Object, List<Object>>();
		
		for (Object event : events) {
			boolean isInternal = generationValueGetter.getBoolean(event,ICppStatemachinesDefinitions.EVENT_IS_INTERNAL);
			boolean isAuto = generationValueGetter.getBoolean(event,ICppStatemachinesDefinitions.EVENT_IS_AUTO);
			boolean isTimer = generationValueGetter.getBoolean(event,ICppStatemachinesDefinitions.EVENT_IS_TIMER);
			
			String allDeclarations = CommonConstants.BLANK;
			String swtichCalls= CommonConstants.BLANK;

			List<?> statemachines = generationValueGetter.getList(uClass, ICppStatemachinesDefinitions.EVENT_STATEMACHINES, event);
			
			List<?> eventParametersList = generationValueGetter.getList(event, ICppStatemachinesDefinitions.EVENT_PARAMETERS);
			String eventParameters = GenerationUtil.asStringParameters(eventParametersList);
			
			for (Object sm : statemachines) {
				String switchCases = CommonConstants.BLANK;
				String qualifiedTypeName = getQualifiedTypeName(generationValueGetter, sm);
				String shortendedQualifiedTypeName= getEnumQualifiedName(generationValueGetter, uClass, sm, qualifiedTypeName);
				allDeclarations = allDeclarations+ generationValueGetter.use(ICppStatemachinesDefinitions.ENUM_VARIABLE_PLACEHOLDER_DECLARATION,
						shortendedQualifiedTypeName, qualifiedTypeName, StringUtil.firstCharacterToLowerCase(qualifiedTypeName));
				allDeclarations = allDeclarations + CommonConstants.NEW_LINE;

				String instanceName = generationValueGetter.use(ICppStatemachinesDefinitions.VARIABLE_INSTANCE, qualifiedTypeName);

				List<?> states = generationValueGetter.getList(sm, ICppStatemachinesDefinitions.STATES);
				for (Object state : states) {
					List<?> transitions = generationValueGetter.getList(state, ICppStatemachinesDefinitions.EVENT_TRANSITIONS,event);

					if (transitions.isEmpty()) {
						continue;
					}

					String stateName = generationValueGetter.getString(state, IModelingElementDefinitions.NAME);
					String body= CommonConstants.BLANK;
					
					//TODO: Only for doActivity
					if(exitableStatemachines.get(state)!= null){
						String exitProcedureNameMain= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_EXIT_PROCEDURE_NAME,qualifiedTypeName);
						
						body = body+ generationValueGetter.use(ICppStatemachinesDefinitions.PROCEDURE_CALL_DECLARATION, 
								exitProcedureNameMain)+ CommonConstants.NEW_LINE;
					}
					
					for (Object transition : transitions) {
						Object targetState = generationValueGetter.getObject(transition, ICppStatemachinesDefinitions.TRANSITION_TARGET_STATE);
						
						Object targetStateObject= generationValueGetter.getObject(transition, ICppStatemachinesDefinitions.TRANSITION_TARGET_STATE);
						Object targetStatemachineObject= generationValueGetter.getObject(targetStateObject, ICppStatemachinesDefinitions.STATEMACHINE);
						
						SimpleEntry<Object, Object> exitDetails= exitableStateMachine(generationValueGetter, state, targetStateObject, exitableStatemachines);
						Object exitSm= null;
						String targetStatePath = getQualifiedTypeName(generationValueGetter, targetStatemachineObject);
						if(exitDetails!= null){
							exitSm = exitDetails.getKey();
						}else{
							targetStatePath = getQualifiedTypeName(generationValueGetter, targetStatemachineObject);
						}
						
						
						//FIXME: Weak condition as it is not generic and meant for umple transformation only
						boolean isSameState = generationValueGetter.getBoolean(state, ICppStatemachinesDefinitions.IS_SAME_STATE, targetState, exitSm);

						if(true|| exitSm== null /*&& !isSameState&& !isInternal*/){
							//TODO: Checking for isSame and isInternal makes us avoid having an extra switch case for a state that will never be entered
							if(isAuto){
								List<Object> list = autoStates.get(sm);
								if(list== null){
									list= new ArrayList<Object>();
									autoStates.put(sm, list);
								}
								
								list.add(state);
								exitSm= sm;
							}else if(isTimer){
								List<Object> list = timerStates.get(sm);
								if(list== null){
									list= new ArrayList<Object>();
									timerStates.put(sm, list);
								}
								
								list.add(state);
								exitSm= sm;
							}
						}
						
						if (exitSm != null && (exitSm!=sm|| isTimer) && !isInternal && !isSameState) {

							Object owingState = generationValueGetter.getObject(targetStatemachineObject, ICppStatemachinesDefinitions.OWING_STATE);
							if(owingState== null){
								List<?> list = generationValueGetter.getList(targetStateObject, ICppStatemachinesDefinitions.NESTED_STATEMACHINES);
								if(list.isEmpty()){
									String targetStateName= generationValueGetter.getString(targetStateObject, IModelingElementDefinitions.NAME);
									List<?> targetStatemachineStates = generationValueGetter.getList(targetStatemachineObject, ICppStatemachinesDefinitions.STATES);
									
									//TODO: Hack
									workaround: {
										if(exitDetails== null){
											break workaround; 
										}
										
										Object exitState = exitDetails.getValue();
										
										List<Object> values = generationValueGetter.getValues(STATEMACHINE_VALUES, targetStatePath, uClass);
										if(values.isEmpty()){
											break workaround; 
										}
										
										Object object = values.get(0);
										
										if(object instanceof Collection== false){
											break workaround; 
										}
										
										List<?> collection= (List<?>) object;
										if(collection.contains(targetStateName)){
											break workaround; 
										}
										
										for(Object nested: targetStatemachineStates){
											Object nestedName= generationValueGetter.getString(nested, IModelingElementDefinitions.NAME);
											if(targetStateName.equals(nestedName)){
												List<?> nestedList = generationValueGetter.getList(nested, ICppStatemachinesDefinitions.NESTED_STATEMACHINES);
												if(!nestedList.isEmpty()){
													break workaround;
												}
											}
										}
										
										Object exitStatemachine= generationValueGetter.getObject(exitState, ICppStatemachinesDefinitions.STATEMACHINE);
										if(exitStatemachine== targetStatemachineObject){
											targetStatePath = getQualifiedTypeName(generationValueGetter, exitStatemachine)+
													generationValueGetter.getString(exitState, IModelingElementDefinitions.NAME);
										}
									}
								}
							}
							
							String exitTypeQualifiedName= getQualifiedTypeName(generationValueGetter, exitSm);
							
							String exitProcedureName= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_EXIT_PROCEDURE_NAME, 
									exitTypeQualifiedName);
							
							body = body+ generationValueGetter.use(ICppStatemachinesDefinitions.PROCEDURE_CALL_DECLARATION, 
									exitProcedureName)+ CommonConstants.NEW_LINE;
						}
						
						String effectCode = generationValueGetter.generationPointString(transition, ICppStatemachinesDefinitions.TRANSITION_EFFECT_CODE_BODY);
						if (effectCode != null && !effectCode.isEmpty()) {
							if(!body.isEmpty()){
								body= body+ CommonConstants.NEW_LINE;
								
							}
							effectCode= effectCode.trim();
							body= body+ effectCode;
						}
						
						String targetStateName = generationValueGetter.getString(targetStateObject, IModelingElementDefinitions.NAME);
						
						String setter= generationValueGetter.use(ICppStatemachinesDefinitions.STATES_SETTER_NAME_DEFINITION, targetStatePath);
						
						
						String targetShortendedQualifiedTypeName= getEnumQualifiedName(generationValueGetter, uClass, targetStatemachineObject, targetStatePath);
						
						String nextBody = generationValueGetter.use(ICppStatemachinesDefinitions.INVOKE_STATES_SETTER_DEFINITION, setter, 
								targetShortendedQualifiedTypeName, targetStateName);
						
						nextBody= nextBody+ CommonConstants.NEW_LINE+ 
								generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_PROCESSED_CASE);
						
						String guardCode = generationValueGetter.generationPointString(transition, ICppStatemachinesDefinitions.TRANSITION_GUARD_CODE_BODY);
						if (guardCode!= null&& !guardCode.isEmpty()) {
							
							String guardsComments = 
									generationValueGetter.generationPointString(transition, IModelingConstants.MULTILINE_COMMENTS_STRING);
							
							nextBody= StringUtil.indent(CommonConstants.NEW_LINE+ nextBody, 1);
							nextBody= generationValueGetter.use(ICppDefinitions.IF_CONDITION_BLOCK, guardCode, nextBody);
							
							if(!guardsComments.isEmpty()){
								nextBody= guardsComments + CommonConstants.NEW_LINE+ nextBody;
							}
							
							nextBody= nextBody+ CommonConstants.NEW_LINE;
						}
						
						if(!body.isEmpty()){
							body= body+ CommonConstants.NEW_LINE;
						}
						body= body+ nextBody;
					}

					switchCases = switchCases+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_SWITCH_CASE_DECLARATION,
							shortendedQualifiedTypeName, stateName, body);

				}
				
				swtichCalls= swtichCalls+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
						instanceName, switchCases);
			}

			String output= allDeclarations+ swtichCalls;
			String eventName = generationValueGetter.getString(event, IModelingElementDefinitions.NAME);
			
			String body= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_METHOD_IMPLEMENTATION,output);
			
			addMethodDetails(generationValueGetter, EVENTS_IMPLEMENTATION, 
					CPPTypesConstants.BOOL, eventParameters, StringUtil.indent(body, 1), uClass, null, eventName, 
					VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP);
		}
		
		generationValueGetter.addValue(AUTO_STATES, autoStates, uClass);
		generationValueGetter.addValue(TIMER_STATES, timerStates, uClass);
	}

	private static void findExitDetails(GenerationPolicyRegistry generationValueGetter, Object uClass) {
		List<Object> allStateMachines = getAllStateMachines(generationValueGetter, uClass);
		
		Map<Object, Object> exitableStatemachines= new HashMap<Object, Object>();
		locateExitableClass(generationValueGetter, exitableStatemachines, uClass);
		
		for (Object sm : allStateMachines) {
			List<?> states = generationValueGetter.getList(sm, ICppStatemachinesDefinitions.STATES);
			findExitDetails(generationValueGetter, uClass, exitableStatemachines, sm, states, generationValueGetter.getValues(TIMER_STATES, uClass), false);
		}
	}

	private static void findExitDetails(GenerationPolicyRegistry generationValueGetter, Object uClass, 
			Map<Object, Object> exitableStatemachines, Object sm, List<?> states, List<Object> timerStates, @SuppressWarnings("unused") boolean isExternal) {
		String switchCases= CommonConstants.BLANK;
		String swtichCalls= CommonConstants.BLANK;
		
		String qualifiedTypeName = getQualifiedTypeName(generationValueGetter, sm);
		String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(qualifiedTypeName);
		
		String shortendedQualifiedTypeName= getEnumQualifiedName(generationValueGetter, uClass, sm, qualifiedTypeName);
		
		for (Object state : states) {
			boolean foundTimer= false;
			
			Object exitSm = exitableStatemachines.get(state);
			if(exitSm== null){
				for(Object val: timerStates){
					HashMap<?, ?> map= (HashMap<?, ?>) val;
					Object item = map.get(sm);
					if(item instanceof List== false){
						continue;
					}
					List<?> list = (List<?>) item;
					if(list.contains(state)){
						foundTimer= true;
						break;
					}
				}
//				if(isExternal){
//					exitSm= sm;
//				}else{
//					
//				}
				if(!foundTimer){
					continue;
				}
			}
			
			String body= CommonConstants.BLANK;
			String stateName = generationValueGetter.getString(state, IModelingElementDefinitions.NAME);
			
			if(foundTimer){
				body= body+ "//Timer exit"+ CommonConstants.NEW_LINE;	//TODO //$NON-NLS-1$
			}
			
			if(exitSm!= null/*&& generationValueGetter.getValue(EXIT_IMPLEMENTATION, uClass, VisibilityConstants.PRIVATE)!= null*/){
				String exitProcedureName= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_EXIT_PROCEDURE_NAME, 
						generationValueGetter.getString(exitSm, IModelingElementDefinitions.NAME));
				
				body= body+ generationValueGetter.use(ICppStatemachinesDefinitions.PROCEDURE_CALL_AND_CHECK_DECLARATION, exitProcedureName, Boolean.TRUE);
			}else{
				body= body+ generationValueGetter.use(ICppStatemachinesDefinitions.PROCEDURE_CALL_AND_CHECK_DECLARATION, CPPTypesConstants.TRUE);
			}
			
			String exitCode = generationValueGetter.generationPointString(state, ICppStatemachinesDefinitions.STATE_EXIT_CODE_BODY);
			if (exitCode != null && !exitCode.isEmpty()) {
				if(!body.isEmpty()){
					body= body+ CommonConstants.NEW_LINE;
				}
				
				body= body+ exitCode+ CommonConstants.NEW_LINE;
				
			}
			
			String doActivityCode = generationValueGetter.generationPointString(state, ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY);
			if(doActivityCode!= null&& !doActivityCode.isEmpty()){
				Object statemachine = generationValueGetter.getObject(state, ICppStatemachinesDefinitions.STATEMACHINE);
				String smType = getQualifiedTypeName(generationValueGetter, statemachine);
				String stateType = getQualifiedTypeName(generationValueGetter, state);
				
				String switchVariableName= smType+ stateType;
				
				String threadInstance = generationValueGetter.use(ICppStatemachinesDefinitions.THREAD_INSTANCE, switchVariableName);
				body= body+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_THREAD_USE_DECLARATION, threadInstance);
			}
			
			switchCases = switchCases+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_SWITCH_CASE_DECLARATION,
					shortendedQualifiedTypeName, stateName, body);
		}
		
		if(!switchCases.trim().isEmpty()){
			swtichCalls= swtichCalls+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
					statemachineQualifiedName, switchCases);
			
			String exitProcedureName= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_EXIT_PROCEDURE_NAME,qualifiedTypeName);
			
			
			String body= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_METHOD_IMPLEMENTATION,swtichCalls);
			addMethodDetails(generationValueGetter, EXIT_IMPLEMENTATION, 
					CPPTypesConstants.BOOL, CPPTypesConstants.VOID, StringUtil.indent(body, 1), uClass, null, exitProcedureName, 
					VisibilityConstants.PRIVATE, IModelingConstants.METHOD_OUTGOING_GROUP);
		}
	}
	
	private static void findEnterImplementations(final GenerationPolicyRegistry generationValueGetter, Object uClass) {
		Map<Object, Object> exitableStatemachines= new HashMap<Object, Object>();
		locateExitableClass(generationValueGetter, exitableStatemachines, uClass);
		
		Map<String,List<Object>> statesMap=new WeakHashMap<String, List<Object>>();
		
		for(Object key: exitableStatemachines.keySet()){
			Object state= exitableStatemachines.get(key);
			String stateName = generationValueGetter.getString(state, IModelingElementDefinitions.NAME);
			List<Object> list = statesMap.get(stateName);
			if(list==null){
				list=new ArrayList<Object>();
				statesMap.put(stateName, list);
			}
			list.add(key);
		}
		
		List<String> orderedNames= new ArrayList<String>(statesMap.keySet());
		Collections.sort(orderedNames, new Comparator<String>() {

			@Override
			public int compare(String string1, String string2) {
				return string1.compareTo(string2);
			}
		});
		
		for(String stateName: orderedNames){
			String allDeclarations = CommonConstants.BLANK;
			String swtichCalls= CommonConstants.BLANK;
			
			List<Object> statesList = statesMap.get(stateName);
			Collections.sort(statesList, new Comparator<Object>() {

				@Override
				public int compare(Object object1, Object object2) {
					int level1= getLevel(object1);
					int level2= getLevel(object2);
					
					if(level1<level2){
						return -1;
					}else if(level1>level2){
						return 1;
					}
					
					String sm1 = generationValueGetter.getString(object1, IModelingElementDefinitions.NAME);
					String sm2 = generationValueGetter.getString(object2, IModelingElementDefinitions.NAME);
					
					return sm1.compareTo(sm2);
				}

				private int getLevel(Object object) {
					int level=0;
					Object sm= generationValueGetter.getObject(object, ICppStatemachinesDefinitions.STATEMACHINE);
					if(sm== null){
						return level;
					}
					
					while (true) {
						sm = generationValueGetter.getObject(sm,ICppStatemachinesDefinitions.OWING_STATEMACHINE);
						if (sm == null) {
							break;
						}
						level++;
					}
					
					return level;
				}
			});
			
			for(Object state:statesList){
				String switchCases = CommonConstants.BLANK;
				
				List<?> list = generationValueGetter.getList(state, ICppStatemachinesDefinitions.NESTED_STATEMACHINES);
				
				for (Object nestedStateMachine : list) {
					List<?> nestedStates = generationValueGetter.getList(nestedStateMachine, ICppStatemachinesDefinitions.STATES);
					if (nestedStates.isEmpty()) {
						continue;
					}
					
					String statemachineQualifiedTypeName = getQualifiedTypeName(generationValueGetter, nestedStateMachine);
					String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(statemachineQualifiedTypeName);
					String shortendedQualifiedTypeName= getEnumQualifiedName(generationValueGetter, uClass, nestedStateMachine, statemachineQualifiedTypeName);
					
					if(!allDeclarations.isEmpty()){
						allDeclarations= allDeclarations+ CommonConstants.NEW_LINE;
					}
					allDeclarations = allDeclarations+ generationValueGetter.use(ICppStatemachinesDefinitions.ENUM_VARIABLE_PLACEHOLDER_DECLARATION,
							shortendedQualifiedTypeName, statemachineQualifiedTypeName, statemachineQualifiedName);
					
					String instanceName = generationValueGetter.use(ICppStatemachinesDefinitions.VARIABLE_INSTANCE, statemachineQualifiedTypeName);
					
					for(Object nestedState: nestedStates){
						String nestedStateName = generationValueGetter.getString(nestedState, IModelingElementDefinitions.NAME);
						
						String setter= generationValueGetter.use(ICppStatemachinesDefinitions.STATES_SETTER_NAME_DEFINITION, 
								statemachineQualifiedTypeName);
						
						String body = generationValueGetter.use(
								ICppStatemachinesDefinitions.INVOKE_STATES_SETTER_DEFINITION, setter, shortendedQualifiedTypeName, nestedStateName);
						
						body= body+ CommonConstants.NEW_LINE+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_PROCESSED_CASE);
						
						switchCases = /*switchCases+*/ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_SWITCH_CASE_DECLARATION,
								shortendedQualifiedTypeName, CPPCommonConstants.NIL, CommonConstants.NEW_LINE+ body);
						
						//Only looking for the first state
						break;
					}
					swtichCalls= swtichCalls+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
							instanceName, switchCases);
				}
				
				allDeclarations = allDeclarations + CommonConstants.NEW_LINE;
			}
			
			String output= allDeclarations+ swtichCalls;
			
			String body= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_METHOD_IMPLEMENTATION,output);
			String enterProcedureName= generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_ENTER_PROCEDURE_NAME, stateName, IModelingElementDefinitions.NAME);
			
			addMethodDetails(generationValueGetter, ENTER_IMPLEMENTATION, 
					CPPTypesConstants.BOOL, CPPTypesConstants.VOID, StringUtil.indent(body, 1), uClass, null, enterProcedureName, 
					VisibilityConstants.PRIVATE, IModelingConstants.METHOD_OUTGOING_GROUP);
		}
	}
		  
	@GenerationPoint(generationPoint = ICppStatemachinesDefinitions.STATEMCHAINE_ENTRY_PROCEDURE_STATE_CONTENTS, priority=IGenerationPointPriorityConstants.LOWEST)
	public static String entryImplementationStateContents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object state,
			@GenerationArgument Object element,
			@GenerationProcedureParameter(id = ICppStatemachinesDefinitions.STATE_ENTRY_CODE_BODY) String entryCode,
			@GenerationProcedureParameter(id = ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_ON_COMPLETION_EVENT) String onCompletionEvent,
			@GenerationProcedureParameter(id = ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY) String doActivityCodeBody){
		
		String body= CommonConstants.BLANK;
		
		Object statemachine = generationValueGetter.getObject(state, ICppStatemachinesDefinitions.STATEMACHINE);
		String smType = getQualifiedTypeName(generationValueGetter, statemachine);
		String smName = StringUtil.firstCharacterToLowerCase(smType, true);
		String stateType = getQualifiedTypeName(generationValueGetter, state);
		String smTypeQualified= getEnumQualifiedName(generationValueGetter, element, statemachine, smType);
		
		String switchVariableType= smType+ stateType;
		String switchVariableName= StringUtil.firstCharacterToLowerCase(switchVariableType);
		switchVariableType= StringUtil.firstCharacterToUpperCase(switchVariableType);
		
		boolean usedMain= false;
		List<?> list = generationValueGetter.getList(state, ICppStatemachinesDefinitions.NESTED_STATEMACHINES);
		for(Object nestedStateMachine: list){
			List<?> nestedStates= generationValueGetter.getList(nestedStateMachine, ICppStatemachinesDefinitions.STATES);
			for(Object nestedState: nestedStates){
				if(!generationValueGetter.getBoolean(nestedState, ICppStatemachinesDefinitions.IS_START_STATE)){
					continue;
				}
				String nestedStateName= generationValueGetter.getString(nestedState, IModelingElementDefinitions.NAME);
				String nestedStateType = StringUtil.firstCharacterToUpperCase(nestedStateName);
				String variableName= smName+ nestedStateType;
				
				if(!body.isEmpty()){
					body= body+ CommonConstants.NEW_LINE;
				}
				
				if(generationValueGetter.getValues(STATEMACHINE_VARIABLE_VALUES, element).contains(variableName)){
					String variableType= StringUtil.firstCharacterToUpperCase(variableName);
					String qualifiedSwitchVariableType= getEnumQualifiedName(generationValueGetter, element, nestedStateMachine, variableType);
					
					String setterName= generationValueGetter.use(ICppStatemachinesDefinitions.STATES_SETTER_NAME_DEFINITION, 
							qualifiedSwitchVariableType);
					
					body= body+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_NESTED_STATE_BODY, 
							variableName, CPPCommonConstants.NIL, qualifiedSwitchVariableType, setterName, nestedStateName);
				}else if(!usedMain){
					String setterName= generationValueGetter.use(ICppStatemachinesDefinitions.STATES_SETTER_NAME_DEFINITION, 
							switchVariableType);
					String qualifiedSwitchVariableType= getEnumQualifiedName(generationValueGetter, element, nestedStateMachine, switchVariableType);
					body= body+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_NESTED_STATE_BODY, 
							switchVariableName, CPPCommonConstants.NIL, qualifiedSwitchVariableType, setterName, nestedStateName);
					usedMain= true;
				}
				
				//break changeNestedState;
			}
		}
		
		String contents= CommonConstants.BLANK;
		
		List<Object> timerStates = generationValueGetter.getValues(TIMER_STATES, element);
		
		for(Object val: timerStates){
			HashMap<?, ?> map= (HashMap<?, ?>) val;
			Object item = map.get(statemachine);
			if(item instanceof List== false){
				continue;
			}
			List<?> all = (List<?>) item;
			if(all.contains(state)){
				contents= contents+ "//Timer Start"+ CommonConstants.NEW_LINE;	//TODO //$NON-NLS-1$
				break;
			}
		}
		
		if(entryCode!= null&& !entryCode.isEmpty()){
			contents= contents+ entryCode+ CommonConstants.NEW_LINE;
		}
		
		contents= contents+ body;
		
		List<?> transitions = generationValueGetter.getList(state, ICppStatemachinesDefinitions.TRANSITIONS);
		for (Object transition : transitions) {
			boolean isAuto = generationValueGetter.getBoolean(transition,ICppStatemachinesDefinitions.TRANSITION_IS_AUTO);
			if(isAuto){
				String autoEventName= generationValueGetter.getString(transition, IModelingElementDefinitions.NAME);
				String invocation = CommonConstants.NEW_LINE+ generationValueGetter.use(
						ICppDefinitions.METHOD_INVOCATION, autoEventName, CommonConstants.BLANK, Boolean.TRUE);
				contents= contents+	invocation; 
			}
		}
		
		String doActivityCode= doActivityCodeBody;
		if(onCompletionEvent!=null&& !onCompletionEvent.isEmpty()){
			String invocation = generationValueGetter.use(ICppDefinitions.METHOD_INVOCATION, onCompletionEvent, CommonConstants.BLANK, Boolean.TRUE);
			if(doActivityCodeBody!= null&& !doActivityCode.isEmpty()){
				invocation= doActivityCode+ CommonConstants.NEW_LINE+ invocation;
			}
			doActivityCode= invocation;
		}
		
		if(doActivityCode!= null&& !doActivityCode.isEmpty()){
			String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
			String threadInstance = generationValueGetter.use(ICppStatemachinesDefinitions.THREAD_INSTANCE, switchVariableType);
			String doActivityInstance = generationValueGetter.use(ICppStatemachinesDefinitions.DO_ACTIVITY_METHOD_INSTANCE, switchVariableType);
			String declaration = generationValueGetter.generate(ICppDefinitions.DECLARE_STATEMENET, state, 
					//GenerationArgumentDescriptor.arg(ICppDefinitions.GENERIC_TYPE, parentName),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_TYPE_ARGUMENT, ICppStatemachinesDefinitions.THREAD),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_PREFIXES_ARGUMENT, new ArrayList<Object>()),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_NAME_ARGUMENT, threadInstance),
					GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_VALUE_ARGUMENT, null),
					GenerationArgumentDescriptor.arg(ICppDefinitions.IS_POINTER_TYPE, Boolean.TRUE));
			generationValueGetter.addValue(ICppDefinitions.HELPER_ATTRIBUTES_DECLARATION, declaration, VisibilityConstants.PRIVATE, element);
			
			String content=  generationValueGetter.use(ICppDefinitions.DESTRUCT_ATTRIBUTE, threadInstance);
			//content= StringUtil.indent(content, 1);
			generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.DESTRUCTOR_IMPLEMENTATION, content, element);
			
			String voidPointerName= generationValueGetter.use(ICppStatemachinesDefinitions.VOID_POINTER_NAME);
			String voidPointerNameParameter = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, 
					CPPTypesConstants.VOID+ CommonConstants.ASTERISK, voidPointerName);
			
			String mediator= generationValueGetter.use(ICppStatemachinesDefinitions.DO_ACTIVITY_MEDIATOR_IMPLEMENTATION, parentName, doActivityInstance); 
			
			Map<String, Object> map= new HashMap<String, Object>();
			map.put(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID);
			map.put(IModelingConstants.CODY_BODY, StringUtil.indent(mediator, 1));
			map.put(IModelingConstants.METHOD_NAME, doActivityInstance);
			map.put(IModelingConstants.METHOD_PARAMETERS_STRING, voidPointerNameParameter);
			map.put(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_OPERATIONS_GROUP);
			map.put(IModelingConstants.METHOD_OBJECT, element);
			generationValueGetter.addValue(ICppStatemachinesDefinitions.DO_ACTIVITY_IMPLEMENTATION, map, element, VisibilityConstants.PRIVATE);
			
			String nomralizedDoActivityCode= generationValueGetter.use(ICppStatemachinesDefinitions.DO_ACTIVITY_BODY_WRAP, doActivityCode);
			
			Map<String, Object> newMap= new HashMap<String, Object>();
			newMap.put(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID);
			newMap.put(IModelingConstants.CODY_BODY, StringUtil.indent(nomralizedDoActivityCode, 1));
			newMap.put(IModelingConstants.METHOD_NAME, doActivityInstance);
			newMap.put(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_OPERATIONS_GROUP);
			newMap.put(IModelingConstants.METHOD_OBJECT, element);
			generationValueGetter.addValue(ICppStatemachinesDefinitions.DO_ACTIVITY_IMPLEMENTATION, newMap, element, VisibilityConstants.PRIVATE);
			
			String functionPointer = generationValueGetter.use(ICppStatemachinesDefinitions.DO_ACTIVITY_FUNCTION_POINTER_IMPLEMENTATION, parentName,
					doActivityInstance, threadInstance);
			
			contents= contents+ CommonConstants.NEW_LINE+ functionPointer;
		}
		
		
		if(contents.isEmpty()){
			return contents;
		}
		return generationValueGetter.use(ICppStatemachinesDefinitions.STATEMACHINE_SWITCH_CASE_DECLARATION, smTypeQualified, 
				generationValueGetter.getString(state, IModelingElementDefinitions.NAME),contents);
	}
	
	private static void findSetterDetails(GenerationPolicyRegistry generationValueGetter, Object element) {
		List<Object> allStateMachines = getAllStateMachines(generationValueGetter, element);
		
		for(Object statemachine: allStateMachines){
			String statemachineQualifiedTypeName = getQualifiedTypeName(generationValueGetter, statemachine);
			String qualifiedType= getEnumQualifiedName(generationValueGetter, element, statemachine, statemachineQualifiedTypeName);
			
			String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(statemachineQualifiedTypeName);
			String instanceName = generationValueGetter.use(ICppStatemachinesDefinitions.VARIABLE_INSTANCE, statemachineQualifiedTypeName);
			
			String body= generationValueGetter.use(ICppDefinitions.ASSIGN_STATEMENET, statemachineQualifiedName, instanceName);
			body= body+ CommonConstants.NEW_LINE;
			
			Object parentState = generationValueGetter.getObject(statemachine, ICppStatemachinesDefinitions.OWING_STATE);
			if(parentState!= null){
				Object parentStatemachine = generationValueGetter.getObject(parentState, ICppStatemachinesDefinitions.STATEMACHINE);
				String stateName = generationValueGetter.getString(parentState, IModelingElementDefinitions.NAME);
				
				
				String parentStatemachineType= getQualifiedTypeName(generationValueGetter, parentStatemachine);
				String parentQualifiedType= getEnumQualifiedName(generationValueGetter, element, parentStatemachine, parentStatemachineType);
				String parentStatemachineName= StringUtil.firstCharacterToLowerCase(parentStatemachineType);
				
				//sm != Sm.s1
				String enumUse1= generationValueGetter.use(ICppStatemachinesDefinitions.ENUM_USE, 
						parentQualifiedType, stateName);
				
				//aSmS1 != SmS1.Null
				String enumUse2= generationValueGetter.use(ICppStatemachinesDefinitions.ENUM_USE, 
						qualifiedType, CPPCommonConstants.NIL);
				
				String condition1= generationValueGetter.use(ICppDefinitions.NOT_EQUAL, parentStatemachineName, enumUse1);
				String condition2= generationValueGetter.use(ICppDefinitions.NOT_EQUAL, instanceName, enumUse2);
				
				String conditions= condition1+ CommonConstants.SPACE+ CPPCommonConstants.AND+ CommonConstants.SPACE+ condition2;
				
				
				String setter= generationValueGetter.use(ICppStatemachinesDefinitions.STATES_SETTER_NAME_DEFINITION, parentStatemachineType);
				
				String setterUse = CommonConstants.NEW_LINE+ generationValueGetter.use(
						ICppStatemachinesDefinitions.INVOKE_STATES_SETTER_DEFINITION, setter, parentQualifiedType, stateName);
				
				body= body+ generationValueGetter.use(ICppDefinitions.IF_CONDITION_BLOCK, conditions, StringUtil.indent(setterUse, 1))+
						CommonConstants.NEW_LINE;
				
				
			}
			
			String languageStatemachineQualifiedTypeName = getEnumQualifiedName(generationValueGetter, element, statemachine, statemachineQualifiedTypeName);
			String setter= generationValueGetter.use(ICppStatemachinesDefinitions.STATES_SETTER_NAME_DEFINITION, statemachineQualifiedTypeName);
			String parametersString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, languageStatemachineQualifiedTypeName, 
					instanceName);
			
			List<?> states= generationValueGetter.getList(statemachine, ICppStatemachinesDefinitions.STATES);
			
			String entryContents= CommonConstants.BLANK;
			String entryBody= CommonConstants.BLANK;
			for(Object state: states){
				String results = generationValueGetter.generationPointString(state, ICppStatemachinesDefinitions.STATEMCHAINE_ENTRY_PROCEDURE_STATE_CONTENTS, element);
				if(results!= null){
					entryBody = entryBody+ results;
				}
			}
			
			if(!entryBody.trim().isEmpty()){
				String reply= CommonConstants.NEW_LINE+ generationValueGetter.use(ICppStatemachinesDefinitions.SETTER_SWITCH_COMMENT);
				reply= reply+ generationValueGetter.use(ICppStatemachinesDefinitions.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
						statemachineQualifiedName, entryBody);
				
				entryContents= entryContents+ reply;
				body= body+ entryContents;
			}
			
			
			String pseudoState;
			if(parentState!= null){
				pseudoState= CPPCommonConstants.NIL;
			}else{
				pseudoState= states.isEmpty()? null: generationValueGetter.getString(states.get(0), IModelingElementDefinitions.NAME); 
			}
			
			if(pseudoState!= null){
				String contents = generationValueGetter.use(ICppDefinitions.METHOD_INVOCATION, setter, 
						qualifiedType+ CPPCommonConstants.DECLARATION_COMMON_PREFIX+ pseudoState, Boolean.TRUE);
						
				generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, 
						new SimpleEntry<Object, String>(element, contents), element, Boolean.FALSE);
			}
			 
			
			addMethodDetails(generationValueGetter, SETTERS_IMPLEMENTATION, 
					CPPTypesConstants.VOID, parametersString, StringUtil.indent(body, 1), element, null, setter, 
					VisibilityConstants.PRIVATE, IModelingConstants.METHOD_OUTGOING_GROUP);
		}
	}

	private static String getEnumQualifiedName(GenerationPolicyRegistry generationValueGetter, Object element, Object statemachine, String statemachineQualifiedTypeName) {
		String languageStatemachineQualifiedTypeName= statemachineQualifiedTypeName;
		List<Object> values = generationValueGetter.getValues(ICppDefinitions.MACROS_TYPE_DEF, statemachine, statemachineQualifiedTypeName, element);
		String elementName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		elementName= elementName+ CommonConstants.UNDERSCORE + CPPCommonConstants.ENUM.toUpperCase();
		for(Object object: values){
			if(object instanceof SimpleEntry== false){
				continue;
			}
			SimpleEntry<?, ?> simple= (SimpleEntry<?, ?>) object;
			Object key = simple.getKey();
			Object value = simple.getValue();
			if(value instanceof List== false|| key instanceof String== false){
				continue;
			}
			List<?> path= (List<?>) value;
			if(path.size()<2){
				continue;
			}
			
			String pathElementName = (String) path.get(0);
			if(pathElementName.startsWith(CommonConstants.UNDERSCORE)){
				pathElementName= pathElementName.substring(1, pathElementName.length());
			}
			if(path.size()<2|| !pathElementName.equals(elementName)|| !path.get(1).equals(statemachineQualifiedTypeName)){
				continue;
			}
			
			return (String) key;
		}
		return languageStatemachineQualifiedTypeName;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.GLOBAL_DEFINITIONS)
	public static String eventsGlobalDefinitions(@GenerationRegistry final GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.CLASSES) List<?> classes,
			@GenerationElementParameter(id = IModelingElementDefinitions.INTERFACES) List<?> interfaces){
		
		String contents= CommonConstants.BLANK;
		List<Object> list= new ArrayList<Object>(); 
		for(Object clazz: classes){
			for(Object obj: generationValueGetter.generationPointList(clazz, ICppStatemachinesDefinitions.ALL_STATES)){
				list.add(obj);
			}
		}
		
		for(Object interfaceObj: interfaces){
			for(Object obj: generationValueGetter.generationPointList(interfaceObj, ICppStatemachinesDefinitions.ALL_STATES)){
				list.add(obj);
			}
		}
		
		List<String> names= new ArrayList<String>();
		for(Object obj: list){
			String name= generationValueGetter.getString(obj, IModelingElementDefinitions.NAME);
			if(name== null|| name.isEmpty()||names.contains(name)){
				continue;
			}
			names.add(name);
		}
		
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String name1, String name2) {
				return name1.compareTo(name2);
			}
		});
		
		for(int index=0; index<names.size(); index++){
			String name= names.get(index);
			contents= contents+ generationValueGetter.use(ICppDefinitions.DEFINITION_DECLARATION, name, Integer.valueOf(index));
		}
		
		return contents;
	}
	
	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = ICppStatemachinesDefinitions.ENUM_VALUES)
	public static String getValues(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
					@GenerationElementParameter(id = ICppStatemachinesDefinitions.STATES) List<?> statesList,
					@GenerationArgument boolean isNested){
		
		List<Object> states= applyStatesHack(generationValueGetter, (List<Object>) statesList);
		
		String values= CommonConstants.BLANK;
		int size = statesList.size();
		
		int incrementer=0;
		if(isNested){
			values= values+ generationValueGetter.use(ICppDefinitions.ENUM_VALUE, CPPCommonConstants.NIL, Integer.valueOf(0));
			incrementer++;
			if(size>0){
				values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
			}
		}
		
		for(int index=0; index<states.size(); index++){
			Object next = states.get(index);
			values= values+ generationValueGetter.use(ICppDefinitions.ENUM_VALUE, 
					generationValueGetter.getString(next, IModelingElementDefinitions.NAME), Integer.valueOf(index+incrementer));
			
			if(index<states.size()-1){
				values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
			}
		}
		return values;
	}

	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = ICppStatemachinesDefinitions.ENUM_CASES_STRING)
	public static String getCasesString(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = ICppStatemachinesDefinitions.STATES) List<?> statesList,
					@GenerationArgument boolean isNested){
		
		String values= CommonConstants.BLANK;
		if(isNested){
			values= values+ generationValueGetter.use(ICppDefinitions.ENUM_CASE_STRING, CPPCommonConstants.NIL);
		}
		
		if(!values.isEmpty()){
			values= values+ CommonConstants.NEW_LINE;
		}
		
		List<Object> states= applyStatesHack(generationValueGetter, (List<Object>) statesList);
		
		Iterator<?> iterator = states.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			String value= generationValueGetter.getString(next, IModelingElementDefinitions.NAME);
			values= values+ generationValueGetter.use(ICppDefinitions.ENUM_CASE_STRING, value);
			if(iterator.hasNext()){
				values= values+ CommonConstants.NEW_LINE;
			}
		}
		
		return values;
	}
	
	private static List<Object> applyStatesHack(GenerationPolicyRegistry generationValueGetter, List<Object> states) {
		Set<Object> redundantStates= new HashSet<Object>();
		List<String> names= new ArrayList<String>();
		for(int index=0; index<states.size(); index++){
			Object next = states.get(index);
			String name = generationValueGetter.getString(next, IModelingElementDefinitions.NAME);
			if(names.contains(name)){
				redundantStates.add(next);
			}else{
				names.add(name);
			}
		}
		List<Object> normalized= new ArrayList<Object>();
		if(!redundantStates.isEmpty()){
			for(Object obj: redundantStates){
				normalized.add(obj);
			}
			return normalized;
		}
		return states;
	}
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.ALL_STATES)
	public static List<?> getAllStates(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
					@GenerationElementParameter(id = ICppStatemachinesDefinitions.STATEMACHINES) List<?> statemachines){
		
		if(statemachines== null){
			return new ArrayList<Object>();
		}
		Set<Object> states= new HashSet<Object>();
		for(Object statemachine: statemachines){
			states.addAll(generationValueGetter.getList(statemachine, ICppStatemachinesDefinitions.STATES));
		}
		return new ArrayList<Object>(states);
	}
	
	@SuppressWarnings("unchecked")
	@GenerationPoint(generationPoint = ICppStatemachinesDefinitions.ALL_STATEMACHINES)
	public static List<Object> getAllStateMachines(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object uClass) {
		return (List<Object>) generationValueGetter.getList(uClass, ICppStatemachinesDefinitions.ALL_STATEMACHINES);
	}
	
	private static SimpleEntry<Object, Object> exitableStateMachine(GenerationPolicyRegistry generationValueGetter, 
			Object state, Object nextState, Map<Object, Object> exitableStatemachines) {
		Object exitSm = exitableStatemachines.get(state);
		if (exitSm != null && /*FIXME: Weak check */!state.equals(nextState)) {
			return new SimpleEntry<Object, Object>(generationValueGetter.getObject(state, ICppStatemachinesDefinitions.STATEMACHINE), exitSm);
		}

		Object parentStatemachine = generationValueGetter.getObject(state, ICppStatemachinesDefinitions.STATEMACHINE);
		if (parentStatemachine == null) {
			return null;
		}

		Object currentState = generationValueGetter.getObject(parentStatemachine, ICppStatemachinesDefinitions.OWING_STATE);
		if (currentState == null) {
			return null;
		}

		while (currentState != null) {
			Object sm = generationValueGetter.getObject(currentState, ICppStatemachinesDefinitions.STATEMACHINE);
			Object currentExitSm = exitableStatemachines.get(currentState);
			if (currentExitSm != null && /*FIXME: Weak check */!currentState.equals(nextState)) {
				return new SimpleEntry<Object, Object>(sm, currentExitSm);
			}
			currentState = generationValueGetter.getObject(sm, ICppStatemachinesDefinitions.OWING_STATE);
		}
		return null;
	}
	
	private static void locateExitableClass(GenerationPolicyRegistry generationValueGetter, Map<Object, Object> exitableStatemachines, Object uClass) {
		List<?> statemachines = generationValueGetter.getList(uClass, ICppStatemachinesDefinitions.STATEMACHINES);
		for (Object sm : statemachines) {
			prepareNestedStatesFor(generationValueGetter, exitableStatemachines, sm, 0);
		}
	}

	private static void prepareNestedStatesFor(GenerationPolicyRegistry generationValueGetter, Map<Object, Object> exitableStatemachines, Object sm, int concurrentIndex) {
		Object parentState = generationValueGetter.getObject(sm, ICppStatemachinesDefinitions.OWING_STATE);
		Object startState = generationValueGetter.getObject(sm, ICppStatemachinesDefinitions.START_STATE);
		
		if (parentState != null && startState != null) {
			Object current = parentState;
			while (true) {
				Object parentStatemachine = generationValueGetter.getObject(current, ICppStatemachinesDefinitions.STATEMACHINE);
				if (parentStatemachine == null) {
					break;
				}
				
				Object owingState = generationValueGetter.getObject(parentStatemachine, ICppStatemachinesDefinitions.OWING_STATE);
				if(owingState== null){
					break;
				}
				
				current = owingState;
			}
			
			if (generationValueGetter.getObject(sm, ICppStatemachinesDefinitions.START_STATE) != null&& concurrentIndex == 0) {
				exitableStatemachines.put(parentState, current);
			}
		}

		List<?> states = generationValueGetter.getList(sm, ICppStatemachinesDefinitions.STATES);
		for (Object s : states) {
			int nestedSmIndex = 0;
			
			for (Object nestedStateMachine : generationValueGetter.getList(s, ICppStatemachinesDefinitions.NESTED_STATEMACHINES)) {
				exitableStatemachines.put(s, s);
				nestedSmIndex += 1;
				
				prepareNestedStatesFor(generationValueGetter, exitableStatemachines, nestedStateMachine, nestedSmIndex);
				nestedSmIndex += 1;
			}
		}
	}
  
  
	private static String getQualifiedTypeName(GenerationPolicyRegistry generationValueGetter, Object sm) {
		Object current= sm;
		String qualifiedTypeName = StringUtil.firstCharacterToUpperCase(generationValueGetter.getString(current, IModelingElementDefinitions.NAME));
		
		while (true) {
			current = generationValueGetter.getObject(current,ICppStatemachinesDefinitions.OWING_STATEMACHINE);
			if (current == null) {
				break;
			}

			qualifiedTypeName = StringUtil.firstCharacterToUpperCase(generationValueGetter.getString(current,IModelingElementDefinitions.NAME))
					+ qualifiedTypeName;
		}
		return qualifiedTypeName;
	}
	
	private static void addMethodDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, String id, String returnType, String parametersString,
			String codeBody, Object parent, Object element, String name, String visibility, String groupId){
		addMethodDetails(generationValueGetter, id, returnType, parametersString, codeBody, parent, element, name, visibility, groupId, null);
	}
	
	private static void addMethodDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, String id, String returnType, String parametersString,
			String codeBody, Object parent, Object element, String name, String visibility, String groupId, String comment){
		
		if("exitStatus".equals(name)){
			System.out.println();
		}
		
		Map<String, Object> map= new HashMap<String, Object>();
		
		map.put(IModelingConstants.METHOD_RETURN_TYPE, returnType);
		map.put(IModelingConstants.METHOD_PARAMETERS_STRING, parametersString);
		map.put(IModelingConstants.CODY_BODY, codeBody);
		map.put(IModelingConstants.METHOD_COMMENT, comment);
		map.put(IModelingConstants.METHOD_NAME, name);
		map.put(IModelingConstants.METHOD_GROUP, groupId);
		map.put(IModelingConstants.METHOD_OBJECT, element);
		generationValueGetter.addValue(id, map, parent, visibility);
	}
	
	private static String getAttributesDeclaraionDetails(GenerationPolicyRegistry generationValueGetter, Object element,String id, String visibility) {
		List<Object> values = generationValueGetter.getValues(id, visibility, element);
		
		String contents= CommonConstants.BLANK;
		for(Object entry: values){
			contents = contents+ entry+ CommonConstants.NEW_LINE;
		}
		
		if(!contents.isEmpty()){
			String comments = generationValueGetter.use(id+ ICppDefinitions.COMMENTS_SUFFIX);
			if(!comments.isEmpty()){
				contents= comments+ CommonConstants.NEW_LINE+ contents;
			}
		}
		
		return contents;
	}
	
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.TRANSITION_EFFECT_CODE_BODY)
	public static String effect(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object transition){
		return generationValueGetter.getString(transition, ICppStatemachinesDefinitions.TRANSITION_EFFECT_CODE_BODY, CPPCommonConstants.CPP_LANGUAGE);
	}
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.TRANSITION_GUARD_CODE_BODY)
	public static String guard(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object transition){
		return generationValueGetter.generationPointString(transition, IModelingElementDefinitions.CONSTRAINTS_EXPRESSIONS_CONTENTS);
	}
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.STATE_ENTRY_CODE_BODY)
	public static String entry(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object state){
		return generationValueGetter.getString(state, ICppStatemachinesDefinitions.STATE_ENTRY_CODE_BODY, CPPCommonConstants.CPP_LANGUAGE);
	}
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.STATE_EXIT_CODE_BODY)
	public static String exit(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object state){
		return generationValueGetter.getString(state, ICppStatemachinesDefinitions.STATE_EXIT_CODE_BODY, CPPCommonConstants.CPP_LANGUAGE);
	}
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY)
	public static String doActivity(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object state){
		return generationValueGetter.getString(state, ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY, CPPCommonConstants.CPP_LANGUAGE);
	}
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_ON_COMPLETION_EVENT)
	public static String doActivityOnCompletion(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object state){
		return generationValueGetter.getString(state, ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_ON_COMPLETION_EVENT/*, CPPCommonConstants.CPP_LANGUAGE*/);
	}
	
}