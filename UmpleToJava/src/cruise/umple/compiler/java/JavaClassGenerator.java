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
  protected final String TEXT_1 = "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/";
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
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "    ";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + "    ( new Thread()" + NL + "    {" + NL + "      Thread thread;" + NL + "      {" + NL + "        thread = Thread.currentThread();" + NL + "      }" + NL + "      public void run()" + NL + "      {" + NL + "        while( thread.isAlive() )" + NL + "        {";
  protected final String TEXT_29 = NL + "          try" + NL + "          {" + NL + "            Thread.sleep(";
  protected final String TEXT_30 = ");" + NL + "          }" + NL + "          catch (InterruptedException e)" + NL + "          {" + NL + "            e.printStackTrace();" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    ).start();";
  protected final String TEXT_31 = NL + "    ";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = "++;";
  protected final String TEXT_34 = NL + "    if (!";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Cannot create due to duplicate ";
  protected final String TEXT_37 = "\");" + NL + "    }";
  protected final String TEXT_38 = NL + "    if (!";
  protected final String TEXT_39 = "(";
  protected final String TEXT_40 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_41 = " due to ";
  protected final String TEXT_42 = "\");" + NL + "    }";
  protected final String TEXT_43 = NL + "    ";
  protected final String TEXT_44 = " = new ArrayList<";
  protected final String TEXT_45 = ">();" + NL + "    boolean ";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = "(";
  protected final String TEXT_48 = ");" + NL + "    if (!";
  protected final String TEXT_49 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_50 = ", must have ";
  protected final String TEXT_51 = " ";
  protected final String TEXT_52 = "\");" + NL + "    }";
  protected final String TEXT_53 = NL + "    ";
  protected final String TEXT_54 = " = new ArrayList<";
  protected final String TEXT_55 = ">();" + NL + "    boolean ";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = "(";
  protected final String TEXT_58 = ");" + NL + "    if (!";
  protected final String TEXT_59 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_60 = ", must have ";
  protected final String TEXT_61 = " or fewer ";
  protected final String TEXT_62 = ", no duplicates.\");" + NL + "    }";
  protected final String TEXT_63 = NL + "    ";
  protected final String TEXT_64 = " = new ArrayList<";
  protected final String TEXT_65 = ">();" + NL + "    boolean ";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = "(";
  protected final String TEXT_68 = ");" + NL + "    if (!";
  protected final String TEXT_69 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_70 = ", must not have duplicate ";
  protected final String TEXT_71 = ".\");" + NL + "    }";
  protected final String TEXT_72 = NL + "    ";
  protected final String TEXT_73 = " = new ArrayList<";
  protected final String TEXT_74 = ">();";
  protected final String TEXT_75 = NL + "    if (";
  protected final String TEXT_76 = " == null || ";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = "() != null)" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_79 = " due to ";
  protected final String TEXT_80 = "\");" + NL + "    }";
  protected final String TEXT_81 = NL + "    ";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ";";
  protected final String TEXT_84 = NL + "    ";
  protected final String TEXT_85 = " = new ArrayList<";
  protected final String TEXT_86 = ">();";
  protected final String TEXT_87 = NL + "    boolean ";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = "(";
  protected final String TEXT_90 = ");" + NL + "    if (!";
  protected final String TEXT_91 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_92 = " due to ";
  protected final String TEXT_93 = "\");" + NL + "    }";
  protected final String TEXT_94 = NL + "    ";
  protected final String TEXT_95 = " = new ArrayList<";
  protected final String TEXT_96 = ">();" + NL + "    boolean ";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = "(";
  protected final String TEXT_99 = ");" + NL + "    if (!";
  protected final String TEXT_100 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_101 = ", must have ";
  protected final String TEXT_102 = " ";
  protected final String TEXT_103 = "\");" + NL + "    }";
  protected final String TEXT_104 = " = new ArrayList<";
  protected final String TEXT_105 = ">();";
  protected final String TEXT_106 = NL + "    ";
  protected final String TEXT_107 = ".add(";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = NL + "    ";
  protected final String TEXT_110 = "(";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "    ";
  protected final String TEXT_114 = "HStar = ";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = ";";
  protected final String TEXT_117 = NL + "    ";
  protected final String TEXT_118 = "H = ";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = ";";
  protected final String TEXT_121 = NL + "    ";
  protected final String TEXT_122 = "(";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "  public static ";
  protected final String TEXT_126 = " getInstance()" + NL + "  {" + NL + "    if(theInstance == null)" + NL + "    {" + NL + "      theInstance = new ";
  protected final String TEXT_127 = "();" + NL + "    }" + NL + "    return theInstance;" + NL + "  }";
  protected final String TEXT_128 = NL + NL + "  public ";
  protected final String TEXT_129 = "(";
  protected final String TEXT_130 = ")" + NL + "  {";
  protected final String TEXT_131 = NL + "    ";
  protected final String TEXT_132 = " = new ArrayList<";
  protected final String TEXT_133 = ">();";
  protected final String TEXT_134 = NL + "    ";
  protected final String TEXT_135 = "();";
  protected final String TEXT_136 = NL + "    ";
  protected final String TEXT_137 = " = ";
  protected final String TEXT_138 = ";";
  protected final String TEXT_139 = NL + "    ";
  protected final String TEXT_140 = " = ";
  protected final String TEXT_141 = ";";
  protected final String TEXT_142 = NL + "    ";
  protected final String TEXT_143 = " = ";
  protected final String TEXT_144 = "++;";
  protected final String TEXT_145 = NL + "    ";
  protected final String TEXT_146 = " = new ";
  protected final String TEXT_147 = "(";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = NL + "    ";
  protected final String TEXT_150 = " = new ArrayList<";
  protected final String TEXT_151 = ">();";
  protected final String TEXT_152 = NL + "    boolean ";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = "(";
  protected final String TEXT_155 = ");" + NL + "    if (!";
  protected final String TEXT_156 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_157 = " due to ";
  protected final String TEXT_158 = "\");" + NL + "    }";
  protected final String TEXT_159 = NL + "    ";
  protected final String TEXT_160 = " = new ArrayList<";
  protected final String TEXT_161 = ">();" + NL + "    boolean ";
  protected final String TEXT_162 = " = ";
  protected final String TEXT_163 = "(";
  protected final String TEXT_164 = ");" + NL + "    if (!";
  protected final String TEXT_165 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_166 = ", must have ";
  protected final String TEXT_167 = " ";
  protected final String TEXT_168 = "\");" + NL + "    }";
  protected final String TEXT_169 = " = new ArrayList<";
  protected final String TEXT_170 = ">();";
  protected final String TEXT_171 = NL + "    ";
  protected final String TEXT_172 = ".add(";
  protected final String TEXT_173 = ");";
  protected final String TEXT_174 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_175 = NL + "  public boolean ";
  protected final String TEXT_176 = "(";
  protected final String TEXT_177 = " ";
  protected final String TEXT_178 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_179 = NL + "    ";
  protected final String TEXT_180 = " = false;";
  protected final String TEXT_181 = NL + "    ";
  protected final String TEXT_182 = " = ";
  protected final String TEXT_183 = ";";
  protected final String TEXT_184 = NL + "    wasSet = true;";
  protected final String TEXT_185 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_186 = NL + "  public boolean ";
  protected final String TEXT_187 = "(";
  protected final String TEXT_188 = " ";
  protected final String TEXT_189 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_190 = NL + "    ";
  protected final String TEXT_191 = " = ";
  protected final String TEXT_192 = ";";
  protected final String TEXT_193 = NL + "    wasSet = true;";
  protected final String TEXT_194 = NL + "    return wasSet;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_195 = "()" + NL + "  {" + NL + "    boolean wasReset = false;";
  protected final String TEXT_196 = NL + "    ";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = "();";
  protected final String TEXT_199 = NL + "    wasReset = true;";
  protected final String TEXT_200 = NL + "    return wasReset;" + NL + "  }" + NL;
  protected final String TEXT_201 = NL + "  public boolean ";
  protected final String TEXT_202 = "(";
  protected final String TEXT_203 = " ";
  protected final String TEXT_204 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_205 = NL + "    wasAdded = ";
  protected final String TEXT_206 = ".add(";
  protected final String TEXT_207 = ");";
  protected final String TEXT_208 = NL;
  protected final String TEXT_209 = "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_210 = "(";
  protected final String TEXT_211 = " ";
  protected final String TEXT_212 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_213 = NL + "    wasRemoved = ";
  protected final String TEXT_214 = ".remove(";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = NL;
  protected final String TEXT_217 = "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_218 = NL + "  public boolean ";
  protected final String TEXT_219 = "(";
  protected final String TEXT_220 = " ";
  protected final String TEXT_221 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_222 = NL + "    ";
  protected final String TEXT_223 = " = ";
  protected final String TEXT_224 = ";";
  protected final String TEXT_225 = NL + "    wasSet = true;";
  protected final String TEXT_226 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_227 = NL + "  public boolean ";
  protected final String TEXT_228 = "(";
  protected final String TEXT_229 = " ";
  protected final String TEXT_230 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_231 = NL + "      wasSet = super.";
  protected final String TEXT_232 = "(";
  protected final String TEXT_233 = ");";
  protected final String TEXT_234 = NL + "    return wasSet;" + NL + "  }" + NL + NL;
  protected final String TEXT_235 = NL + "  public boolean ";
  protected final String TEXT_236 = "(";
  protected final String TEXT_237 = " ";
  protected final String TEXT_238 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_239 = NL + "      wasAdded = super.";
  protected final String TEXT_240 = "(";
  protected final String TEXT_241 = ");";
  protected final String TEXT_242 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_243 = NL + "  public boolean ";
  protected final String TEXT_244 = "(";
  protected final String TEXT_245 = " ";
  protected final String TEXT_246 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_247 = NL + "      wasSet = super.";
  protected final String TEXT_248 = "(";
  protected final String TEXT_249 = ");";
  protected final String TEXT_250 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_251 = NL + "  public ";
  protected final String TEXT_252 = " ";
  protected final String TEXT_253 = "(int index)" + NL + "  {";
  protected final String TEXT_254 = NL + "    ";
  protected final String TEXT_255 = " ";
  protected final String TEXT_256 = " = ";
  protected final String TEXT_257 = ".get(index);";
  protected final String TEXT_258 = NL;
  protected final String TEXT_259 = "    return ";
  protected final String TEXT_260 = ";" + NL + "  }" + NL + "" + NL + "  public ";
  protected final String TEXT_261 = "[] ";
  protected final String TEXT_262 = "()" + NL + "  {";
  protected final String TEXT_263 = NL + "    ";
  protected final String TEXT_264 = "[] ";
  protected final String TEXT_265 = " = ";
  protected final String TEXT_266 = ".toArray(new ";
  protected final String TEXT_267 = "[";
  protected final String TEXT_268 = ".size()]);";
  protected final String TEXT_269 = NL;
  protected final String TEXT_270 = "    return ";
  protected final String TEXT_271 = ";" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_272 = "()" + NL + "  {";
  protected final String TEXT_273 = NL + "    int number = ";
  protected final String TEXT_274 = ".size();";
  protected final String TEXT_275 = NL;
  protected final String TEXT_276 = "    return number;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_277 = "()" + NL + "  {";
  protected final String TEXT_278 = NL + "    boolean has = ";
  protected final String TEXT_279 = ".size() > 0;";
  protected final String TEXT_280 = NL;
  protected final String TEXT_281 = "    return has;" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_282 = "(";
  protected final String TEXT_283 = " ";
  protected final String TEXT_284 = ")" + NL + "  {";
  protected final String TEXT_285 = NL + "    int index = ";
  protected final String TEXT_286 = ".indexOf(";
  protected final String TEXT_287 = ");";
  protected final String TEXT_288 = NL;
  protected final String TEXT_289 = "    return index;" + NL + "  }" + NL;
  protected final String TEXT_290 = NL + "  public ";
  protected final String TEXT_291 = " ";
  protected final String TEXT_292 = "()" + NL + "  {";
  protected final String TEXT_293 = NL + "    ";
  protected final String TEXT_294 = " ";
  protected final String TEXT_295 = " = ";
  protected final String TEXT_296 = ";";
  protected final String TEXT_297 = NL;
  protected final String TEXT_298 = "    return ";
  protected final String TEXT_299 = ";";
  protected final String TEXT_300 = NL + "  }";
  protected final String TEXT_301 = NL + "  public ";
  protected final String TEXT_302 = " ";
  protected final String TEXT_303 = "()" + NL + "  {";
  protected final String TEXT_304 = NL + "    return ";
  protected final String TEXT_305 = ";";
  protected final String TEXT_306 = NL + "  }";
  protected final String TEXT_307 = NL + "  public ";
  protected final String TEXT_308 = " ";
  protected final String TEXT_309 = "()" + NL + "  {";
  protected final String TEXT_310 = NL + "    ";
  protected final String TEXT_311 = " ";
  protected final String TEXT_312 = " = ";
  protected final String TEXT_313 = ";";
  protected final String TEXT_314 = NL;
  protected final String TEXT_315 = "    return ";
  protected final String TEXT_316 = ";" + NL + "  }";
  protected final String TEXT_317 = NL + "  public ";
  protected final String TEXT_318 = " ";
  protected final String TEXT_319 = "()" + NL + "  {";
  protected final String TEXT_320 = NL + "    return ";
  protected final String TEXT_321 = ";" + NL + "  }";
  protected final String TEXT_322 = NL + "  public ";
  protected final String TEXT_323 = " ";
  protected final String TEXT_324 = "()" + NL + "  {";
  protected final String TEXT_325 = NL + "    ";
  protected final String TEXT_326 = " ";
  protected final String TEXT_327 = " = ";
  protected final String TEXT_328 = ";";
  protected final String TEXT_329 = NL;
  protected final String TEXT_330 = "    return ";
  protected final String TEXT_331 = ";" + NL + "  }" + NL;
  protected final String TEXT_332 = NL + "  public ";
  protected final String TEXT_333 = " ";
  protected final String TEXT_334 = "()" + NL + "  {";
  protected final String TEXT_335 = NL + "    return ";
  protected final String TEXT_336 = ";" + NL + "  }" + NL;
  protected final String TEXT_337 = NL + "  public static ";
  protected final String TEXT_338 = " ";
  protected final String TEXT_339 = "(";
  protected final String TEXT_340 = " ";
  protected final String TEXT_341 = ")" + NL + "  {";
  protected final String TEXT_342 = NL + "    ";
  protected final String TEXT_343 = " ";
  protected final String TEXT_344 = " = ";
  protected final String TEXT_345 = ".get(";
  protected final String TEXT_346 = ");";
  protected final String TEXT_347 = NL;
  protected final String TEXT_348 = "    return ";
  protected final String TEXT_349 = ";" + NL + "  }" + NL;
  protected final String TEXT_350 = NL + "  public static ";
  protected final String TEXT_351 = " ";
  protected final String TEXT_352 = "(";
  protected final String TEXT_353 = " ";
  protected final String TEXT_354 = ")" + NL + "  {";
  protected final String TEXT_355 = NL + "    return ";
  protected final String TEXT_356 = ".get(";
  protected final String TEXT_357 = ");" + NL + "  }" + NL;
  protected final String TEXT_358 = NL + "  public static boolean ";
  protected final String TEXT_359 = "(";
  protected final String TEXT_360 = " ";
  protected final String TEXT_361 = ")" + NL + "  {";
  protected final String TEXT_362 = NL + "    boolean ";
  protected final String TEXT_363 = " = ";
  protected final String TEXT_364 = "(";
  protected final String TEXT_365 = ") != null;";
  protected final String TEXT_366 = NL;
  protected final String TEXT_367 = "    return ";
  protected final String TEXT_368 = ";" + NL + "  }" + NL;
  protected final String TEXT_369 = NL + "  public static boolean ";
  protected final String TEXT_370 = "(";
  protected final String TEXT_371 = " ";
  protected final String TEXT_372 = ")" + NL + "  {";
  protected final String TEXT_373 = NL + "    return ";
  protected final String TEXT_374 = "(";
  protected final String TEXT_375 = ") != null;" + NL + "  }" + NL;
  protected final String TEXT_376 = NL + "  public ";
  protected final String TEXT_377 = " ";
  protected final String TEXT_378 = "()" + NL + "  {";
  protected final String TEXT_379 = NL + "    ";
  protected final String TEXT_380 = " ";
  protected final String TEXT_381 = " = ";
  protected final String TEXT_382 = ";";
  protected final String TEXT_383 = NL;
  protected final String TEXT_384 = "    return ";
  protected final String TEXT_385 = ";" + NL + "  }";
  protected final String TEXT_386 = NL + "  public ";
  protected final String TEXT_387 = " ";
  protected final String TEXT_388 = "()" + NL + "  {";
  protected final String TEXT_389 = NL + "    return ";
  protected final String TEXT_390 = ";" + NL + "  }";
  protected final String TEXT_391 = NL + "  public ";
  protected final String TEXT_392 = " ";
  protected final String TEXT_393 = "()" + NL + "  {";
  protected final String TEXT_394 = NL + "    ";
  protected final String TEXT_395 = " ";
  protected final String TEXT_396 = " = ";
  protected final String TEXT_397 = ";";
  protected final String TEXT_398 = NL;
  protected final String TEXT_399 = "    return ";
  protected final String TEXT_400 = ";" + NL + "  }";
  protected final String TEXT_401 = NL + "  public ";
  protected final String TEXT_402 = " ";
  protected final String TEXT_403 = "()" + NL + "  {";
  protected final String TEXT_404 = NL + "    return ";
  protected final String TEXT_405 = ";" + NL + "  }";
  protected final String TEXT_406 = NL + "  public ";
  protected final String TEXT_407 = " ";
  protected final String TEXT_408 = "()" + NL + "  {";
  protected final String TEXT_409 = NL + "    ";
  protected final String TEXT_410 = " ";
  protected final String TEXT_411 = " = ";
  protected final String TEXT_412 = ";";
  protected final String TEXT_413 = NL;
  protected final String TEXT_414 = "    return ";
  protected final String TEXT_415 = ";" + NL + "  }";
  protected final String TEXT_416 = NL + "  public ";
  protected final String TEXT_417 = " ";
  protected final String TEXT_418 = "()" + NL + "  {";
  protected final String TEXT_419 = NL + "    return ";
  protected final String TEXT_420 = ";" + NL + "  }";
  protected final String TEXT_421 = NL + "  public ";
  protected final String TEXT_422 = " ";
  protected final String TEXT_423 = "()" + NL + "  {" + NL + "    String answer = ";
  protected final String TEXT_424 = ".toString();";
  protected final String TEXT_425 = NL + "    return answer;" + NL + "  }" + NL;
  protected final String TEXT_426 = NL + "  public ";
  protected final String TEXT_427 = " ";
  protected final String TEXT_428 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_429 = ";" + NL + "  }" + NL;
  protected final String TEXT_430 = NL + "  ";
  protected final String TEXT_431 = " boolean ";
  protected final String TEXT_432 = "(";
  protected final String TEXT_433 = ")" + NL + "  {";
  protected final String TEXT_434 = NL + "    boolean wasEventProcessed = false;";
  protected final String TEXT_435 = NL + "    ";
  protected final String TEXT_436 = NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_437 = NL + "  public boolean ";
  protected final String TEXT_438 = "(";
  protected final String TEXT_439 = " ";
  protected final String TEXT_440 = ")" + NL + "  {";
  protected final String TEXT_441 = NL + "    ";
  protected final String TEXT_442 = " = ";
  protected final String TEXT_443 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_444 = NL + "  private void ";
  protected final String TEXT_445 = "()" + NL + "  {";
  protected final String TEXT_446 = NL + "    switch(";
  protected final String TEXT_447 = ")" + NL + "    {";
  protected final String TEXT_448 = NL + "      ";
  protected final String TEXT_449 = NL + "    }";
  protected final String TEXT_450 = NL + "  }" + NL;
  protected final String TEXT_451 = NL + "  private void ";
  protected final String TEXT_452 = "(";
  protected final String TEXT_453 = " ";
  protected final String TEXT_454 = ")" + NL + "  {";
  protected final String TEXT_455 = NL + "    ";
  protected final String TEXT_456 = " = ";
  protected final String TEXT_457 = ";";
  protected final String TEXT_458 = NL + "    if (";
  protected final String TEXT_459 = " != ";
  protected final String TEXT_460 = ".";
  protected final String TEXT_461 = " && ";
  protected final String TEXT_462 = " != ";
  protected final String TEXT_463 = ".";
  protected final String TEXT_464 = ") { ";
  protected final String TEXT_465 = "(";
  protected final String TEXT_466 = ".";
  protected final String TEXT_467 = "); }";
  protected final String TEXT_468 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_469 = ")" + NL + "    {";
  protected final String TEXT_470 = NL + "      ";
  protected final String TEXT_471 = NL + "    }";
  protected final String TEXT_472 = NL + "    if (";
  protected final String TEXT_473 = " == ";
  protected final String TEXT_474 = ".HStar) { ";
  protected final String TEXT_475 = " = ";
  protected final String TEXT_476 = "HStar;}";
  protected final String TEXT_477 = NL + "  }" + NL;
  protected final String TEXT_478 = NL + "  public ";
  protected final String TEXT_479 = " ";
  protected final String TEXT_480 = "()" + NL + "  {";
  protected final String TEXT_481 = NL + "    return ";
  protected final String TEXT_482 = ";";
  protected final String TEXT_483 = NL + "    ";
  protected final String TEXT_484 = " ";
  protected final String TEXT_485 = " = ";
  protected final String TEXT_486 = ";";
  protected final String TEXT_487 = NL + "    return ";
  protected final String TEXT_488 = ";";
  protected final String TEXT_489 = NL + "  }";
  protected final String TEXT_490 = NL + NL + "  public boolean ";
  protected final String TEXT_491 = "()" + NL + "  {" + NL + "    boolean has = ";
  protected final String TEXT_492 = " != null;" + NL + "    return has;" + NL + "  }";
  protected final String TEXT_493 = NL;
  protected final String TEXT_494 = NL + "  public ";
  protected final String TEXT_495 = " ";
  protected final String TEXT_496 = "(int index)" + NL + "  {";
  protected final String TEXT_497 = NL + "    ";
  protected final String TEXT_498 = " ";
  protected final String TEXT_499 = " = ";
  protected final String TEXT_500 = ".get(index);";
  protected final String TEXT_501 = NL + "    return ";
  protected final String TEXT_502 = ";" + NL + "  }" + NL;
  protected final String TEXT_503 = NL + "  public List<";
  protected final String TEXT_504 = "> ";
  protected final String TEXT_505 = "()" + NL + "  {";
  protected final String TEXT_506 = NL + "    List<";
  protected final String TEXT_507 = "> ";
  protected final String TEXT_508 = " = Collections.unmodifiableList(";
  protected final String TEXT_509 = ");";
  protected final String TEXT_510 = NL + "    return ";
  protected final String TEXT_511 = ";" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_512 = "()" + NL + "  {";
  protected final String TEXT_513 = NL + "    int number = ";
  protected final String TEXT_514 = ".size();";
  protected final String TEXT_515 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_516 = "()" + NL + "  {";
  protected final String TEXT_517 = NL + "    boolean has = ";
  protected final String TEXT_518 = ".size() > 0;";
  protected final String TEXT_519 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_520 = "(";
  protected final String TEXT_521 = " ";
  protected final String TEXT_522 = ")" + NL + "  {";
  protected final String TEXT_523 = NL + "    int index = ";
  protected final String TEXT_524 = ".indexOf(";
  protected final String TEXT_525 = ");";
  protected final String TEXT_526 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_527 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_528 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_529 = " : ";
  protected final String TEXT_530 = NL + "  public boolean ";
  protected final String TEXT_531 = "()" + NL + "  {";
  protected final String TEXT_532 = NL + "    boolean isValid = ";
  protected final String TEXT_533 = "() >= ";
  protected final String TEXT_534 = "();";
  protected final String TEXT_535 = NL + "    boolean isValid = ";
  protected final String TEXT_536 = "() >= ";
  protected final String TEXT_537 = "() && ";
  protected final String TEXT_538 = "() <= ";
  protected final String TEXT_539 = "();";
  protected final String TEXT_540 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_541 = NL + "  public static int ";
  protected final String TEXT_542 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_543 = ";" + NL + "  }";
  protected final String TEXT_544 = NL + "  public static int ";
  protected final String TEXT_545 = "()" + NL + "  {";
  protected final String TEXT_546 = NL + "    int required = ";
  protected final String TEXT_547 = ";";
  protected final String TEXT_548 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_549 = NL + "  public static int ";
  protected final String TEXT_550 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_551 = ";" + NL + "  }";
  protected final String TEXT_552 = NL + "  public static int ";
  protected final String TEXT_553 = "()" + NL + "  {";
  protected final String TEXT_554 = NL + "    int minimum = ";
  protected final String TEXT_555 = ";";
  protected final String TEXT_556 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_557 = NL + "  public static int ";
  protected final String TEXT_558 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_559 = ";" + NL + "  }";
  protected final String TEXT_560 = NL + "  public static int ";
  protected final String TEXT_561 = "()" + NL + "  {";
  protected final String TEXT_562 = NL + "    int maximum = ";
  protected final String TEXT_563 = ";";
  protected final String TEXT_564 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_565 = NL + "  public boolean ";
  protected final String TEXT_566 = "(";
  protected final String TEXT_567 = " ";
  protected final String TEXT_568 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_569 = NL + "    if (";
  protected final String TEXT_570 = "() >= ";
  protected final String TEXT_571 = "())" + NL + "    {";
  protected final String TEXT_572 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_573 = NL + "    ";
  protected final String TEXT_574 = ".add(";
  protected final String TEXT_575 = ");";
  protected final String TEXT_576 = NL + "    if (";
  protected final String TEXT_577 = ".";
  protected final String TEXT_578 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_579 = ".";
  protected final String TEXT_580 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_581 = NL + "        ";
  protected final String TEXT_582 = ".remove(";
  protected final String TEXT_583 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_584 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_585 = NL + "  public boolean ";
  protected final String TEXT_586 = "(";
  protected final String TEXT_587 = " ";
  protected final String TEXT_588 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_589 = NL + "    if (!";
  protected final String TEXT_590 = ".contains(";
  protected final String TEXT_591 = "))" + NL + "    {";
  protected final String TEXT_592 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_593 = ".indexOf(";
  protected final String TEXT_594 = ");";
  protected final String TEXT_595 = NL + "    ";
  protected final String TEXT_596 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_597 = ".";
  protected final String TEXT_598 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_599 = ".";
  protected final String TEXT_600 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_601 = NL + "        ";
  protected final String TEXT_602 = ".add(oldIndex,";
  protected final String TEXT_603 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_604 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_605 = NL + "  ";
  protected final String TEXT_606 = " boolean ";
  protected final String TEXT_607 = "(";
  protected final String TEXT_608 = " ";
  protected final String TEXT_609 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_610 = NL + "    ";
  protected final String TEXT_611 = " = ";
  protected final String TEXT_612 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_613 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_614 = NL + "  ";
  protected final String TEXT_615 = " boolean ";
  protected final String TEXT_616 = "(";
  protected final String TEXT_617 = " ";
  protected final String TEXT_618 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_619 = NL + "    if (";
  protected final String TEXT_620 = " != null)" + NL + "    {";
  protected final String TEXT_621 = NL + "      ";
  protected final String TEXT_622 = " = ";
  protected final String TEXT_623 = ";" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_624 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_625 = NL + "  public boolean ";
  protected final String TEXT_626 = "(";
  protected final String TEXT_627 = " ";
  protected final String TEXT_628 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_629 = NL + "    if (";
  protected final String TEXT_630 = " != null && !";
  protected final String TEXT_631 = ".equals(";
  protected final String TEXT_632 = ") && equals(";
  protected final String TEXT_633 = ".";
  protected final String TEXT_634 = "()))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_635 = ", as existing ";
  protected final String TEXT_636 = " would become an orphan";
  protected final String TEXT_637 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_638 = NL + "    ";
  protected final String TEXT_639 = " = ";
  protected final String TEXT_640 = ";";
  protected final String TEXT_641 = NL + "    ";
  protected final String TEXT_642 = " ";
  protected final String TEXT_643 = " = ";
  protected final String TEXT_644 = " != null ? ";
  protected final String TEXT_645 = ".";
  protected final String TEXT_646 = "() : null;" + NL + "" + NL + "    if (!this.equals(";
  protected final String TEXT_647 = "))" + NL + "    {" + NL + "      if (";
  protected final String TEXT_648 = " != null)" + NL + "      {";
  protected final String TEXT_649 = NL + "        ";
  protected final String TEXT_650 = ".";
  protected final String TEXT_651 = " = null;" + NL + "      }" + NL + "      if (";
  protected final String TEXT_652 = " != null)" + NL + "      {";
  protected final String TEXT_653 = NL + "        ";
  protected final String TEXT_654 = ".";
  protected final String TEXT_655 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_656 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_657 = NL + "  public boolean ";
  protected final String TEXT_658 = "(";
  protected final String TEXT_659 = " ";
  protected final String TEXT_660 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_661 = NL + "    if (";
  protected final String TEXT_662 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_663 = " to null, as ";
  protected final String TEXT_664 = " must always be associated to a ";
  protected final String TEXT_665 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_666 = NL + "    ";
  protected final String TEXT_667 = " ";
  protected final String TEXT_668 = " = ";
  protected final String TEXT_669 = ".";
  protected final String TEXT_670 = "();" + NL + "    if (";
  protected final String TEXT_671 = " != null && !equals(";
  protected final String TEXT_672 = "))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_673 = ", the current ";
  protected final String TEXT_674 = " already has a ";
  protected final String TEXT_675 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_676 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_677 = NL + "    ";
  protected final String TEXT_678 = " ";
  protected final String TEXT_679 = " = ";
  protected final String TEXT_680 = ";";
  protected final String TEXT_681 = NL + "    ";
  protected final String TEXT_682 = " = ";
  protected final String TEXT_683 = ";";
  protected final String TEXT_684 = NL + "    ";
  protected final String TEXT_685 = ".";
  protected final String TEXT_686 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_687 = " != null)" + NL + "    {";
  protected final String TEXT_688 = NL + "      ";
  protected final String TEXT_689 = ".";
  protected final String TEXT_690 = "(null);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_691 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_692 = NL + "  public ";
  protected final String TEXT_693 = " ";
  protected final String TEXT_694 = "(";
  protected final String TEXT_695 = ")" + NL + "  {";
  protected final String TEXT_696 = NL + "    ";
  protected final String TEXT_697 = " ";
  protected final String TEXT_698 = " = new ";
  protected final String TEXT_699 = "(";
  protected final String TEXT_700 = ");";
  protected final String TEXT_701 = NL + "    return ";
  protected final String TEXT_702 = ";" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_703 = "(";
  protected final String TEXT_704 = " ";
  protected final String TEXT_705 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_706 = NL + "    ";
  protected final String TEXT_707 = " ";
  protected final String TEXT_708 = " = ";
  protected final String TEXT_709 = ".";
  protected final String TEXT_710 = "();" + NL + "    boolean ";
  protected final String TEXT_711 = " = ";
  protected final String TEXT_712 = " != null && !this.equals(";
  protected final String TEXT_713 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_714 = " && ";
  protected final String TEXT_715 = ".";
  protected final String TEXT_716 = "() <= ";
  protected final String TEXT_717 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_718 = NL + "    if (";
  protected final String TEXT_719 = ")" + NL + "    {";
  protected final String TEXT_720 = NL + "      ";
  protected final String TEXT_721 = ".";
  protected final String TEXT_722 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_723 = NL + "      ";
  protected final String TEXT_724 = ".add(";
  protected final String TEXT_725 = ");" + NL + "    }";
  protected final String TEXT_726 = NL + "    wasAdded = true;";
  protected final String TEXT_727 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_728 = "(";
  protected final String TEXT_729 = " ";
  protected final String TEXT_730 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_731 = NL + "    //Unable to remove ";
  protected final String TEXT_732 = ", as it must always have a ";
  protected final String TEXT_733 = NL + "    if (this.equals(";
  protected final String TEXT_734 = ".";
  protected final String TEXT_735 = "()))" + NL + "    {";
  protected final String TEXT_736 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_737 = " already at minimum (";
  protected final String TEXT_738 = ")" + NL + "    if (";
  protected final String TEXT_739 = "() <= ";
  protected final String TEXT_740 = "())" + NL + "    {";
  protected final String TEXT_741 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_742 = NL;
  protected final String TEXT_743 = NL + "    ";
  protected final String TEXT_744 = ".remove(";
  protected final String TEXT_745 = ");";
  protected final String TEXT_746 = NL + "    wasRemoved = true;";
  protected final String TEXT_747 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_748 = NL + "  public ";
  protected final String TEXT_749 = " ";
  protected final String TEXT_750 = "(";
  protected final String TEXT_751 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_752 = "() >= ";
  protected final String TEXT_753 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_754 = "(";
  protected final String TEXT_755 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_756 = "(";
  protected final String TEXT_757 = " ";
  protected final String TEXT_758 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_759 = NL + "    if (";
  protected final String TEXT_760 = "() >= ";
  protected final String TEXT_761 = "())" + NL + "    {";
  protected final String TEXT_762 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_763 = NL + "    ";
  protected final String TEXT_764 = " ";
  protected final String TEXT_765 = " = ";
  protected final String TEXT_766 = ".";
  protected final String TEXT_767 = "();" + NL + "    boolean ";
  protected final String TEXT_768 = " = ";
  protected final String TEXT_769 = " != null && !this.equals(";
  protected final String TEXT_770 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_771 = " && ";
  protected final String TEXT_772 = ".";
  protected final String TEXT_773 = "() <= ";
  protected final String TEXT_774 = "())" + NL + "    {";
  protected final String TEXT_775 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_776 = NL + NL + "    if (";
  protected final String TEXT_777 = ")" + NL + "    {";
  protected final String TEXT_778 = NL + "      ";
  protected final String TEXT_779 = ".";
  protected final String TEXT_780 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_781 = NL + "      ";
  protected final String TEXT_782 = ".add(";
  protected final String TEXT_783 = ");" + NL + "    }";
  protected final String TEXT_784 = NL + "    wasAdded = true;";
  protected final String TEXT_785 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_786 = "(";
  protected final String TEXT_787 = " ";
  protected final String TEXT_788 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_789 = NL + "    //Unable to remove ";
  protected final String TEXT_790 = ", as it must always have a ";
  protected final String TEXT_791 = NL + "    if (this.equals(";
  protected final String TEXT_792 = ".";
  protected final String TEXT_793 = "()))" + NL + "    {";
  protected final String TEXT_794 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_795 = " already at minimum (";
  protected final String TEXT_796 = ")" + NL + "    if (";
  protected final String TEXT_797 = "() <= ";
  protected final String TEXT_798 = "())" + NL + "    {";
  protected final String TEXT_799 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_800 = NL + "    ";
  protected final String TEXT_801 = ".remove(";
  protected final String TEXT_802 = ");";
  protected final String TEXT_803 = NL + "    wasRemoved = true;";
  protected final String TEXT_804 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_805 = NL + "  public ";
  protected final String TEXT_806 = " ";
  protected final String TEXT_807 = "(";
  protected final String TEXT_808 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_809 = "() >= ";
  protected final String TEXT_810 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_811 = "(";
  protected final String TEXT_812 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_813 = "(";
  protected final String TEXT_814 = " ";
  protected final String TEXT_815 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_816 = NL + "    if (";
  protected final String TEXT_817 = "() >= ";
  protected final String TEXT_818 = "())" + NL + "    {";
  protected final String TEXT_819 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_820 = NL + "    ";
  protected final String TEXT_821 = " ";
  protected final String TEXT_822 = " = ";
  protected final String TEXT_823 = ".";
  protected final String TEXT_824 = "();" + NL + "    boolean ";
  protected final String TEXT_825 = " = ";
  protected final String TEXT_826 = " != null && !this.equals(";
  protected final String TEXT_827 = ");";
  protected final String TEXT_828 = NL + "    if (";
  protected final String TEXT_829 = ")" + NL + "    {";
  protected final String TEXT_830 = NL + "      ";
  protected final String TEXT_831 = ".";
  protected final String TEXT_832 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_833 = NL + "      ";
  protected final String TEXT_834 = ".add(";
  protected final String TEXT_835 = ");" + NL + "    }";
  protected final String TEXT_836 = NL + "    wasAdded = true;";
  protected final String TEXT_837 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_838 = "(";
  protected final String TEXT_839 = " ";
  protected final String TEXT_840 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_841 = NL + "    //Unable to remove ";
  protected final String TEXT_842 = ", as it must always have a ";
  protected final String TEXT_843 = NL + "    if (!this.equals(";
  protected final String TEXT_844 = ".";
  protected final String TEXT_845 = "()))" + NL + "    {";
  protected final String TEXT_846 = NL + "      ";
  protected final String TEXT_847 = ".remove(";
  protected final String TEXT_848 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_849 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_850 = NL + "  public boolean ";
  protected final String TEXT_851 = "(";
  protected final String TEXT_852 = "... ";
  protected final String TEXT_853 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_854 = NL + "    ArrayList<";
  protected final String TEXT_855 = "> ";
  protected final String TEXT_856 = " = new ArrayList<";
  protected final String TEXT_857 = ">();" + NL + "    for (";
  protected final String TEXT_858 = " ";
  protected final String TEXT_859 = " : ";
  protected final String TEXT_860 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_861 = ".contains(";
  protected final String TEXT_862 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_863 = NL + "      ";
  protected final String TEXT_864 = ".add(";
  protected final String TEXT_865 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_866 = ".size() != ";
  protected final String TEXT_867 = ".length || ";
  protected final String TEXT_868 = ".size() > ";
  protected final String TEXT_869 = "())" + NL + "    {";
  protected final String TEXT_870 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_871 = "> ";
  protected final String TEXT_872 = " = new ArrayList<";
  protected final String TEXT_873 = ">(";
  protected final String TEXT_874 = ");";
  protected final String TEXT_875 = NL + "    ";
  protected final String TEXT_876 = ".clear();" + NL + "    for (";
  protected final String TEXT_877 = " ";
  protected final String TEXT_878 = " : ";
  protected final String TEXT_879 = ")" + NL + "    {";
  protected final String TEXT_880 = NL + "      ";
  protected final String TEXT_881 = ".add(";
  protected final String TEXT_882 = ");" + NL + "      if (";
  protected final String TEXT_883 = ".contains(";
  protected final String TEXT_884 = "))" + NL + "      {";
  protected final String TEXT_885 = NL + "        ";
  protected final String TEXT_886 = ".remove(";
  protected final String TEXT_887 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_888 = NL + "        ";
  protected final String TEXT_889 = ".";
  protected final String TEXT_890 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_891 = " ";
  protected final String TEXT_892 = " : ";
  protected final String TEXT_893 = ")" + NL + "    {";
  protected final String TEXT_894 = NL + "      ";
  protected final String TEXT_895 = ".";
  protected final String TEXT_896 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_897 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_898 = NL + "  public ";
  protected final String TEXT_899 = " ";
  protected final String TEXT_900 = "(";
  protected final String TEXT_901 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_902 = "(";
  protected final String TEXT_903 = ");" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_904 = "(";
  protected final String TEXT_905 = " ";
  protected final String TEXT_906 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_907 = NL + "    ";
  protected final String TEXT_908 = " ";
  protected final String TEXT_909 = " = ";
  protected final String TEXT_910 = ".";
  protected final String TEXT_911 = "();" + NL + "    boolean ";
  protected final String TEXT_912 = " = ";
  protected final String TEXT_913 = " != null && !this.equals(";
  protected final String TEXT_914 = ");";
  protected final String TEXT_915 = NL + "    if (";
  protected final String TEXT_916 = ")" + NL + "    {";
  protected final String TEXT_917 = NL + "      ";
  protected final String TEXT_918 = ".";
  protected final String TEXT_919 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_920 = NL + "      ";
  protected final String TEXT_921 = ".add(";
  protected final String TEXT_922 = ");" + NL + "    }";
  protected final String TEXT_923 = NL + "    wasAdded = true;";
  protected final String TEXT_924 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_925 = "(";
  protected final String TEXT_926 = " ";
  protected final String TEXT_927 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_928 = NL + "    //Unable to remove ";
  protected final String TEXT_929 = ", as it must always have a ";
  protected final String TEXT_930 = NL + "    if (!this.equals(";
  protected final String TEXT_931 = ".";
  protected final String TEXT_932 = "()))" + NL + "    {";
  protected final String TEXT_933 = NL + "      ";
  protected final String TEXT_934 = ".remove(";
  protected final String TEXT_935 = ");";
  protected final String TEXT_936 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_937 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_938 = NL + "  public boolean ";
  protected final String TEXT_939 = "(";
  protected final String TEXT_940 = " ";
  protected final String TEXT_941 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_942 = NL + "    if (";
  protected final String TEXT_943 = " == null)" + NL + "    {";
  protected final String TEXT_944 = NL + "      ";
  protected final String TEXT_945 = " ";
  protected final String TEXT_946 = " = ";
  protected final String TEXT_947 = ";";
  protected final String TEXT_948 = NL + "      ";
  protected final String TEXT_949 = " = null;" + NL + "      " + NL + "      if (";
  protected final String TEXT_950 = " != null && ";
  protected final String TEXT_951 = ".";
  protected final String TEXT_952 = "() != null)" + NL + "      {";
  protected final String TEXT_953 = NL + "        ";
  protected final String TEXT_954 = ".";
  protected final String TEXT_955 = "(null);" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_956 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_957 = NL + "    ";
  protected final String TEXT_958 = " ";
  protected final String TEXT_959 = " = ";
  protected final String TEXT_960 = "();" + NL + "    if (";
  protected final String TEXT_961 = " != null && !";
  protected final String TEXT_962 = ".equals(";
  protected final String TEXT_963 = "))" + NL + "    {";
  protected final String TEXT_964 = NL + "      ";
  protected final String TEXT_965 = ".";
  protected final String TEXT_966 = "(null);" + NL + "    }" + NL;
  protected final String TEXT_967 = NL + "    ";
  protected final String TEXT_968 = " = ";
  protected final String TEXT_969 = ";";
  protected final String TEXT_970 = NL + "    ";
  protected final String TEXT_971 = " ";
  protected final String TEXT_972 = " = ";
  protected final String TEXT_973 = ".";
  protected final String TEXT_974 = "();" + NL + "" + NL + "    if (!equals(";
  protected final String TEXT_975 = "))" + NL + "    {";
  protected final String TEXT_976 = NL + "      ";
  protected final String TEXT_977 = ".";
  protected final String TEXT_978 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_979 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_980 = NL + "  public boolean ";
  protected final String TEXT_981 = "(";
  protected final String TEXT_982 = " ";
  protected final String TEXT_983 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_984 = NL + "    if (!";
  protected final String TEXT_985 = ".contains(";
  protected final String TEXT_986 = "))" + NL + "    {";
  protected final String TEXT_987 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_988 = "() <= ";
  protected final String TEXT_989 = "())" + NL + "    {";
  protected final String TEXT_990 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_991 = ".indexOf(";
  protected final String TEXT_992 = ");";
  protected final String TEXT_993 = NL + "    ";
  protected final String TEXT_994 = ".remove(oldIndex);";
  protected final String TEXT_995 = NL + "    if (";
  protected final String TEXT_996 = ".";
  protected final String TEXT_997 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_998 = ".";
  protected final String TEXT_999 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_1000 = NL + "        ";
  protected final String TEXT_1001 = ".add(oldIndex,";
  protected final String TEXT_1002 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1003 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1004 = NL + "  public boolean ";
  protected final String TEXT_1005 = "(";
  protected final String TEXT_1006 = " ";
  protected final String TEXT_1007 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1008 = NL + "    if (!";
  protected final String TEXT_1009 = ".contains(";
  protected final String TEXT_1010 = "))" + NL + "    {";
  protected final String TEXT_1011 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1012 = "() <= ";
  protected final String TEXT_1013 = "())" + NL + "    {";
  protected final String TEXT_1014 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_1015 = ".indexOf(";
  protected final String TEXT_1016 = ");";
  protected final String TEXT_1017 = NL + "    ";
  protected final String TEXT_1018 = ".remove(oldIndex);";
  protected final String TEXT_1019 = NL + "    if (";
  protected final String TEXT_1020 = ".";
  protected final String TEXT_1021 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_1022 = ".";
  protected final String TEXT_1023 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_1024 = NL + "        ";
  protected final String TEXT_1025 = ".add(oldIndex,";
  protected final String TEXT_1026 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1027 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1028 = NL + "  public boolean ";
  protected final String TEXT_1029 = "(";
  protected final String TEXT_1030 = " ";
  protected final String TEXT_1031 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1032 = NL + "    if (";
  protected final String TEXT_1033 = " != null && ";
  protected final String TEXT_1034 = ".";
  protected final String TEXT_1035 = "() >= ";
  protected final String TEXT_1036 = ".";
  protected final String TEXT_1037 = "())" + NL + "    {";
  protected final String TEXT_1038 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1039 = NL + "    ";
  protected final String TEXT_1040 = " ";
  protected final String TEXT_1041 = " = ";
  protected final String TEXT_1042 = ";";
  protected final String TEXT_1043 = NL + "    ";
  protected final String TEXT_1044 = " = ";
  protected final String TEXT_1045 = ";" + NL + "    if (";
  protected final String TEXT_1046 = " != null && !";
  protected final String TEXT_1047 = ".equals(";
  protected final String TEXT_1048 = "))" + NL + "    {";
  protected final String TEXT_1049 = NL + "      ";
  protected final String TEXT_1050 = ".";
  protected final String TEXT_1051 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1052 = " != null)" + NL + "    {";
  protected final String TEXT_1053 = NL + "      ";
  protected final String TEXT_1054 = ".";
  protected final String TEXT_1055 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1056 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1057 = NL + "  public boolean ";
  protected final String TEXT_1058 = "(";
  protected final String TEXT_1059 = " ";
  protected final String TEXT_1060 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1061 = NL + "    if (";
  protected final String TEXT_1062 = " == null)" + NL + "    {";
  protected final String TEXT_1063 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1064 = NL + "    ";
  protected final String TEXT_1065 = " ";
  protected final String TEXT_1066 = " = ";
  protected final String TEXT_1067 = ";";
  protected final String TEXT_1068 = NL + "    ";
  protected final String TEXT_1069 = " = ";
  protected final String TEXT_1070 = ";" + NL + "    if (";
  protected final String TEXT_1071 = " != null && !";
  protected final String TEXT_1072 = ".equals(";
  protected final String TEXT_1073 = "))" + NL + "    {";
  protected final String TEXT_1074 = NL + "      ";
  protected final String TEXT_1075 = ".";
  protected final String TEXT_1076 = "(this);" + NL + "    }";
  protected final String TEXT_1077 = NL + "    ";
  protected final String TEXT_1078 = ".";
  protected final String TEXT_1079 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1080 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1081 = NL + "  public boolean ";
  protected final String TEXT_1082 = "(";
  protected final String TEXT_1083 = " ";
  protected final String TEXT_1084 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1085 = NL + "    if (";
  protected final String TEXT_1086 = " == null)" + NL + "    {";
  protected final String TEXT_1087 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1088 = NL + "    ";
  protected final String TEXT_1089 = " ";
  protected final String TEXT_1090 = " = ";
  protected final String TEXT_1091 = ";";
  protected final String TEXT_1092 = NL + "    ";
  protected final String TEXT_1093 = " = ";
  protected final String TEXT_1094 = ";" + NL + "    if (";
  protected final String TEXT_1095 = " != null && !";
  protected final String TEXT_1096 = ".equals(";
  protected final String TEXT_1097 = "))" + NL + "    {";
  protected final String TEXT_1098 = NL + "      ";
  protected final String TEXT_1099 = ".";
  protected final String TEXT_1100 = "(this);" + NL + "    }" + NL + "    if (!";
  protected final String TEXT_1101 = ".";
  protected final String TEXT_1102 = "(this))" + NL + "    {";
  protected final String TEXT_1103 = NL + "      ";
  protected final String TEXT_1104 = " = ";
  protected final String TEXT_1105 = ";" + NL + "      wasSet = false;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_1106 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1107 = NL + "  public boolean ";
  protected final String TEXT_1108 = "(";
  protected final String TEXT_1109 = " ";
  protected final String TEXT_1110 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1111 = NL + "    //Must provide ";
  protected final String TEXT_1112 = " to ";
  protected final String TEXT_1113 = NL + "    if (";
  protected final String TEXT_1114 = " == null)" + NL + "    {";
  protected final String TEXT_1115 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1116 = " already at maximum (";
  protected final String TEXT_1117 = ")" + NL + "    if (";
  protected final String TEXT_1118 = ".";
  protected final String TEXT_1119 = "() >= ";
  protected final String TEXT_1120 = ".";
  protected final String TEXT_1121 = "())" + NL + "    {";
  protected final String TEXT_1122 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1123 = NL + "    ";
  protected final String TEXT_1124 = " ";
  protected final String TEXT_1125 = " = ";
  protected final String TEXT_1126 = ";";
  protected final String TEXT_1127 = NL + "    ";
  protected final String TEXT_1128 = " = ";
  protected final String TEXT_1129 = ";" + NL + "    if (";
  protected final String TEXT_1130 = " != null && !";
  protected final String TEXT_1131 = ".equals(";
  protected final String TEXT_1132 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1133 = ".";
  protected final String TEXT_1134 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1135 = NL + "        ";
  protected final String TEXT_1136 = " = ";
  protected final String TEXT_1137 = ";";
  protected final String TEXT_1138 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1139 = NL + "    ";
  protected final String TEXT_1140 = ".";
  protected final String TEXT_1141 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1142 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1143 = NL + "  public boolean ";
  protected final String TEXT_1144 = "(";
  protected final String TEXT_1145 = " ";
  protected final String TEXT_1146 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1147 = NL + "    //Must provide ";
  protected final String TEXT_1148 = " to ";
  protected final String TEXT_1149 = NL + "    if (";
  protected final String TEXT_1150 = " == null)" + NL + "    {";
  protected final String TEXT_1151 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1152 = " != null && ";
  protected final String TEXT_1153 = ".";
  protected final String TEXT_1154 = "() <= ";
  protected final String TEXT_1155 = ".";
  protected final String TEXT_1156 = "())" + NL + "    {";
  protected final String TEXT_1157 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1158 = NL + "    ";
  protected final String TEXT_1159 = " ";
  protected final String TEXT_1160 = " = ";
  protected final String TEXT_1161 = ";";
  protected final String TEXT_1162 = NL + "    ";
  protected final String TEXT_1163 = " = ";
  protected final String TEXT_1164 = ";" + NL + "    if (";
  protected final String TEXT_1165 = " != null && !";
  protected final String TEXT_1166 = ".equals(";
  protected final String TEXT_1167 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1168 = ".";
  protected final String TEXT_1169 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1170 = NL + "        ";
  protected final String TEXT_1171 = " = ";
  protected final String TEXT_1172 = ";";
  protected final String TEXT_1173 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1174 = NL + "    ";
  protected final String TEXT_1175 = ".";
  protected final String TEXT_1176 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1177 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1178 = NL + "  public boolean ";
  protected final String TEXT_1179 = "(";
  protected final String TEXT_1180 = " ";
  protected final String TEXT_1181 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1182 = NL + "    ";
  protected final String TEXT_1183 = " ";
  protected final String TEXT_1184 = " = ";
  protected final String TEXT_1185 = ".";
  protected final String TEXT_1186 = "();";
  protected final String TEXT_1187 = NL + "    if (";
  protected final String TEXT_1188 = " == null)" + NL + "    {";
  protected final String TEXT_1189 = NL + "      ";
  protected final String TEXT_1190 = ".";
  protected final String TEXT_1191 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1192 = "))" + NL + "    {";
  protected final String TEXT_1193 = NL + "      ";
  protected final String TEXT_1194 = ".";
  protected final String TEXT_1195 = "(";
  protected final String TEXT_1196 = ");";
  protected final String TEXT_1197 = NL + "      ";
  protected final String TEXT_1198 = "(";
  protected final String TEXT_1199 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1200 = NL + "      ";
  protected final String TEXT_1201 = ".add(";
  protected final String TEXT_1202 = ");" + NL + "    }";
  protected final String TEXT_1203 = NL + "    wasAdded = true;";
  protected final String TEXT_1204 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1205 = "(";
  protected final String TEXT_1206 = " ";
  protected final String TEXT_1207 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1208 = NL + "    if (";
  protected final String TEXT_1209 = ".contains(";
  protected final String TEXT_1210 = "))" + NL + "    {";
  protected final String TEXT_1211 = NL + "      ";
  protected final String TEXT_1212 = ".remove(";
  protected final String TEXT_1213 = ");";
  protected final String TEXT_1214 = NL + "      ";
  protected final String TEXT_1215 = ".";
  protected final String TEXT_1216 = "(null);" + NL + "      wasRemoved = true;";
  protected final String TEXT_1217 = NL + "    }";
  protected final String TEXT_1218 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1219 = NL + "  public boolean ";
  protected final String TEXT_1220 = "(";
  protected final String TEXT_1221 = " ";
  protected final String TEXT_1222 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1223 = NL + "    ";
  protected final String TEXT_1224 = " ";
  protected final String TEXT_1225 = " = ";
  protected final String TEXT_1226 = ";";
  protected final String TEXT_1227 = NL + "    ";
  protected final String TEXT_1228 = " = ";
  protected final String TEXT_1229 = ";" + NL + "    if (";
  protected final String TEXT_1230 = " != null && !";
  protected final String TEXT_1231 = ".equals(";
  protected final String TEXT_1232 = "))" + NL + "    {";
  protected final String TEXT_1233 = NL + "      ";
  protected final String TEXT_1234 = ".";
  protected final String TEXT_1235 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1236 = " != null)" + NL + "    {";
  protected final String TEXT_1237 = NL + "      ";
  protected final String TEXT_1238 = ".";
  protected final String TEXT_1239 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1240 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1241 = NL + "  public boolean ";
  protected final String TEXT_1242 = "(";
  protected final String TEXT_1243 = " ";
  protected final String TEXT_1244 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1245 = NL + "    if (";
  protected final String TEXT_1246 = "() >= ";
  protected final String TEXT_1247 = "())" + NL + "    {";
  protected final String TEXT_1248 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1249 = NL + "    ";
  protected final String TEXT_1250 = " ";
  protected final String TEXT_1251 = " = ";
  protected final String TEXT_1252 = ".";
  protected final String TEXT_1253 = "();";
  protected final String TEXT_1254 = NL + "    if (";
  protected final String TEXT_1255 = " == null)" + NL + "    {";
  protected final String TEXT_1256 = NL + "      ";
  protected final String TEXT_1257 = ".";
  protected final String TEXT_1258 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1259 = "))" + NL + "    {";
  protected final String TEXT_1260 = NL + "      ";
  protected final String TEXT_1261 = ".";
  protected final String TEXT_1262 = "(";
  protected final String TEXT_1263 = ");";
  protected final String TEXT_1264 = NL + "      ";
  protected final String TEXT_1265 = "(";
  protected final String TEXT_1266 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1267 = NL + "      ";
  protected final String TEXT_1268 = ".add(";
  protected final String TEXT_1269 = ");" + NL + "    }";
  protected final String TEXT_1270 = NL + "    wasAdded = true;";
  protected final String TEXT_1271 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1272 = "(";
  protected final String TEXT_1273 = " ";
  protected final String TEXT_1274 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1275 = NL + "    if (";
  protected final String TEXT_1276 = ".contains(";
  protected final String TEXT_1277 = "))" + NL + "    {";
  protected final String TEXT_1278 = NL + "      ";
  protected final String TEXT_1279 = ".remove(";
  protected final String TEXT_1280 = ");";
  protected final String TEXT_1281 = NL + "      ";
  protected final String TEXT_1282 = ".";
  protected final String TEXT_1283 = "(null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1284 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1285 = NL + "  public boolean ";
  protected final String TEXT_1286 = "(";
  protected final String TEXT_1287 = " ";
  protected final String TEXT_1288 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1289 = NL + "    if (";
  protected final String TEXT_1290 = "() < ";
  protected final String TEXT_1291 = "())" + NL + "    {";
  protected final String TEXT_1292 = NL + "      ";
  protected final String TEXT_1293 = ".add(";
  protected final String TEXT_1294 = ");";
  protected final String TEXT_1295 = NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1296 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1297 = "(";
  protected final String TEXT_1298 = " ";
  protected final String TEXT_1299 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1300 = NL + "    if (!";
  protected final String TEXT_1301 = ".contains(";
  protected final String TEXT_1302 = "))" + NL + "    {";
  protected final String TEXT_1303 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1304 = "() <= ";
  protected final String TEXT_1305 = "())" + NL + "    {";
  protected final String TEXT_1306 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_1307 = NL;
  protected final String TEXT_1308 = NL + "    ";
  protected final String TEXT_1309 = ".remove(";
  protected final String TEXT_1310 = ");";
  protected final String TEXT_1311 = NL + "    wasRemoved = true;";
  protected final String TEXT_1312 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1313 = NL + "  public boolean ";
  protected final String TEXT_1314 = "(";
  protected final String TEXT_1315 = " ";
  protected final String TEXT_1316 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1317 = NL + "    if (";
  protected final String TEXT_1318 = "() >= ";
  protected final String TEXT_1319 = "())" + NL + "    {";
  protected final String TEXT_1320 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1321 = NL + "    ";
  protected final String TEXT_1322 = " ";
  protected final String TEXT_1323 = " = ";
  protected final String TEXT_1324 = ".";
  protected final String TEXT_1325 = "();" + NL + "    if (";
  protected final String TEXT_1326 = " != null && ";
  protected final String TEXT_1327 = ".";
  protected final String TEXT_1328 = "() <= ";
  protected final String TEXT_1329 = "())" + NL + "    {";
  protected final String TEXT_1330 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1331 = " != null)" + NL + "    {";
  protected final String TEXT_1332 = NL + "      ";
  protected final String TEXT_1333 = ".";
  protected final String TEXT_1334 = ".remove(";
  protected final String TEXT_1335 = ");" + NL + "    }";
  protected final String TEXT_1336 = NL + "    ";
  protected final String TEXT_1337 = ".add(";
  protected final String TEXT_1338 = ");";
  protected final String TEXT_1339 = NL + "    ";
  protected final String TEXT_1340 = "(";
  protected final String TEXT_1341 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1342 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1343 = "(";
  protected final String TEXT_1344 = " ";
  protected final String TEXT_1345 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1346 = NL + "    if (";
  protected final String TEXT_1347 = ".contains(";
  protected final String TEXT_1348 = ") && ";
  protected final String TEXT_1349 = "() > ";
  protected final String TEXT_1350 = "())" + NL + "    {";
  protected final String TEXT_1351 = NL + "      ";
  protected final String TEXT_1352 = ".remove(";
  protected final String TEXT_1353 = ");";
  protected final String TEXT_1354 = NL + "      ";
  protected final String TEXT_1355 = "(";
  protected final String TEXT_1356 = ",null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1357 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1358 = NL + "  public boolean ";
  protected final String TEXT_1359 = "(";
  protected final String TEXT_1360 = "... ";
  protected final String TEXT_1361 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1362 = NL + "    ArrayList<";
  protected final String TEXT_1363 = "> ";
  protected final String TEXT_1364 = " = new ArrayList<";
  protected final String TEXT_1365 = ">();" + NL + "    for (";
  protected final String TEXT_1366 = " ";
  protected final String TEXT_1367 = " : ";
  protected final String TEXT_1368 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1369 = ".contains(";
  protected final String TEXT_1370 = "))" + NL + "      {";
  protected final String TEXT_1371 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1372 = ".";
  protected final String TEXT_1373 = "() != null && !this.equals(";
  protected final String TEXT_1374 = ".";
  protected final String TEXT_1375 = "()))" + NL + "      {";
  protected final String TEXT_1376 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1377 = NL + "      ";
  protected final String TEXT_1378 = ".add(";
  protected final String TEXT_1379 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1380 = ".size() != ";
  protected final String TEXT_1381 = "())" + NL + "    {";
  protected final String TEXT_1382 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1383 = NL + "    ";
  protected final String TEXT_1384 = ".removeAll(";
  protected final String TEXT_1385 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1386 = " orphan : ";
  protected final String TEXT_1387 = ")" + NL + "    {";
  protected final String TEXT_1388 = NL + "      ";
  protected final String TEXT_1389 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1390 = NL + "    ";
  protected final String TEXT_1391 = ".clear();" + NL + "    for (";
  protected final String TEXT_1392 = " ";
  protected final String TEXT_1393 = " : ";
  protected final String TEXT_1394 = ")" + NL + "    {";
  protected final String TEXT_1395 = NL + "      ";
  protected final String TEXT_1396 = "(";
  protected final String TEXT_1397 = ", this);";
  protected final String TEXT_1398 = NL + "      ";
  protected final String TEXT_1399 = ".add(";
  protected final String TEXT_1400 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1401 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1402 = NL + "  private void ";
  protected final String TEXT_1403 = "(";
  protected final String TEXT_1404 = " ";
  protected final String TEXT_1405 = ", ";
  protected final String TEXT_1406 = " ";
  protected final String TEXT_1407 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1408 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1409 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1410 = ", ";
  protected final String TEXT_1411 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1412 = " to ";
  protected final String TEXT_1413 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1414 = NL + "  public boolean ";
  protected final String TEXT_1415 = "(";
  protected final String TEXT_1416 = " ";
  protected final String TEXT_1417 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1418 = NL + "    ";
  protected final String TEXT_1419 = ".add(";
  protected final String TEXT_1420 = ");";
  protected final String TEXT_1421 = NL + "    wasAdded = true;";
  protected final String TEXT_1422 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1423 = "(";
  protected final String TEXT_1424 = " ";
  protected final String TEXT_1425 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1426 = NL + "    if (";
  protected final String TEXT_1427 = ".contains(";
  protected final String TEXT_1428 = "))" + NL + "    {";
  protected final String TEXT_1429 = NL + "      ";
  protected final String TEXT_1430 = ".remove(";
  protected final String TEXT_1431 = ");";
  protected final String TEXT_1432 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1433 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1434 = NL + "  public boolean ";
  protected final String TEXT_1435 = "(";
  protected final String TEXT_1436 = " ";
  protected final String TEXT_1437 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1438 = NL + "    if (";
  protected final String TEXT_1439 = "() < ";
  protected final String TEXT_1440 = "())" + NL + "    {";
  protected final String TEXT_1441 = NL + "      ";
  protected final String TEXT_1442 = ".add(";
  protected final String TEXT_1443 = ");";
  protected final String TEXT_1444 = NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1445 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_1446 = NL;
  protected final String TEXT_1447 = NL + "  public boolean ";
  protected final String TEXT_1448 = "(";
  protected final String TEXT_1449 = " ";
  protected final String TEXT_1450 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1451 = NL + "    if (";
  protected final String TEXT_1452 = ".contains(";
  protected final String TEXT_1453 = "))" + NL + "    {";
  protected final String TEXT_1454 = NL + "      ";
  protected final String TEXT_1455 = ".remove(";
  protected final String TEXT_1456 = ");";
  protected final String TEXT_1457 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1458 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1459 = NL + "  public boolean ";
  protected final String TEXT_1460 = "(";
  protected final String TEXT_1461 = " ";
  protected final String TEXT_1462 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1463 = NL + "    ";
  protected final String TEXT_1464 = ".add(";
  protected final String TEXT_1465 = ");";
  protected final String TEXT_1466 = NL + "    wasAdded = true;";
  protected final String TEXT_1467 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1468 = "(";
  protected final String TEXT_1469 = " ";
  protected final String TEXT_1470 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1471 = NL + "    if (!";
  protected final String TEXT_1472 = ".contains(";
  protected final String TEXT_1473 = "))" + NL + "    {";
  protected final String TEXT_1474 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1475 = "() <= ";
  protected final String TEXT_1476 = "())" + NL + "    {";
  protected final String TEXT_1477 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_1478 = NL;
  protected final String TEXT_1479 = NL + "    ";
  protected final String TEXT_1480 = ".remove(";
  protected final String TEXT_1481 = ");";
  protected final String TEXT_1482 = NL + "    wasRemoved = true;";
  protected final String TEXT_1483 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1484 = NL + "  ";
  protected final String TEXT_1485 = " boolean ";
  protected final String TEXT_1486 = "(";
  protected final String TEXT_1487 = "... ";
  protected final String TEXT_1488 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
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
  protected final String TEXT_1503 = ".size() != ";
  protected final String TEXT_1504 = "())" + NL + "    {";
  protected final String TEXT_1505 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1506 = NL + "    ";
  protected final String TEXT_1507 = ".clear();";
  protected final String TEXT_1508 = NL + "    ";
  protected final String TEXT_1509 = ".addAll(";
  protected final String TEXT_1510 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1511 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1512 = NL + "  ";
  protected final String TEXT_1513 = " boolean ";
  protected final String TEXT_1514 = "(";
  protected final String TEXT_1515 = "... ";
  protected final String TEXT_1516 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1517 = NL + "    ArrayList<";
  protected final String TEXT_1518 = "> ";
  protected final String TEXT_1519 = " = new ArrayList<";
  protected final String TEXT_1520 = ">();" + NL + "    for (";
  protected final String TEXT_1521 = " ";
  protected final String TEXT_1522 = " : ";
  protected final String TEXT_1523 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1524 = ".contains(";
  protected final String TEXT_1525 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1526 = NL + "      ";
  protected final String TEXT_1527 = ".add(";
  protected final String TEXT_1528 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1529 = ".size() != ";
  protected final String TEXT_1530 = ".length)" + NL + "    {";
  protected final String TEXT_1531 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1532 = NL + "    ";
  protected final String TEXT_1533 = ".clear();";
  protected final String TEXT_1534 = NL + "    ";
  protected final String TEXT_1535 = ".addAll(";
  protected final String TEXT_1536 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1537 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1538 = NL + "  public boolean ";
  protected final String TEXT_1539 = "(";
  protected final String TEXT_1540 = " ";
  protected final String TEXT_1541 = ")" + NL + "  {" + NL + "    //" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "    boolean wasSet = false;";
  protected final String TEXT_1542 = NL + "    ";
  protected final String TEXT_1543 = " ";
  protected final String TEXT_1544 = " = ";
  protected final String TEXT_1545 = ";" + NL + "" + NL + "    if (";
  protected final String TEXT_1546 = " == null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1547 = " != null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1548 = ".";
  protected final String TEXT_1549 = "(this))" + NL + "        {";
  protected final String TEXT_1550 = NL + "          ";
  protected final String TEXT_1551 = " = ";
  protected final String TEXT_1552 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if (";
  protected final String TEXT_1553 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1554 = " == null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1555 = ".";
  protected final String TEXT_1556 = "() < ";
  protected final String TEXT_1557 = ".";
  protected final String TEXT_1558 = "())" + NL + "        {";
  protected final String TEXT_1559 = NL + "          ";
  protected final String TEXT_1560 = ".";
  protected final String TEXT_1561 = "(this);";
  protected final String TEXT_1562 = NL + "          ";
  protected final String TEXT_1563 = " = ";
  protected final String TEXT_1564 = ";  // ";
  protected final String TEXT_1565 = " == null" + NL + "          wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1566 = ".";
  protected final String TEXT_1567 = "() < ";
  protected final String TEXT_1568 = ".";
  protected final String TEXT_1569 = "())" + NL + "        {";
  protected final String TEXT_1570 = NL + "          ";
  protected final String TEXT_1571 = ".";
  protected final String TEXT_1572 = "(this);";
  protected final String TEXT_1573 = NL + "          ";
  protected final String TEXT_1574 = ".";
  protected final String TEXT_1575 = "(this);";
  protected final String TEXT_1576 = NL + "          ";
  protected final String TEXT_1577 = " = ";
  protected final String TEXT_1578 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if (wasSet)" + NL + "    {";
  protected final String TEXT_1579 = NL + "      ";
  protected final String TEXT_1580 = " = ";
  protected final String TEXT_1581 = ";" + NL + "    }" + NL + "    return wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_1582 = NL + "//  public boolean ";
  protected final String TEXT_1583 = "(";
  protected final String TEXT_1584 = " ";
  protected final String TEXT_1585 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_1586 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//" + NL + "//    boolean wasSet = false;" + NL + "//    ";
  protected final String TEXT_1587 = " ";
  protected final String TEXT_1588 = " = ";
  protected final String TEXT_1589 = ";" + NL + "//  " + NL + "//    if (";
  protected final String TEXT_1590 = " == null)" + NL + "//    {  " + NL + "//      if (";
  protected final String TEXT_1591 = " != null)" + NL + "//      { " + NL + "//        if (";
  protected final String TEXT_1592 = ".";
  protected final String TEXT_1593 = "(this))" + NL + "//          ";
  protected final String TEXT_1594 = " = ";
  protected final String TEXT_1595 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    else" + NL + "//    {" + NL + "//      if (";
  protected final String TEXT_1596 = " != null)" + NL + "//      {" + NL + "//        if (";
  protected final String TEXT_1597 = " == null)" + NL + "//        {" + NL + "//          if (";
  protected final String TEXT_1598 = ".";
  protected final String TEXT_1599 = " < ";
  protected final String TEXT_1600 = ".";
  protected final String TEXT_1601 = ")" + NL + "//            ";
  protected final String TEXT_1602 = ".";
  protected final String TEXT_1603 = "(this);" + NL + "//            ";
  protected final String TEXT_1604 = " = ";
  protected final String TEXT_1605 = "  // ";
  protected final String TEXT_1606 = " == null;" + NL + "//            wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//      else" + NL + "//      {" + NL + "//        if (   ";
  protected final String TEXT_1607 = ".";
  protected final String TEXT_1608 = " < ";
  protected final String TEXT_1609 = ".";
  protected final String TEXT_1610 = "()" + NL + "//            && ";
  protected final String TEXT_1611 = ".";
  protected final String TEXT_1612 = " > ";
  protected final String TEXT_1613 = ".";
  protected final String TEXT_1614 = "()" + NL + "//           )" + NL + "//          ";
  protected final String TEXT_1615 = ".";
  protected final String TEXT_1616 = "(this);" + NL + "//          ";
  protected final String TEXT_1617 = ".";
  protected final String TEXT_1618 = "(this);" + NL + "//          ";
  protected final String TEXT_1619 = " = ";
  protected final String TEXT_1620 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    " + NL + "//    if (wasSet)" + NL + "//    {" + NL + "//      ";
  protected final String TEXT_1621 = " = ";
  protected final String TEXT_1622 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return wasSet;" + NL + "//  }";
  protected final String TEXT_1623 = NL + "  public boolean ";
  protected final String TEXT_1624 = "(";
  protected final String TEXT_1625 = "... ";
  protected final String TEXT_1626 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1627 = NL + "    ArrayList<";
  protected final String TEXT_1628 = "> ";
  protected final String TEXT_1629 = " = new ArrayList<";
  protected final String TEXT_1630 = ">();" + NL + "    for (";
  protected final String TEXT_1631 = " ";
  protected final String TEXT_1632 = " : ";
  protected final String TEXT_1633 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1634 = ".contains(";
  protected final String TEXT_1635 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1636 = NL + "      ";
  protected final String TEXT_1637 = ".add(";
  protected final String TEXT_1638 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1639 = ".size() != ";
  protected final String TEXT_1640 = ".length || ";
  protected final String TEXT_1641 = ".size() < ";
  protected final String TEXT_1642 = "() || ";
  protected final String TEXT_1643 = ".size() > ";
  protected final String TEXT_1644 = "())" + NL + "    {";
  protected final String TEXT_1645 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1646 = "> ";
  protected final String TEXT_1647 = " = new ArrayList<";
  protected final String TEXT_1648 = ">(";
  protected final String TEXT_1649 = ");";
  protected final String TEXT_1650 = NL + "    ";
  protected final String TEXT_1651 = ".clear();" + NL + "    for (";
  protected final String TEXT_1652 = " ";
  protected final String TEXT_1653 = " : ";
  protected final String TEXT_1654 = ")" + NL + "    {";
  protected final String TEXT_1655 = NL + "      ";
  protected final String TEXT_1656 = ".add(";
  protected final String TEXT_1657 = ");" + NL + "      if (";
  protected final String TEXT_1658 = ".contains(";
  protected final String TEXT_1659 = "))" + NL + "      {";
  protected final String TEXT_1660 = NL + "        ";
  protected final String TEXT_1661 = ".remove(";
  protected final String TEXT_1662 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1663 = NL + "        ";
  protected final String TEXT_1664 = ".";
  protected final String TEXT_1665 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1666 = " ";
  protected final String TEXT_1667 = " : ";
  protected final String TEXT_1668 = ")" + NL + "    {";
  protected final String TEXT_1669 = NL + "      ";
  protected final String TEXT_1670 = ".";
  protected final String TEXT_1671 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1672 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1673 = NL + "  public boolean ";
  protected final String TEXT_1674 = "(";
  protected final String TEXT_1675 = "... ";
  protected final String TEXT_1676 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1677 = NL + "    ArrayList<";
  protected final String TEXT_1678 = "> ";
  protected final String TEXT_1679 = " = new ArrayList<";
  protected final String TEXT_1680 = ">();" + NL + "    for (";
  protected final String TEXT_1681 = " ";
  protected final String TEXT_1682 = " : ";
  protected final String TEXT_1683 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1684 = ".contains(";
  protected final String TEXT_1685 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1686 = NL + "      ";
  protected final String TEXT_1687 = ".add(";
  protected final String TEXT_1688 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1689 = ".size() != ";
  protected final String TEXT_1690 = ".length || ";
  protected final String TEXT_1691 = ".size() < ";
  protected final String TEXT_1692 = "())" + NL + "    {";
  protected final String TEXT_1693 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1694 = "> ";
  protected final String TEXT_1695 = " = new ArrayList<";
  protected final String TEXT_1696 = ">(";
  protected final String TEXT_1697 = ");";
  protected final String TEXT_1698 = NL + "    ";
  protected final String TEXT_1699 = ".clear();" + NL + "    for (";
  protected final String TEXT_1700 = " ";
  protected final String TEXT_1701 = " : ";
  protected final String TEXT_1702 = ")" + NL + "    {";
  protected final String TEXT_1703 = NL + "      ";
  protected final String TEXT_1704 = ".add(";
  protected final String TEXT_1705 = ");" + NL + "      if (";
  protected final String TEXT_1706 = ".contains(";
  protected final String TEXT_1707 = "))" + NL + "      {";
  protected final String TEXT_1708 = NL + "        ";
  protected final String TEXT_1709 = ".remove(";
  protected final String TEXT_1710 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1711 = NL + "        ";
  protected final String TEXT_1712 = ".";
  protected final String TEXT_1713 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1714 = " ";
  protected final String TEXT_1715 = " : ";
  protected final String TEXT_1716 = ")" + NL + "    {";
  protected final String TEXT_1717 = NL + "      ";
  protected final String TEXT_1718 = ".";
  protected final String TEXT_1719 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1720 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1721 = NL + "  ";
  protected final String TEXT_1722 = " boolean ";
  protected final String TEXT_1723 = "(";
  protected final String TEXT_1724 = "... ";
  protected final String TEXT_1725 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1726 = NL + "    ArrayList<";
  protected final String TEXT_1727 = "> ";
  protected final String TEXT_1728 = " = new ArrayList<";
  protected final String TEXT_1729 = ">();" + NL + "    for (";
  protected final String TEXT_1730 = " ";
  protected final String TEXT_1731 = " : ";
  protected final String TEXT_1732 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1733 = ".contains(";
  protected final String TEXT_1734 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1735 = NL + "      ";
  protected final String TEXT_1736 = ".add(";
  protected final String TEXT_1737 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1738 = ".size() != ";
  protected final String TEXT_1739 = ".length || ";
  protected final String TEXT_1740 = ".size() < ";
  protected final String TEXT_1741 = "() || ";
  protected final String TEXT_1742 = ".size() > ";
  protected final String TEXT_1743 = "())" + NL + "    {";
  protected final String TEXT_1744 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1745 = NL + "    ";
  protected final String TEXT_1746 = ".clear();";
  protected final String TEXT_1747 = NL + "    ";
  protected final String TEXT_1748 = ".addAll(";
  protected final String TEXT_1749 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1750 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1751 = NL + "  public boolean ";
  protected final String TEXT_1752 = "(";
  protected final String TEXT_1753 = "... ";
  protected final String TEXT_1754 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1755 = NL + "    if (";
  protected final String TEXT_1756 = ".length < ";
  protected final String TEXT_1757 = "()";
  protected final String TEXT_1758 = ")" + NL + "    {";
  protected final String TEXT_1759 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1760 = "> ";
  protected final String TEXT_1761 = " = new ArrayList<";
  protected final String TEXT_1762 = ">();" + NL + "    HashMap<";
  protected final String TEXT_1763 = ",Integer> ";
  protected final String TEXT_1764 = " = new HashMap<";
  protected final String TEXT_1765 = ",Integer>();" + NL + "    for (";
  protected final String TEXT_1766 = " ";
  protected final String TEXT_1767 = " : ";
  protected final String TEXT_1768 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1769 = ".contains(";
  protected final String TEXT_1770 = "))" + NL + "      {";
  protected final String TEXT_1771 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1772 = ".";
  protected final String TEXT_1773 = "() != null && !this.equals(";
  protected final String TEXT_1774 = ".";
  protected final String TEXT_1775 = "()))" + NL + "      {";
  protected final String TEXT_1776 = NL + "        ";
  protected final String TEXT_1777 = " ";
  protected final String TEXT_1778 = " = ";
  protected final String TEXT_1779 = ".";
  protected final String TEXT_1780 = "();" + NL + "        if (!";
  protected final String TEXT_1781 = ".containsKey(";
  protected final String TEXT_1782 = "))" + NL + "        {";
  protected final String TEXT_1783 = NL + "          ";
  protected final String TEXT_1784 = ".put(";
  protected final String TEXT_1785 = ", new Integer(";
  protected final String TEXT_1786 = ".";
  protected final String TEXT_1787 = "()));" + NL + "        }" + NL + "        Integer currentCount = ";
  protected final String TEXT_1788 = ".get(";
  protected final String TEXT_1789 = ");" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_1790 = ")" + NL + "        {";
  protected final String TEXT_1791 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_1792 = NL + "        ";
  protected final String TEXT_1793 = ".put(";
  protected final String TEXT_1794 = ", new Integer(nextCount));" + NL + "      }";
  protected final String TEXT_1795 = NL + "      ";
  protected final String TEXT_1796 = ".add(";
  protected final String TEXT_1797 = ");" + NL + "    }" + NL;
  protected final String TEXT_1798 = NL + "    ";
  protected final String TEXT_1799 = ".removeAll(";
  protected final String TEXT_1800 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_1801 = " orphan : ";
  protected final String TEXT_1802 = ")" + NL + "    {";
  protected final String TEXT_1803 = NL + "      ";
  protected final String TEXT_1804 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1805 = NL + "    ";
  protected final String TEXT_1806 = ".clear();" + NL + "    for (";
  protected final String TEXT_1807 = " ";
  protected final String TEXT_1808 = " : ";
  protected final String TEXT_1809 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1810 = ".";
  protected final String TEXT_1811 = "() != null)" + NL + "      {";
  protected final String TEXT_1812 = NL + "        ";
  protected final String TEXT_1813 = ".";
  protected final String TEXT_1814 = "().";
  protected final String TEXT_1815 = ".remove(";
  protected final String TEXT_1816 = ");" + NL + "      }";
  protected final String TEXT_1817 = NL + "      ";
  protected final String TEXT_1818 = "(";
  protected final String TEXT_1819 = ", this);";
  protected final String TEXT_1820 = NL + "      ";
  protected final String TEXT_1821 = ".add(";
  protected final String TEXT_1822 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1823 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1824 = NL + "  private void ";
  protected final String TEXT_1825 = "(";
  protected final String TEXT_1826 = " ";
  protected final String TEXT_1827 = ", ";
  protected final String TEXT_1828 = " ";
  protected final String TEXT_1829 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1830 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1831 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1832 = ", ";
  protected final String TEXT_1833 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1834 = " to ";
  protected final String TEXT_1835 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1836 = NL + "  ";
  protected final String TEXT_1837 = " boolean ";
  protected final String TEXT_1838 = "(";
  protected final String TEXT_1839 = "... ";
  protected final String TEXT_1840 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1841 = NL + "    ArrayList<";
  protected final String TEXT_1842 = "> ";
  protected final String TEXT_1843 = " = new ArrayList<";
  protected final String TEXT_1844 = ">();" + NL + "    for (";
  protected final String TEXT_1845 = " ";
  protected final String TEXT_1846 = " : ";
  protected final String TEXT_1847 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1848 = ".contains(";
  protected final String TEXT_1849 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1850 = NL + "      ";
  protected final String TEXT_1851 = ".add(";
  protected final String TEXT_1852 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1853 = ".size() != ";
  protected final String TEXT_1854 = ".length || ";
  protected final String TEXT_1855 = ".size() > ";
  protected final String TEXT_1856 = "())" + NL + "    {";
  protected final String TEXT_1857 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1858 = NL + "    ";
  protected final String TEXT_1859 = ".clear();";
  protected final String TEXT_1860 = NL + "    ";
  protected final String TEXT_1861 = ".addAll(";
  protected final String TEXT_1862 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1863 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1864 = NL + "  ";
  protected final String TEXT_1865 = " boolean ";
  protected final String TEXT_1866 = "(";
  protected final String TEXT_1867 = "... ";
  protected final String TEXT_1868 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1869 = NL + "    ArrayList<";
  protected final String TEXT_1870 = "> ";
  protected final String TEXT_1871 = " = new ArrayList<";
  protected final String TEXT_1872 = ">();" + NL + "    for (";
  protected final String TEXT_1873 = " ";
  protected final String TEXT_1874 = " : ";
  protected final String TEXT_1875 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1876 = ".contains(";
  protected final String TEXT_1877 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1878 = NL + "      ";
  protected final String TEXT_1879 = ".add(";
  protected final String TEXT_1880 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1881 = ".size() != ";
  protected final String TEXT_1882 = ".length || ";
  protected final String TEXT_1883 = ".size() < ";
  protected final String TEXT_1884 = "())" + NL + "    {";
  protected final String TEXT_1885 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1886 = NL + "    ";
  protected final String TEXT_1887 = ".clear();";
  protected final String TEXT_1888 = NL + "    ";
  protected final String TEXT_1889 = ".addAll(";
  protected final String TEXT_1890 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1891 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1892 = NL + "  ";
  protected final String TEXT_1893 = NL + "  public boolean ";
  protected final String TEXT_1894 = "(";
  protected final String TEXT_1895 = " ";
  protected final String TEXT_1896 = ", int index)" + NL + "  {  " + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_1897 = "(";
  protected final String TEXT_1898 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_1899 = "()) { index = ";
  protected final String TEXT_1900 = "() - 1; }";
  protected final String TEXT_1901 = NL + "      ";
  protected final String TEXT_1902 = ".remove(";
  protected final String TEXT_1903 = ");";
  protected final String TEXT_1904 = NL + "      ";
  protected final String TEXT_1905 = ".add(index, ";
  protected final String TEXT_1906 = ");";
  protected final String TEXT_1907 = NL + "      wasAdded = true;" + NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1908 = "(";
  protected final String TEXT_1909 = " ";
  protected final String TEXT_1910 = ", int index)" + NL + "  {" + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_1911 = ".contains(";
  protected final String TEXT_1912 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_1913 = "()) { index = ";
  protected final String TEXT_1914 = "() - 1; }";
  protected final String TEXT_1915 = NL + "      ";
  protected final String TEXT_1916 = ".remove(";
  protected final String TEXT_1917 = ");";
  protected final String TEXT_1918 = NL + "      ";
  protected final String TEXT_1919 = ".add(index, ";
  protected final String TEXT_1920 = ");";
  protected final String TEXT_1921 = NL + "      wasAdded = true;" + NL + "    } " + NL + "    else " + NL + "    {";
  protected final String TEXT_1922 = NL + "      wasAdded = ";
  protected final String TEXT_1923 = "(";
  protected final String TEXT_1924 = ", index);";
  protected final String TEXT_1925 = NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL;
  protected final String TEXT_1926 = NL + "  public boolean equals(Object obj)" + NL + "  {" + NL + "    if (obj == null) { return false; }" + NL + "    if (!getClass().equals(obj.getClass())) { return false; }" + NL;
  protected final String TEXT_1927 = NL + "    ";
  protected final String TEXT_1928 = " compareTo = (";
  protected final String TEXT_1929 = ")obj;" + NL + "  ";
  protected final String TEXT_1930 = NL + "    ";
  protected final String TEXT_1931 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_1932 = NL + "    ";
  protected final String TEXT_1933 = NL;
  protected final String TEXT_1934 = NL + "    ";
  protected final String TEXT_1935 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1936 = NL + "  private void ";
  protected final String TEXT_1937 = "()" + NL + "  {" + NL + "    try" + NL + "    {";
  protected final String TEXT_1938 = NL + "      ";
  protected final String TEXT_1939 = NL + "      Thread.sleep(1);";
  protected final String TEXT_1940 = NL + "    }" + NL + "    catch (InterruptedException e)" + NL + "    {" + NL + "" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1941 = NL + "  private void ";
  protected final String TEXT_1942 = "()" + NL + "  {" + NL + "    try" + NL + "    {";
  protected final String TEXT_1943 = NL + "      ";
  protected final String TEXT_1944 = NL + "      Thread.sleep(1);";
  protected final String TEXT_1945 = NL + "    }" + NL + "    catch (InterruptedException e)" + NL + "    {" + NL + "" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1946 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1947 = NL + "    ";
  protected final String TEXT_1948 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1949 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_1950 = NL + "      ";
  protected final String TEXT_1951 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1952 = NL + "  private void ";
  protected final String TEXT_1953 = "()" + NL + "  {";
  protected final String TEXT_1954 = NL + "    ";
  protected final String TEXT_1955 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1956 = "\",";
  protected final String TEXT_1957 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1958 = "()" + NL + "  {";
  protected final String TEXT_1959 = NL + "    ";
  protected final String TEXT_1960 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1961 = NL + "  private void ";
  protected final String TEXT_1962 = "()" + NL + "  {";
  protected final String TEXT_1963 = NL + "    ";
  protected final String TEXT_1964 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1965 = "\",";
  protected final String TEXT_1966 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1967 = "()" + NL + "  {";
  protected final String TEXT_1968 = NL + "    ";
  protected final String TEXT_1969 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1970 = NL + "  private void ";
  protected final String TEXT_1971 = "()" + NL + "  {";
  protected final String TEXT_1972 = NL + "    ";
  protected final String TEXT_1973 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1974 = "\",";
  protected final String TEXT_1975 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1976 = "()" + NL + "  {";
  protected final String TEXT_1977 = NL + "    ";
  protected final String TEXT_1978 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1979 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1980 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1981 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void run ()" + NL + "    {";
  protected final String TEXT_1982 = NL + "      if (\"";
  protected final String TEXT_1983 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1984 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1985 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1986 = NL + "      if (\"";
  protected final String TEXT_1987 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1988 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1989 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1990 = NL + "      if (\"";
  protected final String TEXT_1991 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1992 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1993 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1994 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1995 = NL + "    ";
  protected final String TEXT_1996 = " ";
  protected final String TEXT_1997 = " = ";
  protected final String TEXT_1998 = "_One";
  protected final String TEXT_1999 = "();";
  protected final String TEXT_2000 = NL + "    ";
  protected final String TEXT_2001 = " = null;";
  protected final String TEXT_2002 = NL + "    clear_";
  protected final String TEXT_2003 = "();";
  protected final String TEXT_2004 = NL;
  protected final String TEXT_2005 = NL + "    ";
  protected final String TEXT_2006 = " ";
  protected final String TEXT_2007 = " = ";
  protected final String TEXT_2008 = "_One";
  protected final String TEXT_2009 = "();" + NL + "    super.clear_";
  protected final String TEXT_2010 = "();" + NL + "    if (";
  protected final String TEXT_2011 = " != null)" + NL + "    {";
  protected final String TEXT_2012 = NL + "      ";
  protected final String TEXT_2013 = ".delete();" + NL + "    }";
  protected final String TEXT_2014 = NL + "    ";
  protected final String TEXT_2015 = " ";
  protected final String TEXT_2016 = " = ";
  protected final String TEXT_2017 = "_One";
  protected final String TEXT_2018 = "();" + NL + "    super.clear_";
  protected final String TEXT_2019 = "();" + NL + "    if (";
  protected final String TEXT_2020 = " != null)" + NL + "    {";
  protected final String TEXT_2021 = NL + "      ";
  protected final String TEXT_2022 = ".delete();";
  protected final String TEXT_2023 = NL + "      ";
  protected final String TEXT_2024 = ".clear_";
  protected final String TEXT_2025 = "();" + NL + "    }";
  protected final String TEXT_2026 = NL + "    while (";
  protected final String TEXT_2027 = "_";
  protected final String TEXT_2028 = "().size() > 0)" + NL + "    {";
  protected final String TEXT_2029 = NL + "      ";
  protected final String TEXT_2030 = " ";
  protected final String TEXT_2031 = " = ";
  protected final String TEXT_2032 = "_";
  protected final String TEXT_2033 = "().get(";
  protected final String TEXT_2034 = "_";
  protected final String TEXT_2035 = "().size() - 1);";
  protected final String TEXT_2036 = NL + "      ";
  protected final String TEXT_2037 = ".delete();";
  protected final String TEXT_2038 = NL + "      ";
  protected final String TEXT_2039 = "_";
  protected final String TEXT_2040 = "().remove(";
  protected final String TEXT_2041 = ");" + NL + "    }" + NL + "    " + NL + "      ";
  protected final String TEXT_2042 = NL;
  protected final String TEXT_2043 = NL + "    ";
  protected final String TEXT_2044 = " ";
  protected final String TEXT_2045 = " = ";
  protected final String TEXT_2046 = "_One";
  protected final String TEXT_2047 = "();" + NL + "    super.clear_";
  protected final String TEXT_2048 = "();" + NL + "    if (";
  protected final String TEXT_2049 = " != null)" + NL + "    {";
  protected final String TEXT_2050 = NL + "      ";
  protected final String TEXT_2051 = ".delete();" + NL + "    }";
  protected final String TEXT_2052 = NL + "    ";
  protected final String TEXT_2053 = " ";
  protected final String TEXT_2054 = " = ";
  protected final String TEXT_2055 = "_One";
  protected final String TEXT_2056 = "();" + NL + "    super.clear_";
  protected final String TEXT_2057 = "();" + NL + "    if (";
  protected final String TEXT_2058 = " != null)" + NL + "    {";
  protected final String TEXT_2059 = NL + "      ";
  protected final String TEXT_2060 = ".delete();" + NL + "    }";
  protected final String TEXT_2061 = NL + "    while (";
  protected final String TEXT_2062 = "_";
  protected final String TEXT_2063 = "().size() > 0)" + NL + "    {";
  protected final String TEXT_2064 = NL + "      ";
  protected final String TEXT_2065 = " ";
  protected final String TEXT_2066 = " = ";
  protected final String TEXT_2067 = "_";
  protected final String TEXT_2068 = "().get(";
  protected final String TEXT_2069 = "_";
  protected final String TEXT_2070 = "().size() - 1);";
  protected final String TEXT_2071 = NL + "      ";
  protected final String TEXT_2072 = ".delete();";
  protected final String TEXT_2073 = NL + "      ";
  protected final String TEXT_2074 = "_";
  protected final String TEXT_2075 = "().remove(";
  protected final String TEXT_2076 = ");" + NL + "    }" + NL + "    " + NL + "      ";
  protected final String TEXT_2077 = NL + "    while (";
  protected final String TEXT_2078 = "_";
  protected final String TEXT_2079 = "().size() > 0)" + NL + "    {";
  protected final String TEXT_2080 = NL + "      ";
  protected final String TEXT_2081 = " ";
  protected final String TEXT_2082 = " = ";
  protected final String TEXT_2083 = "_";
  protected final String TEXT_2084 = "().get(";
  protected final String TEXT_2085 = "_";
  protected final String TEXT_2086 = "().size() - 1);";
  protected final String TEXT_2087 = NL + "      ";
  protected final String TEXT_2088 = ".delete();";
  protected final String TEXT_2089 = NL + "      ";
  protected final String TEXT_2090 = "_";
  protected final String TEXT_2091 = "().remove(";
  protected final String TEXT_2092 = ");" + NL + "    }" + NL + "    " + NL + "      ";
  protected final String TEXT_2093 = NL + "    while( !";
  protected final String TEXT_2094 = "_One";
  protected final String TEXT_2095 = "().isEmpty() )" + NL + "    {";
  protected final String TEXT_2096 = NL + "      ";
  protected final String TEXT_2097 = " ";
  protected final String TEXT_2098 = " = ";
  protected final String TEXT_2099 = "_One";
  protected final String TEXT_2100 = "_";
  protected final String TEXT_2101 = "().get(0);";
  protected final String TEXT_2102 = NL + "      ";
  protected final String TEXT_2103 = ".";
  protected final String TEXT_2104 = "(null);";
  protected final String TEXT_2105 = NL + "      ";
  protected final String TEXT_2106 = "_One";
  protected final String TEXT_2107 = "().remove(";
  protected final String TEXT_2108 = ");" + NL + "    }";
  protected final String TEXT_2109 = NL + "    if (";
  protected final String TEXT_2110 = "_One";
  protected final String TEXT_2111 = "() != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2112 = "_One";
  protected final String TEXT_2113 = "().";
  protected final String TEXT_2114 = "() <= ";
  protected final String TEXT_2115 = ")" + NL + "      {";
  protected final String TEXT_2116 = NL + "        ";
  protected final String TEXT_2117 = " ";
  protected final String TEXT_2118 = " = ";
  protected final String TEXT_2119 = "_One";
  protected final String TEXT_2120 = "();" + NL + "        clear_";
  protected final String TEXT_2121 = "();";
  protected final String TEXT_2122 = NL + "        ";
  protected final String TEXT_2123 = ".delete();" + NL + "      " + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2124 = NL + "        ";
  protected final String TEXT_2125 = " ";
  protected final String TEXT_2126 = " = ";
  protected final String TEXT_2127 = "_One";
  protected final String TEXT_2128 = "();" + NL + "        clear_";
  protected final String TEXT_2129 = "();";
  protected final String TEXT_2130 = NL + "        ";
  protected final String TEXT_2131 = ".";
  protected final String TEXT_2132 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2133 = NL + "    if (";
  protected final String TEXT_2134 = "_One";
  protected final String TEXT_2135 = "() != null)" + NL + "    {";
  protected final String TEXT_2136 = NL + "        ";
  protected final String TEXT_2137 = " ";
  protected final String TEXT_2138 = " = ";
  protected final String TEXT_2139 = "_One";
  protected final String TEXT_2140 = "();" + NL + "        clear_";
  protected final String TEXT_2141 = "();";
  protected final String TEXT_2142 = NL + "        ";
  protected final String TEXT_2143 = ".delete();" + NL + "    }";
  protected final String TEXT_2144 = NL;
  protected final String TEXT_2145 = NL + "    ";
  protected final String TEXT_2146 = " ";
  protected final String TEXT_2147 = " = ";
  protected final String TEXT_2148 = "_One";
  protected final String TEXT_2149 = "();" + NL + "    super.clear_";
  protected final String TEXT_2150 = "();" + NL + "    if (";
  protected final String TEXT_2151 = " != null)" + NL + "    {";
  protected final String TEXT_2152 = NL + "      ";
  protected final String TEXT_2153 = ".delete();" + NL + "    }";
  protected final String TEXT_2154 = NL + "    if (";
  protected final String TEXT_2155 = "_One";
  protected final String TEXT_2156 = "() != null)" + NL + "    {";
  protected final String TEXT_2157 = NL + "      ";
  protected final String TEXT_2158 = "_One";
  protected final String TEXT_2159 = "().clear_";
  protected final String TEXT_2160 = "();" + NL + "    }";
  protected final String TEXT_2161 = NL + "    ";
  protected final String TEXT_2162 = " ";
  protected final String TEXT_2163 = " = ";
  protected final String TEXT_2164 = "_One";
  protected final String TEXT_2165 = "();" + NL + "    super.clear_";
  protected final String TEXT_2166 = "();" + NL + "    if (";
  protected final String TEXT_2167 = " != null)" + NL + "    {";
  protected final String TEXT_2168 = NL + "      ";
  protected final String TEXT_2169 = ".clear_";
  protected final String TEXT_2170 = "();" + NL + "    }";
  protected final String TEXT_2171 = NL + "    ";
  protected final String TEXT_2172 = " ";
  protected final String TEXT_2173 = " = ";
  protected final String TEXT_2174 = "_One";
  protected final String TEXT_2175 = "();" + NL + "    super.clear_";
  protected final String TEXT_2176 = "();" + NL + "    if (";
  protected final String TEXT_2177 = " != null)" + NL + "    {";
  protected final String TEXT_2178 = NL + "      ";
  protected final String TEXT_2179 = ".delete();" + NL + "    }";
  protected final String TEXT_2180 = NL + "    if (";
  protected final String TEXT_2181 = "_One";
  protected final String TEXT_2182 = "() != null)" + NL + "    {";
  protected final String TEXT_2183 = NL + "      ";
  protected final String TEXT_2184 = " ";
  protected final String TEXT_2185 = " = ";
  protected final String TEXT_2186 = "_One";
  protected final String TEXT_2187 = "();" + NL + "      clear_";
  protected final String TEXT_2188 = "();";
  protected final String TEXT_2189 = NL + "      ";
  protected final String TEXT_2190 = ".";
  protected final String TEXT_2191 = "(this);" + NL + "    }";
  protected final String TEXT_2192 = NL + "    if (";
  protected final String TEXT_2193 = "_One";
  protected final String TEXT_2194 = "() != null)" + NL + "    {";
  protected final String TEXT_2195 = NL + "      ";
  protected final String TEXT_2196 = "_One";
  protected final String TEXT_2197 = "().delete();" + NL + "    }";
  protected final String TEXT_2198 = NL + "    if (";
  protected final String TEXT_2199 = "_One";
  protected final String TEXT_2200 = "() != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2201 = "_One";
  protected final String TEXT_2202 = "().";
  protected final String TEXT_2203 = "() <= ";
  protected final String TEXT_2204 = ")" + NL + "      {";
  protected final String TEXT_2205 = NL + "        ";
  protected final String TEXT_2206 = "_One";
  protected final String TEXT_2207 = "().delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2208 = NL + "        ";
  protected final String TEXT_2209 = " ";
  protected final String TEXT_2210 = " = ";
  protected final String TEXT_2211 = "_One";
  protected final String TEXT_2212 = "();" + NL + "        clear_";
  protected final String TEXT_2213 = "();";
  protected final String TEXT_2214 = NL + "        ";
  protected final String TEXT_2215 = ".";
  protected final String TEXT_2216 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2217 = NL + "    ";
  protected final String TEXT_2218 = " ";
  protected final String TEXT_2219 = " = ";
  protected final String TEXT_2220 = "_One";
  protected final String TEXT_2221 = "();" + NL + "    clear_";
  protected final String TEXT_2222 = "();";
  protected final String TEXT_2223 = NL + "    ";
  protected final String TEXT_2224 = ".";
  protected final String TEXT_2225 = "(this);";
  protected final String TEXT_2226 = NL + "    for(";
  protected final String TEXT_2227 = " ";
  protected final String TEXT_2228 = " : ";
  protected final String TEXT_2229 = "_";
  protected final String TEXT_2230 = "())" + NL + "    {";
  protected final String TEXT_2231 = NL + "      ";
  protected final String TEXT_2232 = "(";
  protected final String TEXT_2233 = ",null);" + NL + "    }" + NL + "    clear_";
  protected final String TEXT_2234 = "();";
  protected final String TEXT_2235 = NL + "    ArrayList<";
  protected final String TEXT_2236 = "> ";
  protected final String TEXT_2237 = " = new ArrayList<";
  protected final String TEXT_2238 = ">(";
  protected final String TEXT_2239 = "());" + NL + "    clear_";
  protected final String TEXT_2240 = "();" + NL + "    for(";
  protected final String TEXT_2241 = " ";
  protected final String TEXT_2242 = " : ";
  protected final String TEXT_2243 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2244 = ".";
  protected final String TEXT_2245 = "() <= ";
  protected final String TEXT_2246 = ".";
  protected final String TEXT_2247 = "_";
  protected final String TEXT_2248 = "())" + NL + "      {";
  protected final String TEXT_2249 = NL + "        ";
  protected final String TEXT_2250 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2251 = NL + "        ";
  protected final String TEXT_2252 = ".";
  protected final String TEXT_2253 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2254 = NL + "    ArrayList<";
  protected final String TEXT_2255 = "> ";
  protected final String TEXT_2256 = " = new ArrayList<";
  protected final String TEXT_2257 = ">(";
  protected final String TEXT_2258 = "_";
  protected final String TEXT_2259 = "());" + NL + "    clear_";
  protected final String TEXT_2260 = "();" + NL + "    for(";
  protected final String TEXT_2261 = " ";
  protected final String TEXT_2262 = " : ";
  protected final String TEXT_2263 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2264 = ".";
  protected final String TEXT_2265 = "() <= ";
  protected final String TEXT_2266 = ".";
  protected final String TEXT_2267 = "_";
  protected final String TEXT_2268 = "())" + NL + "      {";
  protected final String TEXT_2269 = NL + "        ";
  protected final String TEXT_2270 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2271 = NL + "        ";
  protected final String TEXT_2272 = ".";
  protected final String TEXT_2273 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2274 = NL + "    ArrayList<";
  protected final String TEXT_2275 = "> ";
  protected final String TEXT_2276 = " = new ArrayList<";
  protected final String TEXT_2277 = ">(";
  protected final String TEXT_2278 = "_";
  protected final String TEXT_2279 = "());" + NL + "    clear_";
  protected final String TEXT_2280 = "();" + NL + "    for(";
  protected final String TEXT_2281 = " ";
  protected final String TEXT_2282 = " : ";
  protected final String TEXT_2283 = ")" + NL + "    {";
  protected final String TEXT_2284 = NL + "      ";
  protected final String TEXT_2285 = ".";
  protected final String TEXT_2286 = "(this);" + NL + "    }";
  protected final String TEXT_2287 = NL + "    for( ";
  protected final String TEXT_2288 = " orphan : ";
  protected final String TEXT_2289 = "_";
  protected final String TEXT_2290 = "() )" + NL + "    {" + NL + "      orphan.clear_";
  protected final String TEXT_2291 = "();" + NL + "    }";
  protected final String TEXT_2292 = NL + "    ";
  protected final String TEXT_2293 = " = null;";
  protected final String TEXT_2294 = NL + "    ";
  protected final String TEXT_2295 = ".clear();";
  protected final String TEXT_2296 = NL + "    ";
  protected final String TEXT_2297 = " ";
  protected final String TEXT_2298 = " = ";
  protected final String TEXT_2299 = ";";
  protected final String TEXT_2300 = NL + "    ";
  protected final String TEXT_2301 = " = null;" + NL + "    if (";
  protected final String TEXT_2302 = " != null)" + NL + "    {";
  protected final String TEXT_2303 = NL + "      ";
  protected final String TEXT_2304 = ".delete();" + NL + "    }";
  protected final String TEXT_2305 = NL + "    ";
  protected final String TEXT_2306 = " ";
  protected final String TEXT_2307 = " = ";
  protected final String TEXT_2308 = ";";
  protected final String TEXT_2309 = NL + "    ";
  protected final String TEXT_2310 = " = null;" + NL + "    if (";
  protected final String TEXT_2311 = " != null)" + NL + "    {";
  protected final String TEXT_2312 = NL + "      ";
  protected final String TEXT_2313 = ".delete();";
  protected final String TEXT_2314 = NL + "      ";
  protected final String TEXT_2315 = ".";
  protected final String TEXT_2316 = "(null);" + NL + "    }";
  protected final String TEXT_2317 = NL + "    while (";
  protected final String TEXT_2318 = ".size() > 0)" + NL + "    {";
  protected final String TEXT_2319 = NL + "      ";
  protected final String TEXT_2320 = " ";
  protected final String TEXT_2321 = " = ";
  protected final String TEXT_2322 = ".get(";
  protected final String TEXT_2323 = ".size() - 1);";
  protected final String TEXT_2324 = NL + "      ";
  protected final String TEXT_2325 = ".delete();";
  protected final String TEXT_2326 = NL + "      ";
  protected final String TEXT_2327 = ".remove(";
  protected final String TEXT_2328 = ");" + NL + "    }" + NL + "    " + NL + "      ";
  protected final String TEXT_2329 = NL + "    ";
  protected final String TEXT_2330 = " ";
  protected final String TEXT_2331 = " = ";
  protected final String TEXT_2332 = ";";
  protected final String TEXT_2333 = NL + "    ";
  protected final String TEXT_2334 = " = null;" + NL + "    if (";
  protected final String TEXT_2335 = " != null)" + NL + "    {";
  protected final String TEXT_2336 = NL + "      ";
  protected final String TEXT_2337 = ".delete();" + NL + "    }";
  protected final String TEXT_2338 = NL + "    ";
  protected final String TEXT_2339 = " ";
  protected final String TEXT_2340 = " = ";
  protected final String TEXT_2341 = ";";
  protected final String TEXT_2342 = NL + "    ";
  protected final String TEXT_2343 = " = null;" + NL + "    if (";
  protected final String TEXT_2344 = " != null)" + NL + "    {";
  protected final String TEXT_2345 = NL + "      ";
  protected final String TEXT_2346 = ".delete();" + NL + "    }";
  protected final String TEXT_2347 = NL + "    while (";
  protected final String TEXT_2348 = ".size() > 0)" + NL + "    {";
  protected final String TEXT_2349 = NL + "      ";
  protected final String TEXT_2350 = " ";
  protected final String TEXT_2351 = " = ";
  protected final String TEXT_2352 = ".get(";
  protected final String TEXT_2353 = ".size() - 1);";
  protected final String TEXT_2354 = NL + "      ";
  protected final String TEXT_2355 = ".delete();";
  protected final String TEXT_2356 = NL + "      ";
  protected final String TEXT_2357 = ".remove(";
  protected final String TEXT_2358 = ");" + NL + "    }" + NL + "    " + NL + "      ";
  protected final String TEXT_2359 = NL + "    while (";
  protected final String TEXT_2360 = ".size() > 0)" + NL + "    {";
  protected final String TEXT_2361 = NL + "      ";
  protected final String TEXT_2362 = " ";
  protected final String TEXT_2363 = " = ";
  protected final String TEXT_2364 = ".get(";
  protected final String TEXT_2365 = ".size() - 1);";
  protected final String TEXT_2366 = NL + "      ";
  protected final String TEXT_2367 = ".delete();";
  protected final String TEXT_2368 = NL + "      ";
  protected final String TEXT_2369 = ".remove(";
  protected final String TEXT_2370 = ");" + NL + "    }" + NL + "    " + NL + "      ";
  protected final String TEXT_2371 = NL + "    while( !";
  protected final String TEXT_2372 = ".isEmpty() )" + NL + "    {";
  protected final String TEXT_2373 = NL + "      ";
  protected final String TEXT_2374 = " ";
  protected final String TEXT_2375 = " = ";
  protected final String TEXT_2376 = ".get(0);";
  protected final String TEXT_2377 = NL + "      ";
  protected final String TEXT_2378 = ".";
  protected final String TEXT_2379 = "(null);";
  protected final String TEXT_2380 = NL + "      ";
  protected final String TEXT_2381 = ".remove(";
  protected final String TEXT_2382 = ");" + NL + "    }";
  protected final String TEXT_2383 = NL + "    if (";
  protected final String TEXT_2384 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2385 = ".";
  protected final String TEXT_2386 = "() <= ";
  protected final String TEXT_2387 = ")" + NL + "      {";
  protected final String TEXT_2388 = NL + "        ";
  protected final String TEXT_2389 = " ";
  protected final String TEXT_2390 = " = ";
  protected final String TEXT_2391 = ";" + NL + "        this.";
  protected final String TEXT_2392 = " = null;";
  protected final String TEXT_2393 = NL + "        ";
  protected final String TEXT_2394 = ".delete();" + NL + "      " + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2395 = NL + "        ";
  protected final String TEXT_2396 = " ";
  protected final String TEXT_2397 = " = ";
  protected final String TEXT_2398 = ";" + NL + "        this.";
  protected final String TEXT_2399 = " = null;";
  protected final String TEXT_2400 = NL + "        ";
  protected final String TEXT_2401 = ".";
  protected final String TEXT_2402 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2403 = NL + "    if (";
  protected final String TEXT_2404 = " != null)" + NL + "    {";
  protected final String TEXT_2405 = NL + "        ";
  protected final String TEXT_2406 = " ";
  protected final String TEXT_2407 = " = ";
  protected final String TEXT_2408 = ";" + NL + "        this.";
  protected final String TEXT_2409 = " = null;";
  protected final String TEXT_2410 = NL + "        ";
  protected final String TEXT_2411 = ".delete();" + NL + "    }";
  protected final String TEXT_2412 = NL + "    ";
  protected final String TEXT_2413 = " ";
  protected final String TEXT_2414 = " = ";
  protected final String TEXT_2415 = ";";
  protected final String TEXT_2416 = NL + "    ";
  protected final String TEXT_2417 = " = null;" + NL + "    if (";
  protected final String TEXT_2418 = " != null)" + NL + "    {";
  protected final String TEXT_2419 = NL + "      ";
  protected final String TEXT_2420 = ".delete();" + NL + "    }";
  protected final String TEXT_2421 = NL + "    if (";
  protected final String TEXT_2422 = " != null)" + NL + "    {";
  protected final String TEXT_2423 = NL + "      ";
  protected final String TEXT_2424 = ".";
  protected final String TEXT_2425 = "(null);" + NL + "    }";
  protected final String TEXT_2426 = NL + "    ";
  protected final String TEXT_2427 = " ";
  protected final String TEXT_2428 = " = ";
  protected final String TEXT_2429 = ";";
  protected final String TEXT_2430 = NL + "    ";
  protected final String TEXT_2431 = " = null;" + NL + "    if (";
  protected final String TEXT_2432 = " != null)" + NL + "    {";
  protected final String TEXT_2433 = NL + "      ";
  protected final String TEXT_2434 = ".";
  protected final String TEXT_2435 = "(null);" + NL + "    }";
  protected final String TEXT_2436 = NL + "    ";
  protected final String TEXT_2437 = " ";
  protected final String TEXT_2438 = " = ";
  protected final String TEXT_2439 = ";";
  protected final String TEXT_2440 = NL + "    ";
  protected final String TEXT_2441 = " = null;" + NL + "    if (";
  protected final String TEXT_2442 = " != null)" + NL + "    {";
  protected final String TEXT_2443 = NL + "      ";
  protected final String TEXT_2444 = ".delete();" + NL + "    }";
  protected final String TEXT_2445 = NL + "    if (";
  protected final String TEXT_2446 = " != null)" + NL + "    {";
  protected final String TEXT_2447 = NL + "      ";
  protected final String TEXT_2448 = " ";
  protected final String TEXT_2449 = " = ";
  protected final String TEXT_2450 = ";" + NL + "      this.";
  protected final String TEXT_2451 = " = null;";
  protected final String TEXT_2452 = NL + "      ";
  protected final String TEXT_2453 = ".";
  protected final String TEXT_2454 = "(this);" + NL + "    }";
  protected final String TEXT_2455 = NL + "    if (";
  protected final String TEXT_2456 = " != null)" + NL + "    {";
  protected final String TEXT_2457 = NL + "      ";
  protected final String TEXT_2458 = ".delete();" + NL + "    }";
  protected final String TEXT_2459 = NL + "    if (";
  protected final String TEXT_2460 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2461 = ".";
  protected final String TEXT_2462 = "() <= ";
  protected final String TEXT_2463 = ")" + NL + "      {";
  protected final String TEXT_2464 = NL + "        ";
  protected final String TEXT_2465 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2466 = NL + "        ";
  protected final String TEXT_2467 = " ";
  protected final String TEXT_2468 = " = ";
  protected final String TEXT_2469 = ";" + NL + "        this.";
  protected final String TEXT_2470 = " = null;";
  protected final String TEXT_2471 = NL + "        ";
  protected final String TEXT_2472 = ".";
  protected final String TEXT_2473 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2474 = NL + "    ";
  protected final String TEXT_2475 = " ";
  protected final String TEXT_2476 = " = ";
  protected final String TEXT_2477 = ";" + NL + "    this.";
  protected final String TEXT_2478 = " = null;";
  protected final String TEXT_2479 = NL + "    ";
  protected final String TEXT_2480 = ".";
  protected final String TEXT_2481 = "(this);";
  protected final String TEXT_2482 = NL + "    for(";
  protected final String TEXT_2483 = " ";
  protected final String TEXT_2484 = " : ";
  protected final String TEXT_2485 = ")" + NL + "    {";
  protected final String TEXT_2486 = NL + "      ";
  protected final String TEXT_2487 = "(";
  protected final String TEXT_2488 = ",null);" + NL + "    }";
  protected final String TEXT_2489 = NL + "    ";
  protected final String TEXT_2490 = ".clear();";
  protected final String TEXT_2491 = NL + "    ArrayList<";
  protected final String TEXT_2492 = "> ";
  protected final String TEXT_2493 = " = new ArrayList<";
  protected final String TEXT_2494 = ">(";
  protected final String TEXT_2495 = ");";
  protected final String TEXT_2496 = NL + "    ";
  protected final String TEXT_2497 = ".clear();" + NL + "    for(";
  protected final String TEXT_2498 = " ";
  protected final String TEXT_2499 = " : ";
  protected final String TEXT_2500 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2501 = ".";
  protected final String TEXT_2502 = "() <= ";
  protected final String TEXT_2503 = ".";
  protected final String TEXT_2504 = "())" + NL + "      {";
  protected final String TEXT_2505 = NL + "        ";
  protected final String TEXT_2506 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2507 = NL + "        ";
  protected final String TEXT_2508 = ".";
  protected final String TEXT_2509 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2510 = NL + "    ArrayList<";
  protected final String TEXT_2511 = "> ";
  protected final String TEXT_2512 = " = new ArrayList<";
  protected final String TEXT_2513 = ">(";
  protected final String TEXT_2514 = ");";
  protected final String TEXT_2515 = NL + "    ";
  protected final String TEXT_2516 = ".clear();" + NL + "    for(";
  protected final String TEXT_2517 = " ";
  protected final String TEXT_2518 = " : ";
  protected final String TEXT_2519 = ")" + NL + "    {";
  protected final String TEXT_2520 = NL + "      ";
  protected final String TEXT_2521 = ".";
  protected final String TEXT_2522 = "(this);" + NL + "    }";
  protected final String TEXT_2523 = NL + "    for(int i=";
  protected final String TEXT_2524 = ".size(); i > 0; i--)" + NL + "    {";
  protected final String TEXT_2525 = NL + "      ";
  protected final String TEXT_2526 = " ";
  protected final String TEXT_2527 = " = ";
  protected final String TEXT_2528 = ".get(i - 1);";
  protected final String TEXT_2529 = NL + "      ";
  protected final String TEXT_2530 = ".delete();" + NL + "    }";
  protected final String TEXT_2531 = NL + "    while( !";
  protected final String TEXT_2532 = ".isEmpty() )" + NL + "    {";
  protected final String TEXT_2533 = NL + "      ";
  protected final String TEXT_2534 = ".get(0).";
  protected final String TEXT_2535 = "(null);" + NL + "    }";
  protected final String TEXT_2536 = NL + "  " + NL + "  @Override" + NL + "  public void run ()" + NL + "  {" + NL + "    boolean status=false;" + NL + "    while (true) " + NL + "    {" + NL;
  protected final String TEXT_2537 = NL + "      " + NL + "      switch (m.type)" + NL + "      {";
  protected final String TEXT_2538 = " " + NL + "        default:" + NL + "      }" + NL + "      if(!status)" + NL + "      {" + NL + "        // Error message is written or  exception is raised" + NL + "      }" + NL + "    }" + NL + "  }";
  protected final String TEXT_2539 = NL + "  " + NL + "  @Override" + NL + "  public void run ()" + NL + "  {" + NL + "    boolean status=false;" + NL + "    while (true) " + NL + "    {" + NL;
  protected final String TEXT_2540 = NL + "      " + NL + "      switch (m.type)" + NL + "      {";
  protected final String TEXT_2541 = " " + NL + "        default:" + NL + "      }" + NL + "      if(!status)" + NL + "      {" + NL + "        // Error message is written or  exception is raised" + NL + "      }" + NL + "    }" + NL + "  }";
  protected final String TEXT_2542 = NL + NL + "  public String toString()" + NL + "  {" + NL + "\t  String outputString = \"\";";
  protected final String TEXT_2543 = NL + "  }";
  protected final String TEXT_2544 = "  " + NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_2545 = NL + "  ";
  protected final String TEXT_2546 = NL + "  ";
  protected final String TEXT_2547 = NL + "}";
  protected final String TEXT_2548 = NL + "  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler" + NL + "  {" + NL + "    public void uncaughtException(Thread t, Throwable e)" + NL + "    {" + NL + "      translate(e);" + NL + "      if(e.getCause()!=null)" + NL + "      {" + NL + "        translate(e.getCause());" + NL + "      }" + NL + "      e.printStackTrace();" + NL + "    }" + NL + "    public void translate(Throwable e)" + NL + "    {" + NL + "      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();" + NL + "      StackTraceElement[] elements = e.getStackTrace();" + NL + "      try" + NL + "      {" + NL + "        for(StackTraceElement element:elements)" + NL + "        {" + NL + "          String className = element.getClassName();" + NL + "          String methodName = element.getMethodName();" + NL + "          boolean methodFound = false;" + NL + "          int index = className.lastIndexOf('.')+1;" + NL + "          try {" + NL + "            java.lang.reflect.Method query = this.getClass().getMethod(className.substring(index)+\"_\"+methodName,new Class[]{});" + NL + "            UmpleSourceData sourceInformation = (UmpleSourceData)query.invoke(this,new Object[]{});" + NL + "            for(int i=0;i<sourceInformation.size();++i)" + NL + "            {" + NL + "              int distanceFromStart = element.getLineNumber()-sourceInformation.getJavaLine(i)-((\"main\".equals(methodName))?2:0);" + NL + "              if(distanceFromStart>=0&&distanceFromStart<=sourceInformation.getLength(i))" + NL + "              {" + NL + "                result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),sourceInformation.getFileName(i),sourceInformation.getUmpleLine(i)+distanceFromStart));" + NL + "                methodFound = true;" + NL + "                break;" + NL + "              }" + NL + "            }" + NL + "          }" + NL + "          catch (Exception e2){}" + NL + "          if(!methodFound)" + NL + "          {" + NL + "            result.add(element);" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "      catch (Exception e1)" + NL + "      {" + NL + "        e1.printStackTrace();" + NL + "      }" + NL + "      e.setStackTrace(result.toArray(new StackTraceElement[0]));" + NL + "    }" + NL + "  //The following methods Map Java lines back to their original Umple file / line    ";
  protected final String TEXT_2549 = NL;
  protected final String TEXT_2550 = NL + "  }" + NL + "  public static class UmpleSourceData" + NL + "  {" + NL + "    String[] umpleFileNames;" + NL + "    Integer[] umpleLines;" + NL + "    Integer[] umpleJavaLines;" + NL + "    Integer[] umpleLengths;" + NL + "    " + NL + "    public UmpleSourceData(){" + NL + "    }" + NL + "    public String getFileName(int i){" + NL + "      return umpleFileNames[i];" + NL + "    }" + NL + "    public Integer getUmpleLine(int i){" + NL + "      return umpleLines[i];" + NL + "    }" + NL + "    public Integer getJavaLine(int i){" + NL + "      return umpleJavaLines[i];" + NL + "    }" + NL + "    public Integer getLength(int i){" + NL + "      return umpleLengths[i];" + NL + "    }" + NL + "    public UmpleSourceData setFileNames(String... filenames){" + NL + "      umpleFileNames = filenames;" + NL + "      return this;" + NL + "    }" + NL + "    public UmpleSourceData setUmpleLines(Integer... umplelines){" + NL + "      umpleLines = umplelines;" + NL + "      return this;" + NL + "    }" + NL + "    public UmpleSourceData setJavaLines(Integer... javalines){" + NL + "      umpleJavaLines = javalines;" + NL + "      return this;" + NL + "    }" + NL + "    public UmpleSourceData setLengths(Integer... lengths){" + NL + "      umpleLengths = lengths;" + NL + "      return this;" + NL + "    }" + NL + "    public int size(){" + NL + "      return umpleFileNames.length;" + NL + "    }" + NL + "  } " + NL + "}";

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
  GeneratorHelper.generator = gen;

  HashMap<String,String> codeInjectionMap = new HashMap<String,String>();
  for (CodeInjection inject : uClass.getCodeInjections())
  {
    String operation = StringFormatter.toUnderscore(inject.getOperation());
    String key = inject.getType() + ":" + operation;
    String newCodeToInject = "";
    String injectCode = inject.getConstraintTree()==null?inject.getCode():inject.getConstraintCode(gen);
    if (codeInjectionMap.containsKey(key))
    {
      newCodeToInject = StringFormatter.format("{0}\n    {1}",codeInjectionMap.get(key),injectCode);
    }
    else
    {
      newCodeToInject = injectCode;
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
  
    append(stringBuffer, "\n  public enum {0} { {1} }", gen.translate("type", sm), gen.translate("listStates", sm));

    for (StateMachine nestedSm : allNested)
    {
      append(stringBuffer, "\n  public enum {0} { {1} }", gen.translate("type", nestedSm), 
             gen.translate("listStates",nestedSm));
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
    append(stringBuffer, "\n  protected enum MessageType { {0} }", gen.translate("listEventsForQSM",uClass));   
  }

  boolean foundQueuedSM = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    if(sm.isQueued())
    {
       foundQueuedSM = true;
    }
  }
  if(foundQueuedSM == true)
  {
    append(stringBuffer,"\n  ");
    append(stringBuffer,"\n  MessageQueue queue;");
    append(stringBuffer,"\n  Thread removal;");
  } 
 
  boolean foundPooledSM = false;
  for(StateMachine sm : uClass.getStateMachines())
  {  
    if(sm.isPooled())
    {
      foundPooledSM = true;
    }
  }
  if(foundPooledSM == true)
  {
    append(stringBuffer,"\n  ");
    append(stringBuffer,"\n  MessagePool pool;");
    append(stringBuffer,"\n  Thread removal;");
    append(stringBuffer,"\n  ");
    append(stringBuffer,"\n  //enumeration type of messages accepted by {0}", uClass.getName());
    append(stringBuffer, "\n  protected enum MessageType { {0} }", gen.translate("listEventsForPooledSM",uClass));
  } 

  boolean foundPooled = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    if (sm.isPooled()){
      foundPooled = true;
    }
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
      for (Activity activity : state.getActivities())
      {
        if (isFirst)
        {
          appendln(stringBuffer, "");
          appendln(stringBuffer, "");
          append(stringBuffer,"  //{0} Do Activity Threads", uClass.getName());
          isFirst = false;
        }
        append(stringBuffer, "\n  Thread {0} = null;", gen.translate("doActivityThread",activity));
      }
    }
  }
}

    
{
  isFirst = true;
  for (AssociationVariable av : uClass.getAssociationVariables())
  {

    
    
    AssociationVariable relatedAssociation = av.getRelatedAssociation();

    //Association relatedAssoc = uClass.getAssociation(uClass.indexOfAssociationVariable(av));
	  
	//boolean reqSuperCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsSuperCode();
	//boolean reqCommonCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsCommonCode();
	  
	boolean reqSuperCode = av.getNeedsSuperCode();
	boolean reqCommonCode = av.getNeedsCommonCode();  
	  
	if (reqSuperCode || reqCommonCode)
	{
	    continue;
	}

    
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
    if (av.isImmutable() && av.isIsLazy())
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

    
    
    AssociationVariable relatedAssociation = av.getRelatedAssociation();

    //Association relatedAssoc = uClass.getAssociation(uClass.indexOfAssociationVariable(av));
	  
	//boolean reqSuperCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsSuperCode();
	//boolean reqCommonCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsCommonCode();
	  
	boolean reqSuperCode = av.getNeedsSuperCode();
	boolean reqCommonCode = av.getNeedsCommonCode();  
	  
	if (reqSuperCode || reqCommonCode)
	{
	    continue;
	}

    
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

  for (StateMachine sm : uClass.getStateMachines())
  {
    if(!sm.getNestedStateMachines().isEmpty())
    {
      for (StateMachine nsm : sm.getNestedStateMachines())
      {
        for (Event event : nsm.getEvents())
        {
          if(!event.getIsTimer())
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
          append(stringBuffer, "  private TimedEventHandler {0};", gen.translate("eventHandler", event));
        }
      }
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
    boolean reqSuperCode, reqCommonCode;
    AssociationVariable relatedAssociation;
    Association relatedAssoc;
    stringBuffer.append(TEXT_11);
    
  boolean isOneToOne = false;

  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {

   
    
    relatedAssociation = av.getRelatedAssociation();
    
    //relatedAssoc = uClass.getAssociation(uClass.indexOfAssociationVariable(av));

    //reqSuperCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsSuperCode();
    //reqCommonCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsCommonCode();
    
    reqSuperCode = av.getNeedsSuperCode();
	reqCommonCode = av.getNeedsCommonCode(); 
    
    if (reqSuperCode || reqCommonCode)
    {
      continue;
    }
    

    

    if (av.isOnlyOne() && relatedAssociation.isOnlyOne() && av.getIsNavigable() && relatedAssociation.getIsNavigable())
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
    
    List<TraceItem> traceItems= av.getTraced("constructor",uClass);
    
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
     
    }
    else
    {
      hasBody = true;
      if(!av.getIsLazy()){
         
    
  String parameterLookup = av.getValue() == null || av.getModifier().equals("fixml") ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_22);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_24);
    
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
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_27);
    } 
    
      }
    }
    
    if(!traceItems.isEmpty())
    {

    stringBuffer.append(TEXT_28);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( traceItem.trace(gen,av,"at_p",uClass) );
    stringBuffer.append(TEXT_29);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( traceItem.getPeriodClause() );
    stringBuffer.append(TEXT_30);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_33);
    
    }
    else if (av.getIsUnique())
    {
   	  hasBody = true;
   	  
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("setMethod", av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(av.getName());
    stringBuffer.append(TEXT_37);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables())
  {

    
    
    relatedAssociation = av.getRelatedAssociation();
    
    //relatedAssoc = uClass.getAssociation(uClass.indexOfAssociationVariable(av));

    //reqSuperCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsSuperCode();
    //reqCommonCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsCommonCode();
    
    reqSuperCode = av.getNeedsSuperCode();
	reqCommonCode = av.getNeedsCommonCode(); 
    
    if (reqSuperCode || reqCommonCode)
    {
      continue;
    }
    

    

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

    
    
    relatedAssociation = av.getRelatedAssociation();
    
    //relatedAssoc = uClass.getAssociation(uClass.indexOfAssociationVariable(av));

    //reqSuperCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsSuperCode();
    //reqCommonCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsCommonCode();
    
    reqSuperCode = av.getNeedsSuperCode();
	reqCommonCode = av.getNeedsCommonCode(); 
    
    if (reqSuperCode || reqCommonCode)
    {
      continue;
    }
    

    

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
    
    
    relatedAssociation = av.getRelatedAssociation();
    
    //relatedAssoc = uClass.getAssociation(uClass.indexOfAssociationVariable(av));

    //reqSuperCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsSuperCode();
    //reqCommonCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsCommonCode();
    
    reqSuperCode = av.getNeedsSuperCode();
	reqCommonCode = av.getNeedsCommonCode(); 
    
    if (reqSuperCode || reqCommonCode)
    {
      continue;
    }
    

    
    
    if (!av.getIsNavigable())
    {
      continue;
    }
    
    if (!relatedAssociation.getIsNavigable())
    {
      if (av.isOnlyOne())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_42);
    
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
  

    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_52);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        hasBody = true;
        
     String requiredNumber = StringFormatter.format("{0}", av.getMultiplicity().getUpperBound()); 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_62);
    
      }
      else if (av.isMany() && av.isImmutable())
      {
      	hasBody = true;
        
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
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_71);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_74);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_83);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_86);
    
    }
    else
    {
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  // if it's a specialization, skip the association code for the av
  if ( reqSuperCode || reqCommonCode )
  {
    continue;
  }

  if (av.isOnlyOne())
  {
    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_93);
    
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
  

    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_103);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_108);
    
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
      
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_112);
    if (nestedSm.getContainsDeepHistoryState()){
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(nestedSm.getState(1).getName());
    stringBuffer.append(TEXT_116);
    }
    if (nestedSm.getContainsHistoryState()){
    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("stateMachineOne",nestedSm));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(nestedSm.getState(1).getName());
    stringBuffer.append(TEXT_120);
    }
    
    }
    
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_124);
    
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
    
    stringBuffer.append(TEXT_125);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_127);
    
  }

    
  if (isOneToOne)
  {
    
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_128);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_130);
    
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
      
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_133);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_135);
     
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
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_138);
    } 
    
    }
    else
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null || av.getModifier().equals("fixml") ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_141);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_144);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    
    
    relatedAssociation = av.getRelatedAssociation();
    
    //relatedAssoc = uClass.getAssociation(uClass.indexOfAssociationVariable(av));

    //reqSuperCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsSuperCode();
    //reqCommonCode = relatedAssoc.getEnd(av.getRelevantEnd()).getNeedsCommonCode();
    
    reqSuperCode = av.getNeedsSuperCode();
	reqCommonCode = av.getNeedsCommonCode(); 
    
    if (reqSuperCode || reqCommonCode)
    {
      continue;
    }
    

    
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    stringBuffer.append(TEXT_148);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_151);
    
    }
    else
    {
      hasBody = true;
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  // if it's a specialization, skip the association code for the av
  if ( reqSuperCode || reqCommonCode )
  {
    continue;
  }

  if (av.isOnlyOne())
  {
    
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_158);
    
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
  

    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_168);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_173);
    
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
    stringBuffer.append(TEXT_174);
    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes())
  {
    if (av.isConstant() || av.getIsAutounique() || "internal".equals(av.getModifier()) || av.getIsDerived())
    {
      continue;
    }

    gen.setParameterConstraintName(av.getName());    
    
    List<TraceItem> traceItems = av.getTraced("setMethod", uClass);
    

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
        
    stringBuffer.append(TEXT_175);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_178);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_179);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_180);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_181);
    stringBuffer.append( gen.translate("associationOne",av));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_183);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
    stringBuffer.append(TEXT_184);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_185);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_186);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_189);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_190);
    stringBuffer.append( gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_192);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
    stringBuffer.append(TEXT_193);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_195);
     if (customResetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customResetPrefixCode,gen.translate("resetMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_t", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_196);
    stringBuffer.append( gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_198);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_t", uClass):""));
    stringBuffer.append(TEXT_199);
     if (customResetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customResetPostfixCode,gen.translate("resetMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_200);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_204);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_a", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_207);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_a", uClass):""));
    stringBuffer.append(TEXT_208);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_212);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_r", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_215);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_r", uClass):""));
    stringBuffer.append(TEXT_216);
     if (customRemovePostfixCode != null) {addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); }
    stringBuffer.append(TEXT_217);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_218);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_221);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_224);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
    stringBuffer.append(TEXT_225);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_226);
    
    }
  }

  if(uClass.getExtendsClass()!=null)
  {
    for(Attribute av:uClass.getExtendsClass().getAttributes())
    {
      if (av.isConstant() || av.getIsAutounique() || "internal".equals(av.getModifier()) || av.getIsDerived())
      {
        continue;
      }

      List<TraceItem> traceItems = av.getTraced("setMethod", uClass);

      gen.setParameterConstraintName(av.getName());

      String customSetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("setMethod",av)));
      String customSetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("setMethod",av)));

//      String customResetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("resetMethod",av)));
//      String customResetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("resetMethod",av)));
      
      String customAddPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("addMethod",av)));
      String customAddPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("addMethod",av)));

//      String customRemovePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("removeMethod",av)));
//      String customRemovePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("removeMethod",av)));

      if(customSetPrefixCode!=null||customSetPostfixCode!=null)
      {
        if (av.getModifier().equals("defaulted"))
        {
          
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_230);
     if (customSetPrefixCode != null) { 
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_233);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_234);
    
        }
        else if (av.getIsList())
        {
          
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_238);
     if (customAddPrefixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_a", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_241);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_a", uClass):""));
     if (customAddPostfixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customAddPostfixCode, "    "));
    } 
    stringBuffer.append(TEXT_242);
    
        }
        else if(!av.isImmutable()||av.getIsLazy())//if(customSetPrefixCode!=null&&customSetPostfixCode!=null&&customSetPrefixCode.matches("[\\s]*if.*\\n[\\s]*.*"))
        {
          
    stringBuffer.append(TEXT_243);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_246);
     if (customSetPrefixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_247);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_249);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
     if (customSetPostfixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_250);
    
        }
      }    
    }
  }
  gen.setParameterConstraintName("");

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes()) 
  {
    if (av.getIsAutounique() || av.isConstant() || "internal".equals(av.getModifier()))
    {
      continue;
    }
    
    gen.setParameterConstraintName(av.getName());

    List<TraceItem> traceItems = av.getTraced("getMethod", uClass);
    
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
      
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_253);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_254);
    stringBuffer.append( gen.translate("typeMany",av));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_257);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_258);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av));
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_262);
     if (customGetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPrefixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_263);
    stringBuffer.append( gen.translate("typeMany",av));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_268);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_ga", uClass):""));
    stringBuffer.append(TEXT_269);
     if (customGetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPostfixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_272);
     if (customNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPrefixCode,gen.translate("numberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_274);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_n", uClass, "number"):""));
    stringBuffer.append(TEXT_275);
     if (customNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPostfixCode,gen.translate("numberOfMethod",av));
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_277);
     if (customHasManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPrefixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_279);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_h", uClass):""));
    stringBuffer.append(TEXT_280);
     if (customHasManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPostfixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); }
    stringBuffer.append(TEXT_281);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_284);
     if (customIndexOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPrefixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_287);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_288);
     if (customIndexOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPostfixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_289);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_292);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_293);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_294);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_295);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_296);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_297);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av));
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_298);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_299);
    addUncaughtExceptionVariables(gen.translate("getMethod",av),av.getPosition().getFilename(),av.getPosition().getLineNumber(),stringBuffer.toString().split("\\n").length-1,1);
    stringBuffer.append(TEXT_300);
    
      }
      else if (av.getIsDerived())
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_302);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_303);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_304);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_305);
    addUncaughtExceptionVariables(gen.translate("getMethod",av),av.getPosition().getFilename(),av.getPosition().getLineNumber(),stringBuffer.toString().split("\\n").length-1,1);
    stringBuffer.append(TEXT_306);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_308);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_309);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_310);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_311);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_313);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_314);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_315);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_316);
    
      }
      else
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_318);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_319);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_321);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_324);
     if (customGetDefaultPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getDefaultMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_327);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_328);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_329);
     if (customGetDefaultPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetDefaultPostfixCode,gen.translate("getDefaultMethod",av));
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_331);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_334);
     if (customGetDefaultPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_335);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_336);
    
      }
      
      if (av.getIsUnique())
      {
        if (customGetUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_337);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_338);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_341);
     if (customGetUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetUniquePrefixCode,gen.translate("getUniqueMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_342);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_346);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_347);
     if (customGetUniquePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetUniquePostfixCode,gen.translate("getUniqueMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetUniquePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_349);
    
        } 
        else 
        {
          
    stringBuffer.append(TEXT_350);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_354);
     if (customGetUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetUniquePrefixCode,gen.translate("getUniqueMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_357);
    
        }
        if (customHasUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_361);
     if (customHasUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasUniquePrefixCode,gen.translate("hasUniqueMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_365);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_366);
     if (customHasUniquePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasUniquePostfixCode,gen.translate("hasUniqueMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasUniquePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_367);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_368);
    
        }
        else
        {
          
    stringBuffer.append(TEXT_369);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_372);
     if (customHasUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasUniquePrefixCode,gen.translate("hasUniqueMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_375);
    
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
      
      List<TraceItem> traceItems = av.getTraced("getMethod", uClass);
      
      if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_378);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_379);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_380);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_382);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_383);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_384);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_385);
    
      }
      else
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_387);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_388);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_390);
    
      }
      appendln(stringBuffer, "");
    }
  }
  gen.setParameterConstraintName("");

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (Attribute av : uClass.getAttributes()) 
  {
    if (!av.getType().equals("Boolean") || av.getIsAutounique() || av.isConstant() || "internal".equals(av.getModifier()))
    {
      continue;
    }
  
    gen.setParameterConstraintName(av.getName());

    List<TraceItem> traceItems = av.getTraced("getMethod", uClass);

    String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("isMethod",av)));
    String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("isMethod",av)));
    
    if (av.getIsDerived() && customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_392);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_393);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_394);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_395);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_396);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_397);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_398);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("isMethod",av));   
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); }
    stringBuffer.append(TEXT_399);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_400);
    
    }
    else if (av.getIsDerived())
    {
      
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_402);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_403);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("parameterValue",av));
    stringBuffer.append(TEXT_405);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_406);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_407);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_408);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_409);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_410);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_411);
    stringBuffer.append( gen.translate("attributeOne",av) );
    stringBuffer.append(TEXT_412);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_413);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_414);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_415);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_417);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_418);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_420);
    
    }
      
    appendln(stringBuffer, "");
  }
  gen.setParameterConstraintName("");

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

    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_424);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_425);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_428);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_429);
    
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
        
        String condition = t.getGuard()!=null?gen.translate("Open",t.getGuard()):"if ()\n{";
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
    stringBuffer.append(TEXT_430);
    stringBuffer.append( scope );
    stringBuffer.append(TEXT_431);
    for (StateMachine sm : uClass.getStateMachines()){if((sm.isQueued() && e.getIsInternal() == false && e.isAutoTransition() == false && !e.isUnspecified()) || (sm.isPooled() && e.getIsInternal() == false && e.isAutoTransition() == false && !e.isUnspecified())){append(stringBuffer,"_");}break;}
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_432);
    stringBuffer.append( (e.getArgs()==null?"":e.getArgs()));
    if(e.isUnspecified()){append(stringBuffer,"String state, String event");}
    stringBuffer.append(TEXT_433);
     if (customEventPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customEventPrefixCode,gen.translate("eventMethod",e));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customEventPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_434);
    stringBuffer.append(TEXT_435);
    stringBuffer.append( eventOutput );
     if (customEventPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customEventPostfixCode,gen.translate("eventMethod",e)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customEventPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_436);
    
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
  
  for(State s : sm.getStates())
  {
    boolean hasThisExit = false;
    boolean hasThisEntry = false;
    for (Action action : s.getActions())
    {
      if ("exit".equals(action.getActionType()))
      {
        TraceItem traceItem = s.getTraced("exit",uClass);
        
        if (!hasThisExit)
        {
          allExitCases.append(StringFormatter.format("    if ({0} == {1}.{2} && {3} != {1}.{2} )\n    {"
            , gen.translate("stateMachineOne",sm)
            , gen.translate("type",sm)
            , gen.translate("stateOne",s)
            , gen.translate("parameterOne",sm)
          ));
        }

        hasThisExit = true;

        allExitCases.append(
          traceItem!=null/*&&traceItem.getIsPost()*/?traceItem.trace(gen, s,"sm_e", uClass)+"\n":"");

        allExitCases.append("\n      " + action.getActionCode()); 
      }
      else if("entry".equals(action.getActionType()))
      {
        TraceItem traceItem = s.getTraced("entry",uClass);        
        
        if (!hasThisEntry)
        {
          allEnterCases.append(StringFormatter.format("    if ({0} != {1}.{2} && {3} == {1}.{2} )\n    {"
            , gen.translate("stateMachineOne",sm)
            , gen.translate("type",sm)
            , gen.translate("stateOne",s)
            , gen.translate("parameterOne",sm)
          ));
        }

        hasThisEntry = true;

        allEnterCases.append(
            traceItem!=null/*&&traceItem.getIsPost()*/?traceItem.trace(gen, s,"sm_x", uClass)+"\n":"");

        allEnterCases.append("\n      " + action.getActionCode()); 
      }
    }
    if (s.getHasExitAction()){
     allExitCases.append("\n    }\n");
    }
    if (s.getHasEntryAction()){
     allEnterCases.append("\n    }\n");
    }
  }
  
  String exitCasesOutput = allExitCases.toString().trim();
  String enterCasesOutput = allEnterCases.toString().trim();

    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_438);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_439);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_440);
     if (!exitCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",exitCasesOutput); } 
     if (!enterCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",enterCasesOutput); } 
    stringBuffer.append(TEXT_441);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_442);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_443);
    
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
        TraceItem traceItemActivity = state.getTraced("activity",uClass);
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
        else if(traceItemActivity!=null)
        {
          for (Activity activity : state.getActivities())
          {
            entryActions.append("\n        " + action.getActionCode().substring(0, action.getActionCode().length() - 1).concat(traceItemActivity.trace(gen, activity,"sm_di", uClass))+" }");
            entryJavaLine+=action.getActionCode().split("\\n").length;
          }
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
          for (Activity activity : state.getActivities())
          {
            exitActions.append("\n        " + action.getActionCode().substring(0, action.getActionCode().length() - 1).concat(traceItemActivity.trace(gen, activity,"sm_di", uClass))+" }");
            exitJavaLine+=action.getActionCode().split("\\n").length;
            exitJavaLine++;
          }
        }
        else
        {
        	exitActions.append("\n        " + action.getActionCode());
            exitJavaLine+=action.getActionCode().split("\\n").length;
        }
      }
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
  
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_445);
     if (customExitPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customExitPrefixCode,gen.translate("exitMethod",sm));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_446);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(TEXT_448);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_449);
     if (customExitPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customExitPostfixCode,gen.translate("exitMethod",sm)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_450);
     
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
    stringBuffer.append(TEXT_451);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_452);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_453);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_454);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",sm)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_455);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_456);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_457);
     if (parentState != null) { 
    stringBuffer.append(TEXT_458);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_459);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_460);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_461);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_462);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_463);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_465);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_466);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_467);
     } 
     if (customSetPostfixCode != null) {  addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",sm));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_468);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(TEXT_470);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_471);
     } 
     if (parentState != null) { 
     if (sm.getContainsDeepHistoryState()) { 
    stringBuffer.append(TEXT_472);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_473);
    stringBuffer.append( gen.translate("type",sm)  );
    stringBuffer.append(TEXT_474);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_475);
    stringBuffer.append( gen.translate("stateMachineOne", sm) );
    stringBuffer.append(TEXT_476);
     } 
     } 
    stringBuffer.append(TEXT_477);
    
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

    gen.setParameterConstraintName(av.getName());

    List<TraceItem> traceItems = av.getTraced("getMethod", uClass);

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
      
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_480);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("associationOne",av)):"")
);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_482);
     } else { 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPre()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("associationOne",av)):"")
);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_486);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPost()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("parameterOne",av)):"")
);
     addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_488);
     } 
    stringBuffer.append(TEXT_489);
     
  if(av.getMultiplicity().getLowerBound() == 0) {
  
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.translate("hasMethod",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_492);
     } 
    stringBuffer.append(TEXT_493);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_496);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPre()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("associationMany",av)+".get(index)"):"")
);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_500);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPost()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("parameterOne",av)):"")
);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_502);
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_505);
     if (customGetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPrefixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_509);
     if (customGetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPostfixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_512);
     if (customNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPrefixCode,gen.translate("numberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_514);
     if (customNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPostfixCode,gen.translate("numberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_516);
     if (customHasManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPrefixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_518);
     if (customHasManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPostfixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_522);
     if (customIndexOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPrefixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_525);
     if (customIndexOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPostfixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_526);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_527);
    
    }
 }
 gen.setParameterConstraintName("");

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  
  boolean sortMethodAdded = false; //To ensure that only one sort method is created per class
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
  
    gen.setParameterConstraintName(av.getName());

    AssociationVariable relatedAssociation = av.getRelatedAssociation();

    if (!av.getIsNavigable())
    {
      continue;
    } 
    
    //TraceItem traceItem = av.getTraced("associationAdd", uClass);
    List<TraceItem> traceItemAssocAdds = av.getTraced("associationAdd", uClass);
    List<TraceItem> traceItemAssocRemoves = av.getTraced("associationRemove", uClass);

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
    else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()) && !(uClass instanceof AssociationClass))
    {
      includeFile = "association_SetOneToMany.jet";
    }
    else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()) && (uClass instanceof AssociationClass))
    {
      includeFile = "association_SetOneToManyAssociationClass.jet";
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
      
    stringBuffer.append(TEXT_528);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_529);
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
      
    
      
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_531);
     if (customIsNumberOfValidPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPrefixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_532);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_534);
     } else { 
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_539);
     } 
     if (customIsNumberOfValidPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPostfixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_540);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_543);
     } else { 
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_545);
     if (customRequiredNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPrefixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_546);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_547);
     if (customRequiredNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPostfixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_548);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));
    
     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_551);
     } else { 
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_553);
     if (customMinimumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPrefixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_554);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_555);
     if (customMinimumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPostfixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_556);
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
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_559);
     } else { 
    stringBuffer.append(umpleSourceFile);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_561);
     if (customMaximumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPrefixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_562);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_563);
     if (customMaximumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPostfixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_564);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_568);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_571);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_572);
     } 
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_575);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_583);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_584);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_588);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append(
    (traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
    );
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_591);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av));
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_603);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append(
    (traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
    );
    stringBuffer.append(TEXT_604);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_605);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_609);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_612);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_613);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_614);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_618);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_623);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_624);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_628);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_636);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_637);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_655);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append(
    (traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,"1"):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_656);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_660);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_663);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_665);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_675);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_676);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_690);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append(
    (traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,"1"):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_691);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_700);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_705);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_717);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_725);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_726);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_730);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_735);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_740);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_741);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_745);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_746);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_747);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_758);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_761);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_762);
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_774);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_775);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_783);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_784);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_788);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_793);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_796);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_798);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_799);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_802);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_803);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_804);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_815);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_818);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_819);
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_827);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_829);
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_835);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_836);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_840);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_848);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_849);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_853);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_869);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_896);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_897);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_906);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_914);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_922);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_923);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_927);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_932);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_935);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_936);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_937);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_941);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(TEXT_944);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_955);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_956);
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_978);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append(
    (traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,"1"):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_979);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_983);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_986);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_989);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_992);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_994);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1002);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1003);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1007);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1010);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1013);
     if (customRemovePostfixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1016);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1018);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1026);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1027);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1031);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1037);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1055);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1056);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1060);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1062);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1079);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1080);
    
    }
    else if (includeFile == "association_SetOneToManyAssociationClass.jet")
    {
      
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1084);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1086);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1105);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1106);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1110);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1114);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1121);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1137);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1141);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1142);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1146);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1150);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av));
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1156);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1172);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1176);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1177);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1181);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1186);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1202);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1203);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1207);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1210);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1216);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1217);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1218);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1222);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1239);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1240);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1244);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1247);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1253);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1269);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1270);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1274);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1277);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1280);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1283);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1284);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1288);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1291);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1294);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1295);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1299);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1302);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1305);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1306);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1310);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1311);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1312);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1316);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1319);
     if (customAddPostfixCode != null) {addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1320);
     } 
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1329);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1335);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1338);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1341);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1345);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1350);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1353);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1356);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1357);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1361);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1370);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1375);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1381);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1400);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1413);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1417);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1420);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1421);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1425);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1428);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1431);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1432);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1433);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1437);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1440);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1443);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1444);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(TEXT_1446);
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1450);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1453);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1456);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1457);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1458);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1462);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1465);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1466);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1470);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1473);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1476);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1477);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1481);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1482);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1483);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1484);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1488);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
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
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1504);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1510);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1511);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1512);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1516);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1530);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1536);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1537);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1558);
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1581);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
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
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1626);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1629);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1632);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1644);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1671);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1672);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1673);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1676);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1677);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1678);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1682);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1687);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1688);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1692);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1696);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(TEXT_1698);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1701);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(TEXT_1703);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1704);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1705);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1706);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1707);
    stringBuffer.append(TEXT_1708);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1709);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1710);
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1713);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1714);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1716);
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1718);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1719);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1720);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1721);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1722);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1723);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1724);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1725);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1726);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1727);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1728);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1730);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1731);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1732);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1733);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(TEXT_1735);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1736);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1737);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1738);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1739);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1740);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1741);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1742);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1743);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1744);
    stringBuffer.append(TEXT_1745);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1746);
    stringBuffer.append(TEXT_1747);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1749);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1750);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1751);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1752);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1753);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1754);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1755);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1756);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1757);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1758);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1759);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1760);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1761);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1762);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1763);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1764);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1765);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1766);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1767);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1768);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1769);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1770);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1771);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1772);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1773);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1774);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1775);
    stringBuffer.append(TEXT_1776);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1777);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1778);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1779);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1780);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1781);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1782);
    stringBuffer.append(TEXT_1783);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1784);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1785);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1786);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1787);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1788);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1789);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1790);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_1791);
    stringBuffer.append(TEXT_1792);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1793);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1794);
    stringBuffer.append(TEXT_1795);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1796);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1797);
    stringBuffer.append(TEXT_1798);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1799);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1800);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1801);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1802);
    stringBuffer.append(TEXT_1803);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1804);
    stringBuffer.append(TEXT_1805);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1806);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1807);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1808);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1809);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1810);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1811);
    stringBuffer.append(TEXT_1812);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1813);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1814);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1815);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1816);
    stringBuffer.append(TEXT_1817);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1818);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1819);
    stringBuffer.append(TEXT_1820);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1821);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1822);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1823);
    stringBuffer.append(TEXT_1824);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1825);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1826);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1827);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1828);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1829);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1830);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1831);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1832);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1833);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1834);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1835);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1836);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1837);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1838);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1839);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1840);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1841);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1842);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1843);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1844);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1845);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1846);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1847);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1848);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1849);
    stringBuffer.append(TEXT_1850);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1851);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1852);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1853);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1854);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1855);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1856);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1857);
    stringBuffer.append(TEXT_1858);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1859);
    stringBuffer.append(TEXT_1860);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1861);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1862);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1863);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1864);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1865);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1866);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1867);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1868);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1869);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1870);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1871);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1872);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1873);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1874);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1875);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1876);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1877);
    stringBuffer.append(TEXT_1878);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1879);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1880);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1881);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1882);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1883);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1884);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1885);
    stringBuffer.append(TEXT_1886);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1887);
    stringBuffer.append(TEXT_1888);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1889);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1890);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1891);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
    }
    
    if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
    {
      
    stringBuffer.append(TEXT_1892);
    
      sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
    }
    else if(includeFile3 == "association_AddIndexControlFunctions.jet")
    {
      
    stringBuffer.append(TEXT_1893);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1894);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1895);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1896);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1897);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1898);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1899);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1900);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1901);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1902);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1903);
    stringBuffer.append(TEXT_1904);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1905);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1906);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1907);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_1908);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1909);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1910);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1911);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1912);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1913);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1914);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1915);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1916);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1917);
    stringBuffer.append(TEXT_1918);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1919);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1920);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1921);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1922);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1923);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1924);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1925);
    
    }
  }
  gen.setParameterConstraintName("");

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
      String avString = av.getIsDerived()?(gen.translate("getMethod",av)+"()"):gen.translate("attributeOne",av);
      if (!av.isImmutable() || av.getIsLazy()) canSet.append(StringFormatter.format("    {0} = false;\n",gen.translate("attributeCanSet",av)));
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
        checks.append(StringFormatter.format("    if ({0} != compareTo.{0})\n",avString));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      else
      {
        checks.append(StringFormatter.format("    if ({0} == null && compareTo.{0} != null)\n",avString));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
        checks.append(StringFormatter.format("    else if ({0} != null && !{0}.equals(compareTo.{0}))\n",avString));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      checks.append("\n");
    }
    else if (as != null)
    {
      String asString = gen.translate("attributeOne",as);
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
        checks.append(StringFormatter.format("    if ({0} == null && compareTo.{0} != null)\n",asString));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
        checks.append(StringFormatter.format("    else if ({0} != null && !{0}.equals(compareTo.{0}))\n",asString));
        checks.append(StringFormatter.format("    {\n"));
        checks.append(StringFormatter.format("      return false;\n"));
        checks.append(StringFormatter.format("    }\n"));
      }
      checks.append("\n");
    }
    
    if (av != null)
    {
      String avString = av.getIsDerived()?(gen.translate("getMethod",av)+"()"):gen.translate("attributeOne",av);
      if ("Integer".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    cachedHashCode = cachedHashCode * 23 + {0};\n",avString));
      }
      else if ("Double".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    cachedHashCode = cachedHashCode * 23 + (new Double({0})).hashCode();\n",avString));
      }
      else if ("Boolean".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    cachedHashCode = cachedHashCode * 23 + ({0} ? 1 : 0);\n",avString));
      }
      else
      {
        String attributeType = av.getIsList() ? "attributeMany" : av.getIsDerived()?"getMethod":"attributeOne";
        String typeString = gen.translate(attributeType,av)+(av.getIsDerived()?"()":"");
        hash.append(StringFormatter.format("    if ({0} != null)\n",typeString));
        hash.append(StringFormatter.format("    {\n"));
        hash.append(StringFormatter.format("      cachedHashCode = cachedHashCode * 23 + {0}.hashCode();\n",typeString));
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


    stringBuffer.append(TEXT_1926);
    stringBuffer.append(TEXT_1927);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1928);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1929);
    stringBuffer.append(TEXT_1930);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1931);
    stringBuffer.append(TEXT_1932);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1933);
    stringBuffer.append(TEXT_1934);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1935);
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
        for (Activity activity : state.getActivities())
        {
          hasActivities = true;
          
    
  Event e = activity.getOnCompletionEvent();
  String postTransition = e != null ? gen.translate("eventMethod",e) : null; 

     Position p = activity.getPosition();
if (p != null) { 
   int javaline = stringBuffer.toString().split("\\n").length;
   addUncaughtExceptionVariables(gen.translate("doActivityMethod",activity),p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/",""),p.getLineNumber(),javaline+7,activity.getActivityCode().split("\\n").length); 
  } 
    stringBuffer.append(TEXT_1936);
    stringBuffer.append( gen.translate("doActivityMethod",activity));
    stringBuffer.append(TEXT_1937);
    stringBuffer.append(TEXT_1938);
    stringBuffer.append( activity.getActivityCode() );
    stringBuffer.append(TEXT_1939);
     if (postTransition != null)
      { 
        for (Activity a : state.getActivities())
        {
          if(a != activity){
            append(stringBuffer, "\n      {0}.join();",gen.translate("doActivityThread",a));
          }
        }
        append(stringBuffer, "\n      {0}();",postTransition); 
      } 
    stringBuffer.append(TEXT_1940);
    
        }
      }
    }
    
    for (State state : sm.getStates())
    {
      for (Activity activity : state.getActivities())
      {
        hasActivities = true;
        
    
  Event e = activity.getOnCompletionEvent();
  String postTransition = e != null ? gen.translate("eventMethod",e) : null; 

     Position p = activity.getPosition();
if (p != null) { 
   int javaline = stringBuffer.toString().split("\\n").length;
   addUncaughtExceptionVariables(gen.translate("doActivityMethod",activity),p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/",""),p.getLineNumber(),javaline+7,activity.getActivityCode().split("\\n").length); 
  } 
    stringBuffer.append(TEXT_1941);
    stringBuffer.append( gen.translate("doActivityMethod",activity));
    stringBuffer.append(TEXT_1942);
    stringBuffer.append(TEXT_1943);
    stringBuffer.append( activity.getActivityCode() );
    stringBuffer.append(TEXT_1944);
     if (postTransition != null)
      { 
        for (Activity a : state.getActivities())
        {
          if(a != activity){
            append(stringBuffer, "\n      {0}.join();",gen.translate("doActivityThread",a));
          }
        }
        append(stringBuffer, "\n      {0}();",postTransition); 
      } 
    stringBuffer.append(TEXT_1945);
    
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
        for (Activity activity : state.getActivities())
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
          output.append(StringFormatter.format(" (\"{0}\".equals(doActivityMethodName))\n",gen.translate("doActivityMethod",activity)));
          output.append(StringFormatter.format("      {\n"));
          output.append(StringFormatter.format("        controller.{0}();\n",gen.translate("doActivityMethod",activity)));
          output.append(StringFormatter.format("      }"));
        }
      }
    }
    
    for (State state : sm.getStates())
    {
      for (Activity activity : state.getActivities())
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
        output.append(StringFormatter.format(" (\"{0}\".equals(doActivityMethodName))\n",gen.translate("doActivityMethod",activity)));
        output.append(StringFormatter.format("      {\n"));
        output.append(StringFormatter.format("        controller.{0}();\n",gen.translate("doActivityMethod",activity)));
        output.append(StringFormatter.format("      }"));
      }
    }
  }

    stringBuffer.append(TEXT_1946);
    stringBuffer.append(TEXT_1947);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1948);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1949);
    stringBuffer.append(TEXT_1950);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1951);
    
  }
}

    
{ 
  boolean hasTimedEvents = false;
  boolean hasTimedEvents_NestedStates = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    if(sm.getNestedStateMachines().isEmpty())
    {
      for (Event e : sm.getEvents())
      {
        if (e.getIsTimer())
        {
          hasTimedEvents = true;
          
    stringBuffer.append(TEXT_1952);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1953);
    stringBuffer.append(TEXT_1954);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1955);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1956);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1957);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1958);
    stringBuffer.append(TEXT_1959);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1960);
    
        }
      }
    }
    else if(!sm.getNestedStateMachines().isEmpty())
    {
      for (Event e : sm.getEvents())
      {
        if (e.getIsTimer())
        {
          hasTimedEvents = true;
          
    stringBuffer.append(TEXT_1961);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1962);
    stringBuffer.append(TEXT_1963);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1964);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1965);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1966);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1967);
    stringBuffer.append(TEXT_1968);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1969);
    
        }
      }
      for(StateMachine nsm : sm.getNestedStateMachines())
      {
        for(Event event : nsm.getEvents())
        {
          if(event.getIsTimer())
          {
            hasTimedEvents_NestedStates = true;
            
    stringBuffer.append(TEXT_1970);
    stringBuffer.append(gen.translate("eventStartMethod",event) );
    stringBuffer.append(TEXT_1971);
    stringBuffer.append(TEXT_1972);
    stringBuffer.append( gen.translate("eventHandler", event) );
    stringBuffer.append(TEXT_1973);
    stringBuffer.append( gen.translate("eventMethod",event) );
    stringBuffer.append(TEXT_1974);
    stringBuffer.append( event.getTimerInSeconds() );
    stringBuffer.append(TEXT_1975);
    stringBuffer.append(gen.translate("eventStopMethod",event) );
    stringBuffer.append(TEXT_1976);
    stringBuffer.append(TEXT_1977);
    stringBuffer.append( gen.translate("eventHandler",event) );
    stringBuffer.append(TEXT_1978);
    
          }
        }
      }
    }
  }
  if (hasTimedEvents || hasTimedEvents_NestedStates)
  {
    
    
 


    stringBuffer.append(TEXT_1979);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1980);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1981);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    if(sm.getNestedStateMachines().isEmpty())
    {
      for (Event e : sm.getEvents())
      {
        if (e.getIsTimer())
        {
          
    stringBuffer.append(TEXT_1982);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1983);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1984);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1985);
    
        }
      }
    }
    else if(!sm.getNestedStateMachines().isEmpty())
    {
      for (Event e : sm.getEvents())
      {
        if (e.getIsTimer())
        {
          
    stringBuffer.append(TEXT_1986);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1987);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1988);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1989);
    
        }
      }
      for(StateMachine nsm : sm.getNestedStateMachines())
      {
        for(Event event : nsm.getEvents())
        {
          if(event.getIsTimer())
          {
            
    stringBuffer.append(TEXT_1990);
    stringBuffer.append( gen.translate("eventMethod",event) );
    stringBuffer.append(TEXT_1991);
    stringBuffer.append( gen.translate("eventMethod",event) );
    stringBuffer.append(TEXT_1992);
    stringBuffer.append( gen.translate("eventStartMethod",event) );
    stringBuffer.append(TEXT_1993);
    
          }
        }
      }
    }
  }

    stringBuffer.append(TEXT_1994);
    
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
    //Association relatedAssoc = uClass.getAssociation(uClass.indexOfAssociationVariable(av));

    boolean reqSuperCode = av.getNeedsSuperCode();
    boolean reqCommonCode = av.getNeedsCommonCode();
    boolean mulChangedToOne = av.getMulChangedToOne();
    boolean relMulChangedToOne = relatedAssociation.getMulChangedToOne();
    

    
    
    if (!av.getIsNavigable() || av.isImmutable())
    {
      continue;
    }
    
    if ( reqCommonCode )      /* Same Class Specialization Case */
    {
      
    
   /* Method Gen skipped due to special specialization syntax */

    
    }
    else if (reqSuperCode)    /* Subclass Case */
    {
      if (!relatedAssociation.getIsNavigable())
      {
        if (av.isOne())
        {
          hasSomethingToDelete = true;
          
    stringBuffer.append(TEXT_1995);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1996);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1997);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_1998);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_1999);
    stringBuffer.append(TEXT_2000);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2001);
    
        }
        else if (av.isMany())
        {
          hasSomethingToDelete = true;
          
    stringBuffer.append(TEXT_2002);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2003);
    
        }
        continue;
      }
      
     
      if (relatedAssociation.getIsComposition()) {
      	if ((relatedAssociation.isOnlyOne() || relatedAssociation.isOptionalOne()) && av.isOnlyOne()) {
      		
    stringBuffer.append(TEXT_2004);
    stringBuffer.append(TEXT_2005);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2006);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2007);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2008);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2009);
    stringBuffer.append(gen.translate("associationOne", av));
    stringBuffer.append(TEXT_2010);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2011);
    stringBuffer.append(TEXT_2012);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2013);
    
      	}
      	else if ((relatedAssociation.isOnlyOne() || relatedAssociation.isOptionalOne()) && av.isOptionalOne()) {
      		
    stringBuffer.append(TEXT_2014);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2015);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2016);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2017);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2018);
    stringBuffer.append(gen.translate("associationOne", av));
    stringBuffer.append(TEXT_2019);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2020);
    stringBuffer.append(TEXT_2021);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2022);
    stringBuffer.append(TEXT_2023);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2024);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_2025);
    
      	}
      	else if ((relatedAssociation.isOnlyOne() || relatedAssociation.isOptionalOne()) && av.isMany()) {
      		
    stringBuffer.append(TEXT_2026);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2027);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2028);
    stringBuffer.append(TEXT_2029);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2030);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2031);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2032);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2033);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2034);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2035);
    stringBuffer.append(TEXT_2036);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2037);
    stringBuffer.append(TEXT_2038);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2039);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2040);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2041);
    
      	}
      	
      	else if (relatedAssociation.isMany() && av.isOnlyOne()) {
      		
    stringBuffer.append(TEXT_2042);
    stringBuffer.append(TEXT_2043);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2044);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2045);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2046);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2047);
    stringBuffer.append(gen.translate("associationOne", av));
    stringBuffer.append(TEXT_2048);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2049);
    stringBuffer.append(TEXT_2050);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2051);
    
      	}
      	else if (relatedAssociation.isMany() && av.isOptionalOne()) {
      	    
    stringBuffer.append(TEXT_2052);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2053);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2054);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2055);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2056);
    stringBuffer.append(gen.translate("associationOne", av));
    stringBuffer.append(TEXT_2057);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2058);
    stringBuffer.append(TEXT_2059);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2060);
    
      	}
      	else if (relatedAssociation.isMany() && av.isMany()) {
      	    
    stringBuffer.append(TEXT_2061);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2062);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2063);
    stringBuffer.append(TEXT_2064);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2065);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2066);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2067);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2068);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2069);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2070);
    stringBuffer.append(TEXT_2071);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2072);
    stringBuffer.append(TEXT_2073);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2074);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2075);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2076);
    
      	}
      	else {
      		continue;
      	}
      	
      	
      }
      
      else if (av.getIsComposition() && (av.isMany() && relatedAssociation.isOnlyOne())) { 
      	// normally this is the same for compositions, except for ManyToOne, the
      	// list has to be cleared on the Many end (here, the ones are successfully deleted, 
      	// but they are not removed from the list)
    		// this functionality is not present for compositions, since, in the case
    		// of deleting one from many, this would be on the composition end, and OneFromOne would
    		// be called so the object is actually deleted. 	
    
      	
    stringBuffer.append(TEXT_2077);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2078);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2079);
    stringBuffer.append(TEXT_2080);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2081);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2082);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2083);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2084);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2085);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2086);
    stringBuffer.append(TEXT_2087);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2088);
    stringBuffer.append(TEXT_2089);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2090);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2091);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2092);
    
  	  
      }
      
      else if (av.getIsComposition() && (av.isMany() && relatedAssociation.isOptionalOne() && !av.isMandatory())) { 
      	
      	
    stringBuffer.append(TEXT_2093);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2094);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2095);
    stringBuffer.append(TEXT_2096);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2097);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2098);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2099);
    stringBuffer.append(gen.translate("type",av));
     } else { 
    stringBuffer.append(TEXT_2100);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2101);
    stringBuffer.append(TEXT_2102);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2103);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2104);
    stringBuffer.append(TEXT_2105);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2106);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2107);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2108);
    
  	  
      }
      
      else if (av.getIsComposition() && (av.isOptionalOne() && relatedAssociation.getMultiplicity().getLowerBound() > 1  && !relatedAssociation.isMandatory())) { 
      	
      	
    stringBuffer.append(TEXT_2109);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2110);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2111);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2112);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2113);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2114);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_2115);
    stringBuffer.append(TEXT_2116);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2117);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2118);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2119);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2120);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2121);
    stringBuffer.append(TEXT_2122);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2123);
    stringBuffer.append(TEXT_2124);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2125);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2126);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2127);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2128);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2129);
    stringBuffer.append(TEXT_2130);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2131);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2132);
    
  	  
      }
      
      else if (av.getIsComposition() && (av.isOptionalOne() && relatedAssociation.getMultiplicity().getLowerBound() > 1  && relatedAssociation.isMandatory())) { 
      	
      	
    stringBuffer.append(TEXT_2133);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2134);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2135);
    stringBuffer.append(TEXT_2136);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2137);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2138);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2139);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2140);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2141);
    stringBuffer.append(TEXT_2142);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2143);
    
  	  
      }
      
      
      else {
      
  	    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
  	    {
  	      
    stringBuffer.append(TEXT_2144);
    stringBuffer.append(TEXT_2145);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2146);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2147);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2148);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2149);
    stringBuffer.append(gen.translate("associationOne", av));
    stringBuffer.append(TEXT_2150);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2151);
    stringBuffer.append(TEXT_2152);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2153);
    
  	    }
  	    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
  	    {
  	      
    stringBuffer.append(TEXT_2154);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2155);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2156);
    stringBuffer.append(TEXT_2157);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2158);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2159);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_2160);
    
  	    }
  	    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
  	    {
  	      
    stringBuffer.append(TEXT_2161);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2162);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2163);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2164);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2165);
    stringBuffer.append(gen.translate("associationOne", av));
    stringBuffer.append(TEXT_2166);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2167);
    stringBuffer.append(TEXT_2168);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2169);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_2170);
    
  	    }
  	    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
  	    {
  	      
    stringBuffer.append(TEXT_2171);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2172);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2173);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2174);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2175);
    stringBuffer.append(gen.translate("associationOne", av));
    stringBuffer.append(TEXT_2176);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2177);
    stringBuffer.append(TEXT_2178);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2179);
    
  	    }
  	    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
  	    {
  	      
    stringBuffer.append(TEXT_2180);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2181);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2182);
    stringBuffer.append(TEXT_2183);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2184);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2185);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2186);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2187);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2188);
    stringBuffer.append(TEXT_2189);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2190);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2191);
    
  	    }
  	    else if (av.isOptionalOne() && relatedAssociation.isN())
  	    {
  	      
    stringBuffer.append(TEXT_2192);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2193);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2194);
    stringBuffer.append(TEXT_2195);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2196);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2197);
    
  	    }
  	    else if (av.isOptionalOne() && relatedAssociation.isMN())
  	    {
  	      
    stringBuffer.append(TEXT_2198);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2199);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2200);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2201);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2202);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2203);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_2204);
    stringBuffer.append(TEXT_2205);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2206);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2207);
    stringBuffer.append(TEXT_2208);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2209);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2210);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_2211);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_2212);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2213);
    stringBuffer.append(TEXT_2214);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2215);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2216);
    
  	    }
  	    else if (av.isOne() && relatedAssociation.isMany())
  	    {
  	      
    stringBuffer.append(TEXT_2217);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2218);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2219);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2220);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2221);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2222);
    stringBuffer.append(TEXT_2223);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2224);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2225);
    
  	    }
  	    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
  	    {
          
    stringBuffer.append(TEXT_2226);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2227);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2228);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2229);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2230);
    stringBuffer.append(TEXT_2231);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2232);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2233);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2234);
    
  	    }
  	    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
  	    {
          if (relatedAssociation.getNeedsCommonCode())
          {
            
    stringBuffer.append(TEXT_2235);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2236);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2237);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2238);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2239);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2240);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2241);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2242);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2243);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2244);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2245);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2246);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2247);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_2248);
    stringBuffer.append(TEXT_2249);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2250);
    stringBuffer.append(TEXT_2251);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2252);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2253);
    
          }
          else
          {
            
    stringBuffer.append(TEXT_2254);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2255);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2256);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2257);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2258);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2259);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2260);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2261);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2262);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2263);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2264);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2265);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2266);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2267);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_2268);
    stringBuffer.append(TEXT_2269);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2270);
    stringBuffer.append(TEXT_2271);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2272);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2273);
    
  	      }
        }
  	    else if (av.isMany() && relatedAssociation.isMany())
  	    {
          
    stringBuffer.append(TEXT_2274);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2275);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2276);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2277);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_2278);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2279);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2280);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2281);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2282);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2283);
    stringBuffer.append(TEXT_2284);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2285);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2286);
    
  	    }
  	    else if (av.isMany() && relatedAssociation.isOnlyOne()) 
  	    {
  	      
    
  	    }
  	    else if (av.isMany() && relatedAssociation.isOptionalOne())
  	    {
  	      
    stringBuffer.append(TEXT_2287);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2288);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2289);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2290);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_2291);
    
  	    }
  	    else
  	    {
  	      continue;
  	    }
  	  }
	  }
    else  /* Normal Case */
    {
      if (!relatedAssociation.getIsNavigable())
      {
        if (av.isOne())
        {
          hasSomethingToDelete = true;
          
    stringBuffer.append(TEXT_2292);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2293);
    
        }
        else if (av.isMany())
        {
          hasSomethingToDelete = true;
          
    stringBuffer.append(TEXT_2294);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2295);
    
        }
        continue;
      }
      
     
      if (relatedAssociation.getIsComposition()) {
      	if ((relatedAssociation.isOnlyOne() || relatedAssociation.isOptionalOne()) && av.isOnlyOne()) {
      		
    stringBuffer.append(TEXT_2296);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2297);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2298);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2299);
    stringBuffer.append(TEXT_2300);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2301);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2302);
    stringBuffer.append(TEXT_2303);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2304);
    
      	}
      	else if ((relatedAssociation.isOnlyOne() || relatedAssociation.isOptionalOne()) && av.isOptionalOne()) {
      		
    stringBuffer.append(TEXT_2305);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2306);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2307);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2308);
    stringBuffer.append(TEXT_2309);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2310);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2311);
    stringBuffer.append(TEXT_2312);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2313);
    stringBuffer.append(TEXT_2314);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2315);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2316);
    
      	}
      	else if ((relatedAssociation.isOnlyOne() || relatedAssociation.isOptionalOne()) && av.isMany()) {
      		
    stringBuffer.append(TEXT_2317);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2318);
    stringBuffer.append(TEXT_2319);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2320);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2321);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2322);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2323);
    stringBuffer.append(TEXT_2324);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2325);
    stringBuffer.append(TEXT_2326);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2327);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2328);
    
      	}
      	
      	else if (relatedAssociation.isMany() && av.isOnlyOne()) {
      		
    stringBuffer.append(TEXT_2329);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2330);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2331);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2332);
    stringBuffer.append(TEXT_2333);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2334);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2335);
    stringBuffer.append(TEXT_2336);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2337);
    
      	}
      	else if (relatedAssociation.isMany() && av.isOptionalOne()) {
      	    
    stringBuffer.append(TEXT_2338);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2339);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2340);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2341);
    stringBuffer.append(TEXT_2342);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2343);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2344);
    stringBuffer.append(TEXT_2345);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2346);
    
      	}
      	else if (relatedAssociation.isMany() && av.isMany()) {
      	    
    stringBuffer.append(TEXT_2347);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2348);
    stringBuffer.append(TEXT_2349);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2350);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2351);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2352);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2353);
    stringBuffer.append(TEXT_2354);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2355);
    stringBuffer.append(TEXT_2356);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2357);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2358);
    
      	}
      	else {
      		continue;
      	}
      	
      	
      }
      
      else if (av.getIsComposition() && (av.isMany() && relatedAssociation.isOnlyOne())) { 
        // normally this is the same for compositions, except for ManyToOne, the
        // list has to be cleared on the Many end (here, the ones are successfully deleted, 
        // but they are not removed from the list)
        // this functionality is not present for compositions, since, in the case
        // of deleting one from many, this would be on the composition end, and OneFromOne would
        // be called so the object is actually deleted.   
    
        
    stringBuffer.append(TEXT_2359);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2360);
    stringBuffer.append(TEXT_2361);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2362);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2363);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2364);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2365);
    stringBuffer.append(TEXT_2366);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2367);
    stringBuffer.append(TEXT_2368);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2369);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2370);
    
      
      }
      
      else if (av.getIsComposition() && (av.isMany() && relatedAssociation.isOptionalOne() && !av.isMandatory())) { 
        
        
    stringBuffer.append(TEXT_2371);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2372);
    stringBuffer.append(TEXT_2373);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2374);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2375);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2376);
    stringBuffer.append(TEXT_2377);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2378);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2379);
    stringBuffer.append(TEXT_2380);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2381);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2382);
    
      
      }
      
      else if (av.getIsComposition() && (av.isOptionalOne() && relatedAssociation.getMultiplicity().getLowerBound() > 1  && !relatedAssociation.isMandatory())) { 
        
        
    stringBuffer.append(TEXT_2383);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2384);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2385);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2386);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_2387);
    stringBuffer.append(TEXT_2388);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2389);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2390);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2391);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2392);
    stringBuffer.append(TEXT_2393);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2394);
    stringBuffer.append(TEXT_2395);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2396);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2397);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2398);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2399);
    stringBuffer.append(TEXT_2400);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2401);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2402);
    
      
      }
      
      else if (av.getIsComposition() && (av.isOptionalOne() && relatedAssociation.getMultiplicity().getLowerBound() > 1  && relatedAssociation.isMandatory())) { 
        
        
    stringBuffer.append(TEXT_2403);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2404);
    stringBuffer.append(TEXT_2405);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2406);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2407);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2408);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2409);
    stringBuffer.append(TEXT_2410);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2411);
    
      
      }
      else 
      {
        if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
        {
          
    stringBuffer.append(TEXT_2412);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2413);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2414);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2415);
    stringBuffer.append(TEXT_2416);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2417);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2418);
    stringBuffer.append(TEXT_2419);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2420);
    
        }
        else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
        {
          
    stringBuffer.append(TEXT_2421);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2422);
    stringBuffer.append(TEXT_2423);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2424);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2425);
    
        }
        else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
        {
          
    stringBuffer.append(TEXT_2426);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2427);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2428);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2429);
    stringBuffer.append(TEXT_2430);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2431);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2432);
    stringBuffer.append(TEXT_2433);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2434);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2435);
    
        }
        else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
        {
          
    stringBuffer.append(TEXT_2436);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2437);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2438);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2439);
    stringBuffer.append(TEXT_2440);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2441);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2442);
    stringBuffer.append(TEXT_2443);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2444);
    
        }
        else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
        {
          
    stringBuffer.append(TEXT_2445);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2446);
    stringBuffer.append(TEXT_2447);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2448);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2449);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2450);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2451);
    stringBuffer.append(TEXT_2452);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2453);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2454);
    
        }
        else if (av.isOptionalOne() && relatedAssociation.isN())
        {
          
    stringBuffer.append(TEXT_2455);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2456);
    stringBuffer.append(TEXT_2457);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2458);
    
        }
        else if (av.isOptionalOne() && relatedAssociation.isMN())
        {
          
    stringBuffer.append(TEXT_2459);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2460);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2461);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2462);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_2463);
    stringBuffer.append(TEXT_2464);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2465);
    stringBuffer.append(TEXT_2466);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2467);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2468);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2469);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2470);
    stringBuffer.append(TEXT_2471);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2472);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2473);
    
        }
        else if (av.isOne() && relatedAssociation.isMany())
        {
          
    stringBuffer.append(TEXT_2474);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2475);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2476);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2477);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2478);
    stringBuffer.append(TEXT_2479);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2480);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2481);
    
        }
        else if (av.isMandatory() && relatedAssociation.isOptionalOne())
        {
          
    stringBuffer.append(TEXT_2482);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2483);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2484);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2485);
    stringBuffer.append(TEXT_2486);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2487);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2488);
    stringBuffer.append(TEXT_2489);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2490);
    
        }
        else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
        {
          
    stringBuffer.append(TEXT_2491);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2492);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2493);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2494);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2495);
    stringBuffer.append(TEXT_2496);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2497);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2498);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2499);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2500);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2501);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2502);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2503);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2504);
    stringBuffer.append(TEXT_2505);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2506);
    stringBuffer.append(TEXT_2507);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2508);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2509);
    
        }
        else if (av.isMany() && relatedAssociation.isMany())
        {
          
    stringBuffer.append(TEXT_2510);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2511);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2512);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2513);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2514);
    stringBuffer.append(TEXT_2515);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2516);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2517);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2518);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2519);
    stringBuffer.append(TEXT_2520);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2521);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2522);
    
        }
        else if (av.isMany() && relatedAssociation.isOnlyOne()) 
        {
          
    stringBuffer.append(TEXT_2523);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2524);
    stringBuffer.append(TEXT_2525);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2526);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2527);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2528);
    stringBuffer.append(TEXT_2529);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2530);
    
        }
        else if (av.isMany() && relatedAssociation.isOptionalOne())
        {
          
    stringBuffer.append(TEXT_2531);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2532);
    stringBuffer.append(TEXT_2533);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2534);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2535);
    
        }
        else
        {
          continue;
        }
      }
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
            if(event.getIsTimer())
            {
               evList.add(event.getName());
               append(stringBuffer,"\n");
               append(stringBuffer,"  public boolean ");
               append(stringBuffer,"{0} ()",gen.translate("eventMethod",event));
               append(stringBuffer,"\n  {");
               append(stringBuffer,"\n    boolean wasAdded = false;");
          
               if(sm.isQueued())
               {
                 append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
               }
               if(sm.isPooled())
               {
                 append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
               }
               append(stringBuffer,"_M, null));");
       
               append(stringBuffer,"\n    wasAdded = true;");
               append(stringBuffer,"\n    return wasAdded;");
               append(stringBuffer,"\n  }");
               append(stringBuffer,"\n");
               evName = event.getName();
            }
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
              if(e.getIsTimer())
              {
                evList.add(e.getName());
                append(stringBuffer,"\n");
                append(stringBuffer,"  public boolean ");
                append(stringBuffer,"{0} ()",gen.translate("eventMethod",e));
                append(stringBuffer,"\n  {");
                append(stringBuffer,"\n    boolean wasAdded = false;");
          
                if(sm.isQueued())
                {
                  append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                }
                if(sm.isPooled())
                {
                  append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                }
                append(stringBuffer,"_M, null));");
       
                append(stringBuffer,"\n    wasAdded = true;");
                append(stringBuffer,"\n    return wasAdded;");
                append(stringBuffer,"\n  }");
                append(stringBuffer,"\n");
                evName = e.getName();
              }
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
           sameEvName=false;
         }
        }
      }
    }

    stringBuffer.append(TEXT_2536);
    
      if(smq.isPooled())
      {
        append(stringBuffer,"      Message m = pool.getNext();");
      }
      if(smq.isQueued())
      {
        append(stringBuffer,"      Message m = queue.getNext();");
      }
      
    stringBuffer.append(TEXT_2537);
     
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
               sameEventNameSM = false;
             }
           }
         }
           
    stringBuffer.append(TEXT_2538);
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
            if(event.getIsTimer())
            {
               evList.add(event.getName());
               append(stringBuffer,"\n");
               append(stringBuffer,"  public boolean ");
               append(stringBuffer,"{0} ()",gen.translate("eventMethod",event));
               append(stringBuffer,"\n  {");
               append(stringBuffer,"\n    boolean wasAdded = false;");
          
               if(sm.isQueued())
               {
                 append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
               }
               if(sm.isPooled())
               {
                 append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",event));
               }
               append(stringBuffer,"_M, null));");
       
               append(stringBuffer,"\n    wasAdded = true;");
               append(stringBuffer,"\n    return wasAdded;");
               append(stringBuffer,"\n  }");
               append(stringBuffer,"\n");
               evName = event.getName();
            }
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
              if(e.getIsTimer())
              {
                evList.add(e.getName());
                append(stringBuffer,"\n");
                append(stringBuffer,"  public boolean ");
                append(stringBuffer,"{0} ()",gen.translate("eventMethod",e));
                append(stringBuffer,"\n  {");
                append(stringBuffer,"\n    boolean wasAdded = false;");
          
                if(sm.isQueued())
                {
                  append(stringBuffer,"\n    queue.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                }
                if(sm.isPooled())
                {
                  append(stringBuffer,"\n    pool.put(new Message(MessageType.{0}",gen.translate("eventMethod",e));
                }
                append(stringBuffer,"_M, null));");
       
                append(stringBuffer,"\n    wasAdded = true;");
                append(stringBuffer,"\n    return wasAdded;");
                append(stringBuffer,"\n  }");
                append(stringBuffer,"\n");
                evName = e.getName();
              }
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
           sameEvName=false;
         }
        }
      }
    }

    stringBuffer.append(TEXT_2539);
    
      if(smq.isPooled())
      {
        append(stringBuffer,"      Message m = pool.getNext();");
      }
      if(smq.isQueued())
      {
        append(stringBuffer,"      Message m = queue.getNext();");
      }
      
    stringBuffer.append(TEXT_2540);
     
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
               sameEventNameSM = false;
             }
           }
         }
           
    stringBuffer.append(TEXT_2541);
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
        List<TraceItem> traceItems= aMethod.getTraced("method",uClass);
        
        if(!aMethod.getExistsInLanguage("Java"))
          continue;
        
          
        Position p = aMethod.getCodePosition();
        String positionHeader = "";        
        
        if (p != null) {
//        use annotations instead
        positionHeader = "  // line " + p.getLineNumber() + " \"" + p.getRelativePath(uClass, "Java") + "\"\n";
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
        String customBeforeInjectionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()));        
        String customAfterInjectionCode  = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", aMethod.getName()));
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

        StringBuilder methodExceptionsBuilder = new StringBuilder();
        if(aMethod.getExceptions()!=null&&aMethod.numberOfExceptions()>0)
        {
          methodExceptionsBuilder.append(" throws ");
          String exceptioncomma = "";
          for(String methodException:aMethod.getExceptions())
          {
            if(!"".equals(methodException))
            {
              methodExceptionsBuilder.append(exceptioncomma);
              methodExceptionsBuilder.append(methodException);
              exceptioncomma = ",";
            }
          }
        }
        String methodExceptions = methodExceptionsBuilder.toString();

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
                    
          append(stringBuffer,positionHeader);
          append(stringBuffer,override);
          append(stringBuffer, "{5}  {0}{1} {2} {3}({4}){6}", methodModifier, methodImplementationModifier, methodType, methodName, finalParams, positionHeader, methodExceptions);
        
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
          append(stringBuffer, "\n  {0}{1} {2} {3}_Original({4}){5}", methodModifier, methodImplementationModifier, methodType, methodName, finalParams, methodExceptions);
        }
        else
        {
          append(stringBuffer,override);
          append(stringBuffer, "{5}  {0}{1} {2} {3}({4}){6}", methodModifier, methodImplementationModifier, methodType, methodName, finalParams, positionHeader, methodExceptions);
        }
        if(aMethod.getIsAbstract())
        {
          append(stringBuffer, ";");
        }
        else
        {
          appendln(stringBuffer, "{");
          for( TraceItem traceItem : traceItems )append(stringBuffer, (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, aMethod,"me_e", uClass):""));
          if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
          if (customBeforeInjectionCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customBeforeInjectionCode, "    "));}
          
          addUncaughtExceptionVariables(methodName,p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/",""),p.getLineNumber(),javaline,stringBuffer.toString().split("\\n").length+1-javaline);
          String traceCode = "";
          if(properMethodBody.contains("return"))
          {
            for( TraceItem traceItem : traceItems )traceCode += (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, aMethod,"me_x", uClass):"");
              properMethodBody = properMethodBody.replaceAll("return", traceCode + "return");

            if(customAfterInjectionCode != null) {
              // Do some pre-processing to handle returns not being on a new line. Doing this allows us to maintain suitable indentation.
              String[] properMethodLines = properMethodBody.split("\\n");
              String fixedProperMethodBody = "";
              for(int i = 0; i < properMethodLines.length; i++) {
                if(properMethodLines[i].contains("return") && !properMethodLines[i].trim().substring(0, 6).equals("return")) {
                  String[] splitLines = properMethodLines[i].split("return", 2); 
                  // Determine indentation of return by adding indentation amount to previous line
                  String returnIndent = "";
                  int j = 0;
                  while(splitLines[0].charAt(j) == ' ') {
                    returnIndent += " ";
                    j++;
                  }

                  fixedProperMethodBody += returnIndent + splitLines[0].trim() + "\n";

                  String[] returnLines = splitLines[1].split(";");
                  if(returnLines.length > 1 && returnLines[1].trim().length() > 0) {
                    fixedProperMethodBody += returnIndent + "  return " + returnLines[0].trim() + ";\n" + returnIndent + returnLines[1].trim() + "\n"; 
                  } else {
                    fixedProperMethodBody += returnIndent + "  return " + splitLines[1].trim() + "\n"; 
                  }
                } else {
                  fixedProperMethodBody += properMethodLines[i] + "\n";
                }
              }

              properMethodBody = fixedProperMethodBody;

              String properMethodIndent = "";
              int indentIndex = 0;
              while(indentIndex < properMethodBody.length() && properMethodBody.charAt(indentIndex) == ' ') {
                properMethodIndent += " ";
                indentIndex++;
              }

              // inject the after injection code after every return, while appropriate indentation
              for(int i = -1; (i = properMethodBody.indexOf("return", i + 1)) != -1; ) {
                // determine the indentation of the return
                String indent = "";
                while(i >= 1 && properMethodBody.charAt(--i) == ' ') {
                  indent += " ";
                }

                // Need to determine if block has braces surrounding it. To do this, take the previous
                // lines of code and apply some regex to remove all of the comments.
                String[] previousLinesOfCode = properMethodBody.substring(0, i+1).replaceAll("\\/\\*([\\S\\s]+?)\\*\\/", "").replaceAll("(?s)/\\*.*?\\*/", "").replaceAll("//.*$", "").split("\\n");
                int commentLineCount = properMethodBody.substring(0, i+1).split("\\n").length - previousLinesOfCode.length;

                // set previousLine to be the first non-empty line
                int previousLine = -1; 
                for(int j = previousLinesOfCode.length - 1; j >= 0; j--) {
                  if(previousLinesOfCode[j].trim().length() > 0) {
                    previousLine = j;
                    break;
                  }
                }

                String previousLineStr = previousLinesOfCode[previousLine].trim();

                // Need to subtract the number of lines of comments between the return and the previous line of code
                while(!properMethodBody.split("\\n")[previousLine + commentLineCount].trim().equals(previousLineStr)) {
                  commentLineCount--;
                }
              
                // If we need to, insert braces, otherwise continue as normal
                String indentedCustomAfterInjectionCode = GeneratorHelper.doIndent("\n" + customAfterInjectionCode, indent);
                String braceIndent = "";
                String brace = "";
                String braceNewLine = "";
                if(previousLine != -1 && (previousLineStr.charAt(previousLineStr.length()-1) == ')' || previousLineStr.substring(previousLineStr.length()-4).equals("else"))) {
                  String[] methodLines = properMethodBody.split("\\n");
                  previousLine += commentLineCount;

                  // determine how indented the brace is
                  int j = 0;
                  while(j < methodLines[previousLine].length() && methodLines[previousLine].charAt(j) == ' ') {
                    braceIndent += " ";
                    j++;
                  }

                  methodLines[previousLine] = braceIndent + methodLines[previousLine].trim() + " {"; 

                  // Set properMethodBody to be String.join(methodLines, "\\n")
                  String newProperMethodBody = "";
                  for(int k = 0; k < methodLines.length; k++) {
                    newProperMethodBody += methodLines[k];
                    if(k != methodLines.length - 1) {
                      newProperMethodBody += "\n";
                    }
                  }
                  properMethodBody = newProperMethodBody;

                  brace = "}";
                  braceNewLine = "\n";
                }

                i += indent.length() + 1;
                String[] returnAndRest = properMethodBody.substring(i).split(";", 2);
                properMethodBody = properMethodIndent + properMethodBody.substring(0, i).trim() + indentedCustomAfterInjectionCode + "\n" + indent + returnAndRest[0].trim() + ";" + braceNewLine + braceIndent + brace + returnAndRest[1]; 
                i += indentedCustomAfterInjectionCode.length() + braceIndent.length() + 7;
              }

              // if the last line isn't a return, insert the injection at the very end
              String[] lines = properMethodBody.split("\\n");
              if(!lines[lines.length-1].contains("return")) {
                properMethodBody += GeneratorHelper.doIndent("\n" + customAfterInjectionCode, "    ");
              }
            }
          }
          appendln(stringBuffer, properMethodBody);
          if(!properMethodBody.contains("return"))
          {
            for( TraceItem traceItem : traceItems )append(stringBuffer, (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, aMethod,"me_x", uClass):""));
            if (customAfterInjectionCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customAfterInjectionCode, "    "));}
          }
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
    stringBuffer.append(TEXT_2542);
    
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
	  
    stringBuffer.append(TEXT_2543);
     } 
    return stringBuffer.toString();
    } 
    private String getAllExtraCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
     
  boolean isMainClass = false;
  if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_2544);
    stringBuffer.append(TEXT_2545);
    stringBuffer.append(uClass.getExtraCode());
    stringBuffer.append(TEXT_2546);
     } 
    if(uClass!=mainMainClass){
    stringBuffer.append(TEXT_2547);
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
    stringBuffer.append(TEXT_2548);
    stringBuffer.append(TEXT_2549);
    stringBuffer.append(exceptions);
    stringBuffer.append(TEXT_2550);
    
  return stringBuffer.toString();
}
    
public String endAll(String stringBuffer)
{
  GeneratorHelper.generator = null;

    return stringBuffer.toString();
  }
}