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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationLoopAnnotation;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationPolicyRegistryPriorities;
import cruise.umple.core.Generator;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.gen.GenAspectableReturnBody;
import cruise.umple.cpp.gen.GenBody;
import cruise.umple.cpp.gen.GenClass;
import cruise.umple.cpp.gen.GenComment;
import cruise.umple.cpp.gen.GenDepend;
import cruise.umple.cpp.gen.GenEnum;
import cruise.umple.cpp.gen.GenEnumEntry;
import cruise.umple.cpp.gen.GenField;
import cruise.umple.cpp.gen.GenGroup;
import cruise.umple.cpp.gen.GenMethod;
import cruise.umple.cpp.gen.GenMethodParameter;
import cruise.umple.cpp.gen.GenPriorities;
import cruise.umple.cpp.gen.GenState;
import cruise.umple.cpp.gen.GenStatemachine;
import cruise.umple.cpp.gen.UniqueGenBody;
import cruise.umple.cpp.gen.Visibilities;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;

public class CppStatemachinePointsHandler{
	
	private static final String WAS_EVENT_PROCESSED = "wasEventProcessed";

	private final static String HISTORY_STATE_SUFFIX= "H"; //$NON-NLS-1$
	
	private final static String AUTO_STATES= "cpp.auto.states.internal"; //$NON-NLS-1$
	
	@GenerationLoopAnnotation(id = ICppStatemachinesDefinitions.STATEMACHINES_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getNavigableAssociationVariables(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object classInterface){
		return getAllStateMachines(generationValueGetter, classInterface);
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
		
		generationValueGetter.rootModel.setRequiresThread(true);
		
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(element, IModelingElementDefinitions.NAME));
		GenDepend depend = new GenDepend(ISTLConstants.ASSERT_LIBRARY);
		depend.setNamespace(ISTLConstants.STD_LIBRARY);
		depend.setIsLibrary(true);
		genClass.addDependency(depend);
		
		findEventsDetails(generationValueGetter, element);
		//Locate nested first in order to build nested switch cases
		findNestedExitDetails(generationValueGetter, element);
		
		findEnumVariables(generationValueGetter, element);
		findSetterDetails(generationValueGetter, element);
		
		findExitDetails(generationValueGetter, element);
		findEnterImplementations(generationValueGetter, element);
	}
	
	private static void findEnumVariables(GenerationPolicyRegistry generationValueGetter, Object uClass) {
		List<Object> allStateMachines = getAllStateMachines(generationValueGetter, uClass);
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME));
		
		for(Object statemachine: allStateMachines){
			String statemachineQualifiedTypeName = getQualifiedTypeName(generationValueGetter, statemachine);
			String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(statemachineQualifiedTypeName);
			
			List<?> states= generationValueGetter.getList(statemachine, ICppStatemachinesDefinitions.STATES);
			
			Object parentState = generationValueGetter.getObject(statemachine, ICppStatemachinesDefinitions.PARENT_STATE);
			boolean isNested = parentState!= null;
			
			@SuppressWarnings("unchecked")
			List<Object> statesModified= applyStatesHack(generationValueGetter, (List<Object>) states);
			
			if(!isNested){
				
				String getSMFullName= generationValueGetter.generate(Generator.STATEMACHINE_FULL_PATH,statemachineQualifiedTypeName);
				//languageStatemachineQualifiedTypeName
				
				String body= CommonConstants.BLANK;
				
				for(Object nested: allStateMachines){
					if(nested.equals(statemachine)){
						continue;
					}
					
					Object nestedParentState = generationValueGetter.getObject(nested, ICppStatemachinesDefinitions.PARENT_STATE);
					if(nestedParentState== null){
						continue;
					}
					
					while(nestedParentState!= null){
						Object nestedSM= generationValueGetter.getObject(nestedParentState, ICppStatemachinesDefinitions.STATEMACHINE);
						if(statemachine.equals(nestedSM)){
							String nestedQualifiedTypeName = getQualifiedTypeName(generationValueGetter, nested);
							String nestedQualifiedName= StringUtil.firstCharacterToLowerCase(nestedQualifiedTypeName);
							String nestedLanguageQualifiedTypeName = getEnumQualifiedName(generationValueGetter, uClass, nested, nestedQualifiedTypeName);
							
							String use = generationValueGetter.generate(Generator.STATEMACHINE_FULL_PATH_SEGMENT, nestedLanguageQualifiedTypeName,
									nestedQualifiedName);
							if(!body.isEmpty()){
								body= body+ CommonConstants.NEW_LINE;
							}
							body= body+ use;
							break;
						}
						nestedParentState = generationValueGetter.getObject(nestedSM, ICppStatemachinesDefinitions.PARENT_STATE);
					}
				}
				
				//if(!body.isEmpty()){
				body= generationValueGetter.generate(Generator.STATEMACHINE_FULL_PATH_IMPLEMENTATION,statemachineQualifiedName, body);
				
				GenMethod method = new GenMethod();
				method.addBody(new GenBody(body));
				method.setReturnType(ISTLConstants.STRING);
				method.setName(getSMFullName);
				method.setVisibility(Visibilities.PUBLIC);
				method.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
				genClass.addMethod(method);
				//}
			}
			
			List<String> values= new ArrayList<String>();
			for(Object s: statesModified){
				values.add(generationValueGetter.getString(s, IModelingElementDefinitions.NAME));
			}
			
			GenEnum enumeration= new GenEnum(statemachineQualifiedTypeName+ "_");
			for(String entry: getCases(generationValueGetter, statemachine, isNested)){
				enumeration.addEntry(new GenEnumEntry(entry));
			}
			
			//Ref12345: link to GenField
			genClass.addEnumeration(enumeration);
			
			GenDepend depend = new GenDepend(ISTLConstants.STRING);
			depend.setNamespace(ISTLConstants.STD_LIBRARY);
			depend.setIsLibrary(true);
			genClass.addDependency(depend);
			
			String languageStatemachineQualifiedTypeName = enumeration.safeName();
			addEnumField(genClass, languageStatemachineQualifiedTypeName, statemachineQualifiedName);
			locateHistoryStates(generationValueGetter, uClass, statemachine);
			String getterMethodName = generationValueGetter.rootModel.getInstance(generationValueGetter.getString(statemachine, IModelingElementDefinitions.NAME));
			
			GenMethod method = new GenMethod();
			genClass.addMethod(method);
			method.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
			String thisName = generationValueGetter.generate(Generator.ATTRIBUTE_USE, CPPCommonConstants.THIS, statemachineQualifiedName, Boolean.TRUE);
			String instanceName= generationValueGetter.generator.variableInstance(statemachineQualifiedName);
			method.setReturnType(languageStatemachineQualifiedTypeName);
			method.setVisibility(Visibilities.PUBLIC);
			method.addBody(new GenAspectableReturnBody(thisName, instanceName, languageStatemachineQualifiedTypeName));
			method.setName(getterMethodName);
		}
	}

	private static GenField addEnumField(GenClass genClass, String type, String name) {
		GenField smField = new GenField();
		smField.setVisibility(Visibilities.PRIVATE);
		smField.setIsEnum(true);	//TODO: could be avoided
		smField.setType(type);
		smField.setName(name);
		genClass.addField(smField);
		smField.setGroup(genClass.getAttributeGroup(genClass.indexOfAttributeGroup(new GenGroup(GenClass.ENUM_GROUP))));
		return smField;
	}

	private static void locateHistoryStates(GenerationPolicyRegistry generationValueGetter, Object uClass, Object statemachine) {
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME));
		List<?> states= generationValueGetter.getList(statemachine, ICppStatemachinesDefinitions.STATES);
		for(Object state: states){
			boolean isHistory= generationValueGetter.getBoolean(state, ICppStatemachinesDefinitions.IS_HISTORY_STATE);
			if(isHistory){
				String qualifiedTypeName = getQualifiedTypeName(generationValueGetter, statemachine);
				String languageHistoryStatemachineQualifiedTypeName = getEnumQualifiedName(generationValueGetter, uClass, statemachine, qualifiedTypeName);
				
				String historyQualifiedName= StringUtil.firstCharacterToLowerCase(qualifiedTypeName)+ HISTORY_STATE_SUFFIX;
				addEnumField(genClass, languageHistoryStatemachineQualifiedTypeName, historyQualifiedName);
			}
		}
	}
	
//	@GenerationPoint(generationPoint = IModelingConstants.NORMALIZED_NAME, priority= IGenerationPointPriorityConstants.HIGHEST, unique= true)
//	public static String normalizedName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
//			@GenerationBaseElement Object statemachine,
//			@GenerationLoopPath TreeMap<String, Object> path){
//		if(statemachine== null|| !statemachine.equals(path.get(ICppStatemachinesDefinitions.STATEMACHINES_PROCESSOR))){
//			return null;
//		}
//		String statemachineQualifiedTypeName = getQualifiedTypeName(generationValueGetter, statemachine);
//		String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(statemachineQualifiedTypeName);
//		return statemachineQualifiedName;
//	}

	@SuppressWarnings("unchecked")
	public static void findNestedExitDetails(final GenerationPolicyRegistry generationValueGetter, Object uClass) {
		Map<Object, Object> exitableStatemachines= new HashMap<Object, Object>();
		locateExitableClass(generationValueGetter, exitableStatemachines, uClass);
		findNestedExitDetails(generationValueGetter, uClass, exitableStatemachines);
		
//		Ref12345
//		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME));
//		for(GenStatemachine genSm: genClass.getAutoStatemachines()){
//			
//		}
		
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
				findExitDetails(generationValueGetter, uClass, exitableStatemachines, sm, states, true);
			}
		}
	}

	private static void findNestedExitDetails(final GenerationPolicyRegistry generationValueGetter, Object uClass, Map<Object, Object> exitableStatemachines) {
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME));
		
		
//		for(GenStatemachine genSm: genClass.getExitableStatemachines()){
//			for(GenState getState: genSm.getStates()){
//				System.out.println(getState);
//			}
//		}
		
		//genClass.getExitableStatemachines().stream().map(statemachine-> statemachine.getStates().stream().map(GenState::getState).collect(Collectors.toList())).collect(Collectors.toList());
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
			StringBuffer allDeclarations = new StringBuffer();
			StringBuffer swtichCalls= new StringBuffer();
			StringBuffer preConditions= new StringBuffer();
			
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
						sm = generationValueGetter.getObject(sm,ICppStatemachinesDefinitions.PARENT_STATEMACHINE);
						if (sm == null) {
							break;
						}
						level++;
					}
					return level;
				}
			});
			
			GenMethod exitMethod= new GenMethod();
			String exitProcedureName= generationValueGetter.generate(Generator.STATEMCHAINE_EXIT_PROCEDURE_NAME, stateName, IModelingElementDefinitions.NAME);
			exitMethod.setName(exitProcedureName);
			
			ArrayList<Object> visited = new ArrayList<Object>();
			for(Object state:statesList){
				appendStatemachineCases(generationValueGetter, exitMethod, uClass, state, allDeclarations, swtichCalls, visited);
			}
			
			visited = new ArrayList<Object>();
			for(Object state:statesList){
				deepHistoryCheck(generationValueGetter, exitMethod, preConditions, state, visited);
			}
			
			if(!preConditions.toString().isEmpty()){
				if(!allDeclarations.toString().isEmpty()){
					allDeclarations.append(CommonConstants.NEW_LINE);
				}
				
				allDeclarations.append(preConditions); 
				
				if(!swtichCalls.toString().isEmpty()){
					allDeclarations.append(CommonConstants.NEW_LINE);
				}
			}
			
			if(exitMethod.hasBody()){
				genClass.addMethod(exitMethod);
				 
				exitMethod.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
				exitMethod.setReturnType(CPPTypesConstants.BOOL);
				exitMethod.setVisibility(Visibilities.PRIVATE);
				exitMethod.addBody(new GenAspectableReturnBody(Boolean.FALSE.toString(), WAS_EVENT_PROCESSED, CPPTypesConstants.BOOL));
			}
		}
	}

	private static void appendStatemachineCases(final GenerationPolicyRegistry generationValueGetter, GenMethod method, Object uClass, Object state,
			StringBuffer allDeclarations, StringBuffer swtichCalls, ArrayList<Object> visited) {
		
		if(visited.contains(state)){
			return;
		}
		
		visited.add(state);
		
		List<?> list = generationValueGetter.getList(state, ICppStatemachinesDefinitions.NESTED_STATEMACHINES);
		
		for (Object nestedStateMachine : list) {
			StringBuffer switchCases = new StringBuffer();
			List<?> nestedStates = generationValueGetter.getList(nestedStateMachine, ICppStatemachinesDefinitions.STATES);
			if (nestedStates.isEmpty()) {
				continue;
			}
			
			String statemachineQualifiedTypeName = getQualifiedTypeName(generationValueGetter, nestedStateMachine);
			String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(statemachineQualifiedTypeName);
			String shortendedQualifiedTypeName= getEnumQualifiedName(generationValueGetter, uClass, nestedStateMachine, statemachineQualifiedTypeName);
			
			if(!allDeclarations.toString().isEmpty()){
				allDeclarations.append(CommonConstants.NEW_LINE);
			}
			String declaration = generationValueGetter.generate(Generator.ENUM_VARIABLE_PLACEHOLDER_DECLARATION,
					shortendedQualifiedTypeName, statemachineQualifiedTypeName, statemachineQualifiedName);
			allDeclarations.append(declaration);
			
			GenBody declarationBody = new GenBody(declaration);
			method.addBody(declarationBody);
			declarationBody.setType(GenBody.PRE_BLOCK);
			
			String instanceName = generationValueGetter.generate(Generator.VARIABLE_INSTANCE, statemachineQualifiedTypeName);
			
			for(Object nestedState: nestedStates){
				String nestedStateName = generationValueGetter.getString(nestedState, IModelingElementDefinitions.NAME);
				
				String setter= generationValueGetter.generate(Generator.STATES_SETTER_NAME_DEFINITION, 
						statemachineQualifiedTypeName);
				
				String body = generationValueGetter.generate(
						Generator.INVOKE_STATES_SETTER_DEFINITION, setter, shortendedQualifiedTypeName, 
						CPPCommonConstants.NIL);
				
				body= body+ CommonConstants.NEW_LINE+ generationValueGetter.generate(Generator.STATEMACHINE_PROCESSED_CASE, "");
				
				switchCases.append(generationValueGetter.generate(Generator.STATEMACHINE_SWITCH_CASE_DECLARATION,
						shortendedQualifiedTypeName, nestedStateName, CommonConstants.NEW_LINE+ body));
			}
			
			String use = generationValueGetter.generate(Generator.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
					instanceName, switchCases.toString());
			
			swtichCalls.append(use);
			
			GenBody switchBody = new GenBody(use);
			method.addBody(switchBody);
			
			for(Object nestedState: nestedStates){
				appendStatemachineCases(generationValueGetter, method, uClass, nestedState, allDeclarations, swtichCalls, visited);
			}
		}
		
		if(!list.isEmpty()){
			if(allDeclarations.length()!= allDeclarations.lastIndexOf(CommonConstants.NEW_LINE)+CommonConstants.NEW_LINE.length()){
				allDeclarations.append(CommonConstants.NEW_LINE);
			}
		}
	}

	public static void findEventsDetails(GenerationPolicyRegistry generationValueGetter, Object uClass) {
		List<?> events = generationValueGetter.getList(uClass, ICppStatemachinesDefinitions.EVENTS);
		
		Map<Object, Object> exitableStatemachines= new HashMap<Object, Object>();
		locateExitableClass(generationValueGetter, exitableStatemachines, uClass);
		
		Map<Object, List<Object>> autoStates= new HashMap<Object, List<Object>>();
		
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME));
		
		for (Object event : events) {
			boolean isInternal = generationValueGetter.getBoolean(event,ICppStatemachinesDefinitions.EVENT_IS_INTERNAL);
			boolean isAuto = generationValueGetter.getBoolean(event,ICppStatemachinesDefinitions.EVENT_IS_AUTO);
			boolean isTimer = generationValueGetter.getBoolean(event,ICppStatemachinesDefinitions.EVENT_IS_TIMER);
			
			GenMethod method = createEventMethod(generationValueGetter, genClass, event);
			
			List<?> statemachines = generationValueGetter.getList(uClass, ICppStatemachinesDefinitions.EVENT_STATEMACHINES, event);
			for (Object sm : statemachines) {
				String smName= generationValueGetter.getString(sm, IModelingElementDefinitions.NAME);
				String switchCases = CommonConstants.BLANK;
				String qualifiedTypeName = getQualifiedTypeName(generationValueGetter, sm);
				String shortendedQualifiedTypeName= getEnumQualifiedName(generationValueGetter, uClass, sm, qualifiedTypeName);
				String declaration = generationValueGetter.generate(Generator.ENUM_VARIABLE_PLACEHOLDER_DECLARATION,
						shortendedQualifiedTypeName, qualifiedTypeName, StringUtil.firstCharacterToLowerCase(qualifiedTypeName));
				
				GenBody declarationBody = new GenBody(declaration);
				declarationBody.setType(GenBody.PRE_BLOCK);
				method.addBody(declarationBody);
				
				String instanceName = generationValueGetter.generate(Generator.VARIABLE_INSTANCE, qualifiedTypeName);
				GenStatemachine volatileStatemachine = new GenStatemachine(qualifiedTypeName, smName);
				List<?> states = generationValueGetter.getList(sm, ICppStatemachinesDefinitions.STATES);
				for (Object state : states) {
					List<?> transitions = generationValueGetter.getList(state, ICppStatemachinesDefinitions.EVENT_TRANSITIONS,event);

					if (transitions.isEmpty()) {
						continue;
					}

					String stateName = generationValueGetter.getString(state, IModelingElementDefinitions.NAME);
					String body= CommonConstants.BLANK;
					
					//TODO: Only for doActivity
					if(genClass.indexOfStatemachine(new GenStatemachine(null, stateName))>-1){
						String exitProcedureNameMain= generationValueGetter.generate(Generator.STATEMCHAINE_EXIT_PROCEDURE_NAME,qualifiedTypeName);
						
						body = body+ generationValueGetter.generate(Generator.PROCEDURE_CALL_DECLARATION, 
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
						if(exitSm== null /*&& !isSameState&& !isInternal*/){
							//TODO: Checking for isSame and isInternal makes us avoid having an extra switch case for a state that will never be entered
							if(isAuto){
								int indexOfAutoStatemachine = genClass.indexOfAutoStatemachine(volatileStatemachine);
								if(indexOfAutoStatemachine <0){
									genClass.addTimerStatemachine(volatileStatemachine);
								}else{
									volatileStatemachine= genClass.getAutoStatemachine(indexOfAutoStatemachine);
								}
								volatileStatemachine.addState(new GenState(stateName));
								
								List<Object> list = autoStates.get(sm);
								if(list== null){
									list= new ArrayList<Object>();
									autoStates.put(sm, list);
								}
								
								list.add(state);
								exitSm= sm;
							}else if(isTimer){
								int indexOfTimerStatemachine = genClass.indexOfTimerStatemachine(volatileStatemachine);
								if(indexOfTimerStatemachine <0){
									genClass.addTimerStatemachine(volatileStatemachine);
								}else{
									volatileStatemachine= genClass.getTimerStatemachine(indexOfTimerStatemachine);
								}
								volatileStatemachine.addState(new GenState(stateName));
								exitSm= sm;
							}
						}

						if (exitSm != null && (exitSm!=sm|| isTimer|| isAuto) && !isInternal && !isSameState) {

							Object owingState = generationValueGetter.getObject(targetStatemachineObject, ICppStatemachinesDefinitions.PARENT_STATE);
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
										GenEnum genEnum = genClass.enumByName(targetStatePath+ "_");
										if(genEnum != null && (!genEnum.hasEntries() || genEnum.indexOfEntry(new GenEnumEntry(targetStateName))< 0)){
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
							
							String exitProcedureName= generationValueGetter.generate(Generator.STATEMCHAINE_EXIT_PROCEDURE_NAME, 
									exitTypeQualifiedName);
							
							if(genClass.methodByIdentifier(exitMethodInstance(exitProcedureName).identifier()) != null){
								body = body+ generationValueGetter.generate(Generator.PROCEDURE_CALL_DECLARATION, 
										exitProcedureName)+ CommonConstants.NEW_LINE;
							}
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
						
						String setter= generationValueGetter.generate(Generator.STATES_SETTER_NAME_DEFINITION, targetStatePath);
						
						String targetShortendedQualifiedTypeName= getEnumQualifiedName(generationValueGetter, uClass, targetStatemachineObject, targetStatePath);
						
						String nextBody= CommonConstants.BLANK;
						boolean isHistory= generationValueGetter.getBoolean(targetStateObject, ICppStatemachinesDefinitions.IS_HISTORY_STATE);
						if(isHistory){
							String historyQualifiedTypeName = targetStatePath+ HISTORY_STATE_SUFFIX;
							String historyQualifiedName= StringUtil.firstCharacterToLowerCase(historyQualifiedTypeName);
							
							nextBody = generationValueGetter.generate(Generator.INVOKE_STATES_SETTER_DEFINITION, setter, 
									historyQualifiedName);
						}else{
							nextBody = generationValueGetter.generate(Generator.INVOKE_STATES_SETTER_DEFINITION, setter, 
									targetShortendedQualifiedTypeName, targetStateName);
						}
						
						 
						nextBody= nextBody+ CommonConstants.NEW_LINE+ generationValueGetter.generate(Generator.STATEMACHINE_PROCESSED_CASE, "");
						
						String guardCode = generationValueGetter.generationPointString(transition, ICppStatemachinesDefinitions.TRANSITION_GUARD_CODE_BODY);
						if (guardCode!= null&& !guardCode.isEmpty()) {
							List<GenComment> addComments = addComments(generationValueGetter, transition);
							
							nextBody= StringUtil.indent(CommonConstants.NEW_LINE+ nextBody, 1);
							nextBody= generationValueGetter.generate(Generator.IF_CONDITION_BLOCK, guardCode, nextBody);
							if(!addComments.isEmpty()){
								nextBody= addComments.stream().map(GenComment::getBody).collect(Collectors.joining(CommonConstants.NEW_LINE)) + CommonConstants.NEW_LINE+ nextBody;
							}
							
							nextBody= nextBody+ CommonConstants.NEW_LINE;
						}
						
						if(!body.isEmpty()){
							body= body+ CommonConstants.NEW_LINE;
						}
						body= body+ nextBody;
					}

					switchCases = switchCases+ generationValueGetter.generate(Generator.STATEMACHINE_SWITCH_CASE_DECLARATION,
							shortendedQualifiedTypeName, stateName, body);

				}
				
				String switchCall = generationValueGetter.generate(Generator.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
						instanceName, switchCases);
				
				GenBody switchBody = new GenBody(switchCall);
				method.addBody(switchBody);
			}

			genClass.addMethod(method);
		}
		
		//Ref12345: create GenAutostate and GenTimers
		generationValueGetter.addValue(AUTO_STATES, autoStates, uClass);
	}
	
	public static List<GenComment> addComments(GenerationPolicyRegistry generationValueGetter, Object element){
		List<String> all= new ArrayList<String>();
		List<GenComment> _comments= new ArrayList<GenComment>();
		List<?> comments= generationValueGetter.getList(element, IModelingElementDefinitions.COMMENTS);
		comments.forEach(c-> all.add(c.toString()));
		String multiLineComment = GenerationUtil.multiLineComment(all);
		if(!multiLineComment.isEmpty()){
			_comments.add(new GenComment(multiLineComment));
		}
		
		List<?> lineNumbers= generationValueGetter.getList(element, IModelingElementDefinitions.LINE_NUMBERS, generationValueGetter.rootModel.getLanguage());
		lineNumbers.forEach(c-> _comments.add(new GenComment(c.toString().trim())));
		
		return _comments;
	}

	private static GenMethod createEventMethod(GenerationPolicyRegistry generationValueGetter, GenClass genClass,
			Object event) {
		GenMethod method= new GenMethod();
		method.addBody(new GenAspectableReturnBody(Boolean.FALSE.toString(), WAS_EVENT_PROCESSED, CPPTypesConstants.BOOL));
		method.setVisibility(Visibilities.PUBLIC);
		method.setReturnType(CPPTypesConstants.BOOL);
		String eventName = generationValueGetter.getString(event, IModelingElementDefinitions.NAME);
		method.setName(eventName);
		genClass.addMethod(method);
		addParameters(generationValueGetter, event, method);
		return method;
	}

	private static void addParameters(GenerationPolicyRegistry generationValueGetter, Object event, GenMethod method) {
		List<?> eventParametersList = generationValueGetter.getList(event, ICppStatemachinesDefinitions.EVENT_PARAMETERS);
		for(Object _eventParameter: eventParametersList){
			String eventParameter = _eventParameter.toString();
			int lastIndexOf = eventParameter.lastIndexOf(" ");
			String type= eventParameter.substring(0, lastIndexOf).trim();
			String name= eventParameter.substring(lastIndexOf+1).trim();
			GenMethodParameter methodParameter = new GenMethodParameter(type, name);
			methodParameter.setNormalize(true);
			method.addParameter(methodParameter);
		}
	}

	private static void findExitDetails(GenerationPolicyRegistry generationValueGetter, Object uClass) {
		List<Object> allStateMachines = getAllStateMachines(generationValueGetter, uClass);
		
		Map<Object, Object> exitableStatemachines= new HashMap<Object, Object>();
		locateExitableClass(generationValueGetter, exitableStatemachines, uClass);
		
		for (Object sm : allStateMachines) {
			List<?> states = generationValueGetter.getList(sm, ICppStatemachinesDefinitions.STATES);
			findExitDetails(generationValueGetter, uClass, exitableStatemachines, sm, states, false);
		}
	}

	private static void findExitDetails(GenerationPolicyRegistry generationValueGetter, Object uClass, 
			Map<Object, Object> exitableStatemachines, Object sm, List<?> states, boolean isExternal) {
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME));
		String smName= generationValueGetter.getString(sm, IModelingElementDefinitions.NAME);
		
		StringBuffer preDeclarations = new StringBuffer();
		String switchCases= CommonConstants.BLANK;
		String swtichCalls= CommonConstants.BLANK;
		GenEnum genEnum = genClass.enumByName(StringUtil.firstCharacterToUpperCase(smName)+ "_");
		
		String qualifiedTypeName = getQualifiedTypeName(generationValueGetter, sm);
		String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(qualifiedTypeName);
		
		String shortendedQualifiedTypeName= genEnum== null? StringUtil.firstCharacterToUpperCase(smName): genEnum.safeName();
		int indexOfTimerStatemachine = genClass.indexOfTimerStatemachine(new GenStatemachine(qualifiedTypeName, smName));
		GenStatemachine timerStatemachine = indexOfTimerStatemachine>-1?genClass.getTimerStatemachine(indexOfTimerStatemachine): null;
		
		for (Object state : states) {
			boolean foundTimer= false;
			String stateName= generationValueGetter.getString(state, IModelingElementDefinitions.NAME);
			
			Object exitSm = exitableStatemachines.get(state);
//			int indexOfExitableStatemachine = genClass.indexOfExitableStatemachine(new GenStatemachine(qualifiedTypeName, smName));
//			GenStatemachine exitableStatemachine = indexOfExitableStatemachine>-1?genClass.getExitableStatemachine(indexOfExitableStatemachine): null;
			
			if(exitSm== null && timerStatemachine!= null){
				List<Object> doActivityCode = generationValueGetter.generationPointList(state, ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY);
				if(doActivityCode.isEmpty()){
					foundTimer= timerStatemachine.indexOfState(new GenState(stateName))> -1;
				}
			}
			
			String body= CommonConstants.BLANK;
			
			if(foundTimer){
				body= body+ "//Timer exit"+ CommonConstants.NEW_LINE;	//TODO //$NON-NLS-1$
			}
			
			if(exitSm!= null/*&& generationValueGetter.getValue(EXIT_IMPLEMENTATION, uClass, Visibilities.PRIVATE)!= null*/){
				String exitProcedureName= generationValueGetter.generate(Generator.STATEMCHAINE_EXIT_PROCEDURE_NAME, 
						generationValueGetter.getString(exitSm, IModelingElementDefinitions.NAME));
				
				body= body+ generationValueGetter.generate(Generator.PROCEDURE_CALL_AND_CHECK_DECLARATION, exitProcedureName, Boolean.TRUE);
			}else{
				body= body+ generationValueGetter.generate(Generator.PROCEDURE_CALL_AND_CHECK_DECLARATION, CPPTypesConstants.TRUE);
			}
			
			String exitCode = generationValueGetter.generationPointString(state, ICppStatemachinesDefinitions.STATE_EXIT_CODE_BODY);
			if (exitCode != null && !exitCode.isEmpty()) {
				if(!body.isEmpty()){
					body= body+ CommonConstants.NEW_LINE;
				}
				
				body= body+ exitCode+ CommonConstants.NEW_LINE;
				
			}
			
			List<Object> doActivityCodes = generationValueGetter.generationPointList(state, ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY);
			String indexer= doActivityCodes.isEmpty()? CommonConstants.BLANK: String.valueOf(1);
			for(Object activityCode: doActivityCodes){
				String doActivityCode= (String) activityCode;
				
				if(!doActivityCode.isEmpty()){
					Object statemachine = generationValueGetter.getObject(state, ICppStatemachinesDefinitions.STATEMACHINE);
					String smType = getQualifiedTypeName(generationValueGetter, statemachine);
					String stateType = getQualifiedTypeName(generationValueGetter, state);
					
					String switchVariableName= smType+ stateType;
					
					String threadInstance = generationValueGetter.generate(Generator.THREAD_INSTANCE, switchVariableName)+ indexer;
					body= body+ generationValueGetter.generate(Generator.STATEMCHAINE_THREAD_USE_DECLARATION, threadInstance);
				}
				
				if(!indexer.isEmpty()){
					indexer= String.valueOf((Integer.valueOf(indexer).intValue()+ 1));
				}
			}
			
			
			switchCases = switchCases+ generationValueGetter.generate(Generator.STATEMACHINE_SWITCH_CASE_DECLARATION,
					shortendedQualifiedTypeName, stateName, body);
		}
		
		List<Object> visited= new ArrayList<Object>();
		for(Object state:states){
			deepHistoryCheck(generationValueGetter,new GenMethod(), preDeclarations, state, visited);
		}
		
		if(preDeclarations.toString().isEmpty()){
			preDeclarations.append(CommonConstants.NEW_LINE);
			
			swtichCalls= preDeclarations+ swtichCalls;
		}
		
		if(!switchCases.trim().isEmpty()){
			swtichCalls= swtichCalls+ generationValueGetter.generate(Generator.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
					statemachineQualifiedName, switchCases);
			
			String exitProcedureName= generationValueGetter.generate(Generator.STATEMCHAINE_EXIT_PROCEDURE_NAME,qualifiedTypeName);
			
			String body= generationValueGetter.generate(Generator.STATEMACHINE_METHOD_IMPLEMENTATION,swtichCalls);
			GenMethod genMethod = exitMethodInstance(exitProcedureName);
			genMethod.addBody(new GenBody(body));
			genClass.addMethod(genMethod);
		}
	}

	private static GenMethod exitMethodInstance(String exitProcedureName) {
		GenMethod genMethod = new GenMethod();
		genMethod.setName(exitProcedureName);
		genMethod.setReturnType(CPPTypesConstants.BOOL);
		genMethod.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		return genMethod;
	}
	
	private static void findEnterImplementations(final GenerationPolicyRegistry generationValueGetter, Object uClass) {
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME));
		
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
			StringBuffer preDeclarations = new StringBuffer();
			String preConditions = CommonConstants.BLANK;
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
						sm = generationValueGetter.getObject(sm,ICppStatemachinesDefinitions.PARENT_STATEMACHINE);
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
					
					if(!preConditions.isEmpty()){
						preConditions= preConditions+ CommonConstants.NEW_LINE;
					}
					preConditions = preConditions+ generationValueGetter.generate(Generator.ENUM_VARIABLE_PLACEHOLDER_DECLARATION,
							shortendedQualifiedTypeName, statemachineQualifiedTypeName, statemachineQualifiedName);
					
					String instanceName = generationValueGetter.generate(Generator.VARIABLE_INSTANCE, statemachineQualifiedTypeName);
					
					for(Object nestedState: nestedStates){
						String nestedStateName = generationValueGetter.getString(nestedState, IModelingElementDefinitions.NAME);
						
						String setter= generationValueGetter.generate(Generator.STATES_SETTER_NAME_DEFINITION, 
								statemachineQualifiedTypeName);
						
						String body = generationValueGetter.generate(
								Generator.INVOKE_STATES_SETTER_DEFINITION, setter, shortendedQualifiedTypeName, nestedStateName);
						
						body= body+ CommonConstants.NEW_LINE+ generationValueGetter.generate(Generator.STATEMACHINE_PROCESSED_CASE, "");
						
						switchCases = /*switchCases+*/ generationValueGetter.generate(Generator.STATEMACHINE_SWITCH_CASE_DECLARATION,
								shortendedQualifiedTypeName, CPPCommonConstants.NIL, CommonConstants.NEW_LINE+ body);
						
						//Only looking for the first state
						break;
					}
					swtichCalls= swtichCalls+ generationValueGetter.generate(Generator.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
							instanceName, switchCases);
				}
			}
			
			List<Object> visited= new ArrayList<Object>();
			for(Object state:statesList){
				deepHistoryCheck(generationValueGetter, new GenMethod() ,preDeclarations, state, visited);
			}
			
			if(!preDeclarations.toString().isEmpty()){
				swtichCalls= CommonConstants.NEW_LINE+ CommonConstants.NEW_LINE+ preDeclarations+ CommonConstants.NEW_LINE+ swtichCalls;
			}
			
			String output= preConditions+ swtichCalls;
			
			String body= generationValueGetter.generate(Generator.STATEMACHINE_METHOD_IMPLEMENTATION,output);
			String enterProcedureName= generationValueGetter.generate(Generator.STATEMCHAINE_ENTER_PROCEDURE_NAME, stateName, IModelingElementDefinitions.NAME);
			
			GenMethod method = new GenMethod();
			method.addBody(new GenBody(body));
			method.setReturnType(CPPTypesConstants.BOOL);
			method.setName(enterProcedureName);
			method.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
			genClass.addMethod(method);
		}
	}

	private static void deepHistoryCheck(final GenerationPolicyRegistry generationValueGetter, GenMethod method, 
			StringBuffer preDeclarations, Object state, List<Object> visited) {
		if(visited.contains(state)){
			return;
		}
		visited.add(state);
		Object statemachine = generationValueGetter.getObject(state, ICppStatemachinesDefinitions.STATEMACHINE);
		boolean isHistory= generationValueGetter.getBoolean(state, ICppStatemachinesDefinitions.IS_HISTORY_STATE);
		if(isHistory){
			String qualifiedTypeName = getQualifiedTypeName(generationValueGetter, statemachine);
			String qualifiedName= StringUtil.firstCharacterToLowerCase(qualifiedTypeName);
			
			if(!preDeclarations.toString().isEmpty()){
				preDeclarations.append(CommonConstants.NEW_LINE);
			}
			
			String use = generationValueGetter.generate(Generator.HISTORY_STATE_CHECK, qualifiedName, qualifiedTypeName);
			preDeclarations.append(use);
			
			GenBody declarationBody = new GenBody(use);
			method.addBody(declarationBody);
		}
		
		for(Object nestedStateMachine: generationValueGetter.getList(state, ICppStatemachinesDefinitions.NESTED_STATEMACHINES)){
			for(Object nestedState: generationValueGetter.getList(nestedStateMachine, ICppStatemachinesDefinitions.STATES)){
				deepHistoryCheck(generationValueGetter, method, preDeclarations, nestedState, visited);
			}
		}
	}
		  
	@GenerationPoint(generationPoint = Generator.STATEMCHAINE_ENTRY_PROCEDURE_STATE_CONTENTS, priority=IGenerationPointPriorityConstants.LOWEST)
	public static String entryImplementationStateContents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object state,
			@GenerationArgument Object element,
			@GenerationProcedureParameter(id = ICppStatemachinesDefinitions.STATE_ENTRY_CODE_BODY) String entryCode,
			@GenerationProcedureParameter(id = ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_ON_COMPLETION_EVENT) String onCompletionEvent,
			@GenerationProcedureParameter(id = ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY) List<Object> doActivityCodes){
		
		String body= CommonConstants.BLANK;
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(element, IModelingElementDefinitions.NAME));
		String stateName= generationValueGetter.getString(state, IModelingElementDefinitions.NAME);
		
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
				
				if(genClass.fieldByName(variableName) != null){
					String variableType= StringUtil.firstCharacterToUpperCase(variableName);
					String qualifiedSwitchVariableType= getEnumQualifiedName(generationValueGetter, element, nestedStateMachine, variableType);
					
					String setterName= generationValueGetter.generate(Generator.STATES_SETTER_NAME_DEFINITION, 
							qualifiedSwitchVariableType);
					
					body= body+ generationValueGetter.generate(Generator.STATEMCHAINE_NESTED_STATE_BODY, 
							variableName, CPPCommonConstants.NIL, qualifiedSwitchVariableType, setterName, nestedStateName);
				}else if(!usedMain){
					String setterName= generationValueGetter.generate(Generator.STATES_SETTER_NAME_DEFINITION, 
							switchVariableType);
					String qualifiedSwitchVariableType= getEnumQualifiedName(generationValueGetter, element, nestedStateMachine, switchVariableType);
					body= body+ generationValueGetter.generate(Generator.STATEMCHAINE_NESTED_STATE_BODY, 
							switchVariableName, CPPCommonConstants.NIL, qualifiedSwitchVariableType, setterName, nestedStateName);
					usedMain= true;
				}
				
				//break changeNestedState;
			}
		}
		
		String contents= CommonConstants.BLANK;
		
		
		int indexOfTimerStatemachine = genClass.indexOfTimerStatemachine(new GenStatemachine(smType, smName));
		GenStatemachine timerStatemachine = indexOfTimerStatemachine>-1?genClass.getTimerStatemachine(indexOfTimerStatemachine): null;
		if(timerStatemachine!= null){
			List<Object> doActivityCode = generationValueGetter.generationPointList(state, ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY);
			if(doActivityCode.isEmpty()){
				if(timerStatemachine.indexOfState(new GenState(stateName))> -1){
					contents= contents+ "//Timer Start"+ CommonConstants.NEW_LINE;	//TODO //$NON-NLS-1$
				}
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
				String invocation = CommonConstants.NEW_LINE+ generationValueGetter.generate(
						Generator.METHOD_INVOCATION, autoEventName, CommonConstants.BLANK, Boolean.TRUE);
				contents= contents+	invocation; 
			}
		}
		
		String indexer= doActivityCodes.isEmpty()? CommonConstants.BLANK: String.valueOf(1);
		for(Object doActivityCodeObject: doActivityCodes){
			String doActivityCode= (String) doActivityCodeObject;
			if(onCompletionEvent!=null&& !onCompletionEvent.isEmpty()){
				String invocation = generationValueGetter.generate(Generator.METHOD_INVOCATION, onCompletionEvent, CommonConstants.BLANK, Boolean.TRUE);
				invocation= doActivityCode+ CommonConstants.NEW_LINE+ invocation;
				doActivityCode= invocation;
			}
			
			String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
			String threadInstance = generationValueGetter.generate(Generator.THREAD_INSTANCE, switchVariableType)+ indexer;
			String doActivityInstance = generationValueGetter.generate(Generator.DO_ACTIVITY_METHOD_INSTANCE, indexer+ switchVariableType);
			
			GenField threadField = new GenField();
			threadField.setVisibility(Visibilities.PRIVATE);
			threadField.setType("Thread");
			threadField.setIsPointer(true);
			threadField.setDestructible(true);
			threadField.setName(threadInstance);
			threadField.setGroup(new GenGroup(GenClass.HELPER_GROUP));
			genClass.addField(threadField);
			
			String mediator= generationValueGetter.generate(Generator.DO_ACTIVITY_MEDIATOR_IMPLEMENTATION, parentName, doActivityInstance); 

			GenMethod threadMethod = new GenMethod();
			threadMethod.setReturnType(CPPTypesConstants.VOID);
			threadMethod.setName(doActivityInstance);
			GenMethodParameter voidPointerParameter = new GenMethodParameter(CPPTypesConstants.VOID, "thisVoidPtr");
			voidPointerParameter.setIsPointer(true);
			threadMethod.addParameter(voidPointerParameter);
			threadMethod.addBody(new GenBody(mediator));
			genClass.addMethod(threadMethod);
			
			String nomralizedDoActivityCode= generationValueGetter.generate(Generator.DO_ACTIVITY_BODY_WRAP, doActivityCode);
			
			GenMethod threadWrapMethod = new GenMethod();
			threadWrapMethod.setReturnType(CPPTypesConstants.VOID);
			threadWrapMethod.setName(doActivityInstance);
			threadWrapMethod.setIsPointer(true);
			threadWrapMethod.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
			threadWrapMethod.addBody(new GenBody(nomralizedDoActivityCode));
			genClass.addMethod(threadWrapMethod);
			
			String functionPointer = generationValueGetter.generate(Generator.DO_ACTIVITY_FUNCTION_POINTER_IMPLEMENTATION, parentName,
					doActivityInstance, threadInstance);
			
			if(!contents.isEmpty()){
				contents= contents+ CommonConstants.NEW_LINE+ CommonConstants.NEW_LINE;
			}
			
			contents= contents+ functionPointer;
			if(!indexer.isEmpty()){
				indexer= String.valueOf((Integer.valueOf(indexer).intValue()+ 1));
			}
		}
		
		if(contents.isEmpty()){
			return contents;
		}
		contents= generationValueGetter.generate(Generator.DO_ACTIVITY_FUNCTION_WRAP, contents);
		
		return generationValueGetter.generate(Generator.STATEMACHINE_SWITCH_CASE_DECLARATION, smTypeQualified, 
				generationValueGetter.getString(state, IModelingElementDefinitions.NAME),contents);
	}

	private static void findSetterDetails(GenerationPolicyRegistry generationValueGetter, Object element) {
		List<Object> allStateMachines = getAllStateMachines(generationValueGetter, element);
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(element, IModelingElementDefinitions.NAME));
		
		for(Object statemachine: allStateMachines){
			String statemachineName = StringUtil.firstCharacterToLowerCase(generationValueGetter.getString(statemachine, IModelingElementDefinitions.NAME));
			String qualifiedTypeName = getQualifiedTypeName(generationValueGetter, statemachine);
			GenEnum enumByName = genClass.enumByName(qualifiedTypeName+"_");
			String statemachineQualifiedTypeName = enumByName.safeName();
			String statemachineQualifiedName= StringUtil.firstCharacterToLowerCase(statemachineQualifiedTypeName);
			
			String instanceName = generationValueGetter.generate(Generator.VARIABLE_INSTANCE, statemachineName);
			String body= generationValueGetter.generate(Generator.ASSIGN_STATEMENET, statemachineName, instanceName);
			body= body+ CommonConstants.NEW_LINE;
			
			Object parentState = generationValueGetter.getObject(statemachine, ICppStatemachinesDefinitions.PARENT_STATE);
			if(parentState!= null){
				Object parentStatemachine = generationValueGetter.getObject(parentState, ICppStatemachinesDefinitions.STATEMACHINE);
				String stateName = generationValueGetter.getString(parentState, IModelingElementDefinitions.NAME);
				
				
				String parentStatemachineType= getQualifiedTypeName(generationValueGetter, parentStatemachine);
				String parentQualifiedType= getEnumQualifiedName(generationValueGetter, element, parentStatemachine, parentStatemachineType);
				String parentStatemachineName= StringUtil.firstCharacterToLowerCase(parentStatemachineType);
				
				//sm != Sm.s1
				String enumUse1= generationValueGetter.generate(Generator.ENUM_USE, 
						parentQualifiedType, stateName);
				
				//aSmS1 != SmS1.Null
				String enumUse2= generationValueGetter.generate(Generator.ENUM_USE, 
						statemachineQualifiedTypeName, CPPCommonConstants.NIL);
				
				String condition1= generationValueGetter.generate(Generator.NOT_EQUAL, parentStatemachineName, enumUse1);
				String condition2= generationValueGetter.generate(Generator.NOT_EQUAL, instanceName, enumUse2);
				
				String conditions= condition1+ CommonConstants.SPACE+ CPPCommonConstants.AND+ CommonConstants.SPACE+ condition2;
				
				
				String setter= generationValueGetter.generate(Generator.STATES_SETTER_NAME_DEFINITION, parentStatemachineType);
				
				String setterUse = CommonConstants.NEW_LINE+ generationValueGetter.generate(
						Generator.INVOKE_STATES_SETTER_DEFINITION, setter, parentQualifiedType, stateName);
				
				body= body+ generationValueGetter.generate(Generator.IF_CONDITION_BLOCK, conditions, StringUtil.indent(setterUse, 1))+
						CommonConstants.NEW_LINE;
				
				
			}
			
			String languageStatemachineQualifiedTypeName = getEnumQualifiedName(generationValueGetter, element, statemachine, statemachineQualifiedTypeName);
			String setter= generationValueGetter.generate(Generator.STATES_SETTER_NAME_DEFINITION, statemachineName);
			
			List<?> states= generationValueGetter.getList(statemachine, ICppStatemachinesDefinitions.STATES);
			String entryContents= CommonConstants.BLANK;
			String entryBody= CommonConstants.BLANK;
			for(Object state: states){
				String results = generationValueGetter.generationPointString(state, Generator.STATEMCHAINE_ENTRY_PROCEDURE_STATE_CONTENTS, element);
				if(results!= null){
					entryBody = entryBody+ results;
				}
			}
			
			if(!entryBody.trim().isEmpty()){
				String reply= CommonConstants.NEW_LINE+ generationValueGetter.generate(Generator.SETTER_SWITCH_COMMENT, "");
				reply= reply+ generationValueGetter.generate(Generator.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, 
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
				String contents = generationValueGetter.generate(Generator.METHOD_INVOCATION, setter, 
						statemachineQualifiedTypeName+ CPPCommonConstants.DECLARATION_COMMON_PREFIX+ pseudoState, Boolean.TRUE);
				genClass.addConstructorContent(new GenBody(contents));
			}
			
			GenMethod method = new GenMethod();
			method.addBody(new GenBody(body));
			method.setReturnType(CPPTypesConstants.VOID);
			method.setName(setter);
			method.addParameter(new GenMethodParameter(languageStatemachineQualifiedTypeName, instanceName));
			genClass.addMethod(method);
			
			for(Object state: states){
				boolean isHistory= generationValueGetter.getBoolean(state, ICppStatemachinesDefinitions.IS_HISTORY_STATE);
				if(isHistory){
					String historyQualifiedTypeName = qualifiedTypeName+ HISTORY_STATE_SUFFIX;
					String historyQualifiedName= StringUtil.firstCharacterToLowerCase(historyQualifiedTypeName);
					
					String first= generationValueGetter.getString(states.get(0), IModelingElementDefinitions.NAME);
					String use = generationValueGetter.generate(Generator.ASSIGN_STATEMENET, historyQualifiedName, 
							qualifiedTypeName+ CommonConstants.COLON+ CommonConstants.COLON+ first);
					
					genClass.addConstructorContent(new GenBody(use));
				}
			}
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
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation
	}, aspect= LoopAspectConstants.AFTER)
	public static void eventsGlobalDefinitions(@GenerationRegistry final GenerationPolicyRegistry generationValueGetter,
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
			contents= contents+ generationValueGetter.generate(Generator.DEFINITION_DECLARATION, name, Integer.valueOf(index));
		}
		if(!contents.isEmpty()){
			UniqueGenBody predefinition = new UniqueGenBody(contents, null);
			predefinition.setPriority(GenPriorities.HIGH);
			generationValueGetter.rootModel.addPredefinition(predefinition);
		}
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
			values= values+ generationValueGetter.generate(Generator.ENUM_VALUE, CPPCommonConstants.NIL, Integer.valueOf(0));
			incrementer++;
			if(size>0){
				values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
			}
		}
		
		for(int index=0; index<states.size(); index++){
			Object next = states.get(index);
			values= values+ generationValueGetter.generate(Generator.ENUM_VALUE, 
					generationValueGetter.getString(next, IModelingElementDefinitions.NAME), Integer.valueOf(index+incrementer));
			
			if(index<states.size()-1){
				values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
			}
		}
		return values;
	}

	public static List<String> getCases(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, Object statemachine, boolean isNested){
		List<?> statesList= generationValueGetter.getList(statemachine, ICppStatemachinesDefinitions.STATES);
		List<String> cases= new ArrayList<String>();
		if(isNested){
			cases.add(CPPCommonConstants.NIL);
		}
		
		@SuppressWarnings("unchecked")
		List<Object> states= applyStatesHack(generationValueGetter, (List<Object>) statesList);
		
		Iterator<?> iterator = states.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			String value= generationValueGetter.getString(next, IModelingElementDefinitions.NAME);
			cases.add(value);
		}
		
		return cases;
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

		Object currentState = generationValueGetter.getObject(parentStatemachine, ICppStatemachinesDefinitions.PARENT_STATE);
		if (currentState == null) {
			return null;
		}

		while (currentState != null) {
			Object sm = generationValueGetter.getObject(currentState, ICppStatemachinesDefinitions.STATEMACHINE);
			Object currentExitSm = exitableStatemachines.get(currentState);
			if (currentExitSm != null && /*FIXME: Weak check */!currentState.equals(nextState)) {
				return new SimpleEntry<Object, Object>(sm, currentExitSm);
			}
			currentState = generationValueGetter.getObject(sm, ICppStatemachinesDefinitions.PARENT_STATE);
		}
		return null;
	}
	
	private static void locateExitableClass(GenerationPolicyRegistry generationValueGetter, Map<Object, Object> exitableStatemachines, Object uClass) {
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME));
		List<?> statemachines = generationValueGetter.getList(uClass, ICppStatemachinesDefinitions.STATEMACHINES);
		for (Object sm : statemachines) {
			prepareNestedStatesFor(generationValueGetter, genClass, exitableStatemachines, sm, 0, 0);
		}
	}

	private static void prepareNestedStatesFor(GenerationPolicyRegistry generationValueGetter, GenClass genClass,
			Map<Object, Object> exitableStatemachines, Object sm, int concurrentIndex, int level) {
		Object parentState = generationValueGetter.getObject(sm, ICppStatemachinesDefinitions.PARENT_STATE);
		String parentStateName= generationValueGetter.getString(parentState, IModelingElementDefinitions.NAME);
		
		Object startState = generationValueGetter.getObject(sm, ICppStatemachinesDefinitions.START_STATE);
		if (parentState != null && startState != null) {
			Object current = parentState;
			while (true) {
				Object parentStatemachine = generationValueGetter.getObject(current, ICppStatemachinesDefinitions.STATEMACHINE);
				if (parentStatemachine == null) {
					break;
				}
				
				Object owingState = generationValueGetter.getObject(parentStatemachine, ICppStatemachinesDefinitions.PARENT_STATE);
				if(owingState== null){
					break;
				}
				
				current = owingState;
			}
			
			if (generationValueGetter.getObject(sm, ICppStatemachinesDefinitions.START_STATE) != null&& concurrentIndex == 0) {
				String qualifiedTypeName = getQualifiedTypeName(generationValueGetter, sm);
				String stateName= generationValueGetter.getString(current, IModelingElementDefinitions.NAME);
				GenStatemachine volatileStatemachine = new GenStatemachine(qualifiedTypeName, parentStateName);
				int indexOfExitableStatemachine = genClass.indexOfStatemachine(volatileStatemachine);
				if(indexOfExitableStatemachine <0){
					genClass.addStatemachine(volatileStatemachine);
				}else{
					volatileStatemachine= genClass.getStatemachine(indexOfExitableStatemachine);
				}
				
				GenState genState= new GenState(parentStateName);
				genState.setLevel(level);
				volatileStatemachine.addState(genState);
				
				GenState exitState= new GenState(stateName);
				exitState.setLevel(level);
				genState.addExitableState(exitState);
				
				exitableStatemachines.put(parentState, current);
			}
		}

		List<?> states = generationValueGetter.getList(sm, ICppStatemachinesDefinitions.STATES);
		for (Object s : states) {
			int nestedSmIndex = 0;
			
			for (Object nestedStateMachine : generationValueGetter.getList(s, ICppStatemachinesDefinitions.NESTED_STATEMACHINES)) {
				//exitableStatemachines.put(s, s);
				//nestedSmIndex += 1;
				
				prepareNestedStatesFor(generationValueGetter, genClass, exitableStatemachines, nestedStateMachine, nestedSmIndex, level+1);
				nestedSmIndex += 1;
			}
		}
	}
  
  
	private static String getQualifiedTypeName(GenerationPolicyRegistry generationValueGetter, Object sm) {
		Object current= sm;
		String qualifiedTypeName = StringUtil.firstCharacterToUpperCase(generationValueGetter.getString(current, IModelingElementDefinitions.NAME));
		
		while (true) {
			current = generationValueGetter.getObject(current,ICppStatemachinesDefinitions.PARENT_STATEMACHINE);
			if (current == null) {
				break;
			}

			qualifiedTypeName = StringUtil.firstCharacterToUpperCase(generationValueGetter.getString(current,IModelingElementDefinitions.NAME))
					+ qualifiedTypeName;
		}
		return qualifiedTypeName;
	}
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.TRANSITION_EFFECT_CODE_BODY)
	public static String effect(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object transition){
		return generationValueGetter.getString(transition, ICppStatemachinesDefinitions.TRANSITION_EFFECT_CODE_BODY, CPPCommonConstants.CPP_LANGUAGE);
	}
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.TRANSITION_GUARD_CODE_BODY)
	public static String guard(@GenerationRegistry final GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object transition){
		return generationValueGetter.getList(transition, IModelingElementDefinitions.CONSTRAINTS).stream()
				.map(constraint-> {
					return generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS, Boolean.FALSE);
				})
				.collect(Collectors.joining(" &&"));
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
	public static List<?> doActivity(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object state){
		return generationValueGetter.getList(state, ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_CODE_BODY, CPPCommonConstants.CPP_LANGUAGE);
	}
	
	@GenerationPoint(generationPoint= ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_ON_COMPLETION_EVENT)
	public static String doActivityOnCompletion(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object state){
		return generationValueGetter.getString(state, ICppStatemachinesDefinitions.STATE_DO_ACTIVITY_ON_COMPLETION_EVENT/*, CPPCommonConstants.CPP_LANGUAGE*/);
	}
	
}