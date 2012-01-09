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
  protected final String TEXT_5 = NL + "class ";
  protected final String TEXT_6 = NL + "{" + NL + "  private:";
  protected final String TEXT_7 = NL + NL + "  //------------------------" + NL + "  // CONSTRUCTOR" + NL + "  //------------------------" + NL + "  public:" + NL;
  protected final String TEXT_8 = NL + "    ";
  protected final String TEXT_9 = " = new ArrayList<";
  protected final String TEXT_10 = ">();";
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
  protected final String TEXT_25 = "++;";
  protected final String TEXT_26 = NL + "    if (!";
  protected final String TEXT_27 = "(";
  protected final String TEXT_28 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_29 = " due to ";
  protected final String TEXT_30 = "\");" + NL + "    }";
  protected final String TEXT_31 = NL + "    ";
  protected final String TEXT_32 = " = new ArrayList<";
  protected final String TEXT_33 = ">();" + NL + "    boolean ";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = ");" + NL + "    if (!";
  protected final String TEXT_37 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_38 = ", must have ";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = "\");" + NL + "    }";
  protected final String TEXT_41 = NL + "    ";
  protected final String TEXT_42 = " = new ArrayList<";
  protected final String TEXT_43 = ">();";
  protected final String TEXT_44 = NL + "    if (";
  protected final String TEXT_45 = " == null || ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = "() != null)" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_48 = " due to ";
  protected final String TEXT_49 = "\");" + NL + "    }";
  protected final String TEXT_50 = NL + "    ";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = ";";
  protected final String TEXT_53 = NL + "    ";
  protected final String TEXT_54 = " = new ArrayList<";
  protected final String TEXT_55 = ">();";
  protected final String TEXT_56 = NL + "    boolean ";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "(";
  protected final String TEXT_59 = ");" + NL + "    if (!";
  protected final String TEXT_60 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_61 = " due to ";
  protected final String TEXT_62 = "\");" + NL + "    }";
  protected final String TEXT_63 = NL + "    ";
  protected final String TEXT_64 = " = new ArrayList<";
  protected final String TEXT_65 = ">();" + NL + "    boolean ";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = "(";
  protected final String TEXT_68 = ");" + NL + "    if (!";
  protected final String TEXT_69 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_70 = ", must have ";
  protected final String TEXT_71 = " ";
  protected final String TEXT_72 = "\");" + NL + "    }";
  protected final String TEXT_73 = " = new ArrayList<";
  protected final String TEXT_74 = ">();";
  protected final String TEXT_75 = NL + "    ";
  protected final String TEXT_76 = ".add(";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "    ";
  protected final String TEXT_79 = "(";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "    if (";
  protected final String TEXT_83 = " == null) { ";
  protected final String TEXT_84 = "(";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = "); }";
  protected final String TEXT_87 = NL + "  public static ";
  protected final String TEXT_88 = " getInstance()" + NL + "  {" + NL + "    if(theInstance == null)" + NL + "    {" + NL + "      theInstance = new ";
  protected final String TEXT_89 = "();" + NL + "    }" + NL + "    return theInstance;" + NL + "  }";
  protected final String TEXT_90 = NL + NL + "  public ";
  protected final String TEXT_91 = "(";
  protected final String TEXT_92 = ")" + NL + "  {";
  protected final String TEXT_93 = NL + "    ";
  protected final String TEXT_94 = " = new ArrayList<";
  protected final String TEXT_95 = ">();";
  protected final String TEXT_96 = NL + "    ";
  protected final String TEXT_97 = "();";
  protected final String TEXT_98 = NL + "    ";
  protected final String TEXT_99 = " = ";
  protected final String TEXT_100 = ";";
  protected final String TEXT_101 = NL + "    ";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = "++;";
  protected final String TEXT_104 = NL + "    ";
  protected final String TEXT_105 = " = new ";
  protected final String TEXT_106 = "(";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "    ";
  protected final String TEXT_109 = " = new ArrayList<";
  protected final String TEXT_110 = ">();" + NL + "    boolean ";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = "(";
  protected final String TEXT_113 = ");" + NL + "    if (!";
  protected final String TEXT_114 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_115 = ", must have ";
  protected final String TEXT_116 = " ";
  protected final String TEXT_117 = "\");" + NL + "    }";
  protected final String TEXT_118 = " = new ArrayList<";
  protected final String TEXT_119 = ">();";
  protected final String TEXT_120 = NL + "    ";
  protected final String TEXT_121 = ".add(";
  protected final String TEXT_122 = ");";
  protected final String TEXT_123 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_124 = NL + "  boolean ";
  protected final String TEXT_125 = "(";
  protected final String TEXT_126 = " ";
  protected final String TEXT_127 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_128 = NL + "    ";
  protected final String TEXT_129 = " = false;";
  protected final String TEXT_130 = NL + "    ";
  protected final String TEXT_131 = " = ";
  protected final String TEXT_132 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_133 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_134 = NL + "  boolean ";
  protected final String TEXT_135 = "(";
  protected final String TEXT_136 = " ";
  protected final String TEXT_137 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_138 = NL + "    ";
  protected final String TEXT_139 = " = ";
  protected final String TEXT_140 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_141 = NL + "    return wasSet;" + NL + "  }" + NL + "" + NL + "  boolean ";
  protected final String TEXT_142 = "()" + NL + "  {" + NL + "    bool wasReset = false;";
  protected final String TEXT_143 = NL + "    ";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = "();" + NL + "    wasReset = true;";
  protected final String TEXT_146 = NL + "    return wasReset;" + NL + "  }" + NL;
  protected final String TEXT_147 = NL + "  boolean ";
  protected final String TEXT_148 = "(";
  protected final String TEXT_149 = " ";
  protected final String TEXT_150 = ")" + NL + "  {" + NL + "    bool wasAdded = false;";
  protected final String TEXT_151 = NL + "    wasAdded = ";
  protected final String TEXT_152 = ".add(";
  protected final String TEXT_153 = ");";
  protected final String TEXT_154 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  boolean ";
  protected final String TEXT_155 = "(";
  protected final String TEXT_156 = " ";
  protected final String TEXT_157 = ")" + NL + "  {" + NL + "    bool wasRemoved = false;";
  protected final String TEXT_158 = NL + "    wasRemoved = ";
  protected final String TEXT_159 = ".remove(";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_162 = NL + "  boolean ";
  protected final String TEXT_163 = "(";
  protected final String TEXT_164 = " ";
  protected final String TEXT_165 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_166 = NL + "    ";
  protected final String TEXT_167 = " = ";
  protected final String TEXT_168 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_169 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_170 = NL + "  ";
  protected final String TEXT_171 = " ";
  protected final String TEXT_172 = "(int index)" + NL + "  {";
  protected final String TEXT_173 = NL + "    ";
  protected final String TEXT_174 = " ";
  protected final String TEXT_175 = " = ";
  protected final String TEXT_176 = ".get(index);";
  protected final String TEXT_177 = NL + "    return ";
  protected final String TEXT_178 = ";" + NL + "  }" + NL;
  protected final String TEXT_179 = NL + "  ";
  protected final String TEXT_180 = "[] ";
  protected final String TEXT_181 = "()" + NL + "  {";
  protected final String TEXT_182 = NL + "    ";
  protected final String TEXT_183 = "[] ";
  protected final String TEXT_184 = " = ";
  protected final String TEXT_185 = ".toArray(new ";
  protected final String TEXT_186 = "[";
  protected final String TEXT_187 = ".size()]);";
  protected final String TEXT_188 = NL + "    return ";
  protected final String TEXT_189 = ";" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_190 = "()" + NL + "  {";
  protected final String TEXT_191 = NL + "    int number = ";
  protected final String TEXT_192 = ".size();";
  protected final String TEXT_193 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  boolean ";
  protected final String TEXT_194 = "()" + NL + "  {";
  protected final String TEXT_195 = NL + "    boolean has = ";
  protected final String TEXT_196 = ".size() > 0;";
  protected final String TEXT_197 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  int ";
  protected final String TEXT_198 = "(";
  protected final String TEXT_199 = " ";
  protected final String TEXT_200 = ")" + NL + "  {";
  protected final String TEXT_201 = NL + "    int index = ";
  protected final String TEXT_202 = ".indexOf(";
  protected final String TEXT_203 = ");";
  protected final String TEXT_204 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_205 = NL + "  ";
  protected final String TEXT_206 = " ";
  protected final String TEXT_207 = "()" + NL + "  {";
  protected final String TEXT_208 = NL + "    ";
  protected final String TEXT_209 = " ";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = ";";
  protected final String TEXT_212 = NL + "    return ";
  protected final String TEXT_213 = ";" + NL + "  }";
  protected final String TEXT_214 = NL + "  ";
  protected final String TEXT_215 = " ";
  protected final String TEXT_216 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_217 = ";" + NL + "  }";
  protected final String TEXT_218 = NL + "  ";
  protected final String TEXT_219 = " ";
  protected final String TEXT_220 = "()" + NL + "  {";
  protected final String TEXT_221 = NL + "    ";
  protected final String TEXT_222 = " ";
  protected final String TEXT_223 = " = ";
  protected final String TEXT_224 = ";";
  protected final String TEXT_225 = NL + "    return ";
  protected final String TEXT_226 = ";" + NL + "  }";
  protected final String TEXT_227 = NL + "  ";
  protected final String TEXT_228 = " ";
  protected final String TEXT_229 = "()" + NL + "  {";
  protected final String TEXT_230 = NL + "    return ";
  protected final String TEXT_231 = ";" + NL + "  }";
  protected final String TEXT_232 = NL + "  ";
  protected final String TEXT_233 = " ";
  protected final String TEXT_234 = "()" + NL + "  {";
  protected final String TEXT_235 = NL + "    ";
  protected final String TEXT_236 = " ";
  protected final String TEXT_237 = " = ";
  protected final String TEXT_238 = ";";
  protected final String TEXT_239 = NL + "    return ";
  protected final String TEXT_240 = ";" + NL + "  }" + NL;
  protected final String TEXT_241 = NL + "  ";
  protected final String TEXT_242 = " ";
  protected final String TEXT_243 = "()" + NL + "  {";
  protected final String TEXT_244 = NL + "    return ";
  protected final String TEXT_245 = ";" + NL + "  }" + NL;
  protected final String TEXT_246 = NL + "  ";
  protected final String TEXT_247 = " ";
  protected final String TEXT_248 = "()" + NL + "  {";
  protected final String TEXT_249 = NL + "    ";
  protected final String TEXT_250 = " ";
  protected final String TEXT_251 = " = ";
  protected final String TEXT_252 = ";";
  protected final String TEXT_253 = NL + "    return ";
  protected final String TEXT_254 = ";" + NL + "  }";
  protected final String TEXT_255 = NL + "  ";
  protected final String TEXT_256 = " ";
  protected final String TEXT_257 = "()" + NL + "  {";
  protected final String TEXT_258 = NL + "    return ";
  protected final String TEXT_259 = ";" + NL + "  }";
  protected final String TEXT_260 = NL + "  public ";
  protected final String TEXT_261 = " ";
  protected final String TEXT_262 = "()" + NL + "  {" + NL + "    String answer = ";
  protected final String TEXT_263 = ".toString();";
  protected final String TEXT_264 = NL + "    return answer;" + NL + "  }" + NL;
  protected final String TEXT_265 = NL + "  public ";
  protected final String TEXT_266 = " ";
  protected final String TEXT_267 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_268 = ";" + NL + "  }" + NL;
  protected final String TEXT_269 = NL + "  private boolean ";
  protected final String TEXT_270 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_271 = ";" + NL + "  }" + NL;
  protected final String TEXT_272 = NL + "  public boolean ";
  protected final String TEXT_273 = "()" + NL + "  {" + NL + "    boolean wasEventProcessed = false;" + NL;
  protected final String TEXT_274 = NL + "    ";
  protected final String TEXT_275 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_276 = NL + "  public boolean ";
  protected final String TEXT_277 = "(";
  protected final String TEXT_278 = " ";
  protected final String TEXT_279 = ")" + NL + "  {";
  protected final String TEXT_280 = NL + "    ";
  protected final String TEXT_281 = " = ";
  protected final String TEXT_282 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_283 = NL + "  private void ";
  protected final String TEXT_284 = "()" + NL + "  {" + NL + "    switch(";
  protected final String TEXT_285 = ")" + NL + "    {";
  protected final String TEXT_286 = NL + "      ";
  protected final String TEXT_287 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_288 = NL + "  private void ";
  protected final String TEXT_289 = "(";
  protected final String TEXT_290 = " ";
  protected final String TEXT_291 = ")" + NL + "  {";
  protected final String TEXT_292 = NL + "    ";
  protected final String TEXT_293 = " = ";
  protected final String TEXT_294 = ";";
  protected final String TEXT_295 = NL + "    if (";
  protected final String TEXT_296 = " != ";
  protected final String TEXT_297 = ".";
  protected final String TEXT_298 = " && ";
  protected final String TEXT_299 = " != ";
  protected final String TEXT_300 = ".";
  protected final String TEXT_301 = ") { ";
  protected final String TEXT_302 = "(";
  protected final String TEXT_303 = ".";
  protected final String TEXT_304 = "); }";
  protected final String TEXT_305 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_306 = ")" + NL + "    {";
  protected final String TEXT_307 = NL + "      ";
  protected final String TEXT_308 = NL + "    }";
  protected final String TEXT_309 = NL + "  }" + NL;
  protected final String TEXT_310 = NL + "  ";
  protected final String TEXT_311 = " ";
  protected final String TEXT_312 = "()" + NL + "  {";
  protected final String TEXT_313 = NL + "    return ";
  protected final String TEXT_314 = ";";
  protected final String TEXT_315 = NL + "    ";
  protected final String TEXT_316 = " ";
  protected final String TEXT_317 = " = ";
  protected final String TEXT_318 = ";";
  protected final String TEXT_319 = NL + "    return ";
  protected final String TEXT_320 = ";";
  protected final String TEXT_321 = NL + "  }" + NL;
  protected final String TEXT_322 = NL + "  ";
  protected final String TEXT_323 = " ";
  protected final String TEXT_324 = "(int index)" + NL + "  {";
  protected final String TEXT_325 = NL + "    ";
  protected final String TEXT_326 = " ";
  protected final String TEXT_327 = " = ";
  protected final String TEXT_328 = ".get(index);";
  protected final String TEXT_329 = NL + "    return ";
  protected final String TEXT_330 = ";" + NL + "  }" + NL + "" + NL + "  List<";
  protected final String TEXT_331 = "> ";
  protected final String TEXT_332 = "()" + NL + "  {";
  protected final String TEXT_333 = NL + "    List<";
  protected final String TEXT_334 = "> ";
  protected final String TEXT_335 = " = Collections.unmodifiableList(";
  protected final String TEXT_336 = ");";
  protected final String TEXT_337 = NL + "    return ";
  protected final String TEXT_338 = ";" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_339 = "()" + NL + "  {";
  protected final String TEXT_340 = NL + "    int number = ";
  protected final String TEXT_341 = ".size();";
  protected final String TEXT_342 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_343 = "()" + NL + "  {";
  protected final String TEXT_344 = NL + "    boolean has = ";
  protected final String TEXT_345 = ".size() > 0;";
  protected final String TEXT_346 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_347 = "(";
  protected final String TEXT_348 = " ";
  protected final String TEXT_349 = ")" + NL + "  {";
  protected final String TEXT_350 = NL + "    int index = ";
  protected final String TEXT_351 = ".indexOf(";
  protected final String TEXT_352 = ");";
  protected final String TEXT_353 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_354 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_355 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_356 = " : ";
  protected final String TEXT_357 = NL + "  public boolean ";
  protected final String TEXT_358 = "()" + NL + "  {";
  protected final String TEXT_359 = NL + "    boolean isValid = ";
  protected final String TEXT_360 = "() >= ";
  protected final String TEXT_361 = "();";
  protected final String TEXT_362 = NL + "    boolean isValid = ";
  protected final String TEXT_363 = "() >= ";
  protected final String TEXT_364 = "() && ";
  protected final String TEXT_365 = "() <= ";
  protected final String TEXT_366 = "();";
  protected final String TEXT_367 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_368 = NL + "  public static int ";
  protected final String TEXT_369 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_370 = ";" + NL + "  }";
  protected final String TEXT_371 = NL + "  public static int ";
  protected final String TEXT_372 = "()" + NL + "  {";
  protected final String TEXT_373 = NL + "    int required = ";
  protected final String TEXT_374 = ";";
  protected final String TEXT_375 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_376 = NL + "  public static int ";
  protected final String TEXT_377 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_378 = ";" + NL + "  }";
  protected final String TEXT_379 = NL + "  public static int ";
  protected final String TEXT_380 = "()" + NL + "  {";
  protected final String TEXT_381 = NL + "    int minimum = ";
  protected final String TEXT_382 = ";";
  protected final String TEXT_383 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_384 = NL + "  public static int ";
  protected final String TEXT_385 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_386 = ";" + NL + "  }";
  protected final String TEXT_387 = NL + "  public static int ";
  protected final String TEXT_388 = "()" + NL + "  {";
  protected final String TEXT_389 = NL + "    int maximum = ";
  protected final String TEXT_390 = ";";
  protected final String TEXT_391 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_392 = NL + "  public boolean ";
  protected final String TEXT_393 = "(";
  protected final String TEXT_394 = " ";
  protected final String TEXT_395 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_396 = NL + "    if (";
  protected final String TEXT_397 = "() >= ";
  protected final String TEXT_398 = "())" + NL + "    {";
  protected final String TEXT_399 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_400 = NL + "    ";
  protected final String TEXT_401 = ".add(";
  protected final String TEXT_402 = ");" + NL + "    if (";
  protected final String TEXT_403 = ".";
  protected final String TEXT_404 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_405 = ".";
  protected final String TEXT_406 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_407 = NL + "        ";
  protected final String TEXT_408 = ".remove(";
  protected final String TEXT_409 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_410 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_411 = NL + "  public boolean ";
  protected final String TEXT_412 = "(";
  protected final String TEXT_413 = " ";
  protected final String TEXT_414 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_415 = NL + "    if (!";
  protected final String TEXT_416 = ".contains(";
  protected final String TEXT_417 = "))" + NL + "    {";
  protected final String TEXT_418 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_419 = ".indexOf(";
  protected final String TEXT_420 = ");";
  protected final String TEXT_421 = NL + "    ";
  protected final String TEXT_422 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_423 = ".";
  protected final String TEXT_424 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_425 = ".";
  protected final String TEXT_426 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_427 = NL + "        ";
  protected final String TEXT_428 = ".add(oldIndex,";
  protected final String TEXT_429 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_430 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_431 = NL + "  boolean ";
  protected final String TEXT_432 = "(";
  protected final String TEXT_433 = " ";
  protected final String TEXT_434 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_435 = NL + "    ";
  protected final String TEXT_436 = " = ";
  protected final String TEXT_437 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_438 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_439 = NL + "  public boolean ";
  protected final String TEXT_440 = "(";
  protected final String TEXT_441 = " ";
  protected final String TEXT_442 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_443 = NL + "    if (";
  protected final String TEXT_444 = " != null)" + NL + "    {";
  protected final String TEXT_445 = NL + "      ";
  protected final String TEXT_446 = " = ";
  protected final String TEXT_447 = ";" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_448 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_449 = NL + "  boolean ";
  protected final String TEXT_450 = "(";
  protected final String TEXT_451 = " ";
  protected final String TEXT_452 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_453 = NL + "    if (";
  protected final String TEXT_454 = " != null && !";
  protected final String TEXT_455 = ".equals(";
  protected final String TEXT_456 = ") && equals(";
  protected final String TEXT_457 = ".";
  protected final String TEXT_458 = "()))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_459 = ", as existing ";
  protected final String TEXT_460 = " would become an orphan";
  protected final String TEXT_461 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_462 = NL + "    ";
  protected final String TEXT_463 = " = ";
  protected final String TEXT_464 = ";";
  protected final String TEXT_465 = NL + "    ";
  protected final String TEXT_466 = " ";
  protected final String TEXT_467 = " = ";
  protected final String TEXT_468 = " != null ? ";
  protected final String TEXT_469 = ".";
  protected final String TEXT_470 = "() : null;" + NL + "" + NL + "    if (!this.equals(";
  protected final String TEXT_471 = "))" + NL + "    {" + NL + "      if (";
  protected final String TEXT_472 = " != null)" + NL + "      {";
  protected final String TEXT_473 = NL + "        ";
  protected final String TEXT_474 = ".";
  protected final String TEXT_475 = " = null;" + NL + "      }" + NL + "      if (";
  protected final String TEXT_476 = " != null)" + NL + "      {";
  protected final String TEXT_477 = NL + "        ";
  protected final String TEXT_478 = ".";
  protected final String TEXT_479 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_480 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_481 = NL + "  boolean ";
  protected final String TEXT_482 = "(";
  protected final String TEXT_483 = " ";
  protected final String TEXT_484 = ")" + NL + "  {" + NL + "    bool";
  protected final String TEXT_485 = NL + "    if (";
  protected final String TEXT_486 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_487 = " to null, as ";
  protected final String TEXT_488 = " must always be associated to a ";
  protected final String TEXT_489 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_490 = NL + "    ";
  protected final String TEXT_491 = " ";
  protected final String TEXT_492 = " = ";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = "();" + NL + "    if (";
  protected final String TEXT_495 = " != null && !equals(";
  protected final String TEXT_496 = "))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_497 = ", the current ";
  protected final String TEXT_498 = " already has a ";
  protected final String TEXT_499 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_500 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_501 = NL + "    ";
  protected final String TEXT_502 = " ";
  protected final String TEXT_503 = " = ";
  protected final String TEXT_504 = ";";
  protected final String TEXT_505 = NL + "    ";
  protected final String TEXT_506 = " = ";
  protected final String TEXT_507 = ";";
  protected final String TEXT_508 = NL + "    ";
  protected final String TEXT_509 = ".";
  protected final String TEXT_510 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_511 = " != null)" + NL + "    {";
  protected final String TEXT_512 = NL + "      ";
  protected final String TEXT_513 = ".";
  protected final String TEXT_514 = "(null);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_515 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_516 = NL + "  ";
  protected final String TEXT_517 = " ";
  protected final String TEXT_518 = "(";
  protected final String TEXT_519 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_520 = "(";
  protected final String TEXT_521 = ");" + NL + "  }" + NL + "" + NL + "  boolean ";
  protected final String TEXT_522 = "(";
  protected final String TEXT_523 = " ";
  protected final String TEXT_524 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_525 = NL + "    ";
  protected final String TEXT_526 = " ";
  protected final String TEXT_527 = " = ";
  protected final String TEXT_528 = ".";
  protected final String TEXT_529 = "();" + NL + "    boolean ";
  protected final String TEXT_530 = " = ";
  protected final String TEXT_531 = " != null && !this.equals(";
  protected final String TEXT_532 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_533 = " && ";
  protected final String TEXT_534 = ".";
  protected final String TEXT_535 = "() <= ";
  protected final String TEXT_536 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_537 = ")" + NL + "    {";
  protected final String TEXT_538 = NL + "      ";
  protected final String TEXT_539 = ".";
  protected final String TEXT_540 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_541 = NL + "      ";
  protected final String TEXT_542 = ".add(";
  protected final String TEXT_543 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_544 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  boolean ";
  protected final String TEXT_545 = "(";
  protected final String TEXT_546 = " ";
  protected final String TEXT_547 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_548 = NL + "    //Unable to remove ";
  protected final String TEXT_549 = ", as it must always have a ";
  protected final String TEXT_550 = NL + "    if (this.equals(";
  protected final String TEXT_551 = ".";
  protected final String TEXT_552 = "()))" + NL + "    {";
  protected final String TEXT_553 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_554 = " already at minimum (";
  protected final String TEXT_555 = ")" + NL + "    if (";
  protected final String TEXT_556 = "() <= ";
  protected final String TEXT_557 = "())" + NL + "    {";
  protected final String TEXT_558 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_559 = NL + "    ";
  protected final String TEXT_560 = ".remove(";
  protected final String TEXT_561 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_562 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_563 = NL + "  public ";
  protected final String TEXT_564 = " ";
  protected final String TEXT_565 = "(";
  protected final String TEXT_566 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_567 = "() >= ";
  protected final String TEXT_568 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_569 = "(";
  protected final String TEXT_570 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_571 = "(";
  protected final String TEXT_572 = " ";
  protected final String TEXT_573 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_574 = NL + "    if (";
  protected final String TEXT_575 = "() >= ";
  protected final String TEXT_576 = "())" + NL + "    {";
  protected final String TEXT_577 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_578 = NL + "    ";
  protected final String TEXT_579 = " ";
  protected final String TEXT_580 = " = ";
  protected final String TEXT_581 = ".";
  protected final String TEXT_582 = "();" + NL + "    boolean ";
  protected final String TEXT_583 = " = ";
  protected final String TEXT_584 = " != null && !this.equals(";
  protected final String TEXT_585 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_586 = " && ";
  protected final String TEXT_587 = ".";
  protected final String TEXT_588 = "() <= ";
  protected final String TEXT_589 = "())" + NL + "    {";
  protected final String TEXT_590 = NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_591 = ")" + NL + "    {";
  protected final String TEXT_592 = NL + "      ";
  protected final String TEXT_593 = ".";
  protected final String TEXT_594 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_595 = NL + "      ";
  protected final String TEXT_596 = ".add(";
  protected final String TEXT_597 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_598 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_599 = "(";
  protected final String TEXT_600 = " ";
  protected final String TEXT_601 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_602 = NL + "    //Unable to remove ";
  protected final String TEXT_603 = ", as it must always have a ";
  protected final String TEXT_604 = NL + "    if (this.equals(";
  protected final String TEXT_605 = ".";
  protected final String TEXT_606 = "()))" + NL + "    {";
  protected final String TEXT_607 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_608 = " already at minimum (";
  protected final String TEXT_609 = ")" + NL + "    if (";
  protected final String TEXT_610 = "() <= ";
  protected final String TEXT_611 = "())" + NL + "    {";
  protected final String TEXT_612 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_613 = NL + "    ";
  protected final String TEXT_614 = ".remove(";
  protected final String TEXT_615 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_616 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_617 = NL + "  public ";
  protected final String TEXT_618 = " ";
  protected final String TEXT_619 = "(";
  protected final String TEXT_620 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_621 = "() >= ";
  protected final String TEXT_622 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_623 = "(";
  protected final String TEXT_624 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_625 = "(";
  protected final String TEXT_626 = " ";
  protected final String TEXT_627 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_628 = NL + "    if (";
  protected final String TEXT_629 = "() >= ";
  protected final String TEXT_630 = "())" + NL + "    {";
  protected final String TEXT_631 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_632 = NL + "    ";
  protected final String TEXT_633 = " ";
  protected final String TEXT_634 = " = ";
  protected final String TEXT_635 = ".";
  protected final String TEXT_636 = "();" + NL + "    boolean ";
  protected final String TEXT_637 = " = ";
  protected final String TEXT_638 = " != null && !this.equals(";
  protected final String TEXT_639 = ");" + NL + "    if (";
  protected final String TEXT_640 = ")" + NL + "    {";
  protected final String TEXT_641 = NL + "      ";
  protected final String TEXT_642 = ".";
  protected final String TEXT_643 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_644 = NL + "      ";
  protected final String TEXT_645 = ".add(";
  protected final String TEXT_646 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_647 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_648 = "(";
  protected final String TEXT_649 = " ";
  protected final String TEXT_650 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_651 = NL + "    //Unable to remove ";
  protected final String TEXT_652 = ", as it must always have a ";
  protected final String TEXT_653 = NL + "    if (!this.equals(";
  protected final String TEXT_654 = ".";
  protected final String TEXT_655 = "()))" + NL + "    {";
  protected final String TEXT_656 = NL + "      ";
  protected final String TEXT_657 = ".remove(";
  protected final String TEXT_658 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_659 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_660 = NL + "  boolean ";
  protected final String TEXT_661 = "(";
  protected final String TEXT_662 = "... ";
  protected final String TEXT_663 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_664 = NL + "    ArrayList<";
  protected final String TEXT_665 = "> ";
  protected final String TEXT_666 = " = new ArrayList<";
  protected final String TEXT_667 = ">();" + NL + "    for (";
  protected final String TEXT_668 = " ";
  protected final String TEXT_669 = " : ";
  protected final String TEXT_670 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_671 = ".contains(";
  protected final String TEXT_672 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_673 = NL + "      ";
  protected final String TEXT_674 = ".add(";
  protected final String TEXT_675 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_676 = ".size() != ";
  protected final String TEXT_677 = ".length || ";
  protected final String TEXT_678 = ".size() > ";
  protected final String TEXT_679 = "())" + NL + "    {";
  protected final String TEXT_680 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_681 = "> ";
  protected final String TEXT_682 = " = new ArrayList<";
  protected final String TEXT_683 = ">(";
  protected final String TEXT_684 = ");";
  protected final String TEXT_685 = NL + "    ";
  protected final String TEXT_686 = ".clear();" + NL + "    for (";
  protected final String TEXT_687 = " ";
  protected final String TEXT_688 = " : ";
  protected final String TEXT_689 = ")" + NL + "    {";
  protected final String TEXT_690 = NL + "      ";
  protected final String TEXT_691 = ".add(";
  protected final String TEXT_692 = ");" + NL + "      if (";
  protected final String TEXT_693 = ".contains(";
  protected final String TEXT_694 = "))" + NL + "      {";
  protected final String TEXT_695 = NL + "        ";
  protected final String TEXT_696 = ".remove(";
  protected final String TEXT_697 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_698 = NL + "        ";
  protected final String TEXT_699 = ".";
  protected final String TEXT_700 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_701 = " ";
  protected final String TEXT_702 = " : ";
  protected final String TEXT_703 = ")" + NL + "    {";
  protected final String TEXT_704 = NL + "      ";
  protected final String TEXT_705 = ".";
  protected final String TEXT_706 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_707 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_708 = NL + "  public ";
  protected final String TEXT_709 = " ";
  protected final String TEXT_710 = "(";
  protected final String TEXT_711 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_712 = "(";
  protected final String TEXT_713 = ");" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_714 = "(";
  protected final String TEXT_715 = " ";
  protected final String TEXT_716 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_717 = NL + "    ";
  protected final String TEXT_718 = " ";
  protected final String TEXT_719 = " = ";
  protected final String TEXT_720 = ".";
  protected final String TEXT_721 = "();" + NL + "    boolean ";
  protected final String TEXT_722 = " = ";
  protected final String TEXT_723 = " != null && !this.equals(";
  protected final String TEXT_724 = ");" + NL + "    if (";
  protected final String TEXT_725 = ")" + NL + "    {";
  protected final String TEXT_726 = NL + "      ";
  protected final String TEXT_727 = ".";
  protected final String TEXT_728 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_729 = NL + "      ";
  protected final String TEXT_730 = ".add(";
  protected final String TEXT_731 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_732 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_733 = "(";
  protected final String TEXT_734 = " ";
  protected final String TEXT_735 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_736 = NL + "    //Unable to remove ";
  protected final String TEXT_737 = ", as it must always have a ";
  protected final String TEXT_738 = NL + "    if (!this.equals(";
  protected final String TEXT_739 = ".";
  protected final String TEXT_740 = "()))" + NL + "    {";
  protected final String TEXT_741 = NL + "      ";
  protected final String TEXT_742 = ".remove(";
  protected final String TEXT_743 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_744 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_745 = NL + "  boolean ";
  protected final String TEXT_746 = "(";
  protected final String TEXT_747 = " ";
  protected final String TEXT_748 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_749 = NL + "    if (";
  protected final String TEXT_750 = " == null)" + NL + "    {";
  protected final String TEXT_751 = NL + "      ";
  protected final String TEXT_752 = " ";
  protected final String TEXT_753 = " = ";
  protected final String TEXT_754 = ";";
  protected final String TEXT_755 = NL + "      ";
  protected final String TEXT_756 = " = null;" + NL + "      " + NL + "      if (";
  protected final String TEXT_757 = " != null && ";
  protected final String TEXT_758 = ".";
  protected final String TEXT_759 = "() != null)" + NL + "      {";
  protected final String TEXT_760 = NL + "        ";
  protected final String TEXT_761 = ".";
  protected final String TEXT_762 = "(null);" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_763 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_764 = NL + "    ";
  protected final String TEXT_765 = " ";
  protected final String TEXT_766 = " = ";
  protected final String TEXT_767 = "();" + NL + "    if (";
  protected final String TEXT_768 = " != null && !";
  protected final String TEXT_769 = ".equals(";
  protected final String TEXT_770 = "))" + NL + "    {";
  protected final String TEXT_771 = NL + "      ";
  protected final String TEXT_772 = ".";
  protected final String TEXT_773 = "(null);" + NL + "    }" + NL;
  protected final String TEXT_774 = NL + "    ";
  protected final String TEXT_775 = " = ";
  protected final String TEXT_776 = ";";
  protected final String TEXT_777 = NL + "    ";
  protected final String TEXT_778 = " ";
  protected final String TEXT_779 = " = ";
  protected final String TEXT_780 = ".";
  protected final String TEXT_781 = "();" + NL + "" + NL + "    if (!equals(";
  protected final String TEXT_782 = "))" + NL + "    {";
  protected final String TEXT_783 = NL + "      ";
  protected final String TEXT_784 = ".";
  protected final String TEXT_785 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_786 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_787 = NL + "  public boolean ";
  protected final String TEXT_788 = "(";
  protected final String TEXT_789 = " ";
  protected final String TEXT_790 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_791 = NL + "    if (!";
  protected final String TEXT_792 = ".contains(";
  protected final String TEXT_793 = "))" + NL + "    {";
  protected final String TEXT_794 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_795 = "() <= ";
  protected final String TEXT_796 = "())" + NL + "    {";
  protected final String TEXT_797 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_798 = ".indexOf(";
  protected final String TEXT_799 = ");";
  protected final String TEXT_800 = NL + "    ";
  protected final String TEXT_801 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_802 = ".";
  protected final String TEXT_803 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_804 = ".";
  protected final String TEXT_805 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_806 = NL + "        ";
  protected final String TEXT_807 = ".add(oldIndex,";
  protected final String TEXT_808 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_809 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_810 = NL + "  public boolean ";
  protected final String TEXT_811 = "(";
  protected final String TEXT_812 = " ";
  protected final String TEXT_813 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_814 = NL + "    if (!";
  protected final String TEXT_815 = ".contains(";
  protected final String TEXT_816 = "))" + NL + "    {";
  protected final String TEXT_817 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_818 = "() <= ";
  protected final String TEXT_819 = "())" + NL + "    {";
  protected final String TEXT_820 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_821 = ".indexOf(";
  protected final String TEXT_822 = ");";
  protected final String TEXT_823 = NL + "    ";
  protected final String TEXT_824 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_825 = ".";
  protected final String TEXT_826 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_827 = ".";
  protected final String TEXT_828 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_829 = NL + "        ";
  protected final String TEXT_830 = ".add(oldIndex,";
  protected final String TEXT_831 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_832 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_833 = NL + "  boolean ";
  protected final String TEXT_834 = "(";
  protected final String TEXT_835 = " ";
  protected final String TEXT_836 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_837 = NL + "    if (";
  protected final String TEXT_838 = " != null && ";
  protected final String TEXT_839 = ".";
  protected final String TEXT_840 = "() >= ";
  protected final String TEXT_841 = ".";
  protected final String TEXT_842 = "())" + NL + "    {";
  protected final String TEXT_843 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_844 = NL + "    ";
  protected final String TEXT_845 = " ";
  protected final String TEXT_846 = " = ";
  protected final String TEXT_847 = ";";
  protected final String TEXT_848 = NL + "    ";
  protected final String TEXT_849 = " = ";
  protected final String TEXT_850 = ";" + NL + "    if (";
  protected final String TEXT_851 = " != null && !";
  protected final String TEXT_852 = ".equals(";
  protected final String TEXT_853 = "))" + NL + "    {";
  protected final String TEXT_854 = NL + "      ";
  protected final String TEXT_855 = ".";
  protected final String TEXT_856 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_857 = " != null)" + NL + "    {";
  protected final String TEXT_858 = NL + "      ";
  protected final String TEXT_859 = ".";
  protected final String TEXT_860 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_861 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_862 = NL + "  boolean ";
  protected final String TEXT_863 = "(";
  protected final String TEXT_864 = " ";
  protected final String TEXT_865 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_866 = NL + "    if (";
  protected final String TEXT_867 = " == null)" + NL + "    {";
  protected final String TEXT_868 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_869 = NL + "    ";
  protected final String TEXT_870 = " ";
  protected final String TEXT_871 = " = ";
  protected final String TEXT_872 = ";";
  protected final String TEXT_873 = NL + "    ";
  protected final String TEXT_874 = " = ";
  protected final String TEXT_875 = ";" + NL + "    if (";
  protected final String TEXT_876 = " != null && !";
  protected final String TEXT_877 = ".equals(";
  protected final String TEXT_878 = "))" + NL + "    {";
  protected final String TEXT_879 = NL + "      ";
  protected final String TEXT_880 = ".";
  protected final String TEXT_881 = "(this);" + NL + "    }";
  protected final String TEXT_882 = NL + "    ";
  protected final String TEXT_883 = ".";
  protected final String TEXT_884 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_885 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_886 = NL + "  boolean ";
  protected final String TEXT_887 = "(";
  protected final String TEXT_888 = " ";
  protected final String TEXT_889 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_890 = NL + "    //Must provide ";
  protected final String TEXT_891 = " to ";
  protected final String TEXT_892 = NL + "    if (";
  protected final String TEXT_893 = " == null)" + NL + "    {";
  protected final String TEXT_894 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_895 = " already at maximum (";
  protected final String TEXT_896 = ")" + NL + "    if (";
  protected final String TEXT_897 = ".";
  protected final String TEXT_898 = "() >= ";
  protected final String TEXT_899 = ".";
  protected final String TEXT_900 = "())" + NL + "    {";
  protected final String TEXT_901 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_902 = NL + "    ";
  protected final String TEXT_903 = " ";
  protected final String TEXT_904 = " = ";
  protected final String TEXT_905 = ";";
  protected final String TEXT_906 = NL + "    ";
  protected final String TEXT_907 = " = ";
  protected final String TEXT_908 = ";" + NL + "    if (";
  protected final String TEXT_909 = " != null && !";
  protected final String TEXT_910 = ".equals(";
  protected final String TEXT_911 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_912 = ".";
  protected final String TEXT_913 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_914 = NL + "        ";
  protected final String TEXT_915 = " = ";
  protected final String TEXT_916 = ";";
  protected final String TEXT_917 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_918 = NL + "    ";
  protected final String TEXT_919 = ".";
  protected final String TEXT_920 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_921 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_922 = NL + "  boolean ";
  protected final String TEXT_923 = "(";
  protected final String TEXT_924 = " ";
  protected final String TEXT_925 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_926 = NL + "    //Must provide ";
  protected final String TEXT_927 = " to ";
  protected final String TEXT_928 = NL + "    if (";
  protected final String TEXT_929 = " == null)" + NL + "    {";
  protected final String TEXT_930 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_931 = " != null && ";
  protected final String TEXT_932 = ".";
  protected final String TEXT_933 = "() <= ";
  protected final String TEXT_934 = ".";
  protected final String TEXT_935 = "())" + NL + "    {";
  protected final String TEXT_936 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_937 = NL + "    ";
  protected final String TEXT_938 = " ";
  protected final String TEXT_939 = " = ";
  protected final String TEXT_940 = ";";
  protected final String TEXT_941 = NL + "    ";
  protected final String TEXT_942 = " = ";
  protected final String TEXT_943 = ";" + NL + "    if (";
  protected final String TEXT_944 = " != null && !";
  protected final String TEXT_945 = ".equals(";
  protected final String TEXT_946 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_947 = ".";
  protected final String TEXT_948 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_949 = NL + "        ";
  protected final String TEXT_950 = " = ";
  protected final String TEXT_951 = ";";
  protected final String TEXT_952 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_953 = NL + "    ";
  protected final String TEXT_954 = ".";
  protected final String TEXT_955 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_956 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_957 = NL + "  public boolean ";
  protected final String TEXT_958 = "(";
  protected final String TEXT_959 = " ";
  protected final String TEXT_960 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_961 = NL + "    ";
  protected final String TEXT_962 = " ";
  protected final String TEXT_963 = " = ";
  protected final String TEXT_964 = ".";
  protected final String TEXT_965 = "();" + NL + "    if (";
  protected final String TEXT_966 = " == null)" + NL + "    {";
  protected final String TEXT_967 = NL + "      ";
  protected final String TEXT_968 = ".";
  protected final String TEXT_969 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_970 = "))" + NL + "    {";
  protected final String TEXT_971 = NL + "      ";
  protected final String TEXT_972 = ".";
  protected final String TEXT_973 = "(";
  protected final String TEXT_974 = ");";
  protected final String TEXT_975 = NL + "      ";
  protected final String TEXT_976 = "(";
  protected final String TEXT_977 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_978 = NL + "      ";
  protected final String TEXT_979 = ".add(";
  protected final String TEXT_980 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_981 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_982 = "(";
  protected final String TEXT_983 = " ";
  protected final String TEXT_984 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_985 = NL + "    if (";
  protected final String TEXT_986 = ".contains(";
  protected final String TEXT_987 = "))" + NL + "    {";
  protected final String TEXT_988 = NL + "      ";
  protected final String TEXT_989 = ".remove(";
  protected final String TEXT_990 = ");";
  protected final String TEXT_991 = NL + "      ";
  protected final String TEXT_992 = ".";
  protected final String TEXT_993 = "(null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_994 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_995 = NL + "  boolean ";
  protected final String TEXT_996 = "(";
  protected final String TEXT_997 = " ";
  protected final String TEXT_998 = ")" + NL + "  {" + NL + "    boolwasSet = false;";
  protected final String TEXT_999 = NL + "    ";
  protected final String TEXT_1000 = " ";
  protected final String TEXT_1001 = " = ";
  protected final String TEXT_1002 = ";";
  protected final String TEXT_1003 = NL + "    ";
  protected final String TEXT_1004 = " = ";
  protected final String TEXT_1005 = ";" + NL + "    if (";
  protected final String TEXT_1006 = " != null && !";
  protected final String TEXT_1007 = ".equals(";
  protected final String TEXT_1008 = "))" + NL + "    {";
  protected final String TEXT_1009 = NL + "      ";
  protected final String TEXT_1010 = ".";
  protected final String TEXT_1011 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1012 = " != null)" + NL + "    {";
  protected final String TEXT_1013 = NL + "      ";
  protected final String TEXT_1014 = ".";
  protected final String TEXT_1015 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1016 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1017 = NL + "  public boolean ";
  protected final String TEXT_1018 = "(";
  protected final String TEXT_1019 = " ";
  protected final String TEXT_1020 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1021 = NL + "    if (";
  protected final String TEXT_1022 = "() >= ";
  protected final String TEXT_1023 = "())" + NL + "    {";
  protected final String TEXT_1024 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1025 = NL + "    ";
  protected final String TEXT_1026 = " ";
  protected final String TEXT_1027 = " = ";
  protected final String TEXT_1028 = ".";
  protected final String TEXT_1029 = "();" + NL + "    if (";
  protected final String TEXT_1030 = " == null)" + NL + "    {";
  protected final String TEXT_1031 = NL + "      ";
  protected final String TEXT_1032 = ".";
  protected final String TEXT_1033 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1034 = "))" + NL + "    {";
  protected final String TEXT_1035 = NL + "      ";
  protected final String TEXT_1036 = ".";
  protected final String TEXT_1037 = "(";
  protected final String TEXT_1038 = ");";
  protected final String TEXT_1039 = NL + "      ";
  protected final String TEXT_1040 = "(";
  protected final String TEXT_1041 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1042 = NL + "      ";
  protected final String TEXT_1043 = ".add(";
  protected final String TEXT_1044 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1045 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1046 = "(";
  protected final String TEXT_1047 = " ";
  protected final String TEXT_1048 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1049 = NL + "    if (";
  protected final String TEXT_1050 = ".contains(";
  protected final String TEXT_1051 = "))" + NL + "    {";
  protected final String TEXT_1052 = NL + "      ";
  protected final String TEXT_1053 = ".remove(";
  protected final String TEXT_1054 = ");";
  protected final String TEXT_1055 = NL + "      ";
  protected final String TEXT_1056 = ".";
  protected final String TEXT_1057 = "(null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1058 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1059 = NL + "  public boolean ";
  protected final String TEXT_1060 = "(";
  protected final String TEXT_1061 = " ";
  protected final String TEXT_1062 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1063 = NL + "    if (";
  protected final String TEXT_1064 = "() < ";
  protected final String TEXT_1065 = "())" + NL + "    {";
  protected final String TEXT_1066 = NL + "      ";
  protected final String TEXT_1067 = ".add(";
  protected final String TEXT_1068 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1069 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1070 = "(";
  protected final String TEXT_1071 = " ";
  protected final String TEXT_1072 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1073 = NL + "    if (!";
  protected final String TEXT_1074 = ".contains(";
  protected final String TEXT_1075 = "))" + NL + "    {";
  protected final String TEXT_1076 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1077 = "() <= ";
  protected final String TEXT_1078 = "())" + NL + "    {";
  protected final String TEXT_1079 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1080 = NL + "    ";
  protected final String TEXT_1081 = ".remove(";
  protected final String TEXT_1082 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_1083 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1084 = NL + "  public boolean ";
  protected final String TEXT_1085 = "(";
  protected final String TEXT_1086 = " ";
  protected final String TEXT_1087 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1088 = NL + "    if (";
  protected final String TEXT_1089 = "() >= ";
  protected final String TEXT_1090 = "())" + NL + "    {";
  protected final String TEXT_1091 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1092 = NL + "    ";
  protected final String TEXT_1093 = " ";
  protected final String TEXT_1094 = " = ";
  protected final String TEXT_1095 = ".";
  protected final String TEXT_1096 = "();" + NL + "    if (";
  protected final String TEXT_1097 = " != null && ";
  protected final String TEXT_1098 = ".";
  protected final String TEXT_1099 = "() <= ";
  protected final String TEXT_1100 = "())" + NL + "    {";
  protected final String TEXT_1101 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1102 = " != null)" + NL + "    {";
  protected final String TEXT_1103 = NL + "      ";
  protected final String TEXT_1104 = ".";
  protected final String TEXT_1105 = ".remove(";
  protected final String TEXT_1106 = ");" + NL + "    }";
  protected final String TEXT_1107 = NL + "    ";
  protected final String TEXT_1108 = ".add(";
  protected final String TEXT_1109 = ");";
  protected final String TEXT_1110 = NL + "    ";
  protected final String TEXT_1111 = "(";
  protected final String TEXT_1112 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1113 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1114 = "(";
  protected final String TEXT_1115 = " ";
  protected final String TEXT_1116 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1117 = NL + "    if (";
  protected final String TEXT_1118 = ".contains(";
  protected final String TEXT_1119 = ") && ";
  protected final String TEXT_1120 = "() > ";
  protected final String TEXT_1121 = "())" + NL + "    {";
  protected final String TEXT_1122 = NL + "      ";
  protected final String TEXT_1123 = ".remove(";
  protected final String TEXT_1124 = ");";
  protected final String TEXT_1125 = NL + "      ";
  protected final String TEXT_1126 = "(";
  protected final String TEXT_1127 = ",null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1128 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1129 = NL + "  boolean ";
  protected final String TEXT_1130 = "(";
  protected final String TEXT_1131 = "... ";
  protected final String TEXT_1132 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1133 = NL + "    ArrayList<";
  protected final String TEXT_1134 = "> ";
  protected final String TEXT_1135 = " = new ArrayList<";
  protected final String TEXT_1136 = ">();" + NL + "    for (";
  protected final String TEXT_1137 = " ";
  protected final String TEXT_1138 = " : ";
  protected final String TEXT_1139 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1140 = ".contains(";
  protected final String TEXT_1141 = "))" + NL + "      {";
  protected final String TEXT_1142 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1143 = ".";
  protected final String TEXT_1144 = "() != null && !this.equals(";
  protected final String TEXT_1145 = ".";
  protected final String TEXT_1146 = "()))" + NL + "      {";
  protected final String TEXT_1147 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1148 = NL + "      ";
  protected final String TEXT_1149 = ".add(";
  protected final String TEXT_1150 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1151 = ".size() != ";
  protected final String TEXT_1152 = "())" + NL + "    {";
  protected final String TEXT_1153 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1154 = NL + "    ";
  protected final String TEXT_1155 = ".removeAll(";
  protected final String TEXT_1156 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1157 = " orphan : ";
  protected final String TEXT_1158 = ")" + NL + "    {";
  protected final String TEXT_1159 = NL + "      ";
  protected final String TEXT_1160 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1161 = NL + "    ";
  protected final String TEXT_1162 = ".clear();" + NL + "    for (";
  protected final String TEXT_1163 = " ";
  protected final String TEXT_1164 = " : ";
  protected final String TEXT_1165 = ")" + NL + "    {";
  protected final String TEXT_1166 = NL + "      ";
  protected final String TEXT_1167 = "(";
  protected final String TEXT_1168 = ", this);";
  protected final String TEXT_1169 = NL + "      ";
  protected final String TEXT_1170 = ".add(";
  protected final String TEXT_1171 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1172 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1173 = NL + "  void ";
  protected final String TEXT_1174 = "(";
  protected final String TEXT_1175 = " ";
  protected final String TEXT_1176 = ", ";
  protected final String TEXT_1177 = " ";
  protected final String TEXT_1178 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1179 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1180 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1181 = ", ";
  protected final String TEXT_1182 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1183 = " to ";
  protected final String TEXT_1184 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1185 = NL + "  public boolean ";
  protected final String TEXT_1186 = "(";
  protected final String TEXT_1187 = " ";
  protected final String TEXT_1188 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1189 = NL + "    ";
  protected final String TEXT_1190 = ".add(";
  protected final String TEXT_1191 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1192 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1193 = "(";
  protected final String TEXT_1194 = " ";
  protected final String TEXT_1195 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1196 = NL + "    if (";
  protected final String TEXT_1197 = ".contains(";
  protected final String TEXT_1198 = "))" + NL + "    {";
  protected final String TEXT_1199 = NL + "      ";
  protected final String TEXT_1200 = ".remove(";
  protected final String TEXT_1201 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1202 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1203 = NL + "  public boolean ";
  protected final String TEXT_1204 = "(";
  protected final String TEXT_1205 = " ";
  protected final String TEXT_1206 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1207 = NL + "    if (";
  protected final String TEXT_1208 = "() < ";
  protected final String TEXT_1209 = "())" + NL + "    {";
  protected final String TEXT_1210 = NL + "      ";
  protected final String TEXT_1211 = ".add(";
  protected final String TEXT_1212 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1213 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1214 = "(";
  protected final String TEXT_1215 = " ";
  protected final String TEXT_1216 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1217 = NL + "    if (";
  protected final String TEXT_1218 = ".contains(";
  protected final String TEXT_1219 = "))" + NL + "    {";
  protected final String TEXT_1220 = NL + "      ";
  protected final String TEXT_1221 = ".remove(";
  protected final String TEXT_1222 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1223 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1224 = NL + "  public boolean ";
  protected final String TEXT_1225 = "(";
  protected final String TEXT_1226 = " ";
  protected final String TEXT_1227 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1228 = NL + "    ";
  protected final String TEXT_1229 = ".add(";
  protected final String TEXT_1230 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1231 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1232 = "(";
  protected final String TEXT_1233 = " ";
  protected final String TEXT_1234 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1235 = NL + "    if (!";
  protected final String TEXT_1236 = ".contains(";
  protected final String TEXT_1237 = "))" + NL + "    {";
  protected final String TEXT_1238 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1239 = "() <= ";
  protected final String TEXT_1240 = "())" + NL + "    {";
  protected final String TEXT_1241 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1242 = NL + "    ";
  protected final String TEXT_1243 = ".remove(";
  protected final String TEXT_1244 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_1245 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1246 = NL + "  boolean ";
  protected final String TEXT_1247 = "(";
  protected final String TEXT_1248 = "... ";
  protected final String TEXT_1249 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1250 = NL + "    ArrayList<";
  protected final String TEXT_1251 = "> ";
  protected final String TEXT_1252 = " = new ArrayList<";
  protected final String TEXT_1253 = ">();" + NL + "    for (";
  protected final String TEXT_1254 = " ";
  protected final String TEXT_1255 = " : ";
  protected final String TEXT_1256 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1257 = ".contains(";
  protected final String TEXT_1258 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1259 = NL + "      ";
  protected final String TEXT_1260 = ".add(";
  protected final String TEXT_1261 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1262 = ".size() != ";
  protected final String TEXT_1263 = ".length || ";
  protected final String TEXT_1264 = ".size() != ";
  protected final String TEXT_1265 = "())" + NL + "    {";
  protected final String TEXT_1266 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1267 = NL + "    ";
  protected final String TEXT_1268 = ".clear();";
  protected final String TEXT_1269 = NL + "    ";
  protected final String TEXT_1270 = ".addAll(";
  protected final String TEXT_1271 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1272 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1273 = NL + "  boolean ";
  protected final String TEXT_1274 = "(";
  protected final String TEXT_1275 = "... ";
  protected final String TEXT_1276 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1277 = NL + "    ArrayList<";
  protected final String TEXT_1278 = "> ";
  protected final String TEXT_1279 = " = new ArrayList<";
  protected final String TEXT_1280 = ">();" + NL + "    for (";
  protected final String TEXT_1281 = " ";
  protected final String TEXT_1282 = " : ";
  protected final String TEXT_1283 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1284 = ".contains(";
  protected final String TEXT_1285 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1286 = NL + "      ";
  protected final String TEXT_1287 = ".add(";
  protected final String TEXT_1288 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1289 = ".size() != ";
  protected final String TEXT_1290 = ".length || ";
  protected final String TEXT_1291 = ".size() < ";
  protected final String TEXT_1292 = "() || ";
  protected final String TEXT_1293 = ".size() > ";
  protected final String TEXT_1294 = "())" + NL + "    {";
  protected final String TEXT_1295 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1296 = "> ";
  protected final String TEXT_1297 = " = new ArrayList<";
  protected final String TEXT_1298 = ">(";
  protected final String TEXT_1299 = ");";
  protected final String TEXT_1300 = NL + "    ";
  protected final String TEXT_1301 = ".clear();" + NL + "    for (";
  protected final String TEXT_1302 = " ";
  protected final String TEXT_1303 = " : ";
  protected final String TEXT_1304 = ")" + NL + "    {";
  protected final String TEXT_1305 = NL + "      ";
  protected final String TEXT_1306 = ".add(";
  protected final String TEXT_1307 = ");" + NL + "      if (";
  protected final String TEXT_1308 = ".contains(";
  protected final String TEXT_1309 = "))" + NL + "      {";
  protected final String TEXT_1310 = NL + "        ";
  protected final String TEXT_1311 = ".remove(";
  protected final String TEXT_1312 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1313 = NL + "        ";
  protected final String TEXT_1314 = ".";
  protected final String TEXT_1315 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1316 = " ";
  protected final String TEXT_1317 = " : ";
  protected final String TEXT_1318 = ")" + NL + "    {";
  protected final String TEXT_1319 = NL + "      ";
  protected final String TEXT_1320 = ".";
  protected final String TEXT_1321 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1322 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1323 = NL + "  boolean ";
  protected final String TEXT_1324 = "(";
  protected final String TEXT_1325 = "... ";
  protected final String TEXT_1326 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1327 = NL + "    ArrayList<";
  protected final String TEXT_1328 = "> ";
  protected final String TEXT_1329 = " = new ArrayList<";
  protected final String TEXT_1330 = ">();" + NL + "    for (";
  protected final String TEXT_1331 = " ";
  protected final String TEXT_1332 = " : ";
  protected final String TEXT_1333 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1334 = ".contains(";
  protected final String TEXT_1335 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1336 = NL + "      ";
  protected final String TEXT_1337 = ".add(";
  protected final String TEXT_1338 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1339 = ".size() != ";
  protected final String TEXT_1340 = ".length || ";
  protected final String TEXT_1341 = ".size() < ";
  protected final String TEXT_1342 = "())" + NL + "    {";
  protected final String TEXT_1343 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1344 = "> ";
  protected final String TEXT_1345 = " = new ArrayList<";
  protected final String TEXT_1346 = ">(";
  protected final String TEXT_1347 = ");";
  protected final String TEXT_1348 = NL + "    ";
  protected final String TEXT_1349 = ".clear();" + NL + "    for (";
  protected final String TEXT_1350 = " ";
  protected final String TEXT_1351 = " : ";
  protected final String TEXT_1352 = ")" + NL + "    {";
  protected final String TEXT_1353 = NL + "      ";
  protected final String TEXT_1354 = ".add(";
  protected final String TEXT_1355 = ");" + NL + "      if (";
  protected final String TEXT_1356 = ".contains(";
  protected final String TEXT_1357 = "))" + NL + "      {";
  protected final String TEXT_1358 = NL + "        ";
  protected final String TEXT_1359 = ".remove(";
  protected final String TEXT_1360 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1361 = NL + "        ";
  protected final String TEXT_1362 = ".";
  protected final String TEXT_1363 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1364 = " ";
  protected final String TEXT_1365 = " : ";
  protected final String TEXT_1366 = ")" + NL + "    {";
  protected final String TEXT_1367 = NL + "      ";
  protected final String TEXT_1368 = ".";
  protected final String TEXT_1369 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1370 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1371 = NL + "  boolean ";
  protected final String TEXT_1372 = "(";
  protected final String TEXT_1373 = "... ";
  protected final String TEXT_1374 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1375 = NL + "    ArrayList<";
  protected final String TEXT_1376 = "> ";
  protected final String TEXT_1377 = " = new ArrayList<";
  protected final String TEXT_1378 = ">();" + NL + "    for (";
  protected final String TEXT_1379 = " ";
  protected final String TEXT_1380 = " : ";
  protected final String TEXT_1381 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1382 = ".contains(";
  protected final String TEXT_1383 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1384 = NL + "      ";
  protected final String TEXT_1385 = ".add(";
  protected final String TEXT_1386 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1387 = ".size() != ";
  protected final String TEXT_1388 = ".length || ";
  protected final String TEXT_1389 = ".size() < ";
  protected final String TEXT_1390 = "() || ";
  protected final String TEXT_1391 = ".size() > ";
  protected final String TEXT_1392 = "())" + NL + "    {";
  protected final String TEXT_1393 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1394 = NL + "    ";
  protected final String TEXT_1395 = ".clear();";
  protected final String TEXT_1396 = NL + "    ";
  protected final String TEXT_1397 = ".addAll(";
  protected final String TEXT_1398 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1399 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1400 = NL + "  boolean ";
  protected final String TEXT_1401 = "(";
  protected final String TEXT_1402 = "... ";
  protected final String TEXT_1403 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1404 = NL + "    if (";
  protected final String TEXT_1405 = ".length < ";
  protected final String TEXT_1406 = "()";
  protected final String TEXT_1407 = ")" + NL + "    {";
  protected final String TEXT_1408 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1409 = "> ";
  protected final String TEXT_1410 = " = new ArrayList<";
  protected final String TEXT_1411 = ">();" + NL + "    HashMap<";
  protected final String TEXT_1412 = ",Integer> ";
  protected final String TEXT_1413 = " = new HashMap<";
  protected final String TEXT_1414 = ",Integer>();" + NL + "    for (";
  protected final String TEXT_1415 = " ";
  protected final String TEXT_1416 = " : ";
  protected final String TEXT_1417 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1418 = ".contains(";
  protected final String TEXT_1419 = "))" + NL + "      {";
  protected final String TEXT_1420 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1421 = ".";
  protected final String TEXT_1422 = "() != null && !this.equals(";
  protected final String TEXT_1423 = ".";
  protected final String TEXT_1424 = "()))" + NL + "      {";
  protected final String TEXT_1425 = NL + "        ";
  protected final String TEXT_1426 = " ";
  protected final String TEXT_1427 = " = ";
  protected final String TEXT_1428 = ".";
  protected final String TEXT_1429 = "();" + NL + "        if (!";
  protected final String TEXT_1430 = ".containsKey(";
  protected final String TEXT_1431 = "))" + NL + "        {";
  protected final String TEXT_1432 = NL + "          ";
  protected final String TEXT_1433 = ".put(";
  protected final String TEXT_1434 = ", new Integer(";
  protected final String TEXT_1435 = ".";
  protected final String TEXT_1436 = "()));" + NL + "        }" + NL + "        Integer currentCount = ";
  protected final String TEXT_1437 = ".get(";
  protected final String TEXT_1438 = ");" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_1439 = ")" + NL + "        {";
  protected final String TEXT_1440 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_1441 = NL + "        ";
  protected final String TEXT_1442 = ".put(";
  protected final String TEXT_1443 = ", new Integer(nextCount));" + NL + "      }";
  protected final String TEXT_1444 = NL + "      ";
  protected final String TEXT_1445 = ".add(";
  protected final String TEXT_1446 = ");" + NL + "    }" + NL;
  protected final String TEXT_1447 = NL + "    ";
  protected final String TEXT_1448 = ".removeAll(";
  protected final String TEXT_1449 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_1450 = " orphan : ";
  protected final String TEXT_1451 = ")" + NL + "    {";
  protected final String TEXT_1452 = NL + "      ";
  protected final String TEXT_1453 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1454 = NL + "    ";
  protected final String TEXT_1455 = ".clear();" + NL + "    for (";
  protected final String TEXT_1456 = " ";
  protected final String TEXT_1457 = " : ";
  protected final String TEXT_1458 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1459 = ".";
  protected final String TEXT_1460 = "() != null)" + NL + "      {";
  protected final String TEXT_1461 = NL + "        ";
  protected final String TEXT_1462 = ".";
  protected final String TEXT_1463 = "().";
  protected final String TEXT_1464 = ".remove(";
  protected final String TEXT_1465 = ");" + NL + "      }";
  protected final String TEXT_1466 = NL + "      ";
  protected final String TEXT_1467 = "(";
  protected final String TEXT_1468 = ", this);";
  protected final String TEXT_1469 = NL + "      ";
  protected final String TEXT_1470 = ".add(";
  protected final String TEXT_1471 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1472 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1473 = NL + "  void ";
  protected final String TEXT_1474 = "(";
  protected final String TEXT_1475 = " ";
  protected final String TEXT_1476 = ", ";
  protected final String TEXT_1477 = " ";
  protected final String TEXT_1478 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1479 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1480 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1481 = ", ";
  protected final String TEXT_1482 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1483 = " to ";
  protected final String TEXT_1484 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1485 = NL + "  boolean ";
  protected final String TEXT_1486 = "(";
  protected final String TEXT_1487 = "... ";
  protected final String TEXT_1488 = ")" + NL + "  {" + NL + "    bool wasSet = false;";
  protected final String TEXT_1489 = NL + "    ArrayList<";
  protected final String TEXT_1490 = "> ";
  protected final String TEXT_1491 = " = new ArrayList<";
  protected final String TEXT_1492 = ">();" + NL + "    for (";
  protected final String TEXT_1493 = " ";
  protected final String TEXT_1494 = " : ";
  protected final String TEXT_1495 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1496 = ".contains(";
  protected final String TEXT_1497 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1498 = NL + "      ";
  protected final String TEXT_1499 = ".add(";
  protected final String TEXT_1500 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1501 = ".size() != ";
  protected final String TEXT_1502 = ".length || ";
  protected final String TEXT_1503 = ".size() > ";
  protected final String TEXT_1504 = "())" + NL + "    {";
  protected final String TEXT_1505 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1506 = NL + "    ";
  protected final String TEXT_1507 = ".clear();";
  protected final String TEXT_1508 = NL + "    ";
  protected final String TEXT_1509 = ".addAll(";
  protected final String TEXT_1510 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1511 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1512 = NL + "  public boolean ";
  protected final String TEXT_1513 = "(";
  protected final String TEXT_1514 = "... ";
  protected final String TEXT_1515 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1516 = NL + "    ArrayList<";
  protected final String TEXT_1517 = "> ";
  protected final String TEXT_1518 = " = new ArrayList<";
  protected final String TEXT_1519 = ">();" + NL + "    for (";
  protected final String TEXT_1520 = " ";
  protected final String TEXT_1521 = " : ";
  protected final String TEXT_1522 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1523 = ".contains(";
  protected final String TEXT_1524 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1525 = NL + "      ";
  protected final String TEXT_1526 = ".add(";
  protected final String TEXT_1527 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1528 = ".size() != ";
  protected final String TEXT_1529 = ".length || ";
  protected final String TEXT_1530 = ".size() < ";
  protected final String TEXT_1531 = "())" + NL + "    {";
  protected final String TEXT_1532 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1533 = NL + "    ";
  protected final String TEXT_1534 = ".clear();";
  protected final String TEXT_1535 = NL + "    ";
  protected final String TEXT_1536 = ".addAll(";
  protected final String TEXT_1537 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1538 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1539 = NL + "  public boolean equals(Object obj)" + NL + "  {" + NL + "    if (obj == null) { return false; }" + NL + "    if (!getClass().equals(obj.getClass())) { return false; }" + NL;
  protected final String TEXT_1540 = NL + "    ";
  protected final String TEXT_1541 = " compareTo = (";
  protected final String TEXT_1542 = ")obj;" + NL + "  ";
  protected final String TEXT_1543 = NL + "    ";
  protected final String TEXT_1544 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_1545 = NL + "    ";
  protected final String TEXT_1546 = NL;
  protected final String TEXT_1547 = NL + "    ";
  protected final String TEXT_1548 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1549 = NL + "  private void ";
  protected final String TEXT_1550 = "()" + NL + "  {" + NL + "     try" + NL + "     {";
  protected final String TEXT_1551 = NL + "       ";
  protected final String TEXT_1552 = NL + "     }" + NL + "     catch (InterruptedException e)" + NL + "     {" + NL + " " + NL + "     }" + NL + "  }" + NL;
  protected final String TEXT_1553 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1554 = NL + "    ";
  protected final String TEXT_1555 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1556 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_1557 = NL + "      ";
  protected final String TEXT_1558 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1559 = NL + "  private void ";
  protected final String TEXT_1560 = "()" + NL + "  {";
  protected final String TEXT_1561 = NL + "    ";
  protected final String TEXT_1562 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1563 = "\",";
  protected final String TEXT_1564 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1565 = "()" + NL + "  {";
  protected final String TEXT_1566 = NL + "    ";
  protected final String TEXT_1567 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1568 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1569 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1570 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void run ()" + NL + "    {";
  protected final String TEXT_1571 = NL + "      if (\"";
  protected final String TEXT_1572 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1573 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1574 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1575 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1576 = NL + "    ";
  protected final String TEXT_1577 = " = null;";
  protected final String TEXT_1578 = NL + "    ";
  protected final String TEXT_1579 = ".clear();";
  protected final String TEXT_1580 = NL + "    ";
  protected final String TEXT_1581 = " ";
  protected final String TEXT_1582 = " = ";
  protected final String TEXT_1583 = ";";
  protected final String TEXT_1584 = NL + "    ";
  protected final String TEXT_1585 = " = null;" + NL + "    if (";
  protected final String TEXT_1586 = " != null)" + NL + "    {";
  protected final String TEXT_1587 = NL + "      ";
  protected final String TEXT_1588 = ".delete();" + NL + "    }";
  protected final String TEXT_1589 = NL + "    if (";
  protected final String TEXT_1590 = " != null)" + NL + "    {";
  protected final String TEXT_1591 = NL + "      ";
  protected final String TEXT_1592 = ".";
  protected final String TEXT_1593 = "(null);" + NL + "    }";
  protected final String TEXT_1594 = NL + "    ";
  protected final String TEXT_1595 = " ";
  protected final String TEXT_1596 = " = ";
  protected final String TEXT_1597 = ";";
  protected final String TEXT_1598 = NL + "    ";
  protected final String TEXT_1599 = " = null;" + NL + "    if (";
  protected final String TEXT_1600 = " != null)" + NL + "    {";
  protected final String TEXT_1601 = NL + "      ";
  protected final String TEXT_1602 = ".";
  protected final String TEXT_1603 = "(null);" + NL + "    }";
  protected final String TEXT_1604 = NL + "    ";
  protected final String TEXT_1605 = " ";
  protected final String TEXT_1606 = " = ";
  protected final String TEXT_1607 = ";";
  protected final String TEXT_1608 = NL + "    ";
  protected final String TEXT_1609 = " = null;" + NL + "    if (";
  protected final String TEXT_1610 = " != null)" + NL + "    {";
  protected final String TEXT_1611 = NL + "      ";
  protected final String TEXT_1612 = ".delete();" + NL + "    }";
  protected final String TEXT_1613 = NL + "    if (";
  protected final String TEXT_1614 = " != null)" + NL + "    {";
  protected final String TEXT_1615 = NL + "      ";
  protected final String TEXT_1616 = " ";
  protected final String TEXT_1617 = " = ";
  protected final String TEXT_1618 = ";" + NL + "      this.";
  protected final String TEXT_1619 = " = null;";
  protected final String TEXT_1620 = NL + "      ";
  protected final String TEXT_1621 = ".";
  protected final String TEXT_1622 = "(this);" + NL + "    }";
  protected final String TEXT_1623 = NL + "    if (";
  protected final String TEXT_1624 = " != null)" + NL + "    {";
  protected final String TEXT_1625 = NL + "      ";
  protected final String TEXT_1626 = ".delete();" + NL + "    }";
  protected final String TEXT_1627 = NL + "    if (";
  protected final String TEXT_1628 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1629 = ".";
  protected final String TEXT_1630 = "() <= ";
  protected final String TEXT_1631 = ")" + NL + "      {";
  protected final String TEXT_1632 = NL + "        ";
  protected final String TEXT_1633 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1634 = NL + "        ";
  protected final String TEXT_1635 = " ";
  protected final String TEXT_1636 = " = ";
  protected final String TEXT_1637 = ";" + NL + "        this.";
  protected final String TEXT_1638 = " = null;";
  protected final String TEXT_1639 = NL + "        ";
  protected final String TEXT_1640 = ".";
  protected final String TEXT_1641 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1642 = NL + "    ";
  protected final String TEXT_1643 = " ";
  protected final String TEXT_1644 = " = ";
  protected final String TEXT_1645 = ";" + NL + "    this.";
  protected final String TEXT_1646 = " = null;";
  protected final String TEXT_1647 = NL + "    ";
  protected final String TEXT_1648 = ".";
  protected final String TEXT_1649 = "(this);";
  protected final String TEXT_1650 = NL + "    for(";
  protected final String TEXT_1651 = " ";
  protected final String TEXT_1652 = " : ";
  protected final String TEXT_1653 = ")" + NL + "    {";
  protected final String TEXT_1654 = NL + "      ";
  protected final String TEXT_1655 = "(";
  protected final String TEXT_1656 = ",null);" + NL + "    }";
  protected final String TEXT_1657 = NL + "    ";
  protected final String TEXT_1658 = ".clear();";
  protected final String TEXT_1659 = NL + "    ArrayList<";
  protected final String TEXT_1660 = "> ";
  protected final String TEXT_1661 = " = new ArrayList<";
  protected final String TEXT_1662 = ">(";
  protected final String TEXT_1663 = ");";
  protected final String TEXT_1664 = NL + "    ";
  protected final String TEXT_1665 = ".clear();" + NL + "    for(";
  protected final String TEXT_1666 = " ";
  protected final String TEXT_1667 = " : ";
  protected final String TEXT_1668 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1669 = ".";
  protected final String TEXT_1670 = "() <= ";
  protected final String TEXT_1671 = ".";
  protected final String TEXT_1672 = "())" + NL + "      {";
  protected final String TEXT_1673 = NL + "        ";
  protected final String TEXT_1674 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1675 = NL + "        ";
  protected final String TEXT_1676 = ".";
  protected final String TEXT_1677 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1678 = NL + "    ArrayList<";
  protected final String TEXT_1679 = "> ";
  protected final String TEXT_1680 = " = new ArrayList<";
  protected final String TEXT_1681 = ">(";
  protected final String TEXT_1682 = ");";
  protected final String TEXT_1683 = NL + "    ";
  protected final String TEXT_1684 = ".clear();" + NL + "    for(";
  protected final String TEXT_1685 = " ";
  protected final String TEXT_1686 = " : ";
  protected final String TEXT_1687 = ")" + NL + "    {";
  protected final String TEXT_1688 = NL + "      ";
  protected final String TEXT_1689 = ".";
  protected final String TEXT_1690 = "(this);" + NL + "    }";
  protected final String TEXT_1691 = NL + "    for(";
  protected final String TEXT_1692 = " ";
  protected final String TEXT_1693 = " : ";
  protected final String TEXT_1694 = ")" + NL + "    {";
  protected final String TEXT_1695 = NL + "      ";
  protected final String TEXT_1696 = ".delete();" + NL + "    }";
  protected final String TEXT_1697 = NL + "    for(";
  protected final String TEXT_1698 = " ";
  protected final String TEXT_1699 = " : ";
  protected final String TEXT_1700 = ")" + NL + "    {";
  protected final String TEXT_1701 = NL + "      ";
  protected final String TEXT_1702 = ".";
  protected final String TEXT_1703 = "(null);" + NL + "    }";
  protected final String TEXT_1704 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1705 = NL + "  ";
  protected final String TEXT_1706 = NL + "};";

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
    append(stringBuffer, "import {0};",depend.getName());
  }
  
  for (String anImport : gClass.getMultiLookup("import"))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "import {0};",anImport);
  }

    stringBuffer.append(TEXT_4);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).isInline) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(stringBuffer, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(uClass.getName());
    stringBuffer.append( gen.translate("isA",uClass) );
    stringBuffer.append(TEXT_6);
    
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
    append(stringBuffer, "  static {0} theInstance = null;", uClass.getName());
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
      type = StringFormatter.format("List<{0}>",gen.translate("typeMany",av));
    }

    appendln(stringBuffer, "");
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
    
    if (av.isOne())
    {
      append(stringBuffer, "  private {0} {1};", gen.translate("type",av), gen.translate("attributeOne",av));
    }
    else
    {
      append(stringBuffer, "  private List<{0}> {1};", gen.translate("typeMany",av), gen.translate("attributeMany",av));
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
    append(stringBuffer, "  private int cachedHashCode;");
  }

  for (Attribute av : uClass.getAttributes())
  {
    if ("immutable".equals(av.getModifier()))
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
      append(stringBuffer, "  private boolean {0};", gen.translate("attributeCanSet",av));
    }
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null && !"immutable".equals(av.getModifier()))
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  private boolean {0};", gen.translate("attributeCanSet",av));
    }
    else if (as != null)
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  private boolean {0};", gen.translate("associationCanSet",as));
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
      append(stringBuffer, "  private TimedEventHandler {0};", gen.translate("eventHandler",e));
    }
  }
}

    stringBuffer.append(TEXT_7);
    
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

  String accessibility = uClass.getIsSingleton() ? "private" : "public";
  append(stringBuffer,"  {0} {1}({2})",new Object[] {accessibility, uClass.getName(), gClass.getLookup("constructorSignature")});

  String extraNote = null;
  
  appendln(stringBuffer, "");
  
  boolean hasBody = false;

  append(stringBuffer, "  {");
  if (!uClass.isRoot() && !"interface".equals(uClass.getExtendsClass().getModifier()))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    super({0});", gClass.getParentClass().getLookup("constructorSignature_caller"));
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
    if (av != null && !"immutable".equals(av.getModifier()))
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
      
    stringBuffer.append(TEXT_8);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_10);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_11);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_12);
     
    }
    else if ("immutable".equals(av.getModifier()) && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_13);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_14);
    
    }
    else if ("immutable".equals(av.getModifier()))
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
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_20);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_22);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_25);
    
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
        
    stringBuffer.append(TEXT_26);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_30);
    
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
  

    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_40);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_43);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_52);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_53);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_55);
    
    }
    else if (av.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_62);
    
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
    append(stringBuffer, "    {0} = new ArrayList<{1}>();", gen.translate("associationMany",av), gen.getType(av));
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
  

    stringBuffer.append(TEXT_63);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_72);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_77);
    
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
    
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_81);
    
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_86);
    
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
    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_89);
    
  }

    
  if (isOneToOne)
  {
    
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_90);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_92);
    
  if (!uClass.isRoot())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    super({0});", gClass.getParentClass().getLookup("constructorSignature_caller"));
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
      
    stringBuffer.append(TEXT_93);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_95);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_96);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_97);
     
    }
    else
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_100);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_103);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    stringBuffer.append(TEXT_107);
    
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
    append(stringBuffer, "    {0} = new ArrayList<{1}>();", gen.translate("associationMany",av), gen.getType(av));
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
  

    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_117);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_122);
    
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


    stringBuffer.append(TEXT_123);
    
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
    
    if ("immutable".equals(av.getModifier()))
    {
      if (av.getIsLazy())
      {
        
    stringBuffer.append(TEXT_124);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_127);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_128);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_132);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_133);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_137);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_140);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_142);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n    {0}",customResetPrefixCode); } 
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_145);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n    {0}",customResetPostfixCode); } 
    stringBuffer.append(TEXT_146);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_150);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_153);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_157);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_158);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_160);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_161);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_162);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_165);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_168);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_169);
    
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
      
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_172);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_176);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_181);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_187);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_190);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_192);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_194);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_196);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_200);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_203);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_204);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_206);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_207);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_208);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_211);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_212);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_213);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_215);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_217);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_219);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_220);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_221);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_224);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_225);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_226);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_229);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_230);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_231);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_234);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_237);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_238);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPostfixCode); } 
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_240);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_241);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_243);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_244);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_245);
    
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
        
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_247);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_248);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_249);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_250);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_252);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_253);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_254);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_256);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_257);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_258);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_259);
    
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

    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_263);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_264);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_267);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_268);
    
    if (sm.hasFinalStates())
    {
      
    

  StringBuilder output = new StringBuilder();
  for(State state : sm.getFinalStates())
  {
    StateMachine finalSm = state.getStateMachine();
    if (output.length() > 0)
    {
      output.append(" && ");
    }
    output.append(StringFormatter.format("{0} == {1}.{2}",gen.translate("stateMachineOne",finalSm),gen.translate("type",finalSm),gen.translate("stateOne",state)));
  }
  String outputAsString = output.toString();

    stringBuffer.append(TEXT_269);
    stringBuffer.append(gen.translate("isFinalMethod",sm));
    stringBuffer.append(TEXT_270);
    stringBuffer.append( outputAsString );
    stringBuffer.append(TEXT_271);
      
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

    stringBuffer.append(TEXT_272);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(TEXT_274);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_275);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_277);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_278);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(TEXT_280);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_281);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_282);
    
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
    stringBuffer.append(TEXT_283);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_284);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(TEXT_286);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_287);
     } 
    stringBuffer.append(TEXT_288);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_289);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_290);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(TEXT_292);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_293);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_294);
     if (parentState != null) { 
    stringBuffer.append(TEXT_295);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_296);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_297);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_298);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_299);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_300);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_302);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_303);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_304);
     } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_305);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(TEXT_307);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_308);
     } 
    stringBuffer.append(TEXT_309);
    
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
      
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_312);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_313);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_314);
     } else { 
    stringBuffer.append(TEXT_315);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_318);
     append(stringBuffer, "\n    {0}",customGetPostfixCode); 
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_320);
     } 
    stringBuffer.append(TEXT_321);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_324);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_328);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_329);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_332);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_336);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_339);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_341);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_343);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_345);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_349);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_350);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_352);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_353);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_354);
    
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
      
    stringBuffer.append(TEXT_355);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(relatedAssociation);
    
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_358);
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPrefixCode); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_361);
     } else { 
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_366);
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPostfixCode); } 
    stringBuffer.append(TEXT_367);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_368);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_370);
     } else { 
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_372);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_373);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_374);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_375);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_378);
     } else { 
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_380);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_381);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_382);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_383);
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
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_386);
     } else { 
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_388);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_389);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_390);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_391);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_395);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_398);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_399);
     } 
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_402);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_409);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_410);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_414);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_417);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_429);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_430);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_431);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_434);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_437);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_438);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_441);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_442);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_443);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_447);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_448);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_452);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_460);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_461);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_471);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_479);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_480);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_484);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_489);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_499);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_500);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_514);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_515);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_524);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_543);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_547);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_548);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_552);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_557);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_558);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_561);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_562);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_573);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_576);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_577);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_589);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_597);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_601);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_606);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_611);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_612);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_615);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_616);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_627);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_630);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_631);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_646);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_650);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_658);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_659);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_663);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_679);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_706);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_707);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_716);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_731);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_735);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_743);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_744);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_748);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_762);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_763);
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_785);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_786);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_790);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_793);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_796);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_808);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_809);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_813);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_816);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_819);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_828);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_831);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_832);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_836);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_842);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_843);
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_860);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_861);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_865);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_867);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_868);
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_884);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_885);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_889);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_893);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_895);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
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
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_916);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_917);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_920);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_921);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_925);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_929);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_935);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_936);
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_951);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_952);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_955);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_956);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_960);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_980);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_984);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_993);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_994);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_998);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1015);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_1016);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1020);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1023);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1044);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1048);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1057);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1058);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1062);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1068);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1072);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1075);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1078);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1082);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1083);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1087);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1090);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1091);
     } 
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1100);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1112);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1116);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1127);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1128);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1132);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1141);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1146);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1152);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1171);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1184);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1188);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1191);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1195);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1201);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1202);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1206);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1212);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1216);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1222);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1223);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1227);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1230);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1234);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1237);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1240);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1244);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1245);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1249);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1265);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1271);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1272);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1276);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1294);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1321);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1322);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1326);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1342);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1369);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1370);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1374);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1392);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1398);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1399);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1400);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1403);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1407);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1419);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1439);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n          {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1471);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1484);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1488);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1503);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1504);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1510);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1511);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1515);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1531);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1537);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1538);
    
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


    stringBuffer.append(TEXT_1539);
    stringBuffer.append(TEXT_1540);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1541);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(TEXT_1543);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(TEXT_1545);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(TEXT_1547);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1548);
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
        
    stringBuffer.append(TEXT_1549);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(TEXT_1551);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1552);
    
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

    stringBuffer.append(TEXT_1553);
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(TEXT_1557);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1558);
    
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
        
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(TEXT_1561);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1562);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1563);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(TEXT_1566);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1567);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1568);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1569);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1570);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1571);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1572);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1573);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1574);
    
      }
    }
  }

    stringBuffer.append(TEXT_1575);
    
  }
}

    

  appendln(stringBuffer,"");
  appendln(stringBuffer,"  public void delete()");
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
        
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1577);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1579);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1588);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1593);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1599);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1603);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1612);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1617);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1622);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1626);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1629);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(TEXT_1632);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1641);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1649);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1658);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(TEXT_1673);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1677);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1678);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1682);
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1687);
    stringBuffer.append(TEXT_1688);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1690);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1692);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1696);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1698);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(TEXT_1701);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1703);
    
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
    		String methodName = aMethod.getName();
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
    			appendln(stringBuffer,override);
    			append(stringBuffer, "  {0} {1} {2}({3})", methodModifier, methodType, methodName, finalParams);	
    			appendln(stringBuffer, "{");
    			appendln(stringBuffer, properMethodBody);
    			appendln(stringBuffer, "  }");
    			
    		}
    		else{
    			appendln(stringBuffer, "");
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
    stringBuffer.append(TEXT_1704);
    stringBuffer.append(TEXT_1705);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_1706);
    return stringBuffer.toString();
  }
}