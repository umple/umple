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
  protected final String TEXT_2 = NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/" + NL + "" + NL + "class ";
  protected final String TEXT_3 = NL + "{";
  protected final String TEXT_4 = NL + NL + "  //------------------------" + NL + "  // CONSTRUCTOR" + NL + "  //------------------------" + NL;
  protected final String TEXT_5 = NL + "    $";
  protected final String TEXT_6 = "->";
  protected final String TEXT_7 = " = array();";
  protected final String TEXT_8 = NL + "    $this->";
  protected final String TEXT_9 = "();";
  protected final String TEXT_10 = NL + "    $this->";
  protected final String TEXT_11 = " = true;";
  protected final String TEXT_12 = NL + "    $this->";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "    $this->";
  protected final String TEXT_15 = " = false;";
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
  protected final String TEXT_28 = NL + "    if (!$";
  protected final String TEXT_29 = "->";
  protected final String TEXT_30 = "($";
  protected final String TEXT_31 = "))" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_32 = " due to ";
  protected final String TEXT_33 = "\");" + NL + "    }";
  protected final String TEXT_34 = NL + "    $";
  protected final String TEXT_35 = "->";
  protected final String TEXT_36 = " = array();" + NL + "    $";
  protected final String TEXT_37 = " = $";
  protected final String TEXT_38 = "->";
  protected final String TEXT_39 = "($";
  protected final String TEXT_40 = ");" + NL + "    if (!$";
  protected final String TEXT_41 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_42 = ", must have ";
  protected final String TEXT_43 = " ";
  protected final String TEXT_44 = "\");" + NL + "    }";
  protected final String TEXT_45 = NL + "    $";
  protected final String TEXT_46 = "->";
  protected final String TEXT_47 = " = array();";
  protected final String TEXT_48 = NL + "    if ($";
  protected final String TEXT_49 = " == null || $";
  protected final String TEXT_50 = "->";
  protected final String TEXT_51 = "() != null)" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_52 = " due to ";
  protected final String TEXT_53 = "\");" + NL + "    }" + NL + "    $";
  protected final String TEXT_54 = "->";
  protected final String TEXT_55 = " = $";
  protected final String TEXT_56 = ";";
  protected final String TEXT_57 = NL + "    $";
  protected final String TEXT_58 = "->";
  protected final String TEXT_59 = " = array();";
  protected final String TEXT_60 = NL + "    $";
  protected final String TEXT_61 = " = $";
  protected final String TEXT_62 = "->";
  protected final String TEXT_63 = "($";
  protected final String TEXT_64 = ");" + NL + "    if (!$";
  protected final String TEXT_65 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_66 = " due to ";
  protected final String TEXT_67 = "\");" + NL + "    }";
  protected final String TEXT_68 = NL + "    $";
  protected final String TEXT_69 = "->";
  protected final String TEXT_70 = " = array();" + NL + "    $";
  protected final String TEXT_71 = " = $";
  protected final String TEXT_72 = "->";
  protected final String TEXT_73 = "($";
  protected final String TEXT_74 = ");" + NL + "    if (!$";
  protected final String TEXT_75 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_76 = ", must have ";
  protected final String TEXT_77 = " ";
  protected final String TEXT_78 = "\");" + NL + "    }";
  protected final String TEXT_79 = "$this->";
  protected final String TEXT_80 = " = array();" + NL + "    $this->";
  protected final String TEXT_81 = "[] = $";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = NL + "    $this->";
  protected final String TEXT_84 = "(self::$";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "    if ($this->";
  protected final String TEXT_87 = " == null) { $this->";
  protected final String TEXT_88 = "(self::$";
  protected final String TEXT_89 = "); }";
  protected final String TEXT_90 = NL + "  public static function getInstance()" + NL + "  {" + NL + "    if(self::$theInstance == null)" + NL + "    {" + NL + "      self::$theInstance = new ";
  protected final String TEXT_91 = "();" + NL + "    }" + NL + "    return self::$theInstance;" + NL + "  }";
  protected final String TEXT_92 = NL + "  public static function newInstance(";
  protected final String TEXT_93 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_94 = " = new ";
  protected final String TEXT_95 = "();";
  protected final String TEXT_96 = NL + "    $";
  protected final String TEXT_97 = "->";
  protected final String TEXT_98 = " = array();";
  protected final String TEXT_99 = NL + "    $this->";
  protected final String TEXT_100 = "();";
  protected final String TEXT_101 = NL + "    $";
  protected final String TEXT_102 = "->";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = ";";
  protected final String TEXT_105 = NL + "    $";
  protected final String TEXT_106 = "->";
  protected final String TEXT_107 = " = self::$";
  protected final String TEXT_108 = "++;";
  protected final String TEXT_109 = NL + "    $";
  protected final String TEXT_110 = "->";
  protected final String TEXT_111 = " = new ";
  protected final String TEXT_112 = "(";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "    $";
  protected final String TEXT_115 = "->";
  protected final String TEXT_116 = " = array();" + NL + "    $";
  protected final String TEXT_117 = " = $";
  protected final String TEXT_118 = "->";
  protected final String TEXT_119 = "($";
  protected final String TEXT_120 = ");" + NL + "    if (!$";
  protected final String TEXT_121 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  protected final String TEXT_122 = ", must have ";
  protected final String TEXT_123 = " ";
  protected final String TEXT_124 = "\");" + NL + "    }";
  protected final String TEXT_125 = "$this->";
  protected final String TEXT_126 = " = array();" + NL + "    $this->";
  protected final String TEXT_127 = "[] = $";
  protected final String TEXT_128 = ";";
  protected final String TEXT_129 = NL + "  private function callParentConstructor(";
  protected final String TEXT_130 = ")" + NL + "  {" + NL + "    parent::__construct(";
  protected final String TEXT_131 = ");" + NL + "  }" + NL;
  protected final String TEXT_132 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  protected final String TEXT_133 = NL + "  public function ";
  protected final String TEXT_134 = "($";
  protected final String TEXT_135 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_136 = NL + "    $this->";
  protected final String TEXT_137 = " = false;" + NL + "    $this->";
  protected final String TEXT_138 = " = $";
  protected final String TEXT_139 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_140 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_141 = NL + "  public function ";
  protected final String TEXT_142 = "($";
  protected final String TEXT_143 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_144 = NL + "    $this->";
  protected final String TEXT_145 = " = $";
  protected final String TEXT_146 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_147 = NL + "    return $wasSet;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_148 = "()" + NL + "  {" + NL + "    $wasReset = false;";
  protected final String TEXT_149 = NL + "    $this->";
  protected final String TEXT_150 = " = $this->";
  protected final String TEXT_151 = "();" + NL + "    $wasReset = true;";
  protected final String TEXT_152 = NL + "    return $wasReset;" + NL + "  }" + NL;
  protected final String TEXT_153 = NL + "  public function ";
  protected final String TEXT_154 = "($";
  protected final String TEXT_155 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_156 = NL + "    $this->";
  protected final String TEXT_157 = "[] = $";
  protected final String TEXT_158 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_159 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_160 = "($";
  protected final String TEXT_161 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_162 = NL + "    unset($this->";
  protected final String TEXT_163 = "[$this->";
  protected final String TEXT_164 = "($";
  protected final String TEXT_165 = ")]);" + NL + "    $this->";
  protected final String TEXT_166 = " = array_values($this->";
  protected final String TEXT_167 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_168 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_169 = NL + "  public function ";
  protected final String TEXT_170 = "($";
  protected final String TEXT_171 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_172 = NL + "    $this->";
  protected final String TEXT_173 = " = $";
  protected final String TEXT_174 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_175 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_176 = NL + "  public function ";
  protected final String TEXT_177 = "($index)" + NL + "  {";
  protected final String TEXT_178 = NL + "    $";
  protected final String TEXT_179 = " = $this->";
  protected final String TEXT_180 = "[$index];";
  protected final String TEXT_181 = NL + "    return $";
  protected final String TEXT_182 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_183 = "()" + NL + "  {";
  protected final String TEXT_184 = NL + "    $";
  protected final String TEXT_185 = " = $this->";
  protected final String TEXT_186 = ";";
  protected final String TEXT_187 = NL + "    return $";
  protected final String TEXT_188 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_189 = "()" + NL + "  {";
  protected final String TEXT_190 = NL + "    $number = count($this->";
  protected final String TEXT_191 = ");";
  protected final String TEXT_192 = NL + "    return $number;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_193 = "()" + NL + "  {";
  protected final String TEXT_194 = NL + "    $has = ";
  protected final String TEXT_195 = ".size() > 0;";
  protected final String TEXT_196 = NL + "    return $has;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_197 = "($";
  protected final String TEXT_198 = ")" + NL + "  {";
  protected final String TEXT_199 = NL + "    $rawAnswer = array_search($";
  protected final String TEXT_200 = ",$this->";
  protected final String TEXT_201 = ");" + NL + "    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;";
  protected final String TEXT_202 = NL + "    return $index;" + NL + "  }" + NL;
  protected final String TEXT_203 = NL + "  public function ";
  protected final String TEXT_204 = "()" + NL + "  {";
  protected final String TEXT_205 = NL + "    $";
  protected final String TEXT_206 = " = ";
  protected final String TEXT_207 = ";";
  protected final String TEXT_208 = NL + "    return $";
  protected final String TEXT_209 = ";" + NL + "  }";
  protected final String TEXT_210 = NL + "  public function ";
  protected final String TEXT_211 = "()" + NL + "  {";
  protected final String TEXT_212 = NL + "    return ";
  protected final String TEXT_213 = ";" + NL + "  }";
  protected final String TEXT_214 = NL + "  public function ";
  protected final String TEXT_215 = "()" + NL + "  {";
  protected final String TEXT_216 = NL + "    $";
  protected final String TEXT_217 = " = $this->";
  protected final String TEXT_218 = ";";
  protected final String TEXT_219 = NL + "    return $";
  protected final String TEXT_220 = ";" + NL + "  }";
  protected final String TEXT_221 = NL + "  public function ";
  protected final String TEXT_222 = "()" + NL + "  {";
  protected final String TEXT_223 = NL + "    return $this->";
  protected final String TEXT_224 = ";" + NL + "  }";
  protected final String TEXT_225 = NL + "  public function ";
  protected final String TEXT_226 = "()" + NL + "  {";
  protected final String TEXT_227 = NL + "    $";
  protected final String TEXT_228 = " = ";
  protected final String TEXT_229 = ";";
  protected final String TEXT_230 = NL + "    return $";
  protected final String TEXT_231 = ";" + NL + "  }" + NL;
  protected final String TEXT_232 = NL + "  public function ";
  protected final String TEXT_233 = "()" + NL + "  {";
  protected final String TEXT_234 = NL + "    return ";
  protected final String TEXT_235 = ";" + NL + "  }" + NL;
  protected final String TEXT_236 = NL + "  public function ";
  protected final String TEXT_237 = "()" + NL + "  {";
  protected final String TEXT_238 = NL + "    $";
  protected final String TEXT_239 = " = $this->";
  protected final String TEXT_240 = ";";
  protected final String TEXT_241 = NL + "    return $";
  protected final String TEXT_242 = ";" + NL + "  }";
  protected final String TEXT_243 = NL + "  public function ";
  protected final String TEXT_244 = "()" + NL + "  {";
  protected final String TEXT_245 = NL + "    return $this->";
  protected final String TEXT_246 = ";" + NL + "  }";
  protected final String TEXT_247 = NL + "  public function ";
  protected final String TEXT_248 = "()" + NL + "  {";
  protected final String TEXT_249 = NL + "    return null;" + NL + "  }" + NL;
  protected final String TEXT_250 = NL + "  public function ";
  protected final String TEXT_251 = "()" + NL + "  {" + NL + "    $wasEventProcessed = false;" + NL;
  protected final String TEXT_252 = NL + "    ";
  protected final String TEXT_253 = NL + NL + "    return $wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_254 = NL + "  public function ";
  protected final String TEXT_255 = "($";
  protected final String TEXT_256 = ")" + NL + "  {";
  protected final String TEXT_257 = NL + "    ";
  protected final String TEXT_258 = NL + "    else" + NL + "    {" + NL + "      return false;" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_259 = NL + "  private function ";
  protected final String TEXT_260 = "()" + NL + "  {";
  protected final String TEXT_261 = NL + "    ";
  protected final String TEXT_262 = NL + "  }" + NL;
  protected final String TEXT_263 = NL + "  private function ";
  protected final String TEXT_264 = "($";
  protected final String TEXT_265 = ")" + NL + "  {" + NL + "    $this->";
  protected final String TEXT_266 = " = $";
  protected final String TEXT_267 = ";";
  protected final String TEXT_268 = NL + NL + "    // entry actions and do activities";
  protected final String TEXT_269 = NL + "    ";
  protected final String TEXT_270 = NL + "  }" + NL;
  protected final String TEXT_271 = NL + "  public function ";
  protected final String TEXT_272 = "()" + NL + "  {";
  protected final String TEXT_273 = NL + "    return $this->";
  protected final String TEXT_274 = ";";
  protected final String TEXT_275 = NL + "    $";
  protected final String TEXT_276 = " = $this->";
  protected final String TEXT_277 = ";";
  protected final String TEXT_278 = NL + "    return $";
  protected final String TEXT_279 = ";";
  protected final String TEXT_280 = NL + "  }" + NL;
  protected final String TEXT_281 = NL + "  public function ";
  protected final String TEXT_282 = "($index)" + NL + "  {";
  protected final String TEXT_283 = NL + "    $";
  protected final String TEXT_284 = " = $this->";
  protected final String TEXT_285 = "[$index];";
  protected final String TEXT_286 = NL + "    return $";
  protected final String TEXT_287 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_288 = "()" + NL + "  {";
  protected final String TEXT_289 = NL + "    $";
  protected final String TEXT_290 = " = $this->";
  protected final String TEXT_291 = ";";
  protected final String TEXT_292 = NL + "    return $";
  protected final String TEXT_293 = ";" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_294 = "()" + NL + "  {";
  protected final String TEXT_295 = NL + "    $number = count($this->";
  protected final String TEXT_296 = ");";
  protected final String TEXT_297 = NL + "    return $number;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_298 = "()" + NL + "  {";
  protected final String TEXT_299 = NL + "    $has = $this->";
  protected final String TEXT_300 = "() > 0;";
  protected final String TEXT_301 = NL + "    return $has;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_302 = "($";
  protected final String TEXT_303 = ")" + NL + "  {";
  protected final String TEXT_304 = NL + "    $wasFound = false;" + NL + "    $index = 0;" + NL + "    foreach($this->";
  protected final String TEXT_305 = " as $";
  protected final String TEXT_306 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_307 = "->equals($";
  protected final String TEXT_308 = "))" + NL + "      {" + NL + "        $wasFound = true;" + NL + "        break;" + NL + "      }" + NL + "      $index += 1;" + NL + "    }" + NL + "    $index = $wasFound ? $index : -1;";
  protected final String TEXT_309 = NL + "    return $index;" + NL + "  }" + NL;
  protected final String TEXT_310 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_311 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_312 = " : ";
  protected final String TEXT_313 = NL + "  public function ";
  protected final String TEXT_314 = "()" + NL + "  {";
  protected final String TEXT_315 = NL + "    $isValid = $this->";
  protected final String TEXT_316 = "() >= self::";
  protected final String TEXT_317 = "();";
  protected final String TEXT_318 = NL + "    $isValid = $this->";
  protected final String TEXT_319 = "() >= self::";
  protected final String TEXT_320 = "() && $this->";
  protected final String TEXT_321 = "() <= self::";
  protected final String TEXT_322 = "();";
  protected final String TEXT_323 = NL + "    return $isValid;" + NL + "  }";
  protected final String TEXT_324 = NL + "  public static function ";
  protected final String TEXT_325 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_326 = ";" + NL + "  }";
  protected final String TEXT_327 = NL + "  public static function ";
  protected final String TEXT_328 = "()" + NL + "  {";
  protected final String TEXT_329 = NL + "    $minimum = ";
  protected final String TEXT_330 = ";";
  protected final String TEXT_331 = NL + "    return $minimum;" + NL + "  }";
  protected final String TEXT_332 = NL + "  public static function ";
  protected final String TEXT_333 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_334 = ";" + NL + "  }";
  protected final String TEXT_335 = NL + "  public static function ";
  protected final String TEXT_336 = "()" + NL + "  {";
  protected final String TEXT_337 = NL + "    $minimum = ";
  protected final String TEXT_338 = ";";
  protected final String TEXT_339 = NL + "    return $minimum;" + NL + "  }";
  protected final String TEXT_340 = NL + "  public static function ";
  protected final String TEXT_341 = "()" + NL + "  {" + NL + "    return ";
  protected final String TEXT_342 = ";" + NL + "  }";
  protected final String TEXT_343 = NL + "  public static function ";
  protected final String TEXT_344 = "()" + NL + "  {";
  protected final String TEXT_345 = NL + "    $maximum = ";
  protected final String TEXT_346 = ";";
  protected final String TEXT_347 = NL + "    return $maximum;" + NL + "  }";
  protected final String TEXT_348 = NL + "  public function ";
  protected final String TEXT_349 = "($";
  protected final String TEXT_350 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_351 = NL + "    if ($this->";
  protected final String TEXT_352 = "() >= self::";
  protected final String TEXT_353 = "())" + NL + "    {";
  protected final String TEXT_354 = NL + "      return $wasAdded;" + NL + "    }" + NL;
  protected final String TEXT_355 = NL + "    $this->";
  protected final String TEXT_356 = "[] = $";
  protected final String TEXT_357 = ";" + NL + "    if ($";
  protected final String TEXT_358 = "->";
  protected final String TEXT_359 = "($this) != -1)" + NL + "    {" + NL + "      $wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasAdded = $";
  protected final String TEXT_360 = "->";
  protected final String TEXT_361 = "($this);" + NL + "      if (!$wasAdded)" + NL + "      {" + NL + "        array_pop($this->";
  protected final String TEXT_362 = ");" + NL + "      }" + NL + "    }";
  protected final String TEXT_363 = NL + "    return $wasAdded;" + NL + "  }";
  protected final String TEXT_364 = NL + "  public function ";
  protected final String TEXT_365 = "($";
  protected final String TEXT_366 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_367 = NL + "    if ($this->";
  protected final String TEXT_368 = "($";
  protected final String TEXT_369 = ") == -1)" + NL + "    {";
  protected final String TEXT_370 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_371 = "($";
  protected final String TEXT_372 = ");" + NL + "    unset($this->";
  protected final String TEXT_373 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_374 = "->";
  protected final String TEXT_375 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_376 = "->";
  protected final String TEXT_377 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_378 = "[$oldIndex] = $";
  protected final String TEXT_379 = ";" + NL + "        ksort($this->";
  protected final String TEXT_380 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_381 = " = array_values($this->";
  protected final String TEXT_382 = ");";
  protected final String TEXT_383 = NL + "    return $wasRemoved;" + NL + "  }";
  protected final String TEXT_384 = NL + "  public function ";
  protected final String TEXT_385 = "($";
  protected final String TEXT_386 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_387 = NL + "    $this->";
  protected final String TEXT_388 = " = $";
  protected final String TEXT_389 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_390 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_391 = NL + "  public function ";
  protected final String TEXT_392 = "($";
  protected final String TEXT_393 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_394 = NL + "    if ($";
  protected final String TEXT_395 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_396 = " = $";
  protected final String TEXT_397 = ";" + NL + "      $wasSet = true;" + NL + "    }";
  protected final String TEXT_398 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_399 = NL + "  public function ";
  protected final String TEXT_400 = "($";
  protected final String TEXT_401 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_402 = NL + "    if ($this->";
  protected final String TEXT_403 = " != null && $this->";
  protected final String TEXT_404 = " != $";
  protected final String TEXT_405 = " && $this == $this->";
  protected final String TEXT_406 = "->";
  protected final String TEXT_407 = "())" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_408 = ", as existing ";
  protected final String TEXT_409 = " would become an orphan";
  protected final String TEXT_410 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $this->";
  protected final String TEXT_411 = " = $";
  protected final String TEXT_412 = ";" + NL + "    $";
  protected final String TEXT_413 = " = $";
  protected final String TEXT_414 = " != null ? $";
  protected final String TEXT_415 = "->";
  protected final String TEXT_416 = "() : null;" + NL + "    " + NL + "    if ($this != $";
  protected final String TEXT_417 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_418 = " != null)" + NL + "      {" + NL + "        $";
  protected final String TEXT_419 = "->";
  protected final String TEXT_420 = " = null;" + NL + "      }" + NL + "      if ($this->";
  protected final String TEXT_421 = " != null)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_422 = "->";
  protected final String TEXT_423 = "($this);" + NL + "      }" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_424 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_425 = NL + "  public function ";
  protected final String TEXT_426 = "($";
  protected final String TEXT_427 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_428 = NL + "    if ($";
  protected final String TEXT_429 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_430 = " to null, as ";
  protected final String TEXT_431 = " must always be associated to a ";
  protected final String TEXT_432 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_433 = " = $";
  protected final String TEXT_434 = "->";
  protected final String TEXT_435 = "();" + NL + "    if ($";
  protected final String TEXT_436 = " != null && $this != $";
  protected final String TEXT_437 = ")" + NL + "    {" + NL + "      //Unable to ";
  protected final String TEXT_438 = ", the current ";
  protected final String TEXT_439 = " already has a ";
  protected final String TEXT_440 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_441 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_442 = " = $this->";
  protected final String TEXT_443 = ";" + NL + "    $this->";
  protected final String TEXT_444 = " = $";
  protected final String TEXT_445 = ";" + NL + "    $this->";
  protected final String TEXT_446 = "->";
  protected final String TEXT_447 = "($this);" + NL + "    " + NL + "    if ($";
  protected final String TEXT_448 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_449 = "->";
  protected final String TEXT_450 = "(null);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_451 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_452 = NL + "  public function ";
  protected final String TEXT_453 = "(";
  protected final String TEXT_454 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_455 = "(";
  protected final String TEXT_456 = ");" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_457 = "($";
  protected final String TEXT_458 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_459 = NL + "    $";
  protected final String TEXT_460 = " = $";
  protected final String TEXT_461 = "->";
  protected final String TEXT_462 = "();" + NL + "    $";
  protected final String TEXT_463 = " = $";
  protected final String TEXT_464 = " != null && $this !== $";
  protected final String TEXT_465 = ";" + NL + "" + NL + "    if ($";
  protected final String TEXT_466 = " && $";
  protected final String TEXT_467 = "->";
  protected final String TEXT_468 = "() <= self::";
  protected final String TEXT_469 = "())" + NL + "    {" + NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    if ($";
  protected final String TEXT_470 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_471 = "->";
  protected final String TEXT_472 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_473 = "[] = $";
  protected final String TEXT_474 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_475 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_476 = "($";
  protected final String TEXT_477 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_478 = NL + "    //Unable to remove ";
  protected final String TEXT_479 = ", as it must always have a ";
  protected final String TEXT_480 = NL + "    if ($this === $";
  protected final String TEXT_481 = "->";
  protected final String TEXT_482 = "())" + NL + "    {";
  protected final String TEXT_483 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_484 = " already at minimum (";
  protected final String TEXT_485 = ")" + NL + "    if ($this->";
  protected final String TEXT_486 = "() <= self::";
  protected final String TEXT_487 = "())" + NL + "    {";
  protected final String TEXT_488 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_489 = "[$this->";
  protected final String TEXT_490 = "($";
  protected final String TEXT_491 = ")]);" + NL + "    $this->";
  protected final String TEXT_492 = " = array_values($this->";
  protected final String TEXT_493 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_494 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_495 = NL + "  public function ";
  protected final String TEXT_496 = "(";
  protected final String TEXT_497 = ")" + NL + "  {" + NL + "    if ($this->";
  protected final String TEXT_498 = "() >= self::";
  protected final String TEXT_499 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_500 = "(";
  protected final String TEXT_501 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_502 = "($";
  protected final String TEXT_503 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_504 = NL + "    if ($this->";
  protected final String TEXT_505 = "() >= self::";
  protected final String TEXT_506 = "())" + NL + "    {";
  protected final String TEXT_507 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_508 = " = $";
  protected final String TEXT_509 = "->";
  protected final String TEXT_510 = "();" + NL + "    $";
  protected final String TEXT_511 = " = $";
  protected final String TEXT_512 = " != null && $this !== $";
  protected final String TEXT_513 = ";" + NL + "" + NL + "    if ($";
  protected final String TEXT_514 = " && $";
  protected final String TEXT_515 = "->";
  protected final String TEXT_516 = "() <= self::";
  protected final String TEXT_517 = "())" + NL + "    {";
  protected final String TEXT_518 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    if ($";
  protected final String TEXT_519 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_520 = "->";
  protected final String TEXT_521 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_522 = "[] = $";
  protected final String TEXT_523 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_524 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_525 = "($";
  protected final String TEXT_526 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_527 = NL + "    //Unable to remove ";
  protected final String TEXT_528 = ", as it must always have a ";
  protected final String TEXT_529 = NL + "    if ($this === $";
  protected final String TEXT_530 = "->";
  protected final String TEXT_531 = "())" + NL + "    {";
  protected final String TEXT_532 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_533 = " already at minimum (";
  protected final String TEXT_534 = ")" + NL + "    if ($this->";
  protected final String TEXT_535 = "() <= self::";
  protected final String TEXT_536 = "())" + NL + "    {";
  protected final String TEXT_537 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_538 = "[$this->";
  protected final String TEXT_539 = "($";
  protected final String TEXT_540 = ")]);" + NL + "    $this->";
  protected final String TEXT_541 = " = array_values($this->";
  protected final String TEXT_542 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_543 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_544 = NL + "  public function ";
  protected final String TEXT_545 = "(";
  protected final String TEXT_546 = ")" + NL + "  {" + NL + "    if ($this->";
  protected final String TEXT_547 = "() >= self::";
  protected final String TEXT_548 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  protected final String TEXT_549 = "(";
  protected final String TEXT_550 = ");" + NL + "    }" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_551 = "($";
  protected final String TEXT_552 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_553 = NL + "    if ($this->";
  protected final String TEXT_554 = "() >= self::";
  protected final String TEXT_555 = "())" + NL + "    {";
  protected final String TEXT_556 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_557 = " = $";
  protected final String TEXT_558 = "->";
  protected final String TEXT_559 = "();" + NL + "    $";
  protected final String TEXT_560 = " = $";
  protected final String TEXT_561 = " != null && $this !== $";
  protected final String TEXT_562 = ";" + NL + "    if ($";
  protected final String TEXT_563 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_564 = "->";
  protected final String TEXT_565 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_566 = "[] = $";
  protected final String TEXT_567 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_568 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_569 = "($";
  protected final String TEXT_570 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_571 = NL + "    //Unable to remove ";
  protected final String TEXT_572 = ", as it must always have a ";
  protected final String TEXT_573 = NL + "    if ($this !== $";
  protected final String TEXT_574 = "->";
  protected final String TEXT_575 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_576 = "[$this->";
  protected final String TEXT_577 = "($";
  protected final String TEXT_578 = ")]);" + NL + "      $this->";
  protected final String TEXT_579 = " = array_values($this->";
  protected final String TEXT_580 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_581 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_582 = NL + "  public function ";
  protected final String TEXT_583 = "($";
  protected final String TEXT_584 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_585 = NL + "    $";
  protected final String TEXT_586 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_587 = " as $";
  protected final String TEXT_588 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_589 = ",$";
  protected final String TEXT_590 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_591 = "[] = $";
  protected final String TEXT_592 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_593 = ") != count($";
  protected final String TEXT_594 = ") || count($";
  protected final String TEXT_595 = ") > self::";
  protected final String TEXT_596 = "())" + NL + "    {";
  protected final String TEXT_597 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_598 = " = $this->";
  protected final String TEXT_599 = ";" + NL + "    $this->";
  protected final String TEXT_600 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_601 = " as $";
  protected final String TEXT_602 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_603 = "[] = $";
  protected final String TEXT_604 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_605 = ",$";
  protected final String TEXT_606 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_607 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_608 = " = array_values($";
  protected final String TEXT_609 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_610 = "->";
  protected final String TEXT_611 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_612 = " as $";
  protected final String TEXT_613 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_614 = "->";
  protected final String TEXT_615 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_616 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_617 = NL + "  public function ";
  protected final String TEXT_618 = "(";
  protected final String TEXT_619 = ")" + NL + "  {" + NL + "    return new ";
  protected final String TEXT_620 = "(";
  protected final String TEXT_621 = ");" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_622 = "($";
  protected final String TEXT_623 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_624 = NL + "    $";
  protected final String TEXT_625 = " = $";
  protected final String TEXT_626 = "->";
  protected final String TEXT_627 = "();" + NL + "    $";
  protected final String TEXT_628 = " = $";
  protected final String TEXT_629 = " != null && $this !== $";
  protected final String TEXT_630 = ";" + NL + "    if ($";
  protected final String TEXT_631 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_632 = "->";
  protected final String TEXT_633 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_634 = "[] = $";
  protected final String TEXT_635 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_636 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_637 = "($";
  protected final String TEXT_638 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_639 = NL + "    //Unable to remove ";
  protected final String TEXT_640 = ", as it must always have a ";
  protected final String TEXT_641 = NL + "    if ($this !== $";
  protected final String TEXT_642 = "->";
  protected final String TEXT_643 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_644 = "[$this->";
  protected final String TEXT_645 = "($";
  protected final String TEXT_646 = ")]);" + NL + "      $this->";
  protected final String TEXT_647 = " = array_values($this->";
  protected final String TEXT_648 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_649 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_650 = NL + "  public function ";
  protected final String TEXT_651 = "($";
  protected final String TEXT_652 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_653 = NL + "    if ($";
  protected final String TEXT_654 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_655 = " = $this->";
  protected final String TEXT_656 = ";" + NL + "      $this->";
  protected final String TEXT_657 = " = null;" + NL + "      " + NL + "      if ($";
  protected final String TEXT_658 = " != null && $";
  protected final String TEXT_659 = "->";
  protected final String TEXT_660 = "() != null)" + NL + "      {" + NL + "        $";
  protected final String TEXT_661 = "->";
  protected final String TEXT_662 = "(null);" + NL + "      }" + NL + "      $wasSet = true;";
  protected final String TEXT_663 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_664 = " = $this->";
  protected final String TEXT_665 = "();" + NL + "    if ($";
  protected final String TEXT_666 = " != null && $";
  protected final String TEXT_667 = " != $";
  protected final String TEXT_668 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_669 = "->";
  protected final String TEXT_670 = "(null);" + NL + "    }" + NL + "    " + NL + "    $this->";
  protected final String TEXT_671 = " = $";
  protected final String TEXT_672 = ";" + NL + "    $";
  protected final String TEXT_673 = " = $";
  protected final String TEXT_674 = "->";
  protected final String TEXT_675 = "();" + NL + "    " + NL + "    if ($this != $";
  protected final String TEXT_676 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_677 = "->";
  protected final String TEXT_678 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_679 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_680 = NL + "  public function ";
  protected final String TEXT_681 = "($";
  protected final String TEXT_682 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_683 = NL + "    if ($this->";
  protected final String TEXT_684 = "($";
  protected final String TEXT_685 = ") == -1)" + NL + "    {";
  protected final String TEXT_686 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_687 = "() <= self::";
  protected final String TEXT_688 = "())" + NL + "    {";
  protected final String TEXT_689 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_690 = "($";
  protected final String TEXT_691 = ");" + NL + "    unset($this->";
  protected final String TEXT_692 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_693 = "->";
  protected final String TEXT_694 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_695 = "->";
  protected final String TEXT_696 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_697 = "[$oldIndex] = $";
  protected final String TEXT_698 = ";" + NL + "        ksort($this->";
  protected final String TEXT_699 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_700 = " = array_values($this->";
  protected final String TEXT_701 = ");";
  protected final String TEXT_702 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_703 = NL + "  public function ";
  protected final String TEXT_704 = "($";
  protected final String TEXT_705 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_706 = NL + "    if ($this->";
  protected final String TEXT_707 = "($";
  protected final String TEXT_708 = ") == -1)" + NL + "    {";
  protected final String TEXT_709 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_710 = "() <= self::";
  protected final String TEXT_711 = "())" + NL + "    {";
  protected final String TEXT_712 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    $oldIndex = $this->";
  protected final String TEXT_713 = "($";
  protected final String TEXT_714 = ");" + NL + "    unset($this->";
  protected final String TEXT_715 = "[$oldIndex]);" + NL + "    if ($";
  protected final String TEXT_716 = "->";
  protected final String TEXT_717 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  protected final String TEXT_718 = "->";
  protected final String TEXT_719 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_720 = "[$oldIndex] = $";
  protected final String TEXT_721 = ";" + NL + "        ksort($this->";
  protected final String TEXT_722 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_723 = " = array_values($this->";
  protected final String TEXT_724 = ");";
  protected final String TEXT_725 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_726 = NL + "  public function ";
  protected final String TEXT_727 = "($";
  protected final String TEXT_728 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_729 = NL + "    if ($";
  protected final String TEXT_730 = " != null && $";
  protected final String TEXT_731 = "->";
  protected final String TEXT_732 = "() >= ";
  protected final String TEXT_733 = "::";
  protected final String TEXT_734 = "())" + NL + "    {";
  protected final String TEXT_735 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_736 = " = $this->";
  protected final String TEXT_737 = ";" + NL + "    $this->";
  protected final String TEXT_738 = " = $";
  protected final String TEXT_739 = ";" + NL + "    if ($";
  protected final String TEXT_740 = " != null && $";
  protected final String TEXT_741 = " != $";
  protected final String TEXT_742 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_743 = "->";
  protected final String TEXT_744 = "($this);" + NL + "    }" + NL + "    if ($";
  protected final String TEXT_745 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_746 = "->";
  protected final String TEXT_747 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_748 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_749 = NL + "  public function ";
  protected final String TEXT_750 = "($";
  protected final String TEXT_751 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_752 = NL + "    if ($";
  protected final String TEXT_753 = " == null)" + NL + "    {";
  protected final String TEXT_754 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_755 = " = $this->";
  protected final String TEXT_756 = ";" + NL + "    $this->";
  protected final String TEXT_757 = " = $";
  protected final String TEXT_758 = ";" + NL + "    if ($";
  protected final String TEXT_759 = " != null && $";
  protected final String TEXT_760 = " != $";
  protected final String TEXT_761 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_762 = "->";
  protected final String TEXT_763 = "($this);" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_764 = "->";
  protected final String TEXT_765 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_766 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_767 = NL + "  public function ";
  protected final String TEXT_768 = "($";
  protected final String TEXT_769 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_770 = NL + "    //Must provide ";
  protected final String TEXT_771 = " to ";
  protected final String TEXT_772 = NL + "    if ($";
  protected final String TEXT_773 = " == null)" + NL + "    {";
  protected final String TEXT_774 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    //";
  protected final String TEXT_775 = " already at maximum (";
  protected final String TEXT_776 = ")" + NL + "    if ($";
  protected final String TEXT_777 = "->";
  protected final String TEXT_778 = "() >= ";
  protected final String TEXT_779 = "::";
  protected final String TEXT_780 = "())" + NL + "    {";
  protected final String TEXT_781 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  protected final String TEXT_782 = " = $this->";
  protected final String TEXT_783 = ";" + NL + "    $this->";
  protected final String TEXT_784 = " = $";
  protected final String TEXT_785 = ";" + NL + "    if ($";
  protected final String TEXT_786 = " != null && $";
  protected final String TEXT_787 = " != $";
  protected final String TEXT_788 = ")" + NL + "    {" + NL + "      $didRemove = $";
  protected final String TEXT_789 = "->";
  protected final String TEXT_790 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_791 = " = $";
  protected final String TEXT_792 = ";";
  protected final String TEXT_793 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_794 = "->";
  protected final String TEXT_795 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_796 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_797 = NL + "  public function ";
  protected final String TEXT_798 = "($";
  protected final String TEXT_799 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_800 = NL + "    //Must provide ";
  protected final String TEXT_801 = " to ";
  protected final String TEXT_802 = NL + "    if ($";
  protected final String TEXT_803 = " == null)" + NL + "    {";
  protected final String TEXT_804 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_805 = " != null && $this->";
  protected final String TEXT_806 = "->";
  protected final String TEXT_807 = "() <= ";
  protected final String TEXT_808 = "::";
  protected final String TEXT_809 = "())" + NL + "    {";
  protected final String TEXT_810 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_811 = " = $this->";
  protected final String TEXT_812 = ";" + NL + "    $this->";
  protected final String TEXT_813 = " = $";
  protected final String TEXT_814 = ";" + NL + "    if ($";
  protected final String TEXT_815 = " != null && $";
  protected final String TEXT_816 = " != $";
  protected final String TEXT_817 = ")" + NL + "    {" + NL + "      $didRemove = $";
  protected final String TEXT_818 = "->";
  protected final String TEXT_819 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_820 = " = $";
  protected final String TEXT_821 = ";";
  protected final String TEXT_822 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_823 = "->";
  protected final String TEXT_824 = "($this);" + NL + "    $wasSet = true;";
  protected final String TEXT_825 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_826 = NL + "  public function ";
  protected final String TEXT_827 = "($";
  protected final String TEXT_828 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_829 = NL + "    $";
  protected final String TEXT_830 = " = $";
  protected final String TEXT_831 = "->";
  protected final String TEXT_832 = "();" + NL + "    if ($";
  protected final String TEXT_833 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_834 = "->";
  protected final String TEXT_835 = "($this);" + NL + "    }" + NL + "    elseif ($this !== $";
  protected final String TEXT_836 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_837 = "->";
  protected final String TEXT_838 = "($";
  protected final String TEXT_839 = ");" + NL + "      $this->";
  protected final String TEXT_840 = "($";
  protected final String TEXT_841 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_842 = "[] = $";
  protected final String TEXT_843 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_844 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_845 = "($";
  protected final String TEXT_846 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_847 = NL + "    if ($this->";
  protected final String TEXT_848 = "($";
  protected final String TEXT_849 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_850 = "[$this->";
  protected final String TEXT_851 = "($";
  protected final String TEXT_852 = ")]);" + NL + "      $this->";
  protected final String TEXT_853 = " = array_values($this->";
  protected final String TEXT_854 = ");" + NL + "      if ($this === $";
  protected final String TEXT_855 = "->";
  protected final String TEXT_856 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_857 = "->";
  protected final String TEXT_858 = "(null);" + NL + "      }" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_859 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_860 = NL + "  public function ";
  protected final String TEXT_861 = "($";
  protected final String TEXT_862 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_863 = NL + "    $";
  protected final String TEXT_864 = " = $this->";
  protected final String TEXT_865 = ";" + NL + "    $this->";
  protected final String TEXT_866 = " = $";
  protected final String TEXT_867 = ";" + NL + "    if ($";
  protected final String TEXT_868 = " != null && $";
  protected final String TEXT_869 = " !== $";
  protected final String TEXT_870 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_871 = "->";
  protected final String TEXT_872 = "($this);" + NL + "    }" + NL + "    if ($";
  protected final String TEXT_873 = " != null && $";
  protected final String TEXT_874 = " !== $";
  protected final String TEXT_875 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_876 = "->";
  protected final String TEXT_877 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_878 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_879 = NL + "  public function ";
  protected final String TEXT_880 = "($";
  protected final String TEXT_881 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_882 = NL + "    if ($this->";
  protected final String TEXT_883 = "() >= self::";
  protected final String TEXT_884 = "())" + NL + "    {";
  protected final String TEXT_885 = NL + "      return $wasAdded;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_886 = " = $";
  protected final String TEXT_887 = "->";
  protected final String TEXT_888 = "();" + NL + "    if ($";
  protected final String TEXT_889 = " == null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_890 = "->";
  protected final String TEXT_891 = "($this);" + NL + "    }" + NL + "    else if ($this !== $";
  protected final String TEXT_892 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_893 = "->";
  protected final String TEXT_894 = "($";
  protected final String TEXT_895 = ");" + NL + "      $this->";
  protected final String TEXT_896 = "($";
  protected final String TEXT_897 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_898 = "[] = $";
  protected final String TEXT_899 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  protected final String TEXT_900 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_901 = "($";
  protected final String TEXT_902 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_903 = NL + "    if ($this->";
  protected final String TEXT_904 = "($";
  protected final String TEXT_905 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_906 = "[$this->";
  protected final String TEXT_907 = "($";
  protected final String TEXT_908 = ")]);" + NL + "      $this->";
  protected final String TEXT_909 = " = array_values($this->";
  protected final String TEXT_910 = ");" + NL + "      $";
  protected final String TEXT_911 = "->";
  protected final String TEXT_912 = "(null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_913 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_914 = NL + "  public function ";
  protected final String TEXT_915 = "($";
  protected final String TEXT_916 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_917 = NL + "    if ($this->";
  protected final String TEXT_918 = "() < self::";
  protected final String TEXT_919 = "())" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_920 = "[] = $";
  protected final String TEXT_921 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  protected final String TEXT_922 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_923 = "($";
  protected final String TEXT_924 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_925 = NL + "    if ($this->";
  protected final String TEXT_926 = "($";
  protected final String TEXT_927 = ") == -1)" + NL + "    {";
  protected final String TEXT_928 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_929 = "() <= self::";
  protected final String TEXT_930 = "())" + NL + "    {";
  protected final String TEXT_931 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_932 = "[$this->";
  protected final String TEXT_933 = "($";
  protected final String TEXT_934 = ")]);" + NL + "    $this->";
  protected final String TEXT_935 = " = array_values($this->";
  protected final String TEXT_936 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_937 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_938 = NL + "  public function ";
  protected final String TEXT_939 = "($";
  protected final String TEXT_940 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_941 = NL + "    if ($this->";
  protected final String TEXT_942 = "() >= self::";
  protected final String TEXT_943 = "())" + NL + "    {";
  protected final String TEXT_944 = NL + "      return $wasAdded;" + NL + "    }";
  protected final String TEXT_945 = NL + "    $";
  protected final String TEXT_946 = " = $";
  protected final String TEXT_947 = "->";
  protected final String TEXT_948 = "();" + NL + "    if ($";
  protected final String TEXT_949 = " != null && $";
  protected final String TEXT_950 = "->";
  protected final String TEXT_951 = "() <= self::";
  protected final String TEXT_952 = "())" + NL + "    {";
  protected final String TEXT_953 = NL + "      return $wasAdded;" + NL + "    }" + NL + "    else if ($";
  protected final String TEXT_954 = " != null)" + NL + "    {" + NL + "      unset($";
  protected final String TEXT_955 = "->";
  protected final String TEXT_956 = "[$";
  protected final String TEXT_957 = "->";
  protected final String TEXT_958 = "($";
  protected final String TEXT_959 = ")]);" + NL + "      $";
  protected final String TEXT_960 = "->";
  protected final String TEXT_961 = " = array_values($";
  protected final String TEXT_962 = "->";
  protected final String TEXT_963 = ");" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_964 = "[] = $";
  protected final String TEXT_965 = ";" + NL + "    $this->";
  protected final String TEXT_966 = "($";
  protected final String TEXT_967 = ",$this);" + NL + "    $wasAdded = true;";
  protected final String TEXT_968 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_969 = "($";
  protected final String TEXT_970 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_971 = NL + "    if ($this->";
  protected final String TEXT_972 = "($";
  protected final String TEXT_973 = ") != -1 && $this->";
  protected final String TEXT_974 = "() > self::";
  protected final String TEXT_975 = "())" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_976 = "[$this->";
  protected final String TEXT_977 = "($";
  protected final String TEXT_978 = ")]);" + NL + "      $this->";
  protected final String TEXT_979 = " = array_values($this->";
  protected final String TEXT_980 = ");" + NL + "      $this->";
  protected final String TEXT_981 = "($";
  protected final String TEXT_982 = ",null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_983 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_984 = NL + "  public function ";
  protected final String TEXT_985 = "($";
  protected final String TEXT_986 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_987 = NL + "    $";
  protected final String TEXT_988 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_989 = " as $";
  protected final String TEXT_990 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_991 = ",$";
  protected final String TEXT_992 = ") !== false)" + NL + "      {";
  protected final String TEXT_993 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  protected final String TEXT_994 = "->";
  protected final String TEXT_995 = "() != null && $this !== $";
  protected final String TEXT_996 = "->";
  protected final String TEXT_997 = "())" + NL + "      {";
  protected final String TEXT_998 = NL + "        return $wasSet;" + NL + "      }" + NL + "      $";
  protected final String TEXT_999 = "[] = $";
  protected final String TEXT_1000 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1001 = ") != self::";
  protected final String TEXT_1002 = "())" + NL + "    {";
  protected final String TEXT_1003 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    foreach ($this->";
  protected final String TEXT_1004 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  protected final String TEXT_1005 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + "" + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1006 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1007 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1008 = " as $";
  protected final String TEXT_1009 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1010 = "($";
  protected final String TEXT_1011 = ", $this);" + NL + "      $this->";
  protected final String TEXT_1012 = "[] = $";
  protected final String TEXT_1013 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1014 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1015 = NL + "  private function ";
  protected final String TEXT_1016 = "($";
  protected final String TEXT_1017 = ", $";
  protected final String TEXT_1018 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_1019 = "->mentor = $";
  protected final String TEXT_1020 = ";" + NL + "    //$prop = new ReflectionProperty($";
  protected final String TEXT_1021 = ", '";
  protected final String TEXT_1022 = "');" + NL + "    //$prop->setAccessible(true);" + NL + "    //$prop->setValue($";
  protected final String TEXT_1023 = ",$";
  protected final String TEXT_1024 = ");" + NL + "    //$prop->setAccessible(false);" + NL + "  }" + NL;
  protected final String TEXT_1025 = NL + "  public function ";
  protected final String TEXT_1026 = "($";
  protected final String TEXT_1027 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1028 = NL + "    $this->";
  protected final String TEXT_1029 = "[] = $";
  protected final String TEXT_1030 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_1031 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1032 = "($";
  protected final String TEXT_1033 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1034 = NL + "    if ($this->";
  protected final String TEXT_1035 = "($";
  protected final String TEXT_1036 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1037 = "[$this->";
  protected final String TEXT_1038 = "($";
  protected final String TEXT_1039 = ")]);" + NL + "      $this->";
  protected final String TEXT_1040 = " = array_values($this->";
  protected final String TEXT_1041 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1042 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1043 = NL + "  public function ";
  protected final String TEXT_1044 = "($";
  protected final String TEXT_1045 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1046 = NL + "    if ($this->";
  protected final String TEXT_1047 = "() < self::";
  protected final String TEXT_1048 = "())" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1049 = "[] = $";
  protected final String TEXT_1050 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  protected final String TEXT_1051 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1052 = "($";
  protected final String TEXT_1053 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1054 = NL + "    if ($this->";
  protected final String TEXT_1055 = "($";
  protected final String TEXT_1056 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  protected final String TEXT_1057 = "[$this->";
  protected final String TEXT_1058 = "($";
  protected final String TEXT_1059 = ")]);" + NL + "      $this->";
  protected final String TEXT_1060 = " = array_values($this->";
  protected final String TEXT_1061 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  protected final String TEXT_1062 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1063 = NL + "  public function ";
  protected final String TEXT_1064 = "($";
  protected final String TEXT_1065 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  protected final String TEXT_1066 = NL + "    $this->";
  protected final String TEXT_1067 = "[] = $";
  protected final String TEXT_1068 = ";" + NL + "    $wasAdded = true;";
  protected final String TEXT_1069 = NL + "    return $wasAdded;" + NL + "  }" + NL + "" + NL + "  public function ";
  protected final String TEXT_1070 = "($";
  protected final String TEXT_1071 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  protected final String TEXT_1072 = NL + "    if ($this->";
  protected final String TEXT_1073 = "($";
  protected final String TEXT_1074 = ") == -1)" + NL + "    {";
  protected final String TEXT_1075 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    if ($this->";
  protected final String TEXT_1076 = "() <= self::";
  protected final String TEXT_1077 = "())" + NL + "    {";
  protected final String TEXT_1078 = NL + "      return $wasRemoved;" + NL + "    }" + NL + "" + NL + "    unset($this->";
  protected final String TEXT_1079 = "[$this->";
  protected final String TEXT_1080 = "($";
  protected final String TEXT_1081 = ")]);" + NL + "    $this->";
  protected final String TEXT_1082 = " = array_values($this->";
  protected final String TEXT_1083 = ");" + NL + "    $wasRemoved = true;";
  protected final String TEXT_1084 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  protected final String TEXT_1085 = NL + "  public function ";
  protected final String TEXT_1086 = "($";
  protected final String TEXT_1087 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1088 = NL + "    $";
  protected final String TEXT_1089 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1090 = " as $";
  protected final String TEXT_1091 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1092 = ",$";
  protected final String TEXT_1093 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1094 = "[] = $";
  protected final String TEXT_1095 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1096 = ") != count($";
  protected final String TEXT_1097 = ") || count($";
  protected final String TEXT_1098 = ") != self::";
  protected final String TEXT_1099 = "())" + NL + "    {";
  protected final String TEXT_1100 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1101 = " = $";
  protected final String TEXT_1102 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1103 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1104 = NL + "  public function ";
  protected final String TEXT_1105 = "($";
  protected final String TEXT_1106 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1107 = NL + "    $";
  protected final String TEXT_1108 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1109 = " as $";
  protected final String TEXT_1110 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1111 = ",$";
  protected final String TEXT_1112 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1113 = "[] = $";
  protected final String TEXT_1114 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1115 = ") != count($";
  protected final String TEXT_1116 = ") || count($";
  protected final String TEXT_1117 = ") < self::";
  protected final String TEXT_1118 = "() || count($";
  protected final String TEXT_1119 = ") > self::";
  protected final String TEXT_1120 = "())" + NL + "    {";
  protected final String TEXT_1121 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1122 = " = $this->";
  protected final String TEXT_1123 = ";" + NL + "    $this->";
  protected final String TEXT_1124 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1125 = " as $";
  protected final String TEXT_1126 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1127 = "[] = $";
  protected final String TEXT_1128 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_1129 = ",$";
  protected final String TEXT_1130 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1131 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_1132 = " = array_values($";
  protected final String TEXT_1133 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1134 = "->";
  protected final String TEXT_1135 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_1136 = " as $";
  protected final String TEXT_1137 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1138 = "->";
  protected final String TEXT_1139 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1140 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1141 = NL + "  public function ";
  protected final String TEXT_1142 = "($";
  protected final String TEXT_1143 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1144 = NL + "    $";
  protected final String TEXT_1145 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1146 = " as $";
  protected final String TEXT_1147 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1148 = ",$";
  protected final String TEXT_1149 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1150 = "[] = $";
  protected final String TEXT_1151 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1152 = ") != count($";
  protected final String TEXT_1153 = ") || count($";
  protected final String TEXT_1154 = ") < self::";
  protected final String TEXT_1155 = "())" + NL + "    {";
  protected final String TEXT_1156 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1157 = " = $this->";
  protected final String TEXT_1158 = ";" + NL + "    $this->";
  protected final String TEXT_1159 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1160 = " as $";
  protected final String TEXT_1161 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1162 = "[] = $";
  protected final String TEXT_1163 = ";" + NL + "      $removeIndex = array_search($";
  protected final String TEXT_1164 = ",$";
  protected final String TEXT_1165 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1166 = "[$removeIndex]);" + NL + "        $";
  protected final String TEXT_1167 = " = array_values($";
  protected final String TEXT_1168 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1169 = "->";
  protected final String TEXT_1170 = "($this);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    foreach ($";
  protected final String TEXT_1171 = " as $";
  protected final String TEXT_1172 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1173 = "->";
  protected final String TEXT_1174 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1175 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1176 = NL + "  public function ";
  protected final String TEXT_1177 = "($";
  protected final String TEXT_1178 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1179 = NL + "    $";
  protected final String TEXT_1180 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1181 = " as $";
  protected final String TEXT_1182 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1183 = ",$";
  protected final String TEXT_1184 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1185 = "[] = $";
  protected final String TEXT_1186 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1187 = ") != count($";
  protected final String TEXT_1188 = ") || count($";
  protected final String TEXT_1189 = ") < self::";
  protected final String TEXT_1190 = "()  || count($";
  protected final String TEXT_1191 = ") > self::";
  protected final String TEXT_1192 = "())" + NL + "    {";
  protected final String TEXT_1193 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1194 = " = $";
  protected final String TEXT_1195 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1196 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1197 = NL + "  public function ";
  protected final String TEXT_1198 = "($";
  protected final String TEXT_1199 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1200 = NL + "    if (count($";
  protected final String TEXT_1201 = ") < self::";
  protected final String TEXT_1202 = "()";
  protected final String TEXT_1203 = ")" + NL + "    {";
  protected final String TEXT_1204 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $";
  protected final String TEXT_1205 = " = array();" + NL + "    $";
  protected final String TEXT_1206 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1207 = " as $";
  protected final String TEXT_1208 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1209 = ",$";
  protected final String TEXT_1210 = ") !== false)" + NL + "      {";
  protected final String TEXT_1211 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  protected final String TEXT_1212 = "->";
  protected final String TEXT_1213 = "() != null && $this !== $";
  protected final String TEXT_1214 = "->";
  protected final String TEXT_1215 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_1216 = " = $";
  protected final String TEXT_1217 = "->";
  protected final String TEXT_1218 = "();" + NL + "        $";
  protected final String TEXT_1219 = " = serialize($";
  protected final String TEXT_1220 = ");" + NL + "        if (!array_key_exists($";
  protected final String TEXT_1221 = ", $";
  protected final String TEXT_1222 = "))" + NL + "        {" + NL + "          $";
  protected final String TEXT_1223 = "[$";
  protected final String TEXT_1224 = "] = $";
  protected final String TEXT_1225 = "->";
  protected final String TEXT_1226 = "();" + NL + "        }" + NL + "        $nextCount = $";
  protected final String TEXT_1227 = "[$";
  protected final String TEXT_1228 = "] - 1;" + NL + "        if ($nextCount < self::minimum";
  protected final String TEXT_1229 = "())" + NL + "        {";
  protected final String TEXT_1230 = NL + "          return $wasSet;" + NL + "        }" + NL + "        $";
  protected final String TEXT_1231 = "[$";
  protected final String TEXT_1232 = "] = $nextCount;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1233 = "[] = $";
  protected final String TEXT_1234 = ";" + NL + "    }" + NL + "" + NL + "    foreach ($this->";
  protected final String TEXT_1235 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  protected final String TEXT_1236 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + "      " + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1237 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1238 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1239 = " as $";
  protected final String TEXT_1240 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1241 = "->";
  protected final String TEXT_1242 = "() != null)" + NL + "      {" + NL + "        unset($";
  protected final String TEXT_1243 = "->";
  protected final String TEXT_1244 = "()->";
  protected final String TEXT_1245 = "[$";
  protected final String TEXT_1246 = "->";
  protected final String TEXT_1247 = "()->";
  protected final String TEXT_1248 = "($";
  protected final String TEXT_1249 = ")]);" + NL + "        $";
  protected final String TEXT_1250 = "->";
  protected final String TEXT_1251 = "()->";
  protected final String TEXT_1252 = " = array_values($";
  protected final String TEXT_1253 = "->";
  protected final String TEXT_1254 = "()->";
  protected final String TEXT_1255 = ");" + NL + "      }" + NL + "      $this->";
  protected final String TEXT_1256 = "($";
  protected final String TEXT_1257 = ", $this);" + NL + "      $this->";
  protected final String TEXT_1258 = "[] = $";
  protected final String TEXT_1259 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  protected final String TEXT_1260 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1261 = NL + "  private function ";
  protected final String TEXT_1262 = "($";
  protected final String TEXT_1263 = ", $";
  protected final String TEXT_1264 = ")" + NL + "  {" + NL + "    $";
  protected final String TEXT_1265 = "->mentor = $";
  protected final String TEXT_1266 = ";" + NL + "    //$prop = new ReflectionProperty($";
  protected final String TEXT_1267 = ", '";
  protected final String TEXT_1268 = "');" + NL + "    //$prop->setAccessible(true);" + NL + "    //$prop->setValue($";
  protected final String TEXT_1269 = ",$";
  protected final String TEXT_1270 = ");" + NL + "    //$prop->setAccessible(false);" + NL + "  }" + NL;
  protected final String TEXT_1271 = NL + "  public function ";
  protected final String TEXT_1272 = "($";
  protected final String TEXT_1273 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1274 = NL + "    $";
  protected final String TEXT_1275 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1276 = " as $";
  protected final String TEXT_1277 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1278 = ",$";
  protected final String TEXT_1279 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1280 = "[] = $";
  protected final String TEXT_1281 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1282 = ") != count($";
  protected final String TEXT_1283 = ") || count($";
  protected final String TEXT_1284 = ") > self::";
  protected final String TEXT_1285 = "())" + NL + "    {";
  protected final String TEXT_1286 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1287 = " = $";
  protected final String TEXT_1288 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1289 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1290 = NL + "  public function ";
  protected final String TEXT_1291 = "($";
  protected final String TEXT_1292 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  protected final String TEXT_1293 = NL + "    $";
  protected final String TEXT_1294 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1295 = " as $";
  protected final String TEXT_1296 = ")" + NL + "    {" + NL + "      if (array_search($";
  protected final String TEXT_1297 = ",$";
  protected final String TEXT_1298 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  protected final String TEXT_1299 = "[] = $";
  protected final String TEXT_1300 = ";" + NL + "    }" + NL + "" + NL + "    if (count($";
  protected final String TEXT_1301 = ") != count($";
  protected final String TEXT_1302 = ") || count($";
  protected final String TEXT_1303 = ") < self::";
  protected final String TEXT_1304 = "())" + NL + "    {";
  protected final String TEXT_1305 = NL + "      return $wasSet;" + NL + "    }" + NL + "" + NL + "    $this->";
  protected final String TEXT_1306 = " = $";
  protected final String TEXT_1307 = ";" + NL + "    $wasSet = true;";
  protected final String TEXT_1308 = NL + "    return $wasSet;" + NL + "  }" + NL;
  protected final String TEXT_1309 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    if ($compareTo == null) { return false; }" + NL + "    if (get_class($this) != get_class($compareTo)) { return false; }" + NL;
  protected final String TEXT_1310 = NL + "    ";
  protected final String TEXT_1311 = NL + NL + "    return true;" + NL + "  }" + NL + "" + NL + "  public function hashCode()" + NL + "  {" + NL + "    if ($this->cachedHashCode != -1)" + NL + "    {" + NL + "      return $this->cachedHashCode;" + NL + "    }" + NL + "    $this->cachedHashCode = 17;";
  protected final String TEXT_1312 = NL + "    ";
  protected final String TEXT_1313 = NL;
  protected final String TEXT_1314 = NL + "    ";
  protected final String TEXT_1315 = NL + "    return $this->cachedHashCode;" + NL + "  }" + NL;
  protected final String TEXT_1316 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    return $this == $compareTo;" + NL + "  }" + NL;
  protected final String TEXT_1317 = NL + "    $this->";
  protected final String TEXT_1318 = " = null;";
  protected final String TEXT_1319 = NL + "    $this->";
  protected final String TEXT_1320 = " = array();";
  protected final String TEXT_1321 = NL + "    $";
  protected final String TEXT_1322 = " = $this->";
  protected final String TEXT_1323 = ";" + NL + "    $this->";
  protected final String TEXT_1324 = " = null;" + NL + "    if ($";
  protected final String TEXT_1325 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1326 = "->delete();" + NL + "    }";
  protected final String TEXT_1327 = NL + "    if ($this->";
  protected final String TEXT_1328 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1329 = "->";
  protected final String TEXT_1330 = "(null);" + NL + "    }";
  protected final String TEXT_1331 = NL + "    $";
  protected final String TEXT_1332 = " = $this->";
  protected final String TEXT_1333 = ";" + NL + "    $this->";
  protected final String TEXT_1334 = " = null;" + NL + "    if ($";
  protected final String TEXT_1335 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1336 = "->";
  protected final String TEXT_1337 = "(null);" + NL + "    }";
  protected final String TEXT_1338 = NL + "    $";
  protected final String TEXT_1339 = " = $this->";
  protected final String TEXT_1340 = ";" + NL + "    $this->";
  protected final String TEXT_1341 = " = null;" + NL + "    if ($";
  protected final String TEXT_1342 = " != null)" + NL + "    {" + NL + "      $";
  protected final String TEXT_1343 = "->delete();" + NL + "    }";
  protected final String TEXT_1344 = NL + "    if ($this->";
  protected final String TEXT_1345 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1346 = "->";
  protected final String TEXT_1347 = "($this);" + NL + "    }";
  protected final String TEXT_1348 = NL + "    if ($this->";
  protected final String TEXT_1349 = " != null)" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1350 = "->delete();" + NL + "    }";
  protected final String TEXT_1351 = NL + "    if ($this->";
  protected final String TEXT_1352 = " != null)" + NL + "    {" + NL + "      if ($this->";
  protected final String TEXT_1353 = "->";
  protected final String TEXT_1354 = "() <= ";
  protected final String TEXT_1355 = ")" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1356 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $this->";
  protected final String TEXT_1357 = "->";
  protected final String TEXT_1358 = "($this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1359 = NL + "    $this->";
  protected final String TEXT_1360 = "->";
  protected final String TEXT_1361 = "($this);";
  protected final String TEXT_1362 = NL + "    foreach ($this->";
  protected final String TEXT_1363 = " as $";
  protected final String TEXT_1364 = ")" + NL + "    {" + NL + "      $this->";
  protected final String TEXT_1365 = "($";
  protected final String TEXT_1366 = ",null);" + NL + "    }" + NL + "    $this->";
  protected final String TEXT_1367 = " = array();";
  protected final String TEXT_1368 = NL + "    $";
  protected final String TEXT_1369 = " = $this->";
  protected final String TEXT_1370 = ";" + NL + "    $this->";
  protected final String TEXT_1371 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1372 = " as $";
  protected final String TEXT_1373 = ")" + NL + "    {" + NL + "      if ($";
  protected final String TEXT_1374 = "->";
  protected final String TEXT_1375 = "() <= ";
  protected final String TEXT_1376 = "::";
  protected final String TEXT_1377 = "())" + NL + "      {" + NL + "        $";
  protected final String TEXT_1378 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  protected final String TEXT_1379 = "->";
  protected final String TEXT_1380 = "($this);" + NL + "      }" + NL + "    }";
  protected final String TEXT_1381 = NL + "    $";
  protected final String TEXT_1382 = " = $this->";
  protected final String TEXT_1383 = ";" + NL + "    $this->";
  protected final String TEXT_1384 = " = array();" + NL + "    foreach ($";
  protected final String TEXT_1385 = " as $";
  protected final String TEXT_1386 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1387 = "->";
  protected final String TEXT_1388 = "($this);" + NL + "    }";
  protected final String TEXT_1389 = NL + "    foreach ($this->";
  protected final String TEXT_1390 = " as $";
  protected final String TEXT_1391 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1392 = "->delete();" + NL + "    }";
  protected final String TEXT_1393 = NL + "    foreach ($this->";
  protected final String TEXT_1394 = " as $";
  protected final String TEXT_1395 = ")" + NL + "    {" + NL + "      $";
  protected final String TEXT_1396 = "->";
  protected final String TEXT_1397 = "(null);" + NL + "    }";
  protected final String TEXT_1398 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  ";
  protected final String TEXT_1399 = NL + "  ";
  protected final String TEXT_1400 = NL + "}" + NL + "?>";

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
    stringBuffer.append( uClass.getName() );
    stringBuffer.append( gen.translate("isA",uClass) );
    stringBuffer.append(TEXT_3);
    
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

    stringBuffer.append(TEXT_4);
    
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
      
    stringBuffer.append(TEXT_5);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_7);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_8);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_9);
     
    }
    else if ("immutable".equals(av.getModifier()) && av.getIsLazy())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_10);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_11);
    
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

    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(parameterValue);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_15);
     
    }
    else
    {
      hasBody = true;
      if(!av.getIsLazy()){
         
    
  String assignValue = av.getValue() == null ? "$" + gen.translate("parameterOne",av) : gen.translate("parameterValue",av);

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
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_33);
    
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
  

    stringBuffer.append(TEXT_34);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_44);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    stringBuffer.append(TEXT_45);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_47);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_56);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_57);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_59);
    
    }
    else if (av.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_67);
    
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
  

    stringBuffer.append(TEXT_68);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_78);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_82);
    
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
    
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_85);
    
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(gen.translate("stateNull",state));
    stringBuffer.append(TEXT_89);
    
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
    
    stringBuffer.append(TEXT_90);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_91);
    
  }

    
  if (isOneToOne)
  {
    instanceIdentifier = "thisInstance";
    
    
  String signature = gClass.getLookup("constructorSignature_mandatory");

    stringBuffer.append(TEXT_92);
    stringBuffer.append(gen.translate("constructorMandatory",uClass));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_95);
    
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
      
    stringBuffer.append(TEXT_96);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_98);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_100);
     
    }
    else
    {
      
    
  String assignValue = av.getValue() == null ? "$" + gen.translate("parameterOne",av) : gen.translate("parameterValue",av);

    stringBuffer.append(TEXT_101);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(assignValue);
    stringBuffer.append(TEXT_104);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_105);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_108);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    stringBuffer.append(TEXT_109);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    stringBuffer.append(TEXT_113);
    
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
  

    stringBuffer.append(TEXT_114);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(instanceIdentifier);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_124);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_128);
    
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
    
    stringBuffer.append(TEXT_129);
    stringBuffer.append( gClass.getParentClass().getLookup("constructorSignature") );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( gClass.getParentClass().getLookup("constructorSignature_caller") );
    stringBuffer.append(TEXT_131);
    
  }

    
  }


    stringBuffer.append(TEXT_132);
    
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
        
    stringBuffer.append(TEXT_133);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_135);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_136);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_139);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_140);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_143);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_146);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_148);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n    {0}",customResetPrefixCode); } 
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_151);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n    {0}",customResetPostfixCode); } 
    stringBuffer.append(TEXT_152);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_155);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_158);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_161);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_167);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_168);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_169);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_171);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_172);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_174);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_175);
    
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
      
    stringBuffer.append(TEXT_176);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_177);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_178);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_180);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_181);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_183);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_186);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_187);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_189);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_190);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_191);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_192);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_193);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_194);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_195);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_198);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_199);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_201);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_202);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_203);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_204);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_206);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_207);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_208);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_209);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_210);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_211);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_212);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_213);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_215);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_216);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_218);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_219);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_220);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_221);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_222);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_224);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_225);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_226);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_229);
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPostfixCode); } 
    stringBuffer.append(TEXT_230);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_231);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_232);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_233);
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetDefaultPrefixCode); } 
    stringBuffer.append(TEXT_234);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_235);
    
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
        
    stringBuffer.append(TEXT_236);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_237);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_238);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_240);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_241);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_242);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_243);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_244);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_245);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_246);
    
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

    stringBuffer.append(TEXT_247);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_248);
     if (outputCases.length() > 0) { append(stringBuffer, "\n    {0}",outputCases); } 
    stringBuffer.append(TEXT_249);
     
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

    stringBuffer.append(TEXT_250);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(TEXT_252);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_253);
    
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

    stringBuffer.append(TEXT_254);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_255);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(TEXT_257);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_258);
    
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
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(TEXT_261);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_262);
     } 
    stringBuffer.append(TEXT_263);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_264);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_265);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_266);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_267);
     if (hasEntry) { 
    stringBuffer.append(TEXT_268);
    stringBuffer.append(TEXT_269);
    stringBuffer.append( entryActions );
     } 
    stringBuffer.append(TEXT_270);
    
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
      
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_272);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_274);
     } else { 
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_277);
     append(stringBuffer, "\n    {0}",customGetPostfixCode); 
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_279);
     } 
    stringBuffer.append(TEXT_280);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_281);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_282);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetPrefixCode); } 
    stringBuffer.append(TEXT_283);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_285);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetPostfixCode); } 
    stringBuffer.append(TEXT_286);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(gen.translate("getManyMethod",av));
    stringBuffer.append(TEXT_288);
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPrefixCode); } 
    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_291);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customGetManyPostfixCode); } 
    stringBuffer.append(TEXT_292);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_294);
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_295);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_296);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_297);
    stringBuffer.append(gen.translate("hasManyMethod",av));
    stringBuffer.append(TEXT_298);
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPrefixCode); } 
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_300);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customHasManyPostfixCode); } 
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_303);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPrefixCode); } 
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_308);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customIndexOfPostfixCode); } 
    stringBuffer.append(TEXT_309);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_310);
    
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
      
    stringBuffer.append(TEXT_311);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(relatedAssociation);
    
    }

    boolean addNewLine = false;
    if (hasIsNumberOfValidMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_313);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
    stringBuffer.append(TEXT_314);
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPrefixCode); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_315);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_317);
     } else { 
    stringBuffer.append(TEXT_318);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_322);
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n    {0}",customIsNumberOfValidPostfixCode); } 
    stringBuffer.append(TEXT_323);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_324);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_326);
     } else { 
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_328);
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_329);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_330);
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customRequiredNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_331);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_334);
     } else { 
    stringBuffer.append(TEXT_335);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_336);
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_337);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_338);
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMinimumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_339);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_342);
     } else { 
    stringBuffer.append(TEXT_343);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_344);
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPrefixCode); } 
    stringBuffer.append(TEXT_345);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_346);
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n    {0}",customMaximumNumberOfPostfixCode); } 
    stringBuffer.append(TEXT_347);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_350);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_353);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_354);
     } 
    stringBuffer.append(TEXT_355);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_362);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_363);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_364);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_366);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_367);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_369);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_370);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_382);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_383);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_386);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_389);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_390);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_393);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_397);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_398);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_401);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_402);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_409);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_410);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_423);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_424);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_427);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_440);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_441);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_450);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_451);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_452);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_458);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_459);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_471);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_474);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_477);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_482);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_487);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_493);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_494);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_503);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_506);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_507);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_517);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_523);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_526);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_531);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_532);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_536);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_537);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_542);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_543);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_552);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_555);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_567);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_568);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_570);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_571);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_580);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_581);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_584);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_596);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_615);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_616);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("addViaMethod",av));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_623);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_635);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_638);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_648);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_649);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_652);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_656);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_662);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_663);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_678);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_679);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_682);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_685);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_688);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_701);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_702);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_705);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_706);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_708);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_711);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_724);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_725);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_728);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_734);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_747);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_748);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_751);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_753);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_765);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_766);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_769);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_773);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_780);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_792);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_795);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_796);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_799);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_803);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_809);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_810);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_821);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_824);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_825);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_828);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_843);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_846);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_858);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_859);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_862);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetPrefixCode); } 
    stringBuffer.append(TEXT_863);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_877);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetPostfixCode); } 
    stringBuffer.append(TEXT_878);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_881);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_882);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_884);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_899);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_902);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_912);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_913);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_914);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_916);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_917);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_921);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_924);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_927);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_930);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_936);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_937);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_940);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_943);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_944);
     } 
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_952);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n      {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_967);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_968);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_970);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_982);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_983);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_986);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_992);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_997);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1002);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1013);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1024);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1027);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1030);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1033);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1041);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1042);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1045);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1050);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1053);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1061);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1062);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1065);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n    {0}",customAddPrefixCode); } 
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1068);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n    {0}",customAddPostfixCode); } 
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1071);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n    {0}",customRemovePrefixCode); } 
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1074);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1077);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n      {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1083);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n    {0}",customRemovePostfixCode); } 
    stringBuffer.append(TEXT_1084);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1087);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_1099);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1102);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1103);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1106);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1120);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1139);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1140);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1143);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1155);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1174);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1175);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1178);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1192);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1195);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1196);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || count(${0}) > self::{1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1199);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(orCheckMaxBound);
    stringBuffer.append(TEXT_1203);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1210);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1229);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n        {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.relatedTranslate("parameterExistingSerialized",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1259);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.relatedTranslate("parameterOne",av));
    stringBuffer.append(TEXT_1270);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1273);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1285);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1288);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1289);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1292);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPrefixCode); } 
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1304);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n      {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1307);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n    {0}",customSetManyPostfixCode); } 
    stringBuffer.append(TEXT_1308);
    
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


    stringBuffer.append(TEXT_1309);
    stringBuffer.append(TEXT_1310);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(TEXT_1312);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(TEXT_1314);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1315);
     } else { 
    stringBuffer.append(TEXT_1316);
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
        
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1318);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1320);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1326);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1330);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1337);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1343);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1347);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1350);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1358);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1361);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1367);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1380);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1388);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1392);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1397);
    
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
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_1400);
    return stringBuffer.toString();
  }
}