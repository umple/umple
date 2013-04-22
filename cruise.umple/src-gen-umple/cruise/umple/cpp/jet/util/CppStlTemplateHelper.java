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

package cruise.umple.cpp.jet.util;

import cruise.umple.core.*;
import cruise.umple.core.GenerationCallback.*;
import cruise.umple.cpp.*;
import cruise.umple.cpp.utils.*;
import cruise.umple.modeling.handlers.cpp.*;


@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppStlTemplateHelper extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppStlTemplateHelper create(String lineSeparator)
  {
    nl = lineSeparator;
    CppStlTemplateHelper result = new CppStlTemplateHelper();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "new time_t(time(NULL))";
  protected final String TEXT_2 = "new tm(*localtime(&t))";
  protected final String TEXT_3 = "ParseDate(";
  protected final String TEXT_4 = ")";
  protected final String TEXT_5 = "ParseTime(";
  protected final String TEXT_6 = ")";
  protected final String TEXT_7 = "time_t t(time(NULL)); \t//current time";
  protected final String TEXT_8 = "new vector<";
  protected final String TEXT_9 = ">()";
  protected final String TEXT_10 = "*";
  protected final String TEXT_11 = NL + "std::for_each(";
  protected final String TEXT_12 = "->begin(), ";
  protected final String TEXT_13 = "->end(), /*std::default_delete<";
  protected final String TEXT_14 = ">*/ deleteElement());";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = "->clear();" + NL + "delete ";
  protected final String TEXT_17 = ";";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    


getRegistry().define(ISTLConstants.DEFAULT_TIME_ASSIGN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    

}});

}});

getRegistry().define(ISTLConstants.DEFAULT_DATE_ASSIGN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_2);
    

}});

}});

getRegistry().define(ISTLConstants.DATE_ASSIGN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String value;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_3);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_4);
    

}});

}});

getRegistry().define(ISTLConstants.TIME_ASSIGN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String value;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_5);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_6);
    

}});

}});

getRegistry().define(ISTLConstants.CURRENT_TIME_REFERENCE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_7);
    

}});

}});

getRegistry().define(ISTLConstants.NEW_VECTOR_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	@GenerationArgument boolean isPointer;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_8);
    stringBuffer.append(type);
    setPointer();
    stringBuffer.append(TEXT_9);
    

}

private void setPointer(){

if(!isPointer){
	return;
}

    stringBuffer.append(TEXT_10);
    

}

});

}});

getRegistry().define(ISTLConstants.DESTRUCT_VECTOR_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_11);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_17);
    

}

});

}});




    return stringBuffer.toString();
  }
}