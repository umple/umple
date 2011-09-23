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
  protected final String TEXT_29 = NL + "    if (!$";
  protected final String TEXT_30 = "->";
  protected final String TEXT_31 = "($";
  protected final String TEXT_32 = "))" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_33 = " due to ";
  protected final String TEXT_34 = "\");" + NL + "    }";
  protected final String TEXT_35 = NL + "    $";
  protected final String TEXT_36 = "->";
  protected final String TEXT_37 = " = array();" + NL + "    $";
  protected final String TEXT_38 = " = $";
  protected final String TEXT_39 = "->";
  protected final String TEXT_40 = "($";
  protected final String TEXT_41 = ");" + NL + "    if (!$";
  protected final String TEXT_42 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_43 = ", must have ";
  protected final String TEXT_44 = " ";
  protected final String TEXT_45 = "\");" + NL + "    }";
  protected final String TEXT_46 = NL + "    $";
  protected final String TEXT_47 = "->";
  protected final String TEXT_48 = " = array();";
  protected final String TEXT_49 = NL + "    if ($";
  protected final String TEXT_50 = " == null || $";
  protected final String TEXT_51 = "->";
  protected final String TEXT_52 = "() != null)" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_53 = " due to ";
  protected final String TEXT_54 = "\");" + NL + "    }" + NL + "    $";
  protected final String TEXT_55 = "->";
  protected final String TEXT_56 = " = $";
  protected final String TEXT_57 = ";";
  protected final String TEXT_58 = NL + "    $";
  protected final String TEXT_59 = "->";
  protected final String TEXT_60 = " = array();";
  protected final String TEXT_61 = NL + "    $";
  protected final String TEXT_62 = " = $";
  protected final String TEXT_63 = "->";
  protected final String TEXT_64 = "($";
  protected final String TEXT_65 = ");" + NL + "    if (!$";
  protected final String TEXT_66 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_67 = " due to ";
  protected final String TEXT_68 = "\");" + NL + "    }";
  protected final String TEXT_69 = NL + "    $";
  protected final String TEXT_70 = "->";
  protected final String TEXT_71 = " = array();" + NL + "    $";
  protected final String TEXT_72 = " = $";
  protected final String TEXT_73 = "->";
  protected final String TEXT_74 = "($";
  protected final String TEXT_75 = ");" + NL + "    if (!$";
  protected final String TEXT_76 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_77 = ", must have ";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = "\");" + NL + "    }";
  protected final String TEXT_80 = "$this->";
  protected final String TEXT_81 = " = array();" + NL + "    $this->";
  protected final String TEXT_82 = "[] = $";
  protected final String TEXT_83 = ";";
  protected final String TEXT_84 = NL + "    $this->";
  protected final String TEXT_85 = "(self::$";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "    if ($this->";
  protected final String TEXT_88 = " == null) { $this->";
  protected final String TEXT_89 = "(self::$";
  protected final String TEXT_90 = "); }";
  protected final String TEXT_91 = NL + "  public static function getInstance()" + NL + "  {" + NL + "    if(self::$theInstance == null)" + NL + "    {" + NL + "      self::$theInstance = new ";
  protected final String TEXT_92 = "();" + NL + "    }" + NL + "    return self::$theInstance;" + NL + "  }";
  protected final String TEXT_93 = NL + "  public static function newInstance(";
  protected final String TEXT_94 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_95 = " = new ";
  protected final String TEXT_96 = "();";
  protected final String TEXT_97 = NL + "    $";
  protected final String TEXT_98 = "->";
  protected final String TEXT_99 = " = array();";
  protected final String TEXT_100 = NL + "    $this->";
  protected final String TEXT_101 = "();";
  protected final String TEXT_102 = NL + "    $";
  protected final String TEXT_103 = "->";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ";";
  protected final String TEXT_106 = NL + "    $";
  protected final String TEXT_107 = "->";
  protected final String TEXT_108 = " = self::$";
  protected final String TEXT_109 = "++;";
  protected final String TEXT_110 = NL + "    $";
  protected final String TEXT_111 = "->";
  protected final String TEXT_112 = " = new ";
  protected final String TEXT_113 = "(";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "    $";
  protected final String TEXT_116 = "->";
  protected final String TEXT_117 = " = array();" + NL + "    $";
  protected final String TEXT_118 = " = $";
  protected final String TEXT_119 = "->";
  protected final String TEXT_120 = "($";
  protected final String TEXT_121 = ");" + NL + "    if (!$";
  protected final String TEXT_122 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_123 = ", must have ";
  protected final String TEXT_124 = " ";
  protected final String TEXT_125 = "\");" + NL + "    }";
  protected final String TEXT_126 = "$this->";
  protected final String TEXT_127 = " = array();" + NL + "    $this->";
  protected final String TEXT_128 = "[] = $";
  protected final String TEXT_129 = ";";
  protected final String TEXT_130 = NL + "  private function callParentConstructor(";
  protected final String TEXT_131 = ")" + NL + "  {" + NL + "    parent::__construct(";
  protected final String TEXT_132 = ");" + NL + "  }" + NL;
  protected final String TEXT_133 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_134 = NL + "  public function ";
  protected final String TEXT_135 = "($";
  protected final String TEXT_136 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_137 = NL + "    $this->";
  protected final String TEXT_138 = " = false;" + NL + "    $this->";
  protected final String TEXT_139 = " = $";
  protected final String TEXT_140 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_141 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_142 = NL + "  public function ";
  protected final String TEXT_143 = "($";
  protected final String TEXT_144 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_145 = NL + "    $this->";
  protected final String TEXT_146 = " = $";
  protected final String TEXT_147 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_148 = NL + "    return $wasSet;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_149 = "()" + NL + "  {" + NL + "    $wasReset = false;";
  protected final String TEXT_150 = NL + "    $this->";
  protected final String TEXT_151 = " = $this->";
  protected final String TEXT_152 = "();" + NL + "    $wasReset = true;";
  protected final String TEXT_153 = NL + "    return $wasReset;" + NL + "  }" + NL;
  protected final String TEXT_154 = NL + "  public function ";
  protected final String TEXT_155 = "($";
  protected final String TEXT_156 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_157 = NL + "    $this->";
  protected final String TEXT_158 = "[] = $";
  protected final String TEXT_159 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_160 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_161 = "($";
  protected final String TEXT_162 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_163 = NL + "    unset($this->";
  protected final String TEXT_164 = "[$this->";
  protected final String TEXT_165 = "($";
  protected final String TEXT_166 = ")]);" + NL + "    $this->";
  protected final String TEXT_167 = " = array_values($this->";
  protected final String TEXT_168 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_169 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_170 = NL + "  public function ";
  protected final String TEXT_171 = "($";
  protected final String TEXT_172 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_173 = NL + "    $this->";
  protected final String TEXT_174 = " = $";
  protected final String TEXT_175 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_176 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_177 = NL + "  public function ";
  protected final String TEXT_178 = "($index)" + NL + "  {";
  protected final String TEXT_179 = NL + "    $";
  protected final String TEXT_180 = " = $this->";
  protected final String TEXT_181 = "[$index];";
  protected final String TEXT_182 = NL + "    return $";
  protected final String TEXT_183 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_184 = "()" + NL + "  {";
  protected final String TEXT_185 = NL + "    $";
  protected final String TEXT_186 = " = $this->";
  protected final String TEXT_187 = ";";
  protected final String TEXT_188 = NL + "    return $";
  protected final String TEXT_189 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_190 = "()" + NL + "  {";
  protected final String TEXT_191 = NL + "    $number = count($this->";
  protected final String TEXT_192 = ");";
  protected final String TEXT_193 = NL + "    return $number;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_194 = "()" + NL + "  {";
  protected final String TEXT_195 = NL + "    $has = ";
  protected final String TEXT_196 = ".size() > 0;";
  protected final String TEXT_197 = NL + "    return $has;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_198 = "($";
  protected final String TEXT_199 = ")" + NL + "  {";
  protected final String TEXT_200 = NL + "    $rawAnswer = array_search($";
  protected final String TEXT_201 = ",$this->";
  protected final String TEXT_202 = ");" + NL + "    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;";
  protected final String TEXT_203 = NL + "    return $index;" + NL + "  }" + NL;
  protected final String TEXT_204 = NL + "  public function ";
  protected final String TEXT_205 = "()" + NL + "  {";
  protected final String TEXT_206 = NL + "    $";
  protected final String TEXT_207 = " = ";
  protected final String TEXT_208 = ";";
  protected final String TEXT_209 = NL + "    return $";
  protected final String TEXT_210 = ";" + NL + "  }";
  protected final String TEXT_211 = NL + "  public function ";
  protected final String TEXT_212 = "()" + NL + "  {";
  protected final String TEXT_213 = NL + "    return ";
  protected final String TEXT_214 = ";" + NL + "  }";
  protected final String TEXT_215 = NL + "  public function ";
  protected final String TEXT_216 = "()" + NL + "  {";
  protected final String TEXT_217 = NL + "    $";
  protected final String TEXT_218 = " = $this->";
  protected final String TEXT_219 = ";";
  protected final String TEXT_220 = NL + "    return $";
  protected final String TEXT_221 = ";" + NL + "  }";
  protected final String TEXT_222 = NL + "  public function ";
  protected final String TEXT_223 = "()" + NL + "  {";
  protected final String TEXT_224 = NL + "    return $this->";
  protected final String TEXT_225 = ";" + NL + "  }";
  protected final String TEXT_226 = NL + "  public function ";
  protected final String TEXT_227 = "()" + NL + "  {";
  protected final String TEXT_228 = NL + "    $";
  protected final String TEXT_229 = " = ";
  protected final String TEXT_230 = ";";
  protected final String TEXT_231 = NL + "    return $";
  protected final String TEXT_232 = ";" + NL + "  }" + NL;
  protected final String TEXT_233 = NL + "  public function ";
  protected final String TEXT_234 = "()" + NL + "  {";
  protected final String TEXT_235 = NL + "    return ";
  protected final String TEXT_236 = ";" + NL + "  }" + NL;
  protected final String TEXT_237 = NL + "  public function ";
  protected final String TEXT_238 = "()" + NL + "  {";
  protected final String TEXT_239 = NL + "    $";
  protected final String TEXT_240 = " = $this->";
  protected final String TEXT_241 = ";";
  protected final String TEXT_242 = NL + "    return $";
  protected final String TEXT_243 = ";" + NL + "  }";
  protected final String TEXT_244 = NL + "  public function ";
  protected final String TEXT_245 = "()" + NL + "  {";
  protected final String TEXT_246 = NL + "    return $this->";
  protected final String TEXT_247 = ";" + NL + "  }";
  protected final String TEXT_248 = NL + "  public function ";
  protected final String TEXT_249 = "()" + NL + "  {";
  protected final String TEXT_250 = NL + "    return null;" + NL + "  }" + NL;
  protected final String TEXT_251 = NL + "  public function ";
  protected final String TEXT_252 = "()" + NL + "  {" + NL + "    $wasEventProcessed = false;" + NL;
  protected final String TEXT_253 = NL + "    ";
  protected final String TEXT_254 = NL + NL + "    return $wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_255 = NL + "  public function ";
  protected final String TEXT_256 = "($";
  protected final String TEXT_257 = ")" + NL + "  {";
  protected final String TEXT_258 = NL + "    ";
  protected final String TEXT_259 = NL + "    else" + NL + "    {" + NL + "      return false;" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_260 = NL + "  private function ";
  protected final String TEXT_261 = "()" + NL + "  {";
  protected final String TEXT_262 = NL + "    ";
  protected final String TEXT_263 = NL + "  }" + NL;
  protected final String TEXT_264 = NL + "  private function ";
  protected final String TEXT_265 = "($";
  protected final String TEXT_266 = ")" + NL + "  {" + NL + "    $this->";
  protected final String TEXT_267 = " = $";
  protected final String TEXT_268 = ";";
  protected final String TEXT_269 = NL + NL + "    // entry actions and do activities";
  protected final String TEXT_270 = NL + "    ";
  protected final String TEXT_271 = NL + "  }" + NL;
  protected final String TEXT_272 = NL + "  public function ";
  protected final String TEXT_273 = "()" + NL + "  {";
  protected final String TEXT_274 = NL + "    return $this->";
  protected final String TEXT_275 = ";";
  protected final String TEXT_276 = NL + "    $";
  protected final String TEXT_277 = " = $this->";
  protected final String TEXT_278 = ";";
  protected final String TEXT_279 = NL + "    return $";
  protected final String TEXT_280 = ";";
  protected final String TEXT_281 = NL + "  }" + NL;
  protected final String TEXT_282 = NL + "  public function ";
  protected final String TEXT_283 = "($index)" + NL + "  {";
  protected final String TEXT_284 = NL + "    $";
  protected final String TEXT_285 = " = $this->";
  protected final String TEXT_286 = "[$index];";
  protected final String TEXT_287 = NL + "    return $";
  protected final String TEXT_288 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_289 = "()" + NL + "  {";
  protected final String TEXT_290 = NL + "    $";
  protected final String TEXT_291 = " = $this->";
  protected final String TEXT_292 = ";";
  protected final String TEXT_293 = NL + "    return $";
  protected final String TEXT_294 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_295 = "()" + NL + "  {";
  protected final String TEXT_296 = NL + "    $number = count($this->";
  protected final String TEXT_297 = ");";
  protected final String TEXT_298 = NL + "    return $number;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_299 = "()" + NL + "  {";
  protected final String TEXT_300 = NL + "    $has = $this->";
  protected final String TEXT_301 = "() > 0;";
  protected final String TEXT_302 = NL + "    return $has;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_303 = "($";
  protected final String TEXT_304 = ")" + NL + "  {";
  protected final String TEXT_305 = NL + "    $wasFound = false;" + NL + "    $index = 0;" + NL + "    foreach($this->";
  protected final String TEXT_306 = " as $";
  protected final String TEXT_307 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_308 = "->equals($";
  protected final String TEXT_309 = "))" + NL + "      {" + NL + "        $wasFound = true;" + NL + "        break;" + NL + "      }" + NL + "      $index += 1;" + NL + "    }" + NL + "    $index = $wasFound ? $index : -1;";
  protected final String TEXT_310 = NL + "    return $index;" + NL + "  }" + NL;
  protected final String TEXT_311 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_312 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_313 = " : ";
  protected final String TEXT_314 = NL + "  public function ";
  protected final String TEXT_315 = "()" + NL + "  {";
  protected final String TEXT_316 = NL + "    $isValid = $this->";
  protected final String TEXT_317 = "() >= self::";
  protected final String TEXT_318 = "();";
  protected final String TEXT_319 = NL + "    $isValid = $this->";
  protected final String TEXT_320 = "() >= self::";
  protected final String TEXT_321 = "() && $this->";
  protected final String TEXT_322 = "() <= self::";
  protected final String TEXT_323 = "();";
  protected final String TEXT_324 = NL + "    return $isValid;" + NL + "  }";
  protected final String TEXT_325 = NL + "  public static function ";
  protected final String TEXT_326 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_327 = ";" + NL + "  }";
  protected final String TEXT_328 = NL + "  public static function ";
  protected final String TEXT_329 = "()" + NL + "  {";
  protected final String TEXT_330 = NL + "    $minimum = ";
  protected final String TEXT_331 = ";";
  protected final String TEXT_332 = NL + "    return $minimum;" + NL + "  }";
  protected final String TEXT_333 = NL + "  public static function ";
  protected final String TEXT_334 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_335 = ";" + NL + "  }";
  protected final String TEXT_336 = NL + "  public static function ";
  protected final String TEXT_337 = "()" + NL + "  {";
  protected final String TEXT_338 = NL + "    $minimum = ";
  protected final String TEXT_339 = ";";
  protected final String TEXT_340 = NL + "    return $minimum;" + NL + "  }";
  protected final String TEXT_341 = NL + "  public static function ";
  protected final String TEXT_342 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_343 = ";" + NL + "  }";
  protected final String TEXT_344 = NL + "  public static function ";
  protected final String TEXT_345 = "()" + NL + "  {";
  protected final String TEXT_346 = NL + "    $maximum = ";
  protected final String TEXT_347 = ";";
  protected final String TEXT_348 = NL + "    return $maximum;" + NL + "  }";
  protected final String TEXT_349 = NL + "  public function ";
  protected final String TEXT_350 = "($";
  protected final String TEXT_351 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_352 = NL + "    if ($this->";
  protected final String TEXT_353 = "() >= self::";
  protected final String TEXT_354 = "())" + NL + "    {";
  protected final String TEXT_355 = NL + "      return $wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_356 = NL + "    $this->";
  protected final String TEXT_357 = "[] = $";
  protected final String TEXT_358 = ";" + NL + "    if ($";
  protected final String TEXT_359 = "->";
  protected final String TEXT_360 = "($this) != -1)" + NL + "    {" + NL + "      $wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasAdded = $";
  protected final String TEXT_361 = "->";
  protected final String TEXT_362 = "($this);" + NL + "      if (!$wasAdded)" + NL + "      {" + NL + "        array_pop($this->";
  protected final String TEXT_363 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_364 = NL + "    return $wasAdded;" + NL + "  }";
  protected final String TEXT_365 = NL + "  public function ";
  protected final String TEXT_366 = "($";
  protected final String TEXT_367 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_368 = NL + "    if ($this->";
  protected final String TEXT_369 = "($";
  protected final String TEXT_370 = ") == -1)" + NL + "    {";
  protected final String TEXT_371 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_372 = "($";
  protected final String TEXT_373 = ");" + NL + "    unset($this->";
  protected final String TEXT_374 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_375 = "->";
  protected final String TEXT_376 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_377 = "->";
  protected final String TEXT_378 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_379 = "[$oldIndex] = $";
  protected final String TEXT_380 = ";" + NL + "        ksort($this->";
  protected final String TEXT_381 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_382 = " = array_values($this->";
  protected final String TEXT_383 = ");";
  protected final String TEXT_384 = NL + "    return $wasRemoved;" + NL + "  }";
  protected final String TEXT_385 = NL + "  public function ";
  protected final String TEXT_386 = "($";
  protected final String TEXT_387 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_388 = NL + "    $this->";
  protected final String TEXT_389 = " = $";
  protected final String TEXT_390 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_391 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_392 = NL + "  public function ";
  protected final String TEXT_393 = "($";
  protected final String TEXT_394 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_395 = NL + "    if ($";
  protected final String TEXT_396 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_397 = " = $";
  protected final String TEXT_398 = ";" + NL + "      $wasSet = true;" + NL + "    }";
  protected final String TEXT_399 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_400 = NL + "  public function ";
  protected final String TEXT_401 = "($";
  protected final String TEXT_402 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_403 = NL + "    if ($this->";
  protected final String TEXT_404 = " != null && $this->";
  protected final String TEXT_405 = " != $";
  protected final String TEXT_406 = " && $this == $this->";
  protected final String TEXT_407 = "->";
  protected final String TEXT_408 = "())" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_409 = ", as existing ";
  protected final String TEXT_410 = " would become an orphan";
  protected final String TEXT_411 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $this->";
  protected final String TEXT_412 = " = $";
  protected final String TEXT_413 = ";" + NL + "    $";
  protected final String TEXT_414 = " = $";
  protected final String TEXT_415 = " != null ? $";
  protected final String TEXT_416 = "->";
  protected final String TEXT_417 = "() : null;" + NL + "    " + NL + "    if ($this != $";
  protected final String TEXT_418 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_419 = " != null)" + NL + "      {" + NL + "        $";
  protected final String TEXT_420 = "->";
  protected final String TEXT_421 = " = null;" + NL + "      }" + NL + "      if ($this->";
  protected final String TEXT_422 = " != null)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_423 = "->";
  protected final String TEXT_424 = "($this);" + NL + "      }" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_425 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_426 = NL + "  public function ";
  protected final String TEXT_427 = "($";
  protected final String TEXT_428 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_429 = NL + "    if ($";
  protected final String TEXT_430 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_431 = " to null, as ";
  protected final String TEXT_432 = " must always be associated to a ";
  protected final String TEXT_433 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_434 = " = $";
  protected final String TEXT_435 = "->";
  protected final String TEXT_436 = "();" + NL + "    if ($";
  protected final String TEXT_437 = " != null && $this != $";
  protected final String TEXT_438 = ")" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_439 = ", the current ";
  protected final String TEXT_440 = " already has a ";
  protected final String TEXT_441 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_442 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_443 = " = $this->";
  protected final String TEXT_444 = ";" + NL + "    $this->";
  protected final String TEXT_445 = " = $";
  protected final String TEXT_446 = ";" + NL + "    $this->";
  protected final String TEXT_447 = "->";
  protected final String TEXT_448 = "($this);" + NL + "    " + NL + "    if ($";
  protected final String TEXT_449 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_450 = "->";
  protected final String TEXT_451 = "(null);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_452 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_453 = NL + "  public function ";
  protected final String TEXT_454 = "(";
  protected final String TEXT_455 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_456 = "(";
  protected final String TEXT_457 = ");" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_458 = "($";
  protected final String TEXT_459 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_460 = NL + "    $";
  protected final String TEXT_461 = " = $";
  protected final String TEXT_462 = "->";
  protected final String TEXT_463 = "();" + NL + "    $";
  protected final String TEXT_464 = " = $";
  protected final String TEXT_465 = " != null && $this !== $";
  protected final String TEXT_466 = ";" + NL + "" + NL + "    if ($";
  protected final String TEXT_467 = " && $";
  protected final String TEXT_468 = "->";
  protected final String TEXT_469 = "() <= self::";
  protected final String TEXT_470 = "())" + NL + "    {" + NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    if ($";
  protected final String TEXT_471 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_472 = "->";
  protected final String TEXT_473 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_474 = "[] = $";
  protected final String TEXT_475 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_476 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_477 = "($";
  protected final String TEXT_478 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_479 = NL + "    //Unable to remove ";
  protected final String TEXT_480 = ", as it must always have a ";
  protected final String TEXT_481 = NL + "    if ($this === $";
  protected final String TEXT_482 = "->";
  protected final String TEXT_483 = "())" + NL + "    {";
  protected final String TEXT_484 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_485 = " already at minimum (";
  protected final String TEXT_486 = ")" + NL + "    if ($this->";
  protected final String TEXT_487 = "() <= self::";
  protected final String TEXT_488 = "())" + NL + "    {";
  protected final String TEXT_489 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_490 = "[$this->";
  protected final String TEXT_491 = "($";
  protected final String TEXT_492 = ")]);" + NL + "    $this->";
  protected final String TEXT_493 = " = array_values($this->";
  protected final String TEXT_494 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_495 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_496 = NL + "  public function ";
  protected final String TEXT_497 = "(";
  protected final String TEXT_498 = ")" + NL + "  {" + NL + "    if ($this->";
  protected final String TEXT_499 = "() >= self::";
  protected final String TEXT_500 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_501 = "(";
  protected final String TEXT_502 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_503 = "($";
  protected final String TEXT_504 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_505 = NL + "    if ($this->";
  protected final String TEXT_506 = "() >= self::";
  protected final String TEXT_507 = "())" + NL + "    {";
  protected final String TEXT_508 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_509 = " = $";
  protected final String TEXT_510 = "->";
  protected final String TEXT_511 = "();" + NL + "    $";
  protected final String TEXT_512 = " = $";
  protected final String TEXT_513 = " != null && $this !== $";
  protected final String TEXT_514 = ";" + NL + "" + NL + "    if ($";
  protected final String TEXT_515 = " && $";
  protected final String TEXT_516 = "->";
  protected final String TEXT_517 = "() <= self::";
  protected final String TEXT_518 = "())" + NL + "    {";
  protected final String TEXT_519 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    if ($";
  protected final String TEXT_520 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_521 = "->";
  protected final String TEXT_522 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_523 = "[] = $";
  protected final String TEXT_524 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_525 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_526 = "($";
  protected final String TEXT_527 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_528 = NL + "    //Unable to remove ";
  protected final String TEXT_529 = ", as it must always have a ";
  protected final String TEXT_530 = NL + "    if ($this === $";
  protected final String TEXT_531 = "->";
  protected final String TEXT_532 = "())" + NL + "    {";
  protected final String TEXT_533 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_534 = " already at minimum (";
  protected final String TEXT_535 = ")" + NL + "    if ($this->";
  protected final String TEXT_536 = "() <= self::";
  protected final String TEXT_537 = "())" + NL + "    {";
  protected final String TEXT_538 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_539 = "[$this->";
  protected final String TEXT_540 = "($";
  protected final String TEXT_541 = ")]);" + NL + "    $this->";
  protected final String TEXT_542 = " = array_values($this->";
  protected final String TEXT_543 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_544 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_545 = NL + "  public function ";
  protected final String TEXT_546 = "(";
  protected final String TEXT_547 = ")" + NL + "  {" + NL + "    if ($this->";
  protected final String TEXT_548 = "() >= self::";
  protected final String TEXT_549 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_550 = "(";
  protected final String TEXT_551 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_552 = "($";
  protected final String TEXT_553 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_554 = NL + "    if ($this->";
  protected final String TEXT_555 = "() >= self::";
  protected final String TEXT_556 = "())" + NL + "    {";
  protected final String TEXT_557 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_558 = " = $";
  protected final String TEXT_559 = "->";
  protected final String TEXT_560 = "();" + NL + "    $";
  protected final String TEXT_561 = " = $";
  protected final String TEXT_562 = " != null && $this !== $";
  protected final String TEXT_563 = ";" + NL + "    if ($";
  protected final String TEXT_564 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_565 = "->";
  protected final String TEXT_566 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_567 = "[] = $";
  protected final String TEXT_568 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_569 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_570 = "($";
  protected final String TEXT_571 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_572 = NL + "    //Unable to remove ";
  protected final String TEXT_573 = ", as it must always have a ";
  protected final String TEXT_574 = NL + "    if ($this !== $";
  protected final String TEXT_575 = "->";
  protected final String TEXT_576 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_577 = "[$this->";
  protected final String TEXT_578 = "($";
  protected final String TEXT_579 = ")]);" + NL + "      $this->";
  protected final String TEXT_580 = " = array_values($this->";
  protected final String TEXT_581 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_582 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_583 = NL + "  public function ";
  protected final String TEXT_584 = "($";
  protected final String TEXT_585 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_586 = NL + "    $";
  protected final String TEXT_587 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_588 = " as $";
  protected final String TEXT_589 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_590 = ",$";
  protected final String TEXT_591 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_592 = "[] = $";
  protected final String TEXT_593 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_594 = ") != count($";
  protected final String TEXT_595 = ") || count($";
  protected final String TEXT_596 = ") > self::";
  protected final String TEXT_597 = "())" + NL + "    {";
  protected final String TEXT_598 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_599 = " = $this->";
  protected final String TEXT_600 = ";" + NL + "    $this->";
  protected final String TEXT_601 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_602 = " as $";
  protected final String TEXT_603 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_604 = "[] = $";
  protected final String TEXT_605 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_606 = ",$";
  protected final String TEXT_607 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_608 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_609 = " = array_values($";
  protected final String TEXT_610 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_611 = "->";
  protected final String TEXT_612 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_613 = " as $";
  protected final String TEXT_614 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_615 = "->";
  protected final String TEXT_616 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_617 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_618 = NL + "  public function ";
  protected final String TEXT_619 = "(";
  protected final String TEXT_620 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_621 = "(";
  protected final String TEXT_622 = ");" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_623 = "($";
  protected final String TEXT_624 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_625 = NL + "    $";
  protected final String TEXT_626 = " = $";
  protected final String TEXT_627 = "->";
  protected final String TEXT_628 = "();" + NL + "    $";
  protected final String TEXT_629 = " = $";
  protected final String TEXT_630 = " != null && $this !== $";
  protected final String TEXT_631 = ";" + NL + "    if ($";
  protected final String TEXT_632 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_633 = "->";
  protected final String TEXT_634 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_635 = "[] = $";
  protected final String TEXT_636 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_637 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_638 = "($";
  protected final String TEXT_639 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_640 = NL + "    //Unable to remove ";
  protected final String TEXT_641 = ", as it must always have a ";
  protected final String TEXT_642 = NL + "    if ($this !== $";
  protected final String TEXT_643 = "->";
  protected final String TEXT_644 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_645 = "[$this->";
  protected final String TEXT_646 = "($";
  protected final String TEXT_647 = ")]);" + NL + "      $this->";
  protected final String TEXT_648 = " = array_values($this->";
  protected final String TEXT_649 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_650 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_651 = NL + "  public function ";
  protected final String TEXT_652 = "($";
  protected final String TEXT_653 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_654 = NL + "    if ($";
  protected final String TEXT_655 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_656 = " = $this->";
  protected final String TEXT_657 = ";" + NL + "      $this->";
  protected final String TEXT_658 = " = null;" + NL + "      " + NL + "      if ($";
  protected final String TEXT_659 = " != null && $";
  protected final String TEXT_660 = "->";
  protected final String TEXT_661 = "() != null)" + NL + "      {" + NL + "        $";
  protected final String TEXT_662 = "->";
  protected final String TEXT_663 = "(null);" + NL + "      }" + NL + "      $wasSet = true;";
  protected final String TEXT_664 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_665 = " = $this->";
  protected final String TEXT_666 = "();" + NL + "    if ($";
  protected final String TEXT_667 = " != null && $";
  protected final String TEXT_668 = " != $";
  protected final String TEXT_669 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_670 = "->";
  protected final String TEXT_671 = "(null);" + NL + "    }" + NL + "    " + NL + "    $this->";
  protected final String TEXT_672 = " = $";
  protected final String TEXT_673 = ";" + NL + "    $";
  protected final String TEXT_674 = " = $";
  protected final String TEXT_675 = "->";
  protected final String TEXT_676 = "();" + NL + "    " + NL + "    if ($this != $";
  protected final String TEXT_677 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_678 = "->";
  protected final String TEXT_679 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_680 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_681 = NL + "  public function ";
  protected final String TEXT_682 = "($";
  protected final String TEXT_683 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_684 = NL + "    if ($this->";
  protected final String TEXT_685 = "($";
  protected final String TEXT_686 = ") == -1)" + NL + "    {";
  protected final String TEXT_687 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_688 = "() <= self::";
  protected final String TEXT_689 = "())" + NL + "    {";
  protected final String TEXT_690 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_691 = "($";
  protected final String TEXT_692 = ");" + NL + "    unset($this->";
  protected final String TEXT_693 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_694 = "->";
  protected final String TEXT_695 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_696 = "->";
  protected final String TEXT_697 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_698 = "[$oldIndex] = $";
  protected final String TEXT_699 = ";" + NL + "        ksort($this->";
  protected final String TEXT_700 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_701 = " = array_values($this->";
  protected final String TEXT_702 = ");";
  protected final String TEXT_703 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_704 = NL + "  public function ";
  protected final String TEXT_705 = "($";
  protected final String TEXT_706 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_707 = NL + "    if ($this->";
  protected final String TEXT_708 = "($";
  protected final String TEXT_709 = ") == -1)" + NL + "    {";
  protected final String TEXT_710 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_711 = "() <= self::";
  protected final String TEXT_712 = "())" + NL + "    {";
  protected final String TEXT_713 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_714 = "($";
  protected final String TEXT_715 = ");" + NL + "    unset($this->";
  protected final String TEXT_716 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_717 = "->";
  protected final String TEXT_718 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_719 = "->";
  protected final String TEXT_720 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_721 = "[$oldIndex] = $";
  protected final String TEXT_722 = ";" + NL + "        ksort($this->";
  protected final String TEXT_723 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_724 = " = array_values($this->";
  protected final String TEXT_725 = ");";
  protected final String TEXT_726 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_727 = NL + "  public function ";
  protected final String TEXT_728 = "($";
  protected final String TEXT_729 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_730 = NL + "    if ($";
  protected final String TEXT_731 = " != null && $";
  protected final String TEXT_732 = "->";
  protected final String TEXT_733 = "() >= ";
  protected final String TEXT_734 = "::";
  protected final String TEXT_735 = "())" + NL + "    {";
  protected final String TEXT_736 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_737 = " = $this->";
  protected final String TEXT_738 = ";" + NL + "    $this->";
  protected final String TEXT_739 = " = $";
  protected final String TEXT_740 = ";" + NL + "    if ($";
  protected final String TEXT_741 = " != null && $";
  protected final String TEXT_742 = " != $";
  protected final String TEXT_743 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_744 = "->";
  protected final String TEXT_745 = "($this);" + NL + "    }" + NL + "    if ($";
  protected final String TEXT_746 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_747 = "->";
  protected final String TEXT_748 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_749 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_750 = NL + "  public function ";
  protected final String TEXT_751 = "($";
  protected final String TEXT_752 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_753 = NL + "    if ($";
  protected final String TEXT_754 = " == null)" + NL + "    {";
  protected final String TEXT_755 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_756 = " = $this->";
  protected final String TEXT_757 = ";" + NL + "    $this->";
  protected final String TEXT_758 = " = $";
  protected final String TEXT_759 = ";" + NL + "    if ($";
  protected final String TEXT_760 = " != null && $";
  protected final String TEXT_761 = " != $";
  protected final String TEXT_762 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_763 = "->";
  protected final String TEXT_764 = "($this);" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_765 = "->";
  protected final String TEXT_766 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_767 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_768 = NL + "  public function ";
  protected final String TEXT_769 = "($";
  protected final String TEXT_770 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_771 = NL + "    //Must provide ";
  protected final String TEXT_772 = " to ";
  protected final String TEXT_773 = NL + "    if ($";
  protected final String TEXT_774 = " == null)" + NL + "    {";
  protected final String TEXT_775 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_776 = " already at maximum (";
  protected final String TEXT_777 = ")" + NL + "    if ($";
  protected final String TEXT_778 = "->";
  protected final String TEXT_779 = "() >= ";
  protected final String TEXT_780 = "::";
  protected final String TEXT_781 = "())" + NL + "    {";
  protected final String TEXT_782 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_783 = " = $this->";
  protected final String TEXT_784 = ";" + NL + "    $this->";
  protected final String TEXT_785 = " = $";
  protected final String TEXT_786 = ";" + NL + "    if ($";
  protected final String TEXT_787 = " != null && $";
  protected final String TEXT_788 = " != $";
  protected final String TEXT_789 = ")" + NL + "    {" + NL + "      $didRemove = $";
  protected final String TEXT_790 = "->";
  protected final String TEXT_791 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_792 = " = $";
  protected final String TEXT_793 = ";";
  protected final String TEXT_794 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_795 = "->";
  protected final String TEXT_796 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_797 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_798 = NL + "  public function ";
  protected final String TEXT_799 = "($";
  protected final String TEXT_800 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_801 = NL + "    //Must provide ";
  protected final String TEXT_802 = " to ";
  protected final String TEXT_803 = NL + "    if ($";
  protected final String TEXT_804 = " == null)" + NL + "    {";
  protected final String TEXT_805 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_806 = " != null && $this->";
  protected final String TEXT_807 = "->";
  protected final String TEXT_808 = "() <= ";
  protected final String TEXT_809 = "::";
  protected final String TEXT_810 = "())" + NL + "    {";
  protected final String TEXT_811 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_812 = " = $this->";
  protected final String TEXT_813 = ";" + NL + "    $this->";
  protected final String TEXT_814 = " = $";
  protected final String TEXT_815 = ";" + NL + "    if ($";
  protected final String TEXT_816 = " != null && $";
  protected final String TEXT_817 = " != $";
  protected final String TEXT_818 = ")" + NL + "    {" + NL + "      $didRemove = $";
  protected final String TEXT_819 = "->";
  protected final String TEXT_820 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_821 = " = $";
  protected final String TEXT_822 = ";";
  protected final String TEXT_823 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_824 = "->";
  protected final String TEXT_825 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_826 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_827 = NL + "  public function ";
  protected final String TEXT_828 = "($";
  protected final String TEXT_829 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_830 = NL + "    $";
  protected final String TEXT_831 = " = $";
  protected final String TEXT_832 = "->";
  protected final String TEXT_833 = "();" + NL + "    if ($";
  protected final String TEXT_834 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_835 = "->";
  protected final String TEXT_836 = "($this);" + NL + "    }" + NL + "    elseif ($this !== $";
  protected final String TEXT_837 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_838 = "->";
  protected final String TEXT_839 = "($";
  protected final String TEXT_840 = ");" + NL + "      $this->";
  protected final String TEXT_841 = "($";
  protected final String TEXT_842 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_843 = "[] = $";
  protected final String TEXT_844 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_845 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_846 = "($";
  protected final String TEXT_847 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_848 = NL + "    if ($this->";
  protected final String TEXT_849 = "($";
  protected final String TEXT_850 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_851 = "[$this->";
  protected final String TEXT_852 = "($";
  protected final String TEXT_853 = ")]);" + NL + "      $this->";
  protected final String TEXT_854 = " = array_values($this->";
  protected final String TEXT_855 = ");" + NL + "      if ($this === $";
  protected final String TEXT_856 = "->";
  protected final String TEXT_857 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_858 = "->";
  protected final String TEXT_859 = "(null);" + NL + "      }" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_860 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_861 = NL + "  public function ";
  protected final String TEXT_862 = "($";
  protected final String TEXT_863 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_864 = NL + "    $";
  protected final String TEXT_865 = " = $this->";
  protected final String TEXT_866 = ";" + NL + "    $this->";
  protected final String TEXT_867 = " = $";
  protected final String TEXT_868 = ";" + NL + "    if ($";
  protected final String TEXT_869 = " != null && $";
  protected final String TEXT_870 = " !== $";
  protected final String TEXT_871 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_872 = "->";
  protected final String TEXT_873 = "($this);" + NL + "    }" + NL + "    if ($";
  protected final String TEXT_874 = " != null && $";
  protected final String TEXT_875 = " !== $";
  protected final String TEXT_876 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_877 = "->";
  protected final String TEXT_878 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_879 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_880 = NL + "  public function ";
  protected final String TEXT_881 = "($";
  protected final String TEXT_882 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_883 = NL + "    if ($this->";
  protected final String TEXT_884 = "() >= self::";
  protected final String TEXT_885 = "())" + NL + "    {";
  protected final String TEXT_886 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_887 = " = $";
  protected final String TEXT_888 = "->";
  protected final String TEXT_889 = "();" + NL + "    if ($";
  protected final String TEXT_890 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_891 = "->";
  protected final String TEXT_892 = "($this);" + NL + "    }" + NL + "    else if ($this !== $";
  protected final String TEXT_893 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_894 = "->";
  protected final String TEXT_895 = "($";
  protected final String TEXT_896 = ");" + NL + "      $this->";
  protected final String TEXT_897 = "($";
  protected final String TEXT_898 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_899 = "[] = $";
  protected final String TEXT_900 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_901 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_902 = "($";
  protected final String TEXT_903 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_904 = NL + "    if ($this->";
  protected final String TEXT_905 = "($";
  protected final String TEXT_906 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_907 = "[$this->";
  protected final String TEXT_908 = "($";
  protected final String TEXT_909 = ")]);" + NL + "      $this->";
  protected final String TEXT_910 = " = array_values($this->";
  protected final String TEXT_911 = ");" + NL + "      $";
  protected final String TEXT_912 = "->";
  protected final String TEXT_913 = "(null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_914 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_915 = NL + "  public function ";
  protected final String TEXT_916 = "($";
  protected final String TEXT_917 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_918 = NL + "    if ($this->";
  protected final String TEXT_919 = "() < self::";
  protected final String TEXT_920 = "())" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_921 = "[] = $";
  protected final String TEXT_922 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  protected final String TEXT_923 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_924 = "($";
  protected final String TEXT_925 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_926 = NL + "    if ($this->";
  protected final String TEXT_927 = "($";
  protected final String TEXT_928 = ") == -1)" + NL + "    {";
  protected final String TEXT_929 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_930 = "() <= self::";
  protected final String TEXT_931 = "())" + NL + "    {";
  protected final String TEXT_932 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_933 = "[$this->";
  protected final String TEXT_934 = "($";
  protected final String TEXT_935 = ")]);" + NL + "    $this->";
  protected final String TEXT_936 = " = array_values($this->";
  protected final String TEXT_937 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_938 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_939 = NL + "  public function ";
  protected final String TEXT_940 = "($";
  protected final String TEXT_941 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_942 = NL + "    if ($this->";
  protected final String TEXT_943 = "() >= self::";
  protected final String TEXT_944 = "())" + NL + "    {";
  protected final String TEXT_945 = NL + "      return $wasAdded;" + NL + "    }";
  protected final String TEXT_946 = NL + "    $";
  protected final String TEXT_947 = " = $";
  protected final String TEXT_948 = "->";
  protected final String TEXT_949 = "();" + NL + "    if ($";
  protected final String TEXT_950 = " != null && $";
  protected final String TEXT_951 = "->";
  protected final String TEXT_952 = "() <= self::";
  protected final String TEXT_953 = "())" + NL + "    {";
  protected final String TEXT_954 = NL + "      return $wasAdded;" + NL + "    }" + NL + "    else if ($";
  protected final String TEXT_955 = " != null)" + NL + "    {" + NL + "      unset($";
  protected final String TEXT_956 = "->";
  protected final String TEXT_957 = "[$";
  protected final String TEXT_958 = "->";
  protected final String TEXT_959 = "($";
  protected final String TEXT_960 = ")]);" + NL + "      $";
  protected final String TEXT_961 = "->";
  protected final String TEXT_962 = " = array_values($";
  protected final String TEXT_963 = "->";
  protected final String TEXT_964 = ");" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_965 = "[] = $";
  protected final String TEXT_966 = ";" + NL + "    $this->";
  protected final String TEXT_967 = "($";
  protected final String TEXT_968 = ",$this);" + NL + "    $wasAdded = true;";
  protected final String TEXT_969 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_970 = "($";
  protected final String TEXT_971 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_972 = NL + "    if ($this->";
  protected final String TEXT_973 = "($";
  protected final String TEXT_974 = ") != -1 && $this->";
  protected final String TEXT_975 = "() > self::";
  protected final String TEXT_976 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_977 = "[$this->";
  protected final String TEXT_978 = "($";
  protected final String TEXT_979 = ")]);" + NL + "      $this->";
  protected final String TEXT_980 = " = array_values($this->";
  protected final String TEXT_981 = ");" + NL + "      $this->";
  protected final String TEXT_982 = "($";
  protected final String TEXT_983 = ",null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_984 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_985 = NL + "  public function ";
  protected final String TEXT_986 = "($";
  protected final String TEXT_987 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_988 = NL + "    $";
  protected final String TEXT_989 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_990 = " as $";
  protected final String TEXT_991 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_992 = ",$";
  protected final String TEXT_993 = ") !== false)" + NL + "      {";
  protected final String TEXT_994 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  protected final String TEXT_995 = "->";
  protected final String TEXT_996 = "() != null && $this !== $";
  protected final String TEXT_997 = "->";
  protected final String TEXT_998 = "())" + NL + "      {";
  protected final String TEXT_999 = NL + "        return $wasSet;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1000 = "[] = $";
  protected final String TEXT_1001 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1002 = ") != self::";
  protected final String TEXT_1003 = "())" + NL + "    {";
  protected final String TEXT_1004 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    foreach ($this->";
  protected final String TEXT_1005 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  protected final String TEXT_1006 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + "" + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1007 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1008 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1009 = " as $";
  protected final String TEXT_1010 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1011 = "($";
  protected final String TEXT_1012 = ", $this);" + NL + "      $this->";
  protected final String TEXT_1013 = "[] = $";
  protected final String TEXT_1014 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1015 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1016 = NL + "  private function ";
  protected final String TEXT_1017 = "($";
  protected final String TEXT_1018 = ", $";
  protected final String TEXT_1019 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_1020 = "->mentor = $";
  protected final String TEXT_1021 = ";" + NL + "    //$prop = new ReflectionProperty($";
  protected final String TEXT_1022 = ", '";
  protected final String TEXT_1023 = "');" + NL + "    //$prop->setAccessible(true);" + NL + "    //$prop->setValue($";
  protected final String TEXT_1024 = ",$";
  protected final String TEXT_1025 = ");" + NL + "    //$prop->setAccessible(false);" + NL + "  }" + NL;
  protected final String TEXT_1026 = NL + "  public function ";
  protected final String TEXT_1027 = "($";
  protected final String TEXT_1028 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1029 = NL + "    $this->";
  protected final String TEXT_1030 = "[] = $";
  protected final String TEXT_1031 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_1032 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1033 = "($";
  protected final String TEXT_1034 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1035 = NL + "    if ($this->";
  protected final String TEXT_1036 = "($";
  protected final String TEXT_1037 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1038 = "[$this->";
  protected final String TEXT_1039 = "($";
  protected final String TEXT_1040 = ")]);" + NL + "      $this->";
  protected final String TEXT_1041 = " = array_values($this->";
  protected final String TEXT_1042 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1043 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1044 = NL + "  public function ";
  protected final String TEXT_1045 = "($";
  protected final String TEXT_1046 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1047 = NL + "    if ($this->";
  protected final String TEXT_1048 = "() < self::";
  protected final String TEXT_1049 = "())" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1050 = "[] = $";
  protected final String TEXT_1051 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  protected final String TEXT_1052 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1053 = "($";
  protected final String TEXT_1054 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1055 = NL + "    if ($this->";
  protected final String TEXT_1056 = "($";
  protected final String TEXT_1057 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1058 = "[$this->";
  protected final String TEXT_1059 = "($";
  protected final String TEXT_1060 = ")]);" + NL + "      $this->";
  protected final String TEXT_1061 = " = array_values($this->";
  protected final String TEXT_1062 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1063 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1064 = NL + "  public function ";
  protected final String TEXT_1065 = "($";
  protected final String TEXT_1066 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1067 = NL + "    $this->";
  protected final String TEXT_1068 = "[] = $";
  protected final String TEXT_1069 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_1070 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1071 = "($";
  protected final String TEXT_1072 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1073 = NL + "    if ($this->";
  protected final String TEXT_1074 = "($";
  protected final String TEXT_1075 = ") == -1)" + NL + "    {";
  protected final String TEXT_1076 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_1077 = "() <= self::";
  protected final String TEXT_1078 = "())" + NL + "    {";
  protected final String TEXT_1079 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_1080 = "[$this->";
  protected final String TEXT_1081 = "($";
  protected final String TEXT_1082 = ")]);" + NL + "    $this->";
  protected final String TEXT_1083 = " = array_values($this->";
  protected final String TEXT_1084 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_1085 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1086 = NL + "  public function ";
  protected final String TEXT_1087 = "($";
  protected final String TEXT_1088 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1089 = NL + "    $";
  protected final String TEXT_1090 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1091 = " as $";
  protected final String TEXT_1092 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1093 = ",$";
  protected final String TEXT_1094 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1095 = "[] = $";
  protected final String TEXT_1096 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1097 = ") != count($";
  protected final String TEXT_1098 = ") || count($";
  protected final String TEXT_1099 = ") != self::";
  protected final String TEXT_1100 = "())" + NL + "    {";
  protected final String TEXT_1101 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1102 = " = $";
  protected final String TEXT_1103 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1104 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1105 = NL + "  public function ";
  protected final String TEXT_1106 = "($";
  protected final String TEXT_1107 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1108 = NL + "    $";
  protected final String TEXT_1109 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1110 = " as $";
  protected final String TEXT_1111 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1112 = ",$";
  protected final String TEXT_1113 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1114 = "[] = $";
  protected final String TEXT_1115 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1116 = ") != count($";
  protected final String TEXT_1117 = ") || count($";
  protected final String TEXT_1118 = ") < self::";
  protected final String TEXT_1119 = "() || count($";
  protected final String TEXT_1120 = ") > self::";
  protected final String TEXT_1121 = "())" + NL + "    {";
  protected final String TEXT_1122 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1123 = " = $this->";
  protected final String TEXT_1124 = ";" + NL + "    $this->";
  protected final String TEXT_1125 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1126 = " as $";
  protected final String TEXT_1127 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1128 = "[] = $";
  protected final String TEXT_1129 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_1130 = ",$";
  protected final String TEXT_1131 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1132 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_1133 = " = array_values($";
  protected final String TEXT_1134 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1135 = "->";
  protected final String TEXT_1136 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_1137 = " as $";
  protected final String TEXT_1138 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1139 = "->";
  protected final String TEXT_1140 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1141 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1142 = NL + "  public function ";
  protected final String TEXT_1143 = "($";
  protected final String TEXT_1144 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1145 = NL + "    $";
  protected final String TEXT_1146 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1147 = " as $";
  protected final String TEXT_1148 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1149 = ",$";
  protected final String TEXT_1150 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1151 = "[] = $";
  protected final String TEXT_1152 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1153 = ") != count($";
  protected final String TEXT_1154 = ") || count($";
  protected final String TEXT_1155 = ") < self::";
  protected final String TEXT_1156 = "())" + NL + "    {";
  protected final String TEXT_1157 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1158 = " = $this->";
  protected final String TEXT_1159 = ";" + NL + "    $this->";
  protected final String TEXT_1160 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1161 = " as $";
  protected final String TEXT_1162 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1163 = "[] = $";
  protected final String TEXT_1164 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_1165 = ",$";
  protected final String TEXT_1166 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1167 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_1168 = " = array_values($";
  protected final String TEXT_1169 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1170 = "->";
  protected final String TEXT_1171 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_1172 = " as $";
  protected final String TEXT_1173 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1174 = "->";
  protected final String TEXT_1175 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1176 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1177 = NL + "  public function ";
  protected final String TEXT_1178 = "($";
  protected final String TEXT_1179 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1180 = NL + "    $";
  protected final String TEXT_1181 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1182 = " as $";
  protected final String TEXT_1183 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1184 = ",$";
  protected final String TEXT_1185 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1186 = "[] = $";
  protected final String TEXT_1187 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1188 = ") != count($";
  protected final String TEXT_1189 = ") || count($";
  protected final String TEXT_1190 = ") < self::";
  protected final String TEXT_1191 = "()  || count($";
  protected final String TEXT_1192 = ") > self::";
  protected final String TEXT_1193 = "())" + NL + "    {";
  protected final String TEXT_1194 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1195 = " = $";
  protected final String TEXT_1196 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1197 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1198 = NL + "  public function ";
  protected final String TEXT_1199 = "($";
  protected final String TEXT_1200 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1201 = NL + "    if (count($";
  protected final String TEXT_1202 = ") < self::";
  protected final String TEXT_1203 = "()";
  protected final String TEXT_1204 = ")" + NL + "    {";
  protected final String TEXT_1205 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1206 = " = array();" + NL + "    $";
  protected final String TEXT_1207 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1208 = " as $";
  protected final String TEXT_1209 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1210 = ",$";
  protected final String TEXT_1211 = ") !== false)" + NL + "      {";
  protected final String TEXT_1212 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  protected final String TEXT_1213 = "->";
  protected final String TEXT_1214 = "() != null && $this !== $";
  protected final String TEXT_1215 = "->";
  protected final String TEXT_1216 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_1217 = " = $";
  protected final String TEXT_1218 = "->";
  protected final String TEXT_1219 = "();" + NL + "        $";
  protected final String TEXT_1220 = " = serialize($";
  protected final String TEXT_1221 = ");" + NL + "        if (!array_key_exists($";
  protected final String TEXT_1222 = ", $";
  protected final String TEXT_1223 = "))" + NL + "        {" + NL + "          $";
  protected final String TEXT_1224 = "[$";
  protected final String TEXT_1225 = "] = $";
  protected final String TEXT_1226 = "->";
  protected final String TEXT_1227 = "();" + NL + "        }" + NL + "        $nextCount = $";
  protected final String TEXT_1228 = "[$";
  protected final String TEXT_1229 = "] - 1;" + NL + "        if ($nextCount < self::minimum";
  protected final String TEXT_1230 = "())" + NL + "        {";
  protected final String TEXT_1231 = NL + "          return $wasSet;" + NL + "        }" + NL + "        $";
  protected final String TEXT_1232 = "[$";
  protected final String TEXT_1233 = "] = $nextCount;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1234 = "[] = $";
  protected final String TEXT_1235 = ";" + NL + "    }" + NL + "" + NL + "    foreach ($this->";
  protected final String TEXT_1236 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  protected final String TEXT_1237 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + "      " + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1238 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1239 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1240 = " as $";
  protected final String TEXT_1241 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1242 = "->";
  protected final String TEXT_1243 = "() != null)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1244 = "->";
  protected final String TEXT_1245 = "()->";
  protected final String TEXT_1246 = "[$";
  protected final String TEXT_1247 = "->";
  protected final String TEXT_1248 = "()->";
  protected final String TEXT_1249 = "($";
  protected final String TEXT_1250 = ")]);" + NL + "        $";
  protected final String TEXT_1251 = "->";
  protected final String TEXT_1252 = "()->";
  protected final String TEXT_1253 = " = array_values($";
  protected final String TEXT_1254 = "->";
  protected final String TEXT_1255 = "()->";
  protected final String TEXT_1256 = ");" + NL + "      }" + NL + "      $this->";
  protected final String TEXT_1257 = "($";
  protected final String TEXT_1258 = ", $this);" + NL + "      $this->";
  protected final String TEXT_1259 = "[] = $";
  protected final String TEXT_1260 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1261 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1262 = NL + "  private function ";
  protected final String TEXT_1263 = "($";
  protected final String TEXT_1264 = ", $";
  protected final String TEXT_1265 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_1266 = "->mentor = $";
  protected final String TEXT_1267 = ";" + NL + "    //$prop = new ReflectionProperty($";
  protected final String TEXT_1268 = ", '";
  protected final String TEXT_1269 = "');" + NL + "    //$prop->setAccessible(true);" + NL + "    //$prop->setValue($";
  protected final String TEXT_1270 = ",$";
  protected final String TEXT_1271 = ");" + NL + "    //$prop->setAccessible(false);" + NL + "  }" + NL;
  protected final String TEXT_1272 = NL + "  public function ";
  protected final String TEXT_1273 = "($";
  protected final String TEXT_1274 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1275 = NL + "    $";
  protected final String TEXT_1276 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1277 = " as $";
  protected final String TEXT_1278 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1279 = ",$";
  protected final String TEXT_1280 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1281 = "[] = $";
  protected final String TEXT_1282 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1283 = ") != count($";
  protected final String TEXT_1284 = ") || count($";
  protected final String TEXT_1285 = ") > self::";
  protected final String TEXT_1286 = "())" + NL + "    {";
  protected final String TEXT_1287 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1288 = " = $";
  protected final String TEXT_1289 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1290 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1291 = NL + "  public function ";
  protected final String TEXT_1292 = "($";
  protected final String TEXT_1293 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1294 = NL + "    $";
  protected final String TEXT_1295 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1296 = " as $";
  protected final String TEXT_1297 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1298 = ",$";
  protected final String TEXT_1299 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1300 = "[] = $";
  protected final String TEXT_1301 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1302 = ") != count($";
  protected final String TEXT_1303 = ") || count($";
  protected final String TEXT_1304 = ") < self::";
  protected final String TEXT_1305 = "())" + NL + "    {";
  protected final String TEXT_1306 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1307 = " = $";
  protected final String TEXT_1308 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1309 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1310 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    if ($compareTo == null) { return false; }" + NL + "    if (get_class($this) != get_class($compareTo)) { return false; }" + NL;
  protected final String TEXT_1311 = NL + "    ";
  protected final String TEXT_1312 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public function hashCode()" + NL + "  {" + NL + "    if ($this->cachedHashCode != -1)" + NL + "    {" + NL + "      return $this->cachedHashCode;" + NL + "    }" + NL + "    $this->cachedHashCode = 17;";
  protected final String TEXT_1313 = NL + "    ";
  protected final String TEXT_1314 = NL;
  protected final String TEXT_1315 = NL + "    ";
  protected final String TEXT_1316 = NL + "    return $this->cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1317 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    return $this == $compareTo;" + NL + "  }" + NL;
  protected final String TEXT_1318 = NL + "    $this->";
  protected final String TEXT_1319 = " = null;";
  protected final String TEXT_1320 = NL + "    $this->";
  protected final String TEXT_1321 = " = array();";
  protected final String TEXT_1322 = NL + "    $";
  protected final String TEXT_1323 = " = $this->";
  protected final String TEXT_1324 = ";" + NL + "    $this->";
  protected final String TEXT_1325 = " = null;" + NL + "    if ($";
  protected final String TEXT_1326 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1327 = "->delete();" + NL + "    }";
  protected final String TEXT_1328 = NL + "    if ($this->";
  protected final String TEXT_1329 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1330 = "->";
  protected final String TEXT_1331 = "(null);" + NL + "    }";
  protected final String TEXT_1332 = NL + "    $";
  protected final String TEXT_1333 = " = $this->";
  protected final String TEXT_1334 = ";" + NL + "    $this->";
  protected final String TEXT_1335 = " = null;" + NL + "    if ($";
  protected final String TEXT_1336 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1337 = "->";
  protected final String TEXT_1338 = "(null);" + NL + "    }";
  protected final String TEXT_1339 = NL + "    $";
  protected final String TEXT_1340 = " = $this->";
  protected final String TEXT_1341 = ";" + NL + "    $this->";
  protected final String TEXT_1342 = " = null;" + NL + "    if ($";
  protected final String TEXT_1343 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1344 = "->delete();" + NL + "    }";
  protected final String TEXT_1345 = NL + "    if ($this->";
  protected final String TEXT_1346 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1347 = "->";
  protected final String TEXT_1348 = "($this);" + NL + "    }";
  protected final String TEXT_1349 = NL + "    if ($this->";
  protected final String TEXT_1350 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1351 = "->delete();" + NL + "    }";
  protected final String TEXT_1352 = NL + "    if ($this->";
  protected final String TEXT_1353 = " != null)" + NL + "    {" + NL + "      if ($this->";
  protected final String TEXT_1354 = "->";
  protected final String TEXT_1355 = "() <= ";
  protected final String TEXT_1356 = ")" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1357 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1358 = "->";
  protected final String TEXT_1359 = "($this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1360 = NL + "    $this->";
  protected final String TEXT_1361 = "->";
  protected final String TEXT_1362 = "($this);";
  protected final String TEXT_1363 = NL + "    foreach ($this->";
  protected final String TEXT_1364 = " as $";
  protected final String TEXT_1365 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1366 = "($";
  protected final String TEXT_1367 = ",null);" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_1368 = " = array();";
  protected final String TEXT_1369 = NL + "    $";
  protected final String TEXT_1370 = " = $this->";
  protected final String TEXT_1371 = ";" + NL + "    $this->";
  protected final String TEXT_1372 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1373 = " as $";
  protected final String TEXT_1374 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1375 = "->";
  protected final String TEXT_1376 = "() <= ";
  protected final String TEXT_1377 = "::";
  protected final String TEXT_1378 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_1379 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1380 = "->";
  protected final String TEXT_1381 = "($this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1382 = NL + "    $";
  protected final String TEXT_1383 = " = $this->";
  protected final String TEXT_1384 = ";" + NL + "    $this->";
  protected final String TEXT_1385 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1386 = " as $";
  protected final String TEXT_1387 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1388 = "->";
  protected final String TEXT_1389 = "($this);" + NL + "    }";
  protected final String TEXT_1390 = NL + "    foreach ($this->";
  protected final String TEXT_1391 = " as $";
  protected final String TEXT_1392 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1393 = "->delete();" + NL + "    }";
  protected final String TEXT_1394 = NL + "    foreach ($this->";
  protected final String TEXT_1395 = " as $";
  protected final String TEXT_1396 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1397 = "->";
  protected final String TEXT_1398 = "(null);" + NL + "    }";
  protected final String TEXT_1399 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1400 = NL + "  ";
  protected final String TEXT_1401 = NL + "}" + NL + "?>";

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
     if (uClass.numberOfComments() > 0) { append(stringBuffer, "\n{0}", Comment.format("Slahses",uClass.getComments())); } 
    stringBuffer.append(TEXT_3);
    stringBuffer.append( uClass.getName() );
    stringBuffer.append( gen.translate("isA",uClass) );
    stringBuffer.append(TEXT_4);
    
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
      append(stringBuffer, "  public static ${0} = {1};", av.getName(), gen.translate("parameterValue",av));
    }
    else if (av.getIsAutounique())
    {
      String defaultValue = av.getValue() == null ? "1" : av.getValue();
      appendln(stringBuffer, "");
      append(stringBuffer, "  private static $next{0} = {1};", av.getUpperCaseName(), defaultValue);
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
    
    if (av.isOptionalOne() && av.getRelatedAssociation().isMandatory())
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
      append(stringBuffer, "  private ${0};", gen.translate("attributeCanSet",av));
    }
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null && !"immutable".equals(av.getModifier()))
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
    append(stringBuffer, "\n    {0}",customConstructorPrefixCode);
    hasBody = true;
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
      
    stringBuffer.append(TEXT_6);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_8);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_10);
     
    }
    else if ("immutable".equals(av.getModifier()) && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_11);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_12);
    
    }
    else if ("immutable".equals(av.getModifier()))
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
         
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";
  String defaultValue = null;
  
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
        
    stringBuffer.append(TEXT_29);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_34);
    
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
  

    stringBuffer.append(TEXT_35);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_45);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_46);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_48);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_57);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_58);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_60);
    
    }
    else if (av.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_68);
    
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
  

    stringBuffer.append(TEXT_69);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_79);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_83);
    
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
    
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_86);
    
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(gen.translate("stateNull",state));
    stringBuffer.append(TEXT_90);
    
    }
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
    if (av != null && !"immutable".equals(av.getModifier()))
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
    
    stringBuffer.append(TEXT_91);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_92);
    
  }

    
  if (isOneToOne)
  {
    instanceIdentifier = "thisInstance";
    
    
  String signature = gClass.getLookup("constructorSignature_mandatory");

    stringBuffer.append(TEXT_93);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_96);
    
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
      
    stringBuffer.append(TEXT_97);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_99);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_101);
     
    }
    else
    {
      
    
  String assignValue = av.getValue() == null ? "$" + gen.translate("parameterOne",av) : gen.translate("parameterValue",av);

    stringBuffer.append(TEXT_102);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(assignValue);
    stringBuffer.append(TEXT_105);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_106);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_109);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_110);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    stringBuffer.append(TEXT_114);
    
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
  

    stringBuffer.append(TEXT_115);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_125);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_129);
    
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
    
    stringBuffer.append(TEXT_130);
    stringBuffer.append( gClass.getParentClass().getLookup("constructorSignature") );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( gClass.getParentClass().getLookup("constructorSignature_caller") );
    stringBuffer.append(TEXT_132);
    
  }

    
  }


    stringBuffer.append(TEXT_133);
    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
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
        
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_136);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_137);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_140);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_141);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_144);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_147);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_149);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n    {0}",customResetPrefixCode); } 
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_152);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n    {0}",customResetPostfixCode); } 
    stringBuffer.append(TEXT_153);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_156);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_159);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_162);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_168);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_169);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("setMethod",av));
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

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
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
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_178);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_181);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_184);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("parameterMany",av));
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
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_199);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_202);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_203);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_205);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_206);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_207);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_208);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_210);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_211);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_212);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_213);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_214);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_215);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_216);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_217);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_219);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_220);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_221);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_222);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_223);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_224);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_225);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_226);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_227);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_229);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_230);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPostfixCode); } 
    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_232);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_233);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_234);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_235);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_236);
    
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
        
    stringBuffer.append(TEXT_237);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_238);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_239);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_241);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_242);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_243);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_244);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_245);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_247);
    
      }
      appendln(stringBuffer, "");
    }
  }

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    
    
// NOT IMPLEMENTED YET

     
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

    stringBuffer.append(TEXT_248);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_249);
     if (outputCases.length() > 0) { append(stringBuffer, "\n    {0}",outputCases); } 
    stringBuffer.append(TEXT_250);
     
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
  for(Event e : uClass.getEvents())
  {
    
    
  StringBuffer allCases = new StringBuffer();

  boolean firstStateMachine = true;
  for(StateMachine sm : uClass.getStateMachines(e))
  {
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
      
      boolean hasExitAction = false;
      for(Action action : state.getActions())
      {
        if ("exit".equals(action.getActionType()))
        {
          hasExitAction = true;
          break;
        }
      }
  
      if (first)
      {
        allCases.append(StringFormatter.format("if ($this->{0} == self::${1})\n",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
      }
      else
      {
        allCases.append(StringFormatter.format("\n    elseif ($this->{0} == self::${1})\n",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
      }
      allCases.append(StringFormatter.format("    {\n"));
  
      boolean needsBreak = true;
      for (Transition t : allT)
      {
        State nextState = t.getNextState();
        String spaceOffset = t.getGuard() == null ? "" : "  ";
        if (t.getGuard() != null)
        {
          allCases.append(StringFormatter.format("      if ({0})\n",t.getGuard().getCondition()));
          allCases.append(StringFormatter.format("      {\n"));
        }
        if (hasExitAction)
        {
          allCases.append(StringFormatter.format("{0}      $this->{1}();\n",spaceOffset,gen.translate("exitMethod",sm)));
        }
        if (t.getAction() != null)
        {
          Action a1= t.getAction();
          allCases.append(StringFormatter.format("{0}      {1}\n",spaceOffset,a1.getActionCode()));
        }
  
        allCases.append(StringFormatter.format("{0}      $this->{1}(self::${2});\n",spaceOffset,gen.translate("setMethod",sm),gen.translate("stateOne",nextState)));
        allCases.append(StringFormatter.format("{0}      $wasEventProcessed = true;\n",spaceOffset));
  
        if (t.getGuard() != null)
        {
          allCases.append(StringFormatter.format("      }\n"));
        }
      }
      allCases.append(StringFormatter.format("    }"));
      first = false;
    }
    firstStateMachine = false;
  }
  String outputCases = allCases.toString().trim();

    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(TEXT_253);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_254);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {
    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    
  
  StringBuffer allCases = new StringBuffer();

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
    allCases.append(StringFormatter.format(" (${0} == \"{1}\")\n",gen.translate("parameterOne",sm),gen.translate("stateOne",state)));
    allCases.append(StringFormatter.format("    {\n"));
    allCases.append(StringFormatter.format("      $this->{0} = self::${1};\n",gen.translate("stateMachineOne",sm),gen.translate("stateOne",state)));
    allCases.append(StringFormatter.format("      return true;\n"));
    allCases.append(StringFormatter.format("    }\n"));
  }
  String outputCases = allCases.toString().trim();

    stringBuffer.append(TEXT_255);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_256);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(TEXT_258);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_259);
    
    }
    else if (sm.numberOfStates() > 0)
    {
      
    
  boolean hasEntry = false;
  boolean hasExit = false;
  boolean isFirstEntry = true;
  boolean isFirstExit = true;

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
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(TEXT_262);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_263);
     } 
    stringBuffer.append(TEXT_264);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_265);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_266);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_267);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_268);
     if (hasEntry) { 
    stringBuffer.append(TEXT_269);
    stringBuffer.append(TEXT_270);
    stringBuffer.append( entryActions );
     } 
    stringBuffer.append(TEXT_271);
    
    }
  }
}

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
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
      
    stringBuffer.append(TEXT_272);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_273);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_275);
     } else { 
    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_278);
     append(stringBuffer, "\n    {0}",customGetPostfixCode); 
    stringBuffer.append(TEXT_279);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_280);
     } 
    stringBuffer.append(TEXT_281);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_282);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_283);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_286);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_287);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_289);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_292);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_295);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_296);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_297);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_298);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_299);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_301);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_304);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_305);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_309);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_310);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_311);
    
    }
 }

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -Dmyenv=FILL_ME_IN.xml codegenMoveTemplates to move into the appropriate projects
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
      
    stringBuffer.append(TEXT_312);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(relatedAssociation);
    
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_314);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_315);
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPrefixCode); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_318);
     } else { 
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_323);
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPostfixCode); } 
    stringBuffer.append(TEXT_324);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_327);
     } else { 
    stringBuffer.append(TEXT_328);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_329);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_330);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_331);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_332);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_335);
     } else { 
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_337);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_338);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_339);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_340);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_343);
     } else { 
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_345);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_346);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_347);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_348);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_351);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_352);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_354);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_355);
     } 
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_363);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_364);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_367);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_368);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_370);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_383);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_384);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_385);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_387);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_388);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_390);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_391);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_394);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_398);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_399);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_402);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_410);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_424);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_425);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_428);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_441);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_451);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_452);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_459);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_460);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_471);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_475);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_478);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_483);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_488);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_494);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_495);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_504);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_507);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_518);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_524);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_527);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_532);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_537);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_543);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_544);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_553);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_556);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_568);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_571);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_581);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_582);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_585);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_597);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_616);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_617);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_624);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_636);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_639);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_649);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_650);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_653);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_663);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_679);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_680);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_683);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_686);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_689);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_702);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_703);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_706);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_709);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_712);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_725);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_726);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_729);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_735);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_748);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_749);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_752);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_753);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_754);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_766);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_767);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_770);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_774);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_781);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_793);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_796);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_797);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_800);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_804);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_810);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_822);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_825);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_826);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_828);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_829);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_844);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_847);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_859);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_860);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_863);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_878);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_879);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_882);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_885);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_900);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_903);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_913);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_914);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_917);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_922);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_925);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_928);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_931);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_937);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_938);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_941);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_944);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_945);
     } 
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_953);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_968);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_971);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_983);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_984);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_987);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_993);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_998);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1003);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1014);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1025);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1028);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1031);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1034);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1042);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1043);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1046);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1051);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1054);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1062);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1063);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1066);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1069);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1072);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1075);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1078);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1084);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1085);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1088);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1100);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1103);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1104);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1107);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1121);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1140);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1141);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1144);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1156);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1175);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1176);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1179);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1193);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1196);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1197);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || count(${0}) > self::{1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1200);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1204);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1211);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1230);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1260);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1271);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1274);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1286);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1289);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1290);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1293);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1305);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1308);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1309);
    
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


    stringBuffer.append(TEXT_1310);
    stringBuffer.append(TEXT_1311);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(TEXT_1313);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(TEXT_1315);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1316);
     } else { 
    stringBuffer.append(TEXT_1317);
     } 
    

  appendln(stringBuffer,"");
  appendln(stringBuffer,"  public function delete()");
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
        
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1319);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1321);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1327);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1331);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1338);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1344);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1348);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1351);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1359);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1362);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1368);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1381);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1389);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1393);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1398);
    
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
  
  

     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_1401);
    return stringBuffer.toString();
  }
}