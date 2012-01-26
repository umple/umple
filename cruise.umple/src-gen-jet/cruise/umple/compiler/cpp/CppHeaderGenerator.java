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
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "#ifndef _";
  protected final String TEXT_4 = NL + "#define _";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + "class ";
  protected final String TEXT_7 = NL + "{" + NL + "   //------------------------" + NL + "  // Attributes for header file" + NL + "  //------------------------" + NL + "  private:";
  protected final String TEXT_8 = NL + NL + "  //------------------------" + NL + "  // Constructor" + NL + "  //------------------------" + NL + "  public:" + NL;
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = " = new ArrayList<";
  protected final String TEXT_11 = ">();";
  protected final String TEXT_12 = NL + "    ";
  protected final String TEXT_13 = "();";
  protected final String TEXT_14 = NL + "    ";
  protected final String TEXT_15 = " = true;";
  protected final String TEXT_16 = NL + "    ";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";";
  protected final String TEXT_19 = NL + "    ";
  protected final String TEXT_20 = " = false;";
  protected final String TEXT_21 = NL + "    ";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "    ";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = "++;";
  protected final String TEXT_27 = NL + "    if (!";
  protected final String TEXT_28 = "(";
  protected final String TEXT_29 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_30 = " due to ";
  protected final String TEXT_31 = "\");" + NL + "    }";
  protected final String TEXT_32 = NL + "    ";
  protected final String TEXT_33 = " = new ArrayList<";
  protected final String TEXT_34 = ">();" + NL + "    boolean ";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = "(";
  protected final String TEXT_37 = ");" + NL + "    if (!";
  protected final String TEXT_38 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_39 = ", must have ";
  protected final String TEXT_40 = " ";
  protected final String TEXT_41 = "\");" + NL + "    }";
  protected final String TEXT_42 = NL + "    ";
  protected final String TEXT_43 = " = new ArrayList<";
  protected final String TEXT_44 = ">();";
  protected final String TEXT_45 = NL + "    if (";
  protected final String TEXT_46 = " == null || ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "() != null)" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_49 = " due to ";
  protected final String TEXT_50 = "\");" + NL + "    }";
  protected final String TEXT_51 = NL + "    ";
  protected final String TEXT_52 = " = ";
  protected final String TEXT_53 = ";";
  protected final String TEXT_54 = NL + "    ";
  protected final String TEXT_55 = " = new ArrayList<";
  protected final String TEXT_56 = ">();";
  protected final String TEXT_57 = NL + "    boolean ";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = "(";
  protected final String TEXT_60 = ");" + NL + "    if (!";
  protected final String TEXT_61 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_62 = " due to ";
  protected final String TEXT_63 = "\");" + NL + "    }";
  protected final String TEXT_64 = NL + "    ";
  protected final String TEXT_65 = " = new ArrayList<";
  protected final String TEXT_66 = ">();" + NL + "    boolean ";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = "(";
  protected final String TEXT_69 = ");" + NL + "    if (!";
  protected final String TEXT_70 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_71 = ", must have ";
  protected final String TEXT_72 = " ";
  protected final String TEXT_73 = "\");" + NL + "    }";
  protected final String TEXT_74 = " = new ArrayList<";
  protected final String TEXT_75 = ">();";
  protected final String TEXT_76 = NL + "    ";
  protected final String TEXT_77 = ".add(";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "    ";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "    if (";
  protected final String TEXT_84 = " == null) { ";
  protected final String TEXT_85 = "(";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = "); }";
  protected final String TEXT_88 = NL + "  public static ";
  protected final String TEXT_89 = " getInstance()" + NL + "  {" + NL + "    if(theInstance == null)" + NL + "    {" + NL + "      theInstance = new ";
  protected final String TEXT_90 = "();" + NL + "    }" + NL + "    return theInstance;" + NL + "  }";
  protected final String TEXT_91 = NL + NL + "  public ";
  protected final String TEXT_92 = "(";
  protected final String TEXT_93 = ")" + NL + "  {";
  protected final String TEXT_94 = NL + "    ";
  protected final String TEXT_95 = " = new ArrayList<";
  protected final String TEXT_96 = ">();";
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
  protected final String TEXT_110 = " = new ArrayList<";
  protected final String TEXT_111 = ">();" + NL + "    boolean ";
  protected final String TEXT_112 = " = ";
  protected final String TEXT_113 = "(";
  protected final String TEXT_114 = ");" + NL + "    if (!";
  protected final String TEXT_115 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_116 = ", must have ";
  protected final String TEXT_117 = " ";
  protected final String TEXT_118 = "\");" + NL + "    }";
  protected final String TEXT_119 = " = new ArrayList<";
  protected final String TEXT_120 = ">();";
  protected final String TEXT_121 = NL + "    ";
  protected final String TEXT_122 = ".add(";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_125 = NL + "  bool ";
  protected final String TEXT_126 = "(";
  protected final String TEXT_127 = " ";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "  bool ";
  protected final String TEXT_130 = "(";
  protected final String TEXT_131 = " ";
  protected final String TEXT_132 = ");" + NL + "  bool ";
  protected final String TEXT_133 = "();";
  protected final String TEXT_134 = NL + "  bool ";
  protected final String TEXT_135 = "(";
  protected final String TEXT_136 = " ";
  protected final String TEXT_137 = ");" + NL + "  bool ";
  protected final String TEXT_138 = "(";
  protected final String TEXT_139 = " ";
  protected final String TEXT_140 = ");";
  protected final String TEXT_141 = NL + "  bool ";
  protected final String TEXT_142 = "(";
  protected final String TEXT_143 = " ";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "  ";
  protected final String TEXT_146 = " ";
  protected final String TEXT_147 = "(int index);";
  protected final String TEXT_148 = NL + "  ";
  protected final String TEXT_149 = "[] ";
  protected final String TEXT_150 = "();" + NL + "  int ";
  protected final String TEXT_151 = "();" + NL + "  bool ";
  protected final String TEXT_152 = "();" + NL + "  int ";
  protected final String TEXT_153 = "(";
  protected final String TEXT_154 = " ";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "  ";
  protected final String TEXT_157 = " ";
  protected final String TEXT_158 = "();";
  protected final String TEXT_159 = NL + "  ";
  protected final String TEXT_160 = " ";
  protected final String TEXT_161 = "();";
  protected final String TEXT_162 = NL + "  ";
  protected final String TEXT_163 = " ";
  protected final String TEXT_164 = "();";
  protected final String TEXT_165 = NL + "  ";
  protected final String TEXT_166 = " ";
  protected final String TEXT_167 = "();";
  protected final String TEXT_168 = NL + "  ";
  protected final String TEXT_169 = " ";
  protected final String TEXT_170 = "();";
  protected final String TEXT_171 = NL + "  ";
  protected final String TEXT_172 = " ";
  protected final String TEXT_173 = "();";
  protected final String TEXT_174 = NL + "  ";
  protected final String TEXT_175 = " ";
  protected final String TEXT_176 = "();";
  protected final String TEXT_177 = NL + "  ";
  protected final String TEXT_178 = " ";
  protected final String TEXT_179 = "();";
  protected final String TEXT_180 = NL + "  public ";
  protected final String TEXT_181 = " ";
  protected final String TEXT_182 = "()" + NL + "  {" + NL + "    String answer = ";
  protected final String TEXT_183 = ".toString();";
  protected final String TEXT_184 = NL + "    return answer;" + NL + "  }" + NL;
  protected final String TEXT_185 = NL + "  public ";
  protected final String TEXT_186 = " ";
  protected final String TEXT_187 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_188 = ";" + NL + "  }" + NL;
  protected final String TEXT_189 = NL + "  public boolean ";
  protected final String TEXT_190 = "()" + NL + "  {" + NL + "    boolean wasEventProcessed = false;" + NL;
  protected final String TEXT_191 = NL + "    ";
  protected final String TEXT_192 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_193 = NL + "  public boolean ";
  protected final String TEXT_194 = "(";
  protected final String TEXT_195 = " ";
  protected final String TEXT_196 = ")" + NL + "  {";
  protected final String TEXT_197 = NL + "    ";
  protected final String TEXT_198 = " = ";
  protected final String TEXT_199 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_200 = NL + "  private void ";
  protected final String TEXT_201 = "()" + NL + "  {" + NL + "    switch(";
  protected final String TEXT_202 = ")" + NL + "    {";
  protected final String TEXT_203 = NL + "      ";
  protected final String TEXT_204 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_205 = NL + "  private void ";
  protected final String TEXT_206 = "(";
  protected final String TEXT_207 = " ";
  protected final String TEXT_208 = ")" + NL + "  {";
  protected final String TEXT_209 = NL + "    ";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = ";";
  protected final String TEXT_212 = NL + "    if (";
  protected final String TEXT_213 = " != ";
  protected final String TEXT_214 = ".";
  protected final String TEXT_215 = " && ";
  protected final String TEXT_216 = " != ";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = ") { ";
  protected final String TEXT_219 = "(";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = "); }";
  protected final String TEXT_222 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_223 = ")" + NL + "    {";
  protected final String TEXT_224 = NL + "      ";
  protected final String TEXT_225 = NL + "    }";
  protected final String TEXT_226 = NL + "  }" + NL;
  protected final String TEXT_227 = NL + "  ";
  protected final String TEXT_228 = " ";
  protected final String TEXT_229 = "();";
  protected final String TEXT_230 = NL + "  ";
  protected final String TEXT_231 = " ";
  protected final String TEXT_232 = "(int index);" + NL + "  List<";
  protected final String TEXT_233 = "> ";
  protected final String TEXT_234 = "();" + NL + "  int ";
  protected final String TEXT_235 = "();" + NL + "  bool ";
  protected final String TEXT_236 = "();" + NL + "  int ";
  protected final String TEXT_237 = "(";
  protected final String TEXT_238 = " ";
  protected final String TEXT_239 = ");";
  protected final String TEXT_240 = "UNABLE TO UNDERSAND association variable (see header_association_Get_All.jet)";
  protected final String TEXT_241 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_242 = " : ";
  protected final String TEXT_243 = NL + "  bool ";
  protected final String TEXT_244 = "();";
  protected final String TEXT_245 = NL + "  static int ";
  protected final String TEXT_246 = "();";
  protected final String TEXT_247 = NL + "  static int ";
  protected final String TEXT_248 = "();";
  protected final String TEXT_249 = NL + "static int ";
  protected final String TEXT_250 = "();";
  protected final String TEXT_251 = NL + "  bool ";
  protected final String TEXT_252 = "(";
  protected final String TEXT_253 = " ";
  protected final String TEXT_254 = ");";
  protected final String TEXT_255 = NL + "  bool ";
  protected final String TEXT_256 = "(";
  protected final String TEXT_257 = " ";
  protected final String TEXT_258 = ");";
  protected final String TEXT_259 = NL + "  bool ";
  protected final String TEXT_260 = "(";
  protected final String TEXT_261 = " ";
  protected final String TEXT_262 = ");";
  protected final String TEXT_263 = NL + "  bool ";
  protected final String TEXT_264 = "(";
  protected final String TEXT_265 = " ";
  protected final String TEXT_266 = ");";
  protected final String TEXT_267 = NL + "  bool ";
  protected final String TEXT_268 = "(";
  protected final String TEXT_269 = " ";
  protected final String TEXT_270 = ");";
  protected final String TEXT_271 = NL + "  bool ";
  protected final String TEXT_272 = "(";
  protected final String TEXT_273 = " ";
  protected final String TEXT_274 = ");";
  protected final String TEXT_275 = NL + "  bool ";
  protected final String TEXT_276 = "(";
  protected final String TEXT_277 = " ";
  protected final String TEXT_278 = ");";
  protected final String TEXT_279 = NL + "  ";
  protected final String TEXT_280 = " ";
  protected final String TEXT_281 = "(";
  protected final String TEXT_282 = ");" + NL + "  bool ";
  protected final String TEXT_283 = "(";
  protected final String TEXT_284 = " ";
  protected final String TEXT_285 = ");" + NL + "  bool ";
  protected final String TEXT_286 = "(";
  protected final String TEXT_287 = " ";
  protected final String TEXT_288 = ");";
  protected final String TEXT_289 = NL + "  ";
  protected final String TEXT_290 = " ";
  protected final String TEXT_291 = "(";
  protected final String TEXT_292 = ");" + NL + "  bool ";
  protected final String TEXT_293 = "(";
  protected final String TEXT_294 = " ";
  protected final String TEXT_295 = ");" + NL + "  bool ";
  protected final String TEXT_296 = "(";
  protected final String TEXT_297 = " ";
  protected final String TEXT_298 = ");";
  protected final String TEXT_299 = NL + "  bool ";
  protected final String TEXT_300 = "(";
  protected final String TEXT_301 = "... ";
  protected final String TEXT_302 = ");";
  protected final String TEXT_303 = NL + "  ";
  protected final String TEXT_304 = " ";
  protected final String TEXT_305 = "(";
  protected final String TEXT_306 = ");" + NL + "  bool ";
  protected final String TEXT_307 = "(";
  protected final String TEXT_308 = " ";
  protected final String TEXT_309 = ");" + NL + "  bool ";
  protected final String TEXT_310 = "(";
  protected final String TEXT_311 = " ";
  protected final String TEXT_312 = ");";
  protected final String TEXT_313 = NL + "  bool ";
  protected final String TEXT_314 = "(";
  protected final String TEXT_315 = " ";
  protected final String TEXT_316 = ");";
  protected final String TEXT_317 = NL + "  bool ";
  protected final String TEXT_318 = "(";
  protected final String TEXT_319 = " ";
  protected final String TEXT_320 = ");";
  protected final String TEXT_321 = NL + "  bool ";
  protected final String TEXT_322 = "(";
  protected final String TEXT_323 = " ";
  protected final String TEXT_324 = ");";
  protected final String TEXT_325 = NL + "  bool ";
  protected final String TEXT_326 = "(";
  protected final String TEXT_327 = "... ";
  protected final String TEXT_328 = ");";
  protected final String TEXT_329 = NL + "  void ";
  protected final String TEXT_330 = "::";
  protected final String TEXT_331 = "(";
  protected final String TEXT_332 = " ";
  protected final String TEXT_333 = ", ";
  protected final String TEXT_334 = " ";
  protected final String TEXT_335 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_336 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_337 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_338 = ", ";
  protected final String TEXT_339 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_340 = " to ";
  protected final String TEXT_341 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_342 = NL + "  bool ";
  protected final String TEXT_343 = "(";
  protected final String TEXT_344 = " ";
  protected final String TEXT_345 = ");";
  protected final String TEXT_346 = NL + "  bool ";
  protected final String TEXT_347 = "(";
  protected final String TEXT_348 = " ";
  protected final String TEXT_349 = ");";
  protected final String TEXT_350 = NL + "  bool ";
  protected final String TEXT_351 = "(";
  protected final String TEXT_352 = " ";
  protected final String TEXT_353 = ");";
  protected final String TEXT_354 = NL + "  bool ";
  protected final String TEXT_355 = "(";
  protected final String TEXT_356 = " ";
  protected final String TEXT_357 = ");" + NL + "  bool ";
  protected final String TEXT_358 = "(";
  protected final String TEXT_359 = " ";
  protected final String TEXT_360 = ");";
  protected final String TEXT_361 = NL + "  bool ";
  protected final String TEXT_362 = "(";
  protected final String TEXT_363 = " ";
  protected final String TEXT_364 = ");";
  protected final String TEXT_365 = NL + "  bool ";
  protected final String TEXT_366 = "(";
  protected final String TEXT_367 = " ";
  protected final String TEXT_368 = ");" + NL + "  bool ";
  protected final String TEXT_369 = "(";
  protected final String TEXT_370 = " ";
  protected final String TEXT_371 = ");";
  protected final String TEXT_372 = NL + "  bool ";
  protected final String TEXT_373 = "(";
  protected final String TEXT_374 = " ";
  protected final String TEXT_375 = ");" + NL + "  bool ";
  protected final String TEXT_376 = "(";
  protected final String TEXT_377 = " ";
  protected final String TEXT_378 = ");";
  protected final String TEXT_379 = NL + "  bool ";
  protected final String TEXT_380 = "(";
  protected final String TEXT_381 = " ";
  protected final String TEXT_382 = ");" + NL + "  bool ";
  protected final String TEXT_383 = "(";
  protected final String TEXT_384 = " ";
  protected final String TEXT_385 = ");";
  protected final String TEXT_386 = NL + "  bool ";
  protected final String TEXT_387 = "(";
  protected final String TEXT_388 = "... ";
  protected final String TEXT_389 = ");";
  protected final String TEXT_390 = NL + "  void ";
  protected final String TEXT_391 = "::";
  protected final String TEXT_392 = "(";
  protected final String TEXT_393 = " ";
  protected final String TEXT_394 = ", ";
  protected final String TEXT_395 = " ";
  protected final String TEXT_396 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_397 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_398 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_399 = ", ";
  protected final String TEXT_400 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_401 = " to ";
  protected final String TEXT_402 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_403 = NL + "  bool ";
  protected final String TEXT_404 = "(";
  protected final String TEXT_405 = " ";
  protected final String TEXT_406 = ");" + NL + "  bool ";
  protected final String TEXT_407 = "(";
  protected final String TEXT_408 = " ";
  protected final String TEXT_409 = ");";
  protected final String TEXT_410 = NL + "  bool ";
  protected final String TEXT_411 = "(";
  protected final String TEXT_412 = " ";
  protected final String TEXT_413 = ");" + NL + "  bool ";
  protected final String TEXT_414 = "(";
  protected final String TEXT_415 = " ";
  protected final String TEXT_416 = ");";
  protected final String TEXT_417 = NL + "  bool ";
  protected final String TEXT_418 = "(";
  protected final String TEXT_419 = " ";
  protected final String TEXT_420 = ");" + NL + "  bool ";
  protected final String TEXT_421 = "(";
  protected final String TEXT_422 = " ";
  protected final String TEXT_423 = ");";
  protected final String TEXT_424 = NL + "  bool ";
  protected final String TEXT_425 = "(";
  protected final String TEXT_426 = "... ";
  protected final String TEXT_427 = ");";
  protected final String TEXT_428 = NL + "  bool ";
  protected final String TEXT_429 = "(";
  protected final String TEXT_430 = "... ";
  protected final String TEXT_431 = ");";
  protected final String TEXT_432 = NL + "  bool ";
  protected final String TEXT_433 = "(";
  protected final String TEXT_434 = "... ";
  protected final String TEXT_435 = ");";
  protected final String TEXT_436 = NL + "  bool ";
  protected final String TEXT_437 = "(";
  protected final String TEXT_438 = "... ";
  protected final String TEXT_439 = ");";
  protected final String TEXT_440 = NL + "  bool ";
  protected final String TEXT_441 = "(";
  protected final String TEXT_442 = "... ";
  protected final String TEXT_443 = ");";
  protected final String TEXT_444 = NL + "  bool ";
  protected final String TEXT_445 = "(";
  protected final String TEXT_446 = "... ";
  protected final String TEXT_447 = ");";
  protected final String TEXT_448 = NL + "  bool ";
  protected final String TEXT_449 = "(";
  protected final String TEXT_450 = "... ";
  protected final String TEXT_451 = ");";
  protected final String TEXT_452 = NL + "  public boolean equals(Object obj)" + NL + "  {" + NL + "    if (obj == null) { return false; }" + NL + "    if (!getClass().equals(obj.getClass())) { return false; }" + NL;
  protected final String TEXT_453 = NL + "    ";
  protected final String TEXT_454 = " compareTo = (";
  protected final String TEXT_455 = ")obj;" + NL + "  ";
  protected final String TEXT_456 = NL + "    ";
  protected final String TEXT_457 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_458 = NL + "    ";
  protected final String TEXT_459 = NL;
  protected final String TEXT_460 = NL + "    ";
  protected final String TEXT_461 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_462 = NL + "  private void ";
  protected final String TEXT_463 = "()" + NL + "  {" + NL + "     try" + NL + "     {";
  protected final String TEXT_464 = NL + "       ";
  protected final String TEXT_465 = NL + "     }" + NL + "     catch (InterruptedException e)" + NL + "     {" + NL + " " + NL + "     }" + NL + "  }" + NL;
  protected final String TEXT_466 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_467 = NL + "    ";
  protected final String TEXT_468 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_469 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_470 = NL + "      ";
  protected final String TEXT_471 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_472 = NL + "  private void ";
  protected final String TEXT_473 = "()" + NL + "  {";
  protected final String TEXT_474 = NL + "    ";
  protected final String TEXT_475 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_476 = "\",";
  protected final String TEXT_477 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_478 = "()" + NL + "  {";
  protected final String TEXT_479 = NL + "    ";
  protected final String TEXT_480 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_481 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_482 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_483 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void run ()" + NL + "    {";
  protected final String TEXT_484 = NL + "      if (\"";
  protected final String TEXT_485 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_486 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_487 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_488 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_489 = NL + "    ";
  protected final String TEXT_490 = " = null;";
  protected final String TEXT_491 = NL + "    ";
  protected final String TEXT_492 = ".clear();";
  protected final String TEXT_493 = NL + "    ";
  protected final String TEXT_494 = " ";
  protected final String TEXT_495 = " = ";
  protected final String TEXT_496 = ";";
  protected final String TEXT_497 = NL + "    ";
  protected final String TEXT_498 = " = null;" + NL + "    if (";
  protected final String TEXT_499 = " != null)" + NL + "    {";
  protected final String TEXT_500 = NL + "      ";
  protected final String TEXT_501 = ".delete();" + NL + "    }";
  protected final String TEXT_502 = NL + "    if (";
  protected final String TEXT_503 = " != null)" + NL + "    {";
  protected final String TEXT_504 = NL + "      ";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = "(null);" + NL + "    }";
  protected final String TEXT_507 = NL + "    ";
  protected final String TEXT_508 = " ";
  protected final String TEXT_509 = " = ";
  protected final String TEXT_510 = ";";
  protected final String TEXT_511 = NL + "    ";
  protected final String TEXT_512 = " = null;" + NL + "    if (";
  protected final String TEXT_513 = " != null)" + NL + "    {";
  protected final String TEXT_514 = NL + "      ";
  protected final String TEXT_515 = ".";
  protected final String TEXT_516 = "(null);" + NL + "    }";
  protected final String TEXT_517 = NL + "    ";
  protected final String TEXT_518 = " ";
  protected final String TEXT_519 = " = ";
  protected final String TEXT_520 = ";";
  protected final String TEXT_521 = NL + "    ";
  protected final String TEXT_522 = " = null;" + NL + "    if (";
  protected final String TEXT_523 = " != null)" + NL + "    {";
  protected final String TEXT_524 = NL + "      ";
  protected final String TEXT_525 = ".delete();" + NL + "    }";
  protected final String TEXT_526 = NL + "    if (";
  protected final String TEXT_527 = " != null)" + NL + "    {";
  protected final String TEXT_528 = NL + "      ";
  protected final String TEXT_529 = " ";
  protected final String TEXT_530 = " = ";
  protected final String TEXT_531 = ";" + NL + "      this.";
  protected final String TEXT_532 = " = null;";
  protected final String TEXT_533 = NL + "      ";
  protected final String TEXT_534 = ".";
  protected final String TEXT_535 = "(this);" + NL + "    }";
  protected final String TEXT_536 = NL + "    if (";
  protected final String TEXT_537 = " != null)" + NL + "    {";
  protected final String TEXT_538 = NL + "      ";
  protected final String TEXT_539 = ".delete();" + NL + "    }";
  protected final String TEXT_540 = NL + "    if (";
  protected final String TEXT_541 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_542 = ".";
  protected final String TEXT_543 = "() <= ";
  protected final String TEXT_544 = ")" + NL + "      {";
  protected final String TEXT_545 = NL + "        ";
  protected final String TEXT_546 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_547 = NL + "        ";
  protected final String TEXT_548 = " ";
  protected final String TEXT_549 = " = ";
  protected final String TEXT_550 = ";" + NL + "        this.";
  protected final String TEXT_551 = " = null;";
  protected final String TEXT_552 = NL + "        ";
  protected final String TEXT_553 = ".";
  protected final String TEXT_554 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_555 = NL + "    ";
  protected final String TEXT_556 = " ";
  protected final String TEXT_557 = " = ";
  protected final String TEXT_558 = ";" + NL + "    this.";
  protected final String TEXT_559 = " = null;";
  protected final String TEXT_560 = NL + "    ";
  protected final String TEXT_561 = ".";
  protected final String TEXT_562 = "(this);";
  protected final String TEXT_563 = NL + "    for(";
  protected final String TEXT_564 = " ";
  protected final String TEXT_565 = " : ";
  protected final String TEXT_566 = ")" + NL + "    {";
  protected final String TEXT_567 = NL + "      ";
  protected final String TEXT_568 = "(";
  protected final String TEXT_569 = ",null);" + NL + "    }";
  protected final String TEXT_570 = NL + "    ";
  protected final String TEXT_571 = ".clear();";
  protected final String TEXT_572 = NL + "    ArrayList<";
  protected final String TEXT_573 = "> ";
  protected final String TEXT_574 = " = new ArrayList<";
  protected final String TEXT_575 = ">(";
  protected final String TEXT_576 = ");";
  protected final String TEXT_577 = NL + "    ";
  protected final String TEXT_578 = ".clear();" + NL + "    for(";
  protected final String TEXT_579 = " ";
  protected final String TEXT_580 = " : ";
  protected final String TEXT_581 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_582 = ".";
  protected final String TEXT_583 = "() <= ";
  protected final String TEXT_584 = ".";
  protected final String TEXT_585 = "())" + NL + "      {";
  protected final String TEXT_586 = NL + "        ";
  protected final String TEXT_587 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_588 = NL + "        ";
  protected final String TEXT_589 = ".";
  protected final String TEXT_590 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_591 = NL + "    ArrayList<";
  protected final String TEXT_592 = "> ";
  protected final String TEXT_593 = " = new ArrayList<";
  protected final String TEXT_594 = ">(";
  protected final String TEXT_595 = ");";
  protected final String TEXT_596 = NL + "    ";
  protected final String TEXT_597 = ".clear();" + NL + "    for(";
  protected final String TEXT_598 = " ";
  protected final String TEXT_599 = " : ";
  protected final String TEXT_600 = ")" + NL + "    {";
  protected final String TEXT_601 = NL + "      ";
  protected final String TEXT_602 = ".";
  protected final String TEXT_603 = "(this);" + NL + "    }";
  protected final String TEXT_604 = NL + "    for(";
  protected final String TEXT_605 = " ";
  protected final String TEXT_606 = " : ";
  protected final String TEXT_607 = ")" + NL + "    {";
  protected final String TEXT_608 = NL + "      ";
  protected final String TEXT_609 = ".delete();" + NL + "    }";
  protected final String TEXT_610 = NL + "    for(";
  protected final String TEXT_611 = " ";
  protected final String TEXT_612 = " : ";
  protected final String TEXT_613 = ")" + NL + "    {";
  protected final String TEXT_614 = NL + "      ";
  protected final String TEXT_615 = ".";
  protected final String TEXT_616 = "(null);" + NL + "    }";
  protected final String TEXT_617 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_618 = NL + "  ";
  protected final String TEXT_619 = NL + "};" + NL + "" + NL + "#endif";

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

    stringBuffer.append(TEXT_3);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_5);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).isInline) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(stringBuffer, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(uClass.getName());
    stringBuffer.append( gen.translate("isA",uClass) );
    stringBuffer.append(TEXT_7);
    
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

    stringBuffer.append(TEXT_8);
    
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
      
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_11);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_13);
     
    }
    else if ("immutable".equals(av.getModifier()) && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_14);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_15);
    
    }
    else if ("immutable".equals(av.getModifier()))
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_16);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_20);
     
    }
    else
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_21);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_23);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_24);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_26);
    
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
        
    stringBuffer.append(TEXT_27);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_31);
    
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
  

    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_41);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_42);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_44);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_53);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_56);
    
    }
    else if (av.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_63);
    
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
  

    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_73);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_78);
    
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
    
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_82);
    
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_87);
    
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
    
    stringBuffer.append(TEXT_88);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_90);
    
  }

    
  if (isOneToOne)
  {
    
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_91);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_93);
    
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
    
    if ("immutable".equals(av.getModifier()))
    {
      if (av.getIsLazy())
      {
        
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_128);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_129);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_133);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_140);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_141);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_144);
    
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
      
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_155);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_158);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_160);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_161);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_163);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_164);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_166);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_167);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_168);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_170);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_173);
    
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
        
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_175);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_176);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_178);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_179);
    
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

    stringBuffer.append(TEXT_180);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_183);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_184);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_187);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_188);
    
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

    stringBuffer.append(TEXT_189);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(TEXT_191);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_192);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_194);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(TEXT_197);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_198);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_199);
    
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
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_201);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(TEXT_203);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_204);
     } 
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_206);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(TEXT_209);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_211);
     if (parentState != null) { 
    stringBuffer.append(TEXT_212);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_213);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_215);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_217);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_219);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_221);
     } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_222);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(TEXT_224);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_225);
     } 
    stringBuffer.append(TEXT_226);
    
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
      
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_229);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_230);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_239);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_240);
    
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
    else if (av.isOptionalOne() && relatedAssociation.isMandatory())
    {
      //ignore
    }
    else
    {
      
    stringBuffer.append(TEXT_241);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(relatedAssociation);
    
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_243);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_244);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

    stringBuffer.append(TEXT_245);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_246);
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_247);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_248);
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_250);
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_254);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_258);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "header_association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_262);
    
    }
    else if (includeFile == "header_association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_263);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_266);
    
    }
    else if (includeFile == "header_association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_267);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_270);
    
    }
    else if (includeFile == "header_association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_274);
    
    }
    else if (includeFile == "header_association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_278);
    
    }
    else if (includeFile == "header_association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_279);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_288);
    
    }
    else if (includeFile == "header_association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_298);
    
    }
    else if (includeFile == "header_association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_302);
    
    }
    else if (includeFile == "header_association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_303);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_312);
    
    }
    else if (includeFile == "header_association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_313);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_316);
    
    }
    else if (includeFile == "header_association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_320);
    
    }
    else if (includeFile == "header_association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_324);
    
    }
    else if (includeFile == "header_association_SetOptionalOneToOptionalN.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_341);
    
    }
    else if (includeFile == "header_association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_345);
    
    }
    else if (includeFile == "header_association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_349);
    
    }
    else if (includeFile == "header_association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_350);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_353);
    
    }
    else if (includeFile == "header_association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_360);
    
    }
    else if (includeFile == "header_association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_364);
    
    }
    else if (includeFile == "header_association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_371);
    
    }
    else if (includeFile == "header_association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_372);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_378);
    
    }
    else if (includeFile == "header_association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_385);
    
    }
    else if (includeFile == "header_association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_402);
    
    }
    else if (includeFile == "header_association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_409);
    
    }
    else if (includeFile == "header_association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_410);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_416);
    
    }
    else if (includeFile == "header_association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_423);
    
    }
    else if (includeFile == "header_association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_427);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "header_association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_431);
    
    }
    else if (includeFile2 == "header_association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_435);
    
    }
    else if (includeFile2 == "header_association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_439);
    
    }
    else if (includeFile2 == "header_association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_441);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_443);
    
    }
    else if (includeFile2 == "header_association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_447);
    
    }
    else if (includeFile2 == "header_association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_451);
    
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


    stringBuffer.append(TEXT_452);
    stringBuffer.append(TEXT_453);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_454);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(TEXT_456);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(TEXT_458);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(TEXT_460);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_461);
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
        
    stringBuffer.append(TEXT_462);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(TEXT_464);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_465);
    
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

    stringBuffer.append(TEXT_466);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(TEXT_470);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_471);
    
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
        
    stringBuffer.append(TEXT_472);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(TEXT_474);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_475);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_476);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(TEXT_479);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_480);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_481);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_482);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_483);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_484);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_485);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_486);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_487);
    
      }
    }
  }

    stringBuffer.append(TEXT_488);
    
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
        
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_490);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_492);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_501);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_506);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_516);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_525);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_535);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_539);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_544);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_554);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_562);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_571);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_590);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_603);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_609);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_616);
    
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
    			append(stringBuffer, "  {0} {1} {2}({3});", methodModifier, methodType, methodName, finalParams);	
    	
    			
    		}
    		else{
    			appendln(stringBuffer, "");
    			appendln(stringBuffer,override);
    			append(stringBuffer, "  {0} {1} {2}();", methodModifier, methodType, methodName);
    		 
    		}
    	}
    }

     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_617);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_619);
    return stringBuffer.toString();
  }
}