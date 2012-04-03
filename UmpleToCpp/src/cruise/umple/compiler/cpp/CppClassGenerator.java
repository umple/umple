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
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "  ";
  protected final String TEXT_6 = NL + "  //------------------------" + NL + "  // CONSTRUCTOR" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_7 = NL + "    ";
  protected final String TEXT_8 = " = new vector<";
  protected final String TEXT_9 = "*>();";
  protected final String TEXT_10 = NL + "    ";
  protected final String TEXT_11 = "();";
  protected final String TEXT_12 = NL + "    ";
  protected final String TEXT_13 = " = true;";
  protected final String TEXT_14 = NL + "    ";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";";
  protected final String TEXT_17 = NL + "    ";
  protected final String TEXT_18 = " = false;";
  protected final String TEXT_19 = NL + "    ";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";";
  protected final String TEXT_22 = NL + "    ";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = "++;";
  protected final String TEXT_25 = NL + "    if (!";
  protected final String TEXT_26 = "(";
  protected final String TEXT_27 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_28 = " due to ";
  protected final String TEXT_29 = "\");" + NL + "    }";
  protected final String TEXT_30 = NL + "    ";
  protected final String TEXT_31 = " = new vector<";
  protected final String TEXT_32 = "*>();" + NL + "    bool ";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = ");" + NL + "    if (!";
  protected final String TEXT_36 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_37 = ", must have ";
  protected final String TEXT_38 = " ";
  protected final String TEXT_39 = "\");" + NL + "    }";
  protected final String TEXT_40 = NL + "    ";
  protected final String TEXT_41 = " = new vector<";
  protected final String TEXT_42 = "*>();";
  protected final String TEXT_43 = NL + "    if (";
  protected final String TEXT_44 = " == null || ";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = "() != null)" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_47 = " due to ";
  protected final String TEXT_48 = "\");" + NL + "    }";
  protected final String TEXT_49 = NL + "    ";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = ";";
  protected final String TEXT_52 = NL + "    ";
  protected final String TEXT_53 = " = new vector<";
  protected final String TEXT_54 = "*>();";
  protected final String TEXT_55 = NL + "    bool ";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = "(";
  protected final String TEXT_58 = ");" + NL + "    if (!";
  protected final String TEXT_59 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_60 = " due to ";
  protected final String TEXT_61 = "\");" + NL + "    }";
  protected final String TEXT_62 = NL + "    ";
  protected final String TEXT_63 = " = new vector<";
  protected final String TEXT_64 = "*>();" + NL + "    bool ";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = ");" + NL + "    if (!";
  protected final String TEXT_68 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_69 = ", must have ";
  protected final String TEXT_70 = " ";
  protected final String TEXT_71 = "\");" + NL + "    }";
  protected final String TEXT_72 = " = new vector<";
  protected final String TEXT_73 = "*>();";
  protected final String TEXT_74 = NL + "    ";
  protected final String TEXT_75 = ".push_back(";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "    ";
  protected final String TEXT_78 = "(";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "    if (";
  protected final String TEXT_82 = " == null) { ";
  protected final String TEXT_83 = "(";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = "); }";
  protected final String TEXT_86 = NL + "  static ";
  protected final String TEXT_87 = " getInstance()" + NL + "  {" + NL + "    if(theInstance == null)" + NL + "    {" + NL + "      theInstance = new ";
  protected final String TEXT_88 = "();" + NL + "    }" + NL + "    return theInstance;" + NL + "  }";
  protected final String TEXT_89 = NL;
  protected final String TEXT_90 = NL + "  ";
  protected final String TEXT_91 = "::";
  protected final String TEXT_92 = "(";
  protected final String TEXT_93 = ")" + NL + "  {";
  protected final String TEXT_94 = NL + "    ";
  protected final String TEXT_95 = " = new vector<";
  protected final String TEXT_96 = "*>();";
  protected final String TEXT_97 = NL + "    ";
  protected final String TEXT_98 = "();";
  protected final String TEXT_99 = NL + "    ";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ";";
  protected final String TEXT_102 = NL + "    ";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = "++;";
  protected final String TEXT_105 = NL + "    ";
  protected final String TEXT_106 = " = new ";
  protected final String TEXT_107 = "(";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = NL + "    ";
  protected final String TEXT_110 = " = new vector<";
  protected final String TEXT_111 = "*>();" + NL + "    bool ";
  protected final String TEXT_112 = " = ";
  protected final String TEXT_113 = "(";
  protected final String TEXT_114 = ");" + NL + "    if (!";
  protected final String TEXT_115 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_116 = ", must have ";
  protected final String TEXT_117 = " ";
  protected final String TEXT_118 = "\");" + NL + "    }";
  protected final String TEXT_119 = " = new vector<";
  protected final String TEXT_120 = "*>();";
  protected final String TEXT_121 = NL + "    ";
  protected final String TEXT_122 = ".push_back(";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_125 = NL + "  bool ";
  protected final String TEXT_126 = "::";
  protected final String TEXT_127 = "(";
  protected final String TEXT_128 = "& ";
  protected final String TEXT_129 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_130 = NL + "    ";
  protected final String TEXT_131 = " = false;";
  protected final String TEXT_132 = NL + "    ";
  protected final String TEXT_133 = " = ";
  protected final String TEXT_134 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_135 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_136 = NL + "  bool ";
  protected final String TEXT_137 = "::";
  protected final String TEXT_138 = "(";
  protected final String TEXT_139 = "& ";
  protected final String TEXT_140 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_141 = NL + "    ";
  protected final String TEXT_142 = " = ";
  protected final String TEXT_143 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_144 = NL + "    return wasSet;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_145 = "::";
  protected final String TEXT_146 = "()" + NL + "  {" + NL + "    bool wasReset = false;";
  protected final String TEXT_147 = NL + "    ";
  protected final String TEXT_148 = " = ";
  protected final String TEXT_149 = "();" + NL + "    wasReset = true;";
  protected final String TEXT_150 = NL + "    return wasReset;" + NL + "  }" + NL;
  protected final String TEXT_151 = NL + "  bool ";
  protected final String TEXT_152 = "::";
  protected final String TEXT_153 = "(";
  protected final String TEXT_154 = "& ";
  protected final String TEXT_155 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_156 = NL + "    wasAdded = ";
  protected final String TEXT_157 = ".add(";
  protected final String TEXT_158 = ");";
  protected final String TEXT_159 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_160 = "::";
  protected final String TEXT_161 = "(";
  protected final String TEXT_162 = "& ";
  protected final String TEXT_163 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_164 = NL + "    wasRemoved = ";
  protected final String TEXT_165 = ".remove(";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_168 = NL + "  bool ";
  protected final String TEXT_169 = "::";
  protected final String TEXT_170 = "(";
  protected final String TEXT_171 = "& ";
  protected final String TEXT_172 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_173 = NL + "    ";
  protected final String TEXT_174 = " = ";
  protected final String TEXT_175 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_176 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_177 = NL + "  ";
  protected final String TEXT_178 = " ";
  protected final String TEXT_179 = "::";
  protected final String TEXT_180 = "(int index)" + NL + "  {";
  protected final String TEXT_181 = NL + "    ";
  protected final String TEXT_182 = " ";
  protected final String TEXT_183 = " = ";
  protected final String TEXT_184 = ".get(index);";
  protected final String TEXT_185 = NL + "    return ";
  protected final String TEXT_186 = ";" + NL + "  }" + NL;
  protected final String TEXT_187 = NL + "  ";
  protected final String TEXT_188 = "[] ";
  protected final String TEXT_189 = "::";
  protected final String TEXT_190 = "()" + NL + "  {";
  protected final String TEXT_191 = NL + "    ";
  protected final String TEXT_192 = "[] ";
  protected final String TEXT_193 = " = ";
  protected final String TEXT_194 = ".toArray(new ";
  protected final String TEXT_195 = "[";
  protected final String TEXT_196 = ".size()]);";
  protected final String TEXT_197 = NL + "    return ";
  protected final String TEXT_198 = ";" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_199 = "::";
  protected final String TEXT_200 = "()" + NL + "  {";
  protected final String TEXT_201 = NL + "    int number = ";
  protected final String TEXT_202 = ".size();";
  protected final String TEXT_203 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_204 = "::";
  protected final String TEXT_205 = "()" + NL + "  {";
  protected final String TEXT_206 = NL + "    bool has = ";
  protected final String TEXT_207 = ".size() > 0;";
  protected final String TEXT_208 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_209 = "::";
  protected final String TEXT_210 = "(";
  protected final String TEXT_211 = " ";
  protected final String TEXT_212 = ")" + NL + "  {";
  protected final String TEXT_213 = NL + "    int index = ";
  protected final String TEXT_214 = ".indexOf(";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_217 = NL + "  ";
  protected final String TEXT_218 = " ";
  protected final String TEXT_219 = "::";
  protected final String TEXT_220 = "()" + NL + "  {";
  protected final String TEXT_221 = NL + "    ";
  protected final String TEXT_222 = " ";
  protected final String TEXT_223 = " = ";
  protected final String TEXT_224 = ";";
  protected final String TEXT_225 = NL + "    return ";
  protected final String TEXT_226 = ";" + NL + "  }";
  protected final String TEXT_227 = NL + "  ";
  protected final String TEXT_228 = " ";
  protected final String TEXT_229 = "::";
  protected final String TEXT_230 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_231 = ";" + NL + "  }";
  protected final String TEXT_232 = NL + "  ";
  protected final String TEXT_233 = " ";
  protected final String TEXT_234 = "::";
  protected final String TEXT_235 = "()" + NL + "  {";
  protected final String TEXT_236 = NL + "    ";
  protected final String TEXT_237 = " ";
  protected final String TEXT_238 = " = ";
  protected final String TEXT_239 = ";";
  protected final String TEXT_240 = NL + "    return ";
  protected final String TEXT_241 = ";" + NL + "  }";
  protected final String TEXT_242 = NL + "  ";
  protected final String TEXT_243 = " ";
  protected final String TEXT_244 = "::";
  protected final String TEXT_245 = "()" + NL + "  {";
  protected final String TEXT_246 = NL + "    return ";
  protected final String TEXT_247 = ";" + NL + "  }";
  protected final String TEXT_248 = NL + "  ";
  protected final String TEXT_249 = " ";
  protected final String TEXT_250 = "::";
  protected final String TEXT_251 = "()" + NL + "  {";
  protected final String TEXT_252 = NL + "    ";
  protected final String TEXT_253 = " ";
  protected final String TEXT_254 = " = ";
  protected final String TEXT_255 = ";";
  protected final String TEXT_256 = NL + "    return ";
  protected final String TEXT_257 = ";" + NL + "  }";
  protected final String TEXT_258 = NL + "  ";
  protected final String TEXT_259 = " ";
  protected final String TEXT_260 = "::";
  protected final String TEXT_261 = "()" + NL + "  {";
  protected final String TEXT_262 = NL + "    return ";
  protected final String TEXT_263 = ";" + NL + "  }" + NL;
  protected final String TEXT_264 = NL + "  ";
  protected final String TEXT_265 = " ";
  protected final String TEXT_266 = "::";
  protected final String TEXT_267 = "()" + NL + "  {";
  protected final String TEXT_268 = NL + "    ";
  protected final String TEXT_269 = " ";
  protected final String TEXT_270 = " = ";
  protected final String TEXT_271 = ";";
  protected final String TEXT_272 = NL + "    return ";
  protected final String TEXT_273 = ";" + NL + "  }";
  protected final String TEXT_274 = NL + "  ";
  protected final String TEXT_275 = " ";
  protected final String TEXT_276 = "::";
  protected final String TEXT_277 = "()" + NL + "  {";
  protected final String TEXT_278 = NL + "    return ";
  protected final String TEXT_279 = ";" + NL + "  }";
  protected final String TEXT_280 = NL + "  public ";
  protected final String TEXT_281 = " ";
  protected final String TEXT_282 = "()" + NL + "  {" + NL + "    String answer = ";
  protected final String TEXT_283 = ".toString();";
  protected final String TEXT_284 = NL + "    return answer;" + NL + "  }" + NL;
  protected final String TEXT_285 = NL + "  public ";
  protected final String TEXT_286 = " ";
  protected final String TEXT_287 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_288 = ";" + NL + "  }" + NL;
  protected final String TEXT_289 = NL + "  public boolean ";
  protected final String TEXT_290 = "()" + NL + "  {" + NL + "    boolean wasEventProcessed = false;" + NL;
  protected final String TEXT_291 = NL + "    ";
  protected final String TEXT_292 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_293 = NL + "  public boolean ";
  protected final String TEXT_294 = "(";
  protected final String TEXT_295 = " ";
  protected final String TEXT_296 = ")" + NL + "  {";
  protected final String TEXT_297 = NL + "    ";
  protected final String TEXT_298 = " = ";
  protected final String TEXT_299 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_300 = NL + "  private void ";
  protected final String TEXT_301 = "()" + NL + "  {" + NL + "    switch(";
  protected final String TEXT_302 = ")" + NL + "    {";
  protected final String TEXT_303 = NL + "      ";
  protected final String TEXT_304 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_305 = NL + "  private void ";
  protected final String TEXT_306 = "(";
  protected final String TEXT_307 = " ";
  protected final String TEXT_308 = ")" + NL + "  {";
  protected final String TEXT_309 = NL + "    ";
  protected final String TEXT_310 = " = ";
  protected final String TEXT_311 = ";";
  protected final String TEXT_312 = NL + "    if (";
  protected final String TEXT_313 = " != ";
  protected final String TEXT_314 = ".";
  protected final String TEXT_315 = " && ";
  protected final String TEXT_316 = " != ";
  protected final String TEXT_317 = ".";
  protected final String TEXT_318 = ") { ";
  protected final String TEXT_319 = "(";
  protected final String TEXT_320 = ".";
  protected final String TEXT_321 = "); }";
  protected final String TEXT_322 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_323 = ")" + NL + "    {";
  protected final String TEXT_324 = NL + "      ";
  protected final String TEXT_325 = NL + "    }";
  protected final String TEXT_326 = NL + "  }" + NL;
  protected final String TEXT_327 = NL + "  ";
  protected final String TEXT_328 = "* ";
  protected final String TEXT_329 = "::";
  protected final String TEXT_330 = "() const" + NL + "  {";
  protected final String TEXT_331 = NL + "    return ";
  protected final String TEXT_332 = ";";
  protected final String TEXT_333 = NL + "    ";
  protected final String TEXT_334 = " ";
  protected final String TEXT_335 = " = ";
  protected final String TEXT_336 = ";";
  protected final String TEXT_337 = NL + "    return ";
  protected final String TEXT_338 = ";";
  protected final String TEXT_339 = NL + "  }" + NL;
  protected final String TEXT_340 = NL + "  ";
  protected final String TEXT_341 = " ";
  protected final String TEXT_342 = "::";
  protected final String TEXT_343 = "(int index) const" + NL + "  {";
  protected final String TEXT_344 = NL + "    ";
  protected final String TEXT_345 = " ";
  protected final String TEXT_346 = " = ";
  protected final String TEXT_347 = ".get(index);";
  protected final String TEXT_348 = NL + "    return ";
  protected final String TEXT_349 = ";" + NL + "  }" + NL + "" + NL + "  vector<";
  protected final String TEXT_350 = "*> ";
  protected final String TEXT_351 = "::";
  protected final String TEXT_352 = "() const" + NL + "  {";
  protected final String TEXT_353 = NL + "    vector<";
  protected final String TEXT_354 = "*> ";
  protected final String TEXT_355 = " = ";
  protected final String TEXT_356 = ";";
  protected final String TEXT_357 = NL + "    return ";
  protected final String TEXT_358 = ";" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_359 = "::";
  protected final String TEXT_360 = "()" + NL + "  {";
  protected final String TEXT_361 = NL + "    int number = ";
  protected final String TEXT_362 = ".size();";
  protected final String TEXT_363 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_364 = "::";
  protected final String TEXT_365 = "()" + NL + "  {";
  protected final String TEXT_366 = NL + "    bool has = ";
  protected final String TEXT_367 = ".size() > 0;";
  protected final String TEXT_368 = NL + "    return has;" + NL + "  }" + NL + "  " + NL + "  int ";
  protected final String TEXT_369 = "::";
  protected final String TEXT_370 = "(";
  protected final String TEXT_371 = " ";
  protected final String TEXT_372 = ")" + NL + "  {";
  protected final String TEXT_373 = NL + "    int index = std::find(";
  protected final String TEXT_374 = ".begin(), ";
  protected final String TEXT_375 = ".end(), ";
  protected final String TEXT_376 = ") - ";
  protected final String TEXT_377 = ".begin();";
  protected final String TEXT_378 = NL + "    return index;" + NL + "  }" + NL + "  ";
  protected final String TEXT_379 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_380 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_381 = " : ";
  protected final String TEXT_382 = NL + "  bool ";
  protected final String TEXT_383 = "::";
  protected final String TEXT_384 = "()" + NL + "  {";
  protected final String TEXT_385 = NL + "    bool isValid = ";
  protected final String TEXT_386 = "() >= ";
  protected final String TEXT_387 = "();";
  protected final String TEXT_388 = NL + "    bool isValid = ";
  protected final String TEXT_389 = "() >= ";
  protected final String TEXT_390 = "() && ";
  protected final String TEXT_391 = "() <= ";
  protected final String TEXT_392 = "();";
  protected final String TEXT_393 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_394 = NL + "  static int ";
  protected final String TEXT_395 = "::";
  protected final String TEXT_396 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_397 = ";" + NL + "  }";
  protected final String TEXT_398 = NL + "  static int ";
  protected final String TEXT_399 = "::";
  protected final String TEXT_400 = "()" + NL + "  {";
  protected final String TEXT_401 = NL + "    int required = ";
  protected final String TEXT_402 = ";";
  protected final String TEXT_403 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_404 = NL + "  static int ";
  protected final String TEXT_405 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_406 = ";" + NL + "  }";
  protected final String TEXT_407 = NL + "  static int ";
  protected final String TEXT_408 = "::";
  protected final String TEXT_409 = "()" + NL + "  {";
  protected final String TEXT_410 = NL + "    int minimum = ";
  protected final String TEXT_411 = ";";
  protected final String TEXT_412 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_413 = NL + "  static int ";
  protected final String TEXT_414 = "::";
  protected final String TEXT_415 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_416 = ";" + NL + "  }";
  protected final String TEXT_417 = NL + "  static int ";
  protected final String TEXT_418 = "::";
  protected final String TEXT_419 = "()" + NL + "  {";
  protected final String TEXT_420 = NL + "    int maximum = ";
  protected final String TEXT_421 = ";";
  protected final String TEXT_422 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_423 = NL + "  bool ";
  protected final String TEXT_424 = "::";
  protected final String TEXT_425 = "(";
  protected final String TEXT_426 = " ";
  protected final String TEXT_427 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_428 = NL + "    if (";
  protected final String TEXT_429 = "() >= ";
  protected final String TEXT_430 = "())" + NL + "    {";
  protected final String TEXT_431 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_432 = NL + "    ";
  protected final String TEXT_433 = ".add(";
  protected final String TEXT_434 = ");" + NL + "    if (";
  protected final String TEXT_435 = ".";
  protected final String TEXT_436 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_437 = ".";
  protected final String TEXT_438 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_439 = NL + "        ";
  protected final String TEXT_440 = ".remove(";
  protected final String TEXT_441 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_442 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_443 = NL + "  bool ";
  protected final String TEXT_444 = "::";
  protected final String TEXT_445 = "(";
  protected final String TEXT_446 = " ";
  protected final String TEXT_447 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_448 = NL + "    if (!";
  protected final String TEXT_449 = ".contains(";
  protected final String TEXT_450 = "))" + NL + "    {";
  protected final String TEXT_451 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_452 = ".indexOf(";
  protected final String TEXT_453 = ");";
  protected final String TEXT_454 = NL + "    ";
  protected final String TEXT_455 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_456 = ".";
  protected final String TEXT_457 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_458 = ".";
  protected final String TEXT_459 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_460 = NL + "        ";
  protected final String TEXT_461 = ".add(oldIndex,";
  protected final String TEXT_462 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_463 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_464 = NL + "  bool ";
  protected final String TEXT_465 = "::";
  protected final String TEXT_466 = "(";
  protected final String TEXT_467 = "* ";
  protected final String TEXT_468 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_469 = NL + "    ";
  protected final String TEXT_470 = " = ";
  protected final String TEXT_471 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_472 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_473 = NL + "  bool ";
  protected final String TEXT_474 = "::";
  protected final String TEXT_475 = "(";
  protected final String TEXT_476 = "* ";
  protected final String TEXT_477 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_478 = NL + "    if (";
  protected final String TEXT_479 = " != null)" + NL + "    {";
  protected final String TEXT_480 = NL + "      ";
  protected final String TEXT_481 = " = ";
  protected final String TEXT_482 = ";" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_483 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_484 = NL + "  bool ";
  protected final String TEXT_485 = "::";
  protected final String TEXT_486 = "(";
  protected final String TEXT_487 = "* ";
  protected final String TEXT_488 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_489 = NL + "    if (";
  protected final String TEXT_490 = " != null && !";
  protected final String TEXT_491 = ".equals(";
  protected final String TEXT_492 = ") && equals(";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = "()))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_495 = ", as existing ";
  protected final String TEXT_496 = " would become an orphan";
  protected final String TEXT_497 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_498 = NL + "    ";
  protected final String TEXT_499 = " = ";
  protected final String TEXT_500 = ";";
  protected final String TEXT_501 = NL + "    ";
  protected final String TEXT_502 = " ";
  protected final String TEXT_503 = " = ";
  protected final String TEXT_504 = " != null ? ";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = "() : null;" + NL + "" + NL + "    if (!this.equals(";
  protected final String TEXT_507 = "))" + NL + "    {" + NL + "      if (";
  protected final String TEXT_508 = " != null)" + NL + "      {";
  protected final String TEXT_509 = NL + "        ";
  protected final String TEXT_510 = ".";
  protected final String TEXT_511 = " = null;" + NL + "      }" + NL + "      if (";
  protected final String TEXT_512 = " != null)" + NL + "      {";
  protected final String TEXT_513 = NL + "        ";
  protected final String TEXT_514 = ".";
  protected final String TEXT_515 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_516 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_517 = NL + "  bool ";
  protected final String TEXT_518 = "::";
  protected final String TEXT_519 = "(";
  protected final String TEXT_520 = " ";
  protected final String TEXT_521 = ")" + NL + "  {" + NL + "    bool";
  protected final String TEXT_522 = NL + "    if (";
  protected final String TEXT_523 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_524 = " to null, as ";
  protected final String TEXT_525 = " must always be associated to a ";
  protected final String TEXT_526 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_527 = NL + "    ";
  protected final String TEXT_528 = " ";
  protected final String TEXT_529 = " = ";
  protected final String TEXT_530 = ".";
  protected final String TEXT_531 = "();" + NL + "    if (";
  protected final String TEXT_532 = " != null && !equals(";
  protected final String TEXT_533 = "))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_534 = ", the current ";
  protected final String TEXT_535 = " already has a ";
  protected final String TEXT_536 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_537 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_538 = NL + "    ";
  protected final String TEXT_539 = " ";
  protected final String TEXT_540 = " = ";
  protected final String TEXT_541 = ";";
  protected final String TEXT_542 = NL + "    ";
  protected final String TEXT_543 = " = ";
  protected final String TEXT_544 = ";";
  protected final String TEXT_545 = NL + "    ";
  protected final String TEXT_546 = ".";
  protected final String TEXT_547 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_548 = " != null)" + NL + "    {";
  protected final String TEXT_549 = NL + "      ";
  protected final String TEXT_550 = ".";
  protected final String TEXT_551 = "(null);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_552 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_553 = NL + "  ";
  protected final String TEXT_554 = " ";
  protected final String TEXT_555 = "::";
  protected final String TEXT_556 = "(";
  protected final String TEXT_557 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_558 = "(";
  protected final String TEXT_559 = ");" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_560 = "::";
  protected final String TEXT_561 = "(";
  protected final String TEXT_562 = " ";
  protected final String TEXT_563 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_564 = NL + "    ";
  protected final String TEXT_565 = " ";
  protected final String TEXT_566 = " = ";
  protected final String TEXT_567 = ".";
  protected final String TEXT_568 = "();" + NL + "    bool ";
  protected final String TEXT_569 = " = ";
  protected final String TEXT_570 = " != null && !this.equals(";
  protected final String TEXT_571 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_572 = " && ";
  protected final String TEXT_573 = ".";
  protected final String TEXT_574 = "() <= ";
  protected final String TEXT_575 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_576 = ")" + NL + "    {";
  protected final String TEXT_577 = NL + "      ";
  protected final String TEXT_578 = ".";
  protected final String TEXT_579 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_580 = NL + "      ";
  protected final String TEXT_581 = ".add(";
  protected final String TEXT_582 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_583 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_584 = "::";
  protected final String TEXT_585 = "(";
  protected final String TEXT_586 = " ";
  protected final String TEXT_587 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_588 = NL + "    //Unable to remove ";
  protected final String TEXT_589 = ", as it must always have a ";
  protected final String TEXT_590 = NL + "    if (this.equals(";
  protected final String TEXT_591 = ".";
  protected final String TEXT_592 = "()))" + NL + "    {";
  protected final String TEXT_593 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_594 = " already at minimum (";
  protected final String TEXT_595 = ")" + NL + "    if (";
  protected final String TEXT_596 = "() <= ";
  protected final String TEXT_597 = "())" + NL + "    {";
  protected final String TEXT_598 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_599 = NL + "    ";
  protected final String TEXT_600 = ".remove(";
  protected final String TEXT_601 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_602 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_603 = NL + "  ";
  protected final String TEXT_604 = " ";
  protected final String TEXT_605 = "::";
  protected final String TEXT_606 = "(";
  protected final String TEXT_607 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_608 = "() >= ";
  protected final String TEXT_609 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_610 = "(";
  protected final String TEXT_611 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_612 = "::";
  protected final String TEXT_613 = "(";
  protected final String TEXT_614 = " ";
  protected final String TEXT_615 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_616 = NL + "    if (";
  protected final String TEXT_617 = "() >= ";
  protected final String TEXT_618 = "())" + NL + "    {";
  protected final String TEXT_619 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_620 = NL + "    ";
  protected final String TEXT_621 = " ";
  protected final String TEXT_622 = " = ";
  protected final String TEXT_623 = ".";
  protected final String TEXT_624 = "();" + NL + "    bool ";
  protected final String TEXT_625 = " = ";
  protected final String TEXT_626 = " != null && !this.equals(";
  protected final String TEXT_627 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_628 = " && ";
  protected final String TEXT_629 = ".";
  protected final String TEXT_630 = "() <= ";
  protected final String TEXT_631 = "())" + NL + "    {";
  protected final String TEXT_632 = NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_633 = ")" + NL + "    {";
  protected final String TEXT_634 = NL + "      ";
  protected final String TEXT_635 = ".";
  protected final String TEXT_636 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_637 = NL + "      ";
  protected final String TEXT_638 = ".add(";
  protected final String TEXT_639 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_640 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_641 = "::";
  protected final String TEXT_642 = "(";
  protected final String TEXT_643 = " ";
  protected final String TEXT_644 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_645 = NL + "    //Unable to remove ";
  protected final String TEXT_646 = ", as it must always have a ";
  protected final String TEXT_647 = NL + "    if (this.equals(";
  protected final String TEXT_648 = ".";
  protected final String TEXT_649 = "()))" + NL + "    {";
  protected final String TEXT_650 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_651 = " already at minimum (";
  protected final String TEXT_652 = ")" + NL + "    if (";
  protected final String TEXT_653 = "() <= ";
  protected final String TEXT_654 = "())" + NL + "    {";
  protected final String TEXT_655 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_656 = NL + "    ";
  protected final String TEXT_657 = ".remove(";
  protected final String TEXT_658 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_659 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_660 = NL + "  ";
  protected final String TEXT_661 = " ";
  protected final String TEXT_662 = "::";
  protected final String TEXT_663 = "(";
  protected final String TEXT_664 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_665 = "() >= ";
  protected final String TEXT_666 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_667 = "(";
  protected final String TEXT_668 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_669 = "::";
  protected final String TEXT_670 = "(";
  protected final String TEXT_671 = " ";
  protected final String TEXT_672 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_673 = NL + "    if (";
  protected final String TEXT_674 = "() >= ";
  protected final String TEXT_675 = "())" + NL + "    {";
  protected final String TEXT_676 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_677 = NL + "    ";
  protected final String TEXT_678 = " ";
  protected final String TEXT_679 = " = ";
  protected final String TEXT_680 = ".";
  protected final String TEXT_681 = "();" + NL + "    bool ";
  protected final String TEXT_682 = " = ";
  protected final String TEXT_683 = " != null && !this.equals(";
  protected final String TEXT_684 = ");" + NL + "    if (";
  protected final String TEXT_685 = ")" + NL + "    {";
  protected final String TEXT_686 = NL + "      ";
  protected final String TEXT_687 = ".";
  protected final String TEXT_688 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_689 = NL + "      ";
  protected final String TEXT_690 = ".add(";
  protected final String TEXT_691 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_692 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_693 = "::";
  protected final String TEXT_694 = "(";
  protected final String TEXT_695 = " ";
  protected final String TEXT_696 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_697 = NL + "    //Unable to remove ";
  protected final String TEXT_698 = ", as it must always have a ";
  protected final String TEXT_699 = NL + "    if (!this.equals(";
  protected final String TEXT_700 = ".";
  protected final String TEXT_701 = "()))" + NL + "    {";
  protected final String TEXT_702 = NL + "      ";
  protected final String TEXT_703 = ".remove(";
  protected final String TEXT_704 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_705 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_706 = NL + "  bool ";
  protected final String TEXT_707 = "::";
  protected final String TEXT_708 = "(";
  protected final String TEXT_709 = "... ";
  protected final String TEXT_710 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_711 = NL + "    vector<";
  protected final String TEXT_712 = "*> ";
  protected final String TEXT_713 = " = new vector<";
  protected final String TEXT_714 = "*>();" + NL + "    for (";
  protected final String TEXT_715 = " ";
  protected final String TEXT_716 = " : ";
  protected final String TEXT_717 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_718 = ".contains(";
  protected final String TEXT_719 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_720 = NL + "      ";
  protected final String TEXT_721 = ".add(";
  protected final String TEXT_722 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_723 = ".size() != ";
  protected final String TEXT_724 = ".length || ";
  protected final String TEXT_725 = ".size() > ";
  protected final String TEXT_726 = "())" + NL + "    {";
  protected final String TEXT_727 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_728 = "*> ";
  protected final String TEXT_729 = " = new vector<";
  protected final String TEXT_730 = "*>(";
  protected final String TEXT_731 = ");";
  protected final String TEXT_732 = NL + "    ";
  protected final String TEXT_733 = ".clear();" + NL + "    for (";
  protected final String TEXT_734 = " ";
  protected final String TEXT_735 = " : ";
  protected final String TEXT_736 = ")" + NL + "    {";
  protected final String TEXT_737 = NL + "      ";
  protected final String TEXT_738 = ".add(";
  protected final String TEXT_739 = ");" + NL + "      if (";
  protected final String TEXT_740 = ".contains(";
  protected final String TEXT_741 = "))" + NL + "      {";
  protected final String TEXT_742 = NL + "        ";
  protected final String TEXT_743 = ".remove(";
  protected final String TEXT_744 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_745 = NL + "        ";
  protected final String TEXT_746 = ".";
  protected final String TEXT_747 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_748 = " ";
  protected final String TEXT_749 = " : ";
  protected final String TEXT_750 = ")" + NL + "    {";
  protected final String TEXT_751 = NL + "      ";
  protected final String TEXT_752 = ".";
  protected final String TEXT_753 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_754 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_755 = NL + "  ";
  protected final String TEXT_756 = " ";
  protected final String TEXT_757 = "::";
  protected final String TEXT_758 = "(";
  protected final String TEXT_759 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_760 = "(";
  protected final String TEXT_761 = ");" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_762 = "::";
  protected final String TEXT_763 = "(";
  protected final String TEXT_764 = " ";
  protected final String TEXT_765 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_766 = NL + "    ";
  protected final String TEXT_767 = " ";
  protected final String TEXT_768 = " = ";
  protected final String TEXT_769 = ".";
  protected final String TEXT_770 = "();" + NL + "    bool ";
  protected final String TEXT_771 = " = ";
  protected final String TEXT_772 = " != null && !this.equals(";
  protected final String TEXT_773 = ");" + NL + "    if (";
  protected final String TEXT_774 = ")" + NL + "    {";
  protected final String TEXT_775 = NL + "      ";
  protected final String TEXT_776 = ".";
  protected final String TEXT_777 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_778 = NL + "      ";
  protected final String TEXT_779 = ".add(";
  protected final String TEXT_780 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_781 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_782 = "::";
  protected final String TEXT_783 = "(";
  protected final String TEXT_784 = " ";
  protected final String TEXT_785 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_786 = NL + "    //Unable to remove ";
  protected final String TEXT_787 = ", as it must always have a ";
  protected final String TEXT_788 = NL + "    if (!this.equals(";
  protected final String TEXT_789 = ".";
  protected final String TEXT_790 = "()))" + NL + "    {";
  protected final String TEXT_791 = NL + "      ";
  protected final String TEXT_792 = ".remove(";
  protected final String TEXT_793 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_794 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_795 = NL + "  bool ";
  protected final String TEXT_796 = "::";
  protected final String TEXT_797 = "(";
  protected final String TEXT_798 = "* ";
  protected final String TEXT_799 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_800 = NL + "    if (";
  protected final String TEXT_801 = " == null)" + NL + "    {";
  protected final String TEXT_802 = NL + "      ";
  protected final String TEXT_803 = " ";
  protected final String TEXT_804 = " = ";
  protected final String TEXT_805 = ";";
  protected final String TEXT_806 = NL + "      ";
  protected final String TEXT_807 = " = null;" + NL + "      " + NL + "      if (";
  protected final String TEXT_808 = " != null && ";
  protected final String TEXT_809 = ".";
  protected final String TEXT_810 = "() != null)" + NL + "      {";
  protected final String TEXT_811 = NL + "        ";
  protected final String TEXT_812 = ".";
  protected final String TEXT_813 = "(null);" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_814 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_815 = NL + "    ";
  protected final String TEXT_816 = " ";
  protected final String TEXT_817 = " = ";
  protected final String TEXT_818 = "();" + NL + "    if (";
  protected final String TEXT_819 = " != null && !";
  protected final String TEXT_820 = ".equals(";
  protected final String TEXT_821 = "))" + NL + "    {";
  protected final String TEXT_822 = NL + "      ";
  protected final String TEXT_823 = ".";
  protected final String TEXT_824 = "(null);" + NL + "    }" + NL;
  protected final String TEXT_825 = NL + "    ";
  protected final String TEXT_826 = " = ";
  protected final String TEXT_827 = ";";
  protected final String TEXT_828 = NL + "    ";
  protected final String TEXT_829 = " ";
  protected final String TEXT_830 = " = ";
  protected final String TEXT_831 = ".";
  protected final String TEXT_832 = "();" + NL + "" + NL + "    if (!equals(";
  protected final String TEXT_833 = "))" + NL + "    {";
  protected final String TEXT_834 = NL + "      ";
  protected final String TEXT_835 = ".";
  protected final String TEXT_836 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_837 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_838 = NL + "  bool ";
  protected final String TEXT_839 = "::";
  protected final String TEXT_840 = "(";
  protected final String TEXT_841 = " ";
  protected final String TEXT_842 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_843 = NL + "    if (!";
  protected final String TEXT_844 = ".contains(";
  protected final String TEXT_845 = "))" + NL + "    {";
  protected final String TEXT_846 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_847 = "() <= ";
  protected final String TEXT_848 = "())" + NL + "    {";
  protected final String TEXT_849 = NL + "      return wasRemoved;" + NL + "    }" + NL + "\t" + NL + "    int oldIndex = std::find(";
  protected final String TEXT_850 = ".begin(), ";
  protected final String TEXT_851 = ".end(), ";
  protected final String TEXT_852 = ") - ";
  protected final String TEXT_853 = ".begin();";
  protected final String TEXT_854 = NL + "    ";
  protected final String TEXT_855 = ".erase(oldIndex);" + NL + "    if (";
  protected final String TEXT_856 = ".";
  protected final String TEXT_857 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_858 = ".";
  protected final String TEXT_859 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_860 = NL + "        ";
  protected final String TEXT_861 = ".add(oldIndex,";
  protected final String TEXT_862 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_863 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_864 = NL + "  bool ";
  protected final String TEXT_865 = "::";
  protected final String TEXT_866 = "(";
  protected final String TEXT_867 = " ";
  protected final String TEXT_868 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_869 = NL + "    if (!";
  protected final String TEXT_870 = ".contains(";
  protected final String TEXT_871 = "))" + NL + "    {";
  protected final String TEXT_872 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_873 = "() <= ";
  protected final String TEXT_874 = "())" + NL + "    {";
  protected final String TEXT_875 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = std::find(";
  protected final String TEXT_876 = ".begin(), ";
  protected final String TEXT_877 = ".end(), ";
  protected final String TEXT_878 = ") - ";
  protected final String TEXT_879 = ".begin();";
  protected final String TEXT_880 = NL + "    ";
  protected final String TEXT_881 = ".erase(oldIndex);" + NL + "    if (";
  protected final String TEXT_882 = ".";
  protected final String TEXT_883 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_884 = ".";
  protected final String TEXT_885 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_886 = NL + "        ";
  protected final String TEXT_887 = ".add(oldIndex,";
  protected final String TEXT_888 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_889 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_890 = NL + "  bool ";
  protected final String TEXT_891 = "::";
  protected final String TEXT_892 = "(";
  protected final String TEXT_893 = "* ";
  protected final String TEXT_894 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_895 = NL + "    if (";
  protected final String TEXT_896 = " != null && ";
  protected final String TEXT_897 = ".";
  protected final String TEXT_898 = "() >= ";
  protected final String TEXT_899 = ".";
  protected final String TEXT_900 = "())" + NL + "    {";
  protected final String TEXT_901 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_902 = NL + "    ";
  protected final String TEXT_903 = " ";
  protected final String TEXT_904 = " = ";
  protected final String TEXT_905 = ";";
  protected final String TEXT_906 = NL + "    ";
  protected final String TEXT_907 = " = ";
  protected final String TEXT_908 = ";" + NL + "    if (";
  protected final String TEXT_909 = " != null && !";
  protected final String TEXT_910 = ".equals(";
  protected final String TEXT_911 = "))" + NL + "    {";
  protected final String TEXT_912 = NL + "      ";
  protected final String TEXT_913 = ".";
  protected final String TEXT_914 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_915 = " != null)" + NL + "    {";
  protected final String TEXT_916 = NL + "      ";
  protected final String TEXT_917 = ".";
  protected final String TEXT_918 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_919 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_920 = NL + "  bool ";
  protected final String TEXT_921 = "::";
  protected final String TEXT_922 = "(";
  protected final String TEXT_923 = " ";
  protected final String TEXT_924 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_925 = NL + "    if (";
  protected final String TEXT_926 = " == null)" + NL + "    {";
  protected final String TEXT_927 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_928 = NL + "    ";
  protected final String TEXT_929 = " ";
  protected final String TEXT_930 = " = ";
  protected final String TEXT_931 = ";";
  protected final String TEXT_932 = NL + "    ";
  protected final String TEXT_933 = " = ";
  protected final String TEXT_934 = ";" + NL + "    if (";
  protected final String TEXT_935 = " != null && !";
  protected final String TEXT_936 = ".equals(";
  protected final String TEXT_937 = "))" + NL + "    {";
  protected final String TEXT_938 = NL + "      ";
  protected final String TEXT_939 = ".";
  protected final String TEXT_940 = "(this);" + NL + "    }";
  protected final String TEXT_941 = NL + "    ";
  protected final String TEXT_942 = ".";
  protected final String TEXT_943 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_944 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_945 = NL + "  bool ";
  protected final String TEXT_946 = "::";
  protected final String TEXT_947 = "(";
  protected final String TEXT_948 = " ";
  protected final String TEXT_949 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_950 = NL + "    //Must provide ";
  protected final String TEXT_951 = " to ";
  protected final String TEXT_952 = NL + "    if (";
  protected final String TEXT_953 = " == null)" + NL + "    {";
  protected final String TEXT_954 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_955 = " already at maximum (";
  protected final String TEXT_956 = ")" + NL + "    if (";
  protected final String TEXT_957 = ".";
  protected final String TEXT_958 = "() >= ";
  protected final String TEXT_959 = ".";
  protected final String TEXT_960 = "())" + NL + "    {";
  protected final String TEXT_961 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_962 = NL + "    ";
  protected final String TEXT_963 = " ";
  protected final String TEXT_964 = " = ";
  protected final String TEXT_965 = ";";
  protected final String TEXT_966 = NL + "    ";
  protected final String TEXT_967 = " = ";
  protected final String TEXT_968 = ";" + NL + "    if (";
  protected final String TEXT_969 = " != null && !";
  protected final String TEXT_970 = ".equals(";
  protected final String TEXT_971 = "))" + NL + "    {" + NL + "      bool didRemove = ";
  protected final String TEXT_972 = ".";
  protected final String TEXT_973 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_974 = NL + "        ";
  protected final String TEXT_975 = " = ";
  protected final String TEXT_976 = ";";
  protected final String TEXT_977 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_978 = NL + "    ";
  protected final String TEXT_979 = ".";
  protected final String TEXT_980 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_981 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_982 = NL + "  bool ";
  protected final String TEXT_983 = "::";
  protected final String TEXT_984 = "(";
  protected final String TEXT_985 = " ";
  protected final String TEXT_986 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_987 = NL + "    //Must provide ";
  protected final String TEXT_988 = " to ";
  protected final String TEXT_989 = NL + "    if (";
  protected final String TEXT_990 = " == null)" + NL + "    {";
  protected final String TEXT_991 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_992 = " != null && ";
  protected final String TEXT_993 = ".";
  protected final String TEXT_994 = "() <= ";
  protected final String TEXT_995 = ".";
  protected final String TEXT_996 = "())" + NL + "    {";
  protected final String TEXT_997 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_998 = NL + "    ";
  protected final String TEXT_999 = " ";
  protected final String TEXT_1000 = " = ";
  protected final String TEXT_1001 = ";";
  protected final String TEXT_1002 = NL + "    ";
  protected final String TEXT_1003 = " = ";
  protected final String TEXT_1004 = ";" + NL + "    if (";
  protected final String TEXT_1005 = " != null && !";
  protected final String TEXT_1006 = ".equals(";
  protected final String TEXT_1007 = "))" + NL + "    {" + NL + "      bool didRemove = ";
  protected final String TEXT_1008 = ".";
  protected final String TEXT_1009 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1010 = NL + "        ";
  protected final String TEXT_1011 = " = ";
  protected final String TEXT_1012 = ";";
  protected final String TEXT_1013 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1014 = NL + "    ";
  protected final String TEXT_1015 = ".";
  protected final String TEXT_1016 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1017 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1018 = NL + "  bool ";
  protected final String TEXT_1019 = "::";
  protected final String TEXT_1020 = "(";
  protected final String TEXT_1021 = " ";
  protected final String TEXT_1022 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1023 = NL + "    ";
  protected final String TEXT_1024 = " ";
  protected final String TEXT_1025 = " = ";
  protected final String TEXT_1026 = ".";
  protected final String TEXT_1027 = "();" + NL + "    if (";
  protected final String TEXT_1028 = " == null)" + NL + "    {";
  protected final String TEXT_1029 = NL + "      ";
  protected final String TEXT_1030 = ".";
  protected final String TEXT_1031 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1032 = "))" + NL + "    {";
  protected final String TEXT_1033 = NL + "      ";
  protected final String TEXT_1034 = ".";
  protected final String TEXT_1035 = "(";
  protected final String TEXT_1036 = ");";
  protected final String TEXT_1037 = NL + "      ";
  protected final String TEXT_1038 = "(";
  protected final String TEXT_1039 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1040 = NL + "      ";
  protected final String TEXT_1041 = ".add(";
  protected final String TEXT_1042 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1043 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1044 = "::";
  protected final String TEXT_1045 = "(";
  protected final String TEXT_1046 = " ";
  protected final String TEXT_1047 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_1048 = NL + "    if (";
  protected final String TEXT_1049 = ".contains(";
  protected final String TEXT_1050 = "))" + NL + "    {";
  protected final String TEXT_1051 = NL + "      ";
  protected final String TEXT_1052 = ".remove(";
  protected final String TEXT_1053 = ");";
  protected final String TEXT_1054 = NL + "      ";
  protected final String TEXT_1055 = ".";
  protected final String TEXT_1056 = "(null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1057 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1058 = NL + "  bool ";
  protected final String TEXT_1059 = "::";
  protected final String TEXT_1060 = "(";
  protected final String TEXT_1061 = "* ";
  protected final String TEXT_1062 = ")" + NL + "  {" + NL + "    boolwasSet = false;";
  protected final String TEXT_1063 = NL + "    ";
  protected final String TEXT_1064 = " ";
  protected final String TEXT_1065 = " = ";
  protected final String TEXT_1066 = ";";
  protected final String TEXT_1067 = NL + "    ";
  protected final String TEXT_1068 = " = ";
  protected final String TEXT_1069 = ";" + NL + "    if (";
  protected final String TEXT_1070 = " != null && !";
  protected final String TEXT_1071 = ".equals(";
  protected final String TEXT_1072 = "))" + NL + "    {";
  protected final String TEXT_1073 = NL + "      ";
  protected final String TEXT_1074 = ".";
  protected final String TEXT_1075 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1076 = " != null)" + NL + "    {";
  protected final String TEXT_1077 = NL + "      ";
  protected final String TEXT_1078 = ".";
  protected final String TEXT_1079 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1080 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1081 = NL + "  bool ";
  protected final String TEXT_1082 = "::";
  protected final String TEXT_1083 = "(";
  protected final String TEXT_1084 = " ";
  protected final String TEXT_1085 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1086 = NL + "    if (";
  protected final String TEXT_1087 = "() >= ";
  protected final String TEXT_1088 = "())" + NL + "    {";
  protected final String TEXT_1089 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1090 = NL + "    ";
  protected final String TEXT_1091 = " ";
  protected final String TEXT_1092 = " = ";
  protected final String TEXT_1093 = ".";
  protected final String TEXT_1094 = "();" + NL + "    if (";
  protected final String TEXT_1095 = " == null)" + NL + "    {";
  protected final String TEXT_1096 = NL + "      ";
  protected final String TEXT_1097 = ".";
  protected final String TEXT_1098 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1099 = "))" + NL + "    {";
  protected final String TEXT_1100 = NL + "      ";
  protected final String TEXT_1101 = ".";
  protected final String TEXT_1102 = "(";
  protected final String TEXT_1103 = ");";
  protected final String TEXT_1104 = NL + "      ";
  protected final String TEXT_1105 = "(";
  protected final String TEXT_1106 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1107 = NL + "      ";
  protected final String TEXT_1108 = ".add(";
  protected final String TEXT_1109 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1110 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1111 = "::";
  protected final String TEXT_1112 = "(";
  protected final String TEXT_1113 = " ";
  protected final String TEXT_1114 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_1115 = NL + "    if (";
  protected final String TEXT_1116 = ".contains(";
  protected final String TEXT_1117 = "))" + NL + "    {";
  protected final String TEXT_1118 = NL + "      ";
  protected final String TEXT_1119 = ".remove(";
  protected final String TEXT_1120 = ");";
  protected final String TEXT_1121 = NL + "      ";
  protected final String TEXT_1122 = ".";
  protected final String TEXT_1123 = "(null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1124 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1125 = NL + "  bool ";
  protected final String TEXT_1126 = "::";
  protected final String TEXT_1127 = "(";
  protected final String TEXT_1128 = " ";
  protected final String TEXT_1129 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1130 = NL + "    if (";
  protected final String TEXT_1131 = "() < ";
  protected final String TEXT_1132 = "())" + NL + "    {";
  protected final String TEXT_1133 = NL + "      ";
  protected final String TEXT_1134 = ".add(";
  protected final String TEXT_1135 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1136 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1137 = "::";
  protected final String TEXT_1138 = "(";
  protected final String TEXT_1139 = " ";
  protected final String TEXT_1140 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_1141 = NL + "    if (!";
  protected final String TEXT_1142 = ".contains(";
  protected final String TEXT_1143 = "))" + NL + "    {";
  protected final String TEXT_1144 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1145 = "() <= ";
  protected final String TEXT_1146 = "())" + NL + "    {";
  protected final String TEXT_1147 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1148 = NL + "    ";
  protected final String TEXT_1149 = ".remove(";
  protected final String TEXT_1150 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_1151 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1152 = NL + "  bool ";
  protected final String TEXT_1153 = "::";
  protected final String TEXT_1154 = "(";
  protected final String TEXT_1155 = " ";
  protected final String TEXT_1156 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1157 = NL + "    if (";
  protected final String TEXT_1158 = "() >= ";
  protected final String TEXT_1159 = "())" + NL + "    {";
  protected final String TEXT_1160 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1161 = NL + "    ";
  protected final String TEXT_1162 = " ";
  protected final String TEXT_1163 = " = ";
  protected final String TEXT_1164 = ".";
  protected final String TEXT_1165 = "();" + NL + "    if (";
  protected final String TEXT_1166 = " != null && ";
  protected final String TEXT_1167 = ".";
  protected final String TEXT_1168 = "() <= ";
  protected final String TEXT_1169 = "())" + NL + "    {";
  protected final String TEXT_1170 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1171 = " != null)" + NL + "    {";
  protected final String TEXT_1172 = NL + "      ";
  protected final String TEXT_1173 = ".";
  protected final String TEXT_1174 = ".remove(";
  protected final String TEXT_1175 = ");" + NL + "    }";
  protected final String TEXT_1176 = NL + "    ";
  protected final String TEXT_1177 = ".add(";
  protected final String TEXT_1178 = ");";
  protected final String TEXT_1179 = NL + "    ";
  protected final String TEXT_1180 = "(";
  protected final String TEXT_1181 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1182 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1183 = "::";
  protected final String TEXT_1184 = "(";
  protected final String TEXT_1185 = " ";
  protected final String TEXT_1186 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_1187 = NL + "    if (";
  protected final String TEXT_1188 = ".contains(";
  protected final String TEXT_1189 = ") && ";
  protected final String TEXT_1190 = "() > ";
  protected final String TEXT_1191 = "())" + NL + "    {";
  protected final String TEXT_1192 = NL + "      ";
  protected final String TEXT_1193 = ".remove(";
  protected final String TEXT_1194 = ");";
  protected final String TEXT_1195 = NL + "      ";
  protected final String TEXT_1196 = "(";
  protected final String TEXT_1197 = ",null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1198 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1199 = NL + "  bool ";
  protected final String TEXT_1200 = "::";
  protected final String TEXT_1201 = "(";
  protected final String TEXT_1202 = "... ";
  protected final String TEXT_1203 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1204 = NL + "    vector<";
  protected final String TEXT_1205 = "*> ";
  protected final String TEXT_1206 = " = new vector<";
  protected final String TEXT_1207 = "*>();" + NL + "    for (";
  protected final String TEXT_1208 = " ";
  protected final String TEXT_1209 = " : ";
  protected final String TEXT_1210 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1211 = ".contains(";
  protected final String TEXT_1212 = "))" + NL + "      {";
  protected final String TEXT_1213 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1214 = ".";
  protected final String TEXT_1215 = "() != null && !this.equals(";
  protected final String TEXT_1216 = ".";
  protected final String TEXT_1217 = "()))" + NL + "      {";
  protected final String TEXT_1218 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1219 = NL + "      ";
  protected final String TEXT_1220 = ".add(";
  protected final String TEXT_1221 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1222 = ".size() != ";
  protected final String TEXT_1223 = "())" + NL + "    {";
  protected final String TEXT_1224 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1225 = NL + "    ";
  protected final String TEXT_1226 = ".removeAll(";
  protected final String TEXT_1227 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1228 = " orphan : ";
  protected final String TEXT_1229 = ")" + NL + "    {";
  protected final String TEXT_1230 = NL + "      ";
  protected final String TEXT_1231 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1232 = NL + "    ";
  protected final String TEXT_1233 = ".clear();" + NL + "    for (";
  protected final String TEXT_1234 = " ";
  protected final String TEXT_1235 = " : ";
  protected final String TEXT_1236 = ")" + NL + "    {";
  protected final String TEXT_1237 = NL + "      ";
  protected final String TEXT_1238 = "(";
  protected final String TEXT_1239 = ", this);";
  protected final String TEXT_1240 = NL + "      ";
  protected final String TEXT_1241 = ".add(";
  protected final String TEXT_1242 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1243 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1244 = NL + "  void ";
  protected final String TEXT_1245 = "::";
  protected final String TEXT_1246 = "(";
  protected final String TEXT_1247 = " ";
  protected final String TEXT_1248 = ", ";
  protected final String TEXT_1249 = " ";
  protected final String TEXT_1250 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1251 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1252 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1253 = ", ";
  protected final String TEXT_1254 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1255 = " to ";
  protected final String TEXT_1256 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1257 = NL + "  bool ";
  protected final String TEXT_1258 = "::";
  protected final String TEXT_1259 = "(";
  protected final String TEXT_1260 = " ";
  protected final String TEXT_1261 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1262 = NL + "    ";
  protected final String TEXT_1263 = ".add(";
  protected final String TEXT_1264 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1265 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1266 = "::";
  protected final String TEXT_1267 = "(";
  protected final String TEXT_1268 = " ";
  protected final String TEXT_1269 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_1270 = NL + "    if (";
  protected final String TEXT_1271 = ".contains(";
  protected final String TEXT_1272 = "))" + NL + "    {";
  protected final String TEXT_1273 = NL + "      ";
  protected final String TEXT_1274 = ".remove(";
  protected final String TEXT_1275 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1276 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1277 = NL + "  bool ";
  protected final String TEXT_1278 = "::";
  protected final String TEXT_1279 = "(";
  protected final String TEXT_1280 = " ";
  protected final String TEXT_1281 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1282 = NL + "    if (";
  protected final String TEXT_1283 = "() < ";
  protected final String TEXT_1284 = "())" + NL + "    {";
  protected final String TEXT_1285 = NL + "      ";
  protected final String TEXT_1286 = ".add(";
  protected final String TEXT_1287 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1288 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1289 = "::";
  protected final String TEXT_1290 = "(";
  protected final String TEXT_1291 = " ";
  protected final String TEXT_1292 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_1293 = NL + "    if (";
  protected final String TEXT_1294 = ".contains(";
  protected final String TEXT_1295 = "))" + NL + "    {";
  protected final String TEXT_1296 = NL + "      ";
  protected final String TEXT_1297 = ".remove(";
  protected final String TEXT_1298 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1299 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1300 = NL + "  bool ";
  protected final String TEXT_1301 = "::";
  protected final String TEXT_1302 = "(";
  protected final String TEXT_1303 = " ";
  protected final String TEXT_1304 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_1305 = NL + "    ";
  protected final String TEXT_1306 = ".add(";
  protected final String TEXT_1307 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1308 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  bool ";
  protected final String TEXT_1309 = "::";
  protected final String TEXT_1310 = "(";
  protected final String TEXT_1311 = " ";
  protected final String TEXT_1312 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_1313 = NL + "    if (!";
  protected final String TEXT_1314 = ".contains(";
  protected final String TEXT_1315 = "))" + NL + "    {";
  protected final String TEXT_1316 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1317 = "() <= ";
  protected final String TEXT_1318 = "())" + NL + "    {";
  protected final String TEXT_1319 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1320 = NL + "    ";
  protected final String TEXT_1321 = ".remove(";
  protected final String TEXT_1322 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_1323 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1324 = NL + "  bool ";
  protected final String TEXT_1325 = "::";
  protected final String TEXT_1326 = "(";
  protected final String TEXT_1327 = "... ";
  protected final String TEXT_1328 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1329 = NL + "    vector<";
  protected final String TEXT_1330 = "*> ";
  protected final String TEXT_1331 = " = new vector<";
  protected final String TEXT_1332 = "*>();" + NL + "    for (";
  protected final String TEXT_1333 = " ";
  protected final String TEXT_1334 = " : ";
  protected final String TEXT_1335 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1336 = ".contains(";
  protected final String TEXT_1337 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1338 = NL + "      ";
  protected final String TEXT_1339 = ".add(";
  protected final String TEXT_1340 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1341 = ".size() != ";
  protected final String TEXT_1342 = ".length || ";
  protected final String TEXT_1343 = ".size() != ";
  protected final String TEXT_1344 = "())" + NL + "    {";
  protected final String TEXT_1345 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1346 = NL + "    ";
  protected final String TEXT_1347 = ".clear();";
  protected final String TEXT_1348 = NL + "    ";
  protected final String TEXT_1349 = ".addAll(";
  protected final String TEXT_1350 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1351 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1352 = NL + "  bool ";
  protected final String TEXT_1353 = "::";
  protected final String TEXT_1354 = "(";
  protected final String TEXT_1355 = "... ";
  protected final String TEXT_1356 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1357 = NL + "    vector<";
  protected final String TEXT_1358 = "*> ";
  protected final String TEXT_1359 = " = new vector<";
  protected final String TEXT_1360 = "*>();" + NL + "    for (";
  protected final String TEXT_1361 = " ";
  protected final String TEXT_1362 = " : ";
  protected final String TEXT_1363 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1364 = ".contains(";
  protected final String TEXT_1365 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1366 = NL + "      ";
  protected final String TEXT_1367 = ".add(";
  protected final String TEXT_1368 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1369 = ".size() != ";
  protected final String TEXT_1370 = ".length || ";
  protected final String TEXT_1371 = ".size() < ";
  protected final String TEXT_1372 = "() || ";
  protected final String TEXT_1373 = ".size() > ";
  protected final String TEXT_1374 = "())" + NL + "    {";
  protected final String TEXT_1375 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1376 = "*> ";
  protected final String TEXT_1377 = " = new vector<";
  protected final String TEXT_1378 = "*>(";
  protected final String TEXT_1379 = ");";
  protected final String TEXT_1380 = NL + "    ";
  protected final String TEXT_1381 = ".clear();" + NL + "    for (";
  protected final String TEXT_1382 = " ";
  protected final String TEXT_1383 = " : ";
  protected final String TEXT_1384 = ")" + NL + "    {";
  protected final String TEXT_1385 = NL + "      ";
  protected final String TEXT_1386 = ".add(";
  protected final String TEXT_1387 = ");" + NL + "      if (";
  protected final String TEXT_1388 = ".contains(";
  protected final String TEXT_1389 = "))" + NL + "      {";
  protected final String TEXT_1390 = NL + "        ";
  protected final String TEXT_1391 = ".remove(";
  protected final String TEXT_1392 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1393 = NL + "        ";
  protected final String TEXT_1394 = ".";
  protected final String TEXT_1395 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1396 = " ";
  protected final String TEXT_1397 = " : ";
  protected final String TEXT_1398 = ")" + NL + "    {";
  protected final String TEXT_1399 = NL + "      ";
  protected final String TEXT_1400 = ".";
  protected final String TEXT_1401 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1402 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1403 = NL + "  bool ";
  protected final String TEXT_1404 = "::";
  protected final String TEXT_1405 = "(";
  protected final String TEXT_1406 = "... ";
  protected final String TEXT_1407 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1408 = NL + "    vector<";
  protected final String TEXT_1409 = "*> ";
  protected final String TEXT_1410 = " = new vector<";
  protected final String TEXT_1411 = "*>();" + NL + "    for (";
  protected final String TEXT_1412 = " ";
  protected final String TEXT_1413 = " : ";
  protected final String TEXT_1414 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1415 = ".contains(";
  protected final String TEXT_1416 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1417 = NL + "      ";
  protected final String TEXT_1418 = ".add(";
  protected final String TEXT_1419 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1420 = ".size() != ";
  protected final String TEXT_1421 = ".length || ";
  protected final String TEXT_1422 = ".size() < ";
  protected final String TEXT_1423 = "())" + NL + "    {";
  protected final String TEXT_1424 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1425 = "*> ";
  protected final String TEXT_1426 = " = new vector<";
  protected final String TEXT_1427 = "*>(";
  protected final String TEXT_1428 = ");";
  protected final String TEXT_1429 = NL + "    ";
  protected final String TEXT_1430 = ".clear();" + NL + "    for (";
  protected final String TEXT_1431 = " ";
  protected final String TEXT_1432 = " : ";
  protected final String TEXT_1433 = ")" + NL + "    {";
  protected final String TEXT_1434 = NL + "      ";
  protected final String TEXT_1435 = ".add(";
  protected final String TEXT_1436 = ");" + NL + "      if (";
  protected final String TEXT_1437 = ".contains(";
  protected final String TEXT_1438 = "))" + NL + "      {";
  protected final String TEXT_1439 = NL + "        ";
  protected final String TEXT_1440 = ".remove(";
  protected final String TEXT_1441 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1442 = NL + "        ";
  protected final String TEXT_1443 = ".";
  protected final String TEXT_1444 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1445 = " ";
  protected final String TEXT_1446 = " : ";
  protected final String TEXT_1447 = ")" + NL + "    {";
  protected final String TEXT_1448 = NL + "      ";
  protected final String TEXT_1449 = ".";
  protected final String TEXT_1450 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1451 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1452 = NL + "  bool ";
  protected final String TEXT_1453 = "::";
  protected final String TEXT_1454 = "(";
  protected final String TEXT_1455 = "... ";
  protected final String TEXT_1456 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1457 = NL + "    vector<";
  protected final String TEXT_1458 = "*> ";
  protected final String TEXT_1459 = " = new vector<";
  protected final String TEXT_1460 = "*>();" + NL + "    for (";
  protected final String TEXT_1461 = " ";
  protected final String TEXT_1462 = " : ";
  protected final String TEXT_1463 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1464 = ".contains(";
  protected final String TEXT_1465 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1466 = NL + "      ";
  protected final String TEXT_1467 = ".add(";
  protected final String TEXT_1468 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1469 = ".size() != ";
  protected final String TEXT_1470 = ".length || ";
  protected final String TEXT_1471 = ".size() < ";
  protected final String TEXT_1472 = "() || ";
  protected final String TEXT_1473 = ".size() > ";
  protected final String TEXT_1474 = "())" + NL + "    {";
  protected final String TEXT_1475 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1476 = NL + "    ";
  protected final String TEXT_1477 = ".clear();";
  protected final String TEXT_1478 = NL + "    ";
  protected final String TEXT_1479 = ".addAll(";
  protected final String TEXT_1480 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1481 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1482 = NL + "  bool ";
  protected final String TEXT_1483 = "::";
  protected final String TEXT_1484 = "(";
  protected final String TEXT_1485 = "... ";
  protected final String TEXT_1486 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1487 = NL + "    if (";
  protected final String TEXT_1488 = ".length < ";
  protected final String TEXT_1489 = "()";
  protected final String TEXT_1490 = ")" + NL + "    {";
  protected final String TEXT_1491 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    vector<";
  protected final String TEXT_1492 = "*> ";
  protected final String TEXT_1493 = " = new vector<";
  protected final String TEXT_1494 = "*>();" + NL + "    HashMap<";
  protected final String TEXT_1495 = ",Integer> ";
  protected final String TEXT_1496 = " = new HashMap<";
  protected final String TEXT_1497 = ",Integer>();" + NL + "    for (";
  protected final String TEXT_1498 = " ";
  protected final String TEXT_1499 = " : ";
  protected final String TEXT_1500 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1501 = ".contains(";
  protected final String TEXT_1502 = "))" + NL + "      {";
  protected final String TEXT_1503 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1504 = ".";
  protected final String TEXT_1505 = "() != null && !this.equals(";
  protected final String TEXT_1506 = ".";
  protected final String TEXT_1507 = "()))" + NL + "      {";
  protected final String TEXT_1508 = NL + "        ";
  protected final String TEXT_1509 = " ";
  protected final String TEXT_1510 = " = ";
  protected final String TEXT_1511 = ".";
  protected final String TEXT_1512 = "();" + NL + "        if (!";
  protected final String TEXT_1513 = ".containsKey(";
  protected final String TEXT_1514 = "))" + NL + "        {";
  protected final String TEXT_1515 = NL + "          ";
  protected final String TEXT_1516 = ".put(";
  protected final String TEXT_1517 = ", new Integer(";
  protected final String TEXT_1518 = ".";
  protected final String TEXT_1519 = "()));" + NL + "        }" + NL + "        Integer currentCount = ";
  protected final String TEXT_1520 = ".get(";
  protected final String TEXT_1521 = ");" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_1522 = ")" + NL + "        {";
  protected final String TEXT_1523 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_1524 = NL + "        ";
  protected final String TEXT_1525 = ".put(";
  protected final String TEXT_1526 = ", new Integer(nextCount));" + NL + "      }";
  protected final String TEXT_1527 = NL + "      ";
  protected final String TEXT_1528 = ".add(";
  protected final String TEXT_1529 = ");" + NL + "    }" + NL;
  protected final String TEXT_1530 = NL + "    ";
  protected final String TEXT_1531 = ".removeAll(";
  protected final String TEXT_1532 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_1533 = " orphan : ";
  protected final String TEXT_1534 = ")" + NL + "    {";
  protected final String TEXT_1535 = NL + "      ";
  protected final String TEXT_1536 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1537 = NL + "    ";
  protected final String TEXT_1538 = ".clear();" + NL + "    for (";
  protected final String TEXT_1539 = " ";
  protected final String TEXT_1540 = " : ";
  protected final String TEXT_1541 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1542 = ".";
  protected final String TEXT_1543 = "() != null)" + NL + "      {";
  protected final String TEXT_1544 = NL + "        ";
  protected final String TEXT_1545 = ".";
  protected final String TEXT_1546 = "().";
  protected final String TEXT_1547 = ".remove(";
  protected final String TEXT_1548 = ");" + NL + "      }";
  protected final String TEXT_1549 = NL + "      ";
  protected final String TEXT_1550 = "(";
  protected final String TEXT_1551 = ", this);";
  protected final String TEXT_1552 = NL + "      ";
  protected final String TEXT_1553 = ".add(";
  protected final String TEXT_1554 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1555 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1556 = NL + "  void ";
  protected final String TEXT_1557 = "::";
  protected final String TEXT_1558 = "(";
  protected final String TEXT_1559 = " ";
  protected final String TEXT_1560 = ", ";
  protected final String TEXT_1561 = " ";
  protected final String TEXT_1562 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1563 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1564 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1565 = ", ";
  protected final String TEXT_1566 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1567 = " to ";
  protected final String TEXT_1568 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1569 = NL + "  bool ";
  protected final String TEXT_1570 = "::";
  protected final String TEXT_1571 = "(";
  protected final String TEXT_1572 = "... ";
  protected final String TEXT_1573 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1574 = NL + "    vector<";
  protected final String TEXT_1575 = "*> ";
  protected final String TEXT_1576 = " = new vector<";
  protected final String TEXT_1577 = "*>();" + NL + "    for (";
  protected final String TEXT_1578 = " ";
  protected final String TEXT_1579 = " : ";
  protected final String TEXT_1580 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1581 = ".contains(";
  protected final String TEXT_1582 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1583 = NL + "      ";
  protected final String TEXT_1584 = ".add(";
  protected final String TEXT_1585 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1586 = ".size() != ";
  protected final String TEXT_1587 = ".length || ";
  protected final String TEXT_1588 = ".size() > ";
  protected final String TEXT_1589 = "())" + NL + "    {";
  protected final String TEXT_1590 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1591 = NL + "    ";
  protected final String TEXT_1592 = ".clear();";
  protected final String TEXT_1593 = NL + "    ";
  protected final String TEXT_1594 = ".addAll(";
  protected final String TEXT_1595 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1596 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1597 = NL + "  bool ";
  protected final String TEXT_1598 = "::";
  protected final String TEXT_1599 = "(";
  protected final String TEXT_1600 = "... ";
  protected final String TEXT_1601 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1602 = NL + "    vector<";
  protected final String TEXT_1603 = "*> ";
  protected final String TEXT_1604 = " = new vector<";
  protected final String TEXT_1605 = "*>();" + NL + "    for (";
  protected final String TEXT_1606 = " ";
  protected final String TEXT_1607 = " : ";
  protected final String TEXT_1608 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1609 = ".contains(";
  protected final String TEXT_1610 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1611 = NL + "      ";
  protected final String TEXT_1612 = ".add(";
  protected final String TEXT_1613 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1614 = ".size() != ";
  protected final String TEXT_1615 = ".length || ";
  protected final String TEXT_1616 = ".size() < ";
  protected final String TEXT_1617 = "())" + NL + "    {";
  protected final String TEXT_1618 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1619 = NL + "    ";
  protected final String TEXT_1620 = ".clear();";
  protected final String TEXT_1621 = NL + "    ";
  protected final String TEXT_1622 = ".addAll(";
  protected final String TEXT_1623 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1624 = NL + "    return wasSet;" + NL + "  }";
  protected final String TEXT_1625 = NL + "  bool equals(Object obj)" + NL + "  {" + NL + "    if (obj == NULL) { return false; }" + NL + "    if (getClass() != obj.getClass()) { return false; }" + NL;
  protected final String TEXT_1626 = NL + "    ";
  protected final String TEXT_1627 = " == (";
  protected final String TEXT_1628 = ")obj;" + NL + "  " + NL + "    return true;" + NL + "  }" + NL + "" + NL + " int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_1629 = NL + "    ";
  protected final String TEXT_1630 = NL;
  protected final String TEXT_1631 = NL + "    ";
  protected final String TEXT_1632 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1633 = NL + "  private void ";
  protected final String TEXT_1634 = "()" + NL + "  {" + NL + "     try" + NL + "     {";
  protected final String TEXT_1635 = NL + "       ";
  protected final String TEXT_1636 = NL + "     }" + NL + "     catch (InterruptedException e)" + NL + "     {" + NL + " " + NL + "     }" + NL + "  }" + NL;
  protected final String TEXT_1637 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1638 = NL + "    ";
  protected final String TEXT_1639 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1640 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_1641 = NL + "      ";
  protected final String TEXT_1642 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1643 = NL + "  private void ";
  protected final String TEXT_1644 = "()" + NL + "  {";
  protected final String TEXT_1645 = NL + "    ";
  protected final String TEXT_1646 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1647 = "\",";
  protected final String TEXT_1648 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1649 = "()" + NL + "  {";
  protected final String TEXT_1650 = NL + "    ";
  protected final String TEXT_1651 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1652 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1653 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1654 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void run ()" + NL + "    {";
  protected final String TEXT_1655 = NL + "      if (\"";
  protected final String TEXT_1656 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1657 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1658 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1659 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1660 = NL + "  " + NL + "  //------------------------" + NL + "  // DESTRUCTOR" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1661 = NL + "    ";
  protected final String TEXT_1662 = " = NULL;" + NL + "    delete ";
  protected final String TEXT_1663 = ";";
  protected final String TEXT_1664 = NL + "    ";
  protected final String TEXT_1665 = ".clear();";
  protected final String TEXT_1666 = NL + "    ";
  protected final String TEXT_1667 = " ";
  protected final String TEXT_1668 = " = ";
  protected final String TEXT_1669 = ";";
  protected final String TEXT_1670 = NL + "    ";
  protected final String TEXT_1671 = " = NULL;" + NL + "    if (";
  protected final String TEXT_1672 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1673 = ";" + NL + "    }";
  protected final String TEXT_1674 = NL + "    if (";
  protected final String TEXT_1675 = " != NULL)" + NL + "    {";
  protected final String TEXT_1676 = NL + "      ";
  protected final String TEXT_1677 = ".";
  protected final String TEXT_1678 = "(NULL);" + NL + "    }";
  protected final String TEXT_1679 = NL + "    ";
  protected final String TEXT_1680 = " ";
  protected final String TEXT_1681 = " = ";
  protected final String TEXT_1682 = ";";
  protected final String TEXT_1683 = NL + "    ";
  protected final String TEXT_1684 = " = NULL;" + NL + "    if (";
  protected final String TEXT_1685 = " != NULL)" + NL + "    {";
  protected final String TEXT_1686 = NL + "      ";
  protected final String TEXT_1687 = ".";
  protected final String TEXT_1688 = "(NULL);" + NL + "    }";
  protected final String TEXT_1689 = NL + "    ";
  protected final String TEXT_1690 = " ";
  protected final String TEXT_1691 = " = ";
  protected final String TEXT_1692 = ";";
  protected final String TEXT_1693 = NL + "    ";
  protected final String TEXT_1694 = " = NULL;" + NL + "    if (";
  protected final String TEXT_1695 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1696 = ";" + NL + "    }";
  protected final String TEXT_1697 = NL + "    if (";
  protected final String TEXT_1698 = " != null)" + NL + "    {";
  protected final String TEXT_1699 = NL + "      ";
  protected final String TEXT_1700 = " ";
  protected final String TEXT_1701 = " = ";
  protected final String TEXT_1702 = ";" + NL + "      this.";
  protected final String TEXT_1703 = " = NULL;";
  protected final String TEXT_1704 = NL + "      ";
  protected final String TEXT_1705 = ".";
  protected final String TEXT_1706 = "(this);" + NL + "    }";
  protected final String TEXT_1707 = NL + "    if (";
  protected final String TEXT_1708 = " != NULL)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1709 = ";" + NL + "    }";
  protected final String TEXT_1710 = NL + "    if (";
  protected final String TEXT_1711 = " != NULL)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1712 = ".";
  protected final String TEXT_1713 = "() <= ";
  protected final String TEXT_1714 = ")" + NL + "      {" + NL + "        delete ";
  protected final String TEXT_1715 = ";" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1716 = NL + "        ";
  protected final String TEXT_1717 = " ";
  protected final String TEXT_1718 = " = ";
  protected final String TEXT_1719 = ";" + NL + "        this.";
  protected final String TEXT_1720 = " = NULL;";
  protected final String TEXT_1721 = NL + "        ";
  protected final String TEXT_1722 = ".";
  protected final String TEXT_1723 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1724 = NL + "    ";
  protected final String TEXT_1725 = " ";
  protected final String TEXT_1726 = " = ";
  protected final String TEXT_1727 = ";" + NL + "    this.";
  protected final String TEXT_1728 = " = NULL;";
  protected final String TEXT_1729 = NL + "    ";
  protected final String TEXT_1730 = ".";
  protected final String TEXT_1731 = "(this);";
  protected final String TEXT_1732 = NL + "    for( int i =0; sizeof(";
  protected final String TEXT_1733 = "); i++)" + NL + "    {";
  protected final String TEXT_1734 = NL + "      ";
  protected final String TEXT_1735 = "(";
  protected final String TEXT_1736 = "[i],NULL);" + NL + "    }";
  protected final String TEXT_1737 = NL + "    ";
  protected final String TEXT_1738 = ".clear();";
  protected final String TEXT_1739 = NL + "    vector<";
  protected final String TEXT_1740 = "> ";
  protected final String TEXT_1741 = " = vector<";
  protected final String TEXT_1742 = ">(";
  protected final String TEXT_1743 = ");";
  protected final String TEXT_1744 = NL + "    ";
  protected final String TEXT_1745 = ".clear();" + NL + "    for( int i =0; sizeof(";
  protected final String TEXT_1746 = "); i++)" + NL + "     {" + NL + "      if (";
  protected final String TEXT_1747 = ".";
  protected final String TEXT_1748 = "() <= ";
  protected final String TEXT_1749 = ".";
  protected final String TEXT_1750 = "())" + NL + "      {" + NL + "        delete ";
  protected final String TEXT_1751 = "[i];" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1752 = NL + "        ";
  protected final String TEXT_1753 = ".";
  protected final String TEXT_1754 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1755 = NL + "    vector<";
  protected final String TEXT_1756 = "> ";
  protected final String TEXT_1757 = " = new vector<";
  protected final String TEXT_1758 = ">(";
  protected final String TEXT_1759 = ");";
  protected final String TEXT_1760 = NL + "    ";
  protected final String TEXT_1761 = ".clear();" + NL + "    for(int i=0;sizeof(";
  protected final String TEXT_1762 = ");i++)" + NL + "    {";
  protected final String TEXT_1763 = NL + "      ";
  protected final String TEXT_1764 = "[i].";
  protected final String TEXT_1765 = "(this);" + NL + "    }";
  protected final String TEXT_1766 = NL + "    for( int i =0; sizeof(";
  protected final String TEXT_1767 = "); i++)" + NL + "    {" + NL + "      delete ";
  protected final String TEXT_1768 = "[i];" + NL + "    }";
  protected final String TEXT_1769 = NL + "    for( int i =0; sizeof(";
  protected final String TEXT_1770 = "); i++)" + NL + "    {";
  protected final String TEXT_1771 = NL + "      ";
  protected final String TEXT_1772 = "[i].";
  protected final String TEXT_1773 = "(NULL);" + NL + "    }";
  protected final String TEXT_1774 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "   ";
  protected final String TEXT_1775 = NL + "  ";
  protected final String TEXT_1776 = NL;

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
    stringBuffer.append(TEXT_3);
    stringBuffer.append(gen.translate("packageDefinition",uClass));
    
  for (Depend depend : uClass.getDepends())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "#include <{0}>;",depend.getName());
  }
  
  for (String anImport : gClass.getMultiLookup("import"))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "#include <{0}>;",anImport);
  }
  
  for (String anImport : gClass.getMultiLookup("using"))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "using namespace {0};",anImport);
  }

    
	appendln(stringBuffer, "");
	append(stringBuffer, "#include \"{0}.h\";",uClass.getName()); 

    stringBuffer.append(TEXT_4);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).isInline) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(stringBuffer, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    stringBuffer.append(TEXT_5);
    
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
  
    append(stringBuffer, "\n  enum {0} { {1} }", gen.translate("type",sm), gen.translate("listStates",sm));

    for (StateMachine nestedSm : allNested)
    {
      append(stringBuffer, "\n  enum {0} { {1} }", gen.translate("type",nestedSm), gen.translate("listStates",nestedSm));
    }
    
    append(stringBuffer, "\n  private {0} {1};", gen.translate("type",sm), gen.translate("stateMachineOne", sm));
    for (StateMachine nestedSm : allNested)
    {
      append(stringBuffer, "\n  private {0} {1};", gen.translate("type",nestedSm), gen.translate("stateMachineOne", nestedSm));
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
    append(stringBuffer, "\n    {0}",customConstructorPrefixCode);
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
      
    stringBuffer.append(TEXT_7);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_9);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_10);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_11);
     
    }
    else if (av.isImmutable() && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_13);
    
    }
    else if (av.isImmutable())
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_14);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_18);
     
    }
    else
    {
      hasBody = true;
      
         
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_19);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_21);
         
        
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
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_39);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_42);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_51);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_54);
    
    }
    else if (av.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_61);
    
    }
    else
    {
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOptionalMany())
  {
    appendln(stringBuffer,"");
    append(stringBuffer, "    {0} = new vector<{1}*>();", gen.translate("associationMany",av), gen.getType(av));
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
  

    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_71);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_76);
    
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
    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_80);
    
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_85);
    
    }
  }
  
  if (customConstructorPostfixCode != null)
  {
    append(stringBuffer, "\n    {0}",customConstructorPostfixCode);
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
    
    stringBuffer.append(TEXT_86);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_88);
    
  }

    
  if (isOneToOne)
  {
    
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_89);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_93);
    
  if (!uClass.isRoot())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    {3}::{0}({1});", gClass.getParentClass().getLookup("constructorSignature_caller"),gClass.getParentClass().getClass().getName(),uClass.getName());
    hasBody = true;
  }
  
  if (customConstructorPrefixCode != null) 
  {
    append(stringBuffer, "\n    {0}",customConstructorPrefixCode);
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
      
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_96);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_97);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_98);
     
    }
    else
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_101);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_104);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_105);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    stringBuffer.append(TEXT_108);
    
    }
    else
    {
      hasBody = true;
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOptionalMany())
  {
    appendln(stringBuffer,"");
    append(stringBuffer, "    {0} = new vector<{1}*>();", gen.translate("associationMany",av), gen.getType(av));
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
  

    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_118);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_123);
    
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
    append(stringBuffer, "\n    {0}",customConstructorPostfixCode);
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


    stringBuffer.append(TEXT_124);
    
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
        
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("type",av));
    if(gen.translate("type",av).equals("string")){append(stringBuffer," const");}
    stringBuffer.append(TEXT_128);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_129);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_130);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_134);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_135);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("type",av));
    if(gen.translate("type",av).equals("string")){append(stringBuffer," const");}
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_140);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_143);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_146);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n    {0}",customResetPrefixCode); } 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_149);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n    {0}",customResetPostfixCode); } 
    stringBuffer.append(TEXT_150);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.translate("type",av));
    if(gen.translate("type",av).equals("string")){append(stringBuffer," const");}
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_155);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_158);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(gen.translate("type",av));
    if(gen.translate("type",av).equals("string")){append(stringBuffer," const");}
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_163);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_166);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_167);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_168);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_169);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("type",av));
    if(gen.translate("type",av).equals("string")){append(stringBuffer," const");}
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_172);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_175);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_176);
    
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
      
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_180);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_181);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_184);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_190);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_196);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_200);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_202);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_203);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_205);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_206);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_207);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_208);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_212);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_213);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_215);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_216);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_217);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_219);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_220);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_221);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_223);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_224);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_225);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_226);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_229);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_230);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_231);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_234);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_235);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_236);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_237);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_239);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_240);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_241);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_242);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_244);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_245);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_247);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_248);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_251);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_252);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_254);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_255);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPostfixCode); } 
    stringBuffer.append(TEXT_256);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_257);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_258);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_261);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_262);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_263);
    
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
        
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_266);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_267);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_268);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_269);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_271);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_272);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_273);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_276);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_277);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_279);
    
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
      output.append(StringFormatter.format("\n    if ({0} != {1}.Null) { answer += \".\" + {0}.toString(); }",gen.translate("stateMachineOne",childSm),gen.translate("type",childSm)));
      allParents.addAll(childSm.getNestedStateMachines());
    }     
  }
  String outputAsString = output.toString();

    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_283);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_284);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_287);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_288);
    
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

        allCases.append(StringFormatter.format("{0}{1}({2}.{3});\n",tabSpace,gen.translate("setMethod",nextState.getStateMachine()),gen.translate("type",nextState.getStateMachine()),gen.translate("stateOne",nextState)));
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
  

  String outputCases = allCases.toString().trim();

    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(TEXT_291);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_292);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_294);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_295);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(TEXT_297);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_298);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_299);
    
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
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_301);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(TEXT_303);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_304);
     } 
    stringBuffer.append(TEXT_305);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_306);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_307);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(TEXT_309);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_310);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_311);
     if (parentState != null) { 
    stringBuffer.append(TEXT_312);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_313);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_314);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_315);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_316);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_317);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_319);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_320);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_321);
     } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_322);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(TEXT_324);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_325);
     } 
    stringBuffer.append(TEXT_326);
    
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
      
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_330);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_332);
     } else { 
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_336);
     append(stringBuffer, "\n    {0}",customGetPostfixCode); 
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_338);
     } 
    stringBuffer.append(TEXT_339);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_343);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_347);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_352);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_356);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_360);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_362);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_365);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_367);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_368);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_372);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_377);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_378);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_379);
    
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
        includeFile = "association_SetUnidirectionalOptionalOne.jet";
      }
      else if (av.isOnlyOne())
      {
        includeFile = "association_SetUnidirectionalOne.jet";
      }
      else if (av.isMStar())
      {
        includeFile = "association_AddUnidirectionalMStar.jet";
        includeFile2 = "association_SetUnidirectionalMStar.jet";
      }
      else if (av.isMN())
      {
        includeFile = "association_AddUnidirectionalMN.jet";
        includeFile2 = "association_SetUnidirectionalMN.jet";
      }
      else if (av.isN())
      {
        includeFile = "association_SetUnidirectionalN.jet";
      }
      else if (av.isOptionalN())
      {
        includeFile = "association_AddUnidirectionalOptionalN.jet";
        includeFile2 = "association_SetUnidirectionalOptionalN.jet";
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
      hasRemoveManyTemplateMethod = true;
    }
    else if (av.isOptionalN() && relatedAssociation.isOptionalMany())
    {
      hasAddManyToManyTemplateMethod = true;
      hasRemoveManyTemplateMethod = true;
      includeFile = "association_SetOptionalNToMany.jet";
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      includeFile = "association_AddManyToOne.jet";
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
    else if (av.isOptionalOne() && relatedAssociation.isMandatory())
    {
      //ignore
    }
    else
    {
      
    stringBuffer.append(TEXT_380);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(relatedAssociation);
    
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_382);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_384);
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPrefixCode); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_385);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_387);
     } else { 
    stringBuffer.append(TEXT_388);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_392);
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPostfixCode); } 
    stringBuffer.append(TEXT_393);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_397);
     } else { 
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_400);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_401);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_402);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_403);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_406);
     } else { 
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_409);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_410);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_411);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_412);
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
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_416);
     } else { 
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_419);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_420);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_421);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_422);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_427);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_430);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_431);
     } 
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_441);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_442);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_443);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_447);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_450);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_451);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_452);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_462);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_463);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_468);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_471);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_472);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_477);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_482);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_483);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_488);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_496);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_497);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_515);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_516);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_521);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_526);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_536);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_537);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_551);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_552);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_563);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_582);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_587);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_592);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_597);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_598);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_601);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_602);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_615);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_618);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_619);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_631);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_639);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_644);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_649);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_654);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_655);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_658);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_659);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_663);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_672);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_675);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_676);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_691);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_696);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_704);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_705);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_710);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_726);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_753);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_754);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_765);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_780);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_785);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_793);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_794);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_799);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_813);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_814);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_836);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_837);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_842);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_845);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_848);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_862);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_863);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_868);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_871);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_874);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_888);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_889);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_894);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_900);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_901);
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_918);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_919);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_924);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_926);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_927);
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_943);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_944);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_949);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_953);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_960);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_961);
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_976);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_977);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_980);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_981);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_986);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_990);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_996);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
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
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1012);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1016);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_1017);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1022);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1042);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1047);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1056);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1057);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1062);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1079);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_1080);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1085);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1088);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1109);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1114);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1123);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1124);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1129);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1135);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1140);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1143);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1146);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1150);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1151);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1156);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1159);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1160);
     } 
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1169);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1181);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1186);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1197);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1198);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1203);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1212);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1217);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1223);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1242);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1256);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1261);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1264);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1269);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1275);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1276);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
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
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1287);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1292);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1298);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1299);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1304);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1307);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1312);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1315);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1318);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1322);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1323);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1328);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1344);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1350);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1351);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1356);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1374);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1401);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1402);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1407);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1423);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1450);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1451);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1456);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1474);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1480);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1481);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1486);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1490);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1502);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1503);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1522);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n          {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1554);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1558);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1568);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1573);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1589);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1595);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1596);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1599);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1601);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1612);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1617);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1623);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1624);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
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


    stringBuffer.append(TEXT_1625);
    stringBuffer.append(TEXT_1626);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1627);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(TEXT_1629);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(TEXT_1631);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1632);
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
        
    stringBuffer.append(TEXT_1633);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(TEXT_1635);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1636);
    
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

    stringBuffer.append(TEXT_1637);
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(TEXT_1641);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1642);
    
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
        
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(TEXT_1645);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1646);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1647);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(TEXT_1650);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1651);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1652);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1653);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1654);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1655);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1656);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1657);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1658);
    
      }
    }
  }

    stringBuffer.append(TEXT_1659);
    
  }
}

    stringBuffer.append(TEXT_1660);
    

  appendln(stringBuffer,"");
  appendln(stringBuffer,"{0}::~{0}()",uClass.getName());
  append(stringBuffer,"  {");

  boolean hasSomethingToDelete = false;

  String customDeletePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","delete"));
  String customDeletePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","delete"));

  if (customDeletePrefixCode != null) 
  {
    append(stringBuffer, "\n    {0}",customDeletePrefixCode);
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
        
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1663);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1665);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1673);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1677);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1678);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1682);
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1687);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1688);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1692);
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1696);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1698);
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1701);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1703);
    stringBuffer.append(TEXT_1704);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1705);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1706);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1707);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1708);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1709);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1710);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1713);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1714);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(TEXT_1716);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1718);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1719);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1720);
    stringBuffer.append(TEXT_1721);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1722);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1723);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1724);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1725);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1726);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1727);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1728);
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1730);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1731);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1732);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1733);
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1735);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1736);
    stringBuffer.append(TEXT_1737);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1738);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1739);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1740);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1741);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1742);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1743);
    stringBuffer.append(TEXT_1744);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1745);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1746);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1747);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1749);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1750);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1751);
    stringBuffer.append(TEXT_1752);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1753);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1754);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1755);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1756);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1757);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1758);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1759);
    stringBuffer.append(TEXT_1760);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1761);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1762);
    stringBuffer.append(TEXT_1763);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1764);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1765);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1766);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1767);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1768);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1769);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1770);
    stringBuffer.append(TEXT_1771);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1772);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1773);
    
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
    append(stringBuffer, "\n    {0}",customDeletePostfixCode);
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
    stringBuffer.append(TEXT_1774);
    stringBuffer.append(TEXT_1775);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_1776);
     if(uClass.getPackageName() != null){
append(stringBuffer, "}"); }

    return stringBuffer.toString();
  }
}