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

import cruise.umple.cpp.CppGenerationTemplate;

import cruise.umple.core.*;
import cruise.umple.modeling.handlers.cpp.*;
import cruise.umple.cpp.utils.*;
import cruise.umple.modeling.handlers.*;
import cruise.umple.core.GenerationCallback.*;

@SuppressWarnings({ "nls", "unqualified-field-access" })
public class UmpleCppTemplateHelper extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized UmpleCppTemplateHelper create(String lineSeparator)
  {
    nl = lineSeparator;
    UmpleCppTemplateHelper result = new UmpleCppTemplateHelper();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "reset";
  protected final String TEXT_2 = "getDefault";
  protected final String TEXT_3 = "Please provide ";
  protected final String TEXT_4 = "valid ";
  protected final String TEXT_5 = "Singleton<";
  protected final String TEXT_6 = ">";
  protected final String TEXT_7 = NL + NL + "//Helper template to be extended by the classes that need to be used as singelton design pattern" + NL + "template<class T> class Singleton {" + NL + "\tSingleton(const Singleton&);" + NL + "\tSingleton& operator=(const Singleton&);" + NL + "\tprotected:" + NL + "\t\tSingleton() {}" + NL + "\t\tvirtual ~Singleton() {}" + NL + "\tpublic:" + NL + "\t\tstatic T& instance() {" + NL + "\t\t\tstatic MutexLock lock;" + NL + "\t\t\tsynchronized(lock) {" + NL + "\t\t\t\tstatic T theInstance;" + NL + "\t\t\t\treturn theInstance;" + NL + "\t\t\t}" + NL + "  \t\t}" + NL + "};";
  protected final String TEXT_8 = "next";
  protected final String TEXT_9 = "\tbool wasReset = false;" + NL + "\tthis->";
  protected final String TEXT_10 = "= ";
  protected final String TEXT_11 = "();" + NL + "\twasReset = true; " + NL + "\treturn wasReset;";
  protected final String TEXT_12 = "if(!this->";
  protected final String TEXT_13 = ") { " + NL + "\treturn false; " + NL + "}" + NL + "this->";
  protected final String TEXT_14 = "= false;" + NL;
  protected final String TEXT_15 = "//Autounique Attributes";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppUmpleDefinitions.RESET_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name, true));
    

}});

}});

getRegistry().define(ICppUmpleDefinitions.DEFAULT_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_2);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name, true));
    

}});

}});

getRegistry().define(ICppUmpleDefinitions.CONSTRAINT_MESSAGE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String variable;
	@GenerationArgument boolean many;
	String article;
	
@Override
public void execute() {

article= many? "": "a ";


    stringBuffer.append(TEXT_3);
    stringBuffer.append(article);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(variable);
    

}});

}});

getRegistry().define(ICppUmpleDefinitions.SINGLETON_CALL, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_5);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_6);
    

}});

}});

getRegistry().define(ICppUmpleDefinitions.SINGLETON_TEMPLATE_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	
@Override
public void execute() {

    stringBuffer.append(TEXT_7);
    
}});

}});

getRegistry().define(ICppUmpleDefinitions.NEXT_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_8);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name, true));
    

}});

}});

getRegistry().define(ICppUmpleDefinitions.RESET_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
	@GenerationArgument String defaultGetter;
				
@Override
public void execute() {


    stringBuffer.append(TEXT_9);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(defaultGetter);
    stringBuffer.append(TEXT_11);
    

}});

}});

getRegistry().define(ICppUmpleDefinitions.SETTER_CAN_SET_CHECK, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@StubPoint(id = ICppNameConstants.CAN_SET) String nameAsVariableElement;
	@GenerationArgument String nameAsVariable;
	
	String canSetFlag;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(canSetFlag);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(canSetFlag);
    stringBuffer.append(TEXT_14);
    
}

@Override
public void preExecute(){
	//Allow defining by element type name, if not, then by argument
	this.canSetFlag= element!=null? this.nameAsVariableElement: this.nameAsVariable;
}

});

}});

getRegistry().define(ICppUmpleDefinitions.AUTOUNIQUE_ATTRIBUTE_DECLARATIONS+ ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {

    stringBuffer.append(TEXT_15);
    
}});

}});


    return stringBuffer.toString();
  }
}