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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationLoopAnnotation;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationPolicyRegistryPriorities;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.core.ContentsDescriptor;
import cruise.umple.cpp.core.IGenerationCommonConstants;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.IModelingPriorityHandler;
import cruise.umple.modeling.handlers.IStructureConstants;
import cruise.umple.modeling.handlers.VisibilityConstants;

public class StructurePointsHandler{
	
	private static final String EVENT = "Event"; //$NON-NLS-1$
	private static final String PORT = "Port"; //$NON-NLS-1$
	private static final String QUEUE_USE = "queue"; //$NON-NLS-1$

	@LoopProcessorAnnotations(aspect= LoopAspectConstants.INITIAL, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IStructureConstants.PORTS_PROCESSOR})
	})
	public static void createExternalProtocolClasses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object port,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		Object protocol = generationValueGetter.getObject(port, IStructureConstants.PORT_PROTOCOL);
		generationValueGetter.addRelatedObject(protocol, port);
		generationValueGetter.addRelatedObject(port, parent);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.INITIAL, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	})
	public static void portMessages(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage,
			@GenerationBaseElement Object uClass){
		HashMap<String, Object> values = new HashMap<String, Object>();
		generationValueGetter.addRelatedObject(values, uClass);
		generationValueGetter.addUniqueValue(ICppStructureDefinitions.PROTOCOL_MESSAGE_TRACKER, values, uClass);
		
		String className= generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME);
		generationValueGetter.addUniqueValue(IModelingConstants.TYPES_TRACKER, values, modelPackage,
				className+ CommonConstants.UNDERSCORE+ IStructureConstants.MESSAGE);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IStructureConstants.PORTS_PROCESSOR})
	})
	public static void addStructureDiagramAPIs(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage){
		generationValueGetter.addUniqueValue(ICppDefinitions.TEMPLATES_DEFINITIONS, generationValueGetter.use(ICppDefinitions.THREAD_IMPLEMENTATION), modelPackage);
		generationValueGetter.addUniqueValue(ICppDefinitions.TEMPLATES_DEFINITIONS, generationValueGetter.use(ICppStructureDefinitions.PUBLISH_SUBSCRIBE_API), modelPackage);
		
		for(String include: new String[]{QUEUE_USE, ISTLConstants.MAP}){
			generationValueGetter.generationPointString(modelPackage, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, include), 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	@GenerationLoopAnnotation(id = IStructureConstants.PORTS_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getNavigableAssociationVariables(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IStructureConstants.PORTS);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IStructureConstants.PORTS_PROCESSOR})
	})
	public static void portEnumeration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object model,
			@GenerationBaseElement Object port,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String portName = getPortEnumName(generationValueGetter, parent);
		
		String enumDefinition = generationValueGetter.getString(parent, IModelingElementDefinitions.NAME)+ 
				CommonConstants.UNDERSCORE + CPPCommonConstants.ENUM.toUpperCase();
		generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACE_OPENING,
				enumDefinition, parent);
		
		generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACE_OPENING, portName, port);
		generationValueGetter.addUniqueValue(ICppDefinitions.DEFNIED_NAMESPACES_MACROS,port, parent, model);
		
		String protocolName = getPortEventEnumName(generationValueGetter, parent);
		Object protocol = generationValueGetter.getObject(port, IStructureConstants.PORT_PROTOCOL);
		
		generationValueGetter.addUniqueValue(ICppDefinitions.NAMESPACE_OPENING, protocolName, protocol);
		generationValueGetter.addUniqueValue(ICppDefinitions.DEFNIED_NAMESPACES_MACROS,protocol, parent, model);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.DEFAULT, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IStructureConstants.PORTS_PROCESSOR})
	})
	public static void portDepends(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object model,
			@GenerationBaseElement Object port,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String modelPath = generationValueGetter.generationPointString(parent, IModelingDecisions.MODEL_PATH);
		
		//Add depend on the protocol class in the class body
		String portProtocol = generationValueGetter.generate(ICppStructureDefinitions.PORT_CLASS_NAME, parent);
		
		Object protocol = generationValueGetter.getObject(port, IStructureConstants.PORT_PROTOCOL);
		String portType= generationValueGetter.getString(port, IModelingElementDefinitions.TYPE_NAME);
		
		String modelPackageName= generationValueGetter.generationPointString(parent, CPPCommonConstants.PACKAGE_SUFFIX);
		
		//Include package header in both body and header protocol files
		generationValueGetter.generationPointString(protocol, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, modelPackageName),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(protocol, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, modelPackageName),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		//Include the main header in the cpp
		generationValueGetter.generationPointString(protocol, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, portProtocol),
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, modelPath),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		generationValueGetter.generationPointString(protocol, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, portType),
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, modelPath),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.MEDIUM)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		
		generationValueGetter.generationPointString(port, ICppStructureDefinitions.PORT_PROTOCOL_EVENT_DEPEND, protocol);
		
		generationValueGetter.generationPointString(parent, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, portProtocol),
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, modelPath),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.MEDIUM)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, /*ICppDefinitions.BODY_INCLUDES_TRACKER*/ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		generationValueGetter.addUniqueValue(IModelingConstants.TYPES_TRACKER, protocol, modelPackage, portProtocol);
		generationValueGetter.addUniqueValue(IModelingConstants.GENERATION_HELPER_TYPE, portProtocol);
		
		
		generationValueGetter.generationPointString(parent, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, portProtocol), model);
		
		generationValueGetter.generationPointString(protocol, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, portType), model);
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Object value = generationValueGetter.getValue(ICppStructureDefinitions.PROTOCOL_MESSAGE_TRACKER, parent);
		generationValueGetter.generationPointString(value, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, modelPackageName),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(value, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, modelPackageName),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		String className= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		generationValueGetter.generationPointString(value, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, className), model);
		
		generationValueGetter.generationPointString(value, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, className),
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, modelPath),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.MEDIUM)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(value, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, className+ CommonConstants.UNDERSCORE+ IStructureConstants.MESSAGE),
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, modelPath),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.MEDIUM)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	})
	public static void register(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList,
			@GenerationElementParameter(id = IStructureConstants.PORT_BINDINGS) List<?> portBindings){
		if(portList.isEmpty()&& portBindings.isEmpty()){
			return;
		}
		
		List<String> connectors= new ArrayList<String>();
		for(Object port: portList){
			String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
			String connector = generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_CONNECT, portName, element);
			connectors.add(connector);
		}
		
		for(Object binding: portBindings){
			Object fromPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_PORT);
			Object toPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_PORT);
			
			String fromPortName = generationValueGetter.getString(fromPort, IModelingElementDefinitions.NAME);
			String toPortName = generationValueGetter.getString(toPort, IModelingElementDefinitions.NAME);
			
			Object fromSubComponent= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_SUBCOMPONENT);
			if(fromSubComponent== null){
				continue;
			}
			Object toSubComponent= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_SUBCOMPONENT);
			if(toSubComponent== null){
				continue;
			}
			
			String fromSubComponentType= generationValueGetter.getString(fromSubComponent, IModelingElementDefinitions.TYPE_NAME);
			String toSubComponentType= generationValueGetter.getString(toSubComponent, IModelingElementDefinitions.TYPE_NAME);
			
			
			String toSubComponentName= generationValueGetter.getString(toSubComponent, IModelingElementDefinitions.NAME);
			String fromSubComponentName= generationValueGetter.getString(fromSubComponent, IModelingElementDefinitions.NAME);
			
			String connector = generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_BINDING_CONNECT, 
					fromSubComponentName, fromSubComponentType, fromPortName, toSubComponentName, fromSubComponentName, toSubComponentType, toPortName,
					ICppStructureDefinitions.PORT_PROTOCOL_HANDLE_BINDING_DEFAULT_NAME);
			
			connectors.add(connector);
		}
		
		String body= GenerationUtil.listToGeneratedString(0, 1, connectors);
		
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_REGISTER,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, CommonConstants.BLANK),
				GenerationArgumentDescriptor.arg(IModelingConstants.CODY_BODY, body),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, IStructureConstants.PORT_INIT_CONNECTIONS_METHODNAME),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, IModelingConstants.OPERATIONS_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_IDENTIFIER, IStructureConstants.PORT_INIT_CONNECTIONS_METHODNAME),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_OPERATIONS_GROUP),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_OBJECT, element)
				//GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_COMMENT, commentsString),
				//GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_VIRTUAL, Boolean.valueOf(isPureVirtual)),
				//GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_PURE, Boolean.valueOf(isPureVirtual)),
				//GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_STATIC, Boolean.valueOf(isStatic)),
				/*GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_DEFAULTED_IMPLEMENTATION, Boolean.valueOf(isDefaultedImplementation))*/);
		
		
		
		List<String> disconnectors= new ArrayList<String>();
		for(Object port: portList){
			String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
			String disconnector = generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_DISCONNECT, portName, element);
			disconnectors.add(disconnector);
		}
		
		String disconnectBody= GenerationUtil.listToGeneratedString(0, 1, disconnectors);
		
		generationValueGetter.generationPointString(element, IModelingConstants.METHOD_REGISTER,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, CommonConstants.BLANK),
				GenerationArgumentDescriptor.arg(IModelingConstants.CODY_BODY, disconnectBody),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, IStructureConstants.PORT_DISCONNECT_CONNECTIONS_METHODNAME),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, IModelingConstants.OPERATIONS_IMPLEMENTATION),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_IDENTIFIER, IStructureConstants.PORT_DISCONNECT_CONNECTIONS_METHODNAME),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_OPERATIONS_GROUP),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_OBJECT, element));
		
		for(Object port: portList){
			String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
			
			
			String normalizedType= generationValueGetter.generationPointString(port, IModelingConstants.NORMALIZED_TYPE_NAME);
			String parmString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, normalizedType, IStructureConstants.DATA);
			
			String sendToBody= generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_SEND_TO_CONTENTS, portName, element);
			sendToBody= StringUtil.indent(sendToBody, 1);
			
			generationValueGetter.generationPointString(element, IModelingConstants.METHOD_REGISTER,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, parmString),
					GenerationArgumentDescriptor.arg(IModelingConstants.CODY_BODY, sendToBody),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, portName),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, IModelingConstants.OPERATIONS_IMPLEMENTATION),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_IDENTIFIER, portName),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_OPERATIONS_GROUP),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_OBJECT, element));
		}
		
		tt(generationValueGetter, element, portList);
		
	}

	private static void tt(GenerationPolicyRegistry generationValueGetter,
			Object element, List<?> portList) {
		for(Object port: portList){
			String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);

			String receiveMethodName= generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_EVENT_RECEIVE_DATA_METHOD_NAME, portName);
			
			String normalizedType= generationValueGetter.generationPointString(port, IModelingConstants.NORMALIZED_TYPE_NAME);
			String portData = portName/*+ CommonConstants.UNDERSCORE+IStructureConstants.DATA*/;
			String parmString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, normalizedType, portData);
			
			String receiveBody= generationValueGetter.generationPointString(port, ICppStructureDefinitions.PORT_PROTOCOL_RECEIVE_METHOD_CONTENTS);
			receiveBody= StringUtil.indent(receiveBody, 1);
			
			generationValueGetter.generationPointString(element, IModelingConstants.METHOD_REGISTER,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, parmString),
					GenerationArgumentDescriptor.arg(IModelingConstants.CODY_BODY, receiveBody),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, receiveMethodName),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, VisibilityConstants.PUBLIC),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, IModelingConstants.OPERATIONS_IMPLEMENTATION),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_IDENTIFIER, receiveMethodName),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_OPERATIONS_GROUP),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_OBJECT, element));
		}
	}

	@LoopProcessorAnnotations(aspect= LoopAspectConstants.DEFAULT, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	})
	public static void registerConnectorsUses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IStructureConstants.PORT_BINDINGS) List<?> portBindings,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		
		if(portList.isEmpty()&& portBindings.isEmpty()){
			return;
		}
		
		String use = generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_DESTRUCTOR);
		generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.DESTRUCTOR_IMPLEMENTATION, use,  element);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.DEFAULT, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	})
	public static void registerConnectorsConstructorUses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IStructureConstants.PORT_BINDINGS) List<?> portBindings,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		
		if(portList.isEmpty()&& portBindings.isEmpty()){
			return;
		}
		
		String use = generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_CONSTRUCTOR);
		//generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, use,  element);
		
		generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, 
				new SimpleEntry<Object, String>(element, use), element, Boolean.valueOf(false));
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRIVATE_DECLARATIONS, group= IModelingPriorityHandler.PRIVATE_DETAILS)
	public static String declarePrivateStructureAttributes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList,
			@GenerationElementParameter(id = IStructureConstants.PORT_BINDINGS) List<?> portBindings){
		if(portList.isEmpty()&& portBindings.isEmpty()){
			return null;
		}
		
		String assign= CommonConstants.BLANK;
		
		List<String> portHandleNames= new ArrayList<String>();
		for(Object port: portList){ 
			String portName = generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
			String use = generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLE_DEFAULT_NAME, portName);
			if(!portHandleNames.contains(use)){
				portHandleNames.add(use);
			}
		}
		
		for(Object binding: portBindings){
			Object fromPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_FROM_PORT);
			Object toPort= generationValueGetter.getObject(binding, IStructureConstants.PORT_BINDING_TO_PORT);
			
			String fromPortName = generationValueGetter.getString(fromPort, IModelingElementDefinitions.NAME);
			String toPortName = generationValueGetter.getString(toPort, IModelingElementDefinitions.NAME);
			
			String use = generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLE_BINDING_DEFAULT_NAME, fromPortName+ CommonConstants.UNDERSCORE+ toPortName);
			
			if(!portHandleNames.contains(use)){
				portHandleNames.add(use);
			}
		}
		
		assign= assign+ generationValueGetter.use(ICppDefinitions.ATTRIBUTE_DECLARATION, IStructureConstants.SLOT_HANDLE, GenerationUtil.asStringParameters(portHandleNames));
		assign= generationValueGetter.use(IStructureConstants.PORT_PROTOCOL_DESCRIPTION_COMMENT)+ CommonConstants.NEW_LINE+ assign;
		
		return assign+ CommonConstants.NEW_LINE;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PUBLIC_DECLARATIONS, group= IModelingPriorityHandler.PRIVATE_DETAILS)
	public static String declarePublicStructureAttributes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList,
			@GenerationElementParameter(id = IStructureConstants.PORT_BINDINGS) List<?> portBindings){
		if(portList.isEmpty()&& portBindings.isEmpty()){
			return null;
		}
		
		String protocolClass = generationValueGetter.generate(ICppStructureDefinitions.PORT_CLASS_NAME, element);
		String assign = portList.isEmpty()?CommonConstants.BLANK:
			generationValueGetter.use(ICppDefinitions.ATTRIBUTE_DECLARATION, protocolClass, StringUtil.firstCharacterToLowerCase(protocolClass))+ CommonConstants.NEW_LINE;
		
		
		return assign+ CommonConstants.NEW_LINE;
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}, aspect= LoopAspectConstants.FINALIZE, priority= GenerationPolicyRegistryPriorities.MEDIUM)
	public static void classAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object uClass,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		
		if(portList.isEmpty()){
			return;
		}
		
		List<Object> protocols= new ArrayList<Object>();
		for(Object port: portList){
			protocols.add(generationValueGetter.getObject(port, IStructureConstants.PORT_PROTOCOL));
		}
		
		String path= generationValueGetter.generationPointString(uClass, IModelingDecisions.MODEL_PATH);
		
		Object port= portList.get(0);
		
		String fullPath = generationValueGetter.generationPointString(port, IModelingConstants.ROOT_PATH,
				GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, path),
				GenerationArgumentDescriptor.arg(IModelingConstants.GENERATION_LANGUAGE, CPPCommonConstants.CPP_LANGUAGE));
				
		String headerFileName= generationValueGetter.generate(ICppStructureDefinitions.PORT_CLASS_NAME, uClass)+CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		String bodyFileName= generationValueGetter.generate(ICppStructureDefinitions.PORT_CLASS_NAME, uClass)+CommonConstants.DOT +CPPCommonConstants.BODY_FILE_EXTENSION;
		
		Object protocol = generationValueGetter.getObject(port, IStructureConstants.PORT_PROTOCOL);
		
		String generate = generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_HEADER_CONTENTS, uClass);
		String processingPath= generationValueGetter.generationPointString(uClass, ICppDefinitions.PRE_PROCESSING_DEFINITION_NAME)+ CommonConstants.UNDERSCORE+ IStructureConstants.PORT_PROTOCOL.toUpperCase();
		
		String headerContents = generationValueGetter.generate(ICppStructureDefinitions.PROTOCOL_CLASS_HEADER, protocol, uClass, generate, processingPath, 
				StringUtil.firstCharacterToUpperCase(IStructureConstants.PORT_PROTOCOL),
				GenerationArgumentDescriptor.arg(IModelingConstants.DEPENDS_LIST, protocols));
		
		ContentsDescriptor headerContentsDescriptor = new ContentsDescriptor(headerContents, headerFileName, fullPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, headerContentsDescriptor);
		
		String bodyIncludes= generationValueGetter.generationPointString(port, ICppDefinitions.BODY_INCLUDES, protocols,
				GenerationArgumentDescriptor.arg(IModelingConstants.DEPENDS_LIST, protocols));
		String bodyContents = generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_BODY_CONTENTS, uClass, uClass, bodyIncludes);
		
		ContentsDescriptor bodyContentsDescriptor = new ContentsDescriptor(bodyContents, bodyFileName, fullPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, bodyContentsDescriptor);
		
		
		//====================================================================================================================//
		Object messageObject = generationValueGetter.getValue(ICppStructureDefinitions.PROTOCOL_MESSAGE_TRACKER, uClass);
 
		String className= generationValueGetter.getString(uClass, IModelingElementDefinitions.NAME);
		
		//String normalizedType = generationValueGetter.generationPointString(uClass, IModelingConstants.NORMALIZED_TYPE_NAME,
		//GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_STRING, className));
		//String messageAttributes = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_DECLARATION, normalizedType, StringUtil.firstCharacterToLowerCase(className));
		String messageHeaderContenets= generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_CLASS_CONTENTS, uClass/*, messageAttributes*/,
				GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_STRING, className));
		String messageProcessingPath= generationValueGetter.generationPointString(uClass, ICppDefinitions.PRE_PROCESSING_DEFINITION_NAME)+ CommonConstants.UNDERSCORE+ IStructureConstants.MESSAGE.toUpperCase();
		
		String descirptorStructName= generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_NAME, uClass);
		String descirptorComment= generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_COMMENT, uClass);
		
		String messageDescriptorAttributes = GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR, 0, 1, uClass);
		String messageDescriptorContents = generationValueGetter.generate(ICppDefinitions.STRUCT_DECLARATION, uClass, descirptorComment, descirptorStructName, messageDescriptorAttributes);
		
		String messageHeaderFileContents = generationValueGetter.generate(ICppStructureDefinitions.PROTOCOL_CLASS_HEADER, messageObject, uClass, messageHeaderContenets, messageProcessingPath,
				StringUtil.firstCharacterToUpperCase(IStructureConstants.MESSAGE),
				GenerationArgumentDescriptor.arg(ICppDefinitions.INTERNAL_DEFINED_TYPES, messageDescriptorContents));
		
		String messageClassName= className+CommonConstants.UNDERSCORE+ IStructureConstants.MESSAGE;
		String messageHeaderFileName= messageClassName+ CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		
		ContentsDescriptor messageHeaderContentsDescriptor = new ContentsDescriptor(messageHeaderFileContents, messageHeaderFileName, fullPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, messageHeaderContentsDescriptor);
		
		String messageBodyIncludes= generationValueGetter.generationPointString(messageObject, ICppDefinitions.BODY_INCLUDES);
		String messageBodyProcessingPath= generationValueGetter.generationPointString(uClass, ICppDefinitions.PRE_PROCESSING_DEFINITION_NAME)+ CommonConstants.UNDERSCORE+ IStructureConstants.MESSAGE.toUpperCase();
		
		String serializeContents= generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_CONSTRUCTOR, uClass);
		serializeContents= serializeContents+ CommonConstants.NEW_LINE+ 
				GenerationUtil.getImplementationDetails(generationValueGetter, ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_GETTER_ASSIGN,  messageObject);
		
		String deserializeContents= GenerationUtil.getImplementationDetails(generationValueGetter, ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_SETTER_ASSIGN,  messageObject);
		String messageBodyContents = generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_BODY_CONTENTS, uClass, uClass, 
				messageBodyIncludes, messageClassName, messageBodyProcessingPath, serializeContents, deserializeContents,
				GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_STRING, className));
		String messageBodyFileName= className+CommonConstants.UNDERSCORE+ IStructureConstants.MESSAGE+ CommonConstants.DOT +CPPCommonConstants.BODY_FILE_EXTENSION;
		
		ContentsDescriptor messageContentsDescriptor = new ContentsDescriptor(messageBodyContents, messageBodyFileName, fullPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, messageContentsDescriptor);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.GETTER_GENERATION_POINT, ifConditionIds= IModelingDecisions.ATTRIBUTE_IS_SETTABLE)
	public static void setGetterDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingConstants.GETTER_METHOD_NAME) String getterMethodName,
			@GenerationProcedureParameter(id = IModelingConstants.SETTER_METHOD_NAME) String setterMethodName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String parameterString = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_DECLARATION, normalizedType, 
				StringUtil.firstCharacterToLowerCase(name));
		generationValueGetter.addValue(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR, parameterString,  parent);
		
		Object messageObject = generationValueGetter.getValue(ICppStructureDefinitions.PROTOCOL_MESSAGE_TRACKER, parent);
		generationValueGetter.generationPointString(messageObject, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, type));
		
		generationValueGetter.generationPointString(messageObject, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, type),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(messageObject, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, type),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(element, ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DEPEND, messageObject);
		
		String className= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		String getterAssign = generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_GETTER_ASSIGN, element, className, name, getterMethodName);
		generationValueGetter.addUniqueValue(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_GETTER_ASSIGN, getterAssign, messageObject);
		
		String setterAssign = generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_SETTER_ASSIGN, element, className, name, setterMethodName);
		generationValueGetter.addUniqueValue(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_SETTER_ASSIGN, setterAssign, messageObject);
	}

	@LoopProcessorAnnotations(aspect= LoopAspectConstants.AFTER, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}) 
	public static void portEnumerationClass(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object uClass,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		if(portList.isEmpty()){
			return;
		}
		
		String protocolName = getPortEnumName(generationValueGetter, uClass);
		String stringValues = generationValueGetter.generationPointString(parent, ICppStructureDefinitions.PORT_ENUM_CASES_STRING);
		
		String enumValues = generationValueGetter.generationPointString(uClass, ICppStructureDefinitions.PORT_ENUM_VALUES);
		
		List<?> ports= generationValueGetter.getList(uClass, IStructureConstants.PORTS);
		
		String first= CPPCommonConstants.NIL;
		String second= ports.isEmpty()?CPPCommonConstants.NIL: generationValueGetter.getString(ports.get(ports.size()-1), IModelingElementDefinitions.NAME);
		
		String enumImplementation = generationValueGetter.generate(ICppDefinitions.ENUM_IMPLEMENTATION, uClass,
				protocolName+ CommonConstants.UNDERSCORE, 
				enumValues, first, second,stringValues, GenerationArgumentDescriptor.arg(ICppDefinitions.OWING_NAMESPACE_OBJECT, uClass), StringUtil.firstCharacterToLowerCase(PORT));
		
		generationValueGetter.generationPointString(uClass, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING),
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		
		Object protocol = generationValueGetter.getObject(ports.get(0), IStructureConstants.PORT_PROTOCOL);
		generationValueGetter.addUniqueValue(ICppDefinitions.ENUM_IMPLEMENTATION, enumImplementation, /*uClass */ protocol);
	}
	
	@GenerationPoint(generationPoint = ICppStructureDefinitions.PORT_ENUM_VALUES)
	public static String getEnumValues(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
					@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		String values= CommonConstants.BLANK;
		
		int incrementer=1000;
		
		values= values+ generationValueGetter.use(ICppDefinitions.ENUM_VALUE, CPPCommonConstants.NIL, Integer.valueOf(0));
		int size = portList.size();
		if(size>0){
			values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
		}
		
		for(int index=0; index<size; index++){
			Object next = portList.get(index);
			values= values+ generationValueGetter.use(ICppDefinitions.ENUM_VALUE, 
					generationValueGetter.getString(next, IModelingElementDefinitions.NAME), Integer.valueOf(index+incrementer));
			
			if(index<size-1){
				values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
			}
		}
		return values;
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.AFTER, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	})
	public static void eventEnumerationClass(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object uClass,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		if(portList.isEmpty()){
			return;
		}
		
		List<SimpleEntry<String, String>> list = getPortEventList(generationValueGetter, portList);
		
		String protocolName = getPortEventEnumName(generationValueGetter, uClass);
		String stringValues = getEventCaseString(generationValueGetter, list);
		String enumValues = generationValueGetter.generationPointString(uClass, ICppStructureDefinitions.PORT_EVENT_ENUM_VALUES);
		
		String first= list.get(0).getKey();
		String second= list.size()<2?list.get(0).getKey(): list.get(list.size()-1).getKey();
		
		String enumImplementation = generationValueGetter.generate(ICppDefinitions.ENUM_IMPLEMENTATION, uClass,
				protocolName+ CommonConstants.UNDERSCORE, 
				enumValues, first, second,stringValues, GenerationArgumentDescriptor.arg(ICppDefinitions.OWING_NAMESPACE_OBJECT, uClass)/*, StringUtil.firstCharacterToLowerCase(EVENT)*/);
		
//		String enumImplementation = generationValueGetter.generate(ICppDefinitions.ENUM_IMPLEMENTATION, uClass,
//				CommonConstants.UNDERSCORE+ statemachineQualifiedTypeName, 
//				enumValues, first, second,stringValues, GenerationArgumentDescriptor.arg(ICppDefinitions.OWING_NAMESPACE_OBJECT, uClass));
//		
		generationValueGetter.generationPointString(uClass, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING),
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		List<?> ports= generationValueGetter.getList(uClass, IStructureConstants.PORTS);
		Object protocol = generationValueGetter.getObject(ports.get(0), IStructureConstants.PORT_PROTOCOL);
		generationValueGetter.addUniqueValue(ICppDefinitions.ENUM_IMPLEMENTATION, enumImplementation, /*uClass */ protocol);
	}
	
	@GenerationPoint(generationPoint = ICppStructureDefinitions.PORT_EVENT_ENUM_VALUES)
	public static String getEventEnumValues(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
					@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		String values= CommonConstants.BLANK;
		
		List<SimpleEntry<String, String>> list = getPortEventList(generationValueGetter, portList);
		
		for(SimpleEntry<String, String> entry: list){
			if(!values.isEmpty()){
				values= values+ CommonConstants.COMMA_SEPARATOR+ CommonConstants.SPACE;
			}
			values= values+ generationValueGetter.use(ICppDefinitions.ENUM_VALUE, entry.getKey(), Integer.valueOf(entry.getValue()));
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
		values= values+ generationValueGetter.use(ICppDefinitions.ENUM_CASE_STRING, list.get(0).getKey(), list.get(0).getKey());
		
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
			
			String description= generationValueGetter.use(ICppStructureDefinitions.PORT_EVENT_ENUM_DESCRIPTION, direction, name);
			values= values+ generationValueGetter.use(ICppDefinitions.ENUM_CASE_STRING, key, description);
		}
		
		return values;
	}
	
	@GenerationPoint(generationPoint = ICppStructureDefinitions.PORT_ENUM_CASES_STRING)
	public static String getCasesString(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IStructureConstants.PORTS) List<?> portList){
		
		String values= CommonConstants.BLANK;
		
		Iterator<?> iterator = portList.iterator();
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
	
	///////////////////////////////////////Port protocol event method implementations//////////////////////////////////////////////
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IStructureConstants.PORTS_PROCESSOR})
	})
	public static void portEvents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object port,
			@GenerationElementParameter(id = IStructureConstants.IS_IN_PORT) boolean isInPort,
			@GenerationElementParameter(id = IStructureConstants.IS_OUT_PORT) boolean isOutPort,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		 
		String body= generationValueGetter.generate(ICppStructureDefinitions.PORT_EVENT_ENTRY_ASSIGN, parent, name);
		body= body+ CommonConstants.NEW_LINE+ CommonConstants.NEW_LINE;
		
		if(isInPort){
			body= body+ generationValueGetter.generate(ICppStructureDefinitions.PORT_EVENT_ENTRY_INVOCATION, parent, name, IStructureConstants.IN, normalizedType);
		}
		
		if(isOutPort){
			if(!body.isEmpty()){
				body= body+ CommonConstants.NEW_LINE+ CommonConstants.NEW_LINE;
			}
			
			body= body+ generationValueGetter.generate(ICppStructureDefinitions.PORT_EVENT_ENTRY_INVOCATION, parent, name, IStructureConstants.OUT, normalizedType);
		}
		
		String parentName= generationValueGetter.generate(ICppStructureDefinitions.PORT_CLASS_NAME, parent);
		
		String qualifiedMethodName = generationValueGetter.use(ICppDefinitions.QUALIFIED_METHOD_NAME, parentName, name);
		
		String parameterString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, normalizedType, IStructureConstants.DATA);
		String implementations = generationValueGetter.generate(ICppDefinitions.METHOD_IMPLEMENTATION, port,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_CONTENTS, body),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, parameterString),
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, qualifiedMethodName));
		
		String declaration = generationValueGetter.use(ICppDefinitions.METHOD_DECLARATION, CPPTypesConstants.VOID, name, parameterString);
		
		generationValueGetter.addUniqueValue(ICppStructureDefinitions.PORT_EVENT_ENTRY_INVOCATION, implementations, parent);
		generationValueGetter.addUniqueValue(ICppStructureDefinitions.PORT_EVENT_DECLARATIONS, declaration, parent);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IStructureConstants.PORTS_PROCESSOR})
	})
	public static void portEventCases(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object port,
			@GenerationProcedureParameter(id= IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationElementParameter(id = IStructureConstants.IS_IN_PORT) boolean isInPort,
			@GenerationElementParameter(id = IStructureConstants.IS_OUT_PORT) boolean isOutPort,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		
		List<String> flows= new ArrayList<String>();
		if(isInPort){
			flows.add(IStructureConstants.IN);
		}
		
		if(isOutPort){
			flows.add(IStructureConstants.IN);
		}
		
		for(String flow: flows){
			String body= generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASE, port, parent, name, flow, normalizedType);
			generationValueGetter.addUniqueValue(ICppStructureDefinitions.PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASES, body, parent);
		}
		
		if(!isPrimitiveType){
			String descirptorStructName= generationValueGetter.generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_NAME, parent);
			
			Object protocol = generationValueGetter.getObject(port, IStructureConstants.PORT_PROTOCOL);
			String modelPath = generationValueGetter.generationPointString(parent, IModelingDecisions.MODEL_PATH);
			generationValueGetter.generationPointString(protocol, IModelingDecisions.DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, descirptorStructName),
					GenerationArgumentDescriptor.arg(IModelingDecisions.MODEL_PATH, modelPath),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IStructureConstants.PORTS_PROCESSOR})
	})
	public static void portEventAttributes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object port,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		 
		String body = generationValueGetter.use(ICppStructureDefinitions.PORT_PROTOCOL_IMPLEMENTATION_PORT_ATTRIBUTE, name, normalizedType);
		generationValueGetter.addUniqueValue(ICppStructureDefinitions.PORT_EVENT_IMPLEMENTATIONS_ATTRIBUTES, body, parent);
		
		Object portProtocol = generationValueGetter.getObject(port, IStructureConstants.PORT_PROTOCOL);
		generationValueGetter.generationPointString(port, ICppStructureDefinitions.PORT_PROTOCOL_EVENT_DEPEND, portProtocol);
		
		String portType= generationValueGetter.getString(port, IModelingElementDefinitions.TYPE_NAME);
		
//		generationValueGetter.generationPointString(portProtocol, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
//				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, portType));
//		generationValueGetter.generationPointString(protocol, IModelingDecisions.DEPENDS_GENERATION_POINT, 
//				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, portType),
//				//GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
//				//GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
//				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
//		generationValueGetter.generationPointString(parent, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
//				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, portProtocol), model);
//		
//		generationValueGetter.generationPointString(protocol, IModelingDecisions.DEPENDS_GENERATION_POINT, 
//				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, portType),
//				//GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
//				//GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
//				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
	}
	
	@GenerationPoint(generationPoint = ICppStructureDefinitions.PORT_EVENT_IMPLEMENTATIONS)
	public static String getPortEventImplementations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		return GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				ICppStructureDefinitions.PORT_EVENT_ENTRY_INVOCATION, 1, 0, element);
	}
	
	@GenerationPoint(generationPoint = ICppStructureDefinitions.PORT_EVENT_DECLARATIONS)
	public static String getPortEventDeclarations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		
		return GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				ICppStructureDefinitions.PORT_EVENT_DECLARATIONS, 1, 0, element);
	}
	
	@GenerationPoint(generationPoint = ICppStructureDefinitions.PORT_EVENT_IMPLEMENTATIONS_ATTRIBUTES)
	public static String getPortEventImplementationAttributes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		String implementationAndIndentDetails = GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
						ICppStructureDefinitions.PORT_EVENT_IMPLEMENTATIONS_ATTRIBUTES, 0, 0, element);
		return implementationAndIndentDetails.isEmpty()? implementationAndIndentDetails: CommonConstants.NEW_LINE+ implementationAndIndentDetails;
	}
	
	@GenerationPoint(generationPoint = ICppStructureDefinitions.PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASES)
	public static String getPortProtocolImplementationEventCases(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		return GenerationUtil.getImplementationAndIndentDetails(generationValueGetter, 
				ICppStructureDefinitions.PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASES, 1, 0, element);
	}
	
	@GenerationPoint(generationPoint = ICppStructureDefinitions.PORT_PROTOCOL_RECEIVE_METHOD_CONTENTS, priority= IGenerationPointPriorityConstants.HIGHEST)
	public static String portProtocolReceiveMethodConstraint(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		String constraints= generationValueGetter.generationPointString(element, IModelingElementDefinitions.CONSTRAINT_BODY);
		String string = constraints.isEmpty()?CommonConstants.BLANK: StringUtil.indent(constraints, 0);
		return string;
	}
	
	@GenerationPoint(generationPoint = ICppStructureDefinitions.PORT_PROTOCOL_RECEIVE_METHOD_CONTENTS)
	public static String portProtocolReceiveMEthodName(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IStructureConstants.ACTIVE_METHODS) List<Object> activeMethods,
			@GenerationLoopElement Object model,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationBaseElement Object port){
		 
		
		List<?> portList= generationValueGetter.getList(parent, IStructureConstants.PORTS);
		String portName= generationValueGetter.getString(port, IModelingElementDefinitions.NAME);
		String portNameData= portName/*+ CommonConstants.UNDERSCORE+IStructureConstants.DATA*/;
		
		String portType= generationValueGetter.getString(port, IModelingElementDefinitions.TYPE_NAME);
		
		String all= CommonConstants.BLANK;
		for(Object activeMethod: activeMethods){
			List<?> list = generationValueGetter.getList(activeMethod, IStructureConstants.ACTIVE_METHOD_CODE_BLOCKS);
			
			if(list== null){
				continue;
			}
			
			String activeMethodName= generationValueGetter.getString(activeMethod, IModelingElementDefinitions.NAME);
			
			List<?> activePorts = generationValueGetter.getList(activeMethod, IModelingElementDefinitions.ACTIVE_METHOD_PORTS,
					GenerationArgumentDescriptor.arg(IModelingConstants.ROOT, parent));
			
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
				String activePortType= generationValueGetter.generationPointString(activePort, IModelingElementDefinitions.TYPE_NAME);
				String normalizedActivePortType= generationValueGetter.generationPointString(activePort, IModelingConstants.NORMALIZED_TYPE_NAME);
				String activePortName= generationValueGetter.getString(activePort, IModelingElementDefinitions.NAME);
				String parmString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, normalizedActivePortType, activePortName);
				paramStrings.add(parmString);
				
				
				generationValueGetter.generationPointString(parent, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, activePortType), model);
				
				generationValueGetter.generationPointString(parent, IModelingDecisions.DEPENDS_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, activePortType),
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
				
			}
			
			String activeMethodVisibility= generationValueGetter.getString(activeMethod, IModelingElementDefinitions.ELEMENT_VISIBILITY);
			
			String normalizedType= generationValueGetter.generationPointString(port, IModelingConstants.NORMALIZED_TYPE_NAME);
			String parmString = paramStrings.size()<2?generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, normalizedType, portName):
				GenerationUtil.asStringParameters(new ArrayList<String>(paramStrings));
			String id = IStructureConstants.ACTIVE_METHODS+ activeMethodName;
			
			generationValueGetter.generationPointString(parent, IModelingConstants.METHOD_REGISTER,
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_RETURN_TYPE, CPPTypesConstants.VOID),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_PARAMETERS_STRING, parmString),
					GenerationArgumentDescriptor.arg(IModelingConstants.CODY_BODY, StringUtil.indent(all, 1)),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, activeMethodName),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_VISIBILITY_ARGUMENT, activeMethodVisibility),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_ID, IModelingConstants.OPERATIONS_IMPLEMENTATION),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_IDENTIFIER, id),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_GROUP, IModelingConstants.METHOD_OPERATIONS_GROUP),
					GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_OBJECT, parent)
					//GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_COMMENT, commentsString),
					//GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_VIRTUAL, Boolean.valueOf(isPureVirtual)),
					//GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_PURE, Boolean.valueOf(isPureVirtual)),
					//GenerationArgumentDescriptor.arg(ICppDefinitions.METHOD_STATIC, Boolean.valueOf(isStatic)),
					/*GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_DEFAULTED_IMPLEMENTATION, Boolean.valueOf(isDefaultedImplementation))*/);
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
			List<?> activePorts = generationValueGetter.getList(activeMethod, IModelingElementDefinitions.ACTIVE_METHOD_PORTS,
					GenerationArgumentDescriptor.arg(IModelingConstants.ROOT, parent));
			Set<String> paramStrings= new HashSet<String>();
			Set<String> paramTypes= new HashSet<String>();
			for(Object activePort: activePorts){
				String normalizedActivePortType= generationValueGetter.generationPointString(activePort, IModelingConstants.NORMALIZED_TYPE_NAME);
				String activePortName= generationValueGetter.getString(activePort, IModelingElementDefinitions.NAME);
				String parmString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, normalizedActivePortType, activePortName);
				paramStrings.add(parmString);
				paramTypes.add(generationValueGetter.getString(activePort, IModelingElementDefinitions.TYPE_NAME));
			}
			
			if(paramStrings.size()<2){
				if(paramTypes.contains(portType)){
					String activeMethodName= generationValueGetter.getString(activeMethod, IModelingElementDefinitions.NAME);
					calls.add(generationValueGetter.use(ICppDefinitions.METHOD_INVOCATION, activeMethodName, portNameData, Boolean.TRUE));
				}
			}else{
				//TODO: active object impementation
			}
		}
		
		String listToGeneratedString = GenerationUtil.listToGeneratedString(0, 0, new ArrayList<Object>(calls));
		
		return listToGeneratedString;
	}
	
	private static String getPortEnumName(GenerationPolicyRegistry generationValueGetter, Object parent) {
		String name= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		String protocolName= name+ CommonConstants.UNDERSCORE+ PORT;
		return protocolName;
	}
	
	private static String getPortEventEnumName(GenerationPolicyRegistry generationValueGetter, Object parent) {
		String name= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		String eventName= name+ CommonConstants.UNDERSCORE+ EVENT;
		return eventName;
	}
}