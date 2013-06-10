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
  protected final String TEXT_1 = "#ifndef TEST_STUBS_H" + NL + "#define TEST_STUBS_H" + NL + "" + NL + "#ifdef PRAGMA" + NL + "#pragma once" + NL + "#ifndef _MSC_VER" + NL + "#pragma interface \"TestStubs.h\"" + NL + "#endif" + NL + "#endif";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "void test(){" + NL;
  protected final String TEXT_4 = NL + "}" + NL + "" + NL + "#endif";
  protected final String TEXT_5 = "assert(";
  protected final String TEXT_6 = "->";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = ")";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = "==";
  protected final String TEXT_12 = "->";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = ";";

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

@Override
public void execute() {


    stringBuffer.append(copyRight);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(startContents);
    stringBuffer.append(TEXT_3);
    

}

});

}});

getRegistry().define(ICppTestsDefinitions.TEST_FILE_END, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_4);
    

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


    stringBuffer.append(TEXT_5);
    stringBuffer.append(instance);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(getterMethod);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_8);
    setOperator();
    stringBuffer.append(TEXT_9);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_10);
    

}

private void setOperator(){
if(operator.isEmpty()){

    stringBuffer.append(TEXT_11);
    
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
    stringBuffer.append(TEXT_12);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_14);
    setEnd();
    

}

private void setEnd(){
	if(!notStatement){
		
    stringBuffer.append(TEXT_15);
    	
	}
}

});

}});


    return stringBuffer.toString();
  }
}