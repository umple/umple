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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import cruise.umple.compiler.ActiveDirectionHandler;
import cruise.umple.compiler.ActiveDirectionHandlerBody;
import cruise.umple.compiler.ActiveMethod;
import cruise.umple.compiler.AnonymousFunction;
import cruise.umple.compiler.BasicConstraint;
import cruise.umple.compiler.CodeBlock;
import cruise.umple.compiler.Comment;
import cruise.umple.compiler.ConstraintAttribute;
import cruise.umple.compiler.ConstraintOperator;
import cruise.umple.compiler.ConstraintPort;
import cruise.umple.compiler.ConstraintTree;
import cruise.umple.compiler.ConstraintUnassignedName;
import cruise.umple.compiler.ConstraintVariable;
import cruise.umple.compiler.DeferredCall;
import cruise.umple.compiler.DeferredFunction;
import cruise.umple.compiler.MessageConstraint;
import cruise.umple.compiler.Monitor;
import cruise.umple.compiler.Port;
import cruise.umple.compiler.PortBinding;
import cruise.umple.compiler.PortConstraint;
import cruise.umple.compiler.Protocol;
import cruise.umple.compiler.TimerConstraint;
import cruise.umple.compiler.Trigger;
import cruise.umple.compiler.Trigger.TimeType;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleVariable;
import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationValueAnnotation;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.cpp.gen.Visibilities;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.IStructureConstants;

public class UmpleStructureGenerationPolicy{
	
	//FIXME: temp till active method implementation
	@SuppressWarnings("nls")
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CODE, priority= IGenerationPointPriorityConstants.HIGHEST)
	public static String getCodeBody(@GenerationBaseElement CodeBlock codeblock,
			@GenerationArgument ActiveMethod active){
		if(active== null){
			return null;
		}
		
		String trim = codeblock.getCode().trim();
		if(trim.startsWith("/")){
			String[] split = trim.split("\n");
			String normalized= "";
			for(String s: split){
				if(!normalized.isEmpty()){
					normalized= normalized+ CommonConstants.NEW_LINE;
				}else{
					normalized= "/";
				}
				normalized= normalized+ "//"+ s;
			}
			return normalized;
		}
		
		return null;
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORTS)
	public static List<Port> getPosrts(@GenerationBaseElement UmpleClass element){
		return element.getPorts();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.TYPE_NAME)
	public static String getType(@GenerationBaseElement Port port){
		return port.getSignalType();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_DIRECTION)
	public static String getDirection(@GenerationBaseElement Port port){
		return port.getDirectionFullName();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.IS_IN_PORT)
	public static boolean isInPort(@GenerationBaseElement Port port){
		String directionFullName = port.getDirectionFullName();
		return directionFullName.equals(IStructureConstants.IN)|| directionFullName.equals(IStructureConstants.BOTH);
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.IS_OUT_PORT)
	public static boolean isOutPort(@GenerationBaseElement Port port){
		String directionFullName = port.getDirectionFullName();
		return directionFullName.equals(IStructureConstants.OUT)|| directionFullName.equals(IStructureConstants.BOTH);
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.IS_CONJUGATED)
	public static boolean isConjugated(@GenerationBaseElement Port port){
		return port.getConjugated();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_OWNING_CLASS)
	public static UmpleClass portOwingClass(@GenerationBaseElement PortBinding port){
		return port.getUmpleClass();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_OWNING_CLASS)
	public static UmpleClass portOwingClass(@GenerationBaseElement Port port){
		return port.getUmpleClass();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.NAME)
	public static String getName(@GenerationBaseElement Port port){
		return port.getName();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_PROTOCOL)
	public static Protocol getProtocol(@GenerationBaseElement Port port){
		return port.getProtocol();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_BINDINGS)
	public static List<PortBinding> getPortBinding(@GenerationBaseElement UmpleClass uClass){
		return uClass.getPortBindings();
	}

	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_BINDING_FROM_PORT)
	public static Port getFromPort(@GenerationBaseElement PortBinding binding){
		return binding.getFromPort();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_BINDING_TO_PORT)
	public static Port getToPort(@GenerationBaseElement PortBinding binding){
		return binding.getToPort();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_BINDING_FROM_SUBCOMPONENT)
	public static UmpleVariable getFromSubcomponnent(@GenerationBaseElement PortBinding binding){
		return binding.getFromSubcomponent();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_BINDING_TO_SUBCOMPONENT)
	public static UmpleVariable getToSubcomponnent(@GenerationBaseElement PortBinding binding){
		return binding.getToSubcomponent();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS)
	public static List<BasicConstraint> getActiveMethodConstraints(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement ActiveMethod activeMethod){
		return processconstraints(activeMethod.getUmpleClass(), activeMethod.getWatchList(), activeMethod.getName(),generationValueGetter);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS)
	public static List<BasicConstraint> getPortConstraints(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Port port,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR/*, IModelingElementDefinitions.INTERFACES_PROCESSOR*/}) UmpleClass parent){
		return processconstraints(parent, port.getProtocol().getWatchList(), port.getName(),generationValueGetter);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS)
	public static List<BasicConstraint> getActiveMethodConstraints(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement ActiveMethod activeMethod,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR}) UmpleClass parent){
		List<BasicConstraint> constraints= new ArrayList<BasicConstraint>();
		for(Monitor monitor: activeMethod.getWatchList()){
			constraints.addAll(monitor.getConstraints());
		}
		
		return constraints;
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.TIMED_CONSTRAINTS)
	public static List<TimerConstraint> getTimedConstraints(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement ActiveMethod activeMethod,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR/*, IModelingElementDefinitions.INTERFACES_PROCESSOR*/}) UmpleClass parent){
		List<TimerConstraint> constraints= new ArrayList<TimerConstraint>();
		for(Monitor monitor: activeMethod.getWatchList()){
			List<TimerConstraint> timerConstraints = monitor.getTimerConstraints();
			constraints.addAll(timerConstraints);
		}
		
		return constraints;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.TYPE_NAME)
	public static String getType(@GenerationBaseElement TimerConstraint timerConstraint){
		return timerConstraint.getTimeConstraintType().name();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.PARENT_CLASS)
	public static UmpleClass parent(@GenerationBaseElement ActiveMethod activeMethod){
		return activeMethod.getUmpleClass();
	}
		
	@GenerationValueAnnotation(fieldName= IStructureConstants.TIMER)
	public static String getTimer(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement TimerConstraint timerConstraint,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR/*, IModelingElementDefinitions.INTERFACES_PROCESSOR*/}) UmpleClass parent){
		return timerConstraint.getTimer();
	}
	
	

	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS, priority= IGenerationPointPriorityConstants.HIGHEST)
	public static List<BasicConstraint> getActiveMethodConstraints(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement ActiveMethod activeMethod,
			@GenerationArgument(id= IModelingConstants.ROOT) Object root){
		return processconstraints(activeMethod.getUmpleClass(), activeMethod.getWatchList(), generationValueGetter);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ACTIVE_METHOD_PORTS)
	public static List<Port> getActiveMethodPorts(@GenerationBaseElement ActiveMethod activeMethod,
			@GenerationArgument(id= IModelingConstants.ROOT) UmpleClass parent){
		
		Map<String, Port> portMap= new HashMap<String, Port>();
		for(Port portObject: parent.getPorts()){
			portMap.put(portObject.getName(), portObject);
		}
		
		List<Port> ports= new ArrayList<Port>();
		
		for(Monitor monitor: activeMethod.getWatchList()){
			List<BasicConstraint> constraints = monitor.getConstraints();
			for(BasicConstraint constraint: constraints){
				generatePortsFromConstraints(constraint,monitor,ports,portMap);
			}
		}
		
		return ports;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ATTRIBUTES_FROM_CONSTRAINTS)
	public static List<Object> constraintAttributes(@GenerationBaseElement BasicConstraint element){
		return Arrays.asList(element.getNames().toArray());
	}

	private static void generatePortsFromConstraints(ConstraintVariable constraint, Monitor monitor, List<Port> ports, Map<String, Port> portMap){
		if (constraint == null)
			return;
		
		if (constraint instanceof ConstraintTree) {
			generatePortsFromConstraints(((ConstraintTree) constraint).getRoot(), monitor, ports,portMap);
		} else if (constraint instanceof ConstraintOperator) {
			generatePortsFromConstraints(((ConstraintOperator) constraint).getLeft(), monitor,ports, portMap);
			generatePortsFromConstraints(((ConstraintOperator) constraint).getRight(), monitor,ports, portMap);
		} else if (constraint instanceof ConstraintAttribute) {
			String value = ((ConstraintAttribute) constraint).getAttribute().getValue();
			Port port = portMap.get(value);
			if (port != null) {
				ports.add(port);
			}
		} else if (constraint instanceof ConstraintUnassignedName) {
			String value = ((ConstraintUnassignedName) constraint).getValue();
			Port port = portMap.get(value);
			if (port != null) {
				ports.add(port);
			}
		}else if (constraint instanceof ConstraintPort) {
			String value = ((ConstraintPort) constraint).getName();
			Port port = portMap.get(value);
			if (port != null) {
				ports.add(port);
			}
		}
	}
	
	private static List<BasicConstraint> processconstraints(UmpleClass parent, List<Monitor> monitors, String type, GenerationPolicyRegistry generationValueGetter) {
		List<String> portStrings = new ArrayList<String>();
		
		Map<String, Port> portMap= new HashMap<String, Port>();
		for(Port portObject: parent.getPorts()){
			portStrings.add(portObject.getName());
			portMap.put(portObject.getName(), portObject);
		}
		
		List<BasicConstraint> basicContraints= new ArrayList<BasicConstraint>();
		for(Monitor monitor: monitors){
			List<BasicConstraint> constraints = monitor.getConstraints();
			for(BasicConstraint constraint: constraints){
				List<?> expressions= generationValueGetter.getList(constraint, IModelingElementDefinitions.CONSTRAINT_LIST);
				
				int count=0;
				for(Object expr: expressions){
					if(!portStrings.contains(expr)){
						count++;
					}
				}
						
				TreeSet<String> names = constraint.getNames();
				//Check for size > 1 in order to ignore the conditions where we listen to a specific port; i.e. [pin1]
				if(type!= null && names.contains(type)&& count>0){
					basicContraints.add(constraint);
				}
				
				//TODO
				//String signalType = port.getSignalType();
				//if(!signalType.equals(CommonTypesConstants.BOOLEAN)&& !signalType.equals("bool")){ //$NON-NLS-1$
				//
				//}
			}
		}
		return basicContraints;
	}
	
	private static List<BasicConstraint> processconstraints(UmpleClass parent, List<Monitor> monitors, GenerationPolicyRegistry generationValueGetter) {
		List<BasicConstraint> basicContraints= new ArrayList<BasicConstraint>();
		for(Monitor monitor: monitors){
			List<BasicConstraint> constraints = monitor.getConstraints();
			for(BasicConstraint constraint: constraints){
				basicContraints.add(constraint);
			}
		}
		return basicContraints;
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.ACTIVE_METHODS)
	public static List<ActiveMethod> activeMethods(@GenerationBaseElement UmpleClass clazz){
		return clazz.getActiveMethods();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.CONJUGATED_ACTIVE_METHODS)
	public static List<ActiveMethod> conjugatedActiveMethods(@GenerationBaseElement UmpleClass clazz){
		return clazz.getActiveMethods().stream().map(ActiveMethod::getInverseMethodBody).collect(Collectors.toList());
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.CONJUGATED_ACTIVE_METHOD)
	public static ActiveMethod conjugatedActiveMethod(@GenerationBaseElement ActiveMethod activeMethod){
		return activeMethod.getInverseMethodBody();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OPERATION_PARAMETERS)
	public static List<?> getOperationParametersString(@GenerationBaseElement ActiveMethod method){
		return method.getMethodParameters();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.RETURN_TYPE)
	public static String getReturnType(@GenerationBaseElement ActiveMethod element){
		return element.getType();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.METHOD_INVOKE)
	public static String methodInvoke(@GenerationBaseElement DeferredCall element){
		List<DeferredFunction> list = element.getList();
		if(list != null && !list.isEmpty()){
			return list.get(0).getMethodInvoke();
		}
		return "";
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OPERATION_PARAMETERS)
	public static String[] operationParameters(@GenerationBaseElement DeferredCall element){
		List<DeferredFunction> list = element.getList();
		if(list != null && !list.isEmpty()){
			return list.get(0).getParameters();
		}
		return new String[]{};
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.ANONYMOUS_BODY)
	public static String anonymousBody(@GenerationBaseElement DeferredCall element){
		List<DeferredFunction> list = element.getList();
		if(list != null && !list.isEmpty()){
			return list.get(0).getAnonymousFunction().getCodeblock().getCode();
		}
		return null;
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.RESOLVE_BODY)
	public static String resolveBody(@GenerationBaseElement DeferredCall element){
		DeferredFunction resolve = element.getResolve();
		if(resolve == null){
			return null;
		}
		
		return getCode(resolve);
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.THEN_BODY)
	public static String thenBody(@GenerationBaseElement DeferredCall element){
		DeferredFunction resolve = element.getThen();
		if(resolve == null){
			return null;
		}
		
		return getCode(resolve);
	}

	private static String getCode(DeferredFunction function) {
		AnonymousFunction anonymousFunction = function.getAnonymousFunction();
		if(anonymousFunction == null){
			return null;
		}
		
		CodeBlock codeblock = anonymousFunction.getCodeblock();
		if(codeblock == null){
			return null;
		}
		
		String code = codeblock.getCode();
		if(code == null){
			return null;
		}
		
		String trim = code.trim();
		if(trim.isEmpty()){
			return null;
		}
		
		return trim;
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.ACTIVE_METHOD_INLINE_BLOCKS)
	public static Map<Object, Map<String, Object>> activeMethodInlineBlocks(@GenerationBaseElement ActiveMethod element){
		return blocks(element);
	}
	
	private static Map<Object, Map<String, Object>> blocks(ActiveMethod element) {
		Map<Object, Map<String, Object>> prepared= new LinkedHashMap<Object, Map<String,Object>>();
		Map<String, Object> lastMap= new LinkedHashMap<String, Object>();

		ActiveDirectionHandler activeDirectionHandler= element.getMethodBody();
		for(ActiveDirectionHandlerBody activeDirectionHandlerBody: activeDirectionHandler.getActiveDirectionHandlerBodies()){
			Trigger trigger = activeDirectionHandlerBody.getTrigger();
			if(trigger!= null){
				DeferredCall deferredCall = trigger.getDeferredCall();
				if(deferredCall!= null){
					fillMap(lastMap, trigger);
					prepared.put(deferredCall, lastMap);
					lastMap= new HashMap<String, Object>();
				}else{
					fillMap(lastMap, trigger);
				}
				
				
			}else{
				CodeBlock codeblock = activeDirectionHandlerBody.getCodeblock();
				if(codeblock!= null && !codeblock.getCode().isEmpty()){
					prepared.put(codeblock, lastMap);
					lastMap= new HashMap<String, Object>();
				}
			}
		}

		return prepared;
	}

	private static void fillMap(Map<String, Object> lastMap, Trigger trigger) {
		boolean empty= true;
		TimeType timeType = trigger.getTimeType();
		if(timeType!= null){
			String name = timeType.name();
			if(!"NONE".equals(name)){
				lastMap.put(name, trigger.getTimerPSec());
				empty= false;
			}
		}
		
		List<TimerConstraint> timerConstraints = trigger.getTimerConstraints();
		if(timerConstraints!= null && !timerConstraints.isEmpty()){
			for(TimerConstraint timerConstraint: timerConstraints){
				String timeConstraintType = timerConstraint.getTimeConstraintType().name();
				if(!"NONE".equals(timeConstraintType)){
					lastMap.put(timeConstraintType, timerConstraint.getTimer());
					empty= false;
				}
			}
		}
		
		MessageConstraint messageConstraint = trigger.getMessageConstraint();
		if(messageConstraint != null){
			lastMap.put("messageConstraint", messageConstraint);
			empty= false;
		}
		
		List<BasicConstraint> constraints = trigger.getConstraints();
		if(constraints != null && !constraints.isEmpty()){
			lastMap.put("constraints", constraints);
			empty= false;
		}
		
		if(empty){
			lastMap.put("async", true);
		}
	}

	//TODO: still better work to do to catch multiple variables in active methods
	@GenerationValueAnnotation(fieldName= IStructureConstants.ACTIVE_METHODS)
	public static List<Object> activeMethods(@GenerationBaseElement Port port,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) UmpleClass clazz){
		
		List<Object> activeMethods= new ArrayList<Object>();
		List<Port> ports = clazz.getPorts();
		for(Port currentPort: ports){
			Protocol protocol = currentPort.getProtocol();
			List<Monitor> watchList = protocol.getWatchList();
			for(Monitor monitor: watchList){
				ActiveMethod activeMethod = monitor.getActiveMethod();
				
				List<Monitor> activeWatchList = activeMethod.getWatchList();
				for(Monitor activeMonitor: activeWatchList){
					List<PortConstraint> portConstraints = activeMonitor.getPortConstraints();
					for(PortConstraint portConstraint: portConstraints){
						Port constraintPort = portConstraint.getPort();
						if(constraintPort== null){
							continue;
						}
						
						if(constraintPort.equals(port)){
							activeMethods.add(activeMethod);
						}
					}
				}
			}
		}
		
		return activeMethods;
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.ACTIVE_METHOD_CODE_BLOCKS)
	public static List<Object> getActiveMthodCodeBody(@GenerationBaseElement ActiveMethod activeMethod, Map<String, Object> options){
		List<Object> visited= new ArrayList<Object>();
		ActiveDirectionHandler handler = activeMethod.getMethodBody();
		List<ActiveDirectionHandlerBody> activeDirectionHandlerBodies = handler.getActiveDirectionHandlerBodies();
		for(ActiveDirectionHandlerBody activeDirectionHandlerBody: activeDirectionHandlerBodies){
			Comment comment = activeDirectionHandlerBody.getComment();
			if(comment!= null&& !visited.contains(comment)){
				visited.add(comment);
			}
			
			CodeBlock codeblock = activeDirectionHandlerBody.getCodeblock();
			if(codeblock!= null&& !visited.contains(codeblock)){
				visited.add(codeblock);
			}
		}
		
		return visited;
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.IS_COMPLEX_PORT)
	public static boolean isComplex(@GenerationBaseElement UmpleClass clazz){
		return clazz.isPortClass();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.IS_COMPLEX_PORT)
	public static boolean isComplex(@GenerationBaseElement Port port){
		return port.getUmpleClass().isPortClass();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.ACTIVE_METHOD_CODE_BLOCKS)
	public static String getActiveMthodCodeBody(@GenerationBaseElement CodeBlock codeblock, Map<String, Object> options){
		return codeblock.getCode();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.NAME)
	public static String getName(@GenerationBaseElement ActiveMethod activeMethod){
		return activeMethod.getName();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ELEMENT_VISIBILITY)
	public static String getElementVisibility(@GenerationBaseElement ActiveMethod activeMethod){
		String modifier = activeMethod.getModifier();
		if(modifier.contains(Visibilities.PUBLIC)){
			return Visibilities.PUBLIC;
		}else if(modifier.contains(Visibilities.PRIVATE)){
			return Visibilities.PRIVATE;
		}else if(modifier.contains(Visibilities.PROTECTED)){
			return Visibilities.PROTECTED;
		}
		return Visibilities.PUBLIC;
	}
	
}
