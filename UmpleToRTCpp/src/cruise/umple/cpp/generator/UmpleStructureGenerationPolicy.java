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
import java.util.List;

import cruise.umple.compiler.ActiveDirectionHandler;
import cruise.umple.compiler.ActiveDirectionHandlerBody;
import cruise.umple.compiler.ActiveMethod;
import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.BasicConstraint;
import cruise.umple.compiler.CodeBlock;
import cruise.umple.compiler.Comment;
import cruise.umple.compiler.ConstraintVariable;
import cruise.umple.compiler.Method;
import cruise.umple.compiler.Monitor;
import cruise.umple.compiler.Port;
import cruise.umple.compiler.PortBinding;
import cruise.umple.compiler.PortConstraint;
import cruise.umple.compiler.Protocol;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleElement;
import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationValueAnnotation;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.IStructureConstants;
import cruise.umple.modeling.handlers.VisibilityConstants;

public class UmpleStructureGenerationPolicy{
	
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
		
		List<String> portStrings = new ArrayList<String>();
		for(Port portObject: parent.getPorts()){
			portStrings.add(portObject.getName());
		}
		
		List<BasicConstraint> basicContraints= new ArrayList<BasicConstraint>();
		Protocol protocol = port.getProtocol();
		for(Monitor monitor: protocol.getWatchList()){
			List<BasicConstraint> constraints = monitor.getConstraints();
			for(BasicConstraint contraint: constraints){
				ConstraintVariable[] expressions = contraint.getExpressions();
				if(expressions.length==1){
					ConstraintVariable constraintVariable = expressions[0];
					if(constraintVariable.getFoundAttribute()== null){
						String value = constraintVariable.getValue();
						if(portStrings.contains(value)){
							//Avoid the main port definition
							continue;
						}
					}
				}
				
				basicContraints.add(contraint);
			}
		}
		return basicContraints;
	}
	
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