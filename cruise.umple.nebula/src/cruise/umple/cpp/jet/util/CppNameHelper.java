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
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.cpp.CppGenerationTemplate;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppDecisions;
import cruise.umple.modeling.handlers.cpp.ICppDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppHandlerDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppMethods;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;


@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppNameHelper extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppNameHelper create(String lineSeparator)
  {
    nl = lineSeparator;
    CppNameHelper result = new CppNameHelper();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "remove";
  protected final String TEXT_2 = "canSet";
  protected final String TEXT_3 = "verified";
  protected final String TEXT_4 = "remove";
  protected final String TEXT_5 = "At";
  protected final String TEXT_6 = "add";
  protected final String TEXT_7 = "At";
  protected final String TEXT_8 = "addOrMove";
  protected final String TEXT_9 = "At";
  protected final String TEXT_10 = "indexOf";
  protected final String TEXT_11 = "placeholder";
  protected final String TEXT_12 = "set";
  protected final String TEXT_13 = "isNew";
  protected final String TEXT_14 = "existing";
  protected final String TEXT_15 = "old";
  protected final String TEXT_16 = "new";
  protected final String TEXT_17 = "all";
  protected final String TEXT_18 = "a";
  protected final String TEXT_19 = "get";
  protected final String TEXT_20 = "is";
  protected final String TEXT_21 = "numberOf";
  protected final String TEXT_22 = "minimumNumberOf";
  protected final String TEXT_23 = "has";
  protected final String TEXT_24 = "maximumNumberOf";
  protected final String TEXT_25 = "deleteAssociatedObjects";
  protected final String TEXT_26 = "add";
  protected final String TEXT_27 = "copyOf";
  protected final String TEXT_28 = "set";
  protected final String TEXT_29 = "_";
  protected final String TEXT_30 = "clear";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    


getRegistry().define(ICppNameConstants.REMOVE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.CAN_SET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String nameAsParameter;
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String elementName;
	
	String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_2);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}

@Override
public void preExecute(){
	//Allow defining by element type name, if not, then by argument
	this.name= element!=null? this.elementName: nameAsParameter;
}

});

}});

getRegistry().define(ICppNameConstants.VERIFIED, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_3);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.REMOVE_AT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_4);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    stringBuffer.append(TEXT_5);
    

}});

}});

getRegistry().define(ICppNameConstants.ADD_AT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_6);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    stringBuffer.append(TEXT_7);
    

}});

}});

getRegistry().define(ICppNameConstants.ADD_OR_MOVE_AT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_8);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    stringBuffer.append(TEXT_9);
    

}});

}});

getRegistry().define(ICppNameConstants.INDEX_OF, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_10);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.PLACE_HOLDER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_11);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.SET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_12);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.IS_NEW, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_13);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.EXISTING, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_14);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.OLD, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_15);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.NEW_INSTANCE, new GenerationProcdure(this){
	
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

getRegistry().define(ICppNameConstants.VARIABLE_PARAMETER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument boolean isMany;
	
@Override
public void execute() {


    prefix();
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}

private void prefix(){
	if(isMany){
		
    stringBuffer.append(TEXT_17);
    	
	}else{
		
    stringBuffer.append(TEXT_18);
    
	}
}

});

}});

getRegistry().define(ICppNameConstants.GET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_19);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.IS_A, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_20);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.NUMBER_OF, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_21);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(IModelingConstants.MINIMUM_NUMBER_OF, new GenerationProcdure(this){
	
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

getRegistry().define(ICppNameConstants.CONTAINS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_23);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});


getRegistry().define(IModelingConstants.MAXIMUM_NUMBER_OF, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_24);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.DELETE_METHOD, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_25);
    

}});

}});

getRegistry().define(ICppNameConstants.ADD_METHOD, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_26);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.COPY_OF, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_27);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.FRIEND_SETTER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String typeName;
	@GenerationArgument String otherEndTypeName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_28);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(typeName));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(otherEndTypeName));
    

}});

}});

getRegistry().define(ICppNameConstants.CLEAR_VECTOR, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_30);
    

}});

}});



    return stringBuffer.toString();
  }
}