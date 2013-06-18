package cruise.umple.compiler.cpp;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class CppHeaderGenerator implements ILang 
{

  protected static String nl;
  public static synchronized CppHeaderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CppHeaderGenerator result = new CppHeaderGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */" + NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/";
  protected final String TEXT_2 = NL + NL + "#ifndef ";
  protected final String TEXT_3 = "_H_" + NL + "#define ";
  protected final String TEXT_4 = "_H_";
  protected final String TEXT_5 = NL + "#include <string>" + NL + "using namespace std;";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "class ";
  protected final String TEXT_8 = NL + "{" + NL + "   //------------------------" + NL + "  // Attributes for header file" + NL + "  //------------------------" + NL + "  private:" + NL;
  protected final String TEXT_9 = NL + "  " + NL + "  //------------------------" + NL + "  // Private Constructor" + NL + "  //------------------------";
  protected final String TEXT_10 = NL + "  " + NL + "" + NL + "" + NL + "  public:" + NL;
  protected final String TEXT_11 = NL + "  //------------------------" + NL + "  // Constructor" + NL + "  //------------------------";
  protected final String TEXT_12 = NL + "  ";
  protected final String TEXT_13 = "* getInstance(); // Singelton";
  protected final String TEXT_14 = NL + NL + "    //------------------------" + NL + "    // Constructor" + NL + "    //------------------------" + NL;
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL + "  ";
  protected final String TEXT_17 = "::";
  protected final String TEXT_18 = "(";
  protected final String TEXT_19 = ")" + NL + "  {";
  protected final String TEXT_20 = NL + "  ";
  protected final String TEXT_21 = NL + "  \t";
  protected final String TEXT_22 = NL + "  \t  \t" + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_23 = NL + "  bool ";
  protected final String TEXT_24 = "(";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "  bool ";
  protected final String TEXT_28 = "(const ";
  protected final String TEXT_29 = " & ";
  protected final String TEXT_30 = ");" + NL + "  bool ";
  protected final String TEXT_31 = "();";
  protected final String TEXT_32 = NL + "  bool ";
  protected final String TEXT_33 = "(const ";
  protected final String TEXT_34 = " & ";
  protected final String TEXT_35 = ");" + NL + "  bool ";
  protected final String TEXT_36 = "(";
  protected final String TEXT_37 = " & ";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "  bool ";
  protected final String TEXT_40 = "(const ";
  protected final String TEXT_41 = " & ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "  ";
  protected final String TEXT_44 = "* ";
  protected final String TEXT_45 = "(int index);";
  protected final String TEXT_46 = NL + "  ";
  protected final String TEXT_47 = "[] ";
  protected final String TEXT_48 = "();" + NL + "  int ";
  protected final String TEXT_49 = "();" + NL + "  bool ";
  protected final String TEXT_50 = "();" + NL + "  int ";
  protected final String TEXT_51 = "(";
  protected final String TEXT_52 = "* ";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "  ";
  protected final String TEXT_55 = " ";
  protected final String TEXT_56 = "();";
  protected final String TEXT_57 = NL + "  ";
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = "();";
  protected final String TEXT_60 = NL + "  ";
  protected final String TEXT_61 = " ";
  protected final String TEXT_62 = "();";
  protected final String TEXT_63 = NL + "  ";
  protected final String TEXT_64 = " ";
  protected final String TEXT_65 = "() const;";
  protected final String TEXT_66 = NL + "  ";
  protected final String TEXT_67 = " ";
  protected final String TEXT_68 = "();";
  protected final String TEXT_69 = NL + "  ";
  protected final String TEXT_70 = " ";
  protected final String TEXT_71 = "() const;";
  protected final String TEXT_72 = NL + "  ";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = "();";
  protected final String TEXT_75 = NL + "  ";
  protected final String TEXT_76 = " ";
  protected final String TEXT_77 = "() const;";
  protected final String TEXT_78 = NL + "  ";
  protected final String TEXT_79 = " ";
  protected final String TEXT_80 = "();" + NL + "  " + NL + "  ";
  protected final String TEXT_81 = NL + "  ";
  protected final String TEXT_82 = "::";
  protected final String TEXT_83 = " ";
  protected final String TEXT_84 = "();";
  protected final String TEXT_85 = NL + "  bool ";
  protected final String TEXT_86 = "();" + NL + "  " + NL;
  protected final String TEXT_87 = NL + "  bool ";
  protected final String TEXT_88 = "(";
  protected final String TEXT_89 = " ";
  protected final String TEXT_90 = ");" + NL + NL;
  protected final String TEXT_91 = NL + "  void ";
  protected final String TEXT_92 = "();";
  protected final String TEXT_93 = NL + "  void ";
  protected final String TEXT_94 = "(";
  protected final String TEXT_95 = " ";
  protected final String TEXT_96 = ");" + NL + "" + NL + "  " + NL;
  protected final String TEXT_97 = NL + "  ";
  protected final String TEXT_98 = "* ";
  protected final String TEXT_99 = "();";
  protected final String TEXT_100 = NL + "  ";
  protected final String TEXT_101 = "* ";
  protected final String TEXT_102 = "(int index);" + NL + "  vector<";
  protected final String TEXT_103 = "*> ";
  protected final String TEXT_104 = "();" + NL + "  int ";
  protected final String TEXT_105 = "();" + NL + "  bool ";
  protected final String TEXT_106 = "();" + NL + "  int ";
  protected final String TEXT_107 = "(";
  protected final String TEXT_108 = "* ";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = "UNABLE TO UNDERSAND association variable (see header_association_Get_All.jet)";
  protected final String TEXT_111 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_112 = " : ";
  protected final String TEXT_113 = NL + "  bool ";
  protected final String TEXT_114 = "();";
  protected final String TEXT_115 = NL + "  static int ";
  protected final String TEXT_116 = "();";
  protected final String TEXT_117 = NL + "  static int ";
  protected final String TEXT_118 = "();";
  protected final String TEXT_119 = NL + "static int ";
  protected final String TEXT_120 = "();";
  protected final String TEXT_121 = NL + "  bool ";
  protected final String TEXT_122 = "(";
  protected final String TEXT_123 = "* ";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "  bool ";
  protected final String TEXT_126 = "(";
  protected final String TEXT_127 = "* ";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "  bool ";
  protected final String TEXT_130 = "(";
  protected final String TEXT_131 = "* ";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = NL + "  bool ";
  protected final String TEXT_134 = "(";
  protected final String TEXT_135 = "* ";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "  bool ";
  protected final String TEXT_138 = "(";
  protected final String TEXT_139 = "* ";
  protected final String TEXT_140 = ");";
  protected final String TEXT_141 = NL + "  bool ";
  protected final String TEXT_142 = "(";
  protected final String TEXT_143 = "* ";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "  bool ";
  protected final String TEXT_146 = "(";
  protected final String TEXT_147 = "* ";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = NL + "  ";
  protected final String TEXT_150 = " ";
  protected final String TEXT_151 = "(";
  protected final String TEXT_152 = ");" + NL + "  bool ";
  protected final String TEXT_153 = "(";
  protected final String TEXT_154 = "* ";
  protected final String TEXT_155 = ");" + NL + "  bool ";
  protected final String TEXT_156 = "(";
  protected final String TEXT_157 = "* ";
  protected final String TEXT_158 = "); ";
  protected final String TEXT_159 = NL + "  ";
  protected final String TEXT_160 = " ";
  protected final String TEXT_161 = "(";
  protected final String TEXT_162 = ");" + NL + "  bool ";
  protected final String TEXT_163 = "(";
  protected final String TEXT_164 = "* ";
  protected final String TEXT_165 = ");" + NL + "  bool ";
  protected final String TEXT_166 = "(";
  protected final String TEXT_167 = "* ";
  protected final String TEXT_168 = ");";
  protected final String TEXT_169 = NL + "  bool ";
  protected final String TEXT_170 = "( vector<";
  protected final String TEXT_171 = "*>& ";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = NL + "  ";
  protected final String TEXT_174 = " ";
  protected final String TEXT_175 = "(";
  protected final String TEXT_176 = ");" + NL + "  bool ";
  protected final String TEXT_177 = "(";
  protected final String TEXT_178 = "* ";
  protected final String TEXT_179 = ");" + NL + "  bool ";
  protected final String TEXT_180 = "(";
  protected final String TEXT_181 = "* ";
  protected final String TEXT_182 = ");";
  protected final String TEXT_183 = NL + "  bool ";
  protected final String TEXT_184 = "(";
  protected final String TEXT_185 = "* ";
  protected final String TEXT_186 = ");";
  protected final String TEXT_187 = NL + "  bool ";
  protected final String TEXT_188 = "(";
  protected final String TEXT_189 = "* ";
  protected final String TEXT_190 = "); ";
  protected final String TEXT_191 = NL + "  bool ";
  protected final String TEXT_192 = "(";
  protected final String TEXT_193 = "* ";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = NL + "  bool ";
  protected final String TEXT_196 = "( vector<";
  protected final String TEXT_197 = "*> ";
  protected final String TEXT_198 = ");";
  protected final String TEXT_199 = NL + "  void ";
  protected final String TEXT_200 = "::";
  protected final String TEXT_201 = "(";
  protected final String TEXT_202 = " ";
  protected final String TEXT_203 = ", ";
  protected final String TEXT_204 = " ";
  protected final String TEXT_205 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_206 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_207 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_208 = ", ";
  protected final String TEXT_209 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_210 = " to ";
  protected final String TEXT_211 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_212 = NL + "  bool ";
  protected final String TEXT_213 = "(";
  protected final String TEXT_214 = "* ";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = NL + "  bool ";
  protected final String TEXT_217 = "(";
  protected final String TEXT_218 = "* ";
  protected final String TEXT_219 = ");";
  protected final String TEXT_220 = NL + "  bool ";
  protected final String TEXT_221 = "(";
  protected final String TEXT_222 = "* ";
  protected final String TEXT_223 = ");";
  protected final String TEXT_224 = NL + "  bool ";
  protected final String TEXT_225 = "(";
  protected final String TEXT_226 = "* ";
  protected final String TEXT_227 = ");" + NL + "  bool ";
  protected final String TEXT_228 = "(";
  protected final String TEXT_229 = "* ";
  protected final String TEXT_230 = ");";
  protected final String TEXT_231 = NL + "  bool ";
  protected final String TEXT_232 = "(";
  protected final String TEXT_233 = "* ";
  protected final String TEXT_234 = ");";
  protected final String TEXT_235 = NL + "  bool ";
  protected final String TEXT_236 = "(";
  protected final String TEXT_237 = "* ";
  protected final String TEXT_238 = ");" + NL + "  bool ";
  protected final String TEXT_239 = "(";
  protected final String TEXT_240 = "* ";
  protected final String TEXT_241 = ");";
  protected final String TEXT_242 = NL + "  bool ";
  protected final String TEXT_243 = "(";
  protected final String TEXT_244 = "* ";
  protected final String TEXT_245 = ");" + NL + "  bool ";
  protected final String TEXT_246 = "(";
  protected final String TEXT_247 = "* ";
  protected final String TEXT_248 = ");";
  protected final String TEXT_249 = NL + "  bool ";
  protected final String TEXT_250 = "(";
  protected final String TEXT_251 = "* ";
  protected final String TEXT_252 = ");" + NL + "  bool ";
  protected final String TEXT_253 = "(";
  protected final String TEXT_254 = "* ";
  protected final String TEXT_255 = ");";
  protected final String TEXT_256 = NL + "  bool ";
  protected final String TEXT_257 = "( vector<";
  protected final String TEXT_258 = "*> ";
  protected final String TEXT_259 = ");";
  protected final String TEXT_260 = NL + "  void ";
  protected final String TEXT_261 = "::";
  protected final String TEXT_262 = "(";
  protected final String TEXT_263 = " ";
  protected final String TEXT_264 = ", ";
  protected final String TEXT_265 = " ";
  protected final String TEXT_266 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_267 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_268 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_269 = ", ";
  protected final String TEXT_270 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_271 = " to ";
  protected final String TEXT_272 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_273 = NL + "  bool ";
  protected final String TEXT_274 = "(";
  protected final String TEXT_275 = "* ";
  protected final String TEXT_276 = ");" + NL + "  bool ";
  protected final String TEXT_277 = "(";
  protected final String TEXT_278 = "* ";
  protected final String TEXT_279 = ");";
  protected final String TEXT_280 = NL + "  bool ";
  protected final String TEXT_281 = "(";
  protected final String TEXT_282 = "* ";
  protected final String TEXT_283 = ");" + NL + "  bool ";
  protected final String TEXT_284 = "(";
  protected final String TEXT_285 = "* ";
  protected final String TEXT_286 = ");";
  protected final String TEXT_287 = NL + "  bool ";
  protected final String TEXT_288 = "(";
  protected final String TEXT_289 = "* ";
  protected final String TEXT_290 = ");" + NL + "  bool ";
  protected final String TEXT_291 = "(";
  protected final String TEXT_292 = "* ";
  protected final String TEXT_293 = ");";
  protected final String TEXT_294 = NL + "  bool ";
  protected final String TEXT_295 = "( vector<";
  protected final String TEXT_296 = "*> ";
  protected final String TEXT_297 = ");";
  protected final String TEXT_298 = NL + "  bool ";
  protected final String TEXT_299 = "( vector<";
  protected final String TEXT_300 = "*>& ";
  protected final String TEXT_301 = ");";
  protected final String TEXT_302 = NL + "  bool ";
  protected final String TEXT_303 = "( vector<";
  protected final String TEXT_304 = "*> ";
  protected final String TEXT_305 = ");";
  protected final String TEXT_306 = NL + "  bool ";
  protected final String TEXT_307 = "( vector<";
  protected final String TEXT_308 = "*> ";
  protected final String TEXT_309 = ");";
  protected final String TEXT_310 = NL + "  bool ";
  protected final String TEXT_311 = "( vector<";
  protected final String TEXT_312 = "*> ";
  protected final String TEXT_313 = ");";
  protected final String TEXT_314 = NL + "  bool ";
  protected final String TEXT_315 = "( vector<";
  protected final String TEXT_316 = "*>  ";
  protected final String TEXT_317 = ");";
  protected final String TEXT_318 = NL + "  bool ";
  protected final String TEXT_319 = "( vector<";
  protected final String TEXT_320 = "*> ";
  protected final String TEXT_321 = ");";
  protected final String TEXT_322 = NL + "  ";
  protected final String TEXT_323 = " ";
  protected final String TEXT_324 = NL + " bool equals(Object obj);" + NL + " int hashCode();" + NL;
  protected final String TEXT_325 = NL + "   void ";
  protected final String TEXT_326 = "::";
  protected final String TEXT_327 = "()" + NL + "  {" + NL + "     try" + NL + "     {";
  protected final String TEXT_328 = NL + "       ";
  protected final String TEXT_329 = NL + "     }" + NL + "     catch (InterruptedException e)" + NL + "     {" + NL + " " + NL + "     }" + NL + "  }" + NL;
  protected final String TEXT_330 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_331 = NL + "    ";
  protected final String TEXT_332 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_333 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_334 = NL + "      ";
  protected final String TEXT_335 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_336 = NL + "  void ";
  protected final String TEXT_337 = "();" + NL + "  void ";
  protected final String TEXT_338 = "();" + NL + "  " + NL + NL;
  protected final String TEXT_339 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_340 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_341 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void ";
  protected final String TEXT_342 = "::stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void ";
  protected final String TEXT_343 = "::run ()" + NL + "    {";
  protected final String TEXT_344 = NL + "      if (\"";
  protected final String TEXT_345 = "\" == timeoutMethodName)" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_346 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_347 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_348 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_349 = NL + "  //------------------------" + NL + "  // Destructor" + NL + "  //------------------------";
  protected final String TEXT_350 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_351 = NL + "  ";
  protected final String TEXT_352 = NL + "};" + NL + "" + NL + "#endif";

  // Add a newline to the end of the input
  private void appendln(StringBuffer buffer, String input, Object... variables)
  {
    append(buffer, input + "\n", variables);
  }  

  // This method will be used to append formatted strings
  // i.e. format("Hello {0} {1}", "andrew","forward");
  private void append(StringBuffer buffer, String input, Object... variables)
  {
    buffer.append(StringFormatter.format(input,variables));
  }

  /* 
  * This method will return the generated code.
  */
  public String getCode(UmpleModel model, UmpleElement uElement)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	UmpleClass uClass = (UmpleClass) uElement;  
  	GeneratedClass gClass = uClass.getGeneratedClass();
  	CppGenerator gen = new CppGenerator();
  	gen.setModel(model);
  	
  	  HashMap<String,String> codeInjectionMap = new HashMap<String,String>();
  for (CodeInjection inject : uClass.getCodeInjections())
  {
    String operation = StringFormatter.toUnderscore(inject.getOperation());
    String key = inject.getType() + ":" + operation;
    String newCodeToInject = "";
    if (codeInjectionMap.containsKey(key))
    {
      newCodeToInject = StringFormatter.format("{0}\n    {1}",codeInjectionMap.get(key),inject.getCode());
    }
    else
    {
      newCodeToInject = inject.getCode();
    }
    codeInjectionMap.put(key,newCodeToInject);
  }

  boolean isFirst = true;

 	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(uClass.getName().toUpperCase());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(uClass.getName().toUpperCase());
    stringBuffer.append(TEXT_4);
    
  for (Depend depend : uClass.getDepends())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "#include <{0}.h>",depend.getName());
  }
  
  for (String anImport : gClass.getMultiLookup("import"))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "#include <{0}>",anImport);
  }
  
  for (String anImport : gClass.getMultiLookup("using"))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "using namespace {0};",anImport);
  }
  
  if (uClass.hasAssociationVariables())
  {
  	appendln(stringBuffer, "");
    append(stringBuffer, "#include<algorithm>");  	
  }

    stringBuffer.append(TEXT_5);
    
  for (AssociationVariable av : uClass.getAssociationVariables())
  {

   
    if (uClass.getName() != av.getRelatedAssociation().getUmpleClass().getName())
	{
	appendln(stringBuffer, "");
    append(stringBuffer, "class {0};",av.getRelatedAssociation().getUmpleClass().getName());
	}
    }
  

    stringBuffer.append(TEXT_6);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).isInline) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(stringBuffer, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(uClass.getName());
    stringBuffer.append( gen.translate("isA",uClass) );
    stringBuffer.append(TEXT_8);
    
{
  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
  
    if (!av.isConstant() && !av.getIsAutounique())
    {
      continue;
    }

    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer, "  //------------------------");
      appendln(stringBuffer, "  // STATIC VARIABLES");
      appendln(stringBuffer, "  //------------------------");
      isFirst = false;
    }
  
    if (av.isConstant())
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  const static {0} {1} = {2};", gen.getType(av), av.getName(), gen.translate("parameterValue",av));
    }
    else if (av.getIsAutounique())
    {
      String defaultValue = av.getValue() == null ? "1" : av.getValue();
      appendln(stringBuffer, "");
      append(stringBuffer, "  static int next{0} = {1};", av.getUpperCaseName(), defaultValue);
    }
  }
  
  if (uClass.getIsSingleton())
  {
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer, "  //------------------------");
      appendln(stringBuffer, "  // STATIC VARIABLES");
      appendln(stringBuffer, "  //------------------------");
      appendln(stringBuffer, "");
      isFirst = false;
    }
    append(stringBuffer, "  static {0}* theInstance;", uClass.getName());
  }
}

    
{

  appendln(stringBuffer, "");
  appendln(stringBuffer, "");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "  // MEMBER VARIABLES");
  append(stringBuffer, "  //------------------------");
  
  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
    if (av.isConstant() || av.getIsAutounique() || av.getIsDerived())
    {
      continue;
    }
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      append(stringBuffer,"  //{0} Attributes", uClass.getName());
      isFirst = false;
    }
    
    String type = gen.translate("type",av);
    String attribute = gen.translate("attributeOne",av);
    if (av.getIsList())
    {
      attribute = gen.translate("attributeMany",av);
      type = StringFormatter.format("vector<{0}>",gen.translate("typeMany",av));
    }

    appendln(stringBuffer, "");
    
    if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); }
    
    append(stringBuffer, "  {0} {1};", type, attribute);
  }
  
  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
    if (!av.getIsAutounique())
    {
      continue;
    }
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      append(stringBuffer,"  //Autounique Attributes");
      isFirst = false;
    }
    appendln(stringBuffer, "");
    append(stringBuffer, "  int {0};", gen.translate("attributeOne",av));
  }
}

    
{
  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    List<StateMachine> allNested = sm.getNestedStateMachines();

    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      append(stringBuffer,"  //{0} State Machines", uClass.getName());
      isFirst = false;
    }
  
    append(stringBuffer, "\n  enum {0} { {1} };", gen.translate("type",sm), gen.translate("listStates",sm));

    for (StateMachine nestedSm : allNested)
    {
      append(stringBuffer, "\n  enum {0} { {1} };", gen.translate("type",nestedSm), gen.translate("listStates",nestedSm));
	  
    }
    
    append(stringBuffer, "\n  {0} {1};", gen.translate("type",sm), gen.translate("stateMachineOne", sm));
	
    for (StateMachine nestedSm : allNested)
    {
      append(stringBuffer, "\n  {0} {1};", gen.translate("type",nestedSm), gen.translate("stateMachineOne", nestedSm));
    }
	}
}

    
{
  isFirst = true;
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    for (State state : sm.getStates())
    {
      if (state.getActivity() == null)
      {
        continue;
      }

      if (isFirst)
      {
        appendln(stringBuffer, "");
        appendln(stringBuffer, "");
        append(stringBuffer,"  //{0} Do Activity Threads", uClass.getName());
        isFirst = false;
      }
      append(stringBuffer, "\n  Thread {0} = null;", gen.translate("doActivityThread",state));
    }
  }
}

    
{
  isFirst = true;
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
    if (!av.getIsNavigable())
    {
      continue;
    }
    
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      
      append(stringBuffer,"  //{0} Associations", uClass.getName());
      isFirst = false;
    }
  
    appendln(stringBuffer, "");
    
    if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Association Javadoc", av.getComments())); }
    
    if (av.isOne())
    {
      append(stringBuffer, "  {0}* {1};", gen.translate("type",av), gen.translate("attributeOne",av));
    }
    else
    {
      append(stringBuffer, "   vector<{0}*> {1};", gen.translate("typeMany",av), gen.translate("attributeMany",av));
    }
  }
}

    
{

  isFirst = true;
  if (uClass.getKey().isProvided())
  {
    isFirst = false;
    appendln(stringBuffer, "");
    appendln(stringBuffer, "");
    appendln(stringBuffer,"  //Helper Variables");
    append(stringBuffer, "  int cachedHashCode;");
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.isImmutable())
    {
      if (isFirst)
      {
        isFirst = false;
        appendln(stringBuffer, "");
        appendln(stringBuffer, "");
        appendln(stringBuffer,"  //Helper Variables");
      } 
      else
      {
        appendln(stringBuffer, "");
      }
      append(stringBuffer, "  bool {0};", gen.translate("attributeCanSet",av));
    }
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null && !av.isImmutable())
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  bool {0};", gen.translate("attributeCanSet",av));
    }
    else if (as != null)
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  bool {0};", gen.translate("associationCanSet",as));
    }
  }
  
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (!e.getIsTimer())
      {
        continue;
      }
    
      if (isFirst)
      {
        isFirst = false;
        appendln(stringBuffer, "");
        appendln(stringBuffer, "");
        appendln(stringBuffer,"  //Helper Variables");
      }
      else
      {
        appendln(stringBuffer, "");
      }
      append(stringBuffer, "  TimedEventHandler {0};", gen.translate("eventHandler",e));
    }
  }
}

    
	
	if (uClass.getIsSingleton()) 
	{
		
    stringBuffer.append(TEXT_9);
    
	  appendln(stringBuffer,"");
	  append(stringBuffer,"  {0}({1});",new Object[] {uClass.getName(), gClass.getLookup("constructorSignature")});
    
	 }
    stringBuffer.append(TEXT_10);
    
  boolean isOneToOne = false;
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssocation = av.getRelatedAssociation();
    if (av.isOnlyOne() && relatedAssocation.isOnlyOne() && av.getIsNavigable() && relatedAssocation.getIsNavigable())
    {
      isOneToOne = true;
      break;
    }
  }
  
    

  String customConstructorPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","constructor"));
  String customConstructorPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","constructor"));

  appendln(stringBuffer, "");

  String accessibility = uClass.getIsSingleton() ? "" : "";

  if (!uClass.getIsSingleton())
	  {
		  
    stringBuffer.append(TEXT_11);
    
			  
		  append(stringBuffer,"  {0} {1}({2});",new Object[] {accessibility, uClass.getName(), gClass.getLookup("constructorSignature")});
	  }

  String extraNote = null;
  
  appendln(stringBuffer, "");
  
  boolean hasBody = false;

 if (uClass.getKey().isProvided())
  {
    hasBody = true;
    appendln(stringBuffer, "");
    append(stringBuffer, "    cachedHashCode = -1;");
  }
  
  
  
  if (uClass.getIsSingleton())
  {
    appendln(stringBuffer, "");
    
    stringBuffer.append(TEXT_12);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_13);
    
  }

    
  if (isOneToOne)
  {
    
    stringBuffer.append(TEXT_14);
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_19);
    
  if (!uClass.isRoot())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    uClass.getName():{0}({1});", gClass.getParentClass().getLookup("constructorSignature_caller"),gClass.getParentClass().getClass().getName());
    hasBody = true;
  }
  
  if (customConstructorPrefixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPrefixCode, "    "));
    hasBody = true;
  }
  
  
  
  
  
  
  
  

    
  }


    stringBuffer.append(TEXT_20);
     if (uClass.getAttributes() != null)
	{
		
  		
    
    appendln(stringBuffer, "");
    appendln(stringBuffer, "  //------------------------");
    appendln(stringBuffer, "  // Copy Constructor");
    appendln(stringBuffer, "  //------------------------");
    appendln(stringBuffer, "");
	append(stringBuffer," {0}(const {0} & {1});",new Object[] {uClass.getName(),uClass.getName().toLowerCase()});
  

    
  	}
    stringBuffer.append(TEXT_21);
     if (uClass.getAttributes() != null)
	{
		
  		
    
  
  appendln(stringBuffer, "");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "  // Operator =");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "");
  appendln(stringBuffer," {0} operator=(const {0} & {1});",new Object[] {uClass.getName(),uClass.getName().toLowerCase()});
  
  


    
  	}
    stringBuffer.append(TEXT_22);
    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes())
  {
  
    if (av.isConstant() || av.getIsAutounique() || "internal".equals(av.getModifier()) || av.getIsDerived())
    {
      continue;
    }

    String customSetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setMethod",av)));
    String customSetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setMethod",av)));

    String customResetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("resetMethod",av)));
    String customResetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("resetMethod",av)));

    String customAddPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("addMethod",av)));
    String customAddPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("addMethod",av)));
  
    String customRemovePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("removeMethod",av)));
    String customRemovePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("removeMethod",av)));
    
    if (av.isImmutable())
    {
      if (av.getIsLazy())
      {
        
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_26);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_27);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_31);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_38);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_39);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_42);
    
    }
  }

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes()) 
  {
    if (av.getIsAutounique() || av.isConstant() || "internal".equals(av.getModifier()))
    {
      continue;
    }
    
    String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getMethod",av)));
    String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getMethod",av)));

    String customGetDefaultPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getDefaultMethod",av)));
    String customGetDefaultPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getDefaultMethod",av)));

    String customGetManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getManyMethod",av)));
    String customGetManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getManyMethod",av)));

    String customNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("numberOfMethod",av)));
    String customNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("numberOfMethod",av)));

    String customHasManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("hasManyMethod",av)));
    String customHasManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("hasManyMethod",av)));

    String customIndexOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("indexOfMethod",av)));
    String customIndexOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("indexOfMethod",av)));
    
    if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_53);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_56);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_59);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_62);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_63);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_64);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_65);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_68);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_71);
    
      }
    }
  }

  for (Attribute av : uClass.getAttributes()) 
  {
  
    if (av.getIsAutounique())
    {
      String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getMethod",av)));
      String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getMethod",av)));
      
      if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_74);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_77);
    
      }
      appendln(stringBuffer, "");
    }
  }

    
{
  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_80);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_81);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_84);
    
	
    
   appendln(stringBuffer,"");
   appendln(stringBuffer,"  string {0} ({1} {2});",gen.translate("getStringMethod",sm),gen.translate("type",sm),gen.translate("stateMachineOne", sm),uClass.getName());

    
  }
}

    
{

  for(Event e : uClass.getEvents())
  {
    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_86);
    
  }
}

    
{
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_88);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_90);
    
    }
    else if (sm.numberOfStates() > 0)
    {
      
    
  boolean hasEntry = false;
  boolean hasExit = false;
  boolean isFirstEntry = true;
  boolean isFirstExit = true;
  State parentState = sm.getParentState();
  StateMachine parentSm = parentState != null ? parentState.getStateMachine() : null;

  StringBuilder entryActions = new StringBuilder();
  StringBuilder exitActions = new StringBuilder();
  for(State state : sm.getStates())
  {
    boolean hasThisEntry = false;
    boolean hasThisExit = false;
    
    for(Action action : state.getActions())
    {
      if ("entry".equals(action.getActionType()))
      {
        if (!hasThisEntry)
        {
          if (!isFirstEntry)
          {
            entryActions.append("\n      ");
          }
          entryActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
        }
        hasEntry = true;
        hasThisEntry = true;
        isFirstEntry = false;
        entryActions.append("\n        " + action.getActionCode());
      }
      else if ("exit".equals(action.getActionType()))
      {
        if (!hasThisExit)
        {
          if (!isFirstExit)
          {
            exitActions.append("\n      ");
          }
          isFirstExit = false;
          exitActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
        }
        hasExit = true;
        hasThisExit = true;
        isFirstExit = false;
        exitActions.append("\n        " + action.getActionCode());
      }
    }
  
    if (state.getActivity() != null)
    {
      if (!hasThisEntry)
      {
        if (!isFirstEntry)
        {
          entryActions.append("\n      ");
        }
        entryActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
      }
      hasEntry = true;
      hasThisEntry = true;
      isFirstEntry = false;
      entryActions.append(StringFormatter.format("\n        {1} = new DoActivityThread(this,\"{0}\");",gen.translate("doActivityMethod",state),gen.translate("doActivityThread",state)));
    }
    
    if (hasThisEntry)
    {
      entryActions.append("\n        break;");
    }
    
    if (hasThisExit)
    {
      exitActions.append("\n        break;");
    }
  }

     if (hasExit) { 
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_92);
     } 
    stringBuffer.append(TEXT_93);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_94);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_96);
    
    }
  }
}

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {

    if (!av.getIsNavigable())
    {
      continue;
    }

    String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getMethod",av)));
    String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getMethod",av)));

    String customGetDefaultPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getDefaultMethod",av)));
    String customGetDefaultPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getDefaultMethod",av)));

    String customGetManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getManyMethod",av)));
    String customGetManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getManyMethod",av)));

    String customNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("numberOfMethod",av)));
    String customNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("numberOfMethod",av)));

    String customHasManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("hasManyMethod",av)));
    String customHasManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("hasManyMethod",av)));

    String customIndexOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("indexOfMethod",av)));
    String customIndexOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("indexOfMethod",av)));

    boolean hasCodeInjections = customGetPrefixCode != null || customGetPostfixCode != null;
  
    if (av.isOne())
    {
      
    stringBuffer.append(TEXT_97);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_99);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_109);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_110);
    
    }
 }

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
  
    AssociationVariable relatedAssociation = av.getRelatedAssociation();

    if (!av.getIsNavigable())
    {
      continue;
    } 

    String customSetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setMethod",av)));
    String customSetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setMethod",av)));

    String customSetManyPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setManyMethod",av)));
    String customSetManyPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setManyMethod",av)));

    String customAddPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("addMethod",av)));
    String customAddPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("addMethod",av)));
  
    String customRemovePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("removeMethod",av)));
    String customRemovePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("removeMethod",av)));

    String customIsNumberOfValidPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("isNumberOfValidMethod",av)));
    String customIsNumberOfValidPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("isNumberOfValidMethod",av)));
    
    String includeFileOne = null;
    String includeFileTwo = null;
    
    boolean hasIsNumberOfValidMethod = false;
    boolean hasAddManyToManyTemplateMethod = false;
    boolean hasMaximumNumberOfMethod = av.isMany() && !av.isStar();
    boolean hasMinimumNumberOfMethod = av.isMany();
    boolean hasRequiredNumberOfMethod = av.isN();
    boolean hasRemoveManyTemplateMethod = false;
    String includeFile = null;
    String includeFile2 = null;


    if (!relatedAssociation.getIsNavigable())
    {
      if (av.isOptionalOne())
      {
        includeFile = "header_association_SetUnidirectionalOptionalOne.jet";
      }
      else if (av.isOnlyOne())
      {
        includeFile = "header_association_SetUnidirectionalOne.jet";
      }
      else if (av.isMStar())
      {
        includeFile = "header_association_AddUnidirectionalMStar.jet";
        includeFile2 = "header_association_SetUnidirectionalMStar.jet";
      }
      else if (av.isMN())
      {
        includeFile = "header_association_AddUnidirectionalMN.jet";
        includeFile2 = "header_association_SetUnidirectionalMN.jet";
      }
      else if (av.isN())
      {
        includeFile = "header_association_SetUnidirectionalN.jet";
      }
      else if (av.isOptionalN())
      {
        includeFile = "header_association_AddUnidirectionalOptionalN.jet";
        includeFile2 = "header_association_SetUnidirectionalOptionalN.jet";
      }
      else if (av.isMany())
      {
        includeFile = "header_association_AddUnidirectionalMany.jet";
      }
    }
    else if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      //ignore
    }  
    else if (av.isN() && relatedAssociation.isOptionalOne())
    { 
      includeFile = "header_association_SetNToOptionalOne.jet";
    }
    else if (av.isMN() && relatedAssociation.isOptionalOne())
    {
      includeFile = "header_association_AddMNToOptionalOne.jet";
      includeFile2 = "header_association_SetMNToOptionalOne.jet";
    }
    else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isMany())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "header_association_AddMStarToMany.jet";
      includeFile2 = "header_association_SetMStarToMany.jet";
    }
    else if ((av.isMN() || av.isN()) && relatedAssociation.isMandatoryMany())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "header_association_AddMNToMany.jet";
      includeFile2 = "header_association_SetMNToMany.jet";
    }
    else if ((av.isMN() || av.isN()) && relatedAssociation.isOptionalN())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "header_association_AddMNToMany.jet";
    }
    else if ((av.isMN() || av.isN()) && !relatedAssociation.isOne())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "header_association_AddMNToMany.jet";
      includeFile2 = "header_association_SetMNToMany.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      includeFile = "header_association_SetOptionalOneToOptionalOne.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOne())
    {
      includeFile = "header_association_SetOptionalOneToOne.jet";
    }
    else if (av.isOne() && relatedAssociation.isOptionalOne())
    {
      includeFile = "header_association_SetOneToOptionalOne.jet";
    }
    else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isOne())
    {
      hasIsNumberOfValidMethod = true;
      includeFile = "header_association_AddMandatoryManyToOne.jet";
    }
    else if ((av.isMN() || av.isN()) && relatedAssociation.isOnlyOne())
    {
      hasIsNumberOfValidMethod = true;
      includeFile = "header_association_AddMNToOnlyOne.jet";
    }
    else if (av.isOptionalN() && relatedAssociation.isOnlyOne())
    {
      includeFile = "header_association_AddOptionalNToOne.jet";
    }
    else if (av.isOptionalN() && (relatedAssociation.isMN() || relatedAssociation.isOptionalN()))
    {
      hasAddManyToManyTemplateMethod = true;
      hasRemoveManyTemplateMethod = true;
    }
    else if (av.isOptionalN() && relatedAssociation.isOptionalMany())
    {
      hasAddManyToManyTemplateMethod = true;
      hasRemoveManyTemplateMethod = true;
      includeFile = "header_association_SetOptionalNToMany.jet";
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      includeFile = "header_association_AddManyToOne.jet";
    }
    else if (av.isOptionalN() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      hasAddManyToManyTemplateMethod = true;
      hasRemoveManyTemplateMethod = true;
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN() || relatedAssociation.isMany()))
    {
      hasAddManyToManyTemplateMethod = true;
      hasRemoveManyTemplateMethod = true;
    }
    else if (av.isOptionalN() && relatedAssociation.isOptionalOne())
    {
      includeFile = "header_association_AddOptionalNToOptionalOne.jet";
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      includeFile = "header_association_AddManyToOptionalOne.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isMandatoryMany() && relatedAssociation.isStar())
    {
      includeFile = "header_association_SetOneToMandatoryMany.jet";
    }
    else if (av.isOnlyOne() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      includeFile = "header_association_SetOneToAtMostN.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalN())
    {
      includeFile = "header_association_SetOneToAtMostN.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()))
    {
      includeFile = "header_association_SetOneToMany.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalN())
    {
      includeFile = "header_association_SetOptionalOneToOptionalN.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      includeFile = "header_association_SetOptionalOneToMany.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isMandatoryMany())
    {
      // Insert code to include code here
      if (relatedAssociation.isUpperBounded())
      {
        //
        // This program cannot currently include header_association_SetOptionalOneToMandatoryMN.jet because of Issue351 where add/remove methods do not generate
        //
        // includeFile = "header_association_SetOptionalOneToMandatoryMN.jet";
      } 
      else
      {
        //
        // We can include header_association_SetOptionalOneToMandatoryMany.jet
        // 
        includeFile = "header_association_SetOptionalOneToMandatoryMany.jet";
      } 
    }
    else if (av.isOptionalOne() && relatedAssociation.isMandatory())
    {
      //ignore
    }
    else
    {
      
    stringBuffer.append(TEXT_111);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(relatedAssociation);
    
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_114);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

    stringBuffer.append(TEXT_115);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_116);
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_118);
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_119);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_120);
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_124);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_128);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "header_association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_129);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_132);
    
    }
    else if (includeFile == "header_association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_133);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_136);
    
    }
    else if (includeFile == "header_association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_140);
    
    }
    else if (includeFile == "header_association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_144);
    
    }
    else if (includeFile == "header_association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_148);
    
    }
    else if (includeFile == "header_association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_158);
    
    }
    else if (includeFile == "header_association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_168);
    
    }
    else if (includeFile == "header_association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_169);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_172);
    
    }
    else if (includeFile == "header_association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_182);
    
    }
    else if (includeFile == "header_association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_183);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_186);
    
    }
    else if (includeFile == "header_association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_187);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_190);
    
    }
    else if (includeFile == "header_association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_194);
    
    }
    else if (includeFile == "header_association_SetOptionalOneToOptionalN.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_211);
    
    }
    else if (includeFile == "header_association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_212);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_215);
    
    }
    else if (includeFile == "header_association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_216);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_219);
    
    }
    else if (includeFile == "header_association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_220);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_223);
    
    }
    else if (includeFile == "header_association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_224);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_230);
    
    }
    else if (includeFile == "header_association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_234);
    
    }
    else if (includeFile == "header_association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_241);
    
    }
    else if (includeFile == "header_association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_242);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_244);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_248);
    
    }
    else if (includeFile == "header_association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_255);
    
    }
    else if (includeFile == "header_association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_256);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_272);
    
    }
    else if (includeFile == "header_association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_279);
    
    }
    else if (includeFile == "header_association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_286);
    
    }
    else if (includeFile == "header_association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_287);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_293);
    
    }
    else if (includeFile == "header_association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_294);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_297);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "header_association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_298);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_301);
    
    }
    else if (includeFile2 == "header_association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_305);
    
    }
    else if (includeFile2 == "header_association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_309);
    
    }
    else if (includeFile2 == "header_association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_313);
    
    }
    else if (includeFile2 == "header_association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_314);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_317);
    
    }
    else if (includeFile2 == "header_association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_318);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_321);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
    }
  }

     if (uClass.getKey().isProvided()) { 
    stringBuffer.append(TEXT_322);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(TEXT_324);
     } 
    
{ 
  boolean hasActivities = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (State state : sm.getStates())
    {
      if (state.getActivity() != null)
      {
        hasActivities = true;
        
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_326);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(TEXT_328);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_329);
    
      }
    }
  } 
  if (hasActivities)
  {
    
       
  StringBuffer output = new StringBuffer();

  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (State state : sm.getStates())
    {
      if (state.getActivity() != null)
      {
        if (isFirst)
        {
          output.append(StringFormatter.format("if"));
          isFirst = false;
        }
        else
        {
          output.append(StringFormatter.format("\n        else if"));
        }
        output.append(StringFormatter.format(" (\"{0}\".equals(doActivityMethodName))\n",gen.translate("doActivityMethod",state)));
        output.append(StringFormatter.format("      {\n"));
        output.append(StringFormatter.format("        controller.{0}();\n",gen.translate("doActivityMethod",state)));
        output.append(StringFormatter.format("      }"));
      }
    }
  }

    stringBuffer.append(TEXT_330);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(TEXT_334);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_335);
    
  }
}

    
{ 
  boolean hasTimedEvents = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        hasTimedEvents = true;
        
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_338);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_339);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_340);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_343);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_344);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_345);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_346);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_347);
    
      }
    }
  }

    stringBuffer.append(TEXT_348);
    
  }
}

    stringBuffer.append(TEXT_349);
    

  appendln(stringBuffer,"");
  appendln(stringBuffer,"virtual ~{0}();",uClass.getName());
  append(stringBuffer,"");

  boolean hasSomethingToDelete = false;

  String customDeletePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","delete"));
  String customDeletePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","delete"));

  if (customDeletePrefixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customDeletePrefixCode, "    "));
    hasSomethingToDelete = true;
  }


     if (uClass.hasMethods()) { 
    
    if (uClass.hasMethods())
    {
    	for (Method aMethod : uClass.getMethods()) 
    	{
    		String methodModifier = aMethod.getModifier().equals("") ? "" : aMethod.getModifier();
    		String methodName = aMethod.getName();
    		String methodType = aMethod.getType();
    		String methodBody = aMethod.getIsImplemented() ? "      return " + gen.translateReturnType(methodType) + ";" : aMethod.getMethodBody().getExtraCode();
    		String properMethodBody = "      " + methodBody; 
    		String override =  aMethod.getIsImplemented() ? "":"";
    		String paramName="";
    		String paramType="";
    		String aSingleParameter="";
    		String isList="";
    	    String parameters = "";
    		if (aMethod.hasMethodParameters())
    		{
    			for (MethodParameter aMethodParam : aMethod.getMethodParameters()) 
    			{
    				paramName = aMethodParam.getName();
    				paramType = aMethodParam.getType();
    				isList = aMethodParam.getIsList() ? " [] " : " ";
    				aSingleParameter = paramType + isList + paramName;
        			parameters += aSingleParameter + ", ";
    			}
    			String finalParams = parameters.substring(0, parameters.length()-2);
    			appendln(stringBuffer, "");
    			append(stringBuffer, "  {0} {1} {2}({3});", methodModifier, gen.translate(methodType), methodName, finalParams);	
    	
    			
    		}
    		else{
    			appendln(stringBuffer, "");
    			appendln(stringBuffer,override);
    			append(stringBuffer, "  {0} {1} {2}();", methodModifier, gen.translate(methodType), methodName);
    		 
    		}
    	}
    }

     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_350);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_352);
    return stringBuffer.toString();
  }
}