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
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;


@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppConstructor extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppConstructor create(String lineSeparator)
  {
    nl = lineSeparator;
    CppConstructor result = new CppConstructor();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//------------------------" + NL + "// CONSTRUCTOR" + NL + "//------------------------";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "(";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "//------------------------" + NL + "// COPY CONSTRUCTOR" + NL + "//------------------------";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = "& other);";
  protected final String TEXT_9 = NL + "//------------------------" + NL + "// DESTRUCTOR" + NL + "//------------------------" + NL + "virtual ~";
  protected final String TEXT_10 = "();";
  protected final String TEXT_11 = NL + "//------------------------" + NL + "// CONSTRUCTOR IMPLEMENTATION" + NL + "//------------------------";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = "::";
  protected final String TEXT_14 = "(";
  protected final String TEXT_15 = ")";
  protected final String TEXT_16 = "{";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "}";
  protected final String TEXT_19 = NL + " : ";
  protected final String TEXT_20 = "(";
  protected final String TEXT_21 = ") ";
  protected final String TEXT_22 = NL + "//------------------------" + NL + "// DESTRUCTOR IMPLEMENTATION" + NL + "//------------------------";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = "::~";
  protected final String TEXT_25 = "(){";
  protected final String TEXT_26 = NL + "\tthis->deleteAssociatedObjects();";
  protected final String TEXT_27 = NL + "}" + NL;
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = "\t" + NL + "\t//";
  protected final String TEXT_30 = "::~";
  protected final String TEXT_31 = "();";
  protected final String TEXT_32 = NL + "//------------------------" + NL + "// COPY CONSTRUCTOR" + NL + "//------------------------";
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = "::";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = "& other)";
  protected final String TEXT_37 = "{";
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = NL + "}";
  protected final String TEXT_40 = NL + " : ";
  protected final String TEXT_41 = "(other) ";
  protected final String TEXT_42 = "//------------------------" + NL + "// STREAM DECLARATION" + NL + "//------------------------" + NL + "friend ostream& operator<<(ostream& os, const ";
  protected final String TEXT_43 = " & dt);";
  protected final String TEXT_44 = NL + "//------------------------" + NL + "// STREAM IMPLEMENTATION" + NL + "//------------------------" + NL + "ostream& operator<<(ostream& os, const ";
  protected final String TEXT_45 = "& dt){" + NL + "\tdt.toOstream(os);" + NL + "    return os;" + NL + "}";
  protected final String TEXT_46 = "toOstream";
  protected final String TEXT_47 = "virtual void toOstream(ostream& os) const;";
  protected final String TEXT_48 = NL + "//------------------------" + NL + "// STREAM HELPER IMPLEMENTATION" + NL + "//------------------------" + NL + "void ";
  protected final String TEXT_49 = "::toOstream(ostream& os) const{";
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL + "}" + NL;
  protected final String TEXT_52 = NL + "\t//Empty Stream";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = "os";
  protected final String TEXT_55 = "\"";
  protected final String TEXT_56 = "\"";
  protected final String TEXT_57 = " << ";
  protected final String TEXT_58 = " <<";
  protected final String TEXT_59 = " << endl";
  protected final String TEXT_60 = "\"";
  protected final String TEXT_61 = ":\" << thisptr->";
  protected final String TEXT_62 = "()";
  protected final String TEXT_63 = "\"";
  protected final String TEXT_64 = ":\" << this->";
  protected final String TEXT_65 = "()";
  protected final String TEXT_66 = "os << \"";
  protected final String TEXT_67 = ":\"; this->";
  protected final String TEXT_68 = "!= NULL ?  os << this->";
  protected final String TEXT_69 = " << endl " + NL + "\t\t\t\t\t\t: os << \"NULL\" << endl;";
  protected final String TEXT_70 = "memcpy(&other.";
  protected final String TEXT_71 = ",&this->";
  protected final String TEXT_72 = ", sizeof other.";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = "this->";
  protected final String TEXT_75 = "= other.";
  protected final String TEXT_76 = ";";
  protected final String TEXT_77 = "copyObject(other.";
  protected final String TEXT_78 = ", this->";
  protected final String TEXT_79 = ", sizeof other.";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = "std::copy(other.";
  protected final String TEXT_82 = "->begin(), other.";
  protected final String TEXT_83 = "->end(), this->";
  protected final String TEXT_84 = "->begin());";
  protected final String TEXT_85 = "this->";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ";";
  protected final String TEXT_88 = "this->";
  protected final String TEXT_89 = "= ";
  protected final String TEXT_90 = ";";
  protected final String TEXT_91 = NL + "if (!";
  protected final String TEXT_92 = "(";
  protected final String TEXT_93 = ")){" + NL + "  throw \"Unable to create ";
  protected final String TEXT_94 = " due to ";
  protected final String TEXT_95 = "\";" + NL + "}";
  protected final String TEXT_96 = "this->";
  protected final String TEXT_97 = " = new vector<";
  protected final String TEXT_98 = "*>();";
  protected final String TEXT_99 = NL + "if (!";
  protected final String TEXT_100 = "(";
  protected final String TEXT_101 = ")){" + NL + "\t";
  protected final String TEXT_102 = NL + "}";
  protected final String TEXT_103 = "throw \"Unable to create ";
  protected final String TEXT_104 = ", must have at least ";
  protected final String TEXT_105 = " ";
  protected final String TEXT_106 = "\";";
  protected final String TEXT_107 = "throw \"Unable to create ";
  protected final String TEXT_108 = ", must have ";
  protected final String TEXT_109 = " to ";
  protected final String TEXT_110 = " ";
  protected final String TEXT_111 = "\";";
  protected final String TEXT_112 = NL + "if (";
  protected final String TEXT_113 = " == NULL || ";
  protected final String TEXT_114 = "->";
  protected final String TEXT_115 = "() != NULL){" + NL + "  throw \"Unable to create ";
  protected final String TEXT_116 = " due to ";
  protected final String TEXT_117 = "\";" + NL + "}";
  protected final String TEXT_118 = NL;
  protected final String TEXT_119 = " = ";
  protected final String TEXT_120 = ";";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	@GenerationArgument String parameters;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_4);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_8);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.DESTRUCTOR_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_9);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_10);
    

}});
}});


getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String parameters;
	@GenerationArgument String body;
	@GenerationArgument String parentClass;
	@GenerationArgument String parentsParameters;
	
	@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_BEFORE) String before;
	@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_AFTER) String after;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_15);
    safeParentCall(parentClass, parentsParameters);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(before);
    stringBuffer.append(body);
    stringBuffer.append(after);
    stringBuffer.append(TEXT_18);
    

}

private void safeParentCall(String parentClassValue, String val){
if(parentClassValue.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(parentClassValue);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_21);
    

}

});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.DESTRUCTOR_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String parentClass;
	@GenerationArgument String body;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_25);
    safeParentCall(parentClass);
    stringBuffer.append(TEXT_26);
    setBody();
    stringBuffer.append(TEXT_27);
    

}

private void setBody(){
	if(body.isEmpty()){
		return;
	}
	

    stringBuffer.append(TEXT_28);
    stringBuffer.append(body);
    
}

private void safeParentCall(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_31);
    

}

});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String body;
	@GenerationArgument String parentClass;
	
	@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_BEFORE) String before;
	@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_AFTER) String after;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_36);
    safeParentCall(parentClass);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(before);
    stringBuffer.append(body);
    stringBuffer.append(after);
    stringBuffer.append(TEXT_39);
    
}

private void safeParentCall(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_41);
    

}

});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_42);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_43);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_44);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_45);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_METHOD_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_46);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_47);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String contents;
	@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_IMPLEMENTATION_BEFORE) String before;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(before);
    content();
    stringBuffer.append(TEXT_51);
    

}

private void content(){
if(contents.isEmpty()){

    stringBuffer.append(TEXT_52);
    

	return;
}

    stringBuffer.append(TEXT_53);
    stringBuffer.append(indent(contents, 1));
    

}


});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.STREAM_IDENTIFIER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {

    stringBuffer.append(TEXT_54);
    

}});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.STREAM_VALUE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String value;
	@GenerationArgument boolean isStart;
	@GenerationArgument boolean isEnd;
	@GenerationArgument boolean isVariable;

@Override
public void execute() {


    setStart();
    setValue();
    setEnd();
    

}

private void setValue(){

if(isVariable){
	
    stringBuffer.append(value);
    	
}else{
	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_56);
    
}

}

private void setStart(){
if(!isStart){
	return;
}


    stringBuffer.append(TEXT_57);
    

}

private void setEnd(){
if(!isEnd){
	return;
}


    stringBuffer.append(TEXT_58);
    

}



});
}});


getRegistry().define(IModelingConstructorDefinitionsConstants.STREAM_NEW_LINE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_59);
    

}});
}});


getRegistry().define(IModelingConstructorDefinitionsConstants.STREAM_CONST_GETTER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String getterMethod;
		
@Override
public void execute() {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(getterMethod);
    stringBuffer.append(TEXT_62);
    

}

});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.STREAM_PRIMITIVE_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	String getterMethodName;
		
@Override
public void execute() {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_64);
    set();
    

}

private void set(){
if(name.isEmpty()){
	
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_65);
    
}else{
	
    stringBuffer.append(name);
    
}

}

@Override
public void preExecute(){
	this.getterMethodName= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.STREAM_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
			
@Override
public void execute() {
	set();
}

private void set(){

    stringBuffer.append(TEXT_66);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_69);
    
}

});

}});

getRegistry().define(ICppDefinitions.COPY_STRING_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_73);
    

}});

}});

getRegistry().define(ICppDefinitions.COPY_PRIMITIVE_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_76);
    

}});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_80);
    

}});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_COLLECTION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_84);
    

}});

}});


getRegistry().define(IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationProcedureParameter(id = IModelingDecisions.DEFAULT_LANGUAGE_TYPE_VALUE) String value;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_87);
    

}

});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_ASSIGN_DIRECTLY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = NAME) String name;
	@GenerationArgument String nameAsVariable;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_90);
    

}});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.SET_AND_CHECK, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherTypeName;
	@GenerationArgument String nameAsVariable;
	
	String setterMethodName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_95);
    

}

@Override
public void preExecute(){
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherTypeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	@GenerationElementParameter(id = LOWER_BOUND) int lowerBound;
	@GenerationElementParameter(id = UPPER_BOUND) int upperBound;
	@GenerationArgument String nameAsVariable;
	@GenerationArgument boolean set;
	
	String setterMethodName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_98);
    setAndCheck();
    
}

private void setAndCheck() {
	if(!set){
		return;
	}


    stringBuffer.append(TEXT_99);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_101);
    boundaries();
    stringBuffer.append(TEXT_102);
    	
	
}

private void boundaries() {
	if(upperBound==-1|| upperBound==1|| lowerBound== upperBound){
		lower();
	}else{
		lowerAndUpper();
	}
}

private void lower() {
	
    stringBuffer.append(TEXT_103);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(lowerBound);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_106);
    
}

private void lowerAndUpper() {
	
    stringBuffer.append(TEXT_107);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(lowerBound);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_111);
    
}

@Override
public void preExecute(){
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});

}});


getRegistry().define(IModelingConstructorDefinitionsConstants.SET_CHECK_OTHER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherTypeName;
	@GenerationArgument String nameAsVariable;
	
	String getterMethodName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_120);
    

}

@Override
public void preExecute(){
	this.getterMethodName= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});


    return stringBuffer.toString();
  }
}