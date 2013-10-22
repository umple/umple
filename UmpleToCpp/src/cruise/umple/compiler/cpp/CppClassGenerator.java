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
  protected final String TEXT_5 = NL + "  //------------------------" + NL + "  // CONSTRUCTOR" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = NL + "    ";
  protected final String TEXT_8 = "();";
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = " = true;";
  protected final String TEXT_11 = NL + "    ";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "    ";
  protected final String TEXT_15 = " = false;";
  protected final String TEXT_16 = NL + "    ";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";";
  protected final String TEXT_19 = NL + "    ";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";";
  protected final String TEXT_22 = NL + "    ";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = "++;";
  protected final String TEXT_25 = NL + "    if (!";
  protected final String TEXT_26 = "(";
  protected final String TEXT_27 = "))" + NL + "    {" + NL + "      throw (\"Unable to create ";
  protected final String TEXT_28 = " due to ";
  protected final String TEXT_29 = "\");" + NL + "    }";
  protected final String TEXT_30 = NL + "    bool ";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = "(";
  protected final String TEXT_33 = ");" + NL + "    try {" + NL + "\t\t throw  ";
  protected final String TEXT_34 = ";" + NL + "\t\t}" + NL + "\tcatch (exception& e)\t" + NL + "\t{" + NL + "\tcout<<\"Unable to create ";
  protected final String TEXT_35 = ", must have ";
  protected final String TEXT_36 = " ";
  protected final String TEXT_37 = "\";" + NL + "\t}";
  protected final String TEXT_38 = NL + "    bool ";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = "(";
  protected final String TEXT_41 = ");" + NL + "    if (!";
  protected final String TEXT_42 = ")" + NL + "    {" + NL + "    \ttry" + NL + "    \t{    \t" + NL + "      \t  cout<<\"Unable to create ";
  protected final String TEXT_43 = ", must have ";
  protected final String TEXT_44 = " or fewer ";
  protected final String TEXT_45 = ", no duplicates.\";" + NL + "      \t}" + NL + "      \t" + NL + "      \tcatch" + NL + "      \t{" + NL + "      \t\tcerr<<\"exception caught:\"<<e.what()<<endl;" + NL + "      \t}" + NL + "    }";
  protected final String TEXT_46 = NL + "    bool ";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = "(";
  protected final String TEXT_49 = ");" + NL + "    if (!";
  protected final String TEXT_50 = ")" + NL + "    {" + NL + "    " + NL + "    try" + NL + "    \t{    \t" + NL + "      \t  cout<<\"Unable to create ";
  protected final String TEXT_51 = ", must not have duplicate ";
  protected final String TEXT_52 = ".\");" + NL + "      \t}" + NL + "      \t" + NL + "      \tcatch" + NL + "      \t{" + NL + "      \t\tcerr<<\"exception caught:\"<<e.what()<<endl;" + NL + "      \t}" + NL + "    }";
  protected final String TEXT_53 = NL + "   ";
  protected final String TEXT_54 = NL + "    if (";
  protected final String TEXT_55 = " == NULL || ";
  protected final String TEXT_56 = "->";
  protected final String TEXT_57 = "() != NULL)" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_58 = " due to ";
  protected final String TEXT_59 = "\");" + NL + "    }";
  protected final String TEXT_60 = NL + "    ";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = ";";
  protected final String TEXT_63 = NL + "   ";
  protected final String TEXT_64 = NL + "    bool ";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = ");" + NL + "    if (!";
  protected final String TEXT_68 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_69 = " due to ";
  protected final String TEXT_70 = "\");" + NL + "    }";
  protected final String TEXT_71 = NL + "    bool ";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = "(";
  protected final String TEXT_74 = ");" + NL + "    try {" + NL + "\t\t throw  ";
  protected final String TEXT_75 = ";" + NL + "\t\t}" + NL + "\tcatch (exception& e)\t" + NL + "\t{" + NL + "\tcout<<\"Unable to create ";
  protected final String TEXT_76 = ", must have ";
  protected final String TEXT_77 = " ";
  protected final String TEXT_78 = "\";" + NL + "\t}";
  protected final String TEXT_79 = ".push_back(";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "    if (";
  protected final String TEXT_82 = " == Null) { ";
  protected final String TEXT_83 = "(";
  protected final String TEXT_84 = "); }";
  protected final String TEXT_85 = NL + "    ";
  protected final String TEXT_86 = "(";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "  ";
  protected final String TEXT_89 = "* ";
  protected final String TEXT_90 = "::getInstance()" + NL + "  {" + NL + "    if(!theInstance)" + NL + "    {" + NL + "      theInstance = new ";
  protected final String TEXT_91 = ";" + NL + "    }" + NL + "    return theInstance;" + NL + "  }";
  protected final String TEXT_92 = NL;
  protected final String TEXT_93 = NL + "  ";
  protected final String TEXT_94 = "::";
  protected final String TEXT_95 = "(";
  protected final String TEXT_96 = ")" + NL + "  {";
  protected final String TEXT_97 = NL + "\t\t";
  protected final String TEXT_98 = NL + "    ";
  protected final String TEXT_99 = "();";
  protected final String TEXT_100 = NL + "    ";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = NL + "    ";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = "++;";
  protected final String TEXT_106 = NL + "    ";
  protected final String TEXT_107 = NL + "   ";
  protected final String TEXT_108 = NL + "    bool ";
  protected final String TEXT_109 = " = ";
  protected final String TEXT_110 = "(";
  protected final String TEXT_111 = ");" + NL + "    if (!";
  protected final String TEXT_112 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_113 = " due to ";
  protected final String TEXT_114 = "\");" + NL + "    }";
  protected final String TEXT_115 = NL + "    bool ";
  protected final String TEXT_116 = " = ";
  protected final String TEXT_117 = "(";
  protected final String TEXT_118 = ");" + NL + "    try {" + NL + "\t\t throw  ";
  protected final String TEXT_119 = ";" + NL + "\t\t}" + NL + "\tcatch (exception& e)\t" + NL + "\t{" + NL + "\tcout<<\"Unable to create ";
  protected final String TEXT_120 = ", must have ";
  protected final String TEXT_121 = " ";
  protected final String TEXT_122 = "\";" + NL + "\t}";
  protected final String TEXT_123 = ".push_back(";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "  ";
  protected final String TEXT_126 = NL + "  \t";
  protected final String TEXT_127 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_128 = NL + "  bool ";
  protected final String TEXT_129 = "::";
  protected final String TEXT_130 = "(const ";
  protected final String TEXT_131 = " & ";
  protected final String TEXT_132 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_133 = NL + "    ";
  protected final String TEXT_134 = " = false;";
  protected final String TEXT_135 = NL + "    ";
  protected final String TEXT_136 = " = ";
  protected final String TEXT_137 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_138 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_139 = NL + "  bool ";
  protected final String TEXT_140 = "::";
  protected final String TEXT_141 = "(const ";
  protected final String TEXT_142 = " & ";
  protected final String TEXT_143 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_144 = NL + "    ";
  protected final String TEXT_145 = " = ";
  protected final String TEXT_146 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_147 = NL + "    return wasSet;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_148 = "::";
  protected final String TEXT_149 = "()" + NL + "  {" + NL + "    bool wasReset = false;";
  protected final String TEXT_150 = NL + "    ";
  protected final String TEXT_151 = " = ";
  protected final String TEXT_152 = "();" + NL + "    wasReset = true;";
  protected final String TEXT_153 = NL + "    return wasReset;" + NL + "  }" + NL;
  protected final String TEXT_154 = NL + "  bool ";
  protected final String TEXT_155 = "::";
  protected final String TEXT_156 = "(const ";
  protected final String TEXT_157 = " & ";
  protected final String TEXT_158 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_159 = NL + "    wasAdded = ";
  protected final String TEXT_160 = ".add(";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_163 = "::";
  protected final String TEXT_164 = "(";
  protected final String TEXT_165 = " & ";
  protected final String TEXT_166 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_167 = NL + "    wasRemoved = ";
  protected final String TEXT_168 = ".remove(";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_171 = NL + "  bool ";
  protected final String TEXT_172 = "::";
  protected final String TEXT_173 = "(const ";
  protected final String TEXT_174 = " & ";
  protected final String TEXT_175 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_176 = NL + "    ";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_179 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_180 = NL + "  ";
  protected final String TEXT_181 = " ";
  protected final String TEXT_182 = "::";
  protected final String TEXT_183 = "(int index)" + NL + "  {";
  protected final String TEXT_184 = NL + "    ";
  protected final String TEXT_185 = " ";
  protected final String TEXT_186 = " = ";
  protected final String TEXT_187 = ".get(index);";
  protected final String TEXT_188 = NL + "    return ";
  protected final String TEXT_189 = ";" + NL + "  }" + NL;
  protected final String TEXT_190 = NL + "  ";
  protected final String TEXT_191 = "[] ";
  protected final String TEXT_192 = "::";
  protected final String TEXT_193 = "()" + NL + "  {";
  protected final String TEXT_194 = NL + "    ";
  protected final String TEXT_195 = "[] ";
  protected final String TEXT_196 = " = ";
  protected final String TEXT_197 = ".toArray(new ";
  protected final String TEXT_198 = "[";
  protected final String TEXT_199 = ".size()]);";
  protected final String TEXT_200 = NL + "    return ";
  protected final String TEXT_201 = ";" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_202 = "::";
  protected final String TEXT_203 = "()" + NL + "  {";
  protected final String TEXT_204 = NL + "    int number = ";
  protected final String TEXT_205 = ".size();";
  protected final String TEXT_206 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_207 = "::";
  protected final String TEXT_208 = "()" + NL + "  {";
  protected final String TEXT_209 = NL + "    bool has = ";
  protected final String TEXT_210 = ".size() > 0;";
  protected final String TEXT_211 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_212 = "::";
  protected final String TEXT_213 = "(";
  protected final String TEXT_214 = "* ";
  protected final String TEXT_215 = ")" + NL + "  {";
  protected final String TEXT_216 = NL + "    int index = find(";
  protected final String TEXT_217 = ".begin(), ";
  protected final String TEXT_218 = ".end(), ";
  protected final String TEXT_219 = ") - ";
  protected final String TEXT_220 = ".begin();";
  protected final String TEXT_221 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_222 = NL + "  ";
  protected final String TEXT_223 = " ";
  protected final String TEXT_224 = "::";
  protected final String TEXT_225 = "()" + NL + "  {";
  protected final String TEXT_226 = NL + "    ";
  protected final String TEXT_227 = " ";
  protected final String TEXT_228 = " = ";
  protected final String TEXT_229 = ";";
  protected final String TEXT_230 = NL + "    return ";
  protected final String TEXT_231 = ";" + NL + "  }";
  protected final String TEXT_232 = NL + "  ";
  protected final String TEXT_233 = " ";
  protected final String TEXT_234 = "::";
  protected final String TEXT_235 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_236 = ";" + NL + "  }";
  protected final String TEXT_237 = NL + "  ";
  protected final String TEXT_238 = " ";
  protected final String TEXT_239 = "::";
  protected final String TEXT_240 = "()" + NL + "  {";
  protected final String TEXT_241 = NL + "    ";
  protected final String TEXT_242 = " ";
  protected final String TEXT_243 = " = ";
  protected final String TEXT_244 = ";";
  protected final String TEXT_245 = NL + "    return ";
  protected final String TEXT_246 = ";" + NL + "  }";
  protected final String TEXT_247 = NL + "  ";
  protected final String TEXT_248 = " ";
  protected final String TEXT_249 = "::";
  protected final String TEXT_250 = "() const" + NL + "  {";
  protected final String TEXT_251 = NL + "    return ";
  protected final String TEXT_252 = ";" + NL + "  }";
  protected final String TEXT_253 = NL + "  ";
  protected final String TEXT_254 = " ";
  protected final String TEXT_255 = "::";
  protected final String TEXT_256 = "()" + NL + "  {";
  protected final String TEXT_257 = NL + "    ";
  protected final String TEXT_258 = " ";
  protected final String TEXT_259 = " = ";
  protected final String TEXT_260 = ";";
  protected final String TEXT_261 = NL + "    return ";
  protected final String TEXT_262 = ";" + NL + "  }";
  protected final String TEXT_263 = NL + "  ";
  protected final String TEXT_264 = " ";
  protected final String TEXT_265 = "::";
  protected final String TEXT_266 = "() const" + NL + "  {";
  protected final String TEXT_267 = NL + "    return ";
  protected final String TEXT_268 = ";" + NL + "  }" + NL;
  protected final String TEXT_269 = NL + "  ";
  protected final String TEXT_270 = " ";
  protected final String TEXT_271 = "(";
  protected final String TEXT_272 = " ";
  protected final String TEXT_273 = ")" + NL + "  {";
  protected final String TEXT_274 = NL + "    ";
  protected final String TEXT_275 = " ";
  protected final String TEXT_276 = " = ";
  protected final String TEXT_277 = ".get(";
  protected final String TEXT_278 = ");";
  protected final String TEXT_279 = NL;
  protected final String TEXT_280 = "    return ";
  protected final String TEXT_281 = ";" + NL + "  }" + NL;
  protected final String TEXT_282 = NL + "  ";
  protected final String TEXT_283 = " ";
  protected final String TEXT_284 = "(";
  protected final String TEXT_285 = " ";
  protected final String TEXT_286 = ")" + NL + "  {";
  protected final String TEXT_287 = NL;
  protected final String TEXT_288 = "    return ";
  protected final String TEXT_289 = ".get(";
  protected final String TEXT_290 = ");" + NL + "  }" + NL;
  protected final String TEXT_291 = NL + "  bool ";
  protected final String TEXT_292 = "(";
  protected final String TEXT_293 = " ";
  protected final String TEXT_294 = ")" + NL + "  {";
  protected final String TEXT_295 = NL + "    boolean ";
  protected final String TEXT_296 = " = ";
  protected final String TEXT_297 = "(";
  protected final String TEXT_298 = ") != null;";
  protected final String TEXT_299 = NL;
  protected final String TEXT_300 = "    return ";
  protected final String TEXT_301 = ";" + NL + "  }" + NL;
  protected final String TEXT_302 = NL + "  bool ";
  protected final String TEXT_303 = "(";
  protected final String TEXT_304 = " ";
  protected final String TEXT_305 = ")" + NL + "  {";
  protected final String TEXT_306 = NL;
  protected final String TEXT_307 = "    return ";
  protected final String TEXT_308 = "(";
  protected final String TEXT_309 = ") != null;" + NL + "  }" + NL;
  protected final String TEXT_310 = NL + "  ";
  protected final String TEXT_311 = " ";
  protected final String TEXT_312 = "::";
  protected final String TEXT_313 = "()" + NL + "  {";
  protected final String TEXT_314 = NL + "    ";
  protected final String TEXT_315 = " ";
  protected final String TEXT_316 = " = ";
  protected final String TEXT_317 = ";";
  protected final String TEXT_318 = NL + "    return ";
  protected final String TEXT_319 = ";" + NL + "  }";
  protected final String TEXT_320 = NL + "  ";
  protected final String TEXT_321 = " ";
  protected final String TEXT_322 = "::";
  protected final String TEXT_323 = "() const" + NL + "  {";
  protected final String TEXT_324 = NL + "    return ";
  protected final String TEXT_325 = ";" + NL + "  }";
  protected final String TEXT_326 = NL + "  ";
  protected final String TEXT_327 = " ";
  protected final String TEXT_328 = "::";
  protected final String TEXT_329 = "()" + NL + "  {" + NL + "    string answer = ";
  protected final String TEXT_330 = "(";
  protected final String TEXT_331 = ");";
  protected final String TEXT_332 = NL + "    return answer;" + NL + "  }" + NL + "  ";
  protected final String TEXT_333 = NL + "  ";
  protected final String TEXT_334 = "::";
  protected final String TEXT_335 = " ";
  protected final String TEXT_336 = "::";
  protected final String TEXT_337 = "()";
  protected final String TEXT_338 = NL + "  ";
  protected final String TEXT_339 = "bool ";
  protected final String TEXT_340 = "::";
  protected final String TEXT_341 = "(";
  protected final String TEXT_342 = ")" + NL + "  {" + NL + "    bool wasEventProcessed = false;" + NL;
  protected final String TEXT_343 = NL + "    ";
  protected final String TEXT_344 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_345 = NL + "  bool ";
  protected final String TEXT_346 = "::";
  protected final String TEXT_347 = "(";
  protected final String TEXT_348 = " ";
  protected final String TEXT_349 = ")" + NL + "  {";
  protected final String TEXT_350 = NL + "    ";
  protected final String TEXT_351 = " = ";
  protected final String TEXT_352 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_353 = NL + "  void ";
  protected final String TEXT_354 = "::";
  protected final String TEXT_355 = "()" + NL + "  {";
  protected final String TEXT_356 = NL + "    switch(";
  protected final String TEXT_357 = ")" + NL + "    {";
  protected final String TEXT_358 = NL + "      ";
  protected final String TEXT_359 = NL + "    }";
  protected final String TEXT_360 = NL + "  }" + NL;
  protected final String TEXT_361 = NL + "  void ";
  protected final String TEXT_362 = "::";
  protected final String TEXT_363 = "(";
  protected final String TEXT_364 = " ";
  protected final String TEXT_365 = ")" + NL + "  {";
  protected final String TEXT_366 = NL + "    ";
  protected final String TEXT_367 = " = ";
  protected final String TEXT_368 = ";";
  protected final String TEXT_369 = NL + "    if (";
  protected final String TEXT_370 = " != ";
  protected final String TEXT_371 = " && ";
  protected final String TEXT_372 = " != ";
  protected final String TEXT_373 = ") { ";
  protected final String TEXT_374 = "(";
  protected final String TEXT_375 = "); }";
  protected final String TEXT_376 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_377 = ")" + NL + "    {";
  protected final String TEXT_378 = NL + "      ";
  protected final String TEXT_379 = NL + "    }";
  protected final String TEXT_380 = NL + "  }" + NL + "  " + NL;
  protected final String TEXT_381 = NL + "  ";
  protected final String TEXT_382 = "* ";
  protected final String TEXT_383 = "::";
  protected final String TEXT_384 = "() " + NL + "  {";
  protected final String TEXT_385 = NL + "    return ";
  protected final String TEXT_386 = ";";
  protected final String TEXT_387 = NL + "    ";
  protected final String TEXT_388 = "* ";
  protected final String TEXT_389 = " = ";
  protected final String TEXT_390 = ";";
  protected final String TEXT_391 = NL + "    return ";
  protected final String TEXT_392 = ";";
  protected final String TEXT_393 = NL + "  }" + NL;
  protected final String TEXT_394 = NL + "  ";
  protected final String TEXT_395 = "* ";
  protected final String TEXT_396 = "::";
  protected final String TEXT_397 = "(int index) " + NL + "  {";
  protected final String TEXT_398 = NL + "    ";
  protected final String TEXT_399 = "* ";
  protected final String TEXT_400 = " = ";
  protected final String TEXT_401 = "[index];";
  protected final String TEXT_402 = NL + "    return ";
  protected final String TEXT_403 = ";" + NL + "  }" + NL + "" + NL + "  vector<";
  protected final String TEXT_404 = "*> ";
  protected final String TEXT_405 = "::";
  protected final String TEXT_406 = "() " + NL + "  {";
  protected final String TEXT_407 = NL + "    vector<";
  protected final String TEXT_408 = "*> ";
  protected final String TEXT_409 = " = ";
  protected final String TEXT_410 = ";";
  protected final String TEXT_411 = NL + "    return ";
  protected final String TEXT_412 = ";" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_413 = "::";
  protected final String TEXT_414 = "()" + NL + "  {";
  protected final String TEXT_415 = NL + "    int number = ";
  protected final String TEXT_416 = ".size();";
  protected final String TEXT_417 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_418 = "::";
  protected final String TEXT_419 = "()" + NL + "  {";
  protected final String TEXT_420 = NL + "    bool has = ";
  protected final String TEXT_421 = ".size() > 0;";
  protected final String TEXT_422 = NL + "    return has;" + NL + "  }" + NL + "  " + NL + "  int ";
  protected final String TEXT_423 = "::";
  protected final String TEXT_424 = "(";
  protected final String TEXT_425 = "* ";
  protected final String TEXT_426 = ")" + NL + "  {";
  protected final String TEXT_427 = NL + "    int index = find(";
  protected final String TEXT_428 = ".begin(), ";
  protected final String TEXT_429 = ".end(), ";
  protected final String TEXT_430 = ") - ";
  protected final String TEXT_431 = ".begin();";
  protected final String TEXT_432 = NL + "    return index;" + NL + "  }" + NL + "  ";
  protected final String TEXT_433 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_434 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_435 = " : ";
  protected final String TEXT_436 = NL + "  bool ";
  protected final String TEXT_437 = "::";
  protected final String TEXT_438 = "()" + NL + "  {";
  protected final String TEXT_439 = NL + "    bool isValid = ";
  protected final String TEXT_440 = "() >= ";
  protected final String TEXT_441 = "();";
  protected final String TEXT_442 = NL + "    bool isValid = ";
  protected final String TEXT_443 = "() >= ";
  protected final String TEXT_444 = "() && ";
  protected final String TEXT_445 = "() <= ";
  protected final String TEXT_446 = "();";
  protected final String TEXT_447 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_448 = NL + "  static int ";
  protected final String TEXT_449 = "::";
  protected final String TEXT_450 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_451 = ";" + NL + "  }";
  protected final String TEXT_452 = NL + "  static int ";
  protected final String TEXT_453 = "::";
  protected final String TEXT_454 = "()" + NL + "  {";
  protected final String TEXT_455 = NL + "    int required = ";
  protected final String TEXT_456 = ";";
  protected final String TEXT_457 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_458 = NL + "  static int ";
  protected final String TEXT_459 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_460 = ";" + NL + "  }";
  protected final String TEXT_461 = NL + "  static int ";
  protected final String TEXT_462 = "::";
  protected final String TEXT_463 = "()" + NL + "  {";
  protected final String TEXT_464 = NL + "    int minimum = ";
  protected final String TEXT_465 = ";";
  protected final String TEXT_466 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_467 = NL + "  static int ";
  protected final String TEXT_468 = "::";
  protected final String TEXT_469 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_470 = ";" + NL + "  }";
  protected final String TEXT_471 = NL + "  static int ";
  protected final String TEXT_472 = "::";
  protected final String TEXT_473 = "()" + NL + "  {";
  protected final String TEXT_474 = NL + "    int maximum = ";
  protected final String TEXT_475 = ";";
  protected final String TEXT_476 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_477 = NL + "  bool ";
  protected final String TEXT_478 = "::";
  protected final String TEXT_479 = "(";
  protected final String TEXT_480 = "* ";
  protected final String TEXT_481 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_482 = NL + "    if (";
  protected final String TEXT_483 = "() >= ";
  protected final String TEXT_484 = "())" + NL + "    {";
  protected final String TEXT_485 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_486 = NL + "    ";
  protected final String TEXT_487 = ".push_back(";
  protected final String TEXT_488 = ");" + NL + "    if (";
  protected final String TEXT_489 = "->";
  protected final String TEXT_490 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_491 = ".";
  protected final String TEXT_492 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_493 = NL + "        ";
  protected final String TEXT_494 = ".erase(find(";
  protected final String TEXT_495 = ".begin(),";
  protected final String TEXT_496 = ".end(),";
  protected final String TEXT_497 = "));" + NL + "      }" + NL + "    }";
  protected final String TEXT_498 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_499 = NL + "  bool ";
  protected final String TEXT_500 = "::";
  protected final String TEXT_501 = "(";
  protected final String TEXT_502 = " ";
  protected final String TEXT_503 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_504 = NL + "    if (!find(";
  protected final String TEXT_505 = ".begin(),";
  protected final String TEXT_506 = ".end(),";
  protected final String TEXT_507 = "))" + NL + "    {";
  protected final String TEXT_508 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = find(";
  protected final String TEXT_509 = ".begin(), ";
  protected final String TEXT_510 = ".end(), ";
  protected final String TEXT_511 = ") - ";
  protected final String TEXT_512 = ".begin();";
  protected final String TEXT_513 = NL + "    ";
  protected final String TEXT_514 = ".erase(find(";
  protected final String TEXT_515 = ".begin(),";
  protected final String TEXT_516 = ".end(),";
  protected final String TEXT_517 = "));" + NL + "    if (";
  protected final String TEXT_518 = "->";
  protected final String TEXT_519 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_520 = "->";
  protected final String TEXT_521 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_522 = NL + "        ";
  protected final String TEXT_523 = ".push_back(oldIndex,";
  protected final String TEXT_524 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_525 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_526 = NL + "  bool ";
  protected final String TEXT_527 = "::";
  protected final String TEXT_528 = "(";
  protected final String TEXT_529 = "* ";
  protected final String TEXT_530 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_531 = NL + "    ";
  protected final String TEXT_532 = " = ";
  protected final String TEXT_533 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_534 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_535 = NL + "  bool ";
  protected final String TEXT_536 = "::";
  protected final String TEXT_537 = "(";
  protected final String TEXT_538 = "* ";
  protected final String TEXT_539 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_540 = NL + "    if (";
  protected final String TEXT_541 = " != NULL)" + NL + "    {";
  protected final String TEXT_542 = NL + "      ";
  protected final String TEXT_543 = " = ";
  protected final String TEXT_544 = ";" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_545 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_546 = NL + "  bool ";
  protected final String TEXT_547 = "::";
  protected final String TEXT_548 = "(";
  protected final String TEXT_549 = "* ";
  protected final String TEXT_550 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_551 = NL + "    if (";
  protected final String TEXT_552 = " != NULL && ";
  protected final String TEXT_553 = "!=";
  protected final String TEXT_554 = " && = ";
  protected final String TEXT_555 = "->";
  protected final String TEXT_556 = "())" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_557 = ", as existing ";
  protected final String TEXT_558 = " would become an orphan";
  protected final String TEXT_559 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_560 = NL + "    ";
  protected final String TEXT_561 = " = ";
  protected final String TEXT_562 = ";";
  protected final String TEXT_563 = NL + "    ";
  protected final String TEXT_564 = " ";
  protected final String TEXT_565 = " = ";
  protected final String TEXT_566 = " != NULL ? ";
  protected final String TEXT_567 = "->";
  protected final String TEXT_568 = "() : NULL;" + NL + "" + NL + "    if (this!=";
  protected final String TEXT_569 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_570 = " != NULL)" + NL + "      {";
  protected final String TEXT_571 = NL + "        ";
  protected final String TEXT_572 = "->";
  protected final String TEXT_573 = " = NULL;" + NL + "      }" + NL + "      if (";
  protected final String TEXT_574 = " != NULL)" + NL + "      {";
  protected final String TEXT_575 = NL + "        ";
  protected final String TEXT_576 = "->";
  protected final String TEXT_577 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_578 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_579 = NL + "  bool ";
  protected final String TEXT_580 = "::";
  protected final String TEXT_581 = "(";
  protected final String TEXT_582 = " ";
  protected final String TEXT_583 = ")" + NL + "  {" + NL + "    bool";
  protected final String TEXT_584 = NL + "    if (";
  protected final String TEXT_585 = " == NULL)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_586 = " to null, as ";
  protected final String TEXT_587 = " must always be associated to a ";
  protected final String TEXT_588 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_589 = NL + "    ";
  protected final String TEXT_590 = "* ";
  protected final String TEXT_591 = " = ";
  protected final String TEXT_592 = "->";
  protected final String TEXT_593 = "();" + NL + "    if (";
  protected final String TEXT_594 = " != NULL && !=";
  protected final String TEXT_595 = ")" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_596 = ", the current ";
  protected final String TEXT_597 = " already has a ";
  protected final String TEXT_598 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_599 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_600 = NL + "    ";
  protected final String TEXT_601 = "* ";
  protected final String TEXT_602 = " = ";
  protected final String TEXT_603 = ";";
  protected final String TEXT_604 = NL + "    ";
  protected final String TEXT_605 = " = ";
  protected final String TEXT_606 = ";";
  protected final String TEXT_607 = NL + "    ";
  protected final String TEXT_608 = "->";
  protected final String TEXT_609 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_610 = " != NULL)" + NL + "    {";
  protected final String TEXT_611 = NL + "      ";
  protected final String TEXT_612 = "->";
  protected final String TEXT_613 = "(null);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_614 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_615 = NL + "  ";
  protected final String TEXT_616 = " ";
  protected final String TEXT_617 = "::";
  protected final String TEXT_618 = "(";
  protected final String TEXT_619 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_620 = "(";
  protected final String TEXT_621 = ");" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_622 = "::";
  protected final String TEXT_623 = "(";
  protected final String TEXT_624 = "* ";
  protected final String TEXT_625 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_626 = NL + "    ";
  protected final String TEXT_627 = " ";
  protected final String TEXT_628 = " = ";
  protected final String TEXT_629 = "->";
  protected final String TEXT_630 = "();" + NL + "    bool ";
  protected final String TEXT_631 = " = (";
  protected final String TEXT_632 = " != NULL && this != ";
  protected final String TEXT_633 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_634 = " && ";
  protected final String TEXT_635 = "->";
  protected final String TEXT_636 = "() <= ";
  protected final String TEXT_637 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_638 = ")" + NL + "    {";
  protected final String TEXT_639 = NL + "      ";
  protected final String TEXT_640 = "->";
  protected final String TEXT_641 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_642 = NL + "      ";
  protected final String TEXT_643 = ".add(";
  protected final String TEXT_644 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_645 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_646 = "::";
  protected final String TEXT_647 = "(";
  protected final String TEXT_648 = "* ";
  protected final String TEXT_649 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\t";
  protected final String TEXT_650 = NL + "    //Unable to remove ";
  protected final String TEXT_651 = ", as it must always have a ";
  protected final String TEXT_652 = NL + "    if (this == ";
  protected final String TEXT_653 = "->";
  protected final String TEXT_654 = "()))" + NL + "    {";
  protected final String TEXT_655 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_656 = " already at minimum (";
  protected final String TEXT_657 = ")" + NL + "    if (";
  protected final String TEXT_658 = "() <= ";
  protected final String TEXT_659 = "())" + NL + "    {";
  protected final String TEXT_660 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_661 = NL + "    ";
  protected final String TEXT_662 = ".remove(";
  protected final String TEXT_663 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_664 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_665 = NL + "  ";
  protected final String TEXT_666 = " ";
  protected final String TEXT_667 = "::";
  protected final String TEXT_668 = "(";
  protected final String TEXT_669 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_670 = "() >= ";
  protected final String TEXT_671 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_672 = "(";
  protected final String TEXT_673 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_674 = "::";
  protected final String TEXT_675 = "(";
  protected final String TEXT_676 = "* ";
  protected final String TEXT_677 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_678 = NL + "    if (";
  protected final String TEXT_679 = "() >= ";
  protected final String TEXT_680 = "())" + NL + "    {";
  protected final String TEXT_681 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_682 = NL + "    ";
  protected final String TEXT_683 = " ";
  protected final String TEXT_684 = " = ";
  protected final String TEXT_685 = "->";
  protected final String TEXT_686 = "();" + NL + "    bool ";
  protected final String TEXT_687 = " = (";
  protected final String TEXT_688 = " != NULL && this!=";
  protected final String TEXT_689 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_690 = " && ";
  protected final String TEXT_691 = "->";
  protected final String TEXT_692 = "() <= ";
  protected final String TEXT_693 = "())" + NL + "    {";
  protected final String TEXT_694 = NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_695 = ")" + NL + "    {";
  protected final String TEXT_696 = NL + "      ";
  protected final String TEXT_697 = "->";
  protected final String TEXT_698 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_699 = NL + "      ";
  protected final String TEXT_700 = ".add(";
  protected final String TEXT_701 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_702 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_703 = "::";
  protected final String TEXT_704 = "(";
  protected final String TEXT_705 = "* ";
  protected final String TEXT_706 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_707 = ".begin(), ";
  protected final String TEXT_708 = ".end(), ";
  protected final String TEXT_709 = ") - ";
  protected final String TEXT_710 = ".begin();";
  protected final String TEXT_711 = NL + "    //Unable to remove ";
  protected final String TEXT_712 = ", as it must always have a ";
  protected final String TEXT_713 = NL + "    if (this == ";
  protected final String TEXT_714 = "->";
  protected final String TEXT_715 = "())" + NL + "    {";
  protected final String TEXT_716 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_717 = " already at minimum (";
  protected final String TEXT_718 = ")" + NL + "    if (";
  protected final String TEXT_719 = "() <= ";
  protected final String TEXT_720 = "())" + NL + "    {";
  protected final String TEXT_721 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_722 = NL + "    ";
  protected final String TEXT_723 = ".erase(find(";
  protected final String TEXT_724 = ".begin(),";
  protected final String TEXT_725 = ".end(),";
  protected final String TEXT_726 = "));" + NL + "\tdelete ";
  protected final String TEXT_727 = "[index];" + NL + "    wasRemoved = true;";
  protected final String TEXT_728 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_729 = NL + "  ";
  protected final String TEXT_730 = " ";
  protected final String TEXT_731 = "::";
  protected final String TEXT_732 = "(";
  protected final String TEXT_733 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_734 = "() >= ";
  protected final String TEXT_735 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_736 = "(";
  protected final String TEXT_737 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_738 = "::";
  protected final String TEXT_739 = "(";
  protected final String TEXT_740 = "* ";
  protected final String TEXT_741 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_742 = NL + "    if (";
  protected final String TEXT_743 = "() >= ";
  protected final String TEXT_744 = "())" + NL + "    {";
  protected final String TEXT_745 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_746 = NL + "    ";
  protected final String TEXT_747 = " ";
  protected final String TEXT_748 = " = ";
  protected final String TEXT_749 = "->";
  protected final String TEXT_750 = "();" + NL + "    bool ";
  protected final String TEXT_751 = " = (";
  protected final String TEXT_752 = " != NULL && this != ";
  protected final String TEXT_753 = ");" + NL + "    if (";
  protected final String TEXT_754 = ")" + NL + "    {";
  protected final String TEXT_755 = NL + "      ";
  protected final String TEXT_756 = "->";
  protected final String TEXT_757 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_758 = NL + "      ";
  protected final String TEXT_759 = ".push_back(";
  protected final String TEXT_760 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_761 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_762 = "::";
  protected final String TEXT_763 = "(";
  protected final String TEXT_764 = "* ";
  protected final String TEXT_765 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_766 = ".begin(), ";
  protected final String TEXT_767 = ".end(), ";
  protected final String TEXT_768 = ") - ";
  protected final String TEXT_769 = ".begin();";
  protected final String TEXT_770 = NL + "    //Unable to remove ";
  protected final String TEXT_771 = ", as it must always have a ";
  protected final String TEXT_772 = NL + "    if (this != ";
  protected final String TEXT_773 = "->";
  protected final String TEXT_774 = "())" + NL + "    {";
  protected final String TEXT_775 = NL + "      ";
  protected final String TEXT_776 = ".erase(find(";
  protected final String TEXT_777 = ".begin(),";
  protected final String TEXT_778 = ".end(),";
  protected final String TEXT_779 = "));" + NL + "\t  delete ";
  protected final String TEXT_780 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_781 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_782 = NL + "  bool ";
  protected final String TEXT_783 = "::";
  protected final String TEXT_784 = "(";
  protected final String TEXT_785 = "... ";
  protected final String TEXT_786 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_787 = NL + "    vector<";
  protected final String TEXT_788 = "*> ";
  protected final String TEXT_789 = ";" + NL + "\t" + NL + "    for (";
  protected final String TEXT_790 = " ";
  protected final String TEXT_791 = " : ";
  protected final String TEXT_792 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_793 = ".begin(),";
  protected final String TEXT_794 = ".end(),";
  protected final String TEXT_795 = ") != ";
  protected final String TEXT_796 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_797 = NL + "      ";
  protected final String TEXT_798 = "->add(";
  protected final String TEXT_799 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_800 = ".size() != ";
  protected final String TEXT_801 = ".length || ";
  protected final String TEXT_802 = ".size() > ";
  protected final String TEXT_803 = "())" + NL + "    {";
  protected final String TEXT_804 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_805 = "*> ";
  protected final String TEXT_806 = ";";
  protected final String TEXT_807 = NL + "    ";
  protected final String TEXT_808 = ".clear();" + NL + "    for (";
  protected final String TEXT_809 = " ";
  protected final String TEXT_810 = " : ";
  protected final String TEXT_811 = ")" + NL + "    {";
  protected final String TEXT_812 = NL + "      ";
  protected final String TEXT_813 = "->add(";
  protected final String TEXT_814 = ");" + NL + "      if (find(";
  protected final String TEXT_815 = ".begin(),";
  protected final String TEXT_816 = ".end(),";
  protected final String TEXT_817 = ") != ";
  protected final String TEXT_818 = ".end())" + NL + "      {";
  protected final String TEXT_819 = NL + "        ";
  protected final String TEXT_820 = ".erase(";
  protected final String TEXT_821 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_822 = NL + "        ";
  protected final String TEXT_823 = "->";
  protected final String TEXT_824 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_825 = " ";
  protected final String TEXT_826 = " : ";
  protected final String TEXT_827 = ")" + NL + "    {";
  protected final String TEXT_828 = NL + "      ";
  protected final String TEXT_829 = "->";
  protected final String TEXT_830 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_831 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_832 = NL + "  ";
  protected final String TEXT_833 = " ";
  protected final String TEXT_834 = "::";
  protected final String TEXT_835 = "(";
  protected final String TEXT_836 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_837 = "(";
  protected final String TEXT_838 = ");" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_839 = "::";
  protected final String TEXT_840 = "(";
  protected final String TEXT_841 = "* ";
  protected final String TEXT_842 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_843 = NL + "    ";
  protected final String TEXT_844 = "* ";
  protected final String TEXT_845 = " = ";
  protected final String TEXT_846 = "->";
  protected final String TEXT_847 = "();" + NL + "    bool ";
  protected final String TEXT_848 = " = (";
  protected final String TEXT_849 = " != NULL && this!=";
  protected final String TEXT_850 = ");" + NL + "    if (";
  protected final String TEXT_851 = ")" + NL + "    {";
  protected final String TEXT_852 = NL + "      ";
  protected final String TEXT_853 = "->";
  protected final String TEXT_854 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_855 = NL + "      ";
  protected final String TEXT_856 = ".push_back(";
  protected final String TEXT_857 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_858 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_859 = "::";
  protected final String TEXT_860 = "(";
  protected final String TEXT_861 = "* ";
  protected final String TEXT_862 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_863 = ".begin(), ";
  protected final String TEXT_864 = ".end(), ";
  protected final String TEXT_865 = ") - ";
  protected final String TEXT_866 = ".begin();";
  protected final String TEXT_867 = NL + "    //Unable to remove ";
  protected final String TEXT_868 = ", as it must always have a ";
  protected final String TEXT_869 = NL + "    if (this!=";
  protected final String TEXT_870 = "->";
  protected final String TEXT_871 = "())" + NL + "    {";
  protected final String TEXT_872 = NL + "      ";
  protected final String TEXT_873 = ".erase(find(";
  protected final String TEXT_874 = ".begin(),";
  protected final String TEXT_875 = ".end(),";
  protected final String TEXT_876 = "));" + NL + "\t  delete ";
  protected final String TEXT_877 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_878 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_879 = NL + "  bool ";
  protected final String TEXT_880 = "::";
  protected final String TEXT_881 = "(";
  protected final String TEXT_882 = "* ";
  protected final String TEXT_883 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_884 = NL + "    if (";
  protected final String TEXT_885 = " == NULL)" + NL + "    {";
  protected final String TEXT_886 = NL + "      ";
  protected final String TEXT_887 = " ";
  protected final String TEXT_888 = " = ";
  protected final String TEXT_889 = ";";
  protected final String TEXT_890 = NL + "      ";
  protected final String TEXT_891 = " = NULL;" + NL + "      " + NL + "      if (";
  protected final String TEXT_892 = " != NULL && ";
  protected final String TEXT_893 = "->";
  protected final String TEXT_894 = "() != NULL)" + NL + "      {";
  protected final String TEXT_895 = NL + "        ";
  protected final String TEXT_896 = "->";
  protected final String TEXT_897 = "(NULL);" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_898 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_899 = NL + "    ";
  protected final String TEXT_900 = "* ";
  protected final String TEXT_901 = " = ";
  protected final String TEXT_902 = "();" + NL + "    if (";
  protected final String TEXT_903 = " != NULL && ";
  protected final String TEXT_904 = "!=";
  protected final String TEXT_905 = ")" + NL + "    {";
  protected final String TEXT_906 = NL + "      ";
  protected final String TEXT_907 = "->";
  protected final String TEXT_908 = "(NULL);" + NL + "    }" + NL;
  protected final String TEXT_909 = NL + "    ";
  protected final String TEXT_910 = " = ";
  protected final String TEXT_911 = ";";
  protected final String TEXT_912 = NL + "    ";
  protected final String TEXT_913 = "* ";
  protected final String TEXT_914 = " = ";
  protected final String TEXT_915 = "->";
  protected final String TEXT_916 = "();" + NL + "" + NL + "    if (!=";
  protected final String TEXT_917 = ")" + NL + "    {";
  protected final String TEXT_918 = NL + "      ";
  protected final String TEXT_919 = "->";
  protected final String TEXT_920 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_921 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_922 = NL + "  bool ";
  protected final String TEXT_923 = "::";
  protected final String TEXT_924 = "(";
  protected final String TEXT_925 = "* ";
  protected final String TEXT_926 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_927 = ".begin(), ";
  protected final String TEXT_928 = ".end(), ";
  protected final String TEXT_929 = ") - ";
  protected final String TEXT_930 = ".begin();";
  protected final String TEXT_931 = NL + "    if (! find(";
  protected final String TEXT_932 = ".begin(),";
  protected final String TEXT_933 = ".end(),";
  protected final String TEXT_934 = "))" + NL + "    {";
  protected final String TEXT_935 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_936 = "() <= ";
  protected final String TEXT_937 = "())" + NL + "    {";
  protected final String TEXT_938 = NL + "      return wasRemoved;" + NL + "    }" + NL + "\t" + NL + "    int oldIndex = find(";
  protected final String TEXT_939 = ".begin(), ";
  protected final String TEXT_940 = ".end(), ";
  protected final String TEXT_941 = ") - ";
  protected final String TEXT_942 = ".begin();";
  protected final String TEXT_943 = NL + "    ";
  protected final String TEXT_944 = ".erase(find(";
  protected final String TEXT_945 = ".begin(), ";
  protected final String TEXT_946 = ".end(), ";
  protected final String TEXT_947 = "));" + NL + "\tdelete ";
  protected final String TEXT_948 = "[oldIndex];" + NL + "    if (";
  protected final String TEXT_949 = "->";
  protected final String TEXT_950 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_951 = "->";
  protected final String TEXT_952 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_953 = NL + "        ";
  protected final String TEXT_954 = "->add(oldIndex,";
  protected final String TEXT_955 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_956 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_957 = NL + "  bool ";
  protected final String TEXT_958 = "::";
  protected final String TEXT_959 = "(";
  protected final String TEXT_960 = "* ";
  protected final String TEXT_961 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_962 = ".begin(), ";
  protected final String TEXT_963 = ".end(), ";
  protected final String TEXT_964 = ") - ";
  protected final String TEXT_965 = ".begin();";
  protected final String TEXT_966 = NL + "    if (! find(";
  protected final String TEXT_967 = ".begin(),";
  protected final String TEXT_968 = ".end(),";
  protected final String TEXT_969 = ") != ";
  protected final String TEXT_970 = ".end())" + NL + "    {";
  protected final String TEXT_971 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_972 = "() <= ";
  protected final String TEXT_973 = "())" + NL + "    {";
  protected final String TEXT_974 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = find(";
  protected final String TEXT_975 = ".begin(), ";
  protected final String TEXT_976 = ".end(), ";
  protected final String TEXT_977 = ") - ";
  protected final String TEXT_978 = ".begin();";
  protected final String TEXT_979 = NL + "    ";
  protected final String TEXT_980 = ".erase(oldIndex);" + NL + "\tdelete ";
  protected final String TEXT_981 = "[oldIndex];" + NL + "    if (";
  protected final String TEXT_982 = "->";
  protected final String TEXT_983 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_984 = ".";
  protected final String TEXT_985 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_986 = NL + "        ";
  protected final String TEXT_987 = ".add(oldIndex,";
  protected final String TEXT_988 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_989 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_990 = NL + "  bool ";
  protected final String TEXT_991 = "::";
  protected final String TEXT_992 = "(";
  protected final String TEXT_993 = "* ";
  protected final String TEXT_994 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_995 = NL + "    if (";
  protected final String TEXT_996 = " != NULL && ";
  protected final String TEXT_997 = "->";
  protected final String TEXT_998 = "() >= ";
  protected final String TEXT_999 = "->";
  protected final String TEXT_1000 = "())" + NL + "    {";
  protected final String TEXT_1001 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1002 = NL + "    ";
  protected final String TEXT_1003 = "* ";
  protected final String TEXT_1004 = " = ";
  protected final String TEXT_1005 = ";";
  protected final String TEXT_1006 = NL + "    ";
  protected final String TEXT_1007 = " = ";
  protected final String TEXT_1008 = ";" + NL + "    if (";
  protected final String TEXT_1009 = " != NULL && ";
  protected final String TEXT_1010 = "!=";
  protected final String TEXT_1011 = ")" + NL + "    {";
  protected final String TEXT_1012 = NL + "      ";
  protected final String TEXT_1013 = "->";
  protected final String TEXT_1014 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1015 = " != null)" + NL + "    {";
  protected final String TEXT_1016 = NL + "      ";
  protected final String TEXT_1017 = "->";
  protected final String TEXT_1018 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1019 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1020 = NL + "  bool ";
  protected final String TEXT_1021 = "::";
  protected final String TEXT_1022 = "(";
  protected final String TEXT_1023 = "* ";
  protected final String TEXT_1024 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1025 = NL + "    if (";
  protected final String TEXT_1026 = " == NULL)" + NL + "    {";
  protected final String TEXT_1027 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1028 = NL + "    ";
  protected final String TEXT_1029 = "* ";
  protected final String TEXT_1030 = " = ";
  protected final String TEXT_1031 = ";";
  protected final String TEXT_1032 = NL + "    ";
  protected final String TEXT_1033 = " = ";
  protected final String TEXT_1034 = ";" + NL + "    if (";
  protected final String TEXT_1035 = " != NULL && ";
  protected final String TEXT_1036 = "!=";
  protected final String TEXT_1037 = ")" + NL + "    {";
  protected final String TEXT_1038 = NL + "      ";
  protected final String TEXT_1039 = "->";
  protected final String TEXT_1040 = "(this);" + NL + "    }";
  protected final String TEXT_1041 = NL + "    ";
  protected final String TEXT_1042 = "->";
  protected final String TEXT_1043 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1044 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1045 = NL + "  bool ";
  protected final String TEXT_1046 = "::";
  protected final String TEXT_1047 = "(";
  protected final String TEXT_1048 = "* ";
  protected final String TEXT_1049 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1050 = NL + "    //Must provide ";
  protected final String TEXT_1051 = " to ";
  protected final String TEXT_1052 = NL + "    if (";
  protected final String TEXT_1053 = " == NULL)" + NL + "    {";
  protected final String TEXT_1054 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1055 = " already at maximum (";
  protected final String TEXT_1056 = ")" + NL + "    if (";
  protected final String TEXT_1057 = "->";
  protected final String TEXT_1058 = "() >= ";
  protected final String TEXT_1059 = "->";
  protected final String TEXT_1060 = "())" + NL + "    {";
  protected final String TEXT_1061 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1062 = NL + "    ";
  protected final String TEXT_1063 = "* ";
  protected final String TEXT_1064 = " = ";
  protected final String TEXT_1065 = ";";
  protected final String TEXT_1066 = NL + "    ";
  protected final String TEXT_1067 = " = ";
  protected final String TEXT_1068 = ";" + NL + "    if (";
  protected final String TEXT_1069 = " != NULL && ";
  protected final String TEXT_1070 = "!=";
  protected final String TEXT_1071 = "))" + NL + "    {" + NL + "      bool didRemove = ";
  protected final String TEXT_1072 = "->";
  protected final String TEXT_1073 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1074 = NL + "        ";
  protected final String TEXT_1075 = " = ";
  protected final String TEXT_1076 = ";";
  protected final String TEXT_1077 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1078 = NL + "    ";
  protected final String TEXT_1079 = "->";
  protected final String TEXT_1080 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1081 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1082 = NL + "  bool ";
  protected final String TEXT_1083 = "::";
  protected final String TEXT_1084 = "(";
  protected final String TEXT_1085 = "* ";
  protected final String TEXT_1086 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1087 = NL + "    //Must provide ";
  protected final String TEXT_1088 = " to ";
  protected final String TEXT_1089 = NL + "    if (";
  protected final String TEXT_1090 = " == NULL)" + NL + "    {";
  protected final String TEXT_1091 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1092 = " != NULL && ";
  protected final String TEXT_1093 = ".";
  protected final String TEXT_1094 = "() <= ";
  protected final String TEXT_1095 = ".";
  protected final String TEXT_1096 = "())" + NL + "    {";
  protected final String TEXT_1097 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1098 = NL + "    ";
  protected final String TEXT_1099 = "* ";
  protected final String TEXT_1100 = " = ";
  protected final String TEXT_1101 = ";";
  protected final String TEXT_1102 = NL + "    ";
  protected final String TEXT_1103 = " = ";
  protected final String TEXT_1104 = ";" + NL + "    if (";
  protected final String TEXT_1105 = " != NULL && ";
  protected final String TEXT_1106 = "!=";
  protected final String TEXT_1107 = ")" + NL + "    {" + NL + "      bool didRemove = ";
  protected final String TEXT_1108 = "->";
  protected final String TEXT_1109 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1110 = NL + "        ";
  protected final String TEXT_1111 = " = ";
  protected final String TEXT_1112 = ";";
  protected final String TEXT_1113 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1114 = NL + "    ";
  protected final String TEXT_1115 = "->";
  protected final String TEXT_1116 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1117 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1118 = NL + "  bool ";
  protected final String TEXT_1119 = "::";
  protected final String TEXT_1120 = "(";
  protected final String TEXT_1121 = "* ";
  protected final String TEXT_1122 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1123 = NL + "    ";
  protected final String TEXT_1124 = "* ";
  protected final String TEXT_1125 = " = ";
  protected final String TEXT_1126 = "->";
  protected final String TEXT_1127 = "();" + NL + "    if (";
  protected final String TEXT_1128 = " == NULL)" + NL + "    {";
  protected final String TEXT_1129 = NL + "      ";
  protected final String TEXT_1130 = "->";
  protected final String TEXT_1131 = "(this);" + NL + "    }" + NL + "    else if (this!=";
  protected final String TEXT_1132 = ")" + NL + "    {";
  protected final String TEXT_1133 = NL + "      ";
  protected final String TEXT_1134 = "->";
  protected final String TEXT_1135 = "(";
  protected final String TEXT_1136 = ");";
  protected final String TEXT_1137 = NL + "      ";
  protected final String TEXT_1138 = "(";
  protected final String TEXT_1139 = ");" + NL + "    } " + NL + "    else" + NL + "    {";
  protected final String TEXT_1140 = NL + "      ";
  protected final String TEXT_1141 = ".push_back(";
  protected final String TEXT_1142 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1143 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1144 = "::";
  protected final String TEXT_1145 = "(";
  protected final String TEXT_1146 = "* ";
  protected final String TEXT_1147 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1148 = ".begin(), ";
  protected final String TEXT_1149 = ".end(), ";
  protected final String TEXT_1150 = ") - ";
  protected final String TEXT_1151 = ".begin();";
  protected final String TEXT_1152 = NL + "    if (find(";
  protected final String TEXT_1153 = ".begin(),";
  protected final String TEXT_1154 = ".end(),";
  protected final String TEXT_1155 = ")!= ";
  protected final String TEXT_1156 = ".end())" + NL + "    {";
  protected final String TEXT_1157 = NL + "      ";
  protected final String TEXT_1158 = ".erase(find(";
  protected final String TEXT_1159 = ".begin(),";
  protected final String TEXT_1160 = ".end(),";
  protected final String TEXT_1161 = "));";
  protected final String TEXT_1162 = NL + "      ";
  protected final String TEXT_1163 = "->";
  protected final String TEXT_1164 = "(NULL);" + NL + "\t  delete ";
  protected final String TEXT_1165 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1166 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1167 = NL + "  bool ";
  protected final String TEXT_1168 = "::";
  protected final String TEXT_1169 = "(";
  protected final String TEXT_1170 = "* ";
  protected final String TEXT_1171 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1172 = NL + "    ";
  protected final String TEXT_1173 = "* ";
  protected final String TEXT_1174 = " = ";
  protected final String TEXT_1175 = ";";
  protected final String TEXT_1176 = NL + "    ";
  protected final String TEXT_1177 = " = ";
  protected final String TEXT_1178 = ";" + NL + "    if (";
  protected final String TEXT_1179 = " != NULL && ";
  protected final String TEXT_1180 = "!=";
  protected final String TEXT_1181 = ")" + NL + "    {";
  protected final String TEXT_1182 = NL + "      ";
  protected final String TEXT_1183 = "->";
  protected final String TEXT_1184 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1185 = " != NULL)" + NL + "    {";
  protected final String TEXT_1186 = NL + "      ";
  protected final String TEXT_1187 = "->";
  protected final String TEXT_1188 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1189 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1190 = NL + "  bool ";
  protected final String TEXT_1191 = "::";
  protected final String TEXT_1192 = "(";
  protected final String TEXT_1193 = "* ";
  protected final String TEXT_1194 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1195 = NL + "    if (";
  protected final String TEXT_1196 = "() >= ";
  protected final String TEXT_1197 = "())" + NL + "    {";
  protected final String TEXT_1198 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1199 = NL + "    ";
  protected final String TEXT_1200 = " ";
  protected final String TEXT_1201 = " = ";
  protected final String TEXT_1202 = "->";
  protected final String TEXT_1203 = "();" + NL + "    if (";
  protected final String TEXT_1204 = " == NULL)" + NL + "    {";
  protected final String TEXT_1205 = NL + "      ";
  protected final String TEXT_1206 = "->";
  protected final String TEXT_1207 = "(this);" + NL + "    }" + NL + "    else if (this!=";
  protected final String TEXT_1208 = ")" + NL + "    {";
  protected final String TEXT_1209 = NL + "      ";
  protected final String TEXT_1210 = "->";
  protected final String TEXT_1211 = "(";
  protected final String TEXT_1212 = ");";
  protected final String TEXT_1213 = NL + "      ";
  protected final String TEXT_1214 = "(";
  protected final String TEXT_1215 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1216 = NL + "      ";
  protected final String TEXT_1217 = ".push_back(";
  protected final String TEXT_1218 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1219 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1220 = "::";
  protected final String TEXT_1221 = "(";
  protected final String TEXT_1222 = "* ";
  protected final String TEXT_1223 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1224 = ".begin(), ";
  protected final String TEXT_1225 = ".end(), ";
  protected final String TEXT_1226 = ") - ";
  protected final String TEXT_1227 = ".begin();";
  protected final String TEXT_1228 = NL + "    if (find(";
  protected final String TEXT_1229 = ".begin(),";
  protected final String TEXT_1230 = ".end(),";
  protected final String TEXT_1231 = ") != ";
  protected final String TEXT_1232 = ".end())" + NL + "    {";
  protected final String TEXT_1233 = NL + "      ";
  protected final String TEXT_1234 = ".remove(";
  protected final String TEXT_1235 = ");";
  protected final String TEXT_1236 = NL + "      ";
  protected final String TEXT_1237 = "->";
  protected final String TEXT_1238 = "(NULL);" + NL + "\t  delete ";
  protected final String TEXT_1239 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1240 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1241 = NL + "  bool ";
  protected final String TEXT_1242 = "::";
  protected final String TEXT_1243 = "(";
  protected final String TEXT_1244 = " ";
  protected final String TEXT_1245 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1246 = NL + "    if (";
  protected final String TEXT_1247 = "() < ";
  protected final String TEXT_1248 = "())" + NL + "    {";
  protected final String TEXT_1249 = NL + "      ";
  protected final String TEXT_1250 = ".push_back(";
  protected final String TEXT_1251 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1252 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1253 = "::";
  protected final String TEXT_1254 = "(";
  protected final String TEXT_1255 = "* ";
  protected final String TEXT_1256 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1257 = ".begin(), ";
  protected final String TEXT_1258 = ".end(), ";
  protected final String TEXT_1259 = ") - ";
  protected final String TEXT_1260 = ".begin();";
  protected final String TEXT_1261 = NL + "    if (!find(";
  protected final String TEXT_1262 = ".begin(),";
  protected final String TEXT_1263 = ".end(),";
  protected final String TEXT_1264 = ") != ";
  protected final String TEXT_1265 = ".end())" + NL + "    {";
  protected final String TEXT_1266 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1267 = "() <= ";
  protected final String TEXT_1268 = "())" + NL + "    {";
  protected final String TEXT_1269 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1270 = NL + "    ";
  protected final String TEXT_1271 = ".erase(find(";
  protected final String TEXT_1272 = ".begin(),";
  protected final String TEXT_1273 = ".end(),";
  protected final String TEXT_1274 = "));" + NL + "\tdelete ";
  protected final String TEXT_1275 = "[index];" + NL + "    wasRemoved = true;";
  protected final String TEXT_1276 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1277 = NL + "  bool ";
  protected final String TEXT_1278 = "::";
  protected final String TEXT_1279 = "(";
  protected final String TEXT_1280 = "* ";
  protected final String TEXT_1281 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1282 = NL + "    if (";
  protected final String TEXT_1283 = "() >= ";
  protected final String TEXT_1284 = "())" + NL + "    {";
  protected final String TEXT_1285 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1286 = NL + "    ";
  protected final String TEXT_1287 = " ";
  protected final String TEXT_1288 = " = ";
  protected final String TEXT_1289 = "->";
  protected final String TEXT_1290 = "();" + NL + "    if (";
  protected final String TEXT_1291 = " != NULL && ";
  protected final String TEXT_1292 = "->";
  protected final String TEXT_1293 = "() <= ";
  protected final String TEXT_1294 = "())" + NL + "    {";
  protected final String TEXT_1295 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1296 = " != null)" + NL + "    {";
  protected final String TEXT_1297 = NL + "      ";
  protected final String TEXT_1298 = ".";
  protected final String TEXT_1299 = ".erase(find(";
  protected final String TEXT_1300 = ".begin(),";
  protected final String TEXT_1301 = ".end(),";
  protected final String TEXT_1302 = "));" + NL + "    }";
  protected final String TEXT_1303 = NL + "    ";
  protected final String TEXT_1304 = ".push_back(";
  protected final String TEXT_1305 = ");";
  protected final String TEXT_1306 = NL + "    ";
  protected final String TEXT_1307 = "(";
  protected final String TEXT_1308 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1309 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1310 = "::";
  protected final String TEXT_1311 = "(";
  protected final String TEXT_1312 = "* ";
  protected final String TEXT_1313 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1314 = ".begin(), ";
  protected final String TEXT_1315 = ".end(), ";
  protected final String TEXT_1316 = ") - ";
  protected final String TEXT_1317 = ".begin();";
  protected final String TEXT_1318 = NL + "    if ((find(";
  protected final String TEXT_1319 = ".begin(),";
  protected final String TEXT_1320 = ".end(),";
  protected final String TEXT_1321 = ") !=";
  protected final String TEXT_1322 = ".end()) && ";
  protected final String TEXT_1323 = "() > ";
  protected final String TEXT_1324 = "())" + NL + "    {";
  protected final String TEXT_1325 = NL + "      ";
  protected final String TEXT_1326 = ".erase(find(";
  protected final String TEXT_1327 = ".begin(),";
  protected final String TEXT_1328 = ".end(),";
  protected final String TEXT_1329 = "));";
  protected final String TEXT_1330 = NL + "      ";
  protected final String TEXT_1331 = "(";
  protected final String TEXT_1332 = ",NULL);" + NL + "\t  delete ";
  protected final String TEXT_1333 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1334 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1335 = NL + "  bool ";
  protected final String TEXT_1336 = "::";
  protected final String TEXT_1337 = "(";
  protected final String TEXT_1338 = "... ";
  protected final String TEXT_1339 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1340 = NL + "    vector<";
  protected final String TEXT_1341 = "*> ";
  protected final String TEXT_1342 = ";" + NL + "\t" + NL + "    for (";
  protected final String TEXT_1343 = " ";
  protected final String TEXT_1344 = " : ";
  protected final String TEXT_1345 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1346 = ".begin(),";
  protected final String TEXT_1347 = ".end(),";
  protected final String TEXT_1348 = ") != ";
  protected final String TEXT_1349 = ".end())" + NL + "      {";
  protected final String TEXT_1350 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1351 = ".";
  protected final String TEXT_1352 = "() != NULL && this!=(";
  protected final String TEXT_1353 = "->";
  protected final String TEXT_1354 = "()))" + NL + "      {";
  protected final String TEXT_1355 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1356 = NL + "      ";
  protected final String TEXT_1357 = ".push_back(";
  protected final String TEXT_1358 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1359 = ".size() != ";
  protected final String TEXT_1360 = "())" + NL + "    {";
  protected final String TEXT_1361 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1362 = NL + "    ";
  protected final String TEXT_1363 = ".removeAll(";
  protected final String TEXT_1364 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1365 = " orphan : ";
  protected final String TEXT_1366 = ")" + NL + "    {";
  protected final String TEXT_1367 = NL + "      ";
  protected final String TEXT_1368 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1369 = NL + "    ";
  protected final String TEXT_1370 = ".clear();" + NL + "    for (";
  protected final String TEXT_1371 = " ";
  protected final String TEXT_1372 = " : ";
  protected final String TEXT_1373 = ")" + NL + "    {";
  protected final String TEXT_1374 = NL + "      ";
  protected final String TEXT_1375 = "(";
  protected final String TEXT_1376 = ", this);";
  protected final String TEXT_1377 = NL + "      ";
  protected final String TEXT_1378 = ".push_back(";
  protected final String TEXT_1379 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1380 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1381 = NL + "  void ";
  protected final String TEXT_1382 = "::";
  protected final String TEXT_1383 = "(";
  protected final String TEXT_1384 = " ";
  protected final String TEXT_1385 = ", ";
  protected final String TEXT_1386 = " ";
  protected final String TEXT_1387 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1388 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1389 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1390 = ", ";
  protected final String TEXT_1391 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1392 = " to ";
  protected final String TEXT_1393 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1394 = NL + "  bool ";
  protected final String TEXT_1395 = "::";
  protected final String TEXT_1396 = "(";
  protected final String TEXT_1397 = " ";
  protected final String TEXT_1398 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1399 = NL + "    ";
  protected final String TEXT_1400 = ".push_back(";
  protected final String TEXT_1401 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1402 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1403 = "::";
  protected final String TEXT_1404 = "(";
  protected final String TEXT_1405 = "* ";
  protected final String TEXT_1406 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1407 = ".begin(), ";
  protected final String TEXT_1408 = ".end(), ";
  protected final String TEXT_1409 = ") - ";
  protected final String TEXT_1410 = ".begin();";
  protected final String TEXT_1411 = NL + "    if (find(";
  protected final String TEXT_1412 = ".begin(),";
  protected final String TEXT_1413 = ".end(),";
  protected final String TEXT_1414 = ") != ";
  protected final String TEXT_1415 = ".end())" + NL + "    {";
  protected final String TEXT_1416 = NL + "      ";
  protected final String TEXT_1417 = ".erase(find(";
  protected final String TEXT_1418 = ".begin(),";
  protected final String TEXT_1419 = ".end(),";
  protected final String TEXT_1420 = "));" + NL + "\t  delete ";
  protected final String TEXT_1421 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1422 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1423 = NL + "  bool ";
  protected final String TEXT_1424 = "::";
  protected final String TEXT_1425 = "(";
  protected final String TEXT_1426 = "* ";
  protected final String TEXT_1427 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1428 = NL + "    if (";
  protected final String TEXT_1429 = "() < ";
  protected final String TEXT_1430 = "())" + NL + "    {";
  protected final String TEXT_1431 = NL + "      ";
  protected final String TEXT_1432 = ".push_back(";
  protected final String TEXT_1433 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1434 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1435 = "::";
  protected final String TEXT_1436 = "(";
  protected final String TEXT_1437 = "* ";
  protected final String TEXT_1438 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1439 = ".begin(), ";
  protected final String TEXT_1440 = ".end(), ";
  protected final String TEXT_1441 = ") - ";
  protected final String TEXT_1442 = ".begin();";
  protected final String TEXT_1443 = NL + "    if (find(";
  protected final String TEXT_1444 = ".begin(),";
  protected final String TEXT_1445 = ".end(),";
  protected final String TEXT_1446 = ") != ";
  protected final String TEXT_1447 = ".end())" + NL + "    {";
  protected final String TEXT_1448 = NL + "      ";
  protected final String TEXT_1449 = ".erase(";
  protected final String TEXT_1450 = ");" + NL + "\t  delete ";
  protected final String TEXT_1451 = "[index];" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1452 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1453 = NL + "  bool ";
  protected final String TEXT_1454 = "::";
  protected final String TEXT_1455 = "(";
  protected final String TEXT_1456 = "* ";
  protected final String TEXT_1457 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1458 = NL + "    ";
  protected final String TEXT_1459 = ".push_back(";
  protected final String TEXT_1460 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1461 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1462 = "::";
  protected final String TEXT_1463 = "(";
  protected final String TEXT_1464 = "* ";
  protected final String TEXT_1465 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;" + NL + "\tint index = find(";
  protected final String TEXT_1466 = ".begin(), ";
  protected final String TEXT_1467 = ".end(), ";
  protected final String TEXT_1468 = ") - ";
  protected final String TEXT_1469 = ".begin();";
  protected final String TEXT_1470 = NL + "    if (!find(";
  protected final String TEXT_1471 = ".begin(),";
  protected final String TEXT_1472 = ".end(),";
  protected final String TEXT_1473 = ") != ";
  protected final String TEXT_1474 = ".end())" + NL + "    {";
  protected final String TEXT_1475 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1476 = "() <= ";
  protected final String TEXT_1477 = "())" + NL + "    {";
  protected final String TEXT_1478 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1479 = NL + "    ";
  protected final String TEXT_1480 = ".erase(find(";
  protected final String TEXT_1481 = ".begin(),";
  protected final String TEXT_1482 = ".end(),";
  protected final String TEXT_1483 = "));" + NL + "    delete ";
  protected final String TEXT_1484 = "[index];" + NL + "\twasRemoved = true;";
  protected final String TEXT_1485 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1486 = NL + "  bool ";
  protected final String TEXT_1487 = "::";
  protected final String TEXT_1488 = "(";
  protected final String TEXT_1489 = "... ";
  protected final String TEXT_1490 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1491 = NL + "    vector<";
  protected final String TEXT_1492 = "*> ";
  protected final String TEXT_1493 = ";" + NL + "    for (";
  protected final String TEXT_1494 = " ";
  protected final String TEXT_1495 = " : ";
  protected final String TEXT_1496 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1497 = ".begin(),";
  protected final String TEXT_1498 = ".end(),";
  protected final String TEXT_1499 = ") != ";
  protected final String TEXT_1500 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1501 = NL + "      ";
  protected final String TEXT_1502 = ".push_back(";
  protected final String TEXT_1503 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1504 = ".size() != ";
  protected final String TEXT_1505 = ".size() || ";
  protected final String TEXT_1506 = ".size() != ";
  protected final String TEXT_1507 = "())" + NL + "    {";
  protected final String TEXT_1508 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1509 = NL + "    ";
  protected final String TEXT_1510 = ".clear();" + NL + "    for (int i=0; i<";
  protected final String TEXT_1511 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1512 = ".push_back(";
  protected final String TEXT_1513 = "[i]);" + NL + "\t}" + NL + "    wasSet = true;";
  protected final String TEXT_1514 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1515 = NL + "  ";
  protected final String TEXT_1516 = " bool ";
  protected final String TEXT_1517 = "(";
  protected final String TEXT_1518 = "... ";
  protected final String TEXT_1519 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1520 = NL + "    vector<";
  protected final String TEXT_1521 = "*> ";
  protected final String TEXT_1522 = ";" + NL + "    for (int i=0 ; i<";
  protected final String TEXT_1523 = ".size() ; i++)" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1524 = ".begin(),";
  protected final String TEXT_1525 = ".end(),(";
  protected final String TEXT_1526 = ") != ";
  protected final String TEXT_1527 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1528 = NL + "      ";
  protected final String TEXT_1529 = ".push_back(";
  protected final String TEXT_1530 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1531 = ".size() != ";
  protected final String TEXT_1532 = ".length)" + NL + "    {";
  protected final String TEXT_1533 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1534 = NL + "    ";
  protected final String TEXT_1535 = ".clear();";
  protected final String TEXT_1536 = NL + "    ";
  protected final String TEXT_1537 = ".addAll(";
  protected final String TEXT_1538 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1539 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1540 = NL + "  bool ";
  protected final String TEXT_1541 = "::";
  protected final String TEXT_1542 = "(";
  protected final String TEXT_1543 = " ";
  protected final String TEXT_1544 = ")" + NL + "  {" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "    // THIS TEMPLATE IS EXPERIMENTAL" + NL + "    //   I cut/Paste from UmpleToJava/templates/association_SetOptionalOneToMandatoryMany.jet" + NL + "    //   and then converted to cpp. " + NL + "    //" + NL + "    bool wasSet = false;";
  protected final String TEXT_1545 = NL + "    ";
  protected final String TEXT_1546 = " *";
  protected final String TEXT_1547 = " = ";
  protected final String TEXT_1548 = ";" + NL + "\t" + NL + "    if (";
  protected final String TEXT_1549 = " == NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1550 = " != NULL)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1551 = "->";
  protected final String TEXT_1552 = "(this))" + NL + "        {";
  protected final String TEXT_1553 = NL + "          ";
  protected final String TEXT_1554 = " = ";
  protected final String TEXT_1555 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if (";
  protected final String TEXT_1556 = " != NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1557 = " == NULL)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1558 = "->";
  protected final String TEXT_1559 = "() < ";
  protected final String TEXT_1560 = "->";
  protected final String TEXT_1561 = "())" + NL + "        {";
  protected final String TEXT_1562 = NL + "          ";
  protected final String TEXT_1563 = "->";
  protected final String TEXT_1564 = "(this);";
  protected final String TEXT_1565 = NL + "          ";
  protected final String TEXT_1566 = " = ";
  protected final String TEXT_1567 = ";  // ";
  protected final String TEXT_1568 = " == NULL" + NL + "          wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1569 = "->";
  protected final String TEXT_1570 = "() < ";
  protected final String TEXT_1571 = "->";
  protected final String TEXT_1572 = "())" + NL + "        {";
  protected final String TEXT_1573 = NL + "          ";
  protected final String TEXT_1574 = "->";
  protected final String TEXT_1575 = "(this);";
  protected final String TEXT_1576 = NL + "          ";
  protected final String TEXT_1577 = "->";
  protected final String TEXT_1578 = "(this);";
  protected final String TEXT_1579 = NL + "          ";
  protected final String TEXT_1580 = " = ";
  protected final String TEXT_1581 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if (wasSet)" + NL + "    {";
  protected final String TEXT_1582 = NL + "      ";
  protected final String TEXT_1583 = " = ";
  protected final String TEXT_1584 = ";" + NL + "    }" + NL + "    return wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_1585 = NL + "//  bool ";
  protected final String TEXT_1586 = "::";
  protected final String TEXT_1587 = "(";
  protected final String TEXT_1588 = " ";
  protected final String TEXT_1589 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_1590 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//    // THIS TEMPLATE IS EXPERIMENTAL" + NL + "//    //   I cut/Paste from UmpleToJava/templates/association_SetOptionalOneToMandatoryMany.jet" + NL + "//    //   and then converted to cpp. " + NL + "//    //" + NL + "//" + NL + "//    bool wasSet = false;" + NL + "//    ";
  protected final String TEXT_1591 = " *";
  protected final String TEXT_1592 = " = ";
  protected final String TEXT_1593 = ";" + NL + "//\t" + NL + "//    if (";
  protected final String TEXT_1594 = " == null)" + NL + "//    {  " + NL + "//      if (";
  protected final String TEXT_1595 = " != null)" + NL + "//      { " + NL + "//        if (";
  protected final String TEXT_1596 = "->";
  protected final String TEXT_1597 = "(this))" + NL + "//          ";
  protected final String TEXT_1598 = " = ";
  protected final String TEXT_1599 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    else" + NL + "//    {" + NL + "//      if (";
  protected final String TEXT_1600 = " != null)" + NL + "//      {" + NL + "//        if (";
  protected final String TEXT_1601 = " == null)" + NL + "//        {" + NL + "//          if (";
  protected final String TEXT_1602 = "->";
  protected final String TEXT_1603 = " < ";
  protected final String TEXT_1604 = ".";
  protected final String TEXT_1605 = ")" + NL + "//            ";
  protected final String TEXT_1606 = "->";
  protected final String TEXT_1607 = "(this);" + NL + "//            ";
  protected final String TEXT_1608 = " = ";
  protected final String TEXT_1609 = "  // ";
  protected final String TEXT_1610 = " == null;" + NL + "//            wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//      else" + NL + "//      {" + NL + "//        if (   ";
  protected final String TEXT_1611 = "->";
  protected final String TEXT_1612 = " < ";
  protected final String TEXT_1613 = "->";
  protected final String TEXT_1614 = "()" + NL + "//            && ";
  protected final String TEXT_1615 = ".";
  protected final String TEXT_1616 = " > ";
  protected final String TEXT_1617 = "->";
  protected final String TEXT_1618 = "()" + NL + "//           )" + NL + "//          ";
  protected final String TEXT_1619 = "->";
  protected final String TEXT_1620 = "(this);" + NL + "//          ";
  protected final String TEXT_1621 = "->";
  protected final String TEXT_1622 = "(this);" + NL + "//          ";
  protected final String TEXT_1623 = " = ";
  protected final String TEXT_1624 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    " + NL + "//    if (wasSet)" + NL + "//    {" + NL + "//      ";
  protected final String TEXT_1625 = " = ";
  protected final String TEXT_1626 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return wasSet;" + NL + "//  }";
  protected final String TEXT_1627 = NL + "  bool ";
  protected final String TEXT_1628 = "::";
  protected final String TEXT_1629 = "(";
  protected final String TEXT_1630 = "... ";
  protected final String TEXT_1631 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1632 = NL + "    vector<";
  protected final String TEXT_1633 = "*> ";
  protected final String TEXT_1634 = ";" + NL + "    for (";
  protected final String TEXT_1635 = " ";
  protected final String TEXT_1636 = " : ";
  protected final String TEXT_1637 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1638 = ".begin(),";
  protected final String TEXT_1639 = ".end(),";
  protected final String TEXT_1640 = ")!= ";
  protected final String TEXT_1641 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1642 = NL + "      ";
  protected final String TEXT_1643 = "push_back(";
  protected final String TEXT_1644 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1645 = ".size() != ";
  protected final String TEXT_1646 = ".length || ";
  protected final String TEXT_1647 = ".size() < ";
  protected final String TEXT_1648 = "() || ";
  protected final String TEXT_1649 = ".size() > ";
  protected final String TEXT_1650 = "())" + NL + "    {";
  protected final String TEXT_1651 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1652 = "*> ";
  protected final String TEXT_1653 = " = new vector<";
  protected final String TEXT_1654 = "*>(";
  protected final String TEXT_1655 = ");";
  protected final String TEXT_1656 = NL + "    ";
  protected final String TEXT_1657 = ".clear();" + NL + "    for (";
  protected final String TEXT_1658 = " ";
  protected final String TEXT_1659 = " : ";
  protected final String TEXT_1660 = ")" + NL + "    {";
  protected final String TEXT_1661 = NL + "      ";
  protected final String TEXT_1662 = ".push_back(";
  protected final String TEXT_1663 = ");" + NL + "      if (find(";
  protected final String TEXT_1664 = ".begin(),";
  protected final String TEXT_1665 = ".end(),";
  protected final String TEXT_1666 = ")!= ";
  protected final String TEXT_1667 = ".end())" + NL + "      {";
  protected final String TEXT_1668 = NL + "        ";
  protected final String TEXT_1669 = ".erase(find(";
  protected final String TEXT_1670 = ".begin(),";
  protected final String TEXT_1671 = ".end(),";
  protected final String TEXT_1672 = "));" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1673 = NL + "        ";
  protected final String TEXT_1674 = "->";
  protected final String TEXT_1675 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1676 = " ";
  protected final String TEXT_1677 = " : ";
  protected final String TEXT_1678 = ")" + NL + "    {";
  protected final String TEXT_1679 = NL + "      ";
  protected final String TEXT_1680 = ".";
  protected final String TEXT_1681 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1682 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1683 = NL + "  bool ";
  protected final String TEXT_1684 = "::";
  protected final String TEXT_1685 = "(";
  protected final String TEXT_1686 = "... ";
  protected final String TEXT_1687 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1688 = NL + "    vector<";
  protected final String TEXT_1689 = "*> ";
  protected final String TEXT_1690 = ";" + NL + "\t" + NL + "    for (";
  protected final String TEXT_1691 = " ";
  protected final String TEXT_1692 = " : ";
  protected final String TEXT_1693 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1694 = ".begin(),";
  protected final String TEXT_1695 = ".end(),";
  protected final String TEXT_1696 = ") != ";
  protected final String TEXT_1697 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1698 = NL + "      ";
  protected final String TEXT_1699 = ".push_back(";
  protected final String TEXT_1700 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1701 = ".size() != ";
  protected final String TEXT_1702 = ".length || ";
  protected final String TEXT_1703 = ".size() < ";
  protected final String TEXT_1704 = "())" + NL + "    {";
  protected final String TEXT_1705 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1706 = "*> ";
  protected final String TEXT_1707 = ";";
  protected final String TEXT_1708 = NL + "    ";
  protected final String TEXT_1709 = ".clear();" + NL + "    for (";
  protected final String TEXT_1710 = " ";
  protected final String TEXT_1711 = " : ";
  protected final String TEXT_1712 = ")" + NL + "    {";
  protected final String TEXT_1713 = NL + "      ";
  protected final String TEXT_1714 = ".push_back(";
  protected final String TEXT_1715 = ");" + NL + "      if (find(";
  protected final String TEXT_1716 = ".begin(),";
  protected final String TEXT_1717 = ".end(),";
  protected final String TEXT_1718 = ")) != ";
  protected final String TEXT_1719 = ".end())" + NL + "      {";
  protected final String TEXT_1720 = NL + "        ";
  protected final String TEXT_1721 = ".erase(";
  protected final String TEXT_1722 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1723 = NL + "        ";
  protected final String TEXT_1724 = "->";
  protected final String TEXT_1725 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1726 = " ";
  protected final String TEXT_1727 = " : ";
  protected final String TEXT_1728 = ")" + NL + "    {";
  protected final String TEXT_1729 = NL + "      ";
  protected final String TEXT_1730 = "->";
  protected final String TEXT_1731 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1732 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1733 = NL + "  bool ";
  protected final String TEXT_1734 = "::";
  protected final String TEXT_1735 = "(";
  protected final String TEXT_1736 = "... ";
  protected final String TEXT_1737 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1738 = NL + "    vector<";
  protected final String TEXT_1739 = "*> ";
  protected final String TEXT_1740 = ";" + NL + "    for (";
  protected final String TEXT_1741 = " ";
  protected final String TEXT_1742 = " : ";
  protected final String TEXT_1743 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1744 = ".begin(),";
  protected final String TEXT_1745 = ".end(),";
  protected final String TEXT_1746 = ") != ";
  protected final String TEXT_1747 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1748 = NL + "      ";
  protected final String TEXT_1749 = "->add(";
  protected final String TEXT_1750 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1751 = ".size() != ";
  protected final String TEXT_1752 = ".size() || ";
  protected final String TEXT_1753 = ".size() < ";
  protected final String TEXT_1754 = "() || ";
  protected final String TEXT_1755 = ".size() > ";
  protected final String TEXT_1756 = "())" + NL + "    {";
  protected final String TEXT_1757 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1758 = NL + "    ";
  protected final String TEXT_1759 = ".clear();" + NL + "\tfor (int i=0; i<";
  protected final String TEXT_1760 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1761 = ".push_back(";
  protected final String TEXT_1762 = "[i]);" + NL + "\t}" + NL + "    " + NL + "    wasSet = true;";
  protected final String TEXT_1763 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1764 = NL + "  bool ";
  protected final String TEXT_1765 = "::";
  protected final String TEXT_1766 = "(";
  protected final String TEXT_1767 = "... ";
  protected final String TEXT_1768 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1769 = NL + "    if (";
  protected final String TEXT_1770 = ".length < ";
  protected final String TEXT_1771 = "()";
  protected final String TEXT_1772 = ")" + NL + "    {";
  protected final String TEXT_1773 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1774 = "*> ";
  protected final String TEXT_1775 = ";" + NL + "\t" + NL + "    map<";
  protected final String TEXT_1776 = ",int> ";
  protected final String TEXT_1777 = ";" + NL + "    for (";
  protected final String TEXT_1778 = " ";
  protected final String TEXT_1779 = " : ";
  protected final String TEXT_1780 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1781 = ".begin(),";
  protected final String TEXT_1782 = ".end(),";
  protected final String TEXT_1783 = ") != ";
  protected final String TEXT_1784 = ".end())" + NL + "      {";
  protected final String TEXT_1785 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1786 = "->";
  protected final String TEXT_1787 = "() != NULL && this!=";
  protected final String TEXT_1788 = "->";
  protected final String TEXT_1789 = "())" + NL + "      {";
  protected final String TEXT_1790 = NL + "        ";
  protected final String TEXT_1791 = "* ";
  protected final String TEXT_1792 = " = ";
  protected final String TEXT_1793 = ".";
  protected final String TEXT_1794 = "();" + NL + "        if (!";
  protected final String TEXT_1795 = ".find(";
  protected final String TEXT_1796 = "))" + NL + "        {";
  protected final String TEXT_1797 = NL + "          ";
  protected final String TEXT_1798 = ".insert(";
  protected final String TEXT_1799 = ", new int(";
  protected final String TEXT_1800 = "->";
  protected final String TEXT_1801 = "()));" + NL + "        }" + NL + "        int currentCount = ";
  protected final String TEXT_1802 = ".find(";
  protected final String TEXT_1803 = ")->firtst;" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_1804 = ")" + NL + "        {";
  protected final String TEXT_1805 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_1806 = NL + "        ";
  protected final String TEXT_1807 = ".insert(";
  protected final String TEXT_1808 = ", new int(nextCount));" + NL + "      }";
  protected final String TEXT_1809 = NL + "      ";
  protected final String TEXT_1810 = ".push_back(";
  protected final String TEXT_1811 = ");" + NL + "    }" + NL;
  protected final String TEXT_1812 = NL + "    ";
  protected final String TEXT_1813 = ".removeAll(";
  protected final String TEXT_1814 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_1815 = " orphan : ";
  protected final String TEXT_1816 = ")" + NL + "    {";
  protected final String TEXT_1817 = NL + "      ";
  protected final String TEXT_1818 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1819 = NL + "    ";
  protected final String TEXT_1820 = ".clear();" + NL + "    for (";
  protected final String TEXT_1821 = " ";
  protected final String TEXT_1822 = " : ";
  protected final String TEXT_1823 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1824 = ".";
  protected final String TEXT_1825 = "() != null)" + NL + "      {";
  protected final String TEXT_1826 = NL + "        ";
  protected final String TEXT_1827 = ".";
  protected final String TEXT_1828 = "()->";
  protected final String TEXT_1829 = ".erase(";
  protected final String TEXT_1830 = ");" + NL + "      }";
  protected final String TEXT_1831 = NL + "      ";
  protected final String TEXT_1832 = "(";
  protected final String TEXT_1833 = ", this);";
  protected final String TEXT_1834 = NL + "      ";
  protected final String TEXT_1835 = ".push_back(";
  protected final String TEXT_1836 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1837 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1838 = NL + "  void ";
  protected final String TEXT_1839 = "::";
  protected final String TEXT_1840 = "(";
  protected final String TEXT_1841 = " ";
  protected final String TEXT_1842 = ", ";
  protected final String TEXT_1843 = " ";
  protected final String TEXT_1844 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1845 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1846 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1847 = ", ";
  protected final String TEXT_1848 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1849 = " to ";
  protected final String TEXT_1850 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1851 = NL + "  bool ";
  protected final String TEXT_1852 = "::";
  protected final String TEXT_1853 = "(";
  protected final String TEXT_1854 = "... ";
  protected final String TEXT_1855 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1856 = NL + "    vector<";
  protected final String TEXT_1857 = "*> ";
  protected final String TEXT_1858 = ";" + NL + "    for (";
  protected final String TEXT_1859 = " ";
  protected final String TEXT_1860 = " : ";
  protected final String TEXT_1861 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1862 = ".begin(),";
  protected final String TEXT_1863 = ".end(),(";
  protected final String TEXT_1864 = ")) - ";
  protected final String TEXT_1865 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1866 = NL + "      ";
  protected final String TEXT_1867 = ".push_back(";
  protected final String TEXT_1868 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1869 = ".size() != ";
  protected final String TEXT_1870 = ".size() || ";
  protected final String TEXT_1871 = ".size() > ";
  protected final String TEXT_1872 = "())" + NL + "    {";
  protected final String TEXT_1873 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1874 = NL + "    ";
  protected final String TEXT_1875 = ".clear();" + NL + "    for (int i=0; i<";
  protected final String TEXT_1876 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1877 = ".push_back(";
  protected final String TEXT_1878 = "[i]);" + NL + "\t}" + NL + "    wasSet = true;";
  protected final String TEXT_1879 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1880 = NL + "  bool ";
  protected final String TEXT_1881 = "::";
  protected final String TEXT_1882 = "(";
  protected final String TEXT_1883 = "... ";
  protected final String TEXT_1884 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1885 = NL + "    vector<";
  protected final String TEXT_1886 = "*> ";
  protected final String TEXT_1887 = ";" + NL + "    for (";
  protected final String TEXT_1888 = " ";
  protected final String TEXT_1889 = " : ";
  protected final String TEXT_1890 = ")" + NL + "    {" + NL + "      if (find(";
  protected final String TEXT_1891 = ".begin(),";
  protected final String TEXT_1892 = ".end(),";
  protected final String TEXT_1893 = ") != ";
  protected final String TEXT_1894 = ".end())" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1895 = NL + "      ";
  protected final String TEXT_1896 = "->add(";
  protected final String TEXT_1897 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1898 = ".size() != ";
  protected final String TEXT_1899 = ".size() || ";
  protected final String TEXT_1900 = ".size() < ";
  protected final String TEXT_1901 = "())" + NL + "    {";
  protected final String TEXT_1902 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1903 = NL + "    ";
  protected final String TEXT_1904 = ".clear();" + NL + "    for (int i=0; i<";
  protected final String TEXT_1905 = ".size(); i++)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1906 = ".push_back(";
  protected final String TEXT_1907 = "[i]);" + NL + "\t}" + NL + "\t" + NL + "    wasSet = true;";
  protected final String TEXT_1908 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1909 = NL + "  bool equals(Object obj)" + NL + "  {" + NL + "    if (obj == NULL) { return false; }" + NL + "    if (getClass() != obj.getClass()) { return false; }" + NL;
  protected final String TEXT_1910 = NL + "    ";
  protected final String TEXT_1911 = " == (";
  protected final String TEXT_1912 = ")obj;" + NL + "  " + NL + "    return true;" + NL + "  }" + NL + "" + NL + " int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_1913 = NL + "    ";
  protected final String TEXT_1914 = NL;
  protected final String TEXT_1915 = NL + "    ";
  protected final String TEXT_1916 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1917 = NL + "   void ";
  protected final String TEXT_1918 = "::";
  protected final String TEXT_1919 = "()" + NL + "  {" + NL + "     try" + NL + "     {";
  protected final String TEXT_1920 = NL + "       ";
  protected final String TEXT_1921 = NL + "     }" + NL + "     catch (InterruptedException e)" + NL + "     {" + NL + " " + NL + "     }" + NL + "  }" + NL;
  protected final String TEXT_1922 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1923 = NL + "    ";
  protected final String TEXT_1924 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1925 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_1926 = NL + "      ";
  protected final String TEXT_1927 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1928 = NL + "  void ";
  protected final String TEXT_1929 = "();" + NL + "  void ";
  protected final String TEXT_1930 = "();" + NL + "  " + NL + NL;
  protected final String TEXT_1931 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1932 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1933 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void ";
  protected final String TEXT_1934 = "::stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void ";
  protected final String TEXT_1935 = "::run ()" + NL + "    {";
  protected final String TEXT_1936 = NL + "      if (\"";
  protected final String TEXT_1937 = "\" == timeoutMethodName)" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1938 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1939 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1940 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1941 = NL + "  " + NL + "  //------------------------" + NL + "  // DESTRUCTOR" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1942 = NL + "    ";
  protected final String TEXT_1943 = " = NULL;" + NL + "    delete ";
  protected final String TEXT_1944 = ";";
  protected final String TEXT_1945 = NL + "    ";
  protected final String TEXT_1946 = ".clear();";
  protected final String TEXT_1947 = NL + "    ";
  protected final String TEXT_1948 = " ";
  protected final String TEXT_1949 = " = ";
  protected final String TEXT_1950 = ";";
  protected final String TEXT_1951 = NL + "    ";
  protected final String TEXT_1952 = " = NULL;" + NL + "    if (";
  protected final String TEXT_1953 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1954 = ";" + NL + "    }";
  protected final String TEXT_1955 = NL + "    if (";
  protected final String TEXT_1956 = " != NULL)" + NL + "    {";
  protected final String TEXT_1957 = NL + "      ";
  protected final String TEXT_1958 = "->";
  protected final String TEXT_1959 = "(NULL);" + NL + "    }";
  protected final String TEXT_1960 = NL + "    ";
  protected final String TEXT_1961 = " ";
  protected final String TEXT_1962 = " = ";
  protected final String TEXT_1963 = ";";
  protected final String TEXT_1964 = NL + "    ";
  protected final String TEXT_1965 = " = NULL;" + NL + "    if (";
  protected final String TEXT_1966 = " != NULL)" + NL + "    {";
  protected final String TEXT_1967 = NL + "      ";
  protected final String TEXT_1968 = "->";
  protected final String TEXT_1969 = "(NULL);" + NL + "    }";
  protected final String TEXT_1970 = NL + "    ";
  protected final String TEXT_1971 = "* ";
  protected final String TEXT_1972 = " = ";
  protected final String TEXT_1973 = ";";
  protected final String TEXT_1974 = NL + "    ";
  protected final String TEXT_1975 = " = NULL;" + NL + "    if (";
  protected final String TEXT_1976 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1977 = ";" + NL + "    }";
  protected final String TEXT_1978 = NL + "    if (";
  protected final String TEXT_1979 = " != NULL)" + NL + "    {";
  protected final String TEXT_1980 = NL + "      ";
  protected final String TEXT_1981 = "* ";
  protected final String TEXT_1982 = " = ";
  protected final String TEXT_1983 = ";" + NL + "      this->";
  protected final String TEXT_1984 = " = NULL;";
  protected final String TEXT_1985 = NL + "      ";
  protected final String TEXT_1986 = "->";
  protected final String TEXT_1987 = "(this);" + NL + "    }" + NL;
  protected final String TEXT_1988 = NL + "    if (";
  protected final String TEXT_1989 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1990 = ";" + NL + "    }";
  protected final String TEXT_1991 = NL + "    if (";
  protected final String TEXT_1992 = " != NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1993 = ".";
  protected final String TEXT_1994 = "() <= ";
  protected final String TEXT_1995 = ")" + NL + "      {" + NL + "        delete ";
  protected final String TEXT_1996 = ";" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1997 = NL + "        ";
  protected final String TEXT_1998 = "* ";
  protected final String TEXT_1999 = " = ";
  protected final String TEXT_2000 = ";" + NL + "        this.";
  protected final String TEXT_2001 = " = NULL;";
  protected final String TEXT_2002 = NL + "        ";
  protected final String TEXT_2003 = "->";
  protected final String TEXT_2004 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2005 = NL + "    ";
  protected final String TEXT_2006 = " ";
  protected final String TEXT_2007 = " = ";
  protected final String TEXT_2008 = ";" + NL + "    this->";
  protected final String TEXT_2009 = " = NULL;";
  protected final String TEXT_2010 = NL + "    ";
  protected final String TEXT_2011 = "->";
  protected final String TEXT_2012 = "(this);";
  protected final String TEXT_2013 = NL + "    for(i =0; sizeof(";
  protected final String TEXT_2014 = "); i++)" + NL + "    {";
  protected final String TEXT_2015 = NL + "      ";
  protected final String TEXT_2016 = "(";
  protected final String TEXT_2017 = "[i],NULL);" + NL + "    }";
  protected final String TEXT_2018 = NL + "    ";
  protected final String TEXT_2019 = ".clear();";
  protected final String TEXT_2020 = NL + "    vector<";
  protected final String TEXT_2021 = "*> ";
  protected final String TEXT_2022 = " = ";
  protected final String TEXT_2023 = ";";
  protected final String TEXT_2024 = NL + "    ";
  protected final String TEXT_2025 = ".clear();" + NL + "    for(i =0; sizeof(";
  protected final String TEXT_2026 = "); i++)" + NL + "     {" + NL + "      if (";
  protected final String TEXT_2027 = ".";
  protected final String TEXT_2028 = "() <= ";
  protected final String TEXT_2029 = "->";
  protected final String TEXT_2030 = "())" + NL + "      {" + NL + "        delete ";
  protected final String TEXT_2031 = "[i];" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2032 = NL + "        ";
  protected final String TEXT_2033 = "->";
  protected final String TEXT_2034 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2035 = NL + "    vector<";
  protected final String TEXT_2036 = "*> ";
  protected final String TEXT_2037 = " = ";
  protected final String TEXT_2038 = ";";
  protected final String TEXT_2039 = NL + "    ";
  protected final String TEXT_2040 = ".clear();" + NL + "    for(i=0;sizeof(";
  protected final String TEXT_2041 = ");i++)" + NL + "    {";
  protected final String TEXT_2042 = NL + "      ";
  protected final String TEXT_2043 = "[i]->";
  protected final String TEXT_2044 = "(this);" + NL + "    }";
  protected final String TEXT_2045 = NL + "    for(i =0; sizeof(";
  protected final String TEXT_2046 = "); i++)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_2047 = "[i];" + NL + "    }";
  protected final String TEXT_2048 = NL + "    for(i =0; sizeof(";
  protected final String TEXT_2049 = "); i++)" + NL + "    {";
  protected final String TEXT_2050 = NL + "      ";
  protected final String TEXT_2051 = "[i]->";
  protected final String TEXT_2052 = "(NULL);" + NL + "    }";
  protected final String TEXT_2053 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "   ";
  protected final String TEXT_2054 = NL + "  ";
  protected final String TEXT_2055 = NL + "  ";
  protected final String TEXT_2056 = NL;

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
	  for (AttributeTraceItem ati: td.getAttributeTraceItems())
	  {
		for (UmpleVariable att : ati.getUmpleVariables())
		{
		appendln(stringBuffer, "");
		append(stringBuffer, "#include \"{0}_tracepoint.h\";",att.getName());	
		}
	  }
	  }
  }  

    stringBuffer.append(TEXT_3);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).getIsInline()) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(stringBuffer, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    stringBuffer.append(TEXT_4);
      if (uClass.getIsSingleton())
  {
    
    
appendln(stringBuffer, "  {0}* {0}::theInstance = NULL; //singleton;", uClass.getName());

    
  }
  
  
    stringBuffer.append(TEXT_5);
    
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
		
    stringBuffer.append(TEXT_6);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_7);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_8);
     
    }
    else if (av.isImmutable() && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_10);
    
    }
    else if (av.isImmutable())
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_11);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_15);
     
    }
    else
    {
      hasBody = true;
      if(!av.getIsLazy()){
         
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_16);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_18);
    
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
    stringBuffer.append(TEXT_19);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_21);
    } 
    
      }
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_22);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_24);
    
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
        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_29);
    
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
  

    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_37);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        hasBody = true;
        
     String requiredNumber = StringFormatter.format("{0}", av.getMultiplicity().getUpperBound()); 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_45);
    
      }
      else if (av.isMany() && av.isImmutable())
      {
      	hasBody = true;
        
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
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_52);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_53);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_62);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_63);
    
    }
    else
    {
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOnlyOne())
  {
    
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_70);
    
  }
  else if (av.isOptionalMany())
  {
    
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
  

    stringBuffer.append(TEXT_71);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_78);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_80);
    
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
      
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_84);
    
    }
    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_87);
    
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
    
    stringBuffer.append(TEXT_88);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_91);
    
  }

    
  if (isOneToOne)
  {
    
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_96);
    
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
		
    stringBuffer.append(TEXT_97);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_99);
     
    }
    else
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_102);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_105);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_106);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_107);
    
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
    
    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_114);
    
  }
  else if (av.isOptionalMany())
  {
    
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
  

    stringBuffer.append(TEXT_115);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_122);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_124);
    
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


    stringBuffer.append(TEXT_125);
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
    stringBuffer.append(TEXT_126);
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
    stringBuffer.append(TEXT_127);
    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes())
  {
    if (av.isConstant() || av.getIsAutounique() || "internal".equals(av.getModifier()) || av.getIsDerived())
    {
      continue;
    }
    
    TraceItem traceItem = av.getTraced("setMethod", uClass);
    

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
        
    stringBuffer.append(TEXT_128);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_132);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_133);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_137);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_138);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_143);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_146);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_149);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_152);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_153);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_158);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_161);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_166);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_169);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_170);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_172);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_175);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_176);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_178);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_179);
    
    }
  }

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes()) 
  {
    if (av.getIsAutounique() || av.isConstant() || "internal".equals(av.getModifier()))
    {
      continue;
    }
    
    TraceItem traceItem = av.getTraced("getMethod", uClass);
    
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
        
    String customHasUniquePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("hasUniqueMethod",av)));
    String customHasUniquePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("hasUniqueMethod",av)));
    
    String customGetUniquePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getUniqueMethod",av)));
    String customGetUniquePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getUniqueMethod",av)));

    if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_180);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_183);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_187);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_193);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_199);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_203);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_205);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_206);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_208);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_210);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_211);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_215);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_216);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_220);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_221);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_222);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_224);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_225);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_226);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_229);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_230);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_231);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_234);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_235);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_236);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_239);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_240);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_241);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_242);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_244);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_245);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_246);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_247);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_249);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_250);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_252);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_253);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_256);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_259);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_260);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_261);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_262);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_263);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_266);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_267);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_268);
    
      }
      
      if (av.getIsUnique())
      {
        if (customGetUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_269);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_273);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_274);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(TEXT_279);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_281);
    
        } 
        else 
        {
          
    stringBuffer.append(TEXT_282);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_286);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_287);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_290);
    
        }
        if (customHasUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_294);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_295);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(TEXT_299);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customHasUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_301);
    
        }
        else
        {
          
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_305);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_306);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_309);
    
        }
      }
    }
  }

  for (Attribute av : uClass.getAttributes()) 
  {
  
    if (av.getIsAutounique())
    {
      String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("getMethod",av)));
      String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("getMethod",av)));
      
      TraceItem traceItem = av.getTraced("getMethod", uClass);
      
      if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_312);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_313);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_314);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_315);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_317);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_318);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_319);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_322);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_323);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_324);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_325);
    
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

    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(gen.translate("getStringMethod",sm));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_331);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_332);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_333);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_334);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_337);
    
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
        
        String condition = t.getGuard()!=null?t.getGuard().getCondition(gen):"if ()\n{";
        if (!"if ()\n{".equals(condition))
        {
          allCases.append(GeneratorHelper.doIndent(condition, "        ")+"\n");
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

        if (!"if ()\n{".equals(condition))
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

    stringBuffer.append(TEXT_338);
    stringBuffer.append(scope);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_341);
    stringBuffer.append( (e.getArgs()==null?"":e.getArgs()));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(TEXT_343);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_344);
    
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

    stringBuffer.append(TEXT_345);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_347);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_348);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_349);
     if (!exitCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",exitCasesOutput); } 
     if (!enterCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",enterCasesOutput); } 
    stringBuffer.append(TEXT_350);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_351);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_352);
    
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
      		  StateMachineTraceItem tracedState = tc.getStateMachineTraceItem(i);
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
      		  StateMachineTraceItem tracedState = tc.getStateMachineTraceItem(i);
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
	      StateMachineTraceItem tracedState = tc.getStateMachineTraceItem(i);
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
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_355);
     if (customExitPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_356);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(TEXT_358);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_359);
     if (customExitPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_360);
     } 
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_363);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_364);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_365);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_366);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_367);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_368);
     if (parentState != null) { 
    stringBuffer.append(TEXT_369);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_370);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_371);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_372);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_374);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_375);
     } 
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_376);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(TEXT_378);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_379);
    stringBuffer.append( traceRecords );
     } 
    stringBuffer.append(TEXT_380);
    
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

	TraceItem traceItem = av.getTraced("getMethod", uClass);

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
      
    stringBuffer.append(TEXT_381);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_384);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_385);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_386);
     } else { 
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_390);
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_392);
     } 
    stringBuffer.append(TEXT_393);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_397);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_401);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_402);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_406);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_410);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_414);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_416);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_419);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_421);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_426);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_431);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_432);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_433);
    
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
    
    TraceItem traceItem = av.getTraced("setMethod", uClass);

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
      
    stringBuffer.append(TEXT_434);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_435);
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
      
    
      
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_438);
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_441);
     } else { 
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_446);
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_447);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_451);
     } else { 
    stringBuffer.append(TEXT_452);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_454);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_455);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_456);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_457);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_460);
     } else { 
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_463);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_464);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_465);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_466);
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
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_470);
     } else { 
    stringBuffer.append(TEXT_471);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_473);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_474);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_475);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_476);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_481);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_484);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_485);
     } 
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_497);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_498);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_503);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_507);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_524);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_525);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_530);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_533);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_534);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_539);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_544);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_545);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_550);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_551);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_558);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_559);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_577);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_578);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_583);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_588);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_598);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_599);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_613);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_614);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_625);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_644);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_649);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_654);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_655);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_656);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_659);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_660);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_663);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_664);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_677);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_680);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_681);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_693);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_701);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_710);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_715);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_720);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_721);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_727);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_728);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_741);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_744);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_745);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_760);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_769);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_780);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_781);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_786);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_803);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_830);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_831);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_842);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_857);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_866);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_877);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_878);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_883);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_897);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_898);
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_920);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_921);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_930);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_934);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_937);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_955);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_956);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_965);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_970);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_973);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_988);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_989);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_994);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1000);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1018);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1019);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1024);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1026);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1043);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1044);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1049);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1053);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1060);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1076);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1080);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1081);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1086);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1090);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1096);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1112);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1116);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1117);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1122);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1142);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1151);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1165);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1166);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1171);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1188);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1189);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1194);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1197);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1218);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1227);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1239);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1240);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1245);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1251);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1260);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1265);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1268);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1275);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1276);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1281);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1284);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1285);
     } 
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1294);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1308);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1317);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1333);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1334);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1339);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1349);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1354);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1360);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1379);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1393);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1398);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1401);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1410);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1421);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1422);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1427);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1433);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1442);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1451);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1452);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1457);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1460);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1469);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1474);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1477);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1484);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1485);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1490);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1503);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1507);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1513);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1514);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1515);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1519);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1532);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1538);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1539);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1558);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1584);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1599);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1612);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1617);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1626);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1629);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1631);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1632);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1650);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(TEXT_1673);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1677);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1678);
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1681);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1682);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1687);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1688);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1692);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1696);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(TEXT_1698);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1701);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1703);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1704);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1705);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1706);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1707);
    stringBuffer.append(TEXT_1708);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1709);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1710);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(TEXT_1713);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1714);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1716);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1718);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1719);
    stringBuffer.append(TEXT_1720);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1721);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1722);
    stringBuffer.append(TEXT_1723);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1724);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1725);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1726);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1727);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1728);
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1730);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1731);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1732);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1733);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1735);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1736);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1737);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1738);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1739);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1740);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1741);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1742);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1743);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1744);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1745);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1746);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1747);
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1749);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1750);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1751);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1752);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1753);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1754);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1755);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1756);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1757);
    stringBuffer.append(TEXT_1758);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1759);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1760);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1761);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1762);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1763);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1764);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1765);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1766);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1767);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1768);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1769);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1770);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1771);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1772);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1773);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1774);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1775);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1776);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1777);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1778);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1779);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1780);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1781);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1782);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1783);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1784);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1785);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1786);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1787);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1788);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1789);
    stringBuffer.append(TEXT_1790);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1791);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1792);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1793);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1794);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1795);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1796);
    stringBuffer.append(TEXT_1797);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1798);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1799);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1800);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1801);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1802);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1803);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1804);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_1805);
    stringBuffer.append(TEXT_1806);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1807);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1808);
    stringBuffer.append(TEXT_1809);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1810);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1811);
    stringBuffer.append(TEXT_1812);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1813);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1814);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1815);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1816);
    stringBuffer.append(TEXT_1817);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1818);
    stringBuffer.append(TEXT_1819);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1820);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1821);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1822);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1823);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1824);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1825);
    stringBuffer.append(TEXT_1826);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1827);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1828);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1829);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1830);
    stringBuffer.append(TEXT_1831);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1832);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1833);
    stringBuffer.append(TEXT_1834);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1835);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1836);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1837);
    stringBuffer.append(TEXT_1838);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1839);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1840);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1841);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1842);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1843);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1844);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1845);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1846);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1847);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1848);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1849);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1850);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1851);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1852);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1853);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1854);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1855);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1856);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1857);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1858);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1859);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1860);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1861);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1862);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1863);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1864);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1865);
    stringBuffer.append(TEXT_1866);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1867);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1868);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1869);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1870);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1871);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1872);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1873);
    stringBuffer.append(TEXT_1874);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1875);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1876);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1877);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1878);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1879);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1880);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1881);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1882);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1883);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1884);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1885);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1886);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1887);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1888);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1889);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1890);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1891);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1892);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1893);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1894);
    stringBuffer.append(TEXT_1895);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1896);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1897);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1898);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1899);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1900);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1901);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1902);
    stringBuffer.append(TEXT_1903);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1904);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1905);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1906);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1907);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1908);
    
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


    stringBuffer.append(TEXT_1909);
    stringBuffer.append(TEXT_1910);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1911);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1912);
    stringBuffer.append(TEXT_1913);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1914);
    stringBuffer.append(TEXT_1915);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1916);
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
        
    stringBuffer.append(TEXT_1917);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1918);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1919);
    stringBuffer.append(TEXT_1920);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1921);
    
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

    stringBuffer.append(TEXT_1922);
    stringBuffer.append(TEXT_1923);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1924);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1925);
    stringBuffer.append(TEXT_1926);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1927);
    
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
        
    stringBuffer.append(TEXT_1928);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1929);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1930);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1931);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1932);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1933);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1934);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1935);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1936);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1937);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1938);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1939);
    
      }
    }
  }

    stringBuffer.append(TEXT_1940);
    
  }
}

    stringBuffer.append(TEXT_1941);
    

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
        
    stringBuffer.append(TEXT_1942);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1943);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1944);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1945);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1946);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1947);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1948);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1949);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1950);
    stringBuffer.append(TEXT_1951);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1952);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1953);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1954);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1955);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1956);
    stringBuffer.append(TEXT_1957);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1958);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1959);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1960);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1961);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1962);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1963);
    stringBuffer.append(TEXT_1964);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1965);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1966);
    stringBuffer.append(TEXT_1967);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1968);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1969);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1970);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1971);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1972);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1973);
    stringBuffer.append(TEXT_1974);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1975);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1976);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1977);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1978);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1979);
    stringBuffer.append(TEXT_1980);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1981);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1982);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1983);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1984);
    stringBuffer.append(TEXT_1985);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1986);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1987);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1988);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1989);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1990);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1991);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1992);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1993);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1994);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1995);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1996);
    stringBuffer.append(TEXT_1997);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1998);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1999);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2000);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2001);
    stringBuffer.append(TEXT_2002);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2003);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2004);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2005);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2006);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2007);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2008);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2009);
    stringBuffer.append(TEXT_2010);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2011);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2012);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2013);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2014);
    stringBuffer.append(TEXT_2015);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2016);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2017);
    stringBuffer.append(TEXT_2018);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2019);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_2020);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2021);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2022);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2023);
    stringBuffer.append(TEXT_2024);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2025);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2026);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2027);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2028);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2029);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2030);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2031);
    stringBuffer.append(TEXT_2032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2033);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2034);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2035);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2036);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2037);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2038);
    stringBuffer.append(TEXT_2039);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2040);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2041);
    stringBuffer.append(TEXT_2042);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2043);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2044);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_2045);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2046);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2047);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2048);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2049);
    stringBuffer.append(TEXT_2050);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2051);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2052);
    
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
       String customPreconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Precondition"));
       String customPostconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Postcondition"));
       customPostconditionCode = customPostconditionCode==null?"":customPostconditionCode;
        
       String methodBody = aMethod.getIsImplemented() ? "      return " + gen.translateReturnType(methodType) + ";" : aMethod.getMethodBody().getExtraCode();
       String properMethodBody = "      " + methodBody; 
       String override =  aMethod.getIsImplemented() ? "" : "";
       String paramName="";
       String paramType="";
       String aSingleParameter="";
       String isList="";
       String finalParams = "";
       String finalParamsWithoutTypes = "";
       StringBuilder parameters = new StringBuilder();
       StringBuilder parametersWithoutTypes = new StringBuilder();
       if(aMethod.hasMethodParameters())
       {
         for (MethodParameter aMethodParam : aMethod.getMethodParameters()) 
         {
            paramName = aMethodParam.getName();
            paramType = gen.translate(aMethodParam.getType());
            isList = aMethodParam.getIsList() ? " [] " : " ";
            aSingleParameter = paramType + isList + paramName;
            parameters.append(aSingleParameter + ", ");
            parametersWithoutTypes.append(aMethodParam.getName() + ", ");
          }
          finalParams = parameters.toString().substring(0, parameters.toString().length()-2);
          finalParamsWithoutTypes = parametersWithoutTypes.toString().substring(0, parametersWithoutTypes.toString().length()-2);
        }
        else {
           appendln(stringBuffer,"");
        }
        if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Method Javadoc",aMethod.getComments())); }
        append(stringBuffer, "\n  {0} {1} {2}({3})", methodModifier, gen.translate(methodType), methodName, finalParams);
        if(!"".equals(customPostconditionCode))
        {
          appendln(stringBuffer, "{");
          if(!"".equals(methodType)||!"void".equals(methodType)){
            append(stringBuffer, "    {0} result = {1}_Original({2});\n", methodType, methodName, finalParamsWithoutTypes);
          }
          else {
            append(stringBuffer, "    {0}_Original({1});\n", methodType, methodName, finalParamsWithoutTypes);
          }
          appendln(stringBuffer, GeneratorHelper.doIndent(customPostconditionCode, "    "));
          if(!"".equals(methodType)||!"void".equals(methodType)){
            append(stringBuffer, "    return result;\n");
          }          
          appendln(stringBuffer, "  }");
          append(stringBuffer, "  {0} {1} {2}_Original({3})", methodModifier, methodType, methodName, finalParams);
        }
    	appendln(stringBuffer, "{");
    	if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
    	appendln(stringBuffer, properMethodBody);
    	appendln(stringBuffer, "  }");
      }
    }

     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_2053);
    stringBuffer.append(TEXT_2054);
    stringBuffer.append(uClass.getExtraCode());
    stringBuffer.append(TEXT_2055);
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
  
  
}

    stringBuffer.append(TEXT_2056);
    return stringBuffer.toString();
  }
}