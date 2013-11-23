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
  protected final String TEXT_2 = NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/" + NL;
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
  protected final String TEXT_15 = ";" + NL + "    $this->";
  protected final String TEXT_16 = " = false;";
  protected final String TEXT_17 = NL + "    $";
  protected final String TEXT_18 = "->";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "    $";
  protected final String TEXT_22 = "->";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "    $";
  protected final String TEXT_26 = "->";
  protected final String TEXT_27 = " = self::$";
  protected final String TEXT_28 = "++;";
  protected final String TEXT_29 = NL + "    if (!$this->";
  protected final String TEXT_30 = "($";
  protected final String TEXT_31 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Cannot create due to duplicate ";
  protected final String TEXT_32 = "\");" + NL + "    }";
  protected final String TEXT_33 = NL + "    if (!$";
  protected final String TEXT_34 = "->";
  protected final String TEXT_35 = "($";
  protected final String TEXT_36 = "))" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_37 = " due to ";
  protected final String TEXT_38 = "\");" + NL + "    }";
  protected final String TEXT_39 = NL + "    $";
  protected final String TEXT_40 = "->";
  protected final String TEXT_41 = " = array();" + NL + "    $";
  protected final String TEXT_42 = " = $";
  protected final String TEXT_43 = "->";
  protected final String TEXT_44 = "($";
  protected final String TEXT_45 = ");" + NL + "    if (!$";
  protected final String TEXT_46 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_47 = ", must have ";
  protected final String TEXT_48 = " ";
  protected final String TEXT_49 = "\");" + NL + "    }";
  protected final String TEXT_50 = NL + "    $";
  protected final String TEXT_51 = "->";
  protected final String TEXT_52 = " = array();" + NL + "    $";
  protected final String TEXT_53 = " = $";
  protected final String TEXT_54 = "->";
  protected final String TEXT_55 = "($";
  protected final String TEXT_56 = ");" + NL + "    if (!$";
  protected final String TEXT_57 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_58 = ", must have ";
  protected final String TEXT_59 = " or fewer ";
  protected final String TEXT_60 = ", no duplicates.\");" + NL + "    }";
  protected final String TEXT_61 = NL + "    $";
  protected final String TEXT_62 = "->";
  protected final String TEXT_63 = " = array();" + NL + "    $";
  protected final String TEXT_64 = " = $";
  protected final String TEXT_65 = "->";
  protected final String TEXT_66 = "($";
  protected final String TEXT_67 = ");" + NL + "    if (!$";
  protected final String TEXT_68 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_69 = ", must not have duplicate ";
  protected final String TEXT_70 = ".\");" + NL + "    }";
  protected final String TEXT_71 = NL + "    $";
  protected final String TEXT_72 = "->";
  protected final String TEXT_73 = " = array();";
  protected final String TEXT_74 = NL + "    if ($";
  protected final String TEXT_75 = " == null || $";
  protected final String TEXT_76 = "->";
  protected final String TEXT_77 = "() != null)" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_78 = " due to ";
  protected final String TEXT_79 = "\");" + NL + "    }" + NL + "    $";
  protected final String TEXT_80 = "->";
  protected final String TEXT_81 = " = $";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = NL + "    $";
  protected final String TEXT_84 = "->";
  protected final String TEXT_85 = " = array();";
  protected final String TEXT_86 = NL + "    $";
  protected final String TEXT_87 = " = $";
  protected final String TEXT_88 = "->";
  protected final String TEXT_89 = "($";
  protected final String TEXT_90 = ");" + NL + "    if (!$";
  protected final String TEXT_91 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_92 = " due to ";
  protected final String TEXT_93 = "\");" + NL + "    }";
  protected final String TEXT_94 = NL + "    $";
  protected final String TEXT_95 = "->";
  protected final String TEXT_96 = " = array();" + NL + "    $";
  protected final String TEXT_97 = " = $";
  protected final String TEXT_98 = "->";
  protected final String TEXT_99 = "($";
  protected final String TEXT_100 = ");" + NL + "    if (!$";
  protected final String TEXT_101 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_102 = ", must have ";
  protected final String TEXT_103 = " ";
  protected final String TEXT_104 = "\");" + NL + "    }";
  protected final String TEXT_105 = "$this->";
  protected final String TEXT_106 = " = array();" + NL + "    $this->";
  protected final String TEXT_107 = "[] = $";
  protected final String TEXT_108 = ";";
  protected final String TEXT_109 = NL + "    $this->";
  protected final String TEXT_110 = "(self::$";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "    $this->";
  protected final String TEXT_113 = "(self::$";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "  public static function getInstance()" + NL + "  {" + NL + "    if(self::$theInstance == null)" + NL + "    {" + NL + "      self::$theInstance = new ";
  protected final String TEXT_116 = "();" + NL + "    }" + NL + "    return self::$theInstance;" + NL + "  }";
  protected final String TEXT_117 = NL + "  public static function newInstance(";
  protected final String TEXT_118 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_119 = " = new ";
  protected final String TEXT_120 = "();";
  protected final String TEXT_121 = NL + "    $";
  protected final String TEXT_122 = "->";
  protected final String TEXT_123 = " = array();";
  protected final String TEXT_124 = NL + "    $this->";
  protected final String TEXT_125 = "();";
  protected final String TEXT_126 = NL + "    $";
  protected final String TEXT_127 = "->";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = ";";
  protected final String TEXT_130 = NL + "    $";
  protected final String TEXT_131 = "->";
  protected final String TEXT_132 = " = ";
  protected final String TEXT_133 = ";";
  protected final String TEXT_134 = NL + "    $";
  protected final String TEXT_135 = "->";
  protected final String TEXT_136 = " = self::$";
  protected final String TEXT_137 = "++;";
  protected final String TEXT_138 = NL + "    $";
  protected final String TEXT_139 = "->";
  protected final String TEXT_140 = " = new ";
  protected final String TEXT_141 = "(";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL + "    $";
  protected final String TEXT_144 = "->";
  protected final String TEXT_145 = " = array();" + NL + "    $";
  protected final String TEXT_146 = " = $";
  protected final String TEXT_147 = "->";
  protected final String TEXT_148 = "($";
  protected final String TEXT_149 = ");" + NL + "    if (!$";
  protected final String TEXT_150 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_151 = ", must have ";
  protected final String TEXT_152 = " ";
  protected final String TEXT_153 = "\");" + NL + "    }";
  protected final String TEXT_154 = "$this->";
  protected final String TEXT_155 = " = array();" + NL + "    $this->";
  protected final String TEXT_156 = "[] = $";
  protected final String TEXT_157 = ";";
  protected final String TEXT_158 = NL + "  private function callParentConstructor(";
  protected final String TEXT_159 = ")" + NL + "  {" + NL + "    parent::__construct(";
  protected final String TEXT_160 = ");" + NL + "  }" + NL;
  protected final String TEXT_161 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_162 = NL + "  public function ";
  protected final String TEXT_163 = "($";
  protected final String TEXT_164 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_165 = NL + "    $this->";
  protected final String TEXT_166 = " = false;" + NL + "    $this->";
  protected final String TEXT_167 = " = $";
  protected final String TEXT_168 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_169 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_170 = NL + "  public function ";
  protected final String TEXT_171 = "($";
  protected final String TEXT_172 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_173 = NL + "    $this->";
  protected final String TEXT_174 = " = $";
  protected final String TEXT_175 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_176 = NL + "    return $wasSet;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_177 = "()" + NL + "  {" + NL + "    $wasReset = false;";
  protected final String TEXT_178 = NL + "    $this->";
  protected final String TEXT_179 = " = $this->";
  protected final String TEXT_180 = "();" + NL + "    $wasReset = true;";
  protected final String TEXT_181 = NL + "    return $wasReset;" + NL + "  }" + NL;
  protected final String TEXT_182 = NL + "  public function ";
  protected final String TEXT_183 = "($";
  protected final String TEXT_184 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_185 = NL + "    $this->";
  protected final String TEXT_186 = "[] = $";
  protected final String TEXT_187 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_188 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_189 = "($";
  protected final String TEXT_190 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_191 = NL + "    unset($this->";
  protected final String TEXT_192 = "[$this->";
  protected final String TEXT_193 = "($";
  protected final String TEXT_194 = ")]);" + NL + "    $this->";
  protected final String TEXT_195 = " = array_values($this->";
  protected final String TEXT_196 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_197 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_198 = NL + "  public function ";
  protected final String TEXT_199 = "($";
  protected final String TEXT_200 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_201 = NL;
  protected final String TEXT_202 = "    $this->";
  protected final String TEXT_203 = " = $";
  protected final String TEXT_204 = ";";
  protected final String TEXT_205 = NL;
  protected final String TEXT_206 = "    $wasSet = true;";
  protected final String TEXT_207 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_208 = NL + "  public function ";
  protected final String TEXT_209 = "($index)" + NL + "  {";
  protected final String TEXT_210 = NL + "    $";
  protected final String TEXT_211 = " = $this->";
  protected final String TEXT_212 = "[$index];";
  protected final String TEXT_213 = NL + "    return $";
  protected final String TEXT_214 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_215 = "()" + NL + "  {";
  protected final String TEXT_216 = NL + "    $";
  protected final String TEXT_217 = " = $this->";
  protected final String TEXT_218 = ";";
  protected final String TEXT_219 = NL + "    return $";
  protected final String TEXT_220 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_221 = "()" + NL + "  {";
  protected final String TEXT_222 = NL + "    $number = count($this->";
  protected final String TEXT_223 = ");";
  protected final String TEXT_224 = NL + "    return $number;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_225 = "()" + NL + "  {";
  protected final String TEXT_226 = NL + "    $has = ";
  protected final String TEXT_227 = ".size() > 0;";
  protected final String TEXT_228 = NL + "    return $has;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_229 = "($";
  protected final String TEXT_230 = ")" + NL + "  {";
  protected final String TEXT_231 = NL + "    $rawAnswer = array_search($";
  protected final String TEXT_232 = ",$this->";
  protected final String TEXT_233 = ");" + NL + "    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;";
  protected final String TEXT_234 = NL + "    return $index;" + NL + "  }" + NL;
  protected final String TEXT_235 = NL + "  public function ";
  protected final String TEXT_236 = "()" + NL + "  {";
  protected final String TEXT_237 = NL + "    $";
  protected final String TEXT_238 = " = ";
  protected final String TEXT_239 = ";";
  protected final String TEXT_240 = NL + "    return $";
  protected final String TEXT_241 = ";" + NL + "  }";
  protected final String TEXT_242 = NL + "  public function ";
  protected final String TEXT_243 = "()" + NL + "  {";
  protected final String TEXT_244 = NL + "    return ";
  protected final String TEXT_245 = ";" + NL + "  }";
  protected final String TEXT_246 = NL + "  public function ";
  protected final String TEXT_247 = "()" + NL + "  {";
  protected final String TEXT_248 = NL + "    $";
  protected final String TEXT_249 = " = $this->";
  protected final String TEXT_250 = ";";
  protected final String TEXT_251 = NL + "    return $";
  protected final String TEXT_252 = ";" + NL + "  }";
  protected final String TEXT_253 = NL + "  public function ";
  protected final String TEXT_254 = "()" + NL + "  {";
  protected final String TEXT_255 = NL + "    return $this->";
  protected final String TEXT_256 = ";" + NL + "  }";
  protected final String TEXT_257 = NL + "  public function ";
  protected final String TEXT_258 = "()" + NL + "  {";
  protected final String TEXT_259 = NL + "    $";
  protected final String TEXT_260 = " = ";
  protected final String TEXT_261 = ";";
  protected final String TEXT_262 = NL + "    return $";
  protected final String TEXT_263 = ";" + NL + "  }" + NL;
  protected final String TEXT_264 = NL + "  public function ";
  protected final String TEXT_265 = "()" + NL + "  {";
  protected final String TEXT_266 = NL + "    return ";
  protected final String TEXT_267 = ";" + NL + "  }" + NL;
  protected final String TEXT_268 = NL + "  public static function ";
  protected final String TEXT_269 = "($";
  protected final String TEXT_270 = ")" + NL + "  {";
  protected final String TEXT_271 = NL + "    $";
  protected final String TEXT_272 = " = ";
  protected final String TEXT_273 = "[(string)$";
  protected final String TEXT_274 = "];";
  protected final String TEXT_275 = NL;
  protected final String TEXT_276 = "    return $";
  protected final String TEXT_277 = ";" + NL + "  }" + NL;
  protected final String TEXT_278 = NL + "  public static function ";
  protected final String TEXT_279 = "($";
  protected final String TEXT_280 = ")" + NL + "  {";
  protected final String TEXT_281 = NL;
  protected final String TEXT_282 = "    return ";
  protected final String TEXT_283 = "[(string)$";
  protected final String TEXT_284 = "];" + NL + "  }" + NL;
  protected final String TEXT_285 = NL + "  public static function ";
  protected final String TEXT_286 = "($";
  protected final String TEXT_287 = ")" + NL + "  {";
  protected final String TEXT_288 = NL + "    $";
  protected final String TEXT_289 = " = array_key_exists((string)$";
  protected final String TEXT_290 = ", ";
  protected final String TEXT_291 = ");";
  protected final String TEXT_292 = NL;
  protected final String TEXT_293 = "    return $";
  protected final String TEXT_294 = ";" + NL + "  }" + NL;
  protected final String TEXT_295 = NL + "  public static function ";
  protected final String TEXT_296 = "($";
  protected final String TEXT_297 = ")" + NL + "  {";
  protected final String TEXT_298 = NL;
  protected final String TEXT_299 = "    return array_key_exists((string)$";
  protected final String TEXT_300 = ", ";
  protected final String TEXT_301 = ");" + NL + "  }" + NL;
  protected final String TEXT_302 = NL + "  public function ";
  protected final String TEXT_303 = "()" + NL + "  {";
  protected final String TEXT_304 = NL + "    $";
  protected final String TEXT_305 = " = $this->";
  protected final String TEXT_306 = ";";
  protected final String TEXT_307 = NL + "    return $";
  protected final String TEXT_308 = ";" + NL + "  }";
  protected final String TEXT_309 = NL + "  public function ";
  protected final String TEXT_310 = "()" + NL + "  {";
  protected final String TEXT_311 = NL + "    return $this->";
  protected final String TEXT_312 = ";" + NL + "  }";
  protected final String TEXT_313 = NL + "  public ";
  protected final String TEXT_314 = " ";
  protected final String TEXT_315 = "()" + NL + "  {";
  protected final String TEXT_316 = NL + "    ";
  protected final String TEXT_317 = " ";
  protected final String TEXT_318 = " = ";
  protected final String TEXT_319 = ";";
  protected final String TEXT_320 = NL + "    return ";
  protected final String TEXT_321 = ";" + NL + "  }";
  protected final String TEXT_322 = NL + "  public ";
  protected final String TEXT_323 = " ";
  protected final String TEXT_324 = "()" + NL + "  {";
  protected final String TEXT_325 = NL + "    return ";
  protected final String TEXT_326 = ";" + NL + "  }";
  protected final String TEXT_327 = NL + "  public ";
  protected final String TEXT_328 = " ";
  protected final String TEXT_329 = "()" + NL + "  {";
  protected final String TEXT_330 = NL + "    $";
  protected final String TEXT_331 = " = $this->";
  protected final String TEXT_332 = ";";
  protected final String TEXT_333 = NL + "    return $";
  protected final String TEXT_334 = ";" + NL + "  }";
  protected final String TEXT_335 = NL + "  public function ";
  protected final String TEXT_336 = "()" + NL + "  {";
  protected final String TEXT_337 = NL + "    return $this->";
  protected final String TEXT_338 = ";" + NL + "  }";
  protected final String TEXT_339 = NL + "  public function ";
  protected final String TEXT_340 = "()" + NL + "  {" + NL + "    $answer = $this->";
  protected final String TEXT_341 = "();";
  protected final String TEXT_342 = NL + "    return $answer;" + NL + "  }" + NL;
  protected final String TEXT_343 = NL + "  public function ";
  protected final String TEXT_344 = "()" + NL + "  {";
  protected final String TEXT_345 = NL + "    return null;" + NL + "  }" + NL;
  protected final String TEXT_346 = NL + "  ";
  protected final String TEXT_347 = " function ";
  protected final String TEXT_348 = "(";
  protected final String TEXT_349 = ")" + NL + "  {" + NL + "    $wasEventProcessed = false;";
  protected final String TEXT_350 = NL + "    ";
  protected final String TEXT_351 = NL + "    return $wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_352 = NL + "  public function ";
  protected final String TEXT_353 = "($";
  protected final String TEXT_354 = ")" + NL + "  {";
  protected final String TEXT_355 = NL + "    ";
  protected final String TEXT_356 = NL + "    else" + NL + "    {" + NL + "      return false;" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_357 = NL + "  private function ";
  protected final String TEXT_358 = "()" + NL + "  {";
  protected final String TEXT_359 = NL + "    ";
  protected final String TEXT_360 = NL + "  }" + NL;
  protected final String TEXT_361 = NL + "  private function ";
  protected final String TEXT_362 = "($";
  protected final String TEXT_363 = ")" + NL + "  {";
  protected final String TEXT_364 = NL + "    $this->";
  protected final String TEXT_365 = " = $";
  protected final String TEXT_366 = ";";
  protected final String TEXT_367 = NL + "    if ($this->";
  protected final String TEXT_368 = " != self::$";
  protected final String TEXT_369 = " && $";
  protected final String TEXT_370 = " != self::$";
  protected final String TEXT_371 = ") { $this->";
  protected final String TEXT_372 = "(self::$";
  protected final String TEXT_373 = "); }";
  protected final String TEXT_374 = NL + NL + "    // entry actions and do activities";
  protected final String TEXT_375 = NL + "    ";
  protected final String TEXT_376 = NL + "  }" + NL;
  protected final String TEXT_377 = NL + "  public function ";
  protected final String TEXT_378 = "()" + NL + "  {";
  protected final String TEXT_379 = NL + "    return $this->";
  protected final String TEXT_380 = ";";
  protected final String TEXT_381 = NL + "    $";
  protected final String TEXT_382 = " = $this->";
  protected final String TEXT_383 = ";";
  protected final String TEXT_384 = NL + "    return $";
  protected final String TEXT_385 = ";";
  protected final String TEXT_386 = NL + "  }" + NL;
  protected final String TEXT_387 = NL + "  public function ";
  protected final String TEXT_388 = "($index)" + NL + "  {";
  protected final String TEXT_389 = NL + "    $";
  protected final String TEXT_390 = " = $this->";
  protected final String TEXT_391 = "[$index];";
  protected final String TEXT_392 = NL + "    return $";
  protected final String TEXT_393 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_394 = "()" + NL + "  {";
  protected final String TEXT_395 = NL + "    $";
  protected final String TEXT_396 = " = $this->";
  protected final String TEXT_397 = ";";
  protected final String TEXT_398 = NL + "    return $";
  protected final String TEXT_399 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_400 = "()" + NL + "  {";
  protected final String TEXT_401 = NL + "    $number = count($this->";
  protected final String TEXT_402 = ");";
  protected final String TEXT_403 = NL + "    return $number;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_404 = "()" + NL + "  {";
  protected final String TEXT_405 = NL + "    $has = $this->";
  protected final String TEXT_406 = "() > 0;";
  protected final String TEXT_407 = NL + "    return $has;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_408 = "($";
  protected final String TEXT_409 = ")" + NL + "  {";
  protected final String TEXT_410 = NL + "    $wasFound = false;" + NL + "    $index = 0;" + NL + "    foreach($this->";
  protected final String TEXT_411 = " as $";
  protected final String TEXT_412 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_413 = "->equals($";
  protected final String TEXT_414 = "))" + NL + "      {" + NL + "        $wasFound = true;" + NL + "        break;" + NL + "      }" + NL + "      $index += 1;" + NL + "    }" + NL + "    $index = $wasFound ? $index : -1;";
  protected final String TEXT_415 = NL + "    return $index;" + NL + "  }" + NL;
  protected final String TEXT_416 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_417 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_418 = " : ";
  protected final String TEXT_419 = NL + "  public function ";
  protected final String TEXT_420 = "()" + NL + "  {";
  protected final String TEXT_421 = NL + "    $isValid = $this->";
  protected final String TEXT_422 = "() >= self::";
  protected final String TEXT_423 = "();";
  protected final String TEXT_424 = NL + "    $isValid = $this->";
  protected final String TEXT_425 = "() >= self::";
  protected final String TEXT_426 = "() && $this->";
  protected final String TEXT_427 = "() <= self::";
  protected final String TEXT_428 = "();";
  protected final String TEXT_429 = NL + "    return $isValid;" + NL + "  }";
  protected final String TEXT_430 = NL + "  public static function ";
  protected final String TEXT_431 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_432 = ";" + NL + "  }";
  protected final String TEXT_433 = NL + "  public static function ";
  protected final String TEXT_434 = "()" + NL + "  {";
  protected final String TEXT_435 = NL + "    $minimum = ";
  protected final String TEXT_436 = ";";
  protected final String TEXT_437 = NL + "    return $minimum;" + NL + "  }";
  protected final String TEXT_438 = NL + "  public static function ";
  protected final String TEXT_439 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_440 = ";" + NL + "  }";
  protected final String TEXT_441 = NL + "  public static function ";
  protected final String TEXT_442 = "()" + NL + "  {";
  protected final String TEXT_443 = NL + "    $minimum = ";
  protected final String TEXT_444 = ";";
  protected final String TEXT_445 = NL + "    return $minimum;" + NL + "  }";
  protected final String TEXT_446 = NL + "  public static function ";
  protected final String TEXT_447 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_448 = ";" + NL + "  }";
  protected final String TEXT_449 = NL + "  public static function ";
  protected final String TEXT_450 = "()" + NL + "  {";
  protected final String TEXT_451 = NL + "    $maximum = ";
  protected final String TEXT_452 = ";";
  protected final String TEXT_453 = NL + "    return $maximum;" + NL + "  }";
  protected final String TEXT_454 = NL + "  public function ";
  protected final String TEXT_455 = "($";
  protected final String TEXT_456 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_457 = NL + "    if ($this->";
  protected final String TEXT_458 = "() >= self::";
  protected final String TEXT_459 = "())" + NL + "    {";
  protected final String TEXT_460 = NL + "      return $wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_461 = NL + "    $this->";
  protected final String TEXT_462 = "[] = $";
  protected final String TEXT_463 = ";" + NL + "    if ($";
  protected final String TEXT_464 = "->";
  protected final String TEXT_465 = "($this) != -1)" + NL + "    {" + NL + "      $wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasAdded = $";
  protected final String TEXT_466 = "->";
  protected final String TEXT_467 = "($this);" + NL + "      if (!$wasAdded)" + NL + "      {" + NL + "        array_pop($this->";
  protected final String TEXT_468 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_469 = NL + "    return $wasAdded;" + NL + "  }";
  protected final String TEXT_470 = NL + "  public function ";
  protected final String TEXT_471 = "($";
  protected final String TEXT_472 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_473 = NL + "    if ($this->";
  protected final String TEXT_474 = "($";
  protected final String TEXT_475 = ") == -1)" + NL + "    {";
  protected final String TEXT_476 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_477 = "($";
  protected final String TEXT_478 = ");" + NL + "    unset($this->";
  protected final String TEXT_479 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_480 = "->";
  protected final String TEXT_481 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_482 = "->";
  protected final String TEXT_483 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_484 = "[$oldIndex] = $";
  protected final String TEXT_485 = ";" + NL + "        ksort($this->";
  protected final String TEXT_486 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_487 = " = array_values($this->";
  protected final String TEXT_488 = ");";
  protected final String TEXT_489 = NL + "    return $wasRemoved;" + NL + "  }";
  protected final String TEXT_490 = NL + "  ";
  protected final String TEXT_491 = " function ";
  protected final String TEXT_492 = "($";
  protected final String TEXT_493 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_494 = NL + "    $this->";
  protected final String TEXT_495 = " = $";
  protected final String TEXT_496 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_497 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_498 = NL + "  ";
  protected final String TEXT_499 = " function ";
  protected final String TEXT_500 = "($";
  protected final String TEXT_501 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_502 = NL + "    if ($";
  protected final String TEXT_503 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_504 = " = $";
  protected final String TEXT_505 = ";" + NL + "      $wasSet = true;" + NL + "    }";
  protected final String TEXT_506 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_507 = NL + "  public function ";
  protected final String TEXT_508 = "($";
  protected final String TEXT_509 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_510 = NL + "    if ($this->";
  protected final String TEXT_511 = " != null && $this->";
  protected final String TEXT_512 = " != $";
  protected final String TEXT_513 = " && $this == $this->";
  protected final String TEXT_514 = "->";
  protected final String TEXT_515 = "())" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_516 = ", as existing ";
  protected final String TEXT_517 = " would become an orphan";
  protected final String TEXT_518 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $this->";
  protected final String TEXT_519 = " = $";
  protected final String TEXT_520 = ";" + NL + "    $";
  protected final String TEXT_521 = " = $";
  protected final String TEXT_522 = " != null ? $";
  protected final String TEXT_523 = "->";
  protected final String TEXT_524 = "() : null;" + NL + "    " + NL + "    if ($this != $";
  protected final String TEXT_525 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_526 = " != null)" + NL + "      {" + NL + "        $";
  protected final String TEXT_527 = "->";
  protected final String TEXT_528 = " = null;" + NL + "      }" + NL + "      if ($this->";
  protected final String TEXT_529 = " != null)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_530 = "->";
  protected final String TEXT_531 = "($this);" + NL + "      }" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_532 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_533 = NL + "  public function ";
  protected final String TEXT_534 = "($";
  protected final String TEXT_535 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_536 = NL + "    if ($";
  protected final String TEXT_537 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_538 = " to null, as ";
  protected final String TEXT_539 = " must always be associated to a ";
  protected final String TEXT_540 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_541 = " = $";
  protected final String TEXT_542 = "->";
  protected final String TEXT_543 = "();" + NL + "    if ($";
  protected final String TEXT_544 = " != null && $this != $";
  protected final String TEXT_545 = ")" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_546 = ", the current ";
  protected final String TEXT_547 = " already has a ";
  protected final String TEXT_548 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_549 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_550 = " = $this->";
  protected final String TEXT_551 = ";" + NL + "    $this->";
  protected final String TEXT_552 = " = $";
  protected final String TEXT_553 = ";" + NL + "    $this->";
  protected final String TEXT_554 = "->";
  protected final String TEXT_555 = "($this);" + NL + "    " + NL + "    if ($";
  protected final String TEXT_556 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_557 = "->";
  protected final String TEXT_558 = "(null);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_559 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_560 = NL + "  public function ";
  protected final String TEXT_561 = "(";
  protected final String TEXT_562 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_563 = "(";
  protected final String TEXT_564 = ");" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_565 = "($";
  protected final String TEXT_566 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_567 = NL + "    $";
  protected final String TEXT_568 = " = $";
  protected final String TEXT_569 = "->";
  protected final String TEXT_570 = "();" + NL + "    $";
  protected final String TEXT_571 = " = $";
  protected final String TEXT_572 = " != null && $this !== $";
  protected final String TEXT_573 = ";" + NL + "" + NL + "    if ($";
  protected final String TEXT_574 = " && $";
  protected final String TEXT_575 = "->";
  protected final String TEXT_576 = "() <= self::";
  protected final String TEXT_577 = "())" + NL + "    {" + NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    if ($";
  protected final String TEXT_578 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_579 = "->";
  protected final String TEXT_580 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_581 = "[] = $";
  protected final String TEXT_582 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_583 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_584 = "($";
  protected final String TEXT_585 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_586 = NL + "    //Unable to remove ";
  protected final String TEXT_587 = ", as it must always have a ";
  protected final String TEXT_588 = NL + "    if ($this === $";
  protected final String TEXT_589 = "->";
  protected final String TEXT_590 = "())" + NL + "    {";
  protected final String TEXT_591 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_592 = " already at minimum (";
  protected final String TEXT_593 = ")" + NL + "    if ($this->";
  protected final String TEXT_594 = "() <= self::";
  protected final String TEXT_595 = "())" + NL + "    {";
  protected final String TEXT_596 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_597 = "[$this->";
  protected final String TEXT_598 = "($";
  protected final String TEXT_599 = ")]);" + NL + "    $this->";
  protected final String TEXT_600 = " = array_values($this->";
  protected final String TEXT_601 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_602 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_603 = NL + "  public function ";
  protected final String TEXT_604 = "(";
  protected final String TEXT_605 = ")" + NL + "  {" + NL + "    if ($this->";
  protected final String TEXT_606 = "() >= self::";
  protected final String TEXT_607 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_608 = "(";
  protected final String TEXT_609 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_610 = "($";
  protected final String TEXT_611 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_612 = NL + "    if ($this->";
  protected final String TEXT_613 = "() >= self::";
  protected final String TEXT_614 = "())" + NL + "    {";
  protected final String TEXT_615 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_616 = " = $";
  protected final String TEXT_617 = "->";
  protected final String TEXT_618 = "();" + NL + "    $";
  protected final String TEXT_619 = " = $";
  protected final String TEXT_620 = " != null && $this !== $";
  protected final String TEXT_621 = ";" + NL + "" + NL + "    if ($";
  protected final String TEXT_622 = " && $";
  protected final String TEXT_623 = "->";
  protected final String TEXT_624 = "() <= self::";
  protected final String TEXT_625 = "())" + NL + "    {";
  protected final String TEXT_626 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    if ($";
  protected final String TEXT_627 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_628 = "->";
  protected final String TEXT_629 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_630 = "[] = $";
  protected final String TEXT_631 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_632 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_633 = "($";
  protected final String TEXT_634 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_635 = NL + "    //Unable to remove ";
  protected final String TEXT_636 = ", as it must always have a ";
  protected final String TEXT_637 = NL + "    if ($this === $";
  protected final String TEXT_638 = "->";
  protected final String TEXT_639 = "())" + NL + "    {";
  protected final String TEXT_640 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_641 = " already at minimum (";
  protected final String TEXT_642 = ")" + NL + "    if ($this->";
  protected final String TEXT_643 = "() <= self::";
  protected final String TEXT_644 = "())" + NL + "    {";
  protected final String TEXT_645 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_646 = "[$this->";
  protected final String TEXT_647 = "($";
  protected final String TEXT_648 = ")]);" + NL + "    $this->";
  protected final String TEXT_649 = " = array_values($this->";
  protected final String TEXT_650 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_651 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_652 = NL + "  public function ";
  protected final String TEXT_653 = "(";
  protected final String TEXT_654 = ")" + NL + "  {" + NL + "    if ($this->";
  protected final String TEXT_655 = "() >= self::";
  protected final String TEXT_656 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_657 = "(";
  protected final String TEXT_658 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_659 = "($";
  protected final String TEXT_660 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_661 = NL + "    if ($this->";
  protected final String TEXT_662 = "() >= self::";
  protected final String TEXT_663 = "())" + NL + "    {";
  protected final String TEXT_664 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_665 = " = $";
  protected final String TEXT_666 = "->";
  protected final String TEXT_667 = "();" + NL + "    $";
  protected final String TEXT_668 = " = $";
  protected final String TEXT_669 = " != null && $this !== $";
  protected final String TEXT_670 = ";" + NL + "    if ($";
  protected final String TEXT_671 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_672 = "->";
  protected final String TEXT_673 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_674 = "[] = $";
  protected final String TEXT_675 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_676 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_677 = "($";
  protected final String TEXT_678 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_679 = NL + "    //Unable to remove ";
  protected final String TEXT_680 = ", as it must always have a ";
  protected final String TEXT_681 = NL + "    if ($this !== $";
  protected final String TEXT_682 = "->";
  protected final String TEXT_683 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_684 = "[$this->";
  protected final String TEXT_685 = "($";
  protected final String TEXT_686 = ")]);" + NL + "      $this->";
  protected final String TEXT_687 = " = array_values($this->";
  protected final String TEXT_688 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_689 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_690 = NL + "  public function ";
  protected final String TEXT_691 = "($";
  protected final String TEXT_692 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_693 = NL + "    $";
  protected final String TEXT_694 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_695 = " as $";
  protected final String TEXT_696 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_697 = ",$";
  protected final String TEXT_698 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_699 = "[] = $";
  protected final String TEXT_700 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_701 = ") != count($";
  protected final String TEXT_702 = ") || count($";
  protected final String TEXT_703 = ") > self::";
  protected final String TEXT_704 = "())" + NL + "    {";
  protected final String TEXT_705 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_706 = " = $this->";
  protected final String TEXT_707 = ";" + NL + "    $this->";
  protected final String TEXT_708 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_709 = " as $";
  protected final String TEXT_710 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_711 = "[] = $";
  protected final String TEXT_712 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_713 = ",$";
  protected final String TEXT_714 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_715 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_716 = " = array_values($";
  protected final String TEXT_717 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_718 = "->";
  protected final String TEXT_719 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_720 = " as $";
  protected final String TEXT_721 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_722 = "->";
  protected final String TEXT_723 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_724 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_725 = NL + "  public function ";
  protected final String TEXT_726 = "(";
  protected final String TEXT_727 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_728 = "(";
  protected final String TEXT_729 = ");" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_730 = "($";
  protected final String TEXT_731 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_732 = NL + "    $";
  protected final String TEXT_733 = " = $";
  protected final String TEXT_734 = "->";
  protected final String TEXT_735 = "();" + NL + "    $";
  protected final String TEXT_736 = " = $";
  protected final String TEXT_737 = " != null && $this !== $";
  protected final String TEXT_738 = ";" + NL + "    if ($";
  protected final String TEXT_739 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_740 = "->";
  protected final String TEXT_741 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_742 = "[] = $";
  protected final String TEXT_743 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_744 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_745 = "($";
  protected final String TEXT_746 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_747 = NL + "    //Unable to remove ";
  protected final String TEXT_748 = ", as it must always have a ";
  protected final String TEXT_749 = NL + "    if ($this !== $";
  protected final String TEXT_750 = "->";
  protected final String TEXT_751 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_752 = "[$this->";
  protected final String TEXT_753 = "($";
  protected final String TEXT_754 = ")]);" + NL + "      $this->";
  protected final String TEXT_755 = " = array_values($this->";
  protected final String TEXT_756 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_757 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_758 = NL + "  public function ";
  protected final String TEXT_759 = "($";
  protected final String TEXT_760 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_761 = NL + "    if ($";
  protected final String TEXT_762 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_763 = " = $this->";
  protected final String TEXT_764 = ";" + NL + "      $this->";
  protected final String TEXT_765 = " = null;" + NL + "      " + NL + "      if ($";
  protected final String TEXT_766 = " != null && $";
  protected final String TEXT_767 = "->";
  protected final String TEXT_768 = "() != null)" + NL + "      {" + NL + "        $";
  protected final String TEXT_769 = "->";
  protected final String TEXT_770 = "(null);" + NL + "      }" + NL + "      $wasSet = true;";
  protected final String TEXT_771 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_772 = " = $this->";
  protected final String TEXT_773 = "();" + NL + "    if ($";
  protected final String TEXT_774 = " != null && $";
  protected final String TEXT_775 = " != $";
  protected final String TEXT_776 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_777 = "->";
  protected final String TEXT_778 = "(null);" + NL + "    }" + NL + "    " + NL + "    $this->";
  protected final String TEXT_779 = " = $";
  protected final String TEXT_780 = ";" + NL + "    $";
  protected final String TEXT_781 = " = $";
  protected final String TEXT_782 = "->";
  protected final String TEXT_783 = "();" + NL + "    " + NL + "    if ($this != $";
  protected final String TEXT_784 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_785 = "->";
  protected final String TEXT_786 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_787 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_788 = NL + "  public function ";
  protected final String TEXT_789 = "($";
  protected final String TEXT_790 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_791 = NL + "    if ($this->";
  protected final String TEXT_792 = "($";
  protected final String TEXT_793 = ") == -1)" + NL + "    {";
  protected final String TEXT_794 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_795 = "() <= self::";
  protected final String TEXT_796 = "())" + NL + "    {";
  protected final String TEXT_797 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_798 = "($";
  protected final String TEXT_799 = ");" + NL + "    unset($this->";
  protected final String TEXT_800 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_801 = "->";
  protected final String TEXT_802 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_803 = "->";
  protected final String TEXT_804 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_805 = "[$oldIndex] = $";
  protected final String TEXT_806 = ";" + NL + "        ksort($this->";
  protected final String TEXT_807 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_808 = " = array_values($this->";
  protected final String TEXT_809 = ");";
  protected final String TEXT_810 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_811 = NL + "  public function ";
  protected final String TEXT_812 = "($";
  protected final String TEXT_813 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_814 = NL + "    if ($this->";
  protected final String TEXT_815 = "($";
  protected final String TEXT_816 = ") == -1)" + NL + "    {";
  protected final String TEXT_817 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_818 = "() <= self::";
  protected final String TEXT_819 = "())" + NL + "    {";
  protected final String TEXT_820 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_821 = "($";
  protected final String TEXT_822 = ");" + NL + "    unset($this->";
  protected final String TEXT_823 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_824 = "->";
  protected final String TEXT_825 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_826 = "->";
  protected final String TEXT_827 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_828 = "[$oldIndex] = $";
  protected final String TEXT_829 = ";" + NL + "        ksort($this->";
  protected final String TEXT_830 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_831 = " = array_values($this->";
  protected final String TEXT_832 = ");";
  protected final String TEXT_833 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_834 = NL + "  public function ";
  protected final String TEXT_835 = "($";
  protected final String TEXT_836 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_837 = NL + "    if ($";
  protected final String TEXT_838 = " != null && $";
  protected final String TEXT_839 = "->";
  protected final String TEXT_840 = "() >= ";
  protected final String TEXT_841 = "::";
  protected final String TEXT_842 = "())" + NL + "    {";
  protected final String TEXT_843 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_844 = " = $this->";
  protected final String TEXT_845 = ";" + NL + "    $this->";
  protected final String TEXT_846 = " = $";
  protected final String TEXT_847 = ";" + NL + "    if ($";
  protected final String TEXT_848 = " != null && $";
  protected final String TEXT_849 = " != $";
  protected final String TEXT_850 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_851 = "->";
  protected final String TEXT_852 = "($this);" + NL + "    }" + NL + "    if ($";
  protected final String TEXT_853 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_854 = "->";
  protected final String TEXT_855 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_856 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_857 = NL + "  public function ";
  protected final String TEXT_858 = "($";
  protected final String TEXT_859 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_860 = NL + "    if ($";
  protected final String TEXT_861 = " == null)" + NL + "    {";
  protected final String TEXT_862 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_863 = " = $this->";
  protected final String TEXT_864 = ";" + NL + "    $this->";
  protected final String TEXT_865 = " = $";
  protected final String TEXT_866 = ";" + NL + "    if ($";
  protected final String TEXT_867 = " != null && $";
  protected final String TEXT_868 = " != $";
  protected final String TEXT_869 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_870 = "->";
  protected final String TEXT_871 = "($this);" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_872 = "->";
  protected final String TEXT_873 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_874 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_875 = NL + "  public function ";
  protected final String TEXT_876 = "($";
  protected final String TEXT_877 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_878 = NL + "    //Must provide ";
  protected final String TEXT_879 = " to ";
  protected final String TEXT_880 = NL + "    if ($";
  protected final String TEXT_881 = " == null)" + NL + "    {";
  protected final String TEXT_882 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_883 = " already at maximum (";
  protected final String TEXT_884 = ")" + NL + "    if ($";
  protected final String TEXT_885 = "->";
  protected final String TEXT_886 = "() >= ";
  protected final String TEXT_887 = "::";
  protected final String TEXT_888 = "())" + NL + "    {";
  protected final String TEXT_889 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_890 = " = $this->";
  protected final String TEXT_891 = ";" + NL + "    $this->";
  protected final String TEXT_892 = " = $";
  protected final String TEXT_893 = ";" + NL + "    if ($";
  protected final String TEXT_894 = " != null && $";
  protected final String TEXT_895 = " != $";
  protected final String TEXT_896 = ")" + NL + "    {" + NL + "      $didRemove = $";
  protected final String TEXT_897 = "->";
  protected final String TEXT_898 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_899 = " = $";
  protected final String TEXT_900 = ";";
  protected final String TEXT_901 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_902 = "->";
  protected final String TEXT_903 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_904 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_905 = NL + "  public function ";
  protected final String TEXT_906 = "($";
  protected final String TEXT_907 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_908 = NL + "    //Must provide ";
  protected final String TEXT_909 = " to ";
  protected final String TEXT_910 = NL + "    if ($";
  protected final String TEXT_911 = " == null)" + NL + "    {";
  protected final String TEXT_912 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_913 = " != null && $this->";
  protected final String TEXT_914 = "->";
  protected final String TEXT_915 = "() <= ";
  protected final String TEXT_916 = "::";
  protected final String TEXT_917 = "())" + NL + "    {";
  protected final String TEXT_918 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_919 = " = $this->";
  protected final String TEXT_920 = ";" + NL + "    $this->";
  protected final String TEXT_921 = " = $";
  protected final String TEXT_922 = ";" + NL + "    if ($";
  protected final String TEXT_923 = " != null && $";
  protected final String TEXT_924 = " != $";
  protected final String TEXT_925 = ")" + NL + "    {" + NL + "      $didRemove = $";
  protected final String TEXT_926 = "->";
  protected final String TEXT_927 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_928 = " = $";
  protected final String TEXT_929 = ";";
  protected final String TEXT_930 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_931 = "->";
  protected final String TEXT_932 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_933 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_934 = NL + "  public function ";
  protected final String TEXT_935 = "($";
  protected final String TEXT_936 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_937 = NL + "    $";
  protected final String TEXT_938 = " = $";
  protected final String TEXT_939 = "->";
  protected final String TEXT_940 = "();" + NL + "    if ($";
  protected final String TEXT_941 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_942 = "->";
  protected final String TEXT_943 = "($this);" + NL + "    }" + NL + "    elseif ($this !== $";
  protected final String TEXT_944 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_945 = "->";
  protected final String TEXT_946 = "($";
  protected final String TEXT_947 = ");" + NL + "      $this->";
  protected final String TEXT_948 = "($";
  protected final String TEXT_949 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_950 = "[] = $";
  protected final String TEXT_951 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_952 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_953 = "($";
  protected final String TEXT_954 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_955 = NL + "    if ($this->";
  protected final String TEXT_956 = "($";
  protected final String TEXT_957 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_958 = "[$this->";
  protected final String TEXT_959 = "($";
  protected final String TEXT_960 = ")]);" + NL + "      $this->";
  protected final String TEXT_961 = " = array_values($this->";
  protected final String TEXT_962 = ");" + NL + "      if ($this === $";
  protected final String TEXT_963 = "->";
  protected final String TEXT_964 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_965 = "->";
  protected final String TEXT_966 = "(null);" + NL + "      }" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_967 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_968 = NL + "  public function ";
  protected final String TEXT_969 = "($";
  protected final String TEXT_970 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_971 = NL + "    $";
  protected final String TEXT_972 = " = $this->";
  protected final String TEXT_973 = ";" + NL + "    $this->";
  protected final String TEXT_974 = " = $";
  protected final String TEXT_975 = ";" + NL + "    if ($";
  protected final String TEXT_976 = " != null && $";
  protected final String TEXT_977 = " !== $";
  protected final String TEXT_978 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_979 = "->";
  protected final String TEXT_980 = "($this);" + NL + "    }" + NL + "    if ($";
  protected final String TEXT_981 = " != null && $";
  protected final String TEXT_982 = " !== $";
  protected final String TEXT_983 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_984 = "->";
  protected final String TEXT_985 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_986 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_987 = NL + "  public function ";
  protected final String TEXT_988 = "($";
  protected final String TEXT_989 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_990 = NL + "    if ($this->";
  protected final String TEXT_991 = "() >= self::";
  protected final String TEXT_992 = "())" + NL + "    {";
  protected final String TEXT_993 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_994 = " = $";
  protected final String TEXT_995 = "->";
  protected final String TEXT_996 = "();" + NL + "    if ($";
  protected final String TEXT_997 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_998 = "->";
  protected final String TEXT_999 = "($this);" + NL + "    }" + NL + "    else if ($this !== $";
  protected final String TEXT_1000 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1001 = "->";
  protected final String TEXT_1002 = "($";
  protected final String TEXT_1003 = ");" + NL + "      $this->";
  protected final String TEXT_1004 = "($";
  protected final String TEXT_1005 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1006 = "[] = $";
  protected final String TEXT_1007 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_1008 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1009 = "($";
  protected final String TEXT_1010 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1011 = NL + "    if ($this->";
  protected final String TEXT_1012 = "($";
  protected final String TEXT_1013 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1014 = "[$this->";
  protected final String TEXT_1015 = "($";
  protected final String TEXT_1016 = ")]);" + NL + "      $this->";
  protected final String TEXT_1017 = " = array_values($this->";
  protected final String TEXT_1018 = ");" + NL + "      $";
  protected final String TEXT_1019 = "->";
  protected final String TEXT_1020 = "(null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1021 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1022 = NL + "  public function ";
  protected final String TEXT_1023 = "($";
  protected final String TEXT_1024 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1025 = NL + "    if ($this->";
  protected final String TEXT_1026 = "() < self::";
  protected final String TEXT_1027 = "())" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1028 = "[] = $";
  protected final String TEXT_1029 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  protected final String TEXT_1030 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1031 = "($";
  protected final String TEXT_1032 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1033 = NL + "    if ($this->";
  protected final String TEXT_1034 = "($";
  protected final String TEXT_1035 = ") == -1)" + NL + "    {";
  protected final String TEXT_1036 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_1037 = "() <= self::";
  protected final String TEXT_1038 = "())" + NL + "    {";
  protected final String TEXT_1039 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_1040 = "[$this->";
  protected final String TEXT_1041 = "($";
  protected final String TEXT_1042 = ")]);" + NL + "    $this->";
  protected final String TEXT_1043 = " = array_values($this->";
  protected final String TEXT_1044 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_1045 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1046 = NL + "  public function ";
  protected final String TEXT_1047 = "($";
  protected final String TEXT_1048 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1049 = NL + "    if ($this->";
  protected final String TEXT_1050 = "() >= self::";
  protected final String TEXT_1051 = "())" + NL + "    {";
  protected final String TEXT_1052 = NL + "      return $wasAdded;" + NL + "    }";
  protected final String TEXT_1053 = NL + "    $";
  protected final String TEXT_1054 = " = $";
  protected final String TEXT_1055 = "->";
  protected final String TEXT_1056 = "();" + NL + "    if ($";
  protected final String TEXT_1057 = " != null && $";
  protected final String TEXT_1058 = "->";
  protected final String TEXT_1059 = "() <= self::";
  protected final String TEXT_1060 = "())" + NL + "    {";
  protected final String TEXT_1061 = NL + "      return $wasAdded;" + NL + "    }" + NL + "    else if ($";
  protected final String TEXT_1062 = " != null)" + NL + "    {" + NL + "      unset($";
  protected final String TEXT_1063 = "->";
  protected final String TEXT_1064 = "[$";
  protected final String TEXT_1065 = "->";
  protected final String TEXT_1066 = "($";
  protected final String TEXT_1067 = ")]);" + NL + "      $";
  protected final String TEXT_1068 = "->";
  protected final String TEXT_1069 = " = array_values($";
  protected final String TEXT_1070 = "->";
  protected final String TEXT_1071 = ");" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_1072 = "[] = $";
  protected final String TEXT_1073 = ";" + NL + "    $this->";
  protected final String TEXT_1074 = "($";
  protected final String TEXT_1075 = ",$this);" + NL + "    $wasAdded = true;";
  protected final String TEXT_1076 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1077 = "($";
  protected final String TEXT_1078 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1079 = NL + "    if ($this->";
  protected final String TEXT_1080 = "($";
  protected final String TEXT_1081 = ") != -1 && $this->";
  protected final String TEXT_1082 = "() > self::";
  protected final String TEXT_1083 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1084 = "[$this->";
  protected final String TEXT_1085 = "($";
  protected final String TEXT_1086 = ")]);" + NL + "      $this->";
  protected final String TEXT_1087 = " = array_values($this->";
  protected final String TEXT_1088 = ");" + NL + "      $this->";
  protected final String TEXT_1089 = "($";
  protected final String TEXT_1090 = ",null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1091 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1092 = NL + "  public function ";
  protected final String TEXT_1093 = "($";
  protected final String TEXT_1094 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1095 = NL + "    $";
  protected final String TEXT_1096 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1097 = " as $";
  protected final String TEXT_1098 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1099 = ",$";
  protected final String TEXT_1100 = ") !== false)" + NL + "      {";
  protected final String TEXT_1101 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  protected final String TEXT_1102 = "->";
  protected final String TEXT_1103 = "() != null && $this !== $";
  protected final String TEXT_1104 = "->";
  protected final String TEXT_1105 = "())" + NL + "      {";
  protected final String TEXT_1106 = NL + "        return $wasSet;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1107 = "[] = $";
  protected final String TEXT_1108 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1109 = ") != self::";
  protected final String TEXT_1110 = "())" + NL + "    {";
  protected final String TEXT_1111 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    foreach ($this->";
  protected final String TEXT_1112 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  protected final String TEXT_1113 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + "" + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1114 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1115 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1116 = " as $";
  protected final String TEXT_1117 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1118 = "($";
  protected final String TEXT_1119 = ", $this);" + NL + "      $this->";
  protected final String TEXT_1120 = "[] = $";
  protected final String TEXT_1121 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1122 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1123 = NL + "  private function ";
  protected final String TEXT_1124 = "($";
  protected final String TEXT_1125 = ", $";
  protected final String TEXT_1126 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_1127 = "->mentor = $";
  protected final String TEXT_1128 = ";" + NL + "    //$prop = new ReflectionProperty($";
  protected final String TEXT_1129 = ", '";
  protected final String TEXT_1130 = "');" + NL + "    //$prop->setAccessible(true);" + NL + "    //$prop->setValue($";
  protected final String TEXT_1131 = ",$";
  protected final String TEXT_1132 = ");" + NL + "    //$prop->setAccessible(false);" + NL + "  }" + NL;
  protected final String TEXT_1133 = NL + "  public function ";
  protected final String TEXT_1134 = "($";
  protected final String TEXT_1135 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1136 = NL + "    $this->";
  protected final String TEXT_1137 = "[] = $";
  protected final String TEXT_1138 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_1139 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1140 = "($";
  protected final String TEXT_1141 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1142 = NL + "    if ($this->";
  protected final String TEXT_1143 = "($";
  protected final String TEXT_1144 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1145 = "[$this->";
  protected final String TEXT_1146 = "($";
  protected final String TEXT_1147 = ")]);" + NL + "      $this->";
  protected final String TEXT_1148 = " = array_values($this->";
  protected final String TEXT_1149 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1150 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1151 = NL + "  public function ";
  protected final String TEXT_1152 = "($";
  protected final String TEXT_1153 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1154 = NL + "    if ($this->";
  protected final String TEXT_1155 = "() < self::";
  protected final String TEXT_1156 = "())" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1157 = "[] = $";
  protected final String TEXT_1158 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  protected final String TEXT_1159 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1160 = "($";
  protected final String TEXT_1161 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1162 = NL + "    if ($this->";
  protected final String TEXT_1163 = "($";
  protected final String TEXT_1164 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1165 = "[$this->";
  protected final String TEXT_1166 = "($";
  protected final String TEXT_1167 = ")]);" + NL + "      $this->";
  protected final String TEXT_1168 = " = array_values($this->";
  protected final String TEXT_1169 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1170 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
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
  protected final String TEXT_1182 = ") == -1)" + NL + "    {";
  protected final String TEXT_1183 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_1184 = "() <= self::";
  protected final String TEXT_1185 = "())" + NL + "    {";
  protected final String TEXT_1186 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_1187 = "[$this->";
  protected final String TEXT_1188 = "($";
  protected final String TEXT_1189 = ")]);" + NL + "    $this->";
  protected final String TEXT_1190 = " = array_values($this->";
  protected final String TEXT_1191 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_1192 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1193 = NL + "  ";
  protected final String TEXT_1194 = " function ";
  protected final String TEXT_1195 = "($";
  protected final String TEXT_1196 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1197 = NL + "    $";
  protected final String TEXT_1198 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1199 = " as $";
  protected final String TEXT_1200 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1201 = ",$";
  protected final String TEXT_1202 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1203 = "[] = $";
  protected final String TEXT_1204 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1205 = ") != count($";
  protected final String TEXT_1206 = ") || count($";
  protected final String TEXT_1207 = ") != self::";
  protected final String TEXT_1208 = "())" + NL + "    {";
  protected final String TEXT_1209 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1210 = " = $";
  protected final String TEXT_1211 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1212 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1213 = NL + "  ";
  protected final String TEXT_1214 = " function ";
  protected final String TEXT_1215 = "($";
  protected final String TEXT_1216 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1217 = NL + "    $";
  protected final String TEXT_1218 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1219 = " as $";
  protected final String TEXT_1220 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1221 = ",$";
  protected final String TEXT_1222 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1223 = "[] = $";
  protected final String TEXT_1224 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1225 = ") != count($";
  protected final String TEXT_1226 = "))" + NL + "    {";
  protected final String TEXT_1227 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1228 = "->";
  protected final String TEXT_1229 = " = $";
  protected final String TEXT_1230 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1231 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1232 = NL + "  public function ";
  protected final String TEXT_1233 = "($";
  protected final String TEXT_1234 = ")" + NL + "  {" + NL + "    //" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + "" + NL + "    $wasSet = false;" + NL + "    " + NL + "    $";
  protected final String TEXT_1235 = " = $this->";
  protected final String TEXT_1236 = ";" + NL + "\t" + NL + "    if ($";
  protected final String TEXT_1237 = " == null)" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1238 = " != null)" + NL + "      {" + NL + "        if ($";
  protected final String TEXT_1239 = "->";
  protected final String TEXT_1240 = "($this))" + NL + "        {" + NL + "          $";
  protected final String TEXT_1241 = " = $";
  protected final String TEXT_1242 = ";" + NL + "          $wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if ($";
  protected final String TEXT_1243 = " != null)" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1244 = " == null)" + NL + "      {" + NL + "        if ($";
  protected final String TEXT_1245 = "->";
  protected final String TEXT_1246 = "() < $";
  protected final String TEXT_1247 = "->";
  protected final String TEXT_1248 = "())" + NL + "        {" + NL + "          $";
  protected final String TEXT_1249 = "->";
  protected final String TEXT_1250 = "($this);" + NL + "          $";
  protected final String TEXT_1251 = " = $";
  protected final String TEXT_1252 = ";  // ";
  protected final String TEXT_1253 = " == null" + NL + "          $wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if ($";
  protected final String TEXT_1254 = "->";
  protected final String TEXT_1255 = "() < $";
  protected final String TEXT_1256 = "->";
  protected final String TEXT_1257 = "())" + NL + "        {" + NL + "          $";
  protected final String TEXT_1258 = "->";
  protected final String TEXT_1259 = "($this);" + NL + "          $";
  protected final String TEXT_1260 = "->";
  protected final String TEXT_1261 = "($this);" + NL + "          $";
  protected final String TEXT_1262 = " = $";
  protected final String TEXT_1263 = ";" + NL + "          $wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if ($wasSet)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1264 = " = $";
  protected final String TEXT_1265 = ";" + NL + "    }" + NL + "    return $wasSet;" + NL + "  }" + NL + "  ";
  protected final String TEXT_1266 = NL + "//  public function ";
  protected final String TEXT_1267 = "($";
  protected final String TEXT_1268 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  protected final String TEXT_1269 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//    $wasSet = false;" + NL + "//" + NL + "//    $";
  protected final String TEXT_1270 = " = $";
  protected final String TEXT_1271 = ";" + NL + "//\t" + NL + "//\tif ($";
  protected final String TEXT_1272 = " == null)" + NL + "//    {" + NL + "//      if ($";
  protected final String TEXT_1273 = " != null)" + NL + "//      {" + NL + "//        if ($";
  protected final String TEXT_1274 = "->";
  protected final String TEXT_1275 = "(this))" + NL + "//        {" + NL + "//          $";
  protected final String TEXT_1276 = " = $";
  protected final String TEXT_1277 = ";" + NL + "//          $wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    } " + NL + "//    else if ($";
  protected final String TEXT_1278 = " != null)" + NL + "//    { " + NL + "//      if ($";
  protected final String TEXT_1279 = " == null)" + NL + "//      {" + NL + "//        if ($";
  protected final String TEXT_1280 = "->";
  protected final String TEXT_1281 = "() < $";
  protected final String TEXT_1282 = "->";
  protected final String TEXT_1283 = "())" + NL + "//        {" + NL + "//          $";
  protected final String TEXT_1284 = "->";
  protected final String TEXT_1285 = "(this);" + NL + "//          $";
  protected final String TEXT_1286 = " = $";
  protected final String TEXT_1287 = ";  // $";
  protected final String TEXT_1288 = " == null" + NL + "//          $wasSet = true;" + NL + "//        }" + NL + "//      } " + NL + "//      else" + NL + "//      {" + NL + "//        if (   $";
  protected final String TEXT_1289 = "->";
  protected final String TEXT_1290 = "() < $";
  protected final String TEXT_1291 = "->";
  protected final String TEXT_1292 = "()" + NL + "//            && $";
  protected final String TEXT_1293 = "->";
  protected final String TEXT_1294 = "() > $";
  protected final String TEXT_1295 = "->";
  protected final String TEXT_1296 = "()" + NL + "//           )" + NL + "//        {" + NL + "//          $";
  protected final String TEXT_1297 = "->";
  protected final String TEXT_1298 = "(this);" + NL + "//          $";
  protected final String TEXT_1299 = "->";
  protected final String TEXT_1300 = "(this);" + NL + "//          $";
  protected final String TEXT_1301 = " = ";
  protected final String TEXT_1302 = ";" + NL + "//          $wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    if ($wasSet)" + NL + "//    {" + NL + "//      $";
  protected final String TEXT_1303 = " = $";
  protected final String TEXT_1304 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return $wasSet;" + NL + "//  }";
  protected final String TEXT_1305 = NL + "  public function ";
  protected final String TEXT_1306 = "($";
  protected final String TEXT_1307 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1308 = NL + "    $";
  protected final String TEXT_1309 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1310 = " as $";
  protected final String TEXT_1311 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1312 = ",$";
  protected final String TEXT_1313 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1314 = "[] = $";
  protected final String TEXT_1315 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1316 = ") != count($";
  protected final String TEXT_1317 = ") || count($";
  protected final String TEXT_1318 = ") < self::";
  protected final String TEXT_1319 = "() || count($";
  protected final String TEXT_1320 = ") > self::";
  protected final String TEXT_1321 = "())" + NL + "    {";
  protected final String TEXT_1322 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1323 = " = $this->";
  protected final String TEXT_1324 = ";" + NL + "    $this->";
  protected final String TEXT_1325 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1326 = " as $";
  protected final String TEXT_1327 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1328 = "[] = $";
  protected final String TEXT_1329 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_1330 = ",$";
  protected final String TEXT_1331 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1332 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_1333 = " = array_values($";
  protected final String TEXT_1334 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1335 = "->";
  protected final String TEXT_1336 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_1337 = " as $";
  protected final String TEXT_1338 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1339 = "->";
  protected final String TEXT_1340 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1341 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1342 = NL + "  public function ";
  protected final String TEXT_1343 = "($";
  protected final String TEXT_1344 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1345 = NL + "    $";
  protected final String TEXT_1346 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1347 = " as $";
  protected final String TEXT_1348 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1349 = ",$";
  protected final String TEXT_1350 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1351 = "[] = $";
  protected final String TEXT_1352 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1353 = ") != count($";
  protected final String TEXT_1354 = ") || count($";
  protected final String TEXT_1355 = ") < self::";
  protected final String TEXT_1356 = "())" + NL + "    {";
  protected final String TEXT_1357 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1358 = " = $this->";
  protected final String TEXT_1359 = ";" + NL + "    $this->";
  protected final String TEXT_1360 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1361 = " as $";
  protected final String TEXT_1362 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1363 = "[] = $";
  protected final String TEXT_1364 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_1365 = ",$";
  protected final String TEXT_1366 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1367 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_1368 = " = array_values($";
  protected final String TEXT_1369 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1370 = "->";
  protected final String TEXT_1371 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_1372 = " as $";
  protected final String TEXT_1373 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1374 = "->";
  protected final String TEXT_1375 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1376 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1377 = NL + "  ";
  protected final String TEXT_1378 = " function ";
  protected final String TEXT_1379 = "($";
  protected final String TEXT_1380 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1381 = NL + "    $";
  protected final String TEXT_1382 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1383 = " as $";
  protected final String TEXT_1384 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1385 = ",$";
  protected final String TEXT_1386 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1387 = "[] = $";
  protected final String TEXT_1388 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1389 = ") != count($";
  protected final String TEXT_1390 = ") || count($";
  protected final String TEXT_1391 = ") < self::";
  protected final String TEXT_1392 = "()  || count($";
  protected final String TEXT_1393 = ") > self::";
  protected final String TEXT_1394 = "())" + NL + "    {";
  protected final String TEXT_1395 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1396 = " = $";
  protected final String TEXT_1397 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1398 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1399 = NL + "  public function ";
  protected final String TEXT_1400 = "($";
  protected final String TEXT_1401 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1402 = NL + "    if (count($";
  protected final String TEXT_1403 = ") < self::";
  protected final String TEXT_1404 = "()";
  protected final String TEXT_1405 = ")" + NL + "    {";
  protected final String TEXT_1406 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1407 = " = array();" + NL + "    $";
  protected final String TEXT_1408 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1409 = " as $";
  protected final String TEXT_1410 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1411 = ",$";
  protected final String TEXT_1412 = ") !== false)" + NL + "      {";
  protected final String TEXT_1413 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  protected final String TEXT_1414 = "->";
  protected final String TEXT_1415 = "() != null && $this !== $";
  protected final String TEXT_1416 = "->";
  protected final String TEXT_1417 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_1418 = " = $";
  protected final String TEXT_1419 = "->";
  protected final String TEXT_1420 = "();" + NL + "        $";
  protected final String TEXT_1421 = " = serialize($";
  protected final String TEXT_1422 = ");" + NL + "        if (!array_key_exists($";
  protected final String TEXT_1423 = ", $";
  protected final String TEXT_1424 = "))" + NL + "        {" + NL + "          $";
  protected final String TEXT_1425 = "[$";
  protected final String TEXT_1426 = "] = $";
  protected final String TEXT_1427 = "->";
  protected final String TEXT_1428 = "();" + NL + "        }" + NL + "        $nextCount = $";
  protected final String TEXT_1429 = "[$";
  protected final String TEXT_1430 = "] - 1;" + NL + "        if ($nextCount < self::minimum";
  protected final String TEXT_1431 = "())" + NL + "        {";
  protected final String TEXT_1432 = NL + "          return $wasSet;" + NL + "        }" + NL + "        $";
  protected final String TEXT_1433 = "[$";
  protected final String TEXT_1434 = "] = $nextCount;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1435 = "[] = $";
  protected final String TEXT_1436 = ";" + NL + "    }" + NL + "" + NL + "    foreach ($this->";
  protected final String TEXT_1437 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  protected final String TEXT_1438 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + "      " + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1439 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1440 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1441 = " as $";
  protected final String TEXT_1442 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1443 = "->";
  protected final String TEXT_1444 = "() != null)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1445 = "->";
  protected final String TEXT_1446 = "()->";
  protected final String TEXT_1447 = "[$";
  protected final String TEXT_1448 = "->";
  protected final String TEXT_1449 = "()->";
  protected final String TEXT_1450 = "($";
  protected final String TEXT_1451 = ")]);" + NL + "        $";
  protected final String TEXT_1452 = "->";
  protected final String TEXT_1453 = "()->";
  protected final String TEXT_1454 = " = array_values($";
  protected final String TEXT_1455 = "->";
  protected final String TEXT_1456 = "()->";
  protected final String TEXT_1457 = ");" + NL + "      }" + NL + "      $this->";
  protected final String TEXT_1458 = "($";
  protected final String TEXT_1459 = ", $this);" + NL + "      $this->";
  protected final String TEXT_1460 = "[] = $";
  protected final String TEXT_1461 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1462 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1463 = NL + "  private function ";
  protected final String TEXT_1464 = "($";
  protected final String TEXT_1465 = ", $";
  protected final String TEXT_1466 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_1467 = "->mentor = $";
  protected final String TEXT_1468 = ";" + NL + "    //$prop = new ReflectionProperty($";
  protected final String TEXT_1469 = ", '";
  protected final String TEXT_1470 = "');" + NL + "    //$prop->setAccessible(true);" + NL + "    //$prop->setValue($";
  protected final String TEXT_1471 = ",$";
  protected final String TEXT_1472 = ");" + NL + "    //$prop->setAccessible(false);" + NL + "  }" + NL;
  protected final String TEXT_1473 = NL + "  ";
  protected final String TEXT_1474 = " function ";
  protected final String TEXT_1475 = "($";
  protected final String TEXT_1476 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1477 = NL + "    $";
  protected final String TEXT_1478 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1479 = " as $";
  protected final String TEXT_1480 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1481 = ",$";
  protected final String TEXT_1482 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1483 = "[] = $";
  protected final String TEXT_1484 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1485 = ") != count($";
  protected final String TEXT_1486 = ") || count($";
  protected final String TEXT_1487 = ") > self::";
  protected final String TEXT_1488 = "())" + NL + "    {";
  protected final String TEXT_1489 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1490 = " = $";
  protected final String TEXT_1491 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1492 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1493 = NL + "  ";
  protected final String TEXT_1494 = " function ";
  protected final String TEXT_1495 = "($";
  protected final String TEXT_1496 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1497 = NL + "    $";
  protected final String TEXT_1498 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1499 = " as $";
  protected final String TEXT_1500 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1501 = ",$";
  protected final String TEXT_1502 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1503 = "[] = $";
  protected final String TEXT_1504 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1505 = ") != count($";
  protected final String TEXT_1506 = ") || count($";
  protected final String TEXT_1507 = ") < self::";
  protected final String TEXT_1508 = "())" + NL + "    {";
  protected final String TEXT_1509 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1510 = " = $";
  protected final String TEXT_1511 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1512 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1513 = NL + "  public function ";
  protected final String TEXT_1514 = "($";
  protected final String TEXT_1515 = ", $index)" + NL + "  {  " + NL + "    $wasAdded = false;" + NL + "    if($this->";
  protected final String TEXT_1516 = "($";
  protected final String TEXT_1517 = "))" + NL + "    {" + NL + "      if($index < 0 ) { $index = 0; }" + NL + "      if($index > $this->";
  protected final String TEXT_1518 = "()) { $index = $this->";
  protected final String TEXT_1519 = "() - 1; }" + NL + "      array_splice($this->";
  protected final String TEXT_1520 = ", $this->";
  protected final String TEXT_1521 = "($";
  protected final String TEXT_1522 = "), 1);" + NL + "      array_splice($this->";
  protected final String TEXT_1523 = ", $index, 0, array($";
  protected final String TEXT_1524 = "));" + NL + "      $wasAdded = true;" + NL + "    }" + NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1525 = "($";
  protected final String TEXT_1526 = ", $index)" + NL + "  {" + NL + "    $wasAdded = false;" + NL + "    if($this->";
  protected final String TEXT_1527 = "($";
  protected final String TEXT_1528 = ") !== -1)" + NL + "    {" + NL + "      if($index < 0 ) { $index = 0; }" + NL + "      if($index > $this->";
  protected final String TEXT_1529 = "()) { $index = $this->";
  protected final String TEXT_1530 = "() - 1; }" + NL + "      array_splice($this->";
  protected final String TEXT_1531 = ", $this->";
  protected final String TEXT_1532 = "($";
  protected final String TEXT_1533 = "), 1);" + NL + "      array_splice($this->";
  protected final String TEXT_1534 = ", $index, 0, array($";
  protected final String TEXT_1535 = "));" + NL + "      $wasAdded = true;" + NL + "    } " + NL + "    else " + NL + "    {" + NL + "      $wasAdded = $this->";
  protected final String TEXT_1536 = "($";
  protected final String TEXT_1537 = ", $index);" + NL + "    }" + NL + "    return $wasAdded;" + NL + "  }" + NL;
  protected final String TEXT_1538 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    if ($compareTo == null) { return false; }" + NL + "    if (get_class($this) != get_class($compareTo)) { return false; }" + NL;
  protected final String TEXT_1539 = NL + "    ";
  protected final String TEXT_1540 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public function hashCode()" + NL + "  {" + NL + "    if ($this->cachedHashCode != -1)" + NL + "    {" + NL + "      return $this->cachedHashCode;" + NL + "    }" + NL + "    $this->cachedHashCode = 17;";
  protected final String TEXT_1541 = NL + "    ";
  protected final String TEXT_1542 = NL;
  protected final String TEXT_1543 = NL + "    ";
  protected final String TEXT_1544 = NL + "    return $this->cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1545 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    return $this == $compareTo;" + NL + "  }" + NL;
  protected final String TEXT_1546 = NL + "    $this->";
  protected final String TEXT_1547 = " = null;";
  protected final String TEXT_1548 = NL + "    $this->";
  protected final String TEXT_1549 = " = array();";
  protected final String TEXT_1550 = NL + "    $";
  protected final String TEXT_1551 = " = $this->";
  protected final String TEXT_1552 = ";" + NL + "    $this->";
  protected final String TEXT_1553 = " = null;" + NL + "    if ($";
  protected final String TEXT_1554 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1555 = "->delete();" + NL + "    }";
  protected final String TEXT_1556 = NL + "    if ($this->";
  protected final String TEXT_1557 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1558 = "->";
  protected final String TEXT_1559 = "(null);" + NL + "    }";
  protected final String TEXT_1560 = NL + "    $";
  protected final String TEXT_1561 = " = $this->";
  protected final String TEXT_1562 = ";" + NL + "    $this->";
  protected final String TEXT_1563 = " = null;" + NL + "    if ($";
  protected final String TEXT_1564 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1565 = "->";
  protected final String TEXT_1566 = "(null);" + NL + "    }";
  protected final String TEXT_1567 = NL + "    $";
  protected final String TEXT_1568 = " = $this->";
  protected final String TEXT_1569 = ";" + NL + "    $this->";
  protected final String TEXT_1570 = " = null;" + NL + "    if ($";
  protected final String TEXT_1571 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1572 = "->delete();" + NL + "    }";
  protected final String TEXT_1573 = NL + "    if ($this->";
  protected final String TEXT_1574 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1575 = "->";
  protected final String TEXT_1576 = "($this);" + NL + "    }";
  protected final String TEXT_1577 = NL + "    if ($this->";
  protected final String TEXT_1578 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1579 = "->delete();" + NL + "    }";
  protected final String TEXT_1580 = NL + "    if ($this->";
  protected final String TEXT_1581 = " != null)" + NL + "    {" + NL + "      if ($this->";
  protected final String TEXT_1582 = "->";
  protected final String TEXT_1583 = "() <= ";
  protected final String TEXT_1584 = ")" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1585 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1586 = "->";
  protected final String TEXT_1587 = "($this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1588 = NL + "    $";
  protected final String TEXT_1589 = " = $this->";
  protected final String TEXT_1590 = ";" + NL + "    $this->";
  protected final String TEXT_1591 = " = null;" + NL + "    $";
  protected final String TEXT_1592 = "->";
  protected final String TEXT_1593 = "($this);";
  protected final String TEXT_1594 = NL + "    foreach ($this->";
  protected final String TEXT_1595 = " as $";
  protected final String TEXT_1596 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1597 = "($";
  protected final String TEXT_1598 = ",null);" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_1599 = " = array();";
  protected final String TEXT_1600 = NL + "    $";
  protected final String TEXT_1601 = " = $this->";
  protected final String TEXT_1602 = ";" + NL + "    $this->";
  protected final String TEXT_1603 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1604 = " as $";
  protected final String TEXT_1605 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1606 = "->";
  protected final String TEXT_1607 = "() <= ";
  protected final String TEXT_1608 = "::";
  protected final String TEXT_1609 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_1610 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1611 = "->";
  protected final String TEXT_1612 = "($this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1613 = NL + "    $";
  protected final String TEXT_1614 = " = $this->";
  protected final String TEXT_1615 = ";" + NL + "    $this->";
  protected final String TEXT_1616 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1617 = " as $";
  protected final String TEXT_1618 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1619 = "->";
  protected final String TEXT_1620 = "($this);" + NL + "    }";
  protected final String TEXT_1621 = NL + "    foreach ($this->";
  protected final String TEXT_1622 = " as $";
  protected final String TEXT_1623 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1624 = "->delete();" + NL + "    }";
  protected final String TEXT_1625 = NL + "    foreach ($this->";
  protected final String TEXT_1626 = " as $";
  protected final String TEXT_1627 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1628 = "->";
  protected final String TEXT_1629 = "(null);" + NL + "    }";
  protected final String TEXT_1630 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1631 = NL + "  ";
  protected final String TEXT_1632 = NL + "}" + NL + "?>";

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
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_16);
     
    }
    else
    {
      hasBody = true;
      if(!av.getIsLazy()){
         
    
  String assignValue = av.getValue() == null ? "$" + gen.translate("parameterOne",av) : gen.translate("parameterValue",av);

    stringBuffer.append(TEXT_17);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(assignValue);
    stringBuffer.append(TEXT_20);
    
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
    stringBuffer.append(TEXT_21);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_24);
    } 
    
      }
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_25);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_28);
    
    }
    else if (av.getIsUnique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.translate("setMethod", av));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(av.getName());
    stringBuffer.append(TEXT_32);
    
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
        
    stringBuffer.append(TEXT_33);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_38);
    
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
  

    stringBuffer.append(TEXT_39);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_49);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        hasBody = true;
        
     String requiredNumber = StringFormatter.format("{0}", av.getMultiplicity().getUpperBound()); 
    stringBuffer.append(TEXT_50);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_60);
    
      }
      else if (av.isMany() && av.isImmutable())
      {
      	hasBody = true;
        
    stringBuffer.append(TEXT_61);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(instanceIdentifier);
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
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("associationMany",av));
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
    stringBuffer.append(instanceIdentifier);
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
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_85);
    
    }
    else if (av.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(instanceIdentifier);
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
  

    stringBuffer.append(TEXT_94);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_104);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_105);
    stringBuffer.append(gen.translate("associationMany",av));
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
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_111);
    
    }
    
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_114);
    
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
    
    stringBuffer.append(TEXT_115);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_116);
    
  }

    
  if (isOneToOne)
  {
    instanceIdentifier = "thisInstance";
    
    
  String signature = gClass.getLookup("constructorSignature_mandatory");

    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_120);
    
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
      
    stringBuffer.append(TEXT_121);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_123);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_124);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_125);
     
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
    stringBuffer.append(TEXT_126);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_129);
    } 
    
    }
    else
    {
      
    
  String assignValue = av.getValue() == null ? "$" + gen.translate("parameterOne",av) : gen.translate("parameterValue",av);

    stringBuffer.append(TEXT_130);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(assignValue);
    stringBuffer.append(TEXT_133);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_134);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_137);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_138);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    stringBuffer.append(TEXT_142);
    
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
  

    stringBuffer.append(TEXT_143);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_153);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_157);
    
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
    
    stringBuffer.append(TEXT_158);
    stringBuffer.append( gClass.getParentClass().getLookup("constructorSignature") );
    stringBuffer.append(TEXT_159);
    stringBuffer.append( gClass.getParentClass().getLookup("constructorSignature_caller") );
    stringBuffer.append(TEXT_160);
    
  }

    
  }


    stringBuffer.append(TEXT_161);
    
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
        
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_164);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_165);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_168);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_169);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_172);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_175);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_176);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_177);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_178);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_180);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_181);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_184);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_187);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_190);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_196);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_197);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_198);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_200);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_201);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,"$"+gen.translate("parameterOne",av))+"\n":"")
);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(TEXT_205);
    stringBuffer.append( (traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_206);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_207);
    
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
      
    stringBuffer.append(TEXT_208);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_209);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_210);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_212);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_213);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_215);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_216);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_218);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_221);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_222);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_223);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_224);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_225);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_226);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_227);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_230);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_233);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_234);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_236);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_238);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_239);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_241);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_242);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_243);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_244);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_245);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_247);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_248);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_250);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_251);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_252);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_253);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_254);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_256);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_258);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_260);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_261);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_262);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_263);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_265);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_266);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_267);
    
      }
      
      if (av.getIsUnique())
      {
        if (customGetUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_268);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_270);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(gen.translate("getUniqueMap",av));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(TEXT_275);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_277);
    
        } 
        else 
        {
          
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_280);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_281);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("getUniqueMap",av));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_284);
    
        }
        if (customHasUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_287);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_288);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("getUniqueMap",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(TEXT_292);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customHasUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_294);
    
        }
        else
        {
          
    stringBuffer.append(TEXT_295);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_297);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_298);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("getUniqueMap",av));
    stringBuffer.append(TEXT_301);
    
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
        
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_303);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_304);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_306);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_307);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_308);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_309);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_310);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_311);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_312);
    
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
      
    stringBuffer.append(TEXT_313);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_314);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_315);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_316);
    stringBuffer.append( gen.translate("type",av) );
    stringBuffer.append(TEXT_317);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_318);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_319);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_320);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_321);
    
    }
    else if (av.getIsDerived())
    {
      
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_323);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_324);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("parameterValue",av));
    stringBuffer.append(TEXT_326);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_328);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_329);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_330);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_331);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_332);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_333);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_334);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_336);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_338);
    
    }
      
    appendln(stringBuffer, "");
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
      output.append(StringFormatter.format("\n    if ($this->{0} != self::${2}) { $answer .= \".\" . $this->{1}(); }",gen.translate("stateMachineOne",childSm),gen.translate("getMethod",childSm),gen.translate("stateNull",childSm)));
      allParents.addAll(childSm.getNestedStateMachines());
    }     
  }
  String outputAsString = output.toString();

    stringBuffer.append(TEXT_339);
    stringBuffer.append(gen.translate("getFullMethod",sm));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_341);
     if (outputAsString.length() > 0) { append(stringBuffer, "{0}",outputAsString); } 
    stringBuffer.append(TEXT_342);
     
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

    stringBuffer.append(TEXT_343);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_344);
     if (outputCases.length() > 0) { append(stringBuffer, "\n    {0}",outputCases); } 
    stringBuffer.append(TEXT_345);
    
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
        String condition = t.getGuard()!=null?t.getGuard().getCondition(gen):"if ()\n{";        
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

    stringBuffer.append(TEXT_346);
    stringBuffer.append( scope );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_348);
    stringBuffer.append( (e.getArgs()==null?"":e.getArgs()));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(TEXT_350);
    stringBuffer.append( eventOutput );
    stringBuffer.append(TEXT_351);
    
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


    stringBuffer.append(TEXT_352);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_353);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_354);
     if (!exitCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",exitCasesOutput); } 
     if (!enterCasesOutput.isEmpty()) { append(stringBuffer, "\n    {0}",enterCasesOutput); } 
    stringBuffer.append(TEXT_355);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_356);
    
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
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_358);
     if (customExitPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_359);
    stringBuffer.append( exitActions );
     if (customExitPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_360);
     } 
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_362);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_363);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_364);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_365);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_366);
     if (parentState != null) { 
    stringBuffer.append(TEXT_367);
    stringBuffer.append( gen.translate("stateMachineOne",parentSm) );
    stringBuffer.append(TEXT_368);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_369);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_370);
    stringBuffer.append( gen.translate("stateNull",sm) );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("setMethod",parentSm));
    stringBuffer.append(TEXT_372);
    stringBuffer.append( gen.translate("stateOne",parentState) );
    stringBuffer.append(TEXT_373);
     } 
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
     if (hasEntry) { 
    stringBuffer.append(TEXT_374);
    stringBuffer.append(TEXT_375);
    stringBuffer.append( entryActions );
     } 
    stringBuffer.append(TEXT_376);
    
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
      
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_378);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_380);
     } else { 
    stringBuffer.append(TEXT_381);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_383);
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_385);
     } 
    stringBuffer.append(TEXT_386);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_388);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_391);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_394);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_397);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_400);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_402);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_404);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_406);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_409);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_410);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_414);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_415);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_416);
    
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
      
    stringBuffer.append(TEXT_417);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_418);
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
      
    
      
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_420);
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_423);
     } else { 
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_428);
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_429);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_432);
     } else { 
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_434);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_435);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_436);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_437);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_438);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_440);
     } else { 
    stringBuffer.append(TEXT_441);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_442);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_443);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_444);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_445);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_448);
     } else { 
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_450);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_451);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_452);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_453);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_456);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_459);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_460);
     } 
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_468);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_469);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_471);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_472);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_475);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_488);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_489);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_490);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_493);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_496);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_497);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_498);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_501);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_505);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_506);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_509);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_517);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_531);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_532);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_535);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_548);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_558);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_559);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_566);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_582);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_585);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_590);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_595);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_601);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_602);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_611);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_614);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_625);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_631);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_634);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_639);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_644);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_650);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_651);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_660);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_663);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_675);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_678);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_679);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_688);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_689);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_692);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_704);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_723);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_724);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_731);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_743);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_746);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_756);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_757);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_760);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_770);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_786);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_787);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_790);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_793);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_796);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_809);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_810);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_813);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_816);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_819);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_828);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_832);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_833);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_836);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
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
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_855);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_856);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_859);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_861);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_873);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_874);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_877);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_881);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_888);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_900);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_903);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_904);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_907);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_911);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_917);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_929);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_932);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_933);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_936);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_951);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_954);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_955);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_966);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_967);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_970);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_985);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_986);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_989);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_992);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1007);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1010);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1020);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1021);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1024);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1029);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1032);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1035);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1038);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1044);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1045);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1048);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1051);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1052);
     } 
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1060);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1075);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1078);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1090);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1091);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1094);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1100);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1105);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1110);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1121);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1132);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1135);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1138);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1141);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1149);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1150);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1153);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1158);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1161);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1169);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1170);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
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
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1185);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1191);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1192);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1193);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1196);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1208);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1211);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1212);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1213);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1216);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1226);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1230);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1231);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1265);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1304);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1307);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1321);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1340);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1341);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1344);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1356);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1375);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1376);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1377);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1380);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1394);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1397);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1398);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || count(${0}) > self::{1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1401);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1405);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1412);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1431);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1461);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1472);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1473);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1476);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1477);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1488);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1490);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1491);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1492);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    stringBuffer.append(TEXT_1493);
    stringBuffer.append( accessModifier );
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1496);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1503);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1508);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1511);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1512);
    
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
      
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1537);
    
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


    stringBuffer.append(TEXT_1538);
    stringBuffer.append(TEXT_1539);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(TEXT_1541);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(TEXT_1543);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1544);
     } else { 
    stringBuffer.append(TEXT_1545);
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
        
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1547);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1549);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1555);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1558);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1559);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1566);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1572);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1576);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1579);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1585);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1587);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1593);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1599);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1612);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1613);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1617);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1620);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1624);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1629);
    
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
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(TEXT_1631);
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


    stringBuffer.append(TEXT_1632);
    return stringBuffer.toString();
  }
}