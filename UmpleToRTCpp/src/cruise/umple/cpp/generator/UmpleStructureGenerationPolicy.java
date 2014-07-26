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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import cruise.umple.compiler.ActiveDirectionHandler;
import cruise.umple.compiler.ActiveDirectionHandlerBody;
import cruise.umple.compiler.ActiveMethod;
import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.BasicConstraint;
import cruise.umple.compiler.CodeBlock;
import cruise.umple.compiler.Comment;
import cruise.umple.compiler.ConstraintVariable;
import cruise.umple.compiler.Monitor;
import cruise.umple.compiler.Port;
import cruise.umple.compiler.PortBinding;
import cruise.umple.compiler.PortConstraint;
import cruise.umple.compiler.Protocol;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationValueAnnotation;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.cpp.utils.CommonTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.IStructureConstants;
import cruise.umple.modeling.handlers.VisibilityConstants;

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
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.NAME)
	public static String getName(@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR/*, IModelingElementDefinitions.INTERFACES_PROCESSOR*/}) UmpleClass parent){
		if(element instanceof Port){
			return ((Port)element).getName();
		}
		return null;
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
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_OWING_CLASS)
	public static UmpleClass portOwingClass(@GenerationBaseElement PortBinding port){
		return port.getUmpleClass();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_PROTOCOL)
	public static Protocol getProtocol(@GenerationBaseElement Port port){
		return port.getProtocol();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_BINDINGS)
	public static List<PortBinding> getProtocol(@GenerationBaseElement UmpleClass uClass){
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
	public static Attribute getFromSubcomponnent(@GenerationBaseElement PortBinding binding){
		return binding.getFromSubcomponent();
	}
	
	@GenerationValueAnnotation(fieldName= IStructureConstants.PORT_BINDING_TO_SUBCOMPONENT)
	public static Attribute getToSubcomponnent(@GenerationBaseElement PortBinding binding){
		return binding.getToSubcomponent();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS)
	public static List<BasicConstraint> getPortConstraints(@GenerationBaseElement Port port,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR/*, IModelingElementDefinitions.INTERFACES_PROCESSOR*/}) UmpleClass parent){
		return processconstraints(parent, port.getProtocol().getWatchList(), port.getName());
	}

	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS, priority= IGenerationPointPriorityConstants.HIGHEST)
	public static List<BasicConstraint> getActiveMethodConstraints(@GenerationBaseElement ActiveMethod activeMethod,
			@GenerationArgument(id= IModelingConstants.ROOT) Object root){
		return processconstraints(null, activeMethod.getWatchList(), null);
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
			for(BasicConstraint contraint: constraints){
				ConstraintVariable[] expressions = contraint.getExpressions();
				ConstraintVariable constraintVariable= null;
				if(expressions.length>1){
					for(ConstraintVariable expr: expressions){
						if("NAME".equals(expr.getType())){ //$NON-NLS-1$
							constraintVariable= expr;
							break;
						}
					}
				}else{
					constraintVariable = expressions[0];
				}
				
				if(constraintVariable== null){
					continue;
				}
				
				if(constraintVariable.getFoundAttribute()== null){
					String value = constraintVariable.getValue();
					Port port = portMap.get(value);
					if(port!= null){
						ports.add(port);
					}
				}
			}
		}
		
		return ports;
	}
	
	private static List<BasicConstraint> processconstraints(UmpleClass parent, List<Monitor> monitors, String type) {
		List<String> portStrings = new ArrayList<String>();
		
		Map<String, Port> portMap= new HashMap<String, Port>();
		for(Port portObject: parent.getPorts()){
			portStrings.add(portObject.getName());
			portMap.put(portObject.getName(), portObject);
		}
		
		List<BasicConstraint> basicContraints= new ArrayList<BasicConstraint>();
		List<String> values= new ArrayList<String>();
		for(Monitor monitor: monitors){
			List<BasicConstraint> constraints = monitor.getConstraints();
			for(BasicConstraint contraint: constraints){
				ConstraintVariable[] expressions = contraint.getExpressions();
				if(expressions.length<2){
					continue;
				}
				for(ConstraintVariable expr: expressions){
					if(!"NAME".equals(expr.getType())){ //$NON-NLS-1$
						continue;
					}
					
					String value = expr.getValue();
					if(value.equals(type)&& !values.contains(value)){
						Port port = portMap.get(value);
						//FIXME FIXME FIXME
//						String signalType = port.getSignalType();
//						if(!signalType.equals(CommonTypesConstants.BOOLEAN)&& !signalType.equals("bool")){ //$NON-NLS-1$
//							continue;
//						}
						basicContraints.add(contraint);
						values.add(value);
						break;
					}
					
				}
//				if(expressions.length==1){
//					ConstraintVariable constraintVariable = expressions[0];
//					if(constraintVariable.getFoundAttribute()== null){
//						String value = constraintVariable.getValue();
//						if(portStrings.contains(value)){
//							//Avoid the main port definition
//							continue;
//						}
//					}
//				}
//				
//				basicContraints.add(contraint);
			}
		}
		
		return basicContraints;
	}
	
	//TODO: still better work to do to catch multipe variables in active methods
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
	public static List<Object> getActiveMthodCodeBody(@GenerationBaseElement ActiveMethod activeMethod){
		
		List<Object> visited= new ArrayList<Object>();
		List<ActiveDirectionHandler> handlers = activeMethod.getMethodBody();
		for(ActiveDirectionHandler handler: handlers){
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
		}
		
		return visited;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.NAME)
	public static String getName(@GenerationBaseElement ActiveMethod activeMethod){
		return activeMethod.getName();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ELEMENT_VISIBILITY)
	public static String getElementVisibility(@GenerationBaseElement ActiveMethod activeMethod){
		String modifier = activeMethod.getModifier();
		if(modifier.contains(VisibilityConstants.PUBLIC)){
			return VisibilityConstants.PUBLIC;
		}else if(modifier.contains(VisibilityConstants.PRIVATE)){
			return VisibilityConstants.PRIVATE;
		}else if(modifier.contains(VisibilityConstants.PROTECTED)){
			return VisibilityConstants.PROTECTED;
		}
		return VisibilityConstants.PUBLIC;
	}
	
}