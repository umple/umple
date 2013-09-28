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
import cruise.umple.modeling.handlers.*;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;
import cruise.umple.cpp.utils.*;
import cruise.umple.modeling.handlers.cpp.ICppAssociationsDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.core.GenerationCallback.*;

@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppAttributeGetterImpl extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppAttributeGetterImpl create(String lineSeparator)
  {
    nl = lineSeparator;
    CppAttributeGetterImpl result = new CppAttributeGetterImpl();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\treturn this->";
  protected final String TEXT_3 = "->size();";
  protected final String TEXT_4 = "\treturn this->";
  protected final String TEXT_5 = "()>0;";
  protected final String TEXT_6 = "int index= IndexOf(this->";
  protected final String TEXT_7 = "->begin(), this->";
  protected final String TEXT_8 = "->end(), ";
  protected final String TEXT_9 = ");" + NL + "if(index<0){" + NL + "\treturn wasRemoved;" + NL + "}";
  protected final String TEXT_10 = NL + "wasRemoved= this->";
  protected final String TEXT_11 = "->erase(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "wasRemoved= this->";
  protected final String TEXT_14 = "(index);";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = "(";
  protected final String TEXT_17 = ", NULL);";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = "->";
  protected final String TEXT_20 = "(NULL);";
  protected final String TEXT_21 = NL + NL + "//Unable to remove ";
  protected final String TEXT_22 = ", as it must always have a ";
  protected final String TEXT_23 = NL + "if (this== ";
  protected final String TEXT_24 = "->";
  protected final String TEXT_25 = "()){" + NL + "  return wasRemoved;" + NL + "}";
  protected final String TEXT_26 = NL + NL + "//";
  protected final String TEXT_27 = " already at minimum (";
  protected final String TEXT_28 = ")" + NL + "if (";
  protected final String TEXT_29 = "() <= ";
  protected final String TEXT_30 = "()){" + NL + "\treturn false;" + NL + "}" + NL;
  protected final String TEXT_31 = NL + "if (";
  protected final String TEXT_32 = "->";
  protected final String TEXT_33 = "(this) == -1){" + NL + "\twasRemoved = true;" + NL + "}else{" + NL + "\twasRemoved = ";
  protected final String TEXT_34 = "->";
  protected final String TEXT_35 = "(this);" + NL + "\tif (!wasRemoved){" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t}" + NL + "}";
  protected final String TEXT_37 = "\tif(index<0){" + NL + "\t\treturn wasRemoved;" + NL + "\t}" + NL + "\t" + NL + "\tint size= this->";
  protected final String TEXT_38 = "();" + NL + "\tif(index> size){" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_39 = NL + "\twasRemoved= size== this->";
  protected final String TEXT_40 = "()+1;";
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = "\tint indexOf_";
  protected final String TEXT_43 = "= IndexOf(this->";
  protected final String TEXT_44 = "->begin(), this->";
  protected final String TEXT_45 = "->end(), ";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "if(this->";
  protected final String TEXT_48 = "!= NULL){" + NL + "\t";
  protected final String TEXT_49 = "* ";
  protected final String TEXT_50 = " = this->";
  protected final String TEXT_51 = ";" + NL + "\tthis->";
  protected final String TEXT_52 = " = NULL;" + NL + "\t";
  protected final String TEXT_53 = "->";
  protected final String TEXT_54 = "(this);" + NL + "}";
  protected final String TEXT_55 = NL + "if(this->";
  protected final String TEXT_56 = " != NULL){";
  protected final String TEXT_57 = NL + "}";
  protected final String TEXT_58 = "\t" + NL + "if(this->";
  protected final String TEXT_59 = "!= NULL){" + NL + "\tthis->";
  protected final String TEXT_60 = "->";
  protected final String TEXT_61 = "(NULL);";
  protected final String TEXT_62 = NL + "}";
  protected final String TEXT_63 = "\t" + NL + "\tthis->";
  protected final String TEXT_64 = "= NULL;";
  protected final String TEXT_65 = NL + "if(this->";
  protected final String TEXT_66 = "!= NULL){" + NL + "\t";
  protected final String TEXT_67 = "* ";
  protected final String TEXT_68 = "= this->";
  protected final String TEXT_69 = ";" + NL + "\tthis->";
  protected final String TEXT_70 = "= NULL;" + NL + "\t";
  protected final String TEXT_71 = "->deleteAssociatedObjects();" + NL + "}";
  protected final String TEXT_72 = NL + "if(this->";
  protected final String TEXT_73 = "!= NULL){" + NL + "\tif(this->";
  protected final String TEXT_74 = "->";
  protected final String TEXT_75 = "()<= this->";
  protected final String TEXT_76 = "->";
  protected final String TEXT_77 = "()){" + NL + "\t\tthis->";
  protected final String TEXT_78 = "->deleteAssociatedObjects();" + NL + "\t}else{" + NL + "\t\t";
  protected final String TEXT_79 = "* placeHolder";
  protected final String TEXT_80 = "= this->";
  protected final String TEXT_81 = ";" + NL + "\t\tthis->";
  protected final String TEXT_82 = "= NULL;" + NL + "\t\tplaceHolder";
  protected final String TEXT_83 = "->";
  protected final String TEXT_84 = "(this);" + NL + "\t}" + NL + "}";
  protected final String TEXT_85 = "\t" + NL + "if(this->";
  protected final String TEXT_86 = "!= NULL){" + NL + "\tthis->";
  protected final String TEXT_87 = "->deleteAssociatedObjects();" + NL + "}";
  protected final String TEXT_88 = "while(this->";
  protected final String TEXT_89 = "->size()>0){";
  protected final String TEXT_90 = NL + "\ta";
  protected final String TEXT_91 = "->";
  protected final String TEXT_92 = "(NULL);" + NL + "}";
  protected final String TEXT_93 = NL;
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "this->";
  protected final String TEXT_96 = "->clear();" + NL + "" + NL + "while(this->";
  protected final String TEXT_97 = "->size()>0){";
  protected final String TEXT_98 = NL + "\ttemp->";
  protected final String TEXT_99 = "(this);" + NL + "}";
  protected final String TEXT_100 = NL;
  protected final String TEXT_101 = NL;
  protected final String TEXT_102 = NL + "this->";
  protected final String TEXT_103 = "->clear();" + NL + "" + NL + "while(this->";
  protected final String TEXT_104 = "->size()>0){";
  protected final String TEXT_105 = NL + "\tif(current";
  protected final String TEXT_106 = "->";
  protected final String TEXT_107 = "()<= current";
  protected final String TEXT_108 = "->";
  protected final String TEXT_109 = "()){" + NL + "\t\tcurrent";
  protected final String TEXT_110 = "->deleteAssociatedObjects();" + NL + "\t}else{" + NL + "\t\tcurrent";
  protected final String TEXT_111 = "->";
  protected final String TEXT_112 = "(this);" + NL + "\t}" + NL + "}";
  protected final String TEXT_113 = NL;
  protected final String TEXT_114 = NL + "this->";
  protected final String TEXT_115 = "->clear();" + NL + "for(unsigned int index = ";
  protected final String TEXT_116 = "->size(); index > 0 ; index--){";
  protected final String TEXT_117 = NL + "\ta";
  protected final String TEXT_118 = "->deleteAssociatedObjects();" + NL + "}";
  protected final String TEXT_119 = NL;
  protected final String TEXT_120 = "for(unsigned int index=0; index<this->";
  protected final String TEXT_121 = "->size();index++){";
  protected final String TEXT_122 = NL + "\t";
  protected final String TEXT_123 = "(current, NULL);" + NL + "}" + NL + "this->";
  protected final String TEXT_124 = "->clear();";
  protected final String TEXT_125 = NL;
  protected final String TEXT_126 = "this->";
  protected final String TEXT_127 = "(";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = "this->";
  protected final String TEXT_130 = "(";
  protected final String TEXT_131 = ", index);";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppAssociationsDefinitionsConstants.MANY_GETTER_METHOD , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	@GenerationArgument String copy;
	
	String copyCall;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    stringBuffer.append(StringUtil.indent(copyCall, 1));
    

}

@Override
public void preExecute(){
	this.copyCall= getRegistry().generationPointString(element, ICppDefinitions.COPY_INVOCATION,
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_SOURCE_ARGUMENT, "this->"+ elementName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_TARGET_ARGUMENT, copy));
	
	//To be used as a return statement in other generation points
	getRegistry().addUniqueValue(ICppAssociationsDefinitionsConstants.GETTER_MANY_IMPLEMENTATION+
			ICppAssociationsDefinitionsConstants.IMPLEMENTATION_RETURN_TRACKER, this.copy, element);
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.GETTER_BY_INDEX_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	
	String returnName, normalizedType;
	
@Override
public void execute() {

    stringBuffer.append(StringUtil.indent(getterCall(normalizedType + " "+ returnName), 1));
    

}

private String getterCall(String assignee){

String thisCall= getRegistry().use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, elementName, Boolean.TRUE);
String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, thisCall),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, "index"));
		
return getterCall;

}

@Override
public void preExecute(){

this.normalizedType= getRegistry().generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME,Boolean.TRUE);

this.returnName= getRegistry().use(ICppNameConstants.VARIABLE_PARAMETER, 
			getRegistry().getString(element, IModelingElementDefinitions.SINGULAR_NAME, elementName));
}

@Override
public void postExecute(){
	//To be used as a return statement in other generation points
	getRegistry().addUniqueValue(ICppAssociationsDefinitionsConstants.GETTER_BY_INDEX_IMPLEMENTATION+
			ICppAssociationsDefinitionsConstants.IMPLEMENTATION_RETURN_TRACKER, this.returnName, element);
}


});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.NUMBER_OF_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_2);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_3);
    

}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.CONTAINS_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String numberOfMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_4);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_5);
    

}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.REMOVE_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	@GenerationProcedureParameter(id = IModelingConstants.REMOVE_AT_METHOD_NAME) String removeAtMethod;
	@GenerationProcedureParameter(id = IModelingDecisions.REMOVE_AT_FILTER_DECISION) boolean filterRemoveAt;
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String elementName;
	@GenerationProcedureParameter(id = IModelingConstants.MODELING_DEFAULT_SINGLE_PARAMETER_NAME) String paramName;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName;
	@GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound;
	
	@GenerationProcedureParameter(id = ICppAssociationsDefinitionsConstants.REMOVE_MINIMUM_CHECK_DECISION) boolean checkForMinimum;
	@GenerationProcedureParameter(id = ICppAssociationsDefinitionsConstants.REMOVE_CHECK_OTHER_END_DECISION) boolean checkOtherEnd;
	@GenerationProcedureParameter(id = ICppAssociationsDefinitionsConstants.REMOVE_NULLIFY_INTERNALLY_DECISION) boolean nullifyInternally;
	@GenerationProcedureParameter(id = ICppAssociationsDefinitionsConstants.REMOVE_NULLIFY_DECISION) boolean nullify;
	@GenerationProcedureParameter(id = ICppAssociationsDefinitionsConstants.REMOVE_SELF_CHECK_DECISION) boolean selfCheck;
	
	String minimumNumberMethodName, numberOfMethodName, indexOfMethod, removeMethodName, friendSetterMethod, setter, otherGetterMethodName, addCall;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_6);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_9);
    minimum();
    selfCheck();
    removeCall();
    nullify();
    friendNullify();
    checkOther();
    
}

public void removeCall(){
	if(filterRemoveAt){
		removeDirectly();
	}else{
		removeByIndex();
	}
}

public void removeDirectly(){


    stringBuffer.append(TEXT_10);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_12);
    

}

public void removeByIndex(){


    stringBuffer.append(TEXT_13);
    stringBuffer.append( removeAtMethod );
    stringBuffer.append(TEXT_14);
    

}

public void friendNullify(){
if(!nullifyInternally){
	return;
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(friendSetterMethod);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_17);
    
}

public void nullify(){
if(!nullify){
	return;
}

    stringBuffer.append(TEXT_18);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(setter);
    stringBuffer.append(TEXT_20);
    
}

public void selfCheck(){
if(!selfCheck){
	return;
}


    stringBuffer.append(TEXT_21);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(otherGetterMethodName);
    stringBuffer.append(TEXT_25);
    
}

public void minimum(){
if(!checkForMinimum){
	return;
}


    stringBuffer.append(TEXT_26);
    stringBuffer.append(otherEndName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(lowerBound);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(minimumNumberMethodName);
    stringBuffer.append(TEXT_30);
    
}

public void checkOther(){
if(!checkOtherEnd){
	return;
}


    stringBuffer.append(TEXT_31);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(indexOfMethod);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(addCall);
    stringBuffer.append(TEXT_36);
    
}

@Override
public void preExecute(){
	this.minimumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.numberOfMethodName= getRegistry().generationPointString(element, IModelingConstants.NUMBER_OF_METHOD_NAME, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.indexOfMethod= getRegistry().generationPointString(element, ICppNameConstants.INDEX_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.setter= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.friendSetterMethod= getRegistry().use(ICppNameConstants.FRIEND_SETTER, typeName, otherEndTypeName);
	
	this.otherGetterMethodName= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	String thisCall= getRegistry().use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, elementName, Boolean.TRUE);
	this.addCall= getRegistry().generationPointString(element, ICppDefinitions.ADD_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_VARIABLE_ARGUMENT, thisCall),
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_INDEX_ARGUMENT, "index"),
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_PARAMETER_ARGUMENT, paramName));
}

});
}});

getRegistry().define(ICppAssociationsDefinitionsConstants.REMOVE_AT_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String elementName;
	String numberOfMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_37);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_38);
    removeCall();
    stringBuffer.append(TEXT_39);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_40);
    

}

private void removeCall(){

String thisCall= getRegistry().use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, elementName, Boolean.TRUE);
String removeCall= getRegistry().generationPointString(element, ICppDefinitions.REMOVE_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_VARIABLE_ARGUMENT, thisCall),
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_INDEX_ARGUMENT, "index"));


    stringBuffer.append(TEXT_41);
    stringBuffer.append(StringUtil.indent(removeCall, 1));
    

}

@Override
public void preExecute(){
	this.numberOfMethodName= getRegistry().generationPointString(element, IModelingConstants.NUMBER_OF_METHOD_NAME, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}


});

}});


getRegistry().define(ICppAssociationsDefinitionsConstants.INDEX_OF_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	@GenerationArgument String paramName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_42);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_46);
    

}

@Override
public void postExecute(){
	//To be used as a return statement in other generation points
	getRegistry().addUniqueValue(ICppAssociationsDefinitionsConstants.INDEX_OF_IMPLEMENTATION+
			ICppAssociationsDefinitionsConstants.IMPLEMENTATION_RETURN_TRACKER, "indexOf_" + paramName, element);
}

});
}});


getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION, new GenerationProcdure(this) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	
	@GenerationArgument(id= ICppAssociationsDefinitionsConstants.RemoveMessages.CHECK) boolean check;
		
	String placeHolder;	
	String removeMethodName;

@Override
public StringBuffer execute(Object element, Object... arguments) {
	StringBuffer content= contents(element, arguments);
	if(check){
		return check(content, element, arguments);
	}
	return content;
}

public StringBuffer contents(Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {
	

    stringBuffer.append(TEXT_47);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(placeHolder);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(placeHolder);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_54);
    
}

@Override
public void preExecute(){
	removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	placeHolder= getRegistry().generationPointString(element, ICppNameConstants.PLACE_HOLDER, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});
}

public StringBuffer check(final StringBuffer body, Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
		
@Override
public void execute() {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(StringUtil.indent(body.toString(), 1));
    stringBuffer.append(TEXT_57);
    
}});
}
	
});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_CHECK_NULLIFY_BY_SETTER_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationArgument(id= ICppAssociationsDefinitionsConstants.RemoveMessages.NULLIFY) boolean nullify;
	
	String setterMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_58);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_61);
    nullify();
    stringBuffer.append(TEXT_62);
    

}

private void nullify() {
if(!nullify){
	return;
}


    stringBuffer.append(TEXT_63);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_64);
    

}

@Override
public void preExecute(){
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_USE_DELETE_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	String existingVariableName;
		
@Override
public void execute() {


    stringBuffer.append(TEXT_65);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(existingVariableName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(existingVariableName);
    stringBuffer.append(TEXT_71);
    

}

@Override
public void preExecute(){
	this.existingVariableName= getRegistry().generationPointString(element, ICppNameConstants.EXISTING, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_REMOVE_OR_NULLIFY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
		
	String numberOfOtherEndMethodName;
	String minimumNumberOtherEndMethodName;
	String removeMethodName;
		
@Override
public void execute() {


    stringBuffer.append(TEXT_72);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(numberOfOtherEndMethodName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(minimumNumberOtherEndMethodName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_84);
    

}

@Override
public void preExecute(){
	this.numberOfOtherEndMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.minimumNumberOtherEndMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_CHECK_USE_DELETE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
		
@Override
public void execute() {


    stringBuffer.append(TEXT_85);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_87);
    

}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_ALL_BY_SETTER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	
	String setterMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_88);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_89);
    getterCall(typeName + "*" + " a" + typeName, 1);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_92);
    

}

private void getterCall(String assignee, int indent){

String thisCall= getRegistry().use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, name, Boolean.TRUE);
String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, thisCall),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, null /* "0" */));


    stringBuffer.append(TEXT_93);
    stringBuffer.append(StringUtil.indent(getterCall, indent));
    

}

@Override
public void preExecute(){
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_SAFELY_CLEAR_AND_REMOVE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	
	String nameAsCopy, removeMethodName, copyCall;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_94);
    stringBuffer.append(copyCall);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_97);
    getterCall(typeName + "*" + " temp", 1);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_99);
    

}

private void getterCall(String assignee, int indent){

String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, nameAsCopy),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, null /* "0" */));


    stringBuffer.append(TEXT_100);
    stringBuffer.append(StringUtil.indent(getterCall, indent));
    

}

@Override
public void preExecute(){
	this.nameAsCopy= getRegistry().generationPointString(element, ICppNameConstants.COPY_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.copyCall= getRegistry().generationPointString(element, ICppDefinitions.COPY_INVOCATION,
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_SOURCE_ARGUMENT, "this->"+ name),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_TARGET_ARGUMENT, nameAsCopy));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
		
	String numberOfOtherEndMethodName, minimumNumberOtherEndMethodName, removeMethodName, nameAsCopy, copyCall;
		
@Override
public void execute() {


    stringBuffer.append(TEXT_101);
    stringBuffer.append(copyCall);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_104);
    getterCall(typeName + "*" + " current" + typeName, 1);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(numberOfOtherEndMethodName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(minimumNumberOtherEndMethodName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_112);
    

}

private void getterCall(String assignee, int indent){

String thisCall= getRegistry().use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, name, Boolean.TRUE);
String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, thisCall),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, null /* "0" */));


    stringBuffer.append(TEXT_113);
    stringBuffer.append(StringUtil.indent(getterCall, indent));
    

}

@Override
public void preExecute(){
	this.numberOfOtherEndMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.minimumNumberOtherEndMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.nameAsCopy= getRegistry().generationPointString(element, ICppNameConstants.COPY_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	
	this.copyCall= getRegistry().generationPointString(element, ICppDefinitions.COPY_INVOCATION,
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_SOURCE_ARGUMENT, "this->"+ name),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_TARGET_ARGUMENT, nameAsCopy));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	
	String copyCall, nameAsCopy;
	
@Override
public void execute() {


    stringBuffer.append(copyCall);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(nameAsCopy);
    stringBuffer.append(TEXT_116);
    getterCall(typeName + "*" + " a" + typeName, 1);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_118);
    

}

private void getterCall(String assignee, int indent){

String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, nameAsCopy),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, "index-1" /* "0" */));


    stringBuffer.append(TEXT_119);
    stringBuffer.append(StringUtil.indent(getterCall, indent));
    

}

@Override
public void preExecute(){
	this.nameAsCopy= getRegistry().generationPointString(element, ICppNameConstants.COPY_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.copyCall= getRegistry().generationPointString(element, ICppDefinitions.COPY_INVOCATION,
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_SOURCE_ARGUMENT, "this->"+ name),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_TARGET_ARGUMENT, this.nameAsCopy));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_USE_FRIEND_SETTER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	
	String friendDeleteMethod;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_121);
    getterCall(typeName + "*" + " current", 1);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(friendDeleteMethod);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_124);
    

}

private void getterCall(String assignee, int indent){

String thisCall= getRegistry().use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, name, Boolean.TRUE);
String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, thisCall),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, null /* "0" */));


    stringBuffer.append(TEXT_125);
    stringBuffer.append(StringUtil.indent(getterCall, indent));
    

}

@Override
public void preExecute(){
	this.friendDeleteMethod= getRegistry().use(ICppNameConstants.FRIEND_SETTER, typeName, otherEndTypeName);
}

});

}});

define("cpp.remove.handler.add.at.call.internal", new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String paramName;
	@GenerationProcedureParameter(id = IModelingConstants.ADD_AT_METHOD_NAME) String addAtMethodName;
	@GenerationProcedureParameter(id = IModelingConstants.ADD_METHOD_NAME) String addMethodName;
	@GenerationProcedureParameter(id = IModelingDecisions.ADD_AT_FILTER_DECISION) boolean filterAddAt;
	
@Override
public void execute() {

if(filterAddAt){
	
    stringBuffer.append(TEXT_126);
    stringBuffer.append(addMethodName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_128);
    	
}else{
	
    stringBuffer.append(TEXT_129);
    stringBuffer.append(addAtMethodName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_131);
    
}

}

});

}});


    return stringBuffer.toString();
  }
}