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
  protected final String TEXT_231 = NL + "      wasSet = ";
  protected final String TEXT_232 = "(";
  protected final String TEXT_233 = ");";
  protected final String TEXT_234 = NL + "      wasSet = true;";
  protected final String TEXT_235 = NL + "    return wasSet;" + NL + "  }" + NL + NL;
  protected final String TEXT_236 = NL + "  public boolean ";
  protected final String TEXT_237 = "(";
  protected final String TEXT_238 = " ";
  protected final String TEXT_239 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_240 = NL + "      wasAdded = super.";
  protected final String TEXT_241 = "(";
  protected final String TEXT_242 = ");";
  protected final String TEXT_243 = NL;
  protected final String TEXT_244 = "    return wasAdded;" + NL + "  }";
  protected final String TEXT_245 = NL + "  public boolean ";
  protected final String TEXT_246 = "(";
  protected final String TEXT_247 = " ";
  protected final String TEXT_248 = ")" + NL + "  {";
  protected final String TEXT_249 = NL + "      boolean wasSet = super.";
  protected final String TEXT_250 = "(";
  protected final String TEXT_251 = ");";
  protected final String TEXT_252 = NL + "      return wasSet;";
  protected final String TEXT_253 = NL + "    else return false;" + NL + "  }" + NL;
  protected final String TEXT_254 = NL + "  public ";
  protected final String TEXT_255 = " ";
  protected final String TEXT_256 = "(int index)" + NL + "  {";
  protected final String TEXT_257 = NL + "    ";
  protected final String TEXT_258 = " ";
  protected final String TEXT_259 = " = ";
  protected final String TEXT_260 = ".get(index);";
  protected final String TEXT_261 = NL;
  protected final String TEXT_262 = "    return ";
  protected final String TEXT_263 = ";" + NL + "  }" + NL + "" + NL + "  public ";
  protected final String TEXT_264 = "[] ";
  protected final String TEXT_265 = "()" + NL + "  {";
  protected final String TEXT_266 = NL + "    ";
  protected final String TEXT_267 = "[] ";
  protected final String TEXT_268 = " = ";
  protected final String TEXT_269 = ".toArray(new ";
  protected final String TEXT_270 = "[";
  protected final String TEXT_271 = ".size()]);";
  protected final String TEXT_272 = NL;
  protected final String TEXT_273 = "    return ";
  protected final String TEXT_274 = ";" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_275 = "()" + NL + "  {";
  protected final String TEXT_276 = NL + "    int number = ";
  protected final String TEXT_277 = ".size();";
  protected final String TEXT_278 = NL;
  protected final String TEXT_279 = "    return number;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_280 = "()" + NL + "  {";
  protected final String TEXT_281 = NL + "    boolean has = ";
  protected final String TEXT_282 = ".size() > 0;";
  protected final String TEXT_283 = NL;
  protected final String TEXT_284 = "    return has;" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_285 = "(";
  protected final String TEXT_286 = " ";
  protected final String TEXT_287 = ")" + NL + "  {";
  protected final String TEXT_288 = NL + "    int index = ";
  protected final String TEXT_289 = ".indexOf(";
  protected final String TEXT_290 = ");";
  protected final String TEXT_291 = NL;
  protected final String TEXT_292 = "    return index;" + NL + "  }" + NL;
  protected final String TEXT_293 = NL + "  public ";
  protected final String TEXT_294 = " ";
  protected final String TEXT_295 = "()" + NL + "  {";
  protected final String TEXT_296 = NL + "    ";
  protected final String TEXT_297 = " ";
  protected final String TEXT_298 = " = ";
  protected final String TEXT_299 = ";";
  protected final String TEXT_300 = NL;
  protected final String TEXT_301 = "    return ";
  protected final String TEXT_302 = ";";
  protected final String TEXT_303 = NL + "  }";
  protected final String TEXT_304 = NL + "  public ";
  protected final String TEXT_305 = " ";
  protected final String TEXT_306 = "()" + NL + "  {";
  protected final String TEXT_307 = NL + "    return ";
  protected final String TEXT_308 = ";";
  protected final String TEXT_309 = NL + "  }";
  protected final String TEXT_310 = NL + "  public ";
  protected final String TEXT_311 = " ";
  protected final String TEXT_312 = "()" + NL + "  {";
  protected final String TEXT_313 = NL + "    ";
  protected final String TEXT_314 = " ";
  protected final String TEXT_315 = " = ";
  protected final String TEXT_316 = ";";
  protected final String TEXT_317 = NL;
  protected final String TEXT_318 = "    return ";
  protected final String TEXT_319 = ";" + NL + "  }";
  protected final String TEXT_320 = NL + "  public ";
  protected final String TEXT_321 = " ";
  protected final String TEXT_322 = "()" + NL + "  {";
  protected final String TEXT_323 = NL + "    return ";
  protected final String TEXT_324 = ";" + NL + "  }";
  protected final String TEXT_325 = NL + "  public ";
  protected final String TEXT_326 = " ";
  protected final String TEXT_327 = "()" + NL + "  {";
  protected final String TEXT_328 = NL + "    ";
  protected final String TEXT_329 = " ";
  protected final String TEXT_330 = " = ";
  protected final String TEXT_331 = ";";
  protected final String TEXT_332 = NL;
  protected final String TEXT_333 = "    return ";
  protected final String TEXT_334 = ";" + NL + "  }" + NL;
  protected final String TEXT_335 = NL + "  public ";
  protected final String TEXT_336 = " ";
  protected final String TEXT_337 = "()" + NL + "  {";
  protected final String TEXT_338 = NL + "    return ";
  protected final String TEXT_339 = ";" + NL + "  }" + NL;
  protected final String TEXT_340 = NL + "  public static ";
  protected final String TEXT_341 = " ";
  protected final String TEXT_342 = "(";
  protected final String TEXT_343 = " ";
  protected final String TEXT_344 = ")" + NL + "  {";
  protected final String TEXT_345 = NL + "    ";
  protected final String TEXT_346 = " ";
  protected final String TEXT_347 = " = ";
  protected final String TEXT_348 = ".get(";
  protected final String TEXT_349 = ");";
  protected final String TEXT_350 = NL;
  protected final String TEXT_351 = "    return ";
  protected final String TEXT_352 = ";" + NL + "  }" + NL;
  protected final String TEXT_353 = NL + "  public static ";
  protected final String TEXT_354 = " ";
  protected final String TEXT_355 = "(";
  protected final String TEXT_356 = " ";
  protected final String TEXT_357 = ")" + NL + "  {";
  protected final String TEXT_358 = NL + "    return ";
  protected final String TEXT_359 = ".get(";
  protected final String TEXT_360 = ");" + NL + "  }" + NL;
  protected final String TEXT_361 = NL + "  public static boolean ";
  protected final String TEXT_362 = "(";
  protected final String TEXT_363 = " ";
  protected final String TEXT_364 = ")" + NL + "  {";
  protected final String TEXT_365 = NL + "    boolean ";
  protected final String TEXT_366 = " = ";
  protected final String TEXT_367 = "(";
  protected final String TEXT_368 = ") != null;";
  protected final String TEXT_369 = NL;
  protected final String TEXT_370 = "    return ";
  protected final String TEXT_371 = ";" + NL + "  }" + NL;
  protected final String TEXT_372 = NL + "  public static boolean ";
  protected final String TEXT_373 = "(";
  protected final String TEXT_374 = " ";
  protected final String TEXT_375 = ")" + NL + "  {";
  protected final String TEXT_376 = NL + "    return ";
  protected final String TEXT_377 = "(";
  protected final String TEXT_378 = ") != null;" + NL + "  }" + NL;
  protected final String TEXT_379 = NL + "  public ";
  protected final String TEXT_380 = " ";
  protected final String TEXT_381 = "()" + NL + "  {";
  protected final String TEXT_382 = NL + "    ";
  protected final String TEXT_383 = " ";
  protected final String TEXT_384 = " = ";
  protected final String TEXT_385 = ";";
  protected final String TEXT_386 = NL;
  protected final String TEXT_387 = "    return ";
  protected final String TEXT_388 = ";" + NL + "  }";
  protected final String TEXT_389 = NL + "  public ";
  protected final String TEXT_390 = " ";
  protected final String TEXT_391 = "()" + NL + "  {";
  protected final String TEXT_392 = NL + "    return ";
  protected final String TEXT_393 = ";" + NL + "  }";
  protected final String TEXT_394 = NL + "  public ";
  protected final String TEXT_395 = " ";
  protected final String TEXT_396 = "()" + NL + "  {";
  protected final String TEXT_397 = NL + "    ";
  protected final String TEXT_398 = " ";
  protected final String TEXT_399 = " = ";
  protected final String TEXT_400 = ";";
  protected final String TEXT_401 = NL;
  protected final String TEXT_402 = "    return ";
  protected final String TEXT_403 = ";" + NL + "  }";
  protected final String TEXT_404 = NL + "  public ";
  protected final String TEXT_405 = " ";
  protected final String TEXT_406 = "()" + NL + "  {";
  protected final String TEXT_407 = NL + "    return ";
  protected final String TEXT_408 = ";" + NL + "  }";
  protected final String TEXT_409 = NL + "  public ";
  protected final String TEXT_410 = " ";
  protected final String TEXT_411 = "()" + NL + "  {";
  protected final String TEXT_412 = NL + "    ";
  protected final String TEXT_413 = " ";
  protected final String TEXT_414 = " = ";
  protected final String TEXT_415 = ";";
  protected final String TEXT_416 = NL;
  protected final String TEXT_417 = "    return ";
  protected final String TEXT_418 = ";" + NL + "  }";
  protected final String TEXT_419 = NL + "  public ";
  protected final String TEXT_420 = " ";
  protected final String TEXT_421 = "()" + NL + "  {";
  protected final String TEXT_422 = NL + "    return ";
  protected final String TEXT_423 = ";" + NL + "  }";
  protected final String TEXT_424 = NL + "  public ";
  protected final String TEXT_425 = " ";
  protected final String TEXT_426 = "()" + NL + "  {" + NL + "    String answer = ";
  protected final String TEXT_427 = ".toString();";
  protected final String TEXT_428 = NL + "    return answer;" + NL + "  }" + NL;
  protected final String TEXT_429 = NL + "  public ";
  protected final String TEXT_430 = " ";
  protected final String TEXT_431 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_432 = ";" + NL + "  }" + NL;
  protected final String TEXT_433 = NL + "  ";
  protected final String TEXT_434 = " boolean ";
  protected final String TEXT_435 = "(";
  protected final String TEXT_436 = ")" + NL + "  {";
  protected final String TEXT_437 = NL + "    boolean wasEventProcessed = false;";
  protected final String TEXT_438 = NL + "    ";
  protected final String TEXT_439 = NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_440 = NL + "  public boolean ";
  protected final String TEXT_441 = "(";
  protected final String TEXT_442 = " ";
  protected final String TEXT_443 = ")" + NL + "  {";
  protected final String TEXT_444 = NL + "    ";
  protected final String TEXT_445 = " = ";
  protected final String TEXT_446 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_447 = NL + "  private void ";
  protected final String TEXT_448 = "()" + NL + "  {";
  protected final String TEXT_449 = NL + "    switch(";
  protected final String TEXT_450 = ")" + NL + "    {";
  protected final String TEXT_451 = NL + "      ";
  protected final String TEXT_452 = NL + "    }";
  protected final String TEXT_453 = NL + "  }" + NL;
  protected final String TEXT_454 = NL + "  private void ";
  protected final String TEXT_455 = "(";
  protected final String TEXT_456 = " ";
  protected final String TEXT_457 = ")" + NL + "  {";
  protected final String TEXT_458 = NL + "    ";
  protected final String TEXT_459 = " = ";
  protected final String TEXT_460 = ";";
  protected final String TEXT_461 = NL + "    if (";
  protected final String TEXT_462 = " != ";
  protected final String TEXT_463 = ".";
  protected final String TEXT_464 = " && ";
  protected final String TEXT_465 = " != ";
  protected final String TEXT_466 = ".";
  protected final String TEXT_467 = ") { ";
  protected final String TEXT_468 = "(";
  protected final String TEXT_469 = ".";
  protected final String TEXT_470 = "); }";
  protected final String TEXT_471 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_472 = ")" + NL + "    {";
  protected final String TEXT_473 = NL + "      ";
  protected final String TEXT_474 = NL + "    }";
  protected final String TEXT_475 = NL + "    if (";
  protected final String TEXT_476 = " == ";
  protected final String TEXT_477 = ".HStar) { ";
  protected final String TEXT_478 = " = ";
  protected final String TEXT_479 = "HStar;}";
  protected final String TEXT_480 = NL + "  }" + NL;
  protected final String TEXT_481 = NL + "  public ";
  protected final String TEXT_482 = " ";
  protected final String TEXT_483 = "()" + NL + "  {";
  protected final String TEXT_484 = NL + "    return ";
  protected final String TEXT_485 = ";";
  protected final String TEXT_486 = NL + "    ";
  protected final String TEXT_487 = " ";
  protected final String TEXT_488 = " = ";
  protected final String TEXT_489 = ";";
  protected final String TEXT_490 = NL + "    return ";
  protected final String TEXT_491 = ";";
  protected final String TEXT_492 = NL + "  }";
  protected final String TEXT_493 = NL + NL + "  public boolean ";
  protected final String TEXT_494 = "()" + NL + "  {" + NL + "    boolean has = ";
  protected final String TEXT_495 = " != null;" + NL + "    return has;" + NL + "  }";
  protected final String TEXT_496 = NL;
  protected final String TEXT_497 = NL + "  public ";
  protected final String TEXT_498 = " ";
  protected final String TEXT_499 = "(int index)" + NL + "  {";
  protected final String TEXT_500 = NL + "    ";
  protected final String TEXT_501 = " ";
  protected final String TEXT_502 = " = ";
  protected final String TEXT_503 = ".get(index);";
  protected final String TEXT_504 = NL + "    return ";
  protected final String TEXT_505 = ";" + NL + "  }" + NL;
  protected final String TEXT_506 = NL + "  public List<";
  protected final String TEXT_507 = "> ";
  protected final String TEXT_508 = "()" + NL + "  {";
  protected final String TEXT_509 = NL + "    List<";
  protected final String TEXT_510 = "> ";
  protected final String TEXT_511 = " = Collections.unmodifiableList(";
  protected final String TEXT_512 = ");";
  protected final String TEXT_513 = NL + "    return ";
  protected final String TEXT_514 = ";" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_515 = "()" + NL + "  {";
  protected final String TEXT_516 = NL + "    int number = ";
  protected final String TEXT_517 = ".size();";
  protected final String TEXT_518 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_519 = "()" + NL + "  {";
  protected final String TEXT_520 = NL + "    boolean has = ";
  protected final String TEXT_521 = ".size() > 0;";
  protected final String TEXT_522 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_523 = "(";
  protected final String TEXT_524 = " ";
  protected final String TEXT_525 = ")" + NL + "  {";
  protected final String TEXT_526 = NL + "    int index = ";
  protected final String TEXT_527 = ".indexOf(";
  protected final String TEXT_528 = ");";
  protected final String TEXT_529 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_530 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_531 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_532 = " : ";
  protected final String TEXT_533 = NL + "  public boolean ";
  protected final String TEXT_534 = "()" + NL + "  {";
  protected final String TEXT_535 = NL + "    boolean isValid = ";
  protected final String TEXT_536 = "() >= ";
  protected final String TEXT_537 = "();";
  protected final String TEXT_538 = NL + "    boolean isValid = ";
  protected final String TEXT_539 = "() >= ";
  protected final String TEXT_540 = "() && ";
  protected final String TEXT_541 = "() <= ";
  protected final String TEXT_542 = "();";
  protected final String TEXT_543 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_544 = NL + "  public static int ";
  protected final String TEXT_545 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_546 = ";" + NL + "  }";
  protected final String TEXT_547 = NL + "  public static int ";
  protected final String TEXT_548 = "()" + NL + "  {";
  protected final String TEXT_549 = NL + "    int required = ";
  protected final String TEXT_550 = ";";
  protected final String TEXT_551 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_552 = NL + "  public static int ";
  protected final String TEXT_553 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_554 = ";" + NL + "  }";
  protected final String TEXT_555 = NL + "  public static int ";
  protected final String TEXT_556 = "()" + NL + "  {";
  protected final String TEXT_557 = NL + "    int minimum = ";
  protected final String TEXT_558 = ";";
  protected final String TEXT_559 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_560 = NL + "  public static int ";
  protected final String TEXT_561 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_562 = ";" + NL + "  }";
  protected final String TEXT_563 = NL + "  public static int ";
  protected final String TEXT_564 = "()" + NL + "  {";
  protected final String TEXT_565 = NL + "    int maximum = ";
  protected final String TEXT_566 = ";";
  protected final String TEXT_567 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_568 = NL + "  public boolean ";
  protected final String TEXT_569 = "(";
  protected final String TEXT_570 = " ";
  protected final String TEXT_571 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_572 = NL + "    if (";
  protected final String TEXT_573 = "() >= ";
  protected final String TEXT_574 = "())" + NL + "    {";
  protected final String TEXT_575 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_576 = NL + "    ";
  protected final String TEXT_577 = ".add(";
  protected final String TEXT_578 = ");";
  protected final String TEXT_579 = NL + "    if (";
  protected final String TEXT_580 = ".";
  protected final String TEXT_581 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_582 = ".";
  protected final String TEXT_583 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_584 = NL + "        ";
  protected final String TEXT_585 = ".remove(";
  protected final String TEXT_586 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_587 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_588 = NL + "  public boolean ";
  protected final String TEXT_589 = "(";
  protected final String TEXT_590 = " ";
  protected final String TEXT_591 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_592 = NL + "    if (!";
  protected final String TEXT_593 = ".contains(";
  protected final String TEXT_594 = "))" + NL + "    {";
  protected final String TEXT_595 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_596 = ".indexOf(";
  protected final String TEXT_597 = ");";
  protected final String TEXT_598 = NL + "    ";
  protected final String TEXT_599 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_600 = ".";
  protected final String TEXT_601 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_602 = ".";
  protected final String TEXT_603 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_604 = NL + "        ";
  protected final String TEXT_605 = ".add(oldIndex,";
  protected final String TEXT_606 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_607 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_608 = NL + "  ";
  protected final String TEXT_609 = " boolean ";
  protected final String TEXT_610 = "(";
  protected final String TEXT_611 = " ";
  protected final String TEXT_612 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_613 = NL + "    ";
  protected final String TEXT_614 = " = ";
  protected final String TEXT_615 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_616 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_617 = NL + "  ";
  protected final String TEXT_618 = " boolean ";
  protected final String TEXT_619 = "(";
  protected final String TEXT_620 = " ";
  protected final String TEXT_621 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_622 = NL + "    if (";
  protected final String TEXT_623 = " != null)" + NL + "    {";
  protected final String TEXT_624 = NL + "      ";
  protected final String TEXT_625 = " = ";
  protected final String TEXT_626 = ";" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_627 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_628 = NL + "  public boolean ";
  protected final String TEXT_629 = "(";
  protected final String TEXT_630 = " ";
  protected final String TEXT_631 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_632 = NL + "    if (";
  protected final String TEXT_633 = " != null && !";
  protected final String TEXT_634 = ".equals(";
  protected final String TEXT_635 = ") && equals(";
  protected final String TEXT_636 = ".";
  protected final String TEXT_637 = "()))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_638 = ", as existing ";
  protected final String TEXT_639 = " would become an orphan";
  protected final String TEXT_640 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_641 = NL + "    ";
  protected final String TEXT_642 = " = ";
  protected final String TEXT_643 = ";";
  protected final String TEXT_644 = NL + "    ";
  protected final String TEXT_645 = " ";
  protected final String TEXT_646 = " = ";
  protected final String TEXT_647 = " != null ? ";
  protected final String TEXT_648 = ".";
  protected final String TEXT_649 = "() : null;" + NL + "" + NL + "    if (!this.equals(";
  protected final String TEXT_650 = "))" + NL + "    {" + NL + "      if (";
  protected final String TEXT_651 = " != null)" + NL + "      {";
  protected final String TEXT_652 = NL + "        ";
  protected final String TEXT_653 = ".";
  protected final String TEXT_654 = " = null;" + NL + "      }" + NL + "      if (";
  protected final String TEXT_655 = " != null)" + NL + "      {";
  protected final String TEXT_656 = NL + "        ";
  protected final String TEXT_657 = ".";
  protected final String TEXT_658 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_659 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_660 = NL + "  public boolean ";
  protected final String TEXT_661 = "(";
  protected final String TEXT_662 = " ";
  protected final String TEXT_663 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_664 = NL + "    if (";
  protected final String TEXT_665 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_666 = " to null, as ";
  protected final String TEXT_667 = " must always be associated to a ";
  protected final String TEXT_668 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_669 = NL + "    ";
  protected final String TEXT_670 = " ";
  protected final String TEXT_671 = " = ";
  protected final String TEXT_672 = ".";
  protected final String TEXT_673 = "();" + NL + "    if (";
  protected final String TEXT_674 = " != null && !equals(";
  protected final String TEXT_675 = "))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_676 = ", the current ";
  protected final String TEXT_677 = " already has a ";
  protected final String TEXT_678 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_679 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_680 = NL + "    ";
  protected final String TEXT_681 = " ";
  protected final String TEXT_682 = " = ";
  protected final String TEXT_683 = ";";
  protected final String TEXT_684 = NL + "    ";
  protected final String TEXT_685 = " = ";
  protected final String TEXT_686 = ";";
  protected final String TEXT_687 = NL + "    ";
  protected final String TEXT_688 = ".";
  protected final String TEXT_689 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_690 = " != null)" + NL + "    {";
  protected final String TEXT_691 = NL + "      ";
  protected final String TEXT_692 = ".";
  protected final String TEXT_693 = "(null);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_694 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_695 = NL + "  public ";
  protected final String TEXT_696 = " ";
  protected final String TEXT_697 = "(";
  protected final String TEXT_698 = ")" + NL + "  {";
  protected final String TEXT_699 = NL + "    ";
  protected final String TEXT_700 = " ";
  protected final String TEXT_701 = " = new ";
  protected final String TEXT_702 = "(";
  protected final String TEXT_703 = ");";
  protected final String TEXT_704 = NL + "    return ";
  protected final String TEXT_705 = ";" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_706 = "(";
  protected final String TEXT_707 = " ";
  protected final String TEXT_708 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_709 = NL + "    ";
  protected final String TEXT_710 = " ";
  protected final String TEXT_711 = " = ";
  protected final String TEXT_712 = ".";
  protected final String TEXT_713 = "();" + NL + "    boolean ";
  protected final String TEXT_714 = " = ";
  protected final String TEXT_715 = " != null && !this.equals(";
  protected final String TEXT_716 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_717 = " && ";
  protected final String TEXT_718 = ".";
  protected final String TEXT_719 = "() <= ";
  protected final String TEXT_720 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_721 = NL + "    if (";
  protected final String TEXT_722 = ")" + NL + "    {";
  protected final String TEXT_723 = NL + "      ";
  protected final String TEXT_724 = ".";
  protected final String TEXT_725 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_726 = NL + "      ";
  protected final String TEXT_727 = ".add(";
  protected final String TEXT_728 = ");" + NL + "    }";
  protected final String TEXT_729 = NL + "    wasAdded = true;";
  protected final String TEXT_730 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_731 = "(";
  protected final String TEXT_732 = " ";
  protected final String TEXT_733 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_734 = NL + "    //Unable to remove ";
  protected final String TEXT_735 = ", as it must always have a ";
  protected final String TEXT_736 = NL + "    if (this.equals(";
  protected final String TEXT_737 = ".";
  protected final String TEXT_738 = "()))" + NL + "    {";
  protected final String TEXT_739 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_740 = " already at minimum (";
  protected final String TEXT_741 = ")" + NL + "    if (";
  protected final String TEXT_742 = "() <= ";
  protected final String TEXT_743 = "())" + NL + "    {";
  protected final String TEXT_744 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_745 = NL;
  protected final String TEXT_746 = NL + "    ";
  protected final String TEXT_747 = ".remove(";
  protected final String TEXT_748 = ");";
  protected final String TEXT_749 = NL + "    wasRemoved = true;";
  protected final String TEXT_750 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_751 = NL + "  public ";
  protected final String TEXT_752 = " ";
  protected final String TEXT_753 = "(";
  protected final String TEXT_754 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_755 = "() >= ";
  protected final String TEXT_756 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_757 = "(";
  protected final String TEXT_758 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_759 = "(";
  protected final String TEXT_760 = " ";
  protected final String TEXT_761 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_762 = NL + "    if (";
  protected final String TEXT_763 = "() >= ";
  protected final String TEXT_764 = "())" + NL + "    {";
  protected final String TEXT_765 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_766 = NL + "    ";
  protected final String TEXT_767 = " ";
  protected final String TEXT_768 = " = ";
  protected final String TEXT_769 = ".";
  protected final String TEXT_770 = "();" + NL + "    boolean ";
  protected final String TEXT_771 = " = ";
  protected final String TEXT_772 = " != null && !this.equals(";
  protected final String TEXT_773 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_774 = " && ";
  protected final String TEXT_775 = ".";
  protected final String TEXT_776 = "() <= ";
  protected final String TEXT_777 = "())" + NL + "    {";
  protected final String TEXT_778 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_779 = NL + NL + "    if (";
  protected final String TEXT_780 = ")" + NL + "    {";
  protected final String TEXT_781 = NL + "      ";
  protected final String TEXT_782 = ".";
  protected final String TEXT_783 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_784 = NL + "      ";
  protected final String TEXT_785 = ".add(";
  protected final String TEXT_786 = ");" + NL + "    }";
  protected final String TEXT_787 = NL + "    wasAdded = true;";
  protected final String TEXT_788 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_789 = "(";
  protected final String TEXT_790 = " ";
  protected final String TEXT_791 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_792 = NL + "    //Unable to remove ";
  protected final String TEXT_793 = ", as it must always have a ";
  protected final String TEXT_794 = NL + "    if (this.equals(";
  protected final String TEXT_795 = ".";
  protected final String TEXT_796 = "()))" + NL + "    {";
  protected final String TEXT_797 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_798 = " already at minimum (";
  protected final String TEXT_799 = ")" + NL + "    if (";
  protected final String TEXT_800 = "() <= ";
  protected final String TEXT_801 = "())" + NL + "    {";
  protected final String TEXT_802 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_803 = NL + "    ";
  protected final String TEXT_804 = ".remove(";
  protected final String TEXT_805 = ");";
  protected final String TEXT_806 = NL + "    wasRemoved = true;";
  protected final String TEXT_807 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_808 = NL + "  public ";
  protected final String TEXT_809 = " ";
  protected final String TEXT_810 = "(";
  protected final String TEXT_811 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_812 = "() >= ";
  protected final String TEXT_813 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_814 = "(";
  protected final String TEXT_815 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_816 = "(";
  protected final String TEXT_817 = " ";
  protected final String TEXT_818 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_819 = NL + "    if (";
  protected final String TEXT_820 = "() >= ";
  protected final String TEXT_821 = "())" + NL + "    {";
  protected final String TEXT_822 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_823 = NL + "    ";
  protected final String TEXT_824 = " ";
  protected final String TEXT_825 = " = ";
  protected final String TEXT_826 = ".";
  protected final String TEXT_827 = "();" + NL + "    boolean ";
  protected final String TEXT_828 = " = ";
  protected final String TEXT_829 = " != null && !this.equals(";
  protected final String TEXT_830 = ");";
  protected final String TEXT_831 = NL + "    if (";
  protected final String TEXT_832 = ")" + NL + "    {";
  protected final String TEXT_833 = NL + "      ";
  protected final String TEXT_834 = ".";
  protected final String TEXT_835 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_836 = NL + "      ";
  protected final String TEXT_837 = ".add(";
  protected final String TEXT_838 = ");" + NL + "    }";
  protected final String TEXT_839 = NL + "    wasAdded = true;";
  protected final String TEXT_840 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_841 = "(";
  protected final String TEXT_842 = " ";
  protected final String TEXT_843 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_844 = NL + "    //Unable to remove ";
  protected final String TEXT_845 = ", as it must always have a ";
  protected final String TEXT_846 = NL + "    if (!this.equals(";
  protected final String TEXT_847 = ".";
  protected final String TEXT_848 = "()))" + NL + "    {";
  protected final String TEXT_849 = NL + "      ";
  protected final String TEXT_850 = ".remove(";
  protected final String TEXT_851 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_852 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_853 = NL + "  public boolean ";
  protected final String TEXT_854 = "(";
  protected final String TEXT_855 = "... ";
  protected final String TEXT_856 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_857 = NL + "    ArrayList<";
  protected final String TEXT_858 = "> ";
  protected final String TEXT_859 = " = new ArrayList<";
  protected final String TEXT_860 = ">();" + NL + "    for (";
  protected final String TEXT_861 = " ";
  protected final String TEXT_862 = " : ";
  protected final String TEXT_863 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_864 = ".contains(";
  protected final String TEXT_865 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_866 = NL + "      ";
  protected final String TEXT_867 = ".add(";
  protected final String TEXT_868 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_869 = ".size() != ";
  protected final String TEXT_870 = ".length || ";
  protected final String TEXT_871 = ".size() > ";
  protected final String TEXT_872 = "())" + NL + "    {";
  protected final String TEXT_873 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_874 = "> ";
  protected final String TEXT_875 = " = new ArrayList<";
  protected final String TEXT_876 = ">(";
  protected final String TEXT_877 = ");";
  protected final String TEXT_878 = NL + "    ";
  protected final String TEXT_879 = ".clear();" + NL + "    for (";
  protected final String TEXT_880 = " ";
  protected final String TEXT_881 = " : ";
  protected final String TEXT_882 = ")" + NL + "    {";
  protected final String TEXT_883 = NL + "      ";
  protected final String TEXT_884 = ".add(";
  protected final String TEXT_885 = ");" + NL + "      if (";
  protected final String TEXT_886 = ".contains(";
  protected final String TEXT_887 = "))" + NL + "      {";
  protected final String TEXT_888 = NL + "        ";
  protected final String TEXT_889 = ".remove(";
  protected final String TEXT_890 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_891 = NL + "        ";
  protected final String TEXT_892 = ".";
  protected final String TEXT_893 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_894 = " ";
  protected final String TEXT_895 = " : ";
  protected final String TEXT_896 = ")" + NL + "    {";
  protected final String TEXT_897 = NL + "      ";
  protected final String TEXT_898 = ".";
  protected final String TEXT_899 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_900 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_901 = NL + "  public ";
  protected final String TEXT_902 = " ";
  protected final String TEXT_903 = "(";
  protected final String TEXT_904 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_905 = "(";
  protected final String TEXT_906 = ");" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_907 = "(";
  protected final String TEXT_908 = " ";
  protected final String TEXT_909 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_910 = NL + "    ";
  protected final String TEXT_911 = " ";
  protected final String TEXT_912 = " = ";
  protected final String TEXT_913 = ".";
  protected final String TEXT_914 = "();" + NL + "    boolean ";
  protected final String TEXT_915 = " = ";
  protected final String TEXT_916 = " != null && !this.equals(";
  protected final String TEXT_917 = ");";
  protected final String TEXT_918 = NL + "    if (";
  protected final String TEXT_919 = ")" + NL + "    {";
  protected final String TEXT_920 = NL + "      ";
  protected final String TEXT_921 = ".";
  protected final String TEXT_922 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_923 = NL + "      ";
  protected final String TEXT_924 = ".add(";
  protected final String TEXT_925 = ");" + NL + "    }";
  protected final String TEXT_926 = NL + "    wasAdded = true;";
  protected final String TEXT_927 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_928 = "(";
  protected final String TEXT_929 = " ";
  protected final String TEXT_930 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_931 = NL + "    //Unable to remove ";
  protected final String TEXT_932 = ", as it must always have a ";
  protected final String TEXT_933 = NL + "    if (!this.equals(";
  protected final String TEXT_934 = ".";
  protected final String TEXT_935 = "()))" + NL + "    {";
  protected final String TEXT_936 = NL + "      ";
  protected final String TEXT_937 = ".remove(";
  protected final String TEXT_938 = ");";
  protected final String TEXT_939 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_940 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_941 = NL + "  public boolean ";
  protected final String TEXT_942 = "(";
  protected final String TEXT_943 = " ";
  protected final String TEXT_944 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_945 = NL + "    if (";
  protected final String TEXT_946 = " == null)" + NL + "    {";
  protected final String TEXT_947 = NL + "      ";
  protected final String TEXT_948 = " ";
  protected final String TEXT_949 = " = ";
  protected final String TEXT_950 = ";";
  protected final String TEXT_951 = NL + "      ";
  protected final String TEXT_952 = " = null;" + NL + "      " + NL + "      if (";
  protected final String TEXT_953 = " != null && ";
  protected final String TEXT_954 = ".";
  protected final String TEXT_955 = "() != null)" + NL + "      {";
  protected final String TEXT_956 = NL + "        ";
  protected final String TEXT_957 = ".";
  protected final String TEXT_958 = "(null);" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_959 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_960 = NL + "    ";
  protected final String TEXT_961 = " ";
  protected final String TEXT_962 = " = ";
  protected final String TEXT_963 = "();" + NL + "    if (";
  protected final String TEXT_964 = " != null && !";
  protected final String TEXT_965 = ".equals(";
  protected final String TEXT_966 = "))" + NL + "    {";
  protected final String TEXT_967 = NL + "      ";
  protected final String TEXT_968 = ".";
  protected final String TEXT_969 = "(null);" + NL + "    }" + NL;
  protected final String TEXT_970 = NL + "    ";
  protected final String TEXT_971 = " = ";
  protected final String TEXT_972 = ";";
  protected final String TEXT_973 = NL + "    ";
  protected final String TEXT_974 = " ";
  protected final String TEXT_975 = " = ";
  protected final String TEXT_976 = ".";
  protected final String TEXT_977 = "();" + NL + "" + NL + "    if (!equals(";
  protected final String TEXT_978 = "))" + NL + "    {";
  protected final String TEXT_979 = NL + "      ";
  protected final String TEXT_980 = ".";
  protected final String TEXT_981 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_982 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_983 = NL + "  public boolean ";
  protected final String TEXT_984 = "(";
  protected final String TEXT_985 = " ";
  protected final String TEXT_986 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_987 = NL + "    if (!";
  protected final String TEXT_988 = ".contains(";
  protected final String TEXT_989 = "))" + NL + "    {";
  protected final String TEXT_990 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_991 = "() <= ";
  protected final String TEXT_992 = "())" + NL + "    {";
  protected final String TEXT_993 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_994 = ".indexOf(";
  protected final String TEXT_995 = ");";
  protected final String TEXT_996 = NL + "    ";
  protected final String TEXT_997 = ".remove(oldIndex);";
  protected final String TEXT_998 = NL + "    if (";
  protected final String TEXT_999 = ".";
  protected final String TEXT_1000 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_1001 = ".";
  protected final String TEXT_1002 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_1003 = NL + "        ";
  protected final String TEXT_1004 = ".add(oldIndex,";
  protected final String TEXT_1005 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1006 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1007 = NL + "  public boolean ";
  protected final String TEXT_1008 = "(";
  protected final String TEXT_1009 = " ";
  protected final String TEXT_1010 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1011 = NL + "    if (!";
  protected final String TEXT_1012 = ".contains(";
  protected final String TEXT_1013 = "))" + NL + "    {";
  protected final String TEXT_1014 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1015 = "() <= ";
  protected final String TEXT_1016 = "())" + NL + "    {";
  protected final String TEXT_1017 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_1018 = ".indexOf(";
  protected final String TEXT_1019 = ");";
  protected final String TEXT_1020 = NL + "    ";
  protected final String TEXT_1021 = ".remove(oldIndex);";
  protected final String TEXT_1022 = NL + "    if (";
  protected final String TEXT_1023 = ".";
  protected final String TEXT_1024 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_1025 = ".";
  protected final String TEXT_1026 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_1027 = NL + "        ";
  protected final String TEXT_1028 = ".add(oldIndex,";
  protected final String TEXT_1029 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1030 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1031 = NL + "  public boolean ";
  protected final String TEXT_1032 = "(";
  protected final String TEXT_1033 = " ";
  protected final String TEXT_1034 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1035 = NL + "    if (";
  protected final String TEXT_1036 = " != null && ";
  protected final String TEXT_1037 = ".";
  protected final String TEXT_1038 = "() >= ";
  protected final String TEXT_1039 = ".";
  protected final String TEXT_1040 = "())" + NL + "    {";
  protected final String TEXT_1041 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1042 = NL + "    ";
  protected final String TEXT_1043 = " ";
  protected final String TEXT_1044 = " = ";
  protected final String TEXT_1045 = ";";
  protected final String TEXT_1046 = NL + "    ";
  protected final String TEXT_1047 = " = ";
  protected final String TEXT_1048 = ";" + NL + "    if (";
  protected final String TEXT_1049 = " != null && !";
  protected final String TEXT_1050 = ".equals(";
  protected final String TEXT_1051 = "))" + NL + "    {";
  protected final String TEXT_1052 = NL + "      ";
  protected final String TEXT_1053 = ".";
  protected final String TEXT_1054 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1055 = " != null)" + NL + "    {";
  protected final String TEXT_1056 = NL + "      ";
  protected final String TEXT_1057 = ".";
  protected final String TEXT_1058 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1059 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1060 = NL + "  public boolean ";
  protected final String TEXT_1061 = "(";
  protected final String TEXT_1062 = " ";
  protected final String TEXT_1063 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1064 = NL + "    if (";
  protected final String TEXT_1065 = " == null)" + NL + "    {";
  protected final String TEXT_1066 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1067 = NL + "    ";
  protected final String TEXT_1068 = " ";
  protected final String TEXT_1069 = " = ";
  protected final String TEXT_1070 = ";";
  protected final String TEXT_1071 = NL + "    ";
  protected final String TEXT_1072 = " = ";
  protected final String TEXT_1073 = ";" + NL + "    if (";
  protected final String TEXT_1074 = " != null && !";
  protected final String TEXT_1075 = ".equals(";
  protected final String TEXT_1076 = "))" + NL + "    {";
  protected final String TEXT_1077 = NL + "      ";
  protected final String TEXT_1078 = ".";
  protected final String TEXT_1079 = "(this);" + NL + "    }";
  protected final String TEXT_1080 = NL + "    ";
  protected final String TEXT_1081 = ".";
  protected final String TEXT_1082 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1083 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1084 = NL + "  public boolean ";
  protected final String TEXT_1085 = "(";
  protected final String TEXT_1086 = " ";
  protected final String TEXT_1087 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1088 = NL + "    if (";
  protected final String TEXT_1089 = " == null)" + NL + "    {";
  protected final String TEXT_1090 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1091 = NL + "    ";
  protected final String TEXT_1092 = " ";
  protected final String TEXT_1093 = " = ";
  protected final String TEXT_1094 = ";";
  protected final String TEXT_1095 = NL + "    ";
  protected final String TEXT_1096 = " = ";
  protected final String TEXT_1097 = ";" + NL + "    if (";
  protected final String TEXT_1098 = " != null && !";
  protected final String TEXT_1099 = ".equals(";
  protected final String TEXT_1100 = "))" + NL + "    {";
  protected final String TEXT_1101 = NL + "      ";
  protected final String TEXT_1102 = ".";
  protected final String TEXT_1103 = "(this);" + NL + "    }" + NL + "    if (!";
  protected final String TEXT_1104 = ".";
  protected final String TEXT_1105 = "(this))" + NL + "    {";
  protected final String TEXT_1106 = NL + "      ";
  protected final String TEXT_1107 = " = ";
  protected final String TEXT_1108 = ";" + NL + "      wasSet = false;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_1109 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1110 = NL + "  public boolean ";
  protected final String TEXT_1111 = "(";
  protected final String TEXT_1112 = " ";
  protected final String TEXT_1113 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1114 = NL + "    //Must provide ";
  protected final String TEXT_1115 = " to ";
  protected final String TEXT_1116 = NL + "    if (";
  protected final String TEXT_1117 = " == null)" + NL + "    {";
  protected final String TEXT_1118 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1119 = " already at maximum (";
  protected final String TEXT_1120 = ")" + NL + "    if (";
  protected final String TEXT_1121 = ".";
  protected final String TEXT_1122 = "() >= ";
  protected final String TEXT_1123 = ".";
  protected final String TEXT_1124 = "())" + NL + "    {";
  protected final String TEXT_1125 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1126 = NL + "    ";
  protected final String TEXT_1127 = " ";
  protected final String TEXT_1128 = " = ";
  protected final String TEXT_1129 = ";";
  protected final String TEXT_1130 = NL + "    ";
  protected final String TEXT_1131 = " = ";
  protected final String TEXT_1132 = ";" + NL + "    if (";
  protected final String TEXT_1133 = " != null && !";
  protected final String TEXT_1134 = ".equals(";
  protected final String TEXT_1135 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1136 = ".";
  protected final String TEXT_1137 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1138 = NL + "        ";
  protected final String TEXT_1139 = " = ";
  protected final String TEXT_1140 = ";";
  protected final String TEXT_1141 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1142 = NL + "    ";
  protected final String TEXT_1143 = ".";
  protected final String TEXT_1144 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1145 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1146 = NL + "  public boolean ";
  protected final String TEXT_1147 = "(";
  protected final String TEXT_1148 = " ";
  protected final String TEXT_1149 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1150 = NL + "    //Must provide ";
  protected final String TEXT_1151 = " to ";
  protected final String TEXT_1152 = NL + "    if (";
  protected final String TEXT_1153 = " == null)" + NL + "    {";
  protected final String TEXT_1154 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1155 = " != null && ";
  protected final String TEXT_1156 = ".";
  protected final String TEXT_1157 = "() <= ";
  protected final String TEXT_1158 = ".";
  protected final String TEXT_1159 = "())" + NL + "    {";
  protected final String TEXT_1160 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1161 = NL + "    ";
  protected final String TEXT_1162 = " ";
  protected final String TEXT_1163 = " = ";
  protected final String TEXT_1164 = ";";
  protected final String TEXT_1165 = NL + "    ";
  protected final String TEXT_1166 = " = ";
  protected final String TEXT_1167 = ";" + NL + "    if (";
  protected final String TEXT_1168 = " != null && !";
  protected final String TEXT_1169 = ".equals(";
  protected final String TEXT_1170 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1171 = ".";
  protected final String TEXT_1172 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1173 = NL + "        ";
  protected final String TEXT_1174 = " = ";
  protected final String TEXT_1175 = ";";
  protected final String TEXT_1176 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1177 = NL + "    ";
  protected final String TEXT_1178 = ".";
  protected final String TEXT_1179 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1180 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1181 = NL + "  public boolean ";
  protected final String TEXT_1182 = "(";
  protected final String TEXT_1183 = " ";
  protected final String TEXT_1184 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1185 = NL + "    ";
  protected final String TEXT_1186 = " ";
  protected final String TEXT_1187 = " = ";
  protected final String TEXT_1188 = ".";
  protected final String TEXT_1189 = "();";
  protected final String TEXT_1190 = NL + "    if (";
  protected final String TEXT_1191 = " == null)" + NL + "    {";
  protected final String TEXT_1192 = NL + "      ";
  protected final String TEXT_1193 = ".";
  protected final String TEXT_1194 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1195 = "))" + NL + "    {";
  protected final String TEXT_1196 = NL + "      ";
  protected final String TEXT_1197 = ".";
  protected final String TEXT_1198 = "(";
  protected final String TEXT_1199 = ");";
  protected final String TEXT_1200 = NL + "      ";
  protected final String TEXT_1201 = "(";
  protected final String TEXT_1202 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1203 = NL + "      ";
  protected final String TEXT_1204 = ".add(";
  protected final String TEXT_1205 = ");" + NL + "    }";
  protected final String TEXT_1206 = NL + "    wasAdded = true;";
  protected final String TEXT_1207 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1208 = "(";
  protected final String TEXT_1209 = " ";
  protected final String TEXT_1210 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1211 = NL + "    if (";
  protected final String TEXT_1212 = ".contains(";
  protected final String TEXT_1213 = "))" + NL + "    {";
  protected final String TEXT_1214 = NL + "      ";
  protected final String TEXT_1215 = ".remove(";
  protected final String TEXT_1216 = ");";
  protected final String TEXT_1217 = NL + "      ";
  protected final String TEXT_1218 = ".";
  protected final String TEXT_1219 = "(null);" + NL + "      wasRemoved = true;";
  protected final String TEXT_1220 = NL + "    }";
  protected final String TEXT_1221 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1222 = NL + "  public boolean ";
  protected final String TEXT_1223 = "(";
  protected final String TEXT_1224 = " ";
  protected final String TEXT_1225 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1226 = NL + "    ";
  protected final String TEXT_1227 = " ";
  protected final String TEXT_1228 = " = ";
  protected final String TEXT_1229 = ";";
  protected final String TEXT_1230 = NL + "    ";
  protected final String TEXT_1231 = " = ";
  protected final String TEXT_1232 = ";" + NL + "    if (";
  protected final String TEXT_1233 = " != null && !";
  protected final String TEXT_1234 = ".equals(";
  protected final String TEXT_1235 = "))" + NL + "    {";
  protected final String TEXT_1236 = NL + "      ";
  protected final String TEXT_1237 = ".";
  protected final String TEXT_1238 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1239 = " != null)" + NL + "    {";
  protected final String TEXT_1240 = NL + "      ";
  protected final String TEXT_1241 = ".";
  protected final String TEXT_1242 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1243 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1244 = NL + "  public boolean ";
  protected final String TEXT_1245 = "(";
  protected final String TEXT_1246 = " ";
  protected final String TEXT_1247 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1248 = NL + "    if (";
  protected final String TEXT_1249 = "() >= ";
  protected final String TEXT_1250 = "())" + NL + "    {";
  protected final String TEXT_1251 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1252 = NL + "    ";
  protected final String TEXT_1253 = " ";
  protected final String TEXT_1254 = " = ";
  protected final String TEXT_1255 = ".";
  protected final String TEXT_1256 = "();";
  protected final String TEXT_1257 = NL + "    if (";
  protected final String TEXT_1258 = " == null)" + NL + "    {";
  protected final String TEXT_1259 = NL + "      ";
  protected final String TEXT_1260 = ".";
  protected final String TEXT_1261 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1262 = "))" + NL + "    {";
  protected final String TEXT_1263 = NL + "      ";
  protected final String TEXT_1264 = ".";
  protected final String TEXT_1265 = "(";
  protected final String TEXT_1266 = ");";
  protected final String TEXT_1267 = NL + "      ";
  protected final String TEXT_1268 = "(";
  protected final String TEXT_1269 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1270 = NL + "      ";
  protected final String TEXT_1271 = ".add(";
  protected final String TEXT_1272 = ");" + NL + "    }";
  protected final String TEXT_1273 = NL + "    wasAdded = true;";
  protected final String TEXT_1274 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1275 = "(";
  protected final String TEXT_1276 = " ";
  protected final String TEXT_1277 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1278 = NL + "    if (";
  protected final String TEXT_1279 = ".contains(";
  protected final String TEXT_1280 = "))" + NL + "    {";
  protected final String TEXT_1281 = NL + "      ";
  protected final String TEXT_1282 = ".remove(";
  protected final String TEXT_1283 = ");";
  protected final String TEXT_1284 = NL + "      ";
  protected final String TEXT_1285 = ".";
  protected final String TEXT_1286 = "(null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1287 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1288 = NL + "  public boolean ";
  protected final String TEXT_1289 = "(";
  protected final String TEXT_1290 = " ";
  protected final String TEXT_1291 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1292 = NL + "    if (";
  protected final String TEXT_1293 = "() < ";
  protected final String TEXT_1294 = "())" + NL + "    {";
  protected final String TEXT_1295 = NL + "      ";
  protected final String TEXT_1296 = ".add(";
  protected final String TEXT_1297 = ");";
  protected final String TEXT_1298 = NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1299 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1300 = "(";
  protected final String TEXT_1301 = " ";
  protected final String TEXT_1302 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1303 = NL + "    if (!";
  protected final String TEXT_1304 = ".contains(";
  protected final String TEXT_1305 = "))" + NL + "    {";
  protected final String TEXT_1306 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1307 = "() <= ";
  protected final String TEXT_1308 = "())" + NL + "    {";
  protected final String TEXT_1309 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_1310 = NL;
  protected final String TEXT_1311 = NL + "    ";
  protected final String TEXT_1312 = ".remove(";
  protected final String TEXT_1313 = ");";
  protected final String TEXT_1314 = NL + "    wasRemoved = true;";
  protected final String TEXT_1315 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1316 = NL + "  public boolean ";
  protected final String TEXT_1317 = "(";
  protected final String TEXT_1318 = " ";
  protected final String TEXT_1319 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1320 = NL + "    if (";
  protected final String TEXT_1321 = "() >= ";
  protected final String TEXT_1322 = "())" + NL + "    {";
  protected final String TEXT_1323 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1324 = NL + "    ";
  protected final String TEXT_1325 = " ";
  protected final String TEXT_1326 = " = ";
  protected final String TEXT_1327 = ".";
  protected final String TEXT_1328 = "();" + NL + "    if (";
  protected final String TEXT_1329 = " != null && ";
  protected final String TEXT_1330 = ".";
  protected final String TEXT_1331 = "() <= ";
  protected final String TEXT_1332 = "())" + NL + "    {";
  protected final String TEXT_1333 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1334 = " != null)" + NL + "    {";
  protected final String TEXT_1335 = NL + "      ";
  protected final String TEXT_1336 = ".";
  protected final String TEXT_1337 = ".remove(";
  protected final String TEXT_1338 = ");" + NL + "    }";
  protected final String TEXT_1339 = NL + "    ";
  protected final String TEXT_1340 = ".add(";
  protected final String TEXT_1341 = ");";
  protected final String TEXT_1342 = NL + "    ";
  protected final String TEXT_1343 = "(";
  protected final String TEXT_1344 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1345 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1346 = "(";
  protected final String TEXT_1347 = " ";
  protected final String TEXT_1348 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1349 = NL + "    if (";
  protected final String TEXT_1350 = ".contains(";
  protected final String TEXT_1351 = ") && ";
  protected final String TEXT_1352 = "() > ";
  protected final String TEXT_1353 = "())" + NL + "    {";
  protected final String TEXT_1354 = NL + "      ";
  protected final String TEXT_1355 = ".remove(";
  protected final String TEXT_1356 = ");";
  protected final String TEXT_1357 = NL + "      ";
  protected final String TEXT_1358 = "(";
  protected final String TEXT_1359 = ",null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1360 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1361 = NL + "  public boolean ";
  protected final String TEXT_1362 = "(";
  protected final String TEXT_1363 = "... ";
  protected final String TEXT_1364 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1365 = NL + "    ArrayList<";
  protected final String TEXT_1366 = "> ";
  protected final String TEXT_1367 = " = new ArrayList<";
  protected final String TEXT_1368 = ">();" + NL + "    for (";
  protected final String TEXT_1369 = " ";
  protected final String TEXT_1370 = " : ";
  protected final String TEXT_1371 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1372 = ".contains(";
  protected final String TEXT_1373 = "))" + NL + "      {";
  protected final String TEXT_1374 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1375 = ".";
  protected final String TEXT_1376 = "() != null && !this.equals(";
  protected final String TEXT_1377 = ".";
  protected final String TEXT_1378 = "()))" + NL + "      {";
  protected final String TEXT_1379 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1380 = NL + "      ";
  protected final String TEXT_1381 = ".add(";
  protected final String TEXT_1382 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1383 = ".size() != ";
  protected final String TEXT_1384 = "())" + NL + "    {";
  protected final String TEXT_1385 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1386 = NL + "    ";
  protected final String TEXT_1387 = ".removeAll(";
  protected final String TEXT_1388 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1389 = " orphan : ";
  protected final String TEXT_1390 = ")" + NL + "    {";
  protected final String TEXT_1391 = NL + "      ";
  protected final String TEXT_1392 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1393 = NL + "    ";
  protected final String TEXT_1394 = ".clear();" + NL + "    for (";
  protected final String TEXT_1395 = " ";
  protected final String TEXT_1396 = " : ";
  protected final String TEXT_1397 = ")" + NL + "    {";
  protected final String TEXT_1398 = NL + "      ";
  protected final String TEXT_1399 = "(";
  protected final String TEXT_1400 = ", this);";
  protected final String TEXT_1401 = NL + "      ";
  protected final String TEXT_1402 = ".add(";
  protected final String TEXT_1403 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1404 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1405 = NL + "  private void ";
  protected final String TEXT_1406 = "(";
  protected final String TEXT_1407 = " ";
  protected final String TEXT_1408 = ", ";
  protected final String TEXT_1409 = " ";
  protected final String TEXT_1410 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1411 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1412 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1413 = ", ";
  protected final String TEXT_1414 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1415 = " to ";
  protected final String TEXT_1416 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1417 = NL + "  public boolean ";
  protected final String TEXT_1418 = "(";
  protected final String TEXT_1419 = " ";
  protected final String TEXT_1420 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1421 = NL + "    ";
  protected final String TEXT_1422 = ".add(";
  protected final String TEXT_1423 = ");";
  protected final String TEXT_1424 = NL + "    wasAdded = true;";
  protected final String TEXT_1425 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1426 = "(";
  protected final String TEXT_1427 = " ";
  protected final String TEXT_1428 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1429 = NL + "    if (";
  protected final String TEXT_1430 = ".contains(";
  protected final String TEXT_1431 = "))" + NL + "    {";
  protected final String TEXT_1432 = NL + "      ";
  protected final String TEXT_1433 = ".remove(";
  protected final String TEXT_1434 = ");";
  protected final String TEXT_1435 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1436 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1437 = NL + "  public boolean ";
  protected final String TEXT_1438 = "(";
  protected final String TEXT_1439 = " ";
  protected final String TEXT_1440 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1441 = NL + "    if (";
  protected final String TEXT_1442 = "() < ";
  protected final String TEXT_1443 = "())" + NL + "    {";
  protected final String TEXT_1444 = NL + "      ";
  protected final String TEXT_1445 = ".add(";
  protected final String TEXT_1446 = ");";
  protected final String TEXT_1447 = NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1448 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_1449 = NL;
  protected final String TEXT_1450 = NL + "  public boolean ";
  protected final String TEXT_1451 = "(";
  protected final String TEXT_1452 = " ";
  protected final String TEXT_1453 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1454 = NL + "    if (";
  protected final String TEXT_1455 = ".contains(";
  protected final String TEXT_1456 = "))" + NL + "    {";
  protected final String TEXT_1457 = NL + "      ";
  protected final String TEXT_1458 = ".remove(";
  protected final String TEXT_1459 = ");";
  protected final String TEXT_1460 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1461 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1462 = NL + "  public boolean ";
  protected final String TEXT_1463 = "(";
  protected final String TEXT_1464 = " ";
  protected final String TEXT_1465 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1466 = NL + "    ";
  protected final String TEXT_1467 = ".add(";
  protected final String TEXT_1468 = ");";
  protected final String TEXT_1469 = NL + "    wasAdded = true;";
  protected final String TEXT_1470 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1471 = "(";
  protected final String TEXT_1472 = " ";
  protected final String TEXT_1473 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1474 = NL + "    if (!";
  protected final String TEXT_1475 = ".contains(";
  protected final String TEXT_1476 = "))" + NL + "    {";
  protected final String TEXT_1477 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1478 = "() <= ";
  protected final String TEXT_1479 = "())" + NL + "    {";
  protected final String TEXT_1480 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_1481 = NL;
  protected final String TEXT_1482 = NL + "    ";
  protected final String TEXT_1483 = ".remove(";
  protected final String TEXT_1484 = ");";
  protected final String TEXT_1485 = NL + "    wasRemoved = true;";
  protected final String TEXT_1486 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1487 = NL + "  ";
  protected final String TEXT_1488 = " boolean ";
  protected final String TEXT_1489 = "(";
  protected final String TEXT_1490 = "... ";
  protected final String TEXT_1491 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1492 = NL + "    ArrayList<";
  protected final String TEXT_1493 = "> ";
  protected final String TEXT_1494 = " = new ArrayList<";
  protected final String TEXT_1495 = ">();" + NL + "    for (";
  protected final String TEXT_1496 = " ";
  protected final String TEXT_1497 = " : ";
  protected final String TEXT_1498 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1499 = ".contains(";
  protected final String TEXT_1500 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1501 = NL + "      ";
  protected final String TEXT_1502 = ".add(";
  protected final String TEXT_1503 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1504 = ".size() != ";
  protected final String TEXT_1505 = ".length || ";
  protected final String TEXT_1506 = ".size() != ";
  protected final String TEXT_1507 = "())" + NL + "    {";
  protected final String TEXT_1508 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1509 = NL + "    ";
  protected final String TEXT_1510 = ".clear();";
  protected final String TEXT_1511 = NL + "    ";
  protected final String TEXT_1512 = ".addAll(";
  protected final String TEXT_1513 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1514 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1515 = NL + "  ";
  protected final String TEXT_1516 = " boolean ";
  protected final String TEXT_1517 = "(";
  protected final String TEXT_1518 = "... ";
  protected final String TEXT_1519 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1520 = NL + "    ArrayList<";
  protected final String TEXT_1521 = "> ";
  protected final String TEXT_1522 = " = new ArrayList<";
  protected final String TEXT_1523 = ">();" + NL + "    for (";
  protected final String TEXT_1524 = " ";
  protected final String TEXT_1525 = " : ";
  protected final String TEXT_1526 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1527 = ".contains(";
  protected final String TEXT_1528 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1529 = NL + "      ";
  protected final String TEXT_1530 = ".add(";
  protected final String TEXT_1531 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1532 = ".size() != ";
  protected final String TEXT_1533 = ".length)" + NL + "    {";
  protected final String TEXT_1534 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1535 = NL + "    ";
  protected final String TEXT_1536 = ".clear();";
  protected final String TEXT_1537 = NL + "    ";
  protected final String TEXT_1538 = ".addAll(";
  protected final String TEXT_1539 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1540 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1541 = NL + "  public boolean ";
  protected final String TEXT_1542 = "(";
  protected final String TEXT_1543 = " ";
  protected final String TEXT_1544 = ")" + NL + "  {" + NL + "    //" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "    boolean wasSet = false;";
  protected final String TEXT_1545 = NL + "    ";
  protected final String TEXT_1546 = " ";
  protected final String TEXT_1547 = " = ";
  protected final String TEXT_1548 = ";" + NL + "" + NL + "    if (";
  protected final String TEXT_1549 = " == null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1550 = " != null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1551 = ".";
  protected final String TEXT_1552 = "(this))" + NL + "        {";
  protected final String TEXT_1553 = NL + "          ";
  protected final String TEXT_1554 = " = ";
  protected final String TEXT_1555 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if (";
  protected final String TEXT_1556 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1557 = " == null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1558 = ".";
  protected final String TEXT_1559 = "() < ";
  protected final String TEXT_1560 = ".";
  protected final String TEXT_1561 = "())" + NL + "        {";
  protected final String TEXT_1562 = NL + "          ";
  protected final String TEXT_1563 = ".";
  protected final String TEXT_1564 = "(this);";
  protected final String TEXT_1565 = NL + "          ";
  protected final String TEXT_1566 = " = ";
  protected final String TEXT_1567 = ";  // ";
  protected final String TEXT_1568 = " == null" + NL + "          wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1569 = ".";
  protected final String TEXT_1570 = "() < ";
  protected final String TEXT_1571 = ".";
  protected final String TEXT_1572 = "())" + NL + "        {";
  protected final String TEXT_1573 = NL + "          ";
  protected final String TEXT_1574 = ".";
  protected final String TEXT_1575 = "(this);";
  protected final String TEXT_1576 = NL + "          ";
  protected final String TEXT_1577 = ".";
  protected final String TEXT_1578 = "(this);";
  protected final String TEXT_1579 = NL + "          ";
  protected final String TEXT_1580 = " = ";
  protected final String TEXT_1581 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if (wasSet)" + NL + "    {";
  protected final String TEXT_1582 = NL + "      ";
  protected final String TEXT_1583 = " = ";
  protected final String TEXT_1584 = ";" + NL + "    }" + NL + "    return wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_1585 = NL + "//  public boolean ";
  protected final String TEXT_1586 = "(";
  protected final String TEXT_1587 = " ";
  protected final String TEXT_1588 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_1589 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//" + NL + "//    boolean wasSet = false;" + NL + "//    ";
  protected final String TEXT_1590 = " ";
  protected final String TEXT_1591 = " = ";
  protected final String TEXT_1592 = ";" + NL + "//  " + NL + "//    if (";
  protected final String TEXT_1593 = " == null)" + NL + "//    {  " + NL + "//      if (";
  protected final String TEXT_1594 = " != null)" + NL + "//      { " + NL + "//        if (";
  protected final String TEXT_1595 = ".";
  protected final String TEXT_1596 = "(this))" + NL + "//          ";
  protected final String TEXT_1597 = " = ";
  protected final String TEXT_1598 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    else" + NL + "//    {" + NL + "//      if (";
  protected final String TEXT_1599 = " != null)" + NL + "//      {" + NL + "//        if (";
  protected final String TEXT_1600 = " == null)" + NL + "//        {" + NL + "//          if (";
  protected final String TEXT_1601 = ".";
  protected final String TEXT_1602 = " < ";
  protected final String TEXT_1603 = ".";
  protected final String TEXT_1604 = ")" + NL + "//            ";
  protected final String TEXT_1605 = ".";
  protected final String TEXT_1606 = "(this);" + NL + "//            ";
  protected final String TEXT_1607 = " = ";
  protected final String TEXT_1608 = "  // ";
  protected final String TEXT_1609 = " == null;" + NL + "//            wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//      else" + NL + "//      {" + NL + "//        if (   ";
  protected final String TEXT_1610 = ".";
  protected final String TEXT_1611 = " < ";
  protected final String TEXT_1612 = ".";
  protected final String TEXT_1613 = "()" + NL + "//            && ";
  protected final String TEXT_1614 = ".";
  protected final String TEXT_1615 = " > ";
  protected final String TEXT_1616 = ".";
  protected final String TEXT_1617 = "()" + NL + "//           )" + NL + "//          ";
  protected final String TEXT_1618 = ".";
  protected final String TEXT_1619 = "(this);" + NL + "//          ";
  protected final String TEXT_1620 = ".";
  protected final String TEXT_1621 = "(this);" + NL + "//          ";
  protected final String TEXT_1622 = " = ";
  protected final String TEXT_1623 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    " + NL + "//    if (wasSet)" + NL + "//    {" + NL + "//      ";
  protected final String TEXT_1624 = " = ";
  protected final String TEXT_1625 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return wasSet;" + NL + "//  }";
  protected final String TEXT_1626 = NL + "  public boolean ";
  protected final String TEXT_1627 = "(";
  protected final String TEXT_1628 = "... ";
  protected final String TEXT_1629 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1630 = NL + "    ArrayList<";
  protected final String TEXT_1631 = "> ";
  protected final String TEXT_1632 = " = new ArrayList<";
  protected final String TEXT_1633 = ">();" + NL + "    for (";
  protected final String TEXT_1634 = " ";
  protected final String TEXT_1635 = " : ";
  protected final String TEXT_1636 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1637 = ".contains(";
  protected final String TEXT_1638 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1639 = NL + "      ";
  protected final String TEXT_1640 = ".add(";
  protected final String TEXT_1641 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1642 = ".size() != ";
  protected final String TEXT_1643 = ".length || ";
  protected final String TEXT_1644 = ".size() < ";
  protected final String TEXT_1645 = "() || ";
  protected final String TEXT_1646 = ".size() > ";
  protected final String TEXT_1647 = "())" + NL + "    {";
  protected final String TEXT_1648 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1649 = "> ";
  protected final String TEXT_1650 = " = new ArrayList<";
  protected final String TEXT_1651 = ">(";
  protected final String TEXT_1652 = ");";
  protected final String TEXT_1653 = NL + "    ";
  protected final String TEXT_1654 = ".clear();" + NL + "    for (";
  protected final String TEXT_1655 = " ";
  protected final String TEXT_1656 = " : ";
  protected final String TEXT_1657 = ")" + NL + "    {";
  protected final String TEXT_1658 = NL + "      ";
  protected final String TEXT_1659 = ".add(";
  protected final String TEXT_1660 = ");" + NL + "      if (";
  protected final String TEXT_1661 = ".contains(";
  protected final String TEXT_1662 = "))" + NL + "      {";
  protected final String TEXT_1663 = NL + "        ";
  protected final String TEXT_1664 = ".remove(";
  protected final String TEXT_1665 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1666 = NL + "        ";
  protected final String TEXT_1667 = ".";
  protected final String TEXT_1668 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1669 = " ";
  protected final String TEXT_1670 = " : ";
  protected final String TEXT_1671 = ")" + NL + "    {";
  protected final String TEXT_1672 = NL + "      ";
  protected final String TEXT_1673 = ".";
  protected final String TEXT_1674 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1675 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1676 = NL + "  public boolean ";
  protected final String TEXT_1677 = "(";
  protected final String TEXT_1678 = "... ";
  protected final String TEXT_1679 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1680 = NL + "    ArrayList<";
  protected final String TEXT_1681 = "> ";
  protected final String TEXT_1682 = " = new ArrayList<";
  protected final String TEXT_1683 = ">();" + NL + "    for (";
  protected final String TEXT_1684 = " ";
  protected final String TEXT_1685 = " : ";
  protected final String TEXT_1686 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1687 = ".contains(";
  protected final String TEXT_1688 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1689 = NL + "      ";
  protected final String TEXT_1690 = ".add(";
  protected final String TEXT_1691 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1692 = ".size() != ";
  protected final String TEXT_1693 = ".length || ";
  protected final String TEXT_1694 = ".size() < ";
  protected final String TEXT_1695 = "())" + NL + "    {";
  protected final String TEXT_1696 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1697 = "> ";
  protected final String TEXT_1698 = " = new ArrayList<";
  protected final String TEXT_1699 = ">(";
  protected final String TEXT_1700 = ");";
  protected final String TEXT_1701 = NL + "    ";
  protected final String TEXT_1702 = ".clear();" + NL + "    for (";
  protected final String TEXT_1703 = " ";
  protected final String TEXT_1704 = " : ";
  protected final String TEXT_1705 = ")" + NL + "    {";
  protected final String TEXT_1706 = NL + "      ";
  protected final String TEXT_1707 = ".add(";
  protected final String TEXT_1708 = ");" + NL + "      if (";
  protected final String TEXT_1709 = ".contains(";
  protected final String TEXT_1710 = "))" + NL + "      {";
  protected final String TEXT_1711 = NL + "        ";
  protected final String TEXT_1712 = ".remove(";
  protected final String TEXT_1713 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1714 = NL + "        ";
  protected final String TEXT_1715 = ".";
  protected final String TEXT_1716 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1717 = " ";
  protected final String TEXT_1718 = " : ";
  protected final String TEXT_1719 = ")" + NL + "    {";
  protected final String TEXT_1720 = NL + "      ";
  protected final String TEXT_1721 = ".";
  protected final String TEXT_1722 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1723 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1724 = NL + "  ";
  protected final String TEXT_1725 = " boolean ";
  protected final String TEXT_1726 = "(";
  protected final String TEXT_1727 = "... ";
  protected final String TEXT_1728 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1729 = NL + "    ArrayList<";
  protected final String TEXT_1730 = "> ";
  protected final String TEXT_1731 = " = new ArrayList<";
  protected final String TEXT_1732 = ">();" + NL + "    for (";
  protected final String TEXT_1733 = " ";
  protected final String TEXT_1734 = " : ";
  protected final String TEXT_1735 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1736 = ".contains(";
  protected final String TEXT_1737 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1738 = NL + "      ";
  protected final String TEXT_1739 = ".add(";
  protected final String TEXT_1740 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1741 = ".size() != ";
  protected final String TEXT_1742 = ".length || ";
  protected final String TEXT_1743 = ".size() < ";
  protected final String TEXT_1744 = "() || ";
  protected final String TEXT_1745 = ".size() > ";
  protected final String TEXT_1746 = "())" + NL + "    {";
  protected final String TEXT_1747 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1748 = NL + "    ";
  protected final String TEXT_1749 = ".clear();";
  protected final String TEXT_1750 = NL + "    ";
  protected final String TEXT_1751 = ".addAll(";
  protected final String TEXT_1752 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1753 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1754 = NL + "  public boolean ";
  protected final String TEXT_1755 = "(";
  protected final String TEXT_1756 = "... ";
  protected final String TEXT_1757 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1758 = NL + "    if (";
  protected final String TEXT_1759 = ".length < ";
  protected final String TEXT_1760 = "()";
  protected final String TEXT_1761 = ")" + NL + "    {";
  protected final String TEXT_1762 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1763 = "> ";
  protected final String TEXT_1764 = " = new ArrayList<";
  protected final String TEXT_1765 = ">();" + NL + "    HashMap<";
  protected final String TEXT_1766 = ",Integer> ";
  protected final String TEXT_1767 = " = new HashMap<";
  protected final String TEXT_1768 = ",Integer>();" + NL + "    for (";
  protected final String TEXT_1769 = " ";
  protected final String TEXT_1770 = " : ";
  protected final String TEXT_1771 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1772 = ".contains(";
  protected final String TEXT_1773 = "))" + NL + "      {";
  protected final String TEXT_1774 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1775 = ".";
  protected final String TEXT_1776 = "() != null && !this.equals(";
  protected final String TEXT_1777 = ".";
  protected final String TEXT_1778 = "()))" + NL + "      {";
  protected final String TEXT_1779 = NL + "        ";
  protected final String TEXT_1780 = " ";
  protected final String TEXT_1781 = " = ";
  protected final String TEXT_1782 = ".";
  protected final String TEXT_1783 = "();" + NL + "        if (!";
  protected final String TEXT_1784 = ".containsKey(";
  protected final String TEXT_1785 = "))" + NL + "        {";
  protected final String TEXT_1786 = NL + "          ";
  protected final String TEXT_1787 = ".put(";
  protected final String TEXT_1788 = ", new Integer(";
  protected final String TEXT_1789 = ".";
  protected final String TEXT_1790 = "()));" + NL + "        }" + NL + "        Integer currentCount = ";
  protected final String TEXT_1791 = ".get(";
  protected final String TEXT_1792 = ");" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_1793 = ")" + NL + "        {";
  protected final String TEXT_1794 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_1795 = NL + "        ";
  protected final String TEXT_1796 = ".put(";
  protected final String TEXT_1797 = ", new Integer(nextCount));" + NL + "      }";
  protected final String TEXT_1798 = NL + "      ";
  protected final String TEXT_1799 = ".add(";
  protected final String TEXT_1800 = ");" + NL + "    }" + NL;
  protected final String TEXT_1801 = NL + "    ";
  protected final String TEXT_1802 = ".removeAll(";
  protected final String TEXT_1803 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_1804 = " orphan : ";
  protected final String TEXT_1805 = ")" + NL + "    {";
  protected final String TEXT_1806 = NL + "      ";
  protected final String TEXT_1807 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1808 = NL + "    ";
  protected final String TEXT_1809 = ".clear();" + NL + "    for (";
  protected final String TEXT_1810 = " ";
  protected final String TEXT_1811 = " : ";
  protected final String TEXT_1812 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1813 = ".";
  protected final String TEXT_1814 = "() != null)" + NL + "      {";
  protected final String TEXT_1815 = NL + "        ";
  protected final String TEXT_1816 = ".";
  protected final String TEXT_1817 = "().";
  protected final String TEXT_1818 = ".remove(";
  protected final String TEXT_1819 = ");" + NL + "      }";
  protected final String TEXT_1820 = NL + "      ";
  protected final String TEXT_1821 = "(";
  protected final String TEXT_1822 = ", this);";
  protected final String TEXT_1823 = NL + "      ";
  protected final String TEXT_1824 = ".add(";
  protected final String TEXT_1825 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1826 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1827 = NL + "  private void ";
  protected final String TEXT_1828 = "(";
  protected final String TEXT_1829 = " ";
  protected final String TEXT_1830 = ", ";
  protected final String TEXT_1831 = " ";
  protected final String TEXT_1832 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1833 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1834 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1835 = ", ";
  protected final String TEXT_1836 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1837 = " to ";
  protected final String TEXT_1838 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1839 = NL + "  ";
  protected final String TEXT_1840 = " boolean ";
  protected final String TEXT_1841 = "(";
  protected final String TEXT_1842 = "... ";
  protected final String TEXT_1843 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1844 = NL + "    ArrayList<";
  protected final String TEXT_1845 = "> ";
  protected final String TEXT_1846 = " = new ArrayList<";
  protected final String TEXT_1847 = ">();" + NL + "    for (";
  protected final String TEXT_1848 = " ";
  protected final String TEXT_1849 = " : ";
  protected final String TEXT_1850 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1851 = ".contains(";
  protected final String TEXT_1852 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1853 = NL + "      ";
  protected final String TEXT_1854 = ".add(";
  protected final String TEXT_1855 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1856 = ".size() != ";
  protected final String TEXT_1857 = ".length || ";
  protected final String TEXT_1858 = ".size() > ";
  protected final String TEXT_1859 = "())" + NL + "    {";
  protected final String TEXT_1860 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1861 = NL + "    ";
  protected final String TEXT_1862 = ".clear();";
  protected final String TEXT_1863 = NL + "    ";
  protected final String TEXT_1864 = ".addAll(";
  protected final String TEXT_1865 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1866 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1867 = NL + "  ";
  protected final String TEXT_1868 = " boolean ";
  protected final String TEXT_1869 = "(";
  protected final String TEXT_1870 = "... ";
  protected final String TEXT_1871 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1872 = NL + "    ArrayList<";
  protected final String TEXT_1873 = "> ";
  protected final String TEXT_1874 = " = new ArrayList<";
  protected final String TEXT_1875 = ">();" + NL + "    for (";
  protected final String TEXT_1876 = " ";
  protected final String TEXT_1877 = " : ";
  protected final String TEXT_1878 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1879 = ".contains(";
  protected final String TEXT_1880 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1881 = NL + "      ";
  protected final String TEXT_1882 = ".add(";
  protected final String TEXT_1883 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1884 = ".size() != ";
  protected final String TEXT_1885 = ".length || ";
  protected final String TEXT_1886 = ".size() < ";
  protected final String TEXT_1887 = "())" + NL + "    {";
  protected final String TEXT_1888 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1889 = NL + "    ";
  protected final String TEXT_1890 = ".clear();";
  protected final String TEXT_1891 = NL + "    ";
  protected final String TEXT_1892 = ".addAll(";
  protected final String TEXT_1893 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1894 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1895 = NL + "  ";
  protected final String TEXT_1896 = NL + "  public boolean ";
  protected final String TEXT_1897 = "(";
  protected final String TEXT_1898 = " ";
  protected final String TEXT_1899 = ", int index)" + NL + "  {  " + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_1900 = "(";
  protected final String TEXT_1901 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_1902 = "()) { index = ";
  protected final String TEXT_1903 = "() - 1; }";
  protected final String TEXT_1904 = NL + "      ";
  protected final String TEXT_1905 = ".remove(";
  protected final String TEXT_1906 = ");";
  protected final String TEXT_1907 = NL + "      ";
  protected final String TEXT_1908 = ".add(index, ";
  protected final String TEXT_1909 = ");";
  protected final String TEXT_1910 = NL + "      wasAdded = true;" + NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1911 = "(";
  protected final String TEXT_1912 = " ";
  protected final String TEXT_1913 = ", int index)" + NL + "  {" + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_1914 = ".contains(";
  protected final String TEXT_1915 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_1916 = "()) { index = ";
  protected final String TEXT_1917 = "() - 1; }";
  protected final String TEXT_1918 = NL + "      ";
  protected final String TEXT_1919 = ".remove(";
  protected final String TEXT_1920 = ");";
  protected final String TEXT_1921 = NL + "      ";
  protected final String TEXT_1922 = ".add(index, ";
  protected final String TEXT_1923 = ");";
  protected final String TEXT_1924 = NL + "      wasAdded = true;" + NL + "    } " + NL + "    else " + NL + "    {";
  protected final String TEXT_1925 = NL + "      wasAdded = ";
  protected final String TEXT_1926 = "(";
  protected final String TEXT_1927 = ", index);";
  protected final String TEXT_1928 = NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL;
  protected final String TEXT_1929 = NL + "  public boolean equals(Object obj)" + NL + "  {" + NL + "    if (obj == null) { return false; }" + NL + "    if (!getClass().equals(obj.getClass())) { return false; }" + NL;
  protected final String TEXT_1930 = NL + "    ";
  protected final String TEXT_1931 = " compareTo = (";
  protected final String TEXT_1932 = ")obj;" + NL + "  ";
  protected final String TEXT_1933 = NL + "    ";
  protected final String TEXT_1934 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_1935 = NL + "    ";
  protected final String TEXT_1936 = NL;
  protected final String TEXT_1937 = NL + "    ";
  protected final String TEXT_1938 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1939 = NL + "  private void ";
  protected final String TEXT_1940 = "()" + NL + "  {" + NL + "    try" + NL + "    {";
  protected final String TEXT_1941 = NL + "      ";
  protected final String TEXT_1942 = NL + "      Thread.sleep(1);";
  protected final String TEXT_1943 = NL + "    }" + NL + "    catch (InterruptedException e)" + NL + "    {" + NL + "" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1944 = NL + "  private void ";
  protected final String TEXT_1945 = "()" + NL + "  {" + NL + "    try" + NL + "    {";
  protected final String TEXT_1946 = NL + "      ";
  protected final String TEXT_1947 = NL + "      Thread.sleep(1);";
  protected final String TEXT_1948 = NL + "    }" + NL + "    catch (InterruptedException e)" + NL + "    {" + NL + "" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1949 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1950 = NL + "    ";
  protected final String TEXT_1951 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1952 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_1953 = NL + "      ";
  protected final String TEXT_1954 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1955 = NL + "  private void ";
  protected final String TEXT_1956 = "()" + NL + "  {";
  protected final String TEXT_1957 = NL + "    ";
  protected final String TEXT_1958 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1959 = "\",";
  protected final String TEXT_1960 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1961 = "()" + NL + "  {";
  protected final String TEXT_1962 = NL + "    ";
  protected final String TEXT_1963 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1964 = NL + "  private void ";
  protected final String TEXT_1965 = "()" + NL + "  {";
  protected final String TEXT_1966 = NL + "    ";
  protected final String TEXT_1967 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1968 = "\",";
  protected final String TEXT_1969 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1970 = "()" + NL + "  {";
  protected final String TEXT_1971 = NL + "    ";
  protected final String TEXT_1972 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1973 = NL + "  private void ";
  protected final String TEXT_1974 = "()" + NL + "  {";
  protected final String TEXT_1975 = NL + "    ";
  protected final String TEXT_1976 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1977 = "\",";
  protected final String TEXT_1978 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1979 = "()" + NL + "  {";
  protected final String TEXT_1980 = NL + "    ";
  protected final String TEXT_1981 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1982 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1983 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1984 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void run ()" + NL + "    {";
  protected final String TEXT_1985 = NL + "      if (\"";
  protected final String TEXT_1986 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1987 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1988 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1989 = NL + "      if (\"";
  protected final String TEXT_1990 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1991 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1992 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1993 = NL + "      if (\"";
  protected final String TEXT_1994 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1995 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1996 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1997 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1998 = NL + "    ";
  protected final String TEXT_1999 = " = null;";
  protected final String TEXT_2000 = NL + "    ";
  protected final String TEXT_2001 = ".clear();";
  protected final String TEXT_2002 = NL + "    ";
  protected final String TEXT_2003 = " ";
  protected final String TEXT_2004 = " = ";
  protected final String TEXT_2005 = ";";
  protected final String TEXT_2006 = NL + "    ";
  protected final String TEXT_2007 = " = null;" + NL + "    if (";
  protected final String TEXT_2008 = " != null)" + NL + "    {";
  protected final String TEXT_2009 = NL + "      ";
  protected final String TEXT_2010 = ".delete();" + NL + "    }";
  protected final String TEXT_2011 = NL + "    if (";
  protected final String TEXT_2012 = " != null)" + NL + "    {";
  protected final String TEXT_2013 = NL + "      ";
  protected final String TEXT_2014 = ".";
  protected final String TEXT_2015 = "(null);" + NL + "    }";
  protected final String TEXT_2016 = NL + "    ";
  protected final String TEXT_2017 = " ";
  protected final String TEXT_2018 = " = ";
  protected final String TEXT_2019 = ";";
  protected final String TEXT_2020 = NL + "    ";
  protected final String TEXT_2021 = " = null;" + NL + "    if (";
  protected final String TEXT_2022 = " != null)" + NL + "    {";
  protected final String TEXT_2023 = NL + "      ";
  protected final String TEXT_2024 = ".";
  protected final String TEXT_2025 = "(null);" + NL + "    }";
  protected final String TEXT_2026 = NL + "    ";
  protected final String TEXT_2027 = " ";
  protected final String TEXT_2028 = " = ";
  protected final String TEXT_2029 = ";";
  protected final String TEXT_2030 = NL + "    ";
  protected final String TEXT_2031 = " = null;" + NL + "    if (";
  protected final String TEXT_2032 = " != null)" + NL + "    {";
  protected final String TEXT_2033 = NL + "      ";
  protected final String TEXT_2034 = ".delete();" + NL + "    }";
  protected final String TEXT_2035 = NL + "    if (";
  protected final String TEXT_2036 = " != null)" + NL + "    {";
  protected final String TEXT_2037 = NL + "      ";
  protected final String TEXT_2038 = " ";
  protected final String TEXT_2039 = " = ";
  protected final String TEXT_2040 = ";" + NL + "      this.";
  protected final String TEXT_2041 = " = null;";
  protected final String TEXT_2042 = NL + "      ";
  protected final String TEXT_2043 = ".";
  protected final String TEXT_2044 = "(this);" + NL + "    }";
  protected final String TEXT_2045 = NL + "    if (";
  protected final String TEXT_2046 = " != null)" + NL + "    {";
  protected final String TEXT_2047 = NL + "      ";
  protected final String TEXT_2048 = ".delete();" + NL + "    }";
  protected final String TEXT_2049 = NL + "    if (";
  protected final String TEXT_2050 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2051 = ".";
  protected final String TEXT_2052 = "() <= ";
  protected final String TEXT_2053 = ")" + NL + "      {";
  protected final String TEXT_2054 = NL + "        ";
  protected final String TEXT_2055 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2056 = NL + "        ";
  protected final String TEXT_2057 = " ";
  protected final String TEXT_2058 = " = ";
  protected final String TEXT_2059 = ";" + NL + "        this.";
  protected final String TEXT_2060 = " = null;";
  protected final String TEXT_2061 = NL + "        ";
  protected final String TEXT_2062 = ".";
  protected final String TEXT_2063 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2064 = NL + "    ";
  protected final String TEXT_2065 = " ";
  protected final String TEXT_2066 = " = ";
  protected final String TEXT_2067 = ";" + NL + "    this.";
  protected final String TEXT_2068 = " = null;";
  protected final String TEXT_2069 = NL + "    ";
  protected final String TEXT_2070 = ".";
  protected final String TEXT_2071 = "(this);";
  protected final String TEXT_2072 = NL + "    for(";
  protected final String TEXT_2073 = " ";
  protected final String TEXT_2074 = " : ";
  protected final String TEXT_2075 = ")" + NL + "    {";
  protected final String TEXT_2076 = NL + "      ";
  protected final String TEXT_2077 = "(";
  protected final String TEXT_2078 = ",null);" + NL + "    }";
  protected final String TEXT_2079 = NL + "    ";
  protected final String TEXT_2080 = ".clear();";
  protected final String TEXT_2081 = NL + "    ArrayList<";
  protected final String TEXT_2082 = "> ";
  protected final String TEXT_2083 = " = new ArrayList<";
  protected final String TEXT_2084 = ">(";
  protected final String TEXT_2085 = ");";
  protected final String TEXT_2086 = NL + "    ";
  protected final String TEXT_2087 = ".clear();" + NL + "    for(";
  protected final String TEXT_2088 = " ";
  protected final String TEXT_2089 = " : ";
  protected final String TEXT_2090 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2091 = ".";
  protected final String TEXT_2092 = "() <= ";
  protected final String TEXT_2093 = ".";
  protected final String TEXT_2094 = "())" + NL + "      {";
  protected final String TEXT_2095 = NL + "        ";
  protected final String TEXT_2096 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2097 = NL + "        ";
  protected final String TEXT_2098 = ".";
  protected final String TEXT_2099 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_2100 = NL + "    ArrayList<";
  protected final String TEXT_2101 = "> ";
  protected final String TEXT_2102 = " = new ArrayList<";
  protected final String TEXT_2103 = ">(";
  protected final String TEXT_2104 = ");";
  protected final String TEXT_2105 = NL + "    ";
  protected final String TEXT_2106 = ".clear();" + NL + "    for(";
  protected final String TEXT_2107 = " ";
  protected final String TEXT_2108 = " : ";
  protected final String TEXT_2109 = ")" + NL + "    {";
  protected final String TEXT_2110 = NL + "      ";
  protected final String TEXT_2111 = ".";
  protected final String TEXT_2112 = "(this);" + NL + "    }";
  protected final String TEXT_2113 = NL + "    for(int i=";
  protected final String TEXT_2114 = ".size(); i > 0; i--)" + NL + "    {";
  protected final String TEXT_2115 = NL + "      ";
  protected final String TEXT_2116 = " ";
  protected final String TEXT_2117 = " = ";
  protected final String TEXT_2118 = ".get(i - 1);";
  protected final String TEXT_2119 = NL + "      ";
  protected final String TEXT_2120 = ".delete();" + NL + "    }";
  protected final String TEXT_2121 = NL + "    while( !";
  protected final String TEXT_2122 = ".isEmpty() )" + NL + "    {";
  protected final String TEXT_2123 = NL + "      ";
  protected final String TEXT_2124 = ".get(0).";
  protected final String TEXT_2125 = "(null);" + NL + "    }";
  protected final String TEXT_2126 = NL + "  " + NL + "  @Override" + NL + "  public void run ()" + NL + "  {" + NL + "    boolean status=false;" + NL + "    while (true) " + NL + "    {" + NL;
  protected final String TEXT_2127 = NL + "      " + NL + "      switch (m.type)" + NL + "      {";
  protected final String TEXT_2128 = " " + NL + "        default:" + NL + "      }" + NL + "      if(!status)" + NL + "      {" + NL + "        // Error message is written or  exception is raised" + NL + "      }" + NL + "    }" + NL + "  }";
  protected final String TEXT_2129 = NL + "  " + NL + "  @Override" + NL + "  public void run ()" + NL + "  {" + NL + "    boolean status=false;" + NL + "    while (true) " + NL + "    {" + NL;
  protected final String TEXT_2130 = NL + "      " + NL + "      switch (m.type)" + NL + "      {";
  protected final String TEXT_2131 = " " + NL + "        default:" + NL + "      }" + NL + "      if(!status)" + NL + "      {" + NL + "        // Error message is written or  exception is raised" + NL + "      }" + NL + "    }" + NL + "  }";
  protected final String TEXT_2132 = NL + NL + "  public String toString()" + NL + "  {" + NL + "\t  String outputString = \"\";";
  protected final String TEXT_2133 = NL + "  }";
  protected final String TEXT_2134 = "  " + NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_2135 = NL + "  ";
  protected final String TEXT_2136 = NL + "  ";
  protected final String TEXT_2137 = NL + "}";
  protected final String TEXT_2138 = NL + "  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler" + NL + "  {" + NL + "    public void uncaughtException(Thread t, Throwable e)" + NL + "    {" + NL + "      translate(e);" + NL + "      if(e.getCause()!=null)" + NL + "      {" + NL + "        translate(e.getCause());" + NL + "      }" + NL + "      e.printStackTrace();" + NL + "    }" + NL + "    public void translate(Throwable e)" + NL + "    {" + NL + "      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();" + NL + "      StackTraceElement[] elements = e.getStackTrace();" + NL + "      try" + NL + "      {" + NL + "        for(StackTraceElement element:elements)" + NL + "        {" + NL + "          String className = element.getClassName();" + NL + "          String methodName = element.getMethodName();" + NL + "          boolean methodFound = false;" + NL + "          int index = className.lastIndexOf('.')+1;" + NL + "          try {" + NL + "            java.lang.reflect.Method query = this.getClass().getMethod(className.substring(index)+\"_\"+methodName,new Class[]{});" + NL + "            UmpleSourceData sourceInformation = (UmpleSourceData)query.invoke(this,new Object[]{});" + NL + "            for(int i=0;i<sourceInformation.size();++i)" + NL + "            {" + NL + "              int distanceFromStart = element.getLineNumber()-sourceInformation.getJavaLine(i)-((\"main\".equals(methodName))?2:0);" + NL + "              if(distanceFromStart>=0&&distanceFromStart<=sourceInformation.getLength(i))" + NL + "              {" + NL + "                result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),sourceInformation.getFileName(i),sourceInformation.getUmpleLine(i)+distanceFromStart));" + NL + "                methodFound = true;" + NL + "                break;" + NL + "              }" + NL + "            }" + NL + "          }" + NL + "          catch (Exception e2){}" + NL + "          if(!methodFound)" + NL + "          {" + NL + "            result.add(element);" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "      catch (Exception e1)" + NL + "      {" + NL + "        e1.printStackTrace();" + NL + "      }" + NL + "      e.setStackTrace(result.toArray(new StackTraceElement[0]));" + NL + "    }" + NL + "  //The following methods Map Java lines back to their original Umple file / line    ";
  protected final String TEXT_2139 = NL;
  protected final String TEXT_2140 = NL + "  }" + NL + "  public static class UmpleSourceData" + NL + "  {" + NL + "    String[] umpleFileNames;" + NL + "    Integer[] umpleLines;" + NL + "    Integer[] umpleJavaLines;" + NL + "    Integer[] umpleLengths;" + NL + "    " + NL + "    public UmpleSourceData(){" + NL + "    }" + NL + "    public String getFileName(int i){" + NL + "      return umpleFileNames[i];" + NL + "    }" + NL + "    public Integer getUmpleLine(int i){" + NL + "      return umpleLines[i];" + NL + "    }" + NL + "    public Integer getJavaLine(int i){" + NL + "      return umpleJavaLines[i];" + NL + "    }" + NL + "    public Integer getLength(int i){" + NL + "      return umpleLengths[i];" + NL + "    }" + NL + "    public UmpleSourceData setFileNames(String... filenames){" + NL + "      umpleFileNames = filenames;" + NL + "      return this;" + NL + "    }" + NL + "    public UmpleSourceData setUmpleLines(Integer... umplelines){" + NL + "      umpleLines = umplelines;" + NL + "      return this;" + NL + "    }" + NL + "    public UmpleSourceData setJavaLines(Integer... javalines){" + NL + "      umpleJavaLines = javalines;" + NL + "      return this;" + NL + "    }" + NL + "    public UmpleSourceData setLengths(Integer... lengths){" + NL + "      umpleLengths = lengths;" + NL + "      return this;" + NL + "    }" + NL + "    public int size(){" + NL + "      return umpleFileNames.length;" + NL + "    }" + NL + "  } " + NL + "}";

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
    append(stringBuffer, "\n  enum MessageType { {0} }", gen.translate("listEventsForPooledSM",uClass));
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
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
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

      if (av.getModifier().equals("defaulted")&&(customSetPrefixCode!=null&&customSetPostfixCode!=null)&&customSetPrefixCode.matches("[\\s]*if.*\\n[\\s]*.*"))
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
    stringBuffer.append(TEXT_234);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_235);
    
      }
      else if (av.getIsList()&&(customAddPrefixCode!=null&&customAddPostfixCode!=null)&&customAddPrefixCode.matches("[\\s]*if.*\\n[\\s]*.*"))
      {
        
    stringBuffer.append(TEXT_236);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_239);
     if (customAddPrefixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_a", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_242);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_a", uClass):""));
    stringBuffer.append(TEXT_243);
     if (customAddPostfixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customAddPostfixCode, "    "));
    } 
    stringBuffer.append(TEXT_244);
    
      }
      else if(customSetPrefixCode!=null&&customSetPostfixCode!=null&&customSetPrefixCode.matches("[\\s]*if.*\\n[\\s]*.*"))
      {
        
    stringBuffer.append(TEXT_245);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_248);
     if (customSetPrefixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_249);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_251);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
    stringBuffer.append(TEXT_252);
     if (customSetPostfixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_253);
    
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
      
    stringBuffer.append(TEXT_254);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_256);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_257);
    stringBuffer.append( gen.translate("typeMany",av));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_260);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_261);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av));
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_262);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_265);
     if (customGetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPrefixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_266);
    stringBuffer.append( gen.translate("typeMany",av));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_271);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_ga", uClass):""));
    stringBuffer.append(TEXT_272);
     if (customGetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPostfixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_275);
     if (customNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPrefixCode,gen.translate("numberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_277);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_n", uClass, "number"):""));
    stringBuffer.append(TEXT_278);
     if (customNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPostfixCode,gen.translate("numberOfMethod",av));
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_279);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_280);
     if (customHasManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPrefixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_281);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_282);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_h", uClass):""));
    stringBuffer.append(TEXT_283);
     if (customHasManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPostfixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); }
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_287);
     if (customIndexOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPrefixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_288);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_290);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_291);
     if (customIndexOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPostfixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_292);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_294);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_295);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_296);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_297);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_298);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_299);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_300);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av));
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_301);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_302);
    addUncaughtExceptionVariables(gen.translate("getMethod",av),av.getPosition().getFilename(),av.getPosition().getLineNumber(),stringBuffer.toString().split("\\n").length-1,1);
    stringBuffer.append(TEXT_303);
    
      }
      else if (av.getIsDerived())
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_305);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_306);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_307);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_308);
    addUncaughtExceptionVariables(gen.translate("getMethod",av),av.getPosition().getFilename(),av.getPosition().getLineNumber(),stringBuffer.toString().split("\\n").length-1,1);
    stringBuffer.append(TEXT_309);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_311);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_312);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_313);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_314);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_316);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_317);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_318);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_319);
    
      }
      else
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_321);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_322);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_324);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_327);
     if (customGetDefaultPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getDefaultMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_328);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_330);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_331);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_332);
     if (customGetDefaultPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetDefaultPostfixCode,gen.translate("getDefaultMethod",av));
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_334);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_337);
     if (customGetDefaultPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_338);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_339);
    
      }
      
      if (av.getIsUnique())
      {
        if (customGetUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_340);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_344);
     if (customGetUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetUniquePrefixCode,gen.translate("getUniqueMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_345);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_349);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_350);
     if (customGetUniquePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetUniquePostfixCode,gen.translate("getUniqueMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetUniquePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_352);
    
        } 
        else 
        {
          
    stringBuffer.append(TEXT_353);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_357);
     if (customGetUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetUniquePrefixCode,gen.translate("getUniqueMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_360);
    
        }
        if (customHasUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_364);
     if (customHasUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasUniquePrefixCode,gen.translate("hasUniqueMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_368);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_369);
     if (customHasUniquePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasUniquePostfixCode,gen.translate("hasUniqueMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasUniquePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_370);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_371);
    
        }
        else
        {
          
    stringBuffer.append(TEXT_372);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("type", av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_375);
     if (customHasUniquePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasUniquePrefixCode,gen.translate("hasUniqueMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_378);
    
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
        
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_380);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_381);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_382);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_383);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_385);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_386);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_387);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_388);
    
      }
      else
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_390);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_391);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_393);
    
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
      
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_395);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_396);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_397);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_398);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_399);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_400);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_401);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("isMethod",av));   
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); }
    stringBuffer.append(TEXT_402);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_403);
    
    }
    else if (av.getIsDerived())
    {
      
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_405);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_406);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("parameterValue",av));
    stringBuffer.append(TEXT_408);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_409);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_410);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_411);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_412);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_413);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_414);
    stringBuffer.append( gen.translate("attributeOne",av) );
    stringBuffer.append(TEXT_415);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_416);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_417);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_418);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_421);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("isMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index"):""));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_423);
    
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

    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_427);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_428);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_431);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_432);
    
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
    stringBuffer.append(TEXT_433);
    stringBuffer.append( scope );
    stringBuffer.append(TEXT_434);
    for (StateMachine sm : uClass.getStateMachines()){if((sm.isQueued() && e.getIsInternal() == false && e.isAutoTransition() == false && !e.isUnspecified()) || (sm.isPooled() && e.getIsInternal() == false && e.isAutoTransition() == false && !e.isUnspecified())){append(stringBuffer,"_");}break;}
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_435);
    stringBuffer.append( (e.getArgs()==null?"":e.getArgs()));
    if(e.isUnspecified()){append(stringBuffer,"String state, String event");}
    stringBuffer.append(TEXT_436);
     if (customEventPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customEventPrefixCode,gen.translate("eventMethod",e));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customEventPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_437);
    stringBuffer.append(TEXT_438);
    stringBuffer.append( eventOutput );
     if (customEventPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customEventPostfixCode,gen.translate("eventMethod",e)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customEventPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_439);
    
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

    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_441);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_442);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_443);
     if (!exitCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",exitCasesOutput); } 
     if (!enterCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",enterCasesOutput); } 
    stringBuffer.append(TEXT_444);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_445);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_446);
    
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
  
    stringBuffer.append(TEXT_447);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_448);
     if (customExitPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customExitPrefixCode,gen.translate("exitMethod",sm));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_449);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(TEXT_451);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_452);
     if (customExitPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customExitPostfixCode,gen.translate("exitMethod",sm)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_453);
     
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
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_455);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_456);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_457);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",sm)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_458);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_459);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_460);
     if (parentState != null) { 
    stringBuffer.append(TEXT_461);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_462);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_463);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_464);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_465);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_466);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_468);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_469);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_470);
     } 
     if (customSetPostfixCode != null) {  addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",sm));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_471);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(TEXT_473);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_474);
     } 
     if (parentState != null) { 
     if (sm.getContainsDeepHistoryState()) { 
    stringBuffer.append(TEXT_475);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_476);
    stringBuffer.append( gen.translate("type",sm)  );
    stringBuffer.append(TEXT_477);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_478);
    stringBuffer.append( gen.translate("stateMachineOne", sm) );
    stringBuffer.append(TEXT_479);
     } 
     } 
    stringBuffer.append(TEXT_480);
    
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
      
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_483);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("associationOne",av)):"")
);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_485);
     } else { 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPre()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("associationOne",av)):"")
);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_489);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPost()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("parameterOne",av)):"")
);
     addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_491);
     } 
    stringBuffer.append(TEXT_492);
     
  if(av.getMultiplicity().getLowerBound() == 0) {
  
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.translate("hasMethod",av));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_495);
     } 
    stringBuffer.append(TEXT_496);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_499);
     if (customGetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPrefixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPre()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("associationMany",av)+".get(index)"):"")
);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_503);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( 
(traceItem!=null&&traceItem.getIsPost()?"\n"+traceItem.trace(gen, av,"as_g", uClass,gen.translate("parameterOne",av)):"")
);
     if (customGetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetPostfixCode,gen.translate("getMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_505);
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_508);
     if (customGetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPrefixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_512);
     if (customGetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customGetManyPostfixCode,gen.translate("getManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_515);
     if (customNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPrefixCode,gen.translate("numberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_517);
     if (customNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customNumberOfPostfixCode,gen.translate("numberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_519);
     if (customHasManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPrefixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_521);
     if (customHasManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customHasManyPostfixCode,gen.translate("hasManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_525);
     if (customIndexOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPrefixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_528);
     if (customIndexOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIndexOfPostfixCode,gen.translate("indexOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_529);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_530);
    
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
      
    stringBuffer.append(TEXT_531);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_532);
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
      
    
      
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_534);
     if (customIsNumberOfValidPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPrefixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_537);
     } else { 
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_542);
     } 
     if (customIsNumberOfValidPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPostfixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_543);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_546);
     } else { 
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_548);
     if (customRequiredNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPrefixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_549);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_550);
     if (customRequiredNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPostfixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_551);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));
    
     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_554);
     } else { 
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_556);
     if (customMinimumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPrefixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_557);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_558);
     if (customMinimumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPostfixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_559);
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
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_562);
     } else { 
    stringBuffer.append(umpleSourceFile);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_564);
     if (customMaximumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPrefixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_565);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_566);
     if (customMaximumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPostfixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_567);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_571);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_574);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_575);
     } 
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_578);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_586);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_587);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_591);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append(
    (traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
    );
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_594);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av));
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_606);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append(
    (traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
    );
    stringBuffer.append(TEXT_607);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_608);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_612);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_615);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_616);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_617);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_621);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_626);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_627);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_631);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_639);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_640);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_658);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append(
    (traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,"1"):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_659);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_663);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_668);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_678);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_679);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_690);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_693);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append(
    (traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,"1"):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_694);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_703);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_708);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_720);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_728);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_729);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_733);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_738);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_743);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_744);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_748);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_749);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_750);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_761);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_764);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_765);
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
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_777);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_778);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_786);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_787);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_791);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_796);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_801);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_802);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_805);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_806);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_807);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_818);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_821);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_822);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_828);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_830);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_838);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_839);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_843);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_851);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_852);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_856);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_872);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_899);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_900);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_909);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_917);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_922);
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_925);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_926);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_930);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_935);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_938);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_939);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_940);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_944);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_958);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_959);
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_981);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append(
    (traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,"1"):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_982);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_986);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_989);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_992);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_995);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_997);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1005);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1006);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1010);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1013);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1016);
     if (customRemovePostfixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1019);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1021);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1029);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1030);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1034);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1040);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1058);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1059);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1063);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1065);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1082);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1083);
    
    }
    else if (includeFile == "association_SetOneToManyAssociationClass.jet")
    {
      
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1087);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1089);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1108);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1109);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1113);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1117);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1124);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1140);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1144);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1145);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1149);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1153);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av));
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1159);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1175);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1179);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1180);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1184);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1189);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1205);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1206);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1210);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1213);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1219);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1220);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1221);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1225);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1242);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1243);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1247);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1250);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1256);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1272);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1273);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1277);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1280);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1283);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1286);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1287);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1291);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1294);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1297);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1298);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1302);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1305);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1308);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1309);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1313);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1314);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1315);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1319);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1322);
     if (customAddPostfixCode != null) {addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1323);
     } 
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1332);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1338);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1341);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1344);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1348);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1353);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1356);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1359);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1360);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1364);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1373);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1378);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1384);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1403);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1416);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1420);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1423);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1424);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1428);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1431);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1434);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1435);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1436);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1440);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1443);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1446);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1447);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(TEXT_1449);
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1453);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
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
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1459);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1460);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1461);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1465);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1468);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1469);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1473);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1476);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1479);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1480);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1484);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1485);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1486);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1487);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1491);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("parameterOne",av));
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
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1513);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
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
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1533);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1539);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1540);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
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
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1599);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1612);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1617);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1625);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1629);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1632);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1647);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1673);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1674);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1675);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1677);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1678);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1679);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1682);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1687);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1688);
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1692);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1695);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1696);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1698);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(TEXT_1701);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1703);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1704);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1705);
    stringBuffer.append(TEXT_1706);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1707);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1708);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1709);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1710);
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1713);
    stringBuffer.append(TEXT_1714);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1716);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1718);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1719);
    stringBuffer.append(TEXT_1720);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1721);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1722);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1723);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1724);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1725);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1726);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1727);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1728);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1730);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1731);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1732);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1733);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1735);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1736);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1737);
    stringBuffer.append(TEXT_1738);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1739);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1740);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1741);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1742);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1743);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1744);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1745);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1746);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1747);
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1749);
    stringBuffer.append(TEXT_1750);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1751);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1752);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1753);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1754);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1755);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1756);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1757);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1758);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1759);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1760);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1761);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1762);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1763);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1764);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1765);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1766);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1767);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1768);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1769);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1770);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1771);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1772);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1773);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1774);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1775);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1776);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1777);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1778);
    stringBuffer.append(TEXT_1779);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1780);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1781);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1782);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1783);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1784);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1785);
    stringBuffer.append(TEXT_1786);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1787);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1788);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1789);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1790);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1791);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1792);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1793);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_1794);
    stringBuffer.append(TEXT_1795);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1796);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1797);
    stringBuffer.append(TEXT_1798);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1799);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1800);
    stringBuffer.append(TEXT_1801);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1802);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1803);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1804);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1805);
    stringBuffer.append(TEXT_1806);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1807);
    stringBuffer.append(TEXT_1808);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1809);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1810);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1811);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1812);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1813);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1814);
    stringBuffer.append(TEXT_1815);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1816);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1817);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1818);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1819);
    stringBuffer.append(TEXT_1820);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1821);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1822);
    stringBuffer.append(TEXT_1823);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1824);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1825);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1826);
    stringBuffer.append(TEXT_1827);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1828);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1829);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1830);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1831);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1832);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1833);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1834);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1835);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1836);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1837);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1838);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1839);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1840);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1841);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1842);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1843);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1844);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1845);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1846);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1847);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1848);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1849);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1850);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1851);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1852);
    stringBuffer.append(TEXT_1853);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1854);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1855);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1856);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1857);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1858);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1859);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1860);
    stringBuffer.append(TEXT_1861);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1862);
    stringBuffer.append(TEXT_1863);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1864);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1865);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1866);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1867);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1868);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1869);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1870);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1871);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1872);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1873);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1874);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1875);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1876);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1877);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1878);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1879);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1880);
    stringBuffer.append(TEXT_1881);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1882);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1883);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1884);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1885);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1886);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1887);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1888);
    stringBuffer.append(TEXT_1889);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1890);
    stringBuffer.append(TEXT_1891);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1892);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1893);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1894);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
    }
    
    if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
    {
      
    stringBuffer.append(TEXT_1895);
    
      sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
    }
    else if(includeFile3 == "association_AddIndexControlFunctions.jet")
    {
      
    stringBuffer.append(TEXT_1896);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1897);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1898);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1899);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1900);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1901);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1902);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1903);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1904);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1905);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1906);
    stringBuffer.append(TEXT_1907);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1908);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1909);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1910);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_1911);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1912);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1913);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1914);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1915);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1916);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1917);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1918);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1919);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1920);
    stringBuffer.append(TEXT_1921);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1922);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1923);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1924);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1925);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1926);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1927);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1928);
    
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


    stringBuffer.append(TEXT_1929);
    stringBuffer.append(TEXT_1930);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1931);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1932);
    stringBuffer.append(TEXT_1933);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1934);
    stringBuffer.append(TEXT_1935);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1936);
    stringBuffer.append(TEXT_1937);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1938);
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
    stringBuffer.append(TEXT_1939);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1940);
    stringBuffer.append(TEXT_1941);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1942);
     if (postTransition != null) { append(stringBuffer, "\n      {0}();",postTransition); } 
    stringBuffer.append(TEXT_1943);
    
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
    stringBuffer.append(TEXT_1944);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1945);
    stringBuffer.append(TEXT_1946);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1947);
     if (postTransition != null) { append(stringBuffer, "\n      {0}();",postTransition); } 
    stringBuffer.append(TEXT_1948);
    
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

    stringBuffer.append(TEXT_1949);
    stringBuffer.append(TEXT_1950);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1951);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1952);
    stringBuffer.append(TEXT_1953);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1954);
    
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
          
    stringBuffer.append(TEXT_1955);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1956);
    stringBuffer.append(TEXT_1957);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1958);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1959);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1960);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1961);
    stringBuffer.append(TEXT_1962);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1963);
    
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
          
    stringBuffer.append(TEXT_1964);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1965);
    stringBuffer.append(TEXT_1966);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1967);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1968);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1969);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1970);
    stringBuffer.append(TEXT_1971);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1972);
    
        }
      }
      for(StateMachine nsm : sm.getNestedStateMachines())
      {
        for(Event event : nsm.getEvents())
        {
          if(event.getIsTimer())
          {
            hasTimedEvents_NestedStates = true;
            
    stringBuffer.append(TEXT_1973);
    stringBuffer.append(gen.translate("eventStartMethod",event) );
    stringBuffer.append(TEXT_1974);
    stringBuffer.append(TEXT_1975);
    stringBuffer.append( gen.translate("eventHandler", event) );
    stringBuffer.append(TEXT_1976);
    stringBuffer.append( gen.translate("eventMethod",event) );
    stringBuffer.append(TEXT_1977);
    stringBuffer.append( event.getTimerInSeconds() );
    stringBuffer.append(TEXT_1978);
    stringBuffer.append(gen.translate("eventStopMethod",event) );
    stringBuffer.append(TEXT_1979);
    stringBuffer.append(TEXT_1980);
    stringBuffer.append( gen.translate("eventHandler",event) );
    stringBuffer.append(TEXT_1981);
    
          }
        }
      }
    }
  }
  if (hasTimedEvents || hasTimedEvents_NestedStates)
  {
    
    
 


    stringBuffer.append(TEXT_1982);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1983);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1984);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    if(sm.getNestedStateMachines().isEmpty())
    {
      for (Event e : sm.getEvents())
      {
        if (e.getIsTimer())
        {
          
    stringBuffer.append(TEXT_1985);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1986);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1987);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1988);
    
        }
      }
    }
    else if(!sm.getNestedStateMachines().isEmpty())
    {
      for (Event e : sm.getEvents())
      {
        if (e.getIsTimer())
        {
          
    stringBuffer.append(TEXT_1989);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1990);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1991);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1992);
    
        }
      }
      for(StateMachine nsm : sm.getNestedStateMachines())
      {
        for(Event event : nsm.getEvents())
        {
          if(event.getIsTimer())
          {
            
    stringBuffer.append(TEXT_1993);
    stringBuffer.append( gen.translate("eventMethod",event) );
    stringBuffer.append(TEXT_1994);
    stringBuffer.append( gen.translate("eventMethod",event) );
    stringBuffer.append(TEXT_1995);
    stringBuffer.append( gen.translate("eventStartMethod",event) );
    stringBuffer.append(TEXT_1996);
    
          }
        }
      }
    }
  }

    stringBuffer.append(TEXT_1997);
    
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
        
    stringBuffer.append(TEXT_1998);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1999);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_2000);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2001);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_2002);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2003);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2004);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2005);
    stringBuffer.append(TEXT_2006);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2007);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2008);
    stringBuffer.append(TEXT_2009);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2010);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2011);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2012);
    stringBuffer.append(TEXT_2013);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2014);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2015);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2016);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2017);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2018);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2019);
    stringBuffer.append(TEXT_2020);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2021);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2022);
    stringBuffer.append(TEXT_2023);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2024);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2025);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_2026);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2027);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2028);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2029);
    stringBuffer.append(TEXT_2030);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2031);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2032);
    stringBuffer.append(TEXT_2033);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2034);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_2035);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2036);
    stringBuffer.append(TEXT_2037);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2038);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2039);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2040);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2041);
    stringBuffer.append(TEXT_2042);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2043);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2044);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_2045);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2046);
    stringBuffer.append(TEXT_2047);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2048);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_2049);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2050);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2051);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2052);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_2053);
    stringBuffer.append(TEXT_2054);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2055);
    stringBuffer.append(TEXT_2056);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2057);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2058);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2059);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2060);
    stringBuffer.append(TEXT_2061);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2062);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2063);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2064);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2065);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2066);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2067);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2068);
    stringBuffer.append(TEXT_2069);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_2070);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2071);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2072);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2073);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2074);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2075);
    stringBuffer.append(TEXT_2076);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2077);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2078);
    stringBuffer.append(TEXT_2079);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2080);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_2081);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2082);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2083);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2084);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2085);
    stringBuffer.append(TEXT_2086);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2087);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2088);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2089);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2090);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2091);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2092);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2093);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2094);
    stringBuffer.append(TEXT_2095);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2096);
    stringBuffer.append(TEXT_2097);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2098);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2099);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_2100);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2101);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2102);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2103);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2104);
    stringBuffer.append(TEXT_2105);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2106);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2107);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2108);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_2109);
    stringBuffer.append(TEXT_2110);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2111);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2112);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_2113);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2114);
    stringBuffer.append(TEXT_2115);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2116);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2117);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2118);
    stringBuffer.append(TEXT_2119);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2120);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_2121);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2122);
    stringBuffer.append(TEXT_2123);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2124);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2125);
    
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

    stringBuffer.append(TEXT_2126);
    
      if(smq.isPooled())
      {
        append(stringBuffer,"      Message m = pool.getNext();");
      }
      if(smq.isQueued())
      {
        append(stringBuffer,"      Message m = queue.getNext();");
      }
      
    stringBuffer.append(TEXT_2127);
     
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
           
    stringBuffer.append(TEXT_2128);
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

    stringBuffer.append(TEXT_2129);
    
      if(smq.isPooled())
      {
        append(stringBuffer,"      Message m = pool.getNext();");
      }
      if(smq.isQueued())
      {
        append(stringBuffer,"      Message m = queue.getNext();");
      }
      
    stringBuffer.append(TEXT_2130);
     
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
           
    stringBuffer.append(TEXT_2131);
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
                    
          append(stringBuffer,positionHeader);
          append(stringBuffer,override);
          append(stringBuffer, "{5}  {0}{1} {2} {3}({4})", methodModifier, methodImplementationModifier, methodType, methodName, finalParams, positionHeader);
        
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
          append(stringBuffer, "{5}  {0}{1} {2} {3}({4})", methodModifier, methodImplementationModifier, methodType, methodName, finalParams, positionHeader);
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
          
          addUncaughtExceptionVariables(methodName,p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/",""),p.getLineNumber(),javaline,stringBuffer.toString().split("\\n").length+1-javaline);
          String traceCode = "";
          if(properMethodBody.contains("return"))
          {
          for( TraceItem traceItem : traceItems )traceCode += (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, aMethod,"me_x", uClass):"");
            properMethodBody = properMethodBody.replaceAll("return", traceCode + "return");
          }
          appendln(stringBuffer, properMethodBody);
          if(!properMethodBody.contains("return"))
          {
            for( TraceItem traceItem : traceItems )append(stringBuffer, (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, aMethod,"me_x", uClass):""));
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
    stringBuffer.append(TEXT_2132);
    
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
	  
    stringBuffer.append(TEXT_2133);
     } 
    return stringBuffer.toString();
    } 
    private String getAllExtraCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
     
  boolean isMainClass = false;
  if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_2134);
    stringBuffer.append(TEXT_2135);
    stringBuffer.append(uClass.getExtraCode());
    stringBuffer.append(TEXT_2136);
     } 
    if(uClass!=mainMainClass){
    stringBuffer.append(TEXT_2137);
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
    stringBuffer.append(TEXT_2138);
    stringBuffer.append(TEXT_2139);
    stringBuffer.append(exceptions);
    stringBuffer.append(TEXT_2140);
    
  return stringBuffer.toString();
}
    

public String endAll(String stringBuffer)
{
  GeneratorHelper.generator = null;

    return stringBuffer.toString();
  }
}