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
	
	public static final String PORT_EVENT_NAME = "portEventName"; //$NON-NLS-1$
	public static final String PORT_EVENT_TYPE = "portEventType"; //$NON-NLS-1$
	public static final String PORT_TYPE = "portType"; //$NON-NLS-1$
	public static final String PORT_NAME = "portName"; //$NON-NLS-1$
	
	public static final String PORT_PROTOCOL_DESCRIPTION_COMMENT = "portProtocolDescriptionComment"; //$NON-NLS-1$
	public static final String PORT_INIT_CONNECTIONS_METHODNAME = "initPortConnections"; //$NON-NLS-1$
	public static final String PORT_DISCONNECT_CONNECTIONS_METHODNAME = "disconnectPortConnections"; //$NON-NLS-1$
	
	public static final String ACTIVE_METHODS= "activeMethods"; //$NON-NLS-1$
	public static final String ACTIVE_METHOD_CODE_BLOCKS= "activeMethodCodeBlocks"; //$NON-NLS-1$
	public static final String ACTIVE_METHOD_CODE_BODY= "activeMethodCodeBody"; //$NON-NLS-1$
	
	public static final String PORT_BINDINGS= "portBindings"; //$NON-NLS-1$

	public static final String PORT_BINDING_FROM_PORT = "portBindingFromPort"; //$NON-NLS-1$
	public static final String PORT_BINDING_TO_PORT = "portBindingtoPort"; //$NON-NLS-1$
	
	public static final String PORT_BINDING_FROM_SUBCOMPONENT = "portBindingFromAttribute"; //$NON-NLS-1$
	public static final String PORT_BINDING_TO_SUBCOMPONENT = "portBindingtoAtribute"; //$NON-NLS-1$

	public static final String PORT_OWING_CLASS = "portOwingClass"; //$NON-NLS-1$
	
}
