package cruise.umple.compiler.java;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class JavaSpecGenerator 
{

  protected static String nl;
  public static synchronized JavaSpecGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    JavaSpecGenerator result = new JavaSpecGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/";
  protected final String TEXT_2 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_3 = " : ";
  protected final String TEXT_4 = NL + "  public boolean ";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = "()" + NL + "  {";
  protected final String TEXT_7 = NL + "    boolean isValid = ";
  protected final String TEXT_8 = "() >= ";
  protected final String TEXT_9 = "_";
  protected final String TEXT_10 = "();";
  protected final String TEXT_11 = NL + "    boolean isValid = ";
  protected final String TEXT_12 = "() >= ";
  protected final String TEXT_13 = "_";
  protected final String TEXT_14 = "() && ";
  protected final String TEXT_15 = "() <= ";
  protected final String TEXT_16 = "_";
  protected final String TEXT_17 = "();";
  protected final String TEXT_18 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_19 = NL + "  public static int ";
  protected final String TEXT_20 = "_";
  protected final String TEXT_21 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_22 = ";" + NL + "  }";
  protected final String TEXT_23 = NL + "  public static int ";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = "()" + NL + "  {";
  protected final String TEXT_26 = NL + "    int required = ";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_29 = NL + "  public static int ";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_32 = ";" + NL + "  }";
  protected final String TEXT_33 = NL + "  public static int ";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = "()" + NL + "  {";
  protected final String TEXT_36 = NL + "    int minimum = ";
  protected final String TEXT_37 = ";";
  protected final String TEXT_38 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_39 = NL + "  public static int ";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_42 = ";" + NL + "  }";
  protected final String TEXT_43 = NL + "  public static int ";
  protected final String TEXT_44 = "_";
  protected final String TEXT_45 = "()" + NL + "  {";
  protected final String TEXT_46 = NL + "    int maximum = ";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_49 = NL + "  public boolean ";
  protected final String TEXT_50 = "(";
  protected final String TEXT_51 = " ";
  protected final String TEXT_52 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_53 = NL + "    ";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = "(";
  protected final String TEXT_57 = "0 ";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "   List<";
  protected final String TEXT_60 = "> ";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = "_";
  protected final String TEXT_63 = "(); ";
  protected final String TEXT_64 = NL + "    if (";
  protected final String TEXT_65 = "() >= ";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = "())" + NL + "    {";
  protected final String TEXT_68 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_69 = NL + "    wasAdded = super.";
  protected final String TEXT_70 = "(";
  protected final String TEXT_71 = ");" + NL;
  protected final String TEXT_72 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_73 = NL + "  public boolean ";
  protected final String TEXT_74 = "(";
  protected final String TEXT_75 = " ";
  protected final String TEXT_76 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_77 = NL + "    List<";
  protected final String TEXT_78 = "> ";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = "_";
  protected final String TEXT_81 = "();";
  protected final String TEXT_82 = NL + "    ";
  protected final String TEXT_83 = " ";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = "_One";
  protected final String TEXT_87 = "();" + NL + "    boolean ";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = " != null && !this.equals(";
  protected final String TEXT_90 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_91 = " && ";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = "() <= ";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    wasAdded = super.";
  protected final String TEXT_96 = "(";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_99 = "(";
  protected final String TEXT_100 = " ";
  protected final String TEXT_101 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_102 = NL + "    List<";
  protected final String TEXT_103 = "> ";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = "_";
  protected final String TEXT_106 = "(); ";
  protected final String TEXT_107 = NL + "    //Unable to remove ";
  protected final String TEXT_108 = ", as it must always have a ";
  protected final String TEXT_109 = NL + "    if (this.equals(";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = "()))" + NL + "    {";
  protected final String TEXT_112 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_113 = " already at minimum (";
  protected final String TEXT_114 = ")" + NL + "    if (";
  protected final String TEXT_115 = "() <= ";
  protected final String TEXT_116 = "_";
  protected final String TEXT_117 = "())" + NL + "    {";
  protected final String TEXT_118 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_119 = NL + NL + "    wasRemoved = super.";
  protected final String TEXT_120 = "(";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_123 = NL + "  public ";
  protected final String TEXT_124 = " ";
  protected final String TEXT_125 = "(";
  protected final String TEXT_126 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_127 = "() >= ";
  protected final String TEXT_128 = "_";
  protected final String TEXT_129 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_130 = "(";
  protected final String TEXT_131 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_132 = "(";
  protected final String TEXT_133 = " ";
  protected final String TEXT_134 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_135 = NL + "    List<";
  protected final String TEXT_136 = "> ";
  protected final String TEXT_137 = " = ";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = "();";
  protected final String TEXT_140 = NL + "    if (";
  protected final String TEXT_141 = "() >= ";
  protected final String TEXT_142 = "_";
  protected final String TEXT_143 = "())" + NL + "    {";
  protected final String TEXT_144 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_145 = NL + "    ";
  protected final String TEXT_146 = " ";
  protected final String TEXT_147 = " = ";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = "_One";
  protected final String TEXT_150 = "();" + NL + "    boolean ";
  protected final String TEXT_151 = " = ";
  protected final String TEXT_152 = " != null && !this.equals(";
  protected final String TEXT_153 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_154 = " && ";
  protected final String TEXT_155 = ".";
  protected final String TEXT_156 = "() <= ";
  protected final String TEXT_157 = "_";
  protected final String TEXT_158 = "())" + NL + "    {";
  protected final String TEXT_159 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_160 = NL + NL + "    wasAdded = super.";
  protected final String TEXT_161 = "(";
  protected final String TEXT_162 = ");";
  protected final String TEXT_163 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_164 = "(";
  protected final String TEXT_165 = " ";
  protected final String TEXT_166 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_167 = NL + "    List<";
  protected final String TEXT_168 = "> ";
  protected final String TEXT_169 = " = ";
  protected final String TEXT_170 = "_";
  protected final String TEXT_171 = "(); ";
  protected final String TEXT_172 = NL + "    //Unable to remove ";
  protected final String TEXT_173 = ", as it must always have a ";
  protected final String TEXT_174 = NL + "    if (this.equals(";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = "()))" + NL + "    {";
  protected final String TEXT_177 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_178 = " already at minimum (";
  protected final String TEXT_179 = ")" + NL + "    if (";
  protected final String TEXT_180 = "() <= ";
  protected final String TEXT_181 = "_";
  protected final String TEXT_182 = "())" + NL + "    {";
  protected final String TEXT_183 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_184 = NL + "    " + NL + "    wasRemoved = super.";
  protected final String TEXT_185 = "(";
  protected final String TEXT_186 = ");";
  protected final String TEXT_187 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_188 = NL + "  public ";
  protected final String TEXT_189 = " ";
  protected final String TEXT_190 = "(";
  protected final String TEXT_191 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_192 = "() >= ";
  protected final String TEXT_193 = "_";
  protected final String TEXT_194 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_195 = "(";
  protected final String TEXT_196 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_197 = "(";
  protected final String TEXT_198 = " ";
  protected final String TEXT_199 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_200 = NL + "    List<";
  protected final String TEXT_201 = "> ";
  protected final String TEXT_202 = " = ";
  protected final String TEXT_203 = "_";
  protected final String TEXT_204 = "();";
  protected final String TEXT_205 = NL + "    if (";
  protected final String TEXT_206 = "() >= ";
  protected final String TEXT_207 = "_";
  protected final String TEXT_208 = "())" + NL + "    {";
  protected final String TEXT_209 = NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    wasAdded = super.";
  protected final String TEXT_210 = "(";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_213 = NL + "  public boolean ";
  protected final String TEXT_214 = "(";
  protected final String TEXT_215 = "... ";
  protected final String TEXT_216 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_217 = NL + "    ArrayList<";
  protected final String TEXT_218 = "> ";
  protected final String TEXT_219 = " = new ArrayList<";
  protected final String TEXT_220 = ">();" + NL + "    for (";
  protected final String TEXT_221 = " ";
  protected final String TEXT_222 = " : ";
  protected final String TEXT_223 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_224 = ".contains(";
  protected final String TEXT_225 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_226 = NL + "      ";
  protected final String TEXT_227 = ".add(";
  protected final String TEXT_228 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_229 = ".size() != ";
  protected final String TEXT_230 = ".length || ";
  protected final String TEXT_231 = ".size() > ";
  protected final String TEXT_232 = "_";
  protected final String TEXT_233 = "())" + NL + "    {";
  protected final String TEXT_234 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    wasSet = super.";
  protected final String TEXT_235 = "(";
  protected final String TEXT_236 = ");";
  protected final String TEXT_237 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_238 = NL + "  public ";
  protected final String TEXT_239 = " ";
  protected final String TEXT_240 = "(";
  protected final String TEXT_241 = ")" + NL + "  {" + NL + "    // need to keep this because of the type differences between sub & super classes" + NL + "    return new ";
  protected final String TEXT_242 = "(";
  protected final String TEXT_243 = ");" + NL + "  }";
  protected final String TEXT_244 = NL + "  public boolean ";
  protected final String TEXT_245 = "(";
  protected final String TEXT_246 = " ";
  protected final String TEXT_247 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_248 = NL + "    List<";
  protected final String TEXT_249 = "> ";
  protected final String TEXT_250 = " = ";
  protected final String TEXT_251 = "_";
  protected final String TEXT_252 = "();";
  protected final String TEXT_253 = NL + NL + "    if (";
  protected final String TEXT_254 = "() <= ";
  protected final String TEXT_255 = "_";
  protected final String TEXT_256 = "())" + NL + "    {";
  protected final String TEXT_257 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    wasRemoved = super.";
  protected final String TEXT_258 = "(";
  protected final String TEXT_259 = ");" + NL;
  protected final String TEXT_260 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_261 = NL + "  public boolean ";
  protected final String TEXT_262 = "(";
  protected final String TEXT_263 = " ";
  protected final String TEXT_264 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_265 = NL + "    List<";
  protected final String TEXT_266 = "> ";
  protected final String TEXT_267 = " = ";
  protected final String TEXT_268 = "_";
  protected final String TEXT_269 = "();";
  protected final String TEXT_270 = NL + NL + "    if (";
  protected final String TEXT_271 = "() <= ";
  protected final String TEXT_272 = "_";
  protected final String TEXT_273 = "())" + NL + "    {";
  protected final String TEXT_274 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    wasRemoved = super.";
  protected final String TEXT_275 = "(";
  protected final String TEXT_276 = ");" + NL;
  protected final String TEXT_277 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_278 = NL + "  public boolean ";
  protected final String TEXT_279 = "(";
  protected final String TEXT_280 = " ";
  protected final String TEXT_281 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_282 = NL + "    if (";
  protected final String TEXT_283 = " != null && ";
  protected final String TEXT_284 = ".";
  protected final String TEXT_285 = "() >= ";
  protected final String TEXT_286 = ".";
  protected final String TEXT_287 = "_";
  protected final String TEXT_288 = "())" + NL + "    {";
  protected final String TEXT_289 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_290 = NL + "    wasSet = super.";
  protected final String TEXT_291 = "(";
  protected final String TEXT_292 = ");";
  protected final String TEXT_293 = NL + "    super.clear_";
  protected final String TEXT_294 = "();" + NL + "    wasSet = ";
  protected final String TEXT_295 = "(";
  protected final String TEXT_296 = ");";
  protected final String TEXT_297 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_298 = NL + "  public boolean ";
  protected final String TEXT_299 = "(";
  protected final String TEXT_300 = " ";
  protected final String TEXT_301 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_302 = NL + "    ";
  protected final String TEXT_303 = " ";
  protected final String TEXT_304 = " = ";
  protected final String TEXT_305 = "_One";
  protected final String TEXT_306 = "();";
  protected final String TEXT_307 = NL + "    if (";
  protected final String TEXT_308 = " == null)" + NL + "    {";
  protected final String TEXT_309 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_310 = NL + "    ";
  protected final String TEXT_311 = " ";
  protected final String TEXT_312 = " = ";
  protected final String TEXT_313 = ";";
  protected final String TEXT_314 = NL + "    ";
  protected final String TEXT_315 = " = ";
  protected final String TEXT_316 = ";" + NL + "    if (";
  protected final String TEXT_317 = " != null && !";
  protected final String TEXT_318 = ".equals(";
  protected final String TEXT_319 = "))" + NL + "    {";
  protected final String TEXT_320 = NL + "      ";
  protected final String TEXT_321 = ".";
  protected final String TEXT_322 = "(this);" + NL + "    }";
  protected final String TEXT_323 = NL + "    ";
  protected final String TEXT_324 = ".";
  protected final String TEXT_325 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_326 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_327 = NL + "  public boolean ";
  protected final String TEXT_328 = "(";
  protected final String TEXT_329 = " ";
  protected final String TEXT_330 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_331 = NL + "    //Must provide ";
  protected final String TEXT_332 = " to ";
  protected final String TEXT_333 = NL + "    if (";
  protected final String TEXT_334 = " == null)" + NL + "    {";
  protected final String TEXT_335 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_336 = " already at maximum (";
  protected final String TEXT_337 = ")" + NL + "    if (";
  protected final String TEXT_338 = ".";
  protected final String TEXT_339 = "() >= ";
  protected final String TEXT_340 = ".";
  protected final String TEXT_341 = "_";
  protected final String TEXT_342 = "())" + NL + "    {";
  protected final String TEXT_343 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_344 = NL + "    wasSet = super.";
  protected final String TEXT_345 = "(";
  protected final String TEXT_346 = ");";
  protected final String TEXT_347 = NL + "    super.clear_";
  protected final String TEXT_348 = "();" + NL + "    wasSet = ";
  protected final String TEXT_349 = "(";
  protected final String TEXT_350 = ");";
  protected final String TEXT_351 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_352 = NL + "  public boolean ";
  protected final String TEXT_353 = "(";
  protected final String TEXT_354 = " ";
  protected final String TEXT_355 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_356 = NL + "    //Must provide ";
  protected final String TEXT_357 = " to ";
  protected final String TEXT_358 = NL + "    if (";
  protected final String TEXT_359 = " == null)" + NL + "    {";
  protected final String TEXT_360 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_361 = "_One";
  protected final String TEXT_362 = "() != null && ";
  protected final String TEXT_363 = "_One";
  protected final String TEXT_364 = "().";
  protected final String TEXT_365 = "() <= ";
  protected final String TEXT_366 = ".";
  protected final String TEXT_367 = "_";
  protected final String TEXT_368 = "())" + NL + "    {";
  protected final String TEXT_369 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_370 = NL + "    wasSet = super.";
  protected final String TEXT_371 = "(";
  protected final String TEXT_372 = ");";
  protected final String TEXT_373 = NL + "    super.clear_";
  protected final String TEXT_374 = "();" + NL + "    wasSet = ";
  protected final String TEXT_375 = "(";
  protected final String TEXT_376 = ");";
  protected final String TEXT_377 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_378 = NL + "  public boolean ";
  protected final String TEXT_379 = "(";
  protected final String TEXT_380 = " ";
  protected final String TEXT_381 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_382 = NL + "    List<";
  protected final String TEXT_383 = "> ";
  protected final String TEXT_384 = " = ";
  protected final String TEXT_385 = "_";
  protected final String TEXT_386 = "();";
  protected final String TEXT_387 = NL + "    ";
  protected final String TEXT_388 = " ";
  protected final String TEXT_389 = " = ";
  protected final String TEXT_390 = ".";
  protected final String TEXT_391 = "_";
  protected final String TEXT_392 = "One";
  protected final String TEXT_393 = "();";
  protected final String TEXT_394 = NL + "    if (";
  protected final String TEXT_395 = " == null)" + NL + "    {";
  protected final String TEXT_396 = NL + "      ";
  protected final String TEXT_397 = ".";
  protected final String TEXT_398 = "(this);";
  protected final String TEXT_399 = NL + "      ";
  protected final String TEXT_400 = ".clear_";
  protected final String TEXT_401 = "();";
  protected final String TEXT_402 = NL + "      ";
  protected final String TEXT_403 = ".";
  protected final String TEXT_404 = "(this);";
  protected final String TEXT_405 = NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_406 = "))" + NL + "    {";
  protected final String TEXT_407 = NL + "      ";
  protected final String TEXT_408 = ".";
  protected final String TEXT_409 = "(";
  protected final String TEXT_410 = ");";
  protected final String TEXT_411 = NL + "      ";
  protected final String TEXT_412 = "(";
  protected final String TEXT_413 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_414 = NL + "      ";
  protected final String TEXT_415 = ".add(";
  protected final String TEXT_416 = ");" + NL + "    }";
  protected final String TEXT_417 = NL + "    wasAdded = true;";
  protected final String TEXT_418 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_419 = "(";
  protected final String TEXT_420 = " ";
  protected final String TEXT_421 = ")a" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_422 = NL + "    List<";
  protected final String TEXT_423 = "> ";
  protected final String TEXT_424 = " = ";
  protected final String TEXT_425 = "_";
  protected final String TEXT_426 = "(); ";
  protected final String TEXT_427 = NL + "    if (";
  protected final String TEXT_428 = "_One";
  protected final String TEXT_429 = ".contains(";
  protected final String TEXT_430 = "))" + NL + "    {";
  protected final String TEXT_431 = NL + "      ";
  protected final String TEXT_432 = ".remove(";
  protected final String TEXT_433 = ");";
  protected final String TEXT_434 = NL + "      ";
  protected final String TEXT_435 = ".";
  protected final String TEXT_436 = "(null);" + NL + "      wasRemoved = true;";
  protected final String TEXT_437 = NL + "    }";
  protected final String TEXT_438 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_439 = NL + "  public boolean ";
  protected final String TEXT_440 = "(";
  protected final String TEXT_441 = " ";
  protected final String TEXT_442 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_443 = NL + "    List<";
  protected final String TEXT_444 = "> ";
  protected final String TEXT_445 = " = ";
  protected final String TEXT_446 = "_";
  protected final String TEXT_447 = "();";
  protected final String TEXT_448 = NL + "    if (";
  protected final String TEXT_449 = "() >= ";
  protected final String TEXT_450 = "_";
  protected final String TEXT_451 = "())" + NL + "    {";
  protected final String TEXT_452 = NL + "      return wasAdded;" + NL + "    }" + NL + "" + NL + "    wasAdded = super.";
  protected final String TEXT_453 = "(";
  protected final String TEXT_454 = ");";
  protected final String TEXT_455 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_456 = NL + "  public boolean ";
  protected final String TEXT_457 = "(";
  protected final String TEXT_458 = " ";
  protected final String TEXT_459 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_460 = NL + "    List<";
  protected final String TEXT_461 = "> ";
  protected final String TEXT_462 = " = ";
  protected final String TEXT_463 = "_";
  protected final String TEXT_464 = "();";
  protected final String TEXT_465 = NL + "    if (";
  protected final String TEXT_466 = "() < ";
  protected final String TEXT_467 = "_";
  protected final String TEXT_468 = "())" + NL + "    {";
  protected final String TEXT_469 = NL + "      wasAdded = super.";
  protected final String TEXT_470 = "(";
  protected final String TEXT_471 = ");";
  protected final String TEXT_472 = NL + "    }";
  protected final String TEXT_473 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_474 = "(";
  protected final String TEXT_475 = " ";
  protected final String TEXT_476 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_477 = NL + NL + "    if (";
  protected final String TEXT_478 = "() <= ";
  protected final String TEXT_479 = "_";
  protected final String TEXT_480 = "())" + NL + "    {";
  protected final String TEXT_481 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_482 = NL + NL + "    wasRemoved = super.";
  protected final String TEXT_483 = "(";
  protected final String TEXT_484 = ");";
  protected final String TEXT_485 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_486 = NL + "  public boolean ";
  protected final String TEXT_487 = "(";
  protected final String TEXT_488 = " ";
  protected final String TEXT_489 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_490 = NL + "    List<";
  protected final String TEXT_491 = "> ";
  protected final String TEXT_492 = " = ";
  protected final String TEXT_493 = "_";
  protected final String TEXT_494 = "();";
  protected final String TEXT_495 = NL + "    if (";
  protected final String TEXT_496 = "() >= ";
  protected final String TEXT_497 = "_";
  protected final String TEXT_498 = "())" + NL + "    {";
  protected final String TEXT_499 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_500 = NL + "    ";
  protected final String TEXT_501 = " ";
  protected final String TEXT_502 = " = ";
  protected final String TEXT_503 = ".";
  protected final String TEXT_504 = "_One";
  protected final String TEXT_505 = "();" + NL + "    if (";
  protected final String TEXT_506 = " != null && ";
  protected final String TEXT_507 = ".";
  protected final String TEXT_508 = "() <= ";
  protected final String TEXT_509 = "_";
  protected final String TEXT_510 = "())" + NL + "    {";
  protected final String TEXT_511 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_512 = NL + "    wasAdded = super.";
  protected final String TEXT_513 = "(";
  protected final String TEXT_514 = ");";
  protected final String TEXT_515 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_516 = "(";
  protected final String TEXT_517 = " ";
  protected final String TEXT_518 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_519 = NL + "    if (";
  protected final String TEXT_520 = "() > ";
  protected final String TEXT_521 = "_";
  protected final String TEXT_522 = "())" + NL + "    {";
  protected final String TEXT_523 = NL + "      wasRemoved = super.";
  protected final String TEXT_524 = "(";
  protected final String TEXT_525 = ");" + NL + "    }";
  protected final String TEXT_526 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_527 = NL + "  public boolean ";
  protected final String TEXT_528 = "(";
  protected final String TEXT_529 = "... ";
  protected final String TEXT_530 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_531 = NL + "    ArrayList<";
  protected final String TEXT_532 = "> ";
  protected final String TEXT_533 = " = new ArrayList<";
  protected final String TEXT_534 = ">();" + NL + "    for (";
  protected final String TEXT_535 = " ";
  protected final String TEXT_536 = " : ";
  protected final String TEXT_537 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_538 = ".contains(";
  protected final String TEXT_539 = "))" + NL + "      {";
  protected final String TEXT_540 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_541 = ".";
  protected final String TEXT_542 = "() != null && !this.equals(";
  protected final String TEXT_543 = ".";
  protected final String TEXT_544 = "()))" + NL + "      {";
  protected final String TEXT_545 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_546 = NL + "      ";
  protected final String TEXT_547 = ".add(";
  protected final String TEXT_548 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_549 = ".size() != ";
  protected final String TEXT_550 = "_";
  protected final String TEXT_551 = "())" + NL + "    {";
  protected final String TEXT_552 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_553 = NL + "    wasSet = super.";
  protected final String TEXT_554 = "(";
  protected final String TEXT_555 = ");";
  protected final String TEXT_556 = NL + "    super.clear_";
  protected final String TEXT_557 = "();" + NL + "    for ( ";
  protected final String TEXT_558 = " orphan : ";
  protected final String TEXT_559 = " )" + NL + "    {";
  protected final String TEXT_560 = NL + "      ";
  protected final String TEXT_561 = "(orphan);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_562 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_563 = NL + "  private void ";
  protected final String TEXT_564 = "(";
  protected final String TEXT_565 = " ";
  protected final String TEXT_566 = ", ";
  protected final String TEXT_567 = " ";
  protected final String TEXT_568 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_569 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_570 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_571 = ", ";
  protected final String TEXT_572 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_573 = " to ";
  protected final String TEXT_574 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_575 = NL + "  public boolean ";
  protected final String TEXT_576 = "(";
  protected final String TEXT_577 = " ";
  protected final String TEXT_578 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_579 = NL + "    List<";
  protected final String TEXT_580 = "> ";
  protected final String TEXT_581 = " = ";
  protected final String TEXT_582 = "_";
  protected final String TEXT_583 = "();";
  protected final String TEXT_584 = NL + "    if (";
  protected final String TEXT_585 = "().contains(";
  protected final String TEXT_586 = "))" + NL + "    {";
  protected final String TEXT_587 = NL + "      wasRemoved = super.";
  protected final String TEXT_588 = "(";
  protected final String TEXT_589 = ");";
  protected final String TEXT_590 = NL + "    }";
  protected final String TEXT_591 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_592 = NL + "  public boolean ";
  protected final String TEXT_593 = "(";
  protected final String TEXT_594 = " ";
  protected final String TEXT_595 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_596 = NL + "    List<";
  protected final String TEXT_597 = "> ";
  protected final String TEXT_598 = " = ";
  protected final String TEXT_599 = "_";
  protected final String TEXT_600 = "();";
  protected final String TEXT_601 = NL + "    if (";
  protected final String TEXT_602 = "() < ";
  protected final String TEXT_603 = "_";
  protected final String TEXT_604 = "())" + NL + "    {";
  protected final String TEXT_605 = NL + "      wasAdded = super.";
  protected final String TEXT_606 = "(";
  protected final String TEXT_607 = ");";
  protected final String TEXT_608 = NL + "    }";
  protected final String TEXT_609 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_610 = NL;
  protected final String TEXT_611 = NL + "  ";
  protected final String TEXT_612 = " boolean ";
  protected final String TEXT_613 = "(";
  protected final String TEXT_614 = "... ";
  protected final String TEXT_615 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_616 = NL + "    ArrayList<";
  protected final String TEXT_617 = "> ";
  protected final String TEXT_618 = " = new ArrayList<";
  protected final String TEXT_619 = ">();" + NL + "    for (";
  protected final String TEXT_620 = " ";
  protected final String TEXT_621 = " : ";
  protected final String TEXT_622 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_623 = ".contains(";
  protected final String TEXT_624 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_625 = NL + "      ";
  protected final String TEXT_626 = ".add(";
  protected final String TEXT_627 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_628 = ".size() != ";
  protected final String TEXT_629 = ".length || ";
  protected final String TEXT_630 = ".size() != ";
  protected final String TEXT_631 = "_";
  protected final String TEXT_632 = "())" + NL + "    {";
  protected final String TEXT_633 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    wasSet = super.";
  protected final String TEXT_634 = "(";
  protected final String TEXT_635 = ");";
  protected final String TEXT_636 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_637 = NL + "  ";
  protected final String TEXT_638 = " boolean ";
  protected final String TEXT_639 = "(";
  protected final String TEXT_640 = "... ";
  protected final String TEXT_641 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_642 = NL + "    ArrayList<";
  protected final String TEXT_643 = "> ";
  protected final String TEXT_644 = " = new ArrayList<";
  protected final String TEXT_645 = ">();" + NL + "    for (";
  protected final String TEXT_646 = " ";
  protected final String TEXT_647 = " : ";
  protected final String TEXT_648 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_649 = ".contains(";
  protected final String TEXT_650 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_651 = NL + "      ";
  protected final String TEXT_652 = ".add(";
  protected final String TEXT_653 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_654 = ".size() != ";
  protected final String TEXT_655 = ".length)" + NL + "    {";
  protected final String TEXT_656 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    wasSet = super.";
  protected final String TEXT_657 = "(";
  protected final String TEXT_658 = ");";
  protected final String TEXT_659 = NL + "    return wasSet;" + NL + "  }" + NL + "" + NL + "  ";
  protected final String TEXT_660 = NL + "  public boolean ";
  protected final String TEXT_661 = "(";
  protected final String TEXT_662 = " ";
  protected final String TEXT_663 = ")" + NL + "  {" + NL + "    //" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "    boolean wasSet = false;";
  protected final String TEXT_664 = NL + "    ";
  protected final String TEXT_665 = " ";
  protected final String TEXT_666 = " = ";
  protected final String TEXT_667 = "_One";
  protected final String TEXT_668 = "();" + NL + "" + NL + "    if (";
  protected final String TEXT_669 = " == null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_670 = " != null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_671 = ".";
  protected final String TEXT_672 = "(this))" + NL + "        {";
  protected final String TEXT_673 = NL + "          wasSet = super.";
  protected final String TEXT_674 = "(";
  protected final String TEXT_675 = ");";
  protected final String TEXT_676 = NL + "          super.clear_";
  protected final String TEXT_677 = "();" + NL + "          wasSet = ";
  protected final String TEXT_678 = "(";
  protected final String TEXT_679 = ");";
  protected final String TEXT_680 = NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if (";
  protected final String TEXT_681 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_682 = " == null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_683 = ".";
  protected final String TEXT_684 = "_";
  protected final String TEXT_685 = "() < ";
  protected final String TEXT_686 = ".";
  protected final String TEXT_687 = "())" + NL + "        {";
  protected final String TEXT_688 = NL + "          wasSet = super.";
  protected final String TEXT_689 = "(";
  protected final String TEXT_690 = ");";
  protected final String TEXT_691 = NL + "          super.clear_";
  protected final String TEXT_692 = "();" + NL + "          wasSet = ";
  protected final String TEXT_693 = "(";
  protected final String TEXT_694 = ");";
  protected final String TEXT_695 = NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if (";
  protected final String TEXT_696 = ".";
  protected final String TEXT_697 = "_";
  protected final String TEXT_698 = "() < ";
  protected final String TEXT_699 = ".";
  protected final String TEXT_700 = "())" + NL + "        {";
  protected final String TEXT_701 = NL + "          wasSet = super.";
  protected final String TEXT_702 = "(";
  protected final String TEXT_703 = ");";
  protected final String TEXT_704 = NL + "          super.clear_";
  protected final String TEXT_705 = "();" + NL + "          wasSet = ";
  protected final String TEXT_706 = "(";
  protected final String TEXT_707 = ");";
  protected final String TEXT_708 = NL + "        }" + NL + "      }" + NL + "    }" + NL + "    return wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_709 = NL + "  public boolean ";
  protected final String TEXT_710 = "(";
  protected final String TEXT_711 = "... ";
  protected final String TEXT_712 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_713 = NL + "    ArrayList<";
  protected final String TEXT_714 = "> ";
  protected final String TEXT_715 = " = new ArrayList<";
  protected final String TEXT_716 = ">();" + NL + "    for (";
  protected final String TEXT_717 = " ";
  protected final String TEXT_718 = " : ";
  protected final String TEXT_719 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_720 = ".contains(";
  protected final String TEXT_721 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_722 = NL + "      ";
  protected final String TEXT_723 = ".add(";
  protected final String TEXT_724 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_725 = ".size() != ";
  protected final String TEXT_726 = ".length || ";
  protected final String TEXT_727 = ".size() < ";
  protected final String TEXT_728 = "_";
  protected final String TEXT_729 = "() || ";
  protected final String TEXT_730 = ".size() > ";
  protected final String TEXT_731 = "_";
  protected final String TEXT_732 = "())" + NL + "    {";
  protected final String TEXT_733 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_734 = NL + "    wasSet = super.";
  protected final String TEXT_735 = "(";
  protected final String TEXT_736 = ");";
  protected final String TEXT_737 = NL + "    super.clear_";
  protected final String TEXT_738 = "();" + NL + "    for ( ";
  protected final String TEXT_739 = " orphan : ";
  protected final String TEXT_740 = ")" + NL + "    {";
  protected final String TEXT_741 = NL + "      ";
  protected final String TEXT_742 = "(orphan);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_743 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_744 = NL + "  public boolean ";
  protected final String TEXT_745 = "(";
  protected final String TEXT_746 = "... ";
  protected final String TEXT_747 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_748 = NL + "    ArrayList<";
  protected final String TEXT_749 = "> ";
  protected final String TEXT_750 = " = new ArrayList<";
  protected final String TEXT_751 = ">();" + NL + "    for (";
  protected final String TEXT_752 = " ";
  protected final String TEXT_753 = " : ";
  protected final String TEXT_754 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_755 = ".contains(";
  protected final String TEXT_756 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_757 = NL + "      ";
  protected final String TEXT_758 = ".add(";
  protected final String TEXT_759 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_760 = ".size() != ";
  protected final String TEXT_761 = ".length || ";
  protected final String TEXT_762 = ".size() < ";
  protected final String TEXT_763 = "_";
  protected final String TEXT_764 = "())" + NL + "    {";
  protected final String TEXT_765 = NL + "      return wasSet;" + NL + "    }" + NL + "\t" + NL + "\t";
  protected final String TEXT_766 = NL + "    wasSet = super.";
  protected final String TEXT_767 = "(";
  protected final String TEXT_768 = ");";
  protected final String TEXT_769 = NL + "    super.clear_";
  protected final String TEXT_770 = "();" + NL + "    for ( ";
  protected final String TEXT_771 = " orphan : ";
  protected final String TEXT_772 = " )" + NL + "    {";
  protected final String TEXT_773 = NL + "      ";
  protected final String TEXT_774 = "(orphan);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_775 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_776 = NL + "  ";
  protected final String TEXT_777 = " boolean ";
  protected final String TEXT_778 = "(";
  protected final String TEXT_779 = "... ";
  protected final String TEXT_780 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_781 = NL + "    ArrayList<";
  protected final String TEXT_782 = "> ";
  protected final String TEXT_783 = " = new ArrayList<";
  protected final String TEXT_784 = ">();" + NL + "    for (";
  protected final String TEXT_785 = " ";
  protected final String TEXT_786 = " : ";
  protected final String TEXT_787 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_788 = ".contains(";
  protected final String TEXT_789 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_790 = NL + "      ";
  protected final String TEXT_791 = ".add(";
  protected final String TEXT_792 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_793 = ".size() != ";
  protected final String TEXT_794 = ".length || ";
  protected final String TEXT_795 = ".size() < ";
  protected final String TEXT_796 = "_";
  protected final String TEXT_797 = "() || ";
  protected final String TEXT_798 = ".size() > ";
  protected final String TEXT_799 = "_";
  protected final String TEXT_800 = "())" + NL + "    {";
  protected final String TEXT_801 = NL + "      return wasSet;" + NL + "    }" + NL + "\t" + NL + "\t";
  protected final String TEXT_802 = NL + "    wasSet = super.";
  protected final String TEXT_803 = "(";
  protected final String TEXT_804 = ");";
  protected final String TEXT_805 = NL + "    clear_";
  protected final String TEXT_806 = "();" + NL + "    for ( ";
  protected final String TEXT_807 = " orphan : ";
  protected final String TEXT_808 = " )" + NL + "    {";
  protected final String TEXT_809 = NL + "      ";
  protected final String TEXT_810 = "(orphan);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_811 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_812 = NL + "  public boolean ";
  protected final String TEXT_813 = "(";
  protected final String TEXT_814 = "... ";
  protected final String TEXT_815 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_816 = NL + "    if (";
  protected final String TEXT_817 = ".length < ";
  protected final String TEXT_818 = "_";
  protected final String TEXT_819 = "()";
  protected final String TEXT_820 = ")" + NL + "    {";
  protected final String TEXT_821 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_822 = NL + "    wasSet = super.";
  protected final String TEXT_823 = "(";
  protected final String TEXT_824 = ");";
  protected final String TEXT_825 = NL + "    super.clear_";
  protected final String TEXT_826 = "();" + NL + "    for ( ";
  protected final String TEXT_827 = " orphan : ";
  protected final String TEXT_828 = " )" + NL + "    {";
  protected final String TEXT_829 = NL + "      ";
  protected final String TEXT_830 = "(orphan);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_831 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_832 = NL + "  private void ";
  protected final String TEXT_833 = "(";
  protected final String TEXT_834 = " ";
  protected final String TEXT_835 = ", ";
  protected final String TEXT_836 = " ";
  protected final String TEXT_837 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_838 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_839 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_840 = ", ";
  protected final String TEXT_841 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_842 = " to ";
  protected final String TEXT_843 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_844 = NL + "  ";
  protected final String TEXT_845 = " boolean ";
  protected final String TEXT_846 = "(";
  protected final String TEXT_847 = "... ";
  protected final String TEXT_848 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_849 = NL + "    ArrayList<";
  protected final String TEXT_850 = "> ";
  protected final String TEXT_851 = " = new ArrayList<";
  protected final String TEXT_852 = ">();" + NL + "    for (";
  protected final String TEXT_853 = " ";
  protected final String TEXT_854 = " : ";
  protected final String TEXT_855 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_856 = ".contains(";
  protected final String TEXT_857 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_858 = NL + "      ";
  protected final String TEXT_859 = ".add(";
  protected final String TEXT_860 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_861 = ".size() != ";
  protected final String TEXT_862 = ".length || ";
  protected final String TEXT_863 = ".size() > ";
  protected final String TEXT_864 = "_";
  protected final String TEXT_865 = "())" + NL + "    {";
  protected final String TEXT_866 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    wasSet = super.";
  protected final String TEXT_867 = "(";
  protected final String TEXT_868 = ");";
  protected final String TEXT_869 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_870 = NL + "  ";
  protected final String TEXT_871 = " boolean ";
  protected final String TEXT_872 = "(";
  protected final String TEXT_873 = "... ";
  protected final String TEXT_874 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_875 = NL + "    ArrayList<";
  protected final String TEXT_876 = "> ";
  protected final String TEXT_877 = " = new ArrayList<";
  protected final String TEXT_878 = ">();" + NL + "    for (";
  protected final String TEXT_879 = " ";
  protected final String TEXT_880 = " : ";
  protected final String TEXT_881 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_882 = ".contains(";
  protected final String TEXT_883 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_884 = NL + "      ";
  protected final String TEXT_885 = ".add(";
  protected final String TEXT_886 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_887 = ".size() != ";
  protected final String TEXT_888 = ".length || ";
  protected final String TEXT_889 = ".size() < ";
  protected final String TEXT_890 = "_";
  protected final String TEXT_891 = "())" + NL + "    {";
  protected final String TEXT_892 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    wasSet = super.";
  protected final String TEXT_893 = "(";
  protected final String TEXT_894 = ");";
  protected final String TEXT_895 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_896 = NL + "  ";
  protected final String TEXT_897 = NL + "  public boolean ";
  protected final String TEXT_898 = "(";
  protected final String TEXT_899 = " ";
  protected final String TEXT_900 = ", int index)" + NL + "  {  " + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_901 = "(";
  protected final String TEXT_902 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_903 = "()) { index = ";
  protected final String TEXT_904 = "() - 1; }";
  protected final String TEXT_905 = NL + "      wasAdded = super.";
  protected final String TEXT_906 = "(";
  protected final String TEXT_907 = ", int index);" + NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_908 = "(";
  protected final String TEXT_909 = " ";
  protected final String TEXT_910 = ", int index)" + NL + "  {" + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_911 = "_";
  protected final String TEXT_912 = "().contains(";
  protected final String TEXT_913 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_914 = "()) { index = ";
  protected final String TEXT_915 = "() - 1; }";
  protected final String TEXT_916 = NL + "      wasAdded = ";
  protected final String TEXT_917 = "(";
  protected final String TEXT_918 = " ";
  protected final String TEXT_919 = ", int index);" + NL + "    } " + NL + "    else " + NL + "    {";
  protected final String TEXT_920 = NL + "      wasAdded = ";
  protected final String TEXT_921 = "(";
  protected final String TEXT_922 = ", index);";
  protected final String TEXT_923 = NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL;
  protected final String TEXT_924 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_925 = " : ";
  protected final String TEXT_926 = NL + "  public boolean ";
  protected final String TEXT_927 = "_";
  protected final String TEXT_928 = "()" + NL + "  {";
  protected final String TEXT_929 = NL + "    boolean isValid = ";
  protected final String TEXT_930 = "() >= ";
  protected final String TEXT_931 = "_";
  protected final String TEXT_932 = "();";
  protected final String TEXT_933 = NL + "    boolean isValid = ";
  protected final String TEXT_934 = "() >= ";
  protected final String TEXT_935 = "_";
  protected final String TEXT_936 = "() && ";
  protected final String TEXT_937 = "() <= ";
  protected final String TEXT_938 = "_";
  protected final String TEXT_939 = "();";
  protected final String TEXT_940 = NL + "    return isValid;" + NL + "  }";
  protected final String TEXT_941 = NL + "  public static int ";
  protected final String TEXT_942 = "_";
  protected final String TEXT_943 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_944 = ";" + NL + "  }";
  protected final String TEXT_945 = NL + "  public static int ";
  protected final String TEXT_946 = "_";
  protected final String TEXT_947 = "()" + NL + "  {";
  protected final String TEXT_948 = NL + "    int required = ";
  protected final String TEXT_949 = ";";
  protected final String TEXT_950 = NL + "    return required;" + NL + "  }";
  protected final String TEXT_951 = NL + "  public static int ";
  protected final String TEXT_952 = "_";
  protected final String TEXT_953 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_954 = ";" + NL + "  }";
  protected final String TEXT_955 = NL + "  public static int ";
  protected final String TEXT_956 = "_";
  protected final String TEXT_957 = "()" + NL + "  {";
  protected final String TEXT_958 = NL + "    int minimum = ";
  protected final String TEXT_959 = ";";
  protected final String TEXT_960 = NL + "    return minimum;" + NL + "  }";
  protected final String TEXT_961 = NL + "  public static int ";
  protected final String TEXT_962 = "_";
  protected final String TEXT_963 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_964 = ";" + NL + "  }";
  protected final String TEXT_965 = NL + "  public static int ";
  protected final String TEXT_966 = "_";
  protected final String TEXT_967 = "()" + NL + "  {";
  protected final String TEXT_968 = NL + "    int maximum = ";
  protected final String TEXT_969 = ";";
  protected final String TEXT_970 = NL + "    return maximum;" + NL + "  }";
  protected final String TEXT_971 = NL + "  public boolean ";
  protected final String TEXT_972 = "(";
  protected final String TEXT_973 = " ";
  protected final String TEXT_974 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_975 = NL + "    if (";
  protected final String TEXT_976 = "() >= ";
  protected final String TEXT_977 = "_";
  protected final String TEXT_978 = "())" + NL + "    {";
  protected final String TEXT_979 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_980 = NL + "    ";
  protected final String TEXT_981 = ".add(";
  protected final String TEXT_982 = ");";
  protected final String TEXT_983 = NL + "    if (";
  protected final String TEXT_984 = ".";
  protected final String TEXT_985 = "(this) != -1)" + NL + "    {" + NL + "      wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasAdded = ";
  protected final String TEXT_986 = ".";
  protected final String TEXT_987 = "(this);" + NL + "      if (!wasAdded)" + NL + "      {";
  protected final String TEXT_988 = NL + "        ";
  protected final String TEXT_989 = ".remove(";
  protected final String TEXT_990 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_991 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_992 = NL + "  public boolean ";
  protected final String TEXT_993 = "(";
  protected final String TEXT_994 = " ";
  protected final String TEXT_995 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_996 = NL + "    if (!";
  protected final String TEXT_997 = ".contains(";
  protected final String TEXT_998 = "))" + NL + "    {";
  protected final String TEXT_999 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_1000 = ".indexOf(";
  protected final String TEXT_1001 = ");";
  protected final String TEXT_1002 = NL + "    ";
  protected final String TEXT_1003 = ".remove(oldIndex);" + NL + "    if (";
  protected final String TEXT_1004 = ".";
  protected final String TEXT_1005 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_1006 = ".";
  protected final String TEXT_1007 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_1008 = NL + "        ";
  protected final String TEXT_1009 = ".add(oldIndex,";
  protected final String TEXT_1010 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1011 = NL + "    return wasRemoved;" + NL + "  }";
  protected final String TEXT_1012 = NL + "  ";
  protected final String TEXT_1013 = " boolean ";
  protected final String TEXT_1014 = "(";
  protected final String TEXT_1015 = " ";
  protected final String TEXT_1016 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1017 = NL + "    ";
  protected final String TEXT_1018 = " = ";
  protected final String TEXT_1019 = "new ArrayList<";
  protected final String TEXT_1020 = ">()";
  protected final String TEXT_1021 = ";";
  protected final String TEXT_1022 = ".add(";
  protected final String TEXT_1023 = ");";
  protected final String TEXT_1024 = NL + "    wasSet = true;";
  protected final String TEXT_1025 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1026 = NL + "  ";
  protected final String TEXT_1027 = " boolean ";
  protected final String TEXT_1028 = "(";
  protected final String TEXT_1029 = " ";
  protected final String TEXT_1030 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1031 = NL + "    if (";
  protected final String TEXT_1032 = " != null)" + NL + "    {";
  protected final String TEXT_1033 = NL + "      ";
  protected final String TEXT_1034 = " = ";
  protected final String TEXT_1035 = "new ArrayList<";
  protected final String TEXT_1036 = ">()";
  protected final String TEXT_1037 = ";";
  protected final String TEXT_1038 = ".add(";
  protected final String TEXT_1039 = ");";
  protected final String TEXT_1040 = NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_1041 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1042 = NL + "  public boolean ";
  protected final String TEXT_1043 = "_";
  protected final String TEXT_1044 = "(";
  protected final String TEXT_1045 = " ";
  protected final String TEXT_1046 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1047 = NL + "    if (";
  protected final String TEXT_1048 = " != null && !";
  protected final String TEXT_1049 = ".equals(";
  protected final String TEXT_1050 = ") && equals(";
  protected final String TEXT_1051 = ".";
  protected final String TEXT_1052 = "()))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_1053 = ", as existing ";
  protected final String TEXT_1054 = " would become an orphan";
  protected final String TEXT_1055 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1056 = NL + "    ";
  protected final String TEXT_1057 = " = ";
  protected final String TEXT_1058 = "new ArrayList<";
  protected final String TEXT_1059 = ">()";
  protected final String TEXT_1060 = ";";
  protected final String TEXT_1061 = ".add(";
  protected final String TEXT_1062 = ");";
  protected final String TEXT_1063 = NL + "    ";
  protected final String TEXT_1064 = " ";
  protected final String TEXT_1065 = " = ";
  protected final String TEXT_1066 = " != null ? ";
  protected final String TEXT_1067 = ".";
  protected final String TEXT_1068 = "() : null;" + NL + "" + NL + "    if (!this.equals(";
  protected final String TEXT_1069 = "))" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1070 = " != null)" + NL + "      {";
  protected final String TEXT_1071 = NL + "        ";
  protected final String TEXT_1072 = ".clear_";
  protected final String TEXT_1073 = "();" + NL + "      }" + NL + "      if (";
  protected final String TEXT_1074 = " != null)" + NL + "      {";
  protected final String TEXT_1075 = NL + "        ";
  protected final String TEXT_1076 = ".";
  protected final String TEXT_1077 = "_";
  protected final String TEXT_1078 = "(this);" + NL + "      }" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1079 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1080 = NL + "  public boolean ";
  protected final String TEXT_1081 = "_";
  protected final String TEXT_1082 = "(";
  protected final String TEXT_1083 = " ";
  protected final String TEXT_1084 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1085 = NL + "    if (";
  protected final String TEXT_1086 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_1087 = " to null, as ";
  protected final String TEXT_1088 = " must always be associated to a ";
  protected final String TEXT_1089 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1090 = NL + "    ";
  protected final String TEXT_1091 = " ";
  protected final String TEXT_1092 = " = ";
  protected final String TEXT_1093 = ".";
  protected final String TEXT_1094 = "_One";
  protected final String TEXT_1095 = "()";
  protected final String TEXT_1096 = "(0)";
  protected final String TEXT_1097 = ";" + NL + "    if (";
  protected final String TEXT_1098 = " != null && !equals(";
  protected final String TEXT_1099 = "))" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_1100 = ", the current ";
  protected final String TEXT_1101 = " already has a ";
  protected final String TEXT_1102 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_1103 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1104 = NL + "    ";
  protected final String TEXT_1105 = " ";
  protected final String TEXT_1106 = " = ";
  protected final String TEXT_1107 = ";";
  protected final String TEXT_1108 = NL + "    ";
  protected final String TEXT_1109 = " = ";
  protected final String TEXT_1110 = "new ArrayList<";
  protected final String TEXT_1111 = ">()";
  protected final String TEXT_1112 = ";";
  protected final String TEXT_1113 = ".add(";
  protected final String TEXT_1114 = ");";
  protected final String TEXT_1115 = NL + "    ";
  protected final String TEXT_1116 = ".";
  protected final String TEXT_1117 = "_";
  protected final String TEXT_1118 = "(this);" + NL + "" + NL + "    if (";
  protected final String TEXT_1119 = " != null)" + NL + "    {";
  protected final String TEXT_1120 = NL + "      ";
  protected final String TEXT_1121 = ".clear_";
  protected final String TEXT_1122 = "();" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1123 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1124 = NL + "  private void ";
  protected final String TEXT_1125 = "(";
  protected final String TEXT_1126 = " ";
  protected final String TEXT_1127 = ", ";
  protected final String TEXT_1128 = " ";
  protected final String TEXT_1129 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1130 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1131 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1132 = ", ";
  protected final String TEXT_1133 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1134 = " to ";
  protected final String TEXT_1135 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1136 = NL + "  public ";
  protected final String TEXT_1137 = " ";
  protected final String TEXT_1138 = "(";
  protected final String TEXT_1139 = ")" + NL + "  {";
  protected final String TEXT_1140 = NL + "    ";
  protected final String TEXT_1141 = " ";
  protected final String TEXT_1142 = " = new ";
  protected final String TEXT_1143 = "(";
  protected final String TEXT_1144 = ");";
  protected final String TEXT_1145 = NL + "    return ";
  protected final String TEXT_1146 = ";" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1147 = "(";
  protected final String TEXT_1148 = " ";
  protected final String TEXT_1149 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1150 = NL + "    ";
  protected final String TEXT_1151 = " ";
  protected final String TEXT_1152 = " = ";
  protected final String TEXT_1153 = ".";
  protected final String TEXT_1154 = "_One";
  protected final String TEXT_1155 = "();" + NL + "    boolean ";
  protected final String TEXT_1156 = " = ";
  protected final String TEXT_1157 = " != null && !this.equals(";
  protected final String TEXT_1158 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_1159 = " && ";
  protected final String TEXT_1160 = ".";
  protected final String TEXT_1161 = "() <= ";
  protected final String TEXT_1162 = "_";
  protected final String TEXT_1163 = "())" + NL + "    {" + NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1164 = NL + "    if (";
  protected final String TEXT_1165 = ")" + NL + "    {";
  protected final String TEXT_1166 = NL + "      ";
  protected final String TEXT_1167 = ".";
  protected final String TEXT_1168 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1169 = NL + "      ";
  protected final String TEXT_1170 = ".add(";
  protected final String TEXT_1171 = ");" + NL + "    }";
  protected final String TEXT_1172 = NL + "    wasAdded = true;";
  protected final String TEXT_1173 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1174 = "(";
  protected final String TEXT_1175 = " ";
  protected final String TEXT_1176 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1177 = NL + "    //Unable to remove ";
  protected final String TEXT_1178 = ", as it must always have a ";
  protected final String TEXT_1179 = NL + "    if (this.equals(";
  protected final String TEXT_1180 = ".";
  protected final String TEXT_1181 = "_One";
  protected final String TEXT_1182 = "()))" + NL + "    {";
  protected final String TEXT_1183 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1184 = " already at minimum (";
  protected final String TEXT_1185 = ")" + NL + "    if (";
  protected final String TEXT_1186 = "() <= ";
  protected final String TEXT_1187 = "_";
  protected final String TEXT_1188 = "())" + NL + "    {";
  protected final String TEXT_1189 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_1190 = NL;
  protected final String TEXT_1191 = NL + "    ";
  protected final String TEXT_1192 = ".remove(";
  protected final String TEXT_1193 = ");";
  protected final String TEXT_1194 = NL + "    wasRemoved = true;";
  protected final String TEXT_1195 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1196 = NL + "  public ";
  protected final String TEXT_1197 = " ";
  protected final String TEXT_1198 = "(";
  protected final String TEXT_1199 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_1200 = "() >= ";
  protected final String TEXT_1201 = "_";
  protected final String TEXT_1202 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_1203 = "(";
  protected final String TEXT_1204 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1205 = "(";
  protected final String TEXT_1206 = " ";
  protected final String TEXT_1207 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1208 = NL + "    if (";
  protected final String TEXT_1209 = "() >= ";
  protected final String TEXT_1210 = "_";
  protected final String TEXT_1211 = "())" + NL + "    {";
  protected final String TEXT_1212 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1213 = NL + "    ";
  protected final String TEXT_1214 = " ";
  protected final String TEXT_1215 = " = ";
  protected final String TEXT_1216 = ".";
  protected final String TEXT_1217 = "_One";
  protected final String TEXT_1218 = "();" + NL + "    boolean ";
  protected final String TEXT_1219 = " = ";
  protected final String TEXT_1220 = " != null && !this.equals(";
  protected final String TEXT_1221 = ");" + NL + "" + NL + "    if (";
  protected final String TEXT_1222 = " && ";
  protected final String TEXT_1223 = ".";
  protected final String TEXT_1224 = "() <= ";
  protected final String TEXT_1225 = "_";
  protected final String TEXT_1226 = "())" + NL + "    {";
  protected final String TEXT_1227 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1228 = NL + NL + "    if (";
  protected final String TEXT_1229 = ")" + NL + "    {";
  protected final String TEXT_1230 = NL + "      ";
  protected final String TEXT_1231 = ".";
  protected final String TEXT_1232 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1233 = NL + "      ";
  protected final String TEXT_1234 = ".add(";
  protected final String TEXT_1235 = ");" + NL + "    }";
  protected final String TEXT_1236 = NL + "    wasAdded = true;";
  protected final String TEXT_1237 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1238 = "(";
  protected final String TEXT_1239 = " ";
  protected final String TEXT_1240 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1241 = NL + "    //Unable to remove ";
  protected final String TEXT_1242 = ", as it must always have a ";
  protected final String TEXT_1243 = NL + "    if (this.equals(";
  protected final String TEXT_1244 = ".";
  protected final String TEXT_1245 = "_One";
  protected final String TEXT_1246 = "()))" + NL + "    {";
  protected final String TEXT_1247 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1248 = " already at minimum (";
  protected final String TEXT_1249 = ")" + NL + "    if (";
  protected final String TEXT_1250 = "() <= ";
  protected final String TEXT_1251 = "_";
  protected final String TEXT_1252 = "())" + NL + "    {";
  protected final String TEXT_1253 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_1254 = NL + "    ";
  protected final String TEXT_1255 = ".remove(";
  protected final String TEXT_1256 = ");";
  protected final String TEXT_1257 = NL + "    wasRemoved = true;";
  protected final String TEXT_1258 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1259 = NL + "  public ";
  protected final String TEXT_1260 = " ";
  protected final String TEXT_1261 = "(";
  protected final String TEXT_1262 = ")" + NL + "  {" + NL + "    if (";
  protected final String TEXT_1263 = "() >= ";
  protected final String TEXT_1264 = "_";
  protected final String TEXT_1265 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_1266 = "(";
  protected final String TEXT_1267 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1268 = "(";
  protected final String TEXT_1269 = " ";
  protected final String TEXT_1270 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1271 = NL + "    if (";
  protected final String TEXT_1272 = "() >= ";
  protected final String TEXT_1273 = "_";
  protected final String TEXT_1274 = "())" + NL + "    {";
  protected final String TEXT_1275 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1276 = NL + "    ";
  protected final String TEXT_1277 = " ";
  protected final String TEXT_1278 = " = ";
  protected final String TEXT_1279 = ".";
  protected final String TEXT_1280 = "_One";
  protected final String TEXT_1281 = "();" + NL + "    boolean ";
  protected final String TEXT_1282 = " = ";
  protected final String TEXT_1283 = " != null && !this.equals(";
  protected final String TEXT_1284 = ");";
  protected final String TEXT_1285 = NL + "    if (";
  protected final String TEXT_1286 = ")" + NL + "    {";
  protected final String TEXT_1287 = NL + "      ";
  protected final String TEXT_1288 = ".";
  protected final String TEXT_1289 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1290 = NL + "      ";
  protected final String TEXT_1291 = ".add(";
  protected final String TEXT_1292 = ");" + NL + "    }";
  protected final String TEXT_1293 = NL + "    wasAdded = true;";
  protected final String TEXT_1294 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1295 = "(";
  protected final String TEXT_1296 = " ";
  protected final String TEXT_1297 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1298 = NL + "    //Unable to remove ";
  protected final String TEXT_1299 = ", as it must always have a ";
  protected final String TEXT_1300 = NL + "    if (!this.equals(";
  protected final String TEXT_1301 = ".";
  protected final String TEXT_1302 = "_One";
  protected final String TEXT_1303 = "()))" + NL + "    {";
  protected final String TEXT_1304 = NL + "      ";
  protected final String TEXT_1305 = ".remove(";
  protected final String TEXT_1306 = ");" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1307 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1308 = NL + "  public boolean ";
  protected final String TEXT_1309 = "_";
  protected final String TEXT_1310 = "(";
  protected final String TEXT_1311 = "... ";
  protected final String TEXT_1312 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1313 = NL + "    ArrayList<";
  protected final String TEXT_1314 = "> ";
  protected final String TEXT_1315 = " = new ArrayList<";
  protected final String TEXT_1316 = ">();" + NL + "    for (";
  protected final String TEXT_1317 = " ";
  protected final String TEXT_1318 = " : ";
  protected final String TEXT_1319 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1320 = ".contains(";
  protected final String TEXT_1321 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_1322 = NL + "      ";
  protected final String TEXT_1323 = ".add(";
  protected final String TEXT_1324 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1325 = ".size() != ";
  protected final String TEXT_1326 = ".length || ";
  protected final String TEXT_1327 = ".size() > ";
  protected final String TEXT_1328 = "_";
  protected final String TEXT_1329 = "())" + NL + "    {";
  protected final String TEXT_1330 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_1331 = "> ";
  protected final String TEXT_1332 = " = new ArrayList<";
  protected final String TEXT_1333 = ">(";
  protected final String TEXT_1334 = "_";
  protected final String TEXT_1335 = "());";
  protected final String TEXT_1336 = NL + "    ";
  protected final String TEXT_1337 = ".clear();" + NL + "    for (";
  protected final String TEXT_1338 = " ";
  protected final String TEXT_1339 = " : ";
  protected final String TEXT_1340 = ")" + NL + "    {";
  protected final String TEXT_1341 = NL + "      ";
  protected final String TEXT_1342 = ".add(";
  protected final String TEXT_1343 = ");" + NL + "      if (";
  protected final String TEXT_1344 = ".contains(";
  protected final String TEXT_1345 = "))" + NL + "      {";
  protected final String TEXT_1346 = NL + "        ";
  protected final String TEXT_1347 = ".remove(";
  protected final String TEXT_1348 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_1349 = NL + "        ";
  protected final String TEXT_1350 = ".";
  protected final String TEXT_1351 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_1352 = " ";
  protected final String TEXT_1353 = " : ";
  protected final String TEXT_1354 = ")" + NL + "    {";
  protected final String TEXT_1355 = NL + "      ";
  protected final String TEXT_1356 = ".";
  protected final String TEXT_1357 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1358 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1359 = NL + "  public ";
  protected final String TEXT_1360 = " ";
  protected final String TEXT_1361 = "(";
  protected final String TEXT_1362 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_1363 = "(";
  protected final String TEXT_1364 = ");" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1365 = "(";
  protected final String TEXT_1366 = " ";
  protected final String TEXT_1367 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1368 = NL + "    ";
  protected final String TEXT_1369 = " ";
  protected final String TEXT_1370 = " = ";
  protected final String TEXT_1371 = ".";
  protected final String TEXT_1372 = "_One";
  protected final String TEXT_1373 = "();" + NL + "    boolean ";
  protected final String TEXT_1374 = " = ";
  protected final String TEXT_1375 = " != null && !this.equals(";
  protected final String TEXT_1376 = ");";
  protected final String TEXT_1377 = NL + "    if (";
  protected final String TEXT_1378 = ")" + NL + "    {";
  protected final String TEXT_1379 = NL + "      ";
  protected final String TEXT_1380 = ".";
  protected final String TEXT_1381 = "(this);" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1382 = NL + "      ";
  protected final String TEXT_1383 = ".add(";
  protected final String TEXT_1384 = ");" + NL + "    }";
  protected final String TEXT_1385 = NL + "    wasAdded = true;";
  protected final String TEXT_1386 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1387 = "(";
  protected final String TEXT_1388 = " ";
  protected final String TEXT_1389 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1390 = NL + "    //Unable to remove ";
  protected final String TEXT_1391 = ", as it must always have a ";
  protected final String TEXT_1392 = NL + "    if (!this.equals(";
  protected final String TEXT_1393 = ".";
  protected final String TEXT_1394 = "_One";
  protected final String TEXT_1395 = "()))" + NL + "    {";
  protected final String TEXT_1396 = NL + "      ";
  protected final String TEXT_1397 = ".remove(";
  protected final String TEXT_1398 = ");";
  protected final String TEXT_1399 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1400 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1401 = NL + "  public boolean ";
  protected final String TEXT_1402 = "_";
  protected final String TEXT_1403 = "(";
  protected final String TEXT_1404 = " ";
  protected final String TEXT_1405 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1406 = NL + "    if (";
  protected final String TEXT_1407 = " == null)" + NL + "    {";
  protected final String TEXT_1408 = NL + "      ";
  protected final String TEXT_1409 = " ";
  protected final String TEXT_1410 = " = ";
  protected final String TEXT_1411 = "_One";
  protected final String TEXT_1412 = "()";
  protected final String TEXT_1413 = "(";
  protected final String TEXT_1414 = ")";
  protected final String TEXT_1415 = ";" + NL + "      clear_";
  protected final String TEXT_1416 = "();" + NL + "      " + NL + "      if (";
  protected final String TEXT_1417 = " != null && ";
  protected final String TEXT_1418 = ".";
  protected final String TEXT_1419 = "() != null)" + NL + "      {";
  protected final String TEXT_1420 = NL + "        ";
  protected final String TEXT_1421 = ".clear_";
  protected final String TEXT_1422 = "();" + NL + "      }" + NL + "      wasSet = true;";
  protected final String TEXT_1423 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1424 = NL + "    ";
  protected final String TEXT_1425 = " ";
  protected final String TEXT_1426 = " = ";
  protected final String TEXT_1427 = "_One";
  protected final String TEXT_1428 = "();" + NL + "    if (";
  protected final String TEXT_1429 = " != null && !";
  protected final String TEXT_1430 = ".equals(";
  protected final String TEXT_1431 = "))" + NL + "    {";
  protected final String TEXT_1432 = NL + "      ";
  protected final String TEXT_1433 = ".clear_";
  protected final String TEXT_1434 = "();" + NL + "    }" + NL;
  protected final String TEXT_1435 = NL + "    ";
  protected final String TEXT_1436 = " = ";
  protected final String TEXT_1437 = "new ArrayList<";
  protected final String TEXT_1438 = ">()";
  protected final String TEXT_1439 = ";";
  protected final String TEXT_1440 = ".add(";
  protected final String TEXT_1441 = ");";
  protected final String TEXT_1442 = NL + "    ";
  protected final String TEXT_1443 = " ";
  protected final String TEXT_1444 = " = ";
  protected final String TEXT_1445 = ".";
  protected final String TEXT_1446 = "_One";
  protected final String TEXT_1447 = "()";
  protected final String TEXT_1448 = "(0)";
  protected final String TEXT_1449 = ";" + NL + "" + NL + "    if (!equals(";
  protected final String TEXT_1450 = "))" + NL + "    {";
  protected final String TEXT_1451 = " " + NL + "      for (";
  protected final String TEXT_1452 = " orphan : ";
  protected final String TEXT_1453 = ")" + NL + "      {";
  protected final String TEXT_1454 = NL + "        ";
  protected final String TEXT_1455 = "_";
  protected final String TEXT_1456 = "((";
  protected final String TEXT_1457 = ")orphan,this);" + NL + "      }      ";
  protected final String TEXT_1458 = NL + "        ";
  protected final String TEXT_1459 = "_";
  protected final String TEXT_1460 = "(";
  protected final String TEXT_1461 = ",this);";
  protected final String TEXT_1462 = NL + "      ";
  protected final String TEXT_1463 = ".";
  protected final String TEXT_1464 = "_";
  protected final String TEXT_1465 = "(this);";
  protected final String TEXT_1466 = NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1467 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1468 = NL + "  private void ";
  protected final String TEXT_1469 = "(";
  protected final String TEXT_1470 = " ";
  protected final String TEXT_1471 = ", ";
  protected final String TEXT_1472 = " ";
  protected final String TEXT_1473 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_1474 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_1475 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_1476 = ", ";
  protected final String TEXT_1477 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_1478 = " to ";
  protected final String TEXT_1479 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1480 = NL + "  public boolean ";
  protected final String TEXT_1481 = "(";
  protected final String TEXT_1482 = " ";
  protected final String TEXT_1483 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1484 = NL + "    if (!";
  protected final String TEXT_1485 = ".contains(";
  protected final String TEXT_1486 = "))" + NL + "    {";
  protected final String TEXT_1487 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1488 = "() <= ";
  protected final String TEXT_1489 = "_";
  protected final String TEXT_1490 = "())" + NL + "    {";
  protected final String TEXT_1491 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_1492 = ".indexOf(";
  protected final String TEXT_1493 = ");";
  protected final String TEXT_1494 = NL + "    ";
  protected final String TEXT_1495 = ".remove(oldIndex);";
  protected final String TEXT_1496 = NL + "    if (";
  protected final String TEXT_1497 = ".";
  protected final String TEXT_1498 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_1499 = ".";
  protected final String TEXT_1500 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_1501 = NL + "        ";
  protected final String TEXT_1502 = ".add(oldIndex,";
  protected final String TEXT_1503 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1504 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1505 = NL + "  public boolean ";
  protected final String TEXT_1506 = "(";
  protected final String TEXT_1507 = " ";
  protected final String TEXT_1508 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1509 = NL + "    if (!";
  protected final String TEXT_1510 = ".contains(";
  protected final String TEXT_1511 = "))" + NL + "    {";
  protected final String TEXT_1512 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1513 = "() <= ";
  protected final String TEXT_1514 = "_";
  protected final String TEXT_1515 = "())" + NL + "    {";
  protected final String TEXT_1516 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    int oldIndex = ";
  protected final String TEXT_1517 = ".indexOf(";
  protected final String TEXT_1518 = ");";
  protected final String TEXT_1519 = NL + "    ";
  protected final String TEXT_1520 = ".remove(oldIndex);";
  protected final String TEXT_1521 = NL + "    if (";
  protected final String TEXT_1522 = ".";
  protected final String TEXT_1523 = "(this) == -1)" + NL + "    {" + NL + "      wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasRemoved = ";
  protected final String TEXT_1524 = ".";
  protected final String TEXT_1525 = "(this);" + NL + "      if (!wasRemoved)" + NL + "      {";
  protected final String TEXT_1526 = NL + "        ";
  protected final String TEXT_1527 = ".add(oldIndex,";
  protected final String TEXT_1528 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_1529 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1530 = NL + "  public boolean ";
  protected final String TEXT_1531 = "_";
  protected final String TEXT_1532 = "(";
  protected final String TEXT_1533 = " ";
  protected final String TEXT_1534 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1535 = NL + "    if (";
  protected final String TEXT_1536 = " != null && ";
  protected final String TEXT_1537 = ".";
  protected final String TEXT_1538 = "() >= ";
  protected final String TEXT_1539 = ".";
  protected final String TEXT_1540 = "_";
  protected final String TEXT_1541 = "())" + NL + "    {";
  protected final String TEXT_1542 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1543 = NL + "    ";
  protected final String TEXT_1544 = " ";
  protected final String TEXT_1545 = " = ";
  protected final String TEXT_1546 = "_One";
  protected final String TEXT_1547 = "()";
  protected final String TEXT_1548 = "(";
  protected final String TEXT_1549 = ")";
  protected final String TEXT_1550 = ";";
  protected final String TEXT_1551 = NL + "    ";
  protected final String TEXT_1552 = " = ";
  protected final String TEXT_1553 = ";";
  protected final String TEXT_1554 = NL + "    ";
  protected final String TEXT_1555 = ".clear();";
  protected final String TEXT_1556 = NL + "    ";
  protected final String TEXT_1557 = ".add(";
  protected final String TEXT_1558 = ");";
  protected final String TEXT_1559 = NL + "    if (";
  protected final String TEXT_1560 = " != null && !";
  protected final String TEXT_1561 = ".equals(";
  protected final String TEXT_1562 = "))" + NL + "    {";
  protected final String TEXT_1563 = NL + "      ";
  protected final String TEXT_1564 = ".";
  protected final String TEXT_1565 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1566 = " != null)" + NL + "    {";
  protected final String TEXT_1567 = NL + "      ";
  protected final String TEXT_1568 = ".";
  protected final String TEXT_1569 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1570 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1571 = NL + "  public boolean ";
  protected final String TEXT_1572 = "_";
  protected final String TEXT_1573 = "(";
  protected final String TEXT_1574 = " ";
  protected final String TEXT_1575 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1576 = NL + "    if (";
  protected final String TEXT_1577 = " == null)" + NL + "    {";
  protected final String TEXT_1578 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1579 = NL + "    ";
  protected final String TEXT_1580 = " ";
  protected final String TEXT_1581 = " = ";
  protected final String TEXT_1582 = "_One";
  protected final String TEXT_1583 = "()";
  protected final String TEXT_1584 = "(";
  protected final String TEXT_1585 = ")";
  protected final String TEXT_1586 = ";";
  protected final String TEXT_1587 = NL + "    ";
  protected final String TEXT_1588 = " = ";
  protected final String TEXT_1589 = ";" + NL + "    if (";
  protected final String TEXT_1590 = " != null && !";
  protected final String TEXT_1591 = ".equals(";
  protected final String TEXT_1592 = "))" + NL + "    {";
  protected final String TEXT_1593 = NL + "      ";
  protected final String TEXT_1594 = ".";
  protected final String TEXT_1595 = "(this);" + NL + "    }";
  protected final String TEXT_1596 = NL + "    ";
  protected final String TEXT_1597 = ".";
  protected final String TEXT_1598 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1599 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1600 = NL + "  public boolean ";
  protected final String TEXT_1601 = "_";
  protected final String TEXT_1602 = "(";
  protected final String TEXT_1603 = " ";
  protected final String TEXT_1604 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1605 = NL + "    if (";
  protected final String TEXT_1606 = " == null)" + NL + "    {";
  protected final String TEXT_1607 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1608 = NL + "    ";
  protected final String TEXT_1609 = " ";
  protected final String TEXT_1610 = " = ";
  protected final String TEXT_1611 = "_One";
  protected final String TEXT_1612 = "()";
  protected final String TEXT_1613 = "(";
  protected final String TEXT_1614 = ")";
  protected final String TEXT_1615 = ";";
  protected final String TEXT_1616 = NL + "    ";
  protected final String TEXT_1617 = " = ";
  protected final String TEXT_1618 = ";" + NL + "    if (";
  protected final String TEXT_1619 = " != null && !";
  protected final String TEXT_1620 = ".equals(";
  protected final String TEXT_1621 = "))" + NL + "    {";
  protected final String TEXT_1622 = NL + "      ";
  protected final String TEXT_1623 = ".";
  protected final String TEXT_1624 = "(this);" + NL + "    }" + NL + "    if (!";
  protected final String TEXT_1625 = ".";
  protected final String TEXT_1626 = "(this))" + NL + "    {";
  protected final String TEXT_1627 = NL + "      ";
  protected final String TEXT_1628 = " = ";
  protected final String TEXT_1629 = ";" + NL + "      wasSet = false;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      wasSet = true;" + NL + "    }";
  protected final String TEXT_1630 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1631 = NL + "  public boolean ";
  protected final String TEXT_1632 = "_";
  protected final String TEXT_1633 = "(";
  protected final String TEXT_1634 = " ";
  protected final String TEXT_1635 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1636 = NL + "    //Must provide ";
  protected final String TEXT_1637 = " to ";
  protected final String TEXT_1638 = NL + "    if (";
  protected final String TEXT_1639 = " == null)" + NL + "    {";
  protected final String TEXT_1640 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_1641 = " already at maximum (";
  protected final String TEXT_1642 = ")" + NL + "    if (";
  protected final String TEXT_1643 = ".";
  protected final String TEXT_1644 = "() >= ";
  protected final String TEXT_1645 = ".";
  protected final String TEXT_1646 = "_";
  protected final String TEXT_1647 = "())" + NL + "    {";
  protected final String TEXT_1648 = NL + "      return wasSet;" + NL + "    }" + NL + "    ";
  protected final String TEXT_1649 = NL + "    ";
  protected final String TEXT_1650 = " ";
  protected final String TEXT_1651 = " = ";
  protected final String TEXT_1652 = "_One";
  protected final String TEXT_1653 = "()";
  protected final String TEXT_1654 = "(";
  protected final String TEXT_1655 = ")";
  protected final String TEXT_1656 = ";";
  protected final String TEXT_1657 = NL + "    ";
  protected final String TEXT_1658 = " = ";
  protected final String TEXT_1659 = ";";
  protected final String TEXT_1660 = NL + "    ";
  protected final String TEXT_1661 = ".clear();";
  protected final String TEXT_1662 = NL + "    ";
  protected final String TEXT_1663 = ".add(";
  protected final String TEXT_1664 = ");";
  protected final String TEXT_1665 = NL + "    if (";
  protected final String TEXT_1666 = " != null && !";
  protected final String TEXT_1667 = ".equals(";
  protected final String TEXT_1668 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1669 = ".";
  protected final String TEXT_1670 = "(this);" + NL + "      if (!didRemove)" + NL + "      {" + NL + "      \t";
  protected final String TEXT_1671 = NL + "        ";
  protected final String TEXT_1672 = " = ";
  protected final String TEXT_1673 = ";";
  protected final String TEXT_1674 = NL + "        ";
  protected final String TEXT_1675 = ".clear();";
  protected final String TEXT_1676 = NL + "        ";
  protected final String TEXT_1677 = ".add(";
  protected final String TEXT_1678 = ");";
  protected final String TEXT_1679 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1680 = NL + "    ";
  protected final String TEXT_1681 = ".";
  protected final String TEXT_1682 = "(this);" + NL + "    wasSet = true;";
  protected final String TEXT_1683 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1684 = NL + "  public boolean ";
  protected final String TEXT_1685 = "_";
  protected final String TEXT_1686 = "(";
  protected final String TEXT_1687 = " ";
  protected final String TEXT_1688 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1689 = NL + "    //Must provide ";
  protected final String TEXT_1690 = " to ";
  protected final String TEXT_1691 = NL + "    if (";
  protected final String TEXT_1692 = " == null)" + NL + "    {";
  protected final String TEXT_1693 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1694 = "_One";
  protected final String TEXT_1695 = "() != null && ";
  protected final String TEXT_1696 = "_One";
  protected final String TEXT_1697 = "().";
  protected final String TEXT_1698 = "() <= ";
  protected final String TEXT_1699 = ".";
  protected final String TEXT_1700 = "_";
  protected final String TEXT_1701 = "())" + NL + "    {";
  protected final String TEXT_1702 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1703 = NL + "    ";
  protected final String TEXT_1704 = " ";
  protected final String TEXT_1705 = " = ";
  protected final String TEXT_1706 = "_One";
  protected final String TEXT_1707 = "()";
  protected final String TEXT_1708 = "(";
  protected final String TEXT_1709 = ")";
  protected final String TEXT_1710 = ";";
  protected final String TEXT_1711 = NL + "    ";
  protected final String TEXT_1712 = " = ";
  protected final String TEXT_1713 = ";";
  protected final String TEXT_1714 = NL + "    ";
  protected final String TEXT_1715 = ".clear();";
  protected final String TEXT_1716 = NL + "    ";
  protected final String TEXT_1717 = ".add(";
  protected final String TEXT_1718 = ");";
  protected final String TEXT_1719 = NL + "    if (";
  protected final String TEXT_1720 = " != null && !";
  protected final String TEXT_1721 = ".equals(";
  protected final String TEXT_1722 = "))" + NL + "    {" + NL + "      boolean didRemove = ";
  protected final String TEXT_1723 = ".";
  protected final String TEXT_1724 = "(this);" + NL + "      if (!didRemove)" + NL + "      {" + NL + "      \t";
  protected final String TEXT_1725 = NL + "        ";
  protected final String TEXT_1726 = " = ";
  protected final String TEXT_1727 = ";";
  protected final String TEXT_1728 = NL + "    \t";
  protected final String TEXT_1729 = ".clear();" + NL + "    \t";
  protected final String TEXT_1730 = ".add(";
  protected final String TEXT_1731 = ");";
  protected final String TEXT_1732 = NL + "        return wasSet;" + NL + "      }" + NL + "    }";
  protected final String TEXT_1733 = NL + "    ";
  protected final String TEXT_1734 = ".";
  protected final String TEXT_1735 = "(this);";
  protected final String TEXT_1736 = NL + "    ";
  protected final String TEXT_1737 = "_One";
  protected final String TEXT_1738 = "().";
  protected final String TEXT_1739 = "(this);";
  protected final String TEXT_1740 = NL + "    wasSet = true;";
  protected final String TEXT_1741 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1742 = NL + "  public boolean ";
  protected final String TEXT_1743 = "(";
  protected final String TEXT_1744 = " ";
  protected final String TEXT_1745 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1746 = NL + "    ";
  protected final String TEXT_1747 = " ";
  protected final String TEXT_1748 = " = ";
  protected final String TEXT_1749 = ".";
  protected final String TEXT_1750 = "_One";
  protected final String TEXT_1751 = "();";
  protected final String TEXT_1752 = NL + "    if (";
  protected final String TEXT_1753 = " == null)" + NL + "    {";
  protected final String TEXT_1754 = NL + "      ";
  protected final String TEXT_1755 = ".";
  protected final String TEXT_1756 = "(this);";
  protected final String TEXT_1757 = NL + "      ";
  protected final String TEXT_1758 = ".clear_";
  protected final String TEXT_1759 = "();";
  protected final String TEXT_1760 = NL + "      ";
  protected final String TEXT_1761 = ".";
  protected final String TEXT_1762 = "(this);";
  protected final String TEXT_1763 = NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1764 = "))" + NL + "    {";
  protected final String TEXT_1765 = NL + "      ";
  protected final String TEXT_1766 = ".";
  protected final String TEXT_1767 = "(";
  protected final String TEXT_1768 = ");";
  protected final String TEXT_1769 = NL + "      ";
  protected final String TEXT_1770 = "(";
  protected final String TEXT_1771 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1772 = NL + "      ";
  protected final String TEXT_1773 = ".add(";
  protected final String TEXT_1774 = ");" + NL + "    }";
  protected final String TEXT_1775 = NL + "    wasAdded = true;";
  protected final String TEXT_1776 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1777 = "(";
  protected final String TEXT_1778 = " ";
  protected final String TEXT_1779 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1780 = NL + "    if (";
  protected final String TEXT_1781 = ".contains(";
  protected final String TEXT_1782 = "))" + NL + "    {";
  protected final String TEXT_1783 = NL + "      ";
  protected final String TEXT_1784 = ".remove(";
  protected final String TEXT_1785 = ");";
  protected final String TEXT_1786 = NL + "      ";
  protected final String TEXT_1787 = ".clear_";
  protected final String TEXT_1788 = "();" + NL + "      wasRemoved = true;";
  protected final String TEXT_1789 = NL + "    }";
  protected final String TEXT_1790 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1791 = NL + "  public boolean ";
  protected final String TEXT_1792 = "_";
  protected final String TEXT_1793 = "(";
  protected final String TEXT_1794 = " ";
  protected final String TEXT_1795 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1796 = NL + "    ";
  protected final String TEXT_1797 = " ";
  protected final String TEXT_1798 = " = ";
  protected final String TEXT_1799 = "_One";
  protected final String TEXT_1800 = "()";
  protected final String TEXT_1801 = "(";
  protected final String TEXT_1802 = ")";
  protected final String TEXT_1803 = ";";
  protected final String TEXT_1804 = NL + "    ";
  protected final String TEXT_1805 = " = ";
  protected final String TEXT_1806 = ";";
  protected final String TEXT_1807 = NL + "    ";
  protected final String TEXT_1808 = ".clear();";
  protected final String TEXT_1809 = NL + "    ";
  protected final String TEXT_1810 = ".add(";
  protected final String TEXT_1811 = ");";
  protected final String TEXT_1812 = NL + "    if (";
  protected final String TEXT_1813 = " != null && !";
  protected final String TEXT_1814 = ".equals(";
  protected final String TEXT_1815 = "))" + NL + "    {";
  protected final String TEXT_1816 = NL + "      ";
  protected final String TEXT_1817 = ".";
  protected final String TEXT_1818 = "(this);" + NL + "    }" + NL + "    if (";
  protected final String TEXT_1819 = " != null)" + NL + "    {";
  protected final String TEXT_1820 = NL + "      ";
  protected final String TEXT_1821 = ".";
  protected final String TEXT_1822 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1823 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1824 = NL + "  public boolean ";
  protected final String TEXT_1825 = "(";
  protected final String TEXT_1826 = " ";
  protected final String TEXT_1827 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1828 = NL + "    if (";
  protected final String TEXT_1829 = "() >= ";
  protected final String TEXT_1830 = "_";
  protected final String TEXT_1831 = "())" + NL + "    {";
  protected final String TEXT_1832 = NL + "      return wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_1833 = NL + "    ";
  protected final String TEXT_1834 = " ";
  protected final String TEXT_1835 = " = ";
  protected final String TEXT_1836 = ".";
  protected final String TEXT_1837 = "_One";
  protected final String TEXT_1838 = "();";
  protected final String TEXT_1839 = NL + "    if (";
  protected final String TEXT_1840 = " == null)" + NL + "    {";
  protected final String TEXT_1841 = NL + "      ";
  protected final String TEXT_1842 = ".";
  protected final String TEXT_1843 = "(this);" + NL + "    }" + NL + "    else if (!this.equals(";
  protected final String TEXT_1844 = "))" + NL + "    {";
  protected final String TEXT_1845 = NL + "      ";
  protected final String TEXT_1846 = ".";
  protected final String TEXT_1847 = "(";
  protected final String TEXT_1848 = ");";
  protected final String TEXT_1849 = NL + "      ";
  protected final String TEXT_1850 = "(";
  protected final String TEXT_1851 = ");" + NL + "    }" + NL + "    else" + NL + "    {";
  protected final String TEXT_1852 = NL + "      ";
  protected final String TEXT_1853 = ".add(";
  protected final String TEXT_1854 = ");" + NL + "    }";
  protected final String TEXT_1855 = NL + "    wasAdded = true;";
  protected final String TEXT_1856 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1857 = "(";
  protected final String TEXT_1858 = " ";
  protected final String TEXT_1859 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1860 = NL + "    if (";
  protected final String TEXT_1861 = ".contains(";
  protected final String TEXT_1862 = "))" + NL + "    {";
  protected final String TEXT_1863 = NL + "      ";
  protected final String TEXT_1864 = ".remove(";
  protected final String TEXT_1865 = ");";
  protected final String TEXT_1866 = NL + "      ";
  protected final String TEXT_1867 = ".clear_";
  protected final String TEXT_1868 = "();" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1869 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1870 = NL + "  public boolean ";
  protected final String TEXT_1871 = "(";
  protected final String TEXT_1872 = " ";
  protected final String TEXT_1873 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1874 = NL + "    if (";
  protected final String TEXT_1875 = "() < ";
  protected final String TEXT_1876 = "_";
  protected final String TEXT_1877 = "())" + NL + "    {";
  protected final String TEXT_1878 = NL + "      ";
  protected final String TEXT_1879 = ".add(";
  protected final String TEXT_1880 = ");";
  protected final String TEXT_1881 = NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_1882 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1883 = "(";
  protected final String TEXT_1884 = " ";
  protected final String TEXT_1885 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1886 = NL + "    if (!";
  protected final String TEXT_1887 = ".contains(";
  protected final String TEXT_1888 = "))" + NL + "    {";
  protected final String TEXT_1889 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1890 = "() <= ";
  protected final String TEXT_1891 = "_";
  protected final String TEXT_1892 = "())" + NL + "    {";
  protected final String TEXT_1893 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_1894 = NL;
  protected final String TEXT_1895 = NL + "    ";
  protected final String TEXT_1896 = ".remove(";
  protected final String TEXT_1897 = ");";
  protected final String TEXT_1898 = NL + "    wasRemoved = true;";
  protected final String TEXT_1899 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1900 = NL + "  public boolean ";
  protected final String TEXT_1901 = "(";
  protected final String TEXT_1902 = " ";
  protected final String TEXT_1903 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_1904 = NL + "    if (";
  protected final String TEXT_1905 = "() >= ";
  protected final String TEXT_1906 = "_";
  protected final String TEXT_1907 = "())" + NL + "    {";
  protected final String TEXT_1908 = NL + "      return wasAdded;" + NL + "    }";
  protected final String TEXT_1909 = NL + "    ";
  protected final String TEXT_1910 = " ";
  protected final String TEXT_1911 = " = ";
  protected final String TEXT_1912 = ".";
  protected final String TEXT_1913 = "_One";
  protected final String TEXT_1914 = "();" + NL + "    if (";
  protected final String TEXT_1915 = " != null && ";
  protected final String TEXT_1916 = ".";
  protected final String TEXT_1917 = "() <= ";
  protected final String TEXT_1918 = "_";
  protected final String TEXT_1919 = "())" + NL + "    {";
  protected final String TEXT_1920 = NL + "      return wasAdded;" + NL + "    }" + NL + "    else if (";
  protected final String TEXT_1921 = " != null)" + NL + "    {";
  protected final String TEXT_1922 = NL + "      ";
  protected final String TEXT_1923 = ".";
  protected final String TEXT_1924 = ".remove(";
  protected final String TEXT_1925 = ");" + NL + "    }";
  protected final String TEXT_1926 = NL + "    ";
  protected final String TEXT_1927 = ".add(";
  protected final String TEXT_1928 = ");";
  protected final String TEXT_1929 = NL + "    ";
  protected final String TEXT_1930 = "(";
  protected final String TEXT_1931 = ",this);" + NL + "    wasAdded = true;";
  protected final String TEXT_1932 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_1933 = "(";
  protected final String TEXT_1934 = " ";
  protected final String TEXT_1935 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_1936 = NL + "    if (";
  protected final String TEXT_1937 = ".contains(";
  protected final String TEXT_1938 = ") && ";
  protected final String TEXT_1939 = "() > ";
  protected final String TEXT_1940 = "_";
  protected final String TEXT_1941 = "())" + NL + "    {";
  protected final String TEXT_1942 = NL + "      ";
  protected final String TEXT_1943 = ".remove(";
  protected final String TEXT_1944 = ");";
  protected final String TEXT_1945 = NL + "      ";
  protected final String TEXT_1946 = "(";
  protected final String TEXT_1947 = ",null);" + NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1948 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1949 = NL + "  public boolean ";
  protected final String TEXT_1950 = "_";
  protected final String TEXT_1951 = "(";
  protected final String TEXT_1952 = "... ";
  protected final String TEXT_1953 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_1954 = NL + "    ArrayList<";
  protected final String TEXT_1955 = "> ";
  protected final String TEXT_1956 = " = new ArrayList<";
  protected final String TEXT_1957 = ">();" + NL + "    for (";
  protected final String TEXT_1958 = " ";
  protected final String TEXT_1959 = " : ";
  protected final String TEXT_1960 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_1961 = ".contains(";
  protected final String TEXT_1962 = "))" + NL + "      {";
  protected final String TEXT_1963 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_1964 = ".";
  protected final String TEXT_1965 = "_One";
  protected final String TEXT_1966 = "() != null && !this.equals(";
  protected final String TEXT_1967 = ".";
  protected final String TEXT_1968 = "_One";
  protected final String TEXT_1969 = "()))" + NL + "      {";
  protected final String TEXT_1970 = NL + "        return wasSet;" + NL + "      }";
  protected final String TEXT_1971 = NL + "      ";
  protected final String TEXT_1972 = ".add(";
  protected final String TEXT_1973 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_1974 = ".size() != ";
  protected final String TEXT_1975 = "_";
  protected final String TEXT_1976 = "())" + NL + "    {";
  protected final String TEXT_1977 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_1978 = NL + "    ";
  protected final String TEXT_1979 = ".removeAll(";
  protected final String TEXT_1980 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_1981 = " orphan : ";
  protected final String TEXT_1982 = "_";
  protected final String TEXT_1983 = "())" + NL + "    {";
  protected final String TEXT_1984 = NL + "      ";
  protected final String TEXT_1985 = "_";
  protected final String TEXT_1986 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_1987 = NL + "    ";
  protected final String TEXT_1988 = ".clear();" + NL + "    for (";
  protected final String TEXT_1989 = " ";
  protected final String TEXT_1990 = " : ";
  protected final String TEXT_1991 = ")" + NL + "    {";
  protected final String TEXT_1992 = NL + "      ";
  protected final String TEXT_1993 = "_";
  protected final String TEXT_1994 = "(";
  protected final String TEXT_1995 = ", this);";
  protected final String TEXT_1996 = NL + "      ";
  protected final String TEXT_1997 = ".add(";
  protected final String TEXT_1998 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_1999 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_2000 = NL + "  private void ";
  protected final String TEXT_2001 = "(";
  protected final String TEXT_2002 = " ";
  protected final String TEXT_2003 = ", ";
  protected final String TEXT_2004 = " ";
  protected final String TEXT_2005 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_2006 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_2007 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_2008 = ", ";
  protected final String TEXT_2009 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_2010 = " to ";
  protected final String TEXT_2011 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_2012 = NL + "  public boolean ";
  protected final String TEXT_2013 = "(";
  protected final String TEXT_2014 = " ";
  protected final String TEXT_2015 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_2016 = NL + "    ";
  protected final String TEXT_2017 = ".add(";
  protected final String TEXT_2018 = ");";
  protected final String TEXT_2019 = NL + "    wasAdded = true;";
  protected final String TEXT_2020 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_2021 = "(";
  protected final String TEXT_2022 = " ";
  protected final String TEXT_2023 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_2024 = NL + "    if (";
  protected final String TEXT_2025 = ".contains(";
  protected final String TEXT_2026 = "))" + NL + "    {";
  protected final String TEXT_2027 = NL + "      ";
  protected final String TEXT_2028 = ".remove(";
  protected final String TEXT_2029 = ");";
  protected final String TEXT_2030 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_2031 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_2032 = NL + "  public boolean ";
  protected final String TEXT_2033 = "(";
  protected final String TEXT_2034 = " ";
  protected final String TEXT_2035 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_2036 = NL + "    if (";
  protected final String TEXT_2037 = "() < ";
  protected final String TEXT_2038 = "_";
  protected final String TEXT_2039 = "())" + NL + "    {";
  protected final String TEXT_2040 = NL + "      ";
  protected final String TEXT_2041 = ".add(";
  protected final String TEXT_2042 = ");";
  protected final String TEXT_2043 = NL + "      wasAdded = true;" + NL + "    }";
  protected final String TEXT_2044 = NL + "    return wasAdded;" + NL + "  }";
  protected final String TEXT_2045 = NL;
  protected final String TEXT_2046 = NL + "  public boolean ";
  protected final String TEXT_2047 = "(";
  protected final String TEXT_2048 = " ";
  protected final String TEXT_2049 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_2050 = NL + "    if (";
  protected final String TEXT_2051 = ".contains(";
  protected final String TEXT_2052 = "))" + NL + "    {";
  protected final String TEXT_2053 = NL + "      ";
  protected final String TEXT_2054 = ".remove(";
  protected final String TEXT_2055 = ");";
  protected final String TEXT_2056 = NL + "      wasRemoved = true;" + NL + "    }";
  protected final String TEXT_2057 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_2058 = NL + "  public boolean ";
  protected final String TEXT_2059 = "(";
  protected final String TEXT_2060 = " ";
  protected final String TEXT_2061 = ")" + NL + "  {" + NL + "    boolean wasAdded = false;";
  protected final String TEXT_2062 = NL + "    ";
  protected final String TEXT_2063 = ".add(";
  protected final String TEXT_2064 = ");";
  protected final String TEXT_2065 = NL + "    wasAdded = true;";
  protected final String TEXT_2066 = NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_2067 = "(";
  protected final String TEXT_2068 = " ";
  protected final String TEXT_2069 = ")" + NL + "  {" + NL + "    boolean wasRemoved = false;";
  protected final String TEXT_2070 = NL + "    if (!";
  protected final String TEXT_2071 = ".contains(";
  protected final String TEXT_2072 = "))" + NL + "    {";
  protected final String TEXT_2073 = NL + "      return wasRemoved;" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_2074 = "() <= ";
  protected final String TEXT_2075 = "_";
  protected final String TEXT_2076 = "())" + NL + "    {";
  protected final String TEXT_2077 = NL + "      return wasRemoved;" + NL + "    }";
  protected final String TEXT_2078 = NL;
  protected final String TEXT_2079 = NL + "    ";
  protected final String TEXT_2080 = ".remove(";
  protected final String TEXT_2081 = ");";
  protected final String TEXT_2082 = NL + "    wasRemoved = true;";
  protected final String TEXT_2083 = NL + "    return wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_2084 = NL + "  ";
  protected final String TEXT_2085 = " boolean ";
  protected final String TEXT_2086 = "(";
  protected final String TEXT_2087 = "... ";
  protected final String TEXT_2088 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_2089 = NL + "    ArrayList<";
  protected final String TEXT_2090 = "> ";
  protected final String TEXT_2091 = " = new ArrayList<";
  protected final String TEXT_2092 = ">();" + NL + "    for (";
  protected final String TEXT_2093 = " ";
  protected final String TEXT_2094 = " : ";
  protected final String TEXT_2095 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2096 = ".contains(";
  protected final String TEXT_2097 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_2098 = NL + "      ";
  protected final String TEXT_2099 = ".add(";
  protected final String TEXT_2100 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_2101 = ".size() != ";
  protected final String TEXT_2102 = ".length || ";
  protected final String TEXT_2103 = ".size() != ";
  protected final String TEXT_2104 = "_";
  protected final String TEXT_2105 = "())" + NL + "    {";
  protected final String TEXT_2106 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_2107 = NL + "    ";
  protected final String TEXT_2108 = ".clear();";
  protected final String TEXT_2109 = NL + "    ";
  protected final String TEXT_2110 = ".addAll(";
  protected final String TEXT_2111 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_2112 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_2113 = NL + "  ";
  protected final String TEXT_2114 = " boolean ";
  protected final String TEXT_2115 = "(";
  protected final String TEXT_2116 = "... ";
  protected final String TEXT_2117 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_2118 = NL + "    ArrayList<";
  protected final String TEXT_2119 = "> ";
  protected final String TEXT_2120 = " = new ArrayList<";
  protected final String TEXT_2121 = ">();" + NL + "    for (";
  protected final String TEXT_2122 = " ";
  protected final String TEXT_2123 = " : ";
  protected final String TEXT_2124 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2125 = ".contains(";
  protected final String TEXT_2126 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_2127 = NL + "      ";
  protected final String TEXT_2128 = ".add(";
  protected final String TEXT_2129 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_2130 = ".size() != ";
  protected final String TEXT_2131 = ".length)" + NL + "    {";
  protected final String TEXT_2132 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_2133 = NL + "    ";
  protected final String TEXT_2134 = ".clear();";
  protected final String TEXT_2135 = NL + "    ";
  protected final String TEXT_2136 = ".addAll(";
  protected final String TEXT_2137 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_2138 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_2139 = NL + "  public boolean ";
  protected final String TEXT_2140 = "_";
  protected final String TEXT_2141 = "(";
  protected final String TEXT_2142 = " ";
  protected final String TEXT_2143 = ")" + NL + "  {" + NL + "    //" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "    boolean wasSet = false;";
  protected final String TEXT_2144 = NL + "    ";
  protected final String TEXT_2145 = " ";
  protected final String TEXT_2146 = " = ";
  protected final String TEXT_2147 = "_One";
  protected final String TEXT_2148 = "()";
  protected final String TEXT_2149 = "(";
  protected final String TEXT_2150 = ")";
  protected final String TEXT_2151 = ";" + NL + "" + NL + "    if (";
  protected final String TEXT_2152 = " == null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2153 = " != null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_2154 = ".";
  protected final String TEXT_2155 = "(this))" + NL + "        {";
  protected final String TEXT_2156 = NL + "          ";
  protected final String TEXT_2157 = " = ";
  protected final String TEXT_2158 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if (";
  protected final String TEXT_2159 = " != null)" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2160 = " == null)" + NL + "      {" + NL + "        if (";
  protected final String TEXT_2161 = ".";
  protected final String TEXT_2162 = "_";
  protected final String TEXT_2163 = "() < ";
  protected final String TEXT_2164 = ".";
  protected final String TEXT_2165 = "())" + NL + "        {";
  protected final String TEXT_2166 = NL + "          ";
  protected final String TEXT_2167 = ".";
  protected final String TEXT_2168 = "(this);";
  protected final String TEXT_2169 = NL + "          ";
  protected final String TEXT_2170 = " = ";
  protected final String TEXT_2171 = ";  // ";
  protected final String TEXT_2172 = " == null" + NL + "          wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if (";
  protected final String TEXT_2173 = ".";
  protected final String TEXT_2174 = "_";
  protected final String TEXT_2175 = "() < ";
  protected final String TEXT_2176 = ".";
  protected final String TEXT_2177 = "())" + NL + "        {";
  protected final String TEXT_2178 = NL + "          ";
  protected final String TEXT_2179 = ".";
  protected final String TEXT_2180 = "(this);";
  protected final String TEXT_2181 = NL + "          ";
  protected final String TEXT_2182 = ".";
  protected final String TEXT_2183 = "(this);";
  protected final String TEXT_2184 = NL + "          ";
  protected final String TEXT_2185 = " = ";
  protected final String TEXT_2186 = ";" + NL + "          wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if (wasSet)" + NL + "    {";
  protected final String TEXT_2187 = NL + "      ";
  protected final String TEXT_2188 = " = ";
  protected final String TEXT_2189 = ";" + NL + "    }" + NL + "    return wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_2190 = NL + "//  public boolean ";
  protected final String TEXT_2191 = "_";
  protected final String TEXT_2192 = "(";
  protected final String TEXT_2193 = " ";
  protected final String TEXT_2194 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_2195 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//" + NL + "//    boolean wasSet = false;" + NL + "//    ";
  protected final String TEXT_2196 = " ";
  protected final String TEXT_2197 = " = ";
  protected final String TEXT_2198 = "_One";
  protected final String TEXT_2199 = "()";
  protected final String TEXT_2200 = "(";
  protected final String TEXT_2201 = ")";
  protected final String TEXT_2202 = ";" + NL + "//  " + NL + "//    if (";
  protected final String TEXT_2203 = " == null)" + NL + "//    {  " + NL + "//      if (";
  protected final String TEXT_2204 = " != null)" + NL + "//      { " + NL + "//        if (";
  protected final String TEXT_2205 = ".";
  protected final String TEXT_2206 = "(this))" + NL + "//          ";
  protected final String TEXT_2207 = " = ";
  protected final String TEXT_2208 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    else" + NL + "//    {" + NL + "//      if (";
  protected final String TEXT_2209 = " != null)" + NL + "//      {" + NL + "//        if (";
  protected final String TEXT_2210 = " == null)" + NL + "//        {" + NL + "//          if (";
  protected final String TEXT_2211 = ".";
  protected final String TEXT_2212 = " < ";
  protected final String TEXT_2213 = ".";
  protected final String TEXT_2214 = ")" + NL + "//            ";
  protected final String TEXT_2215 = ".";
  protected final String TEXT_2216 = "(this);" + NL + "//            ";
  protected final String TEXT_2217 = " = ";
  protected final String TEXT_2218 = "  // ";
  protected final String TEXT_2219 = " == null;" + NL + "//            wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//      else" + NL + "//      {" + NL + "//        if (   ";
  protected final String TEXT_2220 = ".";
  protected final String TEXT_2221 = " < ";
  protected final String TEXT_2222 = ".";
  protected final String TEXT_2223 = "()" + NL + "//            && ";
  protected final String TEXT_2224 = ".";
  protected final String TEXT_2225 = " > ";
  protected final String TEXT_2226 = ".";
  protected final String TEXT_2227 = "()" + NL + "//           )" + NL + "//          ";
  protected final String TEXT_2228 = ".";
  protected final String TEXT_2229 = "(this);" + NL + "//          ";
  protected final String TEXT_2230 = ".";
  protected final String TEXT_2231 = "(this);" + NL + "//          ";
  protected final String TEXT_2232 = " = ";
  protected final String TEXT_2233 = ";" + NL + "//          wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    " + NL + "//    if (wasSet)" + NL + "//    {" + NL + "//      ";
  protected final String TEXT_2234 = " = ";
  protected final String TEXT_2235 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return wasSet;" + NL + "//  }";
  protected final String TEXT_2236 = NL + "  public boolean ";
  protected final String TEXT_2237 = "_";
  protected final String TEXT_2238 = "(";
  protected final String TEXT_2239 = "... ";
  protected final String TEXT_2240 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_2241 = NL + "    ArrayList<";
  protected final String TEXT_2242 = "> ";
  protected final String TEXT_2243 = " = new ArrayList<";
  protected final String TEXT_2244 = ">();" + NL + "    for (";
  protected final String TEXT_2245 = " ";
  protected final String TEXT_2246 = " : ";
  protected final String TEXT_2247 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2248 = ".contains(";
  protected final String TEXT_2249 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_2250 = NL + "      ";
  protected final String TEXT_2251 = ".add(";
  protected final String TEXT_2252 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_2253 = ".size() != ";
  protected final String TEXT_2254 = ".length || ";
  protected final String TEXT_2255 = ".size() < ";
  protected final String TEXT_2256 = "_";
  protected final String TEXT_2257 = "() || ";
  protected final String TEXT_2258 = ".size() > ";
  protected final String TEXT_2259 = "_";
  protected final String TEXT_2260 = "())" + NL + "    {";
  protected final String TEXT_2261 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_2262 = "> ";
  protected final String TEXT_2263 = " = new ArrayList<";
  protected final String TEXT_2264 = ">(";
  protected final String TEXT_2265 = "_";
  protected final String TEXT_2266 = "());";
  protected final String TEXT_2267 = NL + "    ";
  protected final String TEXT_2268 = ".clear();" + NL + "    for (";
  protected final String TEXT_2269 = " ";
  protected final String TEXT_2270 = " : ";
  protected final String TEXT_2271 = ")" + NL + "    {";
  protected final String TEXT_2272 = NL + "      ";
  protected final String TEXT_2273 = ".add(";
  protected final String TEXT_2274 = ");" + NL + "      if (";
  protected final String TEXT_2275 = ".contains(";
  protected final String TEXT_2276 = "))" + NL + "      {";
  protected final String TEXT_2277 = NL + "        ";
  protected final String TEXT_2278 = ".remove(";
  protected final String TEXT_2279 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2280 = NL + "        ";
  protected final String TEXT_2281 = ".";
  protected final String TEXT_2282 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_2283 = " ";
  protected final String TEXT_2284 = " : ";
  protected final String TEXT_2285 = ")" + NL + "    {";
  protected final String TEXT_2286 = NL + "      ";
  protected final String TEXT_2287 = ".";
  protected final String TEXT_2288 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_2289 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_2290 = NL + "  public boolean ";
  protected final String TEXT_2291 = "_";
  protected final String TEXT_2292 = "(";
  protected final String TEXT_2293 = "... ";
  protected final String TEXT_2294 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_2295 = NL + "    ArrayList<";
  protected final String TEXT_2296 = "> ";
  protected final String TEXT_2297 = " = new ArrayList<";
  protected final String TEXT_2298 = ">();" + NL + "    for (";
  protected final String TEXT_2299 = " ";
  protected final String TEXT_2300 = " : ";
  protected final String TEXT_2301 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2302 = ".contains(";
  protected final String TEXT_2303 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_2304 = NL + "      ";
  protected final String TEXT_2305 = ".add(";
  protected final String TEXT_2306 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_2307 = ".size() != ";
  protected final String TEXT_2308 = ".length || ";
  protected final String TEXT_2309 = ".size() < ";
  protected final String TEXT_2310 = "_";
  protected final String TEXT_2311 = "())" + NL + "    {";
  protected final String TEXT_2312 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_2313 = "> ";
  protected final String TEXT_2314 = " = new ArrayList<";
  protected final String TEXT_2315 = ">(";
  protected final String TEXT_2316 = "_";
  protected final String TEXT_2317 = "());";
  protected final String TEXT_2318 = NL + "    ";
  protected final String TEXT_2319 = ".clear();" + NL + "    for (";
  protected final String TEXT_2320 = " ";
  protected final String TEXT_2321 = " : ";
  protected final String TEXT_2322 = ")" + NL + "    {";
  protected final String TEXT_2323 = NL + "      ";
  protected final String TEXT_2324 = ".add(";
  protected final String TEXT_2325 = ");" + NL + "      if (";
  protected final String TEXT_2326 = ".contains(";
  protected final String TEXT_2327 = "))" + NL + "      {";
  protected final String TEXT_2328 = NL + "        ";
  protected final String TEXT_2329 = ".remove(";
  protected final String TEXT_2330 = ");" + NL + "      }" + NL + "      else" + NL + "      {";
  protected final String TEXT_2331 = NL + "        ";
  protected final String TEXT_2332 = ".";
  protected final String TEXT_2333 = "(this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    for (";
  protected final String TEXT_2334 = " ";
  protected final String TEXT_2335 = " : ";
  protected final String TEXT_2336 = ")" + NL + "    {";
  protected final String TEXT_2337 = NL + "      ";
  protected final String TEXT_2338 = ".";
  protected final String TEXT_2339 = "(this);" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_2340 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_2341 = NL + "  ";
  protected final String TEXT_2342 = " boolean ";
  protected final String TEXT_2343 = "(";
  protected final String TEXT_2344 = "... ";
  protected final String TEXT_2345 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_2346 = NL + "    ArrayList<";
  protected final String TEXT_2347 = "> ";
  protected final String TEXT_2348 = " = new ArrayList<";
  protected final String TEXT_2349 = ">();" + NL + "    for (";
  protected final String TEXT_2350 = " ";
  protected final String TEXT_2351 = " : ";
  protected final String TEXT_2352 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2353 = ".contains(";
  protected final String TEXT_2354 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_2355 = NL + "      ";
  protected final String TEXT_2356 = ".add(";
  protected final String TEXT_2357 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_2358 = ".size() != ";
  protected final String TEXT_2359 = ".length || ";
  protected final String TEXT_2360 = ".size() < ";
  protected final String TEXT_2361 = "_";
  protected final String TEXT_2362 = "() || ";
  protected final String TEXT_2363 = ".size() > ";
  protected final String TEXT_2364 = "_";
  protected final String TEXT_2365 = "())" + NL + "    {";
  protected final String TEXT_2366 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_2367 = NL + "    ";
  protected final String TEXT_2368 = ".clear();";
  protected final String TEXT_2369 = NL + "    ";
  protected final String TEXT_2370 = ".addAll(";
  protected final String TEXT_2371 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_2372 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_2373 = NL + "  public boolean ";
  protected final String TEXT_2374 = "_";
  protected final String TEXT_2375 = "(";
  protected final String TEXT_2376 = "... ";
  protected final String TEXT_2377 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_2378 = NL + "    if (";
  protected final String TEXT_2379 = ".length < ";
  protected final String TEXT_2380 = "_";
  protected final String TEXT_2381 = "()";
  protected final String TEXT_2382 = ")" + NL + "    {";
  protected final String TEXT_2383 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    ArrayList<";
  protected final String TEXT_2384 = "> ";
  protected final String TEXT_2385 = " = new ArrayList<";
  protected final String TEXT_2386 = ">();" + NL + "    HashMap<";
  protected final String TEXT_2387 = ",Integer> ";
  protected final String TEXT_2388 = " = new HashMap<";
  protected final String TEXT_2389 = ",Integer>();" + NL + "    for (";
  protected final String TEXT_2390 = " ";
  protected final String TEXT_2391 = " : ";
  protected final String TEXT_2392 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2393 = ".contains(";
  protected final String TEXT_2394 = "))" + NL + "      {";
  protected final String TEXT_2395 = NL + "        return wasSet;" + NL + "      }" + NL + "      else if (";
  protected final String TEXT_2396 = ".";
  protected final String TEXT_2397 = "(";
  protected final String TEXT_2398 = "0";
  protected final String TEXT_2399 = ") != null && !this.equals(";
  protected final String TEXT_2400 = ".";
  protected final String TEXT_2401 = "(";
  protected final String TEXT_2402 = "0";
  protected final String TEXT_2403 = ")))" + NL + "      {";
  protected final String TEXT_2404 = NL + "        ";
  protected final String TEXT_2405 = " ";
  protected final String TEXT_2406 = " = ";
  protected final String TEXT_2407 = ".";
  protected final String TEXT_2408 = "(";
  protected final String TEXT_2409 = "0";
  protected final String TEXT_2410 = ");" + NL + "        if (!";
  protected final String TEXT_2411 = ".containsKey(";
  protected final String TEXT_2412 = "))" + NL + "        {";
  protected final String TEXT_2413 = NL + "          ";
  protected final String TEXT_2414 = ".put(";
  protected final String TEXT_2415 = ", new Integer(";
  protected final String TEXT_2416 = ".";
  protected final String TEXT_2417 = "()));" + NL + "        }" + NL + "        Integer currentCount = ";
  protected final String TEXT_2418 = ".get(";
  protected final String TEXT_2419 = ");" + NL + "        int nextCount = currentCount - 1;" + NL + "        if (nextCount < ";
  protected final String TEXT_2420 = ")" + NL + "        {";
  protected final String TEXT_2421 = NL + "          return wasSet;" + NL + "        }";
  protected final String TEXT_2422 = NL + "        ";
  protected final String TEXT_2423 = ".put(";
  protected final String TEXT_2424 = ", new Integer(nextCount));" + NL + "      }";
  protected final String TEXT_2425 = NL + "      ";
  protected final String TEXT_2426 = ".add(";
  protected final String TEXT_2427 = ");" + NL + "    }" + NL;
  protected final String TEXT_2428 = NL + "    ";
  protected final String TEXT_2429 = ".removeAll(";
  protected final String TEXT_2430 = ");" + NL + "" + NL + "    for (";
  protected final String TEXT_2431 = " orphan : ";
  protected final String TEXT_2432 = "_";
  protected final String TEXT_2433 = "())" + NL + "    {";
  protected final String TEXT_2434 = NL + "      ";
  protected final String TEXT_2435 = "_";
  protected final String TEXT_2436 = "(orphan, null);" + NL + "    }";
  protected final String TEXT_2437 = NL + "    ";
  protected final String TEXT_2438 = ".clear();" + NL + "    for (";
  protected final String TEXT_2439 = " ";
  protected final String TEXT_2440 = " : ";
  protected final String TEXT_2441 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2442 = ".";
  protected final String TEXT_2443 = "(";
  protected final String TEXT_2444 = "0";
  protected final String TEXT_2445 = ") != null)" + NL + "      {";
  protected final String TEXT_2446 = NL + "        ";
  protected final String TEXT_2447 = ".";
  protected final String TEXT_2448 = "(";
  protected final String TEXT_2449 = "0";
  protected final String TEXT_2450 = ").";
  protected final String TEXT_2451 = ".remove(";
  protected final String TEXT_2452 = ");" + NL + "      }";
  protected final String TEXT_2453 = NL + "      ";
  protected final String TEXT_2454 = "_";
  protected final String TEXT_2455 = "(";
  protected final String TEXT_2456 = ", this);";
  protected final String TEXT_2457 = NL + "      ";
  protected final String TEXT_2458 = ".add(";
  protected final String TEXT_2459 = ");" + NL + "    }" + NL + "    wasSet = true;";
  protected final String TEXT_2460 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_2461 = NL + "  private void ";
  protected final String TEXT_2462 = "(";
  protected final String TEXT_2463 = " ";
  protected final String TEXT_2464 = ", ";
  protected final String TEXT_2465 = " ";
  protected final String TEXT_2466 = ")" + NL + "  {" + NL + "    try" + NL + "    {" + NL + "      java.lang.reflect.Field mentorField = ";
  protected final String TEXT_2467 = ".getClass().getDeclaredField(\"";
  protected final String TEXT_2468 = "\");" + NL + "      mentorField.setAccessible(true);" + NL + "      mentorField.set(";
  protected final String TEXT_2469 = ", ";
  protected final String TEXT_2470 = ");" + NL + "    }" + NL + "    catch (Exception e)" + NL + "    {" + NL + "      throw new RuntimeException(\"Issue internally setting ";
  protected final String TEXT_2471 = " to ";
  protected final String TEXT_2472 = "\", e);" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_2473 = NL + "  ";
  protected final String TEXT_2474 = " boolean ";
  protected final String TEXT_2475 = "(";
  protected final String TEXT_2476 = "... ";
  protected final String TEXT_2477 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_2478 = NL + "    ArrayList<";
  protected final String TEXT_2479 = "> ";
  protected final String TEXT_2480 = " = new ArrayList<";
  protected final String TEXT_2481 = ">();" + NL + "    for (";
  protected final String TEXT_2482 = " ";
  protected final String TEXT_2483 = " : ";
  protected final String TEXT_2484 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2485 = ".contains(";
  protected final String TEXT_2486 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_2487 = NL + "      ";
  protected final String TEXT_2488 = ".add(";
  protected final String TEXT_2489 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_2490 = ".size() != ";
  protected final String TEXT_2491 = ".length || ";
  protected final String TEXT_2492 = ".size() > ";
  protected final String TEXT_2493 = "_";
  protected final String TEXT_2494 = "())" + NL + "    {";
  protected final String TEXT_2495 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_2496 = NL + "    ";
  protected final String TEXT_2497 = ".clear();";
  protected final String TEXT_2498 = NL + "    ";
  protected final String TEXT_2499 = ".addAll(";
  protected final String TEXT_2500 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_2501 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_2502 = NL + "  ";
  protected final String TEXT_2503 = " boolean ";
  protected final String TEXT_2504 = "(";
  protected final String TEXT_2505 = "... ";
  protected final String TEXT_2506 = ")" + NL + "  {" + NL + "    boolean wasSet = false;";
  protected final String TEXT_2507 = NL + "    ArrayList<";
  protected final String TEXT_2508 = "> ";
  protected final String TEXT_2509 = " = new ArrayList<";
  protected final String TEXT_2510 = ">();" + NL + "    for (";
  protected final String TEXT_2511 = " ";
  protected final String TEXT_2512 = " : ";
  protected final String TEXT_2513 = ")" + NL + "    {" + NL + "      if (";
  protected final String TEXT_2514 = ".contains(";
  protected final String TEXT_2515 = "))" + NL + "      {" + NL + "        continue;" + NL + "      }";
  protected final String TEXT_2516 = NL + "      ";
  protected final String TEXT_2517 = ".add(";
  protected final String TEXT_2518 = ");" + NL + "    }" + NL + "" + NL + "    if (";
  protected final String TEXT_2519 = ".size() != ";
  protected final String TEXT_2520 = ".length || ";
  protected final String TEXT_2521 = ".size() < ";
  protected final String TEXT_2522 = "_";
  protected final String TEXT_2523 = "())" + NL + "    {";
  protected final String TEXT_2524 = NL + "      return wasSet;" + NL + "    }" + NL;
  protected final String TEXT_2525 = NL + "    ";
  protected final String TEXT_2526 = ".clear();";
  protected final String TEXT_2527 = NL + "    ";
  protected final String TEXT_2528 = ".addAll(";
  protected final String TEXT_2529 = ");" + NL + "    wasSet = true;";
  protected final String TEXT_2530 = NL + "    return wasSet;" + NL + "  }" + NL;
  protected final String TEXT_2531 = NL + "  ";
  protected final String TEXT_2532 = NL + "  public boolean ";
  protected final String TEXT_2533 = "(";
  protected final String TEXT_2534 = " ";
  protected final String TEXT_2535 = ", int index)" + NL + "  {  " + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_2536 = "(";
  protected final String TEXT_2537 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_2538 = "()) { index = ";
  protected final String TEXT_2539 = "() - 1; }";
  protected final String TEXT_2540 = NL + "      ";
  protected final String TEXT_2541 = ".remove(";
  protected final String TEXT_2542 = ");";
  protected final String TEXT_2543 = NL + "      ";
  protected final String TEXT_2544 = ".add(index, ";
  protected final String TEXT_2545 = ");";
  protected final String TEXT_2546 = NL + "      wasAdded = true;" + NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL + "" + NL + "  public boolean ";
  protected final String TEXT_2547 = "(";
  protected final String TEXT_2548 = " ";
  protected final String TEXT_2549 = ", int index)" + NL + "  {" + NL + "    boolean wasAdded = false;" + NL + "    if(";
  protected final String TEXT_2550 = ".contains(";
  protected final String TEXT_2551 = "))" + NL + "    {" + NL + "      if(index < 0 ) { index = 0; }" + NL + "      if(index > ";
  protected final String TEXT_2552 = "()) { index = ";
  protected final String TEXT_2553 = "() - 1; }";
  protected final String TEXT_2554 = NL + "      ";
  protected final String TEXT_2555 = ".remove(";
  protected final String TEXT_2556 = ");";
  protected final String TEXT_2557 = NL + "      ";
  protected final String TEXT_2558 = ".add(index, ";
  protected final String TEXT_2559 = ");";
  protected final String TEXT_2560 = NL + "      wasAdded = true;" + NL + "    } " + NL + "    else " + NL + "    {";
  protected final String TEXT_2561 = NL + "      wasAdded = ";
  protected final String TEXT_2562 = "(";
  protected final String TEXT_2563 = ", index);";
  protected final String TEXT_2564 = NL + "    }" + NL + "    return wasAdded;" + NL + "  }" + NL;

  // Add a newline to the end of the input
  private void appendln(StringBuffer buffer, String input, Object... variables)
  {
    append(buffer, input + "\n", variables);
  }  

  // This method will be used to append formatted strings
  // i.e. format("Hello {0} {1}", "andrew","forward");
  private void append(StringBuffer buffer, String input, Object... variables)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	} // end append
	
  public void getAssociationCode_specialization_reqSuperCode(JavaGenerator gen, String includeFile, String includeFile2, String includeFile3, StringBuffer stringBuffer, AssociationVariable av, AssociationVariable relatedAssociation,
  		String customSetPrefixCode, String customSetPostfixCode, String customAddPrefixCode, String customAddPostfixCode, String customRemovePrefixCode, String customRemovePostfixCode,
  		String customSetManyPrefixCode, String customSetManyPostfixCode, List<TraceItem> traceItemAssocRemoves, List<TraceItem> traceItemAssocAdds, UmpleClass uClass, boolean sortMethodAdded, String umpleSourceFile,
  		Map<String,UncaughtException> uncaughtExceptions, UmpleClass globalUmpleClass, boolean addNewLine, boolean mulChangedToOne, boolean relMulChangedToOne, boolean mulChangedToN, boolean reqSetCode, boolean relReqCommonCode, boolean relReqSetCode, String scName) 
  	{ 
  	this.uncaughtExceptions = uncaughtExceptions;
  	this.globalUmpleClass = globalUmpleClass;
  
    
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
    
	  if (!relatedAssociation.getIsNavigable())
      {
        if (av.isOptionalOne())
        {
          includeFile = "specializationSkip.jet";
        }
        else if (av.isOnlyOne())
        {
          includeFile = "specializationSkip.jet";
        }
        else if (av.isMStar())
        {
          if (!av.isImmutable())
          {
            includeFile = "specializationSkip.jet";
          }
          includeFile2 = "association_SetUnidirectionalMStar_specialization.jet";
        }
        else if (av.isMN())
        {
          if (!av.isImmutable())
          {
            includeFile = "association_AddUnidirectionalMN_specialization.jet";
          }
          includeFile2 = "association_SetUnidirectionalMN_specialization.jet";
        }
        else if (av.isN())
        {
          includeFile = "association_SetUnidirectionalN_specialization.jet";
        }
        else if (av.isOptionalN())
        {
          if (!av.isImmutable())
          {
            includeFile = "association_AddUnidirectionalOptionalN_specialization.jet";
          }
          includeFile2 = "association_SetUnidirectionalOptionalN_specialization.jet";
        }
        else if (av.isImmutable() && av.isMany())
        {
          includeFile = "association_SetUnidirectionalMany_specialization.jet";
        }
        else if (av.isMany())
        {
          includeFile = "association_AddUnidirectionalMany_specialization.jet";
        }
      }
      else if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
      {
        //ignore
      }  
      else if (av.isN() && relatedAssociation.isOptionalOne())
      { 
        includeFile = "association_SetNToOptionalOne_specialization.jet";
      }
      else if (av.isMN() && relatedAssociation.isOptionalOne())
      {
        includeFile = "association_AddMNToOptionalOne_specialization.jet";
        includeFile2 = "association_SetMNToOptionalOne_specialization.jet";
      }
      else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isMany())
      {
        hasIsNumberOfValidMethod = true;
        hasAddManyToManyTemplateMethod = true;
        includeFile = "association_AddMStarToMany_specialization.jet";
        includeFile2 = "association_SetMStarToMany_specialization.jet";
      }
      else if ((av.isMN() || av.isN()) && relatedAssociation.isMandatoryMany())
      {
        hasIsNumberOfValidMethod = true;
        hasAddManyToManyTemplateMethod = true;
        hasAddManyToManyTemplateMethod = true;
        includeFile = "association_AddMNToMany_specialization.jet";
        includeFile2 = "association_SetMNToMany_specialization.jet";
      }
      else if ((av.isMN() || av.isN()) && relatedAssociation.isOptionalN())
      {
        hasIsNumberOfValidMethod = true;
        hasAddManyToManyTemplateMethod = true;
        hasAddManyToManyTemplateMethod = true;
        includeFile = "association_AddMNToMany_specialization.jet";
      }
      else if ((av.isMN() || av.isN()) && !relatedAssociation.isOne())
      {
        hasIsNumberOfValidMethod = true;
        hasAddManyToManyTemplateMethod = true;
        includeFile = "association_AddMNToMany_specialization.jet";
        includeFile2 = "association_SetMNToMany_specialization.jet";
      }
      else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
      {
        includeFile = "specializationSkip.jet";
      }
      else if (av.isOptionalOne() && relatedAssociation.isOne())
      {
        includeFile = "specializationSkip.jet";
      }
      else if (av.isOne() && relatedAssociation.isOptionalOne())
      {
        includeFile = "specializationSkip.jet";
      }
      else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isOne())
      {
        hasIsNumberOfValidMethod = true;
        includeFile = "association_AddMandatoryManyToOne_specialization.jet";
      }
      else if ((av.isMN() || av.isN()) && relatedAssociation.isOnlyOne())
      {
        hasIsNumberOfValidMethod = true;
        includeFile = "association_AddMNToOnlyOne_specialization.jet";
      }
      else if (av.isOptionalN() && relatedAssociation.isOnlyOne())
      {
        includeFile = "association_AddOptionalNToOne_specialization.jet";
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
        includeFile = "association_AddManyToOne_specialization.jet";
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
        includeFile = "association_AddOptionalNToOptionalOne_specialization.jet";
      }
      else if (av.isMany() && relatedAssociation.isOptionalOne())
      {
        includeFile = "specializationSkip.jet";
      }
      else if (av.isOnlyOne() && relatedAssociation.isMandatoryMany() && relatedAssociation.isStar())
      {
        includeFile = "association_SetOneToMandatoryMany_specialization.jet";
      }
      else if (av.isOnlyOne() && (relatedAssociation.isMN() || relatedAssociation.isN()))
      {
        includeFile = "association_SetOneToAtMostN_specialization.jet";
      }
      else if (av.isOnlyOne() && relatedAssociation.isOptionalN())
      {
        includeFile = "association_SetOneToAtMostN_specialization.jet";
      }
      else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()) && !(uClass instanceof AssociationClass))
      {
        includeFile = "specializationSkip.jet";
      }
      else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()) && (uClass instanceof AssociationClass))
      {
        includeFile = "specializationSkip.jet";
      }
      else if (av.isOptionalOne() && relatedAssociation.isOptionalN())
      {
        includeFile = "association_SetOptionalOneToOptionalN_specialization.jet";
      }
      else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
      {
        includeFile = "specializationSkip.jet";
      }
      else if (av.isOptionalOne() && relatedAssociation.isMandatoryMany())
      {
        // Insert code to include code here
        if (relatedAssociation.isUpperBounded())
        {
          //
          // This program cannot currently include SetOptionalOneToMandatoryMN.jet because of Issue351 where add/remove methods do not generate
          //
          //          PLEASE NOTE
          // If Issue351 is resolved, remember to change the specialization
          // code as well -- do not just include this here.
          //
          // includeFile = "association_SetOptionalOneToMandatoryMN.jet";
        } 
        else
        {
          //
          // We can include association_SetOptionalOneToMandatoryMany.jet
          // 
          includeFile = "association_SetOptionalOneToMandatoryMany_specialization.jet";
        } 
      }
      else if (av.isOptionalOne() && relatedAssociation.isMandatory())
      {
        //ignore
      }

      else
      {
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(relatedAssociation);
    
      }
      
      if(av.isSorted())
      {
        includeFile3 = "association_Sort.jet";
      }
      else if(av.isMany() && !av.isImmutable() && !av.isN())
      {
        includeFile3 = "association_AddIndexControlFunctions_specialization.jet";
      }

      addNewLine = false;
      if (hasIsNumberOfValidMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    
        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_6);
     if (customIsNumberOfValidPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPrefixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_10);
     } else { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_17);
     } 
     if (customIsNumberOfValidPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPostfixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_18);
    
      }
      
      if (hasRequiredNumberOfMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    
        
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_22);
     } else { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_25);
     if (customRequiredNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPrefixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_27);
     if (customRequiredNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPostfixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_28);
     } 
    
      }

      if (hasMinimumNumberOfMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    
        
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));
    
     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_32);
     } else { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_35);
     if (customMinimumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPrefixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_36);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_37);
     if (customMinimumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPostfixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_38);
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
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_42);
     } else { 
    stringBuffer.append(umpleSourceFile);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_45);
     if (customMaximumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPrefixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_46);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_47);
     if (customMaximumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPostfixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_48);
     } 
    
      }
      
      if (hasAddManyToManyTemplateMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_52);
     if (customAddPrefixCode != null && av.getMultiplicity().getUpperBound() == 1) { 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_56);
    if (mulChangedToOne) { 
    stringBuffer.append(TEXT_57);
     } 
    stringBuffer.append(TEXT_58);
     } else if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_63);
     } 
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_67);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_68);
     } 
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_71);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_72);
    
      }
      
      if (hasRemoveManyTemplateMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    
   /* Method Gen skipped due to special specialization syntax */

    
      }
	    
    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;	
	
      if (includeFile == "association_SetUnidirectionalOptionalOne_specialization.jet")
      {
        
    
   /* Method Gen skipped due to special specialization syntax */

        // TODO!!
      }
      else if (includeFile == "association_SetUnidirectionalOne_specialization.jet")
      {
        
    
   /* Method Gen skipped due to special specialization syntax */

        // TODO!!
      }
      else if (includeFile == "association_SetOptionalOneToOne_specialization.jet")
      {
        
    
   /* Method Gen skipped due to special specialization syntax */

        // TODO!!
      }
      else if (includeFile == "association_SetOneToOptionalOne_specialization.jet")
      {
        
    
   /* Method Gen skipped due to special specialization syntax */

        // TODO!!
      }
      else if (includeFile == "association_AddMandatoryManyToOne_specialization.jet")
      {
        
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_76);
     if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_81);
     } 
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_97);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_101);
     if (customRemovePrefixCode != null) { 
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_106);
     } 
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_107);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_111);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_117);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_118);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_121);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_122);
    
      }
      else if (includeFile == "association_AddMNToOnlyOne_specialization.jet")
      {
        
    stringBuffer.append(TEXT_123);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_134);
     if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_139);
     } 
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_140);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_143);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_144);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_158);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_159);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_162);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_166);
     if (customRemovePrefixCode != null) { 
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_171);
     } 
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_172);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_176);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_182);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_183);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_186);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_187);
    
      }
      else if (includeFile == "association_AddOptionalNToOne_specialization.jet")
      {
        
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_199);
     if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_204);
     } 
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_208);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_211);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_212);
    
      }
      else if (includeFile == "association_SetOptionalNToMany_specialization.jet")
      {
        
    stringBuffer.append(TEXT_213);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_216);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_217);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_233);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_236);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_237);
    
      }
      else if (includeFile == "association_AddManyToOne_specialization.jet")
      {
        
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_243);
    
      }
      else if (includeFile == "association_SetOptionalOneToOptionalOne_specialization.jet")
      {
        
    
   /* Method Gen skipped due to special specialization syntax */

        // TODO!!
      }
      else if (includeFile == "association_AddMNToMany_specialization.jet")
      {
        
    stringBuffer.append(TEXT_244);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_247);
     if (customRemovePrefixCode != null) { 
    stringBuffer.append(TEXT_248);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_252);
     } 
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_253);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_256);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_259);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_260);
    
      }
      else if (includeFile == "association_AddMStarToMany_specialization.jet")
      {
        
    stringBuffer.append(TEXT_261);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_264);
     if (customRemovePrefixCode != null) { 
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_269);
     } 
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_273);
     if (customRemovePostfixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_276);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_277);
    
      }
      else if (includeFile == "association_SetOptionalOneToOptionalN_specialization.jet")
      {
        
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_281);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_288);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_289);
     if (!reqSetCode) { 
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_292);
     } else { 
    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_296);
     } 
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_297);
    
      }
      else if (includeFile == "association_SetOneToMany_specialization.jet")
      {
        
    stringBuffer.append(TEXT_298);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_305);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_306);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_308);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_309);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_325);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_326);
    
      }
      else if (includeFile == "association_SetOneToManyAssociationClass_specialization.jet")
      {
        
    
   /* Method Gen skipped due to special specialization syntax */

        // TODO!!
      }
      else if (includeFile == "association_SetOneToAtMostN_specialization.jet")
      {
        
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_330);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_334);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_342);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_343);
     if ( !reqSetCode ) { 
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_346);
     } else { 
    stringBuffer.append(TEXT_347);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_350);
     } 
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_351);
    
      }
      else if (includeFile == "association_SetOneToMandatoryMany_specialization.jet")
      {
        
    stringBuffer.append(TEXT_352);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_355);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_359);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av));
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_364);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_368);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_369);
     if ( !reqSetCode ) { 
    stringBuffer.append(TEXT_370);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_372);
     } else { 
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_376);
     } 
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_377);
    
      }
      else if (includeFile == "association_AddManyToOptionalOne_specialization.jet")
      {
        
    stringBuffer.append(TEXT_378);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_381);
     if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_382);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_386);
     } 
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_391);
     if (relatedAssociation.getMultiplicity().getUpperBound() != 1) { 
    stringBuffer.append(gen.relatedTranslate("type",av));
     } else { 
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_393);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_395);
     if (!relReqSetCode) { 
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_398);
     } else { 
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_404);
     } 
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_416);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_417);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_421);
     if (customRemovePrefixCode != null) { 
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_426);
     } 
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_430);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_436);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_437);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_438);
    
      }
      else if (includeFile == "association_SetOptionalOneToMany_specialization.jet")
      {
        
    
   /* Method Gen skipped due to special specialization syntax */

        // TODO!!
      }
      else if (includeFile == "association_AddOptionalNToOptionalOne_specialization.jet")
      {
        
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_441);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_442);
     if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_443);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_447);
     } 
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_451);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_452);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_454);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_455);
    
      }
      else if (includeFile == "association_AddUnidirectionalMN_specialization.jet")
      {
        
    stringBuffer.append(TEXT_456);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_459);
     if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_460);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_464);
     } 
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_468);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_471);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_472);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_476);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_480);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_481);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_484);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_485);
    
      }
      else if (includeFile == "association_AddMNToOptionalOne_specialization.jet")
      {
        
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_489);
     if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_494);
     } 
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_498);
     if (customAddPostfixCode != null) {addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_499);
     } 
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_510);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_511);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_514);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_518);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_522);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_525);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_526);
    
      }
      else if (includeFile == "association_SetNToOptionalOne_specialization.jet")
      {
        
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_530);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_539);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_544);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_545);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_551);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_552);
     if ( !reqSetCode ) { 
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_555);
     } else { 
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_561);
     } 
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_562);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_574);
    
      }
      else if (includeFile == "association_AddUnidirectionalMany_specialization.jet")
      {
        
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_578);
     if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_583);
     } 
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_586);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_589);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_590);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_591);
    
      }
      else if (includeFile == "association_AddUnidirectionalOptionalN_specialization.jet")
      {
        
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_595);
     if (customAddPrefixCode != null) { 
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_600);
     } 
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_604);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_607);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_608);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_609);
    stringBuffer.append(TEXT_610);
    stringBuffer.append( umpleSourceFile );
    
      }
      else if (includeFile == "association_AddUnidirectionalMStar_specialization.jet")
      {
        
    
   /* Method Gen skipped due to special specialization syntax */

        // TODO!!
      }
      else if (includeFile == "association_SetUnidirectionalN_specialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_611);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_615);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_632);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_635);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_636);
    
      }
      else if (includeFile == "association_SetUnidirectionalMany_specialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_637);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_641);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_655);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_658);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_659);
    
      }
      else if (includeFile == "association_SetOptionalOneToMandatoryMany_specialization.jet")
      {
        
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_663);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("type",av));
     } 
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_672);
     if (!reqSetCode) { 
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_675);
     } else { 
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_679);
     } 
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_687);
     if ( !reqSetCode ) { 
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_690);
     } else { 
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_694);
     } 
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_700);
     if (!reqSetCode) { 
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_703);
     } else { 
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_707);
     } 
    stringBuffer.append(TEXT_708);
    
      }
      else if (includeFile == "association_SetOptionalOneToMandatoryMN_specialization.jet")
      {
        
    
   /* Method Gen skipped due to special specialization syntax */

        // TODO!!
      }
      else if (includeFile != null)
      {
        appendln(stringBuffer,"You forgot to include {0}",includeFile);
      }
      
      
    
      if (includeFile2 == "association_SetMNToMany_specialization.jet")
      {
        
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_712);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_732);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_733);
     if ( !reqSetCode ) { 
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_736);
     } else { 
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_742);
     } 
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_743);
    
      }
      else if (includeFile2 == "association_SetMStarToMany_specialization.jet")
      {
        
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_747);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_764);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_765);
     if ( !reqSetCode ) { 
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_768);
     } else { 
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_774);
     } 
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_775);
    
      }
      else if (includeFile2 == "association_SetUnidirectionalMN_specialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_776);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_780);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_800);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_801);
     if (!reqSetCode) { 
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_804);
     } else { 
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_810);
     } 
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_811);
    
      }
      else if (includeFile2 == "association_SetMNToOptionalOne_specialization.jet")
      {
        
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}{2}{3}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av), "_", gen.translate("type",av));

    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_815);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_820);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_821);
     if ( !reqSetCode ) { 
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_824);
     } else { 
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_828);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_830);
     } 
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_831);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_843);
    
      }
      else if (includeFile2 == "association_SetUnidirectionalOptionalN_specialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_844);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_848);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_865);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_868);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_869);
    
      }
      else if (includeFile2 == "association_SetUnidirectionalMStar_specialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_870);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_874);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_891);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_894);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_895);
    
      }
      else if (includeFile2 != null)
      {
        appendln(stringBuffer,"You forgot to include {0}",includeFile2);
      }
      
      if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
      {
        
    stringBuffer.append(TEXT_896);
    
        sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
      }
      else if(includeFile3 == "association_AddIndexControlFunctions.jet")
      {
        
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_904);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_915);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_919);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_922);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_923);
    
      }

    
     }// end super code
     
  public void getAssociationCode_specialization_reqCommonCode(JavaGenerator gen, String includeFile, String includeFile2, String includeFile3, StringBuffer stringBuffer, AssociationVariable av, AssociationVariable relatedAssociation,
  		String customSetPrefixCode, String customSetPostfixCode, String customAddPrefixCode, String customAddPostfixCode, String customRemovePrefixCode, String customRemovePostfixCode,
  		String customSetManyPrefixCode, String customSetManyPostfixCode, List<TraceItem> traceItemAssocRemoves, List<TraceItem> traceItemAssocAdds, UmpleClass uClass, boolean sortMethodAdded, String umpleSourceFile,
  		Map<String,UncaughtException> uncaughtExceptions, UmpleClass globalUmpleClass, boolean addNewLine, boolean mulChangedToOne, boolean relMulChangedToOne, boolean mulChangedToN, boolean reqSetCode, boolean relReqCommonCode, boolean relReqSetCode, String scName) 
  	{
  	 this.uncaughtExceptions = uncaughtExceptions;
  	 this.globalUmpleClass = globalUmpleClass;
  
    

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
    
      if (!relatedAssociation.getIsNavigable())
      {
        if (av.isOptionalOne())
        {
          includeFile = "association_SetUnidirectionalOptionalOne_relatedSpecialization.jet";
        }
        else if (av.isOnlyOne())
        {
          includeFile = "association_SetUnidirectionalOne_relatedSpecialization.jet";
        }
        else if (av.isMStar())
        {
          if (!av.isImmutable())
          {
            includeFile = "association_AddUnidirectionalMStar_relatedSpecialization.jet";
          }
          includeFile2 = "association_SetUnidirectionalMStar_relatedSpecialization.jet";
        }
        else if (av.isMN())
        {
          if (!av.isImmutable())
          {
            includeFile = "association_AddUnidirectionalMN_relatedSpecialization.jet";
          }
          includeFile2 = "association_SetUnidirectionalMN_relatedSpecialization.jet";
        }
        else if (av.isN())
        {
          includeFile = "association_SetUnidirectionalN_relatedSpecialization.jet";
        }
        else if (av.isOptionalN())
        {
          if (!av.isImmutable())
          {
            includeFile = "association_AddUnidirectionalOptionalN_relatedSpecialization.jet";
          }
          includeFile2 = "association_SetUnidirectionalOptionalN_relatedSpecialization.jet";
        }
        else if (av.isImmutable() && av.isMany())
        {
          includeFile = "association_SetUnidirectionalMany_relatedSpecialization.jet";
        }
        else if (av.isMany())
        {
          includeFile = "association_AddUnidirectionalMany_relatedSpecialization.jet";
        }
      }
      else if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
      {
        //ignore
      }  
      else if (av.isN() && relatedAssociation.isOptionalOne())
      { 
        includeFile = "association_SetNToOptionalOne_relatedSpecialization.jet";
      }
      else if (av.isMN() && relatedAssociation.isOptionalOne())
      {
        includeFile = "association_AddMNToOptionalOne_relatedSpecialization.jet";
        includeFile2 = "association_SetMNToOptionalOne_relatedSpecialization.jet";
      }
      else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isMany())
      {
        hasIsNumberOfValidMethod = true;
        hasAddManyToManyTemplateMethod = true;
        includeFile = "association_AddMStarToMany_relatedSpecialization.jet";
        includeFile2 = "association_SetMStarToMany_relatedSpecialization.jet";
      }
      else if ((av.isMN() || av.isN()) && relatedAssociation.isMandatoryMany())
      {
        hasIsNumberOfValidMethod = true;
        hasAddManyToManyTemplateMethod = true;
        hasAddManyToManyTemplateMethod = true;
        includeFile = "association_AddMNToMany_relatedSpecialization.jet";
        includeFile2 = "association_SetMNToMany_relatedSpecialization.jet";
      }
      else if ((av.isMN() || av.isN()) && relatedAssociation.isOptionalN())
      {
        hasIsNumberOfValidMethod = true;
        hasAddManyToManyTemplateMethod = true;
        hasAddManyToManyTemplateMethod = true;
        includeFile = "association_AddMNToMany_relatedSpecialization.jet";
      }
      else if ((av.isMN() || av.isN()) && !relatedAssociation.isOne())
      {
        hasIsNumberOfValidMethod = true;
        hasAddManyToManyTemplateMethod = true;
        includeFile = "association_AddMNToMany_relatedSpecialization.jet";
        includeFile2 = "association_SetMNToMany_relatedSpecialization.jet";
      }
      else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
      {
        includeFile = "association_SetOptionalOneToOptionalOne_relatedSpecialization.jet";
      }
      else if (av.isOptionalOne() && relatedAssociation.isOne())
      {
        includeFile = "association_SetOptionalOneToOne_relatedSpecialization.jet";
      }
      else if (av.isOne() && relatedAssociation.isOptionalOne())
      {
        includeFile = "association_SetOneToOptionalOne_relatedSpecialization.jet";
      }
      else if (av.isMandatoryMany() && av.isStar() && relatedAssociation.isOne())
      {
        hasIsNumberOfValidMethod = true;
        includeFile = "association_AddMandatoryManyToOne_relatedSpecialization.jet";
      }
      else if ((av.isMN() || av.isN()) && relatedAssociation.isOnlyOne())
      {
        hasIsNumberOfValidMethod = true;
        includeFile = "association_AddMNToOnlyOne_relatedSpecialization.jet";
      }
      else if (av.isOptionalN() && relatedAssociation.isOnlyOne())
      {
        includeFile = "association_AddOptionalNToOne_relatedSpecialization.jet";
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
        includeFile = "association_SetOptionalNToMany_relatedSpecialization.jet";
      }
      else if (av.isMany() && relatedAssociation.isOnlyOne())
      {
        includeFile = "association_AddManyToOne_relatedSpecialization.jet";
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
        includeFile = "association_AddOptionalNToOptionalOne_relatedSpecialization.jet";
      }
      else if (av.isMany() && relatedAssociation.isOptionalOne())
      {
        includeFile = "association_AddManyToOptionalOne_relatedSpecialization.jet";
      }
      else if (av.isOnlyOne() && relatedAssociation.isMandatoryMany() && relatedAssociation.isStar())
      {
        includeFile = "association_SetOneToMandatoryMany_relatedSpecialization.jet";
      }
      else if (av.isOnlyOne() && (relatedAssociation.isMN() || relatedAssociation.isN()))
      {
        includeFile = "association_SetOneToAtMostN_relatedSpecialization.jet";
      }
      else if (av.isOnlyOne() && relatedAssociation.isOptionalN())
      {
        includeFile = "association_SetOneToAtMostN_relatedSpecialization.jet";
      }
      else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()) && !(uClass instanceof AssociationClass))
      {
        includeFile = "association_SetOneToMany_relatedSpecialization.jet";
      }
      else if (av.isOnlyOne() && relatedAssociation.isMany() && !(av.isMandatory() && !av.isOne()) && (uClass instanceof AssociationClass))
      {
        includeFile = "association_SetOneToManyAssociationClass_relatedSpecialization.jet";
      }
      else if (av.isOptionalOne() && relatedAssociation.isOptionalN())
      {
        includeFile = "association_SetOptionalOneToOptionalN_relatedSpecialization.jet";
      }
      else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
      {
        includeFile = "association_SetOptionalOneToMany_relatedSpecialization.jet";
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
          includeFile = "association_SetOptionalOneToMandatoryMany_relatedSpecialization.jet";
        } 
      }
      else if (av.isOptionalOne() && relatedAssociation.isMandatory())
      {
        //ignore
      }

      else
      {
        
    stringBuffer.append(TEXT_924);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_925);
    stringBuffer.append(relatedAssociation);
    
      }
      
      if(av.isSorted())
      {
        includeFile3 = "association_Sort.jet";
      }
      else if(av.isMany() && !av.isImmutable() && !av.isN())
      {
        includeFile3 = "association_AddIndexControlFunctions_relatedSpecialization.jet";
      }

      addNewLine = false;
      if (hasIsNumberOfValidMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    
        
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_928);
     if (customIsNumberOfValidPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPrefixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_932);
     } else { 
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_939);
     } 
     if (customIsNumberOfValidPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customIsNumberOfValidPostfixCode,gen.translate("isNumberOfValidMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_940);
    
      }
      
      if (hasRequiredNumberOfMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    
        
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_944);
     } else { 
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_947);
     if (customRequiredNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPrefixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_948);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_949);
     if (customRequiredNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRequiredNumberOfPostfixCode,gen.translate("requiredNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_950);
     } 
    
      }

      if (hasMinimumNumberOfMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    
        
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));
    
     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_954);
     } else { 
    stringBuffer.append(TEXT_955);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_957);
     if (customMinimumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPrefixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_958);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_959);
     if (customMinimumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMinimumNumberOfPostfixCode,gen.translate("minimumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_960);
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
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_964);
     } else { 
    stringBuffer.append(umpleSourceFile);
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_967);
     if (customMaximumNumberOfPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPrefixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_968);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_969);
     if (customMaximumNumberOfPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customMaximumNumberOfPostfixCode,gen.translate("maximumNumberOfMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_970);
     } 
    
      }
      
      if (hasAddManyToManyTemplateMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_974);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_978);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_979);
     } 
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_982);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_990);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_991);
    
      }
      
      if (hasRemoveManyTemplateMethod)
      {
        if (addNewLine) { appendln(stringBuffer,""); }
        addNewLine = true;
        
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_995);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append(
    (traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
    );
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_998);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av));
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1010);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append(
    (traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
    );
    stringBuffer.append(TEXT_1011);
    
      }      

 	  
    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
	
      if (includeFile == "association_SetUnidirectionalOptionalOne_relatedSpecialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1012);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1016);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1018);
     if (!mulChangedToOne) { 
    stringBuffer.append(gen.translate("parameterNew",av));
     } else { 
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(scName);
    stringBuffer.append(TEXT_1020);
     } 
    stringBuffer.append(TEXT_1021);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1023);
     } 
    stringBuffer.append(TEXT_1024);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1025);
    
      }
      else if (includeFile == "association_SetUnidirectionalOne_relatedSpecialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1026);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1030);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1034);
     if (!mulChangedToOne) { 
    stringBuffer.append(gen.translate("parameterNew",av));
     } else { 
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(scName);
    stringBuffer.append(TEXT_1036);
     } 
    stringBuffer.append(TEXT_1037);
     if (!mulChangedToOne) { 
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1039);
     } 
    stringBuffer.append(TEXT_1040);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1041);
    
      }
      else if (includeFile == "association_SetOptionalOneToOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1046);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1054);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1057);
     if (!mulChangedToOne) { 
    stringBuffer.append(gen.translate("parameterNew",av));
     } else { 
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(scName);
    stringBuffer.append(TEXT_1059);
     } 
    stringBuffer.append(TEXT_1060);
     if (!mulChangedToOne) { 
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1062);
     } 
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
     if (relReqCommonCode) { 
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1078);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append(
    (traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,"1"):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1079);
    
      }
      else if (includeFile == "association_SetOneToOptionalOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1084);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1095);
     } else if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1096);
     } 
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1102);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1109);
     if (!mulChangedToOne) { 
    stringBuffer.append(gen.translate("parameterNew",av));
     } else { 
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(scName);
    stringBuffer.append(TEXT_1111);
     } 
    stringBuffer.append(TEXT_1112);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1114);
     } 
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
     if (relReqCommonCode) { 
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1122);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append(
    (traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,"1"):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1123);
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1135);
     } 
    
      }
      else if (includeFile == "association_AddMandatoryManyToOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_1144);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1149);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1163);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1171);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1172);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1176);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1182);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1188);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1189);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1193);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1194);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1195);
    
      }
      else if (includeFile == "association_AddMNToOnlyOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1207);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1211);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1226);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1227);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1235);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1236);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1240);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1246);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1252);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1253);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1256);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1257);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1258);
    
      }
      else if (includeFile == "association_AddOptionalNToOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1270);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1274);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1284);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1292);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1293);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1297);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1306);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1307);
    
      }
      else if (includeFile == "association_SetOptionalNToMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1312);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1329);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1357);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1358);
    
      }
      else if (includeFile == "association_AddManyToOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1367);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1376);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1384);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1385);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1389);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1395);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1398);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1399);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1400);
    
      }
      else if (includeFile == "association_SetOptionalOneToOptionalOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1405);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1410);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1412);
     } else {
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("associationOne",av));
     } 
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1422);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1436);
     if (!mulChangedToOne) { 
    stringBuffer.append(gen.translate("parameterNew",av));
     } else { 
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(scName);
    stringBuffer.append(TEXT_1438);
     } 
    stringBuffer.append(TEXT_1439);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1441);
     } 
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1447);
     } else if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1448);
     } 
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1450);
     if (mulChangedToOne) { 
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(scName);
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
     if (relReqCommonCode) { 
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1457);
     } else if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
     if (relReqCommonCode) { 
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1461);
     } else { 
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
     if (relReqCommonCode) { 
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1465);
     } 
    stringBuffer.append(TEXT_1466);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append(
    (traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,"1"):""));
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1467);
     if (mulChangedToOne || relMulChangedToOne) { 
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1479);
     } 
    
      }
      else if (includeFile == "association_AddMNToMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1483);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1486);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1490);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1493);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1495);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1503);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1504);
    
      }
      else if (includeFile == "association_AddMStarToMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1508);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1511);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1515);
     if (customRemovePostfixCode != null) {
      addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1518);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1520);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1528);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1529);
    
      }
      else if (includeFile == "association_SetOptionalOneToOptionalN_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1534);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1541);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1545);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1547);
     } else {
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(gen.translate("associationOne",av));
     } 
    stringBuffer.append(TEXT_1550);
     if (!mulChangedToOne) { 
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1553);
     } else { 
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1558);
     } 
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1569);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1570);
    
      }
      else if (includeFile == "association_SetOneToMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1575);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1577);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1581);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1583);
     } else {
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(gen.translate("associationOne",av));
     } 
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1598);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1599);
    
      }
      else if (includeFile == "association_SetOneToManyAssociationClass_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1604);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1606);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1610);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1612);
     } else {
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(gen.translate("associationOne",av));
     } 
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1617);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1629);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1630);
    
      }
      else if (includeFile == "association_SetOneToAtMostN_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1632);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1635);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1639);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1647);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1651);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1653);
     } else {
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(gen.translate("associationOne",av));
     } 
    stringBuffer.append(TEXT_1656);
     if (!mulChangedToOne) { 
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1659);
     } else { 
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1664);
     } 
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1670);
     if (!mulChangedToOne) { 
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1673);
     } else { 
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1677);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1678);
     } 
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1682);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1683);
    
      }
      else if (includeFile == "association_SetOneToMandatoryMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1687);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1688);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1689);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1692);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av));
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1696);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1697);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1698);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1701);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(TEXT_1703);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1704);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1705);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1706);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1707);
     } else {
    stringBuffer.append(TEXT_1708);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1709);
    stringBuffer.append(gen.translate("associationOne",av));
     } 
    stringBuffer.append(TEXT_1710);
     if (!mulChangedToOne) { 
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1713);
     } else { 
    stringBuffer.append(TEXT_1714);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(TEXT_1716);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1718);
     } 
    stringBuffer.append(TEXT_1719);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1720);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1721);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1722);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1723);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1724);
     if (!mulChangedToOne) { 
    stringBuffer.append(TEXT_1725);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1726);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1727);
     } else { 
    stringBuffer.append(TEXT_1728);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1730);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1731);
     } 
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1732);
     if (!mulChangedToOne) { 
    stringBuffer.append(TEXT_1733);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1735);
     } else { 
    stringBuffer.append(TEXT_1736);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1737);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1738);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1739);
     } 
    stringBuffer.append(TEXT_1740);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1741);
    
      }
      else if (includeFile == "association_AddManyToOptionalOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1742);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1743);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1744);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1745);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1746);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1747);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1749);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1750);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1751);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1752);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1753);
     if (!relReqSetCode) { 
    stringBuffer.append(TEXT_1754);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1755);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1756);
     } else { 
    stringBuffer.append(TEXT_1757);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1758);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1759);
    stringBuffer.append(TEXT_1760);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1761);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1762);
     } 
    stringBuffer.append(TEXT_1763);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1764);
    stringBuffer.append(TEXT_1765);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1766);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1767);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1768);
    stringBuffer.append(TEXT_1769);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1770);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1771);
    stringBuffer.append(TEXT_1772);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1773);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1774);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1775);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1776);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1777);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1778);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1779);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1780);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1781);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1782);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1783);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1784);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1785);
    stringBuffer.append(TEXT_1786);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1787);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1788);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1789);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1790);
    
      }
      else if (includeFile == "association_SetOptionalOneToMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1791);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1792);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1793);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1794);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1795);
     if (customSetPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPrefixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1796);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1797);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1798);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1799);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1800);
     } else {
    stringBuffer.append(TEXT_1801);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1802);
    stringBuffer.append(gen.translate("associationOne",av));
     } 
    stringBuffer.append(TEXT_1803);
     if (!mulChangedToOne) { 
    stringBuffer.append(TEXT_1804);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1805);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1806);
     } else { 
    stringBuffer.append(TEXT_1807);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1808);
    stringBuffer.append(TEXT_1809);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1810);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1811);
     } 
    stringBuffer.append(TEXT_1812);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1813);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1814);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1815);
    stringBuffer.append(TEXT_1816);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1817);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1818);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1819);
    stringBuffer.append(TEXT_1820);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1821);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1822);
     if (customSetPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetPostfixCode,gen.translate("setMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1823);
    
      }
      else if (includeFile == "association_AddOptionalNToOptionalOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1824);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1825);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1826);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1827);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1828);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1829);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1830);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1831);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1832);
    stringBuffer.append(TEXT_1833);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1834);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1835);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1836);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1837);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1838);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1839);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1840);
    stringBuffer.append(TEXT_1841);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1842);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1843);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1844);
    stringBuffer.append(TEXT_1845);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1846);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1847);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1848);
    stringBuffer.append(TEXT_1849);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1850);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1851);
    stringBuffer.append(TEXT_1852);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1853);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1854);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1855);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1856);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1857);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1858);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1859);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1860);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1861);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1862);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1863);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1864);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1865);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1866);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1867);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1868);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1869);
    
      }
      else if (includeFile == "association_AddUnidirectionalMN_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1870);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1871);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1872);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1873);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1874);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1875);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1876);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1877);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1878);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1879);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1880);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1881);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1882);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1883);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1884);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1885);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1886);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1887);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1888);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1889);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1890);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1891);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1892);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1893);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1894);
    stringBuffer.append(TEXT_1895);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1896);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1897);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1898);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1899);
    
      }
      else if (includeFile == "association_AddMNToOptionalOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1900);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1901);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1902);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1903);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1904);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1905);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1906);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1907);
     if (customAddPostfixCode != null) {addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1908);
     } 
    stringBuffer.append(TEXT_1909);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_1910);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1911);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1912);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1913);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1914);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1915);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1916);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1917);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1918);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1919);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1920);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1921);
    stringBuffer.append(TEXT_1922);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1923);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1924);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1925);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1926);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1927);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1928);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1929);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1930);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1931);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1932);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1933);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1934);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1935);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1936);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1937);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1938);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1939);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1940);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1941);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1942);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1943);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1944);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_1945);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1946);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1947);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1948);
    
      }
      else if (includeFile == "association_SetNToOptionalOne_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_1949);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1950);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1951);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1952);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1953);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1954);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1955);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1956);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1957);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1958);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1959);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1960);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1961);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1962);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1963);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1964);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1965);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1966);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1967);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_1968);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1969);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1970);
    stringBuffer.append(TEXT_1971);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1972);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1973);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1974);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1975);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1976);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1977);
    stringBuffer.append(TEXT_1978);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1979);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1980);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1981);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_1982);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1983);
    stringBuffer.append(TEXT_1984);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
     if (relReqCommonCode) { 
    stringBuffer.append(TEXT_1985);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1986);
    stringBuffer.append(TEXT_1987);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1988);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1989);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1990);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1991);
    stringBuffer.append(TEXT_1992);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
     if (relReqCommonCode) { 
    stringBuffer.append(TEXT_1993);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_1994);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1995);
    stringBuffer.append(TEXT_1996);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1997);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1998);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1999);
    stringBuffer.append(TEXT_2000);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2001);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2002);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2003);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_2004);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_2005);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2006);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_2007);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2008);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_2009);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_2010);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2011);
    
      }
      else if (includeFile == "association_AddUnidirectionalMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_2012);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_2013);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2014);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2015);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2016);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2017);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2018);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2019);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2020);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_2021);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2022);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2023);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2024);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2025);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2026);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2027);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2028);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2029);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2030);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2031);
    
      }
      else if (includeFile == "association_AddUnidirectionalOptionalN_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_2032);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_2033);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2034);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2035);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2036);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_2037);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_2038);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2039);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2040);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2041);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2042);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2043);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2044);
    stringBuffer.append(TEXT_2045);
    stringBuffer.append( umpleSourceFile );
    stringBuffer.append(TEXT_2046);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_2047);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2048);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2049);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2050);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2051);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2052);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2053);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2054);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2055);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2056);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2057);
    
      }
      else if (includeFile == "association_AddUnidirectionalMStar_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_2058);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_2059);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2060);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2061);
     if (customAddPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPrefixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2062);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2063);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2064);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2065);
     if (customAddPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customAddPostfixCode,gen.translate("addMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2066);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_2067);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2068);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2069);
     if (customRemovePrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePrefixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2070);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2071);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2072);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2073);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_2074);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2075);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2076);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2077);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPre()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2078);
    stringBuffer.append(TEXT_2079);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2080);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2081);
    for( TraceItem traceItemAssocRemove : traceItemAssocRemoves )
    stringBuffer.append( 
(traceItemAssocRemove!=null&&traceItemAssocRemove.getIsPost()?"\n"+traceItemAssocRemove.trace(gen, av,"as_r", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2082);
     if (customRemovePostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customRemovePostfixCode,gen.translate("removeMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2083);
    
      }
      else if (includeFile == "association_SetUnidirectionalN_relatedSpecialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_2084);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_2085);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_2086);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2087);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2088);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2089);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2090);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2091);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2092);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2093);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2094);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2095);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2096);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2097);
    stringBuffer.append(TEXT_2098);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2099);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2100);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2101);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2102);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2103);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_2104);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2105);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2106);
    stringBuffer.append(TEXT_2107);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2108);
    stringBuffer.append(TEXT_2109);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2110);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2111);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2112);
    
      }
      else if (includeFile == "association_SetUnidirectionalMany_relatedSpecialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_2113);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_2114);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_2115);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2116);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2117);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2118);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2119);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2120);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2121);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2122);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2123);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2124);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2125);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2126);
    stringBuffer.append(TEXT_2127);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2128);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2129);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2130);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2131);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2132);
    stringBuffer.append(TEXT_2133);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2134);
    stringBuffer.append(TEXT_2135);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2136);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2137);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2138);
    
      }
      else if (includeFile == "association_SetOptionalOneToMandatoryMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_2139);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_2140);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2141);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2143);
    stringBuffer.append(TEXT_2144);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2145);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2146);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2147);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2148);
     } else {
    stringBuffer.append(TEXT_2149);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2150);
    stringBuffer.append(gen.translate("associationOne",av));
     } 
    stringBuffer.append(TEXT_2151);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2152);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2153);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2154);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_2155);
    stringBuffer.append(TEXT_2156);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2158);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2159);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2160);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2161);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2162);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_2163);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2164);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2165);
    stringBuffer.append(TEXT_2166);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2167);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2168);
    stringBuffer.append(TEXT_2169);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2170);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2171);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2172);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2173);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2174);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_2175);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2176);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2177);
    stringBuffer.append(TEXT_2178);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2179);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2180);
    stringBuffer.append(TEXT_2181);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2182);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_2183);
    stringBuffer.append(TEXT_2184);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2186);
    stringBuffer.append(TEXT_2187);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2188);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2189);
    
      }
      else if (includeFile == "association_SetOptionalOneToMandatoryMN_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_2190);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_2191);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2192);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2193);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2194);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_2195);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2196);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2197);
     if (mulChangedToOne) { 
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2198);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2199);
     } else {
    stringBuffer.append(TEXT_2200);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2201);
    stringBuffer.append(gen.translate("associationOne",av));
     } 
    stringBuffer.append(TEXT_2202);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2203);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2204);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2205);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_2206);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2207);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2208);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2209);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2210);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2211);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2212);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2213);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2214);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2215);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2216);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2217);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2218);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2219);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2220);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2221);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2222);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2223);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2224);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_2225);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2226);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_2227);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2228);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2229);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2230);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_2231);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2232);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2233);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_2234);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_2235);
    
      }
      else if (includeFile != null)
      {
        appendln(stringBuffer,"You forgot to include {0}",includeFile);
      }
      
      
    
      if (includeFile2 == "association_SetMNToMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_2236);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_2237);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2238);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2239);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2240);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2241);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2242);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2243);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2244);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2245);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2246);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2247);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2248);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2249);
    stringBuffer.append(TEXT_2250);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2251);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2252);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2253);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2254);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2255);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2256);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2257);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2258);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_2259);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2260);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2261);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2262);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_2263);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2264);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2265);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2266);
    stringBuffer.append(TEXT_2267);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2268);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2269);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2270);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2271);
    stringBuffer.append(TEXT_2272);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2273);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2274);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_2275);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2276);
    stringBuffer.append(TEXT_2277);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_2278);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2279);
    stringBuffer.append(TEXT_2280);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2281);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_2282);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2283);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_2284);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_2285);
    stringBuffer.append(TEXT_2286);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_2287);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2288);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av));
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2289);
    
      }
      else if (includeFile2 == "association_SetMStarToMany_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_2290);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_2291);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2292);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2293);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2294);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2295);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2296);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2297);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2298);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2299);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2300);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2301);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2302);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2303);
    stringBuffer.append(TEXT_2304);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2305);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2306);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2307);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2308);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2309);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2310);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2311);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2312);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2313);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_2314);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2315);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2316);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2317);
    stringBuffer.append(TEXT_2318);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2319);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2320);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2321);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2322);
    stringBuffer.append(TEXT_2323);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2324);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2325);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_2326);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2327);
    stringBuffer.append(TEXT_2328);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_2329);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2330);
    stringBuffer.append(TEXT_2331);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_2332);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_2333);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2334);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_2335);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_2336);
    stringBuffer.append(TEXT_2337);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_2338);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_2339);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2340);
    
      }
      else if (includeFile2 == "association_SetUnidirectionalMN_relatedSpecialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_2341);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_2342);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_2343);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2344);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2345);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2346);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2347);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2348);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2349);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2350);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2351);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2352);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2353);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2354);
    stringBuffer.append(TEXT_2355);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2356);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2357);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2358);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2359);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2360);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2361);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2362);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2363);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_2364);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2365);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2366);
    stringBuffer.append(TEXT_2367);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2368);
    stringBuffer.append(TEXT_2369);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2370);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2371);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2372);
    
      }
      else if (includeFile2 == "association_SetMNToOptionalOne_relatedSpecialization.jet")
      {
        
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || {0}.length > {1}{2}{3}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av), "_", gen.translate("type",av));

    stringBuffer.append(TEXT_2373);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_2374);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2375);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2376);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2377);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2378);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2379);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2380);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2381);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_2382);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2383);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2384);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_2385);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2386);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_2387);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_2388);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_2389);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2390);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2391);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2392);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_2393);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2394);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
        append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_2395);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2396);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_2397);
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_2398);
     } 
    stringBuffer.append(TEXT_2399);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2400);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_2401);
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_2402);
     } 
    stringBuffer.append(TEXT_2403);
    stringBuffer.append(TEXT_2404);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_2405);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_2406);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2407);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_2408);
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_2409);
     } 
    stringBuffer.append(TEXT_2410);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_2411);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_2412);
    stringBuffer.append(TEXT_2413);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_2414);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_2415);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_2416);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_2417);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_2418);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_2419);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_2420);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_2421);
    stringBuffer.append(TEXT_2422);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_2423);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_2424);
    stringBuffer.append(TEXT_2425);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_2426);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2427);
    stringBuffer.append(TEXT_2428);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2429);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_2430);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2431);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_2432);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2433);
    stringBuffer.append(TEXT_2434);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
     if (relReqCommonCode) { 
    stringBuffer.append(TEXT_2435);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_2436);
    stringBuffer.append(TEXT_2437);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2438);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2439);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2440);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2441);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2442);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_2443);
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_2444);
     } 
    stringBuffer.append(TEXT_2445);
    stringBuffer.append(TEXT_2446);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2447);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_2448);
     if (relMulChangedToOne) { 
    stringBuffer.append(TEXT_2449);
     } 
    stringBuffer.append(TEXT_2450);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2451);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2452);
    stringBuffer.append(TEXT_2453);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
     if (relReqCommonCode) { 
    stringBuffer.append(TEXT_2454);
    stringBuffer.append(gen.relatedTranslate("type",av));
     } 
    stringBuffer.append(TEXT_2455);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2456);
    stringBuffer.append(TEXT_2457);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2458);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2459);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2460);
    stringBuffer.append(TEXT_2461);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_2462);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2463);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2464);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_2465);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_2466);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2467);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_2468);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2469);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_2470);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_2471);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2472);
    
      }
      else if (includeFile2 == "association_SetUnidirectionalOptionalN_relatedSpecialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_2473);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_2474);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_2475);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2476);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2477);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2478);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2479);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2480);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2481);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2482);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2483);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2484);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2485);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2486);
    stringBuffer.append(TEXT_2487);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2488);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2489);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2490);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2491);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2492);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_2493);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2494);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2495);
    stringBuffer.append(TEXT_2496);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2497);
    stringBuffer.append(TEXT_2498);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2499);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2500);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2501);
    
      }
      else if (includeFile2 == "association_SetUnidirectionalMStar_relatedSpecialization.jet")
      {
        
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_2502);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_2503);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_2504);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2505);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2506);
     if (customSetManyPrefixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPrefixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_2507);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2508);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2509);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2510);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2511);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2512);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2513);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2514);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2515);
    stringBuffer.append(TEXT_2516);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2517);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2518);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2519);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_2520);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2521);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_2522);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2523);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_2524);
    stringBuffer.append(TEXT_2525);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2526);
    stringBuffer.append(TEXT_2527);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2528);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_2529);
     if (customSetManyPostfixCode != null) { addUncaughtExceptionVariables(stringBuffer.toString().split("\\n").length,customSetManyPostfixCode,gen.translate("setManyMethod",av)); 
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_2530);
    
      }
      else if (includeFile2 != null)
      {
        appendln(stringBuffer,"You forgot to include {0}",includeFile2);
      }
      
      if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
      {
        
    stringBuffer.append(TEXT_2531);
    
        sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
      }
      else if(includeFile3 == "association_AddIndexControlFunctions_relatedSpecialization.jet")
      {
        
    stringBuffer.append(TEXT_2532);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_2533);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2534);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2535);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_2536);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2537);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_2538);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_2539);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2540);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2541);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2542);
    stringBuffer.append(TEXT_2543);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2544);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2545);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2546);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_2547);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_2548);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2549);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2550);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2551);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_2552);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_2553);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2554);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2555);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2556);
    stringBuffer.append(TEXT_2557);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_2558);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2559);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2560);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPre()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2561);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_2562);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_2563);
    for( TraceItem traceItemAssocAdd : traceItemAssocAdds )
    stringBuffer.append( 
(traceItemAssocAdd!=null&&traceItemAssocAdd.getIsPost()?"\n"+traceItemAssocAdd.trace(gen, av,"as_a", uClass,gen.translate("numberOfMethod",av)+"()"):"")
);
    stringBuffer.append(TEXT_2564);
    
      }

     
    } // end common code
    
    java.util.regex.Pattern lineNumberPattern = java.util.regex.Pattern.compile("// line ([0|1|2|3|4|5|6|7|8|9]*) (.*)");
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

private Map<String,UncaughtException> uncaughtExceptions;
private UmpleClass globalUmpleClass;

public String endAll(String stringBuffer)
{
  GeneratorHelper.generator = null;

    return stringBuffer.toString();
  }
}