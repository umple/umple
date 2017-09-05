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
package cruise.umple.modeling.handlers;

public interface IStructureConstants {
	
	public static final String DATA = "data"; //$NON-NLS-1$
	
	public final static String PORTS_PROCESSOR= "portsProcessor"; //$NON-NLS-1$
	public final static String SLOT_HANDLE= "SlotHandle"; //$NON-NLS-1$
	
	public static final String IN = "IN"; //$NON-NLS-1$
	public static final String OUT = "OUT"; //$NON-NLS-1$
	public static final String BOTH = "BOTH"; //$NON-NLS-1$
	
	public static final String PORTS = "ports"; //$NON-NLS-1$
	public static final String PORT_DIRECTION = "portDirection"; //$NON-NLS-1$
	public static final String IS_OUT_PORT = "isOutPort"; //$NON-NLS-1$
	public static final String IS_IN_PORT = "isInPort"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL = "portProtocol"; //$NON-NLS-1$
	public static final String MESSAGE = "Message"; //$NON-NLS-1$
	
	
	public static final String PORT_INIT_CONNECTIONS_METHODNAME = "initPortConnections"; //$NON-NLS-1$
	public static final String PORT_DISCONNECT_CONNECTIONS_METHODNAME = "disconnectPortConnections"; //$NON-NLS-1$
	
	public static final String ACTIVE_METHODS= "activeMethods"; //$NON-NLS-1$
	public static final String IS_CONJUGATED= "isConjugated"; //$NON-NLS-1$
	public static final String CONJUGATED_ACTIVE_METHODS= "conjugatedActiveMethods"; //$NON-NLS-1$
	public static final String CONJUGATED_ACTIVE_METHOD= "conjugatedActiveMethod"; //$NON-NLS-1$
	public static final String ACTIVE_METHOD_CODE_BLOCKS= "activeMethodCodeBlocks"; //$NON-NLS-1$
	public static final String ACTIVE_METHOD_CODE_BODY= "activeMethodCodeBody"; //$NON-NLS-1$
	
	public static final String PORT_BINDINGS= "portBindings"; //$NON-NLS-1$

	public static final String PORT_BINDING_FROM_PORT = "portBindingFromPort"; //$NON-NLS-1$
	public static final String PORT_BINDING_TO_PORT = "portBindingtoPort"; //$NON-NLS-1$
	
	public static final String PORT_BINDING_FROM_SUBCOMPONENT = "portBindingFromAttribute"; //$NON-NLS-1$
	public static final String PORT_BINDING_TO_SUBCOMPONENT = "portBindingtoAtribute"; //$NON-NLS-1$

	public static final String PORT_OWNING_CLASS = "portOwningClass"; //$NON-NLS-1$

	public static final String TIMED_CONSTRAINTS = "timed.constraints";	 //$NON-NLS-1$
	public static final String TIMER = "timer";	 //$NON-NLS-1$

	public static final String ACTIVE_METHOD_INLINE_BLOCKS = "active.methods.inline.blocks"; //$NON-NLS-1$
	public static final String METHOD_INVOKE = "method.invoke"; //$NON-NLS-1$
	public static final String ANONYMOUS_BODY = "anonymous.body"; //$NON-NLS-1$
	public static final String RESOLVE_BODY = "resolveBody";
	public static final String THEN_BODY = "thenBody";

	public static final String IS_COMPLEX_PORT = "isComplexPort";
	
	
	////////////////////////////////////////////
	public final static String PORT_ENUM= "portEnum"; //$NON-NLS-1$
	public final static String PORT_ENUM_CASES_STRING= "cpp.structure.enum.cases.strings"; //$NON-NLS-1$

	public static final String PORT_ENUM_VALUES = "structurePortEnumValue"; //$NON-NLS-1$
	public static final String PORT_EVENT_ENUM_VALUES = "structureProtocolEnumValue"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_IMPLEMENTATION = "portProtocolImplementation"; //$NON-NLS-1$
	public static final String PORT_EVENT_IMPLEMENTATIONS = "portEventImplementations"; //$NON-NLS-1$
	
	public static final String PORT_EVENT_IMPLEMENTATIONS_ATTRIBUTES = "portEventImplementationAttributes"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASES = "portProtocolImplementationEventCases"; //$NON-NLS-1$
	public static final String PORT_EVENT_DECLARATIONS = "portEventDeclarations"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_EVENT_DEPEND = "portProtocolEventDepend"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_DEPEND = "portProtocolEventMessage"; //$NON-NLS-1$
	
	
	public static final String PORT_PROTOCOL_RECEIVE_METHOD_CONTENTS = "portProtocolReceiveMethodContents"; //$NON-NLS-1$
	
	public final static String PROTOCOL_MESSAGE_TRACKER= "protocolMessageTracker"; //$NON-NLS-1$
	public static final String PORT_PROTOCOL_MESSAGE_DESCRIPTOR = "portProtocolMessageDescriptor"; //$NON-NLS-1$
	
}
