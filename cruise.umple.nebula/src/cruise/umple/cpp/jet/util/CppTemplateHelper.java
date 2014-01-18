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
import cruise.umple.cpp.utils.*;
import cruise.umple.core.GenerationCallback.*;

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
  protected final String TEXT_1 = "::main(argc,argv);";
  protected final String TEXT_2 = "::";
  protected final String TEXT_3 = "::";
  protected final String TEXT_4 = "hashCode";
  protected final String TEXT_5 = "//No Implementation in this context";
  protected final String TEXT_6 = "return reinterpret_cast<size_t>(this);";
  protected final String TEXT_7 = "class ";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = "struct ";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = "using namespace ";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = "namespace ";
  protected final String TEXT_14 = "#include ";
  protected final String TEXT_15 = "<";
  protected final String TEXT_16 = ">";
  protected final String TEXT_17 = "#include ";
  protected final String TEXT_18 = ".h";
  protected final String TEXT_19 = "/";
  protected final String TEXT_20 = "\"";
  protected final String TEXT_21 = "<";
  protected final String TEXT_22 = "\"";
  protected final String TEXT_23 = ">";
  protected final String TEXT_24 = "#include <";
  protected final String TEXT_25 = ">";
  protected final String TEXT_26 = "delete ";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = "throw \"";
  protected final String TEXT_29 = "\";";
  protected final String TEXT_30 = "class ";
  protected final String TEXT_31 = " : ";
  protected final String TEXT_32 = NL + "//------------------------" + NL + "// FILE INCLUDES" + NL + "//------------------------";
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = NL + "//------------------------" + NL + "// LIBRARIES INCLUDES" + NL + "//------------------------";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = NL + NL + "//------------------------" + NL + "// USED LIBRARIES" + NL + "//------------------------";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = "return ";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = "//------------------------" + NL + "// EXTERNAL LIBRARIES" + NL + "//------------------------";
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = "if(";
  protected final String TEXT_43 = "){";
  protected final String TEXT_44 = NL + "}";
  protected final String TEXT_45 = "!(";
  protected final String TEXT_46 = ")";
  protected final String TEXT_47 = "else{";
  protected final String TEXT_48 = NL + "\t}";
  protected final String TEXT_49 = "::";
  protected final String TEXT_50 = "= ";
  protected final String TEXT_51 = ";";
  protected final String TEXT_52 = " ";
  protected final String TEXT_53 = "#define ";
  protected final String TEXT_54 = " \t";
  protected final String TEXT_55 = "#pragma include_alias(\".\\";
  protected final String TEXT_56 = "\\";
  protected final String TEXT_57 = ".h\", \"";
  protected final String TEXT_58 = "/";
  protected final String TEXT_59 = ".h\")";
  protected final String TEXT_60 = "#pragma include_alias(\"..\\";
  protected final String TEXT_61 = "\\";
  protected final String TEXT_62 = ".h\", \"";
  protected final String TEXT_63 = ".h\")";
  protected final String TEXT_64 = NL + "//------------------------------" + NL + "// NAMESPACES AND PREDEFINITIONS" + NL + "//------------------------------" + NL + "#ifdef __cplusplus";
  protected final String TEXT_65 = NL;
  protected final String TEXT_66 = NL + "#endif " + NL;
  protected final String TEXT_67 = "#ifdef __GNUC__" + NL + "using namespace __gnu_cxx;" + NL + "#include <ext/hash_map>" + NL + "#else" + NL + "#include <hash_map>" + NL + "#endif ";
  protected final String TEXT_68 = NL + "//------------------------------" + NL + "// PRE=PROCESSORS INCLUDES" + NL + "//------------------------------";
  protected final String TEXT_69 = NL;
  protected final String TEXT_70 = "* thisptr = const_cast<";
  protected final String TEXT_71 = "*>(this);";
  protected final String TEXT_72 = "++";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = "<";
  protected final String TEXT_76 = ">";
  protected final String TEXT_77 = " ";
  protected final String TEXT_78 = "*";
  protected final String TEXT_79 = " ";
  protected final String TEXT_80 = "::";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = "const ";
  protected final String TEXT_84 = "//------------------------------" + NL + "// ATTRIBUTES IMPLEMENTATIONS" + NL + "//------------------------------";
  protected final String TEXT_85 = NL;
  protected final String TEXT_86 = " != ";
  protected final String TEXT_87 = "->";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = ";";
  protected final String TEXT_90 = " ";
  protected final String TEXT_91 = "*";
  protected final String TEXT_92 = "::";
  protected final String TEXT_93 = "(";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = " ";
  protected final String TEXT_96 = "(";
  protected final String TEXT_97 = ")";
  protected final String TEXT_98 = "{";
  protected final String TEXT_99 = NL;
  protected final String TEXT_100 = NL + "}";
  protected final String TEXT_101 = " const";
  protected final String TEXT_102 = "inline ";
  protected final String TEXT_103 = " static";
  protected final String TEXT_104 = " ";
  protected final String TEXT_105 = "(";
  protected final String TEXT_106 = ")";
  protected final String TEXT_107 = ";";
  protected final String TEXT_108 = "static ";
  protected final String TEXT_109 = " const";
  protected final String TEXT_110 = "virtual ";
  protected final String TEXT_111 = " = 0";
  protected final String TEXT_112 = "(";
  protected final String TEXT_113 = ")";
  protected final String TEXT_114 = ";";
  protected final String TEXT_115 = "//TODO Add code body to ";
  protected final String TEXT_116 = NL;
  protected final String TEXT_117 = ":" + NL;
  protected final String TEXT_118 = NL;
  protected final String TEXT_119 = "//";
  protected final String TEXT_120 = " Attributes";
  protected final String TEXT_121 = "//";
  protected final String TEXT_122 = " Associations";
  protected final String TEXT_123 = "//------------------------" + NL + "// STATIC VARIABLES" + NL + "//------------------------";
  protected final String TEXT_124 = "//Helper Variables";
  protected final String TEXT_125 = NL + "\tif(!compare(Right.";
  protected final String TEXT_126 = ", Left.";
  protected final String TEXT_127 = ", sizeof Right.";
  protected final String TEXT_128 = ")){" + NL + "\t\t return false;" + NL + "\t}";
  protected final String TEXT_129 = NL + "\tif(!std::equal(Right.";
  protected final String TEXT_130 = "->begin(), Right.";
  protected final String TEXT_131 = "->end(), Left.";
  protected final String TEXT_132 = "->begin())){" + NL + "\t\t return false;" + NL + "\t}";
  protected final String TEXT_133 = NL + "\tif(Right.";
  protected final String TEXT_134 = ".compare(Left.";
  protected final String TEXT_135 = ") != 0){" + NL + "\t\t return false;" + NL + "\t}";
  protected final String TEXT_136 = "//------------------------" + NL + "// IMPLEMENTED COMPARATORS" + NL + "//------------------------";
  protected final String TEXT_137 = NL;
  protected final String TEXT_138 = "struct ";
  protected final String TEXT_139 = " : public std::binary_function<";
  protected final String TEXT_140 = "*, ";
  protected final String TEXT_141 = "*, bool>{" + NL + "\tbool operator()(";
  protected final String TEXT_142 = "* Right, ";
  protected final String TEXT_143 = "* Left) const{  " + NL + "\t\treturn Right->";
  protected final String TEXT_144 = " < Left->";
  protected final String TEXT_145 = ";" + NL + "\t}" + NL + "};";
  protected final String TEXT_146 = "_";
  protected final String TEXT_147 = "_Comparator";
  protected final String TEXT_148 = NL + "\tif(Right.";
  protected final String TEXT_149 = "!= Left.";
  protected final String TEXT_150 = "){" + NL + "\t\t return false;" + NL + "\t}";
  protected final String TEXT_151 = "const ";
  protected final String TEXT_152 = "&";
  protected final String TEXT_153 = "//-------------------------------------" + NL + "// PREDEFINED OPERATORS" + NL + "//-------------------------------------";
  protected final String TEXT_154 = NL;
  protected final String TEXT_155 = "//-------------------------------------" + NL + "// PREDEFINED OPERATORS IMPLEMENTATION" + NL + "//-------------------------------------";
  protected final String TEXT_156 = NL;
  protected final String TEXT_157 = "bool operator== (";
  protected final String TEXT_158 = " &Right, ";
  protected final String TEXT_159 = " &Left){" + NL + "\t//if (typeid(Right) != typeid(Left)) {" + NL + "\t//\treturn false;" + NL + "\t//}" + NL + "\t" + NL + "\tif(Right.hashCode() != Left.hashCode()) {" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_160 = NL + "\treturn true;" + NL + "}";
  protected final String TEXT_161 = NL + "//------------------------" + NL + "// INLINE FUNCTIONS" + NL + "//------------------------";
  protected final String TEXT_162 = NL;
  protected final String TEXT_163 = NL + "//#define ";
  protected final String TEXT_164 = " ";
  protected final String TEXT_165 = NL + "//------------------------" + NL + "// PACKAGE/EXTERNAL DECLARATIONS" + NL + "//------------------------" + NL + "/* External declarations (package visibility)*/";
  protected final String TEXT_166 = NL;
  protected final String TEXT_167 = NL + NL + "//A template function to get the index of an item for a given vector. It returns -1 if the" + NL + "//item was not found" + NL + "template < typename InputIterator, typename EqualityComparable >" + NL + "\tint IndexOf(const InputIterator& begin," + NL + "\tconst InputIterator& end, const EqualityComparable& item) {" + NL + "\t\tif(begin == end )" + NL + "\t\t\treturn -1;" + NL + "" + NL + "\t\tInputIterator fnd = std::find(begin, end, item);" + NL + "\t\tunsigned int index = std::distance(begin, fnd);" + NL + "\t\treturn fnd != end ? index : -1;" + NL + "};" + NL + "" + NL + "//Used as a function pointer to safely destroy elements or collections of elements" + NL + "//Example: " + NL + "//\tstd::for_each( arr->begin(), arr->end(), delete_pointer_element());" + NL + "//\tdelete arr;" + NL + "struct deleteElement{" + NL + " template< typename T >" + NL + " void operator()( T element ) const{" + NL + "\tdelete element;" + NL + "\t}" + NL + "};" + NL + "" + NL + "template<typename T>" + NL + "unsigned int compare(T c1, T c2, unsigned int sz ) {" + NL + "\tif(!is_ptr<T>::value) {" + NL + "\t\treturn memcmp(&c1,&c2, sz);" + NL + "\t}" + NL + "\treturn memcmp((void*)c1, (void*)c2, sz);" + NL + "};" + NL + "" + NL + "template<typename T>" + NL + "void copyObject(T* object1, T* object2, unsigned int sz ) {" + NL + "\tif(!is_ptr<T>::value) {" + NL + "\t\tmemcpy(&object2,&object1, sz);" + NL + "\t}" + NL + " \tmemcpy((void*)object2, (void*)object1, sz);" + NL + "};" + NL + NL + NL;
  protected final String TEXT_168 = "::";
  protected final String TEXT_169 = "friend void ";
  protected final String TEXT_170 = "(";
  protected final String TEXT_171 = "* ";
  protected final String TEXT_172 = ", ";
  protected final String TEXT_173 = "*);";
  protected final String TEXT_174 = "\t" + NL + "void ";
  protected final String TEXT_175 = "(";
  protected final String TEXT_176 = "* _";
  protected final String TEXT_177 = ", ";
  protected final String TEXT_178 = "* ";
  protected final String TEXT_179 = "){" + NL + "\t_";
  protected final String TEXT_180 = "->";
  protected final String TEXT_181 = "= ";
  protected final String TEXT_182 = ";" + NL + "}";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppDefinitions.MAIN_METHOD_CALL, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
	@GenerationArgument String namespace;
	
@Override
public void execute() {


    setNamespace();
    stringBuffer.append(name);
    stringBuffer.append(TEXT_1);
    

}

private void setNamespace(){
	if(namespace== null|| namespace.equals("")){
		return;
	}
	
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(namespace);
    stringBuffer.append(TEXT_3);
    
}


});

}});

getRegistry().define(ICppDefinitions.HASH_CDOE_METHOD_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_4);
    

}});

}});

getRegistry().define(IModelingConstants.NO_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_5);
    

}});

}});

getRegistry().define(ICppDefinitions.HASH_CDOE_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_6);
    

}});

}});

getRegistry().define(ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_7);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_8);
    

}});

}});

getRegistry().define(ICppDefinitions.STRUCT_INCOMPLETE_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String type;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_9);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_10);
    

}});

}});

getRegistry().define(ICppDefinitions.USE_NAMESPACE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_12);
    

}});

}});

getRegistry().define(ICppDefinitions.NAMESPACE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(name);
    

}});

}});

getRegistry().define(ICppDefinitions.INCLUDE_DIRECT_STATEMENT, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String include;
	@GenerationArgument boolean surround;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_14);
    setStart();
    stringBuffer.append(include);
    setEnd();
    

}

private void setStart(){
if(!surround){
	return;
}

    stringBuffer.append(TEXT_15);
    
} 

private void setEnd(){
if(!surround){
	return;
}

    stringBuffer.append(TEXT_16);
    
}

});

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

    stringBuffer.append(TEXT_17);
    open();
    setPath();
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    end();
    

}

private void setPath(){
	if(path== null|| path.isEmpty()){
		return;
	}
	
    stringBuffer.append(path);
    stringBuffer.append(TEXT_19);
    
}

private void open(){
	//No check for empty in order to enable the callers to determine if they want "< >" notation to be used instead
	if(isCompilerHeader&& path== null){
		
    stringBuffer.append(TEXT_20);
    
		return;
	}
	
    stringBuffer.append(TEXT_21);
    
}

private void end(){
	//No check for empty in order to enable the callers to determine if they want "< >" notation to be used instead
	if(isCompilerHeader&& path== null){
		
    stringBuffer.append(TEXT_22);
    
		return;
	}
	
    stringBuffer.append(TEXT_23);
    
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

    stringBuffer.append(TEXT_24);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_25);
    

}});

}});

getRegistry().define(ICppDefinitions.DESTRUCT_ATTRIBUTE, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String name;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_27);
    

}});

}});

getRegistry().define(ICppDefinitions.THROW_STATEMENET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String body;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_29);
    

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

    stringBuffer.append(TEXT_30);
    stringBuffer.append(name);
    extendsCall();
    

}

private void extendsCall(){
	if(extendsSegment.isEmpty()){
		return;
	}
	
    stringBuffer.append(TEXT_31);
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

    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(includes);
    
}

private void librariesIncludes(){
	if(this.librariesIncludes.isEmpty()){
		return;
	}

    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(librariesIncludes);
    
}

private void librariesUse(){
	if(this.librariesUse.isEmpty()){
		return;
	}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(librariesUse);
    
}

});
}});

getRegistry().define(ICppDefinitions.RETURN_STATEMENET, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String statement;
	@GenerationArgument boolean wrapped;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(statement);
    wrap();
    

}

private void wrap(){
if(wrapped){
	return;
}

    stringBuffer.append(TEXT_39);
    
}

});
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
	

    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
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
	@GenerationArgument boolean invert;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_42);
    setStart();
    stringBuffer.append(condition);
    setEnd();
    stringBuffer.append(TEXT_43);
    stringBuffer.append(block);
    stringBuffer.append(TEXT_44);
    

}

private void setStart(){

if(!invert){
	return;
}


    stringBuffer.append(TEXT_45);
    

}

private void setEnd(){

if(!invert){
	return;
}


    stringBuffer.append(TEXT_46);
    
}

});

}});

getRegistry().define(ICppDefinitions.ELSE_CONDITION_BLOCK, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String block;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(StringUtil.indent(block, 1));
    stringBuffer.append(TEXT_48);
    

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
    stringBuffer.append(TEXT_49);
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
    stringBuffer.append(TEXT_50);
    stringBuffer.append(right);
    stringBuffer.append(TEXT_51);
    

}

private void setType(){
	if(type.isEmpty()){
		return;
	}
	
	
    stringBuffer.append(type);
    stringBuffer.append(TEXT_52);
    	
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

    stringBuffer.append(TEXT_53);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_54);
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

    stringBuffer.append(TEXT_55);
    stringBuffer.append(root);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(target);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_59);
    

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

    stringBuffer.append(TEXT_60);
    stringBuffer.append(base);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_63);
    

}});

}});


getRegistry().define(ICppDefinitions.INCOMPLETE_NAMESPACES_DEFNITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String definitionsBody;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(definitionsBody);
    stringBuffer.append(TEXT_66);
    

}});

}});

getRegistry().define(ICppDefinitions.GNUC_DEFINITION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {

    stringBuffer.append(TEXT_67);
    

}});

}});

getRegistry().define(ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String definitions;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
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
    stringBuffer.append(TEXT_70);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_71);
    

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
    stringBuffer.append(TEXT_72);
    

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
    stringBuffer.append(TEXT_73);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_74);
    
}

private void setGeneric(){
	if(genericType== null|| genericType.isEmpty()){
		return;
	}
	
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genericType);
    stringBuffer.append(TEXT_76);
    
}

private void setPrefix(){
	if(prefix== null|| prefix.isEmpty()){
		return;
	}
	
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_77);
    
}

private void setPointer(){
	if(!isPointer){
		return;
	}
	
    stringBuffer.append(TEXT_78);
    
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
	@GenerationArgument(id= IModelingElementDefinitions.IS_CONSTANT) boolean isConstant;
	
@Override
public void execute() {


    setConstant();
    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(owner);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_82);
    

}

private void setConstant(){

if(!isConstant){
	return;
}


    stringBuffer.append(TEXT_83);
    
}

});

}});

getRegistry().define(ICppDefinitions.ATTRIBUTES_IMPLEMENTATIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String implementation;
	
@Override
public void execute() {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
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
    stringBuffer.append(TEXT_86);
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
		
    stringBuffer.append(TEXT_87);
    		
	}else{
		
    stringBuffer.append(TEXT_88);
    
	}
}

public void isStatement(){
	if(this.isStatement){
		
    stringBuffer.append(TEXT_89);
    		
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
    stringBuffer.append(TEXT_90);
    stringBuffer.append(variable);
    

}

private void setPointer(){
	if(!isPointer){
		return;
	}
	
    stringBuffer.append(TEXT_91);
    	
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
    stringBuffer.append(TEXT_92);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_94);
    

}

});

}});

getRegistry().define(ICppDefinitions.METHOD_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument(id= IModelingConstants.METHOD_NAME) String qualifiedMethodName;
	@GenerationArgument(id= IModelingConstants.METHOD_CONTENTS) String codeBody;
	@GenerationArgument(id= IModelingConstants.METHOD_PARAMETERS_STRING) String parameters;
	@GenerationArgument(id= IModelingConstants.METHOD_RETURN_TYPE) String returnType;
	@GenerationArgument(id= ICppDefinitions.METHOD_CONST) boolean isConstant;
	@GenerationArgument(id= ICppDefinitions.METHOD_INLINE) boolean isInline;
	@GenerationArgument(id= ICppDefinitions.METHOD_STATIC) boolean isStatic;
	//@GenerationArgument(id= ICppDefinitions.METHOD_INIT) boolean init;
			
@Override
public void execute() {


    setInline();
    stringBuffer.append(returnType);
    setStatic();
    stringBuffer.append(TEXT_95);
    stringBuffer.append(qualifiedMethodName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_97);
    setConstant();
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(codeBody);
    stringBuffer.append(TEXT_100);
    

}

private void setConstant(){
	if(!isConstant){
		return;
	}
	
    stringBuffer.append(TEXT_101);
    
}

private void setInline(){
	if(!isInline){
		return;
	}
	
	
    stringBuffer.append(TEXT_102);
    
}

private void setStatic(){
	if(!isStatic){
		return;
	}
	
	
    stringBuffer.append(TEXT_103);
    
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
	@GenerationArgument(id= ICppDefinitions.METHOD_STATIC) boolean isStatic;
	@GenerationArgument(id= ICppDefinitions.METHOD_CONST) boolean isConstant;
	@GenerationArgument(id= ICppDefinitions.METHOD_VIRTUAL) boolean isVirtual;
	@GenerationArgument(id= ICppDefinitions.METHOD_PURE) boolean isPure;
	
@Override
public void execute() {


    setIsStatic();
    setVirtual();
    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(qualifiedMethodName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_106);
    setConstant();
    setPure();
    stringBuffer.append(TEXT_107);
    

}

private void setIsStatic(){
	if(!isStatic){
		return;
	}
	
    stringBuffer.append(TEXT_108);
    
}

private void setConstant(){
	if(!isConstant){
		return;
	}
	
    stringBuffer.append(TEXT_109);
    
}

private void setVirtual(){
	if(!isVirtual){
		return;
	}
	
    stringBuffer.append(TEXT_110);
    
}

private void setPure(){
	if(!isPure){
		return;
	}
	
    stringBuffer.append(TEXT_111);
    
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
    stringBuffer.append(TEXT_112);
    stringBuffer.append(parameters);
    stringBuffer.append(TEXT_113);
    statement();
    

}

public void statement(){
	if(!isStatemenet){
		return;
	}
	
	
    stringBuffer.append(TEXT_114);
    
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

    stringBuffer.append(TEXT_115);
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


    stringBuffer.append(TEXT_116);
    stringBuffer.append(visibility);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(TEXT_118);
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

    stringBuffer.append(TEXT_119);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_120);
    
}});

}});

getRegistry().define(ICppDefinitions.ASSOCIATIONS_DECLARATION +ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String name;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_122);
    
}});

}});

getRegistry().define(ICppDefinitions.STATIC_ATTRIBUTE_DECLARATIONS +ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(TEXT_123);
    

}});

}});

getRegistry().define(ICppDefinitions.HELPER_ATTRIBUTES_DECLARATION +ICppDefinitions.COMMENTS_SUFFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {

    stringBuffer.append(TEXT_124);
    
}});

}});

getRegistry().define(ICppDefinitions.ATTRIBUTE_EQUALITY_ENTRY, new GenerationProcdure(this){
	
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

    stringBuffer.append(TEXT_125);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_128);
    
}

protected void many() {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_132);
    
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


    stringBuffer.append(TEXT_133);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_135);
    	
}

});

}});

getRegistry().define(ICppDefinitions.COMPARATORS_DETAILS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String contents;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_136);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(contents);
    	
}

});

}});

getRegistry().define(ICppDefinitions.BASE_COMPARATOR, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String comparatorName;
	@GenerationArgument String type;
	@GenerationArgument String keyField;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_138);
    stringBuffer.append(comparatorName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(keyField);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(keyField);
    stringBuffer.append(TEXT_145);
    	
}

});

}});

getRegistry().define(ICppDefinitions.BASE_COMPARATOR_DEFAULT_NAME, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String owenr;
	@GenerationArgument String key;
			
@Override
public void execute() {


    stringBuffer.append(owenr);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_147);
    	
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


    stringBuffer.append(TEXT_148);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_150);
    	
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


    stringBuffer.append(TEXT_151);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_152);
    	
}

});

}});

getRegistry().define(ICppDefinitions.PREDEFINED_OPERATORS_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String contents;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(contents);
    
}});

}});

getRegistry().define(ICppDefinitions.PREDEFINED_OPERATORS_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String contents;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(contents);
    
}});

}});

getRegistry().define(ICppDefinitions.ATTRIBUTE_EQUALITY_OPERATOR_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String type;
	@GenerationArgument String operators;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(operators);
    stringBuffer.append(TEXT_160);
    
}});

}});

getRegistry().define(ICppDefinitions.HEADER_INLINE_FUNCTION_CONTENTS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationArgument String inlineFunctionContents;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_161);
    stringBuffer.append(TEXT_162);
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

    stringBuffer.append(TEXT_163);
    stringBuffer.append(definition);
    stringBuffer.append(TEXT_164);
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


    stringBuffer.append(TEXT_165);
    stringBuffer.append(TEXT_166);
    stringBuffer.append( packageContents );
    

}});

}});

getRegistry().define(ICppDefinitions.PREDEFINED_FUNCTIONS, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

@Override
public void execute() {


    stringBuffer.append(TEXT_167);
    

}});

}});

getRegistry().define(ICppDefinitions.CLASS_PREFIX, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
			
@Override
public void execute() {


    stringBuffer.append(name);
    stringBuffer.append(TEXT_168);
    

}});

}});



getRegistry().define(ICppDefinitions.FRIEND_SETTER_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
		
	String parameter, existingMethodName;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_169);
    stringBuffer.append( existingMethodName );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(typeName );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_173);
    

}

@Override
public void preExecute(){
	this.parameter= getRegistry().use(ICppNameConstants.NEW_INSTANCE, otherEndTypeName);
	this.existingMethodName= getRegistry().use(ICppNameConstants.FRIEND_SETTER, typeName, otherEndTypeName);
}

});

}});

getRegistry().define(ICppDefinitions.FRIEND_SETTER_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName;
	@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName;
		
	String parameter, existingMethodName;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_174);
    stringBuffer.append( existingMethodName );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(typeName );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append( otherEndName );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(parameter);
    stringBuffer.append(TEXT_182);
    

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