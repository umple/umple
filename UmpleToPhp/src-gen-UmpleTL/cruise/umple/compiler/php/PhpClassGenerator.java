/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.23.0-3bd2bc7 modeling language!*/

package cruise.umple.compiler.php;
import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;
import java.util.regex.Pattern;

// line 28 "../../../../../UmpleTLTemplates/phpClassGenerator.ump"
public class PhpClassGenerator implements ILang
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String NL = System.getProperty("line.separator");
  public static final String TEXT_0 = "<?php";
  public static final String TEXT_1 = NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/";
  public static final String TEXT_2 = NL;
  public static final String TEXT_3 = NL + "class ";
  public static final String TEXT_4 = NL + "{";
  public static final String TEXT_5 = NL + NL + "  //------------------------" + NL + "  // CONSTRUCTOR" + NL + "  //------------------------" + NL;
  public static final String TEXT_6 = NL + "    $";
  public static final String TEXT_7 = "->";
  public static final String TEXT_8 = " = array();";
  public static final String TEXT_9 = NL + "    $this->";
  public static final String TEXT_10 = "();";
  public static final String TEXT_11 = NL + "    $this->";
  public static final String TEXT_12 = " = true;";
  public static final String TEXT_13 = NL + "    $this->";
  public static final String TEXT_14 = " = ";
  public static final String TEXT_15 = ";";
  public static final String TEXT_16 = NL + "    $";
  public static final String TEXT_17 = "->";
  public static final String TEXT_18 = " = ";
  public static final String TEXT_19 = ";";
  public static final String TEXT_20 = NL + "    $";
  public static final String TEXT_21 = "->";
  public static final String TEXT_22 = " = ";
  public static final String TEXT_23 = ";";
  public static final String TEXT_24 = NL + "    $";
  public static final String TEXT_25 = "->";
  public static final String TEXT_26 = " = self::$";
  public static final String TEXT_27 = "++;";
  public static final String TEXT_28 = NL + "    if (!$this->";
  public static final String TEXT_29 = "($";
  public static final String TEXT_30 = "))" + NL + "    {" + NL + "      throw new RuntimeException(\"Cannot create due to duplicate ";
  public static final String TEXT_31 = "\");" + NL + "    }";
  public static final String TEXT_32 = NL + "    if (!$";
  public static final String TEXT_33 = "->";
  public static final String TEXT_34 = "($";
  public static final String TEXT_35 = "))" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  public static final String TEXT_36 = " due to ";
  public static final String TEXT_37 = "\");" + NL + "    }";
  public static final String TEXT_38 = NL + "    $";
  public static final String TEXT_39 = "->";
  public static final String TEXT_40 = " = array();" + NL + "    $";
  public static final String TEXT_41 = " = $";
  public static final String TEXT_42 = "->";
  public static final String TEXT_43 = "($";
  public static final String TEXT_44 = ");" + NL + "    if (!$";
  public static final String TEXT_45 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  public static final String TEXT_46 = ", must have ";
  public static final String TEXT_47 = " ";
  public static final String TEXT_48 = "\");" + NL + "    }";
  public static final String TEXT_49 = NL + "    $";
  public static final String TEXT_50 = "->";
  public static final String TEXT_51 = " = array();" + NL + "    $";
  public static final String TEXT_52 = " = $";
  public static final String TEXT_53 = "->";
  public static final String TEXT_54 = "($";
  public static final String TEXT_55 = ");" + NL + "    if (!$";
  public static final String TEXT_56 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  public static final String TEXT_57 = ", must have ";
  public static final String TEXT_58 = " or fewer ";
  public static final String TEXT_59 = ", no duplicates.\");" + NL + "    }";
  public static final String TEXT_60 = NL + "    $";
  public static final String TEXT_61 = "->";
  public static final String TEXT_62 = " = array();" + NL + "    $";
  public static final String TEXT_63 = " = $";
  public static final String TEXT_64 = "->";
  public static final String TEXT_65 = "($";
  public static final String TEXT_66 = ");" + NL + "    if (!$";
  public static final String TEXT_67 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  public static final String TEXT_68 = ", must not have duplicate ";
  public static final String TEXT_69 = ".\");" + NL + "    }";
  public static final String TEXT_70 = NL + "    $";
  public static final String TEXT_71 = "->";
  public static final String TEXT_72 = " = array();";
  public static final String TEXT_73 = NL + "    if ($";
  public static final String TEXT_74 = " == null || $";
  public static final String TEXT_75 = "->";
  public static final String TEXT_76 = "() != null)" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  public static final String TEXT_77 = " due to ";
  public static final String TEXT_78 = "\");" + NL + "    }" + NL + "    $";
  public static final String TEXT_79 = "->";
  public static final String TEXT_80 = " = $";
  public static final String TEXT_81 = ";";
  public static final String TEXT_82 = NL + "    $";
  public static final String TEXT_83 = " = $";
  public static final String TEXT_84 = "->";
  public static final String TEXT_85 = "($";
  public static final String TEXT_86 = ");" + NL + "    if (!$";
  public static final String TEXT_87 = ")" + NL + "    {" + NL + "      throw new Exception(\"Unable to create ";
  public static final String TEXT_88 = " due to ";
  public static final String TEXT_89 = "\");" + NL + "    }";
  public static final String TEXT_90 = "$this->";
  public static final String TEXT_91 = " = array();" + NL + "    $this->";
  public static final String TEXT_92 = "[] = $";
  public static final String TEXT_93 = ";";
  public static final String TEXT_94 = NL + "    $this->";
  public static final String TEXT_95 = "(self::$";
  public static final String TEXT_96 = ");";
  public static final String TEXT_97 = NL + "    $this->";
  public static final String TEXT_98 = "(self::$";
  public static final String TEXT_99 = ");";
  public static final String TEXT_100 = NL + "  public static function getInstance()" + NL + "  {" + NL + "    if(self::$theInstance == null)" + NL + "    {" + NL + "      self::$theInstance = new ";
  public static final String TEXT_101 = "();" + NL + "    }" + NL + "    return self::$theInstance;" + NL + "  }";
  public static final String TEXT_102 = NL + "  public static function newInstance(";
  public static final String TEXT_103 = ")" + NL + "  {" + NL + "    $";
  public static final String TEXT_104 = " = new ";
  public static final String TEXT_105 = "();";
  public static final String TEXT_106 = NL + "    $";
  public static final String TEXT_107 = "->";
  public static final String TEXT_108 = " = new ";
  public static final String TEXT_109 = "(";
  public static final String TEXT_110 = ");";
  public static final String TEXT_111 = NL + "  private function callParentConstructor(";
  public static final String TEXT_112 = ")" + NL + "  {" + NL + "    parent::__construct(";
  public static final String TEXT_113 = ");" + NL + "  }" + NL;
  public static final String TEXT_114 = NL + NL + "  //------------------------" + NL + "  // INTERFACE" + NL + "  //------------------------" + NL;
  public static final String TEXT_115 = NL + "  public function ";
  public static final String TEXT_116 = "($";
  public static final String TEXT_117 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_118 = NL + "    $this->";
  public static final String TEXT_119 = " = false;" + NL + "    $this->";
  public static final String TEXT_120 = " = $";
  public static final String TEXT_121 = ";" + NL + "    $wasSet = true;";
  public static final String TEXT_122 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_123 = NL + "  public function ";
  public static final String TEXT_124 = "($";
  public static final String TEXT_125 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_126 = NL + "    $this->";
  public static final String TEXT_127 = " = $";
  public static final String TEXT_128 = ";" + NL + "    $wasSet = true;";
  public static final String TEXT_129 = NL + "    return $wasSet;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_130 = "()" + NL + "  {" + NL + "    $wasReset = false;";
  public static final String TEXT_131 = NL + "    $this->";
  public static final String TEXT_132 = " = $this->";
  public static final String TEXT_133 = "();" + NL + "    $wasReset = true;";
  public static final String TEXT_134 = NL + "    return $wasReset;" + NL + "  }" + NL;
  public static final String TEXT_135 = NL + "  public function ";
  public static final String TEXT_136 = "($";
  public static final String TEXT_137 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_138 = NL + "    $this->";
  public static final String TEXT_139 = "[] = $";
  public static final String TEXT_140 = ";" + NL + "    $wasAdded = true;";
  public static final String TEXT_141 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_142 = "($";
  public static final String TEXT_143 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_144 = NL + "    unset($this->";
  public static final String TEXT_145 = "[$this->";
  public static final String TEXT_146 = "($";
  public static final String TEXT_147 = ")]);" + NL + "    $this->";
  public static final String TEXT_148 = " = array_values($this->";
  public static final String TEXT_149 = ");" + NL + "    $wasRemoved = true;";
  public static final String TEXT_150 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_151 = NL + "  public function ";
  public static final String TEXT_152 = "($";
  public static final String TEXT_153 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_154 = "";
  public static final String TEXT_155 = NL + "    $this->";
  public static final String TEXT_156 = " = $";
  public static final String TEXT_157 = ";";
  public static final String TEXT_158 = NL + "    $wasSet = true;";
  public static final String TEXT_159 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_160 = NL + "  public function ";
  public static final String TEXT_161 = "($";
  public static final String TEXT_162 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_163 = "";
  public static final String TEXT_164 = NL + "      $wasSet = parent::";
  public static final String TEXT_165 = "(";
  public static final String TEXT_166 = ");";
  public static final String TEXT_167 = "";
  public static final String TEXT_168 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_169 = NL + "  public function ";
  public static final String TEXT_170 = "($";
  public static final String TEXT_171 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_172 = "";
  public static final String TEXT_173 = NL + "      $wasAdded = parent::";
  public static final String TEXT_174 = "(";
  public static final String TEXT_175 = ");";
  public static final String TEXT_176 = "";
  public static final String TEXT_177 = NL + "    return $wasAdded;" + NL + "  }";
  public static final String TEXT_178 = NL + "  public function ";
  public static final String TEXT_179 = "($";
  public static final String TEXT_180 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_181 = "";
  public static final String TEXT_182 = NL + "      $wasSet = parent::";
  public static final String TEXT_183 = "(";
  public static final String TEXT_184 = ");";
  public static final String TEXT_185 = "";
  public static final String TEXT_186 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_187 = NL + "  public function ";
  public static final String TEXT_188 = "($index)" + NL + "  {";
  public static final String TEXT_189 = NL + "    $";
  public static final String TEXT_190 = " = $this->";
  public static final String TEXT_191 = "[$index];";
  public static final String TEXT_192 = NL + "    return $";
  public static final String TEXT_193 = ";" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_194 = "()" + NL + "  {";
  public static final String TEXT_195 = NL + "    $";
  public static final String TEXT_196 = " = $this->";
  public static final String TEXT_197 = ";";
  public static final String TEXT_198 = NL + "    return $";
  public static final String TEXT_199 = ";" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_200 = "()" + NL + "  {";
  public static final String TEXT_201 = NL + "    $number = count($this->";
  public static final String TEXT_202 = ");";
  public static final String TEXT_203 = NL + "    return $number;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_204 = "()" + NL + "  {";
  public static final String TEXT_205 = NL + "    $has = ";
  public static final String TEXT_206 = ".size() > 0;";
  public static final String TEXT_207 = NL + "    return $has;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_208 = "($";
  public static final String TEXT_209 = ")" + NL + "  {";
  public static final String TEXT_210 = NL + "    $rawAnswer = array_search($";
  public static final String TEXT_211 = ",$this->";
  public static final String TEXT_212 = ");" + NL + "    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;";
  public static final String TEXT_213 = NL + "    return $index;" + NL + "  }" + NL;
  public static final String TEXT_214 = NL + "  public function ";
  public static final String TEXT_215 = "()" + NL + "  {";
  public static final String TEXT_216 = NL + "    $";
  public static final String TEXT_217 = " = ";
  public static final String TEXT_218 = ";";
  public static final String TEXT_219 = NL + "    return $";
  public static final String TEXT_220 = ";" + NL + "  }";
  public static final String TEXT_221 = NL + "  public function ";
  public static final String TEXT_222 = "()" + NL + "  {";
  public static final String TEXT_223 = NL + "    return ";
  public static final String TEXT_224 = ";" + NL + "  }";
  public static final String TEXT_225 = NL + "  public function ";
  public static final String TEXT_226 = "()" + NL + "  {";
  public static final String TEXT_227 = NL + "    $";
  public static final String TEXT_228 = " = $this->";
  public static final String TEXT_229 = ";";
  public static final String TEXT_230 = NL + "    return $";
  public static final String TEXT_231 = ";" + NL + "  }";
  public static final String TEXT_232 = NL + "  public function ";
  public static final String TEXT_233 = "()" + NL + "  {";
  public static final String TEXT_234 = NL + "    return $this->";
  public static final String TEXT_235 = ";" + NL + "  }";
  public static final String TEXT_236 = NL + "  public function ";
  public static final String TEXT_237 = "()" + NL + "  {";
  public static final String TEXT_238 = NL + "    $";
  public static final String TEXT_239 = " = ";
  public static final String TEXT_240 = ";";
  public static final String TEXT_241 = NL + "    return $";
  public static final String TEXT_242 = ";" + NL + "  }" + NL;
  public static final String TEXT_243 = NL + "  public function ";
  public static final String TEXT_244 = "()" + NL + "  {";
  public static final String TEXT_245 = NL + "    return ";
  public static final String TEXT_246 = ";" + NL + "  }" + NL;
  public static final String TEXT_247 = NL + "  public static function ";
  public static final String TEXT_248 = "($";
  public static final String TEXT_249 = ")" + NL + "  {";
  public static final String TEXT_250 = NL + "    $";
  public static final String TEXT_251 = " = ";
  public static final String TEXT_252 = "[(string)$";
  public static final String TEXT_253 = "];";
  public static final String TEXT_254 = "    return $";
  public static final String TEXT_255 = ";" + NL + "  }" + NL;
  public static final String TEXT_256 = NL + "  public static function ";
  public static final String TEXT_257 = "($";
  public static final String TEXT_258 = ")" + NL + "  {";
  public static final String TEXT_259 = "";
  public static final String TEXT_260 = NL + "    return ";
  public static final String TEXT_261 = "[(string)$";
  public static final String TEXT_262 = "];" + NL + "  }" + NL;
  public static final String TEXT_263 = NL + "  public static function ";
  public static final String TEXT_264 = "($";
  public static final String TEXT_265 = ")" + NL + "  {";
  public static final String TEXT_266 = NL + "    $";
  public static final String TEXT_267 = " = array_key_exists((string)$";
  public static final String TEXT_268 = ", ";
  public static final String TEXT_269 = ");";
  public static final String TEXT_270 = "    return $";
  public static final String TEXT_271 = ";" + NL + "  }" + NL;
  public static final String TEXT_272 = NL + "  public static function ";
  public static final String TEXT_273 = "($";
  public static final String TEXT_274 = ")" + NL + "  {";
  public static final String TEXT_275 = "";
  public static final String TEXT_276 = NL + "    return array_key_exists((string)$";
  public static final String TEXT_277 = ", ";
  public static final String TEXT_278 = ");" + NL + "  }" + NL;
  public static final String TEXT_279 = NL + "  public ";
  public static final String TEXT_280 = " ";
  public static final String TEXT_281 = "()" + NL + "  {";
  public static final String TEXT_282 = NL + "    ";
  public static final String TEXT_283 = " ";
  public static final String TEXT_284 = " = ";
  public static final String TEXT_285 = ";";
  public static final String TEXT_286 = NL + "    return ";
  public static final String TEXT_287 = ";" + NL + "  }";
  public static final String TEXT_288 = NL + "  public ";
  public static final String TEXT_289 = " ";
  public static final String TEXT_290 = "()" + NL + "  {";
  public static final String TEXT_291 = NL + "    return ";
  public static final String TEXT_292 = ";" + NL + "  }";
  public static final String TEXT_293 = NL + "  public ";
  public static final String TEXT_294 = " ";
  public static final String TEXT_295 = "()" + NL + "  {";
  public static final String TEXT_296 = NL + "    $";
  public static final String TEXT_297 = " = $this->";
  public static final String TEXT_298 = ";";
  public static final String TEXT_299 = NL + "    return $";
  public static final String TEXT_300 = ";" + NL + "  }";
  public static final String TEXT_301 = NL + "  public function ";
  public static final String TEXT_302 = "()" + NL + "  {";
  public static final String TEXT_303 = NL + "    return $this->";
  public static final String TEXT_304 = ";" + NL + "  }";
  public static final String TEXT_305 = NL + "  public function ";
  public static final String TEXT_306 = "()" + NL + "  {" + NL + "    $answer = $this->";
  public static final String TEXT_307 = "();";
  public static final String TEXT_308 = NL + "    return $answer;" + NL + "  }" + NL;
  public static final String TEXT_309 = NL + "  public function ";
  public static final String TEXT_310 = "()" + NL + "  {";
  public static final String TEXT_311 = NL + "    return null;" + NL + "  }" + NL;
  public static final String TEXT_312 = NL + "  ";
  public static final String TEXT_313 = " function ";
  public static final String TEXT_314 = "(";
  public static final String TEXT_315 = ")" + NL + "  {" + NL + "    $wasEventProcessed = false;" + NL + "    ";
  public static final String TEXT_316 = NL + "    return $wasEventProcessed;" + NL + "  }" + NL;
  public static final String TEXT_317 = NL + "  public function ";
  public static final String TEXT_318 = "($";
  public static final String TEXT_319 = ")" + NL + "  {";
  public static final String TEXT_320 = "";
  public static final String TEXT_321 = NL + "    ";
  public static final String TEXT_322 = NL + "    else" + NL + "    {" + NL + "      return false;" + NL + "    }" + NL + "  }" + NL;
  public static final String TEXT_323 = "";
  public static final String TEXT_324 = NL + "  private function ";
  public static final String TEXT_325 = "()" + NL + "  {";
  public static final String TEXT_326 = NL + "    ";
  public static final String TEXT_327 = "";
  public static final String TEXT_328 = NL + "  }" + NL;
  public static final String TEXT_329 = NL + "  private function ";
  public static final String TEXT_330 = "($";
  public static final String TEXT_331 = ")" + NL + "  {";
  public static final String TEXT_332 = NL + "    $this->";
  public static final String TEXT_333 = " = $";
  public static final String TEXT_334 = ";";
  public static final String TEXT_335 = NL + "    if ($this->";
  public static final String TEXT_336 = " != self::$";
  public static final String TEXT_337 = " && $";
  public static final String TEXT_338 = " != self::$";
  public static final String TEXT_339 = ") { $this->";
  public static final String TEXT_340 = "(self::$";
  public static final String TEXT_341 = "); }";
  public static final String TEXT_342 = "";
  public static final String TEXT_343 = "";
  public static final String TEXT_344 = NL + NL + "    // entry actions and do activities" + NL + "    ";
  public static final String TEXT_345 = "";
  public static final String TEXT_346 = NL + "  }" + NL;
  public static final String TEXT_347 = NL + "  public function ";
  public static final String TEXT_348 = "()" + NL + "  {";
  public static final String TEXT_349 = "";
  public static final String TEXT_350 = NL + "    return $this->";
  public static final String TEXT_351 = ";";
  public static final String TEXT_352 = NL + "    $";
  public static final String TEXT_353 = " = $this->";
  public static final String TEXT_354 = ";";
  public static final String TEXT_355 = NL + "    return $";
  public static final String TEXT_356 = ";";
  public static final String TEXT_357 = NL + "  }";
  public static final String TEXT_358 = NL + NL + "  public function ";
  public static final String TEXT_359 = "()" + NL + "  {" + NL + "    $has = $this->";
  public static final String TEXT_360 = " != null;" + NL + "    return $has;" + NL + "  }";
  public static final String TEXT_361 = NL;
  public static final String TEXT_362 = NL + "  public function ";
  public static final String TEXT_363 = "_index($index)" + NL + "  {";
  public static final String TEXT_364 = NL + "    $";
  public static final String TEXT_365 = " = $this->";
  public static final String TEXT_366 = "[$index];";
  public static final String TEXT_367 = NL + "    return $";
  public static final String TEXT_368 = ";" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_369 = "()" + NL + "  {";
  public static final String TEXT_370 = NL + "    $";
  public static final String TEXT_371 = " = $this->";
  public static final String TEXT_372 = ";";
  public static final String TEXT_373 = NL + "    return $";
  public static final String TEXT_374 = ";" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_375 = "()" + NL + "  {";
  public static final String TEXT_376 = NL + "    $number = count($this->";
  public static final String TEXT_377 = ");";
  public static final String TEXT_378 = NL + "    return $number;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_379 = "()" + NL + "  {";
  public static final String TEXT_380 = NL + "    $has = $this->";
  public static final String TEXT_381 = "() > 0;";
  public static final String TEXT_382 = NL + "    return $has;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_383 = "($";
  public static final String TEXT_384 = ")" + NL + "  {";
  public static final String TEXT_385 = NL + "    $wasFound = false;" + NL + "    $index = 0;" + NL + "    foreach($this->";
  public static final String TEXT_386 = " as $";
  public static final String TEXT_387 = ")" + NL + "    {" + NL + "      if ($";
  public static final String TEXT_388 = "->equals($";
  public static final String TEXT_389 = "))" + NL + "      {" + NL + "        $wasFound = true;" + NL + "        break;" + NL + "      }" + NL + "      $index += 1;" + NL + "    }" + NL + "    $index = $wasFound ? $index : -1;";
  public static final String TEXT_390 = NL + "    return $index;" + NL + "  }" + NL;
  public static final String TEXT_391 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  public static final String TEXT_392 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  public static final String TEXT_393 = " : ";
  public static final String TEXT_394 = NL + "  public function ";
  public static final String TEXT_395 = "()" + NL + "  {";
  public static final String TEXT_396 = "";
  public static final String TEXT_397 = NL + "    $isValid = $this->";
  public static final String TEXT_398 = "() >= self::";
  public static final String TEXT_399 = "();";
  public static final String TEXT_400 = NL + "    $isValid = $this->";
  public static final String TEXT_401 = "() >= self::";
  public static final String TEXT_402 = "() && $this->";
  public static final String TEXT_403 = "() <= self::";
  public static final String TEXT_404 = "();";
  public static final String TEXT_405 = "";
  public static final String TEXT_406 = NL + "    return $isValid;" + NL + "  }";
  public static final String TEXT_407 = "";
  public static final String TEXT_408 = NL + "  public static function ";
  public static final String TEXT_409 = "()" + NL + "  {" + NL + "    return ";
  public static final String TEXT_410 = ";" + NL + "  }";
  public static final String TEXT_411 = NL + "  public static function ";
  public static final String TEXT_412 = "()" + NL + "  {";
  public static final String TEXT_413 = NL + "    $minimum = ";
  public static final String TEXT_414 = ";";
  public static final String TEXT_415 = NL + "    return $minimum;" + NL + "  }";
  public static final String TEXT_416 = "";
  public static final String TEXT_417 = NL + "  public static function ";
  public static final String TEXT_418 = "()" + NL + "  {" + NL + "    return ";
  public static final String TEXT_419 = ";" + NL + "  }";
  public static final String TEXT_420 = NL + "  public static function ";
  public static final String TEXT_421 = "()" + NL + "  {";
  public static final String TEXT_422 = NL + "    $minimum = ";
  public static final String TEXT_423 = ";";
  public static final String TEXT_424 = NL + "    return $minimum;" + NL + "  }";
  public static final String TEXT_425 = "";
  public static final String TEXT_426 = NL + "  public static function ";
  public static final String TEXT_427 = "()" + NL + "  {" + NL + "    return ";
  public static final String TEXT_428 = ";" + NL + "  }";
  public static final String TEXT_429 = NL + "  public static function ";
  public static final String TEXT_430 = "()" + NL + "  {";
  public static final String TEXT_431 = NL + "    $maximum = ";
  public static final String TEXT_432 = ";";
  public static final String TEXT_433 = NL + "    return $maximum;" + NL + "  }";
  public static final String TEXT_434 = NL + "  public function ";
  public static final String TEXT_435 = "($";
  public static final String TEXT_436 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_437 = "";
  public static final String TEXT_438 = NL + "    if ($this->";
  public static final String TEXT_439 = "() >= self::";
  public static final String TEXT_440 = "())" + NL + "    {";
  public static final String TEXT_441 = NL + "      return $wasAdded;" + NL + "    }" + NL;
  public static final String TEXT_442 = NL + "    $this->";
  public static final String TEXT_443 = "[] = $";
  public static final String TEXT_444 = ";" + NL + "    if ($";
  public static final String TEXT_445 = "->";
  public static final String TEXT_446 = "($this) != -1)" + NL + "    {" + NL + "      $wasAdded = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasAdded = $";
  public static final String TEXT_447 = "->";
  public static final String TEXT_448 = "($this);" + NL + "      if (!$wasAdded)" + NL + "      {" + NL + "        array_pop($this->";
  public static final String TEXT_449 = ");" + NL + "      }" + NL + "    }";
  public static final String TEXT_450 = NL + "    return $wasAdded;" + NL + "  }";
  public static final String TEXT_451 = NL + "  public function ";
  public static final String TEXT_452 = "($";
  public static final String TEXT_453 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_454 = NL + "    if ($this->";
  public static final String TEXT_455 = "($";
  public static final String TEXT_456 = ") == -1)" + NL + "    {";
  public static final String TEXT_457 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    $oldIndex = $this->";
  public static final String TEXT_458 = "($";
  public static final String TEXT_459 = ");" + NL + "    unset($this->";
  public static final String TEXT_460 = "[$oldIndex]);" + NL + "    if ($";
  public static final String TEXT_461 = "->";
  public static final String TEXT_462 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  public static final String TEXT_463 = "->";
  public static final String TEXT_464 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_465 = "[$oldIndex] = $";
  public static final String TEXT_466 = ";" + NL + "        ksort($this->";
  public static final String TEXT_467 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  public static final String TEXT_468 = " = array_values($this->";
  public static final String TEXT_469 = ");";
  public static final String TEXT_470 = NL + "    return $wasRemoved;" + NL + "  }";
  public static final String TEXT_471 = NL + "  ";
  public static final String TEXT_472 = " function ";
  public static final String TEXT_473 = "($";
  public static final String TEXT_474 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_475 = NL + "    $this->";
  public static final String TEXT_476 = " = $";
  public static final String TEXT_477 = ";" + NL + "    $wasSet = true;";
  public static final String TEXT_478 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_479 = NL + "  ";
  public static final String TEXT_480 = " function ";
  public static final String TEXT_481 = "($";
  public static final String TEXT_482 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_483 = NL + "    if ($";
  public static final String TEXT_484 = " != null)" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_485 = " = $";
  public static final String TEXT_486 = ";" + NL + "      $wasSet = true;" + NL + "    }";
  public static final String TEXT_487 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_488 = NL + "  public function ";
  public static final String TEXT_489 = "($";
  public static final String TEXT_490 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_491 = NL + "    if ($this->";
  public static final String TEXT_492 = " != null && $this->";
  public static final String TEXT_493 = " != $";
  public static final String TEXT_494 = " && $this == $this->";
  public static final String TEXT_495 = "->";
  public static final String TEXT_496 = "())" + NL + "    {" + NL + "      //Unable to ";
  public static final String TEXT_497 = ", as existing ";
  public static final String TEXT_498 = " would become an orphan";
  public static final String TEXT_499 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $this->";
  public static final String TEXT_500 = " = $";
  public static final String TEXT_501 = ";" + NL + "    $";
  public static final String TEXT_502 = " = $";
  public static final String TEXT_503 = " != null ? $";
  public static final String TEXT_504 = "->";
  public static final String TEXT_505 = "() : null;" + NL + "    " + NL + "    if ($this != $";
  public static final String TEXT_506 = ")" + NL + "    {" + NL + "      if ($";
  public static final String TEXT_507 = " != null)" + NL + "      {" + NL + "        $";
  public static final String TEXT_508 = "->";
  public static final String TEXT_509 = " = null;" + NL + "      }" + NL + "      if ($this->";
  public static final String TEXT_510 = " != null)" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_511 = "->";
  public static final String TEXT_512 = "($this);" + NL + "      }" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_513 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_514 = NL + "  public function ";
  public static final String TEXT_515 = "($";
  public static final String TEXT_516 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_517 = NL + "    if ($";
  public static final String TEXT_518 = " == null)" + NL + "    {" + NL + "      //Unable to ";
  public static final String TEXT_519 = " to null, as ";
  public static final String TEXT_520 = " must always be associated to a ";
  public static final String TEXT_521 = "";
  public static final String TEXT_522 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  public static final String TEXT_523 = " = $";
  public static final String TEXT_524 = "->";
  public static final String TEXT_525 = "();" + NL + "    if ($";
  public static final String TEXT_526 = " != null && $this != $";
  public static final String TEXT_527 = ")" + NL + "    {" + NL + "      //Unable to ";
  public static final String TEXT_528 = ", the current ";
  public static final String TEXT_529 = " already has a ";
  public static final String TEXT_530 = ", which would be orphaned if it were re-assigned";
  public static final String TEXT_531 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  public static final String TEXT_532 = " = $this->";
  public static final String TEXT_533 = ";" + NL + "    $this->";
  public static final String TEXT_534 = " = $";
  public static final String TEXT_535 = ";" + NL + "    $this->";
  public static final String TEXT_536 = "->";
  public static final String TEXT_537 = "($this);" + NL + "    " + NL + "    if ($";
  public static final String TEXT_538 = " != null)" + NL + "    {" + NL + "      $";
  public static final String TEXT_539 = "->";
  public static final String TEXT_540 = "(null);" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_541 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_542 = NL + "  public function ";
  public static final String TEXT_543 = "(";
  public static final String TEXT_544 = ")" + NL + "  {" + NL + "    return new ";
  public static final String TEXT_545 = "(";
  public static final String TEXT_546 = ");" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_547 = "($";
  public static final String TEXT_548 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_549 = NL + "    $";
  public static final String TEXT_550 = " = $";
  public static final String TEXT_551 = "->";
  public static final String TEXT_552 = "();" + NL + "    $";
  public static final String TEXT_553 = " = $";
  public static final String TEXT_554 = " != null && $this !== $";
  public static final String TEXT_555 = ";" + NL + NL + "    if ($";
  public static final String TEXT_556 = " && $";
  public static final String TEXT_557 = "->";
  public static final String TEXT_558 = "() <= self::";
  public static final String TEXT_559 = "())" + NL + "    {" + NL + "      return $wasAdded;" + NL + "    }" + NL + NL + "    if ($";
  public static final String TEXT_560 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_561 = "->";
  public static final String TEXT_562 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_563 = "[] = $";
  public static final String TEXT_564 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  public static final String TEXT_565 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_566 = "($";
  public static final String TEXT_567 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_568 = NL + "    //Unable to remove ";
  public static final String TEXT_569 = ", as it must always have a ";
  public static final String TEXT_570 = NL + "    if ($this === $";
  public static final String TEXT_571 = "->";
  public static final String TEXT_572 = "())" + NL + "    {";
  public static final String TEXT_573 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    //";
  public static final String TEXT_574 = " already at minimum (";
  public static final String TEXT_575 = ")" + NL + "    if ($this->";
  public static final String TEXT_576 = "() <= self::";
  public static final String TEXT_577 = "())" + NL + "    {";
  public static final String TEXT_578 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    unset($this->";
  public static final String TEXT_579 = "[$this->";
  public static final String TEXT_580 = "($";
  public static final String TEXT_581 = ")]);" + NL + "    $this->";
  public static final String TEXT_582 = " = array_values($this->";
  public static final String TEXT_583 = ");" + NL + "    $wasRemoved = true;";
  public static final String TEXT_584 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_585 = NL + "  public function ";
  public static final String TEXT_586 = "(";
  public static final String TEXT_587 = ")" + NL + "  {" + NL + "    if ($this->";
  public static final String TEXT_588 = "() >= self::";
  public static final String TEXT_589 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  public static final String TEXT_590 = "(";
  public static final String TEXT_591 = ");" + NL + "    }" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_592 = "($";
  public static final String TEXT_593 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_594 = NL + "    if ($this->";
  public static final String TEXT_595 = "() >= self::";
  public static final String TEXT_596 = "())" + NL + "    {";
  public static final String TEXT_597 = NL + "      return $wasAdded;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_598 = " = $";
  public static final String TEXT_599 = "->";
  public static final String TEXT_600 = "();" + NL + "    $";
  public static final String TEXT_601 = " = $";
  public static final String TEXT_602 = " != null && $this !== $";
  public static final String TEXT_603 = ";" + NL + NL + "    if ($";
  public static final String TEXT_604 = " && $";
  public static final String TEXT_605 = "->";
  public static final String TEXT_606 = "() <= self::";
  public static final String TEXT_607 = "())" + NL + "    {";
  public static final String TEXT_608 = NL + "      return $wasAdded;" + NL + "    }" + NL + NL + "    if ($";
  public static final String TEXT_609 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_610 = "->";
  public static final String TEXT_611 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_612 = "[] = $";
  public static final String TEXT_613 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  public static final String TEXT_614 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_615 = "($";
  public static final String TEXT_616 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_617 = NL + "    //Unable to remove ";
  public static final String TEXT_618 = ", as it must always have a ";
  public static final String TEXT_619 = NL + "    if ($this === $";
  public static final String TEXT_620 = "->";
  public static final String TEXT_621 = "())" + NL + "    {";
  public static final String TEXT_622 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    //";
  public static final String TEXT_623 = " already at minimum (";
  public static final String TEXT_624 = ")" + NL + "    if ($this->";
  public static final String TEXT_625 = "() <= self::";
  public static final String TEXT_626 = "())" + NL + "    {";
  public static final String TEXT_627 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    unset($this->";
  public static final String TEXT_628 = "[$this->";
  public static final String TEXT_629 = "($";
  public static final String TEXT_630 = ")]);" + NL + "    $this->";
  public static final String TEXT_631 = " = array_values($this->";
  public static final String TEXT_632 = ");" + NL + "    $wasRemoved = true;";
  public static final String TEXT_633 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_634 = NL + "  public function ";
  public static final String TEXT_635 = "(";
  public static final String TEXT_636 = ")" + NL + "  {" + NL + "    if ($this->";
  public static final String TEXT_637 = "() >= self::";
  public static final String TEXT_638 = "())" + NL + "    {" + NL + "      return null;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      return new ";
  public static final String TEXT_639 = "(";
  public static final String TEXT_640 = ");" + NL + "    }" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_641 = "($";
  public static final String TEXT_642 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_643 = NL + "    if ($this->";
  public static final String TEXT_644 = "() >= self::";
  public static final String TEXT_645 = "())" + NL + "    {";
  public static final String TEXT_646 = NL + "      return $wasAdded;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_647 = " = $";
  public static final String TEXT_648 = "->";
  public static final String TEXT_649 = "();" + NL + "    $";
  public static final String TEXT_650 = " = $";
  public static final String TEXT_651 = " != null && $this !== $";
  public static final String TEXT_652 = ";" + NL + "    if ($";
  public static final String TEXT_653 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_654 = "->";
  public static final String TEXT_655 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_656 = "[] = $";
  public static final String TEXT_657 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  public static final String TEXT_658 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_659 = "($";
  public static final String TEXT_660 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_661 = NL + "    //Unable to remove ";
  public static final String TEXT_662 = ", as it must always have a ";
  public static final String TEXT_663 = NL + "    if ($this !== $";
  public static final String TEXT_664 = "->";
  public static final String TEXT_665 = "())" + NL + "    {" + NL + "      unset($this->";
  public static final String TEXT_666 = "[$this->";
  public static final String TEXT_667 = "($";
  public static final String TEXT_668 = ")]);" + NL + "      $this->";
  public static final String TEXT_669 = " = array_values($this->";
  public static final String TEXT_670 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  public static final String TEXT_671 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_672 = NL + "  public function ";
  public static final String TEXT_673 = "($";
  public static final String TEXT_674 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_675 = NL + "    $";
  public static final String TEXT_676 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_677 = " as $";
  public static final String TEXT_678 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_679 = ",$";
  public static final String TEXT_680 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  public static final String TEXT_681 = "[] = $";
  public static final String TEXT_682 = ";" + NL + "    }" + NL + NL + "    if (count($";
  public static final String TEXT_683 = ") != count($";
  public static final String TEXT_684 = ") || count($";
  public static final String TEXT_685 = ") > self::";
  public static final String TEXT_686 = "())" + NL + "    {";
  public static final String TEXT_687 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_688 = " = $this->";
  public static final String TEXT_689 = ";" + NL + "    $this->";
  public static final String TEXT_690 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_691 = " as $";
  public static final String TEXT_692 = ")" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_693 = "[] = $";
  public static final String TEXT_694 = ";" + NL + "      $removeIndex = array_search($";
  public static final String TEXT_695 = ",$";
  public static final String TEXT_696 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  public static final String TEXT_697 = "[$removeIndex]);" + NL + "        $";
  public static final String TEXT_698 = " = array_values($";
  public static final String TEXT_699 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  public static final String TEXT_700 = "->";
  public static final String TEXT_701 = "($this);" + NL + "      }" + NL + "    }" + NL + NL + "    foreach ($";
  public static final String TEXT_702 = " as $";
  public static final String TEXT_703 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_704 = "->";
  public static final String TEXT_705 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_706 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_707 = NL + "  public function ";
  public static final String TEXT_708 = "(";
  public static final String TEXT_709 = ")" + NL + "  {" + NL + "    return new ";
  public static final String TEXT_710 = "(";
  public static final String TEXT_711 = ");" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_712 = "($";
  public static final String TEXT_713 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_714 = NL + "    $";
  public static final String TEXT_715 = " = $";
  public static final String TEXT_716 = "->";
  public static final String TEXT_717 = "();" + NL + "    $";
  public static final String TEXT_718 = " = $";
  public static final String TEXT_719 = " != null && $this !== $";
  public static final String TEXT_720 = ";" + NL + "    if ($";
  public static final String TEXT_721 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_722 = "->";
  public static final String TEXT_723 = "($this);" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_724 = "[] = $";
  public static final String TEXT_725 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  public static final String TEXT_726 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_727 = "($";
  public static final String TEXT_728 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_729 = NL + "    //Unable to remove ";
  public static final String TEXT_730 = ", as it must always have a ";
  public static final String TEXT_731 = NL + "    if ($this !== $";
  public static final String TEXT_732 = "->";
  public static final String TEXT_733 = "())" + NL + "    {" + NL + "      unset($this->";
  public static final String TEXT_734 = "[$this->";
  public static final String TEXT_735 = "($";
  public static final String TEXT_736 = ")]);" + NL + "      $this->";
  public static final String TEXT_737 = " = array_values($this->";
  public static final String TEXT_738 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  public static final String TEXT_739 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_740 = NL + "  public function ";
  public static final String TEXT_741 = "($";
  public static final String TEXT_742 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_743 = NL + "    if ($";
  public static final String TEXT_744 = " == null)" + NL + "    {" + NL + "      $";
  public static final String TEXT_745 = " = $this->";
  public static final String TEXT_746 = ";" + NL + "      $this->";
  public static final String TEXT_747 = " = null;" + NL + "      " + NL + "      if ($";
  public static final String TEXT_748 = " != null && $";
  public static final String TEXT_749 = "->";
  public static final String TEXT_750 = "() != null)" + NL + "      {" + NL + "        $";
  public static final String TEXT_751 = "->";
  public static final String TEXT_752 = "(null);" + NL + "      }" + NL + "      $wasSet = true;";
  public static final String TEXT_753 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  public static final String TEXT_754 = " = $this->";
  public static final String TEXT_755 = "();" + NL + "    if ($";
  public static final String TEXT_756 = " != null && $";
  public static final String TEXT_757 = " != $";
  public static final String TEXT_758 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_759 = "->";
  public static final String TEXT_760 = "(null);" + NL + "    }" + NL + "    " + NL + "    $this->";
  public static final String TEXT_761 = " = $";
  public static final String TEXT_762 = ";" + NL + "    $";
  public static final String TEXT_763 = " = $";
  public static final String TEXT_764 = "->";
  public static final String TEXT_765 = "();" + NL + "    " + NL + "    if ($this != $";
  public static final String TEXT_766 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_767 = "->";
  public static final String TEXT_768 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_769 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_770 = NL + "  public function ";
  public static final String TEXT_771 = "($";
  public static final String TEXT_772 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_773 = NL + "    if ($this->";
  public static final String TEXT_774 = "($";
  public static final String TEXT_775 = ") == -1)" + NL + "    {";
  public static final String TEXT_776 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    if ($this->";
  public static final String TEXT_777 = "() <= self::";
  public static final String TEXT_778 = "())" + NL + "    {";
  public static final String TEXT_779 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    $oldIndex = $this->";
  public static final String TEXT_780 = "($";
  public static final String TEXT_781 = ");" + NL + "    unset($this->";
  public static final String TEXT_782 = "[$oldIndex]);" + NL + "    if ($";
  public static final String TEXT_783 = "->";
  public static final String TEXT_784 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  public static final String TEXT_785 = "->";
  public static final String TEXT_786 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_787 = "[$oldIndex] = $";
  public static final String TEXT_788 = ";" + NL + "        ksort($this->";
  public static final String TEXT_789 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  public static final String TEXT_790 = " = array_values($this->";
  public static final String TEXT_791 = ");";
  public static final String TEXT_792 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_793 = NL + "  public function ";
  public static final String TEXT_794 = "($";
  public static final String TEXT_795 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_796 = NL + "    if ($this->";
  public static final String TEXT_797 = "($";
  public static final String TEXT_798 = ") == -1)" + NL + "    {";
  public static final String TEXT_799 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    if ($this->";
  public static final String TEXT_800 = "() <= self::";
  public static final String TEXT_801 = "())" + NL + "    {";
  public static final String TEXT_802 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    $oldIndex = $this->";
  public static final String TEXT_803 = "($";
  public static final String TEXT_804 = ");" + NL + "    unset($this->";
  public static final String TEXT_805 = "[$oldIndex]);" + NL + "    if ($";
  public static final String TEXT_806 = "->";
  public static final String TEXT_807 = "($this) == -1)" + NL + "    {" + NL + "      $wasRemoved = true;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasRemoved = $";
  public static final String TEXT_808 = "->";
  public static final String TEXT_809 = "($this);" + NL + "      if (!$wasRemoved)" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_810 = "[$oldIndex] = $";
  public static final String TEXT_811 = ";" + NL + "        ksort($this->";
  public static final String TEXT_812 = ");" + NL + "      }" + NL + "    }" + NL + "    $this->";
  public static final String TEXT_813 = " = array_values($this->";
  public static final String TEXT_814 = ");";
  public static final String TEXT_815 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_816 = NL + "  public function ";
  public static final String TEXT_817 = "($";
  public static final String TEXT_818 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_819 = NL + "    if ($";
  public static final String TEXT_820 = " != null && $";
  public static final String TEXT_821 = "->";
  public static final String TEXT_822 = "() >= ";
  public static final String TEXT_823 = "::";
  public static final String TEXT_824 = "())" + NL + "    {";
  public static final String TEXT_825 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_826 = " = $this->";
  public static final String TEXT_827 = ";" + NL + "    $this->";
  public static final String TEXT_828 = " = $";
  public static final String TEXT_829 = ";" + NL + "    if ($";
  public static final String TEXT_830 = " != null && $";
  public static final String TEXT_831 = " != $";
  public static final String TEXT_832 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_833 = "->";
  public static final String TEXT_834 = "($this);" + NL + "    }" + NL + "    if ($";
  public static final String TEXT_835 = " != null)" + NL + "    {" + NL + "      $";
  public static final String TEXT_836 = "->";
  public static final String TEXT_837 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_838 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_839 = NL + "  public function ";
  public static final String TEXT_840 = "($";
  public static final String TEXT_841 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_842 = NL + "    if ($";
  public static final String TEXT_843 = " == null)" + NL + "    {";
  public static final String TEXT_844 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  public static final String TEXT_845 = " = $this->";
  public static final String TEXT_846 = ";" + NL + "    $this->";
  public static final String TEXT_847 = " = $";
  public static final String TEXT_848 = ";" + NL + "    if ($";
  public static final String TEXT_849 = " != null && $";
  public static final String TEXT_850 = " != $";
  public static final String TEXT_851 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_852 = "->";
  public static final String TEXT_853 = "($this);" + NL + "    }" + NL + "    $this->";
  public static final String TEXT_854 = "->";
  public static final String TEXT_855 = "($this);" + NL + "    $wasSet = true;";
  public static final String TEXT_856 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_857 = NL + "  public function ";
  public static final String TEXT_858 = "($";
  public static final String TEXT_859 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_860 = NL + "    if ($";
  public static final String TEXT_861 = ".nil?)" + NL + "    {";
  public static final String TEXT_862 = NL + "      return wasSet;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_863 = " = $this->";
  public static final String TEXT_864 = ";" + NL + "    $this->";
  public static final String TEXT_865 = " = $";
  public static final String TEXT_866 = ";" + NL + "    if (!$";
  public static final String TEXT_867 = "->is_null() && !$";
  public static final String TEXT_868 = "->equals($";
  public static final String TEXT_869 = "))" + NL + "    {" + NL + "      $";
  public static final String TEXT_870 = "->";
  public static final String TEXT_871 = "($this);" + NL + "    }" + NL + "    if !$this->";
  public static final String TEXT_872 = "->";
  public static final String TEXT_873 = "($this)" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_874 = " = $";
  public static final String TEXT_875 = ";" + NL + "      $wasSet = false;" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $wasSet = true;" + NL + "    }";
  public static final String TEXT_876 = NL + "    return $wasSet;" + NL + "  end" + NL;
  public static final String TEXT_877 = NL + "  public function ";
  public static final String TEXT_878 = "($";
  public static final String TEXT_879 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_880 = NL + "    //Must provide ";
  public static final String TEXT_881 = " to ";
  public static final String TEXT_882 = NL + "    if ($";
  public static final String TEXT_883 = " == null)" + NL + "    {";
  public static final String TEXT_884 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    //";
  public static final String TEXT_885 = " already at maximum (";
  public static final String TEXT_886 = ")" + NL + "    if ($";
  public static final String TEXT_887 = "->";
  public static final String TEXT_888 = "() >= ";
  public static final String TEXT_889 = "::";
  public static final String TEXT_890 = "())" + NL + "    {";
  public static final String TEXT_891 = NL + "      return $wasSet;" + NL + "    }" + NL + "    " + NL + "    $";
  public static final String TEXT_892 = " = $this->";
  public static final String TEXT_893 = ";" + NL + "    $this->";
  public static final String TEXT_894 = " = $";
  public static final String TEXT_895 = ";" + NL + "    if ($";
  public static final String TEXT_896 = " != null && $";
  public static final String TEXT_897 = " != $";
  public static final String TEXT_898 = ")" + NL + "    {" + NL + "      $didRemove = $";
  public static final String TEXT_899 = "->";
  public static final String TEXT_900 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_901 = " = $";
  public static final String TEXT_902 = ";";
  public static final String TEXT_903 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  public static final String TEXT_904 = "->";
  public static final String TEXT_905 = "($this);" + NL + "    $wasSet = true;";
  public static final String TEXT_906 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_907 = NL + "  public function ";
  public static final String TEXT_908 = "($";
  public static final String TEXT_909 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_910 = NL + "    //Must provide ";
  public static final String TEXT_911 = " to ";
  public static final String TEXT_912 = NL + "    if ($";
  public static final String TEXT_913 = " == null)" + NL + "    {";
  public static final String TEXT_914 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    if ($this->";
  public static final String TEXT_915 = " != null && $this->";
  public static final String TEXT_916 = "->";
  public static final String TEXT_917 = "() <= ";
  public static final String TEXT_918 = "::";
  public static final String TEXT_919 = "())" + NL + "    {";
  public static final String TEXT_920 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_921 = " = $this->";
  public static final String TEXT_922 = ";" + NL + "    $this->";
  public static final String TEXT_923 = " = $";
  public static final String TEXT_924 = ";" + NL + "    if ($";
  public static final String TEXT_925 = " != null && $";
  public static final String TEXT_926 = " != $";
  public static final String TEXT_927 = ")" + NL + "    {" + NL + "      $didRemove = $";
  public static final String TEXT_928 = "->";
  public static final String TEXT_929 = "($this);" + NL + "      if (!$didRemove)" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_930 = " = $";
  public static final String TEXT_931 = ";";
  public static final String TEXT_932 = NL + "        return $wasSet;" + NL + "      }" + NL + "    }" + NL + "    $this->";
  public static final String TEXT_933 = "->";
  public static final String TEXT_934 = "($this);" + NL + "    $wasSet = true;";
  public static final String TEXT_935 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_936 = NL + "  public function ";
  public static final String TEXT_937 = "($";
  public static final String TEXT_938 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_939 = NL + "    $";
  public static final String TEXT_940 = " = $";
  public static final String TEXT_941 = "->";
  public static final String TEXT_942 = "();" + NL + "    if ($";
  public static final String TEXT_943 = " == null)" + NL + "    {" + NL + "      $";
  public static final String TEXT_944 = "->";
  public static final String TEXT_945 = "($this);" + NL + "    }" + NL + "    elseif ($this !== $";
  public static final String TEXT_946 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_947 = "->";
  public static final String TEXT_948 = "($";
  public static final String TEXT_949 = ");" + NL + "      $this->";
  public static final String TEXT_950 = "($";
  public static final String TEXT_951 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_952 = "[] = $";
  public static final String TEXT_953 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  public static final String TEXT_954 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_955 = "($";
  public static final String TEXT_956 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_957 = NL + "    if ($this->";
  public static final String TEXT_958 = "($";
  public static final String TEXT_959 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  public static final String TEXT_960 = "[$this->";
  public static final String TEXT_961 = "($";
  public static final String TEXT_962 = ")]);" + NL + "      $this->";
  public static final String TEXT_963 = " = array_values($this->";
  public static final String TEXT_964 = ");" + NL + "      if ($this === $";
  public static final String TEXT_965 = "->";
  public static final String TEXT_966 = "())" + NL + "      {" + NL + "        $";
  public static final String TEXT_967 = "->";
  public static final String TEXT_968 = "(null);" + NL + "      }" + NL + "      $wasRemoved = true;" + NL + "    }";
  public static final String TEXT_969 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_970 = NL + "  public function ";
  public static final String TEXT_971 = "($";
  public static final String TEXT_972 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_973 = NL + "    $";
  public static final String TEXT_974 = " = $this->";
  public static final String TEXT_975 = ";" + NL + "    $this->";
  public static final String TEXT_976 = " = $";
  public static final String TEXT_977 = ";" + NL + "    if ($";
  public static final String TEXT_978 = " != null && $";
  public static final String TEXT_979 = " !== $";
  public static final String TEXT_980 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_981 = "->";
  public static final String TEXT_982 = "($this);" + NL + "    }" + NL + "    if ($";
  public static final String TEXT_983 = " != null && $";
  public static final String TEXT_984 = " !== $";
  public static final String TEXT_985 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_986 = "->";
  public static final String TEXT_987 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_988 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_989 = NL + "  public function ";
  public static final String TEXT_990 = "($";
  public static final String TEXT_991 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_992 = NL + "    if ($this->";
  public static final String TEXT_993 = "() >= self::";
  public static final String TEXT_994 = "())" + NL + "    {";
  public static final String TEXT_995 = NL + "      return $wasAdded;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_996 = " = $";
  public static final String TEXT_997 = "->";
  public static final String TEXT_998 = "();" + NL + "    if ($";
  public static final String TEXT_999 = " == null)" + NL + "    {" + NL + "      $";
  public static final String TEXT_1000 = "->";
  public static final String TEXT_1001 = "($this);" + NL + "    }" + NL + "    else if ($this !== $";
  public static final String TEXT_1002 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_1003 = "->";
  public static final String TEXT_1004 = "($";
  public static final String TEXT_1005 = ");" + NL + "      $this->";
  public static final String TEXT_1006 = "($";
  public static final String TEXT_1007 = ");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1008 = "[] = $";
  public static final String TEXT_1009 = ";" + NL + "    }" + NL + "    $wasAdded = true;";
  public static final String TEXT_1010 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_1011 = "($";
  public static final String TEXT_1012 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_1013 = NL + "    if ($this->";
  public static final String TEXT_1014 = "($";
  public static final String TEXT_1015 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  public static final String TEXT_1016 = "[$this->";
  public static final String TEXT_1017 = "($";
  public static final String TEXT_1018 = ")]);" + NL + "      $this->";
  public static final String TEXT_1019 = " = array_values($this->";
  public static final String TEXT_1020 = ");" + NL + "      $";
  public static final String TEXT_1021 = "->";
  public static final String TEXT_1022 = "(null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  public static final String TEXT_1023 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_1024 = NL + "  public function ";
  public static final String TEXT_1025 = "($";
  public static final String TEXT_1026 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_1027 = NL + "    if ($this->";
  public static final String TEXT_1028 = "() < self::";
  public static final String TEXT_1029 = "())" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1030 = "[] = $";
  public static final String TEXT_1031 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  public static final String TEXT_1032 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_1033 = "($";
  public static final String TEXT_1034 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_1035 = NL + "    if ($this->";
  public static final String TEXT_1036 = "($";
  public static final String TEXT_1037 = ") == -1)" + NL + "    {";
  public static final String TEXT_1038 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    if ($this->";
  public static final String TEXT_1039 = "() <= self::";
  public static final String TEXT_1040 = "())" + NL + "    {";
  public static final String TEXT_1041 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    unset($this->";
  public static final String TEXT_1042 = "[$this->";
  public static final String TEXT_1043 = "($";
  public static final String TEXT_1044 = ")]);" + NL + "    $this->";
  public static final String TEXT_1045 = " = array_values($this->";
  public static final String TEXT_1046 = ");" + NL + "    $wasRemoved = true;";
  public static final String TEXT_1047 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_1048 = NL + "  public function ";
  public static final String TEXT_1049 = "($";
  public static final String TEXT_1050 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_1051 = "";
  public static final String TEXT_1052 = NL + "    if ($this->";
  public static final String TEXT_1053 = "() >= self::";
  public static final String TEXT_1054 = "())" + NL + "    {";
  public static final String TEXT_1055 = NL + "      return $wasAdded;" + NL + "    }";
  public static final String TEXT_1056 = NL + "    $";
  public static final String TEXT_1057 = " = $";
  public static final String TEXT_1058 = "->";
  public static final String TEXT_1059 = "();" + NL + "    if ($";
  public static final String TEXT_1060 = " != null && $";
  public static final String TEXT_1061 = "->";
  public static final String TEXT_1062 = "() <= self::";
  public static final String TEXT_1063 = "())" + NL + "    {";
  public static final String TEXT_1064 = NL + "      return $wasAdded;" + NL + "    }" + NL + "    else if ($";
  public static final String TEXT_1065 = " != null)" + NL + "    {" + NL + "      unset($";
  public static final String TEXT_1066 = "->";
  public static final String TEXT_1067 = "[$";
  public static final String TEXT_1068 = "->";
  public static final String TEXT_1069 = "($";
  public static final String TEXT_1070 = ")]);" + NL + "      $";
  public static final String TEXT_1071 = "->";
  public static final String TEXT_1072 = " = array_values($";
  public static final String TEXT_1073 = "->";
  public static final String TEXT_1074 = ");" + NL + "    }" + NL + "    $this->";
  public static final String TEXT_1075 = "[] = $";
  public static final String TEXT_1076 = ";" + NL + "    $this->";
  public static final String TEXT_1077 = "($";
  public static final String TEXT_1078 = ",$this);" + NL + "    $wasAdded = true;";
  public static final String TEXT_1079 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_1080 = "($";
  public static final String TEXT_1081 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_1082 = NL + "    if ($this->";
  public static final String TEXT_1083 = "($";
  public static final String TEXT_1084 = ") != -1 && $this->";
  public static final String TEXT_1085 = "() > self::";
  public static final String TEXT_1086 = "())" + NL + "    {" + NL + "      unset($this->";
  public static final String TEXT_1087 = "[$this->";
  public static final String TEXT_1088 = "($";
  public static final String TEXT_1089 = ")]);" + NL + "      $this->";
  public static final String TEXT_1090 = " = array_values($this->";
  public static final String TEXT_1091 = ");" + NL + "      $this->";
  public static final String TEXT_1092 = "($";
  public static final String TEXT_1093 = ",null);" + NL + "      $wasRemoved = true;" + NL + "    }";
  public static final String TEXT_1094 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_1095 = NL + "  public function ";
  public static final String TEXT_1096 = "($";
  public static final String TEXT_1097 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_1098 = NL + "    $";
  public static final String TEXT_1099 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1100 = " as $";
  public static final String TEXT_1101 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_1102 = ",$";
  public static final String TEXT_1103 = ") !== false)" + NL + "      {";
  public static final String TEXT_1104 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  public static final String TEXT_1105 = "->";
  public static final String TEXT_1106 = "() != null && $this !== $";
  public static final String TEXT_1107 = "->";
  public static final String TEXT_1108 = "())" + NL + "      {";
  public static final String TEXT_1109 = NL + "        return $wasSet;" + NL + "      }" + NL + "      $";
  public static final String TEXT_1110 = "[] = $";
  public static final String TEXT_1111 = ";" + NL + "    }" + NL + NL + "    if (count($";
  public static final String TEXT_1112 = ") != self::";
  public static final String TEXT_1113 = "())" + NL + "    {";
  public static final String TEXT_1114 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    foreach ($this->";
  public static final String TEXT_1115 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  public static final String TEXT_1116 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_1117 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + NL + "    $this->";
  public static final String TEXT_1118 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1119 = " as $";
  public static final String TEXT_1120 = ")" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1121 = "($";
  public static final String TEXT_1122 = ", $this);" + NL + "      $this->";
  public static final String TEXT_1123 = "[] = $";
  public static final String TEXT_1124 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_1125 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1126 = NL + "  private function ";
  public static final String TEXT_1127 = "($";
  public static final String TEXT_1128 = ", $";
  public static final String TEXT_1129 = ")" + NL + "  {" + NL + "    $";
  public static final String TEXT_1130 = "->mentor = $";
  public static final String TEXT_1131 = ";" + NL + "    //$prop = new ReflectionProperty($";
  public static final String TEXT_1132 = ", '";
  public static final String TEXT_1133 = "');" + NL + "    //$prop->setAccessible(true);" + NL + "    //$prop->setValue($";
  public static final String TEXT_1134 = ",$";
  public static final String TEXT_1135 = ");" + NL + "    //$prop->setAccessible(false);" + NL + "  }" + NL;
  public static final String TEXT_1136 = NL + "  public function ";
  public static final String TEXT_1137 = "($";
  public static final String TEXT_1138 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_1139 = NL + "    $this->";
  public static final String TEXT_1140 = "[] = $";
  public static final String TEXT_1141 = ";" + NL + "    $wasAdded = true;";
  public static final String TEXT_1142 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_1143 = "($";
  public static final String TEXT_1144 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_1145 = NL + "    if ($this->";
  public static final String TEXT_1146 = "($";
  public static final String TEXT_1147 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  public static final String TEXT_1148 = "[$this->";
  public static final String TEXT_1149 = "($";
  public static final String TEXT_1150 = ")]);" + NL + "      $this->";
  public static final String TEXT_1151 = " = array_values($this->";
  public static final String TEXT_1152 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  public static final String TEXT_1153 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_1154 = NL + "  public function ";
  public static final String TEXT_1155 = "($";
  public static final String TEXT_1156 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_1157 = NL + "    if ($this->";
  public static final String TEXT_1158 = "() < self::";
  public static final String TEXT_1159 = "())" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1160 = "[] = $";
  public static final String TEXT_1161 = ";" + NL + "      $wasAdded = true;" + NL + "    }";
  public static final String TEXT_1162 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_1163 = "($";
  public static final String TEXT_1164 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_1165 = NL + "    if ($this->";
  public static final String TEXT_1166 = "($";
  public static final String TEXT_1167 = ") != -1)" + NL + "    {" + NL + "      unset($this->";
  public static final String TEXT_1168 = "[$this->";
  public static final String TEXT_1169 = "($";
  public static final String TEXT_1170 = ")]);" + NL + "      $this->";
  public static final String TEXT_1171 = " = array_values($this->";
  public static final String TEXT_1172 = ");" + NL + "      $wasRemoved = true;" + NL + "    }";
  public static final String TEXT_1173 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_1174 = NL + "  public function ";
  public static final String TEXT_1175 = "($";
  public static final String TEXT_1176 = ")" + NL + "  {" + NL + "    $wasAdded = false;";
  public static final String TEXT_1177 = NL + "    $this->";
  public static final String TEXT_1178 = "[] = $";
  public static final String TEXT_1179 = ";" + NL + "    $wasAdded = true;";
  public static final String TEXT_1180 = NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_1181 = "($";
  public static final String TEXT_1182 = ")" + NL + "  {" + NL + "    $wasRemoved = false;";
  public static final String TEXT_1183 = NL + "    if ($this->";
  public static final String TEXT_1184 = "($";
  public static final String TEXT_1185 = ") == -1)" + NL + "    {";
  public static final String TEXT_1186 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    if ($this->";
  public static final String TEXT_1187 = "() <= self::";
  public static final String TEXT_1188 = "())" + NL + "    {";
  public static final String TEXT_1189 = NL + "      return $wasRemoved;" + NL + "    }" + NL + NL + "    unset($this->";
  public static final String TEXT_1190 = "[$this->";
  public static final String TEXT_1191 = "($";
  public static final String TEXT_1192 = ")]);" + NL + "    $this->";
  public static final String TEXT_1193 = " = array_values($this->";
  public static final String TEXT_1194 = ");" + NL + "    $wasRemoved = true;";
  public static final String TEXT_1195 = NL + "    return $wasRemoved;" + NL + "  }" + NL;
  public static final String TEXT_1196 = NL + "  ";
  public static final String TEXT_1197 = " function ";
  public static final String TEXT_1198 = "($";
  public static final String TEXT_1199 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_1200 = NL + "    $";
  public static final String TEXT_1201 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1202 = " as $";
  public static final String TEXT_1203 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_1204 = ",$";
  public static final String TEXT_1205 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  public static final String TEXT_1206 = "[] = $";
  public static final String TEXT_1207 = ";" + NL + "    }" + NL + NL + "    if (count($";
  public static final String TEXT_1208 = ") != count($";
  public static final String TEXT_1209 = ") || count($";
  public static final String TEXT_1210 = ") != self::";
  public static final String TEXT_1211 = "())" + NL + "    {";
  public static final String TEXT_1212 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $this->";
  public static final String TEXT_1213 = " = $";
  public static final String TEXT_1214 = ";" + NL + "    $wasSet = true;";
  public static final String TEXT_1215 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1216 = NL + "  ";
  public static final String TEXT_1217 = " function ";
  public static final String TEXT_1218 = "($";
  public static final String TEXT_1219 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_1220 = NL + "    $";
  public static final String TEXT_1221 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1222 = " as $";
  public static final String TEXT_1223 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_1224 = ",$";
  public static final String TEXT_1225 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  public static final String TEXT_1226 = "[] = $";
  public static final String TEXT_1227 = ";" + NL + "    }" + NL + NL + "    if (count($";
  public static final String TEXT_1228 = ") != count($";
  public static final String TEXT_1229 = "))" + NL + "    {";
  public static final String TEXT_1230 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_1231 = "->";
  public static final String TEXT_1232 = " = $";
  public static final String TEXT_1233 = ";" + NL + "    $wasSet = true;";
  public static final String TEXT_1234 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1235 = NL + "  public function ";
  public static final String TEXT_1236 = "($";
  public static final String TEXT_1237 = ")" + NL + "  {" + NL + "    //" + NL + "    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    // it's not required (No upper bound)" + NL + "    //   " + NL + NL + "    $wasSet = false;" + NL + "    " + NL + "    $";
  public static final String TEXT_1238 = " = $this->";
  public static final String TEXT_1239 = ";" + NL + NL + "    if ($";
  public static final String TEXT_1240 = " == null)" + NL + "    {" + NL + "      if ($";
  public static final String TEXT_1241 = " != null)" + NL + "      {" + NL + "        if ($";
  public static final String TEXT_1242 = "->";
  public static final String TEXT_1243 = "($this))" + NL + "        {" + NL + "          $";
  public static final String TEXT_1244 = " = $";
  public static final String TEXT_1245 = ";" + NL + "          $wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    } " + NL + "    else if ($";
  public static final String TEXT_1246 = " != null)" + NL + "    {" + NL + "      if ($";
  public static final String TEXT_1247 = " == null)" + NL + "      {" + NL + "        if ($";
  public static final String TEXT_1248 = "->";
  public static final String TEXT_1249 = "() < $";
  public static final String TEXT_1250 = "->";
  public static final String TEXT_1251 = "())" + NL + "        {" + NL + "          $";
  public static final String TEXT_1252 = "->";
  public static final String TEXT_1253 = "($this);" + NL + "          $";
  public static final String TEXT_1254 = " = $";
  public static final String TEXT_1255 = ";  // ";
  public static final String TEXT_1256 = " == null" + NL + "          $wasSet = true;" + NL + "        }" + NL + "      } " + NL + "      else" + NL + "      {" + NL + "        if ($";
  public static final String TEXT_1257 = "->";
  public static final String TEXT_1258 = "() < $";
  public static final String TEXT_1259 = "->";
  public static final String TEXT_1260 = "())" + NL + "        {" + NL + "          $";
  public static final String TEXT_1261 = "->";
  public static final String TEXT_1262 = "($this);" + NL + "          $";
  public static final String TEXT_1263 = "->";
  public static final String TEXT_1264 = "($this);" + NL + "          $";
  public static final String TEXT_1265 = " = $";
  public static final String TEXT_1266 = ";" + NL + "          $wasSet = true;" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    if ($wasSet)" + NL + "    {" + NL + "      $";
  public static final String TEXT_1267 = " = $";
  public static final String TEXT_1268 = ";" + NL + "    }" + NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1269 = NL + "//  public function ";
  public static final String TEXT_1270 = "($";
  public static final String TEXT_1271 = ")" + NL + "//  {" + NL + "//    //" + NL + "//    // The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "//    // (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "//    //   method ";
  public static final String TEXT_1272 = NL + "//    // Currently this will not compile due to Issue351 - the template code is fine." + NL + "//    //" + NL + "//    $wasSet = false;" + NL + "//" + NL + "//    $";
  public static final String TEXT_1273 = " = $";
  public static final String TEXT_1274 = ";" + NL + "//    " + NL + "//    if ($";
  public static final String TEXT_1275 = " == null)" + NL + "//    {" + NL + "//      if ($";
  public static final String TEXT_1276 = " != null)" + NL + "//      {" + NL + "//        if ($";
  public static final String TEXT_1277 = "->";
  public static final String TEXT_1278 = "(this))" + NL + "//        {" + NL + "//          $";
  public static final String TEXT_1279 = " = $";
  public static final String TEXT_1280 = ";" + NL + "//          $wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    } " + NL + "//    else if ($";
  public static final String TEXT_1281 = " != null)" + NL + "//    { " + NL + "//      if ($";
  public static final String TEXT_1282 = " == null)" + NL + "//      {" + NL + "//        if ($";
  public static final String TEXT_1283 = "->";
  public static final String TEXT_1284 = "() < $";
  public static final String TEXT_1285 = "->";
  public static final String TEXT_1286 = "())" + NL + "//        {" + NL + "//          $";
  public static final String TEXT_1287 = "->";
  public static final String TEXT_1288 = "(this);" + NL + "//          $";
  public static final String TEXT_1289 = " = $";
  public static final String TEXT_1290 = ";  // $";
  public static final String TEXT_1291 = " == null" + NL + "//          $wasSet = true;" + NL + "//        }" + NL + "//      } " + NL + "//      else" + NL + "//      {" + NL + "//        if (   $";
  public static final String TEXT_1292 = "->";
  public static final String TEXT_1293 = "() < $";
  public static final String TEXT_1294 = "->";
  public static final String TEXT_1295 = "()" + NL + "//            && $";
  public static final String TEXT_1296 = "->";
  public static final String TEXT_1297 = "() > $";
  public static final String TEXT_1298 = "->";
  public static final String TEXT_1299 = "()" + NL + "//           )" + NL + "//        {" + NL + "//          $";
  public static final String TEXT_1300 = "->";
  public static final String TEXT_1301 = "(this);" + NL + "//          $";
  public static final String TEXT_1302 = "->";
  public static final String TEXT_1303 = "(this);" + NL + "//          $";
  public static final String TEXT_1304 = " = ";
  public static final String TEXT_1305 = ";" + NL + "//          $wasSet = true;" + NL + "//        }" + NL + "//      }" + NL + "//    }" + NL + "//    if ($wasSet)" + NL + "//    {" + NL + "//      $";
  public static final String TEXT_1306 = " = $";
  public static final String TEXT_1307 = ";" + NL + "//    }" + NL + "//    " + NL + "//    return $wasSet;" + NL + "//  }";
  public static final String TEXT_1308 = NL + "  public function ";
  public static final String TEXT_1309 = "($";
  public static final String TEXT_1310 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_1311 = NL + "    $";
  public static final String TEXT_1312 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1313 = " as $";
  public static final String TEXT_1314 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_1315 = ",$";
  public static final String TEXT_1316 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  public static final String TEXT_1317 = "[] = $";
  public static final String TEXT_1318 = ";" + NL + "    }" + NL + NL + "    if (count($";
  public static final String TEXT_1319 = ") != count($";
  public static final String TEXT_1320 = ") || count($";
  public static final String TEXT_1321 = ") < self::";
  public static final String TEXT_1322 = "() || count($";
  public static final String TEXT_1323 = ") > self::";
  public static final String TEXT_1324 = "())" + NL + "    {";
  public static final String TEXT_1325 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_1326 = " = $this->";
  public static final String TEXT_1327 = ";" + NL + "    $this->";
  public static final String TEXT_1328 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1329 = " as $";
  public static final String TEXT_1330 = ")" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1331 = "[] = $";
  public static final String TEXT_1332 = ";" + NL + "      $removeIndex = array_search($";
  public static final String TEXT_1333 = ",$";
  public static final String TEXT_1334 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  public static final String TEXT_1335 = "[$removeIndex]);" + NL + "        $";
  public static final String TEXT_1336 = " = array_values($";
  public static final String TEXT_1337 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  public static final String TEXT_1338 = "->";
  public static final String TEXT_1339 = "($this);" + NL + "      }" + NL + "    }" + NL + NL + "    foreach ($";
  public static final String TEXT_1340 = " as $";
  public static final String TEXT_1341 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_1342 = "->";
  public static final String TEXT_1343 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_1344 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1345 = NL + "  public function ";
  public static final String TEXT_1346 = "($";
  public static final String TEXT_1347 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_1348 = NL + "    $";
  public static final String TEXT_1349 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1350 = " as $";
  public static final String TEXT_1351 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_1352 = ",$";
  public static final String TEXT_1353 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  public static final String TEXT_1354 = "[] = $";
  public static final String TEXT_1355 = ";" + NL + "    }" + NL + NL + "    if (count($";
  public static final String TEXT_1356 = ") != count($";
  public static final String TEXT_1357 = ") || count($";
  public static final String TEXT_1358 = ") < self::";
  public static final String TEXT_1359 = "())" + NL + "    {";
  public static final String TEXT_1360 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_1361 = " = $this->";
  public static final String TEXT_1362 = ";" + NL + "    $this->";
  public static final String TEXT_1363 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1364 = " as $";
  public static final String TEXT_1365 = ")" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1366 = "[] = $";
  public static final String TEXT_1367 = ";" + NL + "      $removeIndex = array_search($";
  public static final String TEXT_1368 = ",$";
  public static final String TEXT_1369 = ");" + NL + "      if ($removeIndex !== false)" + NL + "      {" + NL + "        unset($";
  public static final String TEXT_1370 = "[$removeIndex]);" + NL + "        $";
  public static final String TEXT_1371 = " = array_values($";
  public static final String TEXT_1372 = ");" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  public static final String TEXT_1373 = "->";
  public static final String TEXT_1374 = "($this);" + NL + "      }" + NL + "    }" + NL + NL + "    foreach ($";
  public static final String TEXT_1375 = " as $";
  public static final String TEXT_1376 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_1377 = "->";
  public static final String TEXT_1378 = "($this);" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_1379 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1380 = NL + "  ";
  public static final String TEXT_1381 = " function ";
  public static final String TEXT_1382 = "($";
  public static final String TEXT_1383 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_1384 = NL + "    $";
  public static final String TEXT_1385 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1386 = " as $";
  public static final String TEXT_1387 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_1388 = ",$";
  public static final String TEXT_1389 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  public static final String TEXT_1390 = "[] = $";
  public static final String TEXT_1391 = ";" + NL + "    }" + NL + NL + "    if (count($";
  public static final String TEXT_1392 = ") != count($";
  public static final String TEXT_1393 = ") || count($";
  public static final String TEXT_1394 = ") < self::";
  public static final String TEXT_1395 = "()  || count($";
  public static final String TEXT_1396 = ") > self::";
  public static final String TEXT_1397 = "())" + NL + "    {";
  public static final String TEXT_1398 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $this->";
  public static final String TEXT_1399 = " = $";
  public static final String TEXT_1400 = ";" + NL + "    $wasSet = true;";
  public static final String TEXT_1401 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1402 = NL + "  public function ";
  public static final String TEXT_1403 = "($";
  public static final String TEXT_1404 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_1405 = NL + "    if (count($";
  public static final String TEXT_1406 = ") < self::";
  public static final String TEXT_1407 = "()";
  public static final String TEXT_1408 = ")" + NL + "    {";
  public static final String TEXT_1409 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $";
  public static final String TEXT_1410 = " = array();" + NL + "    $";
  public static final String TEXT_1411 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1412 = " as $";
  public static final String TEXT_1413 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_1414 = ",$";
  public static final String TEXT_1415 = ") !== false)" + NL + "      {";
  public static final String TEXT_1416 = NL + "        return $wasSet;" + NL + "      }" + NL + "      else if ($";
  public static final String TEXT_1417 = "->";
  public static final String TEXT_1418 = "() != null && $this !== $";
  public static final String TEXT_1419 = "->";
  public static final String TEXT_1420 = "())" + NL + "      {" + NL + "        $";
  public static final String TEXT_1421 = " = $";
  public static final String TEXT_1422 = "->";
  public static final String TEXT_1423 = "();" + NL + "        $";
  public static final String TEXT_1424 = " = serialize($";
  public static final String TEXT_1425 = ");" + NL + "        if (!array_key_exists($";
  public static final String TEXT_1426 = ", $";
  public static final String TEXT_1427 = "))" + NL + "        {" + NL + "          $";
  public static final String TEXT_1428 = "[$";
  public static final String TEXT_1429 = "] = $";
  public static final String TEXT_1430 = "->";
  public static final String TEXT_1431 = "();" + NL + "        }" + NL + "        $nextCount = $";
  public static final String TEXT_1432 = "[$";
  public static final String TEXT_1433 = "] - 1;" + NL + "        if ($nextCount < self::minimum";
  public static final String TEXT_1434 = "())" + NL + "        {";
  public static final String TEXT_1435 = NL + "          return $wasSet;" + NL + "        }" + NL + "        $";
  public static final String TEXT_1436 = "[$";
  public static final String TEXT_1437 = "] = $nextCount;" + NL + "      }" + NL + "      $";
  public static final String TEXT_1438 = "[] = $";
  public static final String TEXT_1439 = ";" + NL + "    }" + NL + NL + "    foreach ($this->";
  public static final String TEXT_1440 = " as $orphan) " + NL + "    {" + NL + "      $wasFound = false;" + NL + "      foreach ($";
  public static final String TEXT_1441 = " as $fosterCare)" + NL + "      {" + NL + "        if ($orphan == $fosterCare)" + NL + "        {" + NL + "          $wasFound = true;" + NL + "          break;" + NL + "        }" + NL + "      }" + NL + "      " + NL + "      if (!$wasFound)" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_1442 = "($orphan, null);" + NL + "      }" + NL + "    }" + NL + NL + "    $this->";
  public static final String TEXT_1443 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1444 = " as $";
  public static final String TEXT_1445 = ")" + NL + "    {" + NL + "      if ($";
  public static final String TEXT_1446 = "->";
  public static final String TEXT_1447 = "() != null)" + NL + "      {" + NL + "        unset($";
  public static final String TEXT_1448 = "->";
  public static final String TEXT_1449 = "()->";
  public static final String TEXT_1450 = "[$";
  public static final String TEXT_1451 = "->";
  public static final String TEXT_1452 = "()->";
  public static final String TEXT_1453 = "($";
  public static final String TEXT_1454 = ")]);" + NL + "        $";
  public static final String TEXT_1455 = "->";
  public static final String TEXT_1456 = "()->";
  public static final String TEXT_1457 = " = array_values($";
  public static final String TEXT_1458 = "->";
  public static final String TEXT_1459 = "()->";
  public static final String TEXT_1460 = ");" + NL + "      }" + NL + "      $this->";
  public static final String TEXT_1461 = "($";
  public static final String TEXT_1462 = ", $this);" + NL + "      $this->";
  public static final String TEXT_1463 = "[] = $";
  public static final String TEXT_1464 = ";" + NL + "    }" + NL + "    $wasSet = true;";
  public static final String TEXT_1465 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1466 = NL + "  ";
  public static final String TEXT_1467 = " function ";
  public static final String TEXT_1468 = "($";
  public static final String TEXT_1469 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_1470 = NL + "    $";
  public static final String TEXT_1471 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1472 = " as $";
  public static final String TEXT_1473 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_1474 = ",$";
  public static final String TEXT_1475 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  public static final String TEXT_1476 = "[] = $";
  public static final String TEXT_1477 = ";" + NL + "    }" + NL + NL + "    if (count($";
  public static final String TEXT_1478 = ") != count($";
  public static final String TEXT_1479 = ") || count($";
  public static final String TEXT_1480 = ") > self::";
  public static final String TEXT_1481 = "())" + NL + "    {";
  public static final String TEXT_1482 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $this->";
  public static final String TEXT_1483 = " = $";
  public static final String TEXT_1484 = ";" + NL + "    $wasSet = true;";
  public static final String TEXT_1485 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1486 = NL + "  ";
  public static final String TEXT_1487 = " function ";
  public static final String TEXT_1488 = "($";
  public static final String TEXT_1489 = ")" + NL + "  {" + NL + "    $wasSet = false;";
  public static final String TEXT_1490 = NL + "    $";
  public static final String TEXT_1491 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1492 = " as $";
  public static final String TEXT_1493 = ")" + NL + "    {" + NL + "      if (array_search($";
  public static final String TEXT_1494 = ",$";
  public static final String TEXT_1495 = ") !== false)" + NL + "      {" + NL + "        continue;" + NL + "      }" + NL + "      $";
  public static final String TEXT_1496 = "[] = $";
  public static final String TEXT_1497 = ";" + NL + "    }" + NL + NL + "    if (count($";
  public static final String TEXT_1498 = ") != count($";
  public static final String TEXT_1499 = ") || count($";
  public static final String TEXT_1500 = ") < self::";
  public static final String TEXT_1501 = "())" + NL + "    {";
  public static final String TEXT_1502 = NL + "      return $wasSet;" + NL + "    }" + NL + NL + "    $this->";
  public static final String TEXT_1503 = " = $";
  public static final String TEXT_1504 = ";" + NL + "    $wasSet = true;";
  public static final String TEXT_1505 = NL + "    return $wasSet;" + NL + "  }" + NL;
  public static final String TEXT_1506 = NL + "  public function ";
  public static final String TEXT_1507 = "($";
  public static final String TEXT_1508 = ", $index)" + NL + "  {  " + NL + "    $wasAdded = false;" + NL + "    if($this->";
  public static final String TEXT_1509 = "($";
  public static final String TEXT_1510 = "))" + NL + "    {" + NL + "      if($index < 0 ) { $index = 0; }" + NL + "      if($index > $this->";
  public static final String TEXT_1511 = "()) { $index = $this->";
  public static final String TEXT_1512 = "() - 1; }" + NL + "      array_splice($this->";
  public static final String TEXT_1513 = ", $this->";
  public static final String TEXT_1514 = "($";
  public static final String TEXT_1515 = "), 1);" + NL + "      array_splice($this->";
  public static final String TEXT_1516 = ", $index, 0, array($";
  public static final String TEXT_1517 = "));" + NL + "      $wasAdded = true;" + NL + "    }" + NL + "    return $wasAdded;" + NL + "  }" + NL + NL + "  public function ";
  public static final String TEXT_1518 = "($";
  public static final String TEXT_1519 = ", $index)" + NL + "  {" + NL + "    $wasAdded = false;" + NL + "    if($this->";
  public static final String TEXT_1520 = "($";
  public static final String TEXT_1521 = ") !== -1)" + NL + "    {" + NL + "      if($index < 0 ) { $index = 0; }" + NL + "      if($index > $this->";
  public static final String TEXT_1522 = "()) { $index = $this->";
  public static final String TEXT_1523 = "() - 1; }" + NL + "      array_splice($this->";
  public static final String TEXT_1524 = ", $this->";
  public static final String TEXT_1525 = "($";
  public static final String TEXT_1526 = "), 1);" + NL + "      array_splice($this->";
  public static final String TEXT_1527 = ", $index, 0, array($";
  public static final String TEXT_1528 = "));" + NL + "      $wasAdded = true;" + NL + "    } " + NL + "    else " + NL + "    {" + NL + "      $wasAdded = $this->";
  public static final String TEXT_1529 = "($";
  public static final String TEXT_1530 = ", $index);" + NL + "    }" + NL + "    return $wasAdded;" + NL + "  }" + NL;
  public static final String TEXT_1531 = "";
  public static final String TEXT_1532 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    if ($compareTo == null) { return false; }" + NL + "    if (get_class($this) != get_class($compareTo)) { return false; }" + NL + NL + "    ";
  public static final String TEXT_1533 = NL + NL + "    return true;" + NL + "  }" + NL + NL + "  public function hashCode()" + NL + "  {" + NL + "    if ($this->cachedHashCode != -1)" + NL + "    {" + NL + "      return $this->cachedHashCode;" + NL + "    }" + NL + "    $this->cachedHashCode = 17;" + NL + "    ";
  public static final String TEXT_1534 = NL + NL + "    ";
  public static final String TEXT_1535 = NL + "    return $this->cachedHashCode;" + NL + "  }" + NL;
  public static final String TEXT_1536 = "";
  public static final String TEXT_1537 = NL + "  public function equals($compareTo)" + NL + "  {" + NL + "    return $this == $compareTo;" + NL + "  }" + NL;
  public static final String TEXT_1538 = "";
  public static final String TEXT_1539 = NL + "    $this->";
  public static final String TEXT_1540 = " = null;";
  public static final String TEXT_1541 = NL + "    $this->";
  public static final String TEXT_1542 = " = array();";
  public static final String TEXT_1543 = NL + "    $";
  public static final String TEXT_1544 = " = $this->";
  public static final String TEXT_1545 = ";" + NL + "    $this->";
  public static final String TEXT_1546 = " = null;" + NL + "    if ($";
  public static final String TEXT_1547 = " != null)" + NL + "    {" + NL + "      $";
  public static final String TEXT_1548 = "->delete();" + NL + "    }";
  public static final String TEXT_1549 = NL + "    " + NL + "    if ($this->";
  public static final String TEXT_1550 = " != null)" + NL + "    {" + NL + "        $this->";
  public static final String TEXT_1551 = "->delete();" + NL + "        $this->";
  public static final String TEXT_1552 = " = null;" + NL + "    }" + NL + "    ";
  public static final String TEXT_1553 = NL + "    while (count($this->";
  public static final String TEXT_1554 = ") > 0)" + NL + "    {" + NL + "      $";
  public static final String TEXT_1555 = " = $this->";
  public static final String TEXT_1556 = "[count($this->";
  public static final String TEXT_1557 = ") - 1];" + NL + "      $";
  public static final String TEXT_1558 = "->delete();" + NL + "      unset($this->";
  public static final String TEXT_1559 = "[$this->";
  public static final String TEXT_1560 = "($";
  public static final String TEXT_1561 = ")]);" + NL + "      $this->";
  public static final String TEXT_1562 = " = array_values($this->";
  public static final String TEXT_1563 = ");" + NL + "    }" + NL + "    ";
  public static final String TEXT_1564 = NL + "    while( count($this->";
  public static final String TEXT_1565 = ") > 0 )" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1566 = "[0]->";
  public static final String TEXT_1567 = "(null);" + NL + "      unset($this->";
  public static final String TEXT_1568 = "[0]);" + NL + "      $this->";
  public static final String TEXT_1569 = " = array_values($this->";
  public static final String TEXT_1570 = ");" + NL + "    }" + NL + "    unset($this->";
  public static final String TEXT_1571 = ");" + NL + "    $this->";
  public static final String TEXT_1572 = " = array();";
  public static final String TEXT_1573 = NL + "    if ($this->";
  public static final String TEXT_1574 = " != null)" + NL + "    {" + NL + "      if ($this->";
  public static final String TEXT_1575 = "->";
  public static final String TEXT_1576 = "() <= ";
  public static final String TEXT_1577 = ")" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_1578 = "->delete();" + NL + "    $this->";
  public static final String TEXT_1579 = " = null;" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_1580 = " = null;" + NL + "    $this->";
  public static final String TEXT_1581 = "->";
  public static final String TEXT_1582 = "($this);" + NL + "      }" + NL + "    }";
  public static final String TEXT_1583 = NL + "    if ($this->";
  public static final String TEXT_1584 = " != null)" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1585 = "->";
  public static final String TEXT_1586 = "(null);" + NL + "    }";
  public static final String TEXT_1587 = NL + "    $";
  public static final String TEXT_1588 = " = $this->";
  public static final String TEXT_1589 = ";" + NL + "    $this->";
  public static final String TEXT_1590 = " = null;" + NL + "    if ($";
  public static final String TEXT_1591 = " != null)" + NL + "    {" + NL + "      $";
  public static final String TEXT_1592 = "->";
  public static final String TEXT_1593 = "(null);" + NL + "    }";
  public static final String TEXT_1594 = NL + "    $";
  public static final String TEXT_1595 = " = $this->";
  public static final String TEXT_1596 = ";" + NL + "    $this->";
  public static final String TEXT_1597 = " = null;" + NL + "    if ($";
  public static final String TEXT_1598 = " != null)" + NL + "    {" + NL + "      $";
  public static final String TEXT_1599 = "->delete();" + NL + "    }";
  public static final String TEXT_1600 = NL + "    if ($this->";
  public static final String TEXT_1601 = " != null)" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1602 = "->";
  public static final String TEXT_1603 = "($this);" + NL + "    }";
  public static final String TEXT_1604 = NL + "    if ($this->";
  public static final String TEXT_1605 = " != null)" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1606 = "->delete();" + NL + "    }";
  public static final String TEXT_1607 = NL + "    if ($this->";
  public static final String TEXT_1608 = " != null)" + NL + "    {" + NL + "      if ($this->";
  public static final String TEXT_1609 = "->";
  public static final String TEXT_1610 = "() <= ";
  public static final String TEXT_1611 = ")" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_1612 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $this->";
  public static final String TEXT_1613 = "->";
  public static final String TEXT_1614 = "($this);" + NL + "      }" + NL + "    }";
  public static final String TEXT_1615 = NL + "    $";
  public static final String TEXT_1616 = " = $this->";
  public static final String TEXT_1617 = ";" + NL + "    $this->";
  public static final String TEXT_1618 = " = null;" + NL + "    $";
  public static final String TEXT_1619 = "->";
  public static final String TEXT_1620 = "($this);";
  public static final String TEXT_1621 = NL + "    foreach ($this->";
  public static final String TEXT_1622 = " as $";
  public static final String TEXT_1623 = ")" + NL + "    {" + NL + "      $this->";
  public static final String TEXT_1624 = "($";
  public static final String TEXT_1625 = ",null);" + NL + "    }" + NL + "    $this->";
  public static final String TEXT_1626 = " = array();";
  public static final String TEXT_1627 = NL + "    $";
  public static final String TEXT_1628 = " = $this->";
  public static final String TEXT_1629 = ";" + NL + "    $this->";
  public static final String TEXT_1630 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1631 = " as $";
  public static final String TEXT_1632 = ")" + NL + "    {" + NL + "      if ($";
  public static final String TEXT_1633 = "->";
  public static final String TEXT_1634 = "() <= ";
  public static final String TEXT_1635 = "::";
  public static final String TEXT_1636 = "())" + NL + "      {" + NL + "        $";
  public static final String TEXT_1637 = "->delete();" + NL + "      }" + NL + "      else" + NL + "      {" + NL + "        $";
  public static final String TEXT_1638 = "->";
  public static final String TEXT_1639 = "($this);" + NL + "      }" + NL + "    }";
  public static final String TEXT_1640 = NL + "    $";
  public static final String TEXT_1641 = " = $this->";
  public static final String TEXT_1642 = ";" + NL + "    $this->";
  public static final String TEXT_1643 = " = array();" + NL + "    foreach ($";
  public static final String TEXT_1644 = " as $";
  public static final String TEXT_1645 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_1646 = "->";
  public static final String TEXT_1647 = "($this);" + NL + "    }";
  public static final String TEXT_1648 = NL + "    foreach ($this->";
  public static final String TEXT_1649 = " as $";
  public static final String TEXT_1650 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_1651 = "->delete();" + NL + "    }";
  public static final String TEXT_1652 = NL + "    foreach ($this->";
  public static final String TEXT_1653 = " as $";
  public static final String TEXT_1654 = ")" + NL + "    {" + NL + "      $";
  public static final String TEXT_1655 = "->";
  public static final String TEXT_1656 = "(null);" + NL + "    }";
  public static final String TEXT_1657 = "";
  public static final String TEXT_1658 = "";
  public static final String TEXT_1659 = "";
  public static final String TEXT_1660 = NL + "  //------------------------" + NL + "  // DEVELOPER CODE - PROVIDED AS-IS" + NL + "  //------------------------" + NL + "  " + NL + "  ";
  public static final String TEXT_1661 = "";
  public static final String TEXT_1662 = NL + "}" + NL + "?>";

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhpClassGenerator()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  /**
   * Add a newline to the end of the input
   */
  // line 38 "../../../../../UmpleTLTemplates/phpClassGenerator.ump"
   private void appendln(StringBuilder buffer, String input, Object... variables){
    append(buffer, input + "\n", variables);
  }


  /**
   * This method will be used to append formatted strings
   * i.e. format("Hello {0} {1}", "andrew","forward");
   */
  // line 45 "../../../../../UmpleTLTemplates/phpClassGenerator.ump"
   private void append(StringBuilder buffer, String input, Object... variables){
    buffer.append(StringFormatter.format(input,variables));
  }

  private String _createSpacesString(int numSpaces){
    
  StringBuilder spaces =  new StringBuilder();
      for(int i=0; i <numSpaces; i++) {
          spaces.append(" ");
      }
      return spaces.toString();
  }

  public StringBuilder _getCode(Integer numSpaces, StringBuilder sb, UmpleModel model, UmpleElement uElement){
    String spaces="";
    StringBuilder newCode = new StringBuilder();
    StringBuilder realSb = sb;
    if(numSpaces > 0) {
        realSb = newCode;
        spaces = _createSpacesString(numSpaces);
        newCode.append(spaces);
    }
    
    /*phpClassGenerator*/
    
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


    realSb.append(TEXT_0);
    /*UmpleNotice*/
    realSb.append(TEXT_1);
    realSb.append(TEXT_2);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).getIsInline()) {append(realSb, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(realSb, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    realSb.append(TEXT_3);
    realSb.append(uClass.getName());
    realSb.append(gen.translate("isA",uClass));
    realSb.append(TEXT_4);
    /*members_AllStatics*/
    
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
      appendln(realSb, "");
      appendln(realSb, "");
      appendln(realSb, "  //------------------------");
      appendln(realSb, "  // STATIC VARIABLES");
      appendln(realSb, "  //------------------------");
      isFirst = false;
    }
  
    if (av.isConstant())
    {
      appendln(realSb, "");
      append(realSb, "  public static ${0} = {1};", av.getName(), gen.translate("parameterValue",av));
    }
    else if (av.getIsAutounique())
    {
      String defaultValue = av.getValue() == null ? "1" : av.getValue();
      appendln(realSb, "");
      append(realSb, "  private static $next{0} = {1};", av.getUpperCaseName(), defaultValue);
    }
    else if (av.getIsUnique())
    {
      appendln(realSb, "");
      append(realSb, "  private static ${0} = array();", gen.translate("uniqueMap", av));
    }
  }
  
  if (uClass.getIsSingleton())
  {
    if (isFirst)
    {
      appendln(realSb, "");
      appendln(realSb, "");
      appendln(realSb, "  //------------------------");
      appendln(realSb, "  // STATIC VARIABLES");
      appendln(realSb, "  //------------------------");
      isFirst = false;
    }
    appendln(realSb, "");
    append(realSb, "  private static $theInstance = null;");
  }
}

    /*members_AllAttributes*/
    
{

  appendln(realSb, "");
  appendln(realSb, "");
  appendln(realSb, "  //------------------------");
  appendln(realSb, "  // MEMBER VARIABLES");
  append(realSb, "  //------------------------");

  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
    if (av.isConstant() || av.getIsAutounique() || av.getIsDerived())
    {
      continue;
    }
    if (isFirst)
    {
      appendln(realSb, "");
      appendln(realSb, "");
      append(realSb,"  //{0} Attributes", uClass.getName());
      isFirst = false;
    }
    
    String attribute = gen.translate("attributeOne",av);
    if (av.getIsList())
    {
      attribute = gen.translate("attributeMany",av);
    }

    appendln(realSb, "");
    
    if (av.numberOfComments() > 0) { append(realSb, "\n  {0}\n", Comment.format("Attribute Javadoc", av.getComments())); }
    
    append(realSb, "  private ${0};", attribute);
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
      appendln(realSb, "");
      appendln(realSb, "");
      append(realSb,"  //Autounique Attributes");
      isFirst = false;
    }
    appendln(realSb, "");
    String lookup = av.getIsList() ? "attributeMany" : "attributeOne";
    append(realSb, "  private ${0};", gen.translate(lookup,av));
  }
}

    /*members_AllStateMachines*/
    
{
  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    List<StateMachine> allNested = sm.getNestedStateMachines();

    if (isFirst)
    {
      appendln(realSb, "");
      appendln(realSb, "");
      append(realSb,"  //{0} State Machines", uClass.getName());
      isFirst = false;
    }
    else
    {
      appendln(realSb,"");
    }
  
    int stateCounter = 0;
    for(State state : sm.getStates())
    {
      if (stateCounter >= 0)
      {
        appendln(realSb,"");
      }
      stateCounter += 1;
      append(realSb, "  private static ${0} = {1};", gen.translate("stateOne",state), stateCounter);
    }

    for (StateMachine nestedSm : allNested)
    {
      for(State state : nestedSm.getStates())
      {
        if (stateCounter >= 0)
        {
          appendln(realSb,"");
        }
        stateCounter += 1;
        append(realSb, "  private static ${0} = {1};", gen.translate("stateOne",state), stateCounter);
      }
    }
    
    append(realSb, "\n  private ${0};", gen.translate("stateMachineOne", sm));
    for (StateMachine nestedSm : allNested)
    {
      append(realSb, "\n  private ${0};", gen.translate("stateMachineOne", nestedSm));
    }

  }
}

    /*members_AllDoActivities*/
    
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
          appendln(realSb, "");
          appendln(realSb, "");
          append(realSb,"  //{0} Do Activity Threads", uClass.getName());
          isFirst = false;
        }
        append(realSb, "\n  private ${0} = null;", gen.translate("doActivityThread",activity));
      }
    }
  }
}

    /*members_AllAssociations*/
    
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
      appendln(realSb, "");
      appendln(realSb, "");
      append(realSb,"  //{0} Associations", uClass.getName());
      isFirst = false;
    }
  
    appendln(realSb, "");
    String lookup = av.isOne() ? "associationOne" : "associationMany";
    
    if (av.numberOfComments() > 0) { append(realSb, "\n  {0}\n", Comment.format("Association Javadoc", av.getComments())); }
    
    if (av.isOptionalOne() && av.getRelatedAssociation().isMandatory() && !av.isImmutable())
    {
      append(realSb, "  public ${0}; //until PHP 5.3 (setAccessible)", gen.translate(lookup,av));
    }
    else
    {
      append(realSb, "  private ${0};", gen.translate(lookup,av));
    }
  }
}

    /*members_AllHelpers*/
    
{

  isFirst = true;
  if (uClass.getKey().isProvided())
  {
    isFirst = false;
    appendln(realSb, "");
    appendln(realSb, "");
    appendln(realSb,"  //Helper Variables");
    append(realSb, "  private $cachedHashCode;");
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.isImmutable() && av.isIsLazy())
    {
      if (isFirst)
      {
        isFirst = false;
        appendln(realSb, "");
        appendln(realSb, "");
        appendln(realSb,"  //Helper Variables");
      }
      else
      {
        appendln(realSb, "");
      }
      append(realSb, "  private ${0};", gen.translate("attributeCanSet",av));
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
        appendln(realSb, "");
        appendln(realSb, "");
        appendln(realSb,"  //Helper Variables");
      } 
      else
      {
        appendln(realSb, "");
      }
      append(realSb, "  private ${0};", gen.translate("associationCanSet",av));
    }
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null  && !av.isImmutable())
    {
      appendln(realSb, "");
      append(realSb, "  private ${0};", gen.translate("attributeCanSet",av));
    }
    else if (as != null)
    {
      appendln(realSb, "");
      append(realSb, "  private ${0};", gen.translate("associationCanSet",as));
    }
  }
}

    realSb.append(TEXT_5);
    /*constructor_Declare_All*/
    
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
  
    /*constructor_DeclareDefault*/
    

  String customConstructorPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","constructor"));
  String customConstructorPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","constructor"));

  appendln(realSb, "");

  String constructorLookup = isOneToOne ? "constructorSignature_nulled" : "constructorSignature";
  String accessibility = uClass.getIsSingleton() ? "private" : "public";
  append(realSb,"  {0} function __construct({1})",accessibility, gClass.getLookup(constructorLookup));

  appendln(realSb, "");
  
  boolean hasBody = false;
  
  append(realSb, "  {");
  
  if (isOneToOne)
  {
    appendln(realSb,"");
    appendln(realSb,"    if (func_num_args() == 0) { return; }");
  }
  
  if (!uClass.isRoot() && !"interface".equals(uClass.getExtendsClass().getModifier()))
  {
    appendln(realSb, "");
    append(realSb, "    parent::__construct({0});", gClass.getParentClass().getLookup("constructorSignature_caller"));
    hasBody = true;
  }

  if (customConstructorPrefixCode != null)
  {
    append(realSb, "\n{0}",GeneratorHelper.doIndent(customConstructorPrefixCode, "    "));
    hasBody = true;
  }
  
  if (uClass.getKey().isProvided())
  {
    hasBody = true;
    appendln(realSb, "");
    append(realSb, "    $this->cachedHashCode = -1;");
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null  && !av.isImmutable())
    {
      hasBody = true;
      appendln(realSb, "");
      append(realSb, "    $this->{0} = true;", gen.translate("attributeCanSet",av));
    }
    else if (as != null)
    {
      hasBody = true;
      appendln(realSb, "");
      append(realSb, "    $this->{0} = true;", gen.translate("associationCanSet",as));
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
      
    /*constructor_AttributeAssignList*/
    realSb.append(TEXT_6);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_7);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_8);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      hasBody = true;
      
    /*constructor_AttributeAssignDefaulted*/
    realSb.append(TEXT_9);
    realSb.append(gen.translate("resetMethod",av));
    realSb.append(TEXT_10);
     
    }
    else if (av.isImmutable() && av.getIsLazy())
    {
      hasBody = true;
      
    /*constructor_AttributeUnassignedImmutable*/
    realSb.append(TEXT_11);
    realSb.append(gen.translate("attributeCanSet",av));
    realSb.append(TEXT_12);
    
    }
    else if (av.isImmutable())
    {
      hasBody = true;
      
    /*constructor_AttributeAssignImmutable*/
    
  String parameterValue = "";
  if (av.getValue() == null)
  {
    parameterValue = "$" + gen.translate("parameterOne",av);
  }
  else
  {
    parameterValue = gen.translate("parameterValue",av);
  }

    realSb.append(TEXT_13);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_14);
    realSb.append(parameterValue);
    realSb.append(TEXT_15);
     
    }
    else
    {
      hasBody = true;
      if(!av.getIsLazy()){
         
    /*constructor_AttributeAssign*/
    
  String assignValue = av.getValue() == null || av.getModifier().equals("fixml") ? "$" + gen.translate("parameterOne",av) : gen.translate("parameterValue",av);

    realSb.append(TEXT_16);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_17);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_18);
    realSb.append(assignValue);
    realSb.append(TEXT_19);
    
      }
      else
      {
         
    /*constructor_AttributeAssignLazy*/
    
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
    realSb.append(TEXT_20);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_21);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_22);
    realSb.append(defaultValue);
    realSb.append(TEXT_23);
    } 
    
      }
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    /*constructor_AttributeAssignAutounique*/
    realSb.append(TEXT_24);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_25);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_26);
    realSb.append(gen.translate("parameterNext",av));
    realSb.append(TEXT_27);
    
    }
    else if (av.getIsUnique())
    {
      hasBody = true;
      
    /*constructor_AttributeAssignUnique*/
    realSb.append(TEXT_28);
    realSb.append(gen.translate("setMethod", av));
    realSb.append(TEXT_29);
    realSb.append(gen.translate("parameterOne", av));
    realSb.append(TEXT_30);
    realSb.append(av.getName());
    realSb.append(TEXT_31);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
  	if (!av.getIsNavigable() || !av.isImmutable())
  	{
  	  continue;
  	}
    append(realSb, "\n    ${0}->{1} = true;", instanceIdentifier, gen.translate("associationCanSet",av));
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
        
    /*constructor_AssociationAssignUndirectionalOne*/
    realSb.append(TEXT_32);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_33);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_34);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_35);
    realSb.append(gen.relatedTranslate("type",av));
    realSb.append(TEXT_36);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_37);
    
      }
      else if (av.isOptionalOne() && av.isImmutable())
      {
        hasBody = true;
        
    /*constructor_AssociationAssignImmutableOptionalOne*/
       
    append(realSb, "\n    ${0}->{1}(${2});", instanceIdentifier, gen.translate("setMethod",av), gen.translate("parameterOne",av));

    
      }
      else if (av.isMandatoryMany())
      {
        hasBody = true;
        
    /*constructor_AssociationAssignMandatoryMany*/
    
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
  

    realSb.append(TEXT_38);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_39);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_40);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_41);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_42);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_43);
    realSb.append(gen.translate("parameterAll",av));
    realSb.append(TEXT_44);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_45);
    realSb.append(gen.relatedTranslate("type",av));
    realSb.append(TEXT_46);
    realSb.append(requiredNumber);
    realSb.append(TEXT_47);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_48);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        hasBody = true;
        
    /*constructor_AssociationAssignImmutableOptionalN*/
     String requiredNumber = StringFormatter.format("{0}", av.getMultiplicity().getUpperBound()); 
    realSb.append(TEXT_49);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_50);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_51);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_52);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_53);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_54);
    realSb.append(gen.translate("parameterAll",av));
    realSb.append(TEXT_55);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_56);
    realSb.append(gen.relatedTranslate("type",av));
    realSb.append(TEXT_57);
    realSb.append(requiredNumber);
    realSb.append(TEXT_58);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_59);
    
      }
      else if (av.isMany() && av.isImmutable())
      {
      	hasBody = true;
        
    /*constructor_AssociationAssignImmutableOptionalMany*/
    realSb.append(TEXT_60);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_61);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_62);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_63);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_64);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_65);
    realSb.append(gen.translate("parameterAll",av));
    realSb.append(TEXT_66);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_67);
    realSb.append(gen.relatedTranslate("type",av));
    realSb.append(TEXT_68);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_69);
    
      }
      else if (av.isMany())
      {
        hasBody = true;
        
    /*constructor_AssociationAssignOptionalMany*/
    realSb.append(TEXT_70);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_71);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_72);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    /*constructor_AssociationAssignOneToOne*/
    realSb.append(TEXT_73);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_74);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_75);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_76);
    realSb.append(gen.relatedTranslate("type",av));
    realSb.append(TEXT_77);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_78);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_79);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_80);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_81);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      hasBody = true;
      
    /*constructor_AssociationAssignOptionalMany*/
    realSb.append(TEXT_70);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_71);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_72);
    
    }
    else if (av.isOnlyOne())
    {
      hasBody = true;
      
    /*constructor_AssociationAssignOne*/
    realSb.append(TEXT_82);
    realSb.append(gen.translate("didAdd",av));
    realSb.append(TEXT_83);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_84);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_85);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_86);
    realSb.append(gen.translate("didAdd",av));
    realSb.append(TEXT_87);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_88);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_89);
    
    }
    else
    {
      
    /*constructor_AssociationAssignDefault*/
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOptionalMany())
  {
    appendln(realSb,"");
    append(realSb, "    $this->{0} = array();", gen.translate("associationMany",av));
  }
  else if (av.isMandatoryMany())
  {
    
    /*constructor_AssociationAssignMandatoryMany*/
    
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
  

    realSb.append(TEXT_38);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_39);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_40);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_41);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_42);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_43);
    realSb.append(gen.translate("parameterAll",av));
    realSb.append(TEXT_44);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_45);
    realSb.append(gen.relatedTranslate("type",av));
    realSb.append(TEXT_46);
    realSb.append(requiredNumber);
    realSb.append(TEXT_47);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_48);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    realSb.append(TEXT_90);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_91);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_92);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_93);
    
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
      
    /*constructor_NestedStateMachineAssignDefault*/
    realSb.append(TEXT_94);
    realSb.append(gen.translate("setMethod",nestedSm));
    realSb.append(TEXT_95);
    realSb.append(gen.translate("stateNull",nestedSm));
    realSb.append(TEXT_96);
    
    }
    
    /*constructor_StateMachineAssignDefault*/
    realSb.append(TEXT_97);
    realSb.append(gen.translate("setMethod",sm));
    realSb.append(TEXT_98);
    realSb.append(gen.translate("stateOne",state));
    realSb.append(TEXT_99);
    
  }  

  if (customConstructorPostfixCode != null)
  {
    append(realSb, "\n{0}",GeneratorHelper.doIndent(customConstructorPostfixCode, "    "));
    hasBody = true;
  }

  if (hasBody)
  {
    appendln(realSb, "");
    append(realSb, "  }");
  }
  else
  {
    append(realSb, "}");
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
		  append(realSb,"\n\n  {0} function __construct()",accessibility);
		  appendln(realSb, "");
		  append(realSb, "  {\n");
		  for (Attribute a : uClass.getAttributes())
			  if ("fixml".equals(a.getModifier()) && a.getValue() != null )
				  append(realSb, "    $this->{0} = {1};\n", a.getName(),a.getValue());
		  for( CodeInjection ci  : uClass.getCodeInjections())
			  if( ci.getOperation().equals("emptyConstructor"))
				  appendln(realSb,"    {0}",ci.getCode());
		  appendln(realSb,"  }");
		  break;
	  }
  }
  
  if( fixmlAttr == false && emptyConstructor == true )
  {
	  accessibility = uClass.getIsSingleton() ? "private" : "public";
	  append(realSb,"\n\n  {0} function __construct()",accessibility);
	  appendln(realSb, "");
	  append(realSb, "  {\n");
	  for( CodeInjection ci  : uClass.getCodeInjections())
		  if( ci.getOperation().equals("emptyConstructor"))
			  appendln(realSb,"    {0}",ci.getCode());
	  appendln(realSb,"  }");
  }
  
  if (uClass.getIsSingleton())
  {
    appendln(realSb, "");
    
    /*constructor_Singleton*/
    realSb.append(TEXT_100);
    realSb.append(uClass.getName());
    realSb.append(TEXT_101);
    
  }

    
  if (isOneToOne)
  {
    instanceIdentifier = "thisInstance";
    
    /*constructor_DeclareOneToOne*/
    
  String signature = gClass.getLookup("constructorSignature_mandatory");

    realSb.append(TEXT_102);
    realSb.append(gen.translate("constructorMandatory",uClass));
    realSb.append(TEXT_103);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_104);
    realSb.append(uClass.getName());
    realSb.append(TEXT_105);
    
  if (!uClass.isRoot())
  {
    appendln(realSb, "");
    append(realSb, "    ${0}->__construct({1});", instanceIdentifier , gClass.getParentClass().getLookup("constructorSignature_caller"));
  }
  
  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)))
    {
      continue;
    }
  
    if (av.getIsList())
    {
      
    /*constructor_AttributeAssignList*/
    realSb.append(TEXT_6);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_7);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_8);
    
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    /*constructor_AttributeAssignDefaulted*/
    realSb.append(TEXT_9);
    realSb.append(gen.translate("resetMethod",av));
    realSb.append(TEXT_10);
     
    }
    else if (av.getIsLazy())
    {
      hasBody = true;
      
    /*constructor_AttributeAssignLazy*/
    
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
    realSb.append(TEXT_20);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_21);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_22);
    realSb.append(defaultValue);
    realSb.append(TEXT_23);
    } 
    
    }
    else
    {
      
    /*constructor_AttributeAssign*/
    
  String assignValue = av.getValue() == null || av.getModifier().equals("fixml") ? "$" + gen.translate("parameterOne",av) : gen.translate("parameterValue",av);

    realSb.append(TEXT_16);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_17);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_18);
    realSb.append(assignValue);
    realSb.append(TEXT_19);
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      hasBody = true;
      
    /*constructor_AttributeAssignAutounique*/
    realSb.append(TEXT_24);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_25);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_26);
    realSb.append(gen.translate("parameterNext",av));
    realSb.append(TEXT_27);
    
    }
  }
  
  for (AssociationVariable av : uClass.getAssociationVariables()) 
  {
    AssociationVariable relatedAssociation = av.getRelatedAssociation();
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      hasBody = true;
      
    /*constructor_AssociationCreateOneToOne*/
    realSb.append(TEXT_106);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_107);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_108);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_109);
    realSb.append(gen.translate("callerArgumentsForMandatory",relatedAssociation));
    realSb.append(TEXT_110);
    
    }
    else
    {
      hasBody = true;
      
    /*constructor_AssociationAssignDefault*/
    
  if (!av.getIsNavigable())
  {
    continue;
  }

  if (av.isOptionalMany())
  {
    appendln(realSb,"");
    append(realSb, "    $this->{0} = array();", gen.translate("associationMany",av));
  }
  else if (av.isMandatoryMany())
  {
    
    /*constructor_AssociationAssignMandatoryMany*/
    
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
  

    realSb.append(TEXT_38);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_39);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_40);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_41);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_42);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_43);
    realSb.append(gen.translate("parameterAll",av));
    realSb.append(TEXT_44);
    realSb.append(gen.translate("didAddMany",av));
    realSb.append(TEXT_45);
    realSb.append(gen.relatedTranslate("type",av));
    realSb.append(TEXT_46);
    realSb.append(requiredNumber);
    realSb.append(TEXT_47);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_48);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    realSb.append(TEXT_90);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_91);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_92);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_93);
    
  } 
  else
  {
    continue;
  }
  hasBody = true;

    
    }
  }
  
  appendln(realSb, "");
  appendln(realSb, "    return ${0};",instanceIdentifier);
  append(realSb, "  }");
  
  if (!uClass.isRoot())
  {
    
    /*constructor_CallParentConstructor*/
    realSb.append(TEXT_111);
    realSb.append(gClass.getParentClass().getLookup("constructorSignature"));
    realSb.append(TEXT_112);
    realSb.append(gClass.getParentClass().getLookup("constructorSignature_caller"));
    realSb.append(TEXT_113);
    
  }

    
  }


    realSb.append(TEXT_114);
    /*attribute_Set_All*/
    
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
        
    /*attribute_SetImmutable*/
    realSb.append(TEXT_115);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_116);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_117);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_118);
    realSb.append(gen.translate("attributeCanSet",av));
    realSb.append(TEXT_119);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_120);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_121);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_122);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    /*attribute_SetDefaulted*/
    realSb.append(TEXT_123);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_124);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_125);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_126);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_127);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_128);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_129);
    realSb.append(gen.translate("resetMethod",av));
    realSb.append(TEXT_130);
     if (customResetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    realSb.append(TEXT_131);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_132);
    realSb.append(gen.translate("getDefaultMethod",av));
    realSb.append(TEXT_133);
     if (customResetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    realSb.append(TEXT_134);
    
    }
    else if (av.getIsList())
    {
      
    /*attribute_SetMany*/
    realSb.append(TEXT_135);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_136);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_137);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_138);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_139);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_140);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_141);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_142);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_143);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_144);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_145);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_146);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_147);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_148);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_149);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_150);
    
    }
    else
    {
      
    /*attribute_Set*/
    realSb.append(TEXT_151);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_152);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_153);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_154);
     for( TraceItem traceItem : traceItems )
    realSb.append((traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,"$"+gen.translate("parameterOne",av)):""));
    realSb.append(TEXT_155);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_156);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_157);
     for( TraceItem traceItem : traceItems )
    realSb.append((traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
    realSb.append(TEXT_158);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_159);
    
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
          
    /*attribute_SetDefaulted_subclass*/
    realSb.append(TEXT_160);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_161);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_162);
     if (customSetPrefixCode != null) { 
      append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_163);
     for( TraceItem traceItem : traceItems ) 
    realSb.append((traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    realSb.append(TEXT_164);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_165);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_166);
     for( TraceItem traceItem : traceItems ) 
    realSb.append((traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
    realSb.append(TEXT_167);
     if (customSetPostfixCode != null) {
    append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_168);
    
        }
        else if (av.getIsList())
        {
          
    /*attribute_SetMany_subclass*/
    realSb.append(TEXT_169);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_170);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_171);
     if (customAddPrefixCode != null) {
      append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_172);
     for( TraceItem traceItem : traceItems ) 
    realSb.append((traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_a", uClass,gen.translate("parameterOne",av)):""));
    realSb.append(TEXT_173);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_174);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_175);
     for( TraceItem traceItem : traceItems ) 
    realSb.append((traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_a", uClass):""));
    realSb.append(TEXT_176);
     if (customAddPostfixCode != null) { 
      append(realSb, "{0}\n",GeneratorHelper.doIndent(customAddPostfixCode, "    "));
    } 
    realSb.append(TEXT_177);
    
        }
        else if(!av.isImmutable()||av.getIsLazy())//if(customSetPrefixCode!=null&&customSetPostfixCode!=null&&customSetPrefixCode.matches("[\\s]*if.*\\n[\\s]*.*"))
        {
          
    /*attribute_Set_subclass*/
    realSb.append(TEXT_178);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_179);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_180);
     if (customSetPrefixCode != null) {
      append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_181);
     for( TraceItem traceItem : traceItems ) 
    realSb.append((traceItem!=null&&traceItem.getIsPre()?traceItem.trace(gen, av,"at_s", uClass,gen.translate("parameterOne",av)):""));
    realSb.append(TEXT_182);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_183);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_184);
     for( TraceItem traceItem : traceItems ) 
    realSb.append((traceItem!=null&&traceItem.getIsPost()?traceItem.trace(gen, av,"at_s", uClass):""));
    realSb.append(TEXT_185);
     if (customSetPostfixCode != null) {
      append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_186);
    
        }
      }    
    }
  }
  gen.setParameterConstraintName("");

    /*attribute_Get_All*/
    
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
      
    /*attribute_GetMany*/
    realSb.append(TEXT_187);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_188);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_189);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_190);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_191);
     if (customGetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    realSb.append(TEXT_192);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_193);
    realSb.append(gen.translate("getManyMethod",av));
    realSb.append(TEXT_194);
     if (customGetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_195);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_196);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_197);
     if (customGetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_198);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_199);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_200);
     if (customNumberOfPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    realSb.append(TEXT_201);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_202);
     if (customNumberOfPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    realSb.append(TEXT_203);
    realSb.append(gen.translate("hasManyMethod",av));
    realSb.append(TEXT_204);
     if (customHasManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    realSb.append(TEXT_205);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_206);
     if (customHasManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    realSb.append(TEXT_207);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_208);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_209);
     if (customIndexOfPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    realSb.append(TEXT_210);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_211);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_212);
     if (customIndexOfPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    realSb.append(TEXT_213);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    /*attribute_GetDerivedCodeInjection*/
    realSb.append(TEXT_214);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_215);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_216);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_217);
    realSb.append(gen.translate("parameterValue",av));
    realSb.append(TEXT_218);
     if (customGetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    realSb.append(TEXT_219);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_220);
    
      }
      else if (av.getIsDerived())
      {
        
    /*attribute_GetDerived*/
    realSb.append(TEXT_221);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_222);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_223);
    realSb.append(gen.translate("parameterValue",av));
    realSb.append(TEXT_224);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    /*attribute_GetCodeInjection*/
    realSb.append(TEXT_225);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_226);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_227);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_228);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_229);
     if (customGetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    realSb.append(TEXT_230);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_231);
    
      }
      else
      {
        
    /*attribute_Get*/
    realSb.append(TEXT_232);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_233);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_234);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_235);
    
      }
      
      appendln(realSb, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    /*attribute_GetDefaultedCodeInjection*/
    realSb.append(TEXT_236);
    realSb.append(gen.translate("getDefaultMethod",av));
    realSb.append(TEXT_237);
     if (customGetDefaultPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    realSb.append(TEXT_238);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_239);
    realSb.append(gen.translate("parameterValue",av));
    realSb.append(TEXT_240);
     if (customGetDefaultPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    realSb.append(TEXT_241);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_242);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    /*attribute_GetDefaulted*/
    realSb.append(TEXT_243);
    realSb.append(gen.translate("getDefaultMethod",av));
    realSb.append(TEXT_244);
     if (customGetDefaultPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    realSb.append(TEXT_245);
    realSb.append(gen.translate("parameterValue",av));
    realSb.append(TEXT_246);
    
      }
      
      if (av.getIsUnique())
      {
        if (customGetUniquePostfixCode != null)
        {
          
    /*attribute_GetUniqueCodeInjection*/
    realSb.append(TEXT_247);
    realSb.append(gen.translate("getUniqueMethod",av));
    realSb.append(TEXT_248);
    realSb.append(gen.translate("parameterOne", av));
    realSb.append(TEXT_249);
     if (customGetUniquePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    realSb.append(TEXT_250);
    realSb.append(gen.translate("parameterGetUnique",av));
    realSb.append(TEXT_251);
    realSb.append(gen.translate("getUniqueMap",av));
    realSb.append(TEXT_252);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_253);
     for( TraceItem traceItem : traceItems )
    realSb.append((traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
     if (customGetUniquePostfixCode != null) { append(realSb, "{0}\n",GeneratorHelper.doIndent(customGetUniquePostfixCode, "    ")); } 

    realSb.append(TEXT_254);
    realSb.append(gen.translate("parameterGetUnique",av));
    realSb.append(TEXT_255);
    
        } 
        else 
        {
          
    /*attribute_GetUnique*/
    realSb.append(TEXT_256);
    realSb.append(gen.translate("getUniqueMethod",av));
    realSb.append(TEXT_257);
    realSb.append(gen.translate("parameterOne", av));
    realSb.append(TEXT_258);
     if (customGetUniquePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    realSb.append(TEXT_259);
     for( TraceItem traceItem : traceItems )
    realSb.append((traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    realSb.append(TEXT_260);
    realSb.append(gen.translate("getUniqueMap",av));
    realSb.append(TEXT_261);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_262);
    
        }
        if (customHasUniquePostfixCode != null)
        {
          
    /*attribute_HasUniqueCodeInjection*/
    realSb.append(TEXT_263);
    realSb.append(gen.translate("hasUniqueMethod",av));
    realSb.append(TEXT_264);
    realSb.append(gen.translate("parameterOne", av));
    realSb.append(TEXT_265);
     if (customHasUniquePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    realSb.append(TEXT_266);
    realSb.append(gen.translate("parameterHasUnique",av));
    realSb.append(TEXT_267);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_268);
    realSb.append(gen.translate("getUniqueMap",av));
    realSb.append(TEXT_269);
     for( TraceItem traceItem : traceItems )
    realSb.append((traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
     if (customHasUniquePostfixCode != null) { append(realSb, "{0}\n",GeneratorHelper.doIndent(customHasUniquePostfixCode, "    ")); } 

    realSb.append(TEXT_270);
    realSb.append(gen.translate("parameterHasUnique",av));
    realSb.append(TEXT_271);
    
        }
        else
        {
          
    /*attribute_HasUnique*/
    realSb.append(TEXT_272);
    realSb.append(gen.translate("hasUniqueMethod",av));
    realSb.append(TEXT_273);
    realSb.append(gen.translate("parameterOne", av));
    realSb.append(TEXT_274);
     if (customHasUniquePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    realSb.append(TEXT_275);
     for( TraceItem traceItem : traceItems )
    realSb.append((traceItem!=null?traceItem.trace(gen, av,"at_g", uClass):""));
    realSb.append(TEXT_276);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_277);
    realSb.append(gen.translate("getUniqueMap",av));
    realSb.append(TEXT_278);
    
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
        
    /*attribute_GetCodeInjection*/
    realSb.append(TEXT_225);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_226);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_227);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_228);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_229);
     if (customGetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    realSb.append(TEXT_230);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_231);
    
      }
      else
      {
        
    /*attribute_Get*/
    realSb.append(TEXT_232);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_233);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_234);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_235);
    
      }
      appendln(realSb, "");
    }
  }
  gen.setParameterConstraintName("");

    /*attribute_IsBoolean_All*/
    
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
      
    /*attribute_IsBooleanCodeInjectionDerived*/
    realSb.append(TEXT_279);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_280);
    realSb.append(gen.translate("isMethod",av));
    realSb.append(TEXT_281);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_282);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_283);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_284);
    realSb.append(gen.translate("parameterValue",av));
    realSb.append(TEXT_285);
     if (customGetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    realSb.append(TEXT_286);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_287);
    
    }
    else if (av.getIsDerived())
    {
      
    /*attribute_IsBooleanDerived*/
    realSb.append(TEXT_288);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_289);
    realSb.append(gen.translate("isMethod",av));
    realSb.append(TEXT_290);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_291);
    realSb.append(gen.translate("parameterValue",av));
    realSb.append(TEXT_292);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    /*attribute_IsBooleanCodeInjection*/
    realSb.append(TEXT_293);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_294);
    realSb.append(gen.translate("isMethod",av));
    realSb.append(TEXT_295);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_296);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_297);
    realSb.append(gen.translate("parameterValue",av));
    realSb.append(TEXT_298);
     if (customGetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    realSb.append(TEXT_299);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_300);
    
    }
    else
    {
      
    /*attribute_IsBoolean*/
    realSb.append(TEXT_301);
    realSb.append(gen.translate("isMethod",av));
    realSb.append(TEXT_302);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_303);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_304);
    
    }
      
    appendln(realSb, "");
  }
  gen.setParameterConstraintName("");

    /*state_machine_Get_All*/
    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    
    /*state_machine_GetFull*/
    
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

    realSb.append(TEXT_305);
    realSb.append(gen.translate("getFullMethod",sm));
    realSb.append(TEXT_306);
    realSb.append(gen.translate("getMethod",sm));
    realSb.append(TEXT_307);
     if (outputAsString.length() > 0) { append(realSb, "{0}",outputAsString); } 
    realSb.append(TEXT_308);
     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    /*state_machine_Get*/
    
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

    realSb.append(TEXT_309);
    realSb.append(gen.translate("getMethod",sm));
    realSb.append(TEXT_310);
     if (outputCases.length() > 0) { append(realSb, "\n    {0}",outputCases); } 
    realSb.append(TEXT_311);
    
  }
}

    /*state_machine_Events_All*/
    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for(Event e : uClass.getEvents())
  {
    
    /*state_machine_Event*/
    
  StringBuffer allCases = new StringBuffer();
  StringBuffer allDeclarations = new StringBuffer();
  StringBuffer allArgs = new StringBuffer();

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
  String[] split = e.getArgs().split(",");
  if (split[0] != null && split[0] != "")
  {
    for (int i = 0; i < split.length; i++) {
      if (i > 0)
      {
        allArgs.append(", ");
      }
      allArgs.append(StringFormatter.format("${0}",split[i].substring(split[i].indexOf(" ")+1)));
    }
  }
  String scope = e.getIsInternal() || e.isAutoTransition() ? "private" : "public";
  String eventOutput = allDeclarations.toString() + allCases.toString();
  String argsOutput = allArgs.toString();

    realSb.append(TEXT_312);
    realSb.append(scope);
    realSb.append(TEXT_313);
    realSb.append(gen.translate("eventMethod",e));
    realSb.append(TEXT_314);
    realSb.append(argsOutput);
    realSb.append(TEXT_315);
    realSb.append(eventOutput);
    realSb.append(TEXT_316);
    
  }
}

    /*state_machine_Set_All*/
    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    /*state_machine_SetSimple*/
    
  
  StringBuffer allCases = new StringBuffer();
  StringBuffer allExitCases = new StringBuffer();
  StringBuffer allEnterCases = new StringBuffer();

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

    boolean hasThisEntry = false;
    boolean hasThisExit = false;
    for (Action action : state.getActions())
    {
      if ("exit".equals(action.getActionType()))
      {
        if(!hasThisExit)
        {
          allExitCases.append(StringFormatter.format("    if ($this->{0} == self::${1} && (${2} != self::${1} && ${2} != \"{1}\") )\n    {"
            , gen.translate("stateMachineOne",sm)
            , gen.translate("stateOne",state)
            , gen.translate("parameterOne",sm)
          ));
        }
        hasThisExit = true;
        allExitCases.append("\n      " + action.getActionCode());
      }
      else if ("entry".equals(action.getActionType()))
      {
        if (!hasThisEntry)
        {
          allEnterCases.append(StringFormatter.format("    if ($this->{0} != self::${1} && (${2} == self::${1} || ${2} == \"{1}\") )\n    {"
            , gen.translate("stateMachineOne",sm)
            , gen.translate("stateOne",state)
            , gen.translate("parameterOne",sm)
          ));
        }
        hasThisEntry = true;
        allEnterCases.append("\n      " + action.getActionCode());
      }
    }
    if (state.getHasExitAction()){
     allExitCases.append("\n    }\n");
    }
    if (state.getHasEntryAction()){
     allEnterCases.append("\n    }\n");
    }
  }
  String outputCases = allCases.toString().trim();
  String exitCasesOutput = allExitCases.toString().trim();
  String enterCasesOutput = allEnterCases.toString().trim();


    realSb.append(TEXT_317);
    realSb.append(gen.translate("setMethod",sm));
    realSb.append(TEXT_318);
    realSb.append(gen.translate("parameterOne",sm));
    realSb.append(TEXT_319);
     if (!exitCasesOutput.isEmpty()) { append(realSb, "\n    {0}",exitCasesOutput); } 
    realSb.append(TEXT_320);
     if (!enterCasesOutput.isEmpty()) { append(realSb, "\n    {0}",enterCasesOutput); } 
    realSb.append(TEXT_321);
    realSb.append(outputCases);
    realSb.append(TEXT_322);
    
    }
    else if (sm.numberOfStates() > 0)
    {
      
    /*state_machine_Set*/
    
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
  
    for (Activity activity : state.getActivities())
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
      entryActions.append(StringFormatter.format("\n      {0}",activity.getActivityCode()));
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

    realSb.append(TEXT_323);
     if (hasExit) { 
    realSb.append(TEXT_324);
    realSb.append(gen.translate("exitMethod",sm));
    realSb.append(TEXT_325);
     if (customExitPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customExitPrefixCode, "    ")); } 
    realSb.append(TEXT_326);
    realSb.append(exitActions);
    realSb.append(TEXT_327);
     if (customExitPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customExitPostfixCode, "    ")); } 
    realSb.append(TEXT_328);
     } 
    realSb.append(TEXT_329);
    realSb.append(gen.translate("setMethod",sm));
    realSb.append(TEXT_330);
    realSb.append(gen.translate("parameterOne",sm));
    realSb.append(TEXT_331);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_332);
    realSb.append(gen.translate("stateMachineOne",sm));
    realSb.append(TEXT_333);
    realSb.append(gen.translate("parameterOne",sm));
    realSb.append(TEXT_334);
     if (parentState != null) { 
    realSb.append(TEXT_335);
    realSb.append(gen.translate("stateMachineOne",parentSm));
    realSb.append(TEXT_336);
    realSb.append(gen.translate("stateOne",parentState));
    realSb.append(TEXT_337);
    realSb.append(gen.translate("parameterOne",sm));
    realSb.append(TEXT_338);
    realSb.append(gen.translate("stateNull",sm));
    realSb.append(TEXT_339);
    realSb.append(gen.translate("setMethod",parentSm));
    realSb.append(TEXT_340);
    realSb.append(gen.translate("stateOne",parentState));
    realSb.append(TEXT_341);
     } 
    realSb.append(TEXT_342);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_343);
     if (hasEntry) { 
    realSb.append(TEXT_344);
    realSb.append(entryActions);
    realSb.append(TEXT_345);
     } 
    realSb.append(TEXT_346);
    
    }
  }
}

    /*association_Get_All*/
    
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
      
    /*association_GetOne*/
    realSb.append(TEXT_347);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_348);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_349);
     if (customGetPostfixCode == null) { 
    realSb.append(TEXT_350);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_351);
     } else { 
    realSb.append(TEXT_352);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_353);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_354);
     append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
    realSb.append(TEXT_355);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_356);
     } 
    realSb.append(TEXT_357);
     
  if(av.getMultiplicity().getLowerBound() == 0) {
  
    realSb.append(TEXT_358);
    realSb.append(gen.translate("hasMethod",av));
    realSb.append(TEXT_359);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_360);
     } 
    realSb.append(TEXT_361);
    
    }
    else if (av.isMany())
    {
      
    /*association_GetMany*/
    realSb.append(TEXT_362);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_363);
     if (customGetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    realSb.append(TEXT_364);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_365);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_366);
     if (customGetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    realSb.append(TEXT_367);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_368);
    realSb.append(gen.translate("getManyMethod",av));
    realSb.append(TEXT_369);
     if (customGetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_370);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_371);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_372);
     if (customGetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_373);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_374);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_375);
     if (customNumberOfPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    realSb.append(TEXT_376);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_377);
     if (customNumberOfPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    realSb.append(TEXT_378);
    realSb.append(gen.translate("hasManyMethod",av));
    realSb.append(TEXT_379);
     if (customHasManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    realSb.append(TEXT_380);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_381);
     if (customHasManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    realSb.append(TEXT_382);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_383);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_384);
     if (customIndexOfPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    realSb.append(TEXT_385);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_386);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_387);
    realSb.append(gen.translate("attributeOne",av));
    realSb.append(TEXT_388);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_389);
     if (customIndexOfPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    realSb.append(TEXT_390);
    
    }
    else
    {
      
    realSb.append(TEXT_391);
    
    }
 }
 gen.setParameterConstraintName("");

    /*association_Set_All*/
    
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
      
    realSb.append(TEXT_392);
    realSb.append(av);
    realSb.append(TEXT_393);
    realSb.append(relatedAssociation);
    
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
      if (addNewLine) { appendln(realSb,""); }
      addNewLine = true;
      
    
      
    /*association_IsNumberOfValidMethod*/
    realSb.append(TEXT_394);
    realSb.append(gen.translate("isNumberOfValidMethod",av));
    realSb.append(TEXT_395);
     if (customIsNumberOfValidPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
    realSb.append(TEXT_396);
     if (av.getMultiplicity().isUpperBoundMany()) { 
    realSb.append(TEXT_397);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_398);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_399);
     } else { 
    realSb.append(TEXT_400);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_401);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_402);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_403);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_404);
     } 
    realSb.append(TEXT_405);
     if (customIsNumberOfValidPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    realSb.append(TEXT_406);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(realSb,""); }
      addNewLine = true;
      
    
      
    /*association_RequiredNumberOfMethod*/
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

    realSb.append(TEXT_407);
     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    realSb.append(TEXT_408);
    realSb.append(gen.translate("requiredNumberOfMethod",av));
    realSb.append(TEXT_409);
    realSb.append(av.getMultiplicity().getLowerBound());
    realSb.append(TEXT_410);
     } else { 
    realSb.append(TEXT_411);
    realSb.append(gen.translate("requiredNumberOfMethod",av));
    realSb.append(TEXT_412);
     if (customRequiredNumberOfPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    realSb.append(TEXT_413);
    realSb.append(av.getMultiplicity().getLowerBound());
    realSb.append(TEXT_414);
     if (customRequiredNumberOfPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    realSb.append(TEXT_415);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(realSb,""); }
      addNewLine = true;
      
    
      
    /*association_MinimumNumberOfMethod*/
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

    realSb.append(TEXT_416);
     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    realSb.append(TEXT_417);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_418);
    realSb.append(av.getMultiplicity().getLowerBound());
    realSb.append(TEXT_419);
     } else { 
    realSb.append(TEXT_420);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_421);
     if (customMinimumNumberOfPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    realSb.append(TEXT_422);
    realSb.append(av.getMultiplicity().getLowerBound());
    realSb.append(TEXT_423);
     if (customMinimumNumberOfPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    realSb.append(TEXT_424);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(realSb,""); }
      addNewLine = true;
      
    
      
    /*association_MaximumNumberOfMethod*/
    
    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

    realSb.append(TEXT_425);
     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    realSb.append(TEXT_426);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_427);
    realSb.append(av.getMultiplicity().getUpperBound());
    realSb.append(TEXT_428);
     } else { 
    realSb.append(TEXT_429);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_430);
     if (customMaximumNumberOfPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    realSb.append(TEXT_431);
    realSb.append(av.getMultiplicity().getUpperBound());
    realSb.append(TEXT_432);
     if (customMaximumNumberOfPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    realSb.append(TEXT_433);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(realSb,""); }
      addNewLine = true;
      
    /*association_AddManyToManyMethod*/
    realSb.append(TEXT_434);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_435);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_436);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_437);
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    realSb.append(TEXT_438);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_439);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_440);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    realSb.append(TEXT_441);
     } 
    realSb.append(TEXT_442);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_443);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_444);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_445);
    realSb.append(gen.relatedTranslate("indexOfMethod",av));
    realSb.append(TEXT_446);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_447);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_448);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_449);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    realSb.append(TEXT_450);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(realSb,""); }
      addNewLine = true;
      
    /*association_RemoveMany*/
    realSb.append(TEXT_451);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_452);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_453);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_454);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_455);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_456);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_457);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_458);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_459);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_460);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_461);
    realSb.append(gen.relatedTranslate("indexOfMethod",av));
    realSb.append(TEXT_462);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_463);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_464);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_465);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_466);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_467);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_468);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_469);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_470);
    
    }

    if (addNewLine) { appendln(realSb,""); }
    addNewLine = true;
    
    
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    /*association_SetUnidirectionalOptionalOne*/
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    realSb.append(TEXT_471);
    realSb.append(accessModifier);
    realSb.append(TEXT_472);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_473);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_474);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_475);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_476);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_477);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_478);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    /*association_SetUnidirectionalOne*/
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    realSb.append(TEXT_479);
    realSb.append(accessModifier);
    realSb.append(TEXT_480);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_481);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_482);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_483);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_484);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_485);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_486);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_487);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    /*association_SetOptionalOneToOne*/
    realSb.append(TEXT_488);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_489);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_490);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_491);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_492);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_493);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_494);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_495);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_496);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_497);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_498);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    realSb.append(TEXT_499);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_500);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_501);
    realSb.append(gen.relatedTranslate("parameterOld",av));
    realSb.append(TEXT_502);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_503);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_504);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_505);
    realSb.append(gen.relatedTranslate("parameterOld",av));
    realSb.append(TEXT_506);
    realSb.append(gen.relatedTranslate("parameterOld",av));
    realSb.append(TEXT_507);
    realSb.append(gen.relatedTranslate("parameterOld",av));
    realSb.append(TEXT_508);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_509);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_510);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_511);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_512);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_513);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    /*association_SetOneToOptionalOne*/
    realSb.append(TEXT_514);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_515);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_516);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_517);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_518);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_519);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_520);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_521);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_522);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_523);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_524);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_525);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_526);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_527);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_528);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_529);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_530);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_531);
    realSb.append(gen.translate("parameterOld",av));
    realSb.append(TEXT_532);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_533);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_534);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_535);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_536);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_537);
    realSb.append(gen.translate("parameterOld",av));
    realSb.append(TEXT_538);
    realSb.append(gen.translate("parameterOld",av));
    realSb.append(TEXT_539);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_540);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_541);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    /*association_AddMandatoryManyToOne*/
    realSb.append(TEXT_542);
    realSb.append(gen.translate("addViaMethod",av));
    realSb.append(TEXT_543);
    realSb.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    realSb.append(TEXT_544);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_545);
    realSb.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    realSb.append(TEXT_546);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_547);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_548);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_549);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_550);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_551);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_552);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_553);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_554);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_555);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_556);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_557);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_558);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_559);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_560);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_561);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_562);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_563);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_564);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_565);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_566);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_567);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_568);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_569);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_570);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_571);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_572);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_573);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_574);
    realSb.append(av.getMultiplicity().getLowerBound());
    realSb.append(TEXT_575);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_576);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_577);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_578);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_579);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_580);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_581);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_582);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_583);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_584);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    /*association_AddMNToOnlyOne*/
    realSb.append(TEXT_585);
    realSb.append(gen.translate("addViaMethod",av));
    realSb.append(TEXT_586);
    realSb.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    realSb.append(TEXT_587);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_588);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_589);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_590);
    realSb.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    realSb.append(TEXT_591);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_592);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_593);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_594);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_595);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_596);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    realSb.append(TEXT_597);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_598);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_599);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_600);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_601);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_602);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_603);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_604);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_605);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_606);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_607);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    realSb.append(TEXT_608);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_609);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_610);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_611);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_612);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_613);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_614);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_615);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_616);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_617);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_618);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_619);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_620);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_621);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_622);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_623);
    realSb.append(av.getMultiplicity().getLowerBound());
    realSb.append(TEXT_624);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_625);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_626);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_627);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_628);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_629);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_630);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_631);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_632);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_633);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    /*association_AddOptionalNToOne*/
    realSb.append(TEXT_634);
    realSb.append(gen.translate("addViaMethod",av));
    realSb.append(TEXT_635);
    realSb.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    realSb.append(TEXT_636);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_637);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_638);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_639);
    realSb.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    realSb.append(TEXT_640);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_641);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_642);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_643);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_644);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_645);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    realSb.append(TEXT_646);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_647);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_648);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_649);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_650);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_651);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_652);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_653);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_654);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_655);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_656);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_657);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_658);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_659);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_660);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_661);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_662);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_663);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_664);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_665);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_666);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_667);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_668);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_669);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_670);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_671);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    /*association_SetOptionalNToMany*/
    realSb.append(TEXT_672);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_673);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_674);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_675);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_676);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_677);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_678);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_679);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_680);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_681);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_682);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_683);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_684);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_685);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_686);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_687);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_688);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_689);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_690);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_691);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_692);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_693);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_694);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_695);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_696);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_697);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_698);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_699);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_700);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_701);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_702);
    realSb.append(gen.translate("parameterOld",av));
    realSb.append(TEXT_703);
    realSb.append(gen.translate("parameterOld",av));
    realSb.append(TEXT_704);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_705);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_706);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    /*association_AddManyToOne*/
    realSb.append(TEXT_707);
    realSb.append(gen.translate("addViaMethod",av));
    realSb.append(TEXT_708);
    realSb.append(gen.translate("methodArgumentsExcept",relatedAssociation));
    realSb.append(TEXT_709);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_710);
    realSb.append(gen.translate("callerArgumentsExcept",relatedAssociation));
    realSb.append(TEXT_711);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_712);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_713);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_714);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_715);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_716);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_717);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_718);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_719);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_720);
    realSb.append(gen.relatedTranslate("parameterIsNew",av));
    realSb.append(TEXT_721);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_722);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_723);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_724);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_725);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_726);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_727);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_728);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_729);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_730);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_731);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_732);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_733);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_734);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_735);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_736);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_737);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_738);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_739);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    /*association_SetOptionalOneToOptionalOne*/
    realSb.append(TEXT_740);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_741);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_742);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_743);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_744);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_745);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_746);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_747);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_748);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_749);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_750);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_751);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_752);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_753);
    realSb.append(gen.translate("parameterCurrent",av));
    realSb.append(TEXT_754);
    realSb.append(gen.translate("getMethod",av));
    realSb.append(TEXT_755);
    realSb.append(gen.translate("parameterCurrent",av));
    realSb.append(TEXT_756);
    realSb.append(gen.translate("parameterCurrent",av));
    realSb.append(TEXT_757);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_758);
    realSb.append(gen.translate("parameterCurrent",av));
    realSb.append(TEXT_759);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_760);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_761);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_762);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_763);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_764);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_765);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_766);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_767);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_768);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_769);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    /*association_AddMNToMany*/
    realSb.append(TEXT_770);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_771);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_772);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_773);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_774);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_775);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_776);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_777);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_778);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_779);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_780);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_781);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_782);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_783);
    realSb.append(gen.relatedTranslate("indexOfMethod",av));
    realSb.append(TEXT_784);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_785);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_786);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_787);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_788);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_789);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_790);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_791);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_792);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    /*association_AddMStarToMany*/
    realSb.append(TEXT_793);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_794);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_795);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_796);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_797);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_798);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_799);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_800);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_801);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_802);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_803);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_804);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_805);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_806);
    realSb.append(gen.relatedTranslate("indexOfMethod",av));
    realSb.append(TEXT_807);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_808);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_809);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_810);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_811);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_812);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_813);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_814);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_815);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    /*association_SetOptionalOneToOptionalN*/
    realSb.append(TEXT_816);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_817);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_818);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_819);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_820);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_821);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_822);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_823);
    realSb.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    realSb.append(TEXT_824);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_825);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_826);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_827);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_828);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_829);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_830);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_831);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_832);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_833);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_834);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_835);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_836);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_837);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_838);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    /*association_SetOneToMany*/
    realSb.append(TEXT_839);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_840);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_841);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_842);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_843);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_844);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_845);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_846);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_847);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_848);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_849);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_850);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_851);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_852);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_853);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_854);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_855);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_856);
    
    }
    else if (includeFile == "association_SetOneToManyAssociationClass.jet")
    {
      
    /*association_SetOneToManyAssociationClass*/
    realSb.append(TEXT_857);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_858);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_859);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_860);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_861);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_862);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_863);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_864);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_865);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_866);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_867);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_868);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_869);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_870);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_871);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_872);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_873);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_874);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_875);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_876);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    /*association_SetOneToAtMostN*/
    realSb.append(TEXT_877);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_878);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_879);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_880);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_881);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_882);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_883);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_884);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_885);
    realSb.append(relatedAssociation.getMultiplicity().getUpperBound());
    realSb.append(TEXT_886);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_887);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_888);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_889);
    realSb.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    realSb.append(TEXT_890);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_891);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_892);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_893);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_894);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_895);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_896);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_897);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_898);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_899);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_900);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_901);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_902);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "        ")); } 
    realSb.append(TEXT_903);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_904);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_905);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_906);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    /*association_SetOneToMandatoryMany*/
    realSb.append(TEXT_907);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_908);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_909);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_910);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_911);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_912);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_913);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_914);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_915);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_916);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_917);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_918);
    realSb.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    realSb.append(TEXT_919);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    realSb.append(TEXT_920);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_921);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_922);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_923);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_924);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_925);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_926);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_927);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_928);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_929);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_930);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_931);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "        ")); } 
    realSb.append(TEXT_932);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_933);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_934);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_935);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    /*association_AddManyToOptionalOne*/
    realSb.append(TEXT_936);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_937);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_938);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_939);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_940);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_941);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_942);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_943);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_944);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_945);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_946);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_947);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_948);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_949);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_950);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_951);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_952);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_953);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_954);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_955);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_956);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_957);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_958);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_959);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_960);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_961);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_962);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_963);
    realSb.append(gen.translate("attributeMany",av));
    realSb.append(TEXT_964);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_965);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_966);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_967);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_968);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_969);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    /*association_SetOptionalOneToMany*/
    realSb.append(TEXT_970);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_971);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_972);
     if (customSetPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    realSb.append(TEXT_973);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_974);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_975);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_976);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_977);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_978);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_979);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_980);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_981);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_982);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_983);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_984);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_985);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_986);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_987);
     if (customSetPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    realSb.append(TEXT_988);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    /*association_AddOptionalNToOptionalOne*/
    realSb.append(TEXT_989);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_990);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_991);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_992);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_993);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_994);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    realSb.append(TEXT_995);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_996);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_997);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_998);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_999);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1000);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1001);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1002);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1003);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_1004);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1005);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_1006);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1007);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1008);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1009);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_1010);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_1011);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1012);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_1013);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1014);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1015);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1016);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1017);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1018);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1019);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1020);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1021);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1022);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_1023);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    /*association_AddUnidirectionalMN*/
    realSb.append(TEXT_1024);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_1025);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1026);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_1027);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1028);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_1029);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1030);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1031);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_1032);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_1033);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1034);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_1035);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1036);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1037);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_1038);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1039);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1040);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_1041);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1042);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1043);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1044);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1045);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1046);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_1047);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    /*association_AddMNToOptionalOne*/
    realSb.append(TEXT_1048);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_1049);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1050);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_1051);
     if (!av.isStar()) { 
    realSb.append(TEXT_1052);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1053);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_1054);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    realSb.append(TEXT_1055);
     } 
    realSb.append(TEXT_1056);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1057);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1058);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1059);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1060);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1061);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1062);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1063);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    realSb.append(TEXT_1064);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1065);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1066);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1067);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1068);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1069);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1070);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1071);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1072);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1073);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1074);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1075);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1076);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1077);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1078);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_1079);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_1080);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1081);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_1082);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1083);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1084);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1085);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1086);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1087);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1088);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1089);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1090);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1091);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1092);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1093);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_1094);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    /*association_SetNToOptionalOne*/
    realSb.append(TEXT_1095);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_1096);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1097);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_1098);
    realSb.append(gen.translate("parameterCheckNewMany",av));
    realSb.append(TEXT_1099);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1100);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1101);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1102);
    realSb.append(gen.translate("parameterCheckNewMany",av));
    realSb.append(TEXT_1103);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    realSb.append(TEXT_1104);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1105);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1106);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1107);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1108);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    realSb.append(TEXT_1109);
    realSb.append(gen.translate("parameterCheckNewMany",av));
    realSb.append(TEXT_1110);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1111);
    realSb.append(gen.translate("parameterCheckNewMany",av));
    realSb.append(TEXT_1112);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1113);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_1114);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1115);
    realSb.append(gen.translate("parameterCheckNewMany",av));
    realSb.append(TEXT_1116);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1117);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1118);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1119);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1120);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1121);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1122);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1123);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1124);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_1125);
    /*association_GetPrivate*/
    realSb.append(TEXT_1126);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1127);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1128);
    realSb.append(gen.relatedTranslate("parameterOne",av));
    realSb.append(TEXT_1129);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1130);
    realSb.append(gen.relatedTranslate("parameterOne",av));
    realSb.append(TEXT_1131);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1132);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_1133);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1134);
    realSb.append(gen.relatedTranslate("parameterOne",av));
    realSb.append(TEXT_1135);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    /*association_AddUnidirectionalMany*/
    realSb.append(TEXT_1136);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_1137);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1138);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_1139);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1140);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1141);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_1142);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_1143);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1144);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_1145);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1146);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1147);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1148);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1149);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1150);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1151);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1152);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_1153);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    /*association_AddUnidirectionalOptionalN*/
    realSb.append(TEXT_1154);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_1155);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1156);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_1157);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1158);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_1159);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1160);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1161);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_1162);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_1163);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1164);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_1165);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1166);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1167);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1168);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1169);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1170);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1171);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1172);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_1173);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    /*association_AddUnidirectionalMStar*/
    realSb.append(TEXT_1174);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_1175);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1176);
     if (customAddPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    realSb.append(TEXT_1177);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1178);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1179);
     if (customAddPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    realSb.append(TEXT_1180);
    realSb.append(gen.translate("removeMethod",av));
    realSb.append(TEXT_1181);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1182);
     if (customRemovePrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    realSb.append(TEXT_1183);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1184);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1185);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_1186);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1187);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1188);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    realSb.append(TEXT_1189);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1190);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1191);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1192);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1193);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1194);
     if (customRemovePostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    realSb.append(TEXT_1195);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    /*association_SetUnidirectionalN*/
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    realSb.append(TEXT_1196);
    realSb.append(accessModifier);
    realSb.append(TEXT_1197);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_1198);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1199);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_1200);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1201);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1202);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1203);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1204);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1205);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1206);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1207);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1208);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1209);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1210);
    realSb.append(gen.translate("requiredNumberOfMethod",av));
    realSb.append(TEXT_1211);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_1212);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1213);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1214);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_1215);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
      
    /*association_SetUnidirectionalMany*/
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    realSb.append(TEXT_1216);
    realSb.append(accessModifier);
    realSb.append(TEXT_1217);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_1218);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1219);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_1220);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1221);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1222);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1223);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1224);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1225);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1226);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1227);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1228);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1229);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_1230);
    realSb.append(instanceIdentifier);
    realSb.append(TEXT_1231);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1232);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1233);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_1234);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    /*association_SetOptionalOneToMandatoryMany*/
    realSb.append(TEXT_1235);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_1236);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1237);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1238);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1239);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1240);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1241);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1242);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_1243);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1244);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1245);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1246);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1247);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1248);
    realSb.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1249);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1250);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_1251);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1252);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1253);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1254);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1255);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1256);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1257);
    realSb.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1258);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1259);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_1260);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1261);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1262);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1263);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_1264);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1265);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1266);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1267);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1268);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    /*association_SetOptionalOneToMandatoryMN*/
    realSb.append(TEXT_1269);
    realSb.append(gen.translate("setMethod",av));
    realSb.append(TEXT_1270);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1271);
    realSb.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    realSb.append(TEXT_1272);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1273);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1274);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1275);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1276);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1277);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_1278);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1279);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1280);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1281);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1282);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1283);
    realSb.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1284);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1285);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_1286);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1287);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1288);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1289);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1290);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1291);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1292);
    realSb.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1293);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1294);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_1295);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1296);
    realSb.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    realSb.append(TEXT_1297);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1298);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_1299);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1300);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1301);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1302);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_1303);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1304);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1305);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1306);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1307);
    
    }
    else if (includeFile != null)
    {
      appendln(realSb,"You forgot to include {0}",includeFile);
    }
    
    
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    /*association_SetMNToMany*/
    realSb.append(TEXT_1308);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_1309);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1310);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_1311);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1312);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1313);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1314);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1315);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1316);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1317);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1318);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1319);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1320);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1321);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1322);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1323);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_1324);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_1325);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1326);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1327);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1328);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1329);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_1330);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1331);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_1332);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_1333);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1334);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1335);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1336);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1337);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_1338);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_1339);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1340);
    realSb.append(gen.translate("parameterOld",av));
    realSb.append(TEXT_1341);
    realSb.append(gen.translate("parameterOld",av));
    realSb.append(TEXT_1342);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1343);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_1344);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    /*association_SetMStarToMany*/
    realSb.append(TEXT_1345);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_1346);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1347);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_1348);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1349);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1350);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1351);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1352);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1353);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1354);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1355);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1356);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1357);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1358);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1359);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_1360);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1361);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1362);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1363);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1364);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_1365);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1366);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_1367);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_1368);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1369);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1370);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1371);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1372);
    realSb.append(gen.translate("parameterNew",av));
    realSb.append(TEXT_1373);
    realSb.append(gen.relatedTranslate("addMethod",av));
    realSb.append(TEXT_1374);
    realSb.append(gen.translate("parameterOldMany",av));
    realSb.append(TEXT_1375);
    realSb.append(gen.translate("parameterOld",av));
    realSb.append(TEXT_1376);
    realSb.append(gen.translate("parameterOld",av));
    realSb.append(TEXT_1377);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1378);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_1379);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    /*association_SetUnidirectionalMN*/
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    realSb.append(TEXT_1380);
    realSb.append(accessModifier);
    realSb.append(TEXT_1381);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_1382);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1383);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_1384);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1385);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1386);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1387);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1388);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1389);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1390);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1391);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1392);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1393);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1394);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1395);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1396);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_1397);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_1398);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1399);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1400);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_1401);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    /*association_SetMNToOptionalOne*/
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" || count(${0}) > self::{1}()", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av));

    realSb.append(TEXT_1402);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_1403);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1404);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_1405);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1406);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1407);
    realSb.append(orCheckMaxBound);
    realSb.append(TEXT_1408);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_1409);
    realSb.append(gen.translate("parameterCheckNewMany",av));
    realSb.append(TEXT_1410);
    realSb.append(existingToNewMap);
    realSb.append(TEXT_1411);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1412);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1413);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1414);
    realSb.append(gen.translate("parameterCheckNewMany",av));
    realSb.append(TEXT_1415);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    realSb.append(TEXT_1416);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1417);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1418);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1419);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1420);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1421);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1422);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1423);
    realSb.append(gen.relatedTranslate("parameterExistingSerialized",av));
    realSb.append(TEXT_1424);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1425);
    realSb.append(gen.relatedTranslate("parameterExistingSerialized",av));
    realSb.append(TEXT_1426);
    realSb.append(existingToNewMap);
    realSb.append(TEXT_1427);
    realSb.append(existingToNewMap);
    realSb.append(TEXT_1428);
    realSb.append(gen.relatedTranslate("parameterExistingSerialized",av));
    realSb.append(TEXT_1429);
    realSb.append(gen.relatedTranslate("parameterExisting",av));
    realSb.append(TEXT_1430);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1431);
    realSb.append(existingToNewMap);
    realSb.append(TEXT_1432);
    realSb.append(gen.relatedTranslate("parameterExistingSerialized",av));
    realSb.append(TEXT_1433);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1434);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    realSb.append(TEXT_1435);
    realSb.append(existingToNewMap);
    realSb.append(TEXT_1436);
    realSb.append(gen.relatedTranslate("parameterExistingSerialized",av));
    realSb.append(TEXT_1437);
    realSb.append(gen.translate("parameterCheckNewMany",av));
    realSb.append(TEXT_1438);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1439);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1440);
    realSb.append(gen.translate("parameterCheckNewMany",av));
    realSb.append(TEXT_1441);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1442);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1443);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1444);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1445);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1446);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1447);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1448);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1449);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1450);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1451);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1452);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1453);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1454);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1455);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1456);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1457);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1458);
    realSb.append(gen.relatedTranslate("getMethod",av));
    realSb.append(TEXT_1459);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1460);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1461);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1462);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1463);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1464);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_1465);
    /*association_GetPrivate*/
    realSb.append(TEXT_1126);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1127);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1128);
    realSb.append(gen.relatedTranslate("parameterOne",av));
    realSb.append(TEXT_1129);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1130);
    realSb.append(gen.relatedTranslate("parameterOne",av));
    realSb.append(TEXT_1131);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1132);
    realSb.append(gen.relatedTranslate("associationOne",av));
    realSb.append(TEXT_1133);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1134);
    realSb.append(gen.relatedTranslate("parameterOne",av));
    realSb.append(TEXT_1135);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    /*association_SetUnidirectionalOptionalN*/
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    realSb.append(TEXT_1466);
    realSb.append(accessModifier);
    realSb.append(TEXT_1467);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_1468);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1469);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_1470);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1471);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1472);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1473);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1474);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1475);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1476);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1477);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1478);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1479);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1480);
    realSb.append(gen.translate("maximumNumberOfMethod",av));
    realSb.append(TEXT_1481);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_1482);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1483);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1484);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_1485);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    /*association_SetUnidirectionalMStar*/
     String accessModifier = (av.isImmutable()) ? "private" : "public"; 
    realSb.append(TEXT_1486);
    realSb.append(accessModifier);
    realSb.append(TEXT_1487);
    realSb.append(gen.translate("setManyMethod",av));
    realSb.append(TEXT_1488);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1489);
     if (customSetManyPrefixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    realSb.append(TEXT_1490);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1491);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1492);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1493);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1494);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1495);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1496);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1497);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1498);
    realSb.append(gen.translate("parameterMany",av));
    realSb.append(TEXT_1499);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1500);
    realSb.append(gen.translate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1501);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    realSb.append(TEXT_1502);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1503);
    realSb.append(gen.translate("parameterVerifiedMany",av));
    realSb.append(TEXT_1504);
     if (customSetManyPostfixCode != null) { append(realSb, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    realSb.append(TEXT_1505);
    
    }
    else if (includeFile2 != null)
    {
      appendln(realSb,"You forgot to include {0}",includeFile2);
    }
    
    if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
    {
      
    /*association_Sort*/
    
      sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
    }
    else if(includeFile3 == "association_AddIndexControlFunctions.jet")
    {
      
    /*association_AddIndexControlFunctions*/
    realSb.append(TEXT_1506);
    realSb.append(gen.translate("addAtMethod",av));
    realSb.append(TEXT_1507);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1508);
    realSb.append(gen.translate("addMethod",av));
    realSb.append(TEXT_1509);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1510);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1511);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1512);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1513);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1514);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1515);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1516);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1517);
    realSb.append(gen.translate("addOrMoveAtMethod",av));
    realSb.append(TEXT_1518);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1519);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1520);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1521);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1522);
    realSb.append(gen.translate("numberOfMethod",av));
    realSb.append(TEXT_1523);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1524);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1525);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1526);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1527);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1528);
    realSb.append(gen.translate("addAtMethod",av));
    realSb.append(TEXT_1529);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1530);
    
    }
  }
  gen.setParameterConstraintName("");

    realSb.append(TEXT_1531);
     if (uClass.getKey().isProvided()) { 
    /*equals*/
    

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


    realSb.append(TEXT_1532);
    realSb.append(checks.toString().trim());
    realSb.append(TEXT_1533);
    realSb.append(hash.toString().trim());
    realSb.append(TEXT_1534);
    realSb.append(canSet.toString().trim());
    realSb.append(TEXT_1535);
    realSb.append(TEXT_1536);
     } else { 
    /*equals_default*/
    realSb.append(TEXT_1537);
    realSb.append(TEXT_1538);
     } 
    /*delete_All*/
    

  appendln(realSb,"");
  appendln(realSb,"  public function delete()");
  append(realSb,"  {");

  boolean hasSomethingToDelete = false;

  String customDeletePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","delete"));
  String customDeletePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","delete"));

  if (customDeletePrefixCode != null) 
  {
    append(realSb, "\n{0}",GeneratorHelper.doIndent(customDeletePrefixCode, "    "));
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
        
    /*delete_UndirectionalOne*/
    realSb.append(TEXT_1539);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1540);
    
      }
      else if (av.isMany())
      {
        hasSomethingToDelete = true;
        
    /*delete_UndirectionalMany*/
    realSb.append(TEXT_1541);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1542);
    
      }
      continue;
    }
    
    if (relatedAssociation.getIsComposition()) {
    	if ((relatedAssociation.isOnlyOne() || relatedAssociation.isOptionalOne()) && av.isOnlyOne()) {
    		
    /*delete_OneFromOne*/
    realSb.append(TEXT_1543);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1544);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1545);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1546);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1547);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1548);
    
    	}
    	else if ((relatedAssociation.isOnlyOne() || relatedAssociation.isOptionalOne()) && av.isOptionalOne()) {
    		
    /*delete_OptionalOneFromOne_comp*/
    realSb.append(TEXT_1549);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1550);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1551);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1552);
    
    	}
    	else if ((relatedAssociation.isOnlyOne() || relatedAssociation.isOptionalOne()) && av.isMany()) {
    		
    /*delete_ManyFromX_comp*/
    realSb.append(TEXT_1553);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1554);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1555);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1556);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1557);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1558);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1559);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1560);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1561);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1562);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1563);
    
    	}
    	
    	else if (relatedAssociation.isMany() && av.isOnlyOne()) {
    		
    /*delete_OneFromOne*/
    realSb.append(TEXT_1543);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1544);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1545);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1546);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1547);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1548);
    
    	}
    	else if (relatedAssociation.isMany() && av.isOptionalOne()) {
    	    
    /*delete_OptionalOneFromOne_comp*/
    realSb.append(TEXT_1549);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1550);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1551);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1552);
    
    	}
	else if (relatedAssociation.isMany() && av.isMany()) {
    	    
    /*delete_ManyFromX_comp*/
    realSb.append(TEXT_1553);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1554);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1555);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1556);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1557);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1558);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1559);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1560);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1561);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1562);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1563);
    
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
  
    	
    /*delete_ManyFromX_comp*/
    realSb.append(TEXT_1553);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1554);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1555);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1556);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1557);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1558);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1559);
    realSb.append(gen.translate("indexOfMethod",av));
    realSb.append(TEXT_1560);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1561);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1562);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1563);
    
	  
    }
    
    else if (av.getIsComposition() && (av.isMany() && relatedAssociation.isOptionalOne() && !av.isMandatory())) { 
    	
    	
    /*delete_OptionalOneFromMany_comp*/
    realSb.append(TEXT_1564);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1565);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1566);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1567);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1568);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1569);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1570);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1571);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1572);
    
	  
    }
    
    else if (av.getIsComposition() && (av.isOptionalOne() && relatedAssociation.getMultiplicity().getLowerBound() > 1  && relatedAssociation.getMultiplicity().getLowerBound() != relatedAssociation.getMultiplicity().getUpperBound())) { 
    	
    	
    /*delete_OptionalOneFromMN_comp*/
    realSb.append(TEXT_1573);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1574);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1575);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_1576);
    realSb.append(relatedAssociation.getMultiplicity().getLowerBound());
    realSb.append(TEXT_1577);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1578);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1579);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1580);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1581);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1582);
    
	  
    }

    else if (av.getIsComposition() && av.isMany() && relatedAssociation.isOptionalOne()) {
    	    
    /*delete_OptionalOneFromMany_comp*/
    realSb.append(TEXT_1564);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1565);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1566);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1567);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1568);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1569);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1570);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1571);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1572);
    
    }
    
    else {
    
	    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
	    {
	      
    /*delete_OneFromOne*/
    realSb.append(TEXT_1543);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1544);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1545);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1546);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1547);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1548);
    
	    }
	    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
	    {
	      
    /*delete_OptionalOneFromOptionalOne*/
    realSb.append(TEXT_1583);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1584);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1585);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1586);
    
	    }
	    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
	    {
	      
    /*delete_OneFromOptionalOne*/
    realSb.append(TEXT_1587);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1588);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1589);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1590);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1591);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1592);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1593);
    
	    }
	    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
	    {
	      
    /*delete_OptionalOneFromOne*/
    realSb.append(TEXT_1594);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1595);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1596);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1597);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1598);
    realSb.append(gen.translate("parameterExisting",av));
    realSb.append(TEXT_1599);
    
	    }
	    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
	    {
	      
    /*delete_OptionalOneFromMany*/
    realSb.append(TEXT_1600);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1601);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1602);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1603);
    
	    }
	    else if (av.isOptionalOne() && relatedAssociation.isN())
	    {
	      
    /*delete_OptionalOneFromN*/
    realSb.append(TEXT_1604);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1605);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1606);
    
	    }
	    else if (av.isOptionalOne() && relatedAssociation.isMN())
	    {
	      
    /*delete_OptionalOneFromMN*/
    realSb.append(TEXT_1607);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1608);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1609);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_1610);
    realSb.append(relatedAssociation.getMultiplicity().getLowerBound());
    realSb.append(TEXT_1611);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1612);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1613);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1614);
    
	    }
	    else if (av.isOne() && relatedAssociation.isMany())
	    {
	      
    /*delete_OneFromMany*/
    realSb.append(TEXT_1615);
    realSb.append(gen.translate("removeParameterOne",av));
    realSb.append(TEXT_1616);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1617);
    realSb.append(gen.translate("associationOne",av));
    realSb.append(TEXT_1618);
    realSb.append(gen.translate("removeParameterOne",av));
    realSb.append(TEXT_1619);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1620);
    
	    }
	    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
	    {
	      
    /*delete_MandatoryFromOptionalOne*/
    realSb.append(TEXT_1621);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1622);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1623);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1624);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1625);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1626);
    
	    }
	    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
	    {
	      
    /*delete_ManyFromMN*/
    realSb.append(TEXT_1627);
    realSb.append(gen.translate("parameterCopyOfMany",av));
    realSb.append(TEXT_1628);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1629);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1630);
    realSb.append(gen.translate("parameterCopyOfMany",av));
    realSb.append(TEXT_1631);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1632);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1633);
    realSb.append(gen.relatedTranslate("numberOfMethod",av));
    realSb.append(TEXT_1634);
    realSb.append(gen.translate("type",av));
    realSb.append(TEXT_1635);
    realSb.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    realSb.append(TEXT_1636);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1637);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1638);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1639);
    
	    }
	    else if (av.isMany() && relatedAssociation.isMany())
	    {
	      
    /*delete_ManyFromMany*/
    realSb.append(TEXT_1640);
    realSb.append(gen.translate("parameterCopyOfMany",av));
    realSb.append(TEXT_1641);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1642);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1643);
    realSb.append(gen.translate("parameterCopyOfMany",av));
    realSb.append(TEXT_1644);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1645);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1646);
    realSb.append(gen.relatedTranslate("removeMethod",av));
    realSb.append(TEXT_1647);
    
	    }
	    else if (av.isMany() && relatedAssociation.isOnlyOne()) 
	    {
	      
    /*delete_ManyFromOne*/
    realSb.append(TEXT_1648);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1649);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1650);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1651);
    
	    }
	    else if (av.isMany() && relatedAssociation.isOptionalOne())
	    {
	      
    /*delete_ManyFromOptionalOne*/
    realSb.append(TEXT_1652);
    realSb.append(gen.translate("associationMany",av));
    realSb.append(TEXT_1653);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1654);
    realSb.append(gen.translate("parameterOne",av));
    realSb.append(TEXT_1655);
    realSb.append(gen.relatedTranslate("setMethod",av));
    realSb.append(TEXT_1656);
    
	    }
	    else
	    {
	      continue;
	    }
	}
    hasSomethingToDelete = true;
  }
  
  if (!uClass.isRoot() && !"external".equals(uClass.getExtendsClass().getModifier()))
  {
    hasSomethingToDelete = true;
    appendln(realSb,"");
    append(realSb, "    parent::delete();");
  }

  if (customDeletePostfixCode != null) 
  {
    append(realSb, "\n{0}",GeneratorHelper.doIndent(customDeletePostfixCode, "    "));
    hasSomethingToDelete = true;
  }
  
  if (hasSomethingToDelete)
  {
    appendln(realSb, "");
    appendln(realSb, "  }");
  }
  else
  {
    appendln(realSb, "}");
  }
  
  

    realSb.append(TEXT_1657);
     if (uClass.hasMethods()) { 
    /*class_MethodDeclaration*/
    
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
        
				appendln(realSb, "");
				if (aMethod.numberOfComments() > 0) { append(realSb, "\n  {0}\n", Comment.format("Method Javadoc",aMethod.getComments())); }
				
  			//appendln(realSb,override);
  			append(realSb, "  {0}{1} {2} {3}({4})", methodModifier, methodImplementationModifier, methodType, methodName, finalParams);
  	  if(!"".equals(customPostconditionCode))
      {
        appendln(realSb, "\n  {");
        if(!"".equals(aMethod.getType())&&!"void".equals(aMethod.getType())){
          append(realSb, "    $result = {0}Original({1});\n", methodName, finalParams);
        }
        else {
          append(realSb, "    $this->{0}Original({1});\n", methodName, finalParams);
        }
        appendln(realSb, GeneratorHelper.doIndent(customPostconditionCode, "    "));
        if(!"".equals(aMethod.getType())&&!"void".equals(aMethod.getType())){
          append(realSb, "    return $result;\n");
        }          
        appendln(realSb, "  }");
        append(realSb, "\n  {0}{1} {2} {3}Original({4})", methodModifier, methodImplementationModifier, methodType, methodName, finalParams);
      }    
        if(aMethod.getIsAbstract())
  			{
  			  append(realSb, ";");
  			}
  			else
  			{
    			appendln(realSb, "\n  {");
    			if (customPreconditionCode != null) { append(realSb, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
    			appendln(realSb, properMethodBody);
    			appendln(realSb, "  }");
  			}
    	}
    }

    realSb.append(TEXT_1658);
     } 
    realSb.append(TEXT_1659);
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    realSb.append(TEXT_1660);
    realSb.append(uClass.getExtraCode());
    realSb.append(TEXT_1661);
     } 
    /*trace*/
    

{

	//==== Tracing Code    
    if( model.getTraceType().equals("File") && uClass.hasTraceDirectives() )
	{
		appendln(realSb, "");
		appendln(realSb, "  //------------------------");
		appendln(realSb, "  // FILE TRACER METHOD");
		appendln(realSb, "  //------------------------\n");
		appendln(realSb, "  function fileTracer($tracedItem)");
		appendln(realSb, "  {");
		appendln(realSb, "    $file=fopen({0}TraceLog.txt{1},{3}a{4}) or exit({5}Unable to open file!{6});",'"','"','"','"','"','"','"');
		appendln(realSb, "    fprintf($file,{0}Traced object value: $tracedItem{1}.PHP_EOL);",'"','"');
		appendln(realSb, "    fprintf($file,{0}Trace time: {1}.date(DATE_RFC822).PHP_EOL);",'"','"');
		appendln(realSb, "    fclose($file);");
		appendln(realSb, "  }");
	}
}


    realSb.append(TEXT_1662);

    if(numSpaces > 0) {
        newCode.replace(0, newCode.length(), Pattern.compile(NL).matcher(newCode).replaceAll(NL + spaces));
        sb.append(newCode);
    }
    return sb; 
  }

  public String getCode(UmpleModel model, UmpleElement uElement){
        StringBuilder sb = new StringBuilder();
    return this._getCode(0,sb,model,uElement).toString(); 
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}