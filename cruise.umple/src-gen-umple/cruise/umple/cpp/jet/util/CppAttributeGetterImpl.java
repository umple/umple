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
import cruise.umple.core.GenerationCallback.*;
import cruise.umple.cpp.CppGenerationTemplate;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppAssociationsDefinitionsConstants;
import cruise.umple.modeling.handlers.cpp.ICppDecisions;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;


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
  protected final String TEXT_1 = "\tvector<";
  protected final String TEXT_2 = ">* ";
  protected final String TEXT_3 = "= new vector<";
  protected final String TEXT_4 = ">();" + NL + "\tstd::copy(this->";
  protected final String TEXT_5 = "->begin(), this->";
  protected final String TEXT_6 = "->end(), ";
  protected final String TEXT_7 = "->begin());" + NL + "\treturn ";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = "*";
  protected final String TEXT_10 = "\treturn (*(this->";
  protected final String TEXT_11 = "))[index];";
  protected final String TEXT_12 = "\treturn this->";
  protected final String TEXT_13 = "->size();";
  protected final String TEXT_14 = "\treturn this->";
  protected final String TEXT_15 = "()>0;";
  protected final String TEXT_16 = "\treturn this->";
  protected final String TEXT_17 = "(IndexOf(this->";
  protected final String TEXT_18 = "->begin(), this->";
  protected final String TEXT_19 = "->end(), ";
  protected final String TEXT_20 = "));";
  protected final String TEXT_21 = "\tif(index<0){" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t" + NL + "\tint size= this->";
  protected final String TEXT_22 = "();" + NL + "\tif(index> size){" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t" + NL + "\tthis->";
  protected final String TEXT_23 = "->erase(this->";
  protected final String TEXT_24 = "->begin()+index);" + NL + "\t" + NL + "\treturn size== this->";
  protected final String TEXT_25 = "()-1;";
  protected final String TEXT_26 = NL + "\t//";
  protected final String TEXT_27 = " already at minimum (";
  protected final String TEXT_28 = ")" + NL + "\tif (";
  protected final String TEXT_29 = "() <= ";
  protected final String TEXT_30 = "()){" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_31 = "\treturn IndexOf(this->";
  protected final String TEXT_32 = "->begin(), this->";
  protected final String TEXT_33 = "->end(), ";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = "* ";
  protected final String TEXT_37 = " = this->";
  protected final String TEXT_38 = ";" + NL + "this->";
  protected final String TEXT_39 = " = NULL;";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = "->";
  protected final String TEXT_42 = "(this);";
  protected final String TEXT_43 = NL + "if(this->";
  protected final String TEXT_44 = " != NULL){";
  protected final String TEXT_45 = NL + "}";
  protected final String TEXT_46 = "\t" + NL + "if(this->";
  protected final String TEXT_47 = "!= NULL){" + NL + "\tthis->";
  protected final String TEXT_48 = "->";
  protected final String TEXT_49 = "(NULL);";
  protected final String TEXT_50 = NL + "}";
  protected final String TEXT_51 = "\t" + NL + "\t\tthis->";
  protected final String TEXT_52 = "= NULL;";
  protected final String TEXT_53 = NL + "if(this->";
  protected final String TEXT_54 = "!= NULL){" + NL + "\t";
  protected final String TEXT_55 = "* ";
  protected final String TEXT_56 = "= this->";
  protected final String TEXT_57 = ";" + NL + "\tthis->";
  protected final String TEXT_58 = "= NULL;" + NL + "\t";
  protected final String TEXT_59 = "->deleteAssociatedObjects();" + NL + "}";
  protected final String TEXT_60 = NL + "if(this->";
  protected final String TEXT_61 = "!= NULL){" + NL + "\tif(this->";
  protected final String TEXT_62 = "->";
  protected final String TEXT_63 = "()<= this->";
  protected final String TEXT_64 = "->";
  protected final String TEXT_65 = "()){" + NL + "\t\tthis->";
  protected final String TEXT_66 = "->deleteAssociatedObjects();" + NL + "\t}else{" + NL + "\t\t";
  protected final String TEXT_67 = "* placeHolder";
  protected final String TEXT_68 = "= this->";
  protected final String TEXT_69 = ";" + NL + "\t\tthis->";
  protected final String TEXT_70 = "= NULL;" + NL + "\t\tplaceHolder";
  protected final String TEXT_71 = "->";
  protected final String TEXT_72 = "(this);" + NL + "\t}" + NL + "}";
  protected final String TEXT_73 = "\t" + NL + "if(this->";
  protected final String TEXT_74 = "!= NULL){" + NL + "\tthis->";
  protected final String TEXT_75 = "->deleteAssociatedObjects();" + NL + "}";
  protected final String TEXT_76 = NL + "for(unsigned int index=0; index<this->";
  protected final String TEXT_77 = "->size();index++){" + NL + "\t";
  protected final String TEXT_78 = "* a";
  protected final String TEXT_79 = "= (*(this->";
  protected final String TEXT_80 = "))[index];" + NL + "\ta";
  protected final String TEXT_81 = "->";
  protected final String TEXT_82 = "(NULL);" + NL + "}";
  protected final String TEXT_83 = NL + "vector<";
  protected final String TEXT_84 = "*>* ";
  protected final String TEXT_85 = "= new vector<";
  protected final String TEXT_86 = "*>();" + NL + "std::copy(this->";
  protected final String TEXT_87 = "->begin(), this->";
  protected final String TEXT_88 = "->end(), ";
  protected final String TEXT_89 = "->begin());" + NL + "this->";
  protected final String TEXT_90 = "->clear();" + NL + "for(unsigned int index=0; index<";
  protected final String TEXT_91 = "->size();index++){" + NL + "\t(*";
  protected final String TEXT_92 = ")[index]->";
  protected final String TEXT_93 = "(this);" + NL + "}";
  protected final String TEXT_94 = NL + "vector<";
  protected final String TEXT_95 = "*>* ";
  protected final String TEXT_96 = "= new vector<";
  protected final String TEXT_97 = "*>();" + NL + "std::copy(this->";
  protected final String TEXT_98 = "->begin(), this->";
  protected final String TEXT_99 = "->end(), ";
  protected final String TEXT_100 = "->begin());" + NL + "this->";
  protected final String TEXT_101 = "->clear();" + NL + "for(unsigned int index=0; index<";
  protected final String TEXT_102 = "->size();index++){" + NL + "\t";
  protected final String TEXT_103 = "* current";
  protected final String TEXT_104 = "= (*(this->";
  protected final String TEXT_105 = "))[index];" + NL + "\tif(current";
  protected final String TEXT_106 = "->";
  protected final String TEXT_107 = "()<= current";
  protected final String TEXT_108 = "->";
  protected final String TEXT_109 = "()){" + NL + "\t\tcurrent";
  protected final String TEXT_110 = "->deleteAssociatedObjects();" + NL + "\t}else{" + NL + "\t\tcurrent";
  protected final String TEXT_111 = "->";
  protected final String TEXT_112 = "(this);" + NL + "\t}" + NL + "}";
  protected final String TEXT_113 = NL + "for(unsigned int index=0; index<this->";
  protected final String TEXT_114 = "->size();index++){" + NL + "\t";
  protected final String TEXT_115 = "* a";
  protected final String TEXT_116 = "= (*(this->";
  protected final String TEXT_117 = "))[index];" + NL + "\ta";
  protected final String TEXT_118 = "->deleteAssociatedObjects();" + NL + "}";
  protected final String TEXT_119 = NL + "for(unsigned int index=0; index<this->";
  protected final String TEXT_120 = "->size();index++){" + NL + "\t";
  protected final String TEXT_121 = "* current= (*(this->";
  protected final String TEXT_122 = "))[index];" + NL + "\t";
  protected final String TEXT_123 = "(current, NULL);" + NL + "}" + NL + "this->";
  protected final String TEXT_124 = "->clear();";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppAssociationsDefinitionsConstants.MANY_GETTER_METHOD , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String typeName;
	@GenerationArgument String elementName;
	@GenerationArgument String copy;
	@GenerationArgument boolean isPointer;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    stringBuffer.append( typeName);
    setPointer();
    stringBuffer.append(TEXT_2);
    stringBuffer.append( copy);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(typeName);
    setPointer();
    stringBuffer.append(TEXT_4);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( copy);
    stringBuffer.append(TEXT_7);
    stringBuffer.append( copy);
    stringBuffer.append(TEXT_8);
    

}

private void setPointer(){
	if(!isPointer){
		return;
	}
	
    stringBuffer.append(TEXT_9);
    
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.GETTER_BY_INDEX_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String elementName;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_11);
    

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


    stringBuffer.append(TEXT_12);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_13);
    

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


    stringBuffer.append(TEXT_14);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_15);
    

}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.REMOVE_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String removeAtMethod;
	@GenerationArgument String elementName;
	@GenerationArgument String paramName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_16);
    stringBuffer.append( removeAtMethod );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( paramName );
    stringBuffer.append(TEXT_20);
    

}

});
}});

getRegistry().define(ICppAssociationsDefinitionsConstants.REMOVE_AT_IMPLEMENTATION , new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String elementName;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName;
	@GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound;
	@GenerationProcedureParameter(id = ICppDecisions.HAS_MINIMUM_GETTER) boolean hasMinimumGetter;
	
	String minimumNumberMethodName, numberOfMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_21);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( elementName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_25);
    

}

public void minimum(){
if(!hasMinimumGetter){
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

@Override
public void preExecute(){
	this.minimumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	this.numberOfMethodName= getRegistry().generationPointString(element, IModelingConstants.NUMBER_OF_METHOD_NAME, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
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


    stringBuffer.append(TEXT_31);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(elementName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_34);
    

}

});
}});


getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_ASSIGN_REMOVE_DEFINITION, new GenerationProcdure(this) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument boolean check;
		
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
	

    stringBuffer.append(TEXT_35);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(placeHolder);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(placeHolder);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_42);
    
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

    stringBuffer.append(TEXT_43);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(StringUtil.indent(body.toString(), 1));
    stringBuffer.append(TEXT_45);
    
}});
}
	
});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_CHECK_NULLIFY_BY_SETTER_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationArgument boolean nullify;
	
	String setterMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_46);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_49);
    nullify();
    stringBuffer.append(TEXT_50);
    

}

private void nullify() {
if(!nullify){
	return;
}


    stringBuffer.append(TEXT_51);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_52);
    

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

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	String existingVariableName;
		
@Override
public void execute() {


    stringBuffer.append(TEXT_53);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(existingVariableName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(existingVariableName);
    stringBuffer.append(TEXT_59);
    

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

	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	@GenerationElementParameter(id = NAME) String name;
		
	String numberOfOtherEndMethodName;
	String minimumNumberOtherEndMethodName;
	String removeMethodName;
		
@Override
public void execute() {


    stringBuffer.append(TEXT_60);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(numberOfOtherEndMethodName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(minimumNumberOtherEndMethodName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_72);
    

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

	@GenerationElementParameter(id = NAME) String name;
		
@Override
public void execute() {


    stringBuffer.append(TEXT_73);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_75);
    

}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_ALL_BY_SETTER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	String setterMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_76);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_82);
    

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

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	String nameAsCopy;
	String removeMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_83);
    stringBuffer.append( typeName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(nameAsCopy);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_87);
    stringBuffer.append( name);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(nameAsCopy);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(nameAsCopy);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(nameAsCopy);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_93);
    

}

@Override
public void preExecute(){
	this.nameAsCopy= getRegistry().generationPointString(element, ICppNameConstants.COPY_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_CLEAR_THEN_DELETE_OR_REMOVE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	@GenerationElementParameter(id = NAME) String name;
		
	String numberOfOtherEndMethodName;
	String minimumNumberOtherEndMethodName;
	String removeMethodName;
	String nameAsCopy;
		
@Override
public void execute() {


    stringBuffer.append(TEXT_94);
    stringBuffer.append( typeName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(nameAsCopy);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_98);
    stringBuffer.append( name);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(nameAsCopy);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(nameAsCopy);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(name);
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
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_NULLIFY_USE_DELETE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_118);
    

}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.DELETE_USE_FRIEND_SETTER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	
	String friendDeleteMethod;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(friendDeleteMethod);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_124);
    

}

@Override
public void preExecute(){
	this.friendDeleteMethod= getRegistry().use(ICppNameConstants.FRIEND_SETTER, typeName, otherEndTypeName);
}

});

}});


    return stringBuffer.toString();
  }
}