package cruise.umple.compiler.php;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class PhpClassGenerator implements ILang
{

  protected static String nl;
  public static synchronized PhpClassGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PhpClassGenerator result = new PhpClassGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?php";
  protected final String TEXT_2 = NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE ${last.version} modeling language!*/" + NL;
  protected final String TEXT_3 = NL + "class ";
  protected final String TEXT_4 = NL + "{";
  protected final String TEXT_5 = NL + NL + "  //------------------------" + NL + "  // CONSTRUCTOR" + NL + "  //------------------------" + NL;
  protected final String TEXT_6 = NL + "    $";
  protected final String TEXT_7 = "->";
  protected final String TEXT_8 = " = array();";
  protected final String TEXT_9 = NL + "    $this->";
  protected final String TEXT_10 = "();";
  protected final String TEXT_11 = NL + "    $this->";
  protected final String TEXT_12 = " = true;";
  protected final String TEXT_13 = NL + "    $this->";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "    $";
  protected final String TEXT_17 = "->";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";";
  protected final String TEXT_20 = NL + "    $";
  protected final String TEXT_21 = "->";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "    $";
  protected final String TEXT_25 = "->";
  protected final String TEXT_26 = " = self::$";
  protected final String TEXT_27 = "++;";
  protected final String TEXT_28 = NL + "    if (!$this->";
  protected final String TEXT_29 = "($";
  protected final String TEXT_30 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Cannot create due to duplicate ";
  protected final String TEXT_31 = "\");" + NL + "    }";
  protected final String TEXT_32 = NL + "    if (!$";
  protected final String TEXT_33 = "->";
  protected final String TEXT_34 = "($";
  protected final String TEXT_35 = "))" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_36 = " due to ";
  protected final String TEXT_37 = "\");" + NL + "    }";
  protected final String TEXT_38 = NL + "    $";
  protected final String TEXT_39 = "->";
  protected final String TEXT_40 = " = array();" + NL + "    $";
  protected final String TEXT_41 = " = $";
  protected final String TEXT_42 = "->";
  protected final String TEXT_43 = "($";
  protected final String TEXT_44 = ");" + NL + "    if (!$";
  protected final String TEXT_45 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_46 = ", must have ";
  protected final String TEXT_47 = " ";
  protected final String TEXT_48 = "\");" + NL + "    }";
  protected final String TEXT_49 = NL + "    $";
  protected final String TEXT_50 = "->";
  protected final String TEXT_51 = " = array();" + NL + "    $";
  protected final String TEXT_52 = " = $";
  protected final String TEXT_53 = "->";
  protected final String TEXT_54 = "($";
  protected final String TEXT_55 = ");" + NL + "    if (!$";
  protected final String TEXT_56 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_57 = ", must have ";
  protected final String TEXT_58 = " or fewer ";
  protected final String TEXT_59 = ", no duplicates.\");" + NL + "    }";
  protected final String TEXT_60 = NL + "    $";
  protected final String TEXT_61 = "->";
  protected final String TEXT_62 = " = array();" + NL + "    $";
  protected final String TEXT_63 = " = $";
  protected final String TEXT_64 = "->";
  protected final String TEXT_65 = "($";
  protected final String TEXT_66 = ");" + NL + "    if (!$";
  protected final String TEXT_67 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_68 = ", must not have duplicate ";
  protected final String TEXT_69 = ".\");" + NL + "    }";
  protected final String TEXT_70 = NL + "    $";
  protected final String TEXT_71 = "->";
  protected final String TEXT_72 = " = array();";
  protected final String TEXT_73 = NL + "    if ($";
  protected final String TEXT_74 = " == null || $";
  protected final String TEXT_75 = "->";
  protected final String TEXT_76 = "() != null)" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_77 = " due to ";
  protected final String TEXT_78 = "\");" + NL + "    }" + NL + "    $";
  protected final String TEXT_79 = "->";
  protected final String TEXT_80 = " = $";
  protected final String TEXT_81 = ";";
  protected final String TEXT_82 = NL + "    $";
  protected final String TEXT_83 = "->";
  protected final String TEXT_84 = " = array();";
  protected final String TEXT_85 = NL + "    $";
  protected final String TEXT_86 = " = $";
  protected final String TEXT_87 = "->";
  protected final String TEXT_88 = "($";
  protected final String TEXT_89 = ");" + NL + "    if (!$";
  protected final String TEXT_90 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_91 = " due to ";
  protected final String TEXT_92 = "\");" + NL + "    }";
  protected final String TEXT_93 = NL + "    $";
  protected final String TEXT_94 = "->";
  protected final String TEXT_95 = " = array();" + NL + "    $";
  protected final String TEXT_96 = " = $";
  protected final String TEXT_97 = "->";
  protected final String TEXT_98 = "($";
  protected final String TEXT_99 = ");" + NL + "    if (!$";
  protected final String TEXT_100 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_101 = ", must have ";
  protected final String TEXT_102 = " ";
  protected final String TEXT_103 = "\");" + NL + "    }";
  protected final String TEXT_104 = "$this->";
  protected final String TEXT_105 = " = array();" + NL + "    $this->";
  protected final String TEXT_106 = "[] = $";
  protected final String TEXT_107 = ";";
  protected final String TEXT_108 = NL + "    $this->";
  protected final String TEXT_109 = "(self::$";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "    $this->";
  protected final String TEXT_112 = "(self::$";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "  public static function getInstance()" + NL + "  {" + NL + "    if(self::$theInstance == null)" + NL + "    {" + NL + "      self::$theInstance = new ";
  protected final String TEXT_115 = "();" + NL + "    }" + NL + "    return self::$theInstance;" + NL + "  }";
  protected final String TEXT_116 = NL + "  public static function newInstance(";
  protected final String TEXT_117 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_118 = " = new ";
  protected final String TEXT_119 = "();";
  protected final String TEXT_120 = NL + "    $";
  protected final String TEXT_121 = "->";
  protected final String TEXT_122 = " = array();";
  protected final String TEXT_123 = NL + "    $this->";
  protected final String TEXT_124 = "();";
  protected final String TEXT_125 = NL + "    $";
  protected final String TEXT_126 = "->";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = ";";
  protected final String TEXT_129 = NL + "    $";
  protected final String TEXT_130 = "->";
  protected final String TEXT_131 = " = ";
  protected final String TEXT_132 = ";";
  protected final String TEXT_133 = NL + "    $";
  protected final String TEXT_134 = "->";
  protected final String TEXT_135 = " = self::$";
  protected final String TEXT_136 = "++;";
  protected final String TEXT_137 = NL + "    $";
  protected final String TEXT_138 = "->";
  protected final String TEXT_139 = " = new ";
  protected final String TEXT_140 = "(";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "    $";
  protected final String TEXT_143 = "->";
  protected final String TEXT_144 = " = array();" + NL + "    $";
  protected final String TEXT_145 = " = $";
  protected final String TEXT_146 = "->";
  protected final String TEXT_147 = "($";
  protected final String TEXT_148 = ");" + NL + "    if (!$";
  protected final String TEXT_149 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_150 = ", must have ";
  protected final String TEXT_151 = " ";
  protected final String TEXT_152 = "\");" + NL + "    }";
  protected final String TEXT_153 = "$this->";
  protected final String TEXT_154 = " = array();" + NL + "    $this->";
  protected final String TEXT_155 = "[] = $";
  protected final String TEXT_156 = ";";
  protected final String TEXT_157 = NL + "  private function callParentConstructor(";
  protected final String TEXT_158 = ")" + NL + "  {" + NL + "    parent::__construct(";
  protected final String TEXT_159 = ");" + NL + "  }" + NL;
  protected final String TEXT_160 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_161 = NL + "  public function ";
  protected final String TEXT_162 = "($";
  protected final String TEXT_163 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_164 = NL + "    $this->";
  protected final String TEXT_165 = " = false;" + NL + "    $this->";
  protected final String TEXT_166 = " = $";
  protected final String TEXT_167 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_168 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_169 = NL + "  public function ";
  protected final String TEXT_170 = "($";
  protected final String TEXT_171 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_172 = NL + "    $this->";
  protected final String TEXT_173 = " = $";
  protected final String TEXT_174 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_175 = NL + "    return $wasSet;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_176 = "()" + NL + "  {" + NL + "    $wasReset = false;";
  protected final String TEXT_177 = NL + "    $this->";
  protected final String TEXT_178 = " = $this->";
  protected final String TEXT_179 = "();" + NL + "    $wasReset = true;";
  protected final String TEXT_180 = NL + "    return $wasReset;" + NL + "  }" + NL;
  protected final String TEXT_181 = NL + "  public function ";
  protected final String TEXT_182 = "($";
  protected final String TEXT_183 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_184 = NL + "    $this->";
  protected final String TEXT_185 = "[] = $";
  protected final String TEXT_186 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_187 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_188 = "($";
  protected final String TEXT_189 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_190 = NL + "    unset($this->";
  protected final String TEXT_191 = "[$this->";
  protected final String TEXT_192 = "($";
  protected final String TEXT_193 = ")]);" + NL + "    $this->";
  protected final String TEXT_194 = " = array_values($this->";
  protected final String TEXT_195 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_196 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_197 = NL + "  public function ";
  protected final String TEXT_198 = "($";
  protected final String TEXT_199 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_200 = NL + "    $this->";
  protected final String TEXT_201 = " = $";
  protected final String TEXT_202 = ";";
  protected final String TEXT_203 = NL + "    $wasSet = true;";
  protected final String TEXT_204 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_205 = NL + "  public function ";
  protected final String TEXT_206 = "($";
  protected final String TEXT_207 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_208 = NL + "      $wasSet = parent::";
  protected final String TEXT_209 = "(";
  protected final String TEXT_210 = ");";
  protected final String TEXT_211 = NL + "    return $wasSet;" + NL + "  }" + NL + NL;
  protected final String TEXT_212 = NL + "  public function ";
  protected final String TEXT_213 = "($";
  protected final String TEXT_214 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_215 = NL + "      $wasAdded = parent::";
  protected final String TEXT_216 = "(";
  protected final String TEXT_217 = ");";
  protected final String TEXT_218 = NL + "    return $wasAdded;" + NL + "  }";
  protected final String TEXT_219 = NL + "  public function ";
  protected final String TEXT_220 = "($";
  protected final String TEXT_221 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_222 = NL + "      $wasSet = parent::";
  protected final String TEXT_223 = "(";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_226 = NL + "  public function ";
  protected final String TEXT_227 = "($index)" + NL + "  {";
  protected final String TEXT_228 = NL + "    $";
  protected final String TEXT_229 = " = $this->";
  protected final String TEXT_230 = "[$index];";
  protected final String TEXT_231 = NL + "    return $";
  protected final String TEXT_232 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_233 = "()" + NL + "  {";
  protected final String TEXT_234 = NL + "    $";
  protected final String TEXT_235 = " = $this->";
  protected final String TEXT_236 = ";";
  protected final String TEXT_237 = NL + "    return $";
  protected final String TEXT_238 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_239 = "()" + NL + "  {";
  protected final String TEXT_240 = NL + "    $number = count($this->";
  protected final String TEXT_241 = ");";
  protected final String TEXT_242 = NL + "    return $number;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_243 = "()" + NL + "  {";
  protected final String TEXT_244 = NL + "    $has = ";
  protected final String TEXT_245 = ".size() > 0;";
  protected final String TEXT_246 = NL + "    return $has;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_247 = "($";
  protected final String TEXT_248 = ")" + NL + "  {";
  protected final String TEXT_249 = NL + "    $rawAnswer = array_search($";
  protected final String TEXT_250 = ",$this->";
  protected final String TEXT_251 = ");" + NL + "    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;";
  protected final String TEXT_252 = NL + "    return $index;" + NL + "  }" + NL;
  protected final String TEXT_253 = NL + "  public function ";
  protected final String TEXT_254 = "()" + NL + "  {";
  protected final String TEXT_255 = NL + "    $";
  protected final String TEXT_256 = " = ";
  protected final String TEXT_257 = ";";
  protected final String TEXT_258 = NL + "    return $";
  protected final String TEXT_259 = ";" + NL + "  }";
  protected final String TEXT_260 = NL + "  public function ";
  protected final String TEXT_261 = "()" + NL + "  {";
  protected final String TEXT_262 = NL + "    return ";
  protected final String TEXT_263 = ";" + NL + "  }";
  protected final String TEXT_264 = NL + "  public function ";
  protected final String TEXT_265 = "()" + NL + "  {";
  protected final String TEXT_266 = NL + "    $";
  protected final String TEXT_267 = " = $this->";
  protected final String TEXT_268 = ";";
  protected final String TEXT_269 = NL + "    return $";
  protected final String TEXT_270 = ";" + NL + "  }";
  protected final String TEXT_271 = NL + "  public function ";
  protected final String TEXT_272 = "()" + NL + "  {";
  protected final String TEXT_273 = NL + "    return $this->";
  protected final String TEXT_274 = ";" + NL + "  }";
  protected final String TEXT_275 = NL + "  public function ";
  protected final String TEXT_276 = "()" + NL + "  {";
  protected final String TEXT_277 = NL + "    $";
  protected final String TEXT_278 = " = ";
  protected final String TEXT_279 = ";";
  protected final String TEXT_280 = NL + "    return $";
  protected final String TEXT_281 = ";" + NL + "  }" + NL;
  protected final String TEXT_282 = NL + "  public function ";
  protected final String TEXT_283 = "()" + NL + "  {";
  protected final String TEXT_284 = NL + "    return ";
  protected final String TEXT_285 = ";" + NL + "  }" + NL;
  protected final String TEXT_286 = NL + "  public static function ";
  protected final String TEXT_287 = "($";
  protected final String TEXT_288 = ")" + NL + "  {";
  protected final String TEXT_289 = NL + "    $";
  protected final String TEXT_290 = " = ";
  protected final String TEXT_291 = "[(string)$";
  protected final String TEXT_292 = "];";
  protected final String TEXT_293 = "    return $";
  protected final String TEXT_294 = ";" + NL + "  }" + NL;
  protected final String TEXT_295 = NL + "  public static function ";
  protected final String TEXT_296 = "($";
  protected final String TEXT_297 = ")" + NL + "  {";
  protected final String TEXT_298 = NL + "    return ";
  protected final String TEXT_299 = "[(string)$";
  protected final String TEXT_300 = "];" + NL + "  }" + NL;
  protected final String TEXT_301 = NL + "  public static function ";
  protected final String TEXT_302 = "($";
  protected final String TEXT_303 = ")" + NL + "  {";
  protected final String TEXT_304 = NL + "    $";
  protected final String TEXT_305 = " = array_key_exists((string)$";
  protected final String TEXT_306 = ", ";
  protected final String TEXT_307 = ");";
  protected final String TEXT_308 = "    return $";
  protected final String TEXT_309 = ";" + NL + "  }" + NL;
  protected final String TEXT_310 = NL + "  public static function ";
  protected final String TEXT_311 = "($";
  protected final String TEXT_312 = ")" + NL + "  {";
  protected final String TEXT_313 = NL + "    return array_key_exists((string)$";
  protected final String TEXT_314 = ", ";
  protected final String TEXT_315 = ");" + NL + "  }" + NL;
  protected final String TEXT_316 = NL + "  public function ";
  protected final String TEXT_317 = "()" + NL + "  {";
  protected final String TEXT_318 = NL + "    $";
  protected final String TEXT_319 = " = $this->";
  protected final String TEXT_320 = ";";
  protected final String TEXT_321 = NL + "    return $";
  protected final String TEXT_322 = ";" + NL + "  }";
  protected final String TEXT_323 = NL + "  public function ";
  protected final String TEXT_324 = "()" + NL + "  {";
  protected final String TEXT_325 = NL + "    return $this->";
  protected final String TEXT_326 = ";" + NL + "  }";
  protected final String TEXT_327 = NL + "  public ";
  protected final String TEXT_328 = " ";
  protected final String TEXT_329 = "()" + NL + "  {";
  protected final String TEXT_330 = NL + "    ";
  protected final String TEXT_331 = " ";
  protected final String TEXT_332 = " = ";
  protected final String TEXT_333 = ";";
  protected final String TEXT_334 = NL + "    return ";
  protected final String TEXT_335 = ";" + NL + "  }";
  protected final String TEXT_336 = NL + "  public ";
  protected final String TEXT_337 = " ";
  protected final String TEXT_338 = "()" + NL + "  {";
  protected final String TEXT_339 = NL + "    return ";
  protected final String TEXT_340 = ";" + NL + "  }";
  protected final String TEXT_341 = NL + "  public ";
  protected final String TEXT_342 = " ";
  protected final String TEXT_343 = "()" + NL + "  {";
  protected final String TEXT_344 = NL + "    $";
  protected final String TEXT_345 = " = $this->";
  protected final String TEXT_346 = ";";
  protected final String TEXT_347 = NL + "    return $";
  protected final String TEXT_348 = ";" + NL + "  }";
  protected final String TEXT_349 = NL + "  public function ";
  protected final String TEXT_350 = "()" + NL + "  {";
  protected final String TEXT_351 = NL + "    return $this->";
  protected final String TEXT_352 = ";" + NL + "  }";
  protected final String TEXT_353 = NL + "  public function ";
  protected final String TEXT_354 = "()" + NL + "  {" + NL + "    $answer = $this->";
  protected final String TEXT_355 = "();";
  protected final String TEXT_356 = NL + "    return $answer;" + NL + "  }" + NL;
  protected final String TEXT_357 = NL + "  public function ";
  protected final String TEXT_358 = "()" + NL + "  {";
  protected final String TEXT_359 = NL + "    return null;" + NL + "  }" + NL;
  protected final String TEXT_360 = NL + "  ";
  protected final String TEXT_361 = " function ";
  protected final String TEXT_362 = "(";
  protected final String TEXT_363 = ")" + NL + "  {" + NL + "    $wasEventProcessed = false;";
  protected final String TEXT_364 = NL + "    ";
  protected final String TEXT_365 = NL + "    return $wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_366 = NL + "  public function ";
  protected final String TEXT_367 = "($";
  protected final String TEXT_368 = ")" + NL + "  {";
  protected final String TEXT_369 = NL + "    ";
  protected final String TEXT_370 = NL + "    else" + NL + "    {" + NL + "      return false;" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_371 = NL + "  private function ";
  protected final String TEXT_372 = "()" + NL + "  {";
  protected final String TEXT_373 = NL + "    ";
  protected final String TEXT_374 = NL + "  }" + NL;
  protected final String TEXT_375 = NL + "  private function ";
  protected final String TEXT_376 = "($";
  protected final String TEXT_377 = ")" + NL + "  {";
  protected final String TEXT_378 = NL + "    $this->";
  protected final String TEXT_379 = " = $";
  protected final String TEXT_380 = ";";
  protected final String TEXT_381 = NL + "    if ($this->";
  protected final String TEXT_382 = " != self::$";
  protected final String TEXT_383 = " && $";
  protected final String TEXT_384 = " != self::$";
  protected final String TEXT_385 = ") { $this->";
  protected final String TEXT_386 = "(self::$";
  protected final String TEXT_387 = "); }";
  protected final String TEXT_388 = NL + NL + "    // entry actions and do activities";
  protected final String TEXT_389 = NL + "    ";
  protected final String TEXT_390 = NL + "  }" + NL;
  protected final String TEXT_391 = NL + "  public function ";
  protected final String TEXT_392 = "()" + NL + "  {";
  protected final String TEXT_393 = NL + "    return $this->";
  protected final String TEXT_394 = ";";
  protected final String TEXT_395 = NL + "    $";
  protected final String TEXT_396 = " = $this->";
  protected final String TEXT_397 = ";";
  protected final String TEXT_398 = NL + "    return $";
  protected final String TEXT_399 = ";";
  protected final String TEXT_400 = NL + "  }";
  protected final String TEXT_401 = NL + NL + "  public function ";
  protected final String TEXT_402 = "()" + NL + "  {" + NL + "    $has = $this->";
  protected final String TEXT_403 = " != null;" + NL + "    return $has;" + NL + "  }";
  protected final String TEXT_404 = NL;
  protected final String TEXT_405 = NL + "  public function ";
  protected final String TEXT_406 = "($index)" + NL + "  {";
  protected final String TEXT_407 = NL + "    $";
  protected final String TEXT_408 = " = $this->";
  protected final String TEXT_409 = "[$index];";
  protected final String TEXT_410 = NL + "    return $";
  protected final String TEXT_411 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_412 = "()" + NL + "  {";
  protected final String TEXT_413 = NL + "    $";
  protected final String TEXT_414 = " = $this->";
  protected final String TEXT_415 = ";";
  protected final String TEXT_416 = NL + "    return $";
  protected final String TEXT_417 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_418 = "()" + NL + "  {";
  protected final String TEXT_419 = NL + "    $number = count($this->";
  protected final String TEXT_420 = ");";
  protected final String TEXT_421 = NL + "    return $number;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_422 = "()" + NL + "  {";
  protected final String TEXT_423 = NL + "    $has = $this->";
  protected final String TEXT_424 = "() > 0;";
  protected final String TEXT_425 = NL + "    return $has;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_426 = "($";
  protected final String TEXT_427 = ")" + NL + "  {";
  protected final String TEXT_428 = NL + "    $wasFound = false;" + NL + "    $index = 0;" + NL + "    foreach($this->";
  protected final String TEXT_429 = " as $";
  protected final String TEXT_430 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_431 = "->equals($";
  protected final String TEXT_432 = "))" + NL + "      {" + NL + "        $wasFound = true;" + NL + "        break;" + NL + "      }" + NL + "      $index += 1;" + NL + "    }" + NL + "    $index = $wasFound ? $index : -1;";
  protected final String TEXT_433 = NL + "    return $index;" + NL + "  }" + NL;
  protected final String TEXT_434 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_435 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_436 = " : ";
  protected final String TEXT_437 = NL + "  public function ";
  protected final String TEXT_438 = "()" + NL + "  {";
  protected final String TEXT_439 = NL + "    $isValid = $this->";
  protected final String TEXT_440 = "() >= self::";
  protected final String TEXT_441 = "();";
  protected final String TEXT_442 = NL + "    $isValid = $this->";
  protected final String TEXT_443 = "() >= self::";
  protected final String TEXT_444 = "() && $this->";
  protected final String TEXT_445 = "() <= self::";
  protected final String TEXT_446 = "();";
  protected final String TEXT_447 = NL + "    return $isValid;" + NL + "  }";
  protected final String TEXT_448 = NL + "  public static function ";
  protected final String TEXT_449 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_450 = ";" + NL + "  }";
  protected final String TEXT_451 = NL + "  public static function ";
  protected final String TEXT_452 = "()" + NL + "  {";
  protected final String TEXT_453 = NL + "    $minimum = ";
  protected final String TEXT_454 = ";";
  protected final String TEXT_455 = NL + "    return $minimum;" + NL + "  }";
  protected final String TEXT_456 = NL + "  public static function ";
  protected final String TEXT_457 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_458 = ";" + NL + "  }";
  protected final String TEXT_459 = NL + "  public static function ";
  protected final String TEXT_460 = "()" + NL + "  {";
  protected final String TEXT_461 = NL + "    $minimum = ";
  protected final String TEXT_462 = ";";
  protected final String TEXT_463 = NL + "    return $minimum;" + NL + "  }";
  protected final String TEXT_464 = NL + "  public static function ";
  protected final String TEXT_465 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_466 = ";" + NL + "  }";
  protected final String TEXT_467 = NL + "  public static function ";
  protected final String TEXT_468 = "()" + NL + "  {";
  protected final String TEXT_469 = NL + "    $maximum = ";
  protected final String TEXT_470 = ";";
  protected final String TEXT_471 = NL + "    return $maximum;" + NL + "  }";
  protected final String TEXT_472 = NL + "  public function ";
  protected final String TEXT_473 = "($";
  protected final String TEXT_474 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_475 = NL + "    if ($this->";
  protected final String TEXT_476 = "() >= self::";
  protected final String TEXT_477 = "())" + NL + "    {";
  protected final String TEXT_478 = NL + "      return $wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_479 = NL + "    $this->";
  protected final String TEXT_480 = "[] = $";
  protected final String TEXT_481 = ";" + NL + "    if ($";
  protected final String TEXT_482 = "->";
  protected final String TEXT_483 = "($this) != -1)" + NL + "    {" + NL + "      $wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasAdded = $";
  protected final String TEXT_484 = "->";
  protected final String TEXT_485 = "($this);" + NL + "      if (!$wasAdded)" + NL + "      {" + NL + "        array_pop($this->";
  protected final String TEXT_486 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_487 = NL + "    return $wasAdded;" + NL + "  }";
  protected final String TEXT_488 = NL + "  public function ";
  protected final String TEXT_489 = "($";
  protected final String TEXT_490 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_491 = NL + "    if ($this->";
  protected final String TEXT_492 = "($";
  protected final String TEXT_493 = ") == -1)" + NL + "    {";
  protected final String TEXT_494 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_495 = "($";
  protected final String TEXT_496 = ");" + NL + "    unset($this->";
  protected final String TEXT_497 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_498 = "->";
  protected final String TEXT_499 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_500 = "->";
  protected final String TEXT_501 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_502 = "[$oldIndex] = $";
  protected final String TEXT_503 = ";" + NL + "        ksort($this->";
  protected final String TEXT_504 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_505 = " = array_values($this->";
  protected final String TEXT_506 = ");";
  protected final String TEXT_507 = NL + "    return $wasRemoved;" + NL + "  }";
  protected final String TEXT_508 = NL + "  ";
  protected final String TEXT_509 = " function ";
  protected final String TEXT_510 = "($";
  protected final String TEXT_511 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_512 = NL + "    $this->";
  protected final String TEXT_513 = " = $";
  protected final String TEXT_514 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_515 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_516 = NL + "  ";
  protected final String TEXT_517 = " function ";
  protected final String TEXT_518 = "($";
  protected final String TEXT_519 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_520 = NL + "    if ($";
  protected final String TEXT_521 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_522 = " = $";
  protected final String TEXT_523 = ";" + NL + "      $wasSet = true;" + NL + "    }";
  protected final String TEXT_524 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_525 = NL + "  public function ";
  protected final String TEXT_526 = "($";
  protected final String TEXT_527 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_528 = NL + "    if ($this->";
  protected final String TEXT_529 = " != null && $this->";
  protected final String TEXT_530 = " != $";
  protected final String TEXT_531 = " && $this == $this->";
  protected final String TEXT_532 = "->";
  protected final String TEXT_533 = "())" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_534 = ", as existing ";
  protected final String TEXT_535 = " would become an orphan";
  protected final String TEXT_536 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $this->";
  protected final String TEXT_537 = " = $";
  protected final String TEXT_538 = ";" + NL + "    $";
  protected final String TEXT_539 = " = $";
  protected final String TEXT_540 = " != null ? $";
  protected final String TEXT_541 = "->";
  protected final String TEXT_542 = "() : null;" + NL + "    " + NL + "    if ($this != $";
  protected final String TEXT_543 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_544 = " != null)" + NL + "      {" + NL + "        $";
  protected final String TEXT_545 = "->";
  protected final String TEXT_546 = " = null;" + NL + "      }" + NL + "      if ($this->";
  protected final String TEXT_547 = " != null)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_548 = "->";
  protected final String TEXT_549 = "($this);" + NL + "      }" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_550 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_551 = NL + "  public function ";
  protected final String TEXT_552 = "($";
  protected final String TEXT_553 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_554 = NL + "    if ($";
  protected final String TEXT_555 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_556 = " to null, as ";
  protected final String TEXT_557 = " must always be associated to a ";
  protected final String TEXT_558 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_559 = " = $";
  protected final String TEXT_560 = "->";
  protected final String TEXT_561 = "();" + NL + "    if ($";
  protected final String TEXT_562 = " != null && $this != $";
  protected final String TEXT_563 = ")" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_564 = ", the current ";
  protected final String TEXT_565 = " already has a ";
  protected final String TEXT_566 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_567 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_568 = " = $this->";
  protected final String TEXT_569 = ";" + NL + "    $this->";
  protected final String TEXT_570 = " = $";
  protected final String TEXT_571 = ";" + NL + "    $this->";
  protected final String TEXT_572 = "->";
  protected final String TEXT_573 = "($this);" + NL + "    " + NL + "    if ($";
  protected final String TEXT_574 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_575 = "->";
  protected final String TEXT_576 = "(null);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_577 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_578 = NL + "  public function ";
  protected final String TEXT_579 = "(";
  protected final String TEXT_580 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_581 = "(";
  protected final String TEXT_582 = ");" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_583 = "($";
  protected final String TEXT_584 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_585 = NL + "    $";
  protected final String TEXT_586 = " = $";
  protected final String TEXT_587 = "->";
  protected final String TEXT_588 = "();" + NL + "    $";
  protected final String TEXT_589 = " = $";
  protected final String TEXT_590 = " != null && $this !== $";
  protected final String TEXT_591 = ";" + NL + "" + NL + "    if ($";
  protected final String TEXT_592 = " && $";
  protected final String TEXT_593 = "->";
  protected final String TEXT_594 = "() <= self::";
  protected final String TEXT_595 = "())" + NL + "    {" + NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    if ($";
  protected final String TEXT_596 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_597 = "->";
  protected final String TEXT_598 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_599 = "[] = $";
  protected final String TEXT_600 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_601 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_602 = "($";
  protected final String TEXT_603 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_604 = NL + "    //Unable to remove ";
  protected final String TEXT_605 = ", as it must always have a ";
  protected final String TEXT_606 = NL + "    if ($this === $";
  protected final String TEXT_607 = "->";
  protected final String TEXT_608 = "())" + NL + "    {";
  protected final String TEXT_609 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_610 = " already at minimum (";
  protected final String TEXT_611 = ")" + NL + "    if ($this->";
  protected final String TEXT_612 = "() <= self::";
  protected final String TEXT_613 = "())" + NL + "    {";
  protected final String TEXT_614 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_615 = "[$this->";
  protected final String TEXT_616 = "($";
  protected final String TEXT_617 = ")]);" + NL + "    $this->";
  protected final String TEXT_618 = " = array_values($this->";
  protected final String TEXT_619 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_620 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_621 = NL + "  public function ";
  protected final String TEXT_622 = "(";
  protected final String TEXT_623 = ")" + NL + "  {" + NL + "    if ($this->";
  protected final String TEXT_624 = "() >= self::";
  protected final String TEXT_625 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_626 = "(";
  protected final String TEXT_627 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_628 = "($";
  protected final String TEXT_629 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_630 = NL + "    if ($this->";
  protected final String TEXT_631 = "() >= self::";
  protected final String TEXT_632 = "())" + NL + "    {";
  protected final String TEXT_633 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_634 = " = $";
  protected final String TEXT_635 = "->";
  protected final String TEXT_636 = "();" + NL + "    $";
  protected final String TEXT_637 = " = $";
  protected final String TEXT_638 = " != null && $this !== $";
  protected final String TEXT_639 = ";" + NL + "" + NL + "    if ($";
  protected final String TEXT_640 = " && $";
  protected final String TEXT_641 = "->";
  protected final String TEXT_642 = "() <= self::";
  protected final String TEXT_643 = "())" + NL + "    {";
  protected final String TEXT_644 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    if ($";
  protected final String TEXT_645 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_646 = "->";
  protected final String TEXT_647 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_648 = "[] = $";
  protected final String TEXT_649 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_650 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_651 = "($";
  protected final String TEXT_652 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_653 = NL + "    //Unable to remove ";
  protected final String TEXT_654 = ", as it must always have a ";
  protected final String TEXT_655 = NL + "    if ($this === $";
  protected final String TEXT_656 = "->";
  protected final String TEXT_657 = "())" + NL + "    {";
  protected final String TEXT_658 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_659 = " already at minimum (";
  protected final String TEXT_660 = ")" + NL + "    if ($this->";
  protected final String TEXT_661 = "() <= self::";
  protected final String TEXT_662 = "())" + NL + "    {";
  protected final String TEXT_663 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_664 = "[$this->";
  protected final String TEXT_665 = "($";
  protected final String TEXT_666 = ")]);" + NL + "    $this->";
  protected final String TEXT_667 = " = array_values($this->";
  protected final String TEXT_668 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_669 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_670 = NL + "  public function ";
  protected final String TEXT_671 = "(";
  protected final String TEXT_672 = ")" + NL + "  {" + NL + "    if ($this->";
  protected final String TEXT_673 = "() >= self::";
  protected final String TEXT_674 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_675 = "(";
  protected final String TEXT_676 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_677 = "($";
  protected final String TEXT_678 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_679 = NL + "    if ($this->";
  protected final String TEXT_680 = "() >= self::";
  protected final String TEXT_681 = "())" + NL + "    {";
  protected final String TEXT_682 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_683 = " = $";
  protected final String TEXT_684 = "->";
  protected final String TEXT_685 = "();" + NL + "    $";
  protected final String TEXT_686 = " = $";
  protected final String TEXT_687 = " != null && $this !== $";
  protected final String TEXT_688 = ";" + NL + "    if ($";
  protected final String TEXT_689 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_690 = "->";
  protected final String TEXT_691 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_692 = "[] = $";
  protected final String TEXT_693 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_694 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_695 = "($";
  protected final String TEXT_696 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_697 = NL + "    //Unable to remove ";
  protected final String TEXT_698 = ", as it must always have a ";
  protected final String TEXT_699 = NL + "    if ($this !== $";
  protected final String TEXT_700 = "->";
  protected final String TEXT_701 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_702 = "[$this->";
  protected final String TEXT_703 = "($";
  protected final String TEXT_704 = ")]);" + NL + "      $this->";
  protected final String TEXT_705 = " = array_values($this->";
  protected final String TEXT_706 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_707 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_708 = NL + "  public function ";
  protected final String TEXT_709 = "($";
  protected final String TEXT_710 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_711 = NL + "    $";
  protected final String TEXT_712 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_713 = " as $";
  protected final String TEXT_714 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_715 = ",$";
  protected final String TEXT_716 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_717 = "[] = $";
  protected final String TEXT_718 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_719 = ") != count($";
  protected final String TEXT_720 = ") || count($";
  protected final String TEXT_721 = ") > self::";
  protected final String TEXT_722 = "())" + NL + "    {";
  protected final String TEXT_723 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_724 = " = $this->";
  protected final String TEXT_725 = ";" + NL + "    $this->";
  protected final String TEXT_726 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_727 = " as $";
  protected final String TEXT_728 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_729 = "[] = $";
  protected final String TEXT_730 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_731 = ",$";
  protected final String TEXT_732 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_733 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_734 = " = array_values($";
  protected final String TEXT_735 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_736 = "->";
  protected final String TEXT_737 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_738 = " as $";
  protected final String TEXT_739 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_740 = "->";
  protected final String TEXT_741 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_742 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_743 = NL + "  public function ";
  protected final String TEXT_744 = "(";
  protected final String TEXT_745 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_746 = "(";
  protected final String TEXT_747 = ");" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_748 = "($";
  protected final String TEXT_749 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_750 = NL + "    $";
  protected final String TEXT_751 = " = $";
  protected final String TEXT_752 = "->";
  protected final String TEXT_753 = "();" + NL + "    $";
  protected final String TEXT_754 = " = $";
  protected final String TEXT_755 = " != null && $this !== $";
  protected final String TEXT_756 = ";" + NL + "    if ($";
  protected final String TEXT_757 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_758 = "->";
  protected final String TEXT_759 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_760 = "[] = $";
  protected final String TEXT_761 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_762 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_763 = "($";
  protected final String TEXT_764 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_765 = NL + "    //Unable to remove ";
  protected final String TEXT_766 = ", as it must always have a ";
  protected final String TEXT_767 = NL + "    if ($this !== $";
  protected final String TEXT_768 = "->";
  protected final String TEXT_769 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_770 = "[$this->";
  protected final String TEXT_771 = "($";
  protected final String TEXT_772 = ")]);" + NL + "      $this->";
  protected final String TEXT_773 = " = array_values($this->";
  protected final String TEXT_774 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_775 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_776 = NL + "  public function ";
  protected final String TEXT_777 = "($";
  protected final String TEXT_778 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_779 = NL + "    if ($";
  protected final String TEXT_780 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_781 = " = $this->";
  protected final String TEXT_782 = ";" + NL + "      $this->";
  protected final String TEXT_783 = " = null;" + NL + "      " + NL + "      if ($";
  protected final String TEXT_784 = " != null && $";
  protected final String TEXT_785 = "->";
  protected final String TEXT_786 = "() != null)" + NL + "      {" + NL + "        $";
  protected final String TEXT_787 = "->";
  protected final String TEXT_788 = "(null);" + NL + "      }" + NL + "      $wasSet = true;";
  protected final String TEXT_789 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_790 = " = $this->";
  protected final String TEXT_791 = "();" + NL + "    if ($";
  protected final String TEXT_792 = " != null && $";
  protected final String TEXT_793 = " != $";
  protected final String TEXT_794 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_795 = "->";
  protected final String TEXT_796 = "(null);" + NL + "    }" + NL + "    " + NL + "    $this->";
  protected final String TEXT_797 = " = $";
  protected final String TEXT_798 = ";" + NL + "    $";
  protected final String TEXT_799 = " = $";
  protected final String TEXT_800 = "->";
  protected final String TEXT_801 = "();" + NL + "    " + NL + "    if ($this != $";
  protected final String TEXT_802 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_803 = "->";
  protected final String TEXT_804 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_805 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_806 = NL + "  public function ";
  protected final String TEXT_807 = "($";
  protected final String TEXT_808 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_809 = NL + "    if ($this->";
  protected final String TEXT_810 = "($";
  protected final String TEXT_811 = ") == -1)" + NL + "    {";
  protected final String TEXT_812 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_813 = "() <= self::";
  protected final String TEXT_814 = "())" + NL + "    {";
  protected final String TEXT_815 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_816 = "($";
  protected final String TEXT_817 = ");" + NL + "    unset($this->";
  protected final String TEXT_818 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_819 = "->";
  protected final String TEXT_820 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_821 = "->";
  protected final String TEXT_822 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_823 = "[$oldIndex] = $";
  protected final String TEXT_824 = ";" + NL + "        ksort($this->";
  protected final String TEXT_825 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_826 = " = array_values($this->";
  protected final String TEXT_827 = ");";
  protected final String TEXT_828 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_829 = NL + "  public function ";
  protected final String TEXT_830 = "($";
  protected final String TEXT_831 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_832 = NL + "    if ($this->";
  protected final String TEXT_833 = "($";
  protected final String TEXT_834 = ") == -1)" + NL + "    {";
  protected final String TEXT_835 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_836 = "() <= self::";
  protected final String TEXT_837 = "())" + NL + "    {";
  protected final String TEXT_838 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_839 = "($";
  protected final String TEXT_840 = ");" + NL + "    unset($this->";
  protected final String TEXT_841 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_842 = "->";
  protected final String TEXT_843 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_844 = "->";
  protected final String TEXT_845 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_846 = "[$oldIndex] = $";
  protected final String TEXT_847 = ";" + NL + "        ksort($this->";
  protected final String TEXT_848 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_849 = " = array_values($this->";
  protected final String TEXT_850 = ");";
  protected final String TEXT_851 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_852 = NL + "  public function ";
  protected final String TEXT_853 = "($";
  protected final String TEXT_854 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_855 = NL + "    if ($";
  protected final String TEXT_856 = " != null && $";
  protected final String TEXT_857 = "->";
  protected final String TEXT_858 = "() >= ";
  protected final String TEXT_859 = "::";
  protected final String TEXT_860 = "())" + NL + "    {";
  protected final String TEXT_861 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_862 = " = $this->";
  protected final String TEXT_863 = ";" + NL + "    $this->";
  protected final String TEXT_864 = " = $";
  protected final String TEXT_865 = ";" + NL + "    if ($";
  protected final String TEXT_866 = " != null && $";
  protected final String TEXT_867 = " != $";
  protected final String TEXT_868 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_869 = "->";
  protected final String TEXT_870 = "($this);" + NL + "    }" + NL + "    if ($";
  protected final String TEXT_871 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_872 = "->";
  protected final String TEXT_873 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_874 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_875 = NL + "  public function ";
  protected final String TEXT_876 = "($";
  protected final String TEXT_877 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_878 = NL + "    if ($";
  protected final String TEXT_879 = " == null)" + NL + "    {";
  protected final String TEXT_880 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_881 = " = $this->";
  protected final String TEXT_882 = ";" + NL + "    $this->";
  protected final String TEXT_883 = " = $";
  protected final String TEXT_884 = ";" + NL + "    if ($";
  protected final String TEXT_885 = " != null && $";
  protected final String TEXT_886 = " != $";
  protected final String TEXT_887 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_888 = "->";
  protected final String TEXT_889 = "($this);" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_890 = "->";
  protected final String TEXT_891 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_892 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_893 = NL + "  public function ";
  protected final String TEXT_894 = "($";
  protected final String TEXT_895 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_896 = NL + "    if ($";
  protected final String TEXT_897 = ".nil?)" + NL + "    {";
  protected final String TEXT_898 = NL + "      return wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_899 = " = $this->";
  protected final String TEXT_900 = ";" + NL + "    $this->";
  protected final String TEXT_901 = " = $";
  protected final String TEXT_902 = ";" + NL + "    if (!$";
  protected final String TEXT_903 = "->is_null() && !$";
  protected final String TEXT_904 = "->equals($";
  protected final String TEXT_905 = "))" + NL + "    {" + NL + "      $";
  protected final String TEXT_906 = "->";
  protected final String TEXT_907 = "($this);" + NL + "    }" + NL + "    if !$this->";
  protected final String TEXT_908 = "->";
  protected final String TEXT_909 = "($this)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_910 = " = $";
  protected final String TEXT_911 = ";" + NL + "      $wasSet = false;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasSet = true;" + NL + "    }";
  protected final String TEXT_912 = NL + "    return $wasSet;" + NL + "  end" + NL;
  protected final String TEXT_913 = NL + "  public function ";
  protected final String TEXT_914 = "($";
  protected final String TEXT_915 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_916 = NL + "    //Must provide ";
  protected final String TEXT_917 = " to ";
  protected final String TEXT_918 = NL + "    if ($";
  protected final String TEXT_919 = " == null)" + NL + "    {";
  protected final String TEXT_920 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_921 = " already at maximum (";
  protected final String TEXT_922 = ")" + NL + "    if ($";
  protected final String TEXT_923 = "->";
  protected final String TEXT_924 = "() >= ";
  protected final String TEXT_925 = "::";
  protected final String TEXT_926 = "())" + NL + "    {";
  protected final String TEXT_927 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_928 = " = $this->";
  protected final String TEXT_929 = ";" + NL + "    $this->";
  protected final String TEXT_930 = " = $";
  protected final String TEXT_931 = ";" + NL + "    if ($";
  protected final String TEXT_932 = " != null && $";
  protected final String TEXT_933 = " != $";
  protected final String TEXT_934 = ")" + NL + "    {" + NL + "      $didRemove = $";
  protected final String TEXT_935 = "->";
  protected final String TEXT_936 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_937 = " = $";
  protected final String TEXT_938 = ";";
  protected final String TEXT_939 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_940 = "->";
  protected final String TEXT_941 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_942 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_943 = NL + "  public function ";
  protected final String TEXT_944 = "($";
  protected final String TEXT_945 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_946 = NL + "    //Must provide ";
  protected final String TEXT_947 = " to ";
  protected final String TEXT_948 = NL + "    if ($";
  protected final String TEXT_949 = " == null)" + NL + "    {";
  protected final String TEXT_950 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_951 = " != null && $this->";
  protected final String TEXT_952 = "->";
  protected final String TEXT_953 = "() <= ";
  protected final String TEXT_954 = "::";
  protected final String TEXT_955 = "())" + NL + "    {";
  protected final String TEXT_956 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_957 = " = $this->";
  protected final String TEXT_958 = ";" + NL + "    $this->";
  protected final String TEXT_959 = " = $";
  protected final String TEXT_960 = ";" + NL + "    if ($";
  protected final String TEXT_961 = " != null && $";
  protected final String TEXT_962 = " != $";
  protected final String TEXT_963 = ")" + NL + "    {" + NL + "      $didRemove = $";
  protected final String TEXT_964 = "->";
  protected final String TEXT_965 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_966 = " = $";
  protected final String TEXT_967 = ";";
  protected final String TEXT_968 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_969 = "->";
  protected final String TEXT_970 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_971 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_972 = NL + "  public function ";
  protected final String TEXT_973 = "($";
  protected final String TEXT_974 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_975 = NL + "    $";
  protected final String TEXT_976 = " = $";
  protected final String TEXT_977 = "->";
  protected final String TEXT_978 = "();" + NL + "    if ($";
  protected final String TEXT_979 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_980 = "->";
  protected final String TEXT_981 = "($this);" + NL + "    }" + NL + "    elseif ($this !== $";
  protected final String TEXT_982 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_983 = "->";
  protected final String TEXT_984 = "($";
  protected final String TEXT_985 = ");" + NL + "      $this->";
  protected final String TEXT_986 = "($";
  protected final String TEXT_987 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_988 = "[] = $";
  protected final String TEXT_989 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_990 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_991 = "($";
  protected final String TEXT_992 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_993 = NL + "    if ($this->";
  protected final String TEXT_994 = "($";
  protected final String TEXT_995 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_996 = "[$this->";
  protected final String TEXT_997 = "($";
  protected final String TEXT_998 = ")]);" + NL + "      $this->";
  protected final String TEXT_999 = " = array_values($this->";
  protected final String TEXT_1000 = ");" + NL + "      if ($this === $";
  protected final String TEXT_1001 = "->";
  protected final String TEXT_1002 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_1003 = "->";
  protected final String TEXT_1004 = "(null);" + NL + "      }" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1005 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1006 = NL + "  public function ";
  protected final String TEXT_1007 = "($";
  protected final String TEXT_1008 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1009 = NL + "    $";
  protected final String TEXT_1010 = " = $this->";
  protected final String TEXT_1011 = ";" + NL + "    $this->";
  protected final String TEXT_1012 = " = $";
  protected final String TEXT_1013 = ";" + NL + "    if ($";
  protected final String TEXT_1014 = " != null && $";
  protected final String TEXT_1015 = " !== $";
  protected final String TEXT_1016 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1017 = "->";
  protected final String TEXT_1018 = "($this);" + NL + "    }" + NL + "    if ($";
  protected final String TEXT_1019 = " != null && $";
  protected final String TEXT_1020 = " !== $";
  protected final String TEXT_1021 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1022 = "->";
  protected final String TEXT_1023 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1024 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1025 = NL + "  public function ";
  protected final String TEXT_1026 = "($";
  protected final String TEXT_1027 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1028 = NL + "    if ($this->";
  protected final String TEXT_1029 = "() >= self::";
  protected final String TEXT_1030 = "())" + NL + "    {";
  protected final String TEXT_1031 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1032 = " = $";
  protected final String TEXT_1033 = "->";
  protected final String TEXT_1034 = "();" + NL + "    if ($";
  protected final String TEXT_1035 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1036 = "->";
  protected final String TEXT_1037 = "($this);" + NL + "    }" + NL + "    else if ($this !== $";
  protected final String TEXT_1038 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1039 = "->";
  protected final String TEXT_1040 = "($";
  protected final String TEXT_1041 = ");" + NL + "      $this->";
  protected final String TEXT_1042 = "($";
  protected final String TEXT_1043 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1044 = "[] = $";
  protected final String TEXT_1045 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_1046 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1047 = "($";
  protected final String TEXT_1048 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1049 = NL + "    if ($this->";
  protected final String TEXT_1050 = "($";
  protected final String TEXT_1051 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1052 = "[$this->";
  protected final String TEXT_1053 = "($";
  protected final String TEXT_1054 = ")]);" + NL + "      $this->";
  protected final String TEXT_1055 = " = array_values($this->";
  protected final String TEXT_1056 = ");" + NL + "      $";
  protected final String TEXT_1057 = "->";
  protected final String TEXT_1058 = "(null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1059 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1060 = NL + "  public function ";
  protected final String TEXT_1061 = "($";
  protected final String TEXT_1062 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1063 = NL + "    if ($this->";
  protected final String TEXT_1064 = "() < self::";
  protected final String TEXT_1065 = "())" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1066 = "[] = $";
  protected final String TEXT_1067 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  protected final String TEXT_1068 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1069 = "($";
  protected final String TEXT_1070 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1071 = NL + "    if ($this->";
  protected final String TEXT_1072 = "($";
  protected final String TEXT_1073 = ") == -1)" + NL + "    {";
  protected final String TEXT_1074 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_1075 = "() <= self::";
  protected final String TEXT_1076 = "())" + NL + "    {";
  protected final String TEXT_1077 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_1078 = "[$this->";
  protected final String TEXT_1079 = "($";
  protected final String TEXT_1080 = ")]);" + NL + "    $this->";
  protected final String TEXT_1081 = " = array_values($this->";
  protected final String TEXT_1082 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_1083 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1084 = NL + "  public function ";
  protected final String TEXT_1085 = "($";
  protected final String TEXT_1086 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1087 = NL + "    if ($this->";
  protected final String TEXT_1088 = "() >= self::";
  protected final String TEXT_1089 = "())" + NL + "    {";
  protected final String TEXT_1090 = NL + "      return $wasAdded;" + NL + "    }";
  protected final String TEXT_1091 = NL + "    $";
  protected final String TEXT_1092 = " = $";
  protected final String TEXT_1093 = "->";
  protected final String TEXT_1094 = "();" + NL + "    if ($";
  protected final String TEXT_1095 = " != null && $";
  protected final String TEXT_1096 = "->";
  protected final String TEXT_1097 = "() <= self::";
  protected final String TEXT_1098 = "())" + NL + "    {";
  protected final String TEXT_1099 = NL + "      return $wasAdded;" + NL + "    }" + NL + "    else if ($";
  protected final String TEXT_1100 = " != null)" + NL + "    {" + NL + "      unset($";
  protected final String TEXT_1101 = "->";
  protected final String TEXT_1102 = "[$";
  protected final String TEXT_1103 = "->";
  protected final String TEXT_1104 = "($";
  protected final String TEXT_1105 = ")]);" + NL + "      $";
  protected final String TEXT_1106 = "->";
  protected final String TEXT_1107 = " = array_values($";
  protected final String TEXT_1108 = "->";
  protected final String TEXT_1109 = ");" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_1110 = "[] = $";
  protected final String TEXT_1111 = ";" + NL + "    $this->";
  protected final String TEXT_1112 = "($";
  protected final String TEXT_1113 = ",$this);" + NL + "    $wasAdded = true;";
  protected final String TEXT_1114 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1115 = "($";
  protected final String TEXT_1116 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1117 = NL + "    if ($this->";
  protected final String TEXT_1118 = "($";
  protected final String TEXT_1119 = ") != -1 && $this->";
  protected final String TEXT_1120 = "() > self::";
  protected final String TEXT_1121 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1122 = "[$this->";
  protected final String TEXT_1123 = "($";
  protected final String TEXT_1124 = ")]);" + NL + "      $this->";
  protected final String TEXT_1125 = " = array_values($this->";
  protected final String TEXT_1126 = ");" + NL + "      $this->";
  protected final String TEXT_1127 = "($";
  protected final String TEXT_1128 = ",null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1129 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1130 = NL + "  public function ";
  protected final String TEXT_1131 = "($";
  protected final String TEXT_1132 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1133 = NL + "    $";
  protected final String TEXT_1134 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1135 = " as $";
  protected final String TEXT_1136 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1137 = ",$";
  protected final String TEXT_1138 = ") !== false)" + NL + "      {";
  protected final String TEXT_1139 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  protected final String TEXT_1140 = "->";
  protected final String TEXT_1141 = "() != null && $this !== $";
  protected final String TEXT_1142 = "->";
  protected final String TEXT_1143 = "())" + NL + "      {";
  protected final String TEXT_1144 = NL + "        return $wasSet;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1145 = "[] = $";
  protected final String TEXT_1146 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1147 = ") != self::";
  protected final String TEXT_1148 = "())" + NL + "    {";
  protected final String TEXT_1149 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    foreach ($this->";
  protected final String TEXT_1150 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  protected final String TEXT_1151 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + "" + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1152 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1153 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1154 = " as $";
  protected final String TEXT_1155 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1156 = "($";
  protected final String TEXT_1157 = ", $this);" + NL + "      $this->";
  protected final String TEXT_1158 = "[] = $";
  protected final String TEXT_1159 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1160 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1161 = NL + "  private function ";
  protected final String TEXT_1162 = "($";
  protected final String TEXT_1163 = ", $";
  protected final String TEXT_1164 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_1165 = "->mentor = $";
  protected final String TEXT_1166 = ";" + NL + "    //$prop = new ReflectionProperty($";
  protected final String TEXT_1167 = ", '";
  protected final String TEXT_1168 = "');" + NL + "    //$prop->setAccessible(true);" + NL + "    //$prop->setValue($";
  protected final String TEXT_1169 = ",$";
  protected final String TEXT_1170 = ");" + NL + "    //$prop->setAccessible(false);" + NL + "  }" + NL;
  protected final String TEXT_1171 = NL + "  public function ";
  protected final String TEXT_1172 = "($";
  protected final String TEXT_1173 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1174 = NL + "    $this->";
  protected final String TEXT_1175 = "[] = $";
  protected final String TEXT_1176 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_1177 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1178 = "($";
  protected final String TEXT_1179 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1180 = NL + "    if ($this->";
  protected final String TEXT_1181 = "($";
  protected final String TEXT_1182 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1183 = "[$this->";
  protected final String TEXT_1184 = "($";
  protected final String TEXT_1185 = ")]);" + NL + "      $this->";
  protected final String TEXT_1186 = " = array_values($this->";
  protected final String TEXT_1187 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1188 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1189 = NL + "  public function ";
  protected final String TEXT_1190 = "($";
  protected final String TEXT_1191 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1192 = NL + "    if ($this->";
  protected final String TEXT_1193 = "() < self::";
  protected final String TEXT_1194 = "())" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1195 = "[] = $";
  protected final String TEXT_1196 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  protected final String TEXT_1197 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1198 = "($";
  protected final String TEXT_1199 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1200 = NL + "    if ($this->";
  protected final String TEXT_1201 = "($";
  protected final String TEXT_1202 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1203 = "[$this->";
  protected final String TEXT_1204 = "($";
  protected final String TEXT_1205 = ")]);" + NL + "      $this->";
  protected final String TEXT_1206 = " = array_values($this->";
  protected final String TEXT_1207 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1208 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1209 = NL + "  public function ";
  protected final String TEXT_1210 = "($";
  protected final String TEXT_1211 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1212 = NL + "    $this->";
  protected final String TEXT_1213 = "[] = $";
  protected final String TEXT_1214 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_1215 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1216 = "($";
  protected final String TEXT_1217 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1218 = NL + "    if ($this->";
  protected final String TEXT_1219 = "($";
  protected final String TEXT_1220 = ") == -1)" + NL + "    {";
  protected final String TEXT_1221 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_1222 = "() <= self::";
  protected final String TEXT_1223 = "())" + NL + "    {";
  protected final String TEXT_1224 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_1225 = "[$this->";
  protected final String TEXT_1226 = "($";
  protected final String TEXT_1227 = ")]);" + NL + "    $this->";
  protected final String TEXT_1228 = " = array_values($this->";
  protected final String TEXT_1229 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_1230 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1231 = NL + "  ";
  protected final String TEXT_1232 = " function ";
  protected final String TEXT_1233 = "($";
  protected final String TEXT_1234 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1235 = NL + "    $";
  protected final String TEXT_1236 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1237 = " as $";
  protected final String TEXT_1238 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1239 = ",$";
  protected final String TEXT_1240 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1241 = "[] = $";
  protected final String TEXT_1242 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1243 = ") != count($";
  protected final String TEXT_1244 = ") || count($";
  protected final String TEXT_1245 = ") != self::";
  protected final String TEXT_1246 = "())" + NL + "    {";
  protected final String TEXT_1247 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1248 = " = $";
  protected final String TEXT_1249 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1250 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1251 = NL + "  ";
  protected final String TEXT_1252 = " function ";
  protected final String TEXT_1253 = "($";
  protected final String TEXT_1254 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1255 = NL + "    $";
  protected final String TEXT_1256 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1257 = " as $";
  protected final String TEXT_1258 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1259 = ",$";
  protected final String TEXT_1260 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1261 = "[] = $";
  protected final String TEXT_1262 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1263 = ") != count($";
  protected final String TEXT_1264 = "))" + NL + "    {";
  protected final String TEXT_1265 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1266 = "->";
  protected final String TEXT_1267 = " = $";
  protected final String TEXT_1268 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1269 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1270 = NL + "  public function ";
  protected final String TEXT_1271 = "($";
  protected final String TEXT_1272 = ")" + NL + "  {" + NL + "    //" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "" + NL + "    $wasSet = false;" + NL + "    " + NL + "    $";
  protected final String TEXT_1273 = " = $this->";
  protected final String TEXT_1274 = ";" + NL + "\t" + NL + "    if ($";
  protected final String TEXT_1275 = " == null)" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1276 = " != null)" + NL + "      {" + NL + "        if ($";
  protected final String TEXT_1277 = "->";
  protected final String TEXT_1278 = "($this))" + NL + "        {" + NL + "          $";
  protected final String TEXT_1279 = " = $";
  protected final String TEXT_1280 = ";" + NL + "          $wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if ($";
  protected final String TEXT_1281 = " != null)" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1282 = " == null)" + NL + "      {" + NL + "        if ($";
  protected final String TEXT_1283 = "->";
  protected final String TEXT_1284 = "() < $";
  protected final String TEXT_1285 = "->";
  protected final String TEXT_1286 = "())" + NL + "        {" + NL + "          $";
  protected final String TEXT_1287 = "->";
  protected final String TEXT_1288 = "($this);" + NL + "          $";
  protected final String TEXT_1289 = " = $";
  protected final String TEXT_1290 = ";  // ";
  protected final String TEXT_1291 = " == null" + NL + "          $wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if ($";
  protected final String TEXT_1292 = "->";
  protected final String TEXT_1293 = "() < $";
  protected final String TEXT_1294 = "->";
  protected final String TEXT_1295 = "())" + NL + "        {" + NL + "          $";
  protected final String TEXT_1296 = "->";
  protected final String TEXT_1297 = "($this);" + NL + "          $";
  protected final String TEXT_1298 = "->";
  protected final String TEXT_1299 = "($this);" + NL + "          $";
  protected final String TEXT_1300 = " = $";
  protected final String TEXT_1301 = ";" + NL + "          $wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if ($wasSet)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1302 = " = $";
  protected final String TEXT_1303 = ";" + NL + "    }" + NL + "    return $wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_1304 = NL + "//  public function ";
  protected final String TEXT_1305 = "($";
  protected final String TEXT_1306 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_1307 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//    $wasSet = false;" + NL + "//" + NL + "//    $";
  protected final String TEXT_1308 = " = $";
  protected final String TEXT_1309 = ";" + NL + "//\t" + NL + "//\tif ($";
  protected final String TEXT_1310 = " == null)" + NL + "//    {" + NL + "//      if ($";
  protected final String TEXT_1311 = " != null)" + NL + "//      {" + NL + "//        if ($";
  protected final String TEXT_1312 = "->";
  protected final String TEXT_1313 = "(this))" + NL + "//        {" + NL + "//          $";
  protected final String TEXT_1314 = " = $";
  protected final String TEXT_1315 = ";" + NL + "//          $wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    } " + NL + "//    else if ($";
  protected final String TEXT_1316 = " != null)" + NL + "//    { " + NL + "//      if ($";
  protected final String TEXT_1317 = " == null)" + NL + "//      {" + NL + "//        if ($";
  protected final String TEXT_1318 = "->";
  protected final String TEXT_1319 = "() < $";
  protected final String TEXT_1320 = "->";
  protected final String TEXT_1321 = "())" + NL + "//        {" + NL + "//          $";
  protected final String TEXT_1322 = "->";
  protected final String TEXT_1323 = "(this);" + NL + "//          $";
  protected final String TEXT_1324 = " = $";
  protected final String TEXT_1325 = ";  // $";
  protected final String TEXT_1326 = " == null" + NL + "//          $wasSet = true;" + NL + "//        }" + NL + "//      } " + NL + "//      else" + NL + "//      {" + NL + "//        if (   $";
  protected final String TEXT_1327 = "->";
  protected final String TEXT_1328 = "() < $";
  protected final String TEXT_1329 = "->";
  protected final String TEXT_1330 = "()" + NL + "//            && $";
  protected final String TEXT_1331 = "->";
  protected final String TEXT_1332 = "() > $";
  protected final String TEXT_1333 = "->";
  protected final String TEXT_1334 = "()" + NL + "//           )" + NL + "//        {" + NL + "//          $";
  protected final String TEXT_1335 = "->";
  protected final String TEXT_1336 = "(this);" + NL + "//          $";
  protected final String TEXT_1337 = "->";
  protected final String TEXT_1338 = "(this);" + NL + "//          $";
  protected final String TEXT_1339 = " = ";
  protected final String TEXT_1340 = ";" + NL + "//          $wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    if ($wasSet)" + NL + "//    {" + NL + "//      $";
  protected final String TEXT_1341 = " = $";
  protected final String TEXT_1342 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return $wasSet;" + NL + "//  }";
  protected final String TEXT_1343 = NL + "  public function ";
  protected final String TEXT_1344 = "($";
  protected final String TEXT_1345 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1346 = NL + "    $";
  protected final String TEXT_1347 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1348 = " as $";
  protected final String TEXT_1349 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1350 = ",$";
  protected final String TEXT_1351 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1352 = "[] = $";
  protected final String TEXT_1353 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1354 = ") != count($";
  protected final String TEXT_1355 = ") || count($";
  protected final String TEXT_1356 = ") < self::";
  protected final String TEXT_1357 = "() || count($";
  protected final String TEXT_1358 = ") > self::";
  protected final String TEXT_1359 = "())" + NL + "    {";
  protected final String TEXT_1360 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1361 = " = $this->";
  protected final String TEXT_1362 = ";" + NL + "    $this->";
  protected final String TEXT_1363 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1364 = " as $";
  protected final String TEXT_1365 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1366 = "[] = $";
  protected final String TEXT_1367 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_1368 = ",$";
  protected final String TEXT_1369 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1370 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_1371 = " = array_values($";
  protected final String TEXT_1372 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1373 = "->";
  protected final String TEXT_1374 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_1375 = " as $";
  protected final String TEXT_1376 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1377 = "->";
  protected final String TEXT_1378 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1379 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1380 = NL + "  public function ";
  protected final String TEXT_1381 = "($";
  protected final String TEXT_1382 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1383 = NL + "    $";
  protected final String TEXT_1384 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1385 = " as $";
  protected final String TEXT_1386 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1387 = ",$";
  protected final String TEXT_1388 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1389 = "[] = $";
  protected final String TEXT_1390 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1391 = ") != count($";
  protected final String TEXT_1392 = ") || count($";
  protected final String TEXT_1393 = ") < self::";
  protected final String TEXT_1394 = "())" + NL + "    {";
  protected final String TEXT_1395 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1396 = " = $this->";
  protected final String TEXT_1397 = ";" + NL + "    $this->";
  protected final String TEXT_1398 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1399 = " as $";
  protected final String TEXT_1400 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1401 = "[] = $";
  protected final String TEXT_1402 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_1403 = ",$";
  protected final String TEXT_1404 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1405 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_1406 = " = array_values($";
  protected final String TEXT_1407 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1408 = "->";
  protected final String TEXT_1409 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_1410 = " as $";
  protected final String TEXT_1411 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1412 = "->";
  protected final String TEXT_1413 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1414 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1415 = NL + "  ";
  protected final String TEXT_1416 = " function ";
  protected final String TEXT_1417 = "($";
  protected final String TEXT_1418 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1419 = NL + "    $";
  protected final String TEXT_1420 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1421 = " as $";
  protected final String TEXT_1422 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1423 = ",$";
  protected final String TEXT_1424 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1425 = "[] = $";
  protected final String TEXT_1426 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1427 = ") != count($";
  protected final String TEXT_1428 = ") || count($";
  protected final String TEXT_1429 = ") < self::";
  protected final String TEXT_1430 = "()  || count($";
  protected final String TEXT_1431 = ") > self::";
  protected final String TEXT_1432 = "())" + NL + "    {";
  protected final String TEXT_1433 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1434 = " = $";
  protected final String TEXT_1435 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1436 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1437 = NL + "  public function ";
  protected final String TEXT_1438 = "($";
  protected final String TEXT_1439 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1440 = NL + "    if (count($";
  protected final String TEXT_1441 = ") < self::";
  protected final String TEXT_1442 = "()";
  protected final String TEXT_1443 = ")" + NL + "    {";
  protected final String TEXT_1444 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1445 = " = array();" + NL + "    $";
  protected final String TEXT_1446 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1447 = " as $";
  protected final String TEXT_1448 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1449 = ",$";
  protected final String TEXT_1450 = ") !== false)" + NL + "      {";
  protected final String TEXT_1451 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  protected final String TEXT_1452 = "->";
  protected final String TEXT_1453 = "() != null && $this !== $";
  protected final String TEXT_1454 = "->";
  protected final String TEXT_1455 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_1456 = " = $";
  protected final String TEXT_1457 = "->";
  protected final String TEXT_1458 = "();" + NL + "        $";
  protected final String TEXT_1459 = " = serialize($";
  protected final String TEXT_1460 = ");" + NL + "        if (!array_key_exists($";
  protected final String TEXT_1461 = ", $";
  protected final String TEXT_1462 = "))" + NL + "        {" + NL + "          $";
  protected final String TEXT_1463 = "[$";
  protected final String TEXT_1464 = "] = $";
  protected final String TEXT_1465 = "->";
  protected final String TEXT_1466 = "();" + NL + "        }" + NL + "        $nextCount = $";
  protected final String TEXT_1467 = "[$";
  protected final String TEXT_1468 = "] - 1;" + NL + "        if ($nextCount < self::minimum";
  protected final String TEXT_1469 = "())" + NL + "        {";
  protected final String TEXT_1470 = NL + "          return $wasSet;" + NL + "        }" + NL + "        $";
  protected final String TEXT_1471 = "[$";
  protected final String TEXT_1472 = "] = $nextCount;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1473 = "[] = $";
  protected final String TEXT_1474 = ";" + NL + "    }" + NL + "" + NL + "    foreach ($this->";
  protected final String TEXT_1475 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  protected final String TEXT_1476 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + "      " + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1477 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1478 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1479 = " as $";
  protected final String TEXT_1480 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1481 = "->";
  protected final String TEXT_1482 = "() != null)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1483 = "->";
  protected final String TEXT_1484 = "()->";
  protected final String TEXT_1485 = "[$";
  protected final String TEXT_1486 = "->";
  protected final String TEXT_1487 = "()->";
  protected final String TEXT_1488 = "($";
  protected final String TEXT_1489 = ")]);" + NL + "        $";
  protected final String TEXT_1490 = "->";
  protected final String TEXT_1491 = "()->";
  protected final String TEXT_1492 = " = array_values($";
  protected final String TEXT_1493 = "->";
  protected final String TEXT_1494 = "()->";
  protected final String TEXT_1495 = ");" + NL + "      }" + NL + "      $this->";
  protected final String TEXT_1496 = "($";
  protected final String TEXT_1497 = ", $this);" + NL + "      $this->";
  protected final String TEXT_1498 = "[] = $";
  protected final String TEXT_1499 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1500 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1501 = NL + "  private function ";
  protected final String TEXT_1502 = "($";
  protected final String TEXT_1503 = ", $";
  protected final String TEXT_1504 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_1505 = "->mentor = $";
  protected final String TEXT_1506 = ";" + NL + "    //$prop = new ReflectionProperty($";
  protected final String TEXT_1507 = ", '";
  protected final String TEXT_1508 = "');" + NL + "    //$prop->setAccessible(true);" + NL + "    //$prop->setValue($";
  protected final String TEXT_1509 = ",$";
  protected final String TEXT_1510 = ");" + NL + "    //$prop->setAccessible(false);" + NL + "  }" + NL;
  protected final String TEXT_1511 = NL + "  ";
  protected final String TEXT_1512 = " function ";
  protected final String TEXT_1513 = "($";
  protected final String TEXT_1514 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1515 = NL + "    $";
  protected final String TEXT_1516 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1517 = " as $";
  protected final String TEXT_1518 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1519 = ",$";
  protected final String TEXT_1520 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1521 = "[] = $";
  protected final String TEXT_1522 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1523 = ") != count($";
  protected final String TEXT_1524 = ") || count($";
  protected final String TEXT_1525 = ") > self::";
  protected final String TEXT_1526 = "())" + NL + "    {";
  protected final String TEXT_1527 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1528 = " = $";
  protected final String TEXT_1529 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1530 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1531 = NL + "  ";
  protected final String TEXT_1532 = " function ";
  protected final String TEXT_1533 = "($";
  protected final String TEXT_1534 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1535 = NL + "    $";
  protected final String TEXT_1536 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1537 = " as $";
  protected final String TEXT_1538 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1539 = ",$";
  protected final String TEXT_1540 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1541 = "[] = $";
  protected final String TEXT_1542 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1543 = ") != count($";
  protected final String TEXT_1544 = ") || count($";
  protected final String TEXT_1545 = ") < self::";
  protected final String TEXT_1546 = "())" + NL + "    {";
  protected final String TEXT_1547 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1548 = " = $";
  protected final String TEXT_1549 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1550 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1551 = NL + "  public function ";
  protected final String TEXT_1552 = "($";
  protected final String TEXT_1553 = ", $index)" + NL + "  {  " + NL + "    $wasAdded = false;" + NL + "    if($this->";
  protected final String TEXT_1554 = "($";
  protected final String TEXT_1555 = "))" + NL + "    {" + NL + "      if($index < 0 ) { $index = 0; }" + NL + "      if($index > $this->";
  protected final String TEXT_1556 = "()) { $index = $this->";
  protected final String TEXT_1557 = "() - 1; }" + NL + "      array_splice($this->";
  protected final String TEXT_1558 = ", $this->";
  protected final String TEXT_1559 = "($";
  protected final String TEXT_1560 = "), 1);" + NL + "      array_splice($this->";
  protected final String TEXT_1561 = ", $index, 0, array($";
  protected final String TEXT_1562 = "));" + NL + "      $wasAdded = true;" + NL + "    }" + NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1563 = "($";
  protected final String TEXT_1564 = ", $index)" + NL + "  {" + NL + "    $wasAdded = false;" + NL + "    if($this->";
  protected final String TEXT_1565 = "($";
  protected final String TEXT_1566 = ") !== -1)" + NL + "    {" + NL + "      if($index < 0 ) { $index = 0; }" + NL + "      if($index > $this->";
  protected final String TEXT_1567 = "()) { $index = $this->";
  protected final String TEXT_1568 = "() - 1; }" + NL + "      array_splice($this->";
  protected final String TEXT_1569 = ", $this->";
  protected final String TEXT_1570 = "($";
  protected final String TEXT_1571 = "), 1);" + NL + "      array_splice($this->";
  protected final String TEXT_1572 = ", $index, 0, array($";
  protected final String TEXT_1573 = "));" + NL + "      $wasAdded = true;" + NL + "    } " + NL + "    else " + NL + "    {" + NL + "      $wasAdded = $this->";
  protected final String TEXT_1574 = "($";
  protected final String TEXT_1575 = ", $index);" + NL + "    }" + NL + "    return $wasAdded;" + NL + "  }" + NL;
  protected final String TEXT_1576 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    if ($compareTo == null) { return false; }" + NL + "    if (get_class($this) != get_class($compareTo)) { return false; }" + NL;
  protected final String TEXT_1577 = NL + "    ";
  protected final String TEXT_1578 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public function hashCode()" + NL + "  {" + NL + "    if ($this->cachedHashCode != -1)" + NL + "    {" + NL + "      return $this->cachedHashCode;" + NL + "    }" + NL + "    $this->cachedHashCode = 17;";
  protected final String TEXT_1579 = NL + "    ";
  protected final String TEXT_1580 = NL;
  protected final String TEXT_1581 = NL + "    ";
  protected final String TEXT_1582 = NL + "    return $this->cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1583 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    return $this == $compareTo;" + NL + "  }" + NL;
  protected final String TEXT_1584 = NL + "    $this->";
  protected final String TEXT_1585 = " = null;";
  protected final String TEXT_1586 = NL + "    $this->";
  protected final String TEXT_1587 = " = array();";
  protected final String TEXT_1588 = NL + "    $";
  protected final String TEXT_1589 = " = $this->";
  protected final String TEXT_1590 = ";" + NL + "    $this->";
  protected final String TEXT_1591 = " = null;" + NL + "    if ($";
  protected final String TEXT_1592 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1593 = "->delete();" + NL + "    }";
  protected final String TEXT_1594 = NL + "    if ($this->";
  protected final String TEXT_1595 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1596 = "->";
  protected final String TEXT_1597 = "(null);" + NL + "    }";
  protected final String TEXT_1598 = NL + "    $";
  protected final String TEXT_1599 = " = $this->";
  protected final String TEXT_1600 = ";" + NL + "    $this->";
  protected final String TEXT_1601 = " = null;" + NL + "    if ($";
  protected final String TEXT_1602 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1603 = "->";
  protected final String TEXT_1604 = "(null);" + NL + "    }";
  protected final String TEXT_1605 = NL + "    $";
  protected final String TEXT_1606 = " = $this->";
  protected final String TEXT_1607 = ";" + NL + "    $this->";
  protected final String TEXT_1608 = " = null;" + NL + "    if ($";
  protected final String TEXT_1609 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1610 = "->delete();" + NL + "    }";
  protected final String TEXT_1611 = NL + "    if ($this->";
  protected final String TEXT_1612 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1613 = "->";
  protected final String TEXT_1614 = "($this);" + NL + "    }";
  protected final String TEXT_1615 = NL + "    if ($this->";
  protected final String TEXT_1616 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1617 = "->delete();" + NL + "    }";
  protected final String TEXT_1618 = NL + "    if ($this->";
  protected final String TEXT_1619 = " != null)" + NL + "    {" + NL + "      if ($this->";
  protected final String TEXT_1620 = "->";
  protected final String TEXT_1621 = "() <= ";
  protected final String TEXT_1622 = ")" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1623 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1624 = "->";
  protected final String TEXT_1625 = "($this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1626 = NL + "    $";
  protected final String TEXT_1627 = " = $this->";
  protected final String TEXT_1628 = ";" + NL + "    $this->";
  protected final String TEXT_1629 = " = null;" + NL + "    $";
  protected final String TEXT_1630 = "->";
  protected final String TEXT_1631 = "($this);";
  protected final String TEXT_1632 = NL + "    foreach ($this->";
  protected final String TEXT_1633 = " as $";
  protected final String TEXT_1634 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1635 = "($";
  protected final String TEXT_1636 = ",null);" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_1637 = " = array();";
  protected final String TEXT_1638 = NL + "    $";
  protected final String TEXT_1639 = " = $this->";
  protected final String TEXT_1640 = ";" + NL + "    $this->";
  protected final String TEXT_1641 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1642 = " as $";
  protected final String TEXT_1643 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1644 = "->";
  protected final String TEXT_1645 = "() <= ";
  protected final String TEXT_1646 = "::";
  protected final String TEXT_1647 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_1648 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1649 = "->";
  protected final String TEXT_1650 = "($this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1651 = NL + "    $";
  protected final String TEXT_1652 = " = $this->";
  protected final String TEXT_1653 = ";" + NL + "    $this->";
  protected final String TEXT_1654 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1655 = " as $";
  protected final String TEXT_1656 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1657 = "->";
  protected final String TEXT_1658 = "($this);" + NL + "    }";
  protected final String TEXT_1659 = NL + "    foreach ($this->";
  protected final String TEXT_1660 = " as $";
  protected final String TEXT_1661 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1662 = "->delete();" + NL + "    }";
  protected final String TEXT_1663 = NL + "    foreach ($this->";
  protected final String TEXT_1664 = " as $";
  protected final String TEXT_1665 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1666 = "->";
  protected final String TEXT_1667 = "(null);" + NL + "    }";
  protected final String TEXT_1668 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1669 = NL + "  ";
  protected final String TEXT_1670 = NL + "}" + NL + "?>";

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
    
  UmpleClass uClass = (UmpleClass) uElement;
  GeneratedClass gClass = uClass.getGeneratedClass();
  PhpGenerator gen = new PhpGenerator();
  GeneratorHelper.generator = gen;
  gen.setModel(model);

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


    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).getIsInline()) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(stringBuffer, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    stringBuffer.append(TEXT_3);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append( gen.translate("isA",uClass) );
    stringBuffer.append(TEXT_4);
    
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
      append(stringBuffer, "  public static ${0} = {1};", av.getName(), gen.translate("parameterValue",av));
    }
    else if (av.getIsAutounique())
    {
      String defaultValue = av.getValue() == null ? "1" : av.getValue();
      appendln(stringBuffer, "");
      append(stringBuffer, "  private static $next{0} = {1};", av.getUpperCaseName(), defaultValue);
    }
    else if (av.getIsUnique())
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  private static ${0} = array();", gen.translate("uniqueMap", av));
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
      isFirst = false;
    }
    appendln(stringBuffer, "");
    append(stringBuffer, "  private static $theInstance = null;");
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
    
    String attribute = gen.translate("attributeOne",av);
    if (av.getIsList())
    {
      attribute = gen.translate("attributeMany",av);
    }

    appendln(stringBuffer, "");
    
    if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); }
    
    append(stringBuffer, "  private ${0};", attribute);
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
    String lookup = av.getIsList() ? "attributeMany" : "attributeOne";
    append(stringBuffer, "  private ${0};", gen.translate(lookup,av));
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
    else
    {
      appendln(stringBuffer,"");
    }
  
    int stateCounter = 0;
    for(State state : sm.getStates())
    {
      if (stateCounter >= 0)
      {
        appendln(stringBuffer,"");
      }
      stateCounter += 1;
      append(stringBuffer, "  private static ${0} = {1};", gen.translate("stateOne",state), stateCounter);
    }

    for (StateMachine nestedSm : allNested)
    {
      for(State state : nestedSm.getStates())
      {
        if (stateCounter >= 0)
        {
          appendln(stringBuffer,"");
        }
        stateCounter += 1;
        append(stringBuffer, "  private static ${0} = {1};", gen.translate("stateOne",state), stateCounter);
      }
    }
    
    append(stringBuffer, "\n  private ${0};", gen.translate("stateMachineOne", sm));
    for (StateMachine nestedSm : allNested)
    {
      append(stringBuffer, "\n  private ${0};", gen.translate("stateMachineOne", nestedSm));
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
      append(stringBuffer, "\n  private ${0} = null;", gen.translate("doActivityThread",state));
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
    String lookup = av.isOne() ? "associationOne" : "associationMany";
    
    if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Association Javadoc", av.getComments())); }
    
    if (av.isOptionalOne() && av.getRelatedAssociation().isMandatory() && !av.isImmutable())
    {
      append(stringBuffer, "  public ${0}; //until PHP 5.3 (setAccessible)", gen.translate(lookup,av));
    }
    else
    {
      append(stringBuffer, "  private ${0};", gen.translate(lookup,av));
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
    append(stringBuffer, "  private $cachedHashCode;");
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
      append(stringBuffer, "  private ${0};", gen.translate("attributeCanSet",av));
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
      append(stringBuffer, "  private ${0};", gen.translate("associationCanSet",av));
    }
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null  && !av.isImmutable())
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  private ${0};", gen.translate("attributeCanSet",av));
    }
    else if (as != null)
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  private ${0};", gen.translate("associationCanSet",as));
    }
  }
}

    stringBuffer.append(TEXT_5);
    
  boolean isOneToOne = false;
  String instanceIdentifier = "this";
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

  String constructorLookup = isOneToOne ? "constructorSignature_nulled" : "constructorSignature";
  String accessibility = uClass.getIsSingleton() ? "private" : "public";
  append(stringBuffer,"  {0} function __construct({1})",accessibility, gClass.getLookup(constructorLookup));

  appendln(stringBuffer, "");
  
  boolean hasBody = false;
  
  append(stringBuffer, "  {");
  
  if (isOneToOne)
  {
    appendln(stringBuffer,"");
    appendln(stringBuffer,"    if (func_num_args() == 0) { return; }");
  }
  
  if (!uClass.isRoot() && !"interface".equals(uClass.getExtendsClass().getModifier()))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    parent::__construct({0});", gClass.getParentClass().getLookup("constructorSignature_caller"));
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
    append(stringBuffer, "    $this->cachedHashCode = -1;");
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null  && !av.isImmutable())
    {
      hasBody = true;
      appendln(stringBuffer, "");
      append(stringBuffer, "    $this->{0} = true;", gen.translate("attributeCanSet",av));
    }
    else if (as != null)
    {
      hasBody = true;
      appendln(stringBuffer, "");
      append(stringBuffer, "    $this->{0} = true;", gen.translate("associationCanSet",as));
    }
  }
  
  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique() || av.getIsUnique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)) || av.getIsDerived())
    {
      continue;
    }
    
    if (av.getIsList())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_6);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_8);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_10);
     
    }
    else if (av.isImmutable() && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_11);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_12);
    
    }
    else if (av.isImmutable())
    {
      hasBody = true;
      
    
  String parameterValue = "";
  if (av.getValue() == null)
  {
    parameterValue = "$" + gen.translate("parameterOne",av);
  }
  else
  {
    parameterValue = gen.translate("parameterValue",av);
  }

    stringBuffer.append(TEXT_13);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(parameterValue);
    stringBuffer.append(TEXT_15);
     
    }
    else
    {
      hasBody = true;
      if(!av.getIsLazy()){
         
    
  String assignValue = av.getValue() == null || av.getModifier().equals("fixml") ? "$" + gen.translate("parameterOne",av) : gen.translate("parameterValue",av);

    stringBuffer.append(TEXT_16);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(assignValue);
    stringBuffer.append(TEXT_19);
    
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
     else if(av.getType().equals("Double") || av.getType().equals("Float") || av.getType().equals("Integer"))
     {
  	   defaultValue = "0";
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
    stringBuffer.append(TEXT_20);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_23);
    } 
    
      }
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_24);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_27);
    
    }
    else if (av.getIsUnique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_28);
    stringBuffer.append(gen.translate("setMethod", av));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(av.getName());
    stringBuffer.append(TEXT_31);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
  	if (!av.getIsNavigable() || !av.isImmutable())
  	{
  	  continue;
  	}
    append(stringBuffer, "\n    ${0}->{1} = true;", instanceIdentifier, gen.translate("associationCanSet",av));
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
        
    stringBuffer.append(TEXT_32);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_37);
    
      }
      else if (av.isOptionalOne() && av.isImmutable())
      {
        hasBody = true;
        
       
    append(stringBuffer, "\n    ${0}->{1}(${2});", instanceIdentifier, gen.translate("setMethod",av), gen.translate("parameterOne",av));

    
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
  

    stringBuffer.append(TEXT_38);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_48);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        hasBody = true;
        
     String requiredNumber = StringFormatter.format("{0}", av.getMultiplicity().getUpperBound()); 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_59);
    
      }
      else if (av.isMany() && av.isImmutable())
      {
      	hasBody = true;
        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_69);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_70);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_72);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_81);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_82);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_84);
    
    }
    else if (av.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(instanceIdentifier);
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
    else
    {
      
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOptionalMany())
  {
    appendln(stringBuffer,"");
    append(stringBuffer, "    $this->{0} = array();", gen.translate("associationMany",av));
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
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(instanceIdentifier);
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
    
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.translate("associationMany",av));
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
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_110);
    
    }
    
    stringBuffer.append(TEXT_111);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_113);
    
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

  //=========== fixml attribute (create empty constructor)
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
		  append(stringBuffer,"\n\n  {0} function __construct()",accessibility);
		  appendln(stringBuffer, "");
		  append(stringBuffer, "  {\n");
		  for (Attribute a : uClass.getAttributes())
			  if ("fixml".equals(a.getModifier()) && a.getValue() != null )
				  append(stringBuffer, "    $this->{0} = {1};\n", a.getName(),a.getValue());
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
	  append(stringBuffer,"\n\n  {0} function __construct()",accessibility);
	  appendln(stringBuffer, "");
	  append(stringBuffer, "  {\n");
	  for( CodeInjection ci  : uClass.getCodeInjections())
		  if( ci.getOperation().equals("emptyConstructor"))
			  appendln(stringBuffer,"    {0}",ci.getCode());
	  appendln(stringBuffer,"  }");
  }
  
  if (uClass.getIsSingleton())
  {
    appendln(stringBuffer, "");
    
    stringBuffer.append(TEXT_114);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_115);
    
  }

    
  if (isOneToOne)
  {
    instanceIdentifier = "thisInstance";
    
    
  String signature = gClass.getLookup("constructorSignature_mandatory");

    stringBuffer.append(TEXT_116);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_119);
    
  if (!uClass.isRoot())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    ${0}->__construct({1});", instanceIdentifier , gClass.getParentClass().getLookup("constructorSignature_caller"));
  }
  
  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)))
    {
      continue;
    }
  
    if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_120);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_122);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_123);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_124);
     
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
  	   defaultValue = "NULL";
     }
     else if(av.getType().equals("Double") || av.getType().equals("Float") || av.getType().equals("Integer"))
     {
  	   defaultValue = "0";
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
    stringBuffer.append(TEXT_125);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_128);
    } 
    
    }
    else
    {
      
    
  String assignValue = av.getValue() == null || av.getModifier().equals("fixml") ? "$" + gen.translate("parameterOne",av) : gen.translate("parameterValue",av);

    stringBuffer.append(TEXT_129);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(assignValue);
    stringBuffer.append(TEXT_132);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_133);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_136);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_137);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    stringBuffer.append(TEXT_141);
    
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
    append(stringBuffer, "    $this->{0} = array();", gen.translate("associationMany",av));
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
  

    stringBuffer.append(TEXT_142);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_152);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_156);
    
  } 
  else
  {
    continue;
  }
  hasBody = true;

    
    }
  }
  
  appendln(stringBuffer, "");
  appendln(stringBuffer, "    return ${0};",instanceIdentifier);
  append(stringBuffer, "  }");
  
  if (!uClass.isRoot())
  {
    
    stringBuffer.append(TEXT_157);
    stringBuffer.append( gClass.getParentClass().getLookup("constructorSignature") );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( gClass.getParentClass().getLookup("constructorSignature_caller") );
    stringBuffer.append(TEXT_159);
    
  }

    
  }


    stringBuffer.append(TEXT_160);
    
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
        
    stringBuffer.append(TEXT_161);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_163);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_164);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_167);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_168);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_169);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_171);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_172);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_174);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_175);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_176);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_179);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_180);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_181);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_183);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_186);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_187);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_189);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_190);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_195);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_196);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_199);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems )
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,"$"+gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_202);
     for( TraceItem traceItem : traceItems )
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
    stringBuffer.append(TEXT_203);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_204);
    
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
          
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_207);
     if (customSetPrefixCode != null) { 
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_210);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
     if (customSetPostfixCode != null) {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_211);
    
        }
        else if (av.getIsList())
        {
          
    stringBuffer.append(TEXT_212);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_214);
     if (customAddPrefixCode != null) {
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_a", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_217);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_a", uClass):""));
     if (customAddPostfixCode != null) { 
      append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customAddPostfixCode, "    "));
    } 
    stringBuffer.append(TEXT_218);
    
        }
        else if(!av.isImmutable()||av.getIsLazy())//if(customSetPrefixCode!=null&&customSetPostfixCode!=null&&customSetPrefixCode.matches("[\\s]*if.*\\n[\\s]*.*"))
        {
          
    stringBuffer.append(TEXT_219);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_221);
     if (customSetPrefixCode != null) {
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    stringBuffer.append(TEXT_222);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_224);
     for( TraceItem traceItem : traceItems ) 
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
     if (customSetPostfixCode != null) {
      append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_225);
    
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
      
    stringBuffer.append(TEXT_226);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_227);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_230);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_233);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_236);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_239);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_241);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_242);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_243);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_244);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_245);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_248);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_251);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_252);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_253);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_254);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_256);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_257);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_258);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_259);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_261);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_262);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_263);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_265);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_266);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_268);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_269);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_270);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_272);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_274);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_276);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_277);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_278);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_279);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_281);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_283);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_284);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_285);
    
      }
      
      if (av.getIsUnique())
      {
        if (customGetUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_286);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_288);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("getUniqueMap",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_292);
     for( TraceItem traceItem : traceItems )
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):"")
);
     if (customGetUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_294);
    
        } 
        else 
        {
          
    stringBuffer.append(TEXT_295);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_297);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems )
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(gen.translate("getUniqueMap",av));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_300);
    
        }
        if (customHasUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_303);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.translate("getUniqueMap",av));
    stringBuffer.append(TEXT_307);
     for( TraceItem traceItem : traceItems )
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):"")
);
     if (customHasUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_308);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_309);
    
        }
        else
        {
          
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_312);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
     for( TraceItem traceItem : traceItems )
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(gen.translate("getUniqueMap",av));
    stringBuffer.append(TEXT_315);
    
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
        
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_317);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_318);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_320);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_321);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_322);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_323);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_324);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_326);
    
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
      
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_328);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_329);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_330);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_331);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_332);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_333);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_334);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_335);
    
    }
    else if (av.getIsDerived())
    {
      
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_337);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_338);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_339);
    stringBuffer.append(gen.translate("parameterValue",av));
    stringBuffer.append(TEXT_340);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_342);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_343);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_344);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_345);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_346);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_347);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_348);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_350);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_352);
    
    }
      
    appendln(stringBuffer, "");
  }
  gen.setParameterConstraintName("");

    
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
      output.append(StringFormatter.format("\n    if ($this->{0} != self::${2}) { $answer .= \".\" . $this->{1}(); }",gen.translate("stateMachineOne",childSm),gen.translate("getMethod",childSm),gen.translate("stateNull",childSm)));
      allParents.addAll(childSm.getNestedStateMachines());
    }     
  }
  String outputAsString = output.toString();

    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_355);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_356);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    
  StringBuffer allCases = new StringBuffer();
{
  isFirst = true;
  for(State state : sm.getStates())
  {
    if (isFirst)
    {
      allCases.append(StringFormatter.format("if ($this->{0} == self::${1}) { return {2}; }\n",gen.translate("stateMachineOne",sm), gen.translate("stateOne",state), gen.translate("stateString",state)));
    }
    else
    {
      allCases.append(StringFormatter.format("    elseif ($this->{0} == self::${1}) { return {2}; }\n",gen.translate("stateMachineOne",sm), gen.translate("stateOne",state), gen.translate("stateString",state)));
    }
    isFirst = false;
  }
}
  String outputCases = allCases.toString().trim();

    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_358);
     if (outputCases.length() > 0) { append(stringBuffer, "\n    {0}",outputCases); } 
    stringBuffer.append(TEXT_359);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for(Event e : uClass.getEvents())
  {
    
    
  StringBuffer allCases = new StringBuffer();
  StringBuffer allDeclarations = new StringBuffer();

  boolean firstStateMachine = true;
  for(StateMachine sm : uClass.getStateMachines(e))
  {
    for( TraceDirective tc : uClass.getTraceDirectives() )
  	{
  		for( int i = 0 ; i < tc.numberOfStateMachineTraceItems() ; ++ i )
  		{
  			if( tc.getStateMachineTraceItem(i).getStateMachine() == sm )
  			{
  				if( model.getTraceType().equals("Console"))
  				{
  					allCases.append(StringFormatter.format("\n    print(\"Event={0}\");\n    ",gen.translate("eventMethod",e)));
  				}
  				else if( model.getTraceType().equals("File"))
  				{
  					allCases.append(StringFormatter.format("\n    fileTracer(\"Event={0}\");\n    ",gen.translate("eventMethod",e)));
  				}
  			}
  		}
  	}
  	allDeclarations.append(StringFormatter.format("\n    ${0} = $this->{1};",gen.translate("parameterOne",sm),gen.translate("stateMachineOne", sm)));
  	
    boolean first = true;
    if (!firstStateMachine)
    {
      allCases.append("\n\n    ");
    }

    for(State state : sm.getStates())
    {
  
      List<Transition> allT = state.getTransitionsFor(e);
      
      if (allT.size() == 0)
      {
        continue;
      }
      
      if (first)
      {
        allCases.append(StringFormatter.format("\n    if (${0} == self::${1})\n",gen.translate("parameterOne",sm),gen.translate("stateOne",state)));
      }
      else
      {
        allCases.append(StringFormatter.format("\n    elseif (${0} == self::${1})\n",gen.translate("parameterOne",sm),gen.translate("stateOne",state)));
      }
      allCases.append(StringFormatter.format("    {\n"));
  
      boolean needsBreak = true;
      for (Transition t : allT)
      {
        State nextState = t.getNextState();
        String spaceOffset = t.getGuard() == null ? "" : "  ";
        StateMachine exitSm = state.exitableStateMachine(nextState);
        String condition = t.getGuard()!=null?gen.translate("Open",t.getGuard()):"if ()\n{";        
        if (!"if ()\n{".equals(condition))
        {
          allCases.append(GeneratorHelper.doIndent(condition, "      ")+"\n");
        }
        if (exitSm != null && !e.getIsInternal() && !state.isSameState(nextState,exitSm)) 
        {
          allCases.append(StringFormatter.format("{0}      $this->{1}();\n",spaceOffset,gen.translate("exitMethod",exitSm)));
        }
        if (t.getAction() != null)
        {
          Action a1= t.getAction();
          allCases.append(StringFormatter.format("{0}      {1}\n",spaceOffset,a1.getActionCode()));
        }
  
        allCases.append(StringFormatter.format("{0}      $this->{1}(self::${2});\n",spaceOffset,gen.translate("setMethod",nextState.getStateMachine()),gen.translate("stateOne",nextState)));
        allCases.append(StringFormatter.format("{0}      $wasEventProcessed = true;\n",spaceOffset));
  
        if (!"if ()\n{".equals(condition))
        {
          allCases.append(StringFormatter.format("      }\n"));
        }
      }
      allCases.append(StringFormatter.format("    }"));
      first = false;
    }
    firstStateMachine = false;
  }
  String scope = e.getIsInternal() || e.isAutoTransition() ? "private" : "public";
  String eventOutput = allDeclarations.toString() + allCases.toString();

    stringBuffer.append(TEXT_360);
    stringBuffer.append( scope );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_362);
    stringBuffer.append( (e.getArgs()==null?"":e.getArgs()));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(TEXT_364);
    stringBuffer.append( eventOutput );
    stringBuffer.append(TEXT_365);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    
  
  StringBuffer allCases = new StringBuffer();
  StringBuffer allExitCases = new StringBuffer();
  StringBuffer allEnterCases = new StringBuffer();
  boolean hasExit = sm.getHasExitAction();
  boolean hasEntry = sm.getHasEntryAction();

  for (State state : sm.getStates())
  {
    if (state.getIsStartState())
    {
      allCases.append(StringFormatter.format("if"));
    }
    else
    {
      allCases.append(StringFormatter.format("    elseif"));
    }
    allCases.append(StringFormatter.format(" (${0} == \"{1}\" || ${0} == self::${1})\n",gen.translate("parameterOne",sm),gen.translate("stateOne",state)));
    allCases.append(StringFormatter.format("    {\n"));
    allCases.append(StringFormatter.format("      $this->{0} = self::${1};\n",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
    allCases.append(StringFormatter.format("      return true;\n"));
    allCases.append(StringFormatter.format("    }\n"));

    if (hasExit)
    {
      allExitCases.append(StringFormatter.format("    if ($this->{0} == self::${1} && (${2} != self::${1} && ${2} != \"{1}\") ) { $this->{3}(); }\n"
        , gen.translate("stateMachineOne",sm)
        , gen.translate("stateOne",state)
        , gen.translate("parameterOne",sm)
        , gen.translate("exitMethod",state)
      ));
    }

    if (hasEntry)
    {
      allEnterCases.append(StringFormatter.format("    if ($this->{0} != self::${1} && (${2} == self::${1} || ${2} == \"{1}\") ) { $this->{3}(); }\n"
        , gen.translate("stateMachineOne",sm)
        , gen.translate("stateOne",state)
        , gen.translate("parameterOne",sm)
        , gen.translate("enterMethod",state)
      ));
    }

  }
  String outputCases = allCases.toString().trim();
  String exitCasesOutput = allExitCases.toString().trim();
  String enterCasesOutput = allEnterCases.toString().trim();


    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_367);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_368);
     if (!exitCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",exitCasesOutput); } 
     if (!enterCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",enterCasesOutput); } 
    stringBuffer.append(TEXT_369);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_370);
    
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
          if (isFirstEntry)
          {
            entryActions.append(StringFormatter.format("if ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
            for( TraceDirective tc : uClass.getTraceDirectives() )
          	{
                for( int i = 0 ; i < tc.numberOfStateMachineTraceItems() ; ++ i )
                {
              	  StateMachineTraceItem tracedState = tc.getStateMachineTraceItem(i);
          		  StateMachine stm = tracedState.getStateMachine();
          		  for( int j = 0 ; j < stm.numberOfStates() ; ++j )
          		  {
          		  	State stat = stm.getState(j);
          		  	String statName =  stm.getName() + stat.getName();
          		  	if( tracedState.getEntry() )
          			  if( statName.equalsIgnoreCase(gen.translate("stateOne",state)))
              			if( model.getTraceType().equals("Console"))
          					entryActions.append(StringFormatter.format( "\n      " + "print(\"Tracing state {0} entry action(s)\");",gen.translate("stateOne",state)));
           				else if( model.getTraceType().equals("File"))
           					entryActions.append(StringFormatter.format( "\n      " + "fileTracer(\"Tracing state {0} entry action(s)\");",gen.translate("stateOne",state))); 
           		  }
          	  }
          	}
          }
          else
          {
            entryActions.append("\n    ");
            entryActions.append(StringFormatter.format("elseif ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
          }
        }
        hasEntry = true;
        hasThisEntry = true;
        isFirstEntry = false;
        entryActions.append("\n      " + action.getActionCode());
      }
      else if ("exit".equals(action.getActionType()))
      {
        if (!hasThisExit)
        {
          if (isFirstExit)
          {
            exitActions.append(StringFormatter.format("if ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
            for( TraceDirective tc : uClass.getTraceDirectives() )
        	{
              for( int i = 0 ; i < tc.numberOfStateMachineTraceItems() ; ++ i )
              {
            	  StateMachineTraceItem tracedState = tc.getStateMachineTraceItem(i);
        		  StateMachine stm = tracedState.getStateMachine();
        		  for( int j = 0 ; j < stm.numberOfStates() ; ++j )
        		  {
        		  	State stat = stm.getState(j);
        		  	String statName =  stm.getName() + stat.getName();
        		  	if( tracedState.getExit() )
        			  if( statName.equalsIgnoreCase(gen.translate("stateOne",state)))
            			if( model.getTraceType().equals("Console"))
            				exitActions.append(StringFormatter.format( "\n      " + "print(\"Tracing state {0} exit action(s)\");",gen.translate("stateOne",state)));
         				else if( model.getTraceType().equals("File"))
         					exitActions.append(StringFormatter.format( "\n      " + "fileTracer(\"Tracing state {0} exit action(s)\");",gen.translate("stateOne",state))); 
         		  }
        	  }
        	}
          }
          else
          {
            exitActions.append("\n    ");
            exitActions.append(StringFormatter.format("elseif ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
          }
          isFirstExit = false;
        }
        hasExit = true;
        hasThisExit = true;
        isFirstExit = false;
        exitActions.append("\n      " + action.getActionCode());
      }
    }
  
    if (state.getActivity() != null)
    {
      if (!hasThisEntry)
      {
        if (isFirstEntry)
        {
          entryActions.append(StringFormatter.format("if ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
        }
        else
        {
          entryActions.append("\n    ");
          entryActions.append(StringFormatter.format("elseif ($this->{0} == self::${1})\n    {",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
        }
      }
      hasEntry = true;
      hasThisEntry = true;
      isFirstEntry = false;
      entryActions.append(StringFormatter.format("\n      {0}",state.getActivity().getActivityCode()));
    }
    
    if (hasThisEntry)
    {
      entryActions.append("\n    }");
    }
    
    if (hasThisExit)
    {
      exitActions.append("\n    }");
    }
  }

     if (hasExit) { 
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_372);
     if (customExitPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_373);
    stringBuffer.append( exitActions );
     if (customExitPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_374);
     } 
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_376);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_377);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_378);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_379);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_380);
     if (parentState != null) { 
    stringBuffer.append(TEXT_381);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_382);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_383);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_384);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_386);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_387);
     } 
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_388);
    stringBuffer.append(TEXT_389);
    stringBuffer.append( entryActions );
     } 
    stringBuffer.append(TEXT_390);
    
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
      
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_392);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_393);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_394);
     } else { 
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_397);
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_399);
     } 
    stringBuffer.append(TEXT_400);
     
  if(av.getMultiplicity().getLowerBound() == 0) {
  
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("hasMethod",av));
    stringBuffer.append(TEXT_402);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_403);
     } 
    stringBuffer.append(TEXT_404);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_406);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_409);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_410);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_412);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_415);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_418);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_420);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_422);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_424);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_427);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_432);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_433);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_434);
    
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
      
    stringBuffer.append(TEXT_435);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_436);
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
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_450);
     } else { 
    stringBuffer.append(TEXT_451);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_452);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_453);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_454);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_455);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_456);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_458);
     } else { 
    stringBuffer.append(TEXT_459);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_460);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_461);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_462);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_463);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_466);
     } else { 
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_468);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_469);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_470);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_471);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_472);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_474);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_477);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_478);
     } 
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_486);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_487);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_490);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_493);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_506);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_507);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_508);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_511);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_514);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_515);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_516);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_519);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_523);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_524);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_527);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_535);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_549);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_550);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_551);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_553);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_558);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_566);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_576);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_577);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_584);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_600);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_603);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_608);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_613);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_619);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_620);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_629);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_632);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
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
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_643);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_649);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_652);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_657);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_662);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_663);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_668);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_669);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_678);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_679);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_681);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_693);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_696);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_706);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_707);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_710);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_722);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_741);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_742);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_749);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_761);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_764);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_774);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_775);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_778);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_788);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_804);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_805);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_808);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_811);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_814);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_827);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_828);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_831);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_834);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_837);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_850);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_851);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_854);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_860);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_873);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_874);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_877);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_879);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_891);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_892);
    
    }
    else if (includeFile == "association_SetOneToManyAssociationClass.jet")
    {
      
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_895);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_897);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_911);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_912);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_915);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_919);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_926);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_938);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_941);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_942);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_945);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_949);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_955);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_967);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_970);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_971);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_974);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_989);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_992);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1004);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1005);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1008);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1023);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1024);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1027);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1030);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1045);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1048);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1058);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1059);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1062);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1067);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1070);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1073);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1076);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1082);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1083);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1086);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1089);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1090);
     } 
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1098);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1113);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1116);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1128);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1129);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1132);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1138);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1143);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1148);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1159);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1170);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1173);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1176);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1179);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1187);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1188);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1191);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1196);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1199);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1207);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1208);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1211);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1214);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1217);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1220);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1223);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1229);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1230);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1231);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1234);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1246);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1249);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1250);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1251);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1254);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1264);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1268);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1269);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1303);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1342);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1345);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1359);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1378);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1379);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1382);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1394);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1413);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1414);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1415);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1418);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1432);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1435);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1436);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || count(${0}) > self::{1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1439);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1443);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1450);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1469);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1499);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1503);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1510);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1511);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1514);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("parameterOne",av));
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
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1526);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1529);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1530);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1531);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1534);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1537);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1546);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1549);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1550);
    
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
      
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1558);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1575);
    
    }
  }
  gen.setParameterConstraintName("");

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
      String attributeLabel = av.getIsList() ? "attributeMany" : "attributeOne";
      canSet.append(StringFormatter.format("    $this->{0} = false;\n",gen.translate("attributeCanSet",av)));
      checks.append(StringFormatter.format("    if ($this->{0} != $compareTo->{0})\n",gen.translate(attributeLabel,av)));
      checks.append(StringFormatter.format("    {\n"));
      checks.append(StringFormatter.format("      return false;\n"));
      checks.append(StringFormatter.format("    }\n"));
      checks.append("\n");
    }
    else if (as != null)
    {
      String associationLabel = as.isMany() ? "associationMany" : "associationOne";
      canSet.append(StringFormatter.format("    $this->{0} = false;\n",gen.translate("associationCanSet",as)));
      checks.append(StringFormatter.format("    if ($this->{0} != $compareTo->{0})\n",gen.translate(associationLabel,as)));
      checks.append(StringFormatter.format("    {\n"));
      checks.append(StringFormatter.format("      return false;\n"));
      checks.append(StringFormatter.format("    }\n"));
      checks.append("\n");
    }
    
    if (av != null)
    {
      if (("Integer".equals(av.getType()) || "Double".equals(av.getType())) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->{0};\n",gen.translate("attributeOne",av)));
      }
      else if ("Boolean".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    $this->cachedHashCode = $this->cachedHashCode * 23 + ($this->{0} ? 1 : 0);\n",gen.translate("attributeOne",av)));
      }
      else
      {
        String attributeType = av.getIsList() ? "attributeMany" : "attributeOne";
        hash.append(StringFormatter.format("    if ($this->{0} != null)\n",gen.translate(attributeType,av)));
        hash.append(StringFormatter.format("    {\n"));
        hash.append(StringFormatter.format("      $this->cachedHashCode = $this->cachedHashCode * 23 + spl_object_hash($this->{0});\n",gen.translate(attributeType,av)));
        hash.append(StringFormatter.format("    }\n"));
        hash.append(StringFormatter.format("    else\n"));
        hash.append(StringFormatter.format("    {\n"));
        hash.append(StringFormatter.format("      $this->cachedHashCode = $this->cachedHashCode * 23;\n"));
        hash.append(StringFormatter.format("    }\n"));
      }
      hash.append("\n");
    }
    else if (as != null)
    {
      String attributeType = as.isOne() ? "attributeOne" : "attributeMany";
      hash.append(StringFormatter.format("    if ($this->{0} != null)\n",gen.translate(attributeType,as)));
      hash.append(StringFormatter.format("    {\n"));
      hash.append(StringFormatter.format("      $this->cachedHashCode = $this->cachedHashCode * 23 + spl_object_hash($this->{0});\n",gen.translate(attributeType,as)));
      hash.append(StringFormatter.format("    }\n"));
      hash.append(StringFormatter.format("    else\n"));
      hash.append(StringFormatter.format("    {\n"));
      hash.append(StringFormatter.format("      $this->cachedHashCode = $this->cachedHashCode * 23;\n"));
      hash.append(StringFormatter.format("    }\n"));
    }
  }


    stringBuffer.append(TEXT_1576);
    stringBuffer.append(TEXT_1577);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(TEXT_1579);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(TEXT_1581);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1582);
     } else { 
    stringBuffer.append(TEXT_1583);
     } 
    

  appendln(stringBuffer,"");
  appendln(stringBuffer,"  public function delete()");
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
        
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1585);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1587);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1593);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1597);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1599);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1604);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1610);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1612);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1614);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1617);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1625);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1629);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1631);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1632);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1633);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1634);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1637);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1650);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1658);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1662);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1666);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1667);
    
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
    append(stringBuffer, "    parent::delete();");
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
    	    if(!aMethod.getExistsInLanguage("Php"))
    		  continue;
    		String methodModifier = aMethod.getModifier().equals("") ? "public" : aMethod.getModifier();
    		String methodImplementationModifier = aMethod.getIsAbstract() ? " abstract" : "";
    		String methodName = aMethod.getName();
    		String methodType = "function";
    		String customPreconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Precondition"));String customPostconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Postcondition"));
            customPostconditionCode = customPostconditionCode==null?"":customPostconditionCode;
        
    		String methodBody = aMethod.getIsImplemented() ? "      return \"\";" : aMethod.getMethodBody().getExtraCode();    		
    		
    		/*String methodBody = "";
    		if (aMethod.getMethodBody() != null && aMethod.getMethodBody().getExtraCode() != null)
    		{
    			methodBody = aMethod.getMethodBody().getExtraCode();
    		}*/
    		
    		String properMethodBody = "    " + methodBody; 
    		//String override =  aMethod.getIsImplemented() ? "  @Override" : "";
    		String paramName="";
    		String paramType="";
    		String aSingleParameter="";
    		String finalParams = "";
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
    			
    			finalParams = parameters.substring(0, parameters.length()-2);
        }
        
				appendln(stringBuffer, "");
				if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("Method Javadoc",aMethod.getComments())); }
				
  			//appendln(stringBuffer,override);
  			append(stringBuffer, "  {0}{1} {2} {3}({4})", methodModifier, methodImplementationModifier, methodType, methodName, finalParams);
  	  if(!"".equals(customPostconditionCode))
      {
        appendln(stringBuffer, "\n  {");
        if(!"".equals(aMethod.getType())&&!"void".equals(aMethod.getType())){
          append(stringBuffer, "    $result = {0}Original({1});\n", methodName, finalParams);
        }
        else {
          append(stringBuffer, "    $this->{0}Original({1});\n", methodName, finalParams);
        }
        appendln(stringBuffer, GeneratorHelper.doIndent(customPostconditionCode, "    "));
        if(!"".equals(aMethod.getType())&&!"void".equals(aMethod.getType())){
          append(stringBuffer, "    return $result;\n");
        }          
        appendln(stringBuffer, "  }");
        append(stringBuffer, "\n  {0}{1} {2} {3}Original({4})", methodModifier, methodImplementationModifier, methodType, methodName, finalParams);
      }    
        if(aMethod.getIsAbstract())
  			{
  			  append(stringBuffer, ";");
  			}
  			else
  			{
    			appendln(stringBuffer, "\n  {");
    			if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
    			appendln(stringBuffer, properMethodBody);
    			appendln(stringBuffer, "  }");
  			}
    	}
    }

     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(uClass.getExtraCode());
     } 
    

{

	//==== Tracing Code    
    if( model.getTraceType().equals("File") && uClass.hasTraceDirectives() )
	{
		appendln(stringBuffer, "");
		appendln(stringBuffer, "  //------------------------");
		appendln(stringBuffer, "  // FILE TRACER METHOD");
		appendln(stringBuffer, "  //------------------------\n");
		appendln(stringBuffer, "  function fileTracer($tracedItem)");
		appendln(stringBuffer, "  {");
		appendln(stringBuffer, "    $file=fopen({0}TraceLog.txt{1},{3}a{4}) or exit({5}Unable to open file!{6});",'"','"','"','"','"','"','"');
		appendln(stringBuffer, "    fprintf($file,{0}Traced object value: $tracedItem{1}.PHP_EOL);",'"','"');
		appendln(stringBuffer, "    fprintf($file,{0}Trace time: {1}.date(DATE_RFC822).PHP_EOL);",'"','"');
		appendln(stringBuffer, "    fclose($file);");
		appendln(stringBuffer, "  }");
	}
}


    stringBuffer.append(TEXT_1670);
    return stringBuffer.toString();
  }
}