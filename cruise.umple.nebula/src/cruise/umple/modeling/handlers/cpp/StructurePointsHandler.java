/*******************************************************************************
'* Copyright (c) 2013 Ahmed M.Orabi, Mahmoud M.Orabi.
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
import java.util.Arrays;
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
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationLoopAnnotation;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.Generator;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.gen.AbstractGenConstraint;
import cruise.umple.cpp.gen.ActiveGenMethd;
import cruise.umple.cpp.gen.ActiveMemberInitializer;
import cruise.umple.cpp.gen.GenActiveField;
import cruise.umple.cpp.gen.GenAssociation;
import cruise.umple.cpp.gen.GenAssociationEnd;
import cruise.umple.cpp.gen.GenBody;
import cruise.umple.cpp.gen.GenClass;
import cruise.umple.cpp.gen.GenComplexPort;
import cruise.umple.cpp.gen.GenConnectEntry;
import cruise.umple.cpp.gen.GenConstraint;
import cruise.umple.cpp.gen.GenConstraintCondition;
import cruise.umple.cpp.gen.GenConstraintVariable;
import cruise.umple.cpp.gen.GenConstructorMethod;
import cruise.umple.cpp.gen.GenDepend;
import cruise.umple.cpp.gen.GenEndpointPropagationBody;
import cruise.umple.cpp.gen.GenField;
import cruise.umple.cpp.gen.GenFieldGeneric;
import cruise.umple.cpp.gen.GenFieldInitializer;
import cruise.umple.cpp.gen.GenGroup;
import cruise.umple.cpp.gen.GenInterface;
import cruise.umple.cpp.gen.GenMethod;
import cruise.umple.cpp.gen.GenMethodParameter;
import cruise.umple.cpp.gen.GenPackage;
import cruise.umple.cpp.gen.GenPort;
import cruise.umple.cpp.gen.GenPriorities;
import cruise.umple.cpp.gen.GenSpecializedDefinition;
import cruise.umple.cpp.gen.MemberInitializer;
import cruise.umple.cpp.gen.SuperMemberInitializer;
import cruise.umple.cpp.gen.UniqueGenBody;
import cruise.umple.cpp.gen.Visibilities;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.IStructureConstants;

public class StructurePointsHandler{
	
	private static final String QUEUE_USE = "queue"; //$NON-NLS-1$
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.AFTER, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IStructureConstants.PORTS_PROCESSOR})
	})
	public static void addStructureDiagramAPIs(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		generationValueGetter.rootModel.setRequiresThread(true);
		generationValueGetter.rootModel.addPredefinition(new UniqueGenBody(generationValueGetter.rootModel.publishSubscribeAPI(), null));
		for(String include: new String[]{QUEUE_USE, ISTLConstants.MAP}){
			GenDepend genInclude = new GenDepend(include);
			genInclude.setNamespace(ISTLConstants.STD_LIBRARY);
			genInclude.setIsLibrary(true);
			generationValueGetter.rootModel.addInclude(genInclude);
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}, aspect= LoopAspectConstants.AFTER)
	public static void registerClasses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationElementParameter(id = IStructureConstants.PORT_BINDINGS) List<?> portBindings,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		boolean isComplexPort = generationValueGetter.getBoolean(parent, IStructureConstants.IS_COMPLEX_PORT);
		if(isComplexPort){
			genClass.setGeneratable(false);
		}
		
		GenPackage rootModel = generationValueGetter.rootModel;
		
		String activeObjectUID = genClass.activeObjectUID();
		
		if(!rootModel.hasTemplate(activeObjectUID) && genClass.isGeneratable()){
			List<?> ports = generationValueGetter.getList(element, IStructureConstants.PORTS);
			List<?> activeMethods= generationValueGetter.getList(parent, IStructureConstants.ACTIVE_METHODS);
			if(!ports.isEmpty() || !portBindings.isEmpty() || !activeMethods.isEmpty()){
				genClass.addSpecializedDefinition(new GenSpecializedDefinition(activeObjectUID));
			}
		} 
		
		String windowsSocketDefinition = genClass.windowsSocketDefinition();
		if(!rootModel.hasTemplate(windowsSocketDefinition) && genClass.getIsRemote()){
			genClass.addSpecializedDefinition(new GenSpecializedDefinition(windowsSocketDefinition));
		}
		
		String remoteParserDefinition = genClass.remoteParserDefinition();
		if(!rootModel.hasTemplate(remoteParserDefinition) && genClass.getIsRemote()){
			genClass.addSpecializedDefinition(new GenSpecializedDefinition(remoteParserDefinition));
		}
		
		String localHostDefinition = genClass.getGenPackage().getLocalHost();
		if(!rootModel.hasTemplate(localHostDefinition) && genClass.getIsRemote()){
			genClass.addSpecializedDefinition(new GenSpecializedDefinition(localHostDefinition));
		}
		
		if(genClass.getIsRemote()){
			GenConstructorMethod byEndPoint= constructorMethodInstance(generationValueGetter, genClass);
			byEndPoint.addPrePolymorphicParameter(new GenMethodParameter("Endpoint", "ep"));
			
			GenConstructorMethod byPort= constructorMethodInstance(generationValueGetter, genClass);
			byPort.addPrePolymorphicParameter(new GenMethodParameter(CPPTypesConstants.UNSIGNED_INTEGER, "_portValue"));
		}
		
		if(portList.isEmpty()&& portBindings.isEmpty()){
			return;
		}
		
		List<String> listeners= new ArrayList<String>();
		
		GenMethod portInitConnectionsMethod = portInitConnectionsMethod(generationValueGetter, parent);
		
		for(ActiveGenMethd activeMethod: genClass.activeMethods()){
			String activeMethodName = activeMethod.getBaseName();
			List<AbstractGenConstraint> constraints = activeMethod.getConstraints();
			for(AbstractGenConstraint constraint: constraints){
				if(constraint.numberOfListeners()==1){
					listeners.add(constraint.getListener(0).getName());
				}
			}
			for(String name: listeners){
				//portInitConnectionsMethod.addBody(new GenBody("this->"+name+ "+= "+(isReference?"&":"")+ "this->"+activeMethodName+";"));
				portInitConnectionsMethod.addBody(new GenConnectEntry(null, name, null, activeMethodName, null));
			}
		}
	}
	
	private static GenConstructorMethod constructorMethodInstance(GenerationPolicyRegistry generationValueGetter, GenClass genClass) {
		GenConstructorMethod method = new GenConstructorMethod();
		method.setIsConstructor(true);
		method.setName(genClass.getName());
		method.setVisibility(Visibilities.PUBLIC);
		method.addDefaultImplementation(new GenBody(generationValueGetter.generate(Generator.NO_IMPLEMENTATION, null)));
		genClass.addMethod(method);
		
		method.setGroup(new GenGroup(GenClass.CONSTRUCTOR_GROUP));
		method.setDisableRemote(true);
		return method;
	}
	
	@GenerationLoopAnnotation(id = IStructureConstants.PORTS_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getNavigableAssociationVariables(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IStructureConstants.PORTS);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.DEFAULT, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	})
	public static void registerConnectorsConstructorUses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationElementParameter(id = IStructureConstants.PORT_BINDINGS) List<?> portBindings,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		
		if(portList.isEmpty()&& portBindings.isEmpty()){
			return;
		}
		
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		String use = generationValueGetter.generate(Generator.PORT_PROTOCOL_HANDLER_EVENT_CONSTRUCTOR, "");
		genClass.addConstructorContent(new GenBody(use));
	}
	
	//Test
	@LoopProcessorAnnotations(priority= IGenerationPointPriorityConstants.LOW, aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static List<ActiveGenMethd> registerActiveMethods(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IStructureConstants.ACTIVE_METHODS) List<?> activeMethods,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument List<?> otherActiveMethods,
			@GenerationArgument boolean conjugated) {

		if(activeMethods == null || activeMethods.isEmpty()){
			addSchedulerMemeber(element, generationValueGetter, activeMethods);
			return new ArrayList<ActiveGenMethd>();
		}
		
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(element, IModelingElementDefinitions.NAME));
		GenMethod method= new GenMethod();
		method.setReturnType(CPPTypesConstants.BOOL);
		method.setName("schedulerGuards_");
		method.setVisibility(Visibilities.PRIVATE);
		method.addParameter(new GenMethodParameter(CPPTypesConstants.INTEGER, "guardId"));
		genClass.addMethod(method);
		
//		for(Object activeMethod: activeMethods){
//			Object methodToLook= conjugated? generationValueGetter.getObject(activeMethod, IStructureConstants.CONJUGATED_ACTIVE_METHOD): activeMethod;
//			
//			List<?> constraints = generationValueGetter.getList(methodToLook, IModelingElementDefinitions.CONSTRAINTS);
//			for(Object constraint: constraints){
//				String current= generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS,Boolean.TRUE);
//				if(current!= null){
//					current= current.trim();
//					if(current.equals(portName)){
//						return true;
//					}
//				}
//			}
//		}
		
		List<ActiveGenMethd> methods= registerActionCode(element, parent, activeMethods, generationValueGetter, modelPackage, otherActiveMethods, conjugated);
		
		addSchedulerMemeber(element, generationValueGetter, activeMethods);
		
		for(Object activeMethod: activeMethods){
			Map<String, Object> map = constraintMap(generationValueGetter, parent, activeMethod);
			
			if(!map.containsKey("PERIOD") || !parameterless(generationValueGetter, activeMethod)){
				addActiveMember(element, generationValueGetter, activeMethod, null);
			}else{
				addAsyncMember(element, generationValueGetter, activeMethod);
			}
		}
		
		return methods;
	}

	private static void addSchedulerMemeber(Object owner, GenerationPolicyRegistry generationValueGetter,
			List<?> activeMethods) {
		List<String> params= new ArrayList<String>();
		params.add("this");
		
		String name= generationValueGetter.getString(owner, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		
		GenMethod methodByName = genClass.methodByName("schedulerGuards_");
		if((methodByName != null&& methodByName.hasBody()) || genClass.getIsRemote()){
			MemberInitializer memberInitializer = addScheduler(owner, generationValueGetter, genClass);
			
			if(methodByName != null&& methodByName.hasBody()){
				methodByName.addBody(new GenBody("return true;"));
				memberInitializer.addInitializer(new GenFieldInitializer("&"+name+ "::"+"schedulerGuards_"));
			}else{
				genClass.removeMethod(methodByName);
			}
			
			if(genClass.getIsRemote()){
				MemberInitializer routerInitializer = new SuperMemberInitializer("_messageRouter");
				routerInitializer.setPriority(-20);
				genClass.addMemberInitializer(routerInitializer);
			}
		}else{
			List<String> portNames = portNames(generationValueGetter, owner);
			if(!portNames.isEmpty() || (activeMethods!= null && !activeMethods.isEmpty())){
				addScheduler(owner, generationValueGetter, genClass);
			}
			
			genClass.removeMethod(methodByName);
		}
	}

	private static MemberInitializer addScheduler(Object owner, GenerationPolicyRegistry generationValueGetter,
			GenClass genClass) {
		setScheduler(generationValueGetter, owner);
		
		MemberInitializer memberInitializer = new MemberInitializer("_internalScheduler");
		memberInitializer.setPriority(-10);
		genClass.addMemberInitializer(memberInitializer);
		memberInitializer.addInitializer(new GenFieldInitializer("this"));
		return memberInitializer;
	}
	
	private static void watchPort(GenerationPolicyRegistry generationValueGetter, Object methodOwner,  GenMethod method, Object element, Object registerTo){
		List<?> ports  = ports(generationValueGetter, methodOwner);
		List<String> portNames = portNames(generationValueGetter, ports);
		
		List<?> constraints = generationValueGetter.getList(element, IModelingElementDefinitions.CONSTRAINTS);
		constraints.forEach(constraint-> {
			String current= generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS,Boolean.TRUE);
			if(current!= null){
				current= current.trim();
				int index= portNames.indexOf(current);
				if(index>-1){
					Object port = ports.get(index);
					String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
					String normalizedType= generationValueGetter.getString(port, IModelingElementDefinitions.TYPE_NAME);
					normalizedType= generationValueGetter.rootModel.getNormalizedType(normalizedType);
					
					if(!normalizedType.isEmpty()){
						GenMethodParameter methodParameter = new GenMethodParameter(normalizedType, current);
						methodParameter.setRelatedField(portName);
						method.addParameter(methodParameter);
					}
				}
			}
		});
	}
	
	private static String constraintExpression(Object owner, GenerationPolicyRegistry generationValueGetter,
			List<?> constraints) {
		List<String> search= new ArrayList<String>();
		
		for(Object constraint: constraints){
			String current= generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS, Boolean.TRUE);
			if(!current.isEmpty()){
				search.add("("+current+")");
			}
		}
		
		String expression= String.join(" && ", search);
		return expression;
	}
	
	private static String guardCondition(GenerationPolicyRegistry generationValueGetter, String id, String condition){
		return generationValueGetter.generate(Generator.IF_CONDITION, "guardId == "+ id+ ".getConditionUID()", "return "+ condition+ ";");
	}

	private static void addActiveMember(Object owner, GenerationPolicyRegistry generationValueGetter, Object activeMethod, String referenceMethod) {
		String methodName= generationValueGetter.getString(activeMethod, IModelingElementDefinitions.NAME);
		Map<String, Object> map = constraintMap(generationValueGetter, owner, activeMethod);
		addActiveMember(null, owner, generationValueGetter, methodName, map, referenceMethod);
	}

	private static void addActiveMember(GenActiveField activeField, Object owner, GenerationPolicyRegistry generationValueGetter,
			String methodName, Map<String, Object> map, String referenceMethod) {
		if(referenceMethod== null){
			referenceMethod= "_"+ methodName;
		}
		
		String name= generationValueGetter.getString(owner, IModelingElementDefinitions.NAME);
		
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		MemberInitializer _memberInitializer = genClass.initializerByName(methodName);
		MemberInitializer memberInitializer;
		if(_memberInitializer == null){
			memberInitializer = activeField == null? new MemberInitializer(methodName): new ActiveMemberInitializer(methodName, activeField);
			genClass.addMemberInitializer(memberInitializer);
			memberInitializer.addInitializer(new GenFieldInitializer("this"));
			memberInitializer.addInitializer(new GenFieldInitializer("&_internalScheduler"));
			memberInitializer.addInitializer(new GenFieldInitializer("&"+name+ "::"+ referenceMethod));
		}else{
			memberInitializer= _memberInitializer;
		}
		
		if(map != null){
			List<String> timersFromMap = activeTimersFromMap(generationValueGetter, map);
			timersFromMap.forEach(timer->memberInitializer.addInitializer(new GenFieldInitializer(timer)));
		}
	}
	
	private static void addAsyncMember(Object owner, GenerationPolicyRegistry generationValueGetter, Object activeMethod) {
		Map<String, Object> map = constraintMap(generationValueGetter, owner, activeMethod);
		if(map.containsKey("PERIOD")){
			List<String> timers = timersFromMap(generationValueGetter, map);
			
			String perioidicMethodName = perioidicMethodName(generationValueGetter, activeMethod);
			String methodName= "_"+generationValueGetter.getString(activeMethod, IModelingElementDefinitions.NAME);
			
			asyncPeriodicCall(generationValueGetter, perioidicMethodName, methodName, timers, owner);
			
			String constructorCall= startCall(perioidicMethodName);
			
			GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(owner, IModelingElementDefinitions.NAME));
			genClass.addUniqueConstructorContent(new UniqueGenBody(constructorCall, constructorCall));
		}
	}

	private static List<String> timersFromMap(GenerationPolicyRegistry generationValueGetter, Map<String, Object> map) {
		List<String> timers= new ArrayList<String>();
		
		Object period = map.get("PERIOD");
		Object latency = map.get("LTENCY");
		if(latency== null){
			latency= map.get("AFTER");
		}
		Object timeout = map.get("TIMEOUT");
		
		String periodValue= timerValue(generationValueGetter, period);
		String latencyValue= timerValue(generationValueGetter, latency);
		String timeoutValue= timerValue(generationValueGetter, timeout);
		
		if(timeout!= null){
			timers.add(defaultValue(periodValue));
			timers.add(defaultValue(latencyValue));
			timers.add(defaultValue(timeoutValue));
		}else if(latency!= null){
			timers.add(defaultValue(periodValue));
			timers.add(defaultValue(latencyValue));
		}else if(period!= null){
			timers.add(defaultValue(periodValue));
		}

		return timers;
	}

	private static String defaultValue(String value) {
		return value!= null? value: "0";
	}

	private static List<String> activeTimersFromMap(GenerationPolicyRegistry generationValueGetter, Map<String, Object> map) {
		List<String> timers= new ArrayList<String>();
		
		Object latency = map.get("LTENCY");
		if(latency== null){
			latency= map.get("AFTER");
		}
		Object timeout = map.get("TIMEOUT");
		Object priority = map.get("PRIORITY");
		
		String priorityValue= timerValue(generationValueGetter, priority);
		String latencyValue= timerValue(generationValueGetter, latency);
		String timeoutValue= timerValue(generationValueGetter, timeout);
		
		if(timeout!= null){
			timers.add(defaultValue(priorityValue));
			timers.add(defaultValue(latencyValue));
			timers.add(defaultValue(timeoutValue));
		}else if(latency!= null){
			timers.add(defaultValue(priorityValue));
			timers.add(defaultValue(latencyValue));
		}else if(priority != null){
			timers.add(defaultValue(priorityValue));
		}

		return timers;
	}
	
	private static String timerValue(GenerationPolicyRegistry generationValueGetter, Object constraint) {
		if(constraint == null){
			return "0";
		}
		return constraint instanceof String? (String) constraint: generationValueGetter.getString(constraint, IStructureConstants.TIMER);
	}

	private static String startCall(String perioidicMethodName) {
		return perioidicMethodName+ ".start();";
	}
	
	private static String stopCall(String perioidicMethodName) {
		return perioidicMethodName+ ".stop();";
	}
	
	private static GenField setScheduler(GenerationPolicyRegistry generationValueGetter, Object parent){
		String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(parentName);
		GenField schedulerField = genClass.fieldByName("_internalScheduler");
		if(schedulerField== null){
			schedulerField= new GenField();
			schedulerField.addGeneric(new GenFieldGeneric(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME)));
			schedulerField.setType("Scheduler");
			schedulerField.setName("_internalScheduler");
			schedulerField.setIsComparable(false);
			schedulerField.setPriority(-5);
			genClass.addField(schedulerField);
		}
		return schedulerField;
	}
	
	private static List<ActiveGenMethd> registerActionCode(Object element, Object registerTo, List<?> activeMethods,
			GenerationPolicyRegistry generationValueGetter, Object modelPackage, List<?> otherActiveMethods, boolean conjugated) {
		generationValueGetter.rootModel.setRequiresThread(true);
		
		String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass baseClass = generationValueGetter.rootModel.classByName(parentName);
		
		setScheduler(generationValueGetter, registerTo);
		List<ActiveGenMethd> methods= new ArrayList<ActiveGenMethd>();
		
		String registerToName= generationValueGetter.getString(registerTo, IModelingElementDefinitions.NAME);
		GenClass registerToClass = generationValueGetter.rootModel.classByName(registerToName);
		
		int index=0;
		for(Object activeMethod: activeMethods){
			Object conjugatedActiveMethod= conjugatedMethod(generationValueGetter, activeMethod);
			
			boolean reverse= false;
			boolean inverse= false;
			
			if(element != registerTo){
				for(GenClass genClass: generationValueGetter.rootModel.getClasses()){
					Object clazz = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, genClass.getName()).get(0);
					List<?> portBindings= generationValueGetter.getList(clazz, IStructureConstants.PORT_BINDINGS);
					if(portBindings!= null){
						for(Object binding: portBindings){
							Object fromPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_PORT);
							Object toPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_PORT);
							String toPartName= generationValueGetter.getString(toPort, IModelingElementDefinitions.NAME);
							String fromPartName= generationValueGetter.getString(fromPort, IModelingElementDefinitions.NAME);
							
							String toPartTypeName= generationValueGetter.getString(toPort, IModelingElementDefinitions.TYPE_NAME);
							String fromPartTypeName= generationValueGetter.getString(fromPort, IModelingElementDefinitions.TYPE_NAME);
							if(toPartTypeName!= null && toPartTypeName.equals(fromPartTypeName)){
								Object fromPortParent= generationValueGetter.getObject(fromPort, IStructureConstants.PORT_OWNING_CLASS);
								Object toPortParent= generationValueGetter.getObject(toPort, IStructureConstants.PORT_OWNING_CLASS);
								
								if(registerTo.equals(fromPortParent) || registerTo.equals(toPortParent)){
									Object methodToLook= activeMethod; 
									
									//generationValueGetter.getObject(activeMethod, IStructureConstants.CONJUGATED_ACTIVE_METHOD)
									List<?> constraints = generationValueGetter.getList(methodToLook, IModelingElementDefinitions.CONSTRAINTS);
									if(constraints.isEmpty()){
										constraints= generationValueGetter.getList(conjugatedActiveMethod, IModelingElementDefinitions.CONSTRAINTS);
									}
									
									
									for(Object constraint: constraints){
										String current= generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS,Boolean.TRUE);
										if(current!= null){
											current= current.trim();
											if(current.equals(toPartName)){
												reverse= true; 
											}
											
											if(current.equals(fromPartName)){
												inverse= true; 
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			if(reverse || inverse){
				if(reverse){
					index = setCode(element, registerTo, activeMethods, generationValueGetter, otherActiveMethods,
							methods, index, conjugatedActiveMethod , activeMethod);
				}
				
				if(inverse){
					index = setCode(element, registerTo, activeMethods, generationValueGetter, otherActiveMethods,
							methods, index, activeMethod, conjugatedActiveMethod);
				}
			}else{
				index = setCode(element, registerTo, activeMethods, generationValueGetter, otherActiveMethods,
						methods, index, activeMethod, conjugatedActiveMethod);
			}
		}
		
		return methods;
	}
	
	private static Object conjugatedMethod(GenerationPolicyRegistry generationValueGetter, Object activeMethod){
		Object conjugated = generationValueGetter.getObject(activeMethod, IStructureConstants.CONJUGATED_ACTIVE_METHOD);
		if(conjugated == null){
			for(Object element1: generationValueGetter.getList(generationValueGetter.rootElement, IModelingElementDefinitions.CLASSES)){
				List<?> forwardActiveMethods = generationValueGetter.getList(element1, IStructureConstants.ACTIVE_METHODS);
				for(Object forwardActiveMethod: forwardActiveMethods){
					if(forwardActiveMethod.equals(activeMethod)){
						return conjugated;
					}
					
					Object otherConjugated = generationValueGetter.getObject(forwardActiveMethod, IStructureConstants.CONJUGATED_ACTIVE_METHOD);
					if(otherConjugated != null && otherConjugated.equals(activeMethod)){
						return forwardActiveMethod;
					}
				}
			}
			
		}
		return conjugated;
	}

	private static int setCode(Object element, Object registerTo, List<?> activeMethods,
			GenerationPolicyRegistry generationValueGetter, List<?> otherActiveMethods,
			List<ActiveGenMethd> methods, int index, Object activeMethod,
			Object conjugatedActiveMethod) {
		
		String registerToName= generationValueGetter.getString(registerTo, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(registerToName);
		String parentName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass baseClass = generationValueGetter.rootModel.classByName(parentName);
		
		String returnType= generationValueGetter.getString(activeMethod, IModelingElementDefinitions.RETURN_TYPE);
		if(returnType== null || returnType.isEmpty()){
			returnType= CPPTypesConstants.VOID;
		}
		String originalMethodName= generationValueGetter.getString(activeMethod, IModelingElementDefinitions.NAME);
		String methodName= originalMethodName;
		if(genClass.getIsRemote()){
			methodName= "internal_"+ methodName;
		}
		
		String methodInvoke = "_"+originalMethodName;
		GenMethod prev = genClass.methodByName(methodInvoke);
		
		ActiveGenMethd method = prev instanceof ActiveGenMethd? (ActiveGenMethd) prev: new ActiveGenMethd();
		
		methods.add(method);
		method.setBaseName(originalMethodName);
		method.setDefinitionClass(baseClass);
		
		if(conjugatedActiveMethod != null){
			String conjugatedActiveMethodName= generationValueGetter.getString(conjugatedActiveMethod, IModelingElementDefinitions.NAME);
			method.setInverseMethod(conjugatedActiveMethodName);
		}
		
		method.setName(methodInvoke);
		genClass.addMethod(method);
		
		List<?> list = generationValueGetter.getList(activeMethod, IModelingElementDefinitions.CONSTRAINTS);
		addConstraints(generationValueGetter, method, list);
		
		String timedConstraints= getContraintString(generationValueGetter, element, activeMethod);
		if(!timedConstraints.isEmpty()){
			method.addBody(new GenBody(timedConstraints));
		}
		
		activeMethodBodies(generationValueGetter, registerTo, method, activeMethods, activeMethod, methodName);
		
		method.setReturnType(returnType);
		method.setVisibility(Visibilities.PRIVATE);
		
		//FIXME: get rid of otherActiveMethods parameters
		Object reachToActiveMethod = otherActiveMethods!= null?otherActiveMethods.get(index):activeMethod;
		List<GenMethodParameter> activeMethodParameters = activeMethodParameters(generationValueGetter, activeMethod, registerTo);
		if(activeMethodParameters.isEmpty()){
			watchPort(generationValueGetter, element, method, reachToActiveMethod, registerTo);
		}
		
		activeMethodParameters.forEach(parameter-> {
			List<String> collect = method.getParameters().stream().map(GenMethodParameter::getName).collect(Collectors.toList());
			if(!collect.contains(parameter.getName())){
				method.addParameter(parameter);
			}
		});
		
		if(prev == null){
			GenMethod query = new GenMethod();
			query.setName(originalMethodName);
			activeMethodParameters.forEach(parameter-> {
				GenMethodParameter genMethodParameter = new GenMethodParameter(parameter.getType(), parameter.getName());
				query.addParameter(genMethodParameter);
			});
			
			GenActiveField field = activeMethodField(methodName, registerToName); 
			
//				if(hasInterfaceMethodOfName(genClass, field.getName())){
//					//Required for interface-oriented approach, in which interfaces will have the same methods. So, we need to do that to avoid
//					//name collisions
//					field.setName(field.getName()+ "_Port");
//				}
			
			field.setRelatedMethod(method);
			
			if(conjugatedActiveMethod != null){
				String conjugatedActiveMethodName= generationValueGetter.getString(conjugatedActiveMethod, IModelingElementDefinitions.NAME);
				field.setConjugatedField(conjugatedActiveMethodName);
			}
			
			List<GenMethodParameter> parameters = method.getParameters();
//				if(!parameters.isEmpty() || !CPPTypesConstants.VOID.equals(returnType)){
//					field.addGeneric(new GenFieldGeneric(returnType));
//				}
			field.addGeneric(new GenFieldGeneric(returnType));
			for(GenMethodParameter parameter: parameters){
				GenFieldGeneric generic= new GenFieldGeneric(parameter.getType());
				field.addGeneric(generic);
			}
			field.setVisibility(genClass.getIsRemote()?Visibilities.PRIVATE: Visibilities.PUBLIC);
			genClass.addField(field);
			
			if(genClass.getIsRemote()){
				MemberInitializer memberInitializer = new MemberInitializer(originalMethodName);
				memberInitializer.setPriority(1);
				genClass.addMemberInitializer(memberInitializer);
				memberInitializer.addInitializer(new GenFieldInitializer(registerToName+ "::"+ methodName));
				memberInitializer.addInitializer(new GenFieldInitializer("\""+ originalMethodName+ "\""));
				memberInitializer.addInitializer(new GenFieldInitializer("&_messageRouter"));
				
				
				GenField remoteMethodField = new GenField();
				remoteMethodField.setVisibility("public");
				remoteMethodField.setIsComparable(false);
				remoteMethodField.addGeneric(new GenFieldGeneric(registerToName));
				
				remoteMethodField.addGeneric(new GenFieldGeneric(method.getReturnType()));
				for(GenMethodParameter _param: parameters){
					remoteMethodField.addGeneric(new GenFieldGeneric(_param.getType()));
				}
				
				remoteMethodField.setType("RemoteMethod");
				remoteMethodField.setName(originalMethodName);
				genClass.addField(remoteMethodField);
				method.addRelatedField(remoteMethodField);
				method.setPriority(-5);
				remoteMethodField.setPriority(5);
			}
			 
			addActiveMember(field, registerTo, generationValueGetter, methodName, null, methodInvoke);
			index++;
		}
		return index;
	}

	private static boolean hasInterfaceMethodOfName(GenClass genClass, String methodName) {
		List<GenClass> collect = genClass.allParents().stream().filter(entry->entry instanceof GenInterface).collect(Collectors.toList());
		collect.add(genClass);
		for(GenClass entry: collect){
			for(GenMethod method: entry.getMethods()){
				if(method.getName().equals(methodName)){
					return true;
				}
			}
		}
		
		return false;
	}

	private static void addConstraints(GenerationPolicyRegistry generationValueGetter, ActiveGenMethd method, List<?> constraintObjects) {
		GenClass genClass = method.getDefinitionClass();
		List<String> portNames = genClass.portNames();
		 
		GenConstraint genConstraint= new GenConstraint();
		genConstraint.setPriority(GenPriorities.HIGH);
		for(Object constraint: constraintObjects){
			List<?> names = generationValueGetter.getList(constraint, IModelingElementDefinitions.NAMES);
			String constraintExpressionValue = generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSION_VALUE);
			
			boolean found= false;
			for(Object _name: names){
				GenConstraintVariable constraintVariable = new GenConstraintVariable();
				String name = _name.toString();
				if(!portNames.contains(name) || (constraintExpressionValue != null && !constraintExpressionValue.isEmpty())){
					constraintVariable.setName(name); 
					constraintVariable.setPlural(generationValueGetter.getBoolean(generationValueGetter.rootElement, IModelingElementDefinitions.IS_PLURAL, name));
					genConstraint.addVariable(constraintVariable);
					found= true;
				}else{
					GenConstraintVariable listener = new GenConstraintVariable();
					listener.setName(name);
					genConstraint.addListener(listener);
				}
			}
			
			if(found){
				GenConstraintCondition aCondition = new GenConstraintCondition();
				aCondition.setString(generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS, Boolean.FALSE));
				genConstraint.addCondition(aCondition);
				method.addBody(genConstraint);
			}
		}
		
		//TODO: Should eliminate addBody or addConstraint and use a flag to show body instead
		method.addConstraint(genConstraint);
	}

	private static void activeMethodBodies(GenerationPolicyRegistry generationValueGetter, Object parent, GenMethod method,
			List<?> activeMethods, Object activeMethod, String methodName) {
		@SuppressWarnings("unchecked")
		Map<Object, Map<String, Object>> object = (Map<Object, Map<String, Object>>) generationValueGetter.getObject(activeMethod, 
				IStructureConstants.ACTIVE_METHOD_INLINE_BLOCKS);
		
		for(Object actionCode: object.keySet()){
			addActiveMethodBody(generationValueGetter, parent, method, activeMethod, methodName, object, actionCode);
		}
	}

	private static void addActiveMethodBody(GenerationPolicyRegistry generationValueGetter, Object parent,
			GenMethod method, Object activeMethod, String methodName, Map<Object, Map<String, Object>> object,
			Object actionCode) {
		Map<String, Object> map= object.get(actionCode);
		
		String methodInvoke = generationValueGetter.getString(actionCode, IStructureConstants.METHOD_INVOKE);
		String defaultValue = generationValueGetter.getString(actionCode, IStructureConstants.ACTIVE_METHOD_CODE_BLOCKS, map);
		if(methodInvoke == null){
			methodInvoke = registerAnonymous(generationValueGetter, method, activeMethod, actionCode, methodName);
			if(methodInvoke == null){
				method.addBody(new GenBody(defaultValue));
				return;
			}
		}
		
		String[] methodParameters = (String[]) generationValueGetter.getObject(actionCode, IModelingElementDefinitions.OPERATION_PARAMETERS);
		if(methodParameters.length>0 || map.get("PERIOD") == null){
			activeMethodBody(generationValueGetter, method, activeMethod, actionCode, map, methodInvoke);
		}else{
			asyncBodyMethod(activeMethod, method, parent, generationValueGetter, methodName, map, methodInvoke);
		}
	}
	
	public static boolean isConjugated(GenerationPolicyRegistry generationValueGetter, Object activeMethod){
		for(Object element: generationValueGetter.getList(generationValueGetter.rootElement, IModelingElementDefinitions.CLASSES)){
			List<?> forwardActiveMethods = generationValueGetter.getList(element, IStructureConstants.ACTIVE_METHODS);
			for(Object forwardActiveMethod: forwardActiveMethods){
				
				Object otherConjugated = generationValueGetter.getObject(forwardActiveMethod, IStructureConstants.CONJUGATED_ACTIVE_METHOD);
				if(otherConjugated != null && otherConjugated.equals(activeMethod)){
					return true;
				}
			}
		}
		
		return false;
	}

	private static List<GenMethodParameter> activeMethodParameters(GenerationPolicyRegistry generationValueGetter, Object activeMethod, Object registerTo){
		List<?> parameters = generationValueGetter.getList(activeMethod, IModelingElementDefinitions.OPERATION_PARAMETERS);
		List<GenMethodParameter> genParameters= new ArrayList<GenMethodParameter>();
		
		if(parameters.isEmpty() && registerTo != null){
			if(isConjugated(generationValueGetter, activeMethod)){
				Object conjugatedMethod = conjugatedMethod(generationValueGetter, activeMethod);
				Object parent= generationValueGetter.getObject(conjugatedMethod, IModelingElementDefinitions.PARENT_CLASS);
				
				for(Object element: generationValueGetter.getList(generationValueGetter.rootElement, IModelingElementDefinitions.CLASSES)){
					List<?> portBindings= generationValueGetter.getList(element, IStructureConstants.PORT_BINDINGS);
					if(portBindings!= null){
						for(Object binding: portBindings){
							Object fromPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_PORT);
							Object toPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_PORT);
							String toPartName= generationValueGetter.getString(toPort, IModelingElementDefinitions.NAME);
							String fromPartName= generationValueGetter.getString(fromPort, IModelingElementDefinitions.NAME);
							
							String toPartTypeName= generationValueGetter.getString(toPort, IModelingElementDefinitions.TYPE_NAME);
							String fromPartTypeName= generationValueGetter.getString(fromPort, IModelingElementDefinitions.TYPE_NAME);
							if(toPartTypeName!= null && toPartTypeName.equals(fromPartTypeName)){
								Object fromPortParent= generationValueGetter.getObject(fromPort, IStructureConstants.PORT_OWNING_CLASS);
								Object toPortParent= generationValueGetter.getObject(toPort, IStructureConstants.PORT_OWNING_CLASS);
								
								if(registerTo.equals(fromPortParent) || registerTo.equals(toPortParent)){
									//generationValueGetter.getObject(activeMethod, IStructureConstants.CONJUGATED_ACTIVE_METHOD)
									List<?> constraints = generationValueGetter.getList(conjugatedMethod, IModelingElementDefinitions.CONSTRAINTS);
									if(constraints.isEmpty()){
										constraints= generationValueGetter.getList(activeMethod, IModelingElementDefinitions.CONSTRAINTS);
									}
									
									
									for(Object constraint: constraints){
										String current= generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS,Boolean.TRUE);
										if(current!= null){
											current= current.trim();
											if(current.equals(toPartName)){
												addPortParameter(generationValueGetter, parent, toPartName, genParameters);
											}
											
											if(current.equals(fromPartName)){
												addPortParameter(generationValueGetter, parent, fromPartName, genParameters);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		for(Object parameter: parameters){
			String typeName = generationValueGetter.getString(parameter, IModelingElementDefinitions.TYPE_NAME);
			String name = generationValueGetter.getString(parameter, IModelingElementDefinitions.NAME);
			addParameter(genParameters, typeName, name);
		}
		
		return genParameters;
	}

	private static void addPortParameter(GenerationPolicyRegistry generationValueGetter, Object parent, String portName,
			List<GenMethodParameter> genParameters) {
		Object portByName = portByName(generationValueGetter, parent, portName);
		if(portByName != null){
			String normalizedType= generationValueGetter.getString(portByName, IModelingElementDefinitions.TYPE_NAME);
			addParameter(genParameters, normalizedType, portName);
		}
	}

	private static Object portByName(GenerationPolicyRegistry generationValueGetter, Object parent, String toPartName) {
		for(Object port: ports(generationValueGetter, parent)){
			String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
			if(portName.equals(toPartName)){
				return port;
			}
		}
		return toPartName;
	}

	private static void addParameter(List<GenMethodParameter> genParameters, String typeName, String name) {
		GenMethodParameter genMethodParameter = new GenMethodParameter(typeName, name);
		genMethodParameter.setNormalize(true);
		genParameters.add(genMethodParameter);
	}

	private static void activeMethodBody(GenerationPolicyRegistry generationValueGetter, GenMethod method,
			Object activeMethod,Object actionCode, Map<String, Object> map, String methodInvoke) {
		String _methodInvoke= methodInvoke;
		String returnType= generationValueGetter.getString(activeMethod, IModelingElementDefinitions.RETURN_TYPE);
		Object parent= generationValueGetter.getObject(activeMethod, IModelingElementDefinitions.PARENT_CLASS);
		
		String parentName = generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(parentName);
		
		boolean isAnonymous = isAnonymous(methodInvoke);
		String[] methodParameters;
		final List<String> types= new ArrayList<String>();
		if(isAnonymous){
			methodParameters = anonymousParameters(generationValueGetter, activeMethod);
		}else{
			methodParameters = methodParameters(generationValueGetter, actionCode, parent, types);
		}
		
		String activeMethodName= activeMethodInvokeName(generationValueGetter, activeMethod, methodInvoke);
		
		String type, body;
		List<?> constraints = (List<?>) map.get(IModelingElementDefinitions.CONSTRAINTS);
		if(constraints!= null && !constraints.isEmpty()){
			Map<String, Object> _map= null;
			
			if(!isAnonymous){
				int index= method.getBody().stream().filter(_body-> "logic".equals(_body.getType())).toArray().length+1;
				activeMethodName+= "_"+index;
				methodInvoke= "_"+ activeMethodName;
				List<GenField> collect = genClass.getFields().stream().filter(field-> field instanceof GenActiveField && _methodInvoke.equals(field.getName())).collect(Collectors.toList());
				if(!collect.isEmpty()){
					GenMethod proxy = new GenMethod();
					proxy.setName(methodInvoke);
					genClass.addMethod(proxy);
					proxy.setReturnType(CPPTypesConstants.VOID);
					proxy.setVisibility(Visibilities.PRIVATE);
					
					List<GenMethodParameter> parameters = genClass.methodByName("_"+_methodInvoke).getParameters();
					parameters.forEach(parameter-> proxy.addParameter(parameter));
					proxy.addBody(new GenBody(_methodInvoke+ "("+ parameters.stream().map(GenMethodParameter::getName).collect(Collectors.joining(", "))+ ");"));
				}
				
				_map= map;
			}
			
			String expression = constraintExpression(parent, generationValueGetter, constraints);	//TODO
			if(!expression.isEmpty()){
				GenMethod methodByName = genClass.methodByName("schedulerGuards_");
				methodByName.addBody(new GenBody(guardCondition(generationValueGetter, activeMethodName, expression)));
			}
			
			addActiveMember(null, parent, generationValueGetter, activeMethodName, map, methodInvoke);	//TODO parameters can reduce
			GenField genField = registerActiveMethod(parent, generationValueGetter, activeMethod, returnType, activeMethodName);
			
			genField.setRelatedMethod(method);
			body = activeMethodInvoke(generationValueGetter, _map, activeMethodName,methodParameters);
			type= isAnonymous? "anonymous": "logic";
		}else{
			if(!isAnonymous){
				int index= method.getBody().stream().filter(_body-> "active".equals(_body.getType())).toArray().length+1;
				activeMethodName+= "_"+(index);
			}
			
			GenField genField = activeMethodDeclaration(generationValueGetter, activeMethodName, types, returnType, parentName);
			addInitializer(generationValueGetter, parent, methodInvoke, genField);
			
			genClass.addField(genField);
			String activeMethodDeclaration = genField.declaration();
			genClass.removeField(genField);
			
			body= activeMethodDeclaration.trim()+ CommonConstants.NEW_LINE;
			body+= activeMethodName+ "("+ String.join(",", activeMethodParameters(generationValueGetter, map, methodParameters))+ ");";
			type= isAnonymous? "anonymous": "active";
		}
		
		GenBody genBody = new GenBody(body);
		genBody.setType(type);
		method.addBody(genBody);
	}

	private static String[] anonymousParameters(GenerationPolicyRegistry generationValueGetter, Object activeMethod) {
		String[] methodParameters;
		List<?> parameters = generationValueGetter.getList(activeMethod, IModelingElementDefinitions.OPERATION_PARAMETERS);
		methodParameters= parameters.stream().map(parameter-> generationValueGetter.getString(parameter, IModelingElementDefinitions.NAME)).toArray(String[]::new);
		return methodParameters;
	}

	private static String activeMethodInvokeName(GenerationPolicyRegistry generationValueGetter,
			Object activeMethod, String methodInvoke) {
		if(isAnonymous(methodInvoke)){
			return "active_"+ methodInvoke;
		}else{
			String methodName= generationValueGetter.getString(activeMethod, IModelingElementDefinitions.NAME);
			return "active_"+methodName+ "_"+ methodInvoke;
		}
	}

	private static boolean isAnonymous(String methodInvoke) {
		boolean isAnonymous= methodInvoke.contains("anonymous_part");
		return isAnonymous;
	}

	private static List<String> activeMethodParameters(GenerationPolicyRegistry generationValueGetter,
			Map<String, Object> map, String[] methodParameters) {
		List<String> timersFromMap = activeTimersFromMap(generationValueGetter, map);
		List<String> all= new ArrayList<String>();
		all.addAll(Arrays.asList(methodParameters));
		all.addAll(timersFromMap);
		return all;
	}

	private static void asyncBodyMethod(Object activeMethod, GenMethod method, Object parent, GenerationPolicyRegistry generationValueGetter,
			String methodName, Map<String, Object> map, String methodInvoke) {
		List<String> timersFromMap = timersFromMap(generationValueGetter, map);
		String defferedVersionName= null;
		boolean isAnonymous = isAnonymous(methodInvoke);
		
		if(isAnonymous){
			defferedVersionName= "listen_periodic_"+ methodInvoke;
		}else{
			int index= method.getBody().stream().filter(body-> "async".equals(body.getType())).toArray().length+1;
			defferedVersionName= "listen_periodic_"+methodName+ "_"+ methodInvoke+ "_"+index;
		}
		
		List<?> constraints = (List<?>) map.get(IModelingElementDefinitions.CONSTRAINTS);
		if(constraints!= null && !constraints.isEmpty()){
			String wrapMethodInvoke= methodInvoke+ "_logic";
			String expression = constraintExpression(parent, generationValueGetter, constraints);	//TODO
			String body= asyncGuardCondition(generationValueGetter, expression, methodInvoke+"();");	//TODO
			
			GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
			GenMethod asyncMethod = new GenMethod();
			genClass.addMethod(asyncMethod);
			asyncMethod.setReturnType(CPPTypesConstants.VOID);
			asyncMethod.setVisibility(Visibilities.PRIVATE);
			
			GenBody genBody = new GenBody(body);
			if(isAnonymous){
				genBody.setType("anonymous");
			}
			
			asyncMethod.addBody(genBody);
			asyncMethod.setName(wrapMethodInvoke);
			methodInvoke= wrapMethodInvoke;
			GenMethod active = genClass.methodByName("_"+methodName);
			if(!expression.isEmpty() && active!= null && active.hasBodyConstraints()){
				GenMethod methodByName = genClass.methodByName("schedulerGuards_");
				methodByName.addBody(new GenBody(guardCondition(generationValueGetter, methodName, expression)));
			}
		}
		
		registerAsyncCall(generationValueGetter, parent, defferedVersionName);
		asyncPeriodicCall(generationValueGetter, defferedVersionName, methodInvoke, timersFromMap, parent);
		
		GenBody genBody = new GenBody(asyncMethodInvoke(defferedVersionName));
		genBody.setType("async");
		method.addBody(genBody);
	}

	private static String asyncGuardCondition(GenerationPolicyRegistry generationValueGetter, String condition, String body){
		return condition== null || condition.isEmpty()?body:generationValueGetter.generate(Generator.IF_CONDITION, condition, body);
	}

	private static String asyncMethodInvoke(String defferedVersionName) {
		String _body= stopCall(defferedVersionName).trim()+ CommonConstants.NEW_LINE;
		_body+= startCall(defferedVersionName).trim();
		return _body;
	}

	private static String[] methodParameters(GenerationPolicyRegistry generationValueGetter, Object activeMethod, Object parent, final List<String> _types) {
		String methodInvoke = generationValueGetter.getString(activeMethod, IStructureConstants.METHOD_INVOKE);
		
		String[] methodParameters;
		methodParameters= (String[]) generationValueGetter.getObject(activeMethod, IModelingElementDefinitions.OPERATION_PARAMETERS);
		for(Object operation: generationValueGetter.getList(parent, IModelingElementDefinitions.OPERATIONS)){
			if(methodInvoke.equals(generationValueGetter.getString(operation, IModelingElementDefinitions.NAME))){
				List<?> list = generationValueGetter.getList(operation, IModelingElementDefinitions.OPERATION_PARAMETERS);
				//FIXME: does not work with polymorphism
				if(list.size()== methodParameters.length){
					list.forEach(method->{
						Object typeName = generationValueGetter.getObject(method, IModelingElementDefinitions.TYPE_NAME);
						_types.add(typeName.toString());
					});									
				}
				return methodParameters;
			}
		}
		
		return methodParameters;
	}
	
	private static String registerAnonymous(GenerationPolicyRegistry generationValueGetter, GenMethod method, Object activeMethod, Object actionCode, String methodName){
		String anonymousBody = generationValueGetter.getString(actionCode, IStructureConstants.ANONYMOUS_BODY);
		if(anonymousBody == null){
			return null;
		}
		
		int index= method.getBody().stream().filter(_body-> "anonymous".equals(_body.getType())).toArray().length+1;
		Object parent= generationValueGetter.getObject(activeMethod, IModelingElementDefinitions.PARENT_CLASS);
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		 
		String resolveBody = generationValueGetter.getString(actionCode, IStructureConstants.RESOLVE_BODY);
		String thenBody = generationValueGetter.getString(actionCode, IStructureConstants.THEN_BODY);	
		if(thenBody != null && !thenBody.isEmpty()){
			thenBody= CommonConstants.NEW_LINE+ thenBody;
		}
		String wrap = generationValueGetter.generate(Generator.COMPOSITE_CALL_THEN_RESOLVE, anonymousBody, thenBody, resolveBody);
		
		String operationName= methodName+"_anonymous_part"+ index;
		
		GenMethod anomymousMethod = new GenMethod();
		genClass.addMethod(anomymousMethod);
		
		activeMethodParameters(generationValueGetter, activeMethod, null).forEach(parameter-> anomymousMethod.addParameter(parameter));
		anomymousMethod.setReturnType(CPPTypesConstants.VOID);
		anomymousMethod.setVisibility(Visibilities.PRIVATE);
		anomymousMethod.addBody(new GenBody(wrap));
		anomymousMethod.setName(operationName);
		return operationName;
	}

	private static String activeMethodInvoke(GenerationPolicyRegistry generationValueGetter,
			Map<String, Object> map, String methodInvoke, String[] methodParameters) {
		List<String> allParameters= new ArrayList<String>();
		for(String p: methodParameters){
			allParameters.add(p);
		}
		
		if(map != null){
			List<String> timersFromMap = activeTimersFromMap(generationValueGetter, map);
			timersFromMap.forEach(timer->allParameters.add(timer));
		}
		
		return methodInvoke+"("+ String.join(",", allParameters)+ ");";
	}

	private static GenField registerActiveMethod(Object parent, GenerationPolicyRegistry generationValueGetter,
			Object activeMethod, String returnType, String methodName) {
		GenField field = activeMethodDeclaration(generationValueGetter, activeMethod, returnType, methodName);
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		genClass.addField(field);
		return field;
	}

	private static GenField activeMethodDeclaration(GenerationPolicyRegistry generationValueGetter, Object activeMethod, String returnType, String methodName) {
		List<?> parameters = generationValueGetter.getList(activeMethod, IModelingElementDefinitions.OPERATION_PARAMETERS);
		return activeMethodDeclaration(generationValueGetter, activeMethod, returnType, methodName, parameters);
	}

	private static GenField activeMethodDeclaration(GenerationPolicyRegistry generationValueGetter, Object activeMethod,
			String returnType, String methodName, List<?> parameters) {
		Object parent= generationValueGetter.getObject(activeMethod, IModelingElementDefinitions.PARENT_CLASS);
		
		String className= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		return activeMethodDeclaration(generationValueGetter, methodName, parameters, returnType, className);
	}

	private static GenField activeMethodDeclaration(GenerationPolicyRegistry generationValueGetter, String methodName,
			List<?> parameters, String returnType, String className) {
		List<String> publicParameters= new ArrayList<String>();
		publicParameters.add(returnType!= null && !returnType.isEmpty()? returnType: CPPTypesConstants.VOID);
		
		GenMethod methodByName = generationValueGetter.rootModel.classByName(className).methodByName("_"+ methodName);
		if(methodByName!= null){
			List<GenMethodParameter> proxy = methodByName.getParameters();
			for(GenMethodParameter param: proxy){
				publicParameters.add(param.getType());
			}
		}else{
			parameters.forEach(parameter->{
				if(parameter instanceof String){
					publicParameters.add((String) parameter);
				}else{
					publicParameters.add(generationValueGetter.getString(parameter, IModelingElementDefinitions.TYPE_NAME));
				}
			});
		}
		
		GenField field= activeMethodField(methodName, className);
		publicParameters.forEach(publicParameter->field.addGeneric(new GenFieldGeneric(publicParameter)));
		return field;
	}

	private static GenActiveField activeMethodField(String methodName, String className) {
		GenActiveField field= new GenActiveField();
		field.addGeneric(new GenFieldGeneric(className));
		field.setType("Active");
		field.setName(methodName);
		field.setIsComparable(false);
		
		//genClass.addField(genField); Some places only need to use the string content
		
		return field;
	}

	private static void addInitializer(GenerationPolicyRegistry generationValueGetter, Object parent,
			String methodInvoke, GenField field) {
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		String qualifiedName= genClass.fullQualifiedName();
		field.addInitializer(new GenFieldInitializer("this"));
		field.addInitializer(new GenFieldInitializer("&_internalScheduler"));
		field.addInitializer(new GenFieldInitializer("&"+qualifiedName+ "::" + methodInvoke));
	}
	
	private static void asyncPeriodicCall(GenerationPolicyRegistry generationValueGetter,
			String perioidicMethodName, String methodName, List<String> timers, Object owner) {
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(owner, IModelingElementDefinitions.NAME));
		
		String qualifiedName= genClass.fullQualifiedName();
		
		MemberInitializer memberInitializer = new MemberInitializer(perioidicMethodName);
		genClass.addMemberInitializer(memberInitializer);
		memberInitializer.addInitializer(new GenFieldInitializer("this"));
		memberInitializer.addInitializer(new GenFieldInitializer("&_internalScheduler"));
		memberInitializer.addInitializer(new GenFieldInitializer("&"+qualifiedName+ "::" + methodName));
		timers.forEach(timer->memberInitializer.addInitializer(new GenFieldInitializer(timer)));
	}
	
	public static String getContraintString(GenerationPolicyRegistry generationValueGetter, Object parent, Object element) {
		Map<String, Object> map = constraintMap(generationValueGetter, parent, element);
		return constraintString(generationValueGetter, element, map);
	}

	private static String constraintString(GenerationPolicyRegistry generationValueGetter, Object element,
			Map<String, Object> map) {
		String all= CommonConstants.BLANK;
		if(parameterless(generationValueGetter, element) && (map.containsKey("PERIOD"))){
			Object owner = generationValueGetter.getObject(element, IModelingElementDefinitions.PARENT_CLASS);
			String perioidicMethodName = perioidicMethodName(generationValueGetter, element);
			registerAsyncCall(generationValueGetter, owner, perioidicMethodName);
		}else{
			all = appendLatencyDelay(generationValueGetter, map, all);
		}
		
		//[TIMEOUT, PERIOD, LTENCY]

		return all;
	}

	private static String appendLatencyDelay(GenerationPolicyRegistry generationValueGetter, Map<String, Object> map,
			String all) {
		Object constraint = map.get("LTENCY");
		if(constraint != null){
			if(!all.isEmpty()){
				all+= CommonConstants.NEW_LINE;
			}
			
			String timer= timerValue(generationValueGetter, constraint);
			all+= "Thread::sleep("+timer+");";
		}
		return all;
	}

	private static void registerAsyncCall(GenerationPolicyRegistry generationValueGetter, Object owner, String perioidicMethodName) {
		String className= generationValueGetter.getString(owner, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(owner, IModelingElementDefinitions.NAME));
		GenField field= new GenField();
		field.setIsComparable(false);
		field.addGeneric(new GenFieldGeneric(className));
		genClass.addField(field);
		field.setVisibility(Visibilities.PRIVATE);
		field.setType("AsyncMethod");
		field.setName(perioidicMethodName);
	}

	private static boolean parameterless(GenerationPolicyRegistry generationValueGetter, Object element) {
		return generationValueGetter.getList(element, IModelingElementDefinitions.OPERATION_PARAMETERS).isEmpty();
	}

	private static Map<String, Object> constraintMap(GenerationPolicyRegistry generationValueGetter, Object parent,
			Object element) {
		List<?> constraints= generationValueGetter.getList(element, IStructureConstants.TIMED_CONSTRAINTS);
		Map<String, Object> map = constraintToMap(generationValueGetter, constraints);
		return map;
	}

	private static Map<String, Object> constraintToMap(GenerationPolicyRegistry generationValueGetter,
			List<?> constraints) {
		Map<String, Object> map= new WeakHashMap<String, Object>();
		for(Object constraint: constraints){
			map.put(generationValueGetter.getString(constraint, IModelingElementDefinitions.TYPE_NAME), constraint);
		}
		return map;
	}

	private static String perioidicMethodName(GenerationPolicyRegistry generationValueGetter, Object activeMethod) {
		return "listen_periodic_"+ generationValueGetter.getString(activeMethod, IModelingElementDefinitions.NAME);
	}

	private static List<?> ports(GenerationPolicyRegistry generationValueGetter, Object uClass) {
		return generationValueGetter.getList(uClass, IStructureConstants.PORTS);
	}
	
	private static List<String> portNames(GenerationPolicyRegistry generationValueGetter, Object uClass){
		List<?> ports = ports(generationValueGetter, uClass);
		return portNames(generationValueGetter, ports);
	}

	private static List<String> portNames(GenerationPolicyRegistry generationValueGetter, List<?> ports) {
		return Arrays.asList(ports.stream().map(
				port-> generationValueGetter.getString(port, IModelingElementDefinitions.NAME)).toArray(String[]::new));
	}


//	@LoopProcessorAnnotations(aspect= LoopAspectConstants.AFTER, loopProcessorAnnotations ={ 
//			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
//	}) 
//	public static void portEnumerationClass(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
//			@GenerationBaseElement Object uClass,
//			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
//			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
//		if(portList.isEmpty()){
//			return;
//		}
//		
//		String protocolName = getPortEnumName(generationValueGetter, uClass);
//		String stringValues = generationValueGetter.generationPointString(parent, IStructureConstants.PORT_ENUM_CASES_STRING);
//		
//		String enumValues = generationValueGetter.generationPointString(uClass, IStructureConstants.PORT_ENUM_VALUES);
//		
//		List<?> ports = ports(generationValueGetter, uClass);
//		
//		String first= CPPCommonConstants.NIL;
//		String second= ports.isEmpty()?CPPCommonConstants.NIL: generationValueGetter.getString(ports.get(ports.size()-1), IModelingElementDefinitions.NAME);
//		
//		String enumImplementation = generationValueGetter.generate(Generator.ENUM_IMPLEMENTATION, uClass,
//				protocolName+ CommonConstants.UNDERSCORE, 
//				enumValues, first, second,stringValues, StringUtil.firstCharacterToLowerCase(PORT),
//				GenerationArgumentDescriptor.arg(ICppDefinitions.OWING_NAMESPACE_OBJECT, uClass));
//		
//		generationValueGetter.generationPointString(uClass, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
//				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING),
//				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
//				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
//		
//		
//		Object protocol = generationValueGetter.getObject(ports.get(0), IStructureConstants.PORT_PROTOCOL);
//		generationValueGetter.addUniqueValue(Generator.ENUM_IMPLEMENTATION, enumImplementation, /*uClass */ protocol);
//	}
	
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}, aspect= LoopAspectConstants.PRE+1)
	public static void registerClasses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		String name = generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		String variableInstance = generationValueGetter.generator.variableInstance(name);
		String serializeObjectName= "object";
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		if(!genClass.getIsRemote()){
			return;
		}
		
		GenMethod serializeMethodByReference = new GenMethod();
		GenMethodParameter referenceParameter = new GenMethodParameter(name, variableInstance);
		referenceParameter.setIsReference(true);
		serializeMethodByReference.addParameter(referenceParameter);
		serializeMethodByReference.addBody(new GenBody("JSON "+ serializeObjectName+ ";"));
		
		GenMethod serializeMethodByPointer = new GenMethod();
		GenMethodParameter pointerParameter = new GenMethodParameter(name, variableInstance);
		pointerParameter.setIsPointer(true);
		serializeMethodByPointer.addParameter(pointerParameter);
		serializeMethodByPointer.addBody(new GenBody("JSON "+ serializeObjectName+ ";"));
		
		GenMethod deserializeMethodByReference = new GenMethod();
		List<String> deserializeMethodByReferenceBodies= new ArrayList<String>();
		GenMethod deserializeMethodByPointer = new GenMethod();
		List<String> deserializeMethodByPointerBodies= new ArrayList<String>();
		
		genClass.addMethod(serializeMethodByReference);
		genClass.addMethod(deserializeMethodByReference);
		genClass.addMethod(serializeMethodByPointer);
		genClass.addMethod(deserializeMethodByPointer);
		
		serializeMethodByReference.setExternalDefinition("JSON");
		deserializeMethodByReference.setExternalDefinition("JSON");
		serializeMethodByPointer.setExternalDefinition("JSON");
		deserializeMethodByPointer.setExternalDefinition("JSON");
		
		GenConstructorMethod genConstructorMethod = (GenConstructorMethod)genClass.methodByName(genClass.getName());
		List<GenMethodParameter> parameters = genConstructorMethod.asParameters();
		
		List<String> constructs= new ArrayList<String>();
		for(GenMethodParameter constructorParameter: parameters){
			String attName = constructorParameter.getRelatedField();
			//Ref12345: remove after fixing the constructor arguments
			if(!constructorParameter.getName().contains(StringUtil.firstCharacterToUpperCase(attName)+ "For")){
				String getterName = generationValueGetter.generator.getInstance(attName, genClass.getIsRemote());
				
				constructs.add("(*this)[\""+ attName+ "\"]");
				serializeMethodByReference.addBody(new GenBody("object[\""+ attName+"\"] = "+variableInstance+"."+getterName+"();"));
				serializeMethodByPointer.addBody(new GenBody("object[\""+ attName+"\"] = "+variableInstance+"->"+getterName+"();"));
			}
		}
		
		List<?> attributes = generationValueGetter.getList(parent, IModelingElementDefinitions.ATTRIBUTES);
		for(GenMethodParameter constructorParameter: parameters){
			String attName = constructorParameter.getRelatedField();
			genClass.fieldByName(attName);
			
			for(Object attribute: attributes){
				String _attName = generationValueGetter.getString(attribute, IModelingElementDefinitions.NAME);
				if(attName.equals(_attName) &&
					!generationValueGetter.getBoolean(attribute, IModelingElementDefinitions.IS_INTERNAL)){
					
					//Ref12345: remove after fixing the constructor arguments
					if(!constructorParameter.getName().contains(StringUtil.firstCharacterToUpperCase(attName)+ "For")){
//						serializeMethodByReference.addBody(new GenBody("object[\""+ attName+"\"] = "+variableInstance+"."+getterName+"();"));
//						serializeMethodByPointer.addBody(new GenBody("object[\""+ attName+"\"] = "+variableInstance+"->"+getterName+"();"));
					}
				}
			}
		}
		
		String constructString = constructs.stream().collect(Collectors.joining(", "));
//		if(!constructString.isEmpty()){
//			constructString= "("+ constructString+ ")";
//		}
		
		for(Object attribute: attributes){
			if(generationValueGetter.getBoolean(attribute, IModelingElementDefinitions.IS_LAZY)&&
					!generationValueGetter.getBoolean(attribute, IModelingElementDefinitions.IS_DERIVED)&&
					!generationValueGetter.getBoolean(attribute, IModelingElementDefinitions.IS_AUTO_UNIQUE)&&
					!generationValueGetter.getBoolean(attribute, IModelingElementDefinitions.IS_CONSTANT)&&
					!generationValueGetter.getBoolean(attribute, IModelingElementDefinitions.IS_INTERNAL)&&
					!generationValueGetter.getBoolean(attribute, IModelingElementDefinitions.IS_KEY_MEMBER)&&
					!generationValueGetter.getBoolean(attribute, IModelingElementDefinitions.IS_STATIC)){
				String attName = generationValueGetter.getString(attribute, IModelingElementDefinitions.NAME);
				String getterName = generationValueGetter.generator.getInstance(attName, genClass.getIsRemote());
				String setterName = generationValueGetter.generator.setInstance(attName, genClass.getIsRemote());
				
				deserializeMethodByReferenceBodies.add(variableInstance+ "."+ setterName+ "((*this)[\""+ attName+ "\"]);");
				serializeMethodByReference.addBody(new GenBody("object[\""+ attName+"\"] = "+variableInstance+"."+getterName+"();"));
				
				deserializeMethodByPointerBodies.add(variableInstance+ "->"+ setterName+ "((*this)[\""+ attName+ "\"]);");
				serializeMethodByPointer.addBody(new GenBody("object[\""+ attName+"\"] = "+variableInstance+"->"+getterName+"();"));
			}
		}
		
		serializeMethodByReference.addBody(new GenBody(genClass.getGenPackage().initObjectConnection(variableInstance, ".")));
		serializeMethodByReference.addBody(new GenBody("swap("+ serializeObjectName+ ");"));
		
		deserializeMethodByReference.addBody(new GenBody(generationValueGetter.generator.serializeInitAsReference(name, variableInstance, constructString, 
				deserializeMethodByReferenceBodies.stream().collect(Collectors.joining(CommonConstants.NEW_LINE)))));
		
		serializeMethodByPointer.addBody(new GenBody(genClass.getGenPackage().initObjectConnection(variableInstance, "->")));
		serializeMethodByPointer.addBody(new GenBody("swap("+ serializeObjectName+ ");"));
		deserializeMethodByPointer.addBody(new GenBody(generationValueGetter.generator.serializeInitAsPointer(name, variableInstance, constructString, 
				deserializeMethodByPointerBodies.stream().collect(Collectors.joining(CommonConstants.NEW_LINE)))));
		
		serializeMethodByReference.setName("JSON");
		deserializeMethodByReference.setName("operator "+ name);
		
		serializeMethodByPointer.setName("JSON");
		deserializeMethodByPointer.setName("operator "+ name+ "*");
		
		serializeMethodByReference.setDisableRemote(true);
		deserializeMethodByPointer.setDisableRemote(true);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE-2, loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	})
	public static void assignPorts(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationLoopElement Object modelPackage){
		
		List<?> portList= generationValueGetter.getList(parent, IStructureConstants.PORTS);
		if(portList== null || portList.isEmpty()){
			return;
		}
		
		String name= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		
		for(Object port: portList){
			String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
			String type= generationValueGetter.getString(port, IModelingElementDefinitions.TYPE_NAME);
			String portDirection= generationValueGetter.getString(port, IStructureConstants.PORT_DIRECTION);
			
			GenPort genPort = new GenPort();
			genPort.setName(portName);
			genPort.setType(type);
			genPort.setDirection(portDirection);
			genClass.addPort(genPort);
		}
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.PRE, loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	})
	public static void registerPorts(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationLoopElement Object modelPackage){
		boolean isComplexPort = generationValueGetter.getBoolean(parent, IStructureConstants.IS_COMPLEX_PORT);
		if(isComplexPort){
			return;
		}
		
		List<?> portList= generationValueGetter.getList(parent, IStructureConstants.PORTS);
		if(portList== null || portList.isEmpty()){
			return;
		}
		
		String name= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		
		registerPorts(generationValueGetter, parent, portList, modelPackage, null);
		
		List<ActiveGenMethd> genActiveMethods = genClass.activeMethods();
		for(ActiveGenMethd activeGenMethd: genActiveMethods){
			for(GenAssociation association: genClass.getAssociations()){
				List<?> relatedBindings = relatedBindings(generationValueGetter, association, modelPackage);
				if(!relatedBindings.isEmpty()){
					String inverseMethod = activeGenMethd.getInverseMethod();
					if(inverseMethod != null){
						List<ActiveGenMethd> otherActiveMethods = association.getSourceClass().getMethods().stream().filter(genMethod-> 
							genMethod instanceof ActiveGenMethd && ((ActiveGenMethd)genMethod).getBaseName().equals(inverseMethod))
								.map(ActiveGenMethd.class::cast).collect(Collectors.toList());
						if(!otherActiveMethods.isEmpty()){
							ActiveGenMethd otherActiveMethod = otherActiveMethods.get(0);
							
							String parameterString = parameterString(otherActiveMethod);
							association.setBinding(inverseMethod);
							association.setBindingParameters(parameterString);
							GenBody genBody = new GenBody(association.getBindingNotificationBody());
							genBody.setPriority(3);
							activeGenMethd.addBody(genBody);
						}
						bindToComplexPort(generationValueGetter, modelPackage, activeGenMethd, association, relatedBindings, false);
					}else{
						bindToComplexPort(generationValueGetter, modelPackage, activeGenMethd, association, relatedBindings, true);
					}
				}
			}
		}
	}

	private static void bindToComplexPort(GenerationPolicyRegistry generationValueGetter, Object modelPackage,
			ActiveGenMethd activeMethod, GenAssociation association, List<?> relatedBindings, boolean isIn) {
		for(Object binding: relatedBindings){
			Object fromPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_PORT);
			Object toPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_PORT);
			
			Object fromComplexPort = complexBindingPortClass(generationValueGetter, modelPackage, fromPort);
			Object toComplexPort = complexBindingPortClass(generationValueGetter, modelPackage, toPort);
			
			if(fromComplexPort!= null && fromComplexPort.equals(toComplexPort)){
				if(isIn){
					Object toPortParent= generationValueGetter.getObject(toPort, IStructureConstants.PORT_OWNING_CLASS);
					String toPortParentName= generationValueGetter.getString(toPortParent, IModelingElementDefinitions.NAME);
					GenClass toPortGenClass = generationValueGetter.rootModel.classByName(toPortParentName);
					bindToComplexPort(generationValueGetter, toPortGenClass, fromComplexPort, association, isIn);
				}else{
					Object fromPortParent= generationValueGetter.getObject(fromPort, IStructureConstants.PORT_OWNING_CLASS);
					String fromPortParentName= generationValueGetter.getString(fromPortParent, IModelingElementDefinitions.NAME);
					
					GenClass fromPortGenClass = generationValueGetter.rootModel.classByName(fromPortParentName);
					bindToComplexPort(generationValueGetter, fromPortGenClass, fromComplexPort, association, false);
					
					GenAssociationEnd source = association.getSource();
					
					Object toPortParent= generationValueGetter.getObject(toPort, IStructureConstants.PORT_OWNING_CLASS);
					String toPortParentName= generationValueGetter.getString(toPortParent, IModelingElementDefinitions.NAME);
					
					String inverseMethodString = activeMethod.getInverseMethod();
					if(inverseMethodString.isEmpty() || inverseMethodString== null){
						continue;
					}
					
					//GenClass toPortGenClass = generationValueGetter.rootModel.classByName(toPortParentName);
					//GenField invereMethodField = toPortGenClass.fieldByName(inverseMethodString);
					//ActiveGenMethd inverseMethod = (ActiveGenMethd) invereMethodField.getRelatedMethod();
					String variableInstance = generationValueGetter.generator.variableInstance(toPortParentName);
					
					GenMethod singleMethod = delegateMethod(activeMethod, inverseMethodString);
					String parameterString1= parameterString(singleMethod);
					GenMethodParameter aParameter = new GenMethodParameter(toPortParentName+"*", variableInstance);
					singleMethod.addParameter(aParameter);
					GenMethod prev = activeMethod.getGenClass().methodByIdentifier(singleMethod.identifier());
					if(prev != null){
						//TODO: ref12345: avoid redundant loop instead
						continue;
					}
					GenEndpointPropagationBody propagationBody = new GenEndpointPropagationBody();
					propagationBody.setParameterString(parameterString1);
					propagationBody.setName(variableInstance);
					propagationBody.setType(toPortParentName);
					propagationBody.setMethod(inverseMethodString);
					propagationBody.setRole(source.getRoles());
					
					singleMethod.addBody(new GenBody(propagationBody.propagationBody(false)));
					activeMethod.getGenClass().addMethod(singleMethod);
					singleMethod.implementation();
					String variableInstanceMany = generationValueGetter.generator.copyOfInstance(source.getRoles());
					GenMethod manyMethod = delegateMethod(activeMethod, inverseMethodString);
					String parameterString2= parameterString(manyMethod);
					GenMethodParameter manyParameter = new GenMethodParameter("vector<"+toPortParentName+"*>*", variableInstanceMany);	//Ref12345
					manyMethod.addParameter(manyParameter);
					propagationBody.setName(variableInstanceMany);
					propagationBody.setParameterString(parameterString2);
					manyMethod.addBody(new GenBody(propagationBody.propagationBody(true)));
					activeMethod.getGenClass().addMethod(manyMethod);
				}
			}
		}
	}

	private static GenMethod delegateMethod(ActiveGenMethd activeMethod, String baseName) {
		GenMethod genMethod = new GenMethod();
		genMethod.setName(baseName);
		genMethod.setVisibility(Visibilities.PUBLIC);
		genMethod.setReturnType(activeMethod.getReturnType());
		for(GenMethodParameter parameter: activeMethod.getParameters()){
			genMethod.addParameter(new GenMethodParameter(parameter.getType(), parameter.getName()));
		}
		return genMethod;
	}

	private static void bindToComplexPort(GenerationPolicyRegistry generationValueGetter, GenClass genClass,
			Object complexPort, GenAssociation association, boolean isIn) {
		List<?> _portList= generationValueGetter.getList(complexPort, IStructureConstants.PORTS);
		if(_portList!= null && !_portList.isEmpty()){
			for(Object port: _portList){
				boolean isInPort = generationValueGetter.getBoolean(port, IStructureConstants.IS_IN_PORT);
				boolean isOutPort = generationValueGetter.getBoolean(port, IStructureConstants.IS_OUT_PORT);
				String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
				
				if(isIn?isInPort: isOutPort){
					for(GenField field: genClass.getFields()){
						if(field instanceof GenActiveField && portName.equals(field.getName())){
							GenMethod relatedMethod = field.getRelatedMethod();
							association.setBinding(field.getName());
							association.setBindingParameters(parameterString(relatedMethod));
							UniqueGenBody uniqueGenBody = new UniqueGenBody(association.getBindingNotificationBody(), 
									association.getSource().getRoles());
							uniqueGenBody.setPriority(2);
							relatedMethod.addBody(uniqueGenBody);
						}
					}
				}
			}
		}
	}

	private static String parameterString(GenMethod method) {
		return method.getParameters().stream().map(GenMethodParameter::getName).collect(Collectors.joining(", "));
	}

	private static List<?> relatedBindings(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, GenAssociation association, Object modelPackage){
		List<Object> relatedBindings= new ArrayList<Object>();
		List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, association.getSource().getType());
		if(values.isEmpty()){
			return relatedBindings;
		}
		Object sourceClass = values.get(0);
		List<Object> values2 = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, association.getTarget().getType());
		if(values2.isEmpty()){
			return relatedBindings;
		}
		Object targetClass = values2.get(0);
		
		for(GenClass _genClass: generationValueGetter.rootModel.getClasses()){
			Object clazz = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, _genClass.getName()).get(0);
			List<?> portBindings= generationValueGetter.getList(clazz, IStructureConstants.PORT_BINDINGS);
			if(portBindings!= null){
				for(Object binding: portBindings){
					Object fromPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_PORT);
					Object toPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_PORT);
					
					Object fromPortParent= generationValueGetter.getObject(fromPort, IStructureConstants.PORT_OWNING_CLASS);
					Object toPortParent= generationValueGetter.getObject(toPort, IStructureConstants.PORT_OWNING_CLASS);
					
					if((fromPortParent.equals(sourceClass)&& toPortParent.equals(targetClass))||
							fromPortParent.equals(targetClass) && toPortParent.equals(sourceClass)){
						relatedBindings.add(binding);
					}
				}
			}
		}
		
		return relatedBindings;
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL+1)
	public static void filterCoplex(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		boolean isComplexPort = generationValueGetter.getBoolean(parent, IStructureConstants.IS_COMPLEX_PORT);
		if(isComplexPort){
			String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
			GenClass genClass = generationValueGetter.rootModel.classByName(parentName);
			genClass.setGeneratable(false);
		}
	}

	private static void registerPorts(GenerationPolicyRegistry generationValueGetter, Object parent, List<?> portList, 
			Object modelPackage, String rootType) {
		String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(parentName);
		setScheduler(generationValueGetter, parent);
		
		List<String> portNames= new ArrayList<String>();
		for(Object port: portList){ 
			String portType= generationValueGetter.getString(port, IModelingElementDefinitions.TYPE_NAME);
			String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
			String portDirection= generationValueGetter.getString(port, IStructureConstants.PORT_DIRECTION);
			
			GenClass classByName = generationValueGetter.rootModel.classByName(portType);
			List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, portType);
			if(!values.isEmpty()){
				Object complex= values.get(0); 
				List<?> _portList= generationValueGetter.getList(complex, IStructureConstants.PORTS);
				registerPorts(generationValueGetter, parent, _portList, modelPackage, portType);
				
				List<?> conjugatedActiveMethods = generationValueGetter.getList(complex, IStructureConstants.CONJUGATED_ACTIVE_METHODS);
				List<?> forwardActiveMethods = generationValueGetter.getList(complex, IStructureConstants.ACTIVE_METHODS);
				
//				for(GenAssociation genAssociation: classByName.getAssociations()){
//					genClass.addAssociation(genAssociation);
//				}
				
				boolean conjugated = isConjugated(generationValueGetter, modelPackage, port);
				boolean forward = isForward(generationValueGetter, modelPackage, port);
				if(conjugated){
					registerActiveMethods(generationValueGetter, complex, conjugatedActiveMethods, modelPackage, parent, forwardActiveMethods, conjugated);
				}
				
				if(forward || !conjugated){
					registerActiveMethods(generationValueGetter, complex, forwardActiveMethods, modelPackage, parent, null, conjugated);
				}
				
				if("BOTH".equals(portDirection)){
					if(classByName!= null){
						GenComplexPort genComplexPort = new GenComplexPort();
						genComplexPort.setGenClass(generationValueGetter.rootModel.classByName(parentName));
						genComplexPort.setType(portType);
						genComplexPort.setName(portName);
						classByName.addComplexPort(genComplexPort);
						classByName.setGeneratable(false);
					}
				}
			}else{
				registerPort(generationValueGetter, parent, portNames, port, rootType);
			}
		}
	}

	private static boolean isConjugated(GenerationPolicyRegistry generationValueGetter, Object modelPackage, Object port) {
		return checkPortHandling(generationValueGetter, modelPackage, port, true);
	}

	private static boolean isForward(GenerationPolicyRegistry generationValueGetter, Object modelPackage, Object port) {
		return checkPortHandling(generationValueGetter, modelPackage, port, false);
	}
	
	private static boolean checkPortHandling(GenerationPolicyRegistry generationValueGetter, Object modelPackage,
			Object port, boolean inverse) {
		boolean is = generationValueGetter.getBoolean(port, IStructureConstants.IS_CONJUGATED);
		if(inverse&&is){
			return true; 
		}
		
		String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
		
		for(GenClass genClass: generationValueGetter.rootModel.getClasses()){
			Object clazz = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, genClass.getName()).get(0);
			List<?> portBindings= generationValueGetter.getList(clazz, IStructureConstants.PORT_BINDINGS);
			if(portBindings!= null){
				for(Object binding: portBindings){
					Object fromPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_PORT);
					Object toPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_PORT);
					if(inverse?port.equals(toPort): port.equals(fromPort)){
						return true;
					}
				}
			}
			
//			List<?> activeMethods = generationValueGetter.getList(clazz, IStructureConstants.ACTIVE_METHODS);
//			for(Object activeMethod: activeMethods){
//				Object methodToLook= inverse? generationValueGetter.getObject(activeMethod, IStructureConstants.CONJUGATED_ACTIVE_METHOD): activeMethod;
//				
//				List<?> constraints = generationValueGetter.getList(methodToLook, IModelingElementDefinitions.CONSTRAINTS);
//				for(Object constraint: constraints){
//					String current= generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS,Boolean.TRUE);
//					if(current!= null){
//						current= current.trim();
//						if(current.equals(portName)){
//							return true;
//						}
//					}
//				}
//			}
		}
		return false;
	}

	private static void registerPort(GenerationPolicyRegistry generationValueGetter, Object parent, List<String> portNames, Object port, String rootType) {
		String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(parentName);
		
		String originalPortName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
		String portEventName= originalPortName;
		Integer priority= null;
		if(genClass.getIsRemote()){
			portEventName= "internal_"+ portEventName;
			priority= -1;
		}
		
		GenField old = genClass.fieldByName(portEventName);
		if(old != null){
			return;
		}
		
		portNames.add(originalPortName);
		
		
		
		String normalizedType= generationValueGetter.getString(port, IModelingElementDefinitions.TYPE_NAME);
		normalizedType= generationValueGetter.rootModel.getNormalizedType(normalizedType);
		String activeMethodName = "_"+ originalPortName;
		
		addActiveMember(null, parent, generationValueGetter, portEventName, null, activeMethodName);
		GenField field = activeMethodDeclaration(generationValueGetter, portEventName, Arrays.asList(new String[]{normalizedType}), CPPTypesConstants.VOID, parentName);
		field.setVisibility(genClass.getIsRemote()?Visibilities.PRIVATE:Visibilities.PUBLIC);
		if(priority != null){
			field.setPriority(priority.intValue());
		}
		genClass.addField(field);
		
		GenMethod portEvent = new GenMethod();
		genClass.addMethod(portEvent);
		genClass.addMethod(portEvent);
		portEvent.addParameter(new GenMethodParameter(normalizedType, "data"));
		portEvent.setReturnType(CPPTypesConstants.VOID);
		portEvent.setVisibility(Visibilities.PRIVATE);
		portEvent.setName(activeMethodName);
		field.setRelatedMethod(portEvent);
		
		if(genClass.getIsRemote()){
			MemberInitializer memberInitializer = new MemberInitializer(originalPortName);
			memberInitializer.setPriority(1);
			genClass.addMemberInitializer(memberInitializer);
			memberInitializer.addInitializer(new GenFieldInitializer(parentName+ "::"+ portEventName));
			memberInitializer.addInitializer(new GenFieldInitializer("\""+ originalPortName+ "\""));
			memberInitializer.addInitializer(new GenFieldInitializer("&_messageRouter"));
			
			
			GenField remoteMethodField = new GenField();
			remoteMethodField.setIsComparable(false);
			remoteMethodField.setVisibility("public");
			remoteMethodField.addGeneric(new GenFieldGeneric(parentName));
			remoteMethodField.addGeneric(new GenFieldGeneric(CPPTypesConstants.VOID));
			remoteMethodField.addGeneric(new GenFieldGeneric(normalizedType));
			
			remoteMethodField.setType("RemoteMethod");
			remoteMethodField.setName(originalPortName);
			genClass.addField(remoteMethodField);
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}, aspect= LoopAspectConstants.AFTER)
	public static void registerConnections(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		List<?> portBindings= generationValueGetter.getList(parent, IStructureConstants.PORT_BINDINGS);
		if(portBindings== null || portBindings.isEmpty()){
			return;
		}
		
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		
		GenMethod portInitConnectionsMethod = portInitConnectionsMethod(generationValueGetter, parent);
		
		for(Object binding: portBindings){
			Object fromPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_PORT);
			Object toPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_PORT);
			
			Object fromSubComponent= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_SUBCOMPONENT);
			Object toSubComponent= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_SUBCOMPONENT);
			
			Object fromComplexPort = complexBindingPortClass(generationValueGetter, modelPackage, fromPort);
			Object toComplexPort = complexBindingPortClass(generationValueGetter, modelPackage, toPort);
			if(fromComplexPort!= null && toComplexPort!= null){
				if(fromComplexPort.equals(toComplexPort)){
					List<?> portList= generationValueGetter.getList(fromComplexPort, IStructureConstants.PORTS);
					if(portList!= null && !portList.isEmpty()){
						for(Object port: portList){
							addInitConnectorBody(genClass, generationValueGetter, portInitConnectionsMethod, port, port,
									fromSubComponent, toSubComponent, false);
						}
						
						List<?> activeMethods = generationValueGetter.getList(fromComplexPort, IStructureConstants.ACTIVE_METHODS);
						for(Object activeMethod: activeMethods){
							Object conjugatedActiveMethod= generationValueGetter.getObject(activeMethod, IStructureConstants.CONJUGATED_ACTIVE_METHOD);
							if(conjugatedActiveMethod != null){
//								addInitConnectorBody(genClass, generationValueGetter, portInitConnectionsMethod, activeMethod, conjugatedActiveMethod,
//										fromSubComponent, toSubComponent, false);
								addInitConnectorBody(genClass, generationValueGetter, portInitConnectionsMethod, conjugatedActiveMethod , activeMethod,
										toSubComponent, fromSubComponent, true);
//								addInitConnectorBody(genClass, generationValueGetter, portInitConnectionsMethod, conjugatedActiveMethod , activeMethod,
//										toSubComponent, fromSubComponent, true);
							}
						}
					}
				}
			}else{
				addInitConnectorBody(genClass, generationValueGetter, portInitConnectionsMethod, fromPort, toPort,
						fromSubComponent, toSubComponent, false);
			}
		}
	}

	private static void addInitConnectorBody(GenClass genClass, GenerationPolicyRegistry generationValueGetter,
			GenMethod portInitConnectionsMethod, Object fromPort, Object toPort, Object fromSubComponent,
			Object toSubComponent, boolean inverse) {
		if(fromSubComponent== null || !fromSubComponent.getClass().isInstance(toSubComponent)){
			return;
		}
		String source = generationValueGetter.getString(fromPort, IModelingElementDefinitions.NAME);
		String target = generationValueGetter.getString(toPort, IModelingElementDefinitions.NAME);
		
		String sourceParent= null;
		String targetParent= null;
		
		//String sourceType = generationValueGetter.getString(fromPort, IModelingElementDefinitions.TYPE_NAME);
		if(fromSubComponent!= null){
			String fromSubComponentName = generationValueGetter.getString(fromSubComponent, IModelingElementDefinitions.NAME);
			GenClass _genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(fromSubComponent, IModelingElementDefinitions.TYPE_NAME));
			boolean asComplex= false;
			if(genClass!= null && toSubComponent!= null){
				String toSubComponentName = generationValueGetter.getString(toSubComponent, IModelingElementDefinitions.NAME);
				GenField fieldByName = genClass.fieldByName(source);
				if(fieldByName instanceof GenComplexPort){
					GenClass complexType = generationValueGetter.rootModel.classByName(fieldByName.getType());
					for(GenField field: complexType.getFields()){
						if(field instanceof GenActiveField){
							GenActiveField activeField= (GenActiveField) field;
							String from = activeField.getName();
							String to = activeField.getConjugatedField();
							if(to != null){
								//boolean isReference= !_genClass.getIsRemote();	//isReference(generationValueGetter, sourceType)
								//String _from= fromSubComponentName+ "->"+from;
								//String _to= toSubComponentName+ "->"+to;
								//portInitConnectionsMethod.addBody(new GenBody(_from+ "+= "+(isReference?"&":"")+ _to+";"));
								portInitConnectionsMethod.addBody(new GenConnectEntry(null, from, fromSubComponentName, to, toSubComponentName));
								asComplex= true;
							}
						}
					}
				}
			}
			
			if(asComplex){
				return;
			}
			sourceParent= fromSubComponentName;
			//source= fromSubComponentName + "->" + source;
		}
		
		if(toSubComponent!= null){
			targetParent= generationValueGetter.getString(toSubComponent, IModelingElementDefinitions.NAME);
		}
		
		//boolean isReference= !genClass.getIsRemote();	//isReference(generationValueGetter, sourceType)
		GenConnectEntry aBody = new GenConnectEntry(null, target, targetParent, source, sourceParent);
		aBody.setInverse(inverse);
		portInitConnectionsMethod.addBody(aBody);
		//portInitConnectionsMethod.addBody(new GenBody(source+ "+= "+(isReference?"&":"")+ target+";"));
	}

//	private static boolean isReference(GenerationPolicyRegistry generationValueGetter, String sourceType) {
//		return false;
////		boolean isReference= generationValueGetter.rootModel.isString(sourceType)? false : generationValueGetter.rootModel.isPrimitive(sourceType);
////		return isReference;
//	}

	private static Object complexBindingPortClass(GenerationPolicyRegistry generationValueGetter, Object modelPackage,
			Object port) {
		String portType= generationValueGetter.getString(port, IModelingElementDefinitions.TYPE_NAME);
		List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, portType);
		if(!values.isEmpty()){
			Object complexPort = values.get(0);
			if(generationValueGetter.getBoolean(complexPort, IStructureConstants.IS_COMPLEX_PORT)){
				return complexPort;
			}
			
			return complexPort;
		}
		return null;
	}

	private static GenMethod portInitConnectionsMethod(GenerationPolicyRegistry generationValueGetter, Object parent) {
		String className= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(className);
		GenMethod portInitConnectionsMethod = genClass.methodByName(IStructureConstants.PORT_INIT_CONNECTIONS_METHODNAME);
		if(portInitConnectionsMethod != null){
			return portInitConnectionsMethod;
		}
		
		portInitConnectionsMethod = new GenMethod();
		genClass.addMethod(portInitConnectionsMethod);
		portInitConnectionsMethod.setReturnType(CPPTypesConstants.VOID);
		portInitConnectionsMethod.setVisibility(Visibilities.PRIVATE);
		portInitConnectionsMethod.setName(IStructureConstants.PORT_INIT_CONNECTIONS_METHODNAME);
		return portInitConnectionsMethod;
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}, aspect= LoopAspectConstants.POST+1)
	public static void redefineOperations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		String name = generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		List<GenMethod> removes= new ArrayList<GenMethod>();
		for(ActiveGenMethd activeMethod: genClass.activeMethods()){
			List<GenMethodParameter> activeMethodPrameters = activeMethod.getParameters();
			for(GenMethod method: genClass.getMethods()){
				if(!method.equals(activeMethod) && method.getName().equals(activeMethod.getBaseName())){
					List<GenMethodParameter> parameters = method.getParameters();
					if(match(activeMethodPrameters, parameters)){
						for(GenBody genBody: method.getBody()){
							GenBody clone = new GenBody(genBody.getBody());
							clone.setPriority(1);
							activeMethod.addBody(clone);
						}
						removes.add(method);
					}
				}
			}
		}
		
		for(GenMethod method: removes){
			GenClass clazz = method.getGenClass();
			if(clazz != null){
				clazz.removeMethod(method);
			}
		}
	}

	private static boolean match(List<GenMethodParameter> activeMethodPrameters, List<GenMethodParameter> parameters) {
		if(parameters.size()!= activeMethodPrameters.size()){
			return false;
		}
		
		for(int index=0; index<parameters.size(); index++){
			if(!parameters.get(index).getType().equals(activeMethodPrameters.get(index).getType())){
				return false;
			}
		}
		
		return true;
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void setRouter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String className= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(className);
		if(!genClass.getIsRemote()){
			return;
		}
		
		GenField routerField = new GenField();
		routerField.setIsComparable(false);
		routerField.setType("TCPMessageRouter");
		routerField.setName("_messageRouter");
		routerField.setPriority(-10);
		routerField.setVisibility(Visibilities.PRIVATE);
		genClass.addField(routerField);
		
		GenMethod method = new GenMethod();
		method.setName("getMessageRouter");
		method.setVisibility(Visibilities.PUBLIC);
		method.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		method.addBody(new GenBody("return this->_messageRouter;"));
		method.setReturnType("TCPMessageRouter");
		method.setDisableRemote(true);
		method.setPriority(4);
		genClass.addMethod(method);
	}
	
	@GenerationPoint(generationPoint = IStructureConstants.PORT_ENUM_VALUES)
	public static String getEnumValues(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
					@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		String values= CommonConstants.BLANK;
		
		int incrementer=1000;
		
		values= values+ generationValueGetter.generate(Generator.ENUM_VALUE, CPPCommonConstants.NIL, Integer.valueOf(0));
		int size = portList.size();
		if(size>0){
			values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
		}
		
		for(int index=0; index<size; index++){
			Object next = portList.get(index);
			values= values+ generationValueGetter.generate(Generator.ENUM_VALUE, 
					generationValueGetter.getString(next, IModelingElementDefinitions.NAME), Integer.valueOf(index+incrementer));
			
			if(index<size-1){
				values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
			}
		}
		return values;
	}
	
	
	
	@GenerationPoint(generationPoint = IStructureConstants.PORT_EVENT_ENUM_VALUES)
	public static String getEventEnumValues(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
					@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		String values= CommonConstants.BLANK;
		
		List<SimpleEntry<String, String>> list = getPortEventList(generationValueGetter, portList);
		
		for(SimpleEntry<String, String> entry: list){
			if(!values.isEmpty()){
				values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
			}
			values= values+ generationValueGetter.generate(Generator.ENUM_VALUE, entry.getKey(), Integer.valueOf(entry.getValue()));
		}
		
		return values;
	}

	private static List<SimpleEntry<String, String>> getPortEventList(GenerationPolicyRegistry generationValueGetter, List<?> portList) {
		int incrementer=1;
		int size = portList.size();
		
		List<SimpleEntry<String, String>> list= new ArrayList<SimpleEntry<String, String>>();
		
		list.add(new SimpleEntry<String, String>(CPPCommonConstants.NIL,String.valueOf(0)));
		
		for(int index=0; index<size; index++){
			Object port = portList.get(index);
			
			boolean isInPort = generationValueGetter.getBoolean(port, IStructureConstants.IS_IN_PORT);
			boolean isOutPort = generationValueGetter.getBoolean(port, IStructureConstants.IS_OUT_PORT);
			String name = generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
			
			if(isInPort){
				list.add(new SimpleEntry<String, String>(IStructureConstants.IN+ CommonConstants.UNDERSCORE+ name,String.valueOf(index+incrementer)));
			}
			
			if(isOutPort){
				list.add(new SimpleEntry<String, String>(IStructureConstants.OUT+ CommonConstants.UNDERSCORE+ name,String.valueOf(index+incrementer)));
			}
		}
		return list;
	}
	
	public static String getEventCaseString(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			List<SimpleEntry<String, String>> list){
		
		String values= CommonConstants.BLANK;
		values= values+ generationValueGetter.generate(Generator.ENUM_CASE_STRING, list.get(0).getKey(), list.get(0).getKey());
		
		int size = list.size();
		for(int index=1; index<size; index++){
			if(index<size){
				values= values+ CommonConstants.NEW_LINE;
			}
			
			SimpleEntry<String, String> entry = list.get(index);
			
			String key = entry.getKey();
			int indexOf = key.indexOf(CommonConstants.UNDERSCORE);
			String direction= key.substring(0, indexOf);
			String name= key.substring(indexOf+1);
			
			String description= generationValueGetter.generate(Generator.PORT_EVENT_ENUM_DESCRIPTION, direction, name);
			values= values+ generationValueGetter.generate(Generator.ENUM_CASE_STRING, key, description);
		}
		
		return values;
	}
	
	@GenerationPoint(generationPoint = IStructureConstants.PORT_ENUM_CASES_STRING)
	public static String getCasesString(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		String values= CommonConstants.BLANK;
		
		Iterator<?> iterator = portList.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			String value= generationValueGetter.getString(next, IModelingElementDefinitions.NAME);
			values= values+ generationValueGetter.generate(Generator.ENUM_CASE_STRING, value, (String)null);
			if(iterator.hasNext()){
				values= values+ CommonConstants.NEW_LINE;
			}
		}
		
		return values;
	}
	
	@GenerationPoint(generationPoint = IStructureConstants.PORT_EVENT_IMPLEMENTATIONS)
	public static String getPortEventImplementations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		return GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				Generator.PORT_EVENT_ENTRY_INVOCATION, 1, 0, element);
	}
	
	@GenerationPoint(generationPoint = IStructureConstants.PORT_EVENT_DECLARATIONS)
	public static String getPortEventDeclarations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		return GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				IStructureConstants.PORT_EVENT_DECLARATIONS, 1, 0, element);
	}
	
	@GenerationPoint(generationPoint = IStructureConstants.PORT_EVENT_IMPLEMENTATIONS_ATTRIBUTES)
	public static String getPortEventImplementationAttributes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		String implementationAndIndentDetails = GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				IStructureConstants.PORT_EVENT_IMPLEMENTATIONS_ATTRIBUTES, 0, 0, element);
		return implementationAndIndentDetails.isEmpty()? implementationAndIndentDetails: CommonConstants.NEW_LINE+ implementationAndIndentDetails;
	}
	
	@GenerationPoint(generationPoint = IStructureConstants.PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASES)
	public static String getPortProtocolImplementationEventCases(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				IStructureConstants.PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASES, 1, 0, element);
	}
	
//	@GenerationPoint(generationPoint = IStructureConstants.PORT_PROTOCOL_RECEIVE_METHOD_CONTENTS, priority= IGenerationPointPriorityConstants.HIGHEST)
//	public static String portProtocolReceiveMethodConstraint(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
//			@GenerationBaseElement Object element){
//		String constraints= generationValueGetter.generationPointString(element, IModelingElementDefinitions.CONSTRAINT_BODY);
//		String string = constraints.isEmpty()?CommonConstants.BLANK: StringUtil.indent(constraints, 0);
//		return string;
//	}
	
	@GenerationPoint(generationPoint = IStructureConstants.PORT_PROTOCOL_RECEIVE_METHOD_CONTENTS)
	public static String portProtocolReceiveMethodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IStructureConstants.ACTIVE_METHODS) List<Object> activeMethods,
			@GenerationLoopElement Object model,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationBaseElement Object port){
		 
		
		List<?> portList = ports(generationValueGetter, parent);
		String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
		String portNameData= portName/*+ CommonConstants.UNDERSCORE+IStructureConstants.DATA*/;
		
		String portType= generationValueGetter.getString(port, IModelingElementDefinitions.TYPE_NAME);
		
		String all= CommonConstants.BLANK;
		for(Object activeMethod: activeMethods){
			List<?> list = generationValueGetter.getList(activeMethod, IStructureConstants.ACTIVE_METHOD_CODE_BLOCKS);
			
			if(list== null){
				continue;
			}
			
			List<?> activePorts = generationValueGetter.getList(activeMethod, IModelingElementDefinitions.ACTIVE_METHOD_PORTS);
			
			if(!activePorts.contains(port)){
				continue;
			}
			
			List<String> strings= new ArrayList<String>();
			for(Object item: list){
				if(item.toString().trim().isEmpty()){
					continue;
				}
				strings.add(generationValueGetter.getString(item, IModelingElementDefinitions.CODE, activeMethod));
			}
			all= GenerationUtil.listToGeneratedString(0, 0, strings);
			
			Set<String> paramStrings= new HashSet<String>();
			
			for(Object activePort: activePorts){
				String normalizedActivePortType= generationValueGetter.getString(activePort, IModelingElementDefinitions.TYPE_NAME);
				normalizedActivePortType= generationValueGetter.rootModel.getNormalizedType(normalizedActivePortType);
				
				String activePortName= generationValueGetter.getString(activePort, IModelingElementDefinitions.NAME);
				String parmString = generationValueGetter.generate(Generator.PARAMETER_ASSIGN_STATEMENET, normalizedActivePortType, activePortName);
				paramStrings.add(parmString);
			}
		}
		
		if(all.isEmpty()){
			List<?> list = generationValueGetter.getList(parent, IStructureConstants.PORT_BINDINGS);
			if(list!= null){
				List<String> visitedPorts= new ArrayList<String>();
				for(Object binding: list){
					Object fromPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_PORT);
					Object toPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_PORT);
					
					if(!portList.contains(fromPort)|| !portList.contains(toPort)){
						continue;
					}
					
					String toPartName= generationValueGetter.getString(toPort, IModelingElementDefinitions.NAME);
					String fromPartName= generationValueGetter.getString(fromPort, IModelingElementDefinitions.NAME);
					
					String toPartTypeName= generationValueGetter.getString(toPort, IModelingElementDefinitions.TYPE_NAME);
					String fromPartTypeName= generationValueGetter.getString(fromPort, IModelingElementDefinitions.TYPE_NAME);
					
					if(!port.equals(toPort)&& port.equals(fromPort)){
						if(visitedPorts.contains(toPartName)){
							continue;
						}
						
						visitedPorts.add(toPartName);
						
						if(!all.isEmpty()){
							all= all+ CommonConstants.NEW_LINE;
						}
						
						//FIXME FIXME
						all= all+ toPartName+ "("+ portNameData+ ");";
					}
					
					if(!port.equals(fromPort)&& portType.equals(fromPartTypeName)){
						if(visitedPorts.contains(fromPartName)){
							continue;
						}
						
						visitedPorts.add(fromPartName);
						
						if(!all.isEmpty()){
							all= all+ CommonConstants.NEW_LINE;
						}
						//FIXME FIXME
						all= all+ fromPartName+ "("+ portNameData+ ");";
					}else{
						if(!port.equals(toPort)&& portType.equals(toPartTypeName)){
							if(visitedPorts.contains(toPartName)){
								continue;
							}
							
							visitedPorts.add(toPartName);
							
							if(!all.isEmpty()){
								all= all+ CommonConstants.NEW_LINE;
							}
							
							//FIXME FIXME
							all= all+ toPartName+ "("+ portNameData+ ");";
						}
					}
				}
			}
			
		}
		
		if(activeMethods.isEmpty()){
			return all.isEmpty()?CommonConstants.BLANK: StringUtil.indent(all, 0);
		}
		
		Set<String> calls= new HashSet<String>();
		for(Object activeMethod: activeMethods){
			List<?> activePorts = generationValueGetter.getList(activeMethod, IModelingElementDefinitions.ACTIVE_METHOD_PORTS);
			Set<String> paramStrings= new HashSet<String>();
			Set<String> paramTypes= new HashSet<String>();
			for(Object activePort: activePorts){
				String normalizedActivePortType= generationValueGetter.getString(activePort, IModelingElementDefinitions.TYPE_NAME);
				normalizedActivePortType= generationValueGetter.rootModel.getNormalizedType(normalizedActivePortType);
				
				String activePortName= generationValueGetter.getString(activePort, IModelingElementDefinitions.NAME);
				String parmString = generationValueGetter.generate(Generator.PARAMETER_ASSIGN_STATEMENET, normalizedActivePortType, activePortName);
				paramStrings.add(parmString);
				paramTypes.add(generationValueGetter.getString(activePort, IModelingElementDefinitions.TYPE_NAME));
			}
			
			if(paramStrings.size()<2){
				if(paramTypes.contains(portType)){
					String activeMethodName= generationValueGetter.getString(activeMethod, IModelingElementDefinitions.NAME);
					calls.add(generationValueGetter.generate(Generator.METHOD_INVOCATION, activeMethodName, portNameData, Boolean.TRUE));
				}
			}else{
				//TODO: active object implementation
			}
		}
		
		String listToGeneratedString = GenerationUtil.listToGeneratedString(0, 0, new ArrayList<Object>(calls));
		
		return listToGeneratedString;
	}
	
}