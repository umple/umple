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
import cruise.umple.modeling.handlers.cpp.ICppDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppHandlerDefinitions;
import cruise.umple.modeling.handlers.cpp.ICppMethods;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;


@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppTemplateHelper extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppTemplateHelper create(String lineSeparator)
  {
    nl = lineSeparator;
    CppTemplateHelper result = new CppTemplateHelper();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "hashCode";
  protected final String TEXT_2 = "return reinterpret_cast<size_t>(this);";
  protected final String TEXT_3 = "class ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = "vector<";
  protected final String TEXT_6 = ">";
  protected final String TEXT_7 = "*";
  protected final String TEXT_8 = "using namespace ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = "namespace ";
  protected final String TEXT_11 = "#include ";
  protected final String TEXT_12 = ".h";
  protected final String TEXT_13 = "/";
  protected final String TEXT_14 = "\"";
  protected final String TEXT_15 = "<";
  protected final String TEXT_16 = "\"";
  protected final String TEXT_17 = ">";
  protected final String TEXT_18 = "#include <";
  protected final String TEXT_19 = ">";
  protected final String TEXT_20 = "delete ";
  protected final String TEXT_21 = ";";
  protected final String TEXT_22 = "throw \"";
  protected final String TEXT_23 = "\";";
  protected final String TEXT_24 = "class ";
  protected final String TEXT_25 = " : ";
  protected final String TEXT_26 = NL + "//------------------------" + NL + "// FILE INCLUDES" + NL + "//------------------------";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + NL + "//------------------------" + NL + "// LIBRARIES INCLUDES" + NL + "//------------------------";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + NL + "//------------------------" + NL + "// USED LIBRARIES" + NL + "//------------------------";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = "return ";
  protected final String TEXT_33 = ";";
  protected final String TEXT_34 = "//------------------------" + NL + "// EXTERNAL LIBRARIES" + NL + "//------------------------";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = "if(";
  protected final String TEXT_37 = "){";
  protected final String TEXT_38 = NL + "}";
  protected final String TEXT_39 = "else{";
  protected final String TEXT_40 = NL + "\t}";
  protected final String TEXT_41 = "::";
  protected final String TEXT_42 = "= ";
  protected final String TEXT_43 = ";";
  protected final String TEXT_44 = " ";
  protected final String TEXT_45 = "#define ";
  protected final String TEXT_46 = " \t";
  protected final String TEXT_47 = "#pragma include_alias(\".\\";
  protected final String TEXT_48 = "\\";
  protected final String TEXT_49 = ".h\", \"";
  protected final String TEXT_50 = "/";
  protected final String TEXT_51 = ".h\")";
  protected final String TEXT_52 = "#pragma include_alias(\"..\\";
  protected final String TEXT_53 = "\\";
  protected final String TEXT_54 = ".h\", \"";
  protected final String TEXT_55 = ".h\")";
  protected final String TEXT_56 = NL + "//------------------------------" + NL + "// NAMESPACES AND PREDEFINITIONS" + NL + "//------------------------------" + NL + "#ifdef __cplusplus";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = NL + "#endif " + NL;
  protected final String TEXT_59 = "#ifdef __GNUC__" + NL + "using namespace __gnu_cxx;" + NL + "#include <ext/hash_map>" + NL + "#else" + NL + "#include <hash_map>" + NL + "#endif ";
  protected final String TEXT_60 = NL + "//------------------------------" + NL + "// PRE=PROCESSORS INCLUDES" + NL + "//------------------------------";
  protected final String TEXT_61 = NL;
  protected final String TEXT_62 = "* thisptr = const_cast<";
  protected final String TEXT_63 = "*>(this);";
  protected final String TEXT_64 = "++";
  protected final String TEXT_65 = " ";
  protected final String TEXT_66 = ";";
  protected final String TEXT_67 = "<";
  protected final String TEXT_68 = ">";
  protected final String TEXT_69 = " ";
  protected final String TEXT_70 = "*";
  protected final String TEXT_71 = " ";
  protected final String TEXT_72 = "::";
  protected final String TEXT_73 = " = ";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = "//------------------------------" + NL + "// ATTRIBUTES IMPLEMENTATIONS" + NL + "//------------------------------";
  protected final String TEXT_76 = NL;
  protected final String TEXT_77 = " != ";
  protected final String TEXT_78 = "->";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ";";
  protected final String TEXT_81 = " ";
  protected final String TEXT_82 = "*";
  protected final String TEXT_83 = "::";
  protected final String TEXT_84 = "(";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = " ";
  protected final String TEXT_87 = "(";
  protected final String TEXT_88 = ")";
  protected final String TEXT_89 = "{";
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = NL + "}";
  protected final String TEXT_92 = " const";
  protected final String TEXT_93 = "inline ";
  protected final String TEXT_94 = " static";
  protected final String TEXT_95 = " ";
  protected final String TEXT_96 = "(";
  protected final String TEXT_97 = ")";
  protected final String TEXT_98 = ";";
  protected final String TEXT_99 = " const";
  protected final String TEXT_100 = "(";
  protected final String TEXT_101 = ")";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = "//TODO Add code body to ";
  protected final String TEXT_104 = NL;
  protected final String TEXT_105 = ":" + NL;
  protected final String TEXT_106 = NL;
  protected final String TEXT_107 = "//";
  protected final String TEXT_108 = " Attributes";
  protected final String TEXT_109 = "//";
  protected final String TEXT_110 = " Associations";
  protected final String TEXT_111 = "//------------------------" + NL + "// STATIC VARIABLES" + NL + "//------------------------";
  protected final String TEXT_112 = "//Helper Variables";
  protected final String TEXT_113 = NL + "\tif(!compare(Right.";
  protected final String TEXT_114 = ", Left.";
  protected final String TEXT_115 = ", sizeof Right.";
  protected final String TEXT_116 = ")){" + NL + "\t\t return false;" + NL + "\t}";
  protected final String TEXT_117 = NL + "\tif(!std::equal(Right.";
  protected final String TEXT_118 = "->begin(), Right.";
  protected final String TEXT_119 = "->end(), Left.";
  protected final String TEXT_120 = "->begin())){" + NL + "\t\t return false;" + NL + "\t}";
  protected final String TEXT_121 = NL + "\tif(Right.";
  protected final String TEXT_122 = ".compare(Left.";
  protected final String TEXT_123 = ") != 0){" + NL + "\t\t return false;" + NL + "\t}";
  protected final String TEXT_124 = NL + "\tif(Right.";
  protected final String TEXT_125 = "!= Left.";
  protected final String TEXT_126 = "){" + NL + "\t\t return false;" + NL + "\t}";
  protected final String TEXT_127 = "const ";
  protected final String TEXT_128 = "&";
  protected final String TEXT_129 = "//-------------------------------------" + NL + "// PREDEFINED OPERATORS IMPLEMENTATION" + NL + "//-------------------------------------" + NL + "bool operator== (";
  protected final String TEXT_130 = " &Right, ";
  protected final String TEXT_131 = " &Left){" + NL + "\t//if (typeid(Right) != typeid(Left)) {" + NL + "\t//\treturn false;" + NL + "\t//}" + NL + "\t";
  protected final String TEXT_132 = NL + "\treturn true;" + NL + "}";
  protected final String TEXT_133 = NL + "//------------------------" + NL + "// INLINE FUNCTIONS" + NL + "//------------------------";
  protected final String TEXT_134 = NL;
  protected final String TEXT_135 = NL + "//#define ";
  protected final String TEXT_136 = " ";
  protected final String TEXT_137 = NL + "//------------------------" + NL + "// PACKAGE/EXTERNAL DECLARATIONS" + NL + "//------------------------" + NL + "/* External declarations (package visibility)*/";
  protected final String TEXT_138 = NL;
  protected final String TEXT_139 = NL + "//A template function to get the index of an item for a given vector. It returns -1 if the" + NL + "//item was not found" + NL + "template < typename InputIterator, typename EqualityComparable >" + NL + "\tint IndexOf(const InputIterator& begin," + NL + "\tconst InputIterator& end, const EqualityComparable& item) {" + NL + "\t\tInputIterator fnd = std::find(begin, end, item);" + NL + "\t\tunsigned int index = std::distance(begin, fnd);" + NL + "\t\treturn fnd != end ? index : -1;" + NL + "}" + NL + "" + NL + "//Used as a function pointer to safely destroy elements or collections of elements" + NL + "//Example: " + NL + "//\tstd::for_each( arr->begin(), arr->end(), delete_pointer_element());" + NL + "//\tdelete arr;" + NL + "struct deleteElement{" + NL + " template< typename T >" + NL + " void operator()( T element ) const{" + NL + "\tdelete element;" + NL + "\t}" + NL + "};" + NL + "" + NL + "template<typename T>" + NL + "unsigned int compare(T c1, T c2, unsigned int sz ) {" + NL + "\tif(!is_ptr<T>::value) {" + NL + "\t\treturn memcmp(&c1,&c2, sz);" + NL + "\t}" + NL + "\treturn memcmp((void*)c1, (void*)c2, sz);" + NL + "} " + NL + "" + NL + "template<typename T>" + NL + "void copyObject(T* object1, T* object2, unsigned int sz ) {" + NL + "\tif(!is_ptr<T>::value) {" + NL + "\t\tmemcpy(&object2,&object1, sz);" + NL + "\t}" + NL + " \tmemcpy((void*)object2, (void*)object1, sz);" + NL + "}";
  protected final String TEXT_140 = "::";
  protected final String TEXT_141 = "friend void ";
  protected final String TEXT_142 = "(";
  protected final String TEXT_143 = "* ";
  protected final String TEXT_144 = ", ";
  protected final String TEXT_145 = "*);";
  protected final String TEXT_146 = "\t" + NL + "void ";
  protected final String TEXT_147 = "(";
  protected final String TEXT_148 = "* _";
  protected final String TEXT_149 = ", ";
  protected final String TEXT_150 = "* ";
  protected final String TEXT_151 = "){" + NL + "\t_";
  protected final String TEXT_152 = "->";
  protected final String TEXT_153 = "= ";
  protected final String TEXT_154 = ";" + NL + "}";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppDefinitions.HASH_CDOE_METHOD_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    

}});

}});

getRegistry().define(ICppDefinitions.HASH_CDOE_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_2);
    

}});

}});

getRegistry().define(ICppMethods.CLASS_INLINE_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_3);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_4);
    

}});

}});

getRegistry().define(ICppDefinitions.TYPE_AS_VECTOR, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String type;
	@GenerationArgument boolean isPointer;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_6);
    setPointer();
    
}

private void setPointer(){
	if(!isPointer){
		return;
	}
	
    stringBuffer.append(TEXT_7);
    
}

});

}});

getRegistry().define(ICppDefinitions.USE_NAMESPACE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_9);
    

}});

}});

getRegistry().define(ICppDefinitions.NAMESPACE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(name);
    

}});

}});

getRegistry().define(ICppDefinitions.INCLUDE_STATEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument(adjust= false) String path;
	@GenerationArgument boolean isCompilerHeader;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_11);
    open();
    setPath();
    stringBuffer.append(name);
    stringBuffer.append(TEXT_12);
    end();
    

}

private void setPath(){
	if(path== null|| path.isEmpty()){
		return;
	}
	
    stringBuffer.append(path);
    stringBuffer.append(TEXT_13);
    
}

private void open(){
	//No check for empty in order to enable the callers to determine if they want "< >" notation to be used instead
	if(isCompilerHeader&& path== null){
		
    stringBuffer.append(TEXT_14);
    
		return;
	}
	
    stringBuffer.append(TEXT_15);
    
}

private void end(){
	//No check for empty in order to enable the callers to determine if they want "< >" notation to be used instead
	if(isCompilerHeader&& path== null){
		
    stringBuffer.append(TEXT_16);
    
		return;
	}
	
    stringBuffer.append(TEXT_17);
    
}

});

}});

getRegistry().define(ICppDefinitions.BUILTIN_INCLUDE_STATEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_19);
    

}});

}});

getRegistry().define(ICppDefinitions.DESTRUCT_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_21);
    

}});

}});

getRegistry().define(ICppDefinitions.THROW_STATEMENET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String body;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_23);
    

}});

}});

getRegistry().define(ICppDefinitions.CLASS_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String extendsSegment;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(name);
    extendsCall();
    

}

private void extendsCall(){
	if(extendsSegment.isEmpty()){
		return;
	}
	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(extendsSegment);
    
	

}

});
}});

getRegistry().define(ICppDefinitions.INCLUDES_DECLARATIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String includes;
	@GenerationArgument String librariesUse;
	@GenerationArgument String librariesIncludes;
	
@Override
public void execute() {
	
    includes();
    librariesIncludes();
    librariesUse();
    
}

private void includes(){
	if(this.includes.isEmpty()){
		return;
	}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(includes);
    
}

private void librariesIncludes(){
	if(this.librariesIncludes.isEmpty()){
		return;
	}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(librariesIncludes);
    
}

private void librariesUse(){
	if(this.librariesUse.isEmpty()){
		return;
	}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(librariesUse);
    
}

});
}});

getRegistry().define(ICppDefinitions.RETURN_STATEMENET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String statement;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_33);
    

}});
}});



getRegistry().define(ICppDefinitions.EXTERNAL_NAMESPACES, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String librariesUse;
	
@Override
public void execute() {
	
    librariesUse();
    
}

private void librariesUse(){
	if(this.librariesUse.isEmpty()){
		return;
	}
	

    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(librariesUse);
    
}

});

}});

getRegistry().define(ICppDefinitions.IF_CONDITION_BLOCK, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String condition;
	@GenerationArgument String block;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(block);
    stringBuffer.append(TEXT_38);
    

}});

}});

getRegistry().define(ICppDefinitions.ELSE_CONDITION_BLOCK, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String block;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(StringUtil.indent(block, 1));
    stringBuffer.append(TEXT_40);
    

}});

}});

getRegistry().define(ICppDefinitions.QUALIFIED_METHOD_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String owner;
	@GenerationArgument String methodName;
			
@Override
public void execute() {


    stringBuffer.append(owner);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(methodName);
    

}});

}});

getRegistry().define(ICppDefinitions.ASSIGN_STATEMENET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String left;
	@GenerationArgument String right;
	@GenerationArgument String type;
	
@Override
public void execute() {

    setType();
    stringBuffer.append(left);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(right);
    stringBuffer.append(TEXT_43);
    

}

private void setType(){
	if(type.isEmpty()){
		return;
	}
	
	
    stringBuffer.append(type);
    stringBuffer.append(TEXT_44);
    	
}

});

}});

getRegistry().define(ICppDefinitions.DEFINE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String definition;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(definition);
    

}});

}});

getRegistry().define(ICppDefinitions.ALIAS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	@GenerationArgument String root;
	@GenerationArgument String target;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(root);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(target);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_51);
    

}});

}});

getRegistry().define(ICppDefinitions.ROOT_ALIAS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String base;
	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(base);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_55);
    

}});

}});


getRegistry().define(ICppDefinitions.INCOMPLETE_NAMESPACES_DEFNITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String definitionsBody;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(definitionsBody);
    stringBuffer.append(TEXT_58);
    

}});

}});

getRegistry().define(ICppDefinitions.GNUC_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {

    stringBuffer.append(TEXT_59);
    

}});

}});

getRegistry().define(ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String definitions;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(definitions);
    

}});

}});

getRegistry().define(ICppDefinitions.THIS_POINTER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(type);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_63);
    

}});

}});

getRegistry().define(ICppDefinitions.INCREMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(name);
    stringBuffer.append(TEXT_64);
    

}});

}});

getRegistry().define(ICppDefinitions.DECLARE_STATEMENET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(final Object element, final Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String prefix;
	@GenerationArgument(id= IModelingConstants.ATTRIBUTE_TYPE_ARGUMENT) String type;
	@GenerationArgument(id= IModelingConstants.ATTRIBUTE_NAME_ARGUMENT) String name;
	@GenerationArgument(id= ICppDefinitions.GENERIC_TYPE) String genericType;
	@GenerationArgument(id= ICppDefinitions.IS_POINTER_TYPE) boolean isPointer;
			
@Override
public void execute() {

    setPrefix();
    stringBuffer.append(type);
    setGeneric();
    setPointer();
    stringBuffer.append(TEXT_65);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_66);
    
}

private void setGeneric(){
	if(genericType== null|| genericType.isEmpty()){
		return;
	}
	
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genericType);
    stringBuffer.append(TEXT_68);
    
}

private void setPrefix(){
	if(prefix== null|| prefix.isEmpty()){
		return;
	}
	
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_69);
    
}

private void setPointer(){
	if(!isPointer){
		return;
	}
	
    stringBuffer.append(TEXT_70);
    
}

@Override
public void postExecute(){
	getRegistry().generationPointString(element, ICppDefinitions.DECLARE_IMPLEMENTATION, arguments);
}

});

}});

getRegistry().define(ICppDefinitions.DECLARE_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String returnType;
	@GenerationArgument String owner;
	@GenerationArgument String name;
	@GenerationArgument String value;
	
@Override
public void execute() {


    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(owner);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_74);
    

}});

}});

getRegistry().define(ICppDefinitions.ATTRIBUTES_IMPLEMENTATIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String implementation;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(implementation);
    
}});

}});

getRegistry().define(ICppDefinitions.NOT_EQUAL, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String left;
	@GenerationArgument String right;
	
@Override
public void execute() {

    stringBuffer.append(left);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(right);
    

}});

}});

getRegistry().define(ICppDefinitions.ATTRIBUTE_USE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String left;
	@GenerationArgument String right;
	@GenerationArgument boolean isPointer;
	@GenerationArgument boolean isStatement;
	
@Override
public void execute() {
//this->name->clear();
//this.name

    stringBuffer.append(left);
    isPointer();
    stringBuffer.append(right);
    isStatement();
    

}

public void isPointer(){
	if(this.isPointer){
		
    stringBuffer.append(TEXT_78);
    		
	}else{
		
    stringBuffer.append(TEXT_79);
    
	}
}

public void isStatement(){
	if(this.isStatement){
		
    stringBuffer.append(TEXT_80);
    		
	}
}

});

}});

getRegistry().define(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	@GenerationArgument String variable;
	@GenerationArgument boolean isPointer;
	
	
@Override
public void execute() {

    stringBuffer.append(type);
    setPointer();
    stringBuffer.append(TEXT_81);
    stringBuffer.append(variable);
    

}

private void setPointer(){
	if(!isPointer){
		return;
	}
	
    stringBuffer.append(TEXT_82);
    	
}


});

}});

getRegistry().define(ICppDefinitions.METHOD_PARENT_CALL, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String parent;
	@GenerationArgument String methodName;
	@GenerationArgument String parameters;
			
@Override
public void execute() {


    stringBuffer.append(parent);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_85);
    

}

});

}});

getRegistry().define(ICppDefinitions.METHOD_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String returnType;
	@GenerationArgument String qualifiedMethodName;
	@GenerationArgument String parameters;
	@GenerationArgument String codeBody;
	@GenerationArgument boolean isInline;
	@GenerationArgument boolean isStatic;
	@GenerationArgument String init;
	@GenerationArgument(id= IModelingConstants.METHOD_CONST) boolean isConstant;
			
@Override
public void execute() {


    setInline();
    stringBuffer.append(returnType);
    setStatic();
    stringBuffer.append(TEXT_86);
    stringBuffer.append(qualifiedMethodName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_88);
    setConstant();
    stringBuffer.append( init );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(codeBody);
    stringBuffer.append(TEXT_91);
    

}

private void setConstant(){
	if(!isConstant){
		return;
	}
	
    stringBuffer.append(TEXT_92);
    
}

private void setInline(){
	if(!isInline){
		return;
	}
	
	
    stringBuffer.append(TEXT_93);
    
}

private void setStatic(){
	if(!isStatic){
		return;
	}
	
	
    stringBuffer.append(TEXT_94);
    
}


});

}});

getRegistry().define(ICppDefinitions.METHOD_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String returnType;
	@GenerationArgument String qualifiedMethodName;
	@GenerationArgument String parameters;
	@GenerationArgument String init;
	@GenerationArgument(id= IModelingConstants.METHOD_CONST) boolean isConstant;
			
@Override
public void execute() {


    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(qualifiedMethodName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_97);
    setConstant();
    stringBuffer.append( init );
    stringBuffer.append(TEXT_98);
    

}

private void setConstant(){
	if(!isConstant){
		return;
	}
	
    stringBuffer.append(TEXT_99);
    
}

});

}});

getRegistry().define(ICppDefinitions.METHOD_INVOCATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String methodName;
	@GenerationArgument String parameters;
	@GenerationArgument	boolean isStatemenet;
			
@Override
public void execute() {


    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_101);
    statement();
    

}

public void statement(){
	if(!isStatemenet){
		return;
	}
	
	
    stringBuffer.append(TEXT_102);
    
}

});

}});

getRegistry().define(ICppDefinitions.METHOD_TODO_STATEMENET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(name);
    
}});

}});

getRegistry().define(ICppDefinitions.VISIBILITY_PART, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String visibility;
	@GenerationArgument String contents;
	@GenerationArgument boolean optimistic;
	
@Override
public void execute() {

if(contents.isEmpty() && !optimistic){
	return;
}


    stringBuffer.append(TEXT_104);
    stringBuffer.append(visibility);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(indent(contents, 1));
    	
	
}

});

}});

getRegistry().define(ICppDefinitions.ATTRIBUTES_DECLARATION+ ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_108);
    
}});

}});

getRegistry().define(ICppDefinitions.ASSOCIATIONS_DECLARATION +ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_110);
    
}});

}});

getRegistry().define(ICppDefinitions.STATIC_ATTRIBUTE_DECLARATIONS +ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(TEXT_111);
    

}});

}});

getRegistry().define(ICppDefinitions.HELPER_ATTRIBUTES_DECLARATION +ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {

    stringBuffer.append(TEXT_112);
    
}});

}});

getRegistry().define(ICppDefinitions.ATTRIBUTE_EQUALITY_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
	@GenerationArgument boolean isMany;
			
@Override
public void execute() {

	if(isMany){
		many();
	}else{
		single();
	}
	
}

protected void single() {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_116);
    
}

protected void many() {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_120);
    
}

});

}});

getRegistry().define(ICppDefinitions.STRING_ATTRIBUTE_EQUALITY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_121);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_123);
    	
}

});

}});

getRegistry().define(ICppDefinitions.PRIMITIVE_ATTRIBUTE_EQUALITY, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_124);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_126);
    	
}

});

}});

getRegistry().define(ICppDefinitions.CONSTANT_PARAMETER, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String type;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_127);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_128);
    	
}

});

}});

getRegistry().define(PREDEFINED_OPERATORS_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String type;
	@GenerationArgument String operators;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(operators);
    stringBuffer.append(TEXT_132);
    
}});

}});

getRegistry().define(ICppHandlerDefinitions.HEADER_INLINE_FUNCTION_CONTENTS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String inlineFunctionContents;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_133);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(inlineFunctionContents);
    

}});
}});

getRegistry().define(ICppDefinitions.DEFINITION_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String definition;
	@GenerationArgument int index;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_135);
    stringBuffer.append(definition);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(index);
    

}});

}});


getRegistry().define(ICppDefinitions.PACKAGE_DECLARATIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String packageContents;
			
@Override
public void execute() {
if(packageContents== null|| packageContents.isEmpty()){
	return;
}


    stringBuffer.append(TEXT_137);
    stringBuffer.append(TEXT_138);
    stringBuffer.append( packageContents );
    

}});

}});

getRegistry().define(ICppDefinitions.PREDEFINED_FUNCTIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_139);
    

}});

}});

getRegistry().define(ICppDefinitions.CLASS_PREFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = NAME) String name;
			
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_140);
    

}});

}});



getRegistry().define(ICppHandlerDefinitions.FRIEND_SETTER_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
		
	String parameter, existingMethodName;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_141);
    stringBuffer.append( existingMethodName );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(typeName );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_145);
    

}

@Override
public void preExecute(){
	this.parameter= getRegistry().use(ICppNameConstants.NEW_INSTANCE, otherEndTypeName);
	this.existingMethodName= getRegistry().use(ICppNameConstants.FRIEND_SETTER, typeName, otherEndTypeName);
}

});

}});

getRegistry().define(ICppHandlerDefinitions.FRIEND_SETTER_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = OTHER_END_NAME) String otherEndName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
		
	String parameter, existingMethodName;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_146);
    stringBuffer.append( existingMethodName );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(typeName );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append( otherEndName );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_154);
    

}

@Override
public void preExecute(){
	this.parameter= getRegistry().use(ICppNameConstants.NEW_INSTANCE, otherEndTypeName);
	this.existingMethodName= getRegistry().use(ICppNameConstants.FRIEND_SETTER, typeName, otherEndTypeName);
}

});

}});


    return stringBuffer.toString();
  }
}