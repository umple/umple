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
  protected final String TEXT_8 = "new ";
  protected final String TEXT_9 = "()";
  protected final String TEXT_10 = "vector<";
  protected final String TEXT_11 = "*>::iterator _";
  protected final String TEXT_12 = "iterator;" + NL + "_";
  protected final String TEXT_13 = "iterator = ";
  protected final String TEXT_14 = "->begin();";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = "->erase(_";
  protected final String TEXT_17 = "iterator);";
  protected final String TEXT_18 = "set<";
  protected final String TEXT_19 = "*>::iterator _";
  protected final String TEXT_20 = "iterator;";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = "->erase(";
  protected final String TEXT_23 = "->begin());";
  protected final String TEXT_24 = "->erase(";
  protected final String TEXT_25 = "->begin()+";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = "* ";
  protected final String TEXT_28 = "= this->";
  protected final String TEXT_29 = "(";
  protected final String TEXT_30 = ");" + NL + "\t" + NL + "if(";
  protected final String TEXT_31 = "== NULL){" + NL + "\treturn false;" + NL + "}" + NL;
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = "->erase(";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = "->push_back(";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = "->insert(";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = "std::copy(";
  protected final String TEXT_40 = "->begin(), ";
  protected final String TEXT_41 = "->end(), ";
  protected final String TEXT_42 = "->begin());";
  protected final String TEXT_43 = " ";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = ";" + NL;
  protected final String TEXT_46 = "::iterator ";
  protected final String TEXT_47 = "(";
  protected final String TEXT_48 = "->begin());";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = "::iterator ";
  protected final String TEXT_51 = "(";
  protected final String TEXT_52 = "->begin());" + NL + "copySet(";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = " ";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ";" + NL;
  protected final String TEXT_59 = "(*(";
  protected final String TEXT_60 = "))[";
  protected final String TEXT_61 = "];";
  protected final String TEXT_62 = "return ";
  protected final String TEXT_63 = "= ";
  protected final String TEXT_64 = "::iterator ";
  protected final String TEXT_65 = "(";
  protected final String TEXT_66 = "->begin());" + NL;
  protected final String TEXT_67 = "(";
  protected final String TEXT_68 = "*)GetAt(";
  protected final String TEXT_69 = ", ";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = "return ";
  protected final String TEXT_72 = "= ";
  protected final String TEXT_73 = NL + "//A template function to get an item in a set by index" + NL + "template < typename InputIterator> " + NL + "void* GetAt(InputIterator& it, int index) {" + NL + "\tstd::advance(it, index);" + NL + "\treturn *it;" + NL + "};" + NL;
  protected final String TEXT_74 = NL + "//A template function to copy set" + NL + "template<typename InputIterator, typename T>" + NL + "void copySet(InputIterator& it, InputIterator& end ,T* setObj) {\t" + NL + "\tfor (; it != end; ++it) {" + NL + "\t\tsetObj->insert(*it);" + NL + "\t}" + NL + "};" + NL;
  protected final String TEXT_75 = "<";
  protected final String TEXT_76 = ">";
  protected final String TEXT_77 = "*";
  protected final String TEXT_78 = "<";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ">";
  protected final String TEXT_81 = "*";
  protected final String TEXT_82 = NL + "std::for_each(";
  protected final String TEXT_83 = "->begin(), ";
  protected final String TEXT_84 = "->end(), /*std::default_delete<";
  protected final String TEXT_85 = ">*/ deleteElement());";
  protected final String TEXT_86 = NL;
  protected final String TEXT_87 = "->clear();" + NL + "delete ";
  protected final String TEXT_88 = ";";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    


getRegistry().define(ISTLConstants.DEFAULT_TIME_ASSIGN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    

}});

}});

getRegistry().define(ISTLConstants.DEFAULT_DATE_ASSIGN, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

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

@Override
public void execute() {


    stringBuffer.append(TEXT_7);
    

}});

}});

getRegistry().define(ISTLConstants.NEW_LIST_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	String listType;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_8);
    stringBuffer.append(listType);
    stringBuffer.append(TEXT_9);
    

}

@Override
public void preExecute(){
	this.listType= getRegistry().generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME,
		GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT, Boolean.TRUE));	
}

});

}});

getRegistry().define(ISTLConstants.REMOVE_ALL_VECTOR_ELEMENTS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument(id= ICppDefinitions.REMOVE_ALL_TYPE_ARGUMENT) String type;
	@GenerationArgument(id= ICppDefinitions.REMOVE_ALL_VARIABLE_ARGUMENT) String fullName;
	@GenerationArgument(id= ICppDefinitions.REMOVE_ALL_REMOVE_LIST_ARGUMENT) String removeList;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_10);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(removeList);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_17);
    

}

});

}});

getRegistry().define(ISTLConstants.REMOVE_ALL_SET_ELEMENTS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument(id= ICppDefinitions.REMOVE_ALL_TYPE_ARGUMENT) String type;
	@GenerationArgument(id= ICppDefinitions.REMOVE_ALL_VARIABLE_ARGUMENT) String fullName;
	@GenerationArgument(id= ICppDefinitions.REMOVE_ALL_REMOVE_LIST_ARGUMENT) String removeList;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_18);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(removeList);
    stringBuffer.append(TEXT_23);
    

}

});

}});

getRegistry().define(ISTLConstants.REMOVE_VECTOR_ELEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument(id= ICppDefinitions.REMOVE_VARIABLE_ARGUMENT) String fullName;
	@GenerationArgument(id= ICppDefinitions.REMOVE_INDEX_ARGUMENT) String indexVariable;
	
@Override
public void execute() {


    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(indexVariable);
    stringBuffer.append(TEXT_26);
    

}

});

}});

getRegistry().define(ISTLConstants.REMOVE_SET_ELEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	
	@GenerationArgument(id= ICppDefinitions.REMOVE_VARIABLE_ARGUMENT) String fullName;
	@GenerationArgument(id= ICppDefinitions.REMOVE_INDEX_ARGUMENT) String indexVariable;
	
	String getterMethodName, existingVariableName;
	
@Override
public void execute() {


    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(existingVariableName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(indexVariable);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(existingVariableName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(existingVariableName);
    stringBuffer.append(TEXT_34);
    

}

@Override
public void preExecute(){
	this.getterMethodName= getRegistry().generationPointString(element, IModelingConstants.GETTER_BY_INDEX_METHOD_NAME, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	
	this.existingVariableName= getRegistry().generationPointString(element, ICppNameConstants.EXISTING, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));	
}

});

}});

getRegistry().define(ISTLConstants.ADD_VECTOR_ELEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument(id= ICppDefinitions.ADD_VARIABLE_ARGUMENT) String fullName;
	@GenerationArgument(id= ICppDefinitions.ADD_PARAMETER_ARGUMENT) String parameter;
	
@Override
public void execute() {


    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_36);
    

}

});

}});

getRegistry().define(ISTLConstants.ADD_SET_ELEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument(id= ICppDefinitions.ADD_VARIABLE_ARGUMENT) String fullName;
	@GenerationArgument(id= ICppDefinitions.ADD_PARAMETER_ARGUMENT) String parameter;
	
@Override
public void execute() {


    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_38);
    

}

});

}});

getRegistry().define(ISTLConstants.COPY_VECTOR_ELEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument(id= ICppDefinitions.COPY_SOURCE_ARGUMENT) String sourceFullName;
	@GenerationArgument(id= ICppDefinitions.COPY_TARGET_ARGUMENT) String targetFullName;
	@GenerationArgument(id= ICppDefinitions.COPY_IS_INITIALIZED_ARGUMENT) boolean isInitialized;
	
	String listDefinition, listType;
	
@Override
public void execute() {


    initialize();
    stringBuffer.append(TEXT_39);
    stringBuffer.append(sourceFullName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(sourceFullName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(targetFullName);
    stringBuffer.append(TEXT_42);
    

}

private void initialize(){
	if(this.isInitialized){
		return;
	}


    stringBuffer.append(listType);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(targetFullName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_45);
    

}

@Override
public void preExecute(){
	this.listDefinition = getRegistry().generate(ISTLConstants.NEW_LIST_DEFINITION, element);
	this.listType= getRegistry().generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME);
}

});

}});

getRegistry().define(ISTLConstants.COPY_SET_ELEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument(id= ICppDefinitions.COPY_SOURCE_ARGUMENT) String sourceFullName;
	@GenerationArgument(id= ICppDefinitions.COPY_TARGET_ARGUMENT) String targetFullName;
	@GenerationArgument(id= ICppDefinitions.COPY_IS_INITIALIZED_ARGUMENT) boolean isInitialized;
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
	String listDefinition, listType, listIterativeType, beginIterator, endIterator;
	
@Override
public void execute() {


    initialize();
    stringBuffer.append(listIterativeType);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(beginIterator);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(sourceFullName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(listIterativeType);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(endIterator);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(sourceFullName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(beginIterator);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(endIterator);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(targetFullName);
    stringBuffer.append(TEXT_55);
    

}

private void initialize(){
	if(this.isInitialized){
		return;
	}


    stringBuffer.append(listType);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(targetFullName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_58);
    

} 

@Override
public void preExecute(){
	this.listDefinition = getRegistry().generate(ISTLConstants.NEW_LIST_DEFINITION, element);
	this.listType= getRegistry().generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME,
		GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT, Boolean.FALSE));
		
	this.listIterativeType= getRegistry().generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME,
		GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT, Boolean.TRUE));
	
	this.beginIterator= name+ "Begin"+ "Iterator";
	this.endIterator= name+ "End"+ "Iterator";
}

});

}});
	
getRegistry().define(ISTLConstants.GET_VECTOR_ELEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument(id= ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT) String fullName;
	@GenerationArgument(id= ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT) String indexVariable;
	@GenerationArgument(id= ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT) String assignee;
	
@Override
public void execute() {


    setAssigneeOrReturn();
    stringBuffer.append(TEXT_59);
    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(indexVariable);
    stringBuffer.append(TEXT_61);
    

}

private void setAssigneeOrReturn(){
	if(assignee== null|| assignee.isEmpty()){
		
    stringBuffer.append(TEXT_62);
    
		return;
	}
	
    stringBuffer.append(assignee);
    stringBuffer.append(TEXT_63);
    
}

});

}});

getRegistry().define(ISTLConstants.GET_SET_ELEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument(id= ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT) String fullName;
	@GenerationArgument(id= ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT) String indexVariable;
	@GenerationArgument(id= ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT) String type;
	@GenerationArgument(id= ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT) String assignee;
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
	String listIterativeType, beginIterator;
	
@Override
public void execute() {


    stringBuffer.append(listIterativeType);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(beginIterator);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(fullName);
    stringBuffer.append(TEXT_66);
    setAssigneeOrReturn();
    stringBuffer.append(TEXT_67);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(beginIterator);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(indexVariable);
    stringBuffer.append(TEXT_70);
    

}



private void setAssigneeOrReturn(){
	if(assignee== null|| assignee.isEmpty()){
		
    stringBuffer.append(TEXT_71);
    
		return;
	}
	
    stringBuffer.append(assignee);
    stringBuffer.append(TEXT_72);
    
}

@Override
public void preExecute(){
	this.listIterativeType= getRegistry().generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME,
		GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT, Boolean.TRUE));
	
	this.beginIterator= name+ "Begin"+ "Iterator";	
}

});

}});

getRegistry().define(ISTLConstants.GET_SET_ELEMENT_TEMPLATE_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_73);
    

}

});

}});

getRegistry().define(ISTLConstants.COPY_SET_ELEMENT_TEMPLATE_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_74);
    

}

});

}});

getRegistry().define(ISTLConstants.TYPE_AS_LIST, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type;
	@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName;
	@GenerationProcedureParameter(id = ICppDefinitions.IS_POINTER_TYPE) boolean isPointerType;
	@GenerationArgument boolean isPointer;
			
@Override
public void execute() {

    stringBuffer.append(manyTypeName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(type);
    setPointer(isPointerType);
    stringBuffer.append(TEXT_76);
    setPointer(isPointer);
    
}

private void setPointer(boolean flag){
	if(!flag){
		return;
	}
	
    stringBuffer.append(TEXT_77);
    
}

});

}});

getRegistry().define(ISTLConstants.TYPE_AS_SET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type;
	@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName;
	@GenerationProcedureParameter(id = ICppDefinitions.IS_POINTER_TYPE) boolean isPointerType;
	@GenerationArgument(id= ISTLConstants.TYPE_AS_SET_COMPARATOR_ARGUMENT) String comparator;
	@GenerationArgument boolean isPointer;
			
@Override
public void execute() {

    stringBuffer.append(manyTypeName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(type);
    setPointer(isPointerType);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(comparator);
    stringBuffer.append(TEXT_80);
    setPointer(isPointer);
    
}

private void setPointer(boolean flag){
	if(!flag){
		return;
	}
	
    stringBuffer.append(TEXT_81);
    
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


    stringBuffer.append(TEXT_82);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_88);
    

}

});

}});




    return stringBuffer.toString();
  }
}