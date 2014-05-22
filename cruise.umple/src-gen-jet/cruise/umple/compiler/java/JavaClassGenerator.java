package cruise.umple.compiler.java;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class JavaClassGenerator implements ILang 
{

  protected static String nl;
  public static synchronized JavaClassGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    JavaClassGenerator result = new JavaClassGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE ${last.version} modeling language!*/";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "// line ";
  protected final String TEXT_6 = " \"";
  protected final String TEXT_7 = "\"";
  protected final String TEXT_8 = NL + "public ";
  protected final String TEXT_9 = "class ";
  protected final String TEXT_10 = NL + "{";
  protected final String TEXT_11 = NL + NL + "  //------------------------" + NL + "  // CONSTRUCTOR" + NL + "  //------------------------" + NL;
  protected final String TEXT_12 = NL + "    ";
  protected final String TEXT_13 = " = new ArrayList<";
  protected final String TEXT_14 = ">();";
  protected final String TEXT_15 = NL + "    ";
  protected final String TEXT_16 = "();";
  protected final String TEXT_17 = NL + "    ";
  protected final String TEXT_18 = " = true;";
  protected final String TEXT_19 = NL + "    ";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";";
  protected final String TEXT_22 = NL + "    ";
  protected final String TEXT_23 = " = false;";
  protected final String TEXT_24 = NL + "    ";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "    ";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ";";
  protected final String TEXT_30 = NL + "    ( new Thread()" + NL + "    {" + NL + "      Thread thread;" + NL + "      {" + NL + "        thread = Thread.currentThread();" + NL + "      }" + NL + "      public void run()" + NL + "      {" + NL + "        while( thread.isAlive() )" + NL + "        {";
  protected final String TEXT_31 = NL + "          ";
  protected final String TEXT_32 = NL + "          try" + NL + "          {" + NL + "            Thread.sleep(";
  protected final String TEXT_33 = ");" + NL + "          }" + NL + "          catch (InterruptedException e)" + NL + "          {" + NL + "            e.printStackTrace();" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    ).start();";
  protected final String TEXT_34 = NL + "    ";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = "++;";
  protected final String TEXT_37 = NL + "    if (!";
  protected final String TEXT_38 = "(";
  protected final String TEXT_39 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Cannot create due to duplicate ";
  protected final String TEXT_40 = "\");" + NL + "    }";
  protected final String TEXT_41 = NL + "    if (!";
  protected final String TEXT_42 = "(";
  protected final String TEXT_43 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_44 = " due to ";
  protected final String TEXT_45 = "\");" + NL + "    }";
  protected final String TEXT_46 = NL + "    ";
  protected final String TEXT_47 = " = new ArrayList<";
  protected final String TEXT_48 = ">();" + NL + "    boolean ";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = "(";
  protected final String TEXT_51 = ");" + NL + "    if (!";
  protected final String TEXT_52 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_53 = ", must have ";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = "\");" + NL + "    }";
  protected final String TEXT_56 = NL + "    ";
  protected final String TEXT_57 = " = new ArrayList<";
  protected final String TEXT_58 = ">();" + NL + "    boolean ";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = "(";
  protected final String TEXT_61 = ");" + NL + "    if (!";
  protected final String TEXT_62 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_63 = ", must have ";
  protected final String TEXT_64 = " or fewer ";
  protected final String TEXT_65 = ", no duplicates.\");" + NL + "    }";
  protected final String TEXT_66 = NL + "    ";
  protected final String TEXT_67 = " = new ArrayList<";
  protected final String TEXT_68 = ">();" + NL + "    boolean ";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = "(";
  protected final String TEXT_71 = ");" + NL + "    if (!";
  protected final String TEXT_72 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_73 = ", must not have duplicate ";
  protected final String TEXT_74 = ".\");" + NL + "    }";
  protected final String TEXT_75 = NL + "    ";
  protected final String TEXT_76 = " = new ArrayList<";
  protected final String TEXT_77 = ">();";
  protected final String TEXT_78 = NL + "    if (";
  protected final String TEXT_79 = " == null || ";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = "() != null)" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_82 = " due to ";
  protected final String TEXT_83 = "\");" + NL + "    }";
  protected final String TEXT_84 = NL + "    ";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";";
  protected final String TEXT_87 = NL + "    ";
  protected final String TEXT_88 = " = new ArrayList<";
  protected final String TEXT_89 = ">();";
  protected final String TEXT_90 = NL + "    boolean ";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = "(";
  protected final String TEXT_93 = ");" + NL + "    if (!";
  protected final String TEXT_94 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_95 = " due to ";
  protected final String TEXT_96 = "\");" + NL + "    }";
  protected final String TEXT_97 = NL + "    ";
  protected final String TEXT_98 = " = new ArrayList<";
  protected final String TEXT_99 = ">();" + NL + "    boolean ";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = "(";
  protected final String TEXT_102 = ");" + NL + "    if (!";
  protected final String TEXT_103 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_104 = ", must have ";
  protected final String TEXT_105 = " ";
  protected final String TEXT_106 = "\");" + NL + "    }";
  protected final String TEXT_107 = " = new ArrayList<";
  protected final String TEXT_108 = ">();";
  protected final String TEXT_109 = NL + "    ";
  protected final String TEXT_110 = ".add(";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "    ";
  protected final String TEXT_113 = "(";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "    ";
  protected final String TEXT_117 = "HStar = ";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = ";";
  protected final String TEXT_120 = NL + "    ";
  protected final String TEXT_121 = "H = ";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = ";";
  protected final String TEXT_124 = NL + "    ";
  protected final String TEXT_125 = "(";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = ");";
  protected final String TEXT_128 = NL + "  public static ";
  protected final String TEXT_129 = " getInstance()" + NL + "  {" + NL + "    if(theInstance == null)" + NL + "    {" + NL + "      theInstance = new ";
  protected final String TEXT_130 = "();" + NL + "    }" + NL + "    return theInstance;" + NL + "  }";
  protected final String TEXT_131 = NL + NL + "  public ";
  protected final String TEXT_132 = "(";
  protected final String TEXT_133 = ")" + NL + "  {";
  protected final String TEXT_134 = NL + "    ";
  protected final String TEXT_135 = " = new ArrayList<";
  protected final String TEXT_136 = ">();";
  protected final String TEXT_137 = NL + "    ";
  protected final String TEXT_138 = "();";
  protected final String TEXT_139 = NL + "    ";
  protected final String TEXT_140 = " = ";
  protected final String TEXT_141 = ";";
  protected final String TEXT_142 = NL + "    ";
  protected final String TEXT_143 = " = ";
  protected final String TEXT_144 = ";";
  protected final String TEXT_145 = NL + "    ";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = "++;";
  protected final String TEXT_148 = NL + "    ";
  protected final String TEXT_149 = " = new ";
  protected final String TEXT_150 = "(";
  protected final String TEXT_151 = ");";
  protected final String TEXT_152 = NL + "    ";
  protected final String TEXT_153 = " = new ArrayList<";
  protected final String TEXT_154 = ">();";
  protected final String TEXT_155 = NL + "    boolean ";
  protected final String TEXT_156 = " = ";
  protected final String TEXT_157 = "(";
  protected final String TEXT_158 = ");" + NL + "    if (!";
  protected final String TEXT_159 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_160 = " due to ";
  protected final String TEXT_161 = "\");" + NL + "    }";
  protected final String TEXT_162 = NL + "    ";
  protected final String TEXT_163 = " = new ArrayList<";
  protected final String TEXT_164 = ">();" + NL + "    boolean ";
  protected final String TEXT_165 = " = ";
  protected final String TEXT_166 = "(";
  protected final String TEXT_167 = ");" + NL + "    if (!";
  protected final String TEXT_168 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_169 = ", must have ";
  protected final String TEXT_170 = " ";
  protected final String TEXT_171 = "\");" + NL + "    }";
  protected final String TEXT_172 = " = new ArrayList<";
  protected final String TEXT_173 = ">();";
  protected final String TEXT_174 = NL + "    ";
  protected final String TEXT_175 = ".add(";
  protected final String TEXT_176 = ");";
  protected final String TEXT_177 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_178 = NL + "  public boolean ";
  protected final String TEXT_179 = "(";
  protected final String TEXT_180 = " ";
  protected final String TEXT_181 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_182 = NL + "    ";
  protected final String TEXT_183 = " = false;";
  protected final String TEXT_184 = NL;
  protected final String TEXT_185 = "    ";
  protected final String TEXT_186 = " = ";
  protected final String TEXT_187 = ";";
  protected final String TEXT_188 = NL;
  protected final String TEXT_189 = "    wasSet = true;";
  protected final String TEXT_190 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_191 = NL + "  public boolean ";
  protected final String TEXT_192 = "(";
  protected final String TEXT_193 = " ";
  protected final String TEXT_194 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_195 = NL;
  protected final String TEXT_196 = "    ";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ";";
  protected final String TEXT_199 = NL;
  protected final String TEXT_200 = "    wasSet = true;";
  protected final String TEXT_201 = NL + "    return wasSet;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_202 = "()" + NL + "  {" + NL + "    boolean wasReset = false;";
  protected final String TEXT_203 = NL;
  protected final String TEXT_204 = "    ";
  protected final String TEXT_205 = " = ";
  protected final String TEXT_206 = "();";
  protected final String TEXT_207 = NL;
  protected final String TEXT_208 = "    wasReset = true;";
  protected final String TEXT_209 = NL + "    return wasReset;" + NL + "  }" + NL;
  protected final String TEXT_210 = NL + "  public boolean ";
  protected final String TEXT_211 = "(";
  protected final String TEXT_212 = " ";
  protected final String TEXT_213 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_214 = NL;
  protected final String TEXT_215 = "    wasAdded = ";
  protected final String TEXT_216 = ".add(";
  protected final String TEXT_217 = ");";
  protected final String TEXT_218 = NL;
  protected final String TEXT_219 = "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_220 = "(";
  protected final String TEXT_221 = " ";
  protected final String TEXT_222 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_223 = NL;
  protected final String TEXT_224 = "    wasRemoved = ";
  protected final String TEXT_225 = ".remove(";
  protected final String TEXT_226 = ");";
  protected final String TEXT_227 = NL;
  protected final String TEXT_228 = "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_229 = NL + "  public boolean ";
  protected final String TEXT_230 = "(";
  protected final String TEXT_231 = " ";
  protected final String TEXT_232 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_233 = NL;
  protected final String TEXT_234 = "    ";
  protected final String TEXT_235 = " = ";
  protected final String TEXT_236 = ";";
  protected final String TEXT_237 = NL;
  protected final String TEXT_238 = "    wasSet = true;";
  protected final String TEXT_239 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_240 = NL + "  public ";
  protected final String TEXT_241 = " ";
  protected final String TEXT_242 = "(int index)" + NL + "  {";
  protected final String TEXT_243 = NL + "    ";
  protected final String TEXT_244 = " ";
  protected final String TEXT_245 = " = ";
  protected final String TEXT_246 = ".get(index);";
  protected final String TEXT_247 = NL;
  protected final String TEXT_248 = "    return ";
  protected final String TEXT_249 = ";" + NL + "  }" + NL + "" + NL + "  public ";
  protected final String TEXT_250 = "[] ";
  protected final String TEXT_251 = "()" + NL + "  {";
  protected final String TEXT_252 = NL + "    ";
  protected final String TEXT_253 = "[] ";
  protected final String TEXT_254 = " = ";
  protected final String TEXT_255 = ".toArray(new ";
  protected final String TEXT_256 = "[";
  protected final String TEXT_257 = ".size()]);";
  protected final String TEXT_258 = NL;
  protected final String TEXT_259 = "    return ";
  protected final String TEXT_260 = ";" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_261 = "()" + NL + "  {";
  protected final String TEXT_262 = NL + "    int number = ";
  protected final String TEXT_263 = ".size();";
  protected final String TEXT_264 = NL;
  protected final String TEXT_265 = "    return number;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_266 = "()" + NL + "  {";
  protected final String TEXT_267 = NL + "    boolean has = ";
  protected final String TEXT_268 = ".size() > 0;";
  protected final String TEXT_269 = NL;
  protected final String TEXT_270 = "    return has;" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_271 = "(";
  protected final String TEXT_272 = " ";
  protected final String TEXT_273 = ")" + NL + "  {";
  protected final String TEXT_274 = NL + "    int index = ";
  protected final String TEXT_275 = ".indexOf(";
  protected final String TEXT_276 = ");";
  protected final String TEXT_277 = NL;
  protected final String TEXT_278 = "    return index;" + NL + "  }" + NL;
  protected final String TEXT_279 = NL + "  public ";
  protected final String TEXT_280 = " ";
  protected final String TEXT_281 = "()" + NL + "  {";
  protected final String TEXT_282 = NL + "    ";
  protected final String TEXT_283 = " ";
  protected final String TEXT_284 = " = ";
  protected final String TEXT_285 = ";";
  protected final String TEXT_286 = NL;
  protected final String TEXT_287 = "    return ";
  protected final String TEXT_288 = ";";
  protected final String TEXT_289 = NL + "  }";
  protected final String TEXT_290 = NL + "  public ";
  protected final String TEXT_291 = " ";
  protected final String TEXT_292 = "()" + NL + "  {";
  protected final String TEXT_293 = NL;
  protected final String TEXT_294 = "    return ";
  protected final String TEXT_295 = ";";
  protected final String TEXT_296 = NL + "  }";
  protected final String TEXT_297 = NL + "  public ";
  protected final String TEXT_298 = " ";
  protected final String TEXT_299 = "()" + NL + "  {";
  protected final String TEXT_300 = NL + "    ";
  protected final String TEXT_301 = " ";
  protected final String TEXT_302 = " = ";
  protected final String TEXT_303 = ";";
  protected final String TEXT_304 = NL;
  protected final String TEXT_305 = "    return ";
  protected final String TEXT_306 = ";" + NL + "  }";
  protected final String TEXT_307 = NL + "  public ";
  protected final String TEXT_308 = " ";
  protected final String TEXT_309 = "()" + NL + "  {";
  protected final String TEXT_310 = NL;
  protected final String TEXT_311 = "    return ";
  protected final String TEXT_312 = ";" + NL + "  }";
  protected final String TEXT_313 = NL + "  public ";
  protected final String TEXT_314 = " ";
  protected final String TEXT_315 = "()" + NL + "  {";
  protected final String TEXT_316 = NL + "    ";
  protected final String TEXT_317 = " ";
  protected final String TEXT_318 = " = ";
  protected final String TEXT_319 = ";";
  protected final String TEXT_320 = NL;
  protected final String TEXT_321 = "    return ";
  protected final String TEXT_322 = ";" + NL + "  }" + NL;
  protected final String TEXT_323 = NL + "  public ";
  protected final String TEXT_324 = " ";
  protected final String TEXT_325 = "()" + NL + "  {";
  protected final String TEXT_326 = NL;
  protected final String TEXT_327 = "    return ";
  protected final String TEXT_328 = ";" + NL + "  }" + NL;
  protected final String TEXT_329 = NL + "  public static ";
  protected final String TEXT_330 = " ";
  protected final String TEXT_331 = "(";
  protected final String TEXT_332 = " ";
  protected final String TEXT_333 = ")" + NL + "  {";
  protected final String TEXT_334 = NL + "    ";
  protected final String TEXT_335 = " ";
  protected final String TEXT_336 = " = ";
  protected final String TEXT_337 = ".get(";
  protected final String TEXT_338 = ");";
  protected final String TEXT_339 = NL;
  protected final String TEXT_340 = "    return ";
  protected final String TEXT_341 = ";" + NL + "  }" + NL;
  protected final String TEXT_342 = NL + "  public static ";
  protected final String TEXT_343 = " ";
  protected final String TEXT_344 = "(";
  protected final String TEXT_345 = " ";
  protected final String TEXT_346 = ")" + NL + "  {";
  protected final String TEXT_347 = NL;
  protected final String TEXT_348 = "    return ";
  protected final String TEXT_349 = ".get(";
  protected final String TEXT_350 = ");" + NL + "  }" + NL;
  protected final String TEXT_351 = NL + "  public static boolean ";
  protected final String TEXT_352 = "(";
  protected final String TEXT_353 = " ";
  protected final String TEXT_354 = ")" + NL + "  {";
  protected final String TEXT_355 = NL + "    boolean ";
  protected final String TEXT_356 = " = ";
  protected final String TEXT_357 = "(";
  protected final String TEXT_358 = ") != null;";
  protected final String TEXT_359 = NL;
  protected final String TEXT_360 = "    return ";
  protected final String TEXT_361 = ";" + NL + "  }" + NL;
  protected final String TEXT_362 = NL + "  public static boolean ";
  protected final String TEXT_363 = "(";
  protected final String TEXT_364 = " ";
  protected final String TEXT_365 = ")" + NL + "  {";
  protected final String TEXT_366 = NL;
  protected final String TEXT_367 = "    return ";
  protected final String TEXT_368 = "(";
  protected final String TEXT_369 = ") != null;" + NL + "  }" + NL;
  protected final String TEXT_370 = NL + "  public ";
  protected final String TEXT_371 = " ";
  protected final String TEXT_372 = "()" + NL + "  {";
  protected final String TEXT_373 = NL + "    ";
  protected final String TEXT_374 = " ";
  protected final String TEXT_375 = " = ";
  protected final String TEXT_376 = ";";
  protected final String TEXT_377 = NL;
  protected final String TEXT_378 = "    return ";
  protected final String TEXT_379 = ";" + NL + "  }";
  protected final String TEXT_380 = NL + "  public ";
  protected final String TEXT_381 = " ";
  protected final String TEXT_382 = "()" + NL + "  {";
  protected final String TEXT_383 = NL;
  protected final String TEXT_384 = "    return ";
  protected final String TEXT_385 = ";" + NL + "  }";
  protected final String TEXT_386 = NL + "  public ";
  protected final String TEXT_387 = " ";
  protected final String TEXT_388 = "()" + NL + "  {";
  protected final String TEXT_389 = NL + "    ";
  protected final String TEXT_390 = " ";
  protected final String TEXT_391 = " = ";
  protected final String TEXT_392 = ";";
  protected final String TEXT_393 = NL;
  protected final String TEXT_394 = "    return ";
  protected final String TEXT_395 = ";" + NL + "  }";
  protected final String TEXT_396 = NL + "  public ";
  protected final String TEXT_397 = " ";
  protected final String TEXT_398 = "()" + NL + "  {";
  protected final String TEXT_399 = NL;
  protected final String TEXT_400 = "    return ";
  protected final String TEXT_401 = ";" + NL + "  }";
  protected final String TEXT_402 = NL + "  public ";
  protected final String TEXT_403 = " ";
  protected final String TEXT_404 = "()" + NL + "  {";
  protected final String TEXT_405 = NL + "    ";
  protected final String TEXT_406 = " ";
  protected final String TEXT_407 = " = ";
  protected final String TEXT_408 = ";";
  protected final String TEXT_409 = NL;
  protected final String TEXT_410 = "    return ";
  protected final String TEXT_411 = ";" + NL + "  }";
  protected final String TEXT_412 = NL + "  public ";
  protected final String TEXT_413 = " ";
  protected final String TEXT_414 = "()" + NL + "  {";
  protected final String TEXT_415 = NL;
  protected final String TEXT_416 = "    return ";
  protected final String TEXT_417 = ";" + NL + "  }";
  protected final String TEXT_418 = NL + "  public ";
  protected final String TEXT_419 = " ";
  protected final String TEXT_420 = "()" + NL + "  {" + NL + "    String answer = ";
  protected final String TEXT_421 = ".toString();";
  protected final String TEXT_422 = NL + "    return answer;" + NL + "  }" + NL;
  protected final String TEXT_423 = NL + "  public ";
  protected final String TEXT_424 = " ";
  protected final String TEXT_425 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_426 = ";" + NL + "  }" + NL;
  protected final String TEXT_427 = NL + "  ";
  protected final String TEXT_428 = " boolean ";
  protected final String TEXT_429 = "(";
  protected final String TEXT_430 = ")" + NL + "  {";
  protected final String TEXT_431 = NL + "    boolean wasEventProcessed = false;";
  protected final String TEXT_432 = NL + "    ";
  protected final String TEXT_433 = NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_434 = NL + "  public boolean ";
  protected final String TEXT_435 = "(";
  protected final String TEXT_436 = " ";
  protected final String TEXT_437 = ")" + NL + "  {";
  protected final String TEXT_438 = NL + "    ";
  protected final String TEXT_439 = " = ";
  protected final String TEXT_440 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_441 = NL + "  private void ";
  protected final String TEXT_442 = "()" + NL + "  {";
  protected final String TEXT_443 = NL + "    switch(";
  protected final String TEXT_444 = ")" + NL + "    {";
  protected final String TEXT_445 = NL + "      ";
  protected final String TEXT_446 = NL + "    }";
  protected final String TEXT_447 = NL + "  }" + NL;
  protected final String TEXT_448 = NL + "  private void ";
  protected final String TEXT_449 = "(";
  protected final String TEXT_450 = " ";
  protected final String TEXT_451 = ")" + NL + "  {";
  protected final String TEXT_452 = NL + "    ";
  protected final String TEXT_453 = " = ";
  protected final String TEXT_454 = ";";
  protected final String TEXT_455 = NL + "    if (";
  protected final String TEXT_456 = " != ";
  protected final String TEXT_457 = ".";
  protected final String TEXT_458 = " && ";
  protected final String TEXT_459 = " != ";
  protected final String TEXT_460 = ".";
  protected final String TEXT_461 = ") { ";
  protected final String TEXT_462 = "(";
  protected final String TEXT_463 = ".";
  protected final String TEXT_464 = "); }";
  protected final String TEXT_465 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_466 = ")" + NL + "    {";
  protected final String TEXT_467 = NL + "      ";
  protected final String TEXT_468 = NL + "    }";
  protected final String TEXT_469 = NL + "    if (";
  protected final String TEXT_470 = " == ";
  protected final String TEXT_471 = ".HStar) { ";
  protected final String TEXT_472 = " = ";
  protected final String TEXT_473 = "HStar;}";
  protected final String TEXT_474 = NL + "  }" + NL;
  protected final String TEXT_475 = NL + "  public ";
  protected final String TEXT_476 = " ";
  protected final String TEXT_477 = "()" + NL + "  {";
  protected final String TEXT_478 = NL + "    return ";
  protected final String TEXT_479 = ";";
  protected final String TEXT_480 = NL + "    ";
  protected final String TEXT_481 = " ";
  protected final String TEXT_482 = " = ";
  protected final String TEXT_483 = ";";
  protected final String TEXT_484 = NL + "    return ";
  protected final String TEXT_485 = ";";
  protected final String TEXT_486 = NL + "  }";
  protected final String TEXT_487 = NL + NL + "  public boolean ";
  protected final String TEXT_488 = "()" + NL + "  {" + NL + "    boolean has = ";
  protected final String TEXT_489 = " != null;" + NL + "    return has;" + NL + "  }";
  protected final String TEXT_490 = NL;
  protected final String TEXT_491 = NL + "  public ";
  protected final String TEXT_492 = " ";
  protected final String TEXT_493 = "(int index)" + NL + "  {";
  protected final String TEXT_494 = NL + "    ";
  protected final String TEXT_495 = " ";
  protected final String TEXT_496 = " = ";
  protected final String TEXT_497 = ".get(index);";
  protected final String TEXT_498 = NL + "    return ";
  protected final String TEXT_499 = ";" + NL + "  }" + NL;
  protected final String TEXT_500 = NL + "  public List<";
  protected final String TEXT_501 = "> ";
  protected final String TEXT_502 = "()" + NL + "  {";
  protected final String TEXT_503 = NL + "    List<";
  protected final String TEXT_504 = "> ";
  protected final String TEXT_505 = " = Collections.unmodifiableList(";
  protected final String TEXT_506 = ");";
  protected final String TEXT_507 = NL + "    return ";
  protected final String TEXT_508 = ";" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_509 = "()" + NL + "  {";
  protected final String TEXT_510 = NL + "    int number = ";
  protected final String TEXT_511 = ".size();";
  protected final String TEXT_512 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_513 = "()" + NL + "  {";
  protected final String TEXT_514 = NL + "    boolean has = ";
  protected final String TEXT_515 = ".size() > 0;";
  protected final String TEXT_516 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_517 = "(";
  protected final String TEXT_518 = " ";
  protected final String TEXT_519 = ")" + NL + "  {";
  protected final String TEXT_520 = NL + "    int index = ";
  protected final String TEXT_521 = ".indexOf(";
  protected final String TEXT_522 = ");";
  protected final String TEXT_523 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_524 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_525 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_526 = " : ";
  protected final String TEXT_527 = NL + "  public boolean ";
  protected final String TEXT_528 = "()" + NL + "  {";
  protected final String TEXT_529 = NL + "    boolean isValid = ";
  protected final String TEXT_530 = "() >= ";
  protected final String TEXT_531 = "();";
  protected final String TEXT_532 = NL + "    boolean isValid = ";
  protected final String TEXT_533 = "() >= ";
  protected final String TEXT_534 = "() && ";
  protected final String TEXT_535 = "() <= ";
  protected final String TEXT_536 = "();";
  protected final String TEXT_537 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_538 = NL + "  public static int ";
  protected final String TEXT_539 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_540 = ";" + NL + "  }";
  protected final String TEXT_541 = NL + "  public static int ";
  protected final String TEXT_542 = "()" + NL + "  {";
  protected final String TEXT_543 = NL + "    int required = ";
  protected final String TEXT_544 = ";";
  protected final String TEXT_545 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_546 = NL + "  public static int ";
  protected final String TEXT_547 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_548 = ";" + NL + "  }";
  protected final String TEXT_549 = NL + "  public static int ";
  protected final String TEXT_550 = "()" + NL + "  {";
  protected final String TEXT_551 = NL + "    int minimum = ";
  protected final String TEXT_552 = ";";
  protected final String TEXT_553 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_554 = NL + "  public static int ";
  protected final String TEXT_555 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_556 = ";" + NL + "  }";
  protected final String TEXT_557 = NL + "  public static int ";
  protected final String TEXT_558 = "()" + NL + "  {";
  protected final String TEXT_559 = NL + "    int maximum = ";
  protected final String TEXT_560 = ";";
  protected final String TEXT_561 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_562 = NL + "  public boolean ";
  protected final String TEXT_563 = "(";
  protected final String TEXT_564 = " ";
  protected final String TEXT_565 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_566 = NL + "    if (";
  protected final String TEXT_567 = "() >= ";
  protected final String TEXT_568 = "())" + NL + "    {";
  protected final String TEXT_569 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_570 = NL + "    ";
  protected final String TEXT_571 = ".add(";
  protected final String TEXT_572 = ");";
  protected final String TEXT_573 = NL + "    if (";
  protected final String TEXT_574 = ".";
  protected final String TEXT_575 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_576 = ".";
  protected final String TEXT_577 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_578 = NL + "        ";
  protected final String TEXT_579 = ".remove(";
  protected final String TEXT_580 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_581 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_582 = NL + "  public boolean ";
  protected final String TEXT_583 = "(";
  protected final String TEXT_584 = " ";
  protected final String TEXT_585 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_586 = NL + "    if (!";
  protected final String TEXT_587 = ".contains(";
  protected final String TEXT_588 = "))" + NL + "    {";
  protected final String TEXT_589 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_590 = ".indexOf(";
  protected final String TEXT_591 = ");";
  protected final String TEXT_592 = NL + "    ";
  protected final String TEXT_593 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_594 = ".";
  protected final String TEXT_595 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_596 = ".";
  protected final String TEXT_597 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_598 = NL + "        ";
  protected final String TEXT_599 = ".add(oldIndex,";
  protected final String TEXT_600 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_601 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_602 = NL + "  ";
  protected final String TEXT_603 = " boolean ";
  protected final String TEXT_604 = "(";
  protected final String TEXT_605 = " ";
  protected final String TEXT_606 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_607 = NL + "    ";
  protected final String TEXT_608 = " = ";
  protected final String TEXT_609 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_610 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_611 = NL + "  ";
  protected final String TEXT_612 = " boolean ";
  protected final String TEXT_613 = "(";
  protected final String TEXT_614 = " ";
  protected final String TEXT_615 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_616 = NL + "    if (";
  protected final String TEXT_617 = " != null)" + NL + "    {";
  protected final String TEXT_618 = NL + "      ";
  protected final String TEXT_619 = " = ";
  protected final String TEXT_620 = ";" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_621 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_622 = NL + "  public boolean ";
  protected final String TEXT_623 = "(";
  protected final String TEXT_624 = " ";
  protected final String TEXT_625 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_626 = NL + "    if (";
  protected final String TEXT_627 = " != null && !";
  protected final String TEXT_628 = ".equals(";
  protected final String TEXT_629 = ") && equals(";
  protected final String TEXT_630 = ".";
  protected final String TEXT_631 = "()))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_632 = ", as existing ";
  protected final String TEXT_633 = " would become an orphan";
  protected final String TEXT_634 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_635 = NL + "    ";
  protected final String TEXT_636 = " = ";
  protected final String TEXT_637 = ";";
  protected final String TEXT_638 = NL + "    ";
  protected final String TEXT_639 = " ";
  protected final String TEXT_640 = " = ";
  protected final String TEXT_641 = " != null ? ";
  protected final String TEXT_642 = ".";
  protected final String TEXT_643 = "() : null;" + NL + "" + NL + "    if (!this.equals(";
  protected final String TEXT_644 = "))" + NL + "    {" + NL + "      if (";
  protected final String TEXT_645 = " != null)" + NL + "      {";
  protected final String TEXT_646 = NL + "        ";
  protected final String TEXT_647 = ".";
  protected final String TEXT_648 = " = null;" + NL + "      }" + NL + "      if (";
  protected final String TEXT_649 = " != null)" + NL + "      {";
  protected final String TEXT_650 = NL + "        ";
  protected final String TEXT_651 = ".";
  protected final String TEXT_652 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_653 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_654 = NL + "  public boolean ";
  protected final String TEXT_655 = "(";
  protected final String TEXT_656 = " ";
  protected final String TEXT_657 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_658 = NL + "    if (";
  protected final String TEXT_659 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_660 = " to null, as ";
  protected final String TEXT_661 = " must always be associated to a ";
  protected final String TEXT_662 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_663 = NL + "    ";
  protected final String TEXT_664 = " ";
  protected final String TEXT_665 = " = ";
  protected final String TEXT_666 = ".";
  protected final String TEXT_667 = "();" + NL + "    if (";
  protected final String TEXT_668 = " != null && !equals(";
  protected final String TEXT_669 = "))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_670 = ", the current ";
  protected final String TEXT_671 = " already has a ";
  protected final String TEXT_672 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_673 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_674 = NL + "    ";
  protected final String TEXT_675 = " ";
  protected final String TEXT_676 = " = ";
  protected final String TEXT_677 = ";";
  protected final String TEXT_678 = NL + "    ";
  protected final String TEXT_679 = " = ";
  protected final String TEXT_680 = ";";
  protected final String TEXT_681 = NL + "    ";
  protected final String TEXT_682 = ".";
  protected final String TEXT_683 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_684 = " != null)" + NL + "    {";
  protected final String TEXT_685 = NL + "      ";
  protected final String TEXT_686 = ".";
  protected final String TEXT_687 = "(null);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_688 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_689 = NL + "  public ";
  protected final String TEXT_690 = " ";
  protected final String TEXT_691 = "(";
  protected final String TEXT_692 = ")" + NL + "  {";
  protected final String TEXT_693 = NL + "    ";
  protected final String TEXT_694 = " ";
  protected final String TEXT_695 = " = new ";
  protected final String TEXT_696 = "(";
  protected final String TEXT_697 = ");";
  protected final String TEXT_698 = NL + "    return ";
  protected final String TEXT_699 = ";" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_700 = "(";
  protected final String TEXT_701 = " ";
  protected final String TEXT_702 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_703 = NL + "    ";
  protected final String TEXT_704 = " ";
  protected final String TEXT_705 = " = ";
  protected final String TEXT_706 = ".";
  protected final String TEXT_707 = "();" + NL + "    boolean ";
  protected final String TEXT_708 = " = ";
  protected final String TEXT_709 = " != null && !this.equals(";
  protected final String TEXT_710 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_711 = " && ";
  protected final String TEXT_712 = ".";
  protected final String TEXT_713 = "() <= ";
  protected final String TEXT_714 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_715 = NL;
  protected final String TEXT_716 = NL + "    if (";
  protected final String TEXT_717 = ")" + NL + "    {";
  protected final String TEXT_718 = NL + "      ";
  protected final String TEXT_719 = ".";
  protected final String TEXT_720 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_721 = NL + "      ";
  protected final String TEXT_722 = ".add(";
  protected final String TEXT_723 = ");" + NL + "    }";
  protected final String TEXT_724 = NL + "    wasAdded = true;";
  protected final String TEXT_725 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_726 = "(";
  protected final String TEXT_727 = " ";
  protected final String TEXT_728 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_729 = NL + "    //Unable to remove ";
  protected final String TEXT_730 = ", as it must always have a ";
  protected final String TEXT_731 = NL + "    if (this.equals(";
  protected final String TEXT_732 = ".";
  protected final String TEXT_733 = "()))" + NL + "    {";
  protected final String TEXT_734 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_735 = " already at minimum (";
  protected final String TEXT_736 = ")" + NL + "    if (";
  protected final String TEXT_737 = "() <= ";
  protected final String TEXT_738 = "())" + NL + "    {";
  protected final String TEXT_739 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_740 = NL;
  protected final String TEXT_741 = NL + "    ";
  protected final String TEXT_742 = ".remove(";
  protected final String TEXT_743 = ");";
  protected final String TEXT_744 = NL + "    wasRemoved = true;";
  protected final String TEXT_745 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_746 = NL + "  public ";
  protected final String TEXT_747 = " ";
  protected final String TEXT_748 = "(";
  protected final String TEXT_749 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_750 = "() >= ";
  protected final String TEXT_751 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_752 = "(";
  protected final String TEXT_753 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_754 = "(";
  protected final String TEXT_755 = " ";
  protected final String TEXT_756 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_757 = NL + "    if (";
  protected final String TEXT_758 = "() >= ";
  protected final String TEXT_759 = "())" + NL + "    {";
  protected final String TEXT_760 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_761 = NL + "    ";
  protected final String TEXT_762 = " ";
  protected final String TEXT_763 = " = ";
  protected final String TEXT_764 = ".";
  protected final String TEXT_765 = "();" + NL + "    boolean ";
  protected final String TEXT_766 = " = ";
  protected final String TEXT_767 = " != null && !this.equals(";
  protected final String TEXT_768 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_769 = " && ";
  protected final String TEXT_770 = ".";
  protected final String TEXT_771 = "() <= ";
  protected final String TEXT_772 = "())" + NL + "    {";
  protected final String TEXT_773 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_774 = NL + NL + "    if (";
  protected final String TEXT_775 = ")" + NL + "    {";
  protected final String TEXT_776 = NL + "      ";
  protected final String TEXT_777 = ".";
  protected final String TEXT_778 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_779 = NL + "      ";
  protected final String TEXT_780 = ".add(";
  protected final String TEXT_781 = ");" + NL + "    }";
  protected final String TEXT_782 = NL + "    wasAdded = true;";
  protected final String TEXT_783 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_784 = "(";
  protected final String TEXT_785 = " ";
  protected final String TEXT_786 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_787 = NL + "    //Unable to remove ";
  protected final String TEXT_788 = ", as it must always have a ";
  protected final String TEXT_789 = NL + "    if (this.equals(";
  protected final String TEXT_790 = ".";
  protected final String TEXT_791 = "()))" + NL + "    {";
  protected final String TEXT_792 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_793 = " already at minimum (";
  protected final String TEXT_794 = ")" + NL + "    if (";
  protected final String TEXT_795 = "() <= ";
  protected final String TEXT_796 = "())" + NL + "    {";
  protected final String TEXT_797 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_798 = NL;
  protected final String TEXT_799 = NL + "    ";
  protected final String TEXT_800 = ".remove(";
  protected final String TEXT_801 = ");";
  protected final String TEXT_802 = NL + "    wasRemoved = true;";
  protected final String TEXT_803 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_804 = NL + "  public ";
  protected final String TEXT_805 = " ";
  protected final String TEXT_806 = "(";
  protected final String TEXT_807 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_808 = "() >= ";
  protected final String TEXT_809 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_810 = "(";
  protected final String TEXT_811 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_812 = "(";
  protected final String TEXT_813 = " ";
  protected final String TEXT_814 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_815 = NL + "    if (";
  protected final String TEXT_816 = "() >= ";
  protected final String TEXT_817 = "())" + NL + "    {";
  protected final String TEXT_818 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_819 = NL + "    ";
  protected final String TEXT_820 = " ";
  protected final String TEXT_821 = " = ";
  protected final String TEXT_822 = ".";
  protected final String TEXT_823 = "();" + NL + "    boolean ";
  protected final String TEXT_824 = " = ";
  protected final String TEXT_825 = " != null && !this.equals(";
  protected final String TEXT_826 = ");";
  protected final String TEXT_827 = NL + "    if (";
  protected final String TEXT_828 = ")" + NL + "    {";
  protected final String TEXT_829 = NL + "      ";
  protected final String TEXT_830 = ".";
  protected final String TEXT_831 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_832 = NL + "      ";
  protected final String TEXT_833 = ".add(";
  protected final String TEXT_834 = ");" + NL + "    }";
  protected final String TEXT_835 = NL + "    wasAdded = true;";
  protected final String TEXT_836 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_837 = "(";
  protected final String TEXT_838 = " ";
  protected final String TEXT_839 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_840 = NL + "    //Unable to remove ";
  protected final String TEXT_841 = ", as it must always have a ";
  protected final String TEXT_842 = NL + "    if (!this.equals(";
  protected final String TEXT_843 = ".";
  protected final String TEXT_844 = "()))" + NL + "    {";
  protected final String TEXT_845 = NL + "      ";
  protected final String TEXT_846 = ".remove(";
  protected final String TEXT_847 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_848 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_849 = NL + "  public boolean ";
  protected final String TEXT_850 = "(";
  protected final String TEXT_851 = "... ";
  protected final String TEXT_852 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_853 = NL + "    ArrayList<";
  protected final String TEXT_854 = "> ";
  protected final String TEXT_855 = " = new ArrayList<";
  protected final String TEXT_856 = ">();" + NL + "    for (";
  protected final String TEXT_857 = " ";
  protected final String TEXT_858 = " : ";
  protected final String TEXT_859 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_860 = ".contains(";
  protected final String TEXT_861 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_862 = NL + "      ";
  protected final String TEXT_863 = ".add(";
  protected final String TEXT_864 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_865 = ".size() != ";
  protected final String TEXT_866 = ".length || ";
  protected final String TEXT_867 = ".size() > ";
  protected final String TEXT_868 = "())" + NL + "    {";
  protected final String TEXT_869 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_870 = "> ";
  protected final String TEXT_871 = " = new ArrayList<";
  protected final String TEXT_872 = ">(";
  protected final String TEXT_873 = ");";
  protected final String TEXT_874 = NL + "    ";
  protected final String TEXT_875 = ".clear();" + NL + "    for (";
  protected final String TEXT_876 = " ";
  protected final String TEXT_877 = " : ";
  protected final String TEXT_878 = ")" + NL + "    {";
  protected final String TEXT_879 = NL + "      ";
  protected final String TEXT_880 = ".add(";
  protected final String TEXT_881 = ");" + NL + "      if (";
  protected final String TEXT_882 = ".contains(";
  protected final String TEXT_883 = "))" + NL + "      {";
  protected final String TEXT_884 = NL + "        ";
  protected final String TEXT_885 = ".remove(";
  protected final String TEXT_886 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_887 = NL + "        ";
  protected final String TEXT_888 = ".";
  protected final String TEXT_889 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_890 = " ";
  protected final String TEXT_891 = " : ";
  protected final String TEXT_892 = ")" + NL + "    {";
  protected final String TEXT_893 = NL + "      ";
  protected final String TEXT_894 = ".";
  protected final String TEXT_895 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_896 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_897 = NL + "  public ";
  protected final String TEXT_898 = " ";
  protected final String TEXT_899 = "(";
  protected final String TEXT_900 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_901 = "(";
  protected final String TEXT_902 = ");" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_903 = "(";
  protected final String TEXT_904 = " ";
  protected final String TEXT_905 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_906 = NL + "    ";
  protected final String TEXT_907 = " ";
  protected final String TEXT_908 = " = ";
  protected final String TEXT_909 = ".";
  protected final String TEXT_910 = "();" + NL + "    boolean ";
  protected final String TEXT_911 = " = ";
  protected final String TEXT_912 = " != null && !this.equals(";
  protected final String TEXT_913 = ");";
  protected final String TEXT_914 = NL + "    if (";
  protected final String TEXT_915 = ")" + NL + "    {";
  protected final String TEXT_916 = NL + "      ";
  protected final String TEXT_917 = ".";
  protected final String TEXT_918 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_919 = NL + "      ";
  protected final String TEXT_920 = ".add(";
  protected final String TEXT_921 = ");" + NL + "    }";
  protected final String TEXT_922 = NL + "    wasAdded = true;";
  protected final String TEXT_923 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_924 = "(";
  protected final String TEXT_925 = " ";
  protected final String TEXT_926 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_927 = NL + "    //Unable to remove ";
  protected final String TEXT_928 = ", as it must always have a ";
  protected final String TEXT_929 = NL + "    if (!this.equals(";
  protected final String TEXT_930 = ".";
  protected final String TEXT_931 = "()))" + NL + "    {";
  protected final String TEXT_932 = NL + "      ";
  protected final String TEXT_933 = ".remove(";
  protected final String TEXT_934 = ");";
  protected final String TEXT_935 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_936 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_937 = NL + "  public boolean ";
  protected final String TEXT_938 = "(";
  protected final String TEXT_939 = " ";
  protected final String TEXT_940 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_941 = NL + "    if (";
  protected final String TEXT_942 = " == null)" + NL + "    {";
  protected final String TEXT_943 = NL + "      ";
  protected final String TEXT_944 = " ";
  protected final String TEXT_945 = " = ";
  protected final String TEXT_946 = ";";
  protected final String TEXT_947 = NL + "      ";
  protected final String TEXT_948 = " = null;" + NL + "      " + NL + "      if (";
  protected final String TEXT_949 = " != null && ";
  protected final String TEXT_950 = ".";
  protected final String TEXT_951 = "() != null)" + NL + "      {";
  protected final String TEXT_952 = NL + "        ";
  protected final String TEXT_953 = ".";
  protected final String TEXT_954 = "(null);" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_955 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_956 = NL + "    ";
  protected final String TEXT_957 = " ";
  protected final String TEXT_958 = " = ";
  protected final String TEXT_959 = "();" + NL + "    if (";
  protected final String TEXT_960 = " != null && !";
  protected final String TEXT_961 = ".equals(";
  protected final String TEXT_962 = "))" + NL + "    {";
  protected final String TEXT_963 = NL + "      ";
  protected final String TEXT_964 = ".";
  protected final String TEXT_965 = "(null);" + NL + "    }" + NL;
  protected final String TEXT_966 = NL + "    ";
  protected final String TEXT_967 = " = ";
  protected final String TEXT_968 = ";";
  protected final String TEXT_969 = NL + "    ";
  protected final String TEXT_970 = " ";
  protected final String TEXT_971 = " = ";
  protected final String TEXT_972 = ".";
  protected final String TEXT_973 = "();" + NL + "" + NL + "    if (!equals(";
  protected final String TEXT_974 = "))" + NL + "    {";
  protected final String TEXT_975 = NL + "      ";
  protected final String TEXT_976 = ".";
  protected final String TEXT_977 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_978 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_979 = NL + "  public boolean ";
  protected final String TEXT_980 = "(";
  protected final String TEXT_981 = " ";
  protected final String TEXT_982 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_983 = NL + "    if (!";
  protected final String TEXT_984 = ".contains(";
  protected final String TEXT_985 = "))" + NL + "    {";
  protected final String TEXT_986 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_987 = "() <= ";
  protected final String TEXT_988 = "())" + NL + "    {";
  protected final String TEXT_989 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_990 = ".indexOf(";
  protected final String TEXT_991 = ");";
  protected final String TEXT_992 = NL + "    ";
  protected final String TEXT_993 = ".remove(oldIndex);";
  protected final String TEXT_994 = NL + "    if (";
  protected final String TEXT_995 = ".";
  protected final String TEXT_996 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_997 = ".";
  protected final String TEXT_998 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_999 = NL + "        ";
  protected final String TEXT_1000 = ".add(oldIndex,";
  protected final String TEXT_1001 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1002 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1003 = NL + "  public boolean ";
  protected final String TEXT_1004 = "(";
  protected final String TEXT_1005 = " ";
  protected final String TEXT_1006 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1007 = NL + "    if (!";
  protected final String TEXT_1008 = ".contains(";
  protected final String TEXT_1009 = "))" + NL + "    {";
  protected final String TEXT_1010 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1011 = "() <= ";
  protected final String TEXT_1012 = "())" + NL + "    {";
  protected final String TEXT_1013 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_1014 = ".indexOf(";
  protected final String TEXT_1015 = ");";
  protected final String TEXT_1016 = NL + "    ";
  protected final String TEXT_1017 = ".remove(oldIndex);";
  protected final String TEXT_1018 = NL + "    if (";
  protected final String TEXT_1019 = ".";
  protected final String TEXT_1020 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_1021 = ".";
  protected final String TEXT_1022 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_1023 = NL + "        ";
  protected final String TEXT_1024 = ".add(oldIndex,";
  protected final String TEXT_1025 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1026 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1027 = NL + "  public boolean ";
  protected final String TEXT_1028 = "(";
  protected final String TEXT_1029 = " ";
  protected final String TEXT_1030 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1031 = NL + "    if (";
  protected final String TEXT_1032 = " != null && ";
  protected final String TEXT_1033 = ".";
  protected final String TEXT_1034 = "() >= ";
  protected final String TEXT_1035 = ".";
  protected final String TEXT_1036 = "())" + NL + "    {";
  protected final String TEXT_1037 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1038 = NL + "    ";
  protected final String TEXT_1039 = " ";
  protected final String TEXT_1040 = " = ";
  protected final String TEXT_1041 = ";";
  protected final String TEXT_1042 = NL + "    ";
  protected final String TEXT_1043 = " = ";
  protected final String TEXT_1044 = ";" + NL + "    if (";
  protected final String TEXT_1045 = " != null && !";
  protected final String TEXT_1046 = ".equals(";
  protected final String TEXT_1047 = "))" + NL + "    {";
  protected final String TEXT_1048 = NL + "      ";
  protected final String TEXT_1049 = ".";
  protected final String TEXT_1050 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1051 = " != null)" + NL + "    {";
  protected final String TEXT_1052 = NL + "      ";
  protected final String TEXT_1053 = ".";
  protected final String TEXT_1054 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1055 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1056 = NL + "  public boolean ";
  protected final String TEXT_1057 = "(";
  protected final String TEXT_1058 = " ";
  protected final String TEXT_1059 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1060 = NL + "    if (";
  protected final String TEXT_1061 = " == null)" + NL + "    {";
  protected final String TEXT_1062 = NL + "      return wasSet;" + NL + "    }" + NL;
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
  protected final String TEXT_1075 = "(this);" + NL + "    }";
  protected final String TEXT_1076 = NL + "    ";
  protected final String TEXT_1077 = ".";
  protected final String TEXT_1078 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1079 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1080 = NL + "  public boolean ";
  protected final String TEXT_1081 = "(";
  protected final String TEXT_1082 = " ";
  protected final String TEXT_1083 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1084 = NL + "    //Must provide ";
  protected final String TEXT_1085 = " to ";
  protected final String TEXT_1086 = NL + "    if (";
  protected final String TEXT_1087 = " == null)" + NL + "    {";
  protected final String TEXT_1088 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1089 = " already at maximum (";
  protected final String TEXT_1090 = ")" + NL + "    if (";
  protected final String TEXT_1091 = ".";
  protected final String TEXT_1092 = "() >= ";
  protected final String TEXT_1093 = ".";
  protected final String TEXT_1094 = "())" + NL + "    {";
  protected final String TEXT_1095 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1096 = NL + "    ";
  protected final String TEXT_1097 = " ";
  protected final String TEXT_1098 = " = ";
  protected final String TEXT_1099 = ";";
  protected final String TEXT_1100 = NL + "    ";
  protected final String TEXT_1101 = " = ";
  protected final String TEXT_1102 = ";" + NL + "    if (";
  protected final String TEXT_1103 = " != null && !";
  protected final String TEXT_1104 = ".equals(";
  protected final String TEXT_1105 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1106 = ".";
  protected final String TEXT_1107 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1108 = NL + "        ";
  protected final String TEXT_1109 = " = ";
  protected final String TEXT_1110 = ";";
  protected final String TEXT_1111 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1112 = NL + "    ";
  protected final String TEXT_1113 = ".";
  protected final String TEXT_1114 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1115 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1116 = NL + "  public boolean ";
  protected final String TEXT_1117 = "(";
  protected final String TEXT_1118 = " ";
  protected final String TEXT_1119 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1120 = NL + "    //Must provide ";
  protected final String TEXT_1121 = " to ";
  protected final String TEXT_1122 = NL + "    if (";
  protected final String TEXT_1123 = " == null)" + NL + "    {";
  protected final String TEXT_1124 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1125 = " != null && ";
  protected final String TEXT_1126 = ".";
  protected final String TEXT_1127 = "() <= ";
  protected final String TEXT_1128 = ".";
  protected final String TEXT_1129 = "())" + NL + "    {";
  protected final String TEXT_1130 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1131 = NL + "    ";
  protected final String TEXT_1132 = " ";
  protected final String TEXT_1133 = " = ";
  protected final String TEXT_1134 = ";";
  protected final String TEXT_1135 = NL + "    ";
  protected final String TEXT_1136 = " = ";
  protected final String TEXT_1137 = ";" + NL + "    if (";
  protected final String TEXT_1138 = " != null && !";
  protected final String TEXT_1139 = ".equals(";
  protected final String TEXT_1140 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1141 = ".";
  protected final String TEXT_1142 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1143 = NL + "        ";
  protected final String TEXT_1144 = " = ";
  protected final String TEXT_1145 = ";";
  protected final String TEXT_1146 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1147 = NL + "    ";
  protected final String TEXT_1148 = ".";
  protected final String TEXT_1149 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1150 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1151 = NL + "  public boolean ";
  protected final String TEXT_1152 = "(";
  protected final String TEXT_1153 = " ";
  protected final String TEXT_1154 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1155 = NL + "    ";
  protected final String TEXT_1156 = " ";
  protected final String TEXT_1157 = " = ";
  protected final String TEXT_1158 = ".";
  protected final String TEXT_1159 = "();";
  protected final String TEXT_1160 = NL + "    if (";
  protected final String TEXT_1161 = " == null)" + NL + "    {";
  protected final String TEXT_1162 = NL + "      ";
  protected final String TEXT_1163 = ".";
  protected final String TEXT_1164 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1165 = "))" + NL + "    {";
  protected final String TEXT_1166 = NL + "      ";
  protected final String TEXT_1167 = ".";
  protected final String TEXT_1168 = "(";
  protected final String TEXT_1169 = ");";
  protected final String TEXT_1170 = NL + "      ";
  protected final String TEXT_1171 = "(";
  protected final String TEXT_1172 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1173 = NL + "      ";
  protected final String TEXT_1174 = ".add(";
  protected final String TEXT_1175 = ");" + NL + "    }";
  protected final String TEXT_1176 = NL + "    wasAdded = true;";
  protected final String TEXT_1177 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1178 = "(";
  protected final String TEXT_1179 = " ";
  protected final String TEXT_1180 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1181 = NL + "    if (";
  protected final String TEXT_1182 = ".contains(";
  protected final String TEXT_1183 = "))" + NL + "    {";
  protected final String TEXT_1184 = NL + "      ";
  protected final String TEXT_1185 = ".remove(";
  protected final String TEXT_1186 = ");";
  protected final String TEXT_1187 = NL + "      ";
  protected final String TEXT_1188 = ".";
  protected final String TEXT_1189 = "(null);" + NL + "      wasRemoved = true;";
  protected final String TEXT_1190 = NL + "    }";
  protected final String TEXT_1191 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1192 = NL + "  public boolean ";
  protected final String TEXT_1193 = "(";
  protected final String TEXT_1194 = " ";
  protected final String TEXT_1195 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1196 = NL + "    ";
  protected final String TEXT_1197 = " ";
  protected final String TEXT_1198 = " = ";
  protected final String TEXT_1199 = ";";
  protected final String TEXT_1200 = NL + "    ";
  protected final String TEXT_1201 = " = ";
  protected final String TEXT_1202 = ";" + NL + "    if (";
  protected final String TEXT_1203 = " != null && !";
  protected final String TEXT_1204 = ".equals(";
  protected final String TEXT_1205 = "))" + NL + "    {";
  protected final String TEXT_1206 = NL + "      ";
  protected final String TEXT_1207 = ".";
  protected final String TEXT_1208 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1209 = " != null)" + NL + "    {";
  protected final String TEXT_1210 = NL + "      ";
  protected final String TEXT_1211 = ".";
  protected final String TEXT_1212 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1213 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1214 = NL + "  public boolean ";
  protected final String TEXT_1215 = "(";
  protected final String TEXT_1216 = " ";
  protected final String TEXT_1217 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1218 = NL + "    if (";
  protected final String TEXT_1219 = "() >= ";
  protected final String TEXT_1220 = "())" + NL + "    {";
  protected final String TEXT_1221 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1222 = NL + "    ";
  protected final String TEXT_1223 = " ";
  protected final String TEXT_1224 = " = ";
  protected final String TEXT_1225 = ".";
  protected final String TEXT_1226 = "();";
  protected final String TEXT_1227 = NL + "    if (";
  protected final String TEXT_1228 = " == null)" + NL + "    {";
  protected final String TEXT_1229 = NL + "      ";
  protected final String TEXT_1230 = ".";
  protected final String TEXT_1231 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1232 = "))" + NL + "    {";
  protected final String TEXT_1233 = NL + "      ";
  protected final String TEXT_1234 = ".";
  protected final String TEXT_1235 = "(";
  protected final String TEXT_1236 = ");";
  protected final String TEXT_1237 = NL + "      ";
  protected final String TEXT_1238 = "(";
  protected final String TEXT_1239 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1240 = NL + "      ";
  protected final String TEXT_1241 = ".add(";
  protected final String TEXT_1242 = ");" + NL + "    }";
  protected final String TEXT_1243 = NL + "    wasAdded = true;";
  protected final String TEXT_1244 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1245 = "(";
  protected final String TEXT_1246 = " ";
  protected final String TEXT_1247 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1248 = NL + "    if (";
  protected final String TEXT_1249 = ".contains(";
  protected final String TEXT_1250 = "))" + NL + "    {";
  protected final String TEXT_1251 = NL + "      ";
  protected final String TEXT_1252 = ".remove(";
  protected final String TEXT_1253 = ");";
  protected final String TEXT_1254 = NL + "      ";
  protected final String TEXT_1255 = ".";
  protected final String TEXT_1256 = "(null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1257 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1258 = NL + "  public boolean ";
  protected final String TEXT_1259 = "(";
  protected final String TEXT_1260 = " ";
  protected final String TEXT_1261 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1262 = NL + "    if (";
  protected final String TEXT_1263 = "() < ";
  protected final String TEXT_1264 = "())" + NL + "    {";
  protected final String TEXT_1265 = NL + "      ";
  protected final String TEXT_1266 = ".add(";
  protected final String TEXT_1267 = ");";
  protected final String TEXT_1268 = NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1269 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1270 = "(";
  protected final String TEXT_1271 = " ";
  protected final String TEXT_1272 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1273 = NL + "    if (!";
  protected final String TEXT_1274 = ".contains(";
  protected final String TEXT_1275 = "))" + NL + "    {";
  protected final String TEXT_1276 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1277 = "() <= ";
  protected final String TEXT_1278 = "())" + NL + "    {";
  protected final String TEXT_1279 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_1280 = NL;
  protected final String TEXT_1281 = NL + "    ";
  protected final String TEXT_1282 = ".remove(";
  protected final String TEXT_1283 = ");";
  protected final String TEXT_1284 = NL + "    wasRemoved = true;";
  protected final String TEXT_1285 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1286 = NL + "  public boolean ";
  protected final String TEXT_1287 = "(";
  protected final String TEXT_1288 = " ";
  protected final String TEXT_1289 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1290 = NL + "    if (";
  protected final String TEXT_1291 = "() >= ";
  protected final String TEXT_1292 = "())" + NL + "    {";
  protected final String TEXT_1293 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1294 = NL + "    ";
  protected final String TEXT_1295 = " ";
  protected final String TEXT_1296 = " = ";
  protected final String TEXT_1297 = ".";
  protected final String TEXT_1298 = "();" + NL + "    if (";
  protected final String TEXT_1299 = " != null && ";
  protected final String TEXT_1300 = ".";
  protected final String TEXT_1301 = "() <= ";
  protected final String TEXT_1302 = "())" + NL + "    {";
  protected final String TEXT_1303 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1304 = " != null)" + NL + "    {";
  protected final String TEXT_1305 = NL + "      ";
  protected final String TEXT_1306 = ".";
  protected final String TEXT_1307 = ".remove(";
  protected final String TEXT_1308 = ");" + NL + "    }";
  protected final String TEXT_1309 = NL + "    ";
  protected final String TEXT_1310 = ".add(";
  protected final String TEXT_1311 = ");";
  protected final String TEXT_1312 = NL + "    ";
  protected final String TEXT_1313 = "(";
  protected final String TEXT_1314 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1315 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1316 = "(";
  protected final String TEXT_1317 = " ";
  protected final String TEXT_1318 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1319 = NL + "    if (";
  protected final String TEXT_1320 = ".contains(";
  protected final String TEXT_1321 = ") && ";
  protected final String TEXT_1322 = "() > ";
  protected final String TEXT_1323 = "())" + NL + "    {";
  protected final String TEXT_1324 = NL + "      ";
  protected final String TEXT_1325 = ".remove(";
  protected final String TEXT_1326 = ");";
  protected final String TEXT_1327 = NL + "      ";
  protected final String TEXT_1328 = "(";
  protected final String TEXT_1329 = ",null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1330 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1331 = NL + "  public boolean ";
  protected final String TEXT_1332 = "(";
  protected final String TEXT_1333 = "... ";
  protected final String TEXT_1334 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1335 = NL + "    ArrayList<";
  protected final String TEXT_1336 = "> ";
  protected final String TEXT_1337 = " = new ArrayList<";
  protected final String TEXT_1338 = ">();" + NL + "    for (";
  protected final String TEXT_1339 = " ";
  protected final String TEXT_1340 = " : ";
  protected final String TEXT_1341 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1342 = ".contains(";
  protected final String TEXT_1343 = "))" + NL + "      {";
  protected final String TEXT_1344 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1345 = ".";
  protected final String TEXT_1346 = "() != null && !this.equals(";
  protected final String TEXT_1347 = ".";
  protected final String TEXT_1348 = "()))" + NL + "      {";
  protected final String TEXT_1349 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1350 = NL + "      ";
  protected final String TEXT_1351 = ".add(";
  protected final String TEXT_1352 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1353 = ".size() != ";
  protected final String TEXT_1354 = "())" + NL + "    {";
  protected final String TEXT_1355 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1356 = NL + "    ";
  protected final String TEXT_1357 = ".removeAll(";
  protected final String TEXT_1358 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1359 = " orphan : ";
  protected final String TEXT_1360 = ")" + NL + "    {";
  protected final String TEXT_1361 = NL + "      ";
  protected final String TEXT_1362 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1363 = NL + "    ";
  protected final String TEXT_1364 = ".clear();" + NL + "    for (";
  protected final String TEXT_1365 = " ";
  protected final String TEXT_1366 = " : ";
  protected final String TEXT_1367 = ")" + NL + "    {";
  protected final String TEXT_1368 = NL + "      ";
  protected final String TEXT_1369 = "(";
  protected final String TEXT_1370 = ", this);";
  protected final String TEXT_1371 = NL + "      ";
  protected final String TEXT_1372 = ".add(";
  protected final String TEXT_1373 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1374 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1375 = NL + "  private void ";
  protected final String TEXT_1376 = "(";
  protected final String TEXT_1377 = " ";
  protected final String TEXT_1378 = ", ";
  protected final String TEXT_1379 = " ";
  protected final String TEXT_1380 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1381 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1382 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1383 = ", ";
  protected final String TEXT_1384 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1385 = " to ";
  protected final String TEXT_1386 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1387 = NL + "  public boolean ";
  protected final String TEXT_1388 = "(";
  protected final String TEXT_1389 = " ";
  protected final String TEXT_1390 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1391 = NL + "    ";
  protected final String TEXT_1392 = ".add(";
  protected final String TEXT_1393 = ");";
  protected final String TEXT_1394 = NL + "    wasAdded = true;";
  protected final String TEXT_1395 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1396 = "(";
  protected final String TEXT_1397 = " ";
  protected final String TEXT_1398 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1399 = NL + "    if (";
  protected final String TEXT_1400 = ".contains(";
  protected final String TEXT_1401 = "))" + NL + "    {";
  protected final String TEXT_1402 = NL + "      ";
  protected final String TEXT_1403 = ".remove(";
  protected final String TEXT_1404 = ");";
  protected final String TEXT_1405 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1406 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1407 = NL + "  public boolean ";
  protected final String TEXT_1408 = "(";
  protected final String TEXT_1409 = " ";
  protected final String TEXT_1410 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1411 = NL + "    if (";
  protected final String TEXT_1412 = "() < ";
  protected final String TEXT_1413 = "())" + NL + "    {";
  protected final String TEXT_1414 = NL + "      ";
  protected final String TEXT_1415 = ".add(";
  protected final String TEXT_1416 = ");";
  protected final String TEXT_1417 = NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1418 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_1419 = NL;
  protected final String TEXT_1420 = NL + "  public boolean ";
  protected final String TEXT_1421 = "(";
  protected final String TEXT_1422 = " ";
  protected final String TEXT_1423 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1424 = NL + "    if (";
  protected final String TEXT_1425 = ".contains(";
  protected final String TEXT_1426 = "))" + NL + "    {";
  protected final String TEXT_1427 = NL + "      ";
  protected final String TEXT_1428 = ".remove(";
  protected final String TEXT_1429 = ");";
  protected final String TEXT_1430 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1431 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1432 = NL + "  public boolean ";
  protected final String TEXT_1433 = "(";
  protected final String TEXT_1434 = " ";
  protected final String TEXT_1435 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1436 = NL + "    ";
  protected final String TEXT_1437 = ".add(";
  protected final String TEXT_1438 = ");";
  protected final String TEXT_1439 = NL + "    wasAdded = true;";
  protected final String TEXT_1440 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1441 = "(";
  protected final String TEXT_1442 = " ";
  protected final String TEXT_1443 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1444 = NL + "    if (!";
  protected final String TEXT_1445 = ".contains(";
  protected final String TEXT_1446 = "))" + NL + "    {";
  protected final String TEXT_1447 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1448 = "() <= ";
  protected final String TEXT_1449 = "())" + NL + "    {";
  protected final String TEXT_1450 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_1451 = NL;
  protected final String TEXT_1452 = NL + "    ";
  protected final String TEXT_1453 = ".remove(";
  protected final String TEXT_1454 = ");";
  protected final String TEXT_1455 = NL + "    wasRemoved = true;";
  protected final String TEXT_1456 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1457 = NL + "  ";
  protected final String TEXT_1458 = " boolean ";
  protected final String TEXT_1459 = "(";
  protected final String TEXT_1460 = "... ";
  protected final String TEXT_1461 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1462 = NL + "    ArrayList<";
  protected final String TEXT_1463 = "> ";
  protected final String TEXT_1464 = " = new ArrayList<";
  protected final String TEXT_1465 = ">();" + NL + "    for (";
  protected final String TEXT_1466 = " ";
  protected final String TEXT_1467 = " : ";
  protected final String TEXT_1468 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1469 = ".contains(";
  protected final String TEXT_1470 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1471 = NL + "      ";
  protected final String TEXT_1472 = ".add(";
  protected final String TEXT_1473 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1474 = ".size() != ";
  protected final String TEXT_1475 = ".length || ";
  protected final String TEXT_1476 = ".size() != ";
  protected final String TEXT_1477 = "())" + NL + "    {";
  protected final String TEXT_1478 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1479 = NL + "    ";
  protected final String TEXT_1480 = ".clear();";
  protected final String TEXT_1481 = NL + "    ";
  protected final String TEXT_1482 = ".addAll(";
  protected final String TEXT_1483 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1484 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1485 = NL + "  ";
  protected final String TEXT_1486 = " boolean ";
  protected final String TEXT_1487 = "(";
  protected final String TEXT_1488 = "... ";
  protected final String TEXT_1489 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1490 = NL + "    ArrayList<";
  protected final String TEXT_1491 = "> ";
  protected final String TEXT_1492 = " = new ArrayList<";
  protected final String TEXT_1493 = ">();" + NL + "    for (";
  protected final String TEXT_1494 = " ";
  protected final String TEXT_1495 = " : ";
  protected final String TEXT_1496 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1497 = ".contains(";
  protected final String TEXT_1498 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1499 = NL + "      ";
  protected final String TEXT_1500 = ".add(";
  protected final String TEXT_1501 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1502 = ".size() != ";
  protected final String TEXT_1503 = ".length)" + NL + "    {";
  protected final String TEXT_1504 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1505 = NL + "    ";
  protected final String TEXT_1506 = ".clear();";
  protected final String TEXT_1507 = NL + "    ";
  protected final String TEXT_1508 = ".addAll(";
  protected final String TEXT_1509 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1510 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1511 = NL + "  public boolean ";
  protected final String TEXT_1512 = "(";
  protected final String TEXT_1513 = " ";
  protected final String TEXT_1514 = ")" + NL + "  {" + NL + "    //" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "    boolean wasSet = false;";
  protected final String TEXT_1515 = NL + "    ";
  protected final String TEXT_1516 = " ";
  protected final String TEXT_1517 = " = ";
  protected final String TEXT_1518 = ";" + NL + "" + NL + "    if (";
  protected final String TEXT_1519 = " == null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1520 = " != null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1521 = ".";
  protected final String TEXT_1522 = "(this))" + NL + "        {";
  protected final String TEXT_1523 = NL + "          ";
  protected final String TEXT_1524 = " = ";
  protected final String TEXT_1525 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if (";
  protected final String TEXT_1526 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1527 = " == null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1528 = ".";
  protected final String TEXT_1529 = "() < ";
  protected final String TEXT_1530 = ".";
  protected final String TEXT_1531 = "())" + NL + "        {";
  protected final String TEXT_1532 = NL + "          ";
  protected final String TEXT_1533 = ".";
  protected final String TEXT_1534 = "(this);";
  protected final String TEXT_1535 = NL + "          ";
  protected final String TEXT_1536 = " = ";
  protected final String TEXT_1537 = ";  // ";
  protected final String TEXT_1538 = " == null" + NL + "          wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1539 = ".";
  protected final String TEXT_1540 = "() < ";
  protected final String TEXT_1541 = ".";
  protected final String TEXT_1542 = "())" + NL + "        {";
  protected final String TEXT_1543 = NL + "          ";
  protected final String TEXT_1544 = ".";
  protected final String TEXT_1545 = "(this);";
  protected final String TEXT_1546 = NL + "          ";
  protected final String TEXT_1547 = ".";
  protected final String TEXT_1548 = "(this);";
  protected final String TEXT_1549 = NL + "          ";
  protected final String TEXT_1550 = " = ";
  protected final String TEXT_1551 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if (wasSet)" + NL + "    {";
  protected final String TEXT_1552 = NL + "      ";
  protected final String TEXT_1553 = " = ";
  protected final String TEXT_1554 = ";" + NL + "    }" + NL + "    return wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_1555 = NL + "//  public boolean ";
  protected final String TEXT_1556 = "(";
  protected final String TEXT_1557 = " ";
  protected final String TEXT_1558 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_1559 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//" + NL + "//    boolean wasSet = false;" + NL + "//    ";
  protected final String TEXT_1560 = " ";
  protected final String TEXT_1561 = " = ";
  protected final String TEXT_1562 = ";" + NL + "//  " + NL + "//    if (";
  protected final String TEXT_1563 = " == null)" + NL + "//    {  " + NL + "//      if (";
  protected final String TEXT_1564 = " != null)" + NL + "//      { " + NL + "//        if (";
  protected final String TEXT_1565 = ".";
  protected final String TEXT_1566 = "(this))" + NL + "//          ";
  protected final String TEXT_1567 = " = ";
  protected final String TEXT_1568 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    else" + NL + "//    {" + NL + "//      if (";
  protected final String TEXT_1569 = " != null)" + NL + "//      {" + NL + "//        if (";
  protected final String TEXT_1570 = " == null)" + NL + "//        {" + NL + "//          if (";
  protected final String TEXT_1571 = ".";
  protected final String TEXT_1572 = " < ";
  protected final String TEXT_1573 = ".";
  protected final String TEXT_1574 = ")" + NL + "//            ";
  protected final String TEXT_1575 = ".";
  protected final String TEXT_1576 = "(this);" + NL + "//            ";
  protected final String TEXT_1577 = " = ";
  protected final String TEXT_1578 = "  // ";
  protected final String TEXT_1579 = " == null;" + NL + "//            wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//      else" + NL + "//      {" + NL + "//        if (   ";
  protected final String TEXT_1580 = ".";
  protected final String TEXT_1581 = " < ";
  protected final String TEXT_1582 = ".";
  protected final String TEXT_1583 = "()" + NL + "//            && ";
  protected final String TEXT_1584 = ".";
  protected final String TEXT_1585 = " > ";
  protected final String TEXT_1586 = ".";
  protected final String TEXT_1587 = "()" + NL + "//           )" + NL + "//          ";
  protected final String TEXT_1588 = ".";
  protected final String TEXT_1589 = "(this);" + NL + "//          ";
  protected final String TEXT_1590 = ".";
  protected final String TEXT_1591 = "(this);" + NL + "//          ";
  protected final String TEXT_1592 = " = ";
  protected final String TEXT_1593 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    " + NL + "//    if (wasSet)" + NL + "//    {" + NL + "//      ";
  protected final String TEXT_1594 = " = ";
  protected final String TEXT_1595 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return wasSet;" + NL + "//  }";
  protected final String TEXT_1596 = NL + "  public boolean ";
  protected final String TEXT_1597 = "(";
  protected final String TEXT_1598 = "... ";
  protected final String TEXT_1599 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1600 = NL + "    ArrayList<";
  protected final String TEXT_1601 = "> ";
  protected final String TEXT_1602 = " = new ArrayList<";
  protected final String TEXT_1603 = ">();" + NL + "    for (";
  protected final String TEXT_1604 = " ";
  protected final String TEXT_1605 = " : ";
  protected final String TEXT_1606 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1607 = ".contains(";
  protected final String TEXT_1608 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1609 = NL + "      ";
  protected final String TEXT_1610 = ".add(";
  protected final String TEXT_1611 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1612 = ".size() != ";
  protected final String TEXT_1613 = ".length || ";
  protected final String TEXT_1614 = ".size() < ";
  protected final String TEXT_1615 = "() || ";
  protected final String TEXT_1616 = ".size() > ";
  protected final String TEXT_1617 = "())" + NL + "    {";
  protected final String TEXT_1618 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1619 = "> ";
  protected final String TEXT_1620 = " = new ArrayList<";
  protected final String TEXT_1621 = ">(";
  protected final String TEXT_1622 = ");";
  protected final String TEXT_1623 = NL + "    ";
  protected final String TEXT_1624 = ".clear();" + NL + "    for (";
  protected final String TEXT_1625 = " ";
  protected final String TEXT_1626 = " : ";
  protected final String TEXT_1627 = ")" + NL + "    {";
  protected final String TEXT_1628 = NL + "      ";
  protected final String TEXT_1629 = ".add(";
  protected final String TEXT_1630 = ");" + NL + "      if (";
  protected final String TEXT_1631 = ".contains(";
  protected final String TEXT_1632 = "))" + NL + "      {";
  protected final String TEXT_1633 = NL + "        ";
  protected final String TEXT_1634 = ".remove(";
  protected final String TEXT_1635 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1636 = NL + "        ";
  protected final String TEXT_1637 = ".";
  protected final String TEXT_1638 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1639 = " ";
  protected final String TEXT_1640 = " : ";
  protected final String TEXT_1641 = ")" + NL + "    {";
  protected final String TEXT_1642 = NL + "      ";
  protected final String TEXT_1643 = ".";
  protected final String TEXT_1644 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1645 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1646 = NL + "  public boolean ";
  protected final String TEXT_1647 = "(";
  protected final String TEXT_1648 = "... ";
  protected final String TEXT_1649 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1650 = NL + "    ArrayList<";
  protected final String TEXT_1651 = "> ";
  protected final String TEXT_1652 = " = new ArrayList<";
  protected final String TEXT_1653 = ">();" + NL + "    for (";
  protected final String TEXT_1654 = " ";
  protected final String TEXT_1655 = " : ";
  protected final String TEXT_1656 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1657 = ".contains(";
  protected final String TEXT_1658 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1659 = NL + "      ";
  protected final String TEXT_1660 = ".add(";
  protected final String TEXT_1661 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1662 = ".size() != ";
  protected final String TEXT_1663 = ".length || ";
  protected final String TEXT_1664 = ".size() < ";
  protected final String TEXT_1665 = "())" + NL + "    {";
  protected final String TEXT_1666 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1667 = "> ";
  protected final String TEXT_1668 = " = new ArrayList<";
  protected final String TEXT_1669 = ">(";
  protected final String TEXT_1670 = ");";
  protected final String TEXT_1671 = NL + "    ";
  protected final String TEXT_1672 = ".clear();" + NL + "    for (";
  protected final String TEXT_1673 = " ";
  protected final String TEXT_1674 = " : ";
  protected final String TEXT_1675 = ")" + NL + "    {";
  protected final String TEXT_1676 = NL + "      ";
  protected final String TEXT_1677 = ".add(";
  protected final String TEXT_1678 = ");" + NL + "      if (";
  protected final String TEXT_1679 = ".contains(";
  protected final String TEXT_1680 = "))" + NL + "      {";
  protected final String TEXT_1681 = NL + "        ";
  protected final String TEXT_1682 = ".remove(";
  protected final String TEXT_1683 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1684 = NL + "        ";
  protected final String TEXT_1685 = ".";
  protected final String TEXT_1686 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1687 = " ";
  protected final String TEXT_1688 = " : ";
  protected final String TEXT_1689 = ")" + NL + "    {";
  protected final String TEXT_1690 = NL + "      ";
  protected final String TEXT_1691 = ".";
  protected final String TEXT_1692 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1693 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1694 = NL + "  ";
  protected final String TEXT_1695 = " boolean ";
  protected final String TEXT_1696 = "(";
  protected final String TEXT_1697 = "... ";
  protected final String TEXT_1698 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1699 = NL + "    ArrayList<";
  protected final String TEXT_1700 = "> ";
  protected final String TEXT_1701 = " = new ArrayList<";
  protected final String TEXT_1702 = ">();" + NL + "    for (";
  protected final String TEXT_1703 = " ";
  protected final String TEXT_1704 = " : ";
  protected final String TEXT_1705 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1706 = ".contains(";
  protected final String TEXT_1707 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1708 = NL + "      ";
  protected final String TEXT_1709 = ".add(";
  protected final String TEXT_1710 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1711 = ".size() != ";
  protected final String TEXT_1712 = ".length || ";
  protected final String TEXT_1713 = ".size() < ";
  protected final String TEXT_1714 = "() || ";
  protected final String TEXT_1715 = ".size() > ";
  protected final String TEXT_1716 = "())" + NL + "    {";
  protected final String TEXT_1717 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1718 = NL + "    ";
  protected final String TEXT_1719 = ".clear();";
  protected final String TEXT_1720 = NL + "    ";
  protected final String TEXT_1721 = ".addAll(";
  protected final String TEXT_1722 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1723 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1724 = NL + "  public boolean ";
  protected final String TEXT_1725 = "(";
  protected final String TEXT_1726 = "... ";
  protected final String TEXT_1727 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1728 = NL + "    if (";
  protected final String TEXT_1729 = ".length < ";
  protected final String TEXT_1730 = "()";
  protected final String TEXT_1731 = ")" + NL + "    {";
  protected final String TEXT_1732 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1733 = "> ";
  protected final String TEXT_1734 = " = new ArrayList<";
  protected final String TEXT_1735 = ">();" + NL + "    HashMap<";
  protected final String TEXT_1736 = ",Integer> ";
  protected final String TEXT_1737 = " = new HashMap<";
  protected final String TEXT_1738 = ",Integer>();" + NL + "    for (";
  protected final String TEXT_1739 = " ";
  protected final String TEXT_1740 = " : ";
  protected final String TEXT_1741 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1742 = ".contains(";
  protected final String TEXT_1743 = "))" + NL + "      {";
  protected final String TEXT_1744 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1745 = ".";
  protected final String TEXT_1746 = "() != null && !this.equals(";
  protected final String TEXT_1747 = ".";
  protected final String TEXT_1748 = "()))" + NL + "      {";
  protected final String TEXT_1749 = NL + "        ";
  protected final String TEXT_1750 = " ";
  protected final String TEXT_1751 = " = ";
  protected final String TEXT_1752 = ".";
  protected final String TEXT_1753 = "();" + NL + "        if (!";
  protected final String TEXT_1754 = ".containsKey(";
  protected final String TEXT_1755 = "))" + NL + "        {";
  protected final String TEXT_1756 = NL + "          ";
  protected final String TEXT_1757 = ".put(";
  protected final String TEXT_1758 = ", new Integer(";
  protected final String TEXT_1759 = ".";
  protected final String TEXT_1760 = "()));" + NL + "        }" + NL + "        Integer currentCount = ";
  protected final String TEXT_1761 = ".get(";
  protected final String TEXT_1762 = ");" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_1763 = ")" + NL + "        {";
  protected final String TEXT_1764 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_1765 = NL + "        ";
  protected final String TEXT_1766 = ".put(";
  protected final String TEXT_1767 = ", new Integer(nextCount));" + NL + "      }";
  protected final String TEXT_1768 = NL + "      ";
  protected final String TEXT_1769 = ".add(";
  protected final String TEXT_1770 = ");" + NL + "    }" + NL;
  protected final String TEXT_1771 = NL + "    ";
  protected final String TEXT_1772 = ".removeAll(";
  protected final String TEXT_1773 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_1774 = " orphan : ";
  protected final String TEXT_1775 = ")" + NL + "    {";
  protected final String TEXT_1776 = NL + "      ";
  protected final String TEXT_1777 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1778 = NL + "    ";
  protected final String TEXT_1779 = ".clear();" + NL + "    for (";
  protected final String TEXT_1780 = " ";
  protected final String TEXT_1781 = " : ";
  protected final String TEXT_1782 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1783 = ".";
  protected final String TEXT_1784 = "() != null)" + NL + "      {";
  protected final String TEXT_1785 = NL + "        ";
  protected final String TEXT_1786 = ".";
  protected final String TEXT_1787 = "().";
  protected final String TEXT_1788 = ".remove(";
  protected final String TEXT_1789 = ");" + NL + "      }";
  protected final String TEXT_1790 = NL + "      ";
  protected final String TEXT_1791 = "(";
  protected final String TEXT_1792 = ", this);";
  protected final String TEXT_1793 = NL + "      ";
  protected final String TEXT_1794 = ".add(";
  protected final String TEXT_1795 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1796 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1797 = NL + "  private void ";
  protected final String TEXT_1798 = "(";
  protected final String TEXT_1799 = " ";
  protected final String TEXT_1800 = ", ";
  protected final String TEXT_1801 = " ";
  protected final String TEXT_1802 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1803 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1804 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1805 = ", ";
  protected final String TEXT_1806 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1807 = " to ";
  protected final String TEXT_1808 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1809 = NL + "  ";
  protected final String TEXT_1810 = " boolean ";
  protected final String TEXT_1811 = "(";
  protected final String TEXT_1812 = "... ";
  protected final String TEXT_1813 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1814 = NL + "    ArrayList<";
  protected final String TEXT_1815 = "> ";
  protected final String TEXT_1816 = " = new ArrayList<";
  protected final String TEXT_1817 = ">();" + NL + "    for (";
  protected final String TEXT_1818 = " ";
  protected final String TEXT_1819 = " : ";
  protected final String TEXT_1820 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1821 = ".contains(";
  protected final String TEXT_1822 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1823 = NL + "      ";
  protected final String TEXT_1824 = ".add(";
  protected final String TEXT_1825 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1826 = ".size() != ";
  protected final String TEXT_1827 = ".length || ";
  protected final String TEXT_1828 = ".size() > ";
  protected final String TEXT_1829 = "())" + NL + "    {";
  protected final String TEXT_1830 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1831 = NL + "    ";
  protected final String TEXT_1832 = ".clear();";
  protected final String TEXT_1833 = NL + "    ";
  protected final String TEXT_1834 = ".addAll(";
  protected final String TEXT_1835 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1836 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1837 = NL + "  ";
  protected final String TEXT_1838 = " boolean ";
  protected final String TEXT_1839 = "(";
  protected final String TEXT_1840 = "... ";
  protected final String TEXT_1841 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1842 = NL + "    ArrayList<";
  protected final String TEXT_1843 = "> ";
  protected final String TEXT_1844 = " = new ArrayList<";
  protected final String TEXT_1845 = ">();" + NL + "    for (";
  protected final String TEXT_1846 = " ";
  protected final String TEXT_1847 = " : ";
  protected final String TEXT_1848 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1849 = ".contains(";
  protected final String TEXT_1850 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1851 = NL + "      ";
  protected final String TEXT_1852 = ".add(";
  protected final String TEXT_1853 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1854 = ".size() != ";
  protected final String TEXT_1855 = ".length || ";
  protected final String TEXT_1856 = ".size() < ";
  protected final String TEXT_1857 = "())" + NL + "    {";
  protected final String TEXT_1858 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1859 = NL + "    ";
  protected final String TEXT_1860 = ".clear();";
  protected final String TEXT_1861 = NL + "    ";
  protected final String TEXT_1862 = ".addAll(";
  protected final String TEXT_1863 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1864 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1865 = NL + "  ";
  protected final String TEXT_1866 = NL + "  public boolean ";
  protected final String TEXT_1867 = "(";
  protected final String TEXT_1868 = " ";
  protected final String TEXT_1869 = ", int index)" + NL + "  {  " + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_1870 = "(";
  protected final String TEXT_1871 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_1872 = "()) { index = ";
  protected final String TEXT_1873 = "() - 1; }";
  protected final String TEXT_1874 = NL + "      ";
  protected final String TEXT_1875 = ".remove(";
  protected final String TEXT_1876 = ");";
  protected final String TEXT_1877 = NL + "      ";
  protected final String TEXT_1878 = ".add(index, ";
  protected final String TEXT_1879 = ");";
  protected final String TEXT_1880 = NL + "      wasAdded = true;" + NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1881 = "(";
  protected final String TEXT_1882 = " ";
  protected final String TEXT_1883 = ", int index)" + NL + "  {" + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_1884 = ".contains(";
  protected final String TEXT_1885 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_1886 = "()) { index = ";
  protected final String TEXT_1887 = "() - 1; }";
  protected final String TEXT_1888 = NL + "      ";
  protected final String TEXT_1889 = ".remove(";
  protected final String TEXT_1890 = ");";
  protected final String TEXT_1891 = NL + "      ";
  protected final String TEXT_1892 = ".add(index, ";
  protected final String TEXT_1893 = ");";
  protected final String TEXT_1894 = NL + "      wasAdded = true;" + NL + "    } " + NL + "    else " + NL + "    {";
  protected final String TEXT_1895 = NL + "      wasAdded = ";
  protected final String TEXT_1896 = "(";
  protected final String TEXT_1897 = ", index);";
  protected final String TEXT_1898 = NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL;
  protected final String TEXT_1899 = NL + "  public boolean equals(Object obj)" + NL + "  {" + NL + "    if (obj == null) { return false; }" + NL + "    if (!getClass().equals(obj.getClass())) { return false; }" + NL;
  protected final String TEXT_1900 = NL + "    ";
  protected final String TEXT_1901 = " compareTo = (";
  protected final String TEXT_1902 = ")obj;" + NL + "  ";
  protected final String TEXT_1903 = NL + "    ";
  protected final String TEXT_1904 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_1905 = NL + "    ";
  protected final String TEXT_1906 = NL;
  protected final String TEXT_1907 = NL + "    ";
  protected final String TEXT_1908 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1909 = NL + "  private void ";
  protected final String TEXT_1910 = "()" + NL + "  {" + NL + "    try" + NL + "    {";
  protected final String TEXT_1911 = NL + "      ";
  protected final String TEXT_1912 = NL + "      Thread.sleep(1);";
  protected final String TEXT_1913 = NL + "    }" + NL + "    catch (InterruptedException e)" + NL + "    {" + NL + "" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1914 = NL + "  private void ";
  protected final String TEXT_1915 = "()" + NL + "  {" + NL + "    try" + NL + "    {";
  protected final String TEXT_1916 = NL + "      ";
  protected final String TEXT_1917 = NL + "      Thread.sleep(1);";
  protected final String TEXT_1918 = NL + "    }" + NL + "    catch (InterruptedException e)" + NL + "    {" + NL + "" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1919 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1920 = NL + "    ";
  protected final String TEXT_1921 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1922 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_1923 = NL + "      ";
  protected final String TEXT_1924 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1925 = NL + "  private void ";
  protected final String TEXT_1926 = "()" + NL + "  {";
  protected final String TEXT_1927 = NL + "    ";
  protected final String TEXT_1928 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1929 = "\",";
  protected final String TEXT_1930 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1931 = "()" + NL + "  {";
  protected final String TEXT_1932 = NL + "    ";
  protected final String TEXT_1933 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1934 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1935 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1936 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void run ()" + NL + "    {";
  protected final String TEXT_1937 = NL + "      if (\"";
  protected final String TEXT_1938 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1939 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1940 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1941 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1942 = NL + "    ";
  protected final String TEXT_1943 = " = null;";
  protected final String TEXT_1944 = NL + "    ";
  protected final String TEXT_1945 = ".clear();";
  protected final String TEXT_1946 = NL + "    ";
  protected final String TEXT_1947 = " ";
  protected final String TEXT_1948 = " = ";
  protected final String TEXT_1949 = ";";
  protected final String TEXT_1950 = NL + "    ";
  protected final String TEXT_1951 = " = null;" + NL + "    if (";
  protected final String TEXT_1952 = " != null)" + NL + "    {";
  protected final String TEXT_1953 = NL + "      ";
  protected final String TEXT_1954 = ".delete();" + NL + "    }";
  protected final String TEXT_1955 = NL + "    if (";
  protected final String TEXT_1956 = " != null)" + NL + "    {";
  protected final String TEXT_1957 = NL + "      ";
  protected final String TEXT_1958 = ".";
  protected final String TEXT_1959 = "(null);" + NL + "    }";
  protected final String TEXT_1960 = NL + "    ";
  protected final String TEXT_1961 = " ";
  protected final String TEXT_1962 = " = ";
  protected final String TEXT_1963 = ";";
  protected final String TEXT_1964 = NL + "    ";
  protected final String TEXT_1965 = " = null;" + NL + "    if (";
  protected final String TEXT_1966 = " != null)" + NL + "    {";
  protected final String TEXT_1967 = NL + "      ";
  protected final String TEXT_1968 = ".";
  protected final String TEXT_1969 = "(null);" + NL + "    }";
  protected final String TEXT_1970 = NL + "    ";
  protected final String TEXT_1971 = " ";
  protected final String TEXT_1972 = " = ";
  protected final String TEXT_1973 = ";";
  protected final String TEXT_1974 = NL + "    ";
  protected final String TEXT_1975 = " = null;" + NL + "    if (";
  protected final String TEXT_1976 = " != null)" + NL + "    {";
  protected final String TEXT_1977 = NL + "      ";
  protected final String TEXT_1978 = ".delete();" + NL + "    }";
  protected final String TEXT_1979 = NL + "    if (";
  protected final String TEXT_1980 = " != null)" + NL + "    {";
  protected final String TEXT_1981 = NL + "      ";
  protected final String TEXT_1982 = " ";
  protected final String TEXT_1983 = " = ";
  protected final String TEXT_1984 = ";" + NL + "      this.";
  protected final String TEXT_1985 = " = null;";
  protected final String TEXT_1986 = NL + "      ";
  protected final String TEXT_1987 = ".";
  protected final String TEXT_1988 = "(this);" + NL + "    }";
  protected final String TEXT_1989 = NL + "    if (";
  protected final String TEXT_1990 = " != null)" + NL + "    {";
  protected final String TEXT_1991 = NL + "      ";
  protected final String TEXT_1992 = ".delete();" + NL + "    }";
  protected final String TEXT_1993 = NL + "    if (";
  protected final String TEXT_1994 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1995 = ".";
  protected final String TEXT_1996 = "() <= ";
  protected final String TEXT_1997 = ")" + NL + "      {";
  protected final String TEXT_1998 = NL + "        ";
  protected final String TEXT_1999 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2000 = NL + "        ";
  protected final String TEXT_2001 = " ";
  protected final String TEXT_2002 = " = ";
  protected final String TEXT_2003 = ";" + NL + "        this.";
  protected final String TEXT_2004 = " = null;";
  protected final String TEXT_2005 = NL + "        ";
  protected final String TEXT_2006 = ".";
  protected final String TEXT_2007 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2008 = NL + "    ";
  protected final String TEXT_2009 = " ";
  protected final String TEXT_2010 = " = ";
  protected final String TEXT_2011 = ";" + NL + "    this.";
  protected final String TEXT_2012 = " = null;";
  protected final String TEXT_2013 = NL + "    ";
  protected final String TEXT_2014 = ".";
  protected final String TEXT_2015 = "(this);";
  protected final String TEXT_2016 = NL + "    for(";
  protected final String TEXT_2017 = " ";
  protected final String TEXT_2018 = " : ";
  protected final String TEXT_2019 = ")" + NL + "    {";
  protected final String TEXT_2020 = NL + "      ";
  protected final String TEXT_2021 = "(";
  protected final String TEXT_2022 = ",null);" + NL + "    }";
  protected final String TEXT_2023 = NL + "    ";
  protected final String TEXT_2024 = ".clear();";
  protected final String TEXT_2025 = NL + "    ArrayList<";
  protected final String TEXT_2026 = "> ";
  protected final String TEXT_2027 = " = new ArrayList<";
  protected final String TEXT_2028 = ">(";
  protected final String TEXT_2029 = ");";
  protected final String TEXT_2030 = NL + "    ";
  protected final String TEXT_2031 = ".clear();" + NL + "    for(";
  protected final String TEXT_2032 = " ";
  protected final String TEXT_2033 = " : ";
  protected final String TEXT_2034 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2035 = ".";
  protected final String TEXT_2036 = "() <= ";
  protected final String TEXT_2037 = ".";
  protected final String TEXT_2038 = "())" + NL + "      {";
  protected final String TEXT_2039 = NL + "        ";
  protected final String TEXT_2040 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2041 = NL + "        ";
  protected final String TEXT_2042 = ".";
  protected final String TEXT_2043 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2044 = NL + "    ArrayList<";
  protected final String TEXT_2045 = "> ";
  protected final String TEXT_2046 = " = new ArrayList<";
  protected final String TEXT_2047 = ">(";
  protected final String TEXT_2048 = ");";
  protected final String TEXT_2049 = NL + "    ";
  protected final String TEXT_2050 = ".clear();" + NL + "    for(";
  protected final String TEXT_2051 = " ";
  protected final String TEXT_2052 = " : ";
  protected final String TEXT_2053 = ")" + NL + "    {";
  protected final String TEXT_2054 = NL + "      ";
  protected final String TEXT_2055 = ".";
  protected final String TEXT_2056 = "(this);" + NL + "    }";
  protected final String TEXT_2057 = NL + "    for(int i=";
  protected final String TEXT_2058 = ".size(); i > 0; i--)" + NL + "    {";
  protected final String TEXT_2059 = NL + "      ";
  protected final String TEXT_2060 = " ";
  protected final String TEXT_2061 = " = ";
  protected final String TEXT_2062 = ".get(i - 1);";
  protected final String TEXT_2063 = NL + "      ";
  protected final String TEXT_2064 = ".delete();" + NL + "    }";
  protected final String TEXT_2065 = NL + "    while( !";
  protected final String TEXT_2066 = ".isEmpty() )" + NL + "    {";
  protected final String TEXT_2067 = NL + "      ";
  protected final String TEXT_2068 = ".get(0).";
  protected final String TEXT_2069 = "(null);" + NL + "    }";
  protected final String TEXT_2070 = NL + "  " + NL + "  @Override" + NL + "  public void run ()" + NL + "  {" + NL + "    boolean status=false;" + NL + "    while (true) " + NL + "    {" + NL;
  protected final String TEXT_2071 = NL + "      " + NL + "      switch (m.type)" + NL + "      {";
  protected final String TEXT_2072 = " " + NL + "        default:" + NL + "      }" + NL + "      if(!status)" + NL + "      {" + NL + "        // Error message is written or  exception is raised" + NL + "      }" + NL + "    }" + NL + "  }";
  protected final String TEXT_2073 = NL + "  " + NL + "  @Override" + NL + "  public void run ()" + NL + "  {" + NL + "    boolean status=false;" + NL + "    while (true) " + NL + "    {" + NL;
  protected final String TEXT_2074 = NL + "      " + NL + "      switch (m.type)" + NL + "      {";
  protected final String TEXT_2075 = " " + NL + "        default:" + NL + "      }" + NL + "      if(!status)" + NL + "      {" + NL + "        // Error message is written or  exception is raised" + NL + "      }" + NL + "    }" + NL + "  }";
  protected final String TEXT_2076 = NL + NL + "  public String toString()" + NL + "  {" + NL + "\t  String outputString = \"\";";
  protected final String TEXT_2077 = NL + "  }";
  protected final String TEXT_2078 = "  " + NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_2079 = NL + "  ";
  protected final String TEXT_2080 = NL + "  ";
  protected final String TEXT_2081 = NL + "}";
  protected final String TEXT_2082 = NL + "  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler" + NL + "  {" + NL + "    public void uncaughtException(Thread t, Throwable e)" + NL + "    {" + NL + "      translate(e);" + NL + "      if(e.getCause()!=null)" + NL + "      {" + NL + "        translate(e.getCause());" + NL + "      }" + NL + "      e.printStackTrace();" + NL + "    }" + NL + "    public void translate(Throwable e)" + NL + "    {" + NL + "      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();" + NL + "      StackTraceElement[] elements = e.getStackTrace();" + NL + "      try" + NL + "      {" + NL + "        for(StackTraceElement element:elements)" + NL + "        {" + NL + "          String className = element.getClassName();" + NL + "          String methodName = element.getMethodName();" + NL + "          boolean methodFound = false;" + NL + "          int index = className.lastIndexOf('.')+1;" + NL + "          try {" + NL + "            java.lang.reflect.Method query = this.getClass().getMethod(className.substring(index)+\"_\"+methodName,new Class[]{});" + NL + "            UmpleSourceData sourceInformation = (UmpleSourceData)query.invoke(this,new Object[]{});" + NL + "            for(int i=0;i<sourceInformation.size();++i)" + NL + "            {" + NL + "              int distanceFromStart = element.getLineNumber()-sourceInformation.getJavaLine(i)-((\"main\".equals(methodName))?2:0);" + NL + "              if(distanceFromStart>=0&&distanceFromStart<=sourceInformation.getLength(i))" + NL + "              {" + NL + "                result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),sourceInformation.getFileName(i),sourceInformation.getUmpleLine(i)+distanceFromStart));" + NL + "                methodFound = true;" + NL + "                break;" + NL + "              }" + NL + "            }" + NL + "          }" + NL + "          catch (Exception e2){}" + NL + "          if(!methodFound)" + NL + "          {" + NL + "            result.add(element);" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "      catch (Exception e1)" + NL + "      {" + NL + "        e1.printStackTrace();" + NL + "      }" + NL + "      e.setStackTrace(result.toArray(new StackTraceElement[0]));" + NL + "    }" + NL + "  //The following methods Map Java lines back to their original Umple file / line    ";
  protected final String TEXT_2083 = NL;
  protected final String TEXT_2084 = NL + "  }" + NL + "  public static class UmpleSourceData" + NL + "  {" + NL + "    String[] umpleFileNames;" + NL + "    Integer[] umpleLines;" + NL + "    Integer[] umpleJavaLines;" + NL + "    Integer[] umpleLengths;" + NL + "    " + NL + "    public UmpleSourceData(){" + NL + "    }" + NL + "    public String getFileName(int i){" + NL + "      return umpleFileNames[i];" + NL + "    }" + NL + "    public Integer getUmpleLine(int i){" + NL + "      return umpleLines[i];" + NL + "    }" + NL + "    public Integer getJavaLine(int i){" + NL + "      return umpleJavaLines[i];" + NL + "    }" + NL + "    public Integer getLength(int i){" + NL + "      return umpleLengths[i];" + NL + "    }" + NL + "    public UmpleSourceData setFileNames(String... filenames){" + NL + "      umpleFileNames = filenames;" + NL + "      return this;" + NL + "    }" + NL + "    public UmpleSourceData setUmpleLines(Integer... umplelines){" + NL + "      umpleLines = umplelines;" + NL + "      return this;" + NL + "    }" + NL + "    public UmpleSourceData setJavaLines(Integer... javalines){" + NL + "      umpleJavaLines = javalines;" + NL + "      return this;" + NL + "    }" + NL + "    public UmpleSourceData setLengths(Integer... lengths){" + NL + "      umpleLengths = lengths;" + NL + "      return this;" + NL + "    }" + NL + "    public int size(){" + NL + "      return umpleFileNames.length;" + NL + "    }" + NL + "  } " + NL + "}";

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
  globalUmpleClass = uClass;  
  GeneratedClass gClass = uClass.getGeneratedClass();
  JavaGenerator gen = new JavaGenerator();
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
     if (uClass.numberOfComments() > 0) { append(stringBuffer, "\n{0}", Comment.format("Javadoc",uClass.getComments())); } 
     for (Position p : uClass.getPositions()) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append( p.getLineNumber() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( p.getRelativePath(uClass, "Java") );
    stringBuffer.append(TEXT_7);
     } 
    stringBuffer.append(TEXT_8);
     if (uClass.getIsAbstract()) { append(stringBuffer, "{0} ", "abstract"); } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(uClass.getName());
    stringBuffer.append( gen.translate("isA",uClass) );
    

for (StateMachine smq : uClass.getStateMachines())
  {
    if (smq.isQueued())
    {
      append(stringBuffer," implements Runnable");
      break;
    }
    else if(smq.isPooled())
    {
      append(stringBuffer," implements Runnable");
      break;
    }
  }


    stringBuffer.append(TEXT_10);
    getMemberCode(stringBuffer, model,uClass,gClass,gen,isFirst);
  getConstructorCode(stringBuffer, model,uClass,gClass,gen,isFirst, false);
  getAttributeCode(stringBuffer, model,uClass,gClass,gen,isFirst,false);
  getStateMachine1Code(stringBuffer, model,uClass,gClass,gen,isFirst,false);
  getAssociationCode(stringBuffer, model,uClass,gClass,gen,isFirst,false);
  getEqualsCode(stringBuffer, model,uClass,gClass,gen,isFirst);
  getStateMachine2Code(stringBuffer, model,uClass,gClass,gen,isFirst);
  getDeleteCode(stringBuffer, model,uClass,gClass,gen,isFirst,false);
  getExtraMethodsCode(stringBuffer, model,uClass,gClass,gen,isFirst);
  getAllExtraCode(stringBuffer, model,uClass,gClass,gen,isFirst);
  return stringBuffer.toString();
    } 
    private String getMemberCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
    
{
  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
  
    if (!av.isConstant() && !av.getIsAutounique() && !av.getIsUnique())
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
      if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); }
      append(stringBuffer, "  public static final {0} {1} = {2};", gen.getType(av), av.getName(), gen.translate("parameterValue",av));
    }
    else if (av.getIsAutounique())
    {
      String defaultValue = av.getValue() == null ? "1" : av.getValue();
      appendln(stringBuffer, "");
      append(stringBuffer, "  private static int next{0} = {1};", av.getUpperCaseName(), defaultValue);
    }
    else if (av.getIsUnique())
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  private static Map<{0}, {1}> {2} = new HashMap<{0}, {1}>();",
        av.getType(),
        av.getUmpleClass().getName(),
        gen.translate("uniqueMap", av));
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
    append(stringBuffer, "  private static {0} theInstance = null;", uClass.getName());
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
    
    if("internal".equals(av.getModifier()))
    {
      if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); }
    }
    append(stringBuffer, "  private {0} {1};", type, attribute);
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
    if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); }
    append(stringBuffer, "  private int {0};", gen.translate("attributeOne",av));
  }
  
  isFirst = true;
  for( TraceDirective td : uClass.getTraceDirectives() )
  {
	  for( TraceCondition traceCond : td.getCondition() )
	  {
		  if (isFirst && (traceCond.getConditionType().equals("until") ||  traceCond.getConditionType().equals("after")))
		  {
			  appendln(stringBuffer, "");
			  append(stringBuffer, "  //Trace Attributes");
			  isFirst = false;
		  }
		  if(traceCond.getConditionType().equals("until") )
		  {
			  for( AttributeTraceItem traceAttr : td.getAttributeTraceItems() )
			  {
				  for( UmpleVariable attr : traceAttr.getUmpleVariables() )
				  {
					  String attrName = gen.translate("attribute",(Attribute)attr);
					  attrName = attrName.substring(0,1).toUpperCase()+attrName.substring(1).toLowerCase();
					  appendln(stringBuffer, "");
					  append(stringBuffer, "  private boolean {0} = true;", "trace" + attrName + "Until");  
				  }
			  }  
		  }
		  if(traceCond.getConditionType().equals("after") )
		  {
			  for( AttributeTraceItem traceAttr : td.getAttributeTraceItems() )
			  {
				  for( UmpleVariable attr : traceAttr.getUmpleVariables() )
				  {
					  String attrName = gen.translate("attribute",(Attribute)attr);
					  attrName = attrName.substring(0,1).toUpperCase()+attrName.substring(1).toLowerCase();
					  appendln(stringBuffer, "");
					  append(stringBuffer, "  private boolean {0} = false;", "trace" + attrName + "After");  
				  }
			  }
		  }
		  
	  }
	  
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
      if(nestedSm.getContainsHistoryState())
      {
        append(stringBuffer, "\n  private {0} {1}H;", gen.translate("type",nestedSm), gen.translate("stateMachineOne", nestedSm));
      }
      if(nestedSm.getContainsDeepHistoryState())
      {
        append(stringBuffer, "\n  private {0} {1}HStar;", gen.translate("type",nestedSm), gen.translate("stateMachineOne", nestedSm));
      }
    }  
  }
  
  boolean foundQueued = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    if(sm.isQueued())
    {
      foundQueued = true;
    }
  }
  if(foundQueued == true)
  {
    append(stringBuffer,"\n  ");
    append(stringBuffer,"\n  //enumeration type of messages accepted by {0}", uClass.getName());
    append(stringBuffer, "\n  enum MessageType { {0} }", gen.translate("listEventsForQSM",uClass));   
  }
  for(StateMachine sm : uClass.getStateMachines())
  {
    if(sm.isQueued())
    {
       append(stringBuffer,"\n  ");
       append(stringBuffer,"\n  MessageQueue queue;");
       append(stringBuffer,"\n  Thread removal;");
    }
    break;
  }
  
  for(StateMachine sm : uClass.getStateMachines())
  {  
    if(sm.isPooled())
    {
      append(stringBuffer,"\n  ");
      append(stringBuffer,"\n  MessagePool pool;");
      append(stringBuffer,"\n  Thread removal;");
      append(stringBuffer,"\n  ");
      append(stringBuffer,"\n  //enumeration type of messages accepted by {0}", uClass.getName());
      append(stringBuffer, "\n  enum MessageType { {0} }", gen.translate("listEventsForPooledSM",uClass));
    }
    break;
  }
  boolean foundPooled = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    if (sm.isPooled()){
      foundPooled = true;
    }
    break;
  }
  if(foundPooled == true)
  {
    append(stringBuffer,"\n");
    append(stringBuffer,"\n  // Map for a {0} pooled state machine that allows querying which events are possible in each map", uClass.getName());
    append(stringBuffer,"\n");
    append(stringBuffer,"\n  public static final Map<Object, HashSet<MessageType>> stateMessageMap = new HashMap<Object, HashSet<MessageType>>();");
    append(stringBuffer,"\n  static {");
  }
   
  for(StateMachine sm : uClass.getStateMachines())
  {
    if(sm.isPooled())
    {
      append(stringBuffer,"\n  {0}",gen.translate("listMessageTypesStates",sm));
    }
  }
  
  if(foundPooled == true)
  {
    append(stringBuffer,"\n  }");
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
    
    //if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Association Javadoc", av.getComments())); }
    
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
      append(stringBuffer, "  private boolean {0};", gen.translate("attributeCanSet",av));
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
    if (!av.getIsNavigable())
    {
      continue;
    }
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
      append(stringBuffer, "  private boolean {0};", gen.translate("associationCanSet",av));
    }
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null  && !av.isImmutable())
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

    return stringBuffer.toString();
    }
  private UmpleClass globalUmpleClass = null;
  public Map<String,UncaughtException> uncaughtExceptions = new HashMap<String,UncaughtException>();
  
    private String getConstructorCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst, boolean isFake)
  {
    Integer baseJavaLine = stringBuffer.toString().split("\\n").length;
    stringBuffer.append(TEXT_11);
    
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

  String accessibility = uClass.getIsSingleton() ? "private" : "public";
  append(stringBuffer,"\n  {0} {1}({2})",new Object[] {accessibility, uClass.getName(), gClass.getLookup("constructorSignature")});

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
    addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customConstructorPrefixCode,uClass.getName());
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
    if (av != null  && !av.isImmutable())
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
    if (av.getIsAutounique() || av.getIsUnique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)) || av.getIsDerived())
    {
      continue;
    }
    
    TraceItem traceItem = av.getTraced("constructor",uClass);
    
    if (av.getIsList())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_14);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_15);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_16);
     
    }
    else if (av.isImmutable() && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_17);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_18);
    
    }
    else if (av.isImmutable())
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_19);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_23);
     
    }
    else
    {
      hasBody = true;
      if(!av.getIsLazy()){
         
    
  String parameterLookup = av.getValue() == null || av.getModifier().equals("fixml") ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_24);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_26);
    
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
  	   defaultValue = "null";
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
   }
   else
   {
       defaultValue = gen.translate("parameterValue",av);
   }
  
  // Only assign a value if we could find a default
  if(defaultValue != null)
  { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_29);
    } 
    
      }
    }
    
    if(traceItem!=null)
    {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append( traceItem.trace(gen,av,"at_p",uClass) );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( traceItem.getPeriodClause() );
    stringBuffer.append(TEXT_33);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_36);
    
    }
    else if (av.getIsUnique())
    {
   	  hasBody = true;
   	  
    stringBuffer.append(TEXT_37);
    stringBuffer.append(gen.translate("setMethod", av));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(av.getName());
    stringBuffer.append(TEXT_40);
    
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
  boolean doneOnce=false;
  String firstSorted = "";
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
  	if (av.isOnlyOne() && av.getRelatedAssociation().isMany() && av.getRelatedAssociation().isSorted() && av.getIsNavigable())
  	{
  		if("".equals(firstSorted))
  		{
  			firstSorted = gen.translate("attributeOne",av) + "=" + gen.translate("parameterOne",av) + ";";
  		}
  		else
  		{
  			if(!doneOnce)
  			{
  				append(stringBuffer,"\n    {0}\n    {1}\n    {2}","// Direct set of variable needed to ensure consistency","// for multiple sorted associations",firstSorted);
  				doneOnce = true;
  			}	
  			append(stringBuffer,"\n    {0}={1};", gen.translate("attributeOne",av),gen.translate("parameterOne",av));
    	}
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
        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_45);
    
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
  

    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_55);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        hasBody = true;
        
     String requiredNumber = StringFormatter.format("{0}", av.getMultiplicity().getUpperBound()); 
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_65);
    
      }
      else if (av.isMany() && av.isImmutable())
      {
      	hasBody = true;
        
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_74);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_77);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_86);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_89);
    
    }
    else
    {
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOnlyOne())
  {
    
    stringBuffer.append(TEXT_90);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_96);
    
  }
  else if (av.isOptionalMany())
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
  

    stringBuffer.append(TEXT_97);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_106);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_111);
    
  }
  else
  {
    continue;
  }
  hasBody = true;

    
    }
  }
  
  boolean foundQueued=false;
  boolean foundPooled=false;
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
      
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_115);
    if (nestedSm.getContainsDeepHistoryState()){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(nestedSm.getState(1).getName());
    stringBuffer.append(TEXT_119);
    }
    if (nestedSm.getContainsHistoryState()){
    stringBuffer.append(TEXT_120);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(nestedSm.getState(1).getName());
    stringBuffer.append(TEXT_123);
    }
    
    }
    
    stringBuffer.append(TEXT_124);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_127);
    
    for (StateMachine smq : uClass.getStateMachines())
    {
      if (smq.isQueued() || smq.isPooled())
      {
        //nothing to do
      }
    }

    
    if (sm.isQueued())
    {
      foundQueued = true;
    }
    if (sm.isPooled())
    {
      foundPooled = true;
    }
  }
  if(foundQueued == true)
  {
    append(stringBuffer,"\n    queue = new MessageQueue();");
    append(stringBuffer,"\n    removal=new Thread(this);");
    append(stringBuffer,"\n    //start the thread of {0}", uClass.getName());
    append(stringBuffer,"\n    removal.start();");
  }
  if(foundPooled == true)
  {
    append(stringBuffer,"\n    pool = new MessagePool();");
    append(stringBuffer,"\n    removal=new Thread(this);");
    append(stringBuffer,"\n    //start the thread of {0}", uClass.getName());
    append(stringBuffer,"\n    removal.start();");
  }
  
  if (customConstructorPostfixCode != null)
  {
    addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customConstructorPostfixCode,uClass.getName());
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
  
  // fixml attribute (create empty constructor)
  boolean fixmlAttr = false;
  boolean emptyConstructor = false;
  
  for (Attribute av : uClass.getAttributes())
	  if ("fixml".equals(av.getModifier()))
	  {
		  fixmlAttr = true;
		  break;
	  }

  for( CodeInjection ci  : uClass.getCodeInjections())
	  if( ci.getOperation().equals("emptyConstructor"))
	  {
		  emptyConstructor = true;
		  break;
	  }

  for (Attribute av : uClass.getAttributes())
  {
	  if ("fixml".equals(av.getModifier()))
	  {
		  accessibility = uClass.getIsSingleton() ? "private" : "public";
		  appendln(stringBuffer,"");
		  appendln(stringBuffer,"");
		  appendln(stringBuffer,"  {0} {1}()",new Object[] {accessibility, uClass.getName()});
		  appendln(stringBuffer,"  {");
		  for (Attribute a : uClass.getAttributes())
			  if ("fixml".equals(a.getModifier()) && a.getValue() != null )
				  append(stringBuffer, "    {0} = {1};\n", a.getName(),a.getValue());
		  for( CodeInjection ci  : uClass.getCodeInjections())
			  if( ci.getOperation().equals("emptyConstructor"))
				  appendln(stringBuffer,"    {0}",ci.getCode());
		  appendln(stringBuffer,"  }");
		  break;
	  }
  }

  if( fixmlAttr == false && emptyConstructor == true )
  {
	  accessibility = uClass.getIsSingleton() ? "private" : "public";
	  appendln(stringBuffer,"");
	  appendln(stringBuffer,"");
	  appendln(stringBuffer,"  {0} {1}()",new Object[] {accessibility, uClass.getName()});
	  appendln(stringBuffer,"  {");
	  for( CodeInjection ci  : uClass.getCodeInjections())
		  if( ci.getOperation().equals("emptyConstructor"))
			  appendln(stringBuffer,"    {0}",ci.getCode());
	  appendln(stringBuffer,"  }");
  }

  if (uClass.getIsSingleton())
  {
    appendln(stringBuffer, "");
    
    stringBuffer.append(TEXT_128);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_130);
    
  }

    
  if (isOneToOne)
  {
    
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_131);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_133);
    
  if (!uClass.isRoot())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    super({0});", gClass.getParentClass().getLookup("constructorSignature_caller"));
    hasBody = true;
  }
  
  if (customConstructorPrefixCode != null) 
  {
    addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customConstructorPrefixCode,uClass.getName());
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
      
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_136);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_138);
     
    }
    else if (av.getIsLazy())
    {
      hasBody = true;
      
    
  String parameterLookup = null; // av.getValue() == null ? "parameterOne" : "parameterValue";
  String defaultValue = null;
  
 
  if(av.getValue() == null)
  {
     // Try to assign a null value or 0 value if we recognize
     // one of Umple's built in data types. (http://cruise.site.uottawa.ca/umple/UmpleBuiltinDataTypes.html)

     if(av.getType().equals("String") || av.getType().equals("Date") || av.getType().equals("Time"))
     {
  	   defaultValue = "null";
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
   }
   else
   {
       defaultValue = gen.translate("parameterValue",av);
   }
  
  // Only assign a value if we could find a default
  if(defaultValue != null)
  { 
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_141);
    } 
    
    }
    else
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null || av.getModifier().equals("fixml") ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_144);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_147);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    stringBuffer.append(TEXT_151);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_154);
    
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
    
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_161);
    
  }
  else if (av.isOptionalMany())
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
  

    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_171);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_176);
    
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
    addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customConstructorPostfixCode,uClass.getName());
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


    return stringBuffer.toString();
    } 
    private String getAttributeCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst, boolean isFake)
  { 
    String umpleSourceFile = "";
    Integer baseJavaLine = stringBuffer.toString().split("\\n").length;
    stringBuffer.append(TEXT_177);
    
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
        
    stringBuffer.append(TEXT_178);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_181);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_182);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(TEXT_184);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_185);
    stringBuffer.append( gen.translate("associationOne",av));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(TEXT_188);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_189);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_190);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_194);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_195);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_196);
    stringBuffer.append( gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(TEXT_199);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_200);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_202);
     if (customResetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customResetPrefixCode,gen.translate("resetMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_203);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_t", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_204);
    stringBuffer.append( gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(TEXT_207);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_t", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_208);
     if (customResetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customResetPostfixCode,gen.translate("resetMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_209);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_210);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_213);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_214);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_a", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(TEXT_218);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_a", uClass)+"\n":"")
);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_222);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_223);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_r", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(TEXT_227);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_r", uClass)+"\n":"")
);
     if (customRemovePostfixCode != null) {addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); }

    stringBuffer.append(TEXT_228);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_229);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_232);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_233);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(TEXT_237);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_238);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_239);
    
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
      
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_242);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_243);
    stringBuffer.append( gen.translate("typeMany",av));
    stringBuffer.append(TEXT_244);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(TEXT_247);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av));
       append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_248);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_251);
     if (customGetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPrefixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_252);
    stringBuffer.append( gen.translate("typeMany",av));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(TEXT_258);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_ga", uClass)+"\n":"")
);
     if (customGetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPostfixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_261);
     if (customNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPrefixCode,gen.translate("numberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_262);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(TEXT_264);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_n", uClass, "number")+"\n":"")
);
     if (customNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPostfixCode,gen.translate("numberOfMethod",av));
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_266);
     if (customHasManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPrefixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_267);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(TEXT_269);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_h", uClass)+"\n":"")
);
     if (customHasManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPostfixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); }

    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_273);
     if (customIndexOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPrefixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(TEXT_277);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
     if (customIndexOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPostfixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_278);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_280);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_281);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_282);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_283);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_284);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(TEXT_286);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av));
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_287);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_288);
    addUncaughtExceptionVariables(gen.translate("getMethod",av),av.getPosition().getFilename(),av.getPosition().getLineNumber(),stringBuffer.toString().split("\\n").length-1,1);
    stringBuffer.append(TEXT_289);
    
      }
      else if (av.getIsDerived())
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(TEXT_293);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_294);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_295);
    addUncaughtExceptionVariables(gen.translate("getMethod",av),av.getPosition().getFilename(),av.getPosition().getLineNumber(),stringBuffer.toString().split("\\n").length-1,1);
    stringBuffer.append(TEXT_296);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_297);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_298);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_299);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_300);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_301);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(TEXT_304);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_305);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_306);
    
      }
      else
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_308);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_309);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_310);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_312);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_313);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_315);
     if (customGetDefaultPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getDefaultMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_318);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(TEXT_320);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetDefaultPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetDefaultPostfixCode,gen.translate("getDefaultMethod",av));
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_322);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_325);
     if (customGetDefaultPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_326);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_327);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_328);
    
      }
      
      if (av.getIsUnique())
      {
        if (customGetUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_329);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_333);
     if (customGetUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetUniquePrefixCode,gen.translate("getUniqueMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_334);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(TEXT_339);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetUniquePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetUniquePostfixCode,gen.translate("getUniqueMethod",av)); 
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_341);
    
        } 
        else 
        {
          
    stringBuffer.append(TEXT_342);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_346);
     if (customGetUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetUniquePrefixCode,gen.translate("getUniqueMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_347);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_350);
    
        }
        if (customHasUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_354);
     if (customHasUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasUniquePrefixCode,gen.translate("hasUniqueMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_355);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(TEXT_359);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customHasUniquePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasUniquePostfixCode,gen.translate("hasUniqueMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_361);
    
        }
        else
        {
          
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_365);
     if (customHasUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasUniquePrefixCode,gen.translate("hasUniqueMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_366);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_369);
    
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
        
    stringBuffer.append(TEXT_370);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_371);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_372);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_373);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_374);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(TEXT_377);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_378);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_379);
    
      }
      else
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_381);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_382);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_383);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_385);
    
      }
      appendln(stringBuffer, "");
    }
  }

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes()) 
  {
    if (!av.getType().equals("Boolean") || av.getIsAutounique() || av.isConstant() || "internal".equals(av.getModifier()))
    {
      continue;
    }
  
    TraceItem traceItem = av.getTraced("getMethod", uClass);

    String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("isMethod",av)));
    String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("isMethod",av)));
    
    if (av.getIsDerived() && customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_387);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_388);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_389);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_390);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_391);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(TEXT_393);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("isMethod",av)); 
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_394);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_395);
    
    }
    else if (av.getIsDerived())
    {
      
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_397);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_398);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_399);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.translate("parameterValue",av));
    stringBuffer.append(TEXT_401);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_402);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_403);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_404);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_405);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_406);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_407);
    stringBuffer.append( gen.translate("attributeOne",av) );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(TEXT_409);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_410);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_411);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_413);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_414);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_415);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_417);
    
    }
      
    appendln(stringBuffer, "");
  }


    return stringBuffer.toString();
    } 
    private String getStateMachine1Code(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst, boolean isFake)
  {
    Integer baseJavaLine = stringBuffer.toString().split("\\n").length;
    
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

    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_421);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_422);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_425);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_426);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for(Event e : uClass.getEvents())
  {
    
    
  int javaLine = stringBuffer.toString().split("\\n").length+7;

  StringBuffer allCases = new StringBuffer();
  StringBuffer allDeclarations = new StringBuffer();
  
  StringBuilder actionLineNumbers = new StringBuilder();
  StringBuilder actionFileNames = new StringBuilder();
  StringBuilder actionJavaLineNumbers = new StringBuilder();
  StringBuilder actionLengths = new StringBuilder();
  String umpleSourceFileFormat = "\n  @umplesourcefile(line={{0}}, file={{1}}, javaline={{2}}, length={{3}})";
  String customEventPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("eventMethod",e)));
  String customEventPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("eventMethod",e)));
  if(e.getName().startsWith("_")&&(customEventPrefixCode==null||customEventPostfixCode==null))
  {
    boolean queued = false;
    for(StateMachine sm : uClass.getStateMachines(e))
    {
      if(sm.isQueued())
      {
        queued = true;
        break;
      }
    }
    if(queued)
    {
      if(customEventPrefixCode==null)
      {
        customEventPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("eventMethod",e)));
      }
      if(customEventPostfixCode==null)
      {
        customEventPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("eventMethod",e)));
      }
  
    }
  }
  for(StateMachine sm : uClass.getStateMachines(e))
  {
    allDeclarations.append(StringFormatter.format("\n    {0} {1} = {2};",gen.translate("type",sm),gen.translate("parameterOne",sm),gen.translate("stateMachineOne", sm)));
    if(sm.getContainsHistoryState())
    {     
      allDeclarations.append(StringFormatter.format("\n    if ({0} != {1}.Null){",gen.translate("stateMachineOne",sm),gen.translate("type",sm)));
    	allDeclarations.append(StringFormatter.format("{0}H = {1};}",gen.translate("stateMachineOne",sm),gen.translate("stateMachineOne", sm)));    
      javaLine++;
    }
    if(sm.getContainsDeepHistoryState())
    { 
      allDeclarations.append(StringFormatter.format("\n    if ({0} != {1}.Null){",gen.translate("stateMachineOne",sm),gen.translate("type",sm)));
    	allDeclarations.append(StringFormatter.format("{0}HStar = {1};}",gen.translate("stateMachineOne",sm),gen.translate("stateMachineOne", sm)));
      javaLine++;
    }
    allCases.append(StringFormatter.format("\n    switch ({0})\n",gen.translate("parameterOne",sm)));
    allCases.append(StringFormatter.format("    {\n"));
    javaLine+=3;
    for(State state : sm.getStates())
    {
  	  TraceItem traceItem = state.getTraced("transition",uClass);
      List<Transition> allT = state.getTransitionsFor(e);
  
      if (allT.size() == 0)
      {
        continue;
      }

      allCases.append(StringFormatter.format("      case {0}:\n",gen.translate("stateOne",state)));
      javaLine++;

      boolean needsBreak = true;
      for (Transition t : allT)
      {
        
        State nextState = t.getNextState();
        String tabSpace = t.getGuard() == null ? "        " : "          ";
        StateMachine exitSm = state.exitableStateMachine(nextState);
        
        String condition = t.getGuard()!=null?t.getGuard().getCondition(gen):"if ()\n{";
        if (!"if ()\n{".equals(condition))
        {
            addUncaughtExceptionVariables(gen.translate("eventMethod",e),
                                        t.getGuard().getPosition().getRelativePath(sm.getUmpleClass(),"Java").replace("\\","/").replaceAll(".*/","").replace("\"",""),
                                        t.getGuard().getPosition().getLineNumber(),
                                        javaLine-1,
                                        condition.split("\\n").length-1);
            allCases.append(GeneratorHelper.doIndent(condition, "        ")+"\n");
            javaLine+=1+condition.split("\\n").length;
          
        }
        if (exitSm != null && !e.getIsInternal() && !state.isSameState(nextState,exitSm)) 
        {
          allCases.append(StringFormatter.format("{0}{1}();\n",tabSpace,gen.translate("exitMethod",exitSm)));
          javaLine++;
        }
        if (t.getAction() != null)
        {
          Action a1 = t.getAction();
          Position p = a1.getPosition();
          if (p != null) {
            addUncaughtExceptionVariables(gen.translate("eventMethod",e),
                                        p.getRelativePath(sm.getUmpleClass(),"Java").replace("\\","/").replaceAll(".*/","").replace("\"",""),
                                        p.getLineNumber(),
                                        javaLine-2,
                                        a1.getActionCode().split("\\n").length);
            allCases.append("        // line " + p.getLineNumber() + " \"" + p.getRelativePath(sm.getUmpleClass(), "Java") + "\"\n");
            javaLine++;
          }
          allCases.append(StringFormatter.format("{0}{1}\n",tabSpace,a1.getActionCode()));
          javaLine+=a1.getActionCode().split("\\n").length;
        }
        
        StateMachineTraceItem traceStmItem = null;
        
        traceStmItem = state.getTrace("entry",uClass,t);
        allCases.append(traceStmItem!=null?traceStmItem.trace(gen, t, "sm_t", uClass)+"\n":"");
        
        traceStmItem = state.getTrace("exit",uClass,t);
        allCases.append(traceStmItem!=null?traceStmItem.trace(gen, t, "sm_t", uClass)+"\n":"");
        
        traceStmItem = state.getTrace("state",uClass,t);
        allCases.append(traceStmItem!=null?traceStmItem.trace(gen, t, "sm_t", uClass)+"\n":"");
        
        traceStmItem = state.getTrace("transition",uClass,t);
        allCases.append(traceStmItem!=null?traceStmItem.trace(gen, t, "sm_t", uClass)+"\n":"");
        	
//        allCases.append(traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, t,"sm_t", uClass)+"\n":"");
        if (nextState.getIsHistoryState() == true)
        {
        	allCases.append(StringFormatter.format("{0}{1}({2}{3});\n",tabSpace,gen.translate("setMethod",nextState.getStateMachine()),gen.translate("stateMachineOne",nextState.getStateMachine()),gen.translate("stateOne",nextState)));
        	
        }
        else
        {
        	allCases.append(StringFormatter.format("{0}{1}({2}.{3});\n",tabSpace,gen.translate("setMethod",nextState.getStateMachine()),gen.translate("type",nextState.getStateMachine()),gen.translate("stateOne",nextState)));
		}
//        allCases.append(traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, t,"sm_t", uClass)+"\n":"");

        
        allCases.append(StringFormatter.format("{0}wasEventProcessed = true;\n",tabSpace));
        allCases.append(StringFormatter.format("{0}break;\n",tabSpace));
        
        javaLine+=traceItem!=null?4:3;
        
        if (!"if ()\n{".equals(condition))
        {
          allCases.append(StringFormatter.format("        }\n"));
          javaLine++;
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
        javaLine++;
      }
    } 
    allCases.append(StringFormatter.format("      default:\n"));
    allCases.append(StringFormatter.format("        // Other states do respond to this event\n"));
    
    for(State s : sm.getStates())
    {
      Transition t1=null;
      Transition t2=null;
      String exitEvent=null;
      if (sm.getParentState() != null)
      {
        State parentState = sm.getParentState();
        exitEvent = gen.translate("exitMethod",parentState);
      }
      for(Transition tran: s.getTransitions())
      {
        if(tran.getEvent().isUnspecified())
        {
          t1=tran;
        }
        if(tran.getEvent().getName().equals(e.getName()))
        {
          t2=tran;
        }
      }
      if(s.getTransitions().contains(t1) && s.getTransitions().contains(t2))
      {
        if(!e.isUnspecified() && !e.getName().equals(exitEvent))
        {
          allCases.append(StringFormatter.format("        wasEventProcessed = unspecified("));
          allCases.append(StringFormatter.format("get"));
          allCases.append(StringFormatter.format("{0}",gen.translate("type",sm)));
          allCases.append(StringFormatter.format("("));
          allCases.append(StringFormatter.format(").toString()"));
          allCases.append(StringFormatter.format(", "));
          allCases.append(StringFormatter.format("\""));
          allCases.append(StringFormatter.format(e.getName()));
          allCases.append(StringFormatter.format("\""));
          allCases.append(StringFormatter.format(");\n"));
        }
      }
    }
    allCases.append(StringFormatter.format("    }\n"));
    javaLine+=3;
  }

  
  String scope = e.getIsInternal() || e.isAutoTransition() ? "private" : "public";
  String eventOutput = allDeclarations.toString() + allCases.toString();
    stringBuffer.append(TEXT_427);
    stringBuffer.append( scope );
    stringBuffer.append(TEXT_428);
    for (StateMachine sm : uClass.getStateMachines()){if((sm.isQueued() && e.getIsInternal() == false && e.isAutoTransition() == false && !e.getIsTimer() && !e.isUnspecified()) || (sm.isPooled() && e.getIsInternal() == false && e.isAutoTransition() == false  && !e.getIsTimer() && !e.isUnspecified())){append(stringBuffer,"_");}break;}
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_429);
    stringBuffer.append( (e.getArgs()==null?"":e.getArgs()));
    if(e.isUnspecified()){append(stringBuffer,"String state, String event");}
    stringBuffer.append(TEXT_430);
     if (customEventPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customEventPrefixCode,gen.translate("eventMethod",e));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customEventPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_431);
    stringBuffer.append(TEXT_432);
    stringBuffer.append( eventOutput );
     if (customEventPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customEventPostfixCode,gen.translate("eventMethod",e)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customEventPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_433);
    
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
      TraceItem traceItem = s.getTraced("entry",uClass);
      allExitCases.append(StringFormatter.format("    if ({0} == {1}.{2} && {3} != {1}.{2} ) { {4}(); }\n"
        , gen.translate("stateMachineOne",sm)
        , gen.translate("type",sm)
        , gen.translate("stateOne",s)
        , gen.translate("parameterOne",sm)
        , gen.translate("exitMethod",s)
      ));
      allEnterCases.append(
        traceItem!=null/*&&traceItem.getIsPost()*/?traceItem.trace(gen, s,"sm_e", uClass)+"\n":"");      
    }

    if (hasEntry)
    {
      TraceItem traceItem = s.getTraced("exit",uClass);
      allEnterCases.append(StringFormatter.format("    if ({0} != {1}.{2} && {3} == {1}.{2} ) { {4}(); }\n"
        , gen.translate("stateMachineOne",sm)
        , gen.translate("type",sm)
        , gen.translate("stateOne",s)
        , gen.translate("parameterOne",sm)
        , gen.translate("enterMethod",s)
      ));
      allEnterCases.append(
        traceItem!=null/*&&traceItem.getIsPost()*/?traceItem.trace(gen, s,"sm_x", uClass)+"\n":"");      
    }
  }
  
  String exitCasesOutput = allExitCases.toString().trim();
  String enterCasesOutput = allEnterCases.toString().trim();

    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_435);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_436);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_437);
     if (!exitCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",exitCasesOutput); } 
     if (!enterCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",enterCasesOutput); } 
    stringBuffer.append(TEXT_438);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_439);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_440);
    
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

  List<String> entryFileNames = new ArrayList<String>();
  List<Integer> entryUmpleLineNumbers = new ArrayList<Integer>();
  List<Integer> entryJavaLineNumbers = new ArrayList<Integer>();
  List<Integer> entryLengths = new ArrayList<Integer>();
  int preJavaLine = stringBuffer.toString().split("\\n").length;
  int entryJavaLine = stringBuffer.toString().split("\\n").length+(customSetPostfixCode != null?customSetPostfixCode.split("\\n").length:0)+(customSetPrefixCode != null?customSetPrefixCode.split("\\n").length:0)+10+(parentState != null?2:0);
  int exitJavaLine = stringBuffer.toString().split("\\n").length+(customExitPrefixCode != null?customExitPrefixCode.split("\\n").length:0)+7;
  
  for(State state : sm.getStates())
  {
    boolean hasThisEntry = false;
    boolean hasThisExit = false;
    for(Action action : state.getActions())
    {
      if ("entry".equals(action.getActionType()))
      {
        TraceItem traceItem = state.getTraced("entry",uClass);
        if (!hasThisEntry)
        {
          if (!isFirstEntry)
          {
            entryActions.append("\n      ");
            entryJavaLine++;
          }
          entryActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
          entryJavaLine++;
        }
        hasEntry = true;
        hasThisEntry = true;
        isFirstEntry = false;
        if(traceItem!=null)
        {
          entryActions.append("\n"+traceItem.trace(gen, state,"sm_e", uClass));
          entryJavaLine++;
        }
        Position p = action.getPosition();
        if (p != null) {
          entryActions.append("\n        // line " + p.getLineNumber() + " \"" + p.getRelativePath(sm.getUmpleClass(), "Java") + "\"");
          entryFileNames.add(p.getRelativePath(sm.getUmpleClass(), "Java").replace("\\","/").replaceAll(".*/",""));
          entryUmpleLineNumbers.add(p.getLineNumber());
          entryJavaLineNumbers.add(entryJavaLine-1);
          entryLengths.add(action.getActionCode().split("\\n").length);
        }

        if (state.getIsDeepHistoryState() == true){
          
          String actionCode = action.getActionCode();
          int x = actionCode.lastIndexOf('.');
          int y = actionCode.indexOf(')',x);
          String substate = actionCode.substring(x+1,y);
          String beginning = actionCode.substring(0,x + 1);
          String end = actionCode.substring(y);
          actionCode = beginning.concat("HStar").concat(end);
          
          entryActions.append(StringFormatter.format("\n        if({0}HStar == {1}.{2})", gen.translate("stateMachineOne",sm), gen.translate("type",sm), substate));
          entryJavaLine++;
          entryActions.append("\n        {");
          entryJavaLine++;  
          
          entryActions.append("\n          " + actionCode);
          entryJavaLine+=actionCode.split("\\n").length;
          

          //TODO: add more spaces if deepHistory
          //entryActions.append(StringFormatter.format("{0}{1}({2}{3});","\n          ",gen.translate("setMethod",state.getStateMachine()),gen.translate("stateMachineOne",state.getStateMachine()),gen.translate("stateOne",state)));
          //entryJavaLine++;
          entryActions.append("\n        }");
          entryJavaLine++;
        }
        else{
          entryActions.append("\n        " + action.getActionCode());
          entryJavaLine+=action.getActionCode().split("\\n").length;
        }

      }
      else if ("exit".equals(action.getActionType()))
      {
        TraceItem traceItem = state.getTraced("exit",uClass);
        TraceItem traceItemActivity = state.getTraced("activity",uClass);
        
        if (!hasThisExit)
        {
          if (!isFirstExit)
          {
            exitActions.append("\n      ");
            exitJavaLine++;
          }
          isFirstExit = false;
          exitActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
          exitJavaLine++;
        }
        hasExit = true;
        hasThisExit = true;
        isFirstExit = false;
        if(traceItem!=null)
        {
          exitActions.append("\n"+traceItem.trace(gen, state,"sm_x", uClass));
          exitJavaLine++;
        }
        Position p = action.getPosition();
        if (p != null) {
          exitActions.append("\n        // line " + p.getLineNumber() + " \"" + p.getRelativePath(sm.getUmpleClass(), "Java") + "\"");
          addUncaughtExceptionVariables(gen.translate("exitMethod",sm),
                                        p.getRelativePath(sm.getUmpleClass(), "Java").replace("\\","/").replaceAll(".*/",""),
                                        p.getLineNumber(),
                                        exitJavaLine-1,
                                        action.getActionCode().split("\\n").length);
        }
        if(traceItemActivity!=null)
        {
        	exitActions.append("\n        " + action.getActionCode().substring(0, action.getActionCode().length() - 1).concat(traceItemActivity.trace(gen, state.getActivity(),"sm_di", uClass))+" }");
            exitJavaLine+=action.getActionCode().split("\\n").length;
        	exitJavaLine++;
        }
        else
        {
        	exitActions.append("\n        " + action.getActionCode());
            exitJavaLine+=action.getActionCode().split("\\n").length;
        }
      }
    }
    if (state.getActivity() != null)
    {
      if (!hasThisEntry)
      {
        if (!isFirstEntry)
        {
          entryActions.append("\n      ");
          entryJavaLine++;
        }
        entryActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
        entryJavaLine++;
      }
      TraceItem traceItem = state.getTraced("activity",uClass);
      hasEntry = true;
      hasThisEntry = true;
      isFirstEntry = false;
      
      if(traceItem!=null)
      {
    	  entryActions.append("\n"+traceItem.trace(gen, state.getActivity(),"sm_da", uClass));
    	  entryJavaLine++;
      }
      entryActions.append(StringFormatter.format("\n        {1} = new DoActivityThread(this,\"{0}\");",gen.translate("doActivityMethod",state),gen.translate("doActivityThread",state)));
      entryJavaLine++;
    }
    
    if (hasThisEntry)
    {
      entryActions.append("\n        break;");
      entryJavaLine++;
    }
    
    if (hasThisExit)
    {
      exitActions.append("\n        break;");
      exitJavaLine++;
    }
    
  }

     if (hasExit) {
  
    stringBuffer.append(TEXT_441);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_442);
     if (customExitPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customExitPrefixCode,gen.translate("exitMethod",sm));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_443);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(TEXT_445);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_446);
     if (customExitPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customExitPostfixCode,gen.translate("exitMethod",sm)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_447);
     
    List<Integer> tempList = new ArrayList<Integer>();
    tempList.addAll(entryJavaLineNumbers);
    entryJavaLineNumbers.clear();
    for(Integer i: tempList){
      entryJavaLineNumbers.add(i+(stringBuffer.toString().split("\\n").length-preJavaLine));
    }
  }
  if(entryJavaLineNumbers.size()>0){
    String methodName = gen.translate("setMethod",sm);
    for(int i=0;i<entryJavaLineNumbers.size();++i){
      addUncaughtExceptionVariables(methodName,entryFileNames.get(i),entryUmpleLineNumbers.get(i),entryJavaLineNumbers.get(i),entryLengths.get(i));
    }
  } 
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_449);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_450);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_451);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",sm)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_452);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_453);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_454);
     if (parentState != null) { 
    stringBuffer.append(TEXT_455);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_456);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_457);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_458);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_459);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_460);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_462);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_463);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_464);
     } 
     if (customSetPostfixCode != null) {  addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",sm));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_465);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(TEXT_467);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_468);
     } 
     if (parentState != null) { 
     if (sm.getContainsDeepHistoryState()) { 
    stringBuffer.append(TEXT_469);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_470);
    stringBuffer.append( gen.translate("type",sm)  );
    stringBuffer.append(TEXT_471);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_472);
    stringBuffer.append( gen.translate("stateMachineOne", sm) );
    stringBuffer.append(TEXT_473);
     } 
     } 
    stringBuffer.append(TEXT_474);
    
    }
  }
}

    
    return stringBuffer.toString();
  } 
  private String getAssociationCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst, boolean isFake)
  {
    String umpleSourceFile = "";
    Integer baseJavaLine = stringBuffer.toString().split("\\n").length+3;
    
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
      
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_477);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append( 
(traceItem!=null?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("associationOne",av)):"")
);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_479);
     } else { 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPre()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("associationOne",av)):"")
);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_483);
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPost()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("parameterOne",av)):"")
);
     addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_485);
     } 
    stringBuffer.append(TEXT_486);
     
  if(av.getMultiplicity().getLowerBound() == 0) {
  
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("hasMethod",av));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_489);
     } 
    stringBuffer.append(TEXT_490);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_493);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPre()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("associationMany",av)+".get(index)"):"")
);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPost()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("parameterOne",av)):"")
);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_499);
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_502);
     if (customGetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPrefixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_506);
     if (customGetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPostfixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_509);
     if (customNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPrefixCode,gen.translate("numberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_511);
     if (customNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPostfixCode,gen.translate("numberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_513);
     if (customHasManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPrefixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_515);
     if (customHasManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPostfixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_519);
     if (customIndexOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPrefixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_522);
     if (customIndexOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPostfixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_523);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_524);
    
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
    
    //TraceItem traceItem = av.getTraced("associationAdd", uClass);
    TraceItem traceItemAssocAdd = av.getTraced("associationAdd", uClass);
    TraceItem traceItemAssocRemove = av.getTraced("associationRemove", uClass);

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
      
    stringBuffer.append(TEXT_525);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_526);
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
      
    
      
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_528);
     if (customIsNumberOfValidPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPrefixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_531);
     } else { 
    stringBuffer.append(TEXT_532);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_536);
     } 
     if (customIsNumberOfValidPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPostfixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_537);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_540);
     } else { 
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_542);
     if (customRequiredNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPrefixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_543);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_544);
     if (customRequiredNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPostfixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_545);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));
    
     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_548);
     } else { 
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_550);
     if (customMinimumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPrefixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_551);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_552);
     if (customMinimumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPostfixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_553);
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
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_556);
     } else { 
    stringBuffer.append(umpleSourceFile);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_558);
     if (customMaximumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPrefixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_559);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_560);
     if (customMaximumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPostfixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_561);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_562);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_565);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_568);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_569);
     } 
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_580);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_581);
    
    }
    
    //traceItem = av.getTraced("associationRemove", uClass);
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(
    (traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
    );
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_588);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av));
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_600);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(
    (traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
    );
    stringBuffer.append(TEXT_601);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    
    
    //traceItem = av.getTraced("associationAdd", uClass);
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_602);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_606);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_609);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_610);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_611);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_615);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_620);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_621);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_625);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_633);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_634);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_652);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_653);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_657);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_662);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_672);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_673);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_687);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_688);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_697);
    stringBuffer.append( 
(traceItemAssocAdd!=null?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_702);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(TEXT_715);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_724);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_728);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_733);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_738);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_739);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_743);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_744);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_745);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_756);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_759);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_760);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_772);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_773);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_781);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_782);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_786);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_791);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_796);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_797);
    stringBuffer.append(TEXT_798);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_802);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_803);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_814);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_817);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_818);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_828);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_835);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_839);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_847);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_848);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_852);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_868);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_895);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_896);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_905);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_922);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_926);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_935);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_936);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_940);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_954);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_955);
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_977);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_978);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_982);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_985);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_988);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_991);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_993);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1001);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1002);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1006);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1009);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1012);
     if (customRemovePostfixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1025);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1026);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1030);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1036);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1054);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1055);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1059);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1061);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1062);
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
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1078);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1079);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1083);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1087);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1094);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1110);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1114);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1115);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1119);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1123);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av));
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1129);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1145);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1149);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1150);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1154);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1176);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1180);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1190);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1191);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1195);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1212);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1213);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1217);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1220);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1243);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1247);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1256);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1257);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1261);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1268);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1272);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1275);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1278);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1279);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1284);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1285);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1289);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1292);
     if (customAddPostfixCode != null) {addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1293);
     } 
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1302);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1308);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1311);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1314);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1318);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1329);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1330);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1334);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1343);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1348);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1354);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1373);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1386);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1390);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1394);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1398);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1401);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1405);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1406);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1410);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1413);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1416);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1417);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(TEXT_1419);
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1423);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1430);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1431);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1435);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1439);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1443);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1446);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1449);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1450);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1454);
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1455);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1456);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1457);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1461);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1477);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1483);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1484);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1485);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1489);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1503);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1509);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1510);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1545);
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
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1554);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1558);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1595);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1599);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1612);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1617);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1629);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1632);
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1644);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1645);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1649);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1665);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1673);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1677);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1678);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1682);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1687);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1688);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1692);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1693);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1694);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1696);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1698);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1701);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1703);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1704);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1705);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1706);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1707);
    stringBuffer.append(TEXT_1708);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1709);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1710);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1713);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1714);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1716);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(TEXT_1718);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1719);
    stringBuffer.append(TEXT_1720);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1721);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1722);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1723);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1724);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1725);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1726);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1727);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1728);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1730);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1731);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1732);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1733);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1735);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1736);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1737);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1738);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1739);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1740);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1741);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1742);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1743);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1744);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1745);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1746);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1747);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(TEXT_1749);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1750);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1751);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1752);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1753);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1754);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1755);
    stringBuffer.append(TEXT_1756);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1757);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1758);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1759);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1760);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1761);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1762);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1763);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_1764);
    stringBuffer.append(TEXT_1765);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1766);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1767);
    stringBuffer.append(TEXT_1768);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1769);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1770);
    stringBuffer.append(TEXT_1771);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1772);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1773);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1774);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1775);
    stringBuffer.append(TEXT_1776);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1777);
    stringBuffer.append(TEXT_1778);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1779);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1780);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1781);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1782);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1783);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1784);
    stringBuffer.append(TEXT_1785);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1786);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1787);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1788);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1789);
    stringBuffer.append(TEXT_1790);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1791);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1792);
    stringBuffer.append(TEXT_1793);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1794);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1795);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1796);
    stringBuffer.append(TEXT_1797);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1798);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1799);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1800);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1801);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1802);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1803);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1804);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1805);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1806);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1807);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1808);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1809);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1810);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1811);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1812);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1813);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1814);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1815);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1816);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1817);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1818);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1819);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1820);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1821);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1822);
    stringBuffer.append(TEXT_1823);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1824);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1825);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1826);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1827);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1828);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1829);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1830);
    stringBuffer.append(TEXT_1831);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1832);
    stringBuffer.append(TEXT_1833);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1834);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1835);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1836);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1837);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1838);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1839);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1840);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1841);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1842);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1843);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1844);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1845);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1846);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1847);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1848);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1849);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1850);
    stringBuffer.append(TEXT_1851);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1852);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1853);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1854);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1855);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1856);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1857);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1858);
    stringBuffer.append(TEXT_1859);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1860);
    stringBuffer.append(TEXT_1861);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1862);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1863);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1864);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
    }
    
    if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
    {
      
    stringBuffer.append(TEXT_1865);
    
      sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
    }
    else if(includeFile3 == "association_AddIndexControlFunctions.jet")
    {
      
    stringBuffer.append(TEXT_1866);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1867);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1868);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1869);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1870);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1871);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1872);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1873);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1874);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1875);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1876);
    stringBuffer.append(TEXT_1877);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1878);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1879);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1880);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_1881);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1882);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1883);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1884);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1885);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1886);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1887);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1888);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1889);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1890);
    stringBuffer.append(TEXT_1891);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1892);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1893);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1894);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1895);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1896);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1897);
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1898);
    
    }
  }

    return stringBuffer.toString();
    } 
    private String getEqualsCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
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


    stringBuffer.append(TEXT_1899);
    stringBuffer.append(TEXT_1900);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1901);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1902);
    stringBuffer.append(TEXT_1903);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1904);
    stringBuffer.append(TEXT_1905);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1906);
    stringBuffer.append(TEXT_1907);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1908);
     } 
    return stringBuffer.toString();
    } 
    private String getStateMachine2Code(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
    
{ 
  boolean hasActivities = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    List<StateMachine> allNested = sm.getNestedStateMachines();
    
    for (StateMachine nestedSm : allNested)
    {
      for (State state : nestedSm.getStates())
      {
        if (state.getActivity() != null)
        {
          hasActivities = true;
          
    
  Activity activity = state.getActivity();
  Event e = activity.getOnCompletionEvent();
  String postTransition = e != null ? gen.translate("eventMethod",e) : null; 

     Position p = state.getActivity().getPosition();
if (p != null) { 
   int javaline = stringBuffer.toString().split("\\n").length;
   addUncaughtExceptionVariables(gen.translate("doActivityMethod",state),p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/",""),p.getLineNumber(),javaline+7,state.getActivity().getActivityCode().split("\\n").length); 
  } 
    stringBuffer.append(TEXT_1909);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1910);
    stringBuffer.append(TEXT_1911);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1912);
     if (postTransition != null) { append(stringBuffer, "\n      {0}();",postTransition); } 
    stringBuffer.append(TEXT_1913);
    
        }
      }
    }
    
    for (State state : sm.getStates())
    {
      if (state.getActivity() != null)
      {
        hasActivities = true;
        
    
  Activity activity = state.getActivity();
  Event e = activity.getOnCompletionEvent();
  String postTransition = e != null ? gen.translate("eventMethod",e) : null; 

     Position p = state.getActivity().getPosition();
if (p != null) { 
   int javaline = stringBuffer.toString().split("\\n").length;
   addUncaughtExceptionVariables(gen.translate("doActivityMethod",state),p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/",""),p.getLineNumber(),javaline+7,state.getActivity().getActivityCode().split("\\n").length); 
  } 
    stringBuffer.append(TEXT_1914);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1915);
    stringBuffer.append(TEXT_1916);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1917);
     if (postTransition != null) { append(stringBuffer, "\n      {0}();",postTransition); } 
    stringBuffer.append(TEXT_1918);
    
      }
    }
  } 
  if (hasActivities)
  {
    
       
  StringBuffer output = new StringBuffer();

  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    List<StateMachine> allNested = sm.getNestedStateMachines();
    
    for (StateMachine nestedSm : allNested)
    {
      for (State state : nestedSm.getStates())
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

    stringBuffer.append(TEXT_1919);
    stringBuffer.append(TEXT_1920);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1921);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1922);
    stringBuffer.append(TEXT_1923);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1924);
    
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
        
    stringBuffer.append(TEXT_1925);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1926);
    stringBuffer.append(TEXT_1927);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1928);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1929);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1930);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1931);
    stringBuffer.append(TEXT_1932);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1933);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1934);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1935);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1936);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1937);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1938);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1939);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1940);
    
      }
    }
  }

    stringBuffer.append(TEXT_1941);
    
  }
}

    return stringBuffer.toString();
    } 
    private String getDeleteCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst, boolean isFake)
  {
    Integer baseJavaLine = stringBuffer.toString().split("\\n").length+1; 
    
  String customDeletePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","delete"));
  String customDeletePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","delete"));

  appendln(stringBuffer,"\n  public void delete()");
  append(stringBuffer,"  {");

  boolean hasSomethingToDelete = false;  

  if (customDeletePrefixCode != null) 
  {
    addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customDeletePrefixCode,"delete");
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customDeletePrefixCode, "    "));
    hasSomethingToDelete = true;
  }

  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (!av.getIsNavigable() || av.isImmutable())
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
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1944);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1945);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1946);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1947);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1948);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1949);
    stringBuffer.append(TEXT_1950);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1951);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1952);
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
    stringBuffer.append(TEXT_1977);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1978);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1979);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1980);
    stringBuffer.append(TEXT_1981);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1982);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1983);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1984);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1985);
    stringBuffer.append(TEXT_1986);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1987);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1988);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1989);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1990);
    stringBuffer.append(TEXT_1991);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1992);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1993);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1994);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1995);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1996);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1997);
    stringBuffer.append(TEXT_1998);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1999);
    stringBuffer.append(TEXT_2000);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2001);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2002);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2003);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2004);
    stringBuffer.append(TEXT_2005);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2006);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2007);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2008);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2009);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2010);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2011);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2012);
    stringBuffer.append(TEXT_2013);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2014);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2015);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2016);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2017);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2018);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2019);
    stringBuffer.append(TEXT_2020);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2021);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2022);
    stringBuffer.append(TEXT_2023);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2024);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_2025);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2026);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2027);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2028);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2029);
    stringBuffer.append(TEXT_2030);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2031);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2033);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2034);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2035);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2036);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2037);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2038);
    stringBuffer.append(TEXT_2039);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2040);
    stringBuffer.append(TEXT_2041);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2042);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2043);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2044);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2045);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2046);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2047);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2048);
    stringBuffer.append(TEXT_2049);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2050);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2051);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2052);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2053);
    stringBuffer.append(TEXT_2054);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2055);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2056);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_2057);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2058);
    stringBuffer.append(TEXT_2059);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2060);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2061);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2062);
    stringBuffer.append(TEXT_2063);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2064);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2065);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2066);
    stringBuffer.append(TEXT_2067);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2068);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2069);
    
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
    addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customDeletePostfixCode,"delete");
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


     for (StateMachine smq : uClass.getStateMachines())
     {
       if (smq.isPooled())
       {
    
  appendln(stringBuffer,"\n  protected class Message");
  appendln(stringBuffer,"  {");
  appendln(stringBuffer,"    MessageType type;"); 
  appendln(stringBuffer,"    ");  
  appendln(stringBuffer,"    //Message parameters");
  appendln(stringBuffer,"    Vector<Object> param;"); 
  appendln(stringBuffer,"    ");   
  appendln(stringBuffer,"    public Message(MessageType t, Vector<Object> p)");
  appendln(stringBuffer,"    {");
  appendln(stringBuffer,"      type = t; "); 
  appendln(stringBuffer,"      param = p;");
  appendln(stringBuffer,"    }");
  appendln(stringBuffer,"");
  appendln(stringBuffer,"    @Override");
  appendln(stringBuffer,"    public String toString()");
  appendln(stringBuffer,"    {");
  appendln(stringBuffer,"      return type + \",\" + param;");
  appendln(stringBuffer,"    }");
  appendln(stringBuffer,"  }");
  appendln(stringBuffer,"  ");  
 
  if (smq.isQueued())
  {
    appendln(stringBuffer,"  protected class MessageQueue {");
    appendln(stringBuffer,"    Queue<Message> messages = new LinkedList<Message>();");
    appendln(stringBuffer,"    ");   
    appendln(stringBuffer,"    public synchronized void put(Message m)");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      messages.add(m); "); 
    appendln(stringBuffer,"      notify();");
    appendln(stringBuffer,"    }");
    appendln(stringBuffer,"");  
    appendln(stringBuffer,"    public synchronized Message getNext()");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      try {");
    appendln(stringBuffer,"        while (messages.isEmpty()) "); 
    appendln(stringBuffer,"        {");
    appendln(stringBuffer,"          wait();");
    appendln(stringBuffer,"        }");
    appendln(stringBuffer,"      } catch (InterruptedException e) { e.printStackTrace(); } "); 
    appendln(stringBuffer,"");
    appendln(stringBuffer,"      //The element to be removed");
    appendln(stringBuffer,"      Message m = messages.remove(); "); 
    appendln(stringBuffer,"      return (m);");
    appendln(stringBuffer,"    }");
    append(stringBuffer,"  }");  
  }
  else if(smq.isPooled())
  {
    appendln(stringBuffer,"  protected class MessagePool {");
    appendln(stringBuffer,"    Queue<Message> messages = new LinkedList<Message>();");
    appendln(stringBuffer,"    ");   
    appendln(stringBuffer,"    public synchronized void put(Message m)");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      messages.add(m); "); 
    appendln(stringBuffer,"      notify();");
    appendln(stringBuffer,"    }");
    appendln(stringBuffer,"");  
    appendln(stringBuffer,"    public synchronized Message getNext()");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      Message message=null;");
    appendln(stringBuffer,"");
    appendln(stringBuffer,"      try {");
    appendln(stringBuffer,"        message=getNextProcessableMessage();");
    appendln(stringBuffer,"        while (message==null)");
    appendln(stringBuffer,"        {");
    appendln(stringBuffer,"          wait();");
    appendln(stringBuffer,"          message=getNextProcessableMessage();");
    appendln(stringBuffer,"        }");
    appendln(stringBuffer,"      } catch (InterruptedException e) { e.printStackTrace(); }");
    appendln(stringBuffer,"");
    appendln(stringBuffer,"      // return the message");
    appendln(stringBuffer,"      return (message);");
    appendln(stringBuffer,"    }");
    appendln(stringBuffer,"");
    appendln(stringBuffer,"    public Message getNextProcessableMessage()");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      // Iterate through messages and remove the first message that matches one of the Messages list");
    appendln(stringBuffer,"      // otherwise return null");
    appendln(stringBuffer,"      for (Message msg: messages)");
    appendln(stringBuffer,"      {");
    
    for(StateMachine sm: uClass.getStateMachines())
    {
      if(sm.isPooled())
      {
        if(sm.getNestedStateMachines().isEmpty())
        {
          append(stringBuffer,"        if(stateMessageMap.get(get");
          append(stringBuffer,"{0}", gen.translate("type",sm));
          appendln(stringBuffer,"()).contains(msg.type))");
          appendln(stringBuffer,"        {");
          appendln(stringBuffer,"          //The element to be removed");
          appendln(stringBuffer,"          messages.remove(msg);");
          appendln(stringBuffer,"          return (msg);");
          appendln(stringBuffer,"        }");
        }
        else if(!sm.getNestedStateMachines().isEmpty())
        {
          append(stringBuffer,"        if(stateMessageMap.get(get");
          append(stringBuffer,"{0}", gen.translate("type",sm));
          appendln(stringBuffer,"()).contains(msg.type))");
          appendln(stringBuffer,"        {");
          appendln(stringBuffer,"          //The element to be removed");
          appendln(stringBuffer,"          messages.remove(msg);");
          appendln(stringBuffer,"          return (msg);");
          appendln(stringBuffer,"        }");
          append(stringBuffer,"        else");
          int nsmSize = sm.getNestedStateMachines().size();
          int nesCount = 0;
          for(StateMachine nsm : sm.getNestedStateMachines())
          {
            nesCount++;
            append(stringBuffer," if(stateMessageMap.get(get");
            append(stringBuffer,"{0}", gen.translate("type",nsm));
            appendln(stringBuffer,"()).contains(msg.type))");
            appendln(stringBuffer,"        {");
            appendln(stringBuffer,"          //The element to be removed");
            appendln(stringBuffer,"          messages.remove(msg);");
            appendln(stringBuffer,"          return (msg);");
            appendln(stringBuffer,"        }");
            if(nsmSize > nesCount)
            {
              append(stringBuffer,"        else");
            }
          }
        }
      }
    }
    appendln(stringBuffer,"      }");
    appendln(stringBuffer,"      return null;");
    appendln(stringBuffer,"    }");
    append(stringBuffer,"  }"); 
  }

    
  append(stringBuffer,"\n");
  append(stringBuffer,"\n  //------------------------------");
  append(stringBuffer,"\n  //messages accepted ");
  append(stringBuffer,"\n  //------------------------------");
  append(stringBuffer,"\n");
  
  
  String evName="";
  boolean sameEvName=false;
  List<String> evList=new ArrayList<String>();
          
  for (StateMachine sm : uClass.getStateMachines())
  {
    if(sm.isQueued() || sm.isPooled()) 
    { 
      for(Event event : sm.getEvents())
      { 
        for(int i=0; i<evList.size(); i++)
        {
          if(evList.get(i).equals(event.getName()))
          {
            sameEvName=true;
          }
        }
             
        if(sameEvName == false)
        {
          if(event.isAutoTransition() == false)
          {
            if(!event.getIsTimer())
            {
              if(!event.isUnspecified())
              {
                if( !evName.equals(event.getName()))
                {
                  evList.add(event.getName());
                  append(stringBuffer,"\n");
                  append(stringBuffer,"  public void ");
                  append(stringBuffer,"{0} ({1})",gen.translate("eventMethod",event), event.getArgs());
                  append(stringBuffer,"\n  {");
          
                  if (!event.getArgs().equals(""))
                  {
                    append(stringBuffer,"\n    Vector v = new Vector({0});", event.getParams().size());
                    for ( int i=0; i < event.getParams().size(); i++)
                    {
                      append(stringBuffer,"\n    v.add({0}, {1});",i, event.getParam(i).getName());
                    }
                    if(sm.isQueued())
                    {
                      append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
                    }
                    if(sm.isPooled())
                    {
                      append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
                    }
                    append(stringBuffer,"_M, v));");
                  }
                  else
                  {
                    if(sm.isQueued())
                    {
                      append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
                    }
                    if(sm.isPooled())
                    {
                      append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
                    }
                    append(stringBuffer,"_M, null));");
                  }
                  append(stringBuffer,"\n  }");
                  append(stringBuffer,"\n");
                  evName = event.getName();
                }
              }
            }
          }
        }
        sameEvName = false;        
      }


      for (StateMachine nsm : sm.getNestedStateMachines())
      {
        for (Event e : nsm.getEvents())
        {
          for(int i=0; i<evList.size(); i++)
          {
            if(evList.get(i).equals(e.getName()))
            {
              sameEvName=true;
            }
          }
        
          if(sameEvName == false)
          {
            if(e.isAutoTransition() == false)
            {
              if(!e.getIsTimer())
              {
                if(!e.isUnspecified())
                {
                   if(e.getIsInternal() == false)
                   {
                     if( !evName.equals(e.getName()))
                     {
                       evList.add(e.getName());
                       append(stringBuffer,"\n");
                       append(stringBuffer,"  public void ");
                       append(stringBuffer,"{0} ({1})",gen.translate("eventMethod",e), e.getArgs());
                       append(stringBuffer,"\n  {");
        
                       if (!e.getArgs().equals(""))
                       {
                         evList.add(e.getName());
                         append(stringBuffer,"\n    Vector v = new Vector({0});", e.getParams().size());
                         for ( int i=0; i < e.getParams().size(); i++)
                         {
                           append(stringBuffer,"\n    v.add({0}, {1});",i, e.getParam(i).getName());
                         }
                         if(sm.isQueued())
                         {
                           append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                         }
                         if(sm.isPooled())
                         {
                           append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                         } 
                         append(stringBuffer,"_M, v));"); 
                       }
                       else
                       {
                         if(sm.isQueued())
                         {
                           append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                         }
                         if(sm.isPooled())
                         {
                           append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                         }
                         append(stringBuffer,"_M, null));");
                       }
                       append(stringBuffer,"\n  }");
                       append(stringBuffer,"\n");
                       evName = e.getName();
                     }
                   }
                 }
               }
             }
           }
           sameEvName=false;
         }
        }
      }
    }

    stringBuffer.append(TEXT_2070);
    
      if(smq.isPooled())
      {
        append(stringBuffer,"      Message m = pool.getNext();");
      }
      if(smq.isQueued())
      {
        append(stringBuffer,"      Message m = queue.getNext();");
      }
      
    stringBuffer.append(TEXT_2071);
     
        String eveNameSM="";
        boolean sameEventNameSM=false;
        List<String> eventListSM=new ArrayList<String>();
          
        for(StateMachine sm: uClass.getStateMachines())
        {
           for(Event event : sm.getEvents())
           {
             for(int i=0; i<eventListSM.size(); i++)
             {
               if(eventListSM.get(i).equals(event.getName()))
               {
                 sameEventNameSM=true;
               }
             }
             
             if(sameEventNameSM == false)
             {
               if(event.isAutoTransition() == false)
               {
                 if(!event.getIsTimer())
                 {
                   if(!event.isUnspecified())
                   {
                     if( !eveNameSM.equals(event.getName()))
                     {
                       eventListSM.add(event.getName());
                       append(stringBuffer,"\n        case {0}",gen.translate("eventMethod",event));
                       append(stringBuffer,"_M:");
                       if (!event.getArgs().equals(""))
                       {
                         append(stringBuffer,"\n          status = _{0}(",gen.translate("eventMethod",event));
                         String allParameters="";
                         for ( int i=0; i < event.getParams().size(); i++)
                         {
                           if (allParameters.length() > 0)
                           {
                             allParameters += ", ";
                           }
                           allParameters += "("+event.getParam(i).getType()+") m.param.elementAt("+i+")";
                         }
                         append(stringBuffer,"{0});",allParameters);
                       }
                       else
                       {
                         append(stringBuffer,"\n          status = _{0}",gen.translate("eventMethod",event));
                         append(stringBuffer,"();");
                       }
                       append(stringBuffer,"\n          break;");
                       eveNameSM = event.getName();
                     }
                   }
                 }
               }
             }
             sameEventNameSM = false;             
           }


           for (StateMachine nsm : sm.getNestedStateMachines())
           {
             for (Event e : nsm.getEvents())
             {
               for(int i=0; i<eventListSM.size(); i++)
               {
                 if(eventListSM.get(i).equals(e.getName()))
                 {
                   sameEventNameSM=true;
                 }
               }

               if(sameEventNameSM == false)
               {
                 if(e.isAutoTransition() == false)
                 {
                   if(!e.getIsTimer())
                   {
                     if(!e.isUnspecified())
                     {
                       if(e.getIsInternal() == false)
                       {
                         if( !eveNameSM.equals(e.getName()))
                         {
                           eventListSM.add(e.getName());
                           append(stringBuffer,"\n        case {0}",gen.translate("eventMethod",e));
                           append(stringBuffer,"_M:");
                           if (!e.getArgs().equals(""))
                           {
                             append(stringBuffer,"\n          status = _{0}(",gen.translate("eventMethod",e));
                             String allParameters="";
                             for ( int i=0; i < e.getParams().size(); i++)
                             {
                               if (allParameters.length() > 0)
                               {
                                 allParameters += ", ";
                               }
                               allParameters += "("+e.getParam(i).getType()+") m.param.elementAt("+i+")";
                             }
                             append(stringBuffer,"{0});",allParameters);
                           }
                           else
                           {
                             append(stringBuffer,"\n          status = _{0}",gen.translate("eventMethod",e));
                             append(stringBuffer,"();");
                           }
                           append(stringBuffer,"\n          break;");
                           eveNameSM = e.getName();
                         }
                       }
                     }
                   }
                 }
               }
               sameEventNameSM = false;
             }
           }
         }
           
    stringBuffer.append(TEXT_2072);
     break;
       }       
       if (smq.isQueued())
       {
    
  appendln(stringBuffer,"\n  protected class Message");
  appendln(stringBuffer,"  {");
  appendln(stringBuffer,"    MessageType type;"); 
  appendln(stringBuffer,"    ");  
  appendln(stringBuffer,"    //Message parameters");
  appendln(stringBuffer,"    Vector<Object> param;"); 
  appendln(stringBuffer,"    ");   
  appendln(stringBuffer,"    public Message(MessageType t, Vector<Object> p)");
  appendln(stringBuffer,"    {");
  appendln(stringBuffer,"      type = t; "); 
  appendln(stringBuffer,"      param = p;");
  appendln(stringBuffer,"    }");
  appendln(stringBuffer,"");
  appendln(stringBuffer,"    @Override");
  appendln(stringBuffer,"    public String toString()");
  appendln(stringBuffer,"    {");
  appendln(stringBuffer,"      return type + \",\" + param;");
  appendln(stringBuffer,"    }");
  appendln(stringBuffer,"  }");
  appendln(stringBuffer,"  ");  
 
  if (smq.isQueued())
  {
    appendln(stringBuffer,"  protected class MessageQueue {");
    appendln(stringBuffer,"    Queue<Message> messages = new LinkedList<Message>();");
    appendln(stringBuffer,"    ");   
    appendln(stringBuffer,"    public synchronized void put(Message m)");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      messages.add(m); "); 
    appendln(stringBuffer,"      notify();");
    appendln(stringBuffer,"    }");
    appendln(stringBuffer,"");  
    appendln(stringBuffer,"    public synchronized Message getNext()");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      try {");
    appendln(stringBuffer,"        while (messages.isEmpty()) "); 
    appendln(stringBuffer,"        {");
    appendln(stringBuffer,"          wait();");
    appendln(stringBuffer,"        }");
    appendln(stringBuffer,"      } catch (InterruptedException e) { e.printStackTrace(); } "); 
    appendln(stringBuffer,"");
    appendln(stringBuffer,"      //The element to be removed");
    appendln(stringBuffer,"      Message m = messages.remove(); "); 
    appendln(stringBuffer,"      return (m);");
    appendln(stringBuffer,"    }");
    append(stringBuffer,"  }");  
  }
  else if(smq.isPooled())
  {
    appendln(stringBuffer,"  protected class MessagePool {");
    appendln(stringBuffer,"    Queue<Message> messages = new LinkedList<Message>();");
    appendln(stringBuffer,"    ");   
    appendln(stringBuffer,"    public synchronized void put(Message m)");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      messages.add(m); "); 
    appendln(stringBuffer,"      notify();");
    appendln(stringBuffer,"    }");
    appendln(stringBuffer,"");  
    appendln(stringBuffer,"    public synchronized Message getNext()");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      Message message=null;");
    appendln(stringBuffer,"");
    appendln(stringBuffer,"      try {");
    appendln(stringBuffer,"        message=getNextProcessableMessage();");
    appendln(stringBuffer,"        while (message==null)");
    appendln(stringBuffer,"        {");
    appendln(stringBuffer,"          wait();");
    appendln(stringBuffer,"          message=getNextProcessableMessage();");
    appendln(stringBuffer,"        }");
    appendln(stringBuffer,"      } catch (InterruptedException e) { e.printStackTrace(); }");
    appendln(stringBuffer,"");
    appendln(stringBuffer,"      // return the message");
    appendln(stringBuffer,"      return (message);");
    appendln(stringBuffer,"    }");
    appendln(stringBuffer,"");
    appendln(stringBuffer,"    public Message getNextProcessableMessage()");
    appendln(stringBuffer,"    {");
    appendln(stringBuffer,"      // Iterate through messages and remove the first message that matches one of the Messages list");
    appendln(stringBuffer,"      // otherwise return null");
    appendln(stringBuffer,"      for (Message msg: messages)");
    appendln(stringBuffer,"      {");
    
    for(StateMachine sm: uClass.getStateMachines())
    {
      if(sm.isPooled())
      {
        if(sm.getNestedStateMachines().isEmpty())
        {
          append(stringBuffer,"        if(stateMessageMap.get(get");
          append(stringBuffer,"{0}", gen.translate("type",sm));
          appendln(stringBuffer,"()).contains(msg.type))");
          appendln(stringBuffer,"        {");
          appendln(stringBuffer,"          //The element to be removed");
          appendln(stringBuffer,"          messages.remove(msg);");
          appendln(stringBuffer,"          return (msg);");
          appendln(stringBuffer,"        }");
        }
        else if(!sm.getNestedStateMachines().isEmpty())
        {
          append(stringBuffer,"        if(stateMessageMap.get(get");
          append(stringBuffer,"{0}", gen.translate("type",sm));
          appendln(stringBuffer,"()).contains(msg.type))");
          appendln(stringBuffer,"        {");
          appendln(stringBuffer,"          //The element to be removed");
          appendln(stringBuffer,"          messages.remove(msg);");
          appendln(stringBuffer,"          return (msg);");
          appendln(stringBuffer,"        }");
          append(stringBuffer,"        else");
          int nsmSize = sm.getNestedStateMachines().size();
          int nesCount = 0;
          for(StateMachine nsm : sm.getNestedStateMachines())
          {
            nesCount++;
            append(stringBuffer," if(stateMessageMap.get(get");
            append(stringBuffer,"{0}", gen.translate("type",nsm));
            appendln(stringBuffer,"()).contains(msg.type))");
            appendln(stringBuffer,"        {");
            appendln(stringBuffer,"          //The element to be removed");
            appendln(stringBuffer,"          messages.remove(msg);");
            appendln(stringBuffer,"          return (msg);");
            appendln(stringBuffer,"        }");
            if(nsmSize > nesCount)
            {
              append(stringBuffer,"        else");
            }
          }
        }
      }
    }
    appendln(stringBuffer,"      }");
    appendln(stringBuffer,"      return null;");
    appendln(stringBuffer,"    }");
    append(stringBuffer,"  }"); 
  }

    
  append(stringBuffer,"\n");
  append(stringBuffer,"\n  //------------------------------");
  append(stringBuffer,"\n  //messages accepted ");
  append(stringBuffer,"\n  //------------------------------");
  append(stringBuffer,"\n");
  
  
  String evName="";
  boolean sameEvName=false;
  List<String> evList=new ArrayList<String>();
          
  for (StateMachine sm : uClass.getStateMachines())
  {
    if(sm.isQueued() || sm.isPooled()) 
    { 
      for(Event event : sm.getEvents())
      { 
        for(int i=0; i<evList.size(); i++)
        {
          if(evList.get(i).equals(event.getName()))
          {
            sameEvName=true;
          }
        }
             
        if(sameEvName == false)
        {
          if(event.isAutoTransition() == false)
          {
            if(!event.getIsTimer())
            {
              if(!event.isUnspecified())
              {
                if( !evName.equals(event.getName()))
                {
                  evList.add(event.getName());
                  append(stringBuffer,"\n");
                  append(stringBuffer,"  public void ");
                  append(stringBuffer,"{0} ({1})",gen.translate("eventMethod",event), event.getArgs());
                  append(stringBuffer,"\n  {");
          
                  if (!event.getArgs().equals(""))
                  {
                    append(stringBuffer,"\n    Vector v = new Vector({0});", event.getParams().size());
                    for ( int i=0; i < event.getParams().size(); i++)
                    {
                      append(stringBuffer,"\n    v.add({0}, {1});",i, event.getParam(i).getName());
                    }
                    if(sm.isQueued())
                    {
                      append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
                    }
                    if(sm.isPooled())
                    {
                      append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
                    }
                    append(stringBuffer,"_M, v));");
                  }
                  else
                  {
                    if(sm.isQueued())
                    {
                      append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
                    }
                    if(sm.isPooled())
                    {
                      append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
                    }
                    append(stringBuffer,"_M, null));");
                  }
                  append(stringBuffer,"\n  }");
                  append(stringBuffer,"\n");
                  evName = event.getName();
                }
              }
            }
          }
        }
        sameEvName = false;        
      }


      for (StateMachine nsm : sm.getNestedStateMachines())
      {
        for (Event e : nsm.getEvents())
        {
          for(int i=0; i<evList.size(); i++)
          {
            if(evList.get(i).equals(e.getName()))
            {
              sameEvName=true;
            }
          }
        
          if(sameEvName == false)
          {
            if(e.isAutoTransition() == false)
            {
              if(!e.getIsTimer())
              {
                if(!e.isUnspecified())
                {
                   if(e.getIsInternal() == false)
                   {
                     if( !evName.equals(e.getName()))
                     {
                       evList.add(e.getName());
                       append(stringBuffer,"\n");
                       append(stringBuffer,"  public void ");
                       append(stringBuffer,"{0} ({1})",gen.translate("eventMethod",e), e.getArgs());
                       append(stringBuffer,"\n  {");
        
                       if (!e.getArgs().equals(""))
                       {
                         evList.add(e.getName());
                         append(stringBuffer,"\n    Vector v = new Vector({0});", e.getParams().size());
                         for ( int i=0; i < e.getParams().size(); i++)
                         {
                           append(stringBuffer,"\n    v.add({0}, {1});",i, e.getParam(i).getName());
                         }
                         if(sm.isQueued())
                         {
                           append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                         }
                         if(sm.isPooled())
                         {
                           append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                         } 
                         append(stringBuffer,"_M, v));"); 
                       }
                       else
                       {
                         if(sm.isQueued())
                         {
                           append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                         }
                         if(sm.isPooled())
                         {
                           append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                         }
                         append(stringBuffer,"_M, null));");
                       }
                       append(stringBuffer,"\n  }");
                       append(stringBuffer,"\n");
                       evName = e.getName();
                     }
                   }
                 }
               }
             }
           }
           sameEvName=false;
         }
        }
      }
    }

    stringBuffer.append(TEXT_2073);
    
      if(smq.isPooled())
      {
        append(stringBuffer,"      Message m = pool.getNext();");
      }
      if(smq.isQueued())
      {
        append(stringBuffer,"      Message m = queue.getNext();");
      }
      
    stringBuffer.append(TEXT_2074);
     
        String eveNameSM="";
        boolean sameEventNameSM=false;
        List<String> eventListSM=new ArrayList<String>();
          
        for(StateMachine sm: uClass.getStateMachines())
        {
           for(Event event : sm.getEvents())
           {
             for(int i=0; i<eventListSM.size(); i++)
             {
               if(eventListSM.get(i).equals(event.getName()))
               {
                 sameEventNameSM=true;
               }
             }
             
             if(sameEventNameSM == false)
             {
               if(event.isAutoTransition() == false)
               {
                 if(!event.getIsTimer())
                 {
                   if(!event.isUnspecified())
                   {
                     if( !eveNameSM.equals(event.getName()))
                     {
                       eventListSM.add(event.getName());
                       append(stringBuffer,"\n        case {0}",gen.translate("eventMethod",event));
                       append(stringBuffer,"_M:");
                       if (!event.getArgs().equals(""))
                       {
                         append(stringBuffer,"\n          status = _{0}(",gen.translate("eventMethod",event));
                         String allParameters="";
                         for ( int i=0; i < event.getParams().size(); i++)
                         {
                           if (allParameters.length() > 0)
                           {
                             allParameters += ", ";
                           }
                           allParameters += "("+event.getParam(i).getType()+") m.param.elementAt("+i+")";
                         }
                         append(stringBuffer,"{0});",allParameters);
                       }
                       else
                       {
                         append(stringBuffer,"\n          status = _{0}",gen.translate("eventMethod",event));
                         append(stringBuffer,"();");
                       }
                       append(stringBuffer,"\n          break;");
                       eveNameSM = event.getName();
                     }
                   }
                 }
               }
             }
             sameEventNameSM = false;             
           }


           for (StateMachine nsm : sm.getNestedStateMachines())
           {
             for (Event e : nsm.getEvents())
             {
               for(int i=0; i<eventListSM.size(); i++)
               {
                 if(eventListSM.get(i).equals(e.getName()))
                 {
                   sameEventNameSM=true;
                 }
               }

               if(sameEventNameSM == false)
               {
                 if(e.isAutoTransition() == false)
                 {
                   if(!e.getIsTimer())
                   {
                     if(!e.isUnspecified())
                     {
                       if(e.getIsInternal() == false)
                       {
                         if( !eveNameSM.equals(e.getName()))
                         {
                           eventListSM.add(e.getName());
                           append(stringBuffer,"\n        case {0}",gen.translate("eventMethod",e));
                           append(stringBuffer,"_M:");
                           if (!e.getArgs().equals(""))
                           {
                             append(stringBuffer,"\n          status = _{0}(",gen.translate("eventMethod",e));
                             String allParameters="";
                             for ( int i=0; i < e.getParams().size(); i++)
                             {
                               if (allParameters.length() > 0)
                               {
                                 allParameters += ", ";
                               }
                               allParameters += "("+e.getParam(i).getType()+") m.param.elementAt("+i+")";
                             }
                             append(stringBuffer,"{0});",allParameters);
                           }
                           else
                           {
                             append(stringBuffer,"\n          status = _{0}",gen.translate("eventMethod",e));
                             append(stringBuffer,"();");
                           }
                           append(stringBuffer,"\n          break;");
                           eveNameSM = e.getName();
                         }
                       }
                     }
                   }
                 }
               }
               sameEventNameSM = false;
             }
           }
         }
           
    stringBuffer.append(TEXT_2075);
     break;
       }
     }
    return stringBuffer.toString();
    } 
    private String getExtraMethodsCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
     if (uClass.hasMethods()) { 
    
    if (uClass.hasMethods())
    {
      for (Method aMethod : uClass.getMethods()) 
      {
        if(!aMethod.getExistsInLanguage("Java"))
          continue;
        
          
        Position p = aMethod.getCodePosition();
        String positionHeader = "";        
        
        if (p != null) {
//        use annotations instead
//        positionHeader = "\n  // line " + p.getLineNumber() + " \"" + p.getRelativePath(uClass, "Java") + "\"";
//        positionHeader = "\n  @umplesourcefile(line={"+p.getLineNumber()+"},file={\""+p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/","")+ "\"},javaline={"+(javaline+4)+"},length={"+(aMethod.getIsImplemented()?2: aMethod.getMethodBody().getExtraCode().split("\\n").length+2)+"})";          
        }
        else 
        {
          p = aMethod.getPosition();
//          positionHeader = "\n  @umplesourcefile(line={"+p.getLineNumber()+"},file={\""+p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/","")+ "\"},javaline={"+(javaline+3)+"},length={"+(aMethod.getIsImplemented()?2: aMethod.getMethodBody().getExtraCode().split("\\n").length+2)+"})";
        }
        String methodModifier = aMethod.getModifier().equals("") ? "public" : aMethod.getModifier();
        String methodImplementationModifier = aMethod.getIsAbstract() ? " abstract" : "";
        String methodName = aMethod.getName();
        String methodType = aMethod.getType();
        String customPreconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Precondition"));        
        String customPostconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Postcondition"));
        customPostconditionCode = customPostconditionCode==null?"":customPostconditionCode;
        
        String methodBody = aMethod.getIsImplemented() ? "      return " + gen.translate(methodType) + ";" : aMethod.getMethodBody().getExtraCode();
        String properMethodBody = "    " + methodBody; 
        String override =  aMethod.getIsImplemented() ? "  @Override\n" : "";
        String paramName="";
        String paramType="";
        String aSingleParameter="";
        String isList="";
        String finalParams = "";        
        String finalParamsWithoutTypes = "";
        if(methodName.equals("main")&&methodType.equals("void")&&methodModifier.contains("public")&&methodModifier.contains("static"))
        {
          String exceptionHandlerPackage = "";
          if(mainMainClass!=null)
          {
            exceptionHandlerPackage = mainMainClass.getPackageName()+"."+mainMainClass.getName()+".";
          }
          else
          {
            mainMainClass = uClass;
          }
          properMethodBody = "    Thread.currentThread().setUncaughtExceptionHandler(new "+exceptionHandlerPackage+"UmpleExceptionHandler());\n"+
                             "    Thread.setDefaultUncaughtExceptionHandler(new "+exceptionHandlerPackage+"UmpleExceptionHandler());\n"+properMethodBody;
          uClass.setHasMainMethod(true);
        }
        StringBuilder parameters = new StringBuilder();
        StringBuilder parametersWithoutTypes = new StringBuilder();
        if (aMethod.hasMethodParameters())
        {
          for (MethodParameter aMethodParam : aMethod.getMethodParameters()) 
          {
            paramName = aMethodParam.getName();
            paramType = aMethodParam.getType();
            isList = aMethodParam.getIsList() ? " [] " : " ";
            aSingleParameter = paramType + isList + paramName;
            parameters.append(aSingleParameter + ", ");
            parametersWithoutTypes.append(aMethodParam.getName() + ", ");
          }
          
          finalParams = parameters.toString().substring(0, parameters.toString().length()-2);
          finalParamsWithoutTypes = parametersWithoutTypes.toString().substring(0, parametersWithoutTypes.toString().length()-2);
        }
        
        if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n\n  {0}", Comment.format("Method Javadoc",aMethod.getComments())); }
        
        append(stringBuffer,"\n");
        int javaline = stringBuffer.toString().split("\\n").length+(aMethod.numberOfComments() > 0?0:1);
        
        if(!"".equals(customPostconditionCode))
        {
          StringBuilder lineNumbers = new StringBuilder();
          StringBuilder javaLineNumbers = new StringBuilder();
          StringBuilder filenames = new StringBuilder();
          StringBuilder lengths = new StringBuilder();
          String comma = "";
          if(p!=null)
          {
            int previousConditionsFound = 0;
            for(Postcondition condition:uClass.getPostconditions())
            {
              if(condition.getMethod().equals(aMethod)&&condition.getPosition()!=null)
              {
                lineNumbers.append(comma+(condition.getPosition().getLineNumber()));
                filenames.append(comma+condition.getPosition().getFilename());
                javaLineNumbers.append(comma+(javaline+7+3*previousConditionsFound));
                lengths.append(comma+"1");
                comma = ",";
                previousConditionsFound++;
              }
            }
          }
          if(!"".equals(lineNumbers.toString())){
            String positionEndHeader = "\n";
          }
          append(stringBuffer,override);
          append(stringBuffer, "  {0}{1} {2} {3}({4})", methodModifier, methodImplementationModifier, methodType, methodName, finalParams);
        
          appendln(stringBuffer, "{");
          if(!"".equals(methodType)&&!"void".equals(methodType))
          {
            append(stringBuffer, "    {0} result = {1}_Original({2});\n", methodType, methodName, finalParamsWithoutTypes);
          }
          else
          {
            append(stringBuffer, "    {0}_Original({1});\n", methodName, finalParamsWithoutTypes);
          }
          appendln(stringBuffer, GeneratorHelper.doIndent(customPostconditionCode, "    "));
          if(!"".equals(methodType)&&!"void".equals(methodType))
          {
            append(stringBuffer, "    return result;\n");
            javaline++;
          }          
          appendln(stringBuffer, "  }");
          
          javaline+= 5+customPostconditionCode.split("\\n").length;
          append(stringBuffer, "\n  {0}{1} {2} {3}_Original({4})", methodModifier, methodImplementationModifier, methodType, methodName, finalParams);
        }
        else
        {
          append(stringBuffer,override);
          append(stringBuffer, "  {0}{1} {2} {3}({4})", methodModifier, methodImplementationModifier, methodType, methodName, finalParams);
        }
        if(aMethod.getIsAbstract())
        {
          append(stringBuffer, ";");
        }
        else
        {
          appendln(stringBuffer, "{");
          if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
          appendln(stringBuffer, properMethodBody);
          addUncaughtExceptionVariables(methodName,p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/",""),p.getLineNumber(),javaline,stringBuffer.toString().split("\\n").length+1-javaline);
          appendln(stringBuffer, "  }");
        }
      }
    }

     } 
     
   boolean matchFound = false;
   UmpleClass parent = uClass.getExtendsClass(); 
   if(uClass.getExtraCode() != null)
   {
     matchFound = java.util.regex.Pattern.compile(".*((public)|(protected)|(private))\\s+(String)\\s+(toString)\\s*\\(\\s*\\).*", java.util.regex.Pattern.DOTALL).matcher(uClass.getExtraCode()).matches();
   }
   if(parent!=null && parent.getExtraCode() != null)
   {
     matchFound = java.util.regex.Pattern.compile(".*((public)|(protected)|(private))\\s+(String)\\s+(toString)\\s*\\(\\s*\\).*", java.util.regex.Pattern.DOTALL).matcher(parent.getExtraCode()).matches();
   }
   if(!matchFound)
   for(Method meth: uClass.getMethods())
   {
     if("toString".equals(meth.getName()))
     {
       matchFound = true;
       break;
     }
   }
   if(!matchFound && parent!=null)
   for(Method meth: parent.getMethods())
   {
     if("toString".equals(meth.getName()))
     {
       matchFound = true;
       break;
     }
   }
   if (uClass.getAttributes().size()>0 && !matchFound){ 
    stringBuffer.append(TEXT_2076);
    
	  String customToStringPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","toString"));
	  String customToStringPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","toString"));
	  if (customToStringPrefixCode != null) 
	  {
		  append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customToStringPrefixCode, "    "));
	  }
	  if (customToStringPostfixCode != null) 
	  {
		  append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customToStringPostfixCode, "    "));
	  }
	  String ret = "";

	  LinkedList<String> displayedAttributes = new LinkedList<String>();
	  LinkedList<String> nameOfAttributes = new LinkedList<String>();
	  LinkedList<String> displayedPrimitives = new LinkedList<String>();
	  LinkedList<String> nameOfPrimitives = new LinkedList<String>();
	  List<String> keys = new ArrayList<String>();
	  List<String> reflexiveNames = new ArrayList<String>();
	  List<String> reflexive = new ArrayList<String>();
	  for(String k: uClass.getKey().getMembers())
		  keys.add(k);
	  for(Attribute av: uClass.getAttributes())
	  {
	      
		  if(!av.getIsList()&&!"internal".equals(av.getModifier())&&!"const".equals(av.getModifier())&&("String".equals(av.getType())||"int".equals(av.getType())||"Integer".equals(av.getType())||"boolean".equals(av.getType().toLowerCase())||"float".equals(av.getType())||"Float".equals(av.getType())||"double".equals(av.getType())||"Double".equals(av.getType())||"byte".equals(av.getType())||"Byte".equals(av.getType())||"char".equals(av.getType())||"Character".equals(av.getType())||"long".equals(av.getType())||"Long".equals(av.getType())||"short".equals(av.getType())||"Short".equals(av.getType())))
		  {
			  if(av.getIsAutounique() || keys.contains(av.getName())){
				  nameOfPrimitives.addFirst(av.getName());
				  displayedPrimitives.addFirst(gen.translate("getMethod",av)+"()");
			  }
			  else {
				  nameOfPrimitives.addLast(av.getName());
				  displayedPrimitives.addLast(gen.translate("getMethod",av)+"()");
			  }
		  }
		  else if(!av.getIsList()&&!"const".equals(av.getModifier())&&!"internal".equals(av.getModifier()))
		  {
			  if(av.getIsAutounique() || keys.contains(av.getName())){
				  nameOfAttributes.addFirst(av.getName());
				  displayedAttributes.addFirst(gen.translate("getMethod",av)+"()");
			  }
			  else {
				  nameOfAttributes.addLast(av.getName());
				  displayedAttributes.addLast(gen.translate("getMethod",av)+"()");
			  }
		  }
	  }
	  for(AssociationVariable av: uClass.getAssociationVariables())
	  {
	    if(av.isIsNavigable()&&av.getUmpleClass()!=av.getRelatedAssociation().getUmpleClass())
	    {
	      if("1".equals(av.getMultiplicity().getMinimum())||"0".equals(av.getMultiplicity().getMinimum())||"1".equals(av.getMultiplicity().getBound()))
	      {
	        if("1".equals(av.getMultiplicity().getMaximum())||"1".equals(av.getMultiplicity().getBound()))
	        {
	          reflexiveNames.add(av.getName());
	          reflexive.add(gen.translate("getMethod",av)+"()");
		    }
		  }
		}
		  
	  }
	  ret += "super.toString() + \"[\"";
	  boolean firstStr = true;
	  for(int m=0;m<displayedPrimitives.size();m++)
	  {
		  if(firstStr)
			  firstStr = false;
		  else
			  ret += "+ \",\" ";
		  ret += "+\n            \"" + nameOfPrimitives.get(m) + "\" + \":\" + " + displayedPrimitives.get(m); 
	  }
	  ret += "+ \"]\"";
	  for(int m=0;m<displayedAttributes.size();m++)
	  {          
		  ret += " + System.getProperties().getProperty(\"line.separator\") +\n            ";      
		  ret += "\"  \" + " + "\"" + nameOfAttributes.get(m) + "\" + \"=\" + (" + displayedAttributes.get(m) + " != null ? !" + displayedAttributes.get(m) + ".equals(this)  ? " + displayedAttributes.get(m) + ".toString().replaceAll(\"  \",\"    \") : \"this\" : \"null\")";

	  }
	  for(int m=0;m<reflexive.size();m++){
	      ret += " + System.getProperties().getProperty(\"line.separator\") +\n            ";
	      ret += "\"  \" + " +  "\""+reflexiveNames.get(m)+" = \"+("+reflexive.get(m)+"!=null?Integer.toHexString(System.identityHashCode("+reflexive.get(m)+")):\"null\")";
	  }
	  ret += "\n     + outputString";
	  append(stringBuffer,"\n    return {0};", ret);
	  
    stringBuffer.append(TEXT_2077);
     } 
    return stringBuffer.toString();
    } 
    private String getAllExtraCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
     
  boolean isMainClass = false;
  if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_2078);
    stringBuffer.append(TEXT_2079);
    stringBuffer.append(uClass.getExtraCode());
    stringBuffer.append(TEXT_2080);
     } 
    if(uClass!=mainMainClass){
    stringBuffer.append(TEXT_2081);
    }
  return stringBuffer.toString();
}

    
java.util.regex.Pattern lineNumberPattern = java.util.regex.Pattern.compile("// line ([0|1|2|3|4|5|6|7|8|9]*) (.*)");
public static UmpleClass mainMainClass = null;
private void addUncaughtExceptionVariables(int javaline, String code, String methodname)
{
  String[] lines = code.split("\\n");
  java.util.regex.Matcher matcher = lineNumberPattern.matcher(lines[0]);
  if(matcher.matches())
  {
    if(!uncaughtExceptions.containsKey(methodname))
    {
      uncaughtExceptions.put(methodname,new UncaughtException(globalUmpleClass.getName(), methodname));
    }
    uncaughtExceptions.get(methodname).addUncaughtFileName(matcher.group(2));
    uncaughtExceptions.get(methodname).addUncaughtUmpleLine(Integer.parseInt(matcher.group(1))-1);
    uncaughtExceptions.get(methodname).addUncaughtJavaLine(javaline+1);
    uncaughtExceptions.get(methodname).addUncaughtLength(lines.length);
  }  
}
private void addUncaughtExceptionVariables(String methodname, String filename, int umpleline, int javaline, int length)
{
  if(!uncaughtExceptions.containsKey(methodname))
  {
    uncaughtExceptions.put(methodname,new UncaughtException(globalUmpleClass.getName(), methodname));
  }
  
  uncaughtExceptions.get(methodname).addUncaughtFileName(filename);
  uncaughtExceptions.get(methodname).addUncaughtUmpleLine(umpleline-1);
  uncaughtExceptions.get(methodname).addUncaughtJavaLine(javaline+1);
  uncaughtExceptions.get(methodname).addUncaughtLength(length);
}
public String getExceptionHandler(String exceptions) { 
  StringBuilder stringBuffer = new StringBuilder();
    stringBuffer.append(TEXT_2082);
    stringBuffer.append(TEXT_2083);
    stringBuffer.append(exceptions);
    stringBuffer.append(TEXT_2084);
    
  return stringBuffer.toString();
}
    

public String endAll(String stringBuffer)
{

    return stringBuffer.toString();
  }
}