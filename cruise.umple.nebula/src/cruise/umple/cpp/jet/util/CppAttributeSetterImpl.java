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
import cruise.umple.modeling.handlers.*;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.cpp.ICppNameConstants;
import cruise.umple.modeling.handlers.cpp.ICppAssociationsDefinitionsConstants;
import cruise.umple.core.GenerationCallback.*;

@SuppressWarnings({ "nls", "unqualified-field-access" })
public class CppAttributeSetterImpl extends CppGenerationTemplate{
   
  protected static String nl;
  public static synchronized CppAttributeSetterImpl create(String lineSeparator)
  {
    nl = lineSeparator;
    CppAttributeSetterImpl result = new CppAttributeSetterImpl();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\treturn wasSet;";
  protected final String TEXT_3 = "if(!this->";
  protected final String TEXT_4 = ") { " + NL + "\treturn false; " + NL + "}" + NL + "this->";
  protected final String TEXT_5 = "= false;" + NL;
  protected final String TEXT_6 = "\t" + NL + "\tif (";
  protected final String TEXT_7 = " == NULL){" + NL + "\t\t";
  protected final String TEXT_8 = "* existing";
  protected final String TEXT_9 = " = this->";
  protected final String TEXT_10 = ";" + NL + "\t\tthis->";
  protected final String TEXT_11 = " = NULL;" + NL + "\t\t" + NL + "\t\tif (existing";
  protected final String TEXT_12 = " != NULL && existing";
  protected final String TEXT_13 = "->";
  protected final String TEXT_14 = "() != NULL){" + NL + "\t\t\texisting";
  protected final String TEXT_15 = "->";
  protected final String TEXT_16 = "(NULL);" + NL + "\t\t}" + NL + "\t\twasSet = true;" + NL + "\t\treturn wasSet;" + NL + "    }" + NL + "    " + NL + "\t";
  protected final String TEXT_17 = "* current";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "();" + NL + "\tif (current";
  protected final String TEXT_20 = " != NULL && current";
  protected final String TEXT_21 = "!= ";
  protected final String TEXT_22 = "){" + NL + "\t\tcurrent";
  protected final String TEXT_23 = "->";
  protected final String TEXT_24 = "(NULL);" + NL + "\t}" + NL + "\t" + NL + "\tthis->";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ";" + NL + "\t";
  protected final String TEXT_27 = "* ";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = "->";
  protected final String TEXT_30 = "();" + NL + "    " + NL + "\tif (this!=";
  protected final String TEXT_31 = "){" + NL + "\t\t";
  protected final String TEXT_32 = "->";
  protected final String TEXT_33 = "(this);" + NL + "\t}" + NL + "\twasSet = true;" + NL + "\t";
  protected final String TEXT_34 = "\t";
  protected final String TEXT_35 = NL + "\t";
  protected final String TEXT_36 = "* existing";
  protected final String TEXT_37 = " = this->";
  protected final String TEXT_38 = ";" + NL + "\tthis->";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = ";" + NL + "\tif (existing";
  protected final String TEXT_41 = " != NULL && existing";
  protected final String TEXT_42 = " !=";
  protected final String TEXT_43 = "){" + NL + "\t\texisting";
  protected final String TEXT_44 = "->";
  protected final String TEXT_45 = "(this);" + NL + "\t}" + NL + "\t" + NL + "\tif (";
  protected final String TEXT_46 = " != NULL){" + NL + "\t\t";
  protected final String TEXT_47 = "->";
  protected final String TEXT_48 = "(this);" + NL + "\t}" + NL + "\twasSet = true;" + NL + "\t";
  protected final String TEXT_49 = NL + "\tif (";
  protected final String TEXT_50 = " != NULL && ";
  protected final String TEXT_51 = "->";
  protected final String TEXT_52 = "() >= ";
  protected final String TEXT_53 = "->";
  protected final String TEXT_54 = "()){" + NL + "\t\treturn wasSet;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_55 = NL + "\tif (this->";
  protected final String TEXT_56 = " != NULL && this->";
  protected final String TEXT_57 = " != ";
  protected final String TEXT_58 = " && this== this->";
  protected final String TEXT_59 = "->";
  protected final String TEXT_60 = "()){" + NL + "\t\t//Unable to set ";
  protected final String TEXT_61 = ", as existing ";
  protected final String TEXT_62 = " would become an orphan" + NL + " \t\treturn wasSet;" + NL + "\t}" + NL + " \t" + NL + "\tthis->";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL + "\t";
  protected final String TEXT_65 = "* ";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = " != NULL ? ";
  protected final String TEXT_68 = "->";
  protected final String TEXT_69 = "() : NULL;" + NL + "\t" + NL + "\tif (this != ";
  protected final String TEXT_70 = "){" + NL + "\t\tif (";
  protected final String TEXT_71 = " != NULL){" + NL + "\t \t \t";
  protected final String TEXT_72 = "->";
  protected final String TEXT_73 = " = NULL;" + NL + "\t \t}" + NL + "\t \t" + NL + " \t\tif (this->";
  protected final String TEXT_74 = " != NULL){" + NL + "   \t\t\tthis->";
  protected final String TEXT_75 = "->";
  protected final String TEXT_76 = "(this);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_77 = "  " + NL + "\t";
  protected final String TEXT_78 = "* existing";
  protected final String TEXT_79 = " = this->";
  protected final String TEXT_80 = ";" + NL + "\t" + NL + "\tif (existing";
  protected final String TEXT_81 = " == NULL) {" + NL + "\t\tif (";
  protected final String TEXT_82 = " != NULL && ";
  protected final String TEXT_83 = "->";
  protected final String TEXT_84 = "(this)) {" + NL + "\t\t\texisting";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";" + NL + "\t\t\twasSet = true;" + NL + "\t\t}" + NL + "\t" + NL + "\t} else if (existing";
  protected final String TEXT_87 = "->";
  protected final String TEXT_88 = "() < existing";
  protected final String TEXT_89 = "->";
  protected final String TEXT_90 = "()) {" + NL + "\t\texisting";
  protected final String TEXT_91 = "->";
  protected final String TEXT_92 = "(this);" + NL + "\t\tif (";
  protected final String TEXT_93 = " != NULL) {" + NL + "\t\t\t";
  protected final String TEXT_94 = "->";
  protected final String TEXT_95 = "(this);" + NL + "\t\t}" + NL + "\t" + NL + "\t\texisting";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = ";" + NL + "\t\twasSet = true;" + NL + "\t}" + NL + "\t" + NL + "\tif (wasSet) {" + NL + "\t\tthis->";
  protected final String TEXT_98 = " = existing";
  protected final String TEXT_99 = ";" + NL + "\t}";
  protected final String TEXT_100 = NL + "\tif (";
  protected final String TEXT_101 = " == NULL){" + NL + " \t\t//Unable to set ";
  protected final String TEXT_102 = " to NULL, as ";
  protected final String TEXT_103 = " must always be associated to a ";
  protected final String TEXT_104 = NL + " \t\treturn wasSet;" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_105 = "* ";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = "->";
  protected final String TEXT_108 = "();" + NL + "\tif (";
  protected final String TEXT_109 = " != NULL && this!= ";
  protected final String TEXT_110 = "){" + NL + "  \t\t//Unable to set ";
  protected final String TEXT_111 = ", the current ";
  protected final String TEXT_112 = " already has a ";
  protected final String TEXT_113 = ", which would be orphaned if it were re-assigned" + NL + "  \t\treturn wasSet;" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_114 = "* old";
  protected final String TEXT_115 = " = this->";
  protected final String TEXT_116 = ";" + NL + "\tthis->";
  protected final String TEXT_117 = " = ";
  protected final String TEXT_118 = ";" + NL + "\tthis->";
  protected final String TEXT_119 = "->";
  protected final String TEXT_120 = "(this);" + NL + "\t" + NL + "\tif (old";
  protected final String TEXT_121 = " != NULL) {" + NL + "  \t\told";
  protected final String TEXT_122 = "->";
  protected final String TEXT_123 = "(NULL);" + NL + "\t}" + NL + "\twasSet = true;" + NL + "\t";
  protected final String TEXT_124 = "\t" + NL + "\tif (";
  protected final String TEXT_125 = " == NULL){" + NL + "\t\treturn wasSet;" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_126 = "* existing";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = ";" + NL + "\tthis->";
  protected final String TEXT_129 = " = ";
  protected final String TEXT_130 = ";" + NL + "\t" + NL + "\tif (existing";
  protected final String TEXT_131 = " != NULL && existing";
  protected final String TEXT_132 = " != ";
  protected final String TEXT_133 = "){" + NL + "\t  \texisting";
  protected final String TEXT_134 = "->";
  protected final String TEXT_135 = "(this);" + NL + "\t}" + NL + "\tthis->";
  protected final String TEXT_136 = "->";
  protected final String TEXT_137 = "(this);" + NL + "\twasSet = true;";
  protected final String TEXT_138 = NL + "\tif (";
  protected final String TEXT_139 = " == NULL){" + NL + "\t\t//Must provide ";
  protected final String TEXT_140 = " to ";
  protected final String TEXT_141 = NL + "\t\treturn wasSet;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_142 = NL + "\t" + NL + "\t";
  protected final String TEXT_143 = "* existing";
  protected final String TEXT_144 = " = this->";
  protected final String TEXT_145 = ";" + NL + "\tthis->";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = ";" + NL + "\tif (existing";
  protected final String TEXT_148 = " != NULL && existing";
  protected final String TEXT_149 = "!= ";
  protected final String TEXT_150 = "){" + NL + "\t\tbool didRemove = existing";
  protected final String TEXT_151 = "->";
  protected final String TEXT_152 = "(this);" + NL + "\t\tif (!didRemove){" + NL + "\t\t\tthis->";
  protected final String TEXT_153 = " = existing";
  protected final String TEXT_154 = ";" + NL + "\t\t\treturn wasSet;" + NL + "\t\t}" + NL + "\t}" + NL + "\tthis->";
  protected final String TEXT_155 = "->";
  protected final String TEXT_156 = "(this);" + NL + "\twasSet = true;";
  protected final String TEXT_157 = "\t" + NL + "\t";
  protected final String TEXT_158 = " checkNew";
  protected final String TEXT_159 = "s= ";
  protected final String TEXT_160 = ";" + NL + "\t" + NL + "\tfor (unsigned int index=0; index<";
  protected final String TEXT_161 = "->size(); index++){";
  protected final String TEXT_162 = ";" + NL + "  \t\t" + NL + "  \t\tunsigned int indexOf= IndexOf(checkNew";
  protected final String TEXT_163 = "s->begin(), checkNew";
  protected final String TEXT_164 = "s->end(), a";
  protected final String TEXT_165 = ");" + NL + "    \tif(indexOf>-1|| (a";
  protected final String TEXT_166 = "->";
  protected final String TEXT_167 = "() != NULL && this !=a";
  protected final String TEXT_168 = "->";
  protected final String TEXT_169 = "())){" + NL + "    \t\treturn wasSet;" + NL + "    \t}" + NL + "    \t";
  protected final String TEXT_170 = NL + "  \t}" + NL + "    " + NL + "\t" + NL + "\tif (checkNew";
  protected final String TEXT_171 = "s->size() != ";
  protected final String TEXT_172 = "->size()) {" + NL + "\t\treturn wasSet;" + NL + "\t}" + NL + "" + NL + "    //Remove all checkNew";
  protected final String TEXT_173 = "s from ";
  protected final String TEXT_174 = NL + "    " + NL + "    for (unsigned int index=0 ;index<";
  protected final String TEXT_175 = "->size(); index++){";
  protected final String TEXT_176 = ";" + NL + "\t\t";
  protected final String TEXT_177 = "(orphan, NULL);" + NL + "    }" + NL + "    ";
  protected final String TEXT_178 = NL + "    ";
  protected final String TEXT_179 = "->clear();" + NL + "    for (unsigned int index=0; index<";
  protected final String TEXT_180 = "->size(); index++){";
  protected final String TEXT_181 = ";" + NL + "    \t";
  protected final String TEXT_182 = "(a";
  protected final String TEXT_183 = ", this);" + NL + "    \t";
  protected final String TEXT_184 = NL + "    }" + NL + "    " + NL + "    wasSet = true;";
  protected final String TEXT_185 = NL;
  protected final String TEXT_186 = NL;
  protected final String TEXT_187 = "\t" + NL + "\t";
  protected final String TEXT_188 = " ";
  protected final String TEXT_189 = "= ";
  protected final String TEXT_190 = ";" + NL + "\tfor (unsigned int index=0; index<";
  protected final String TEXT_191 = "->size(); index++) {";
  protected final String TEXT_192 = ";" + NL + "\t\tif (IndexOf(";
  protected final String TEXT_193 = "->begin(), ";
  protected final String TEXT_194 = "->end(), temp)> -1) {" + NL + "\t\t\tcontinue;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_195 = NL + "\t\tdelete temp;" + NL + "\t}" + NL + "\tif (";
  protected final String TEXT_196 = "->size() != ";
  protected final String TEXT_197 = "->size() ";
  protected final String TEXT_198 = ") {" + NL + "\t\treturn wasSet;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_199 = NL + "\twasSet = true;";
  protected final String TEXT_200 = NL;
  protected final String TEXT_201 = NL + "\tthis->";
  protected final String TEXT_202 = " = ";
  protected final String TEXT_203 = ";";
  protected final String TEXT_204 = NL;
  protected final String TEXT_205 = " " + NL + "\t";
  protected final String TEXT_206 = " ";
  protected final String TEXT_207 = "= ";
  protected final String TEXT_208 = ";";
  protected final String TEXT_209 = NL;
  protected final String TEXT_210 = NL + "\tthis->";
  protected final String TEXT_211 = "->clear();" + NL + "\tfor (unsigned int index=0; index<";
  protected final String TEXT_212 = "->size(); index++) {";
  protected final String TEXT_213 = ";" + NL + "\t\tthis->";
  protected final String TEXT_214 = "(";
  protected final String TEXT_215 = ");" + NL + "" + NL + "\t\tunsigned int indexOf= IndexOf(";
  protected final String TEXT_216 = "->begin(), ";
  protected final String TEXT_217 = "->end(), ";
  protected final String TEXT_218 = ");" + NL + "\t\tif (index> -1) {";
  protected final String TEXT_219 = NL + "\t\t}else{" + NL + "\t\t\t";
  protected final String TEXT_220 = "->";
  protected final String TEXT_221 = "(this);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tdelete ";
  protected final String TEXT_222 = ";" + NL + "\t}" + NL + "" + NL + "\tfor (unsigned int index=0; index<";
  protected final String TEXT_223 = "->size(); index++) {";
  protected final String TEXT_224 = ";" + NL + "\t\t_a_";
  protected final String TEXT_225 = "->";
  protected final String TEXT_226 = "(this);" + NL + "\t}" + NL + "\t" + NL + "\tdelete ";
  protected final String TEXT_227 = ";";
  protected final String TEXT_228 = NL;
  protected final String TEXT_229 = NL;
  protected final String TEXT_230 = "\t" + NL + "\t";
  protected final String TEXT_231 = NL + "\t";
  protected final String TEXT_232 = " checkNew";
  protected final String TEXT_233 = "s= ";
  protected final String TEXT_234 = ";" + NL + "\t" + NL + "\thash_map<";
  protected final String TEXT_235 = "*, int>* _";
  protected final String TEXT_236 = "ToNew";
  protected final String TEXT_237 = "s= new hash_map<";
  protected final String TEXT_238 = "*, int>();" + NL + "\t" + NL + "\tfor (unsigned int index=0; index<";
  protected final String TEXT_239 = "->size(); index++){";
  protected final String TEXT_240 = ";" + NL + "    \tunsigned int indexOf= IndexOf(checkNew";
  protected final String TEXT_241 = "s->begin(), checkNew";
  protected final String TEXT_242 = "s->end(), a";
  protected final String TEXT_243 = ");" + NL + "    \tif(indexOf>-1){" + NL + "    \t\treturn wasSet;" + NL + "    \t}" + NL + "" + NL + "    \tif (a";
  protected final String TEXT_244 = "->";
  protected final String TEXT_245 = "() != NULL && this !=a";
  protected final String TEXT_246 = "->";
  protected final String TEXT_247 = "()){" + NL + "\t\t\t";
  protected final String TEXT_248 = "* existing";
  protected final String TEXT_249 = " = a";
  protected final String TEXT_250 = "->";
  protected final String TEXT_251 = "();" + NL + "\t\t\tif ((*_";
  protected final String TEXT_252 = "ToNew";
  protected final String TEXT_253 = "s)[existing";
  protected final String TEXT_254 = "]== NULL){" + NL + "\t\t\t\t_";
  protected final String TEXT_255 = "ToNew";
  protected final String TEXT_256 = "s->insert(std::pair<";
  protected final String TEXT_257 = "*, int>(existing";
  protected final String TEXT_258 = ",existing";
  protected final String TEXT_259 = "->";
  protected final String TEXT_260 = "()));" + NL + "\t\t\t}" + NL + "\t\t\tint currentCount = (*_";
  protected final String TEXT_261 = "ToNew";
  protected final String TEXT_262 = "s)[existing";
  protected final String TEXT_263 = "];" + NL + "\t\t\tint nextCount = currentCount - 1;" + NL + "\t\t\tif (nextCount < 1){" + NL + "\t\t\t  return wasSet;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t_";
  protected final String TEXT_264 = "ToNew";
  protected final String TEXT_265 = "s->insert(std::pair<";
  protected final String TEXT_266 = "*, int>(existing";
  protected final String TEXT_267 = ",nextCount));" + NL + "   \t\t}" + NL + "   \t\t";
  protected final String TEXT_268 = NL + "    }" + NL + "" + NL + "    //Remove all checkNew";
  protected final String TEXT_269 = "s from ";
  protected final String TEXT_270 = NL + "\t";
  protected final String TEXT_271 = "->clear();" + NL + "    " + NL + "    for (unsigned int index=0; index<";
  protected final String TEXT_272 = "->size(); index++){";
  protected final String TEXT_273 = ";" + NL + "  \t\t";
  protected final String TEXT_274 = "(current, NULL);" + NL + "  \t}" + NL + "" + NL + "    this->";
  protected final String TEXT_275 = "->clear();" + NL + "    for (unsigned int index=0; index<";
  protected final String TEXT_276 = "->size(); index++){";
  protected final String TEXT_277 = ";" + NL + "    \tif (a";
  protected final String TEXT_278 = "->";
  protected final String TEXT_279 = "() != NULL){" + NL + "    \t\ta";
  protected final String TEXT_280 = "->";
  protected final String TEXT_281 = "()->";
  protected final String TEXT_282 = "(a";
  protected final String TEXT_283 = ");" + NL + "    \t}" + NL + "  \t\t";
  protected final String TEXT_284 = "(a";
  protected final String TEXT_285 = ", this);" + NL + "  \t\t";
  protected final String TEXT_286 = NL + "    }";
  protected final String TEXT_287 = NL;
  protected final String TEXT_288 = "\tthis->";
  protected final String TEXT_289 = " = ";
  protected final String TEXT_290 = ";" + NL + "\twasSet = true;";
  protected final String TEXT_291 = "\tif(";
  protected final String TEXT_292 = " != NULL){";
  protected final String TEXT_293 = NL;
  protected final String TEXT_294 = NL + "\t}";
  protected final String TEXT_295 = "if (";
  protected final String TEXT_296 = "){" + NL + "\t\treturn wasSet;" + NL + "\t}";
  protected final String TEXT_297 = "->size() < ";
  protected final String TEXT_298 = "()";
  protected final String TEXT_299 = "||";
  protected final String TEXT_300 = "->size() > ";
  protected final String TEXT_301 = "()";
  protected final String TEXT_302 = "this->";
  protected final String TEXT_303 = "!= NULL&& this->";
  protected final String TEXT_304 = "->";
  protected final String TEXT_305 = "() <= ";
  protected final String TEXT_306 = "->";
  protected final String TEXT_307 = "()";
  protected final String TEXT_308 = "->";
  protected final String TEXT_309 = "() >= ";
  protected final String TEXT_310 = "->";
  protected final String TEXT_311 = "()";
  protected final String TEXT_312 = "\t" + NL + "\tif (";
  protected final String TEXT_313 = "){" + NL + "\t\treturn wasSet;" + NL + "\t}";
  protected final String TEXT_314 = "||";
  protected final String TEXT_315 = "->size() < ";
  protected final String TEXT_316 = "()";
  protected final String TEXT_317 = "||";
  protected final String TEXT_318 = "->size() > ";
  protected final String TEXT_319 = "()";

  /**
  * @param argument
  * @param arguments
  * @return
  */
  @Override
  public String define()
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

getRegistry().define(ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@GenerationArgument String content;
			
@Override
public void execute() {


    stringBuffer.append(TEXT_1);
    stringBuffer.append(content);
    

}});

}});


getRegistry().define(ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION_END, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
@Override
public void execute() {


    stringBuffer.append(TEXT_2);
    

}});

}});


getRegistry().define(ICppAssociationsDefinitionsConstants.SETTER_CAN_SET_CHECK, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {
	
	@StubPoint(id = ICppNameConstants.CAN_SET) String nameAsVariableElement;
	@GenerationArgument String nameAsVariable;
	
	String canSetFlag;
			
@Override
public void execute() {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(canSetFlag);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(canSetFlag);
    stringBuffer.append(TEXT_5);
    
}

@Override
public void preExecute(){
	//Allow defining by element type name, if not, then by argument
	this.canSetFlag= element!=null? this.nameAsVariableElement: this.nameAsVariable;
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_OPTIONAL_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument String nameAsVariable;
	String otherGetterMethodName, getterMethodName, setterMethodName, existingOtherEndVariableName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_6);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( otherGetterMethodName );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( setterMethodName );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( setterMethodName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_25);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(existingOtherEndVariableName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( otherGetterMethodName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(existingOtherEndVariableName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( setterMethodName );
    stringBuffer.append(TEXT_33);
    

}

@Override
public void preExecute(){
	this.otherGetterMethodName= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.getterMethodName= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));	
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.existingOtherEndVariableName= getRegistry().generationPointString(element, ICppNameConstants.EXISTING, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_UNBOUND_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName;
	
	@GenerationArgument String nameAsVariable;
	@GenerationArgument boolean check;
	String removeMethodName, addMethodName, otherEndmaximumNumberMethodName, numberOfMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_34);
    check();
    stringBuffer.append(TEXT_35);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_39);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( removeMethodName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_46);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_47);
    stringBuffer.append( addMethodName );
    stringBuffer.append(TEXT_48);
    

}

private void check(){
	if(!check){
		return;
	}	
	

    stringBuffer.append(TEXT_49);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( nameAsVariable);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(numberOfMethodName );
    stringBuffer.append(TEXT_52);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( otherEndmaximumNumberMethodName );
    stringBuffer.append(TEXT_54);
    
}

@Override
public void preExecute(){
	this.otherEndmaximumNumberMethodName= getRegistry().use(IModelingConstants.MAXIMUM_NUMBER_OF, otherEndName);
	
	this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.addMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
			
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});


getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HANDLE_ONE_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument String nameAsVariable;
	String getterMethodName, setterMethodName, oldVariable;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_55);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_57);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_59);
    stringBuffer.append( getterMethodName );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_63);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( otherEndTypeName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_66);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( getterMethodName );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_75);
    stringBuffer.append( setterMethodName );
    stringBuffer.append(TEXT_76);
    

}

@Override
public void preExecute(){
	this.getterMethodName= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.oldVariable= getRegistry().use(ICppNameConstants.OLD, otherEndTypeName);
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_RANGED_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument String nameAsVariable;
	String removeMethodName, addMethodName, numberOfMethodName, minimumNumberMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_77);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_80);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( addMethodName );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(minimumNumberMethodName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(numberOfMethodName );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( removeMethodName );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( addMethodName );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_98);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_99);
    

}

@Override
public void preExecute(){
	this.minimumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
			
	this.addMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
			
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_USE_EXISTING_SETTER_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument String nameAsVariable;
	String getterMethodName, setterMethodName, existingOtherEndVariableName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_100);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( otherEndTypeName );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( existingOtherEndVariableName );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( getterMethodName );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( existingOtherEndVariableName );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( existingOtherEndVariableName );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_112);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_117);
    stringBuffer.append( nameAsVariable );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(setterMethodName);
    stringBuffer.append(TEXT_123);
    

}

@Override
public void preExecute(){
	this.getterMethodName= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.setterMethodName= getRegistry().generationPointString(element, ICppNameConstants.SET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	this.existingOtherEndVariableName= getRegistry().generationPointString(element, ICppNameConstants.EXISTING, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});


getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_USE_EXISTING_REMOVE_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument String nameAsVariable;
	String removeMethodName, addMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_124);
    stringBuffer.append( nameAsVariable);
    stringBuffer.append(TEXT_125);
    stringBuffer.append( typeName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( nameAsVariable);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_129);
    stringBuffer.append( nameAsVariable);
    stringBuffer.append(TEXT_130);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_132);
    stringBuffer.append( nameAsVariable);
    stringBuffer.append(TEXT_133);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(addMethodName);
    stringBuffer.append(TEXT_137);
    

}

@Override
public void preExecute(){
	this.addMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MAXIMUM_MANY_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, final Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument String nameAsVariable;
	String removeMethodName, addMethodName;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_138);
    stringBuffer.append( nameAsVariable);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(getGenerationTemplate().generate("class.associations.attributes.internal.contents.element.otherEnd.constraintCheck", element, nameAsVariable));
    stringBuffer.append(TEXT_142);
    stringBuffer.append( typeName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_146);
    stringBuffer.append( nameAsVariable);
    stringBuffer.append(TEXT_147);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_148);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( nameAsVariable);
    stringBuffer.append(TEXT_150);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_153);
    stringBuffer.append( typeName );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(addMethodName);
    stringBuffer.append(TEXT_156);
    

}

@Override
public void preExecute(){
	this.addMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MINIMUM_FIXED_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument String nameAsVariable;
	String getterMethodName, friendSetterMethod,listType, listDefinition;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_157);
    stringBuffer.append(listType);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_161);
    getterCall(typeName +"*" + " a" +typeName, 2);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_169);
    addCall("checkNew"+ typeName+ "s", "a"+ typeName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(nameAsVariable);
    removeAllCall();
    stringBuffer.append(TEXT_174);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_175);
    getterCall(typeName + "*" + " orphan", 2);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(friendSetterMethod);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_180);
    getterCall(typeName+ "*" + " a" +typeName, 2);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(friendSetterMethod);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_183);
    addCall(nameAsVariable, "a"+ typeName);
    stringBuffer.append(TEXT_184);
    

}

public void addCall(String var, String param) {

String addCall= getRegistry().generationPointString(element, ICppDefinitions.ADD_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_VARIABLE_ARGUMENT, var),
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_PARAMETER_ARGUMENT, param));
		

    stringBuffer.append(addCall);
    

}

private void removeAllCall(){

String removeAllCall= getRegistry().generationPointString(element, ICppDefinitions.REMOVE_ALL_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_ALL_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_ALL_VARIABLE_ARGUMENT, name),
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_ALL_REMOVE_LIST_ARGUMENT, "checkNew"+ typeName +"s"));

removeAllCall= StringUtil.indent(removeAllCall, 1);

    stringBuffer.append(TEXT_185);
    stringBuffer.append(removeAllCall);
    

}

private void getterCall(String assignee, int indent){

String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, nameAsVariable),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, "index"));


    stringBuffer.append(TEXT_186);
    stringBuffer.append(StringUtil.indent(getterCall, indent));
    

}

@Override
public void preExecute(){
	this.getterMethodName= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	this.friendSetterMethod= getRegistry().use(ICppNameConstants.FRIEND_SETTER, typeName, otherEndTypeName);
	
	this.listType= getRegistry().generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME,
		GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT, Boolean.FALSE));	
	this.listDefinition= getRegistry().generate(ISTLConstants.NEW_LIST_DEFINITION, element);
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_VERIFIED_LIST_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(final Object element, final Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument String nameAsVariable;
	@GenerationArgument boolean copyDirectly;
	String verifiedList, listType, listDefinition;
	
@Override
public void execute() {


    stringBuffer.append(TEXT_187);
    stringBuffer.append(listType);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(verifiedList);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_191);
    getterCall(typeName + "*" + " temp", 2);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(verifiedList);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(verifiedList);
    stringBuffer.append(TEXT_194);
    addCall();
    stringBuffer.append(TEXT_195);
    stringBuffer.append(verifiedList);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(getGenerationTemplate().generate("class.associations.attributes.internal.contents.constraintCheck", element));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(extension());
    stringBuffer.append(TEXT_199);
    
}

private void getterCall(String assignee, int indent){

String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, nameAsVariable),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, "index"));


    stringBuffer.append(TEXT_200);
    stringBuffer.append(StringUtil.indent(getterCall, indent));
    

}

public void addCall() {

String addCall= getRegistry().generationPointString(element, ICppDefinitions.ADD_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_VARIABLE_ARGUMENT, verifiedList),
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_PARAMETER_ARGUMENT, "temp"));
		

    stringBuffer.append(addCall);
    

}

private StringBuffer extension(){
	if(copyDirectly){
		return copyDirectly();
	}
	return safelyCopy();
}

public StringBuffer copyDirectly() {
return CodeProcedure.generate(new CodeProcedure(getGenerationProcedure(),element, arguments) {

	String verifiedListCopyCall;
		
@Override
public void execute() {


    stringBuffer.append(TEXT_201);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(StringUtil.indent(verifiedListCopyCall, 1));
    
}

@Override
public void preExecute(){
	this.verifiedListCopyCall= getRegistry().generationPointString(element, ICppDefinitions.COPY_INVOCATION,
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_SOURCE_ARGUMENT, verifiedList),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_TARGET_ARGUMENT, "this->"+ name),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_IS_INITIALIZED_ARGUMENT, Boolean.TRUE));
}

});
}

public StringBuffer safelyCopy() {
return CodeProcedure.generate(new CodeProcedure(getGenerationProcedure(),element, arguments) {
	
	String addOtherMethodName, addMethodName, removeMethodName, oldVariable, instanceAsVariable, oldVariableCopyCall;
			
	@Override
	public void execute() {

    stringBuffer.append(TEXT_205);
    stringBuffer.append(listType);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(StringUtil.indent(oldVariableCopyCall, 1));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(verifiedList);
    stringBuffer.append(TEXT_212);
    getterCall(verifiedList, "index", typeName + "*" + " "+ instanceAsVariable, 2);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(addMethodName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_218);
    removeCall(oldVariable, "indexOf");
    stringBuffer.append(TEXT_219);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(addOtherMethodName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(instanceAsVariable);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_223);
    getterCall(oldVariable, "index", typeName + "*" + " _a_" + typeName, 2);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(oldVariable);
    stringBuffer.append(TEXT_227);
    
}

private void getterCall(String var, String varIndex, String assignee, int indent){

String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, var),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, varIndex));


    stringBuffer.append(TEXT_228);
    stringBuffer.append(StringUtil.indent(getterCall, indent));
    

}

public void removeCall(String var, String indexVar) {

String removeCall= getRegistry().generationPointString(element, ICppDefinitions.REMOVE_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_VARIABLE_ARGUMENT, var),
		GenerationArgumentDescriptor.arg(ICppDefinitions.REMOVE_INDEX_ARGUMENT, indexVar));
removeCall= StringUtil.indent(removeCall, 3);

    stringBuffer.append(TEXT_229);
    stringBuffer.append(removeCall);
    

}

@Override
public void preExecute(){
	this.oldVariable= getRegistry().use(ICppNameConstants.OLD, name);
	
	this.addOtherMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.addMethodName= getRegistry().generationPointString(element, ICppNameConstants.ADD_METHOD, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
			
	this.instanceAsVariable= getRegistry().generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
	this.oldVariableCopyCall= getRegistry().generationPointString(element, ICppDefinitions.COPY_INVOCATION,
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_SOURCE_ARGUMENT, "this->" + name),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_TARGET_ARGUMENT, oldVariable),
		GenerationArgumentDescriptor.arg(ICppDefinitions.COPY_IS_INITIALIZED_ARGUMENT, Boolean.TRUE));
}

});
}


@Override
public void preExecute(){
	this.verifiedList= getRegistry().use(ICppNameConstants.VERIFIED, name);
	
	this.listType= getRegistry().generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME,
		GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT, Boolean.FALSE));	
	this.listDefinition= getRegistry().generate(ISTLConstants.NEW_LIST_DEFINITION, element);
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HASH_MAP_DECLARATION, new GenerationProcdure(this){
	
@Override
public StringBuffer execute(Object element, Object... arguments) {
	
return CodeProcedure.generate(new CodeProcedure(this, element, arguments) {

	@GenerationElementParameter(id = NAME) String name;
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE_NAME) String otherEndTypeName;
	@GenerationElementParameter(id = TYPE_NAME) String typeName;
	
	@GenerationArgument String nameAsVariable;
	String getterMethodName, removeMethodName, numberOfMethodName, friendSetterMethod, listType, listDefinition;
	
	
@Override
public void execute() {

	
    stringBuffer.append(TEXT_230);
    stringBuffer.append(getGenerationTemplate().generate("class.associations.attributes.internal.contents.element.constraintCheck", element, nameAsVariable));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(listType);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(listDefinition);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_239);
    getterCall(typeName + "*"+ " a" + typeName, 2);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(numberOfMethodName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(otherEndTypeName);
    stringBuffer.append(TEXT_267);
    addCall("checkNew"+ typeName+ "s", "a"+ typeName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_272);
    getterCall(typeName + "*" + " current", 2);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(friendSetterMethod);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_276);
    getterCall(typeName + "*" + " a" + typeName, 2);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(getterMethodName);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(removeMethodName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(friendSetterMethod);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_285);
    addCall("this->"+name, "a"+ typeName);
    stringBuffer.append(TEXT_286);
    
}

public void addCall(String var, String param) {

String addCall= getRegistry().generationPointString(element, ICppDefinitions.ADD_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_VARIABLE_ARGUMENT, var),
		GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_PARAMETER_ARGUMENT, param));
		

    stringBuffer.append(addCall);
    

}

private void getterCall(String assignee, int indent){

String getterCall= getRegistry().generationPointString(element, ICppDefinitions.GETTER_BY_INDEX_INVOCATION, 
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_VARIABLE_ARGUMENT, nameAsVariable),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_TYPE_ARGUMENT, typeName),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_ASSIGNEE_ARGUMENT, assignee),
		GenerationArgumentDescriptor.arg(ICppDefinitions.GETTER_BY_INDEX_INDEX_VARIABLE_ARGUMENT, "index"));


    stringBuffer.append(TEXT_287);
    stringBuffer.append(StringUtil.indent(getterCall, indent));
    

}

@Override
public void preExecute(){
	this.getterMethodName= getRegistry().generationPointString(element, ICppNameConstants.GET, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	
	this.friendSetterMethod= getRegistry().use(ICppNameConstants.FRIEND_SETTER, typeName, otherEndTypeName);
	
	this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
			
	this.removeMethodName= getRegistry().generationPointString(element, ICppNameConstants.REMOVE, 
		GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	
	this.listType= getRegistry().generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME,
		GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_IS_CONSTRUCTION_ARGUMENT, Boolean.FALSE));	
		
	this.listDefinition= getRegistry().generate(ISTLConstants.NEW_LIST_DEFINITION, element);
}

});

}});

getRegistry().define(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_ASSIGN_DIRECTLY_DECLARATION, new GenerationProcdure(this) {

	@GenerationElementParameter(id = NAME) String name;
	
	@GenerationArgument String nameAsVariable;
	@GenerationArgument boolean check;

@Override
public StringBuffer execute(Object element, Object... arguments) {
	StringBuffer content= contents();
	if(check){
		return check(content);
	}
	return content;
}

public StringBuffer contents() {
return CodeProcedure.generate(new CodeProcedure(this) {

@Override
public void execute() {

    stringBuffer.append(TEXT_288);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_290);
    
}
});
}

public StringBuffer check(final StringBuffer body) {
return CodeProcedure.generate(new CodeProcedure(this) {
		
@Override
public void execute() {

    stringBuffer.append(TEXT_291);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(StringUtil.indent(body.toString(), 1));
    stringBuffer.append(TEXT_294);
    
}});
}
	
});

//////////////////////////////////////////////////////INTERNAL DEFINITIONS///////////////////////////////////////////////////////////////////////////

define("class.associations.attributes.internal.contents.element.constraintCheck", new GenerationProcdure(this) {

@GenerationProcedureParameter(id = IModelingDecisions.HAS_MINIMUM_GETTER) boolean hasMinimumGetter;
@GenerationProcedureParameter(id = IModelingDecisions.HAS_MAXIMUM_GETTER) boolean hasMaximumGetter;
@GenerationArgument String nameAsVariable;

@Override
public StringBuffer execute(Object element, Object... arguments) {
	StringBuffer content= new StringBuffer();
	if(!hasMinimumGetter&& !hasMaximumGetter){
		return content;
	}
	
	if(hasMinimumGetter){
		content.append(minimum(element, arguments));
	}
	
	if(hasMaximumGetter){
		if(hasMinimumGetter){
			content.append(orSegment(element, arguments));
		}
		content.append(maximum(element, arguments));
	}
	return wrap(content);
}

public StringBuffer wrap(final StringBuffer body) {
return CodeProcedure.generate(new CodeProcedure(this) {

@Override
public void execute() {

    stringBuffer.append(TEXT_295);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_296);
    
}
	
});
}

public StringBuffer minimum(Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this,element, arguments) {

	String minimumNumberMethodName;
		
	@Override
	public void execute() {
		
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(minimumNumberMethodName);
    stringBuffer.append(TEXT_298);
    
	}
	
	@Override
	public void preExecute(){
		this.minimumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
			GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	}
});
}

public StringBuffer orSegment(Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this,element, arguments) {
	
	@Override
	public void execute() {
		
    stringBuffer.append(TEXT_299);
    
}});
}

public StringBuffer maximum(Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this,element, arguments) {
		
	@GenerationElementParameter(id = NAME) String name;
	String maximumNumberMethodName;
		
	@Override
	public void execute() {
		
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(maximumNumberMethodName);
    stringBuffer.append(TEXT_301);
    
	}
	
	@Override
	public void preExecute(){
		this.maximumNumberMethodName= getRegistry().use(IModelingConstants.MAXIMUM_NUMBER_OF, name);
	}
	
});
}
	
});

define("class.associations.attributes.internal.contents.element.otherEnd.constraintCheck", new GenerationProcdure(this) {

@GenerationProcedureParameter(id = IModelingDecisions.HAS_OTHER_MINIMUM_GETTER) boolean hasMinimumGetter;
@GenerationProcedureParameter(id = IModelingDecisions.HAS_OTHER_MAXIMUM_GETTER) boolean hasMaximumGetter;
@GenerationArgument String nameAsVariable;

@Override
public StringBuffer execute(Object element, Object... arguments) {
	if(!hasMaximumGetter){
		//Only use the minimum function if there is no maximum one
		if(hasMinimumGetter){
			return allContents(minimum(element, arguments), element, arguments);
		}
		return new StringBuffer();
	}
		
	return allContents(maximum(element, arguments), element, arguments);
}

public StringBuffer minimum(Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this,element, arguments) {

		@GenerationElementParameter(id = NAME) String name;
		
		String numberOfMethodName, otherEndMinimumNumberMethodName;
		
	@Override
	public void execute() {
		
    stringBuffer.append(TEXT_302);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_304);
    stringBuffer.append( numberOfMethodName);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(otherEndMinimumNumberMethodName);
    stringBuffer.append(TEXT_307);
    
	}
	
	@Override
	public void preExecute(){
		this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
			GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
		this.otherEndMinimumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
			GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
	}
	
});
}

public StringBuffer maximum(Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this,element, arguments) {
		
	@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_NAME) String otherEndName;
	String numberOfMethodName, otherEndmaximumNumberMethodName;
		
	@Override
	public void execute() {
		
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_308);
    stringBuffer.append( numberOfMethodName);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(nameAsVariable);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(otherEndmaximumNumberMethodName);
    stringBuffer.append(TEXT_311);
    
	}
	
	@Override
	public void preExecute(){
		this.numberOfMethodName= getRegistry().generationPointString(element, ICppNameConstants.NUMBER_OF, 
			GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.TRUE));
		
		this.otherEndmaximumNumberMethodName= getRegistry().use(IModelingConstants.MAXIMUM_NUMBER_OF, otherEndName);
	}
	
});
}

public StringBuffer allContents(final StringBuffer content, Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this,element, arguments) {
		
	@Override
	public void execute() {

    stringBuffer.append(TEXT_312);
    stringBuffer.append(content);
    stringBuffer.append(TEXT_313);
    
}});
}
	
});

define("class.associations.attributes.internal.contents.constraintCheck", new GenerationProcdure(this) {

@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name;
@GenerationProcedureParameter(id = IModelingDecisions.HAS_MINIMUM_GETTER) boolean hasMinimumGetter;
@GenerationProcedureParameter(id = IModelingDecisions.HAS_MAXIMUM_GETTER) boolean hasMaximumGetter;

@Override
public StringBuffer execute(Object element, Object... arguments) {
	StringBuffer content= new StringBuffer();
	if(hasMinimumGetter){
		content.append(minimum(element, arguments));
	}
	
	if(hasMaximumGetter){
		content.append(maximum(element, arguments));
	}
	return content;
}

public StringBuffer minimum(Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this,element, arguments) {

	String verifiedList, minimumNumberMethodName;
		
	@Override
	public void execute() {
		
    stringBuffer.append(TEXT_314);
    stringBuffer.append(verifiedList);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(minimumNumberMethodName);
    stringBuffer.append(TEXT_316);
    
	}
	
	@Override
	public void preExecute(){
		this.verifiedList= getRegistry().use(ICppNameConstants.VERIFIED, name);
		
		this.minimumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MINIMUM_NUMBER_OF, 
			GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	}
});
}

public StringBuffer maximum(Object element, Object... arguments) {
return CodeProcedure.generate(new CodeProcedure(this,element, arguments) {
		
	String verifiedList, maximumNumberMethodName;
		
	@Override
	public void execute() {
		
    stringBuffer.append(TEXT_317);
    stringBuffer.append(verifiedList);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(maximumNumberMethodName);
    stringBuffer.append(TEXT_319);
    
	}
	
	@Override
	public void preExecute(){
		this.verifiedList= getRegistry().use(ICppNameConstants.VERIFIED, name);
		this.maximumNumberMethodName= getRegistry().generationPointString(element, IModelingConstants.MAXIMUM_NUMBER_OF, 
			GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
	}
});
}
	
});



    return stringBuffer.toString();
  }
}