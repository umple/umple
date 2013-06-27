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
import cruise.umple.cpp.utils.*;
import cruise.umple.modeling.handlers.*;
import cruise.umple.modeling.handlers.cpp.*;
import cruise.umple.core.GenerationCallback.*;

@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppAddHandler extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppAddHandler create(String lineSeparator)
  {
    nl = lineSeparator;
    CppAddHandler result = new CppAddHandler();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\tif(";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = ")){" + NL + "\t\tint newIndex= index;" + NL + "\t\tif(index < 0 ) { " + NL + "\t\t\tnewIndex = 0; " + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tint size= this->";
  protected final String TEXT_4 = "();" + NL + "\t\tif(size>0){" + NL + "\t\t\t";
  protected final String TEXT_5 = "\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tsize= this->";
  protected final String TEXT_6 = "();" + NL + "\t\tif(newIndex > size) { " + NL + "\t\t\tnewIndex = size; " + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\twasAdded = true;" + NL + "    }";
  protected final String TEXT_8 = "IndexOf(this->";
  protected final String TEXT_9 = "->begin(), this->";
  protected final String TEXT_10 = "->end(),";
  protected final String TEXT_11 = ")";
  protected final String TEXT_12 = "\twasAdded= this->";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = ", this->";
  protected final String TEXT_15 = "());";
  protected final String TEXT_16 = "\tif (IndexOf(this->";
  protected final String TEXT_17 = "->begin()," + NL + "\t\tthis->";
  protected final String TEXT_18 = "->end(), ";
  protected final String TEXT_19 = ") > -1) {" + NL + "\t\tif (index < 0) {" + NL + "\t\t\tindex = 0;" + NL + "\t\t}" + NL + "\t" + NL + "\t\tint size= this->";
  protected final String TEXT_20 = "();" + NL + "\t\tif (index > size) {" + NL + "\t\t\tindex = size - 1;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn this->";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = ")|" + NL + "\t\t\t\tthis->";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = ", index);" + NL + "\t}" + NL + "\treturn this->";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = ", index);";
  protected final String TEXT_27 = "\t" + NL + "\tif (IndexOf(this->";
  protected final String TEXT_28 = "->begin(), this->";
  protected final String TEXT_29 = "->end(), ";
  protected final String TEXT_30 = ")> -1) {" + NL + "\t\treturn wasAdded;" + NL + "\t}";
  protected final String TEXT_31 = "\t";
  protected final String TEXT_32 = NL + "    ";
  protected final String TEXT_33 = "* ";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = "->";
  protected final String TEXT_36 = "();" + NL + "    if (";
  protected final String TEXT_37 = " != NULL){" + NL + "\t\tif(";
  protected final String TEXT_38 = "->";
  protected final String TEXT_39 = "() <= ";
  protected final String TEXT_40 = "()){" + NL + "\t          return wasAdded;" + NL + "\t\t}else{" + NL + "      \t\t";
  protected final String TEXT_41 = "->";
  protected final String TEXT_42 = "(";
  protected final String TEXT_43 = ");" + NL + "    \t}" + NL + "    }" + NL + "\t";
  protected final String TEXT_44 = NL + "    ";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_47 = "\t";
  protected final String TEXT_48 = NL + "    ";
  protected final String TEXT_49 = "* ";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = "->";
  protected final String TEXT_52 = "();" + NL + "    if (";
  protected final String TEXT_53 = " == NULL){" + NL + "\t\t";
  protected final String TEXT_54 = "->";
  protected final String TEXT_55 = "(this);" + NL + "\t}else if(this!= ";
  protected final String TEXT_56 = "){" + NL + "\t\t";
  protected final String TEXT_57 = "->";
  protected final String TEXT_58 = "(";
  protected final String TEXT_59 = ");" + NL + "\t\tthis->";
  protected final String TEXT_60 = "(";
  protected final String TEXT_61 = ");" + NL + "    }else{" + NL + "    \t";
  protected final String TEXT_62 = NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_63 = "\t" + NL + "\t";
  protected final String TEXT_64 = NL + "\twasAdded = true;" + NL + "\t";
  protected final String TEXT_65 = "\t" + NL + "\tif (";
  protected final String TEXT_66 = "->";
  protected final String TEXT_67 = "(this)!= -1) {" + NL + "\t\twasAdded = true;" + NL + "\t}else{" + NL + "\t\twasAdded = ";
  protected final String TEXT_68 = "->";
  protected final String TEXT_69 = "(this);" + NL + "\t\tif(!wasAdded){" + NL + "      \t\tint currentIndex= this->";
  protected final String TEXT_70 = ";" + NL + "      \t\t";
  protected final String TEXT_71 = NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_72 = "\t" + NL + "\t";
  protected final String TEXT_73 = NL + "\t" + NL + "\tif (";
  protected final String TEXT_74 = "){" + NL + "\t\t";
  protected final String TEXT_75 = "->";
  protected final String TEXT_76 = "(this);" + NL + "    }else{" + NL + "    \t";
  protected final String TEXT_77 = NL + "    }" + NL + "    wasAdded= true;";
  protected final String TEXT_78 = "\t" + NL + "\t";
  protected final String TEXT_79 = NL + "\t" + NL + "\tif (";
  protected final String TEXT_80 = "){" + NL + "\t\tif(";
  protected final String TEXT_81 = "->";
  protected final String TEXT_82 = "() <= ";
  protected final String TEXT_83 = "()){" + NL + "\t\t\treturn wasAdded;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_84 = "->";
  protected final String TEXT_85 = "(this);" + NL + "    }else{" + NL + "\t\t";
  protected final String TEXT_86 = NL + "    }" + NL + "    wasAdded= true;";
  protected final String TEXT_87 = "\t" + NL + "    if (this->";
  protected final String TEXT_88 = "() >= this->";
  protected final String TEXT_89 = "()){" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t}";
  protected final String TEXT_91 = "return wasAdded;";
  protected final String TEXT_92 = "return ";
  protected final String TEXT_93 = ";";
  protected final String TEXT_94 = "* ";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = "->";
  protected final String TEXT_97 = "();" + NL + "\tbool ";
  protected final String TEXT_98 = " = ";
  protected final String TEXT_99 = " != NULL && this!=";
  protected final String TEXT_100 = ";";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

final String isNewVariable= "add.is.new.variable.internal";

getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_AT_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	@GenerationArgument String paramName;
	
	String addMethod, numberOfMethodName, addCall, removeCall;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    stringBuffer.append(addMethod);
    stringBuffer.append(TEXT_2);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(removeCall);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(addCall);
    stringBuffer.append(TEXT_7);
    

}

private StringBuffer indexOf() {
return CodeProcedure.generate(new CodeProcedure(this.getGenerationProcedure()) {
		
	@Override
	public void execute() {
		
    stringBuffer.append(TEXT_8);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_11);
    
	}
});
}

@Override
public void preExecute(){
	this.addMethod= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	
	this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	String thisCall= getRegistry().use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, elementName, Boolean.TRUE);
	
	this.addCall= getRegistry().generationPointString(element, ICppDefinitions.ADD_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_VARIABLE_ARGUMENT, thisCall),
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_INDEX_ARGUMENT, "newIndex"),
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_PARAMETER_ARGUMENT, paramName));
	
	this.removeCall= getRegistry().generationPointString(element, ICppDefinitions.REMOVE_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_VARIABLE_ARGUMENT, thisCall),
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_INDEX_ARGUMENT, indexOf().toString()));
}

});
}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	String numberOfMethodName, addAtMethod, paramName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_12);
    stringBuffer.append(addAtMethod);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_15);
    

}

@Override
public void preExecute(){
	this.paramName= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.addAtMethod= getRegistry().generationPointString(element, ICppNameConstants.ADD_AT, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});
}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_OR_MOVE_AT_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String elementName;
	
	String numberOfMethodName, addAtMethod, removeMethodName, paramName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_16);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( addAtMethod );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( addAtMethod );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_26);
    

}

@Override
public void preExecute(){
	this.paramName= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.addAtMethod= getRegistry().generationPointString(element, ICppNameConstants.ADD_AT, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});
}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_CHECK_EXISTING, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String parameter;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_30);
    

}

});

}});

	
getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;	
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	String friendSetMethod;
	String removeMethodName;
	String instanceAsVariable;
	String numberOfMethodName;
	String existing;
	String minimumNumberMethodName;
	String getter;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(otherEndTypeName );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(getter);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(minimumNumberMethodName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(getGenerationTemplate().generate("cpp.add.handler.add.item.internal", element, name, instanceAsVariable));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(friendSetMethod);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_46);
    

}

@Override
public void preExecute(){
	this.friendSetMethod= getRegistry().use(ICppNameConstants.FRIEND_SETTER, typeName, otherEndTypeName);
	
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.minimumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	
	this.getter= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	this.existing= getRegistry().generationPointString(element, ICppNameConstants.EXISTING, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.instanceAsVariable= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});

}});


getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING_OR_THIS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;	
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	String addMethodName;
	String removeMethodName;
	String instanceAsVariable;
	String existing;
	String getter;
	String setter;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(otherEndTypeName );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(getter);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(setter);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(addMethodName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(getGenerationTemplate().generate("cpp.add.handler.add.item.internal", element, name, instanceAsVariable));
    stringBuffer.append(TEXT_62);
    

}

@Override
public void preExecute(){
	this.getter= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.setter= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.addMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.instanceAsVariable= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.existing= getRegistry().generationPointString(element, ICppNameConstants.EXISTING, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_DIRECTLY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
	@GenerationArgument boolean check;
			
	String instanceAsVariable, otherEndIndexOfMethod, indexOfMethod, addOtherEndMethodName, asIndex, removeCall;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(getGenerationTemplate().generate("cpp.add.handler.add.item.internal", element, name, instanceAsVariable));
    check();
    

}

private void check(){

if(!check){

    stringBuffer.append(TEXT_64);
    
return;
}
	
	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(otherEndIndexOfMethod);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(addOtherEndMethodName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(asIndex);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(removeCall);
    stringBuffer.append(TEXT_71);
    	
}

@Override
public void preExecute(){
	this.otherEndIndexOfMethod= getRegistry().generationPointString(element, ICppNameConstants.INDEX_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.indexOfMethod= getRegistry().generationPointString(element, ICppNameConstants.INDEX_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	
	this.addOtherEndMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	this.addOtherEndMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	this.instanceAsVariable= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	
	this.asIndex= getRegistry().use(ICppDefinitions.METHOD_INVOCATION, indexOfMethod, this.instanceAsVariable);
	
	String thisCall= getRegistry().use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, name, Boolean.TRUE);
	this.removeCall= getRegistry().generationPointString(element, ICppDefinitions.REMOVE_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_VARIABLE_ARGUMENT, thisCall),
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_INDEX_ARGUMENT, "currentIndex"));
	
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_CHECK_NEW_OTHER_EXSITING, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
	String instanceAsVariable, preCode, isNew, setter;

@Override
public void execute() {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(preCode);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(isNew);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(instanceAsVariable );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(setter);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(getGenerationTemplate().generate("cpp.add.handler.add.item.internal", element, name, instanceAsVariable));
    stringBuffer.append(TEXT_77);
    	

}

@Override
public void preExecute(){
this.preCode= getInternalRegistry().generate(isNewVariable, element);
	this.isNew= getRegistry().generationPointString(element, ICppNameConstants.IS_NEW, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.setter= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.instanceAsVariable= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));	
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_SET_IF_NEW, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	
	String isNew, existing, numberOfMethodName, 
		minimumNumberMethodName, instanceAsVariable, preCode, setter;

@Override
public void execute() {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(preCode);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(isNew );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(minimumNumberMethodName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(instanceAsVariable );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(setter);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(getGenerationTemplate().generate("cpp.add.handler.add.item.internal", element, name, instanceAsVariable));
    stringBuffer.append(TEXT_86);
    	

}

@Override
public void preExecute(){
	this.preCode= getInternalRegistry().generate(isNewVariable, element);
	
	this.isNew= getRegistry().generationPointString(element, ICppNameConstants.IS_NEW, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.minimumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	
	this.setter= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
			
	this.existing= getRegistry().generationPointString(element, ICppNameConstants.EXISTING, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.instanceAsVariable= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});

}});


getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_MAXIMUM_CHECK, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	String numberOfMethodName, maximumNumberMethodName;
	
	@GenerationArgument String returnValue;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(numberOfMethodName );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( maximumNumberMethodName );
    stringBuffer.append(TEXT_89);
    setReturnFlag();
    stringBuffer.append(TEXT_90);
    	

}

private void setReturnFlag(){

if(returnValue.isEmpty()){
	
    stringBuffer.append(TEXT_91);
    
	return;
}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(returnValue);
    stringBuffer.append(TEXT_93);
    

}

@Override
public void preExecute(){
	this.maximumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MAXIMUM_NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});

}});

/////////////////////////////////////////////////////////////////Internal///////////////////////////////////////////////////////////////
define(isNewVariable, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	
	String getter, isNew, existing, instanceAsVariable; 
	
@Override
public void execute() {

    stringBuffer.append(otherEndTypeName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(getter);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(isNew);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_100);
    

}

@Override
public void preExecute(){
	this.isNew= getRegistry().generationPointString(element, ICppNameConstants.IS_NEW, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.getter= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.instanceAsVariable= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.existing= getRegistry().generationPointString(element, ICppNameConstants.EXISTING, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});


define("cpp.add.handler.add.item.internal", new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String instanceAsVariable; 
	
@Override
public void execute() {

String thisCall= getRegistry().use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, name, Boolean.TRUE);
String addCall= getRegistry().generationPointString(element, ICppDefinitions.ADD_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_VARIABLE_ARGUMENT, thisCall),
		//GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_INDEX_ARGUMENT, "index"),
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_PARAMETER_ARGUMENT, instanceAsVariable));
		

    stringBuffer.append(addCall);
    

}

});

}});


    return stringBuffer.toString();
  }
}