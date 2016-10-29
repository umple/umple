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

package cruise.umple.cpp.jet;

import cruise.umple.cpp.CppGenerationTemplate;

import cruise.umple.core.*;
import cruise.umple.modeling.handlers.cpp.*;
import cruise.umple.cpp.utils.*;
import cruise.umple.core.GenerationCallback.*;
import cruise.umple.modeling.handlers.*;

@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppStructure extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppStructure create(String lineSeparator)
  {
    nl = lineSeparator;
    CppStructure result = new CppStructure();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "typedef char samllInt;" + NL + "typedef unsigned char unsignedSamllInt;" + NL + "typedef short int shortInt;" + NL + "typedef unsigned short int unsignedShortInt;" + NL + "" + NL + "#define MSG_MAX 80" + NL + "#define MSG_SIZE 128" + NL + "" + NL + "typedef int SlotHandle;" + NL + "" + NL + "template <typename T,typename P>" + NL + "class IPublisher" + NL + "{" + NL + "public:" + NL + "\tvirtual T publish(P param) = 0;" + NL + "};" + NL + "" + NL + "template <typename L,typename R,typename P>" + NL + "class Publisher : public IPublisher<R,P>" + NL + "{" + NL + "private:" + NL + "\ttypedef R (L::*FuncPtr)(P);" + NL + "\tL* _object;" + NL + "\tFuncPtr _functionPointer;" + NL + "\t" + NL + "public:" + NL + "\tPublisher(L* object, FuncPtr funcPtr)" + NL + "\t\t: _object(object), _functionPointer(funcPtr)" + NL + "\t{}" + NL + "" + NL + "\tR publish(P arg)" + NL + "\t{" + NL + "\t\treturn (_object->*_functionPointer)(arg);\t\t" + NL + "\t}" + NL + "};" + NL + "" + NL + "template <typename R,typename P1>" + NL + "class Event" + NL + "{" + NL + "private:" + NL + "\ttypedef std::map<int,IPublisher<R,P1> *> SubscribersMap;" + NL + "\tSubscribersMap subscribers;" + NL + "\tint subscribersCount;" + NL + "" + NL + "public:" + NL + "\tEvent()" + NL + "\t\t: subscribersCount(0) {}" + NL + "" + NL + "\ttemplate <typename L>" + NL + "\tSlotHandle subscribe(L* component,R (L::*func)(P1))" + NL + "\t{" + NL + "\t\ttypedef R (L::*FuncPtr)(P1);\t" + NL + "\t\tsubscribers[subscribersCount] = (new Publisher<L,R,P1>(component,func));" + NL + "\t\tsubscribersCount++;\t" + NL + "\t\treturn subscribersCount-1;" + NL + "\t}" + NL + "" + NL + "\tbool disconnect(SlotHandle id)" + NL + "\t{" + NL + "\t\ttypename SubscribersMap::iterator it = subscribers.find(id);" + NL + "\t\tif(it == subscribers.end())" + NL + "\t\t\treturn false;" + NL + "\t\tdelete it->second;" + NL + "\t\tsubscribers.erase(it);\t\t\t\t" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\tR publish(P1 arg)" + NL + "\t{" + NL + "\t\ttypename SubscribersMap::iterator it = subscribers.begin();" + NL + "\t\tfor(; it != subscribers.end(); it++)" + NL + "\t\t{" + NL + "\t\t\tit->second->publish(arg);" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "" + NL + "typedef struct MessageHeader{" + NL + "\tshortInt portId;" + NL + "\tshortInt eventId;" + NL + "\tvoid* data;" + NL + "} MessageHeader;" + NL + "" + NL + "" + NL + "" + NL + "class MessageService {" + NL + "\tprivate:" + NL + "\t\tmutable MutexLock lock;" + NL + "" + NL + "\t\tqueue<MessageHeader*>* msgQueue;" + NL + "\t\tqueue<MessageHeader*>* msgPool;" + NL + "\t\t//Thread* executeThread;" + NL + "" + NL + "\t\tSlotHandle dispatcherHandleId;" + NL + "\t\tEvent<void,const MessageHeader*> msgDispatcher;" + NL + "" + NL + "\t\tunsignedSamllInt buffer[MSG_MAX*MSG_SIZE];" + NL + "\tpublic:" + NL + "\t\ttemplate <typename L,typename R,typename P1>" + NL + "\t\tMessageService(L* component,R (L::*func)(P1))" + NL + "\t\t{" + NL + "\t\t\tdispatcherHandleId = msgDispatcher.subscribe(component,func);" + NL + "\t\t\tmsgQueue = new queue<MessageHeader*>();" + NL + "\t\t\tmsgPool = new queue<MessageHeader*>();" + NL + "\t\t\tfor (int i=0; i< MSG_MAX; i++){" + NL + "\t\t\t\tMessageHeader* block = (MessageHeader*) &buffer[i* MSG_SIZE];" + NL + "\t\t\t\tmsgPool->push(block);" + NL + "\t\t\t}" + NL + "\t\t\t//executeThread = new Thread(&MessageService::execute,this);" + NL + "\t\t\t//executeThread->start();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tvirtual ~MessageService() {" + NL + "\t\t\tmsgDispatcher.disconnect(dispatcherHandleId);" + NL + "\t\t\twhile(!msgQueue->empty()) {" + NL + "\t\t\t\tMessageHeader* msg = msgQueue->front();" + NL + "\t\t\t\tmsgQueue->pop();" + NL + "\t\t\t\tdelete msg;" + NL + "\t\t\t}" + NL + "\t\t\tdelete msgQueue;" + NL + "\t" + NL + "\t\t\twhile(!msgPool->empty()) {" + NL + "\t\t\t\tMessageHeader* msg = msgPool->front();" + NL + "\t\t\t\tmsgPool->pop();" + NL + "\t\t\t\tdelete msg->data;" + NL + "\t\t\t\tdelete msg;" + NL + "\t\t\t}" + NL + "\t\t\t//delete executeThread;" + NL + "\t\t\tdelete msgPool;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tvoid push(MessageHeader* msg) {" + NL + "\t\t\t//synchronized(lock) " + NL + "\t\t\t{" + NL + "\t\t\t\tmsgQueue->push(msg);" + NL + "\t\t\t\t//executeThread->wakeUp();" + NL + "\t\t\t\texecute();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tMessageHeader* pop() {" + NL + "\t\t\tMessageHeader* msg = msgQueue->front();" + NL + "\t\t\tmsgQueue->pop();" + NL + "\t\t\treturn msg;" + NL + "\t\t}" + NL + "" + NL + "\t\tMessageHeader* getBufferedMessage(){" + NL + "\t\t\t//synchronized(lock) " + NL + "\t\t\t{" + NL + "\t\t\t\tif (msgPool->size()>0){" + NL + "\t\t\t\t\tMessageHeader* msg = msgPool->front();" + NL + "\t\t\t\t\tmsgPool->pop();" + NL + "\t\t\t\t\treturn msg;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn NULL;" + NL + "\t\t}" + NL + "" + NL + "\t\tvoid poolMessage(MessageHeader* buffer){" + NL + "\t\t\tmsgPool->push(buffer);" + NL + "\t\t}" + NL + "" + NL + "\t\tvoid execute() {" + NL + "\t\t\t\twhile(!msgQueue->empty()) {" + NL + "\t\t\t\t\tMessageHeader* msg = msgQueue->front();" + NL + "\t\t\t\t\tmsgQueue->pop();" + NL + "\t\t\t\t\tmsgDispatcher.publish(msg);" + NL + "\t\t\t\t\tpoolMessage(msg);" + NL + "\t\t\t\t}" + NL + "\t\t}" + NL + "\t\t/*" + NL + "\t\tvoid execute(void* thisVoidPtr) {" + NL + "\t\t\tMessageService* thisPtr = static_cast<MessageService*>(thisVoidPtr);" + NL + "\t\t\twhile(true) {" + NL + "\t\t\t\twhile(!msgQueue->empty()) {" + NL + "\t\t\t\t\tMessageHeader* msg = thisPtr->msgQueue->front();" + NL + "\t\t\t\t\tthisPtr->msgQueue->pop();" + NL + "\t\t\t\t\tthisPtr->msgDispatcher.publish(msg);" + NL + "\t\t\t\t\tthisPtr->poolMessage(msg);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tthisPtr->executeThread->wait();" + NL + "\t\t\t}" + NL + "\t\t}*/" + NL + "};" + NL;
  protected final String TEXT_3 = " event ";
  protected final String TEXT_4 = "case ";
  protected final String TEXT_5 = "::";
  protected final String TEXT_6 = "_";
  protected final String TEXT_7 = ":" + NL + "\tif(sizeof(msg->data) >= sizeof(";
  protected final String TEXT_8 = ")) {";
  protected final String TEXT_9 = NL + "\t\t";
  protected final String TEXT_10 = "_event.publish(data);" + NL + "\t} else {" + NL + "\t\tthrow \"Bad port data\";" + NL + "\t}" + NL + "\tbreak;";
  protected final String TEXT_11 = "\t\t" + NL + "\t\t";
  protected final String TEXT_12 = " data = *((";
  protected final String TEXT_13 = "*) msg->data);";
  protected final String TEXT_14 = "\t\t" + NL + "\t\t";
  protected final String TEXT_15 = "* messageData = new ";
  protected final String TEXT_16 = "();" + NL + "\t\t";
  protected final String TEXT_17 = "* data =  messageData->deserialize(*((";
  protected final String TEXT_18 = "**) msg->data));" + NL + "\t\t";
  protected final String TEXT_19 = " data = *((";
  protected final String TEXT_20 = "*) msg->data);";
  protected final String TEXT_21 = NL + "\tpublic:" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t" + NL + "\t\t//------------------------" + NL + "\t\t// CONSTRUCTOR" + NL + "\t\t//------------------------" + NL + "\t\t";
  protected final String TEXT_23 = "_PortProtocol();" + NL + "\t" + NL + "\t\t//------------------------" + NL + "\t\t// DESTRUCTOR" + NL + "\t\t//------------------------" + NL + "\t\tvirtual ~";
  protected final String TEXT_24 = "_PortProtocol();" + NL + "" + NL + "\t\tstring get";
  protected final String TEXT_25 = "EventFullName(void);" + NL + "\t\t";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + NL + "\tprivate:" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_28 = " ";
  protected final String TEXT_29 = ";" + NL + "\t\t";
  protected final String TEXT_30 = " ";
  protected final String TEXT_31 = ";" + NL + "\t\tMessageService* service;" + NL + "\t\t\t" + NL + "\t\tvoid sendMessage(short int portId,short int evtId, int size, void* data);" + NL + "\t\tvoid receive_";
  protected final String TEXT_32 = "_PortProtocol_Message(const MessageHeader* msg);" + NL;
  protected final String TEXT_33 = NL + "#define ";
  protected final String TEXT_34 = "_BODY" + NL + "" + NL + "#if defined( PRAGMA ) && ! defined( PRAGMA_IMPLEMENTED )" + NL + "#pragma implementation <";
  protected final String TEXT_35 = ".h>" + NL + "#endif";
  protected final String TEXT_36 = NL + "//------------------------" + NL + "// CONSTRUCTOR IMPLEMENTATION" + NL + "//------------------------";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = "_PortProtocol::";
  protected final String TEXT_39 = "_PortProtocol() {" + NL + "\tservice = new MessageService(this, &";
  protected final String TEXT_40 = "_PortProtocol::receive_";
  protected final String TEXT_41 = "_PortProtocol_Message);" + NL + "}" + NL + "\t\t";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = "_PortProtocol::~";
  protected final String TEXT_44 = "_PortProtocol() {" + NL + "\tdelete service;" + NL + "}" + NL + "" + NL + "string ";
  protected final String TEXT_45 = "_PortProtocol::get";
  protected final String TEXT_46 = "EventFullName(void){" + NL + "\tstring answer = ";
  protected final String TEXT_47 = "_Event;" + NL + "\treturn answer;" + NL + "}" + NL + "\t\t";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = "\t\t" + NL + "" + NL + "void ";
  protected final String TEXT_50 = "_PortProtocol::sendMessage(short int portId,short int evtId, int size, void* data) {" + NL + "\tMessageHeader* msg = service->getBufferedMessage();" + NL + "\tif (msg!=NULL) {" + NL + "\t\tmsg->portId = portId;" + NL + "\t\tmsg->eventId = evtId;" + NL + "\t\tif (size>0 && data!=NULL) {" + NL + "\t\t\tmsg->data = malloc(size);" + NL + "     \t\tmemcpy(msg->data, data, size);" + NL + "\t\t}" + NL + "\t\tservice->push(msg);" + NL + "\t}" + NL + "}" + NL + "\t\t" + NL + "void ";
  protected final String TEXT_51 = "_PortProtocol::receive_";
  protected final String TEXT_52 = "_PortProtocol_Message(const MessageHeader* msg){" + NL + "\tswitch(msg->eventId){";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL + NL + "\t\tdefault:" + NL + "\t\t\tbreak;" + NL + "\t}" + NL + "}" + NL + ";\t";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = NL;
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = "_Event";
  protected final String TEXT_59 = "_Event";
  protected final String TEXT_60 = "_Port";
  protected final String TEXT_61 = "_Port";
  protected final String TEXT_62 = "\t";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = "::";
  protected final String TEXT_65 = ";";
  protected final String TEXT_66 = "\t";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = "::";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = ";" + NL + "\tsendMessage(";
  protected final String TEXT_71 = "::";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = "::";
  protected final String TEXT_74 = "_";
  protected final String TEXT_75 = ", sizeof(";
  protected final String TEXT_76 = "), &data);";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = "->";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ".subscribe(";
  protected final String TEXT_81 = ", &";
  protected final String TEXT_82 = "::";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = "->";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = ".subscribe(";
  protected final String TEXT_88 = ", &";
  protected final String TEXT_89 = "::";
  protected final String TEXT_90 = ");";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = ".disconnect(";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = "(data);";
  protected final String TEXT_96 = "this->disconnectPortConnections();";
  protected final String TEXT_97 = "this->initPortConnections();";
  protected final String TEXT_98 = "_Handle";
  protected final String TEXT_99 = "_BindingHandle";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = ".subscribe(this, &";
  protected final String TEXT_103 = "::";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = "_event";
  protected final String TEXT_106 = "Event<void, ";
  protected final String TEXT_107 = "> ";
  protected final String TEXT_108 = ";";
  protected final String TEXT_109 = "receive_";
  protected final String TEXT_110 = "_Data";
  protected final String TEXT_111 = "//Composite structure variables";
  protected final String TEXT_112 = "_PortProtocol";
  protected final String TEXT_113 = NL + "#ifndef ";
  protected final String TEXT_114 = "_H" + NL + "#define ";
  protected final String TEXT_115 = "_H" + NL + "" + NL + "#ifdef PRAGMA" + NL + "#pragma once" + NL + "#ifndef _MSC_VER" + NL + "#pragma interface \"";
  protected final String TEXT_116 = ".h\"" + NL + "#endif" + NL + "#endif";
  protected final String TEXT_117 = NL;
  protected final String TEXT_118 = " {";
  protected final String TEXT_119 = NL;
  protected final String TEXT_120 = NL + "};";
  protected final String TEXT_121 = NL;
  protected final String TEXT_122 = NL + NL + "#endif";
  protected final String TEXT_123 = NL;
  protected final String TEXT_124 = "_Message_Descriptor";
  protected final String TEXT_125 = "_Message";
  protected final String TEXT_126 = "//Message descriptor for ";
  protected final String TEXT_127 = "* msg = new ";
  protected final String TEXT_128 = "();";
  protected final String TEXT_129 = "msg->";
  protected final String TEXT_130 = " = ";
  protected final String TEXT_131 = "->";
  protected final String TEXT_132 = "();";
  protected final String TEXT_133 = "->";
  protected final String TEXT_134 = "(msg->";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL + "#define ";
  protected final String TEXT_137 = "_BODY" + NL + "" + NL + "#if defined( PRAGMA ) && ! defined( PRAGMA_IMPLEMENTED )" + NL + "#pragma implementation <";
  protected final String TEXT_138 = ".h>" + NL + "#endif";
  protected final String TEXT_139 = NL + NL + "//------------------------" + NL + "// CONSTRUCTOR IMPLEMENTATION" + NL + "//------------------------";
  protected final String TEXT_140 = NL;
  protected final String TEXT_141 = "::";
  protected final String TEXT_142 = "() {" + NL + "\t//Empty constructor" + NL + "}" + NL + "\t\t";
  protected final String TEXT_143 = NL;
  protected final String TEXT_144 = "::~";
  protected final String TEXT_145 = "() {" + NL + "}" + NL;
  protected final String TEXT_146 = NL;
  protected final String TEXT_147 = "* ";
  protected final String TEXT_148 = "::serialize(";
  protected final String TEXT_149 = " ";
  protected final String TEXT_150 = "){";
  protected final String TEXT_151 = NL;
  protected final String TEXT_152 = NL + "\treturn msg;" + NL + "}" + NL + "\t\t" + NL + "void ";
  protected final String TEXT_153 = "::deserialize(";
  protected final String TEXT_154 = " ";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = "* msg) {";
  protected final String TEXT_157 = NL;
  protected final String TEXT_158 = NL + "}" + NL + "\t\t" + NL + ";\t";
  protected final String TEXT_159 = NL;
  protected final String TEXT_160 = NL;
  protected final String TEXT_161 = NL;
  protected final String TEXT_162 = NL + "\tpublic:" + NL + "\t\t" + NL + "\t\t//------------------------" + NL + "\t\t// CONSTRUCTOR" + NL + "\t\t//------------------------" + NL + "\t\t";
  protected final String TEXT_163 = "_Message();" + NL + "\t" + NL + "\t\t//------------------------" + NL + "\t\t// DESTRUCTOR" + NL + "\t\t//------------------------" + NL + "\t\tvirtual ~";
  protected final String TEXT_164 = "_Message();" + NL + "" + NL + "\t\t";
  protected final String TEXT_165 = "* serialize(";
  protected final String TEXT_166 = " ";
  protected final String TEXT_167 = ");" + NL + "\t\tvoid deserialize(";
  protected final String TEXT_168 = " ";
  protected final String TEXT_169 = ", ";
  protected final String TEXT_170 = "* ";
  protected final String TEXT_171 = ");";
  protected final String TEXT_172 = "\t\t\t";
  protected final String TEXT_173 = NL + NL + "\tprivate:" + NL;
  protected final String TEXT_174 = NL;
  protected final String TEXT_175 = "\t\t\t" + NL;

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
getRegistry().define(ICppStructureDefinitions.PUBLISH_SUBSCRIBE_API, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {

    stringBuffer.append(TEXT_2);
    

}});

}});

getRegistry().define(ICppStructureDefinitions.PORT_EVENT_ENUM_DESCRIPTION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String direction;
	@GenerationArgument String portName;
	
@Override
public void execute() {


String directionString= "OUT".equals(direction)? "Output": "In";
String directionToOrFrom= ("OUT".equals(direction)? "from": "to")+ " "+ portName;


    stringBuffer.append(directionString);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(directionToOrFrom);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationProcedureParameter(id= IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType;

	@GenerationArgument Object parent;
	@GenerationArgument String portName;
	@GenerationArgument String direction;
	@GenerationArgument String type;
	
@Override
public void execute() {

String portEventType= getRegistry().generate(IStructureConstants.PORT_EVENT_TYPE, parent);


    stringBuffer.append(TEXT_4);
    stringBuffer.append(portEventType);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(direction);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_8);
    setData();
    stringBuffer.append(TEXT_9);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_10);
    

}

private void setData(){

if(true|| isPrimitiveType){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_13);
    
return;
}

String descirptorStructName= getRegistry().generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_NAME, parent);
String protocolMesageName= getRegistry().generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_NAME, parent);


    stringBuffer.append(TEXT_14);
    stringBuffer.append(protocolMesageName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(protocolMesageName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(descirptorStructName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(descirptorStructName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_20);
    
}


});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_HEADER_CONTENTS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationProcedureParameter(id = ICppStructureDefinitions.PORT_EVENT_IMPLEMENTATIONS_ATTRIBUTES) String portEventAttributes;
	@GenerationProcedureParameter(id = ICppStructureDefinitions.PORT_EVENT_DECLARATIONS) String portEventDeclarations;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_21);
    stringBuffer.append(StringUtil.indent(portEventAttributes,2));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(StringUtil.indent(portEventDeclarations,2));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_EVENT_TYPE, element));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_EVENT_NAME, element));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_TYPE, element));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_NAME, element));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_32);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_BODY_CONTENTS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationProcedureParameter(id = ICppStructureDefinitions.PORT_EVENT_IMPLEMENTATIONS) String portEventImplementations;
	@GenerationProcedureParameter(id = ICppStructureDefinitions.PORT_PROTOCOL_IMPLEMENTATION_EVENT_CASES) String portEventCases;
	@GenerationProcedureParameter(id = IModelingConstants.FULL_PATH) String fullPath;
		

	@GenerationProcedureParameter(id = ICppDefinitions.PRE_PROCESSING_DEFINITION_NAME) String fullName;
	
	@GenerationArgument Object protocol;
	@GenerationArgument String bodyIncludes;
	
	String namespaceOpening;
	String namespaceClosing;
	
	@GenerationProcedureParameter(id = IModelingConstants.COPY_RIGHT) String copyRight;
	@GenerationProcedureParameter(id = ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS) String preProcessorDefnitionUse;
	
@Override
public void execute() {

namespaceOpening= getRegistry().generationPointString(protocol, ICppDefinitions.NAMESPACE_OPENING, Boolean.TRUE);
namespaceClosing= getRegistry().generationPointString(protocol, ICppDefinitions.NAMESPACE_CLOSING, Boolean.TRUE);


    stringBuffer.append(copyRight);
    stringBuffer.append(TEXT_33);
    stringBuffer.append( fullName );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(fullPath);
    stringBuffer.append(TEXT_35);
    safeSet(bodyIncludes);
    safeSet(preProcessorDefnitionUse);
    stringBuffer.append(namespaceOpening);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(StringUtil.firstCharacterToLowerCase(name));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(portEventImplementations);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(StringUtil.indent(portEventCases,2));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(namespaceClosing);
    

}

private void safeSet(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_56);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_57);
    

}

});

}});

getRegistry().define(IStructureConstants.PORT_EVENT_TYPE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_58);
    

}});

}

});

getRegistry().define(IStructureConstants.PORT_EVENT_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
@Override
public void execute() {


    stringBuffer.append(StringUtil.firstCharacterToLowerCase(name));
    stringBuffer.append(TEXT_59);
    

}});

}

});

getRegistry().define(IStructureConstants.PORT_TYPE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_60);
    

}});

}

});

getRegistry().define(IStructureConstants.PORT_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
@Override
public void execute() {


    stringBuffer.append(StringUtil.firstCharacterToLowerCase(name));
    stringBuffer.append(TEXT_61);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_EVENT_ENTRY_ASSIGN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String portName;
	
@Override
public void execute() {



    stringBuffer.append(TEXT_62);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_NAME, element));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_TYPE, element));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_65);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_EVENT_ENTRY_INVOCATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String portName;
	@GenerationArgument String direction;
	@GenerationArgument String type;
	
@Override
public void execute() {



    stringBuffer.append(TEXT_66);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_EVENT_NAME, element));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_EVENT_TYPE, element));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(direction);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_TYPE, element));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(getRegistry().generate(IStructureConstants.PORT_EVENT_TYPE, element));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(direction);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_76);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_BINDING_CONNECT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	@GenerationArgument String fromSubComponentName;
	@GenerationArgument String fromSubComponentType;
	@GenerationArgument String fromPortName;
	@GenerationArgument String toSubComponentName;
	@GenerationArgument Object toSubComponentObject;
	@GenerationArgument String owingClass;
	@GenerationArgument String toPortName;

	
	@GenerationArgument Object parent;
	@GenerationArgument String context;
	@GenerationArgument String handleVariableGetter;
	
@Override
public void execute() {
String portName= fromPortName+ CommonConstants.UNDERSCORE+ toPortName;

String handle= getRegistry().use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLE_BINDING_DEFAULT_NAME, portName);
String protocolClassName= StringUtil.firstCharacterToLowerCase(fromSubComponentType)+ "_PortProtocol";
String event= getRegistry().use(ICppStructureDefinitions.PORT_PROTOCOL_EVENT_DEFAULT_NAME, fromPortName);



    stringBuffer.append(handle);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(fromSubComponentName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(protocolClassName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(event);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(toSubComponentName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(owingClass);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(toPortName);
    stringBuffer.append(TEXT_83);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_BINDING_CONNECT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	@GenerationArgument String fromSubComponentName;
	@GenerationArgument String fromSubComponentType;
	@GenerationArgument String fromPortName;
	@GenerationArgument String toSubComponentName;
	@GenerationArgument String owingClass;
	@GenerationArgument String toPortName;

	
@Override
public void execute() {
String portName= fromPortName+ CommonConstants.UNDERSCORE+ toPortName;

String handle= getRegistry().use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLE_BINDING_DEFAULT_NAME, portName);
String protocolClassName= StringUtil.firstCharacterToLowerCase(fromSubComponentType)+ "_PortProtocol";
String event= getRegistry().use(ICppStructureDefinitions.PORT_PROTOCOL_EVENT_DEFAULT_NAME, fromPortName);



    stringBuffer.append(handle);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(fromSubComponentName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(protocolClassName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(event);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(toSubComponentName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(owingClass);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(toPortName);
    stringBuffer.append(TEXT_90);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_DISCONNECT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String portName;
	@GenerationArgument Object parent;
	
@Override
public void execute() {

String protocolClassName= getRegistry().generate(ICppStructureDefinitions.PORT_PROTOCOL_DEFAULT_VARIABLE_NAME, parent);
String handle= getRegistry().use(ICppStructureDefinitions.PORT_PROTOCOL_HANDLE_DEFAULT_NAME, portName);
String event= getRegistry().use(ICppStructureDefinitions.PORT_PROTOCOL_EVENT_DEFAULT_NAME, portName);


    stringBuffer.append(protocolClassName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(event);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(handle);
    stringBuffer.append(TEXT_93);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_SEND_TO_CONTENTS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String portName;
	@GenerationArgument Object parent;
	
@Override
public void execute() {

String protocolClassName= getRegistry().generate(ICppStructureDefinitions.PORT_PROTOCOL_DEFAULT_VARIABLE_NAME, parent);


    stringBuffer.append(protocolClassName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_95);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_DESTRUCTOR, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(TEXT_96);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_CONSTRUCTOR, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(TEXT_97);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_HANDLE_DEFAULT_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String portName;
	
@Override
public void execute() {


    stringBuffer.append(portName);
    stringBuffer.append(TEXT_98);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_HANDLE_BINDING_DEFAULT_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String portName;
	
@Override
public void execute() {


    stringBuffer.append(portName);
    stringBuffer.append(TEXT_99);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_HANDLER_EVENT_CONNECT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String portName;
	@GenerationArgument Object parent;
	@GenerationArgument String handleVariableGetter;
	
@Override
public void execute() {

String protocolClassName= getRegistry().generate(ICppStructureDefinitions.PORT_PROTOCOL_DEFAULT_VARIABLE_NAME, parent);
String parentName= getRegistry().getString(parent, IModelingElementDefinitions.NAME);
String receiveMethodName= getRegistry().use(ICppStructureDefinitions.PORT_PROTOCOL_EVENT_RECEIVE_DATA_METHOD_NAME, portName);
String handle= getRegistry().use(handleVariableGetter== null|| handleVariableGetter.isEmpty()?ICppStructureDefinitions.PORT_PROTOCOL_HANDLE_DEFAULT_NAME: handleVariableGetter, portName);
String event= getRegistry().use(ICppStructureDefinitions.PORT_PROTOCOL_EVENT_DEFAULT_NAME, portName);
 

    stringBuffer.append(handle);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(protocolClassName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(event);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(receiveMethodName);
    stringBuffer.append(TEXT_104);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_EVENT_DEFAULT_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String portName;
	
@Override
public void execute() {


    stringBuffer.append(portName);
    stringBuffer.append(TEXT_105);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_IMPLEMENTATION_PORT_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String portName;
	@GenerationArgument String typeName;
	
@Override
public void execute() {

String eventMethodName= getRegistry().use(ICppStructureDefinitions.PORT_PROTOCOL_EVENT_DEFAULT_NAME, portName);


    stringBuffer.append(TEXT_106);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(eventMethodName);
    stringBuffer.append(TEXT_108);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_EVENT_RECEIVE_DATA_METHOD_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument Object portName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_109);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_110);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_DEFAULT_VARIABLE_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {

String protocolClass = getRegistry().generate(ICppStructureDefinitions.PORT_CLASS_NAME, element);
String protocolClassName= StringUtil.firstCharacterToLowerCase(protocolClass);
		

    stringBuffer.append(protocolClassName);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_DEFAULT_SEND_TO_NAME, new GenerationProcdure(this){

	@GenerationArgument Object portName;
		
@Override
public StringBuffer execute(Object element, Object... arguments) {

return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(portName);
    

}});

}

});

getRegistry().define(IStructureConstants.PORT_PROTOCOL_DESCRIPTION_COMMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(TEXT_111);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_CLASS_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_112);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PROTOCOL_CLASS_HEADER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument Object parent;
	@GenerationArgument String contents;
	@GenerationArgument String definitionFullPath;
	@GenerationArgument String className;
	@GenerationArgument(id= ICppDefinitions.INTERNAL_DEFINED_TYPES) String internalDefinedTypes;
	
	String namespaceOpening;
	String namespaceClosing;
	String fullPath;
	String classDeclarations;
	
	@GenerationProcedureParameter(id = ICppDefinitions.INCLUDES) String includes;
	@GenerationProcedureParameter(id = IModelingConstants.COPY_RIGHT) String copyRight;
	@GenerationProcedureParameter(id = ICppDefinitions.INCOMPLETE_TYPES_DEFNITION) String incompleteTypes;
	@GenerationProcedureParameter(id = ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS) String preProcessorDefnitionUse;
			
@Override
public void execute() {
namespaceOpening= getRegistry().generationPointString(parent, ICppDefinitions.NAMESPACE_OPENING, Boolean.TRUE);
namespaceClosing= getRegistry().generationPointString(parent, ICppDefinitions.NAMESPACE_CLOSING, Boolean.TRUE);
fullPath= getRegistry().generationPointString(parent, IModelingConstants.FULL_PATH)+ "_"+ className;
classDeclarations= getRegistry().generationPointString(parent, IModelingConstants.CLASS_DECLARATIONS)+ "_"+ className;


    stringBuffer.append(copyRight);
    stringBuffer.append(TEXT_113);
    stringBuffer.append( definitionFullPath );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( definitionFullPath );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(fullPath);
    stringBuffer.append(TEXT_116);
    safeSet(includes);
    safeSet(preProcessorDefnitionUse);
    safeSet(namespaceOpening);
    safeSet(incompleteTypes);
    safeSet(internalDefinedTypes);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(classDeclarations);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(contents);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(namespaceClosing);
    stringBuffer.append(TEXT_122);
    

}

private void safeSet(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(val);
    stringBuffer.append(TEXT_123);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_NAME, new GenerationProcdure(this){

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
		
@Override
public StringBuffer execute(Object element, Object... arguments) {

return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_124);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_NAME, new GenerationProcdure(this){

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
		
@Override
public StringBuffer execute(Object element, Object... arguments) {

return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_125);
    

}});

}

});


getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_COMMENT, new GenerationProcdure(this){

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
		
@Override
public StringBuffer execute(Object element, Object... arguments) {

return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(TEXT_126);
    stringBuffer.append(name);
    

}});

}

});


getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_CONSTRUCTOR, new GenerationProcdure(this){

@Override
public StringBuffer execute(Object element, Object... arguments) {

return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {

String descirptorStructName= getRegistry().generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_NAME, element);


    stringBuffer.append(descirptorStructName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(descirptorStructName);
    stringBuffer.append(TEXT_128);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_GETTER_ASSIGN, new GenerationProcdure(this){

	@GenerationArgument String name;
	@GenerationArgument String attributeName;
	@GenerationArgument String getterMethod;
		
@Override
public StringBuffer execute(Object element, Object... arguments) {

return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {

String variableName= StringUtil.firstCharacterToLowerCase(name);


    stringBuffer.append(TEXT_129);
    stringBuffer.append(attributeName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(variableName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(getterMethod);
    stringBuffer.append(TEXT_132);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_SETTER_ASSIGN, new GenerationProcdure(this){

	@GenerationArgument String name;
	@GenerationArgument String attributeName;
	@GenerationArgument String setterMethod;
		
@Override
public StringBuffer execute(Object element, Object... arguments) {

return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {

String variableName= StringUtil.firstCharacterToLowerCase(name);


    stringBuffer.append(variableName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(setterMethod);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(attributeName);
    stringBuffer.append(TEXT_135);
    

}});

}

});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_BODY_CONTENTS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType;
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
	@GenerationArgument Object parent;
	@GenerationArgument String bodyIncludes;
	@GenerationArgument String className;
	@GenerationArgument String fullName;
	
	@GenerationArgument String serializeContents;
	@GenerationArgument String deserializeContents;
		
	String fullPath;
	String namespaceOpening;
	String namespaceClosing;
	
	
	@GenerationProcedureParameter(id = IModelingConstants.COPY_RIGHT) String copyRight;
	@GenerationProcedureParameter(id = ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS) String preProcessorDefnitionUse;
	
@Override
public void execute() {

String normalizedTypeName = StringUtil.firstCharacterToLowerCase(name);
namespaceOpening= getRegistry().generationPointString(parent, ICppDefinitions.NAMESPACE_OPENING, Boolean.TRUE);
namespaceClosing= getRegistry().generationPointString(parent, ICppDefinitions.NAMESPACE_CLOSING, Boolean.TRUE);
fullPath= getRegistry().generationPointString(parent, IModelingConstants.FULL_PATH)+ "_"+ className;

String descirptorStructName= getRegistry().generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_NAME, element);


    stringBuffer.append(copyRight);
    stringBuffer.append(TEXT_136);
    stringBuffer.append( fullName );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(fullPath);
    stringBuffer.append(TEXT_138);
    safeSet(bodyIncludes);
    safeSet(preProcessorDefnitionUse);
    stringBuffer.append(namespaceOpening);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(descirptorStructName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(normalizedType);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(normalizedTypeName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(StringUtil.indent(serializeContents,1));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(normalizedType);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(normalizedTypeName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(descirptorStructName);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(StringUtil.indent(deserializeContents,1));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(namespaceClosing);
    

}

private void safeSet(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_160);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_161);
    

}

});

}});

getRegistry().define(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_CLASS_CONTENTS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String privateContents;
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType;
	
@Override
public void execute() {

String normalizedTypeName = StringUtil.firstCharacterToLowerCase(name);
String descirptorStructName= getRegistry().generate(ICppStructureDefinitions.PORT_PROTOCOL_MESSAGE_DESCRIPTOR_NAME, element);


    stringBuffer.append(TEXT_162);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(descirptorStructName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(normalizedType);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(normalizedTypeName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(normalizedType);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(normalizedTypeName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(descirptorStructName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(StringUtil.firstCharacterToLowerCase(descirptorStructName));
    stringBuffer.append(TEXT_171);
    safeSet(privateContents);
    stringBuffer.append(TEXT_172);
    

}

private void safeSet(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_173);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(StringUtil.indent(val,2));
    stringBuffer.append(TEXT_175);
    

}

});

}

});


    return stringBuffer.toString();
  }
}