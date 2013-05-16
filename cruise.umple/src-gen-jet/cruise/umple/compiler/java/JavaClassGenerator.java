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
  protected final String TEXT_1 = "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "// line ";
  protected final String TEXT_6 = " \"";
  protected final String TEXT_7 = "\"";
  protected final String TEXT_8 = NL + "public ";
  protected final String TEXT_9 = "class ";
  protected final String TEXT_10 = NL + "{" + NL + "  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)" + NL + "  public @interface umplesourcefile{int line();String file();int javaline();int length();}";
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
  protected final String TEXT_39 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_40 = " due to ";
  protected final String TEXT_41 = "\");" + NL + "    }";
  protected final String TEXT_42 = NL + "    ";
  protected final String TEXT_43 = " = new ArrayList<";
  protected final String TEXT_44 = ">();" + NL + "    boolean ";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = "(";
  protected final String TEXT_47 = ");" + NL + "    if (!";
  protected final String TEXT_48 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_49 = ", must have ";
  protected final String TEXT_50 = " ";
  protected final String TEXT_51 = "\");" + NL + "    }";
  protected final String TEXT_52 = NL + "    ";
  protected final String TEXT_53 = " = new ArrayList<";
  protected final String TEXT_54 = ">();" + NL + "    boolean ";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = "(";
  protected final String TEXT_57 = ");" + NL + "    if (!";
  protected final String TEXT_58 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_59 = ", must have ";
  protected final String TEXT_60 = " or fewer ";
  protected final String TEXT_61 = ", no duplicates.\");" + NL + "    }";
  protected final String TEXT_62 = NL + "    ";
  protected final String TEXT_63 = " = new ArrayList<";
  protected final String TEXT_64 = ">();" + NL + "    boolean ";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = ");" + NL + "    if (!";
  protected final String TEXT_68 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_69 = ", must not have duplicate ";
  protected final String TEXT_70 = ".\");" + NL + "    }";
  protected final String TEXT_71 = NL + "    ";
  protected final String TEXT_72 = " = new ArrayList<";
  protected final String TEXT_73 = ">();";
  protected final String TEXT_74 = NL + "    if (";
  protected final String TEXT_75 = " == null || ";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = "() != null)" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_78 = " due to ";
  protected final String TEXT_79 = "\");" + NL + "    }";
  protected final String TEXT_80 = NL + "    ";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = NL + "    ";
  protected final String TEXT_84 = " = new ArrayList<";
  protected final String TEXT_85 = ">();";
  protected final String TEXT_86 = NL + "    boolean ";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = "(";
  protected final String TEXT_89 = ");" + NL + "    if (!";
  protected final String TEXT_90 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_91 = " due to ";
  protected final String TEXT_92 = "\");" + NL + "    }";
  protected final String TEXT_93 = NL + "    ";
  protected final String TEXT_94 = " = new ArrayList<";
  protected final String TEXT_95 = ">();" + NL + "    boolean ";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = "(";
  protected final String TEXT_98 = ");" + NL + "    if (!";
  protected final String TEXT_99 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_100 = ", must have ";
  protected final String TEXT_101 = " ";
  protected final String TEXT_102 = "\");" + NL + "    }";
  protected final String TEXT_103 = " = new ArrayList<";
  protected final String TEXT_104 = ">();";
  protected final String TEXT_105 = NL + "    ";
  protected final String TEXT_106 = ".add(";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "    ";
  protected final String TEXT_109 = "(";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "    ";
  protected final String TEXT_113 = "(";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "  public static ";
  protected final String TEXT_117 = " getInstance()" + NL + "  {" + NL + "    if(theInstance == null)" + NL + "    {" + NL + "      theInstance = new ";
  protected final String TEXT_118 = "();" + NL + "    }" + NL + "    return theInstance;" + NL + "  }";
  protected final String TEXT_119 = NL + NL + "  public ";
  protected final String TEXT_120 = "(";
  protected final String TEXT_121 = ")" + NL + "  {";
  protected final String TEXT_122 = NL + "    ";
  protected final String TEXT_123 = " = new ArrayList<";
  protected final String TEXT_124 = ">();";
  protected final String TEXT_125 = NL + "    ";
  protected final String TEXT_126 = "();";
  protected final String TEXT_127 = NL + "    ";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = ";";
  protected final String TEXT_130 = NL + "    ";
  protected final String TEXT_131 = " = ";
  protected final String TEXT_132 = "++;";
  protected final String TEXT_133 = NL + "    ";
  protected final String TEXT_134 = " = new ";
  protected final String TEXT_135 = "(";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "    ";
  protected final String TEXT_138 = " = new ArrayList<";
  protected final String TEXT_139 = ">();";
  protected final String TEXT_140 = NL + "    boolean ";
  protected final String TEXT_141 = " = ";
  protected final String TEXT_142 = "(";
  protected final String TEXT_143 = ");" + NL + "    if (!";
  protected final String TEXT_144 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_145 = " due to ";
  protected final String TEXT_146 = "\");" + NL + "    }";
  protected final String TEXT_147 = NL + "    ";
  protected final String TEXT_148 = " = new ArrayList<";
  protected final String TEXT_149 = ">();" + NL + "    boolean ";
  protected final String TEXT_150 = " = ";
  protected final String TEXT_151 = "(";
  protected final String TEXT_152 = ");" + NL + "    if (!";
  protected final String TEXT_153 = ")" + NL + "    {" + NL + "      throw new RuntimeException(\"Unable to create ";
  protected final String TEXT_154 = ", must have ";
  protected final String TEXT_155 = " ";
  protected final String TEXT_156 = "\");" + NL + "    }";
  protected final String TEXT_157 = " = new ArrayList<";
  protected final String TEXT_158 = ">();";
  protected final String TEXT_159 = NL + "    ";
  protected final String TEXT_160 = ".add(";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_163 = NL + "  public boolean ";
  protected final String TEXT_164 = "(";
  protected final String TEXT_165 = " ";
  protected final String TEXT_166 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_167 = NL + "    ";
  protected final String TEXT_168 = " = false;";
  protected final String TEXT_169 = NL;
  protected final String TEXT_170 = "    ";
  protected final String TEXT_171 = " = ";
  protected final String TEXT_172 = ";";
  protected final String TEXT_173 = NL;
  protected final String TEXT_174 = "    wasSet = true;";
  protected final String TEXT_175 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_176 = NL + "  public boolean ";
  protected final String TEXT_177 = "(";
  protected final String TEXT_178 = " ";
  protected final String TEXT_179 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_180 = NL;
  protected final String TEXT_181 = "    ";
  protected final String TEXT_182 = " = ";
  protected final String TEXT_183 = ";";
  protected final String TEXT_184 = NL;
  protected final String TEXT_185 = "    wasSet = true;";
  protected final String TEXT_186 = NL + "    return wasSet;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_187 = "()" + NL + "  {" + NL + "    boolean wasReset = false;";
  protected final String TEXT_188 = NL;
  protected final String TEXT_189 = "    ";
  protected final String TEXT_190 = " = ";
  protected final String TEXT_191 = "();";
  protected final String TEXT_192 = NL;
  protected final String TEXT_193 = "    wasReset = true;";
  protected final String TEXT_194 = NL + "    return wasReset;" + NL + "  }" + NL;
  protected final String TEXT_195 = NL + "  public boolean ";
  protected final String TEXT_196 = "(";
  protected final String TEXT_197 = " ";
  protected final String TEXT_198 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_199 = NL;
  protected final String TEXT_200 = "    wasAdded = ";
  protected final String TEXT_201 = ".add(";
  protected final String TEXT_202 = ");";
  protected final String TEXT_203 = NL;
  protected final String TEXT_204 = "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_205 = "(";
  protected final String TEXT_206 = " ";
  protected final String TEXT_207 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_208 = NL;
  protected final String TEXT_209 = "    wasRemoved = ";
  protected final String TEXT_210 = ".remove(";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL;
  protected final String TEXT_213 = "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_214 = NL + "  public boolean ";
  protected final String TEXT_215 = "(";
  protected final String TEXT_216 = " ";
  protected final String TEXT_217 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_218 = NL;
  protected final String TEXT_219 = "    ";
  protected final String TEXT_220 = " = ";
  protected final String TEXT_221 = ";";
  protected final String TEXT_222 = NL;
  protected final String TEXT_223 = "    wasSet = true;";
  protected final String TEXT_224 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_225 = NL + "  public ";
  protected final String TEXT_226 = " ";
  protected final String TEXT_227 = "(int index)" + NL + "  {";
  protected final String TEXT_228 = NL + "    ";
  protected final String TEXT_229 = " ";
  protected final String TEXT_230 = " = ";
  protected final String TEXT_231 = ".get(index);";
  protected final String TEXT_232 = NL;
  protected final String TEXT_233 = "    return ";
  protected final String TEXT_234 = ";" + NL + "  }" + NL + "" + NL + "  public ";
  protected final String TEXT_235 = "[] ";
  protected final String TEXT_236 = "()" + NL + "  {";
  protected final String TEXT_237 = NL + "    ";
  protected final String TEXT_238 = "[] ";
  protected final String TEXT_239 = " = ";
  protected final String TEXT_240 = ".toArray(new ";
  protected final String TEXT_241 = "[";
  protected final String TEXT_242 = ".size()]);";
  protected final String TEXT_243 = NL;
  protected final String TEXT_244 = "    return ";
  protected final String TEXT_245 = ";" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_246 = "()" + NL + "  {";
  protected final String TEXT_247 = NL + "    int number = ";
  protected final String TEXT_248 = ".size();";
  protected final String TEXT_249 = NL;
  protected final String TEXT_250 = "    return number;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_251 = "()" + NL + "  {";
  protected final String TEXT_252 = NL + "    boolean has = ";
  protected final String TEXT_253 = ".size() > 0;";
  protected final String TEXT_254 = NL;
  protected final String TEXT_255 = "    return has;" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_256 = "(";
  protected final String TEXT_257 = " ";
  protected final String TEXT_258 = ")" + NL + "  {";
  protected final String TEXT_259 = NL + "    int index = ";
  protected final String TEXT_260 = ".indexOf(";
  protected final String TEXT_261 = ");";
  protected final String TEXT_262 = NL;
  protected final String TEXT_263 = "    return index;" + NL + "  }" + NL;
  protected final String TEXT_264 = NL + "  public ";
  protected final String TEXT_265 = " ";
  protected final String TEXT_266 = "()" + NL + "  {";
  protected final String TEXT_267 = NL + "    ";
  protected final String TEXT_268 = " ";
  protected final String TEXT_269 = " = ";
  protected final String TEXT_270 = ";";
  protected final String TEXT_271 = NL;
  protected final String TEXT_272 = "    return ";
  protected final String TEXT_273 = ";" + NL + "  }";
  protected final String TEXT_274 = NL + "  public ";
  protected final String TEXT_275 = " ";
  protected final String TEXT_276 = "()" + NL + "  {";
  protected final String TEXT_277 = NL;
  protected final String TEXT_278 = "    return ";
  protected final String TEXT_279 = ";" + NL + "  }";
  protected final String TEXT_280 = NL + "  public ";
  protected final String TEXT_281 = " ";
  protected final String TEXT_282 = "()" + NL + "  {";
  protected final String TEXT_283 = NL + "    ";
  protected final String TEXT_284 = " ";
  protected final String TEXT_285 = " = ";
  protected final String TEXT_286 = ";";
  protected final String TEXT_287 = NL;
  protected final String TEXT_288 = "    return ";
  protected final String TEXT_289 = ";" + NL + "  }";
  protected final String TEXT_290 = NL + "  public ";
  protected final String TEXT_291 = " ";
  protected final String TEXT_292 = "()" + NL + "  {";
  protected final String TEXT_293 = NL;
  protected final String TEXT_294 = "    return ";
  protected final String TEXT_295 = ";" + NL + "  }";
  protected final String TEXT_296 = NL + "  public ";
  protected final String TEXT_297 = " ";
  protected final String TEXT_298 = "()" + NL + "  {";
  protected final String TEXT_299 = NL + "    ";
  protected final String TEXT_300 = " ";
  protected final String TEXT_301 = " = ";
  protected final String TEXT_302 = ";";
  protected final String TEXT_303 = NL;
  protected final String TEXT_304 = "    return ";
  protected final String TEXT_305 = ";" + NL + "  }" + NL;
  protected final String TEXT_306 = NL + "  public ";
  protected final String TEXT_307 = " ";
  protected final String TEXT_308 = "()" + NL + "  {";
  protected final String TEXT_309 = NL;
  protected final String TEXT_310 = "    return ";
  protected final String TEXT_311 = ";" + NL + "  }" + NL;
  protected final String TEXT_312 = NL + "  public ";
  protected final String TEXT_313 = " ";
  protected final String TEXT_314 = "()" + NL + "  {";
  protected final String TEXT_315 = NL + "    ";
  protected final String TEXT_316 = " ";
  protected final String TEXT_317 = " = ";
  protected final String TEXT_318 = ";";
  protected final String TEXT_319 = NL;
  protected final String TEXT_320 = "    return ";
  protected final String TEXT_321 = ";" + NL + "  }";
  protected final String TEXT_322 = NL + "  public ";
  protected final String TEXT_323 = " ";
  protected final String TEXT_324 = "()" + NL + "  {";
  protected final String TEXT_325 = NL;
  protected final String TEXT_326 = "    return ";
  protected final String TEXT_327 = ";" + NL + "  }";
  protected final String TEXT_328 = NL + "  public ";
  protected final String TEXT_329 = " ";
  protected final String TEXT_330 = "()" + NL + "  {";
  protected final String TEXT_331 = NL + "    ";
  protected final String TEXT_332 = " ";
  protected final String TEXT_333 = " = ";
  protected final String TEXT_334 = ";";
  protected final String TEXT_335 = NL;
  protected final String TEXT_336 = "    return ";
  protected final String TEXT_337 = ";" + NL + "  }";
  protected final String TEXT_338 = NL + "  public ";
  protected final String TEXT_339 = " ";
  protected final String TEXT_340 = "()" + NL + "  {";
  protected final String TEXT_341 = NL;
  protected final String TEXT_342 = "    return ";
  protected final String TEXT_343 = ";" + NL + "  }";
  protected final String TEXT_344 = NL + "  public ";
  protected final String TEXT_345 = " ";
  protected final String TEXT_346 = "()" + NL + "  {";
  protected final String TEXT_347 = NL + "    ";
  protected final String TEXT_348 = " ";
  protected final String TEXT_349 = " = ";
  protected final String TEXT_350 = ";";
  protected final String TEXT_351 = NL;
  protected final String TEXT_352 = "    return ";
  protected final String TEXT_353 = ";" + NL + "  }";
  protected final String TEXT_354 = NL + "  public ";
  protected final String TEXT_355 = " ";
  protected final String TEXT_356 = "()" + NL + "  {";
  protected final String TEXT_357 = NL;
  protected final String TEXT_358 = "    return ";
  protected final String TEXT_359 = ";" + NL + "  }";
  protected final String TEXT_360 = NL + "  public ";
  protected final String TEXT_361 = " ";
  protected final String TEXT_362 = "()" + NL + "  {" + NL + "    String answer = ";
  protected final String TEXT_363 = ".toString();";
  protected final String TEXT_364 = NL + "    return answer;" + NL + "  }" + NL;
  protected final String TEXT_365 = NL + "  public ";
  protected final String TEXT_366 = " ";
  protected final String TEXT_367 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_368 = ";" + NL + "  }" + NL;
  protected final String TEXT_369 = NL + "  ";
  protected final String TEXT_370 = " boolean ";
  protected final String TEXT_371 = "(";
  protected final String TEXT_372 = ")" + NL + "  {" + NL + "    boolean wasEventProcessed = false;";
  protected final String TEXT_373 = NL + "    ";
  protected final String TEXT_374 = NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_375 = NL + "  public boolean ";
  protected final String TEXT_376 = "(";
  protected final String TEXT_377 = " ";
  protected final String TEXT_378 = ")" + NL + "  {";
  protected final String TEXT_379 = NL + "    ";
  protected final String TEXT_380 = " = ";
  protected final String TEXT_381 = ";" + NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_382 = NL + "  private void ";
  protected final String TEXT_383 = "()" + NL + "  {";
  protected final String TEXT_384 = NL + "    switch(";
  protected final String TEXT_385 = ")" + NL + "    {";
  protected final String TEXT_386 = NL + "      ";
  protected final String TEXT_387 = NL + "    }";
  protected final String TEXT_388 = NL + "  }" + NL;
  protected final String TEXT_389 = NL + "  private void ";
  protected final String TEXT_390 = "(";
  protected final String TEXT_391 = " ";
  protected final String TEXT_392 = ")" + NL + "  {";
  protected final String TEXT_393 = NL + "    ";
  protected final String TEXT_394 = " = ";
  protected final String TEXT_395 = ";";
  protected final String TEXT_396 = NL + "    if (";
  protected final String TEXT_397 = " != ";
  protected final String TEXT_398 = ".";
  protected final String TEXT_399 = " && ";
  protected final String TEXT_400 = " != ";
  protected final String TEXT_401 = ".";
  protected final String TEXT_402 = ") { ";
  protected final String TEXT_403 = "(";
  protected final String TEXT_404 = ".";
  protected final String TEXT_405 = "); }";
  protected final String TEXT_406 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_407 = ")" + NL + "    {";
  protected final String TEXT_408 = NL + "      ";
  protected final String TEXT_409 = NL + "    }";
  protected final String TEXT_410 = NL + "  }" + NL;
  protected final String TEXT_411 = NL + "  public ";
  protected final String TEXT_412 = " ";
  protected final String TEXT_413 = "()" + NL + "  {";
  protected final String TEXT_414 = NL + "    return ";
  protected final String TEXT_415 = ";";
  protected final String TEXT_416 = NL + "    ";
  protected final String TEXT_417 = " ";
  protected final String TEXT_418 = " = ";
  protected final String TEXT_419 = ";";
  protected final String TEXT_420 = NL + "    return ";
  protected final String TEXT_421 = ";";
  protected final String TEXT_422 = NL + "  }" + NL;
  protected final String TEXT_423 = NL + "  public ";
  protected final String TEXT_424 = " ";
  protected final String TEXT_425 = "(int index)" + NL + "  {";
  protected final String TEXT_426 = NL + "    ";
  protected final String TEXT_427 = " ";
  protected final String TEXT_428 = " = ";
  protected final String TEXT_429 = ".get(index);";
  protected final String TEXT_430 = NL + "    return ";
  protected final String TEXT_431 = ";" + NL + "  }" + NL;
  protected final String TEXT_432 = NL + "  public List<";
  protected final String TEXT_433 = "> ";
  protected final String TEXT_434 = "()" + NL + "  {";
  protected final String TEXT_435 = NL + "    List<";
  protected final String TEXT_436 = "> ";
  protected final String TEXT_437 = " = Collections.unmodifiableList(";
  protected final String TEXT_438 = ");";
  protected final String TEXT_439 = NL + "    return ";
  protected final String TEXT_440 = ";" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_441 = "()" + NL + "  {";
  protected final String TEXT_442 = NL + "    int number = ";
  protected final String TEXT_443 = ".size();";
  protected final String TEXT_444 = NL + "    return number;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_445 = "()" + NL + "  {";
  protected final String TEXT_446 = NL + "    boolean has = ";
  protected final String TEXT_447 = ".size() > 0;";
  protected final String TEXT_448 = NL + "    return has;" + NL + "  }" + NL + "" + NL + "  public int ";
  protected final String TEXT_449 = "(";
  protected final String TEXT_450 = " ";
  protected final String TEXT_451 = ")" + NL + "  {";
  protected final String TEXT_452 = NL + "    int index = ";
  protected final String TEXT_453 = ".indexOf(";
  protected final String TEXT_454 = ");";
  protected final String TEXT_455 = NL + "    return index;" + NL + "  }" + NL;
  protected final String TEXT_456 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_457 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_458 = " : ";
  protected final String TEXT_459 = NL + "  public boolean ";
  protected final String TEXT_460 = "()" + NL + "  {";
  protected final String TEXT_461 = NL + "    boolean isValid = ";
  protected final String TEXT_462 = "() >= ";
  protected final String TEXT_463 = "();";
  protected final String TEXT_464 = NL + "    boolean isValid = ";
  protected final String TEXT_465 = "() >= ";
  protected final String TEXT_466 = "() && ";
  protected final String TEXT_467 = "() <= ";
  protected final String TEXT_468 = "();";
  protected final String TEXT_469 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_470 = NL + "  public static int ";
  protected final String TEXT_471 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_472 = ";" + NL + "  }";
  protected final String TEXT_473 = NL + "  public static int ";
  protected final String TEXT_474 = "()" + NL + "  {";
  protected final String TEXT_475 = NL + "    int required = ";
  protected final String TEXT_476 = ";";
  protected final String TEXT_477 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_478 = NL + "  public static int ";
  protected final String TEXT_479 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_480 = ";" + NL + "  }";
  protected final String TEXT_481 = NL + "  public static int ";
  protected final String TEXT_482 = "()" + NL + "  {";
  protected final String TEXT_483 = NL + "    int minimum = ";
  protected final String TEXT_484 = ";";
  protected final String TEXT_485 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_486 = NL + "  public static int ";
  protected final String TEXT_487 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_488 = ";" + NL + "  }";
  protected final String TEXT_489 = NL + "  public static int ";
  protected final String TEXT_490 = "()" + NL + "  {";
  protected final String TEXT_491 = NL + "    int maximum = ";
  protected final String TEXT_492 = ";";
  protected final String TEXT_493 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_494 = NL + "  public boolean ";
  protected final String TEXT_495 = "(";
  protected final String TEXT_496 = " ";
  protected final String TEXT_497 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_498 = NL + "    if (";
  protected final String TEXT_499 = "() >= ";
  protected final String TEXT_500 = "())" + NL + "    {";
  protected final String TEXT_501 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_502 = NL + "    ";
  protected final String TEXT_503 = ".add(";
  protected final String TEXT_504 = ");" + NL + "    if (";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_507 = ".";
  protected final String TEXT_508 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_509 = NL + "        ";
  protected final String TEXT_510 = ".remove(";
  protected final String TEXT_511 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_512 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_513 = NL + "  public boolean ";
  protected final String TEXT_514 = "(";
  protected final String TEXT_515 = " ";
  protected final String TEXT_516 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_517 = NL + "    if (!";
  protected final String TEXT_518 = ".contains(";
  protected final String TEXT_519 = "))" + NL + "    {";
  protected final String TEXT_520 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_521 = ".indexOf(";
  protected final String TEXT_522 = ");";
  protected final String TEXT_523 = NL + "    ";
  protected final String TEXT_524 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_525 = ".";
  protected final String TEXT_526 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_527 = ".";
  protected final String TEXT_528 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_529 = NL + "        ";
  protected final String TEXT_530 = ".add(oldIndex,";
  protected final String TEXT_531 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_532 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_533 = NL + "  ";
  protected final String TEXT_534 = " boolean ";
  protected final String TEXT_535 = "(";
  protected final String TEXT_536 = " ";
  protected final String TEXT_537 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_538 = NL + "    ";
  protected final String TEXT_539 = " = ";
  protected final String TEXT_540 = ";" + NL + "    wasSet = true;";
  protected final String TEXT_541 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_542 = NL + "  ";
  protected final String TEXT_543 = " boolean ";
  protected final String TEXT_544 = "(";
  protected final String TEXT_545 = " ";
  protected final String TEXT_546 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_547 = NL + "    if (";
  protected final String TEXT_548 = " != null)" + NL + "    {";
  protected final String TEXT_549 = NL + "      ";
  protected final String TEXT_550 = " = ";
  protected final String TEXT_551 = ";" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_552 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_553 = NL + "  public boolean ";
  protected final String TEXT_554 = "(";
  protected final String TEXT_555 = " ";
  protected final String TEXT_556 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_557 = NL + "    if (";
  protected final String TEXT_558 = " != null && !";
  protected final String TEXT_559 = ".equals(";
  protected final String TEXT_560 = ") && equals(";
  protected final String TEXT_561 = ".";
  protected final String TEXT_562 = "()))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_563 = ", as existing ";
  protected final String TEXT_564 = " would become an orphan";
  protected final String TEXT_565 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_566 = NL + "    ";
  protected final String TEXT_567 = " = ";
  protected final String TEXT_568 = ";";
  protected final String TEXT_569 = NL + "    ";
  protected final String TEXT_570 = " ";
  protected final String TEXT_571 = " = ";
  protected final String TEXT_572 = " != null ? ";
  protected final String TEXT_573 = ".";
  protected final String TEXT_574 = "() : null;" + NL + "" + NL + "    if (!this.equals(";
  protected final String TEXT_575 = "))" + NL + "    {" + NL + "      if (";
  protected final String TEXT_576 = " != null)" + NL + "      {";
  protected final String TEXT_577 = NL + "        ";
  protected final String TEXT_578 = ".";
  protected final String TEXT_579 = " = null;" + NL + "      }" + NL + "      if (";
  protected final String TEXT_580 = " != null)" + NL + "      {";
  protected final String TEXT_581 = NL + "        ";
  protected final String TEXT_582 = ".";
  protected final String TEXT_583 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_584 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_585 = NL + "  public boolean ";
  protected final String TEXT_586 = "(";
  protected final String TEXT_587 = " ";
  protected final String TEXT_588 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_589 = NL + "    if (";
  protected final String TEXT_590 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_591 = " to null, as ";
  protected final String TEXT_592 = " must always be associated to a ";
  protected final String TEXT_593 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_594 = NL + "    ";
  protected final String TEXT_595 = " ";
  protected final String TEXT_596 = " = ";
  protected final String TEXT_597 = ".";
  protected final String TEXT_598 = "();" + NL + "    if (";
  protected final String TEXT_599 = " != null && !equals(";
  protected final String TEXT_600 = "))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_601 = ", the current ";
  protected final String TEXT_602 = " already has a ";
  protected final String TEXT_603 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_604 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_605 = NL + "    ";
  protected final String TEXT_606 = " ";
  protected final String TEXT_607 = " = ";
  protected final String TEXT_608 = ";";
  protected final String TEXT_609 = NL + "    ";
  protected final String TEXT_610 = " = ";
  protected final String TEXT_611 = ";";
  protected final String TEXT_612 = NL + "    ";
  protected final String TEXT_613 = ".";
  protected final String TEXT_614 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_615 = " != null)" + NL + "    {";
  protected final String TEXT_616 = NL + "      ";
  protected final String TEXT_617 = ".";
  protected final String TEXT_618 = "(null);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_619 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_620 = NL + "  public ";
  protected final String TEXT_621 = " ";
  protected final String TEXT_622 = "(";
  protected final String TEXT_623 = ")" + NL + "  {";
  protected final String TEXT_624 = NL + "    ";
  protected final String TEXT_625 = " ";
  protected final String TEXT_626 = " = new ";
  protected final String TEXT_627 = "(";
  protected final String TEXT_628 = ");";
  protected final String TEXT_629 = NL + "    return ";
  protected final String TEXT_630 = ";" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_631 = "(";
  protected final String TEXT_632 = " ";
  protected final String TEXT_633 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_634 = NL + "    ";
  protected final String TEXT_635 = " ";
  protected final String TEXT_636 = " = ";
  protected final String TEXT_637 = ".";
  protected final String TEXT_638 = "();" + NL + "    boolean ";
  protected final String TEXT_639 = " = ";
  protected final String TEXT_640 = " != null && !this.equals(";
  protected final String TEXT_641 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_642 = " && ";
  protected final String TEXT_643 = ".";
  protected final String TEXT_644 = "() <= ";
  protected final String TEXT_645 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_646 = NL;
  protected final String TEXT_647 = NL + "    if (";
  protected final String TEXT_648 = ")" + NL + "    {";
  protected final String TEXT_649 = NL + "      ";
  protected final String TEXT_650 = ".";
  protected final String TEXT_651 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_652 = NL + "      ";
  protected final String TEXT_653 = ".add(";
  protected final String TEXT_654 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_655 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_656 = "(";
  protected final String TEXT_657 = " ";
  protected final String TEXT_658 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_659 = NL + "    //Unable to remove ";
  protected final String TEXT_660 = ", as it must always have a ";
  protected final String TEXT_661 = NL + "    if (this.equals(";
  protected final String TEXT_662 = ".";
  protected final String TEXT_663 = "()))" + NL + "    {";
  protected final String TEXT_664 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_665 = " already at minimum (";
  protected final String TEXT_666 = ")" + NL + "    if (";
  protected final String TEXT_667 = "() <= ";
  protected final String TEXT_668 = "())" + NL + "    {";
  protected final String TEXT_669 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_670 = NL;
  protected final String TEXT_671 = NL + "    ";
  protected final String TEXT_672 = ".remove(";
  protected final String TEXT_673 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_674 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_675 = NL + "  public ";
  protected final String TEXT_676 = " ";
  protected final String TEXT_677 = "(";
  protected final String TEXT_678 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_679 = "() >= ";
  protected final String TEXT_680 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_681 = "(";
  protected final String TEXT_682 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_683 = "(";
  protected final String TEXT_684 = " ";
  protected final String TEXT_685 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_686 = NL + "    if (";
  protected final String TEXT_687 = "() >= ";
  protected final String TEXT_688 = "())" + NL + "    {";
  protected final String TEXT_689 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_690 = NL + "    ";
  protected final String TEXT_691 = " ";
  protected final String TEXT_692 = " = ";
  protected final String TEXT_693 = ".";
  protected final String TEXT_694 = "();" + NL + "    boolean ";
  protected final String TEXT_695 = " = ";
  protected final String TEXT_696 = " != null && !this.equals(";
  protected final String TEXT_697 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_698 = " && ";
  protected final String TEXT_699 = ".";
  protected final String TEXT_700 = "() <= ";
  protected final String TEXT_701 = "())" + NL + "    {";
  protected final String TEXT_702 = NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_703 = ")" + NL + "    {";
  protected final String TEXT_704 = NL + "      ";
  protected final String TEXT_705 = ".";
  protected final String TEXT_706 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_707 = NL + "      ";
  protected final String TEXT_708 = ".add(";
  protected final String TEXT_709 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_710 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_711 = "(";
  protected final String TEXT_712 = " ";
  protected final String TEXT_713 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_714 = NL + "    //Unable to remove ";
  protected final String TEXT_715 = ", as it must always have a ";
  protected final String TEXT_716 = NL + "    if (this.equals(";
  protected final String TEXT_717 = ".";
  protected final String TEXT_718 = "()))" + NL + "    {";
  protected final String TEXT_719 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_720 = " already at minimum (";
  protected final String TEXT_721 = ")" + NL + "    if (";
  protected final String TEXT_722 = "() <= ";
  protected final String TEXT_723 = "())" + NL + "    {";
  protected final String TEXT_724 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_725 = NL + "    ";
  protected final String TEXT_726 = ".remove(";
  protected final String TEXT_727 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_728 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_729 = NL + "  public ";
  protected final String TEXT_730 = " ";
  protected final String TEXT_731 = "(";
  protected final String TEXT_732 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_733 = "() >= ";
  protected final String TEXT_734 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_735 = "(";
  protected final String TEXT_736 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_737 = "(";
  protected final String TEXT_738 = " ";
  protected final String TEXT_739 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_740 = NL + "    if (";
  protected final String TEXT_741 = "() >= ";
  protected final String TEXT_742 = "())" + NL + "    {";
  protected final String TEXT_743 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_744 = NL + "    ";
  protected final String TEXT_745 = " ";
  protected final String TEXT_746 = " = ";
  protected final String TEXT_747 = ".";
  protected final String TEXT_748 = "();" + NL + "    boolean ";
  protected final String TEXT_749 = " = ";
  protected final String TEXT_750 = " != null && !this.equals(";
  protected final String TEXT_751 = ");" + NL + "    if (";
  protected final String TEXT_752 = ")" + NL + "    {";
  protected final String TEXT_753 = NL + "      ";
  protected final String TEXT_754 = ".";
  protected final String TEXT_755 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_756 = NL + "      ";
  protected final String TEXT_757 = ".add(";
  protected final String TEXT_758 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_759 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_760 = "(";
  protected final String TEXT_761 = " ";
  protected final String TEXT_762 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_763 = NL + "    //Unable to remove ";
  protected final String TEXT_764 = ", as it must always have a ";
  protected final String TEXT_765 = NL + "    if (!this.equals(";
  protected final String TEXT_766 = ".";
  protected final String TEXT_767 = "()))" + NL + "    {";
  protected final String TEXT_768 = NL + "      ";
  protected final String TEXT_769 = ".remove(";
  protected final String TEXT_770 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_771 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_772 = NL + "  public boolean ";
  protected final String TEXT_773 = "(";
  protected final String TEXT_774 = "... ";
  protected final String TEXT_775 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_776 = NL + "    ArrayList<";
  protected final String TEXT_777 = "> ";
  protected final String TEXT_778 = " = new ArrayList<";
  protected final String TEXT_779 = ">();" + NL + "    for (";
  protected final String TEXT_780 = " ";
  protected final String TEXT_781 = " : ";
  protected final String TEXT_782 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_783 = ".contains(";
  protected final String TEXT_784 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_785 = NL + "      ";
  protected final String TEXT_786 = ".add(";
  protected final String TEXT_787 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_788 = ".size() != ";
  protected final String TEXT_789 = ".length || ";
  protected final String TEXT_790 = ".size() > ";
  protected final String TEXT_791 = "())" + NL + "    {";
  protected final String TEXT_792 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_793 = "> ";
  protected final String TEXT_794 = " = new ArrayList<";
  protected final String TEXT_795 = ">(";
  protected final String TEXT_796 = ");";
  protected final String TEXT_797 = NL + "    ";
  protected final String TEXT_798 = ".clear();" + NL + "    for (";
  protected final String TEXT_799 = " ";
  protected final String TEXT_800 = " : ";
  protected final String TEXT_801 = ")" + NL + "    {";
  protected final String TEXT_802 = NL + "      ";
  protected final String TEXT_803 = ".add(";
  protected final String TEXT_804 = ");" + NL + "      if (";
  protected final String TEXT_805 = ".contains(";
  protected final String TEXT_806 = "))" + NL + "      {";
  protected final String TEXT_807 = NL + "        ";
  protected final String TEXT_808 = ".remove(";
  protected final String TEXT_809 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_810 = NL + "        ";
  protected final String TEXT_811 = ".";
  protected final String TEXT_812 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_813 = " ";
  protected final String TEXT_814 = " : ";
  protected final String TEXT_815 = ")" + NL + "    {";
  protected final String TEXT_816 = NL + "      ";
  protected final String TEXT_817 = ".";
  protected final String TEXT_818 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_819 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_820 = NL + "  public ";
  protected final String TEXT_821 = " ";
  protected final String TEXT_822 = "(";
  protected final String TEXT_823 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_824 = "(";
  protected final String TEXT_825 = ");" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_826 = "(";
  protected final String TEXT_827 = " ";
  protected final String TEXT_828 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_829 = NL + "    ";
  protected final String TEXT_830 = " ";
  protected final String TEXT_831 = " = ";
  protected final String TEXT_832 = ".";
  protected final String TEXT_833 = "();" + NL + "    boolean ";
  protected final String TEXT_834 = " = ";
  protected final String TEXT_835 = " != null && !this.equals(";
  protected final String TEXT_836 = ");" + NL + "    if (";
  protected final String TEXT_837 = ")" + NL + "    {";
  protected final String TEXT_838 = NL + "      ";
  protected final String TEXT_839 = ".";
  protected final String TEXT_840 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_841 = NL + "      ";
  protected final String TEXT_842 = ".add(";
  protected final String TEXT_843 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_844 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_845 = "(";
  protected final String TEXT_846 = " ";
  protected final String TEXT_847 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_848 = NL + "    //Unable to remove ";
  protected final String TEXT_849 = ", as it must always have a ";
  protected final String TEXT_850 = NL + "    if (!this.equals(";
  protected final String TEXT_851 = ".";
  protected final String TEXT_852 = "()))" + NL + "    {";
  protected final String TEXT_853 = NL + "      ";
  protected final String TEXT_854 = ".remove(";
  protected final String TEXT_855 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_856 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_857 = NL + "  public boolean ";
  protected final String TEXT_858 = "(";
  protected final String TEXT_859 = " ";
  protected final String TEXT_860 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_861 = NL + "    if (";
  protected final String TEXT_862 = " == null)" + NL + "    {";
  protected final String TEXT_863 = NL + "      ";
  protected final String TEXT_864 = " ";
  protected final String TEXT_865 = " = ";
  protected final String TEXT_866 = ";";
  protected final String TEXT_867 = NL + "      ";
  protected final String TEXT_868 = " = null;" + NL + "      " + NL + "      if (";
  protected final String TEXT_869 = " != null && ";
  protected final String TEXT_870 = ".";
  protected final String TEXT_871 = "() != null)" + NL + "      {";
  protected final String TEXT_872 = NL + "        ";
  protected final String TEXT_873 = ".";
  protected final String TEXT_874 = "(null);" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_875 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_876 = NL + "    ";
  protected final String TEXT_877 = " ";
  protected final String TEXT_878 = " = ";
  protected final String TEXT_879 = "();" + NL + "    if (";
  protected final String TEXT_880 = " != null && !";
  protected final String TEXT_881 = ".equals(";
  protected final String TEXT_882 = "))" + NL + "    {";
  protected final String TEXT_883 = NL + "      ";
  protected final String TEXT_884 = ".";
  protected final String TEXT_885 = "(null);" + NL + "    }" + NL;
  protected final String TEXT_886 = NL + "    ";
  protected final String TEXT_887 = " = ";
  protected final String TEXT_888 = ";";
  protected final String TEXT_889 = NL + "    ";
  protected final String TEXT_890 = " ";
  protected final String TEXT_891 = " = ";
  protected final String TEXT_892 = ".";
  protected final String TEXT_893 = "();" + NL + "" + NL + "    if (!equals(";
  protected final String TEXT_894 = "))" + NL + "    {";
  protected final String TEXT_895 = NL + "      ";
  protected final String TEXT_896 = ".";
  protected final String TEXT_897 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_898 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_899 = NL + "  public boolean ";
  protected final String TEXT_900 = "(";
  protected final String TEXT_901 = " ";
  protected final String TEXT_902 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_903 = NL + "    if (!";
  protected final String TEXT_904 = ".contains(";
  protected final String TEXT_905 = "))" + NL + "    {";
  protected final String TEXT_906 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_907 = "() <= ";
  protected final String TEXT_908 = "())" + NL + "    {";
  protected final String TEXT_909 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_910 = ".indexOf(";
  protected final String TEXT_911 = ");";
  protected final String TEXT_912 = NL + "    ";
  protected final String TEXT_913 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_914 = ".";
  protected final String TEXT_915 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_916 = ".";
  protected final String TEXT_917 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_918 = NL + "        ";
  protected final String TEXT_919 = ".add(oldIndex,";
  protected final String TEXT_920 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_921 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_922 = NL + "  public boolean ";
  protected final String TEXT_923 = "(";
  protected final String TEXT_924 = " ";
  protected final String TEXT_925 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_926 = NL + "    if (!";
  protected final String TEXT_927 = ".contains(";
  protected final String TEXT_928 = "))" + NL + "    {";
  protected final String TEXT_929 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_930 = "() <= ";
  protected final String TEXT_931 = "())" + NL + "    {";
  protected final String TEXT_932 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_933 = ".indexOf(";
  protected final String TEXT_934 = ");";
  protected final String TEXT_935 = NL + "    ";
  protected final String TEXT_936 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_937 = ".";
  protected final String TEXT_938 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_939 = ".";
  protected final String TEXT_940 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_941 = NL + "        ";
  protected final String TEXT_942 = ".add(oldIndex,";
  protected final String TEXT_943 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_944 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_945 = NL + "  public boolean ";
  protected final String TEXT_946 = "(";
  protected final String TEXT_947 = " ";
  protected final String TEXT_948 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_949 = NL + "    if (";
  protected final String TEXT_950 = " != null && ";
  protected final String TEXT_951 = ".";
  protected final String TEXT_952 = "() >= ";
  protected final String TEXT_953 = ".";
  protected final String TEXT_954 = "())" + NL + "    {";
  protected final String TEXT_955 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_956 = NL + "    ";
  protected final String TEXT_957 = " ";
  protected final String TEXT_958 = " = ";
  protected final String TEXT_959 = ";";
  protected final String TEXT_960 = NL + "    ";
  protected final String TEXT_961 = " = ";
  protected final String TEXT_962 = ";" + NL + "    if (";
  protected final String TEXT_963 = " != null && !";
  protected final String TEXT_964 = ".equals(";
  protected final String TEXT_965 = "))" + NL + "    {";
  protected final String TEXT_966 = NL + "      ";
  protected final String TEXT_967 = ".";
  protected final String TEXT_968 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_969 = " != null)" + NL + "    {";
  protected final String TEXT_970 = NL + "      ";
  protected final String TEXT_971 = ".";
  protected final String TEXT_972 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_973 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_974 = NL + "  public boolean ";
  protected final String TEXT_975 = "(";
  protected final String TEXT_976 = " ";
  protected final String TEXT_977 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_978 = NL + "    if (";
  protected final String TEXT_979 = " == null)" + NL + "    {";
  protected final String TEXT_980 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_981 = NL + "    ";
  protected final String TEXT_982 = " ";
  protected final String TEXT_983 = " = ";
  protected final String TEXT_984 = ";";
  protected final String TEXT_985 = NL + "    ";
  protected final String TEXT_986 = " = ";
  protected final String TEXT_987 = ";" + NL + "    if (";
  protected final String TEXT_988 = " != null && !";
  protected final String TEXT_989 = ".equals(";
  protected final String TEXT_990 = "))" + NL + "    {";
  protected final String TEXT_991 = NL + "      ";
  protected final String TEXT_992 = ".";
  protected final String TEXT_993 = "(this);" + NL + "    }";
  protected final String TEXT_994 = NL + "    ";
  protected final String TEXT_995 = ".";
  protected final String TEXT_996 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_997 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_998 = NL + "  public boolean ";
  protected final String TEXT_999 = "(";
  protected final String TEXT_1000 = " ";
  protected final String TEXT_1001 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1002 = NL + "    //Must provide ";
  protected final String TEXT_1003 = " to ";
  protected final String TEXT_1004 = NL + "    if (";
  protected final String TEXT_1005 = " == null)" + NL + "    {";
  protected final String TEXT_1006 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1007 = " already at maximum (";
  protected final String TEXT_1008 = ")" + NL + "    if (";
  protected final String TEXT_1009 = ".";
  protected final String TEXT_1010 = "() >= ";
  protected final String TEXT_1011 = ".";
  protected final String TEXT_1012 = "())" + NL + "    {";
  protected final String TEXT_1013 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1014 = NL + "    ";
  protected final String TEXT_1015 = " ";
  protected final String TEXT_1016 = " = ";
  protected final String TEXT_1017 = ";";
  protected final String TEXT_1018 = NL + "    ";
  protected final String TEXT_1019 = " = ";
  protected final String TEXT_1020 = ";" + NL + "    if (";
  protected final String TEXT_1021 = " != null && !";
  protected final String TEXT_1022 = ".equals(";
  protected final String TEXT_1023 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1024 = ".";
  protected final String TEXT_1025 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1026 = NL + "        ";
  protected final String TEXT_1027 = " = ";
  protected final String TEXT_1028 = ";";
  protected final String TEXT_1029 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1030 = NL + "    ";
  protected final String TEXT_1031 = ".";
  protected final String TEXT_1032 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1033 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1034 = NL + "  public boolean ";
  protected final String TEXT_1035 = "(";
  protected final String TEXT_1036 = " ";
  protected final String TEXT_1037 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1038 = NL + "    //Must provide ";
  protected final String TEXT_1039 = " to ";
  protected final String TEXT_1040 = NL + "    if (";
  protected final String TEXT_1041 = " == null)" + NL + "    {";
  protected final String TEXT_1042 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1043 = " != null && ";
  protected final String TEXT_1044 = ".";
  protected final String TEXT_1045 = "() <= ";
  protected final String TEXT_1046 = ".";
  protected final String TEXT_1047 = "())" + NL + "    {";
  protected final String TEXT_1048 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1049 = NL + "    ";
  protected final String TEXT_1050 = " ";
  protected final String TEXT_1051 = " = ";
  protected final String TEXT_1052 = ";";
  protected final String TEXT_1053 = NL + "    ";
  protected final String TEXT_1054 = " = ";
  protected final String TEXT_1055 = ";" + NL + "    if (";
  protected final String TEXT_1056 = " != null && !";
  protected final String TEXT_1057 = ".equals(";
  protected final String TEXT_1058 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1059 = ".";
  protected final String TEXT_1060 = "(this);" + NL + "      if (!didRemove)" + NL + "      {";
  protected final String TEXT_1061 = NL + "        ";
  protected final String TEXT_1062 = " = ";
  protected final String TEXT_1063 = ";";
  protected final String TEXT_1064 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1065 = NL + "    ";
  protected final String TEXT_1066 = ".";
  protected final String TEXT_1067 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1068 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1069 = NL + "  public boolean ";
  protected final String TEXT_1070 = "(";
  protected final String TEXT_1071 = " ";
  protected final String TEXT_1072 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1073 = NL + "    ";
  protected final String TEXT_1074 = " ";
  protected final String TEXT_1075 = " = ";
  protected final String TEXT_1076 = ".";
  protected final String TEXT_1077 = "();" + NL + "    if (";
  protected final String TEXT_1078 = " == null)" + NL + "    {";
  protected final String TEXT_1079 = NL + "      ";
  protected final String TEXT_1080 = ".";
  protected final String TEXT_1081 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1082 = "))" + NL + "    {";
  protected final String TEXT_1083 = NL + "      ";
  protected final String TEXT_1084 = ".";
  protected final String TEXT_1085 = "(";
  protected final String TEXT_1086 = ");";
  protected final String TEXT_1087 = NL + "      ";
  protected final String TEXT_1088 = "(";
  protected final String TEXT_1089 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1090 = NL + "      ";
  protected final String TEXT_1091 = ".add(";
  protected final String TEXT_1092 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1093 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1094 = "(";
  protected final String TEXT_1095 = " ";
  protected final String TEXT_1096 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1097 = NL + "    if (";
  protected final String TEXT_1098 = ".contains(";
  protected final String TEXT_1099 = "))" + NL + "    {";
  protected final String TEXT_1100 = NL + "      ";
  protected final String TEXT_1101 = ".remove(";
  protected final String TEXT_1102 = ");";
  protected final String TEXT_1103 = NL + "      ";
  protected final String TEXT_1104 = ".";
  protected final String TEXT_1105 = "(null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1106 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1107 = NL + "  public boolean ";
  protected final String TEXT_1108 = "(";
  protected final String TEXT_1109 = " ";
  protected final String TEXT_1110 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1111 = NL + "    ";
  protected final String TEXT_1112 = " ";
  protected final String TEXT_1113 = " = ";
  protected final String TEXT_1114 = ";";
  protected final String TEXT_1115 = NL + "    ";
  protected final String TEXT_1116 = " = ";
  protected final String TEXT_1117 = ";" + NL + "    if (";
  protected final String TEXT_1118 = " != null && !";
  protected final String TEXT_1119 = ".equals(";
  protected final String TEXT_1120 = "))" + NL + "    {";
  protected final String TEXT_1121 = NL + "      ";
  protected final String TEXT_1122 = ".";
  protected final String TEXT_1123 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1124 = " != null)" + NL + "    {";
  protected final String TEXT_1125 = NL + "      ";
  protected final String TEXT_1126 = ".";
  protected final String TEXT_1127 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1128 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1129 = NL + "  public boolean ";
  protected final String TEXT_1130 = "(";
  protected final String TEXT_1131 = " ";
  protected final String TEXT_1132 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1133 = NL + "    if (";
  protected final String TEXT_1134 = "() >= ";
  protected final String TEXT_1135 = "())" + NL + "    {";
  protected final String TEXT_1136 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1137 = NL + "    ";
  protected final String TEXT_1138 = " ";
  protected final String TEXT_1139 = " = ";
  protected final String TEXT_1140 = ".";
  protected final String TEXT_1141 = "();" + NL + "    if (";
  protected final String TEXT_1142 = " == null)" + NL + "    {";
  protected final String TEXT_1143 = NL + "      ";
  protected final String TEXT_1144 = ".";
  protected final String TEXT_1145 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1146 = "))" + NL + "    {";
  protected final String TEXT_1147 = NL + "      ";
  protected final String TEXT_1148 = ".";
  protected final String TEXT_1149 = "(";
  protected final String TEXT_1150 = ");";
  protected final String TEXT_1151 = NL + "      ";
  protected final String TEXT_1152 = "(";
  protected final String TEXT_1153 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1154 = NL + "      ";
  protected final String TEXT_1155 = ".add(";
  protected final String TEXT_1156 = ");" + NL + "    }" + NL + "    wasAdded = true;";
  protected final String TEXT_1157 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1158 = "(";
  protected final String TEXT_1159 = " ";
  protected final String TEXT_1160 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1161 = NL + "    if (";
  protected final String TEXT_1162 = ".contains(";
  protected final String TEXT_1163 = "))" + NL + "    {";
  protected final String TEXT_1164 = NL + "      ";
  protected final String TEXT_1165 = ".remove(";
  protected final String TEXT_1166 = ");";
  protected final String TEXT_1167 = NL + "      ";
  protected final String TEXT_1168 = ".";
  protected final String TEXT_1169 = "(null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1170 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1171 = NL + "  public boolean ";
  protected final String TEXT_1172 = "(";
  protected final String TEXT_1173 = " ";
  protected final String TEXT_1174 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1175 = NL + "    if (";
  protected final String TEXT_1176 = "() < ";
  protected final String TEXT_1177 = "())" + NL + "    {";
  protected final String TEXT_1178 = NL + "      ";
  protected final String TEXT_1179 = ".add(";
  protected final String TEXT_1180 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1181 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1182 = "(";
  protected final String TEXT_1183 = " ";
  protected final String TEXT_1184 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1185 = NL + "    if (!";
  protected final String TEXT_1186 = ".contains(";
  protected final String TEXT_1187 = "))" + NL + "    {";
  protected final String TEXT_1188 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1189 = "() <= ";
  protected final String TEXT_1190 = "())" + NL + "    {";
  protected final String TEXT_1191 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1192 = NL + "    ";
  protected final String TEXT_1193 = ".remove(";
  protected final String TEXT_1194 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_1195 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1196 = NL + "  public boolean ";
  protected final String TEXT_1197 = "(";
  protected final String TEXT_1198 = " ";
  protected final String TEXT_1199 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1200 = NL + "    if (";
  protected final String TEXT_1201 = "() >= ";
  protected final String TEXT_1202 = "())" + NL + "    {";
  protected final String TEXT_1203 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1204 = NL + "    ";
  protected final String TEXT_1205 = " ";
  protected final String TEXT_1206 = " = ";
  protected final String TEXT_1207 = ".";
  protected final String TEXT_1208 = "();" + NL + "    if (";
  protected final String TEXT_1209 = " != null && ";
  protected final String TEXT_1210 = ".";
  protected final String TEXT_1211 = "() <= ";
  protected final String TEXT_1212 = "())" + NL + "    {";
  protected final String TEXT_1213 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1214 = " != null)" + NL + "    {";
  protected final String TEXT_1215 = NL + "      ";
  protected final String TEXT_1216 = ".";
  protected final String TEXT_1217 = ".remove(";
  protected final String TEXT_1218 = ");" + NL + "    }";
  protected final String TEXT_1219 = NL + "    ";
  protected final String TEXT_1220 = ".add(";
  protected final String TEXT_1221 = ");";
  protected final String TEXT_1222 = NL + "    ";
  protected final String TEXT_1223 = "(";
  protected final String TEXT_1224 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1225 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1226 = "(";
  protected final String TEXT_1227 = " ";
  protected final String TEXT_1228 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1229 = NL + "    if (";
  protected final String TEXT_1230 = ".contains(";
  protected final String TEXT_1231 = ") && ";
  protected final String TEXT_1232 = "() > ";
  protected final String TEXT_1233 = "())" + NL + "    {";
  protected final String TEXT_1234 = NL + "      ";
  protected final String TEXT_1235 = ".remove(";
  protected final String TEXT_1236 = ");";
  protected final String TEXT_1237 = NL + "      ";
  protected final String TEXT_1238 = "(";
  protected final String TEXT_1239 = ",null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1240 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1241 = NL + "  public boolean ";
  protected final String TEXT_1242 = "(";
  protected final String TEXT_1243 = "... ";
  protected final String TEXT_1244 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1245 = NL + "    ArrayList<";
  protected final String TEXT_1246 = "> ";
  protected final String TEXT_1247 = " = new ArrayList<";
  protected final String TEXT_1248 = ">();" + NL + "    for (";
  protected final String TEXT_1249 = " ";
  protected final String TEXT_1250 = " : ";
  protected final String TEXT_1251 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1252 = ".contains(";
  protected final String TEXT_1253 = "))" + NL + "      {";
  protected final String TEXT_1254 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1255 = ".";
  protected final String TEXT_1256 = "() != null && !this.equals(";
  protected final String TEXT_1257 = ".";
  protected final String TEXT_1258 = "()))" + NL + "      {";
  protected final String TEXT_1259 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1260 = NL + "      ";
  protected final String TEXT_1261 = ".add(";
  protected final String TEXT_1262 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1263 = ".size() != ";
  protected final String TEXT_1264 = "())" + NL + "    {";
  protected final String TEXT_1265 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1266 = NL + "    ";
  protected final String TEXT_1267 = ".removeAll(";
  protected final String TEXT_1268 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1269 = " orphan : ";
  protected final String TEXT_1270 = ")" + NL + "    {";
  protected final String TEXT_1271 = NL + "      ";
  protected final String TEXT_1272 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1273 = NL + "    ";
  protected final String TEXT_1274 = ".clear();" + NL + "    for (";
  protected final String TEXT_1275 = " ";
  protected final String TEXT_1276 = " : ";
  protected final String TEXT_1277 = ")" + NL + "    {";
  protected final String TEXT_1278 = NL + "      ";
  protected final String TEXT_1279 = "(";
  protected final String TEXT_1280 = ", this);";
  protected final String TEXT_1281 = NL + "      ";
  protected final String TEXT_1282 = ".add(";
  protected final String TEXT_1283 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1284 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1285 = NL + "  private void ";
  protected final String TEXT_1286 = "(";
  protected final String TEXT_1287 = " ";
  protected final String TEXT_1288 = ", ";
  protected final String TEXT_1289 = " ";
  protected final String TEXT_1290 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1291 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1292 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1293 = ", ";
  protected final String TEXT_1294 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1295 = " to ";
  protected final String TEXT_1296 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1297 = NL + "  public boolean ";
  protected final String TEXT_1298 = "(";
  protected final String TEXT_1299 = " ";
  protected final String TEXT_1300 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1301 = NL + "    ";
  protected final String TEXT_1302 = ".add(";
  protected final String TEXT_1303 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1304 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1305 = "(";
  protected final String TEXT_1306 = " ";
  protected final String TEXT_1307 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1308 = NL + "    if (";
  protected final String TEXT_1309 = ".contains(";
  protected final String TEXT_1310 = "))" + NL + "    {";
  protected final String TEXT_1311 = NL + "      ";
  protected final String TEXT_1312 = ".remove(";
  protected final String TEXT_1313 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1314 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1315 = NL + "  public boolean ";
  protected final String TEXT_1316 = "(";
  protected final String TEXT_1317 = " ";
  protected final String TEXT_1318 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1319 = NL + "    if (";
  protected final String TEXT_1320 = "() < ";
  protected final String TEXT_1321 = "())" + NL + "    {";
  protected final String TEXT_1322 = NL + "      ";
  protected final String TEXT_1323 = ".add(";
  protected final String TEXT_1324 = ");" + NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1325 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1326 = "(";
  protected final String TEXT_1327 = " ";
  protected final String TEXT_1328 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1329 = NL + "    if (";
  protected final String TEXT_1330 = ".contains(";
  protected final String TEXT_1331 = "))" + NL + "    {";
  protected final String TEXT_1332 = NL + "      ";
  protected final String TEXT_1333 = ".remove(";
  protected final String TEXT_1334 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1335 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1336 = NL + "  public boolean ";
  protected final String TEXT_1337 = "(";
  protected final String TEXT_1338 = " ";
  protected final String TEXT_1339 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1340 = NL + "    ";
  protected final String TEXT_1341 = ".add(";
  protected final String TEXT_1342 = ");" + NL + "    wasAdded = true;";
  protected final String TEXT_1343 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1344 = "(";
  protected final String TEXT_1345 = " ";
  protected final String TEXT_1346 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1347 = NL + "    if (!";
  protected final String TEXT_1348 = ".contains(";
  protected final String TEXT_1349 = "))" + NL + "    {";
  protected final String TEXT_1350 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1351 = "() <= ";
  protected final String TEXT_1352 = "())" + NL + "    {";
  protected final String TEXT_1353 = NL + "      return wasRemoved;" + NL + "    }" + NL;
  protected final String TEXT_1354 = NL + "    ";
  protected final String TEXT_1355 = ".remove(";
  protected final String TEXT_1356 = ");" + NL + "    wasRemoved = true;";
  protected final String TEXT_1357 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1358 = NL + "  ";
  protected final String TEXT_1359 = " boolean ";
  protected final String TEXT_1360 = "(";
  protected final String TEXT_1361 = "... ";
  protected final String TEXT_1362 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1363 = NL + "    ArrayList<";
  protected final String TEXT_1364 = "> ";
  protected final String TEXT_1365 = " = new ArrayList<";
  protected final String TEXT_1366 = ">();" + NL + "    for (";
  protected final String TEXT_1367 = " ";
  protected final String TEXT_1368 = " : ";
  protected final String TEXT_1369 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1370 = ".contains(";
  protected final String TEXT_1371 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1372 = NL + "      ";
  protected final String TEXT_1373 = ".add(";
  protected final String TEXT_1374 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1375 = ".size() != ";
  protected final String TEXT_1376 = ".length || ";
  protected final String TEXT_1377 = ".size() != ";
  protected final String TEXT_1378 = "())" + NL + "    {";
  protected final String TEXT_1379 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1380 = NL + "    ";
  protected final String TEXT_1381 = ".clear();";
  protected final String TEXT_1382 = NL + "    ";
  protected final String TEXT_1383 = ".addAll(";
  protected final String TEXT_1384 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1385 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1386 = NL + "  ";
  protected final String TEXT_1387 = " boolean ";
  protected final String TEXT_1388 = "(";
  protected final String TEXT_1389 = "... ";
  protected final String TEXT_1390 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1391 = NL + "    ArrayList<";
  protected final String TEXT_1392 = "> ";
  protected final String TEXT_1393 = " = new ArrayList<";
  protected final String TEXT_1394 = ">();" + NL + "    for (";
  protected final String TEXT_1395 = " ";
  protected final String TEXT_1396 = " : ";
  protected final String TEXT_1397 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1398 = ".contains(";
  protected final String TEXT_1399 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1400 = NL + "      ";
  protected final String TEXT_1401 = ".add(";
  protected final String TEXT_1402 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1403 = ".size() != ";
  protected final String TEXT_1404 = ".length)" + NL + "    {";
  protected final String TEXT_1405 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1406 = NL + "    ";
  protected final String TEXT_1407 = ".clear();";
  protected final String TEXT_1408 = NL + "    ";
  protected final String TEXT_1409 = ".addAll(";
  protected final String TEXT_1410 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1411 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1412 = NL + "  public boolean ";
  protected final String TEXT_1413 = "(";
  protected final String TEXT_1414 = " ";
  protected final String TEXT_1415 = ")" + NL + "  {" + NL + "    //" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "    boolean wasSet = false;";
  protected final String TEXT_1416 = NL + "    ";
  protected final String TEXT_1417 = " ";
  protected final String TEXT_1418 = " = ";
  protected final String TEXT_1419 = ";" + NL + "" + NL + "    if (";
  protected final String TEXT_1420 = " == null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1421 = " != null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1422 = ".";
  protected final String TEXT_1423 = "(this))" + NL + "        {";
  protected final String TEXT_1424 = NL + "          ";
  protected final String TEXT_1425 = " = ";
  protected final String TEXT_1426 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if (";
  protected final String TEXT_1427 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1428 = " == null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1429 = ".";
  protected final String TEXT_1430 = "() < ";
  protected final String TEXT_1431 = ".";
  protected final String TEXT_1432 = "())" + NL + "        {";
  protected final String TEXT_1433 = NL + "          ";
  protected final String TEXT_1434 = ".";
  protected final String TEXT_1435 = "(this);";
  protected final String TEXT_1436 = NL + "          ";
  protected final String TEXT_1437 = " = ";
  protected final String TEXT_1438 = ";  // ";
  protected final String TEXT_1439 = " == null" + NL + "          wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if (";
  protected final String TEXT_1440 = ".";
  protected final String TEXT_1441 = "() < ";
  protected final String TEXT_1442 = ".";
  protected final String TEXT_1443 = "())" + NL + "        {";
  protected final String TEXT_1444 = NL + "          ";
  protected final String TEXT_1445 = ".";
  protected final String TEXT_1446 = "(this);";
  protected final String TEXT_1447 = NL + "          ";
  protected final String TEXT_1448 = ".";
  protected final String TEXT_1449 = "(this);";
  protected final String TEXT_1450 = NL + "          ";
  protected final String TEXT_1451 = " = ";
  protected final String TEXT_1452 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if (wasSet)" + NL + "    {";
  protected final String TEXT_1453 = NL + "      ";
  protected final String TEXT_1454 = " = ";
  protected final String TEXT_1455 = ";" + NL + "    }" + NL + "    return wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_1456 = NL + "//  public boolean ";
  protected final String TEXT_1457 = "(";
  protected final String TEXT_1458 = " ";
  protected final String TEXT_1459 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_1460 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//" + NL + "//    boolean wasSet = false;" + NL + "//    ";
  protected final String TEXT_1461 = " ";
  protected final String TEXT_1462 = " = ";
  protected final String TEXT_1463 = ";" + NL + "//  " + NL + "//    if (";
  protected final String TEXT_1464 = " == null)" + NL + "//    {  " + NL + "//      if (";
  protected final String TEXT_1465 = " != null)" + NL + "//      { " + NL + "//        if (";
  protected final String TEXT_1466 = ".";
  protected final String TEXT_1467 = "(this))" + NL + "//          ";
  protected final String TEXT_1468 = " = ";
  protected final String TEXT_1469 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    else" + NL + "//    {" + NL + "//      if (";
  protected final String TEXT_1470 = " != null)" + NL + "//      {" + NL + "//        if (";
  protected final String TEXT_1471 = " == null)" + NL + "//        {" + NL + "//          if (";
  protected final String TEXT_1472 = ".";
  protected final String TEXT_1473 = " < ";
  protected final String TEXT_1474 = ".";
  protected final String TEXT_1475 = ")" + NL + "//            ";
  protected final String TEXT_1476 = ".";
  protected final String TEXT_1477 = "(this);" + NL + "//            ";
  protected final String TEXT_1478 = " = ";
  protected final String TEXT_1479 = "  // ";
  protected final String TEXT_1480 = " == null;" + NL + "//            wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//      else" + NL + "//      {" + NL + "//        if (   ";
  protected final String TEXT_1481 = ".";
  protected final String TEXT_1482 = " < ";
  protected final String TEXT_1483 = ".";
  protected final String TEXT_1484 = "()" + NL + "//            && ";
  protected final String TEXT_1485 = ".";
  protected final String TEXT_1486 = " > ";
  protected final String TEXT_1487 = ".";
  protected final String TEXT_1488 = "()" + NL + "//           )" + NL + "//          ";
  protected final String TEXT_1489 = ".";
  protected final String TEXT_1490 = "(this);" + NL + "//          ";
  protected final String TEXT_1491 = ".";
  protected final String TEXT_1492 = "(this);" + NL + "//          ";
  protected final String TEXT_1493 = " = ";
  protected final String TEXT_1494 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    " + NL + "//    if (wasSet)" + NL + "//    {" + NL + "//      ";
  protected final String TEXT_1495 = " = ";
  protected final String TEXT_1496 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return wasSet;" + NL + "//  }";
  protected final String TEXT_1497 = NL + "  public boolean ";
  protected final String TEXT_1498 = "(";
  protected final String TEXT_1499 = "... ";
  protected final String TEXT_1500 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1501 = NL + "    ArrayList<";
  protected final String TEXT_1502 = "> ";
  protected final String TEXT_1503 = " = new ArrayList<";
  protected final String TEXT_1504 = ">();" + NL + "    for (";
  protected final String TEXT_1505 = " ";
  protected final String TEXT_1506 = " : ";
  protected final String TEXT_1507 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1508 = ".contains(";
  protected final String TEXT_1509 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1510 = NL + "      ";
  protected final String TEXT_1511 = ".add(";
  protected final String TEXT_1512 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1513 = ".size() != ";
  protected final String TEXT_1514 = ".length || ";
  protected final String TEXT_1515 = ".size() < ";
  protected final String TEXT_1516 = "() || ";
  protected final String TEXT_1517 = ".size() > ";
  protected final String TEXT_1518 = "())" + NL + "    {";
  protected final String TEXT_1519 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1520 = "> ";
  protected final String TEXT_1521 = " = new ArrayList<";
  protected final String TEXT_1522 = ">(";
  protected final String TEXT_1523 = ");";
  protected final String TEXT_1524 = NL + "    ";
  protected final String TEXT_1525 = ".clear();" + NL + "    for (";
  protected final String TEXT_1526 = " ";
  protected final String TEXT_1527 = " : ";
  protected final String TEXT_1528 = ")" + NL + "    {";
  protected final String TEXT_1529 = NL + "      ";
  protected final String TEXT_1530 = ".add(";
  protected final String TEXT_1531 = ");" + NL + "      if (";
  protected final String TEXT_1532 = ".contains(";
  protected final String TEXT_1533 = "))" + NL + "      {";
  protected final String TEXT_1534 = NL + "        ";
  protected final String TEXT_1535 = ".remove(";
  protected final String TEXT_1536 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1537 = NL + "        ";
  protected final String TEXT_1538 = ".";
  protected final String TEXT_1539 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1540 = " ";
  protected final String TEXT_1541 = " : ";
  protected final String TEXT_1542 = ")" + NL + "    {";
  protected final String TEXT_1543 = NL + "      ";
  protected final String TEXT_1544 = ".";
  protected final String TEXT_1545 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1546 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1547 = NL + "  public boolean ";
  protected final String TEXT_1548 = "(";
  protected final String TEXT_1549 = "... ";
  protected final String TEXT_1550 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1551 = NL + "    ArrayList<";
  protected final String TEXT_1552 = "> ";
  protected final String TEXT_1553 = " = new ArrayList<";
  protected final String TEXT_1554 = ">();" + NL + "    for (";
  protected final String TEXT_1555 = " ";
  protected final String TEXT_1556 = " : ";
  protected final String TEXT_1557 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1558 = ".contains(";
  protected final String TEXT_1559 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1560 = NL + "      ";
  protected final String TEXT_1561 = ".add(";
  protected final String TEXT_1562 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1563 = ".size() != ";
  protected final String TEXT_1564 = ".length || ";
  protected final String TEXT_1565 = ".size() < ";
  protected final String TEXT_1566 = "())" + NL + "    {";
  protected final String TEXT_1567 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1568 = "> ";
  protected final String TEXT_1569 = " = new ArrayList<";
  protected final String TEXT_1570 = ">(";
  protected final String TEXT_1571 = ");";
  protected final String TEXT_1572 = NL + "    ";
  protected final String TEXT_1573 = ".clear();" + NL + "    for (";
  protected final String TEXT_1574 = " ";
  protected final String TEXT_1575 = " : ";
  protected final String TEXT_1576 = ")" + NL + "    {";
  protected final String TEXT_1577 = NL + "      ";
  protected final String TEXT_1578 = ".add(";
  protected final String TEXT_1579 = ");" + NL + "      if (";
  protected final String TEXT_1580 = ".contains(";
  protected final String TEXT_1581 = "))" + NL + "      {";
  protected final String TEXT_1582 = NL + "        ";
  protected final String TEXT_1583 = ".remove(";
  protected final String TEXT_1584 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1585 = NL + "        ";
  protected final String TEXT_1586 = ".";
  protected final String TEXT_1587 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1588 = " ";
  protected final String TEXT_1589 = " : ";
  protected final String TEXT_1590 = ")" + NL + "    {";
  protected final String TEXT_1591 = NL + "      ";
  protected final String TEXT_1592 = ".";
  protected final String TEXT_1593 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1594 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1595 = NL + "  ";
  protected final String TEXT_1596 = " boolean ";
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
  protected final String TEXT_1618 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1619 = NL + "    ";
  protected final String TEXT_1620 = ".clear();";
  protected final String TEXT_1621 = NL + "    ";
  protected final String TEXT_1622 = ".addAll(";
  protected final String TEXT_1623 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1624 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1625 = NL + "  public boolean ";
  protected final String TEXT_1626 = "(";
  protected final String TEXT_1627 = "... ";
  protected final String TEXT_1628 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1629 = NL + "    if (";
  protected final String TEXT_1630 = ".length < ";
  protected final String TEXT_1631 = "()";
  protected final String TEXT_1632 = ")" + NL + "    {";
  protected final String TEXT_1633 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1634 = "> ";
  protected final String TEXT_1635 = " = new ArrayList<";
  protected final String TEXT_1636 = ">();" + NL + "    HashMap<";
  protected final String TEXT_1637 = ",Integer> ";
  protected final String TEXT_1638 = " = new HashMap<";
  protected final String TEXT_1639 = ",Integer>();" + NL + "    for (";
  protected final String TEXT_1640 = " ";
  protected final String TEXT_1641 = " : ";
  protected final String TEXT_1642 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1643 = ".contains(";
  protected final String TEXT_1644 = "))" + NL + "      {";
  protected final String TEXT_1645 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1646 = ".";
  protected final String TEXT_1647 = "() != null && !this.equals(";
  protected final String TEXT_1648 = ".";
  protected final String TEXT_1649 = "()))" + NL + "      {";
  protected final String TEXT_1650 = NL + "        ";
  protected final String TEXT_1651 = " ";
  protected final String TEXT_1652 = " = ";
  protected final String TEXT_1653 = ".";
  protected final String TEXT_1654 = "();" + NL + "        if (!";
  protected final String TEXT_1655 = ".containsKey(";
  protected final String TEXT_1656 = "))" + NL + "        {";
  protected final String TEXT_1657 = NL + "          ";
  protected final String TEXT_1658 = ".put(";
  protected final String TEXT_1659 = ", new Integer(";
  protected final String TEXT_1660 = ".";
  protected final String TEXT_1661 = "()));" + NL + "        }" + NL + "        Integer currentCount = ";
  protected final String TEXT_1662 = ".get(";
  protected final String TEXT_1663 = ");" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_1664 = ")" + NL + "        {";
  protected final String TEXT_1665 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_1666 = NL + "        ";
  protected final String TEXT_1667 = ".put(";
  protected final String TEXT_1668 = ", new Integer(nextCount));" + NL + "      }";
  protected final String TEXT_1669 = NL + "      ";
  protected final String TEXT_1670 = ".add(";
  protected final String TEXT_1671 = ");" + NL + "    }" + NL;
  protected final String TEXT_1672 = NL + "    ";
  protected final String TEXT_1673 = ".removeAll(";
  protected final String TEXT_1674 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_1675 = " orphan : ";
  protected final String TEXT_1676 = ")" + NL + "    {";
  protected final String TEXT_1677 = NL + "      ";
  protected final String TEXT_1678 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1679 = NL + "    ";
  protected final String TEXT_1680 = ".clear();" + NL + "    for (";
  protected final String TEXT_1681 = " ";
  protected final String TEXT_1682 = " : ";
  protected final String TEXT_1683 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1684 = ".";
  protected final String TEXT_1685 = "() != null)" + NL + "      {";
  protected final String TEXT_1686 = NL + "        ";
  protected final String TEXT_1687 = ".";
  protected final String TEXT_1688 = "().";
  protected final String TEXT_1689 = ".remove(";
  protected final String TEXT_1690 = ");" + NL + "      }";
  protected final String TEXT_1691 = NL + "      ";
  protected final String TEXT_1692 = "(";
  protected final String TEXT_1693 = ", this);";
  protected final String TEXT_1694 = NL + "      ";
  protected final String TEXT_1695 = ".add(";
  protected final String TEXT_1696 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1697 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1698 = NL + "  private void ";
  protected final String TEXT_1699 = "(";
  protected final String TEXT_1700 = " ";
  protected final String TEXT_1701 = ", ";
  protected final String TEXT_1702 = " ";
  protected final String TEXT_1703 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1704 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1705 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1706 = ", ";
  protected final String TEXT_1707 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1708 = " to ";
  protected final String TEXT_1709 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1710 = NL + "  ";
  protected final String TEXT_1711 = " boolean ";
  protected final String TEXT_1712 = "(";
  protected final String TEXT_1713 = "... ";
  protected final String TEXT_1714 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1715 = NL + "    ArrayList<";
  protected final String TEXT_1716 = "> ";
  protected final String TEXT_1717 = " = new ArrayList<";
  protected final String TEXT_1718 = ">();" + NL + "    for (";
  protected final String TEXT_1719 = " ";
  protected final String TEXT_1720 = " : ";
  protected final String TEXT_1721 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1722 = ".contains(";
  protected final String TEXT_1723 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1724 = NL + "      ";
  protected final String TEXT_1725 = ".add(";
  protected final String TEXT_1726 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1727 = ".size() != ";
  protected final String TEXT_1728 = ".length || ";
  protected final String TEXT_1729 = ".size() > ";
  protected final String TEXT_1730 = "())" + NL + "    {";
  protected final String TEXT_1731 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1732 = NL + "    ";
  protected final String TEXT_1733 = ".clear();";
  protected final String TEXT_1734 = NL + "    ";
  protected final String TEXT_1735 = ".addAll(";
  protected final String TEXT_1736 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1737 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1738 = NL + "  ";
  protected final String TEXT_1739 = " boolean ";
  protected final String TEXT_1740 = "(";
  protected final String TEXT_1741 = "... ";
  protected final String TEXT_1742 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1743 = NL + "    ArrayList<";
  protected final String TEXT_1744 = "> ";
  protected final String TEXT_1745 = " = new ArrayList<";
  protected final String TEXT_1746 = ">();" + NL + "    for (";
  protected final String TEXT_1747 = " ";
  protected final String TEXT_1748 = " : ";
  protected final String TEXT_1749 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1750 = ".contains(";
  protected final String TEXT_1751 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1752 = NL + "      ";
  protected final String TEXT_1753 = ".add(";
  protected final String TEXT_1754 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1755 = ".size() != ";
  protected final String TEXT_1756 = ".length || ";
  protected final String TEXT_1757 = ".size() < ";
  protected final String TEXT_1758 = "())" + NL + "    {";
  protected final String TEXT_1759 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1760 = NL + "    ";
  protected final String TEXT_1761 = ".clear();";
  protected final String TEXT_1762 = NL + "    ";
  protected final String TEXT_1763 = ".addAll(";
  protected final String TEXT_1764 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_1765 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1766 = NL + "  ";
  protected final String TEXT_1767 = NL + "  public boolean ";
  protected final String TEXT_1768 = "(";
  protected final String TEXT_1769 = " ";
  protected final String TEXT_1770 = ", int index)" + NL + "  {  " + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_1771 = "(";
  protected final String TEXT_1772 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_1773 = "()) { index = ";
  protected final String TEXT_1774 = "() - 1; }";
  protected final String TEXT_1775 = NL + "      ";
  protected final String TEXT_1776 = ".remove(";
  protected final String TEXT_1777 = ");";
  protected final String TEXT_1778 = NL + "      ";
  protected final String TEXT_1779 = ".add(index, ";
  protected final String TEXT_1780 = ");";
  protected final String TEXT_1781 = NL + "      wasAdded = true;" + NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1782 = "(";
  protected final String TEXT_1783 = " ";
  protected final String TEXT_1784 = ", int index)" + NL + "  {" + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_1785 = ".contains(";
  protected final String TEXT_1786 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_1787 = "()) { index = ";
  protected final String TEXT_1788 = "() - 1; }";
  protected final String TEXT_1789 = NL + "      ";
  protected final String TEXT_1790 = ".remove(";
  protected final String TEXT_1791 = ");";
  protected final String TEXT_1792 = NL + "      ";
  protected final String TEXT_1793 = ".add(index, ";
  protected final String TEXT_1794 = ");";
  protected final String TEXT_1795 = NL + "      wasAdded = true;" + NL + "    } " + NL + "    else " + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_1796 = "(";
  protected final String TEXT_1797 = ", index);";
  protected final String TEXT_1798 = NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL;
  protected final String TEXT_1799 = NL + "  public boolean equals(Object obj)" + NL + "  {" + NL + "    if (obj == null) { return false; }" + NL + "    if (!getClass().equals(obj.getClass())) { return false; }" + NL;
  protected final String TEXT_1800 = NL + "    ";
  protected final String TEXT_1801 = " compareTo = (";
  protected final String TEXT_1802 = ")obj;" + NL + "  ";
  protected final String TEXT_1803 = NL + "    ";
  protected final String TEXT_1804 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public int hashCode()" + NL + "  {" + NL + "    if (cachedHashCode != -1)" + NL + "    {" + NL + "      return cachedHashCode;" + NL + "    }" + NL + "    cachedHashCode = 17;";
  protected final String TEXT_1805 = NL + "    ";
  protected final String TEXT_1806 = NL;
  protected final String TEXT_1807 = NL + "    ";
  protected final String TEXT_1808 = NL + "    return cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1809 = NL + "  // line ";
  protected final String TEXT_1810 = " \"";
  protected final String TEXT_1811 = "\"";
  protected final String TEXT_1812 = NL + "  private void ";
  protected final String TEXT_1813 = "()" + NL + "  {" + NL + "    try" + NL + "    {";
  protected final String TEXT_1814 = NL + "      ";
  protected final String TEXT_1815 = NL + "      Thread.sleep(1);";
  protected final String TEXT_1816 = NL + "    }" + NL + "    catch (InterruptedException e)" + NL + "    {" + NL + "" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1817 = NL + "  // line ";
  protected final String TEXT_1818 = " \"";
  protected final String TEXT_1819 = "\"";
  protected final String TEXT_1820 = NL + "  private void ";
  protected final String TEXT_1821 = "()" + NL + "  {" + NL + "    try" + NL + "    {";
  protected final String TEXT_1822 = NL + "      ";
  protected final String TEXT_1823 = NL + "      Thread.sleep(1);";
  protected final String TEXT_1824 = NL + "    }" + NL + "    catch (InterruptedException e)" + NL + "    {" + NL + "" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1825 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1826 = NL + "    ";
  protected final String TEXT_1827 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1828 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    public void run()" + NL + "    {";
  protected final String TEXT_1829 = NL + "      ";
  protected final String TEXT_1830 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1831 = NL + "  private void ";
  protected final String TEXT_1832 = "()" + NL + "  {";
  protected final String TEXT_1833 = NL + "    ";
  protected final String TEXT_1834 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1835 = "\",";
  protected final String TEXT_1836 = ");" + NL + "  }" + NL + "" + NL + "  private void ";
  protected final String TEXT_1837 = "()" + NL + "  {";
  protected final String TEXT_1838 = NL + "    ";
  protected final String TEXT_1839 = ".stop();" + NL + "  }" + NL;
  protected final String TEXT_1840 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1841 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1842 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    public void stop()" + NL + "    {" + NL + "      timer.cancel();" + NL + "    }" + NL + "    " + NL + "    public void run ()" + NL + "    {";
  protected final String TEXT_1843 = NL + "      if (\"";
  protected final String TEXT_1844 = "\".equals(timeoutMethodName))" + NL + "      {" + NL + "        boolean shouldRestart = !controller.";
  protected final String TEXT_1845 = "();" + NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1846 = "();" + NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1847 = NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1848 = NL + "    ";
  protected final String TEXT_1849 = " = null;";
  protected final String TEXT_1850 = NL + "    ";
  protected final String TEXT_1851 = ".clear();";
  protected final String TEXT_1852 = NL + "    ";
  protected final String TEXT_1853 = " ";
  protected final String TEXT_1854 = " = ";
  protected final String TEXT_1855 = ";";
  protected final String TEXT_1856 = NL + "    ";
  protected final String TEXT_1857 = " = null;" + NL + "    if (";
  protected final String TEXT_1858 = " != null)" + NL + "    {";
  protected final String TEXT_1859 = NL + "      ";
  protected final String TEXT_1860 = ".delete();" + NL + "    }";
  protected final String TEXT_1861 = NL + "    if (";
  protected final String TEXT_1862 = " != null)" + NL + "    {";
  protected final String TEXT_1863 = NL + "      ";
  protected final String TEXT_1864 = ".";
  protected final String TEXT_1865 = "(null);" + NL + "    }";
  protected final String TEXT_1866 = NL + "    ";
  protected final String TEXT_1867 = " ";
  protected final String TEXT_1868 = " = ";
  protected final String TEXT_1869 = ";";
  protected final String TEXT_1870 = NL + "    ";
  protected final String TEXT_1871 = " = null;" + NL + "    if (";
  protected final String TEXT_1872 = " != null)" + NL + "    {";
  protected final String TEXT_1873 = NL + "      ";
  protected final String TEXT_1874 = ".";
  protected final String TEXT_1875 = "(null);" + NL + "    }";
  protected final String TEXT_1876 = NL + "    ";
  protected final String TEXT_1877 = " ";
  protected final String TEXT_1878 = " = ";
  protected final String TEXT_1879 = ";";
  protected final String TEXT_1880 = NL + "    ";
  protected final String TEXT_1881 = " = null;" + NL + "    if (";
  protected final String TEXT_1882 = " != null)" + NL + "    {";
  protected final String TEXT_1883 = NL + "      ";
  protected final String TEXT_1884 = ".delete();" + NL + "    }";
  protected final String TEXT_1885 = NL + "    if (";
  protected final String TEXT_1886 = " != null)" + NL + "    {";
  protected final String TEXT_1887 = NL + "      ";
  protected final String TEXT_1888 = " ";
  protected final String TEXT_1889 = " = ";
  protected final String TEXT_1890 = ";" + NL + "      this.";
  protected final String TEXT_1891 = " = null;";
  protected final String TEXT_1892 = NL + "      ";
  protected final String TEXT_1893 = ".";
  protected final String TEXT_1894 = "(this);" + NL + "    }";
  protected final String TEXT_1895 = NL + "    if (";
  protected final String TEXT_1896 = " != null)" + NL + "    {";
  protected final String TEXT_1897 = NL + "      ";
  protected final String TEXT_1898 = ".delete();" + NL + "    }";
  protected final String TEXT_1899 = NL + "    if (";
  protected final String TEXT_1900 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1901 = ".";
  protected final String TEXT_1902 = "() <= ";
  protected final String TEXT_1903 = ")" + NL + "      {";
  protected final String TEXT_1904 = NL + "        ";
  protected final String TEXT_1905 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1906 = NL + "        ";
  protected final String TEXT_1907 = " ";
  protected final String TEXT_1908 = " = ";
  protected final String TEXT_1909 = ";" + NL + "        this.";
  protected final String TEXT_1910 = " = null;";
  protected final String TEXT_1911 = NL + "        ";
  protected final String TEXT_1912 = ".";
  protected final String TEXT_1913 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1914 = NL + "    ";
  protected final String TEXT_1915 = " ";
  protected final String TEXT_1916 = " = ";
  protected final String TEXT_1917 = ";" + NL + "    this.";
  protected final String TEXT_1918 = " = null;";
  protected final String TEXT_1919 = NL + "    ";
  protected final String TEXT_1920 = ".";
  protected final String TEXT_1921 = "(this);";
  protected final String TEXT_1922 = NL + "    for(";
  protected final String TEXT_1923 = " ";
  protected final String TEXT_1924 = " : ";
  protected final String TEXT_1925 = ")" + NL + "    {";
  protected final String TEXT_1926 = NL + "      ";
  protected final String TEXT_1927 = "(";
  protected final String TEXT_1928 = ",null);" + NL + "    }";
  protected final String TEXT_1929 = NL + "    ";
  protected final String TEXT_1930 = ".clear();";
  protected final String TEXT_1931 = NL + "    ArrayList<";
  protected final String TEXT_1932 = "> ";
  protected final String TEXT_1933 = " = new ArrayList<";
  protected final String TEXT_1934 = ">(";
  protected final String TEXT_1935 = ");";
  protected final String TEXT_1936 = NL + "    ";
  protected final String TEXT_1937 = ".clear();" + NL + "    for(";
  protected final String TEXT_1938 = " ";
  protected final String TEXT_1939 = " : ";
  protected final String TEXT_1940 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1941 = ".";
  protected final String TEXT_1942 = "() <= ";
  protected final String TEXT_1943 = ".";
  protected final String TEXT_1944 = "())" + NL + "      {";
  protected final String TEXT_1945 = NL + "        ";
  protected final String TEXT_1946 = ".delete();" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1947 = NL + "        ";
  protected final String TEXT_1948 = ".";
  protected final String TEXT_1949 = "(this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1950 = NL + "    ArrayList<";
  protected final String TEXT_1951 = "> ";
  protected final String TEXT_1952 = " = new ArrayList<";
  protected final String TEXT_1953 = ">(";
  protected final String TEXT_1954 = ");";
  protected final String TEXT_1955 = NL + "    ";
  protected final String TEXT_1956 = ".clear();" + NL + "    for(";
  protected final String TEXT_1957 = " ";
  protected final String TEXT_1958 = " : ";
  protected final String TEXT_1959 = ")" + NL + "    {";
  protected final String TEXT_1960 = NL + "      ";
  protected final String TEXT_1961 = ".";
  protected final String TEXT_1962 = "(this);" + NL + "    }";
  protected final String TEXT_1963 = NL + "    for(int i=";
  protected final String TEXT_1964 = ".size(); i > 0; i--)" + NL + "    {";
  protected final String TEXT_1965 = NL + "      ";
  protected final String TEXT_1966 = " ";
  protected final String TEXT_1967 = " = ";
  protected final String TEXT_1968 = ".get(i - 1);";
  protected final String TEXT_1969 = NL + "      ";
  protected final String TEXT_1970 = ".delete();" + NL + "    }";
  protected final String TEXT_1971 = NL + "    for(";
  protected final String TEXT_1972 = " ";
  protected final String TEXT_1973 = " : ";
  protected final String TEXT_1974 = ")" + NL + "    {";
  protected final String TEXT_1975 = NL + "      ";
  protected final String TEXT_1976 = ".";
  protected final String TEXT_1977 = "(null);" + NL + "    }";
  protected final String TEXT_1978 = NL + NL + "  public String toString()" + NL + "  {" + NL + "\t  String outputString = \"\";" + NL + "\t  ";
  protected final String TEXT_1979 = NL + "  }";
  protected final String TEXT_1980 = "  " + NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1981 = NL + "  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler" + NL + "  {" + NL + "    public void uncaughtException(Thread t, Throwable e)" + NL + "    {" + NL + "      translate(e);" + NL + "      if(e.getCause()!=null)" + NL + "      {" + NL + "        translate(e.getCause());" + NL + "      }" + NL + "      e.printStackTrace();" + NL + "    }" + NL + "    public void translate(Throwable e)" + NL + "    {" + NL + "      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();" + NL + "      StackTraceElement[] elements = e.getStackTrace();" + NL + "      try" + NL + "      {" + NL + "        for(StackTraceElement element:elements)" + NL + "        {" + NL + "          Class clazz = Class.forName(element.getClassName());" + NL + "          String methodName = element.getMethodName();" + NL + "          boolean methodFound = false;" + NL + "          for(java.lang.reflect.Method meth:clazz.getDeclaredMethods())" + NL + "          {" + NL + "            if(meth.getName().equals(methodName))" + NL + "            {" + NL + "              int line = -1;" + NL + "              String file = \"\";" + NL + "              for(java.lang.annotation.Annotation anno: meth.getAnnotations())" + NL + "              {" + NL + "                if(anno.annotationType().getSimpleName().equals(\"umplesourcefile\"))" + NL + "                {" + NL + "                  int methodlength = (Integer)anno.annotationType().getMethod(\"length\", new Class[]{}).invoke(anno,new Object[]{});" + NL + "                  int distanceFromStart = (element.getLineNumber()-(Integer)anno.annotationType().getMethod(\"javaline\", new Class[]{}).invoke(anno,new Object[]{}));" + NL + "                  distanceFromStart-=(\"main\".equals(methodName))?2:0;" + NL + "                  line = (Integer)anno.annotationType().getMethod(\"line\", new Class[]{}).invoke(anno,new Object[]{})+distanceFromStart;" + NL + "                  file = (String)anno.annotationType().getMethod(\"file\", new Class[]{}).invoke(anno,new Object[]{});" + NL + "                  if(file == \"\")" + NL + "                  {" + NL + "                    break;" + NL + "                  }" + NL + "                  else if(distanceFromStart>=0&&distanceFromStart<=methodlength)" + NL + "                  {" + NL + "                    result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),file,line));" + NL + "                    methodFound = true;" + NL + "                    break;" + NL + "                  }" + NL + "                }" + NL + "              }" + NL + "              if(methodFound)" + NL + "              {" + NL + "                break;" + NL + "              }" + NL + "            }" + NL + "          }" + NL + "          if(!methodFound)" + NL + "          {" + NL + "            result.add(element);" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "      catch (Exception e1)" + NL + "      {" + NL + "        e1.printStackTrace();" + NL + "      }" + NL + "      e.setStackTrace(result.toArray(new StackTraceElement[0]));" + NL + "    }" + NL + "  }";
  protected final String TEXT_1982 = NL + "}";

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
    stringBuffer.append(TEXT_10);
    getMemberCode(stringBuffer, model,uClass,gClass,gen,isFirst);
  getConstructorCode(stringBuffer, model,uClass,gClass,gen,isFirst);
  getAttributeCode(stringBuffer, model,uClass,gClass,gen,isFirst);
  getStateMachine1Code(stringBuffer, model,uClass,gClass,gen,isFirst);
  getAssociationCode(stringBuffer, model,uClass,gClass,gen,isFirst);
  getEqualsCode(stringBuffer, model,uClass,gClass,gen,isFirst);
  getStateMachine2Code(stringBuffer, model,uClass,gClass,gen,isFirst);
  getDeleteCode(stringBuffer, model,uClass,gClass,gen,isFirst);
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
      append(stringBuffer, "  public static final {0} {1} = {2};", gen.getType(av), av.getName(), gen.translate("parameterValue",av));
    }
    else if (av.getIsAutounique())
    {
      String defaultValue = av.getValue() == null ? "1" : av.getValue();
      appendln(stringBuffer, "");
      append(stringBuffer, "  private static int next{0} = {1};", av.getUpperCaseName(), defaultValue);
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
    
    //if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); }
    
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
    private String getConstructorCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
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
    if (av.getIsAutounique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)) || av.getIsDerived())
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
         
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

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
        
    stringBuffer.append(TEXT_37);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_41);
    
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
  

    stringBuffer.append(TEXT_42);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_51);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        hasBody = true;
        
     String requiredNumber = StringFormatter.format("{0}", av.getMultiplicity().getUpperBound()); 
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_61);
    
      }
      else if (av.isMany() && av.isImmutable())
      {
      	hasBody = true;
        
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
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_70);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_71);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_73);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_82);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_85);
    
    }
    else
    {
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOnlyOne())
  {
    
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_92);
    
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
  

    stringBuffer.append(TEXT_93);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_102);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.getType(av));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_107);
    
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
      
    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_111);
    
    }
    
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_115);
    
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
    
    stringBuffer.append(TEXT_116);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_118);
    
  }

    
  if (isOneToOne)
  {
    
    
  
  String signature = gClass.getLookup("constructorSignature_mandatory");
  hasBody = false;

    stringBuffer.append(TEXT_119);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_121);
    
  if (!uClass.isRoot())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    super({0});", gClass.getParentClass().getLookup("constructorSignature_caller"));
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
      
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_124);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_126);
     
    }
    else
    {
      hasBody = true;
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_129);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_132);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_133);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    stringBuffer.append(TEXT_136);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_139);
    
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
    
    stringBuffer.append(TEXT_140);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_146);
    
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
  

    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_156);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.getType(av));
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


    return stringBuffer.toString();
    } 
    private String getAttributeCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
    stringBuffer.append(TEXT_162);
    
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
        
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_166);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_167);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(TEXT_169);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_170);
    stringBuffer.append( gen.translate("associationOne",av));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(TEXT_173);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_174);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_175);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_176);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_179);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_180);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_181);
    stringBuffer.append( gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(TEXT_184);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_185);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_186);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_187);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_188);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_t", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_189);
    stringBuffer.append( gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(TEXT_192);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_t", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_193);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_194);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_198);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_199);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_a", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(TEXT_203);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_a", uClass)+"\n":"")
);
     if (customAddPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_207);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_208);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_r", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(TEXT_212);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_r", uClass)+"\n":"")
);
     if (customRemovePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); }

    stringBuffer.append(TEXT_213);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_214);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_217);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_218);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(TEXT_222);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_223);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_224);
    
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
    
    if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_225);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_227);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_228);
    stringBuffer.append( gen.translate("typeMany",av));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(TEXT_232);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_236);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_237);
    stringBuffer.append( gen.translate("typeMany",av));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(TEXT_243);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_ga", uClass)+"\n":"")
);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_244);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_246);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_247);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(TEXT_249);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_n", uClass, "number")+"\n":"")
);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_251);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_252);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(TEXT_254);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_h", uClass)+"\n":"")
);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); }

    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(gen.translate("typeMany",av));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_258);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(TEXT_262);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_263);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_265);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_266);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_267);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_268);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_269);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(TEXT_271);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_272);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_273);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_275);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(TEXT_277);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_278);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_279);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_281);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_282);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_283);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_284);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(TEXT_287);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_288);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_289);
    
      }
      else
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_292);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_293);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_295);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_296);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_298);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_301);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(TEXT_303);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_305);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_308);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_309);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_310);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_311);
    
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
        
    stringBuffer.append(TEXT_312);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_313);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_314);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_315);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_316);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(TEXT_319);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_320);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_321);
    
      }
      else
      {
        
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_323);
    stringBuffer.append( gen.translate("getMethod",av) );
    stringBuffer.append(TEXT_324);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_325);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_327);
    
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
      
    stringBuffer.append(TEXT_328);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_329);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_330);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_331);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_332);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_333);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(TEXT_335);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
     if (customGetPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_336);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_337);
    
    }
    else if (av.getIsDerived())
    {
      
    stringBuffer.append(TEXT_338);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_339);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_340);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_341);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.translate("parameterValue",av));
    stringBuffer.append(TEXT_343);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_345);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_346);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_347);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_348);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_349);
    stringBuffer.append( gen.translate("attributeOne",av) );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(TEXT_351);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
     if (customGetPostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 

    stringBuffer.append(TEXT_352);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_353);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_355);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_356);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_357);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_i", uClass, gen.translate("parameterOne",av), "index")+"\n":"")
);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_359);
    
    }
      
    appendln(stringBuffer, "");
  }


    return stringBuffer.toString();
    } 
    private String getStateMachine1Code(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
    
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

    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("typeFull",sm));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_363);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_364);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_367);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_368);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for(Event e : uClass.getEvents())
  {
    
    
  StringBuffer allCases = new StringBuffer();
  StringBuffer allDeclarations = new StringBuffer();

  for(StateMachine sm : uClass.getStateMachines(e))
  {
    allDeclarations.append(StringFormatter.format("\n    {0} {1} = {2};",gen.translate("type",sm),gen.translate("parameterOne",sm),gen.translate("stateMachineOne", sm)));
    allCases.append(StringFormatter.format("\n    switch ({0})\n",gen.translate("parameterOne",sm)));
    allCases.append(StringFormatter.format("    {\n"));

    for(State state : sm.getStates())
    {
  	  TraceItem traceItem = state.getTraced("transition",uClass);
      List<Transition> allT = state.getTransitionsFor(e);
  
      if (allT.size() == 0)
      {
        continue;
      }

      allCases.append(StringFormatter.format("      case {0}:\n",gen.translate("stateOne",state)));

      boolean needsBreak = true;
      for (Transition t : allT)
      {
        
        State nextState = t.getNextState();
        String tabSpace = t.getGuard() == null ? "        " : "          ";
        StateMachine exitSm = state.exitableStateMachine(nextState);
        
        if (t.getGuard() != null)
        {
          allCases.append(StringFormatter.format("        if ({0})\n",t.getGuard().getCondition()));
          allCases.append(StringFormatter.format("        {\n"));
        }
        if (exitSm != null && !e.getIsInternal() && !state.isSameState(nextState,exitSm)) 
        {
          allCases.append(StringFormatter.format("{0}{1}();\n",tabSpace,gen.translate("exitMethod",exitSm)));
        }
        if (t.getAction() != null)
        {
          Action a1 = t.getAction();
          Position p = a1.getPosition();
        if (p != null) {
          allCases.append("        // line " + p.getLineNumber() + " \"" + p.getRelativePath(sm.getUmpleClass(), "Java") + "\"\n");
        }
          allCases.append(StringFormatter.format("{0}{1}\n",tabSpace,a1.getActionCode()));
        }
        allCases.append(traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, t,"sm_t", uClass)+"\n":"");
        allCases.append(StringFormatter.format("{0}{1}({2}.{3});\n",tabSpace,gen.translate("setMethod",nextState.getStateMachine()),gen.translate("type",nextState.getStateMachine()),gen.translate("stateOne",nextState)));
        allCases.append(traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, t,"sm_t", uClass)+"\n":"");
        
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
    allCases.append(StringFormatter.format("      default:\n"));
    allCases.append(StringFormatter.format("        // Other states do respond to this event\n"));
    allCases.append(StringFormatter.format("    }\n"));
    /*
    if(traceItem!=null)
    {
      //allCases.append("\n  "+traceItem.trace(gen, e, "  {0}Tracer.handle({1});","post"));
    }*/
  }

  //for( TraceDirective tc : uClass.getTraceDirectives() )
  //{
  //  for( StateMachineTraceItem tracedStm : tc .getStateMachineTraceItems() )
  //  {
  //      if( tracedStm.getTransition() != null || tracedStm.getTraceStateMachineFlag() )
 //      {
//        if( tc.getTraceRecord() != null )
//          allCases.append(StringFormatter.format("\n    System.err.println(\"state@post=\"+{0}+\",{1}=\"+{2});",tracedStm.getStateMachine().getName(),tc.getTraceRecord().getAttribute(0).getName(),tc.getTraceRecord().getAttribute(0).getName()));
//        else 
//          allCases.append(StringFormatter.format("\n    System.err.println(\"state@post=\"+{0});",tracedStm.getStateMachine().getName()));
//      }
//    
//    }
  //}
  
  String scope = e.getIsInternal() || e.isAutoTransition() ? "private" : "public";
  String eventOutput = allDeclarations.toString() + allCases.toString();

    stringBuffer.append(TEXT_369);
    stringBuffer.append( scope );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_371);
    stringBuffer.append( (e.getArgs()==null?"":e.getArgs()));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(TEXT_373);
    stringBuffer.append( eventOutput );
    stringBuffer.append(TEXT_374);
    
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

    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_376);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_377);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_378);
     if (!exitCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",exitCasesOutput); } 
     if (!enterCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",enterCasesOutput); } 
    stringBuffer.append(TEXT_379);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_380);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_381);
    
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
        TraceItem traceItem = state.getTraced("entry",uClass);
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
        entryActions.append(
        traceItem!=null/*&&traceItem.getIsPost()*/?traceItem.trace(gen, state,"sm_e", uClass)+"\n":"");
        Position p = action.getPosition();
        if (p != null) {
          entryActions.append("\n        // line " + p.getLineNumber() + " \"" + p.getRelativePath(sm.getUmpleClass(), "Java") + "\"");
        }
        entryActions.append("\n        " + action.getActionCode());
      }
      else if ("exit".equals(action.getActionType()))
      {
        TraceItem traceItem = state.getTraced("exit",uClass);
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
        exitActions.append(
        traceItem!=null/*&&traceItem.getIsPost()*/?traceItem.trace(gen, state,"sm_x", uClass)+"\n":"");        
        Position p = action.getPosition();
        if (p != null) {
          exitActions.append("\n        // line " + p.getLineNumber() + " \"" + p.getRelativePath(sm.getUmpleClass(), "Java") + "\"");
        }
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
//        if( traceRecord != null )
//        {
//          for( int j = 0 ; j < stm.numberOfStates() ; ++j )
//          {
//            State stat = stm.getState(j);
//
//            if( stat == state )
//            {
//              traceRecords.append("\n    ");
//              traceRecords.append("if( " + gen.translate("parameterOne",stm) + ".equals(" + gen.translate("type",stm) + "." + stat.getName() + ") )");
//              traceRecords.append("\n      ");
//              if( model.getTraceType().equals("Console"))
//              {
//                traceRecords.append(StringFormatter.format("System.out.println(\"action={0}-entry, {1}=\" + {2});",stat.getName(),traceRecord.getRecord(),traceRecord.getRecord()));
//               }
//               else if( model.getTraceType().equals("File"))
//              {
//                traceRecords.append(StringFormatter.format("fileTracer(\"action={0}-entry, {1}=\" + {2});",stat.getName(),traceRecord.getRecord(),traceRecord.getRecord()));
//              }
//            }
//           }
//        }
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
    stringBuffer.append(TEXT_382);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_383);
     if (customExitPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_384);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(TEXT_386);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_387);
     if (customExitPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_388);
     } 
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_390);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_391);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_392);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_393);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_394);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_395);
     if (parentState != null) { 
    stringBuffer.append(TEXT_396);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_397);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_398);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_399);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_400);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_401);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_403);
    stringBuffer.append( gen.translate("type",parentSm) );
    stringBuffer.append(TEXT_404);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_405);
     } 
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_406);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(TEXT_408);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_409);
    stringBuffer.append( traceRecords );
     } 
    stringBuffer.append(TEXT_410);
    
    }
  }
}

    
  return stringBuffer.toString();
    } 
    private String getAssociationCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
    
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
      
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_413);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"get", uClass, "!no arguments")))
   ,"    "):
   ""));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_415);
     } else { 
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_419);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"get", uClass, "")))
   ,"    "):
   ""));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_421);
     } 
    stringBuffer.append(TEXT_422);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_425);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"get", uClass, "index")))
   ,"    "):
   ""));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_431);
     if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}", Comment.format("Attribute Javadoc", av.getComments())); } 
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_434);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_438);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"get", uClass, gen.translate("parameterMany",av))))
   ,"    "):
   ""));
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_441);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_443);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"get", uClass, "number")))
   ,"    "):
   ""));
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_445);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_447);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"get", uClass, "has")))
   ,"    "):
   ""));
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_451);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_452);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_454);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"get", uClass, "index")))
   ,"    "):
   ""));
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_455);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_456);
    
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
      
    stringBuffer.append(TEXT_457);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_458);
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
      
    stringBuffer.append(TEXT_459);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_460);
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_463);
     } else { 
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_468);
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_469);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_471);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_472);
     } else { 
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_474);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_475);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_476);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_477);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_480);
     } else { 
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_482);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_483);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_484);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_485);
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
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_488);
     } else { 
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_490);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_491);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_492);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_493);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_497);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_500);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_501);
     } 
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"add", uClass, gen.translate("parameterOne",av))))
   ,"    "):
   ""));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_511);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_512);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_516);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_519);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_531);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_532);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_533);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_537);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_540);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_541);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_542);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_546);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_551);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_552);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_556);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_564);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_565);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_583);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_584);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_588);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_593);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_603);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_604);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_618);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_619);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_628);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"add", uClass, gen.translate("parameterNew",av))))
   ,"    "):
   ""));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_633);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(TEXT_646);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"\" + "+gen.relatedTranslate("parameterIsNew",av)+"?\"set\":\"add\" + \"", uClass, gen.translate("parameterOne",av))))
   ,"    "):
   ""));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_654);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_655);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_658);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_659);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_663);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_668);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_669);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"remove", uClass, gen.translate("parameterOne",av))))
   ,"    "):
   ""));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_673);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_674);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_685);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_688);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_689);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_701);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_709);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_713);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_718);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_723);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_724);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_727);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_728);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_739);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_740);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_742);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_743);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_758);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_762);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_770);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_771);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_775);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_791);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_818);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_819);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_828);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_843);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_847);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_855);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_856);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_860);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_874);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_875);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_897);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_898);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_902);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_905);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_908);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_920);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_921);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_925);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_928);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_931);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_943);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_944);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_948);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_954);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_955);
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_972);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_973);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_977);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_979);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_980);
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_996);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_997);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1001);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1005);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1012);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1028);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1032);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1033);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1037);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1041);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1047);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1063);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1067);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1068);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1072);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1092);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1096);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1105);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1106);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1110);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1127);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1128);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1132);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1135);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1156);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1160);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1169);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1170);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1174);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1180);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1184);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1187);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1190);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1194);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1195);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1199);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1202);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1203);
     } 
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1212);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1224);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1228);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1239);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1240);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1244);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1253);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1258);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1264);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1283);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1296);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1300);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1303);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1307);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1313);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1314);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1318);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1324);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1328);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1334);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1335);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1339);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1342);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1346);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1349);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1352);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1356);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1357);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1358);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1362);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1378);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1384);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1385);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1386);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1390);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1404);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1410);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1411);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1455);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1496);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1500);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1503);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1518);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1545);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1546);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1550);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1558);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1566);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1593);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1594);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1595);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1599);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
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
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1623);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1624);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1625);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1628);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1629);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1632);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1644);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1664);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1673);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(TEXT_1677);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1678);
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1682);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1687);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1688);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1692);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1696);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(TEXT_1698);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1701);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1703);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1704);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1705);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1706);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1707);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1708);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1709);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1710);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1713);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1714);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1716);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1718);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1719);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1720);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1721);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1722);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1723);
    stringBuffer.append(TEXT_1724);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1725);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1726);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1727);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1728);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1730);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1731);
    stringBuffer.append(TEXT_1732);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1733);
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1735);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1736);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1737);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1738);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1739);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1740);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1741);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1742);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1743);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1744);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1745);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1746);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1747);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1749);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1750);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1751);
    stringBuffer.append(TEXT_1752);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1753);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1754);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1755);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1756);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1757);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1758);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1759);
    stringBuffer.append(TEXT_1760);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1761);
    stringBuffer.append(TEXT_1762);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1763);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1764);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1765);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
    }
    
    if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
    {
      
    stringBuffer.append(TEXT_1766);
    
      sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
    }
    else if(includeFile3 == "association_AddIndexControlFunctions.jet")
    {
      
    stringBuffer.append(TEXT_1767);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1768);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1769);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1770);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1771);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1772);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1773);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1774);
    stringBuffer.append(TEXT_1775);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1776);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1777);
    stringBuffer.append(TEXT_1778);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1779);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1780);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"add", uClass, gen.translate("parameterOne",av), "index")))
   ,"      "):
   ""));
    stringBuffer.append(TEXT_1781);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_1782);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1783);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1784);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1785);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1786);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1787);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1788);
    stringBuffer.append(TEXT_1789);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1790);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1791);
    stringBuffer.append(TEXT_1792);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1793);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1794);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"add", uClass, gen.translate("parameterOne",av), "index")))
   ,"      "):
   ""));
    stringBuffer.append(TEXT_1795);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1796);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1797);
    stringBuffer.append( 
    (traceItem!=null?
  "\n"+GeneratorHelper.doIndent(
    StringFormatter.format(traceItem.getExtremities(gen,av.getName()),
      StringFormatter.format(
        "{0}Tracer.handle( {1}  + new Date());", 
        traceItem.getTracerType(), 
        traceItem.trace(gen, av,"add", uClass, gen.translate("parameterOne",av), "index")))
   ,"      "):
   ""));
    stringBuffer.append(TEXT_1798);
    
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


    stringBuffer.append(TEXT_1799);
    stringBuffer.append(TEXT_1800);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1801);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append(TEXT_1802);
    stringBuffer.append(TEXT_1803);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1804);
    stringBuffer.append(TEXT_1805);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1806);
    stringBuffer.append(TEXT_1807);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1808);
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
    stringBuffer.append(TEXT_1809);
    stringBuffer.append( p.getLineNumber() );
    stringBuffer.append(TEXT_1810);
    stringBuffer.append( p.getRelativePath(sm.getUmpleClass(), "Java") );
    stringBuffer.append(TEXT_1811);
     } 
    stringBuffer.append(TEXT_1812);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1813);
    stringBuffer.append(TEXT_1814);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1815);
     if (postTransition != null) { append(stringBuffer, "\n      {0}();",postTransition); } 
    stringBuffer.append(TEXT_1816);
    
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
    stringBuffer.append(TEXT_1817);
    stringBuffer.append( p.getLineNumber() );
    stringBuffer.append(TEXT_1818);
    stringBuffer.append( p.getRelativePath(sm.getUmpleClass(), "Java") );
    stringBuffer.append(TEXT_1819);
     } 
    stringBuffer.append(TEXT_1820);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1821);
    stringBuffer.append(TEXT_1822);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1823);
     if (postTransition != null) { append(stringBuffer, "\n      {0}();",postTransition); } 
    stringBuffer.append(TEXT_1824);
    
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

    stringBuffer.append(TEXT_1825);
    stringBuffer.append(TEXT_1826);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1827);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1828);
    stringBuffer.append(TEXT_1829);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1830);
    
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
        
    stringBuffer.append(TEXT_1831);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1832);
    stringBuffer.append(TEXT_1833);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1834);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1835);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1836);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1837);
    stringBuffer.append(TEXT_1838);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1839);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1840);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1841);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1842);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1843);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1844);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1845);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1846);
    
      }
    }
  }

    stringBuffer.append(TEXT_1847);
    
  }
}

    return stringBuffer.toString();
    } 
    private String getDeleteCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
    

  appendln(stringBuffer,"");
  appendln(stringBuffer,"  public void delete()");
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
    
    if (!av.getIsNavigable() || av.isImmutable())
    {
      continue;
    }
    
    if (!relatedAssociation.getIsNavigable())
    {
      if (av.isOne())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1848);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1849);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1850);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1851);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1852);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1853);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1854);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1855);
    stringBuffer.append(TEXT_1856);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1857);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1858);
    stringBuffer.append(TEXT_1859);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1860);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1861);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1862);
    stringBuffer.append(TEXT_1863);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1864);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1865);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1866);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1867);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1868);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1869);
    stringBuffer.append(TEXT_1870);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1871);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1872);
    stringBuffer.append(TEXT_1873);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1874);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1875);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1876);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1877);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1878);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1879);
    stringBuffer.append(TEXT_1880);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1881);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1882);
    stringBuffer.append(TEXT_1883);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1884);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1885);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1886);
    stringBuffer.append(TEXT_1887);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1888);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1889);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1890);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1891);
    stringBuffer.append(TEXT_1892);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1893);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1894);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1895);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1896);
    stringBuffer.append(TEXT_1897);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1898);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1899);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1900);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1901);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1902);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1903);
    stringBuffer.append(TEXT_1904);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1905);
    stringBuffer.append(TEXT_1906);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1907);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1908);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1909);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1910);
    stringBuffer.append(TEXT_1911);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1912);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1913);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1914);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1915);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1916);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1917);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1918);
    stringBuffer.append(TEXT_1919);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1920);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1921);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1922);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1923);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1924);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1925);
    stringBuffer.append(TEXT_1926);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1927);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1928);
    stringBuffer.append(TEXT_1929);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1930);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1931);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1932);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1933);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1934);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1935);
    stringBuffer.append(TEXT_1936);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1937);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1938);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1939);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1940);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1941);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1942);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1943);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1944);
    stringBuffer.append(TEXT_1945);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1946);
    stringBuffer.append(TEXT_1947);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1948);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1949);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1950);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1951);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1952);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1953);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1954);
    stringBuffer.append(TEXT_1955);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1956);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1957);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1958);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1959);
    stringBuffer.append(TEXT_1960);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1961);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1962);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1963);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1964);
    stringBuffer.append(TEXT_1965);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1966);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1967);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1968);
    stringBuffer.append(TEXT_1969);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1970);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1971);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1972);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1973);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1974);
    stringBuffer.append(TEXT_1975);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1976);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1977);
    
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
        Position p = aMethod.getPosition();
        String positionHeader = "";
        if (p != null) {
          int javaline = stringBuffer.toString().split("\\n").length;
//        use annotations instead
//        positionHeader = "\n  // line " + p.getLineNumber() + " \"" + p.getRelativePath(uClass, "Java") + "\"";
          positionHeader = "\n  @umplesourcefile(line="+p.getLineNumber()+",file=\""+p.getFilename().replaceAll("\\\\","/").replaceAll("(.*)/","")+ "\",javaline="+(javaline+3)+",length="+(aMethod.getIsImplemented()?2: aMethod.getMethodBody().getExtraCode().split("\\n").length)+")";
        }
        String methodModifier = aMethod.getModifier().equals("") ? "public" : aMethod.getModifier();
        String methodName = aMethod.getName();
        String methodType = aMethod.getType();
        String customPreconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Precondition"));
        String methodBody = aMethod.getIsImplemented() ? "      return " + gen.translate(methodType) + ";" : aMethod.getMethodBody().getExtraCode();
        String properMethodBody = "    " + methodBody; 
        String override =  aMethod.getIsImplemented() ? "  @Override\n" : "";
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
        
        if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n\n  {0}", Comment.format("Method Javadoc",aMethod.getComments())); }
        
        if (p != null)
        {
          appendln(stringBuffer, positionHeader);
        }
        
          append(stringBuffer,override);
          append(stringBuffer, "  {0} {1} {2}({3})", methodModifier, methodType, methodName, finalParams);  
          appendln(stringBuffer, "{");
          if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
          appendln(stringBuffer, properMethodBody);
          appendln(stringBuffer, "  }");
          
        }
        else{
           
           if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n\n  {0}", Comment.format("Method Javadoc",aMethod.getComments())); }
           
           if (p != null)
        {
          appendln(stringBuffer, positionHeader);
        }
           
          append(stringBuffer,override);          
          append(stringBuffer, "  {0} {1} {2}()", methodModifier, methodType, methodName);
            appendln(stringBuffer, "{");
            if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
          appendln(stringBuffer, properMethodBody);
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
    stringBuffer.append(TEXT_1978);
    
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
	    if(av.isIsNavigable()){
		  
			  if("1".equals(av.getMultiplicity().getMinimum())||"0".equals(av.getMultiplicity().getMinimum())||"1".equals(av.getMultiplicity().getBound()))
				  if("1".equals(av.getMultiplicity().getMaximum())||"1".equals(av.getMultiplicity().getBound()))
					  if(keys.contains(av.getName())){
						  nameOfAttributes.addFirst(av.getName());
						  displayedAttributes.addLast(gen.translate("getMethod",av)+"()");
					  }
					  else{
						  nameOfAttributes.addFirst(av.getName());
						  displayedAttributes.addLast(gen.translate("getMethod",av)+"()");
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
		  ret += "\"  \" + " + "\"" + nameOfAttributes.get(m) + "\" + \"=\" + " + displayedAttributes.get(m) + " != null ? !" + displayedAttributes.get(m) + " .equals(this)  ? " + displayedAttributes.get(m) + ".toString().replaceAll(\"  \",\"    \") : \"this\" : \"null\"";

	  }
	  ret += "\n     + outputString";
	  append(stringBuffer,"\n    return {0};", ret);
	  
    stringBuffer.append(TEXT_1979);
     } 
    return stringBuffer.toString();
    } 
    private String getAllExtraCode(StringBuffer stringBuffer, UmpleModel model,UmpleClass uClass, GeneratedClass gClass, JavaGenerator gen, boolean isFirst)
  {
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_1980);
    
  java.util.regex.Pattern lineNumberPattern = java.util.regex.Pattern.compile("// line ([0|1|2|3|4|5|6|7|8|9]*) (.*)");
  java.util.regex.Pattern methodNamePattern = java.util.regex.Pattern.compile("[ |\\t]*(public|private|protected)[ |\\t]+(.*)[(](.*)[)].*");
  String extraCode = uClass.getExtraCode();
  String[] lines = extraCode.split("\\n");
  extraCode = "";
  boolean setIsMainMethodToFalse = false;
  boolean isMainMethod = false;
  boolean isMainClass = false;
  int linenumber = 0;
  int javaline = stringBuffer.toString().split("\\n").length+1;
  String umplefilename = "";
  for(int i=0;i<lines.length;i++)
  {
    String l = lines[i];
    java.util.regex.Matcher lineNumberMatcher = lineNumberPattern.matcher(l);
    java.util.regex.Matcher methodNameMatcher = methodNamePattern.matcher(l);
     
    if(l.matches("(.*)[ |\\t]+void([ |\\t]+)main([ |\\t]*)[(]([ |\\t]*)String\\[\\](.*)"))
    {
       isMainMethod = true;
       isMainClass = true;
    }
    if(isMainMethod&&l.contains("{"))
    {
      setIsMainMethodToFalse=true;
      l+="\n    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());";
      l+="\n    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());";
      javaline+=2;
    }
    if(lineNumberMatcher.find())
    {
      umplefilename = lineNumberMatcher.group(2);
      linenumber = Integer.parseInt(lineNumberMatcher.group(1))-1;
    }
    if(methodNameMatcher.matches())
    {
      
      int j=i;
      int braces = 1;
      boolean start=false;
      boolean isMultiComment=false;
      for(;j<lines.length&&braces>0;j++)
      {
        int tempbraces=0;
        boolean isLineComment=false;
        for(int k=0;k<lines[j].length();k++)
        {
          if(k>0&&lines[j].substring(k-1,k+1).equals("//")){
            isLineComment=true;
          }
          if(k>0&&lines[j].substring(k-1,k+1).equals("/*")){
            isMultiComment=true;
          }
          if(k>0&&lines[j].substring(k-1,k+1).equals("*/")){
            isMultiComment=false;
          }
          if(lines[j].charAt(k)=='{'){
            if(start)
            {
              tempbraces++;
            }
            else
            {
              start = true;
            }
          }
          else if(lines[j].charAt(k)=='}'){
            if(start)
            {
              tempbraces--;
            }
          }
        }
        if(!isLineComment&&!isMultiComment)
        {
          braces+=tempbraces;
        }
      }
      j+=isMainMethod?2:0;
      l ="  @umplesourcefile(line="+linenumber+",file=\""+umplefilename.replaceAll("\\\\","/").replaceAll("(.*)/","")+"\",javaline="+javaline+",length="+(j-i)+")\n"+l;
      javaline++;
    }
    if(setIsMainMethodToFalse){
      isMainMethod=false;
      setIsMainMethodToFalse=false;
    }
    linenumber++;
    javaline++;
    extraCode+=l+"\n";
  }
  
    stringBuffer.append(extraCode);
    if(isMainClass){
    stringBuffer.append(TEXT_1981);
    }
     } 
    stringBuffer.append(TEXT_1982);
    return stringBuffer.toString();
  }
}