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
import cruise.umple.modeling.handlers.*;
import cruise.umple.modeling.handlers.cpp.*;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;
import cruise.umple.core.GenerationCallback.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "//------------------------" + NL + "// CONSTRUCTOR";
  protected final String TEXT_5 = NL + "//------------------------";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "S";
  protected final String TEXT_8 = "//------------------------" + NL + "// CONSTRUCTORS ARE DISALLOWED " + NL + "// IN THIS CONTEXT" + NL + "//------------------------" + NL;
  protected final String TEXT_9 = NL + "//------------------------" + NL + "// COPY CONSTRUCTOR" + NL + "//------------------------";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = "& other);";
  protected final String TEXT_13 = NL + "//------------------------" + NL + "// DESTRUCTOR" + NL + "//------------------------" + NL + "virtual ~";
  protected final String TEXT_14 = "()";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = " = 0";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = "::";
  protected final String TEXT_19 = "(";
  protected final String TEXT_20 = ")";
  protected final String TEXT_21 = "{";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL + "}";
  protected final String TEXT_24 = NL + " : ";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = ") ";
  protected final String TEXT_27 = NL + "//------------------------" + NL + "// CONSTRUCTOR IMPLEMENTATION";
  protected final String TEXT_28 = NL + "//------------------------";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = "S";
  protected final String TEXT_31 = NL + "//------------------------" + NL + "// DESTRUCTOR IMPLEMENTATION" + NL + "//------------------------";
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = "::~";
  protected final String TEXT_34 = "(){";
  protected final String TEXT_35 = NL + "\t";
  protected final String TEXT_36 = NL + "}" + NL;
  protected final String TEXT_37 = "this->deleteAssociatedObjects();" + NL;
  protected final String TEXT_38 = "\t" + NL + "\t//";
  protected final String TEXT_39 = "::~";
  protected final String TEXT_40 = "();";
  protected final String TEXT_41 = NL + "//------------------------" + NL + "// COPY CONSTRUCTOR" + NL + "//------------------------";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = "::";
  protected final String TEXT_44 = "(";
  protected final String TEXT_45 = "& other)";
  protected final String TEXT_46 = "{";
  protected final String TEXT_47 = NL;
  protected final String TEXT_48 = "\tinternalCopy(other);";
  protected final String TEXT_49 = NL + "}";
  protected final String TEXT_50 = NL + " : ";
  protected final String TEXT_51 = "(other) ";
  protected final String TEXT_52 = "//------------------------" + NL + "// STREAM DECLARATION" + NL + "//------------------------" + NL + "friend ostream& operator<<(ostream& os, const ";
  protected final String TEXT_53 = " & dt);";
  protected final String TEXT_54 = NL + "//------------------------" + NL + "// STREAM IMPLEMENTATION" + NL + "//------------------------" + NL + "ostream& operator<<(ostream& os, const ";
  protected final String TEXT_55 = "& dt){" + NL + "\tdt.toOstream(os);" + NL + "    return os;" + NL + "}";
  protected final String TEXT_56 = "toOstream";
  protected final String TEXT_57 = "virtual void toOstream(ostream& os) const;";
  protected final String TEXT_58 = NL + "//------------------------" + NL + "// STREAM HELPER IMPLEMENTATION" + NL + "//------------------------" + NL + "void ";
  protected final String TEXT_59 = "::toOstream(ostream& os) const{";
  protected final String TEXT_60 = NL;
  protected final String TEXT_61 = NL + "}" + NL;
  protected final String TEXT_62 = "\t//Empty Stream";
  protected final String TEXT_63 = NL;
  protected final String TEXT_64 = "os";
  protected final String TEXT_65 = "\"";
  protected final String TEXT_66 = "\"";
  protected final String TEXT_67 = " << ";
  protected final String TEXT_68 = " <<";
  protected final String TEXT_69 = " << endl";
  protected final String TEXT_70 = "\"";
  protected final String TEXT_71 = ":\" << thisptr->";
  protected final String TEXT_72 = "()";
  protected final String TEXT_73 = "(";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = "new ";
  protected final String TEXT_76 = "= new ";
  protected final String TEXT_77 = "* ";
  protected final String TEXT_78 = "\"";
  protected final String TEXT_79 = ":\" << this->";
  protected final String TEXT_80 = "()";
  protected final String TEXT_81 = "\"";
  protected final String TEXT_82 = ":\"; this->";
  protected final String TEXT_83 = "!= NULL ?  os << this->";
  protected final String TEXT_84 = " << endl " + NL + "\t\t\t\t\t\t: os << \"NULL\" << endl;";
  protected final String TEXT_85 = "this->";
  protected final String TEXT_86 = ".assign(other.";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = "this->";
  protected final String TEXT_89 = "= other.";
  protected final String TEXT_90 = ";";
  protected final String TEXT_91 = "copyObject(other.";
  protected final String TEXT_92 = ", this->";
  protected final String TEXT_93 = ", sizeof other.";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = "this->";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = ";";
  protected final String TEXT_98 = NL;
  protected final String TEXT_99 = "this->";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ";";
  protected final String TEXT_102 = "this->";
  protected final String TEXT_103 = "= ";
  protected final String TEXT_104 = ";";
  protected final String TEXT_105 = NL + "if (!";
  protected final String TEXT_106 = "(";
  protected final String TEXT_107 = ")){" + NL + "  throw \"Unable to create ";
  protected final String TEXT_108 = " due to ";
  protected final String TEXT_109 = "\";" + NL + "}";
  protected final String TEXT_110 = "this->";
  protected final String TEXT_111 = "= NULL;";
  protected final String TEXT_112 = NL + "if (!";
  protected final String TEXT_113 = "(";
  protected final String TEXT_114 = ")){" + NL + "\t";
  protected final String TEXT_115 = NL + "}";
  protected final String TEXT_116 = "throw \"Unable to create ";
  protected final String TEXT_117 = ", must have at least ";
  protected final String TEXT_118 = " ";
  protected final String TEXT_119 = "\";";
  protected final String TEXT_120 = "throw \"Unable to create ";
  protected final String TEXT_121 = ", must have ";
  protected final String TEXT_122 = " to ";
  protected final String TEXT_123 = " ";
  protected final String TEXT_124 = "\";";
  protected final String TEXT_125 = "this->";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = ";";
  protected final String TEXT_128 = NL + "if (";
  protected final String TEXT_129 = " == NULL || ";
  protected final String TEXT_130 = "->";
  protected final String TEXT_131 = "() != NULL){" + NL + "  throw \"Unable to create ";
  protected final String TEXT_132 = " due to ";
  protected final String TEXT_133 = "\";" + NL + "}";
  protected final String TEXT_134 = NL;
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = ";";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
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
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_3);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_DECLARATIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String contents;
	@GenerationArgument boolean isMany;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_4);
    setIsMany();
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(contents);
    

}

private void setIsMany(){
if(!isMany){
	return;
}


    stringBuffer.append(TEXT_7);
    

}

});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_NO_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_8);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_12);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.DESTRUCTOR_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	@GenerationArgument(id= ICppDefinitions.METHOD_PURE) boolean isPure;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_13);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_14);
    setPure();
    stringBuffer.append(TEXT_15);
    

}

private void setPure(){
	if(!isPure){
		return;
	}
	
    stringBuffer.append(TEXT_16);
    
}

});
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


    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_20);
    safeParentCall(parentClass, parentsParameters);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(before);
    stringBuffer.append(body);
    stringBuffer.append(after);
    stringBuffer.append(TEXT_23);
    

}

private void safeParentCall(String parentClassValue, String val){
if(parentClassValue.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(parentClassValue);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_26);
    

}

});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String contents;
	@GenerationArgument boolean isMany;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_27);
    setIsMany();
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(contents);
    

}

private void setIsMany(){
if(!isMany){
	return;
}


    stringBuffer.append(TEXT_30);
    

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
	@GenerationArgument boolean isVirtual;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_34);
    safeParentCall(parentClass);
    stringBuffer.append(TEXT_35);
    removeAssociatedObjectsCall();
    setBody();
    stringBuffer.append(TEXT_36);
    

}

private void removeAssociatedObjectsCall(){
	if(isVirtual){
		return;
	}
	

    stringBuffer.append(TEXT_37);
    
}

private void setBody(){
	if(body.isEmpty()){
		return;
	}
	

    stringBuffer.append(body);
    
}

private void safeParentCall(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_40);
    

}

});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String parentClass;
	
	@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_BEFORE) String before;
	@GenerationProcedureParameter(id = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_IMPLEMENTATION_AFTER) String after;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_45);
    safeParentCall(parentClass);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(before);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(after);
    stringBuffer.append(TEXT_49);
    
}

private void safeParentCall(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_51);
    

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


    stringBuffer.append(TEXT_52);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_53);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_54);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_55);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_METHOD_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_56);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_57);
    

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

    stringBuffer.append(TEXT_58);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(before);
    content();
    stringBuffer.append(TEXT_61);
    

}

private void content(){
if(contents.isEmpty()){

    stringBuffer.append(TEXT_62);
    

	return;
}

    stringBuffer.append(TEXT_63);
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

    stringBuffer.append(TEXT_64);
    

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
	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_66);
    
}

}

private void setStart(){
if(!isStart){
	return;
}


    stringBuffer.append(TEXT_67);
    

}

private void setEnd(){
if(!isEnd){
	return;
}


    stringBuffer.append(TEXT_68);
    

}



});
}});


getRegistry().define(IModelingConstructorDefinitionsConstants.STREAM_NEW_LINE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_69);
    

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

    stringBuffer.append(TEXT_70);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(getterMethod);
    stringBuffer.append(TEXT_72);
    

}

});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCT_CLASS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String constructArguments;
	@GenerationArgument String type;
	@GenerationArgument String name;
	@GenerationArgument boolean define;

@Override
public void execute() {


    setType();
    setName();
    stringBuffer.append(type);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(constructArguments);
    stringBuffer.append(TEXT_74);
    

}

private void setName(){
	if(name.isEmpty()){
		
    stringBuffer.append(TEXT_75);
    
		return;
	}

	
    stringBuffer.append(name);
    stringBuffer.append(TEXT_76);
    	
}

private void setType(){
	if(!define){
		return;
	}

	
    stringBuffer.append(type);
    stringBuffer.append(TEXT_77);
    	
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

    stringBuffer.append(TEXT_78);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_79);
    set();
    

}

private void set(){
if(name.isEmpty()){
	
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_80);
    
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

    stringBuffer.append(TEXT_81);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_84);
    
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

    stringBuffer.append(TEXT_85);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_87);
    

}});

}});

getRegistry().define(ICppDefinitions.COPY_PRIMITIVE_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_90);
    

}});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_94);
    

}});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_COLLECTION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name, copyCall;
	String listDefinition;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(copyCall);
    

}

@Override
public void preExecute(){
	this.listDefinition= getRegistry().generate(ISTLConstants.NEW_LIST_DEFINITION, element);

	this.copyCall= getRegistry().generationPointString(element, ICppDefinitions.COPY_INVOCATION,
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_SOURCE_ARGUMENT, "other." + name),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_TARGET_ARGUMENT, "this->" + name),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_IS_INITIALIZED_ARGUMENT, Boolean.TRUE));
}


});

}});


getRegistry().define(IModelingConstructorDefinitionsConstants.DEFAULT_ASSIGN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationProcedureParameter(id = IModelingDecisions.DEFAULT_LANGUAGE_TYPE_VALUE) String value;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_101);
    

}

});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_ASSIGN_DIRECTLY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationArgument String nameAsVariable;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_104);
    

}});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.SET_AND_CHECK, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(final Object element, final Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherTypeName;
	@GenerationArgument String nameAsVariable;
	
	@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent;
	
	String setterMethodName;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_109);
    

}

@Override
public void preExecute(){
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

@Override
public void postExecute(){
	getRegistry().addUniqueValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PRE_IMPLEMENTATION, 
					nullifyCall().toString(), parent);
}

private StringBuffer nullifyCall(){

return CodeProcedure.generate(new CodeProcedure(getGenerationProcedure(), element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_110);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_111);
    

}});

}

});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(final Object element, final Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherTypeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound;
	@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound;
	@GenerationArgument String nameAsVariable;
	@GenerationArgument boolean set;
	
	@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent;
	
	String setterMethodName, listDefinition;
			
@Override
public void execute() {

    setAndCheck();
    
}

private void setAndCheck() {
	if(!set){
		return;
	}


    stringBuffer.append(TEXT_112);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_114);
    boundaries();
    stringBuffer.append(TEXT_115);
    	
	
}

private void boundaries() {
	if(upperBound==-1|| upperBound==1|| lowerBound== upperBound){
		lower();
	}else{
		lowerAndUpper();
	}
}

private void lower() {
	
    stringBuffer.append(TEXT_116);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(lowerBound);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_119);
    
}

private void lowerAndUpper() {
	
    stringBuffer.append(TEXT_120);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(lowerBound);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_124);
    
}

@Override
public void preExecute(){
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.listDefinition= getRegistry().generate(ISTLConstants.NEW_LIST_DEFINITION, element);
}

@Override
public void postExecute(){
	getRegistry().addUniqueValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PRE_IMPLEMENTATION, 
					initList().toString(), parent);
}

private StringBuffer initList(){

return CodeProcedure.generate(new CodeProcedure(getGenerationProcedure(), element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_125);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_127);
    

}});

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

    stringBuffer.append(TEXT_128);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_136);
    

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