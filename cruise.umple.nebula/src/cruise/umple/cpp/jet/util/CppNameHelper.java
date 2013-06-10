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
  protected final String TEXT_1 = "add";
  protected final String TEXT_2 = "remove";
  protected final String TEXT_3 = "remove";
  protected final String TEXT_4 = "For";
  protected final String TEXT_5 = "canSet";
  protected final String TEXT_6 = "verified";
  protected final String TEXT_7 = "remove";
  protected final String TEXT_8 = "At";
  protected final String TEXT_9 = "add";
  protected final String TEXT_10 = "At";
  protected final String TEXT_11 = "addOrMove";
  protected final String TEXT_12 = "At";
  protected final String TEXT_13 = "indexOf";
  protected final String TEXT_14 = "placeholder";
  protected final String TEXT_15 = "set";
  protected final String TEXT_16 = "isNew";
  protected final String TEXT_17 = "existing";
  protected final String TEXT_18 = "old";
  protected final String TEXT_19 = "new";
  protected final String TEXT_20 = "all";
  protected final String TEXT_21 = "a";
  protected final String TEXT_22 = "get";
  protected final String TEXT_23 = "is";
  protected final String TEXT_24 = "numberOf";
  protected final String TEXT_25 = "minimumNumberOf";
  protected final String TEXT_26 = "has";
  protected final String TEXT_27 = "maximumNumberOf";
  protected final String TEXT_28 = "deleteAssociatedObjects";
  protected final String TEXT_29 = "add";
  protected final String TEXT_30 = "copyOf";
  protected final String TEXT_31 = "set";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = "clear";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppNameConstants.ADD_INSTANCE, new GenerationProcdure(this){
	
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

getRegistry().define(ICppNameConstants.REMOVE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_2);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.REMOVE, new GenerationProcdure(this){
	
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

getRegistry().define(ICppNameConstants.DELEGATED_PARAMETER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String parameter;
	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(type));
    

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


    stringBuffer.append(TEXT_5);
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


    stringBuffer.append(TEXT_6);
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


    stringBuffer.append(TEXT_7);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    stringBuffer.append(TEXT_8);
    

}});

}});

getRegistry().define(ICppNameConstants.ADD_AT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_9);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    stringBuffer.append(TEXT_10);
    

}});

}});

getRegistry().define(ICppNameConstants.ADD_OR_MOVE_AT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_11);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    stringBuffer.append(TEXT_12);
    

}});

}});

getRegistry().define(ICppNameConstants.INDEX_OF, new GenerationProcdure(this){
	
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

getRegistry().define(ICppNameConstants.PLACE_HOLDER, new GenerationProcdure(this){
	
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

getRegistry().define(ICppNameConstants.SET, new GenerationProcdure(this){
	
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

getRegistry().define(ICppNameConstants.IS_NEW, new GenerationProcdure(this){
	
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

getRegistry().define(ICppNameConstants.EXISTING, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_17);
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


    stringBuffer.append(TEXT_18);
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


    stringBuffer.append(TEXT_19);
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
		
    stringBuffer.append(TEXT_20);
    	
	}else{
		
    stringBuffer.append(TEXT_21);
    
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


    stringBuffer.append(TEXT_22);
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


    stringBuffer.append(TEXT_23);
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


    stringBuffer.append(TEXT_24);
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


    stringBuffer.append(TEXT_25);
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


    stringBuffer.append(TEXT_26);
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


    stringBuffer.append(TEXT_27);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(name));
    

}});

}});

getRegistry().define(ICppNameConstants.DELETE_METHOD, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_28);
    

}});

}});

getRegistry().define(ICppNameConstants.ADD_METHOD, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_29);
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


    stringBuffer.append(TEXT_30);
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


    stringBuffer.append(TEXT_31);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(typeName));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(StringUtil.firstCharacterToUpperCase(otherEndTypeName));
    

}});

}});

getRegistry().define(ICppNameConstants.CLEAR_VECTOR, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_33);
    

}});

}});



    return stringBuffer.toString();
  }
}