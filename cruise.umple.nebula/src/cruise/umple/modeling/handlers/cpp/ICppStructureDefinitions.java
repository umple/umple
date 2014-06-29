/*******************************************************************************
* Copyright (c) 2013-2014 Ahmed M.Orabi, Mahmoud M.Orabi.
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

public interface ICppStructureDefinitions {
	
	public final static String PUBLISH_SUBSCRIBE_API= "publishSubscribeAPI"; //$NON-NLS-1$
	public static final String PORT_EVENT_ENTRY_ASSIGN = "portEntry"; //$NON-NLS-1$
	
	public final static String PORT_ENUM= "portEnum"; //$NON-NLS-1$
	public final static String PORT_ENUM_CASES_STRING= "cpp.structure.enum.cases.strings"; //$NON-NLS-1$

	public static final String PORT_ENUM_VALUES = "structurePortEnumValue"; //$NON-NLS-1$
	public static final String PORT_EVENT_ENUM_VALUES = "structureProtocolEnumValue"; //$NON-NLS-1$
	public static final String PORT_EVENT_ENUM_DESCRIPTION = "portEventEnumDescription"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_IMPLEMENTATION = "portProtocolImplementation"; //$NON-NLS-1$
	public static final String PORT_EVENT_IMPLEMENTATIONS = "portEventImplementations"; //$NON-NLS-1$
	public static final String PORT_EVENT_ENTRY_INVOCATION = "portEventEntryInvocation"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_IMPLEMENTATION_PORT_ATTRIBUTE = "portProtocolImplementationPortAttribute"; //$NON-NLS-1$
	public static final String PORT_EVENT_IMPLEMENTATIONS_ATTRIBUTES = "portEventImplementationAttributes"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASE = "portProtocolImplementationEventCase"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASES = "portProtocolImplementationEventCases"; //$NON-NLS-1$
	public static final String PROTOCOL_CLASS_HEADER = "protocolClassHeader"; //$NON-NLS-1$
	public static final String PORT_CLASS_NAME = "portClassName"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_HEADER_CONTENTS = "portProtocolHeaderContents"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_BODY_CONTENTS = "portProtocolBodyContents"; //$NON-NLS-1$
	public static final String PORT_EVENT_DECLARATIONS = "portEventDeclarations"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_EVENT_DEPEND = "portProtocolEventDepend"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_DEPEND = "portProtocolEventMessage"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_HANDLER_EVENT_CONNECT = "portProtocolHandlerEventConncet"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_HANDLER_EVENT_BINDING_CONNECT = "portProtocolHandlerBindingEventConncet"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_HANDLER_EVENT_DISCONNECT = "portProtocolHandlerEventDisconnect"; //$NON-NLS-1$
	
	public static final String PORT_PROTOCOL_DEFAULT_VARIABLE_NAME = "portProtocolDefaultVariuableName"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_EVENT_RECEIVE_DATA_METHOD_NAME = "portProtocolEventReceiveDataMethodName"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_HANDLE_DEFAULT_NAME = "portProtocolHandlerDefaultName"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_HANDLE_BINDING_DEFAULT_NAME = "portProtocolHandlerBindingDefaultName"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_EVENT_DEFAULT_NAME = "portProtocolEventDefaultName"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_HANDLER_EVENT_DESTRUCTOR = "portProtocolHandlerEventDestructor"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_HANDLER_EVENT_CONSTRUCTOR = "portProtocolHandlerEventConstructor"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_DEFAULT_SEND_TO_NAME = "portProtocolDefaultSendToName"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_SEND_TO_CONTENTS = "portProtocolSendToContents"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_RECEIVE_METHOD_CONTENTS = "portProtocolReceiveMethodContents"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_CLASS_CONTENTS = "portProtocolMessageClassContents"; //$NON-NLS-1$
	
	public final static String PROTOCOL_MESSAGE_TRACKER= "protocolMessageTracker"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_BODY_CONTENTS = "portProtocolMessageBodyConetns"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_NAME = "portProtocolMEssageName"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_DESCRIPTOR_NAME = "portProtocolMEssageDescriptorName]"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_DESCRIPTOR_COMMENT = "portProtocolMessageDescriptorComment"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_DESCRIPTOR = "portProtocolMessageDescriptor"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_CONSTRUCTOR = "portProtoolMessageConstructor"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_GETTER_ASSIGN = "portProtocolMessageGetterAssign"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_SETTER_ASSIGN = "portProtocolMessageSetterAssign"; //$NON-NLS-1$
	
	
	
}
