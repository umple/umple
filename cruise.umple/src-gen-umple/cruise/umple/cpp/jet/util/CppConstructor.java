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
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;

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
  protected final String TEXT_5 = "//------------------------" + NL + "// CONSTRUCTORS ARE DISALLOWED " + NL + "// IN THIS CONTEXT" + NL + "//------------------------" + NL;
  protected final String TEXT_6 = NL + "//------------------------" + NL + "// COPY CONSTRUCTOR" + NL + "//------------------------";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = "& other);";
  protected final String TEXT_10 = NL + "//------------------------" + NL + "// DESTRUCTOR" + NL + "//------------------------" + NL + "virtual ~";
  protected final String TEXT_11 = "()";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = " = 0";
  protected final String TEXT_14 = NL + "//------------------------" + NL + "// CONSTRUCTOR IMPLEMENTATION" + NL + "//------------------------";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = "::";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ")";
  protected final String TEXT_19 = "{";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL + "}";
  protected final String TEXT_22 = NL + " : ";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = ") ";
  protected final String TEXT_25 = NL + "//------------------------" + NL + "// DESTRUCTOR IMPLEMENTATION" + NL + "//------------------------";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = "::~";
  protected final String TEXT_28 = "(){";
  protected final String TEXT_29 = NL + "\t";
  protected final String TEXT_30 = NL + "}" + NL;
  protected final String TEXT_31 = "this->deleteAssociatedObjects();" + NL;
  protected final String TEXT_32 = "\t" + NL + "\t//";
  protected final String TEXT_33 = "::~";
  protected final String TEXT_34 = "();";
  protected final String TEXT_35 = NL + "//------------------------" + NL + "// COPY CONSTRUCTOR" + NL + "//------------------------";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = "::";
  protected final String TEXT_38 = "(";
  protected final String TEXT_39 = "& other)";
  protected final String TEXT_40 = "{";
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = "\tinternalCopy(other);";
  protected final String TEXT_43 = NL + "}";
  protected final String TEXT_44 = NL + " : ";
  protected final String TEXT_45 = "(other) ";
  protected final String TEXT_46 = "//------------------------" + NL + "// STREAM DECLARATION" + NL + "//------------------------" + NL + "friend ostream& operator<<(ostream& os, const ";
  protected final String TEXT_47 = " & dt);";
  protected final String TEXT_48 = NL + "//------------------------" + NL + "// STREAM IMPLEMENTATION" + NL + "//------------------------" + NL + "ostream& operator<<(ostream& os, const ";
  protected final String TEXT_49 = "& dt){" + NL + "\tdt.toOstream(os);" + NL + "    return os;" + NL + "}";
  protected final String TEXT_50 = "toOstream";
  protected final String TEXT_51 = "virtual void toOstream(ostream& os) const;";
  protected final String TEXT_52 = NL + "//------------------------" + NL + "// STREAM HELPER IMPLEMENTATION" + NL + "//------------------------" + NL + "void ";
  protected final String TEXT_53 = "::toOstream(ostream& os) const{";
  protected final String TEXT_54 = NL;
  protected final String TEXT_55 = NL + "}" + NL;
  protected final String TEXT_56 = "\t//Empty Stream";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = "os";
  protected final String TEXT_59 = "\"";
  protected final String TEXT_60 = "\"";
  protected final String TEXT_61 = " << ";
  protected final String TEXT_62 = " <<";
  protected final String TEXT_63 = " << endl";
  protected final String TEXT_64 = "\"";
  protected final String TEXT_65 = ":\" << thisptr->";
  protected final String TEXT_66 = "()";
  protected final String TEXT_67 = "\"";
  protected final String TEXT_68 = ":\" << this->";
  protected final String TEXT_69 = "()";
  protected final String TEXT_70 = "\"";
  protected final String TEXT_71 = ":\"; this->";
  protected final String TEXT_72 = "!= NULL ?  os << this->";
  protected final String TEXT_73 = " << endl " + NL + "\t\t\t\t\t\t: os << \"NULL\" << endl;";
  protected final String TEXT_74 = "memcpy(&other.";
  protected final String TEXT_75 = ",&this->";
  protected final String TEXT_76 = ", sizeof other.";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = "this->";
  protected final String TEXT_79 = "= other.";
  protected final String TEXT_80 = ";";
  protected final String TEXT_81 = "copyObject(other.";
  protected final String TEXT_82 = ", this->";
  protected final String TEXT_83 = ", sizeof other.";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = "this->";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ";";
  protected final String TEXT_88 = NL;
  protected final String TEXT_89 = "this->";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = ";";
  protected final String TEXT_92 = "this->";
  protected final String TEXT_93 = "= ";
  protected final String TEXT_94 = ";";
  protected final String TEXT_95 = NL + "if (!";
  protected final String TEXT_96 = "(";
  protected final String TEXT_97 = ")){" + NL + "  throw \"Unable to create ";
  protected final String TEXT_98 = " due to ";
  protected final String TEXT_99 = "\";" + NL + "}";
  protected final String TEXT_100 = "this->";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = NL + "if (!";
  protected final String TEXT_104 = "(";
  protected final String TEXT_105 = ")){" + NL + "\t";
  protected final String TEXT_106 = NL + "}";
  protected final String TEXT_107 = "throw \"Unable to create ";
  protected final String TEXT_108 = ", must have at least ";
  protected final String TEXT_109 = " ";
  protected final String TEXT_110 = "\";";
  protected final String TEXT_111 = "throw \"Unable to create ";
  protected final String TEXT_112 = ", must have ";
  protected final String TEXT_113 = " to ";
  protected final String TEXT_114 = " ";
  protected final String TEXT_115 = "\";";
  protected final String TEXT_116 = NL + "if (";
  protected final String TEXT_117 = " == NULL || ";
  protected final String TEXT_118 = "->";
  protected final String TEXT_119 = "() != NULL){" + NL + "  throw \"Unable to create ";
  protected final String TEXT_120 = " due to ";
  protected final String TEXT_121 = "\";" + NL + "}";
  protected final String TEXT_122 = NL;
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = ";";

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
    stringBuffer.append(TEXT_2);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_4);
    

}});
}});


getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_NO_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_5);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_9);
    

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


    stringBuffer.append(TEXT_10);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_11);
    setPure();
    stringBuffer.append(TEXT_12);
    

}

private void setPure(){
	if(!isPure){
		return;
	}
	
    stringBuffer.append(TEXT_13);
    
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


    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_18);
    safeParentCall(parentClass, parentsParameters);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(before);
    stringBuffer.append(body);
    stringBuffer.append(after);
    stringBuffer.append(TEXT_21);
    

}

private void safeParentCall(String parentClassValue, String val){
if(parentClassValue.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(parentClassValue);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_24);
    

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


    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_28);
    safeParentCall(parentClass);
    stringBuffer.append(TEXT_29);
    removeAssociatedObjectsCall();
    setBody();
    stringBuffer.append(TEXT_30);
    

}

private void removeAssociatedObjectsCall(){
	if(isVirtual){
		return;
	}
	

    stringBuffer.append(TEXT_31);
    
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

    stringBuffer.append(TEXT_32);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_34);
    

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


    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_39);
    safeParentCall(parentClass);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(before);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(after);
    stringBuffer.append(TEXT_43);
    
}

private void safeParentCall(String val){
if(val.isEmpty()){
	return;
}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(val);
    stringBuffer.append(TEXT_45);
    

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


    stringBuffer.append(TEXT_46);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_47);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_48);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_49);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_METHOD_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_50);
    

}});
}});

getRegistry().define(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_HELPER_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_51);
    

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

    stringBuffer.append(TEXT_52);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(before);
    content();
    stringBuffer.append(TEXT_55);
    

}

private void content(){
if(contents.isEmpty()){

    stringBuffer.append(TEXT_56);
    

	return;
}

    stringBuffer.append(TEXT_57);
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

    stringBuffer.append(TEXT_58);
    

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
	
    stringBuffer.append(TEXT_59);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_60);
    
}

}

private void setStart(){
if(!isStart){
	return;
}


    stringBuffer.append(TEXT_61);
    

}

private void setEnd(){
if(!isEnd){
	return;
}


    stringBuffer.append(TEXT_62);
    

}



});
}});


getRegistry().define(IModelingConstructorDefinitionsConstants.STREAM_NEW_LINE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_63);
    

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

    stringBuffer.append(TEXT_64);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(getterMethod);
    stringBuffer.append(TEXT_66);
    

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

    stringBuffer.append(TEXT_67);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_68);
    set();
    

}

private void set(){
if(name.isEmpty()){
	
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_69);
    
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

    stringBuffer.append(TEXT_70);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_73);
    
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

    stringBuffer.append(TEXT_74);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_77);
    

}});

}});

getRegistry().define(ICppDefinitions.COPY_PRIMITIVE_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_80);
    

}});

}});

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_ATTRIBUTE, new GenerationProcdure(this){
	
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

getRegistry().define(IModelingConstructorDefinitionsConstants.COPY_COLLECTION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name, copyCall;
	String listDefinition;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(TEXT_88);
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

    stringBuffer.append(TEXT_89);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_91);
    

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

    stringBuffer.append(TEXT_92);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_94);
    

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

    stringBuffer.append(TEXT_95);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_99);
    

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
	@GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound;
	@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound;
	@GenerationArgument String nameAsVariable;
	@GenerationArgument boolean set;
	
	String setterMethodName, listDefinition;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_102);
    setAndCheck();
    
}

private void setAndCheck() {
	if(!set){
		return;
	}


    stringBuffer.append(TEXT_103);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_105);
    boundaries();
    stringBuffer.append(TEXT_106);
    	
	
}

private void boundaries() {
	if(upperBound==-1|| upperBound==1|| lowerBound== upperBound){
		lower();
	}else{
		lowerAndUpper();
	}
}

private void lower() {
	
    stringBuffer.append(TEXT_107);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(lowerBound);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_110);
    
}

private void lowerAndUpper() {
	
    stringBuffer.append(TEXT_111);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(lowerBound);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_115);
    
}

@Override
public void preExecute(){
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.listDefinition= getRegistry().generate(ISTLConstants.NEW_LIST_DEFINITION, element);
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

    stringBuffer.append(TEXT_116);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(otherTypeName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_124);
    

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