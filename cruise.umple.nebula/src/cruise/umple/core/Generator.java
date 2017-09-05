package cruise.umple.core;

import java.util.List;

import cruise.umple.cpp.gen.CompositeStructure;
import cruise.umple.cpp.gen.GenerationTemplate;

public class Generator extends GenerationTemplate {
	
	public final static String COMPOSITE_SERIALIZE= "compositeSerialize";
	public final static String COMPOSITE_DESERIALIZE = "compositeDeserialize";
	public final static String COMPOSITE_PUBLIC_MESSAGE_CONTENT= "publicMessageContent";
	
	public final static String COMPOSITE_SERIALIZE_IMPLEMENTATION= "compositeSerializeImplementation";
	public final static String COMPOSITE_DESERIALIZE_IMPLEMENTATION= "compositedeserializeImplementation";
	public final static String COMPOSITE_CALL_THEN_RESOLVE= "compositeCallThenResolve";
	public final static String IF_CONDITION = "ifCondition";
	public final static String NO_IMPLEMENTATION= "no.implementation";  //$NON-NLS-1$
	
	
	public final static String RETURN_STATEMENET= "cpp.return.statemenet"; //$NON-NLS-1$
	
	public final static String IF_CONDITION_BLOCK= "cpp.if.condition.block"; //$NON-NLS-1$
	public final static String ASSIGN_STATEMENET= "cpp.assign.statement"; //$NON-NLS-1$
	public final static String NOT_EQUAL= "cpp.not.equal"; //$NON-NLS-1$
	public final static String ATTRIBUTE_USE= "cpp.attribute.use"; //$NON-NLS-1$
	public final static String PARAMETER_ASSIGN_STATEMENET= "cpp.parameter.assign.statement"; //$NON-NLS-1$
	
	
	
	public final static String METHOD_INVOCATION= "cpp.method.invocation"; //$NON-NLS-1$
	public final static String METHOD_TODO_STATEMENET= "cpp.method.todo.statement"; //$NON-NLS-1$
	public final static String DEFINITION_DECLARATION="cpp.definition.declaration";  //$NON-NLS-1$
	public final static String ENUM_VALUE= "cpp.element.enum.value"; //$NON-NLS-1$
	public final static String ENUM_CASE_STRING= "cpp.structure.enum.case.string"; //$NON-NLS-1$
	
	//////////STATEMACHINE-SPECIFIC///////////////
	public final static String HISTORY_STATE_CHECK = "historyStateCheck"; //$NON-NLS-1$
	public final static String STATES_SETTER_NAME_DEFINITION= "cpp.statemachine.states.setter.name.definition"; //$NON-NLS-1$
	public final static String DO_ACTIVITY_BODY_WRAP= "statemachine.do.activity.body.wrap"; //$NON-NLS-1$
	public final static String STATEMACHINE_FULL_PATH= "statemachine.full.path"; //$NON-NLS-1$
	public final static String STATEMACHINE_FULL_PATH_IMPLEMENTATION= "statemachine.full.path.implementation"; //$NON-NLS-1$
	public final static String STATEMACHINE_FULL_PATH_SEGMENT= "statemachine.full.path.segment"; //$NON-NLS-1$
	public final static String INVOKE_STATES_SETTER_DEFINITION= "cpp.statemachine.invoke.states.setter.definition"; //$NON-NLS-1$
	public final static String VARIABLE_INSTANCE= "cpp.statemachine.variable.instance"; //$NON-NLS-1$
	public final static String STATEMCHAINE_EXIT_PROCEDURE_NAME= "cpp.statemachine.exit.procedure.name"; //$NON-NLS-1$
	public final static String STATEMCHAINE_ENTER_PROCEDURE_NAME= "cpp.statemachine.enter.procedure.name"; //$NON-NLS-1$
	public final static String PROCEDURE_CALL_DECLARATION= "cpp.statemachine.procedure.call.declaration"; //$NON-NLS-1$
	public final static String PROCEDURE_CALL_AND_CHECK_DECLARATION= "cpp.statemachine.procedure.call.check.declaration"; //$NON-NLS-1$
	public final static String STATEMACHINE_METHOD_IMPLEMENTATION= "cpp.statemachine.events.implementation"; //$NON-NLS-1$
	public final static String STATUS_SETTER_DEFINITION= "cpp.statemachine.status.setter.definition"; //$NON-NLS-1$
	public final static String STATEMCHAINE_EXIT_PROCEDURE_DECLARATION= "cpp.statemachine.exit.procedure.declaration"; //$NON-NLS-1$
	public final static String STATEMCHAINE_EXIT_PROCEDURE_IMPLEMENTATION= "cpp.statemachine.exit.procedure.implementation"; //$NON-NLS-1$
	public final static String STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION= "cpp.statemachine.exit.procedure.state.implementation"; //$NON-NLS-1$
	public final static String STATEMCHAINE_NESTED_STATE_BODY= "cpp.statemachine.nested.state.body"; //$NON-NLS-1$
	public final static String SETTER_SWITCH_COMMENT= "cpp.setter.switch.comment"; //$NON-NLS-1$
	public final static String THREAD_INSTANCE= "statemachine.thread.instance"; //$NON-NLS-1$
	public final static String DO_ACTIVITY_MEDIATOR_IMPLEMENTATION= "cpp.do.activity.mediator.implementation";  //$NON-NLS-1$
	public final static String DO_ACTIVITY_METHOD_INSTANCE= "statemachine.do.activity.method"; //$NON-NLS-1$
	public final static String DO_ACTIVITY_FUNCTION_POINTER_IMPLEMENTATION= "cpp.do.activity.function.pointer.implementation";  //$NON-NLS-1$
	public final static String DO_ACTIVITY_FUNCTION_WRAP= "cpp.do.activity.function.pointer.wrap";  //$NON-NLS-1$
	public final static String STATEMCHAINE_THREAD_USE_DECLARATION= "cpp.statemachine.thread.use.declaration"; //$NON-NLS-1$
	public final static String ENUM_VARIABLE_PLACEHOLDER_DECLARATION= "cpp.enum.variable.placeholder.declaration"; //$NON-NLS-1$
	public final static String ENUM_VARIABLE_ASSIGMENT_DEFINITION= "cpp.statemachine.enum.variable.assignment.definition"; //$NON-NLS-1$
	public final static String STATEMACHINE_PROCESSED_CASE= "cpp.statemachine.processed.case"; //$NON-NLS-1$
	public final static String STATEMACHINE_SWITCH_CASE_DECLARATION= "cpp.statemachine.switch.case"; //$NON-NLS-1$
	
	
	public final static String STATEMCHAINE_ENTRY_PROCEDURE_STATE_CONTENTS= "cpp.statemachine.entry.procedure.state.contents"; //$NON-NLS-1$
	public final static String ENUM_USE= "cpp.enum.use"; //$NON-NLS-1$
	/////////////////////////
	
	
	//STL-specific
	public final static String TIME_ASSIGN= "time.assign"; //$NON-NLS-1$
	public final static String DATE_ASSIGN= "date.assign"; //$NON-NLS-1$
	public final static String DEFAULT_TIME_ASSIGN= "default.time.assign"; //$NON-NLS-1$
	public final static String DEFAULT_DATE_ASSIGN= "default.date.assign"; //$NON-NLS-1$
	public final static String CURRENT_TIME_REFERENCE= "current.time.reference"; //$NON-NLS-1$
	
	//Test-specific
	public final static String ASSERT_GETTER= "cpp.tests.assert.getter";	 	//$NON-NLS-1$
	public final static String METHOD_CALL= "cpp.tests.method.call";	 	//$NON-NLS-1$
	public final static String TEST_FILE_START= "cpp.tests.start";	 	//$NON-NLS-1$
	public final static String TEST_FILE_END= "cpp.tests.end";	 	//$NON-NLS-1$
	
	//Umple-specific
	public final static String SETTER_CAN_SET_CHECK= "class.setter.can.set.check";  //$NON-NLS-1$
	public final static String RESET_IMPLEMENTATION= "reset.method.implementation"; //$NON-NLS-1$
	
	//Composite-specific
	public final static String PORT_PROTOCOL_MESSAGE_GETTER_ASSIGN = "portProtocolMessageGetterAssign"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_MESSAGE_SETTER_ASSIGN = "portProtocolMessageSetterAssign"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_MESSAGE_DESCRIPTOR_COMMENT = "portProtocolMessageDescriptorComment"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_MESSAGE_NAME = "portProtocolMEssageName"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_MESSAGE_DESCRIPTOR_NAME = "portProtocolMEssageDescriptorName]"; //$NON-NLS-1$
	public final static String PROTOCOL_CLASS_HEADER = "protocolClassHeader"; //$NON-NLS-1$
	public final static String PORT_CLASS_NAME = "portClassName"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_DESCRIPTION_COMMENT = "portProtocolDescriptionComment"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_IMPLEMENTATION_PORT_ATTRIBUTE = "portProtocolImplementationPortAttribute"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_EVENT_RECEIVE_DATA_METHOD_NAME = "portProtocolEventReceiveDataMethodName"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_DEFAULT_VARIABLE_NAME = "portProtocolDefaultVariuableName"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_EVENT_DEFAULT_NAME = "portProtocolEventDefaultName"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_HANDLER_EVENT_CONNECT = "portProtocolHandlerEventConncet"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_HANDLE_BINDING_DEFAULT_NAME = "portProtocolHandlerBindingDefaultName"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_HANDLE_DEFAULT_NAME = "portProtocolHandlerDefaultName"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_HANDLER_EVENT_CONSTRUCTOR = "portProtocolHandlerEventConstructor"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_HANDLER_EVENT_DESTRUCTOR = "portProtocolHandlerEventDestructor"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_SEND_TO_CONTENTS = "portProtocolSendToContents"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_HANDLER_EVENT_DISCONNECT = "portProtocolHandlerEventDisconnect"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_HANDLER_EVENT_BINDING_CONNECT = "portProtocolHandlerBindingEventConncet"; //$NON-NLS-1$
	public final static String PORT_EVENT_ENTRY_INVOCATION = "portEventEntryInvocation"; //$NON-NLS-1$
	public final static String PORT_EVENT_ENTRY_ASSIGN = "portEntry"; //$NON-NLS-1$
	public final static String PORT_NAME = "portName"; //$NON-NLS-1$
	public final static String PORT_TYPE = "portType"; //$NON-NLS-1$
	public final static String PORT_EVENT_NAME = "portEventName"; //$NON-NLS-1$
	public final static String PORT_EVENT_TYPE = "portEventType"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_BODY_CONTENTS = "portProtocolBodyContents"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_HEADER_CONTENTS = "portProtocolHeaderContents"; //$NON-NLS-1$
	public final static String PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASE = "portProtocolImplementationEventCase"; //$NON-NLS-1$
	public final static String PORT_EVENT_ENUM_DESCRIPTION = "portEventEnumDescription"; //$NON-NLS-1$
	
	public CompositeStructure helper;
	
	public Generator(GenerationPolicyRegistry generationPolicyRegistry) {
		super(generationPolicyRegistry);
		helper = new CompositeStructure(generationPolicyRegistry);
	}

	public String generate(String id, Object element, Object... args){
		switch (id) {
		
		case Generator.IF_CONDITION:
			return helper.ifCondition((String)element, (String)args[0]);
		case Generator.COMPOSITE_SERIALIZE:
			return helper.serialize((String)element, (String)args[0], (String)args[1]);
		case Generator.COMPOSITE_DESERIALIZE:
			return helper.deserialize((String)element, (String)args[0]);
		case Generator.COMPOSITE_PUBLIC_MESSAGE_CONTENT:
			return helper.publicMessageContent((String)element, (String)args[0], (String)args[1]);
		case Generator.COMPOSITE_SERIALIZE_IMPLEMENTATION:
			return helper.serializeImplementation((String)element, (String)args[0]);
		case Generator.COMPOSITE_DESERIALIZE_IMPLEMENTATION:
			return helper.deserializeImplementation((String)element, (String)args[0], (String)args[1], (String)args[2], (String)args[3]);
		case Generator.COMPOSITE_CALL_THEN_RESOLVE:
			return helper.callThenResolve((String)element, (String)args[0], (String)args[1]);
		case Generator.NO_IMPLEMENTATION:
			return helper.nullImplementation();	
		case Generator.RETURN_STATEMENET:	
			return helper.returnStatement((String)element, args.length>0?(Boolean)args[0]: false);		
		case Generator.IF_CONDITION_BLOCK:	
			return helper.ifConditionBlock((String)element, (String)args[0], args.length>1?(Boolean)args[1]: false);
		case Generator.ASSIGN_STATEMENET:	
			return helper.assignStatement((String)element, (String)args[0], args.length>1?(String)args[1]: null);
			
		case Generator.NOT_EQUAL:
			return helper.notEqual((String)element, (String)args[0]);
		case Generator.ATTRIBUTE_USE:
			return helper.attributeUse((String)element, (String)args[0], args.length>1?(Boolean)args[1]: false, args.length>2?(Boolean)args[2]: false);
		case Generator.PARAMETER_ASSIGN_STATEMENET:
			return helper.parameterAssignStatement((String)element, (String)args[0], args.length>1?(Boolean)args[1]: false);
		case Generator.METHOD_INVOCATION:
			return helper.methodInvocation((String)element, (String)args[0], args.length>1?(Boolean)args[1]: false);
		case Generator.METHOD_TODO_STATEMENET:
			return helper.methodTodoStatement((String)element);
		case Generator.DEFINITION_DECLARATION:
			return helper.definitionDeclaration((String)element, (Integer)args[0]);
		
		case Generator.ENUM_VALUE:
			return helper.enumValue((String)element, (Integer)args[0]);
		case Generator.ENUM_CASE_STRING:
			return helper.enumCaseString((String)element, args.length>0?(String)args[0]: null);
		
		
		case Generator.HISTORY_STATE_CHECK:
			return helper.historyStateCheck((String) element, (String)args[0]);
		case Generator.STATES_SETTER_NAME_DEFINITION:
			return helper.statesSetterNameDefinition((String) element);
		case Generator.DO_ACTIVITY_BODY_WRAP:
			return helper.doActivityBodyWrap((String) element);
		case Generator.STATEMACHINE_FULL_PATH:
			return helper.statemachineFullPath((String) element);
		case Generator.STATEMACHINE_FULL_PATH_IMPLEMENTATION:
			return helper.statemachineFullPathImplementation((String) element, (String)args[0]);
		case Generator.STATEMACHINE_FULL_PATH_SEGMENT:
			return helper.statemachineFullPathSegment((String) element, (String)args[0]);
		case Generator.INVOKE_STATES_SETTER_DEFINITION:
			return helper.invokeStatesSetterDefinition((String) element, (String)args[0], (String)args[1]);
		case Generator.VARIABLE_INSTANCE:
			return helper.variableInstance((String) element);
		case Generator.STATEMCHAINE_EXIT_PROCEDURE_NAME:
			return helper.statemachineExitProcedureName((String) element);
		case Generator.STATEMCHAINE_ENTER_PROCEDURE_NAME:
			return helper.statemachineEnterProcedureName((String) element);
		case Generator.PROCEDURE_CALL_DECLARATION:
			return helper.procedureCallDeclaration((String) element);
		case Generator.PROCEDURE_CALL_AND_CHECK_DECLARATION:
			return helper.procedureCallAndCheckDeclaration((String) element, args.length>0?(Boolean)args[0]: false);
		case Generator.STATEMACHINE_METHOD_IMPLEMENTATION:
			return helper.statemachineMethodImplementation((String) element);
		case Generator.STATUS_SETTER_DEFINITION:
			return helper.statusSetterDefinition((String) element, (String)args[0]);
		case Generator.STATEMCHAINE_EXIT_PROCEDURE_DECLARATION:
			return helper.statemachineExitProcedureDeclaration((String) element);
		case Generator.STATEMCHAINE_EXIT_PROCEDURE_IMPLEMENTATION:
			return helper.statemachineExitProcedureImplementation((String) element, (String)args[0], (String)args[1]);
		case Generator.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION:
			return helper.statemachineEntryExitProcedureStateImplementation((String) element, (String)args[0]);
		case Generator.STATEMCHAINE_NESTED_STATE_BODY:
			return helper.statemachineNestedStateBody((String) element, (String)args[0], (String)args[1], (String)args[2], (String)args[3]);
		case Generator.SETTER_SWITCH_COMMENT:
			return helper.setterSwitchComment();
		case Generator.THREAD_INSTANCE:
			return helper.threadInstance((String) element);
		case Generator.DO_ACTIVITY_MEDIATOR_IMPLEMENTATION:
			return helper.doActivityMediatorImplementation((String) element, (String)args[0]);
		case Generator.DO_ACTIVITY_METHOD_INSTANCE:
			return helper.doActivityMethodInstance((String) element);
		case Generator.DO_ACTIVITY_FUNCTION_POINTER_IMPLEMENTATION:
			return helper.doActivityFunctionPointerImplementation((String) element, (String)args[0], (String)args[1]);
		case Generator.DO_ACTIVITY_FUNCTION_WRAP:
			return helper.doActivityFunctionWrap((String) element);
		case Generator.STATEMCHAINE_THREAD_USE_DECLARATION:
			return helper.statemachineThreadUseDeclaration((String) element);
		case Generator.ENUM_VARIABLE_PLACEHOLDER_DECLARATION:
			return helper.enumVariablePlaceholderDeclaration((String) element, (String)args[0], (String)args[1]);
		case Generator.ENUM_VARIABLE_ASSIGMENT_DEFINITION:
			return helper.enumVariableAssignmentDefinition((String) element, (String)args[0]);
		case Generator.STATEMACHINE_PROCESSED_CASE:
			return helper.statemachineProcessedCase();
		case Generator.STATEMACHINE_SWITCH_CASE_DECLARATION:
			return helper.statemachineSwitchCaseDeclaration((String) element, (String)args[0], (String)args[1]);
		case Generator.ENUM_USE:
			return helper.enumUseDeclaration((String) element, (String)args[0]);
		
		
		case Generator.TIME_ASSIGN:
			return helper.timeAssign((String)element);
		case Generator.DATE_ASSIGN:
			return helper.dateAssign((String)element);
		case Generator.DEFAULT_TIME_ASSIGN:
			return helper.defaultTimeAssign();
		case Generator.DEFAULT_DATE_ASSIGN:
			return helper.defaultDateAssign();
		case Generator.CURRENT_TIME_REFERENCE:
			return helper.currentTimeReference();
			
		
		case Generator.ASSERT_GETTER:
			return helper.assertGetter((String) element, (String)args[0], (String)args[1], (String)args[2], (String)args[3]);
		case Generator.METHOD_CALL:
			return helper.methodCall((String) element, (String)args[0], (String)args[1], (Boolean)args[2]);
		case Generator.TEST_FILE_START:
			return helper.testFileStart((String) element, (String)args[0], (String)args[1], (String)args[2]);
		case Generator.TEST_FILE_END:
			return helper.testFileEnd((String) element, (String)args[0]);
			
			
			
			
		case Generator.SETTER_CAN_SET_CHECK:
			return helper.setterCanSetCheck((String) element);
		case Generator.RESET_IMPLEMENTATION:
			return helper.resetImplementation((String) element, (String)args[0]);
			
			
		
		case Generator.PORT_PROTOCOL_MESSAGE_GETTER_ASSIGN:
			return helper.portProtocolMessageGetterAssign((String)args[0], (String)args[1], (String)args[2]);
		case Generator.PORT_PROTOCOL_MESSAGE_SETTER_ASSIGN:
			return helper.portProtocolMessageSetterAssign((String)args[0], (String)args[1], (String)args[2]);
		case Generator.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_COMMENT:
			return helper.portProtocolMessageDescriptorComment(element);
		case Generator.PORT_PROTOCOL_MESSAGE_NAME:
			return helper.portProtocolMessageName(element);
		case Generator.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_NAME:
			return helper.portProtocolMessageDescriptorName(element);
		case Generator.PROTOCOL_CLASS_HEADER:
			return helper.protocolClassHeader(element, args[0], (String)args[1], (String)args[2], (String) args[3], (List<?>)args[4], (String) args[5]);
		case Generator.PORT_CLASS_NAME:
			return helper.portClassName(element);
		case Generator.PORT_PROTOCOL_DESCRIPTION_COMMENT:
			return helper.portProtocolDescriptionComment();
		case Generator.PORT_PROTOCOL_IMPLEMENTATION_PORT_ATTRIBUTE:
			return helper.portProtocolImplementationPortAttribute((String) element, (String)args[0]);
		case Generator.PORT_PROTOCOL_EVENT_RECEIVE_DATA_METHOD_NAME:
			return helper.portProtocolEventReceiveDataMethodName((String) element);
		case Generator.PORT_PROTOCOL_DEFAULT_VARIABLE_NAME:
			return helper.portProtocolDefaultVariableName(element);
		case Generator.PORT_PROTOCOL_EVENT_DEFAULT_NAME:
			return helper.portProtocolEventDefaultName((String) element);
		case Generator.PORT_PROTOCOL_HANDLER_EVENT_CONNECT:
			return helper.portProtocolHandlerEventConnect(element, (String)args[0], (String)args[1]);
		case Generator.PORT_PROTOCOL_HANDLE_BINDING_DEFAULT_NAME:
			return helper.portProtocolHandleBindingDefaultName((String) element);
		case Generator.PORT_PROTOCOL_HANDLE_DEFAULT_NAME:
			return helper.portProtocolHandleDefaultName((String) element);
		case Generator.PORT_PROTOCOL_HANDLER_EVENT_CONSTRUCTOR:
			return helper.portProtocolHandlerEventConstructor();
		case Generator.PORT_PROTOCOL_HANDLER_EVENT_DESTRUCTOR:
			return helper.portProtocolHandlerEventDestructor();
		case Generator.PORT_PROTOCOL_SEND_TO_CONTENTS:
			return helper.portProtocolSendToContents(element, (String)args[0]);
		case Generator.PORT_PROTOCOL_HANDLER_EVENT_DISCONNECT:
			return helper.portProtocolHandlerEventBindingDisconnect(element, (String)args[0]);
		case Generator.PORT_PROTOCOL_HANDLER_EVENT_BINDING_CONNECT:
			return helper.portProtocolHandlerEventBindingConnect((String) element, (String)args[0], (String)args[1], (String)args[2], (String)args[3], (String)args[4]);
		case Generator.PORT_EVENT_ENTRY_INVOCATION:
			return helper.portEventEntryInvocation(element, (String)args[0], (String)args[1], (String)args[2]);
		case Generator.PORT_EVENT_ENTRY_ASSIGN:
			return helper.portEventEntryAssign(element, (String)args[0]);
		case Generator.PORT_NAME:
			return helper.portName(element);
		case Generator.PORT_TYPE:
			return helper.portType(element);
		case Generator.PORT_EVENT_NAME:
			return helper.portEventName(element);
		case Generator.PORT_EVENT_TYPE:
			return helper.portEventType(element);
		case Generator.PORT_PROTOCOL_BODY_CONTENTS:
			return helper.portProtocolBodyContents(element, args[0], (String)args[1]);
		case Generator.PORT_PROTOCOL_HEADER_CONTENTS:
			return helper.portProtocolHeaderContents(element);
		case Generator.PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASE:
			return helper.portProtocolImplementationEventCase(element, (String)args[0], (String)args[1], (String)args[2]);
		case Generator.PORT_EVENT_ENUM_DESCRIPTION:
			return helper.portEventEnumDescription((String) element, (String)args[0]);
		
			
		default:
			break;
		}
		return null;
	}

}