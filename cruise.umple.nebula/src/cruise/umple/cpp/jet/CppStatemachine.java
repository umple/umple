/*
Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

Model for generating documentation such as the Umple user manual
See Documenter_Code.ump for the methods injected into these classes
*/

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
  protected final String TEXT_2 = "set";
  protected final String TEXT_3 = "get";
  protected final String TEXT_4 = "FullName";
  protected final String TEXT_5 = "string answer = ";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + "return answer;";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "if (";
  protected final String TEXT_10 = " != ";
  protected final String TEXT_11 = "::NIL) { " + NL + "\tanswer += \".\" + ";
  protected final String TEXT_12 = "; " + NL + "}";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = "::";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = "a";
  protected final String TEXT_17 = "exit";
  protected final String TEXT_18 = "enter";
  protected final String TEXT_19 = "();";
  protected final String TEXT_20 = "wasEventProcessed= ";
  protected final String TEXT_21 = ";";
  protected final String TEXT_22 = "()";
  protected final String TEXT_23 = "\t\t" + NL + "\t\tenum ";
  protected final String TEXT_24 = " { ";
  protected final String TEXT_25 = " };";
  protected final String TEXT_26 = "::";
  protected final String TEXT_27 = "=";
  protected final String TEXT_28 = "bool wasEventProcessed = false;";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "return wasEventProcessed;";
  protected final String TEXT_31 = "//";
  protected final String TEXT_32 = " State Machines";
  protected final String TEXT_33 = "\t\t" + NL + "\t\tvoid ";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = " a";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = "\t\t" + NL + "\t\tbool ";
  protected final String TEXT_38 = "();";
  protected final String TEXT_39 = "\t\t" + NL + "bool ";
  protected final String TEXT_40 = "(){" + NL + "\tbool wasEventProcessed = false;";
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = NL + "\treturn wasEventProcessed;" + NL + "}";
  protected final String TEXT_43 = "\t" + NL + "switch((int)";
  protected final String TEXT_44 = "){";
  protected final String TEXT_45 = NL + "\tdefault:" + NL + "\t\t// Other states do respond to this event" + NL + "\t\tbreak;" + NL + "}" + NL + "\t\t";
  protected final String TEXT_46 = "if(";
  protected final String TEXT_47 = "== ";
  protected final String TEXT_48 = "::";
  protected final String TEXT_49 = "){" + NL + "\t";
  protected final String TEXT_50 = "(";
  protected final String TEXT_51 = "::";
  protected final String TEXT_52 = ");" + NL + "}";
  protected final String TEXT_53 = "// entry actions and do activities";
  protected final String TEXT_54 = "Thread";
  protected final String TEXT_55 = "thisVoidPtr";
  protected final String TEXT_56 = "* thisPtr = static_cast<";
  protected final String TEXT_57 = "*>(thisVoidPtr);" + NL + "thisPtr->";
  protected final String TEXT_58 = "();";
  protected final String TEXT_59 = "doActivity";
  protected final String TEXT_60 = "{" + NL + "\tthis->";
  protected final String TEXT_61 = " = new Thread(&";
  protected final String TEXT_62 = "::";
  protected final String TEXT_63 = ", this, \"";
  protected final String TEXT_64 = "\");" + NL + "\tthis->";
  protected final String TEXT_65 = "->run();" + NL + "}";
  protected final String TEXT_66 = "\t\t" + NL + "if (";
  protected final String TEXT_67 = " != NULL) { " + NL + "\t";
  protected final String TEXT_68 = "->stop(); " + NL + "}";
  protected final String TEXT_69 = "\t\t" + NL + "\t\t//";
  protected final String TEXT_70 = "= new ";
  protected final String TEXT_71 = "(); ";
  protected final String TEXT_72 = " a";
  protected final String TEXT_73 = "= ";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = "\t\t" + NL + "\t";
  protected final String TEXT_76 = " a";
  protected final String TEXT_77 = "= ";
  protected final String TEXT_78 = ";";
  protected final String TEXT_79 = NL + "case ";
  protected final String TEXT_80 = "::";
  protected final String TEXT_81 = ":";
  protected final String TEXT_82 = NL;
  protected final String TEXT_83 = NL + "\tbreak;" + NL + "\t\t\t";
  protected final String TEXT_84 = "wasEventProcessed = true;";
  protected final String TEXT_85 = "case ";
  protected final String TEXT_86 = ": return \"";
  protected final String TEXT_87 = "\";";
  protected final String TEXT_88 = "class ";
  protected final String TEXT_89 = "{" + NL + "" + NL + "\tpublic:" + NL + "\t\ttypedef enum{ ";
  protected final String TEXT_90 = " } enum_type;" + NL + "\t\t" + NL + "\t    ";
  protected final String TEXT_91 = "(";
  protected final String TEXT_92 = "){" + NL + "\t\t\t";
  protected final String TEXT_93 = NL + "\t    }" + NL + "\t" + NL + "\t    operator enum_type() const {" + NL + "\t        return _val;" + NL + "\t    }" + NL + "\t    " + NL + "\t    operator int() { " + NL + "\t\t\treturn static_cast<int>(_val); " + NL + "\t\t}" + NL + "\t\t" + NL + "\t\toperator string() { " + NL + "\t\t\tswitch (_val){";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = "\t\t\t\t" + NL + "\t\t\t\tdefault:  return \"[Unknown ENUM Type]\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\tprivate:" + NL + "\t    enum_type _val;" + NL + "\t\t" + NL + "};";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = "enum_type val = ";
  protected final String TEXT_99 = "): _val(val";
  protected final String TEXT_100 = "//Empty Enumeration";
  protected final String TEXT_101 = "assert(val <= ";
  protected final String TEXT_102 = ");";

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
getRegistry().define(ICppStatemachinesDefinitions.STATES_SETTER_NAME_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(enumName));
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMACHINE_FULL_PATH, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(enumName));
    stringBuffer.append(TEXT_4);
    

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

    stringBuffer.append(TEXT_5);
    stringBuffer.append(statemachine);
    stringBuffer.append(TEXT_6);
    setBody();
    stringBuffer.append(TEXT_7);
    

}

private void setBody(){
	if(body.isEmpty()){
		return;
	}


    stringBuffer.append(TEXT_8);
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

    stringBuffer.append(TEXT_9);
    stringBuffer.append(nestedTypeInstance);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(nestedType);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(nestedTypeInstance);
    stringBuffer.append(TEXT_12);
    

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
    stringBuffer.append(TEXT_13);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(targetState);
    stringBuffer.append(TEXT_15);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.VARIABLE_INSTANCE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_16);
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

    stringBuffer.append(TEXT_17);
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

    stringBuffer.append(TEXT_18);
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
    stringBuffer.append(TEXT_19);
    
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

    stringBuffer.append(TEXT_20);
    stringBuffer.append(procedureName);
    isInvocation();
    stringBuffer.append(TEXT_21);
    
}

private void isInvocation(){
	if(!isImvocation){
		return;
	}
	
    stringBuffer.append(TEXT_22);
    	
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

    stringBuffer.append(TEXT_23);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(values);
    stringBuffer.append(TEXT_25);
    

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
    stringBuffer.append(TEXT_26);
    stringBuffer.append(value);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.ENUM_VALUE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String enumName;
	@GenerationArgument int enumValue;
			
@Override
public void execute() {

    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(enumValue);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMACHINE_METHOD_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument Object body;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_30);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.ENUM+ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_32);
    
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

    stringBuffer.append(TEXT_33);
    stringBuffer.append(setter);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_36);
    
}});

}});

getRegistry().define(ICppStatemachinesDefinitions.STATEMCHAINE_EXIT_PROCEDURE_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String exitProcedureName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(exitProcedureName);
    stringBuffer.append(TEXT_38);
    
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

    stringBuffer.append(TEXT_39);
    stringBuffer.append(owner);
    stringBuffer.append(exitProcedureName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_42);
    
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

    stringBuffer.append(TEXT_43);
    stringBuffer.append(stateName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(StringUtil.indent(body,1));
    stringBuffer.append(TEXT_45);
    
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

    stringBuffer.append(TEXT_46);
    stringBuffer.append(enumVariable);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(enumState);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(setterName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(enumNextState);
    stringBuffer.append(TEXT_52);
    
}});

}

});

getRegistry().define(ICppStatemachinesDefinitions.SETTER_SWITCH_COMMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this) {
	
@Override
public void execute() {

    stringBuffer.append(TEXT_53);
    
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
    stringBuffer.append(TEXT_54);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.VOID_POINTER_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_55);
    

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
    stringBuffer.append(TEXT_56);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(doActivity);
    stringBuffer.append(TEXT_58);
    

}});

}});

getRegistry().define(ICppStatemachinesDefinitions.DO_ACTIVITY_METHOD_INSTANCE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_59);
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


    stringBuffer.append(TEXT_60);
    stringBuffer.append(threadInstance);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(owner);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(functionPointer);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(functionPointer);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(threadInstance);
    stringBuffer.append(TEXT_65);
    

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
	

    stringBuffer.append(TEXT_66);
    stringBuffer.append(threadCallback);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(threadCallback);
    stringBuffer.append(TEXT_68);
    
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
	

    stringBuffer.append(TEXT_69);
    stringBuffer.append(threadCallback);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(threadCallback);
    stringBuffer.append(TEXT_71);
    
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
    stringBuffer.append(TEXT_72);
    stringBuffer.append(enumType);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_74);
    
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

    stringBuffer.append(TEXT_75);
    stringBuffer.append(enumType);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(enumType);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_78);
    
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


    stringBuffer.append(TEXT_79);
    stringBuffer.append(enumType);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(sourceState);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(StringUtil.indent(body,1));
    stringBuffer.append(TEXT_83);
    

}});

}

});

getRegistry().define(ICppStatemachinesDefinitions.STATEMACHINE_PROCESSED_CASE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this) {
	
@Override
public void execute() {


    stringBuffer.append(TEXT_84);
    

}});

}

});


getRegistry().define(ICppStatemachinesDefinitions.ENUM_CASE_STRING, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String caseValue;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_85);
    stringBuffer.append(caseValue);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(caseValue);
    stringBuffer.append(TEXT_87);
    

}});

}

});

getRegistry().define(ICppStatemachinesDefinitions.ENUM_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationProcedureParameter(id = ICppDefinitions.NAMESPACE_OPENING) String namespaceOpening;
	@GenerationProcedureParameter(id = ICppDefinitions.NAMESPACE_CLOSING) String namespaceClosing;
	@GenerationArgument String enumName;
	@GenerationArgument String values;
	@GenerationArgument String first;
	@GenerationArgument String last;
	@GenerationArgument String casesString;
			
@Override
public void execute() {

    stringBuffer.append(namespaceOpening);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(values);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(enumName);
    stringBuffer.append(TEXT_91);
    setFirstParameter();
    stringBuffer.append(TEXT_92);
    setAssert();
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(StringUtil.indent(casesString,4));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(namespaceClosing);
    stringBuffer.append(TEXT_97);
    

}

private void setFirstParameter(){
if(first.isEmpty()){
	return;
}


    stringBuffer.append(TEXT_98);
    stringBuffer.append(first);
    stringBuffer.append(TEXT_99);
    

}

private void setAssert(){
if(last.isEmpty()){
	
    stringBuffer.append(TEXT_100);
    
	return;
}


    stringBuffer.append(TEXT_101);
    stringBuffer.append(last);
    stringBuffer.append(TEXT_102);
    

}

});

}});



    return stringBuffer.toString();
  }
}