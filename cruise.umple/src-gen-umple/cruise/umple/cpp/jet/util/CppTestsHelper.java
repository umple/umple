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
import cruise.umple.modeling.handlers.*;
import cruise.umple.modeling.handlers.cpp.*;
import cruise.umple.cpp.utils.*;
import cruise.umple.core.GenerationCallback.*;

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
  protected final String TEXT_1 = "* ";
  protected final String TEXT_2 = "= new ";
  protected final String TEXT_3 = "(";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = "assert(";
  protected final String TEXT_6 = "->";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = ")== ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = "->";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = ");";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppTestsDefinitions.CONSTRUCT_CLASS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	@GenerationArgument String name;
	@GenerationArgument String constructArguments;

@Override
public void execute() {


    stringBuffer.append(type);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(constructArguments);
    stringBuffer.append(TEXT_4);
    

}});

}});

getRegistry().define(ICppTestsDefinitions.ASSERT_GETTER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String instance;
	@GenerationArgument String getterMethod;
	@GenerationArgument String value;
	@GenerationArgument String parameters;

@Override
public void execute() {


    stringBuffer.append(TEXT_5);
    stringBuffer.append(instance);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(getterMethod);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_9);
    

}});

}});

getRegistry().define(ICppTestsDefinitions.METHOD_CALL, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String instance;
	@GenerationArgument String method;
	@GenerationArgument String value;

@Override
public void execute() {


    stringBuffer.append(instance);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_12);
    

}});

}});


    return stringBuffer.toString();
  }
}