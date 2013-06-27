/*
Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
http://umple.org/license

Model for generating documentation such as the Umple user manual
See Documenter_Code.ump for the methods injected into these classes
*/

package cruise.umple.cpp.jet.util;

import cruise.umple.cpp.CppGenerationTemplate;

import cruise.umple.core.*;
import cruise.umple.modeling.handlers.cpp.*;
import cruise.umple.core.GenerationCallback.*;
import cruise.umple.modeling.handlers.*;

@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppTestsHelper extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppTestsHelper create(String lineSeparator)
  {
    nl = lineSeparator;
    CppTestsHelper result = new CppTestsHelper();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#ifndef ";
  protected final String TEXT_2 = "_H" + NL + "#define ";
  protected final String TEXT_3 = "_H" + NL + "" + NL + "#ifdef PRAGMA" + NL + "#pragma once" + NL + "#ifndef _MSC_VER" + NL + "#pragma interface \"";
  protected final String TEXT_4 = ".h\"" + NL + "#endif" + NL + "#endif";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + NL + "void ";
  protected final String TEXT_7 = "(){" + NL;
  protected final String TEXT_8 = NL + "}" + NL + "" + NL + "#endif";
  protected final String TEXT_9 = "assert(";
  protected final String TEXT_10 = "->";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = ")";
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = "==";
  protected final String TEXT_16 = "->";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ")";
  protected final String TEXT_19 = ";";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppTestsDefinitions.TEST_FILE_START, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationProcedureParameter(id = IModelingConstants.COPY_RIGHT) String copyRight;
	@GenerationArgument String startContents;
	@GenerationArgument String testFile;
	@GenerationArgument String testMethod;
	
	String fullName;

@Override
public void execute() {


    stringBuffer.append(copyRight);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(testFile);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(startContents);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(testMethod);
    stringBuffer.append(TEXT_7);
    

}

@Override
public void preExecute(){
	this.fullName= testFile.toUpperCase();
}

});

}});

getRegistry().define(ICppTestsDefinitions.TEST_FILE_END, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_8);
    

}

});

}});

getRegistry().define(ICppTestsDefinitions.ASSERT_GETTER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String instance;
	@GenerationArgument String getterMethod;
	@GenerationArgument String value;
	@GenerationArgument String parameters;
	@GenerationArgument String operator;

@Override
public void execute() {


    stringBuffer.append(TEXT_9);
    stringBuffer.append(instance);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(getterMethod);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_12);
    setOperator();
    stringBuffer.append(TEXT_13);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_14);
    

}

private void setOperator(){
if(operator.isEmpty()){

    stringBuffer.append(TEXT_15);
    
return;
}

    stringBuffer.append(operator);
    
	
}

});

}});

getRegistry().define(ICppTestsDefinitions.METHOD_CALL, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String instance;
	@GenerationArgument String method;
	@GenerationArgument String value;
	@GenerationArgument boolean notStatement;

@Override
public void execute() {


    stringBuffer.append(instance);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_18);
    setEnd();
    

}

private void setEnd(){
	if(!notStatement){
		
    stringBuffer.append(TEXT_19);
    	
	}
}

});

}});


    return stringBuffer.toString();
  }
}