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
import cruise.umple.cpp.CppGenerationTemplate;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.cpp.ICppAssociationsDefinitionsConstants;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;


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
  protected final String TEXT_1 = "\tthis->";
  protected final String TEXT_2 = "->insert(this->";
  protected final String TEXT_3 = "->begin()+ index -1, ";
  protected final String TEXT_4 = ");" + NL + "\treturn IndexOf(this->";
  protected final String TEXT_5 = "->begin(), this->";
  protected final String TEXT_6 = "->end(),";
  protected final String TEXT_7 = ")>-1;";
  protected final String TEXT_8 = "\tif (IndexOf(this->";
  protected final String TEXT_9 = "->begin()," + NL + "\t\tthis->";
  protected final String TEXT_10 = "->end(), ";
  protected final String TEXT_11 = ") > -1) {" + NL + "\t\tif (index < 0) {" + NL + "\t\t\tindex = 0;" + NL + "\t\t}" + NL + "\t" + NL + "\t\tint size= this->";
  protected final String TEXT_12 = "();" + NL + "\t\tif (index > size) {" + NL + "\t\t\tindex = size - 1;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn this->";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = ")|" + NL + "\t\t\t\tthis->";
  protected final String TEXT_15 = "(";
  protected final String TEXT_16 = ", index);" + NL + "\t}" + NL + "\treturn this->";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ", index);";
  protected final String TEXT_19 = "\t" + NL + "\tif (IndexOf(this->";
  protected final String TEXT_20 = "->begin(), this->";
  protected final String TEXT_21 = "->end(), ";
  protected final String TEXT_22 = ")> -1) {" + NL + "\t\treturn wasAdded;" + NL + "\t}";
  protected final String TEXT_23 = "\t";
  protected final String TEXT_24 = NL + "    ";
  protected final String TEXT_25 = "* ";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = "->";
  protected final String TEXT_28 = "();" + NL + "    if (";
  protected final String TEXT_29 = " != NULL){" + NL + "\t\tif(";
  protected final String TEXT_30 = "->";
  protected final String TEXT_31 = "() <= ";
  protected final String TEXT_32 = "()){" + NL + "\t          return wasAdded;" + NL + "\t\t}else{" + NL + "      \t\t";
  protected final String TEXT_33 = "->";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = ");" + NL + "    \t}" + NL + "    }" + NL + "" + NL + "    this->";
  protected final String TEXT_36 = "->push_back(";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "    ";
  protected final String TEXT_39 = "(";
  protected final String TEXT_40 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_41 = "\t";
  protected final String TEXT_42 = NL + "    ";
  protected final String TEXT_43 = "* ";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = "->";
  protected final String TEXT_46 = "();" + NL + "    if (";
  protected final String TEXT_47 = " == NULL){" + NL + "\t\t";
  protected final String TEXT_48 = "->";
  protected final String TEXT_49 = "(this);" + NL + "\t}else if(this!= ";
  protected final String TEXT_50 = "){" + NL + "\t\t";
  protected final String TEXT_51 = "->";
  protected final String TEXT_52 = "(";
  protected final String TEXT_53 = ");" + NL + "\t\tthis->";
  protected final String TEXT_54 = "(";
  protected final String TEXT_55 = ");" + NL + "    }else{" + NL + "    \tthis->";
  protected final String TEXT_56 = "->push_back(";
  protected final String TEXT_57 = ");\t" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_58 = "\t" + NL + "\tthis->";
  protected final String TEXT_59 = "->push_back(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\twasAdded = true;";
  protected final String TEXT_62 = "\t" + NL + "\tif (";
  protected final String TEXT_63 = "->";
  protected final String TEXT_64 = "(this)!= -1) {" + NL + "\t\twasAdded = true;" + NL + "\t}else{" + NL + "\t\twasAdded = ";
  protected final String TEXT_65 = "->";
  protected final String TEXT_66 = "(this);" + NL + "\t\tif(!wasAdded){" + NL + "      \t\tthis->";
  protected final String TEXT_67 = "(";
  protected final String TEXT_68 = ");" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_69 = "\t" + NL + "\t";
  protected final String TEXT_70 = NL + "\t" + NL + "\tif (";
  protected final String TEXT_71 = "){" + NL + "\t\t";
  protected final String TEXT_72 = "->";
  protected final String TEXT_73 = "(this);" + NL + "    }else{" + NL + "      this->";
  protected final String TEXT_74 = "->push_back(";
  protected final String TEXT_75 = ");" + NL + "    }";
  protected final String TEXT_76 = "\t" + NL + "\t";
  protected final String TEXT_77 = NL + "\t" + NL + "\tif (";
  protected final String TEXT_78 = "){" + NL + "\t\tif(";
  protected final String TEXT_79 = "->";
  protected final String TEXT_80 = "() <= ";
  protected final String TEXT_81 = "()){" + NL + "\t\t\treturn wasAdded;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_82 = "->";
  protected final String TEXT_83 = "(this);" + NL + "    }else{" + NL + "\t\tthis->";
  protected final String TEXT_84 = "->push_back(";
  protected final String TEXT_85 = ");" + NL + "    }";
  protected final String TEXT_86 = "\t" + NL + "    if (this->";
  protected final String TEXT_87 = "() >= this->";
  protected final String TEXT_88 = "()){" + NL + "\t\treturn wasAdded;" + NL + "\t}";
  protected final String TEXT_89 = "* ";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = "->";
  protected final String TEXT_92 = "();" + NL + "\tbool ";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = " != NULL && this!=";
  protected final String TEXT_95 = ";";

  /**
  * @param argument
  * @param arguments
  * @return
  */
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
	
@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_7);
    

}

});
}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_OR_MOVE_AT_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String elementName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	String numberOfMethodName, addAtMethod, removeMethodName, paramName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_8);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( addAtMethod );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( addAtMethod );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_18);
    

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

    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_22);
    

}

});

}});

	
getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;	
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	@GenerationElementParameter(id = OTHER_END_TYPE_NAME) String otherEndTypeName;
	String friendSetMethod;
	String removeMethodName;
	String instanceAsVariable;
	String numberOfMethodName;
	String existing;
	String minimumNumberMethodName;
	String getter;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(otherEndTypeName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(getter);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(minimumNumberMethodName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(friendSetMethod);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_40);
    

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

	@GenerationElementParameter(id = NAME) String name;	
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	@GenerationElementParameter(id = OTHER_END_TYPE_NAME) String otherEndTypeName;
	String addMethodName;
	String removeMethodName;
	String instanceAsVariable;
	String existing;
	String getter;
	String setter;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(otherEndTypeName );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(getter);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(setter);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(addMethodName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_57);
    

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

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	@GenerationElementParameter(id = OTHER_END_TYPE_NAME) String otherTypeName;
	
	@GenerationArgument boolean check;
			
	String instanceAsVariable;
	String removeMethodName;
	String indexOfMethod;
	String addOtherEndMethodName;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_60);
    check();
    stringBuffer.append(TEXT_61);
    

}

private void check(){
	if(!check){
		return;
	}
	
	
    stringBuffer.append(TEXT_62);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(indexOfMethod);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(addOtherEndMethodName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_68);
    	
}

@Override
public void preExecute(){
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.indexOfMethod= getRegistry().generationPointString(element, ICppNameConstants.INDEX_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.addOtherEndMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	this.addOtherEndMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	this.instanceAsVariable= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ADD_CHECK_NEW_OTHER_EXSITING, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	String instanceAsVariable;
	String preCode;
	String isNew;
	String setter;

@Override
public void execute() {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(preCode);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(isNew);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(instanceAsVariable );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(setter);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(instanceAsVariable );
    stringBuffer.append(TEXT_75);
    	

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
	
	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	String isNew;
	String existing;
	String numberOfMethodName;
	String minimumNumberMethodName;	
	String instanceAsVariable;
	String preCode;
	String setter;

@Override
public void execute() {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(preCode);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(isNew );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(minimumNumberMethodName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(instanceAsVariable );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(setter);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(instanceAsVariable );
    stringBuffer.append(TEXT_85);
    	

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

	@GenerationElementParameter(id = NAME) String name;	
	String numberOfMethodName;
	String maximumNumberMethodName;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(numberOfMethodName );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( maximumNumberMethodName );
    stringBuffer.append(TEXT_88);
    	

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

	@GenerationElementParameter(id = OTHER_END_TYPE_NAME) String otherEndTypeName;
	
	String getter, isNew, existing, instanceAsVariable; 
	
@Override
public void execute() {

    stringBuffer.append(otherEndTypeName );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(getter);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(isNew);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(existing);
    stringBuffer.append(TEXT_95);
    

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


    return stringBuffer.toString();
  }
}