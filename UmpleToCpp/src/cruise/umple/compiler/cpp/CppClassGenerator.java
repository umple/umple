package cruise.umple.compiler.cpp;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class CppClassGenerator implements ILang 
{

  protected static String nl;
  public static synchronized CppClassGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassGenerator result = new CppClassGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */" + NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = "int i;";
  protected final String TEXT_6 = NL + "  //------------------------" + NL + "  // CONSTRUCTOR" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_7 = NL + "\t\tfor (";
  protected final String TEXT_8 = "i=0; i<";
  protected final String TEXT_9 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_10 = "[i] = NULL;" + NL + "\t}";
  protected final String TEXT_11 = NL + "    ";
  protected final String TEXT_12 = "();";
  protected final String TEXT_13 = NL + "    ";
  protected final String TEXT_14 = " = true;";
  protected final String TEXT_15 = NL + "    ";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";";
  protected final String TEXT_18 = NL + "    ";
  protected final String TEXT_19 = " = false;";
  protected final String TEXT_20 = NL + "    ";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = NL + "    ";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = NL + "    ";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = "++;";
  protected final String TEXT_29 = NL + "    if (!";
  protected final String TEXT_30 = "(";
  protected final String TEXT_31 = "))" + NL + "    {" + NL + "      throw (\"Unable to create ";
  protected final String TEXT_32 = " due to ";
  protected final String TEXT_33 = "\");" + NL + "    }";
  protected final String TEXT_34 = NL + "    for (i=0; i<";
  protected final String TEXT_35 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_36 = "[i] = NULL;" + NL + "\t}" + NL + "    bool ";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = "(";
  protected final String TEXT_39 = ");" + NL + "    try {" + NL + "\t\t throw  ";
  protected final String TEXT_40 = ";" + NL + "\t\t}" + NL + "\tcatch (exception& e)\t" + NL + "\t{" + NL + "\tcout<<\"Unable to create ";
  protected final String TEXT_41 = ", must have ";
  protected final String TEXT_42 = " ";
  protected final String TEXT_43 = "\";" + NL + "\t}";
  protected final String TEXT_44 = NL + "    for (i=0; i<";
  protected final String TEXT_45 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_46 = "[i] = NULL;" + NL + "\t}" + NL + "    bool ";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = "(";
  protected final String TEXT_49 = ");" + NL + "    if (!";
  protected final String TEXT_50 = ")" + NL + "    {" + NL + "    \ttry" + NL + "    \t{    \t" + NL + "      \t  cout<<\"Unable to create ";
  protected final String TEXT_51 = ", must have ";
  protected final String TEXT_52 = " or fewer ";
  protected final String TEXT_53 = ", no duplicates.\";" + NL + "      \t}" + NL + "      \t" + NL + "      \tcatch" + NL + "      \t{" + NL + "      \t\tcerr<<\"exception caught:\"<<e.what()<<endl;" + NL + "      \t}" + NL + "    }";
  protected final String TEXT_54 = NL + "    for (i=0; i<";
  protected final String TEXT_55 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_56 = "[i] = NULL;" + NL + "\t}" + NL + "    bool ";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "(";
  protected final String TEXT_59 = ");" + NL + "    if (!";
  protected final String TEXT_60 = ")" + NL + "    {" + NL + "    " + NL + "    try" + NL + "    \t{    \t" + NL + "      \t  cout<<\"Unable to create ";
  protected final String TEXT_61 = ", must not have duplicate ";
  protected final String TEXT_62 = ".\");" + NL + "      \t}" + NL + "      \t" + NL + "      \tcatch" + NL + "      \t{" + NL + "      \t\tcerr<<\"exception caught:\"<<e.what()<<endl;" + NL + "      \t}" + NL + "    }";
  protected final String TEXT_63 = NL + "    for (i=0; i<";
  protected final String TEXT_64 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_65 = "[i] = NULL;" + NL + "\t}";
  protected final String TEXT_66 = NL + "    if (";
  protected final String TEXT_67 = " == NULL || ";
  protected final String TEXT_68 = "->";
  protected final String TEXT_69 = "() != NULL)" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_70 = " due to ";
  protected final String TEXT_71 = "\");" + NL + "    }";
  protected final String TEXT_72 = NL + "    ";
  protected final String TEXT_73 = " = ";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = NL + "    for (i=0; i<";
  protected final String TEXT_76 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_77 = "[i] = NULL;" + NL + "\t}";
  protected final String TEXT_78 = NL + "    bool ";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = ");" + NL + "    if (!";
  protected final String TEXT_82 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_83 = " due to ";
  protected final String TEXT_84 = "\");" + NL + "    }";
  protected final String TEXT_85 = NL + "    for (i=0; i<";
  protected final String TEXT_86 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_87 = "[i] = NULL;" + NL + "\t}";
  protected final String TEXT_88 = NL + "    for (i=0; i<";
  protected final String TEXT_89 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_90 = "[i] = NULL;" + NL + "\t}" + NL + "    bool ";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = "(";
  protected final String TEXT_93 = ");" + NL + "    try {" + NL + "\t\t throw  ";
  protected final String TEXT_94 = ";" + NL + "\t\t}" + NL + "\tcatch (exception& e)\t" + NL + "\t{" + NL + "\tcout<<\"Unable to create ";
  protected final String TEXT_95 = ", must have ";
  protected final String TEXT_96 = " ";
  protected final String TEXT_97 = "\";" + NL + "\t}";
  protected final String TEXT_98 = "for (i=0; i<";
  protected final String TEXT_99 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_100 = "[i] = NULL;" + NL + "\t};";
  protected final String TEXT_101 = NL + "    ";
  protected final String TEXT_102 = ".push_back(";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "    if (";
  protected final String TEXT_105 = " == Null) { ";
  protected final String TEXT_106 = "(";
  protected final String TEXT_107 = "); }";
  protected final String TEXT_108 = NL + "    ";
  protected final String TEXT_109 = "(";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "  ";
  protected final String TEXT_112 = "* ";
  protected final String TEXT_113 = "::getInstance()" + NL + "  {" + NL + "    if(!theInstance)" + NL + "    {" + NL + "      theInstance = new ";
  protected final String TEXT_114 = ";" + NL + "    }" + NL + "    return theInstance;" + NL + "  }";
  protected final String TEXT_115 = NL;
  protected final String TEXT_116 = NL + "  ";
  protected final String TEXT_117 = "::";
  protected final String TEXT_118 = "(";
  protected final String TEXT_119 = ")" + NL + "  {";
  protected final String TEXT_120 = NL + "\t\tfor (";
  protected final String TEXT_121 = "i=0; i<";
  protected final String TEXT_122 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_123 = "[i] = NULL;" + NL + "\t}";
  protected final String TEXT_124 = NL + "    ";
  protected final String TEXT_125 = "();";
  protected final String TEXT_126 = NL + "    ";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = ";";
  protected final String TEXT_129 = NL + "    ";
  protected final String TEXT_130 = " = ";
  protected final String TEXT_131 = "++;";
  protected final String TEXT_132 = NL + "    ";
  protected final String TEXT_133 = NL + "    for (i=0; i<";
  protected final String TEXT_134 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_135 = "[i] = NULL;" + NL + "\t}";
  protected final String TEXT_136 = NL + "    bool ";
  protected final String TEXT_137 = " = ";
  protected final String TEXT_138 = "(";
  protected final String TEXT_139 = ");" + NL + "    if (!";
  protected final String TEXT_140 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_141 = " due to ";
  protected final String TEXT_142 = "\");" + NL + "    }";
  protected final String TEXT_143 = NL + "    for (i=0; i<";
  protected final String TEXT_144 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_145 = "[i] = NULL;" + NL + "\t}";
  protected final String TEXT_146 = NL + "    for (i=0; i<";
  protected final String TEXT_147 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_148 = "[i] = NULL;" + NL + "\t}" + NL + "    bool ";
  protected final String TEXT_149 = " = ";
  protected final String TEXT_150 = "(";
  protected final String TEXT_151 = ");" + NL + "    try {" + NL + "\t\t throw  ";
  protected final String TEXT_152 = ";" + NL + "\t\t}" + NL + "\tcatch (exception& e)\t" + NL + "\t{" + NL + "\tcout<<\"Unable to create ";
  protected final String TEXT_153 = ", must have ";
  protected final String TEXT_154 = " ";
  protected final String TEXT_155 = "\";" + NL + "\t}";
  protected final String TEXT_156 = "for (i=0; i<";
  protected final String TEXT_157 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_158 = "[i] = NULL;" + NL + "\t};";
  protected final String TEXT_159 = NL + "    ";
  protected final String TEXT_160 = ".push_back(";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "  ";
  protected final String TEXT_163 = NL + "  \t";
  protected final String TEXT_164 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_165 = NL + "  bool ";
  protected final String TEXT_166 = "::";
  protected final String TEXT_167 = "(const ";
  protected final String TEXT_168 = " & ";
  protected final String TEXT_169 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_170 = NL + "    ";
  protected final String TEXT_171 = " = false;";
  protected final String TEXT_172 = NL + "    ";
  protected final String TEXT_173 = " = ";
  protected final String TEXT_174 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_175 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_176 = NL + "  bool ";
  protected final String TEXT_177 = "::";
  protected final String TEXT_178 = "(const ";
  protected final String TEXT_179 = " & ";
  protected final String TEXT_180 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_181 = NL + "    ";
  protected final String TEXT_182 = " = ";
  protected final String TEXT_183 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_184 = NL + "    return wasSet;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_185 = "::";
  protected final String TEXT_186 = "()" + NL + "  {" + NL + "    bool wasReset = false;";
  protected final String TEXT_187 = NL + "    ";
  protected final String TEXT_188 = " = ";
  protected final String TEXT_189 = "();" + NL + "    wasReset = true;";
  protected final String TEXT_190 = NL + "    return wasReset;" + NL + "  }" + NL;
  protected final String TEXT_191 = NL + "  bool ";
  protected final String TEXT_192 = "::";
  protected final String TEXT_193 = "(const ";
  protected final String TEXT_194 = " & ";
  protected final String TEXT_195 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_196 = NL + "    wasAdded = ";
  protected final String TEXT_197 = ".add(";
  protected final String TEXT_198 = ");";
  protected final String TEXT_199 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_200 = "::";
  protected final String TEXT_201 = "(";
  protected final String TEXT_202 = " & ";
  protected final String TEXT_203 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_204 = NL + "    wasRemoved = ";
  protected final String TEXT_205 = ".remove(";
  protected final String TEXT_206 = ");";
  protected final String TEXT_207 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_208 = NL + "  bool ";
  protected final String TEXT_209 = "::";
  protected final String TEXT_210 = "(const ";
  protected final String TEXT_211 = " & ";
  protected final String TEXT_212 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_213 = NL + "    ";
  protected final String TEXT_214 = " = ";
  protected final String TEXT_215 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_216 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_217 = NL + "  ";
  protected final String TEXT_218 = " ";
  protected final String TEXT_219 = "::";
  protected final String TEXT_220 = "(int index)" + NL + "  {";
  protected final String TEXT_221 = NL + "    ";
  protected final String TEXT_222 = " ";
  protected final String TEXT_223 = " = ";
  protected final String TEXT_224 = ".get(index);";
  protected final String TEXT_225 = NL + "    return ";
  protected final String TEXT_226 = ";" + NL + "  }" + NL;
  protected final String TEXT_227 = NL + "  ";
  protected final String TEXT_228 = "[] ";
  protected final String TEXT_229 = "::";
  protected final String TEXT_230 = "()" + NL + "  {";
  protected final String TEXT_231 = NL + "    ";
  protected final String TEXT_232 = "[] ";
  protected final String TEXT_233 = " = ";
  protected final String TEXT_234 = ".toArray(new ";
  protected final String TEXT_235 = "[";
  protected final String TEXT_236 = ".size()]);";
  protected final String TEXT_237 = NL + "    return ";
  protected final String TEXT_238 = ";" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_239 = "::";
  protected final String TEXT_240 = "()" + NL + "  {";
  protected final String TEXT_241 = NL + "    int number = ";
  protected final String TEXT_242 = ".size();";
  protected final String TEXT_243 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_244 = "::";
  protected final String TEXT_245 = "()" + NL + "  {";
  protected final String TEXT_246 = NL + "    bool has = ";
  protected final String TEXT_247 = ".size() > 0;";
  protected final String TEXT_248 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_249 = "::";
  protected final String TEXT_250 = "(";
  protected final String TEXT_251 = "* ";
  protected final String TEXT_252 = ")" + NL + "  {";
  protected final String TEXT_253 = NL + "    int index = find(";
  protected final String TEXT_254 = ".begin(), ";
  protected final String TEXT_255 = ".end(), ";
  protected final String TEXT_256 = ") - ";
  protected final String TEXT_257 = ".begin();";
  protected final String TEXT_258 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_259 = NL + "  ";
  protected final String TEXT_260 = " ";
  protected final String TEXT_261 = "::";
  protected final String TEXT_262 = "()" + NL + "  {";
  protected final String TEXT_263 = NL + "    ";
  protected final String TEXT_264 = " ";
  protected final String TEXT_265 = " = ";
  protected final String TEXT_266 = ";";
  protected final String TEXT_267 = NL + "    return ";
  protected final String TEXT_268 = ";" + NL + "  }";
  protected final String TEXT_269 = NL + "  ";
  protected final String TEXT_270 = " ";
  protected final String TEXT_271 = "::";
  protected final String TEXT_272 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_273 = ";" + NL + "  }";
  protected final String TEXT_274 = NL + "  ";
  protected final String TEXT_275 = " ";
  protected final String TEXT_276 = "::";
  protected final String TEXT_277 = "()" + NL + "  {";
  protected final String TEXT_278 = NL + "    ";
  protected final String TEXT_279 = " ";
  protected final String TEXT_280 = " = ";
  protected final String TEXT_281 = ";";
  protected final String TEXT_282 = NL + "    return ";
  protected final String TEXT_283 = ";" + NL + "  }";
  protected final String TEXT_284 = NL + "  ";
  protected final String TEXT_285 = " ";
  protected final String TEXT_286 = "::";
  protected final String TEXT_287 = "() const" + NL + "  {";
  protected final String TEXT_288 = NL + "    return ";
  protected final String TEXT_289 = ";" + NL + "  }";
  protected final String TEXT_290 = NL + "  ";
  protected final String TEXT_291 = " ";
  protected final String TEXT_292 = "::";
  protected final String TEXT_293 = "()" + NL + "  {";
  protected final String TEXT_294 = NL + "    ";
  protected final String TEXT_295 = " ";
  protected final String TEXT_296 = " = ";
  protected final String TEXT_297 = ";";
  protected final String TEXT_298 = NL + "    return ";
  protected final String TEXT_299 = ";" + NL + "  }";
  protected final String TEXT_300 = NL + "  ";
  protected final String TEXT_301 = " ";
  protected final String TEXT_302 = "::";
  protected final String TEXT_303 = "() const" + NL + "  {";
  protected final String TEXT_304 = NL + "    return ";
  protected final String TEXT_305 = ";" + NL + "  }" + NL;
  protected final String TEXT_306 = NL + "  ";
  protected final String TEXT_307 = " ";
  protected final String TEXT_308 = "::";
  protected final String TEXT_309 = "()" + NL + "  {";
  protected final String TEXT_310 = NL + "    ";
  protected final String TEXT_311 = " ";
  protected final String TEXT_312 = " = ";
  protected final String TEXT_313 = ";";
  protected final String TEXT_314 = NL + "    return ";
  protected final String TEXT_315 = ";" + NL + "  }";
  protected final String TEXT_316 = NL + "  ";
  protected final String TEXT_317 = " ";
  protected final String TEXT_318 = "::";
  protected final String TEXT_319 = "() const" + NL + "  {";
  protected final String TEXT_320 = NL + "    return ";
  protected final String TEXT_321 = ";" + NL + "  }";
  protected final String TEXT_322 = NL + "  ";
  protected final String TEXT_323 = " ";
  protected final String TEXT_324 = "::";
  protected final String TEXT_325 = "()" + NL + "  {" + NL + "    string answer = ";
  protected final String TEXT_326 = "(";
  protected final String TEXT_327 = ");";
  protected final String TEXT_328 = NL + "    return answer;" + NL + "  }" + NL + "  ";
  protected final String TEXT_329 = NL + "  ";
  protected final String TEXT_330 = "::";
  protected final String TEXT_331 = " ";
  protected final String TEXT_332 = "::";
  protected final String TEXT_333 = "()";
  protected final String TEXT_334 = NL + "  ";
  protected final String TEXT_335 = "bool ";
  protected final String TEXT_336 = "::";
  protected final String TEXT_337 = "(";
  protected final String TEXT_338 = ")" + NL + "  {" + NL + "    bool wasEventProcessed = false;" + NL;
  protected final String TEXT_339 = NL + "    ";
  protected final String TEXT_340 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_341 = NL + "  bool ";
  protected final String TEXT_342 = "::";
  protected final String TEXT_343 = "(";
  protected final String TEXT_344 = " ";
  protected final String TEXT_345 = ")" + NL + "  {";
  protected final String TEXT_346 = NL + "    ";
  protected final String TEXT_347 = " = ";
  protected final String TEXT_348 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_349 = NL + "  void ";
  protected final String TEXT_350 = "::";
  protected final String TEXT_351 = "()" + NL + "  {";
  protected final String TEXT_352 = NL + "    switch(";
  protected final String TEXT_353 = ")" + NL + "    {";
  protected final String TEXT_354 = NL + "      ";
  protected final String TEXT_355 = NL + "    }";
  protected final String TEXT_356 = NL + "  }" + NL;
  protected final String TEXT_357 = NL + "  void ";
  protected final String TEXT_358 = "::";
  protected final String TEXT_359 = "(";
  protected final String TEXT_360 = " ";
  protected final String TEXT_361 = ")" + NL + "  {";
  protected final String TEXT_362 = NL + "    ";
  protected final String TEXT_363 = " = ";
  protected final String TEXT_364 = ";";
  protected final String TEXT_365 = NL + "    if (";
  protected final String TEXT_366 = " != ";
  protected final String TEXT_367 = " && ";
  protected final String TEXT_368 = " != ";
  protected final String TEXT_369 = ") { ";
  protected final String TEXT_370 = "(";
  protected final String TEXT_371 = "); }";
  protected final String TEXT_372 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_373 = ")" + NL + "    {";
  protected final String TEXT_374 = NL + "      ";
  protected final String TEXT_375 = NL + "    }";
  protected final String TEXT_376 = NL + "  }" + NL + "  " + NL;
  protected final String TEXT_377 = NL + "  ";
  protected final String TEXT_378 = "* ";
  protected final String TEXT_379 = "::";
  protected final String TEXT_380 = "() " + NL + "  {";
  protected final String TEXT_381 = NL + "    return ";
  protected final String TEXT_382 = ";";
  protected final String TEXT_383 = NL + "    ";
  protected final String TEXT_384 = "* ";
  protected final String TEXT_385 = " = ";
  protected final String TEXT_386 = ";";
  protected final String TEXT_387 = NL + "    return ";
  protected final String TEXT_388 = ";";
  protected final String TEXT_389 = NL + "  }" + NL;
  protected final String TEXT_390 = NL + "  ";
  protected final String TEXT_391 = "* ";
  protected final String TEXT_392 = "::";
  protected final String TEXT_393 = "(int index) " + NL + "  {";
  protected final String TEXT_394 = NL + "    ";
  protected final String TEXT_395 = "* ";
  protected final String TEXT_396 = " = ";
  protected final String TEXT_397 = "[index];";
  protected final String TEXT_398 = NL + "    return ";
  protected final String TEXT_399 = ";" + NL + "  }" + NL + "" + NL + "  vector<";
  protected final String TEXT_400 = "*> ";
  protected final String TEXT_401 = "::";
  protected final String TEXT_402 = "() " + NL + "  {";
  protected final String TEXT_403 = NL + "    vector<";
  protected final String TEXT_404 = "*> ";
  protected final String TEXT_405 = " = ";
  protected final String TEXT_406 = ";";
  protected final String TEXT_407 = NL + "    return ";
  protected final String TEXT_408 = ";" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_409 = "::";
  protected final String TEXT_410 = "()" + NL + "  {";
  protected final String TEXT_411 = NL + "    int number = ";
  protected final String TEXT_412 = ".size();";
  protected final String TEXT_413 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_414 = "::";
  protected final String TEXT_415 = "()" + NL + "  {";
  protected final String TEXT_416 = NL + "    bool has = ";
  protected final String TEXT_417 = ".size() > 0;";
  protected final String TEXT_418 = NL + "    return has;" + NL + "  }" + NL + "  " + NL + "  int ";
  protected final String TEXT_419 = "::";
  protected final String TEXT_420 = "(";
  protected final String TEXT_421 = "* ";
  protected final String TEXT_422 = ")" + NL + "  {";
  protected final String TEXT_423 = NL + "    int index = find(";
  protected final String TEXT_424 = ".begin(), ";
  protected final String TEXT_425 = ".end(), ";
  protected final String TEXT_426 = ") - ";
  protected final String TEXT_427 = ".begin();";
  protected final String TEXT_428 = NL + "    return index;" + NL + "  }" + NL + "  ";
  protected final String TEXT_429 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_430 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_431 = " : ";
  protected final String TEXT_432 = NL + "  bool ";
  protected final String TEXT_433 = "::";
  protected final String TEXT_434 = "()" + NL + "  {";
  protected final String TEXT_435 = NL + "    bool isValid = ";
  protected final String TEXT_436 = "() >= ";
  protected final String TEXT_437 = "();";
  protected final String TEXT_438 = NL + "    bool isValid = ";
  protected final String TEXT_439 = "() >= ";
  protected final String TEXT_440 = "() && ";
  protected final String TEXT_441 = "() <= ";
  protected final String TEXT_442 = "();";
  protected final String TEXT_443 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_444 = NL + "  static int ";
  protected final String TEXT_445 = "::";
  protected final String TEXT_446 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_447 = ";" + NL + "  }";
  protected final String TEXT_448 = NL + "  static int ";
  protected final String TEXT_449 = "::";
  protected final String TEXT_450 = "()" + NL + "  {";
  protected final String TEXT_451 = NL + "    int required = ";
  protected final String TEXT_452 = ";";
  protected final String TEXT_453 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_454 = NL + "  static int ";
  protected final String TEXT_455 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_456 = ";" + NL + "  }";
  protected final String TEXT_457 = NL + "  static int ";
  protected final String TEXT_458 = "::";
  protected final String TEXT_459 = "()" + NL + "  {";
  protected final String TEXT_460 = NL + "    int minimum = ";
  protected final String TEXT_461 = ";";
  protected final String TEXT_462 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_463 = NL + "  static int ";
  protected final String TEXT_464 = "::";
  protected final String TEXT_465 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_466 = ";" + NL + "  }";
  protected final String TEXT_467 = NL + "  static int ";
  protected final String TEXT_468 = "::";
  protected final String TEXT_469 = "()" + NL + "  {";
  protected final String TEXT_470 = NL + "    int maximum = ";
  protected final String TEXT_471 = ";";
  protected final String TEXT_472 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_473 = NL + "  bool ";
  protected final String TEXT_474 = "::";
  protected final String TEXT_475 = "(";
  protected final String TEXT_476 = "* ";
  protected final String TEXT_477 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_478 = NL + "    if (";
  protected final String TEXT_479 = "() >= ";
  protected final String TEXT_480 = "())" + NL + "    {";
  protected final String TEXT_481 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_482 = NL + "    ";
  protected final String TEXT_483 = ".push_back(";
  protected final String TEXT_484 = ");" + NL + "    if (";
  protected final String TEXT_485 = "->";
  protected final String TEXT_486 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_487 = ".";
  protected final String TEXT_488 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_489 = NL + "        ";
  protected final String TEXT_490 = ".erase(find(";
  protected final String TEXT_491 = ".begin(),";
  protected final String TEXT_492 = ".end(),";
  protected final String TEXT_493 = "));" + NL + "      }" + NL + "    }";
  protected final String TEXT_494 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_495 = NL + "  bool ";
  protected final String TEXT_496 = "::";
  protected final String TEXT_497 = "(";
  protected final String TEXT_498 = " ";
  protected final String TEXT_499 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_500 = NL + "    if (!find(";
  protected final String TEXT_501 = ".begin(),";
  protected final String TEXT_502 = ".end(),";
  protected final String TEXT_503 = "))" + NL + "    {";
  protected final String TEXT_504 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = find(";
  protected final String TEXT_505 = ".begin(), ";
  protected final String TEXT_506 = ".end(), ";
  protected final String TEXT_507 = ") - ";
  protected final String TEXT_508 = ".begin();";
  protected final String TEXT_509 = NL + "    ";
  protected final String TEXT_510 = ".erase(find(";
  protected final String TEXT_511 = ".begin(),";
  protected final String TEXT_512 = ".end(),";
  protected final String TEXT_513 = "));" + NL + "    if (";
  protected final String TEXT_514 = "->";
  protected final String TEXT_515 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_516 = "->";
  protected final String TEXT_517 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_518 = NL + "        ";
  protected final String TEXT_519 = ".push_back(oldIndex,";
  protected final String TEXT_520 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_521 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_522 = NL + "  bool ";
  protected final String TEXT_523 = "::";
  protected final String TEXT_524 = "(";
  protected final String TEXT_525 = "* ";
  protected final String TEXT_526 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_527 = NL + "    ";
  protected final String TEXT_528 = " = ";
  protected final String TEXT_529 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_530 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_531 = NL + "  bool ";
  protected final String TEXT_532 = "::";
  protected final String TEXT_533 = "(";
  protected final String TEXT_534 = "* ";
  protected final String TEXT_535 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_536 = NL + "    if (";
  protected final String TEXT_537 = " != NULL)" + NL + "    {";
  protected final String TEXT_538 = NL + "      ";
  protected final String TEXT_539 = " = ";
  protected final String TEXT_540 = ";" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_541 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_542 = NL + "  bool ";
  protected final String TEXT_543 = "::";
  protected final String TEXT_544 = "(";
  protected final String TEXT_545 = "* ";
  protected final String TEXT_546 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_547 = NL + "    if (";
  protected final String TEXT_548 = " != NULL && ";
  protected final String TEXT_549 = "!=";
  protected final String TEXT_550 = " && = ";
  protected final String TEXT_551 = "->";
  protected final String TEXT_552 = "())" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_553 = ", as existing ";
  protected final String TEXT_554 = " would become an orphan";
  protected final String TEXT_555 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_556 = NL + "    ";
  protected final String TEXT_557 = " = ";
  protected final String TEXT_558 = ";";
  protected final String TEXT_559 = NL + "    ";
  protected final String TEXT_560 = " ";
  protected final String TEXT_561 = " = ";
  protected final String TEXT_562 = " != NULL ? ";
  protected final String TEXT_563 = "->";
  protected final String TEXT_564 = "() : NULL;" + NL + "" + NL + "    if (this!=";
  protected final String TEXT_565 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_566 = " != NULL)" + NL + "      {";
  protected final String TEXT_567 = NL + "        ";
  protected final String TEXT_568 = "->";
  protected final String TEXT_569 = " = NULL;" + NL + "      }" + NL + "      if (";
  protected final String TEXT_570 = " != NULL)" + NL + "      {";
  protected final String TEXT_571 = NL + "        ";
  protected final String TEXT_572 = "->";
  protected final String TEXT_573 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_574 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_575 = NL + "  bool ";
  protected final String TEXT_576 = "::";
  protected final String TEXT_577 = "(";
  protected final String TEXT_578 = " ";
  protected final String TEXT_579 = ")" + NL + "  {" + NL + "    bool";
  protected final String TEXT_580 = NL + "    if (";
  protected final String TEXT_581 = " == NULL)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_582 = " to null, as ";
  protected final String TEXT_583 = " must always be associated to a ";
  protected final String TEXT_584 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_585 = NL + "    ";
  protected final String TEXT_586 = "* ";
  protected final String TEXT_587 = " = ";
  protected final String TEXT_588 = "->";
  protected final String TEXT_589 = "();" + NL + "    if (";
  protected final String TEXT_590 = " != NULL && !=";
  protected final String TEXT_591 = ")" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_592 = ", the current ";
  protected final String TEXT_593 = " already has a ";
  protected final String TEXT_594 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_595 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_596 = NL + "    ";
  protected final String TEXT_597 = "* ";
  protected final String TEXT_598 = " = ";
  protected final String TEXT_599 = ";";
  protected final String TEXT_600 = NL + "    ";
  protected final String TEXT_601 = " = ";
  protected final String TEXT_602 = ";";
  protected final String TEXT_603 = NL + "    ";
  protected final String TEXT_604 = "->";
  protected final String TEXT_605 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_606 = " != NULL)" + NL + "    {";
  protected final String TEXT_607 = NL + "      ";
  protected final String TEXT_608 = "->";
  protected final String TEXT_609 = "(null);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_610 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_611 = NL + "  ";
  protected final String TEXT_612 = " ";
  protected final String TEXT_613 = "::";
  protected final String TEXT_614 = "(";
  protected final String TEXT_615 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_616 = "(";
  protected final String TEXT_617 = ");" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_618 = "::";
  protected final String TEXT_619 = "(";
  protected final String TEXT_620 = "* ";
  protected final String TEXT_621 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_622 = NL + "    ";
  protected final String TEXT_623 = " ";
  protected final String TEXT_624 = " = ";
  protected final String TEXT_625 = "->";
  protected final String TEXT_626 = "();" + NL + "    bool ";
  protected final String TEXT_627 = " = (";
  protected final String TEXT_628 = " != NULL && this != ";
  protected final String TEXT_629 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_630 = " && ";
  protected final String TEXT_631 = "->";
  protected final String TEXT_632 = "() <= ";
  protected final String TEXT_633 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_634 = ")" + NL + "    {";
  protected final String TEXT_635 = NL + "      ";
  protected final String TEXT_636 = "->";
  protected final String TEXT_637 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_638 = NL + "      ";
  protected final String TEXT_639 = ".add(";
  protected final String TEXT_640 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_641 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_642 = "::";
  protected final String TEXT_643 = "(";
  protected final String TEXT_644 = "* ";
  protected final String TEXT_645 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\t";
  protected final String TEXT_646 = NL + "    //Unable to remove ";
  protected final String TEXT_647 = ", as it must always have a ";
  protected final String TEXT_648 = NL + "    if (this == ";
  protected final String TEXT_649 = "->";
  protected final String TEXT_650 = "()))" + NL + "    {";
  protected final String TEXT_651 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_652 = " already at minimum (";
  protected final String TEXT_653 = ")" + NL + "    if (";
  protected final String TEXT_654 = "() <= ";
  protected final String TEXT_655 = "())" + NL + "    {";
  protected final String TEXT_656 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_657 = NL + "    ";
  protected final String TEXT_658 = ".remove(";
  protected final String TEXT_659 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_660 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_661 = NL + "  ";
  protected final String TEXT_662 = " ";
  protected final String TEXT_663 = "::";
  protected final String TEXT_664 = "(";
  protected final String TEXT_665 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_666 = "() >= ";
  protected final String TEXT_667 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_668 = "(";
  protected final String TEXT_669 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_670 = "::";
  protected final String TEXT_671 = "(";
  protected final String TEXT_672 = "* ";
  protected final String TEXT_673 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_674 = NL + "    if (";
  protected final String TEXT_675 = "() >= ";
  protected final String TEXT_676 = "())" + NL + "    {";
  protected final String TEXT_677 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_678 = NL + "    ";
  protected final String TEXT_679 = " ";
  protected final String TEXT_680 = " = ";
  protected final String TEXT_681 = "->";
  protected final String TEXT_682 = "();" + NL + "    bool ";
  protected final String TEXT_683 = " = (";
  protected final String TEXT_684 = " != NULL && this!=";
  protected final String TEXT_685 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_686 = " && ";
  protected final String TEXT_687 = "->";
  protected final String TEXT_688 = "() <= ";
  protected final String TEXT_689 = "())" + NL + "    {";
  protected final String TEXT_690 = NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_691 = ")" + NL + "    {";
  protected final String TEXT_692 = NL + "      ";
  protected final String TEXT_693 = "->";
  protected final String TEXT_694 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_695 = NL + "      ";
  protected final String TEXT_696 = ".add(";
  protected final String TEXT_697 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_698 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_699 = "::";
  protected final String TEXT_700 = "(";
  protected final String TEXT_701 = "* ";
  protected final String TEXT_702 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_703 = ".begin(), ";
  protected final String TEXT_704 = ".end(), ";
  protected final String TEXT_705 = ") - ";
  protected final String TEXT_706 = ".begin();";
  protected final String TEXT_707 = NL + "    //Unable to remove ";
  protected final String TEXT_708 = ", as it must always have a ";
  protected final String TEXT_709 = NL + "    if (this == ";
  protected final String TEXT_710 = "->";
  protected final String TEXT_711 = "())" + NL + "    {";
  protected final String TEXT_712 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_713 = " already at minimum (";
  protected final String TEXT_714 = ")" + NL + "    if (";
  protected final String TEXT_715 = "() <= ";
  protected final String TEXT_716 = "())" + NL + "    {";
  protected final String TEXT_717 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_718 = NL + "    ";
  protected final String TEXT_719 = ".erase(find(";
  protected final String TEXT_720 = ".begin(),";
  protected final String TEXT_721 = ".end(),";
  protected final String TEXT_722 = "));" + NL + "\tdelete ";
  protected final String TEXT_723 = "[index];" + NL + "    wasRemoved = true;";
  protected final String TEXT_724 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_725 = NL + "  ";
  protected final String TEXT_726 = " ";
  protected final String TEXT_727 = "::";
  protected final String TEXT_728 = "(";
  protected final String TEXT_729 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_730 = "() >= ";
  protected final String TEXT_731 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_732 = "(";
  protected final String TEXT_733 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_734 = "::";
  protected final String TEXT_735 = "(";
  protected final String TEXT_736 = "* ";
  protected final String TEXT_737 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_738 = NL + "    if (";
  protected final String TEXT_739 = "() >= ";
  protected final String TEXT_740 = "())" + NL + "    {";
  protected final String TEXT_741 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_742 = NL + "    ";
  protected final String TEXT_743 = " ";
  protected final String TEXT_744 = " = ";
  protected final String TEXT_745 = "->";
  protected final String TEXT_746 = "();" + NL + "    bool ";
  protected final String TEXT_747 = " = (";
  protected final String TEXT_748 = " != NULL && this != ";
  protected final String TEXT_749 = ");" + NL + "    if (";
  protected final String TEXT_750 = ")" + NL + "    {";
  protected final String TEXT_751 = NL + "      ";
  protected final String TEXT_752 = "->";
  protected final String TEXT_753 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_754 = NL + "      ";
  protected final String TEXT_755 = ".push_back(";
  protected final String TEXT_756 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_757 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_758 = "::";
  protected final String TEXT_759 = "(";
  protected final String TEXT_760 = "* ";
  protected final String TEXT_761 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_762 = ".begin(), ";
  protected final String TEXT_763 = ".end(), ";
  protected final String TEXT_764 = ") - ";
  protected final String TEXT_765 = ".begin();";
  protected final String TEXT_766 = NL + "    //Unable to remove ";
  protected final String TEXT_767 = ", as it must always have a ";
  protected final String TEXT_768 = NL + "    if (this != ";
  protected final String TEXT_769 = "->";
  protected final String TEXT_770 = "())" + NL + "    {";
  protected final String TEXT_771 = NL + "      ";
  protected final String TEXT_772 = ".erase(find(";
  protected final String TEXT_773 = ".begin(),";
  protected final String TEXT_774 = ".end(),";
  protected final String TEXT_775 = "));" + NL + "\t  delete ";
  protected final String TEXT_776 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_777 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_778 = NL + "  bool ";
  protected final String TEXT_779 = "::";
  protected final String TEXT_780 = "(";
  protected final String TEXT_781 = "... ";
  protected final String TEXT_782 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_783 = NL + "    vector<";
  protected final String TEXT_784 = "*> ";
  protected final String TEXT_785 = ";" + NL + "\t" + NL + "    for (";
  protected final String TEXT_786 = " ";
  protected final String TEXT_787 = " : ";
  protected final String TEXT_788 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_789 = ".begin(),";
  protected final String TEXT_790 = ".end(),";
  protected final String TEXT_791 = ") != ";
  protected final String TEXT_792 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_793 = NL + "      ";
  protected final String TEXT_794 = "->add(";
  protected final String TEXT_795 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_796 = ".size() != ";
  protected final String TEXT_797 = ".length || ";
  protected final String TEXT_798 = ".size() > ";
  protected final String TEXT_799 = "())" + NL + "    {";
  protected final String TEXT_800 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_801 = "*> ";
  protected final String TEXT_802 = ";";
  protected final String TEXT_803 = NL + "    ";
  protected final String TEXT_804 = ".clear();" + NL + "    for (";
  protected final String TEXT_805 = " ";
  protected final String TEXT_806 = " : ";
  protected final String TEXT_807 = ")" + NL + "    {";
  protected final String TEXT_808 = NL + "      ";
  protected final String TEXT_809 = "->add(";
  protected final String TEXT_810 = ");" + NL + "      if (find(";
  protected final String TEXT_811 = ".begin(),";
  protected final String TEXT_812 = ".end(),";
  protected final String TEXT_813 = ") != ";
  protected final String TEXT_814 = ".end())" + NL + "      {";
  protected final String TEXT_815 = NL + "        ";
  protected final String TEXT_816 = ".erase(";
  protected final String TEXT_817 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_818 = NL + "        ";
  protected final String TEXT_819 = "->";
  protected final String TEXT_820 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_821 = " ";
  protected final String TEXT_822 = " : ";
  protected final String TEXT_823 = ")" + NL + "    {";
  protected final String TEXT_824 = NL + "      ";
  protected final String TEXT_825 = "->";
  protected final String TEXT_826 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_827 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_828 = NL + "  ";
  protected final String TEXT_829 = " ";
  protected final String TEXT_830 = "::";
  protected final String TEXT_831 = "(";
  protected final String TEXT_832 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_833 = "(";
  protected final String TEXT_834 = ");" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_835 = "::";
  protected final String TEXT_836 = "(";
  protected final String TEXT_837 = "* ";
  protected final String TEXT_838 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_839 = NL + "    ";
  protected final String TEXT_840 = "* ";
  protected final String TEXT_841 = " = ";
  protected final String TEXT_842 = "->";
  protected final String TEXT_843 = "();" + NL + "    bool ";
  protected final String TEXT_844 = " = (";
  protected final String TEXT_845 = " != NULL && this!=";
  protected final String TEXT_846 = ");" + NL + "    if (";
  protected final String TEXT_847 = ")" + NL + "    {";
  protected final String TEXT_848 = NL + "      ";
  protected final String TEXT_849 = "->";
  protected final String TEXT_850 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_851 = NL + "      ";
  protected final String TEXT_852 = ".push_back(";
  protected final String TEXT_853 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_854 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_855 = "::";
  protected final String TEXT_856 = "(";
  protected final String TEXT_857 = "* ";
  protected final String TEXT_858 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_859 = ".begin(), ";
  protected final String TEXT_860 = ".end(), ";
  protected final String TEXT_861 = ") - ";
  protected final String TEXT_862 = ".begin();";
  protected final String TEXT_863 = NL + "    //Unable to remove ";
  protected final String TEXT_864 = ", as it must always have a ";
  protected final String TEXT_865 = NL + "    if (this!=";
  protected final String TEXT_866 = "->";
  protected final String TEXT_867 = "())" + NL + "    {";
  protected final String TEXT_868 = NL + "      ";
  protected final String TEXT_869 = ".erase(find(";
  protected final String TEXT_870 = ".begin(),";
  protected final String TEXT_871 = ".end(),";
  protected final String TEXT_872 = "));" + NL + "\t  delete ";
  protected final String TEXT_873 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_874 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_875 = NL + "  bool ";
  protected final String TEXT_876 = "::";
  protected final String TEXT_877 = "(";
  protected final String TEXT_878 = "* ";
  protected final String TEXT_879 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_880 = NL + "    if (";
  protected final String TEXT_881 = " == NULL)" + NL + "    {";
  protected final String TEXT_882 = NL + "      ";
  protected final String TEXT_883 = " ";
  protected final String TEXT_884 = " = ";
  protected final String TEXT_885 = ";";
  protected final String TEXT_886 = NL + "      ";
  protected final String TEXT_887 = " = NULL;" + NL + "      " + NL + "      if (";
  protected final String TEXT_888 = " != NULL && ";
  protected final String TEXT_889 = "->";
  protected final String TEXT_890 = "() != NULL)" + NL + "      {";
  protected final String TEXT_891 = NL + "        ";
  protected final String TEXT_892 = "->";
  protected final String TEXT_893 = "(NULL);" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_894 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_895 = NL + "    ";
  protected final String TEXT_896 = "* ";
  protected final String TEXT_897 = " = ";
  protected final String TEXT_898 = "();" + NL + "    if (";
  protected final String TEXT_899 = " != NULL && ";
  protected final String TEXT_900 = "!=";
  protected final String TEXT_901 = ")" + NL + "    {";
  protected final String TEXT_902 = NL + "      ";
  protected final String TEXT_903 = "->";
  protected final String TEXT_904 = "(NULL);" + NL + "    }" + NL;
  protected final String TEXT_905 = NL + "    ";
  protected final String TEXT_906 = " = ";
  protected final String TEXT_907 = ";";
  protected final String TEXT_908 = NL + "    ";
  protected final String TEXT_909 = "* ";
  protected final String TEXT_910 = " = ";
  protected final String TEXT_911 = "->";
  protected final String TEXT_912 = "();" + NL + "" + NL + "    if (!=";
  protected final String TEXT_913 = ")" + NL + "    {";
  protected final String TEXT_914 = NL + "      ";
  protected final String TEXT_915 = "->";
  protected final String TEXT_916 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_917 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_918 = NL + "  bool ";
  protected final String TEXT_919 = "::";
  protected final String TEXT_920 = "(";
  protected final String TEXT_921 = "* ";
  protected final String TEXT_922 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_923 = ".begin(), ";
  protected final String TEXT_924 = ".end(), ";
  protected final String TEXT_925 = ") - ";
  protected final String TEXT_926 = ".begin();";
  protected final String TEXT_927 = NL + "    if (! find(";
  protected final String TEXT_928 = ".begin(),";
  protected final String TEXT_929 = ".end(),";
  protected final String TEXT_930 = "))" + NL + "    {";
  protected final String TEXT_931 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_932 = "() <= ";
  protected final String TEXT_933 = "())" + NL + "    {";
  protected final String TEXT_934 = NL + "      return wasRemoved;" + NL + "    }" + NL + "\t" + NL + "    int oldIndex = find(";
  protected final String TEXT_935 = ".begin(), ";
  protected final String TEXT_936 = ".end(), ";
  protected final String TEXT_937 = ") - ";
  protected final String TEXT_938 = ".begin();";
  protected final String TEXT_939 = NL + "    ";
  protected final String TEXT_940 = ".erase(find(";
  protected final String TEXT_941 = ".begin(), ";
  protected final String TEXT_942 = ".end(), ";
  protected final String TEXT_943 = "));" + NL + "\tdelete ";
  protected final String TEXT_944 = "[oldIndex];" + NL + "    if (";
  protected final String TEXT_945 = "->";
  protected final String TEXT_946 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_947 = "->";
  protected final String TEXT_948 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_949 = NL + "        ";
  protected final String TEXT_950 = "->add(oldIndex,";
  protected final String TEXT_951 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_952 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_953 = NL + "  bool ";
  protected final String TEXT_954 = "::";
  protected final String TEXT_955 = "(";
  protected final String TEXT_956 = "* ";
  protected final String TEXT_957 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_958 = ".begin(), ";
  protected final String TEXT_959 = ".end(), ";
  protected final String TEXT_960 = ") - ";
  protected final String TEXT_961 = ".begin();";
  protected final String TEXT_962 = NL + "    if (! find(";
  protected final String TEXT_963 = ".begin(),";
  protected final String TEXT_964 = ".end(),";
  protected final String TEXT_965 = ") != ";
  protected final String TEXT_966 = ".end())" + NL + "    {";
  protected final String TEXT_967 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_968 = "() <= ";
  protected final String TEXT_969 = "())" + NL + "    {";
  protected final String TEXT_970 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = find(";
  protected final String TEXT_971 = ".begin(), ";
  protected final String TEXT_972 = ".end(), ";
  protected final String TEXT_973 = ") - ";
  protected final String TEXT_974 = ".begin();";
  protected final String TEXT_975 = NL + "    ";
  protected final String TEXT_976 = ".erase(oldIndex);" + NL + "\tdelete ";
  protected final String TEXT_977 = "[oldIndex];" + NL + "    if (";
  protected final String TEXT_978 = "->";
  protected final String TEXT_979 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_980 = ".";
  protected final String TEXT_981 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_982 = NL + "        ";
  protected final String TEXT_983 = ".add(oldIndex,";
  protected final String TEXT_984 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_985 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_986 = NL + "  bool ";
  protected final String TEXT_987 = "::";
  protected final String TEXT_988 = "(";
  protected final String TEXT_989 = "* ";
  protected final String TEXT_990 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_991 = NL + "    if (";
  protected final String TEXT_992 = " != NULL && ";
  protected final String TEXT_993 = "->";
  protected final String TEXT_994 = "() >= ";
  protected final String TEXT_995 = "->";
  protected final String TEXT_996 = "())" + NL + "    {";
  protected final String TEXT_997 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_998 = NL + "    ";
  protected final String TEXT_999 = "* ";
  protected final String TEXT_1000 = " = ";
  protected final String TEXT_1001 = ";";
  protected final String TEXT_1002 = NL + "    ";
  protected final String TEXT_1003 = " = ";
  protected final String TEXT_1004 = ";" + NL + "    if (";
  protected final String TEXT_1005 = " != NULL && ";
  protected final String TEXT_1006 = "!=";
  protected final String TEXT_1007 = ")" + NL + "    {";
  protected final String TEXT_1008 = NL + "      ";
  protected final String TEXT_1009 = "->";
  protected final String TEXT_1010 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1011 = " != null)" + NL + "    {";
  protected final String TEXT_1012 = NL + "      ";
  protected final String TEXT_1013 = "->";
  protected final String TEXT_1014 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1015 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1016 = NL + "  bool ";
  protected final String TEXT_1017 = "::";
  protected final String TEXT_1018 = "(";
  protected final String TEXT_1019 = "* ";
  protected final String TEXT_1020 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1021 = NL + "    if (";
  protected final String TEXT_1022 = " == NULL)" + NL + "    {";
  protected final String TEXT_1023 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1024 = NL + "    ";
  protected final String TEXT_1025 = "* ";
  protected final String TEXT_1026 = " = ";
  protected final String TEXT_1027 = ";";
  protected final String TEXT_1028 = NL + "    ";
  protected final String TEXT_1029 = " = ";
  protected final String TEXT_1030 = ";" + NL + "    if (";
  protected final String TEXT_1031 = " != NULL && ";
  protected final String TEXT_1032 = "!=";
  protected final String TEXT_1033 = ")" + NL + "    {";
  protected final String TEXT_1034 = NL + "      ";
  protected final String TEXT_1035 = "->";
  protected final String TEXT_1036 = "(this);" + NL + "    }";
  protected final String TEXT_1037 = NL + "    ";
  protected final String TEXT_1038 = "->";
  protected final String TEXT_1039 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1040 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1041 = NL + "  bool ";
  protected final String TEXT_1042 = "::";
  protected final String TEXT_1043 = "(";
  protected final String TEXT_1044 = "* ";
  protected final String TEXT_1045 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1046 = NL + "    //Must provide ";
  protected final String TEXT_1047 = " to ";
  protected final String TEXT_1048 = NL + "    if (";
  protected final String TEXT_1049 = " == NULL)" + NL + "    {";
  protected final String TEXT_1050 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1051 = " already at maximum (";
  protected final String TEXT_1052 = ")" + NL + "    if (";
  protected final String TEXT_1053 = "->";
  protected final String TEXT_1054 = "() >= ";
  protected final String TEXT_1055 = "->";
  protected final String TEXT_1056 = "())" + NL + "    {";
  protected final String TEXT_1057 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1058 = NL + "    ";
  protected final String TEXT_1059 = "* ";
  protected final String TEXT_1060 = " = ";
  protected final String TEXT_1061 = ";";
  protected final String TEXT_1062 = NL + "    ";
  protected final String TEXT_1063 = " = ";
  protected final String TEXT_1064 = ";" + NL + "    if (";
  protected final String TEXT_1065 = " != NULL && ";
  protected final String TEXT_1066 = "!=";
  protected final String TEXT_1067 = "))" + NL + "    {" + NL + "      bool didRemove = ";
  protected final String TEXT_1068 = "->";
  protected final String TEXT_1069 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1070 = NL + "        ";
  protected final String TEXT_1071 = " = ";
  protected final String TEXT_1072 = ";";
  protected final String TEXT_1073 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1074 = NL + "    ";
  protected final String TEXT_1075 = "->";
  protected final String TEXT_1076 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1077 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1078 = NL + "  bool ";
  protected final String TEXT_1079 = "::";
  protected final String TEXT_1080 = "(";
  protected final String TEXT_1081 = "* ";
  protected final String TEXT_1082 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1083 = NL + "    //Must provide ";
  protected final String TEXT_1084 = " to ";
  protected final String TEXT_1085 = NL + "    if (";
  protected final String TEXT_1086 = " == NULL)" + NL + "    {";
  protected final String TEXT_1087 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1088 = " != NULL && ";
  protected final String TEXT_1089 = ".";
  protected final String TEXT_1090 = "() <= ";
  protected final String TEXT_1091 = ".";
  protected final String TEXT_1092 = "())" + NL + "    {";
  protected final String TEXT_1093 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1094 = NL + "    ";
  protected final String TEXT_1095 = "* ";
  protected final String TEXT_1096 = " = ";
  protected final String TEXT_1097 = ";";
  protected final String TEXT_1098 = NL + "    ";
  protected final String TEXT_1099 = " = ";
  protected final String TEXT_1100 = ";" + NL + "    if (";
  protected final String TEXT_1101 = " != NULL && ";
  protected final String TEXT_1102 = "!=";
  protected final String TEXT_1103 = ")" + NL + "    {" + NL + "      bool didRemove = ";
  protected final String TEXT_1104 = "->";
  protected final String TEXT_1105 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1106 = NL + "        ";
  protected final String TEXT_1107 = " = ";
  protected final String TEXT_1108 = ";";
  protected final String TEXT_1109 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1110 = NL + "    ";
  protected final String TEXT_1111 = "->";
  protected final String TEXT_1112 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1113 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1114 = NL + "  bool ";
  protected final String TEXT_1115 = "::";
  protected final String TEXT_1116 = "(";
  protected final String TEXT_1117 = "* ";
  protected final String TEXT_1118 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1119 = NL + "    ";
  protected final String TEXT_1120 = "* ";
  protected final String TEXT_1121 = " = ";
  protected final String TEXT_1122 = "->";
  protected final String TEXT_1123 = "();" + NL + "    if (";
  protected final String TEXT_1124 = " == NULL)" + NL + "    {";
  protected final String TEXT_1125 = NL + "      ";
  protected final String TEXT_1126 = "->";
  protected final String TEXT_1127 = "(this);" + NL + "    }" + NL + "    else if (this!=";
  protected final String TEXT_1128 = ")" + NL + "    {";
  protected final String TEXT_1129 = NL + "      ";
  protected final String TEXT_1130 = "->";
  protected final String TEXT_1131 = "(";
  protected final String TEXT_1132 = ");";
  protected final String TEXT_1133 = NL + "      ";
  protected final String TEXT_1134 = "(";
  protected final String TEXT_1135 = ");" + NL + "    } " + NL + "    else" + NL + "    {";
  protected final String TEXT_1136 = NL + "      ";
  protected final String TEXT_1137 = ".push_back(";
  protected final String TEXT_1138 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1139 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1140 = "::";
  protected final String TEXT_1141 = "(";
  protected final String TEXT_1142 = "* ";
  protected final String TEXT_1143 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1144 = ".begin(), ";
  protected final String TEXT_1145 = ".end(), ";
  protected final String TEXT_1146 = ") - ";
  protected final String TEXT_1147 = ".begin();";
  protected final String TEXT_1148 = NL + "    if (find(";
  protected final String TEXT_1149 = ".begin(),";
  protected final String TEXT_1150 = ".end(),";
  protected final String TEXT_1151 = ")!= ";
  protected final String TEXT_1152 = ".end())" + NL + "    {";
  protected final String TEXT_1153 = NL + "      ";
  protected final String TEXT_1154 = ".erase(find(";
  protected final String TEXT_1155 = ".begin(),";
  protected final String TEXT_1156 = ".end(),";
  protected final String TEXT_1157 = "));";
  protected final String TEXT_1158 = NL + "      ";
  protected final String TEXT_1159 = "->";
  protected final String TEXT_1160 = "(NULL);" + NL + "\t  delete ";
  protected final String TEXT_1161 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1162 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1163 = NL + "  bool ";
  protected final String TEXT_1164 = "::";
  protected final String TEXT_1165 = "(";
  protected final String TEXT_1166 = "* ";
  protected final String TEXT_1167 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1168 = NL + "    ";
  protected final String TEXT_1169 = "* ";
  protected final String TEXT_1170 = " = ";
  protected final String TEXT_1171 = ";";
  protected final String TEXT_1172 = NL + "    ";
  protected final String TEXT_1173 = " = ";
  protected final String TEXT_1174 = ";" + NL + "    if (";
  protected final String TEXT_1175 = " != NULL && ";
  protected final String TEXT_1176 = "!=";
  protected final String TEXT_1177 = ")" + NL + "    {";
  protected final String TEXT_1178 = NL + "      ";
  protected final String TEXT_1179 = "->";
  protected final String TEXT_1180 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1181 = " != NULL)" + NL + "    {";
  protected final String TEXT_1182 = NL + "      ";
  protected final String TEXT_1183 = "->";
  protected final String TEXT_1184 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1185 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1186 = NL + "  bool ";
  protected final String TEXT_1187 = "::";
  protected final String TEXT_1188 = "(";
  protected final String TEXT_1189 = "* ";
  protected final String TEXT_1190 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1191 = NL + "    if (";
  protected final String TEXT_1192 = "() >= ";
  protected final String TEXT_1193 = "())" + NL + "    {";
  protected final String TEXT_1194 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1195 = NL + "    ";
  protected final String TEXT_1196 = " ";
  protected final String TEXT_1197 = " = ";
  protected final String TEXT_1198 = "->";
  protected final String TEXT_1199 = "();" + NL + "    if (";
  protected final String TEXT_1200 = " == NULL)" + NL + "    {";
  protected final String TEXT_1201 = NL + "      ";
  protected final String TEXT_1202 = "->";
  protected final String TEXT_1203 = "(this);" + NL + "    }" + NL + "    else if (this!=";
  protected final String TEXT_1204 = ")" + NL + "    {";
  protected final String TEXT_1205 = NL + "      ";
  protected final String TEXT_1206 = "->";
  protected final String TEXT_1207 = "(";
  protected final String TEXT_1208 = ");";
  protected final String TEXT_1209 = NL + "      ";
  protected final String TEXT_1210 = "(";
  protected final String TEXT_1211 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1212 = NL + "      ";
  protected final String TEXT_1213 = ".push_back(";
  protected final String TEXT_1214 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1215 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1216 = "::";
  protected final String TEXT_1217 = "(";
  protected final String TEXT_1218 = "* ";
  protected final String TEXT_1219 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1220 = ".begin(), ";
  protected final String TEXT_1221 = ".end(), ";
  protected final String TEXT_1222 = ") - ";
  protected final String TEXT_1223 = ".begin();";
  protected final String TEXT_1224 = NL + "    if (find(";
  protected final String TEXT_1225 = ".begin(),";
  protected final String TEXT_1226 = ".end(),";
  protected final String TEXT_1227 = ") != ";
  protected final String TEXT_1228 = ".end())" + NL + "    {";
  protected final String TEXT_1229 = NL + "      ";
  protected final String TEXT_1230 = ".remove(";
  protected final String TEXT_1231 = ");";
  protected final String TEXT_1232 = NL + "      ";
  protected final String TEXT_1233 = "->";
  protected final String TEXT_1234 = "(NULL);" + NL + "\t  delete ";
  protected final String TEXT_1235 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1236 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1237 = NL + "  bool ";
  protected final String TEXT_1238 = "::";
  protected final String TEXT_1239 = "(";
  protected final String TEXT_1240 = " ";
  protected final String TEXT_1241 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1242 = NL + "    if (";
  protected final String TEXT_1243 = "() < ";
  protected final String TEXT_1244 = "())" + NL + "    {";
  protected final String TEXT_1245 = NL + "      ";
  protected final String TEXT_1246 = ".push_back(";
  protected final String TEXT_1247 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1248 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1249 = "::";
  protected final String TEXT_1250 = "(";
  protected final String TEXT_1251 = "* ";
  protected final String TEXT_1252 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1253 = ".begin(), ";
  protected final String TEXT_1254 = ".end(), ";
  protected final String TEXT_1255 = ") - ";
  protected final String TEXT_1256 = ".begin();";
  protected final String TEXT_1257 = NL + "    if (!find(";
  protected final String TEXT_1258 = ".begin(),";
  protected final String TEXT_1259 = ".end(),";
  protected final String TEXT_1260 = ") != ";
  protected final String TEXT_1261 = ".end())" + NL + "    {";
  protected final String TEXT_1262 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1263 = "() <= ";
  protected final String TEXT_1264 = "())" + NL + "    {";
  protected final String TEXT_1265 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1266 = NL + "    ";
  protected final String TEXT_1267 = ".erase(find(";
  protected final String TEXT_1268 = ".begin(),";
  protected final String TEXT_1269 = ".end(),";
  protected final String TEXT_1270 = "));" + NL + "\tdelete ";
  protected final String TEXT_1271 = "[index];" + NL + "    wasRemoved = true;";
  protected final String TEXT_1272 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1273 = NL + "  bool ";
  protected final String TEXT_1274 = "::";
  protected final String TEXT_1275 = "(";
  protected final String TEXT_1276 = "* ";
  protected final String TEXT_1277 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1278 = NL + "    if (";
  protected final String TEXT_1279 = "() >= ";
  protected final String TEXT_1280 = "())" + NL + "    {";
  protected final String TEXT_1281 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1282 = NL + "    ";
  protected final String TEXT_1283 = " ";
  protected final String TEXT_1284 = " = ";
  protected final String TEXT_1285 = "->";
  protected final String TEXT_1286 = "();" + NL + "    if (";
  protected final String TEXT_1287 = " != NULL && ";
  protected final String TEXT_1288 = "->";
  protected final String TEXT_1289 = "() <= ";
  protected final String TEXT_1290 = "())" + NL + "    {";
  protected final String TEXT_1291 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1292 = " != null)" + NL + "    {";
  protected final String TEXT_1293 = NL + "      ";
  protected final String TEXT_1294 = ".";
  protected final String TEXT_1295 = ".erase(find(";
  protected final String TEXT_1296 = ".begin(),";
  protected final String TEXT_1297 = ".end(),";
  protected final String TEXT_1298 = "));" + NL + "    }";
  protected final String TEXT_1299 = NL + "    ";
  protected final String TEXT_1300 = ".push_back(";
  protected final String TEXT_1301 = ");";
  protected final String TEXT_1302 = NL + "    ";
  protected final String TEXT_1303 = "(";
  protected final String TEXT_1304 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1305 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1306 = "::";
  protected final String TEXT_1307 = "(";
  protected final String TEXT_1308 = "* ";
  protected final String TEXT_1309 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1310 = ".begin(), ";
  protected final String TEXT_1311 = ".end(), ";
  protected final String TEXT_1312 = ") - ";
  protected final String TEXT_1313 = ".begin();";
  protected final String TEXT_1314 = NL + "    if ((find(";
  protected final String TEXT_1315 = ".begin(),";
  protected final String TEXT_1316 = ".end(),";
  protected final String TEXT_1317 = ") !=";
  protected final String TEXT_1318 = ".end()) && ";
  protected final String TEXT_1319 = "() > ";
  protected final String TEXT_1320 = "())" + NL + "    {";
  protected final String TEXT_1321 = NL + "      ";
  protected final String TEXT_1322 = ".erase(find(";
  protected final String TEXT_1323 = ".begin(),";
  protected final String TEXT_1324 = ".end(),";
  protected final String TEXT_1325 = "));";
  protected final String TEXT_1326 = NL + "      ";
  protected final String TEXT_1327 = "(";
  protected final String TEXT_1328 = ",NULL);" + NL + "\t  delete ";
  protected final String TEXT_1329 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1330 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1331 = NL + "  bool ";
  protected final String TEXT_1332 = "::";
  protected final String TEXT_1333 = "(";
  protected final String TEXT_1334 = "... ";
  protected final String TEXT_1335 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1336 = NL + "    vector<";
  protected final String TEXT_1337 = "*> ";
  protected final String TEXT_1338 = ";" + NL + "\t" + NL + "    for (";
  protected final String TEXT_1339 = " ";
  protected final String TEXT_1340 = " : ";
  protected final String TEXT_1341 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1342 = ".begin(),";
  protected final String TEXT_1343 = ".end(),";
  protected final String TEXT_1344 = ") != ";
  protected final String TEXT_1345 = ".end())" + NL + "      {";
  protected final String TEXT_1346 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1347 = ".";
  protected final String TEXT_1348 = "() != NULL && this!=(";
  protected final String TEXT_1349 = "->";
  protected final String TEXT_1350 = "()))" + NL + "      {";
  protected final String TEXT_1351 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1352 = NL + "      ";
  protected final String TEXT_1353 = ".push_back(";
  protected final String TEXT_1354 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1355 = ".size() != ";
  protected final String TEXT_1356 = "())" + NL + "    {";
  protected final String TEXT_1357 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1358 = NL + "    ";
  protected final String TEXT_1359 = ".removeAll(";
  protected final String TEXT_1360 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1361 = " orphan : ";
  protected final String TEXT_1362 = ")" + NL + "    {";
  protected final String TEXT_1363 = NL + "      ";
  protected final String TEXT_1364 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1365 = NL + "    ";
  protected final String TEXT_1366 = ".clear();" + NL + "    for (";
  protected final String TEXT_1367 = " ";
  protected final String TEXT_1368 = " : ";
  protected final String TEXT_1369 = ")" + NL + "    {";
  protected final String TEXT_1370 = NL + "      ";
  protected final String TEXT_1371 = "(";
  protected final String TEXT_1372 = ", this);";
  protected final String TEXT_1373 = NL + "      ";
  protected final String TEXT_1374 = ".push_back(";
  protected final String TEXT_1375 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1376 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1377 = NL + "  void ";
  protected final String TEXT_1378 = "::";
  protected final String TEXT_1379 = "(";
  protected final String TEXT_1380 = " ";
  protected final String TEXT_1381 = ", ";
  protected final String TEXT_1382 = " ";
  protected final String TEXT_1383 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1384 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1385 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1386 = ", ";
  protected final String TEXT_1387 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1388 = " to ";
  protected final String TEXT_1389 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1390 = NL + "  bool ";
  protected final String TEXT_1391 = "::";
  protected final String TEXT_1392 = "(";
  protected final String TEXT_1393 = " ";
  protected final String TEXT_1394 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1395 = NL + "    ";
  protected final String TEXT_1396 = ".push_back(";
  protected final String TEXT_1397 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1398 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1399 = "::";
  protected final String TEXT_1400 = "(";
  protected final String TEXT_1401 = "* ";
  protected final String TEXT_1402 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1403 = ".begin(), ";
  protected final String TEXT_1404 = ".end(), ";
  protected final String TEXT_1405 = ") - ";
  protected final String TEXT_1406 = ".begin();";
  protected final String TEXT_1407 = NL + "    if (find(";
  protected final String TEXT_1408 = ".begin(),";
  protected final String TEXT_1409 = ".end(),";
  protected final String TEXT_1410 = ") != ";
  protected final String TEXT_1411 = ".end())" + NL + "    {";
  protected final String TEXT_1412 = NL + "      ";
  protected final String TEXT_1413 = ".erase(find(";
  protected final String TEXT_1414 = ".begin(),";
  protected final String TEXT_1415 = ".end(),";
  protected final String TEXT_1416 = "));" + NL + "\t  delete ";
  protected final String TEXT_1417 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1418 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1419 = NL + "  bool ";
  protected final String TEXT_1420 = "::";
  protected final String TEXT_1421 = "(";
  protected final String TEXT_1422 = "* ";
  protected final String TEXT_1423 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1424 = NL + "    if (";
  protected final String TEXT_1425 = "() < ";
  protected final String TEXT_1426 = "())" + NL + "    {";
  protected final String TEXT_1427 = NL + "      ";
  protected final String TEXT_1428 = ".push_back(";
  protected final String TEXT_1429 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1430 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1431 = "::";
  protected final String TEXT_1432 = "(";
  protected final String TEXT_1433 = "* ";
  protected final String TEXT_1434 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1435 = ".begin(), ";
  protected final String TEXT_1436 = ".end(), ";
  protected final String TEXT_1437 = ") - ";
  protected final String TEXT_1438 = ".begin();";
  protected final String TEXT_1439 = NL + "    if (find(";
  protected final String TEXT_1440 = ".begin(),";
  protected final String TEXT_1441 = ".end(),";
  protected final String TEXT_1442 = ") != ";
  protected final String TEXT_1443 = ".end())" + NL + "    {";
  protected final String TEXT_1444 = NL + "      ";
  protected final String TEXT_1445 = ".erase(";
  protected final String TEXT_1446 = ");" + NL + "\t  delete ";
  protected final String TEXT_1447 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1448 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1449 = NL + "  bool ";
  protected final String TEXT_1450 = "::";
  protected final String TEXT_1451 = "(";
  protected final String TEXT_1452 = "* ";
  protected final String TEXT_1453 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1454 = NL + "    ";
  protected final String TEXT_1455 = ".push_back(";
  protected final String TEXT_1456 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1457 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1458 = "::";
  protected final String TEXT_1459 = "(";
  protected final String TEXT_1460 = "* ";
  protected final String TEXT_1461 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1462 = ".begin(), ";
  protected final String TEXT_1463 = ".end(), ";
  protected final String TEXT_1464 = ") - ";
  protected final String TEXT_1465 = ".begin();";
  protected final String TEXT_1466 = NL + "    if (!find(";
  protected final String TEXT_1467 = ".begin(),";
  protected final String TEXT_1468 = ".end(),";
  protected final String TEXT_1469 = ") != ";
  protected final String TEXT_1470 = ".end())" + NL + "    {";
  protected final String TEXT_1471 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1472 = "() <= ";
  protected final String TEXT_1473 = "())" + NL + "    {";
  protected final String TEXT_1474 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1475 = NL + "    ";
  protected final String TEXT_1476 = ".erase(find(";
  protected final String TEXT_1477 = ".begin(),";
  protected final String TEXT_1478 = ".end(),";
  protected final String TEXT_1479 = "));" + NL + "    delete ";
  protected final String TEXT_1480 = "[index];" + NL + "\twasRemoved = true;";
  protected final String TEXT_1481 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1482 = NL + "  bool ";
  protected final String TEXT_1483 = "::";
  protected final String TEXT_1484 = "(";
  protected final String TEXT_1485 = "... ";
  protected final String TEXT_1486 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1487 = NL + "    vector<";
  protected final String TEXT_1488 = "*> ";
  protected final String TEXT_1489 = ";" + NL + "    for (";
  protected final String TEXT_1490 = " ";
  protected final String TEXT_1491 = " : ";
  protected final String TEXT_1492 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1493 = ".begin(),";
  protected final String TEXT_1494 = ".end(),";
  protected final String TEXT_1495 = ") != ";
  protected final String TEXT_1496 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1497 = NL + "      ";
  protected final String TEXT_1498 = ".push_back(";
  protected final String TEXT_1499 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1500 = ".size() != ";
  protected final String TEXT_1501 = ".size() || ";
  protected final String TEXT_1502 = ".size() != ";
  protected final String TEXT_1503 = "())" + NL + "    {";
  protected final String TEXT_1504 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1505 = NL + "    ";
  protected final String TEXT_1506 = ".clear();" + NL + "    for (int i=0; i<";
  protected final String TEXT_1507 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1508 = ".push_back(";
  protected final String TEXT_1509 = "[i]);" + NL + "\t}" + NL + "    wasSet = true;";
  protected final String TEXT_1510 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1511 = NL + "  ";
  protected final String TEXT_1512 = " bool ";
  protected final String TEXT_1513 = "(";
  protected final String TEXT_1514 = "... ";
  protected final String TEXT_1515 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1516 = NL + "    vector<";
  protected final String TEXT_1517 = "*> ";
  protected final String TEXT_1518 = ";" + NL + "    for (int i=0 ; i<";
  protected final String TEXT_1519 = ".size() ; i++)" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1520 = ".begin(),";
  protected final String TEXT_1521 = ".end(),(";
  protected final String TEXT_1522 = ") != ";
  protected final String TEXT_1523 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1524 = NL + "      ";
  protected final String TEXT_1525 = ".push_back(";
  protected final String TEXT_1526 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1527 = ".size() != ";
  protected final String TEXT_1528 = ".length)" + NL + "    {";
  protected final String TEXT_1529 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1530 = NL + "    ";
  protected final String TEXT_1531 = ".clear();";
  protected final String TEXT_1532 = NL + "    ";
  protected final String TEXT_1533 = ".addAll(";
  protected final String TEXT_1534 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1535 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1536 = NL + "  bool ";
  protected final String TEXT_1537 = "::";
  protected final String TEXT_1538 = "(";
  protected final String TEXT_1539 = " ";
  protected final String TEXT_1540 = ")" + NL + "  {" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "    // THIS TEMPLATE IS EXPERIMENTAL" + NL + "    //   I cut/Paste from UmpleToJava/templates/association_SetOptionalOneToMandatoryMany.jet" + NL + "    //   and then converted to cpp. " + NL + "    //" + NL + "    bool wasSet = false;";
  protected final String TEXT_1541 = NL + "    ";
  protected final String TEXT_1542 = " *";
  protected final String TEXT_1543 = " = ";
  protected final String TEXT_1544 = ";" + NL + "\t" + NL + "    if (";
  protected final String TEXT_1545 = " == NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1546 = " != NULL)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1547 = "->";
  protected final String TEXT_1548 = "(this))" + NL + "        {";
  protected final String TEXT_1549 = NL + "          ";
  protected final String TEXT_1550 = " = ";
  protected final String TEXT_1551 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if (";
  protected final String TEXT_1552 = " != NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1553 = " == NULL)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1554 = "->";
  protected final String TEXT_1555 = "() < ";
  protected final String TEXT_1556 = "->";
  protected final String TEXT_1557 = "())" + NL + "        {";
  protected final String TEXT_1558 = NL + "          ";
  protected final String TEXT_1559 = "->";
  protected final String TEXT_1560 = "(this);";
  protected final String TEXT_1561 = NL + "          ";
  protected final String TEXT_1562 = " = ";
  protected final String TEXT_1563 = ";  // ";
  protected final String TEXT_1564 = " == NULL" + NL + "          wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1565 = "->";
  protected final String TEXT_1566 = "() < ";
  protected final String TEXT_1567 = "->";
  protected final String TEXT_1568 = "())" + NL + "        {";
  protected final String TEXT_1569 = NL + "          ";
  protected final String TEXT_1570 = "->";
  protected final String TEXT_1571 = "(this);";
  protected final String TEXT_1572 = NL + "          ";
  protected final String TEXT_1573 = "->";
  protected final String TEXT_1574 = "(this);";
  protected final String TEXT_1575 = NL + "          ";
  protected final String TEXT_1576 = " = ";
  protected final String TEXT_1577 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if (wasSet)" + NL + "    {";
  protected final String TEXT_1578 = NL + "      ";
  protected final String TEXT_1579 = " = ";
  protected final String TEXT_1580 = ";" + NL + "    }" + NL + "    return wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_1581 = NL + "//  bool ";
  protected final String TEXT_1582 = "::";
  protected final String TEXT_1583 = "(";
  protected final String TEXT_1584 = " ";
  protected final String TEXT_1585 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_1586 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//    // THIS TEMPLATE IS EXPERIMENTAL" + NL + "//    //   I cut/Paste from UmpleToJava/templates/association_SetOptionalOneToMandatoryMany.jet" + NL + "//    //   and then converted to cpp. " + NL + "//    //" + NL + "//" + NL + "//    bool wasSet = false;" + NL + "//    ";
  protected final String TEXT_1587 = " *";
  protected final String TEXT_1588 = " = ";
  protected final String TEXT_1589 = ";" + NL + "//\t" + NL + "//    if (";
  protected final String TEXT_1590 = " == null)" + NL + "//    {  " + NL + "//      if (";
  protected final String TEXT_1591 = " != null)" + NL + "//      { " + NL + "//        if (";
  protected final String TEXT_1592 = "->";
  protected final String TEXT_1593 = "(this))" + NL + "//          ";
  protected final String TEXT_1594 = " = ";
  protected final String TEXT_1595 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    else" + NL + "//    {" + NL + "//      if (";
  protected final String TEXT_1596 = " != null)" + NL + "//      {" + NL + "//        if (";
  protected final String TEXT_1597 = " == null)" + NL + "//        {" + NL + "//          if (";
  protected final String TEXT_1598 = "->";
  protected final String TEXT_1599 = " < ";
  protected final String TEXT_1600 = ".";
  protected final String TEXT_1601 = ")" + NL + "//            ";
  protected final String TEXT_1602 = "->";
  protected final String TEXT_1603 = "(this);" + NL + "//            ";
  protected final String TEXT_1604 = " = ";
  protected final String TEXT_1605 = "  // ";
  protected final String TEXT_1606 = " == null;" + NL + "//            wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//      else" + NL + "//      {" + NL + "//        if (   ";
  protected final String TEXT_1607 = "->";
  protected final String TEXT_1608 = " < ";
  protected final String TEXT_1609 = "->";
  protected final String TEXT_1610 = "()" + NL + "//            && ";
  protected final String TEXT_1611 = ".";
  protected final String TEXT_1612 = " > ";
  protected final String TEXT_1613 = "->";
  protected final String TEXT_1614 = "()" + NL + "//           )" + NL + "//          ";
  protected final String TEXT_1615 = "->";
  protected final String TEXT_1616 = "(this);" + NL + "//          ";
  protected final String TEXT_1617 = "->";
  protected final String TEXT_1618 = "(this);" + NL + "//          ";
  protected final String TEXT_1619 = " = ";
  protected final String TEXT_1620 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    " + NL + "//    if (wasSet)" + NL + "//    {" + NL + "//      ";
  protected final String TEXT_1621 = " = ";
  protected final String TEXT_1622 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return wasSet;" + NL + "//  }";
  protected final String TEXT_1623 = NL + "  bool ";
  protected final String TEXT_1624 = "::";
  protected final String TEXT_1625 = "(";
  protected final String TEXT_1626 = "... ";
  protected final String TEXT_1627 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1628 = NL + "    vector<";
  protected final String TEXT_1629 = "*> ";
  protected final String TEXT_1630 = ";" + NL + "    for (";
  protected final String TEXT_1631 = " ";
  protected final String TEXT_1632 = " : ";
  protected final String TEXT_1633 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1634 = ".begin(),";
  protected final String TEXT_1635 = ".end(),";
  protected final String TEXT_1636 = ")!= ";
  protected final String TEXT_1637 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1638 = NL + "      ";
  protected final String TEXT_1639 = "push_back(";
  protected final String TEXT_1640 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1641 = ".size() != ";
  protected final String TEXT_1642 = ".length || ";
  protected final String TEXT_1643 = ".size() < ";
  protected final String TEXT_1644 = "() || ";
  protected final String TEXT_1645 = ".size() > ";
  protected final String TEXT_1646 = "())" + NL + "    {";
  protected final String TEXT_1647 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1648 = "*> ";
  protected final String TEXT_1649 = " = new vector<";
  protected final String TEXT_1650 = "*>(";
  protected final String TEXT_1651 = ");";
  protected final String TEXT_1652 = NL + "    ";
  protected final String TEXT_1653 = ".clear();" + NL + "    for (";
  protected final String TEXT_1654 = " ";
  protected final String TEXT_1655 = " : ";
  protected final String TEXT_1656 = ")" + NL + "    {";
  protected final String TEXT_1657 = NL + "      ";
  protected final String TEXT_1658 = ".push_back(";
  protected final String TEXT_1659 = ");" + NL + "      if (find(";
  protected final String TEXT_1660 = ".begin(),";
  protected final String TEXT_1661 = ".end(),";
  protected final String TEXT_1662 = ")!= ";
  protected final String TEXT_1663 = ".end())" + NL + "      {";
  protected final String TEXT_1664 = NL + "        ";
  protected final String TEXT_1665 = ".erase(find(";
  protected final String TEXT_1666 = ".begin(),";
  protected final String TEXT_1667 = ".end(),";
  protected final String TEXT_1668 = "));" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1669 = NL + "        ";
  protected final String TEXT_1670 = "->";
  protected final String TEXT_1671 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1672 = " ";
  protected final String TEXT_1673 = " : ";
  protected final String TEXT_1674 = ")" + NL + "    {";
  protected final String TEXT_1675 = NL + "      ";
  protected final String TEXT_1676 = ".";
  protected final String TEXT_1677 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1678 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1679 = NL + "  bool ";
  protected final String TEXT_1680 = "::";
  protected final String TEXT_1681 = "(";
  protected final String TEXT_1682 = "... ";
  protected final String TEXT_1683 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1684 = NL + "    vector<";
  protected final String TEXT_1685 = "*> ";
  protected final String TEXT_1686 = ";" + NL + "\t" + NL + "    for (";
  protected final String TEXT_1687 = " ";
  protected final String TEXT_1688 = " : ";
  protected final String TEXT_1689 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1690 = ".begin(),";
  protected final String TEXT_1691 = ".end(),";
  protected final String TEXT_1692 = ") != ";
  protected final String TEXT_1693 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1694 = NL + "      ";
  protected final String TEXT_1695 = ".push_back(";
  protected final String TEXT_1696 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1697 = ".size() != ";
  protected final String TEXT_1698 = ".length || ";
  protected final String TEXT_1699 = ".size() < ";
  protected final String TEXT_1700 = "())" + NL + "    {";
  protected final String TEXT_1701 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1702 = "*> ";
  protected final String TEXT_1703 = ";";
  protected final String TEXT_1704 = NL + "    ";
  protected final String TEXT_1705 = ".clear();" + NL + "    for (";
  protected final String TEXT_1706 = " ";
  protected final String TEXT_1707 = " : ";
  protected final String TEXT_1708 = ")" + NL + "    {";
  protected final String TEXT_1709 = NL + "      ";
  protected final String TEXT_1710 = ".push_back(";
  protected final String TEXT_1711 = ");" + NL + "      if (find(";
  protected final String TEXT_1712 = ".begin(),";
  protected final String TEXT_1713 = ".end(),";
  protected final String TEXT_1714 = ")) != ";
  protected final String TEXT_1715 = ".end())" + NL + "      {";
  protected final String TEXT_1716 = NL + "        ";
  protected final String TEXT_1717 = ".erase(";
  protected final String TEXT_1718 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1719 = NL + "        ";
  protected final String TEXT_1720 = "->";
  protected final String TEXT_1721 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1722 = " ";
  protected final String TEXT_1723 = " : ";
  protected final String TEXT_1724 = ")" + NL + "    {";
  protected final String TEXT_1725 = NL + "      ";
  protected final String TEXT_1726 = "->";
  protected final String TEXT_1727 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1728 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1729 = NL + "  bool ";
  protected final String TEXT_1730 = "::";
  protected final String TEXT_1731 = "(";
  protected final String TEXT_1732 = "... ";
  protected final String TEXT_1733 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1734 = NL + "    vector<";
  protected final String TEXT_1735 = "*> ";
  protected final String TEXT_1736 = ";" + NL + "    for (";
  protected final String TEXT_1737 = " ";
  protected final String TEXT_1738 = " : ";
  protected final String TEXT_1739 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1740 = ".begin(),";
  protected final String TEXT_1741 = ".end(),";
  protected final String TEXT_1742 = ") != ";
  protected final String TEXT_1743 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1744 = NL + "      ";
  protected final String TEXT_1745 = "->add(";
  protected final String TEXT_1746 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1747 = ".size() != ";
  protected final String TEXT_1748 = ".size() || ";
  protected final String TEXT_1749 = ".size() < ";
  protected final String TEXT_1750 = "() || ";
  protected final String TEXT_1751 = ".size() > ";
  protected final String TEXT_1752 = "())" + NL + "    {";
  protected final String TEXT_1753 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1754 = NL + "    ";
  protected final String TEXT_1755 = ".clear();" + NL + "\tfor (int i=0; i<";
  protected final String TEXT_1756 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1757 = ".push_back(";
  protected final String TEXT_1758 = "[i]);" + NL + "\t}" + NL + "    " + NL + "    wasSet = true;";
  protected final String TEXT_1759 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1760 = NL + "  bool ";
  protected final String TEXT_1761 = "::";
  protected final String TEXT_1762 = "(";
  protected final String TEXT_1763 = "... ";
  protected final String TEXT_1764 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1765 = NL + "    if (";
  protected final String TEXT_1766 = ".length < ";
  protected final String TEXT_1767 = "()";
  protected final String TEXT_1768 = ")" + NL + "    {";
  protected final String TEXT_1769 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1770 = "*> ";
  protected final String TEXT_1771 = ";" + NL + "\t" + NL + "    map<";
  protected final String TEXT_1772 = ",int> ";
  protected final String TEXT_1773 = ";" + NL + "    for (";
  protected final String TEXT_1774 = " ";
  protected final String TEXT_1775 = " : ";
  protected final String TEXT_1776 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1777 = ".begin(),";
  protected final String TEXT_1778 = ".end(),";
  protected final String TEXT_1779 = ") != ";
  protected final String TEXT_1780 = ".end())" + NL + "      {";
  protected final String TEXT_1781 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1782 = "->";
  protected final String TEXT_1783 = "() != NULL && this!=";
  protected final String TEXT_1784 = "->";
  protected final String TEXT_1785 = "())" + NL + "      {";
  protected final String TEXT_1786 = NL + "        ";
  protected final String TEXT_1787 = "* ";
  protected final String TEXT_1788 = " = ";
  protected final String TEXT_1789 = ".";
  protected final String TEXT_1790 = "();" + NL + "        if (!";
  protected final String TEXT_1791 = ".find(";
  protected final String TEXT_1792 = "))" + NL + "        {";
  protected final String TEXT_1793 = NL + "          ";
  protected final String TEXT_1794 = ".insert(";
  protected final String TEXT_1795 = ", new int(";
  protected final String TEXT_1796 = "->";
  protected final String TEXT_1797 = "()));" + NL + "        }" + NL + "        int currentCount = ";
  protected final String TEXT_1798 = ".find(";
  protected final String TEXT_1799 = ")->firtst;" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_1800 = ")" + NL + "        {";
  protected final String TEXT_1801 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_1802 = NL + "        ";
  protected final String TEXT_1803 = ".insert(";
  protected final String TEXT_1804 = ", new int(nextCount));" + NL + "      }";
  protected final String TEXT_1805 = NL + "      ";
  protected final String TEXT_1806 = ".push_back(";
  protected final String TEXT_1807 = ");" + NL + "    }" + NL;
  protected final String TEXT_1808 = NL + "    ";
  protected final String TEXT_1809 = ".removeAll(";
  protected final String TEXT_1810 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_1811 = " orphan : ";
  protected final String TEXT_1812 = ")" + NL + "    {";
  protected final String TEXT_1813 = NL + "      ";
  protected final String TEXT_1814 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1815 = NL + "    ";
  protected final String TEXT_1816 = ".clear();" + NL + "    for (";
  protected final String TEXT_1817 = " ";
  protected final String TEXT_1818 = " : ";
  protected final String TEXT_1819 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1820 = ".";
  protected final String TEXT_1821 = "() != null)" + NL + "      {";
  protected final String TEXT_1822 = NL + "        ";
  protected final String TEXT_1823 = ".";
  protected final String TEXT_1824 = "()->";
  protected final String TEXT_1825 = ".erase(";
  protected final String TEXT_1826 = ");" + NL + "      }";
  protected final String TEXT_1827 = NL + "      ";
  protected final String TEXT_1828 = "(";
  protected final String TEXT_1829 = ", this);";
  protected final String TEXT_1830 = NL + "      ";
  protected final String TEXT_1831 = ".push_back(";
  protected final String TEXT_1832 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1833 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1834 = NL + "  void ";
  protected final String TEXT_1835 = "::";
  protected final String TEXT_1836 = "(";
  protected final String TEXT_1837 = " ";
  protected final String TEXT_1838 = ", ";
  protected final String TEXT_1839 = " ";
  protected final String TEXT_1840 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1841 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1842 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1843 = ", ";
  protected final String TEXT_1844 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1845 = " to ";
  protected final String TEXT_1846 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1847 = NL + "  bool ";
  protected final String TEXT_1848 = "::";
  protected final String TEXT_1849 = "(";
  protected final String TEXT_1850 = "... ";
  protected final String TEXT_1851 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1852 = NL + "    vector<";
  protected final String TEXT_1853 = "*> ";
  protected final String TEXT_1854 = ";" + NL + "    for (";
  protected final String TEXT_1855 = " ";
  protected final String TEXT_1856 = " : ";
  protected final String TEXT_1857 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1858 = ".begin(),";
  protected final String TEXT_1859 = ".end(),(";
  protected final String TEXT_1860 = ")) - ";
  protected final String TEXT_1861 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1862 = NL + "      ";
  protected final String TEXT_1863 = ".push_back(";
  protected final String TEXT_1864 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1865 = ".size() != ";
  protected final String TEXT_1866 = ".size() || ";
  protected final String TEXT_1867 = ".size() > ";
  protected final String TEXT_1868 = "())" + NL + "    {";
  protected final String TEXT_1869 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1870 = NL + "    ";
  protected final String TEXT_1871 = ".clear();" + NL + "    for (int i=0; i<";
  protected final String TEXT_1872 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1873 = ".push_back(";
  protected final String TEXT_1874 = "[i]);" + NL + "\t}" + NL + "    wasSet = true;";
  protected final String TEXT_1875 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1876 = NL + "  bool ";
  protected final String TEXT_1877 = "::";
  protected final String TEXT_1878 = "(";
  protected final String TEXT_1879 = "... ";
  protected final String TEXT_1880 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1881 = NL + "    vector<";
  protected final String TEXT_1882 = "*> ";
  protected final String TEXT_1883 = ";" + NL + "    for (";
  protected final String TEXT_1884 = " ";
  protected final String TEXT_1885 = " : ";
  protected final String TEXT_1886 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1887 = ".begin(),";
  protected final String TEXT_1888 = ".end(),";
  protected final String TEXT_1889 = ") != ";
  protected final String TEXT_1890 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1891 = NL + "      ";
  protected final String TEXT_1892 = "->add(";
  protected final String TEXT_1893 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1894 = ".size() != ";
  protected final String TEXT_1895 = ".size() || ";
  protected final String TEXT_1896 = ".size() < ";
  protected final String TEXT_1897 = "())" + NL + "    {";
  protected final String TEXT_1898 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1899 = NL + "    ";
  protected final String TEXT_1900 = ".clear();" + NL + "    for (int i=0; i<";
  protected final String TEXT_1901 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1902 = ".push_back(";
  protected final String TEXT_1903 = "[i]);" + NL + "\t}" + NL + "\t" + NL + "    wasSet = true;";
  protected final String TEXT_1904 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1905 = NL + "  bool equals(Object obj)" + NL + "  {" + NL + "    if (obj == NULL) { return false; }" + NL + "    if (getClass() != obj.getClass()) { return false; }" + NL;
  protected final String TEXT_1906 = NL + "    ";
  protected final String TEXT_1907 = " == (";
  protected final String TEXT_1908 = ")obj;" + NL + "  " + NL + "    return true;" + NL + "  }" + NL + "" + NL + " int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_1909 = NL + "    ";
  protected final String TEXT_1910 = NL;
  protected final String TEXT_1911 = NL + "    ";
  protected final String TEXT_1912 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1913 = NL + "   void ";
  protected final String TEXT_1914 = "::";
  protected final String TEXT_1915 = "()" + NL + "  {" + NL + "     try" + NL + "     {";
  protected final String TEXT_1916 = NL + "       ";
  protected final String TEXT_1917 = NL + "     }" + NL + "     catch (InterruptedException e)" + NL + "     {" + NL + " " + NL + "     }" + NL + "  }" + NL;
  protected final String TEXT_1918 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1919 = NL + "    ";
  protected final String TEXT_1920 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1921 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_1922 = NL + "      ";
  protected final String TEXT_1923 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1924 = NL + "  void ";
  protected final String TEXT_1925 = "();" + NL + "  void ";
  protected final String TEXT_1926 = "();" + NL + "  " + NL + NL;
  protected final String TEXT_1927 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1928 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1929 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void ";
  protected final String TEXT_1930 = "::stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void ";
  protected final String TEXT_1931 = "::run ()" + NL + "    {";
  protected final String TEXT_1932 = NL + "      if (\"";
  protected final String TEXT_1933 = "\" == timeoutMethodName)" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1934 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1935 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1936 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1937 = NL + "  " + NL + "  //------------------------" + NL + "  // DESTRUCTOR" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1938 = NL + "    ";
  protected final String TEXT_1939 = " = NULL;" + NL + "    delete ";
  protected final String TEXT_1940 = ";";
  protected final String TEXT_1941 = NL + "    ";
  protected final String TEXT_1942 = ".clear();";
  protected final String TEXT_1943 = NL + "    ";
  protected final String TEXT_1944 = " ";
  protected final String TEXT_1945 = " = ";
  protected final String TEXT_1946 = ";";
  protected final String TEXT_1947 = NL + "    ";
  protected final String TEXT_1948 = " = NULL;" + NL + "    if (";
  protected final String TEXT_1949 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1950 = ";" + NL + "    }";
  protected final String TEXT_1951 = NL + "    if (";
  protected final String TEXT_1952 = " != NULL)" + NL + "    {";
  protected final String TEXT_1953 = NL + "      ";
  protected final String TEXT_1954 = "->";
  protected final String TEXT_1955 = "(NULL);" + NL + "    }";
  protected final String TEXT_1956 = NL + "    ";
  protected final String TEXT_1957 = " ";
  protected final String TEXT_1958 = " = ";
  protected final String TEXT_1959 = ";";
  protected final String TEXT_1960 = NL + "    ";
  protected final String TEXT_1961 = " = NULL;" + NL + "    if (";
  protected final String TEXT_1962 = " != NULL)" + NL + "    {";
  protected final String TEXT_1963 = NL + "      ";
  protected final String TEXT_1964 = "->";
  protected final String TEXT_1965 = "(NULL);" + NL + "    }";
  protected final String TEXT_1966 = NL + "    ";
  protected final String TEXT_1967 = "* ";
  protected final String TEXT_1968 = " = ";
  protected final String TEXT_1969 = ";";
  protected final String TEXT_1970 = NL + "    ";
  protected final String TEXT_1971 = " = NULL;" + NL + "    if (";
  protected final String TEXT_1972 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1973 = ";" + NL + "    }";
  protected final String TEXT_1974 = NL + "    if (";
  protected final String TEXT_1975 = " != NULL)" + NL + "    {";
  protected final String TEXT_1976 = NL + "      ";
  protected final String TEXT_1977 = "* ";
  protected final String TEXT_1978 = " = ";
  protected final String TEXT_1979 = ";" + NL + "      this->";
  protected final String TEXT_1980 = " = NULL;";
  protected final String TEXT_1981 = NL + "      ";
  protected final String TEXT_1982 = "->";
  protected final String TEXT_1983 = "(this);" + NL + "    }" + NL;
  protected final String TEXT_1984 = NL + "    if (";
  protected final String TEXT_1985 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1986 = ";" + NL + "    }";
  protected final String TEXT_1987 = NL + "    if (";
  protected final String TEXT_1988 = " != NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1989 = ".";
  protected final String TEXT_1990 = "() <= ";
  protected final String TEXT_1991 = ")" + NL + "      {" + NL + "        delete ";
  protected final String TEXT_1992 = ";" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1993 = NL + "        ";
  protected final String TEXT_1994 = "* ";
  protected final String TEXT_1995 = " = ";
  protected final String TEXT_1996 = ";" + NL + "        this.";
  protected final String TEXT_1997 = " = NULL;";
  protected final String TEXT_1998 = NL + "        ";
  protected final String TEXT_1999 = "->";
  protected final String TEXT_2000 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2001 = NL + "    ";
  protected final String TEXT_2002 = " ";
  protected final String TEXT_2003 = " = ";
  protected final String TEXT_2004 = ";" + NL + "    this->";
  protected final String TEXT_2005 = " = NULL;";
  protected final String TEXT_2006 = NL + "    ";
  protected final String TEXT_2007 = "->";
  protected final String TEXT_2008 = "(this);";
  protected final String TEXT_2009 = NL + "    for(i =0; sizeof(";
  protected final String TEXT_2010 = "); i++)" + NL + "    {";
  protected final String TEXT_2011 = NL + "      ";
  protected final String TEXT_2012 = "(";
  protected final String TEXT_2013 = "[i],NULL);" + NL + "    }";
  protected final String TEXT_2014 = NL + "    ";
  protected final String TEXT_2015 = ".clear();";
  protected final String TEXT_2016 = NL + "    vector<";
  protected final String TEXT_2017 = "*> ";
  protected final String TEXT_2018 = " = ";
  protected final String TEXT_2019 = ";";
  protected final String TEXT_2020 = NL + "    ";
  protected final String TEXT_2021 = ".clear();" + NL + "    for(i =0; sizeof(";
  protected final String TEXT_2022 = "); i++)" + NL + "     {" + NL + "      if (";
  protected final String TEXT_2023 = ".";
  protected final String TEXT_2024 = "() <= ";
  protected final String TEXT_2025 = "->";
  protected final String TEXT_2026 = "())" + NL + "      {" + NL + "        delete ";
  protected final String TEXT_2027 = "[i];" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2028 = NL + "        ";
  protected final String TEXT_2029 = "->";
  protected final String TEXT_2030 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2031 = NL + "    vector<";
  protected final String TEXT_2032 = "*> ";
  protected final String TEXT_2033 = " = ";
  protected final String TEXT_2034 = ";";
  protected final String TEXT_2035 = NL + "    ";
  protected final String TEXT_2036 = ".clear();" + NL + "    for(i=0;sizeof(";
  protected final String TEXT_2037 = ");i++)" + NL + "    {";
  protected final String TEXT_2038 = NL + "      ";
  protected final String TEXT_2039 = "[i]->";
  protected final String TEXT_2040 = "(this);" + NL + "    }";
  protected final String TEXT_2041 = NL + "    for(i =0; sizeof(";
  protected final String TEXT_2042 = "); i++)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_2043 = "[i];" + NL + "    }";
  protected final String TEXT_2044 = NL + "    for(i =0; sizeof(";
  protected final String TEXT_2045 = "); i++)" + NL + "    {";
  protected final String TEXT_2046 = NL + "      ";
  protected final String TEXT_2047 = "[i]->";
  protected final String TEXT_2048 = "(NULL);" + NL + "    }";
  protected final String TEXT_2049 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "   ";
  protected final String TEXT_2050 = NL + "  ";
  protected final String TEXT_2051 = NL + "  ";
  protected final String TEXT_2052 = NL;

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
   
   String curlyBracket = (gen.translate("packageDefinition",uClass) == "")? "" : "}" ; 

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
    
	appendln(stringBuffer, "");
	append(stringBuffer, "#include \"{0}.h\"",uClass.getName()); 
	if (uClass.hasAssociationVariables())
	for (AssociationVariable av : uClass.getAssociationVariables())
	{
	if ( uClass.getName() != av.getRelatedAssociation().getUmpleClass().getName())
	{
		appendln(stringBuffer, "");
		append(stringBuffer, "#include \"{0}.h\"",av.getRelatedAssociation().getUmpleClass().getName()); 
	}
	}
	
	if( model.getTraceType().equals("Lttng") && uClass.hasTraceDirectives() )
  {
	for (TraceDirective td : uClass.getTraceDirectives())
	    	{
	  for (Attribute_TraceItem ati: td.getAttributeTraceItems())
	  {
		for (Attribute att : ati.getAttributes())
		{
		appendln(stringBuffer, "");
		append(stringBuffer, "#include \"{0}_tracepoint.h\";",att.getName());	
		}
	  }
	  }
  }  

    stringBuffer.append(TEXT_3);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).isInline) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(stringBuffer, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    stringBuffer.append(TEXT_4);
      if (uClass.getIsSingleton())
  {
    
    
appendln(stringBuffer, "  {0}* {0}::theInstance = NULL //singleton;", uClass.getName());

    
  }
  for(AssociationVariable av : uClass.getAssociationVariables())
  {
  	if(av.isMany())
  	{
  		
    stringBuffer.append(TEXT_5);
    
		break;
  	}
  }
  
    stringBuffer.append(TEXT_6);
    
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

  String accessibility = uClass.getIsSingleton() ? "private" : "";
  append(stringBuffer," {0}::{0}({1})",new Object[] {uClass.getName(), gClass.getLookup("constructorSignature")});

  String extraNote = null;
  
  appendln(stringBuffer, "");
  
  boolean hasBody = false;

  append(stringBuffer, "  {");
  if (!uClass.isRoot() && !"interface".equals(uClass.getExtendsClass().getModifier()))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    {1}({0});", gClass.getParentClass().getLookup("constructorSignature_caller"),uClass.getName());
    hasBody = true;
  }
  
  if (customConstructorPrefixCode != null)
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPrefixCode, "    "));
    hasBody = true;
  }
  
  if (uClass.getKey().isProvided())
  {
    hasBody = true;
    appendln(stringBuffer, "");
    append(stringBuffer, "    cachedHashCode = -1;");
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null && !av.isImmutable())
    {
      hasBody = true;
      appendln(stringBuffer, "");
      append(stringBuffer, "    {0} = true;", gen.translate("attributeCanSet",av));
    }
    else if (as != null)
    {
      hasBody = true;
      appendln(stringBuffer, "");
      append(stringBuffer, "    {0} = true;", gen.translate("associationCanSet",as));
    }
  }   

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)) || av.getIsDerived())
    {
      continue;
    }
    
    if (av.getIsList())
    {
      hasBody = true;
      
    boolean hasAvMany = false;
		for (AssociationVariable av2 : uClass.getAssociationVariables())
		{
			if ( av2.isMany())
			{
				hasAvMany = true;
			}			
		}
		String cDec = (hasAvMany)? "" : "int";
		
    stringBuffer.append(TEXT_7);
    append(stringBuffer,"{0} ",cDec);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_10);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_11);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_12);
     
    }
    else if (av.isImmutable() && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_13);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_14);
    
    }
    else if (av.isImmutable())
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_15);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_19);
     
    }
    else
    {
      hasBody = true;
      if(!av.getIsLazy()){
         
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_20);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_22);
    
      }
      else
      {
         
    
  String parameterLookup = null; // av.getValue() == null ? "parameterOne" : "parameterValue";
  String defaultValue = null;
  
 
  if(av.getValue() == null)
  {
     // Try to assign a null value or 0 value if we recognize
     // one of Umple's built in data types. (http://cruise.site.uottawa.ca/umple/UmpleBuiltinDataTypes.html)

     if(av.getType().equals("String") || av.getType().equals("Date") || av.getType().equals("Time"))
     {
  	   defaultValue = "NULL";
     }
     else if(av.getType().equals("Double") || av.getType().equals("Integer"))
     {
       defaultValue = "0";
     }
     else if(av.getType().equals("Float"))
     {
  	   defaultValue = "0.0f";
     }
     else if(av.getType().equals("Boolean"))
     {
  	   defaultValue = "false";
     }
   else
   {
       defaultValue = gen.translate("parameterValue",av);
   }
  }
  // Only assign a value if we could find a default
  if(defaultValue != null)
  { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_25);
    } 
    
      }
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_26);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_28);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
  	if (!av.getIsNavigable() || !av.isImmutable())
  	{
  	  continue;
  	}
    append(stringBuffer, "\n    {0} = true;", gen.translate("associationCanSet",av));
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (!av.getIsNavigable())
    {
      continue;
    }
    
    if (!relatedAssociation.getIsNavigable())
    {
      if (av.isOnlyOne())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_33);
    
      }
      else if (av.isOptionalOne() && av.isImmutable())
      {
        hasBody = true;
        
       
    append(stringBuffer, "\n    {0}({1});", gen.translate("setMethod",av), gen.translate("parameterOne",av));

    
      }
      else if (av.isMandatoryMany())
      {
        hasBody = true;
        
    
  String requiredNumber = "";
  if (av.isN())
  {
    requiredNumber += av.getMultiplicity().getLowerBound();
  }
  else if (av.isStar())
  {
    requiredNumber = StringFormatter.format("at least {0}", av.getMultiplicity().getLowerBound());
  }
  else
  {
    requiredNumber = StringFormatter.format("{0} to {1}", av.getMultiplicity().getLowerBound(), av.getMultiplicity().getUpperBound());
  }
  

    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_43);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        hasBody = true;
        
     String requiredNumber = StringFormatter.format("{0}", av.getMultiplicity().getUpperBound()); 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_53);
    
      }
      else if (av.isMany() && av.isImmutable())
      {
      	hasBody = true;
        
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_62);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_63);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_65);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_74);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_77);
    
    }
    else
    {
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOnlyOne())
  {
    
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_84);
    
  }
  else if (av.isOptionalMany())
  {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_87);
    
  }
  else if (av.isMandatoryMany())
  {
    
    
  String requiredNumber = "";
  if (av.isN())
  {
    requiredNumber += av.getMultiplicity().getLowerBound();
  }
  else if (av.isStar())
  {
    requiredNumber = StringFormatter.format("at least {0}", av.getMultiplicity().getLowerBound());
  }
  else
  {
    requiredNumber = StringFormatter.format("{0} to {1}", av.getMultiplicity().getLowerBound(), av.getMultiplicity().getUpperBound());
  }
  

    stringBuffer.append(TEXT_88);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_97);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_103);
    
  }
  else
  {
    continue;
  }
  hasBody = true;

    
    }
  }
  
  for(StateMachine sm : uClass.getStateMachines())
  {
    State state = sm.getStartState();
    if (state == null)
    {
      continue;
    }
    hasBody = true;
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_107);
    
    }
    
    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_110);
    
  }
  
  if (customConstructorPostfixCode != null)
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPostfixCode, "    "));
    hasBody = true;
  }

  if (hasBody)
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "  }");
  }
  else
  {
    append(stringBuffer, "}");
  }

  if (uClass.getIsSingleton())
  {
    appendln(stringBuffer, "");
    
    stringBuffer.append(TEXT_111);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_114);
    
  }

    
  if (isOneToOne)
  {
    
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_115);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_119);
    
  if (!uClass.isRoot())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    {3}::{0}({1});", gClass.getParentClass().getLookup("constructorSignature_caller"),gClass.getParentClass().getClass().getName(),uClass.getName());
    hasBody = true;
  }
  
  if (customConstructorPrefixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPrefixCode, "    "));
    hasBody = true;
  }
  
  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)))
    {
      continue;
    }
  
    if (av.getIsList())
    {
      hasBody = true;
      
    boolean hasAvMany = false;
		for (AssociationVariable av2 : uClass.getAssociationVariables())
		{
			if ( av2.isMany())
			{
				hasAvMany = true;
			}			
		}
		String cDec = (hasAvMany)? "" : "int";
		
    stringBuffer.append(TEXT_120);
    append(stringBuffer,"{0} ",cDec);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_123);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_124);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_125);
     
    }
    else
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_128);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_129);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_131);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_132);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_133);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_135);
    
    }
    else
    {
      hasBody = true;
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOnlyOne())
  {
    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_142);
    
  }
  else if (av.isOptionalMany())
  {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_145);
    
  }
  else if (av.isMandatoryMany())
  {
    
    
  String requiredNumber = "";
  if (av.isN())
  {
    requiredNumber += av.getMultiplicity().getLowerBound();
  }
  else if (av.isStar())
  {
    requiredNumber = StringFormatter.format("at least {0}", av.getMultiplicity().getLowerBound());
  }
  else
  {
    requiredNumber = StringFormatter.format("{0} to {1}", av.getMultiplicity().getLowerBound(), av.getMultiplicity().getUpperBound());
  }
  

    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_155);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_161);
    
  }
  else
  {
    continue;
  }
  hasBody = true;

    
    }
  }
  
  if (customConstructorPostfixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPostfixCode, "    "));
    hasBody = true;
  }
  
  if (hasBody)
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "  }");
  }
  else
  {
    append(stringBuffer, "}");
  }
  

    
  }


    stringBuffer.append(TEXT_162);
     if (uClass.getAttributes() != null)
	{
		
  		
    
  
  appendln(stringBuffer, "");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "  // COPY CONSTRUCTOR");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "");
  append(stringBuffer," {0}::{0}(const {0} & {1})",new Object[] {uClass.getName(),uClass.getName().toLowerCase()});

  appendln(stringBuffer, "");
  append(stringBuffer, "  {");
  for (Attribute av : uClass.getAttributes())
  {
  	 appendln(stringBuffer, "");
     append(stringBuffer, "    this->{0} = {1}.{0};",av.getName(),uClass.getName().toLowerCase());  
  }
  
  if(uClass.hasAttributes())
  {
  	appendln(stringBuffer, "");
  	append(stringBuffer, "  }");
  }
  else
  {
    append(stringBuffer, "  }");
  }
  


    
  	}
    stringBuffer.append(TEXT_163);
     if (uClass.getAttributes() != null)
	{
		
  		
    
  
  appendln(stringBuffer, "");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "  // Operator =");
  appendln(stringBuffer, "  //------------------------");
  appendln(stringBuffer, "");
  appendln(stringBuffer," {0} {0}::operator=(const {0} & {1})",new Object[] {uClass.getName(),uClass.getName().toLowerCase()});
  append(stringBuffer, "  {");
  for (Attribute av : uClass.getAttributes())
  {
  	 appendln(stringBuffer, "");
  	 append(stringBuffer, "    this->{0} = {1}.{0};",av.getName(),uClass.getName().toLowerCase());  
  }
  if(uClass.hasAttributes())
  {
  	appendln(stringBuffer, "");
  	append(stringBuffer, "  }");
  }
  else
  {
    append(stringBuffer, "  }");
  }
  


    
  	}
    stringBuffer.append(TEXT_164);
    
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
        
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_169);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_170);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_174);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_175);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_176);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_180);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_181);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_183);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_186);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_187);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_189);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_190);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_195);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_198);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_199);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_203);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_206);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_207);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_208);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_209);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_212);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_213);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_215);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_216);
    
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
      
    stringBuffer.append(TEXT_217);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_220);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_221);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_224);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_225);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_230);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_236);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_240);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_241);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_242);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_243);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_244);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_245);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_247);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_248);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_252);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_253);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_257);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_258);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_261);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_262);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_263);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_264);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_265);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_266);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_267);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_268);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_269);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_271);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_272);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_273);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_276);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_277);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_278);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_279);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_281);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_282);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_283);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_286);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_287);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_288);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_289);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_293);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_294);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_296);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_297);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_298);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_299);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_303);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_304);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_305);
    
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
        
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_308);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_309);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_310);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_311);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_313);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_314);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_315);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_318);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_319);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_321);
    
      }
      appendln(stringBuffer, "");
    }
  }

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    
    
  StringBuilder output = new StringBuilder(); 
  List<StateMachine> allParents = new ArrayList<StateMachine>();
  allParents.add(sm);
  while (allParents.size() > 0) 
  {
    StateMachine parentSm = allParents.get(0);
    allParents.remove(0);
    for (StateMachine childSm : parentSm.getNestedStateMachines()) 
    {
      output.append(StringFormatter.format("\n    if ({0} != Null) { answer += \".\" + {2}({0}); }",gen.translate("stateMachineOne",childSm),gen.translate("type",childSm),gen.translate("getStringMethod",childSm)));
      allParents.addAll(childSm.getNestedStateMachines());
    }     
  }
  String outputAsString = output.toString();

    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("getStringMethod",sm));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_327);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_328);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_329);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_333);
    
  appendln(stringBuffer,"");
  appendln(stringBuffer,"  {");
  appendln(stringBuffer,"    return {0};", gen.translate("stateOne",sm));
  appendln(stringBuffer,"  }");
  appendln(stringBuffer,"");
  
     int i=0;
   appendln(stringBuffer,"  string {3}::{0} ({1} {2})",gen.translate("getStringMethod",sm),gen.translate("type",sm),gen.translate("stateMachineOne", sm),uClass.getName());
	appendln(stringBuffer,"  {");
	appendln(stringBuffer,"    switch ({0})  {",gen.translate("stateMachineOne", sm));
	if (!sm.getStates().equals(null))
	{
		for (State state : sm.getStates())
		{
			appendln(stringBuffer,"      case {1} : {return \"{0}\"; break;}", gen.translate("stateOne",state),i++);
		}
		appendln(stringBuffer,"      default: {return \"\"; break;}");
		appendln(stringBuffer,"    }");
		appendln(stringBuffer,"  }");
    }

    

    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for(Event e : uClass.getEvents())
  {
    
    
  StringBuffer allCases = new StringBuffer();

  for(StateMachine sm : uClass.getStateMachines(e))
  {
    allCases.append(StringFormatter.format("    switch ({0})\n",gen.translate("stateMachineOne",sm)));
    allCases.append(StringFormatter.format("    {\n"));
    
    for(State state : sm.getStates())
    {
  
      List<Transition> allT = state.getTransitionsFor(e);
  
      if (allT.size() == 0)
      {
        continue;
      }

      allCases.append(StringFormatter.format("      case {0}:\n",gen.translate("stateOne",state)));

      boolean hasExitAction = false;
      for(Action action : state.getActions())
      {
        if ("exit".equals(action.getActionType()))
        {
          hasExitAction = true;
          break;
        }
      }
  
      boolean needsBreak = true;
      for (Transition t : allT)
      {
        State nextState = t.getNextState();
        String tabSpace = t.getGuard() == null ? "        " : "          ";
        if (t.getGuard() != null)
        {
          allCases.append(StringFormatter.format("        if ({0})\n",t.getGuard().getCondition()));
          allCases.append(StringFormatter.format("        {\n"));
        }
        if (hasExitAction)
        {
          allCases.append(StringFormatter.format("{0}{1}();\n",tabSpace,gen.translate("exitMethod",sm)));
        }
        if (t.getAction() != null)
        {
          Action a1= t.getAction();
          allCases.append(StringFormatter.format("{0}{1}\n",tabSpace,a1.getActionCode()));
        }

        allCases.append(StringFormatter.format("{0}{1}({3});\n",tabSpace,gen.translate("setMethod",nextState.getStateMachine()),gen.translate("type",nextState.getStateMachine()),gen.translate("stateOne",nextState)));
        allCases.append(StringFormatter.format("{0}wasEventProcessed = true;\n",tabSpace));
        allCases.append(StringFormatter.format("{0}break;\n",tabSpace));

        if (t.getGuard() != null)
        {
          allCases.append(StringFormatter.format("        }\n"));
        }
        else
        {
          needsBreak = false;
          //You can only have one *no guard case*
          break;
        }
      }
  
      if (needsBreak)
      {
        allCases.append(StringFormatter.format("        break;\n"));
      }
    } 
    allCases.append(StringFormatter.format("    }\n\n"));
  }
  
  String scope = e.getIsInternal() || e.isAutoTransition() ? "" : "";
  String outputCases = allCases.toString().trim();

    stringBuffer.append(TEXT_334);
    stringBuffer.append(scope);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_337);
    stringBuffer.append( (e.getArgs()==null?"":e.getArgs()));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(TEXT_339);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_340);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    
  StringBuffer allExitCases = new StringBuffer();
  StringBuffer allEnterCases = new StringBuffer();
  boolean hasExit = sm.getHasExitAction();
  boolean hasEntry = sm.getHasEntryAction();
  
  for(State s : sm.getStates())
  {
    if (hasExit)
    {
      allExitCases.append(StringFormatter.format("    if ({0} == {1}.{2} && {3} != {1}.{2} ) { {4}(); }\n"
        , gen.translate("stateMachineOne",sm)
        , gen.translate("type",sm)
        , gen.translate("stateOne",s)
        , gen.translate("parameterOne",sm)
        , gen.translate("exitMethod",s)
      ));
    }

    if (hasEntry)
    {
      allEnterCases.append(StringFormatter.format("    if ({0} != {1}.{2} && {3} == {1}.{2} ) { {4}(); }\n"
        , gen.translate("stateMachineOne",sm)
        , gen.translate("type",sm)
        , gen.translate("stateOne",s)
        , gen.translate("parameterOne",sm)
        , gen.translate("enterMethod",s)
      ));
    }
  }
  
  String exitCasesOutput = allExitCases.toString().trim();
  String enterCasesOutput = allEnterCases.toString().trim();

    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_343);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_344);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_345);
     if (!exitCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",exitCasesOutput); } 
     if (!enterCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",enterCasesOutput); } 
    stringBuffer.append(TEXT_346);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_347);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_348);
    
    }
    else if (sm.numberOfStates() > 0)
    {
      
    
  boolean hasEntry = false;
  boolean hasExit = false;
  boolean isFirstEntry = true;
  boolean isFirstExit = true;
  State parentState = sm.getParentState();
  StateMachine parentSm = parentState != null ? parentState.getStateMachine() : null;
  String customSetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setMethod",sm)));
  String customSetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setMethod",sm)));
  String customExitPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("exitMethod",sm)));
  String customExitPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("exitMethod",sm)));
  
  StringBuilder entryActions = new StringBuilder();
  StringBuilder exitActions = new StringBuilder();
  StringBuilder traceRecords = new StringBuilder();
  
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
          for( TraceDirective tc : uClass.getTraceDirectives() )
      	  {
      		for( int i = 0 ; i < tc.numberOfStateMachineTraceItems() ; ++ i )
      		{
      		  StateMachine_TraceItem tracedState = tc.getStateMachineTraceItem(i);
      		  StateMachine stm = tracedState.getStateMachine();
      		  if( tracedState.getEntry() )
      		    for( int j = 0 ; j < stm.numberOfStates() ; ++j )
      		    {
      		  	  State stat = stm.getState(j);
      			  //if( stat.getName().equals(gen.translate("stateOne",state)) )
          			//if( model.getTraceType().equals("Console"))
      					//entryActions.append(StringFormatter.format( "\n        " + "System.out.println(\"Tracing state {0} entry action(s)\");",gen.translate("stateOne",state)));
       				//else if( model.getTraceType().equals("File"))
       					//entryActions.append(StringFormatter.format( "\n        " + "fileTracer(\"Tracing state {0} entry action(s)\");",gen.translate("stateOne",state))); 
       		    }
      		}
      	  }
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
          for( TraceDirective tc : uClass.getTraceDirectives() )
      	  {
      		for( int i = 0 ; i < tc.numberOfStateMachineTraceItems() ; ++ i )
      		{
      		  StateMachine_TraceItem tracedState = tc.getStateMachineTraceItem(i);
      		  StateMachine stm = tracedState.getStateMachine();
      		  if( tracedState.getExit() )
      		    for( int j = 0 ; j < stm.numberOfStates() ; ++j )
      		    {
      		  	  State stat = stm.getState(j);
      			  //if( stat.getName().equals(gen.translate("stateOne",state)) )
          			//if( model.getTraceType().equals("Console"))
          				//exitActions.append(StringFormatter.format( "\n        " + "System.out.println(\"Tracing state {0} exit action(s)\");",gen.translate("stateOne",state)));
       				//else if( model.getTraceType().equals("File"))
       					//exitActions.append(StringFormatter.format( "\n        " + "fileTracer(\"Tracing state {0} exit action(s)\");",gen.translate("stateOne",state))); 
       		    }
      		 }
      	   }
        }
        hasExit = true;
        hasThisExit = true;
        isFirstExit = false;
        exitActions.append("\n        " + action.getActionCode());
      }
    }
  
    for( TraceDirective tc : uClass.getTraceDirectives() )
	  {
  	  TraceRecord traceRecord = tc.getTraceRecord();
	    for( int i = 0 ; i < tc.numberOfStateMachineTraceItems() ; ++ i )
	    {
	      StateMachine_TraceItem tracedState = tc.getStateMachineTraceItem(i);
	      StateMachine stm = tracedState.getStateMachine();
//		    if( traceRecord != null )
//		    {
//		      for( int j = 0 ; j < stm.numberOfStates() ; ++j )
//		      {
//		  	    State stat = stm.getState(j);
//
//		  	    if( stat == state )
//		  	    {
//		  	      traceRecords.append("\n    ");
//  		        traceRecords.append("if( " + gen.translate("parameterOne",stm) + ".equals(" + gen.translate("type",stm) + "." + stat.getName() + ") )");
//  		        traceRecords.append("\n      ");
//    		      if( model.getTraceType().equals("Console"))
//    		      {
//    		        traceRecords.append(StringFormatter.format("System.out.println(\"action={0}-entry, {1}=\" + {2});",stat.getName(),traceRecord.getRecord(),traceRecord.getRecord()));
// 			        }
// 			        else if( model.getTraceType().equals("File"))
//      		    {
//      		      traceRecords.append(StringFormatter.format("fileTracer(\"action={0}-entry, {1}=\" + {2});",stat.getName(),traceRecord.getRecord(),traceRecord.getRecord()));
//      		    }
//		  	    }
// 		      }
//		    }
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
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_351);
     if (customExitPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_352);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(TEXT_354);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_355);
     if (customExitPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_356);
     } 
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_359);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_360);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_361);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_362);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_363);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_364);
     if (parentState != null) { 
    stringBuffer.append(TEXT_365);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_366);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_367);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_368);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_370);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_371);
     } 
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_372);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(TEXT_374);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_375);
    stringBuffer.append( traceRecords );
     } 
    stringBuffer.append(TEXT_376);
    
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
      
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_380);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_381);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_382);
     } else { 
    stringBuffer.append(TEXT_383);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_386);
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_388);
     } 
    stringBuffer.append(TEXT_389);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_390);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_393);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_397);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_402);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_406);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_410);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_412);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_415);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_417);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_422);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_427);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_428);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_429);
    
    }
 }

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  
  boolean sortMethodAdded = false; //To ensure that only one sort method is created per class
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
	String includeFile3 = null;

    if (!relatedAssociation.getIsNavigable())
    {
      if (av.isOptionalOne())
      {
        includeFile = "association_SetUnidirectionalOptionalOne.jet";
      }
      else if (av.isOnlyOne())
      {
        includeFile = "association_SetUnidirectionalOne.jet";
      }
      else if (av.isMStar())
      {
        if (!av.isImmutable())
        {
          includeFile = "association_AddUnidirectionalMStar.jet";
        }
        includeFile2 = "association_SetUnidirectionalMStar.jet";
      }
      else if (av.isMN())
      {
      	if (!av.isImmutable())
      	{
          includeFile = "association_AddUnidirectionalMN.jet";
        }
        includeFile2 = "association_SetUnidirectionalMN.jet";
      }
      else if (av.isN())
      {
        includeFile = "association_SetUnidirectionalN.jet";
      }
      else if (av.isOptionalN())
      {
        if (!av.isImmutable())
      	{
          includeFile = "association_AddUnidirectionalOptionalN.jet";
        }
        includeFile2 = "association_SetUnidirectionalOptionalN.jet";
      }
      else if (av.isImmutable() && av.isMany())
      {
      	includeFile = "association_SetUnidirectionalMany.jet";
      }
      else if (av.isMany())
      {
        includeFile = "association_AddUnidirectionalMany.jet";
      }
    }
    else if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      //ignore
    }  
    else if (av.isN() && relatedAssociation.isOptionalOne())
    { 
      includeFile = "association_SetNToOptionalOne.jet";
    }
    else if (av.isMN() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_AddMNToOptionalOne.jet";
      includeFile2 = "association_SetMNToOptionalOne.jet";
    }
    else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isMany())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "association_AddMStarToMany.jet";
      includeFile2 = "association_SetMStarToMany.jet";
    }
    else if ((av.isMN() || av.isN()) && relatedAssociation.isMandatoryMany())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "association_AddMNToMany.jet";
      includeFile2 = "association_SetMNToMany.jet";
    }
    else if ((av.isMN() || av.isN()) && relatedAssociation.isOptionalN())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "association_AddMNToMany.jet";
    }
    else if ((av.isMN() || av.isN()) && !relatedAssociation.isOne())
    {
      hasIsNumberOfValidMethod = true;
      hasAddManyToManyTemplateMethod = true;
      includeFile = "association_AddMNToMany.jet";
      includeFile2 = "association_SetMNToMany.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_SetOptionalOneToOptionalOne.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOne())
    {
      includeFile = "association_SetOptionalOneToOne.jet";
    }
    else if (av.isOne() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_SetOneToOptionalOne.jet";
    }
    else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isOne())
    {
      hasIsNumberOfValidMethod = true;
      includeFile = "association_AddMandatoryManyToOne.jet";
    }
    else if ((av.isMN() || av.isN()) && relatedAssociation.isOnlyOne())
    {
      hasIsNumberOfValidMethod = true;
      includeFile = "association_AddMNToOnlyOne.jet";
    }
    else if (av.isOptionalN() && relatedAssociation.isOnlyOne())
    {
      includeFile = "association_AddOptionalNToOne.jet";
    }
    else if (av.isOptionalN() && (relatedAssociation.isMN() || relatedAssociation.isOptionalN()))
    {
      hasAddManyToManyTemplateMethod = true;
      if (!av.isImmutable())
      {
      	hasRemoveManyTemplateMethod = true;
      }
    }
    else if (av.isOptionalN() && relatedAssociation.isOptionalMany())
    {
      hasAddManyToManyTemplateMethod = true;
      if (!av.isImmutable())
      {
      	hasRemoveManyTemplateMethod = true;
      }
      includeFile = "association_SetOptionalNToMany.jet";
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      includeFile = "association_AddManyToOne.jet";
    }
    else if (av.isOptionalN() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      hasAddManyToManyTemplateMethod = true;
      if (!av.isImmutable())
      {
      	hasRemoveManyTemplateMethod = true;
      }
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN() || relatedAssociation.isMany()))
    {
      hasAddManyToManyTemplateMethod = true;
      if (!av.isImmutable())
      {
      	hasRemoveManyTemplateMethod = true;
      }
    }
    else if (av.isOptionalN() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_AddOptionalNToOptionalOne.jet";
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      includeFile = "association_AddManyToOptionalOne.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isMandatoryMany() && relatedAssociation.isStar())
    {
      includeFile = "association_SetOneToMandatoryMany.jet";
    }
    else if (av.isOnlyOne() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      includeFile = "association_SetOneToAtMostN.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalN())
    {
      includeFile = "association_SetOneToAtMostN.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()))
    {
      includeFile = "association_SetOneToMany.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalN())
    {
      includeFile = "association_SetOptionalOneToOptionalN.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      includeFile = "association_SetOptionalOneToMany.jet";
    }
    else if (av.isOptionalOne() && relatedAssociation.isMandatoryMany())
    {
      // Insert code to include code here
      if (relatedAssociation.isUpperBounded())
      {
        //
        // This program cannot currently include SetOptionalOneToMandatoryMN.jet because of Issue351 where add/remove methods do not generate
        //
        // includeFile = "association_SetOptionalOneToMandatoryMN.jet";
      } 
      else
      {
        //
        // We can include association_SetOptionalOneToMandatoryMany.jet
        // 
        includeFile = "association_SetOptionalOneToMandatoryMany.jet";
      } 
    }
    else if (av.isOptionalOne() && relatedAssociation.isMandatory())
    {
      //ignore
    }

    else
    {
      
    stringBuffer.append(TEXT_430);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(relatedAssociation);
    
    }
    
    if(av.isSorted())
    {
      includeFile3 = "association_Sort.jet";
    }
    else if(av.isMany() && !av.isImmutable() && !av.isN())
    {
      includeFile3 = "association_AddIndexControlFunctions.jet";
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_434);
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_437);
     } else { 
    stringBuffer.append(TEXT_438);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_441);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_442);
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_443);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_447);
     } else { 
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_450);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_451);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_452);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_453);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_456);
     } else { 
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_459);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_460);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_461);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_462);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getMethod",av)));

    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_463);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_466);
     } else { 
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_469);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_470);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_471);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_472);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_477);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_480);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_481);
     } 
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_493);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_494);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_499);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_503);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_520);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_521);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_526);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_529);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_530);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_535);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_540);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_541);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_546);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_554);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_555);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_573);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_574);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_579);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_584);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_594);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_595);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_609);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_610);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_621);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_640);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_645);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_650);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_655);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_656);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_659);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_660);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_663);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_673);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_676);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_677);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_689);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_697);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_706);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_711);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_716);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_717);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_723);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_724);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_737);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_740);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_741);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_756);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_765);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_776);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_777);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_782);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_799);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_826);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_827);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_828);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_838);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_853);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_862);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_873);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_874);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_879);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_893);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_894);
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_916);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_917);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_926);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_930);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_933);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_951);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_952);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_961);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_966);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_969);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_984);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_985);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_990);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_996);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_997);
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1014);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1015);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1020);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1022);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1039);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1040);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1045);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1049);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1056);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1072);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1076);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1077);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1082);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1086);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1092);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1108);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1112);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1113);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1118);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1138);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1147);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1161);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1162);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1167);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1184);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1185);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1190);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1193);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1214);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1223);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1235);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1236);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1241);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1247);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1256);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1261);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1264);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1271);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1272);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1277);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1280);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1281);
     } 
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1290);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1304);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1313);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1329);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1330);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1335);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1345);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1350);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1356);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1375);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1389);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1394);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1397);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1406);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1417);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1418);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1423);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1429);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1438);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1447);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1448);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1453);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1456);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1465);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1470);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1473);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1480);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1481);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1486);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1503);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1509);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1510);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
    	
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1511);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1515);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1528);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1534);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1535);
    
    }
	else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(TEXT_1558);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1580);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1599);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1612);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1617);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1622);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1627);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1629);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1632);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1646);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1673);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1677);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1678);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1682);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1683);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1687);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1688);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1692);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1696);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1698);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1700);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1701);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1703);
    stringBuffer.append(TEXT_1704);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1705);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1706);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1707);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1708);
    stringBuffer.append(TEXT_1709);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1710);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1713);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1714);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(TEXT_1716);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1718);
    stringBuffer.append(TEXT_1719);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1720);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1721);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1722);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1723);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1724);
    stringBuffer.append(TEXT_1725);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1726);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1727);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1728);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1730);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1731);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1732);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1733);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1735);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1736);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1737);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1738);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1739);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1740);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1741);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1742);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1743);
    stringBuffer.append(TEXT_1744);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1745);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1746);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1747);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1749);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1750);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1751);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1752);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1753);
    stringBuffer.append(TEXT_1754);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1755);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1756);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1757);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1758);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1759);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1760);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1761);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1762);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1763);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1764);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1765);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1766);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1767);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1768);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1769);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1770);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1771);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1772);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1773);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1774);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1775);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1776);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1777);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1778);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1779);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1780);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1781);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1782);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1783);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1784);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1785);
    stringBuffer.append(TEXT_1786);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1787);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1788);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1789);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1790);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1791);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1792);
    stringBuffer.append(TEXT_1793);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1794);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1795);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1796);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1797);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1798);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1799);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1800);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_1801);
    stringBuffer.append(TEXT_1802);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1803);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1804);
    stringBuffer.append(TEXT_1805);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1806);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1807);
    stringBuffer.append(TEXT_1808);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1809);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1810);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1811);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1812);
    stringBuffer.append(TEXT_1813);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1814);
    stringBuffer.append(TEXT_1815);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1816);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1817);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1818);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1819);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1820);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1821);
    stringBuffer.append(TEXT_1822);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1823);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1824);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1825);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1826);
    stringBuffer.append(TEXT_1827);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1828);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1829);
    stringBuffer.append(TEXT_1830);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1831);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1832);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1833);
    stringBuffer.append(TEXT_1834);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1835);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1836);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1837);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1838);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1839);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1840);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1841);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1842);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1843);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1844);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1845);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1846);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1847);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1848);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1849);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1850);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1851);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1852);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1853);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1854);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1855);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1856);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1857);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1858);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1859);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1860);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1861);
    stringBuffer.append(TEXT_1862);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1863);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1864);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1865);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1866);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1867);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1868);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1869);
    stringBuffer.append(TEXT_1870);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1871);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1872);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1873);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1874);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1875);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1876);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1877);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1878);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1879);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1880);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1881);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1882);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1883);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1884);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1885);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1886);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1887);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1888);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1889);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1890);
    stringBuffer.append(TEXT_1891);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1892);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1893);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1894);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1895);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1896);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1897);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1898);
    stringBuffer.append(TEXT_1899);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1900);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1901);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1902);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1903);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1904);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
    }
    
    if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
    {
      
    
      sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
    }
    else if(includeFile3 == "association_AddIndexControlFunctions.jet")
    {
      
    
    }
  }

     if (uClass.getKey().isProvided()) { 
    

  StringBuilder checks = new StringBuilder();
  StringBuilder hash = new StringBuilder();
  StringBuilder canSet = new StringBuilder();
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null)
    {
      canSet.append(StringFormatter.format("    {0} = false;\n",gen.translate("attributeCanSet",av)));
      if (av.getIsList())
      {
        checks.append(StringFormatter.format("    if ({0}.size() != compareTo.{0}.size())\n",gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n\n"));
        checks.append(StringFormatter.format("    for (int i=0; i<{0}.size(); i++)\n",gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      {0} me = {1}.get(i);\n",gen.translate("type",av),gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("      {0} them = compareTo.{1}.get(i);\n",gen.translate("type",av),gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("      if (me == null && them != null)\n"));
        checks.append(StringFormatter.format("      {\n"));
        checks.append(StringFormatter.format("       return false;\n"));
        checks.append(StringFormatter.format("      }\n"));
        checks.append(StringFormatter.format("      else if (me != null && !me.equals(them))\n"));
        checks.append(StringFormatter.format("      {\n"));
        checks.append(StringFormatter.format("        return false;\n"));
        checks.append(StringFormatter.format("      }\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      else if ("Integer".equals(av.getType()) || "Boolean".equals(av.getType()) || "Double".equals(av.getType()))
      {
        checks.append(StringFormatter.format("    if ({0} != compareTo.{0})\n",gen.translate("attributeOne",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      else
      {
        checks.append(StringFormatter.format("    if ({0} == null && compareTo.{0} != null)\n",gen.translate("attributeOne",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
        checks.append(StringFormatter.format("    else if ({0} != null && !{0}.equals(compareTo.{0}))\n",gen.translate("attributeOne",av)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      checks.append("\n");
    }
    else if (as != null)
    {
      canSet.append(StringFormatter.format("    {0} = false;\n",gen.translate("associationCanSet",as)));
      if (as.isMany())
      {
        checks.append(StringFormatter.format("    if ({0}.size() != compareTo.{0}.size())\n",gen.translate("associationMany",as)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n\n"));
        checks.append(StringFormatter.format("    for (int i=0; i<{0}.size(); i++)\n",gen.translate("attributeMany",as)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      {0} me = {1}.get(i);\n",gen.translate("type",as),gen.translate("associationMany",as)));
        checks.append(StringFormatter.format("      {0} them = compareTo.{1}.get(i);\n",gen.translate("type",as),gen.translate("associationMany",as)));
        checks.append(StringFormatter.format("      if (me == null && them != null)\n"));
        checks.append(StringFormatter.format("      {\n"));
        checks.append(StringFormatter.format("       return false;\n"));
        checks.append(StringFormatter.format("      }\n"));
        checks.append(StringFormatter.format("      else if (me != null && !me.equals(them))\n"));
        checks.append(StringFormatter.format("      {\n"));
        checks.append(StringFormatter.format("        return false;\n"));
        checks.append(StringFormatter.format("      }\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      else
      {
        checks.append(StringFormatter.format("    if ({0} == null && compareTo.{0} != null)\n",gen.translate("attributeOne",as)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
        checks.append(StringFormatter.format("    else if ({0} != null && !{0}.equals(compareTo.{0}))\n",gen.translate("attributeOne",as)));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      checks.append("\n");
    }
    
    if (av != null)
    {
      if ("Integer".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    cachedHashCode = cachedHashCode * 23 + {0};\n",gen.translate("attributeOne",av)));
      }
      else if ("Double".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    cachedHashCode = cachedHashCode * 23 + (new Double({0})).hashCode();\n",gen.translate("attributeOne",av)));
      }
      else if ("Boolean".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    cachedHashCode = cachedHashCode * 23 + ({0} ? 1 : 0);\n",gen.translate("attributeOne",av)));
      }
      else
      {
        String attributeType = av.getIsList() ? "attributeMany" : "attributeOne";
        hash.append(StringFormatter.format("    if ({0} != null)\n",gen.translate(attributeType,av)));
        hash.append(StringFormatter.format("    {\n"));
        hash.append(StringFormatter.format("      cachedHashCode = cachedHashCode * 23 + {0}.hashCode();\n",gen.translate(attributeType,av)));
        hash.append(StringFormatter.format("    }\n"));
        hash.append(StringFormatter.format("    else\n"));
        hash.append(StringFormatter.format("    {\n"));
        hash.append(StringFormatter.format("      cachedHashCode = cachedHashCode * 23;\n"));
        hash.append(StringFormatter.format("    }\n"));
      }
      hash.append("\n");
    }
    else if (as != null)
    {
      String attributeType = as.isOne() ? "attributeOne" : "attributeMany";
      hash.append(StringFormatter.format("    if ({0} != null)\n",gen.translate(attributeType,as)));
      hash.append(StringFormatter.format("    {\n"));
      hash.append(StringFormatter.format("      cachedHashCode = cachedHashCode * 23 + {0}.hashCode();\n",gen.translate(attributeType,as)));
      hash.append(StringFormatter.format("    }\n"));
      hash.append(StringFormatter.format("    else\n"));
      hash.append(StringFormatter.format("    {\n"));
      hash.append(StringFormatter.format("      cachedHashCode = cachedHashCode * 23;\n"));
      hash.append(StringFormatter.format("    }\n"));
    }
  }


    stringBuffer.append(TEXT_1905);
    stringBuffer.append(TEXT_1906);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1907);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1908);
    stringBuffer.append(TEXT_1909);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1910);
    stringBuffer.append(TEXT_1911);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1912);
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
        
    stringBuffer.append(TEXT_1913);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1914);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1915);
    stringBuffer.append(TEXT_1916);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1917);
    
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

    stringBuffer.append(TEXT_1918);
    stringBuffer.append(TEXT_1919);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1920);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1921);
    stringBuffer.append(TEXT_1922);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1923);
    
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
        
    stringBuffer.append(TEXT_1924);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1925);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1926);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1927);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1928);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1929);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1930);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1931);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1932);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1933);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1934);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1935);
    
      }
    }
  }

    stringBuffer.append(TEXT_1936);
    
  }
}

    stringBuffer.append(TEXT_1937);
    

  appendln(stringBuffer,"");
  appendln(stringBuffer,"{0}::~{0}()",uClass.getName());
  append(stringBuffer,"  {");

  boolean hasSomethingToDelete = false;

  String customDeletePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","delete"));
  String customDeletePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","delete"));

  if (customDeletePrefixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customDeletePrefixCode, "    "));
    hasSomethingToDelete = true;
  }

  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (!av.getIsNavigable())
    {
      continue;
    }
    
    if (!relatedAssociation.getIsNavigable())
    {
      if (av.isOne())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1938);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1939);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1940);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1941);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1942);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1943);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1944);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1945);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1946);
    stringBuffer.append(TEXT_1947);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1948);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1949);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1950);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1951);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1952);
    stringBuffer.append(TEXT_1953);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1954);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1955);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1956);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1957);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1958);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1959);
    stringBuffer.append(TEXT_1960);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1961);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1962);
    stringBuffer.append(TEXT_1963);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1964);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1965);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1966);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1967);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1968);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1969);
    stringBuffer.append(TEXT_1970);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1971);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1972);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1973);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1974);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1975);
    stringBuffer.append(TEXT_1976);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1977);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1978);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1979);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1980);
    stringBuffer.append(TEXT_1981);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1982);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1983);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1984);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1985);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1986);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1987);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1988);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1989);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1990);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1991);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1992);
    stringBuffer.append(TEXT_1993);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1994);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1995);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1996);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1997);
    stringBuffer.append(TEXT_1998);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1999);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2000);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2001);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2002);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2003);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2004);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2005);
    stringBuffer.append(TEXT_2006);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2007);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2008);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2009);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2010);
    stringBuffer.append(TEXT_2011);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2012);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2013);
    stringBuffer.append(TEXT_2014);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2015);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_2016);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2017);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2018);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2019);
    stringBuffer.append(TEXT_2020);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2021);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2022);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2023);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2024);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2025);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2026);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2027);
    stringBuffer.append(TEXT_2028);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2029);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2030);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2031);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2032);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2033);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2034);
    stringBuffer.append(TEXT_2035);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2036);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2037);
    stringBuffer.append(TEXT_2038);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2039);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2040);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_2041);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2042);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2043);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2044);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2045);
    stringBuffer.append(TEXT_2046);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2047);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2048);
    
    }
    else
    {
      continue;
    }
    hasSomethingToDelete = true;
  }
  
  if (!uClass.isRoot() && !"external".equals(uClass.getExtendsClass().getModifier()))
  {
    hasSomethingToDelete = true;
    appendln(stringBuffer,"");
    append(stringBuffer, "    super.delete();");
  }

  if (customDeletePostfixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customDeletePostfixCode, "    "));
    hasSomethingToDelete = true;
  }

  if (hasSomethingToDelete)
  {
    appendln(stringBuffer, "");
    appendln(stringBuffer, "  }");
  }
  else
  {
    appendln(stringBuffer, "}");
  }


     if (uClass.hasMethods()) { 
    
    if (uClass.hasMethods())
    {
    	for (Method aMethod : uClass.getMethods()) 
    	{
    		String methodModifier = aMethod.getModifier().equals("") ? "" : aMethod.getModifier();
    		String methodName = (uClass.getName()+"::"+aMethod.getName());
    		String methodType = aMethod.getType();
    		String methodBody = aMethod.getIsImplemented() ? "      return " + gen.translate(methodType) + ";" : aMethod.getMethodBody().getExtraCode();
    		String properMethodBody = "      " + methodBody; 
    		String override =  aMethod.getIsImplemented() ? "  @Override" : "";
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
    			
    			if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Method Javadoc",aMethod.getComments())); }
    			
    			appendln(stringBuffer,override);
    			append(stringBuffer, "  {0} {1} {2}({3})", methodModifier, methodType, methodName, finalParams);	
    			appendln(stringBuffer, "{");
    			appendln(stringBuffer, properMethodBody);
    			appendln(stringBuffer, "  }");
    			
    		}
    		else{
    			appendln(stringBuffer, "");
    			
    			if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Method Javadoc",aMethod.getComments())); }
    			
    			appendln(stringBuffer,override);
    			append(stringBuffer, "  {0} {1} {2}()", methodModifier, methodType, methodName);
    		    appendln(stringBuffer, "{");
    			appendln(stringBuffer, properMethodBody);
    			appendln(stringBuffer, "  }");
    		}
    	}
    }

     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_2049);
    stringBuffer.append(TEXT_2050);
    stringBuffer.append(uClass.getExtraCode());
    stringBuffer.append(TEXT_2051);
     } 
    
{
  //==== Tracing Code    
  if( model.getTraceType().equals("File") && uClass.hasTraceDirectives() )
  {
    appendln(stringBuffer, "");
	appendln(stringBuffer, "  //------------------------");
	appendln(stringBuffer, "  // FILE TRACER METHOD");
	appendln(stringBuffer, "  //------------------------\n");
	appendln(stringBuffer, "  {0}::fileTracer(Object obj)",uClass.getName());
	appendln(stringBuffer, "  {");
	appendln(stringBuffer, "      // Create and Open an output stream");
	appendln(stringBuffer, "    ofstream fout;");
	appendln(stringBuffer, "    time_t rawTime; // for timestamp");
	appendln(stringBuffer, "    try");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      // Create and Open an output stream");
	appendln(stringBuffer, "      fout.open(\"TraceLog.txt\")");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "    catch (exception& e)");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      cout<<\"Unable to write to file due to:\"<<e.what()<<endl;");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "    // Write traced Item information");
	appendln(stringBuffer, "    fout<<obj;");
	appendln(stringBuffer, "    try");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      // Close output stream");
	appendln(stringBuffer, "      fout.close();");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "    catch (exception& e)");
	appendln(stringBuffer, "    {");
	appendln(stringBuffer, "      fout<<e.what()<<endl;");
	appendln(stringBuffer, "    }");
	appendln(stringBuffer, "  }");
  }
  
  isFirst = true;
  for( TraceDirective td : uClass.getTraceDirectives() )
  {
    for( Attribute_TraceItem traceAttr : td.getAttributeTraceItems() )
    {
      if( traceAttr.getPeriodClause() != null )
      {
    	if( isFirst )
    	{
          appendln(stringBuffer, "");
      	  appendln(stringBuffer, "  //------------------------");
      	  appendln(stringBuffer, "  // TRACING METHOD(s)");
      	  appendln(stringBuffer, "  //------------------------\n");
      	  isFirst = false;
    	}
    	for( Attribute attr : traceAttr.getAttributes() )
    	{
    	  String attrName = attr.getName();
    	  attrName = attrName.substring(0,1).toUpperCase()+attrName.substring(1).toLowerCase();
          appendln(stringBuffer, "  private void trace{0}Period(final int period)",attrName); 	
          appendln(stringBuffer, "  {");
          appendln(stringBuffer, "    ( new Thread()");
          appendln(stringBuffer, "    {");
          appendln(stringBuffer, "      public void run()");
          appendln(stringBuffer, "      {");
          appendln(stringBuffer, "         while( true )");
          appendln(stringBuffer, "         {");
          appendln(stringBuffer, "           Date date = new Date();");
          appendln(stringBuffer, "           System.err.println(\"{0}=\"+{1} +\", t =\"+date.toString());",attrName,attr.getName());
          appendln(stringBuffer, "           try");
          appendln(stringBuffer, "           {Thread.sleep(period);}");
          appendln(stringBuffer, "           catch (InterruptedException e)");
          appendln(stringBuffer, "           {e.printStackTrace();}");
          appendln(stringBuffer, "         }");
          appendln(stringBuffer, "      }");
          appendln(stringBuffer, "    }");
          appendln(stringBuffer, "    ).start();");
          appendln(stringBuffer, "  }");
    	}
      }
    }
  }
}

    stringBuffer.append(TEXT_2052);
    return stringBuffer.toString();
  }
}