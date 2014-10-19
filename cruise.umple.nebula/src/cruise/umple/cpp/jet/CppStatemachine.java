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

@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppStatemachine extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppStatemachine create(String lineSeparator)
  {
    nl = lineSeparator;
    CppStatemachine result = new CppStatemachine();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "if(";
  protected final String TEXT_3 = "!= ";
  protected final String TEXT_4 = "::NIL){" + NL + "\t";
  protected final String TEXT_5 = "H = ";
  protected final String TEXT_6 = ";" + NL + "}";
  protected final String TEXT_7 = "set";
  protected final String TEXT_8 = NL + "Thread::sleep(1);";
  protected final String TEXT_9 = "get";
  protected final String TEXT_10 = "FullName";
  protected final String TEXT_11 = "string answer = ";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + "return answer;";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL + "if (";
  protected final String TEXT_16 = " != ";
  protected final String TEXT_17 = "::NIL) { " + NL + "\tanswer += \".\" + ";
  protected final String TEXT_18 = "; " + NL + "}";
  protected final String TEXT_19 = "(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = "::";
  protected final String TEXT_22 = "a";
  protected final String TEXT_23 = "exit";
  protected final String TEXT_24 = "enter";
  protected final String TEXT_25 = "();";
  protected final String TEXT_26 = "wasEventProcessed= ";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = "()";
  protected final String TEXT_29 = "\t\t" + NL + "\t\tenum ";
  protected final String TEXT_30 = " { ";
  protected final String TEXT_31 = " };";
  protected final String TEXT_32 = "::";
  protected final String TEXT_33 = "bool wasEventProcessed = false;";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = NL + "return wasEventProcessed;";
  protected final String TEXT_36 = "//";
  protected final String TEXT_37 = " State Machines";
  protected final String TEXT_38 = "\t\t" + NL + "\t\tvoid ";
  protected final String TEXT_39 = "(";
  protected final String TEXT_40 = " a";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = "\t\t" + NL + "\t\tbool ";
  protected final String TEXT_43 = "();";
  protected final String TEXT_44 = "\t\t" + NL + "bool ";
  protected final String TEXT_45 = "(){" + NL + "\tbool wasEventProcessed = false;";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = NL + "\treturn wasEventProcessed;" + NL + "}";
  protected final String TEXT_48 = "\t" + NL + "switch((int)";
  protected final String TEXT_49 = "){";
  protected final String TEXT_50 = NL + "\tdefault:" + NL + "\t\t// Other states do respond to this event" + NL + "\t\tbreak;" + NL + "}" + NL + "\t\t";
  protected final String TEXT_51 = "if(";
  protected final String TEXT_52 = "== ";
  protected final String TEXT_53 = "::";
  protected final String TEXT_54 = "){" + NL + "\t";
  protected final String TEXT_55 = "(";
  protected final String TEXT_56 = "::";
  protected final String TEXT_57 = ");" + NL + "}";
  protected final String TEXT_58 = "// entry actions and do activities";
  protected final String TEXT_59 = "Thread";
  protected final String TEXT_60 = "thisVoidPtr";
  protected final String TEXT_61 = "* thisPtr = static_cast<";
  protected final String TEXT_62 = "*>(thisVoidPtr);" + NL + "thisPtr->";
  protected final String TEXT_63 = "();";
  protected final String TEXT_64 = "doActivity";
  protected final String TEXT_65 = "this->";
  protected final String TEXT_66 = " = new Thread(&";
  protected final String TEXT_67 = "::";
  protected final String TEXT_68 = ", this, \"";
  protected final String TEXT_69 = "\");" + NL + "this->";
  protected final String TEXT_70 = "->start();";
  protected final String TEXT_71 = "{";
  protected final String TEXT_72 = NL;
  protected final String TEXT_73 = NL + "}";
  protected final String TEXT_74 = "\t\t" + NL + "if (";
  protected final String TEXT_75 = " != NULL) { " + NL + "\t";
  protected final String TEXT_76 = "->stop(); " + NL + "}";
  protected final String TEXT_77 = "\t\t" + NL + "\t\t//";
  protected final String TEXT_78 = "= new ";
  protected final String TEXT_79 = "(); ";
  protected final String TEXT_80 = " a";
  protected final String TEXT_81 = "= ";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = "\t\t" + NL + "\t";
  protected final String TEXT_84 = " a";
  protected final String TEXT_85 = "= ";
  protected final String TEXT_86 = ";";
  protected final String TEXT_87 = NL + "case ";
  protected final String TEXT_88 = "::";
  protected final String TEXT_89 = ":";
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = NL + "\tbreak;" + NL + "\t\t\t";
  protected final String TEXT_92 = "wasEventProcessed = true;";

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
getRegistry().define(ICppStatemachinesDefinitions.HISTORY_STATE_CHECK, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String qualifiedName;
	@GenerationArgument String qualifiedType;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(qualifiedName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(qualifiedType);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(qualifiedName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(qualifiedName);
    stringBuffer.append(TEXT_6);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATES_SETTER_NAME_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(enumName));
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.DO_ACTIVITY_BODY_WRAP, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String body;
			
@Override
public void execute() {

    stringBuffer.append(body);
    stringBuffer.append(TEXT_8);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMACHINE_FULL_PATH, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(enumName));
    stringBuffer.append(TEXT_10);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMACHINE_FULL_PATH_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String statemachine;
	@GenerationArgument String body;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(statemachine);
    stringBuffer.append(TEXT_12);
    setBody();
    stringBuffer.append(TEXT_13);
    

}

private void setBody(){
	if(body.isEmpty()){
		return;
	}


    stringBuffer.append(TEXT_14);
    stringBuffer.append(body);
    

}

});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMACHINE_FULL_PATH_SEGMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String nestedType;
	@GenerationArgument String nestedTypeInstance;
	
			
@Override
public void execute() {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(nestedTypeInstance);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(nestedType);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(nestedTypeInstance);
    stringBuffer.append(TEXT_18);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.INVOKE_STATES_SETTER_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String setter;
	@GenerationArgument String type;
	@GenerationArgument String targetState;
			
@Override
public void execute() {


    stringBuffer.append(setter);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(type);
    safeSet();
    stringBuffer.append(TEXT_20);
    

}

private void safeSet(){
if(targetState== null|| targetState.isEmpty()){
	return;
}


    stringBuffer.append(TEXT_21);
    stringBuffer.append(targetState);
    

}

});

}});

getRegistry().define(ICppStatemachinesDefinitions.VARIABLE_INSTANCE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMCHAINE_EXIT_PROCEDURE_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(enumName));
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMCHAINE_ENTER_PROCEDURE_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(enumName));
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.PROCEDURE_CALL_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String procedureName;
			
@Override
public void execute() {

    stringBuffer.append(procedureName);
    stringBuffer.append(TEXT_25);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.PROCEDURE_CALL_AND_CHECK_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String procedureName;
	@GenerationArgument boolean isImvocation;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(procedureName);
    isInvocation();
    stringBuffer.append(TEXT_27);
    
}

private void isInvocation(){
	if(!isImvocation){
		return;
	}
	
    stringBuffer.append(TEXT_28);
    	
}

});

}});

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

getRegistry().define(ICppStatemachinesDefinitions.ENUM, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumName;
	@GenerationArgument String values;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(values);
    stringBuffer.append(TEXT_31);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.ENUM_USE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumType;
	@GenerationArgument String value;
	
@Override
public void execute() {


    stringBuffer.append(enumType);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(value);
    

}});

}});


getRegistry().define(ICppStatemachinesDefinitions.STATEMACHINE_METHOD_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument Object body;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_35);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.ENUM+ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_37);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATUS_SETTER_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String setter;
	@GenerationArgument String enumName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(setter);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_41);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMCHAINE_EXIT_PROCEDURE_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String exitProcedureName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(exitProcedureName);
    stringBuffer.append(TEXT_43);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMCHAINE_EXIT_PROCEDURE_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String exitProcedureName;
	@GenerationArgument String owner;
	@GenerationArgument String body;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(owner);
    stringBuffer.append(exitProcedureName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_47);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMCHAINE_ENTRY_EXIT_PROCEDURE_STATE_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String stateName;
	@GenerationArgument String body;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(stateName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(StringUtil.indent(body,1));
    stringBuffer.append(TEXT_50);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMCHAINE_NESTED_STATE_BODY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumVariable;
	@GenerationArgument String enumState;
	@GenerationArgument String enumName;
	@GenerationArgument String setterName;
	@GenerationArgument String enumNextState;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(enumVariable);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(enumState);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(setterName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(enumNextState);
    stringBuffer.append(TEXT_57);
    
}});

}

});

getRegistry().define(ICppStatemachinesDefinitions.SETTER_SWITCH_COMMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this) {
	
@Override
public void execute() {

    stringBuffer.append(TEXT_58);
    
}});

}
});

getRegistry().define(ICppStatemachinesDefinitions.THREAD_INSTANCE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(StringUtil.firstCharacterToLowerCase(name));
    stringBuffer.append(TEXT_59);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.VOID_POINTER_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_60);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.DO_ACTIVITY_MEDIATOR_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String doActivity;
	
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(doActivity);
    stringBuffer.append(TEXT_63);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.DO_ACTIVITY_METHOD_INSTANCE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_64);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.DO_ACTIVITY_FUNCTION_POINTER_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String owner;
	@GenerationArgument String functionPointer;
	@GenerationArgument String threadInstance;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_65);
    stringBuffer.append(threadInstance);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(owner);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(functionPointer);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(functionPointer);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(threadInstance);
    stringBuffer.append(TEXT_70);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.DO_ACTIVITY_FUNCTION_WRAP, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String threadInstance;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_71);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(StringUtil.indent(threadInstance,1));
    stringBuffer.append(TEXT_73);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMCHAINE_THREAD_USE_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String threadCallback;
			
@Override
public void execute() {
if(threadCallback== null|| threadCallback.isEmpty()){
	return;
}
	

    stringBuffer.append(TEXT_74);
    stringBuffer.append(threadCallback);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(threadCallback);
    stringBuffer.append(TEXT_76);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMCHAINE_THREAD_CONSTRUCTOR_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String threadCallback;
			
@Override
public void execute() {
if(threadCallback== null|| threadCallback.isEmpty()){
	return;
}
	

    stringBuffer.append(TEXT_77);
    stringBuffer.append(threadCallback);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(threadCallback);
    stringBuffer.append(TEXT_79);
    
}});

}});


getRegistry().define(ICppStatemachinesDefinitions.ENUM_VARIABLE_PLACEHOLDER_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String shortenedType;
	@GenerationArgument String enumType;
	@GenerationArgument String name;
			
@Override
public void execute() {

    stringBuffer.append(shortenedType);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(enumType);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_82);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.ENUM_VARIABLE_ASSIGMENT_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
	@GenerationArgument String enumType;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(enumType);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(enumType);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_86);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMACHINE_SWITCH_CASE_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String enumType;
	@GenerationArgument String sourceState;
	@GenerationArgument String body;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_87);
    stringBuffer.append(enumType);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(sourceState);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(StringUtil.indent(body,1));
    stringBuffer.append(TEXT_91);
    

}});

}

});

getRegistry().define(ICppStatemachinesDefinitions.STATEMACHINE_PROCESSED_CASE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this) {
	
@Override
public void execute() {


    stringBuffer.append(TEXT_92);
    

}});

}

});


    return stringBuffer.toString();
  }
}