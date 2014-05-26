package cruise.umple.compiler.ruby;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class RubyClassGenerator implements ILang 
{

  protected static String nl;
  public static synchronized RubyClassGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    RubyClassGenerator result = new RubyClassGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "# PLEASE DO NOT EDIT THIS CODE" + NL + "# This code was generated using the UMPLE 1.20.1.4071 modeling language!" + NL + "# NOTE: Ruby generator is experimental and is missing some features available in" + NL + "# in other Umple generated languages like Java or PHP";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "class ";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + "  #------------------------" + NL + "  # CONSTRUCTOR" + NL + "  #------------------------" + NL;
  protected final String TEXT_9 = NL + "    @";
  protected final String TEXT_10 = " = []";
  protected final String TEXT_11 = NL + "    ";
  protected final String TEXT_12 = NL + "    @";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = NL + "    @";
  protected final String TEXT_15 = " = true";
  protected final String TEXT_16 = NL + "    @";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = NL + "    @";
  protected final String TEXT_19 = " = false";
  protected final String TEXT_20 = NL + "    @";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = NL + "    @";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = NL + "    @";
  protected final String TEXT_25 = " = @@";
  protected final String TEXT_26 = NL + "    @@";
  protected final String TEXT_27 = " += 1";
  protected final String TEXT_28 = NL + "    @";
  protected final String TEXT_29 = " = nil" + NL + "    if (!";
  protected final String TEXT_30 = "(";
  protected final String TEXT_31 = "))" + NL + "      raise ArgumentError, 'Cannot create due to duplicate ";
  protected final String TEXT_32 = "'" + NL + "    end";
  protected final String TEXT_33 = NL + "    unless ";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = ")" + NL + "      raise \"Unable to create ";
  protected final String TEXT_36 = " due to ";
  protected final String TEXT_37 = "\" " + NL + "    end";
  protected final String TEXT_38 = NL + "    ";
  protected final String TEXT_39 = "(";
  protected final String TEXT_40 = ")";
  protected final String TEXT_41 = NL + "    @";
  protected final String TEXT_42 = " = []";
  protected final String TEXT_43 = NL + "    ";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_47 = ", must have ";
  protected final String TEXT_48 = " @";
  protected final String TEXT_49 = "\" unless ";
  protected final String TEXT_50 = " ";
  protected final String TEXT_51 = NL + "    @";
  protected final String TEXT_52 = " = []";
  protected final String TEXT_53 = NL + "    ";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = "(";
  protected final String TEXT_56 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_57 = ", must have ";
  protected final String TEXT_58 = " or fewer @";
  protected final String TEXT_59 = ", no duplicates\" unless ";
  protected final String TEXT_60 = NL + "    @";
  protected final String TEXT_61 = " = []";
  protected final String TEXT_62 = NL + "    ";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = "(";
  protected final String TEXT_65 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_66 = ", must not have duplicate @";
  protected final String TEXT_67 = "\" unless ";
  protected final String TEXT_68 = NL + "    @";
  protected final String TEXT_69 = " = []";
  protected final String TEXT_70 = NL + "    @";
  protected final String TEXT_71 = " = nil";
  protected final String TEXT_72 = NL + "    @";
  protected final String TEXT_73 = " = nil" + NL + "    unless ";
  protected final String TEXT_74 = ".nil?" + NL + "      @";
  protected final String TEXT_75 = " = ";
  protected final String TEXT_76 = NL + "      ";
  protected final String TEXT_77 = ".instance_variable_set(\"@";
  protected final String TEXT_78 = "\",self)" + NL + "    end";
  protected final String TEXT_79 = NL + "    @";
  protected final String TEXT_80 = " = []";
  protected final String TEXT_81 = NL + "    @";
  protected final String TEXT_82 = " = nil";
  protected final String TEXT_83 = NL + "    ";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = "(";
  protected final String TEXT_86 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_87 = " due to @";
  protected final String TEXT_88 = "\" unless ";
  protected final String TEXT_89 = NL + "    @";
  protected final String TEXT_90 = " = []";
  protected final String TEXT_91 = NL + "    ";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = "(";
  protected final String TEXT_94 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_95 = ", must have ";
  protected final String TEXT_96 = " @";
  protected final String TEXT_97 = "\" unless ";
  protected final String TEXT_98 = " ";
  protected final String TEXT_99 = "@";
  protected final String TEXT_100 = " = []" + NL + "    @";
  protected final String TEXT_101 = " << ";
  protected final String TEXT_102 = NL + "    ";
  protected final String TEXT_103 = "(";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = ")";
  protected final String TEXT_106 = NL + "    ";
  protected final String TEXT_107 = "(";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = ")  if ";
  protected final String TEXT_110 = ".nil?";
  protected final String TEXT_111 = NL;
  protected final String TEXT_112 = NL + "  #------------------------" + NL + "  # INTERFACE" + NL + "  #------------------------" + NL;
  protected final String TEXT_113 = NL + "  def ";
  protected final String TEXT_114 = "(";
  protected final String TEXT_115 = ")" + NL + "    was_set = false";
  protected final String TEXT_116 = NL + "    @";
  protected final String TEXT_117 = " = false" + NL + "    @";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = NL + "    was_set = true";
  protected final String TEXT_120 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_121 = NL + "  def ";
  protected final String TEXT_122 = "(";
  protected final String TEXT_123 = ")" + NL + "    was_set = false";
  protected final String TEXT_124 = NL + "    @";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = NL + "    was_set = true";
  protected final String TEXT_127 = NL + "    was_set" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_128 = NL + "    wasReset = false";
  protected final String TEXT_129 = NL + "    @";
  protected final String TEXT_130 = " = ";
  protected final String TEXT_131 = NL + "    wasReset = true";
  protected final String TEXT_132 = NL + "    wasReset" + NL + "  end" + NL;
  protected final String TEXT_133 = NL + "  def ";
  protected final String TEXT_134 = "(";
  protected final String TEXT_135 = ")" + NL + "    was_added = false";
  protected final String TEXT_136 = NL + "    was_added = ";
  protected final String TEXT_137 = " << ";
  protected final String TEXT_138 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_139 = "(";
  protected final String TEXT_140 = ")" + NL + "    was_removed = false";
  protected final String TEXT_141 = NL + "    was_removed = ";
  protected final String TEXT_142 = ".delete(";
  protected final String TEXT_143 = ")";
  protected final String TEXT_144 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_145 = NL + "  def ";
  protected final String TEXT_146 = "(";
  protected final String TEXT_147 = ")" + NL + "    was_set = false";
  protected final String TEXT_148 = NL + "    @";
  protected final String TEXT_149 = " = ";
  protected final String TEXT_150 = NL + "    was_set = true";
  protected final String TEXT_151 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_152 = NL + "  def ";
  protected final String TEXT_153 = "(index)";
  protected final String TEXT_154 = NL + "    ";
  protected final String TEXT_155 = " = ";
  protected final String TEXT_156 = "[index]";
  protected final String TEXT_157 = NL + "    ";
  protected final String TEXT_158 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_159 = NL + "    ";
  protected final String TEXT_160 = "[] ";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = ".toArray(new ";
  protected final String TEXT_163 = "[";
  protected final String TEXT_164 = ".size])";
  protected final String TEXT_165 = NL + "    ";
  protected final String TEXT_166 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_167 = NL + "    number = ";
  protected final String TEXT_168 = ".size";
  protected final String TEXT_169 = NL + "    number;" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_170 = NL + "    has = ";
  protected final String TEXT_171 = ".size > 0";
  protected final String TEXT_172 = NL + "    has" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_173 = "(";
  protected final String TEXT_174 = ")";
  protected final String TEXT_175 = NL + "    index = ";
  protected final String TEXT_176 = ".index(";
  protected final String TEXT_177 = ")" + NL + "    index = -1 if index.nil?";
  protected final String TEXT_178 = NL + "    index" + NL + "  end" + NL;
  protected final String TEXT_179 = NL + "  def ";
  protected final String TEXT_180 = NL + "    ";
  protected final String TEXT_181 = " = ";
  protected final String TEXT_182 = NL + "    ";
  protected final String TEXT_183 = NL + "  end";
  protected final String TEXT_184 = NL + "  def ";
  protected final String TEXT_185 = NL + "    ";
  protected final String TEXT_186 = NL + "  end";
  protected final String TEXT_187 = NL + "  def ";
  protected final String TEXT_188 = NL + "    ";
  protected final String TEXT_189 = " = @";
  protected final String TEXT_190 = NL + "    ";
  protected final String TEXT_191 = NL + "  end";
  protected final String TEXT_192 = NL + "  def ";
  protected final String TEXT_193 = NL + "    @";
  protected final String TEXT_194 = NL + "  end";
  protected final String TEXT_195 = NL + "  def ";
  protected final String TEXT_196 = NL + "    ";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = NL + "    ";
  protected final String TEXT_199 = NL + "  end" + NL;
  protected final String TEXT_200 = NL + "  def ";
  protected final String TEXT_201 = NL + "    ";
  protected final String TEXT_202 = NL + "  end" + NL;
  protected final String TEXT_203 = NL + "  def ";
  protected final String TEXT_204 = "::";
  protected final String TEXT_205 = "($";
  protected final String TEXT_206 = ")";
  protected final String TEXT_207 = NL + "    ";
  protected final String TEXT_208 = " = @";
  protected final String TEXT_209 = "[";
  protected final String TEXT_210 = "]";
  protected final String TEXT_211 = NL;
  protected final String TEXT_212 = "    ";
  protected final String TEXT_213 = NL + "  end";
  protected final String TEXT_214 = NL + "  def ";
  protected final String TEXT_215 = "::";
  protected final String TEXT_216 = "(";
  protected final String TEXT_217 = ")";
  protected final String TEXT_218 = NL;
  protected final String TEXT_219 = "    @";
  protected final String TEXT_220 = "[";
  protected final String TEXT_221 = "]" + NL + "  end";
  protected final String TEXT_222 = NL + "  def ";
  protected final String TEXT_223 = "::";
  protected final String TEXT_224 = "?(";
  protected final String TEXT_225 = ")";
  protected final String TEXT_226 = NL + "    ";
  protected final String TEXT_227 = " = ";
  protected final String TEXT_228 = "(";
  protected final String TEXT_229 = ") != null;";
  protected final String TEXT_230 = NL;
  protected final String TEXT_231 = "    ";
  protected final String TEXT_232 = NL + "  end";
  protected final String TEXT_233 = NL + "  def ";
  protected final String TEXT_234 = "::";
  protected final String TEXT_235 = "?(";
  protected final String TEXT_236 = ")";
  protected final String TEXT_237 = NL;
  protected final String TEXT_238 = "    ";
  protected final String TEXT_239 = "(";
  protected final String TEXT_240 = ") != nil" + NL + "  end";
  protected final String TEXT_241 = NL + "  def ";
  protected final String TEXT_242 = NL + "    ";
  protected final String TEXT_243 = " = @";
  protected final String TEXT_244 = NL + "    ";
  protected final String TEXT_245 = NL + "  end";
  protected final String TEXT_246 = NL + "  def ";
  protected final String TEXT_247 = NL + "    @";
  protected final String TEXT_248 = NL + "  end";
  protected final String TEXT_249 = NL + "  def ";
  protected final String TEXT_250 = "?";
  protected final String TEXT_251 = NL + "    ";
  protected final String TEXT_252 = " = ";
  protected final String TEXT_253 = NL + "    ";
  protected final String TEXT_254 = NL + "  end";
  protected final String TEXT_255 = NL + "  def ";
  protected final String TEXT_256 = "?";
  protected final String TEXT_257 = NL + "    @";
  protected final String TEXT_258 = NL + "  end";
  protected final String TEXT_259 = NL + "  def ";
  protected final String TEXT_260 = "?";
  protected final String TEXT_261 = NL + "    ";
  protected final String TEXT_262 = " = @";
  protected final String TEXT_263 = NL + "    ";
  protected final String TEXT_264 = NL + "  end";
  protected final String TEXT_265 = NL + "  def ";
  protected final String TEXT_266 = "?";
  protected final String TEXT_267 = NL + "    @";
  protected final String TEXT_268 = NL + "  end";
  protected final String TEXT_269 = NL + "  public ";
  protected final String TEXT_270 = " ";
  protected final String TEXT_271 = NL + "    ";
  protected final String TEXT_272 = NL + "  end" + NL;
  protected final String TEXT_273 = NL + "  def ";
  protected final String TEXT_274 = NL + "  {" + NL + "    wasEventProcessed = false;" + NL;
  protected final String TEXT_275 = NL + "    ";
  protected final String TEXT_276 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_277 = NL + "  def ";
  protected final String TEXT_278 = "(";
  protected final String TEXT_279 = " ";
  protected final String TEXT_280 = ")" + NL + "  {";
  protected final String TEXT_281 = NL + "    ";
  protected final String TEXT_282 = " = ";
  protected final String TEXT_283 = NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_284 = NL + "  def ";
  protected final String TEXT_285 = NL + "    switch(";
  protected final String TEXT_286 = ")";
  protected final String TEXT_287 = NL + "      ";
  protected final String TEXT_288 = NL + "    end" + NL + "  end" + NL;
  protected final String TEXT_289 = NL + "  private void ";
  protected final String TEXT_290 = "(";
  protected final String TEXT_291 = " ";
  protected final String TEXT_292 = ")" + NL + "  {";
  protected final String TEXT_293 = NL + "    ";
  protected final String TEXT_294 = " = ";
  protected final String TEXT_295 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_296 = ")" + NL + "    {";
  protected final String TEXT_297 = NL + "      ";
  protected final String TEXT_298 = NL + "    }";
  protected final String TEXT_299 = NL + "  }" + NL;
  protected final String TEXT_300 = NL + "  def ";
  protected final String TEXT_301 = NL + "    @";
  protected final String TEXT_302 = NL + "    ";
  protected final String TEXT_303 = " = @";
  protected final String TEXT_304 = NL + "    ";
  protected final String TEXT_305 = NL + "  end";
  protected final String TEXT_306 = NL + NL + "  def ";
  protected final String TEXT_307 = NL + "    has = !@";
  protected final String TEXT_308 = ".nil?" + NL + "    has" + NL + "  end";
  protected final String TEXT_309 = NL;
  protected final String TEXT_310 = NL + "  def ";
  protected final String TEXT_311 = "(index)";
  protected final String TEXT_312 = NL + "    ";
  protected final String TEXT_313 = " = @";
  protected final String TEXT_314 = "[index]";
  protected final String TEXT_315 = NL + "    ";
  protected final String TEXT_316 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_317 = NL + "    ";
  protected final String TEXT_318 = " = @";
  protected final String TEXT_319 = ".dup";
  protected final String TEXT_320 = NL + "    ";
  protected final String TEXT_321 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_322 = NL + "    number = @";
  protected final String TEXT_323 = ".size";
  protected final String TEXT_324 = NL + "    number" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_325 = NL + "    has = @";
  protected final String TEXT_326 = ".size > 0";
  protected final String TEXT_327 = NL + "    has" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_328 = "(";
  protected final String TEXT_329 = ")";
  protected final String TEXT_330 = NL + "    index = @";
  protected final String TEXT_331 = ".index(";
  protected final String TEXT_332 = ")" + NL + "    index = -1 if index.nil?";
  protected final String TEXT_333 = NL + "    index" + NL + "  end" + NL;
  protected final String TEXT_334 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_335 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_336 = " : ";
  protected final String TEXT_337 = NL + "  def ";
  protected final String TEXT_338 = NL + "    is_valid = ";
  protected final String TEXT_339 = " >= ";
  protected final String TEXT_340 = ".";
  protected final String TEXT_341 = NL + "    is_valid = ";
  protected final String TEXT_342 = " >= ";
  protected final String TEXT_343 = ".";
  protected final String TEXT_344 = " and ";
  protected final String TEXT_345 = " <= ";
  protected final String TEXT_346 = ".";
  protected final String TEXT_347 = NL + "    is_valid" + NL + "  end";
  protected final String TEXT_348 = NL + "  def self.";
  protected final String TEXT_349 = NL + "    ";
  protected final String TEXT_350 = NL + "  end";
  protected final String TEXT_351 = NL + "  def self.";
  protected final String TEXT_352 = NL + "    minimum = ";
  protected final String TEXT_353 = NL + "    minimum" + NL + "  end";
  protected final String TEXT_354 = NL + "  def self.";
  protected final String TEXT_355 = NL + "    ";
  protected final String TEXT_356 = NL + "  end";
  protected final String TEXT_357 = NL + "  def self.";
  protected final String TEXT_358 = NL + "    minimum = ";
  protected final String TEXT_359 = NL + "    minimum" + NL + "  end";
  protected final String TEXT_360 = NL + "  def self.";
  protected final String TEXT_361 = NL + "    ";
  protected final String TEXT_362 = NL + "  end";
  protected final String TEXT_363 = NL + "  def self.";
  protected final String TEXT_364 = NL + "    maximum = ";
  protected final String TEXT_365 = NL + "    maximum" + NL + "  end";
  protected final String TEXT_366 = NL + "  def ";
  protected final String TEXT_367 = "(";
  protected final String TEXT_368 = ")" + NL + "    was_added = false";
  protected final String TEXT_369 = NL + "    if ";
  protected final String TEXT_370 = " >= ";
  protected final String TEXT_371 = ".";
  protected final String TEXT_372 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_373 = NL + "    @";
  protected final String TEXT_374 = " << ";
  protected final String TEXT_375 = NL + "    if ";
  protected final String TEXT_376 = ".";
  protected final String TEXT_377 = "(self) != -1" + NL + "      was_added = true" + NL + "    else" + NL + "      was_added = ";
  protected final String TEXT_378 = ".";
  protected final String TEXT_379 = "(self)" + NL + "      unless was_added" + NL + "        @";
  protected final String TEXT_380 = ".delete(";
  protected final String TEXT_381 = ")" + NL + "      end" + NL + "    end";
  protected final String TEXT_382 = NL + "    was_added" + NL + "  end";
  protected final String TEXT_383 = NL + "  def ";
  protected final String TEXT_384 = "(";
  protected final String TEXT_385 = ")" + NL + "    was_removed = false";
  protected final String TEXT_386 = NL + "    unless @";
  protected final String TEXT_387 = ".include?(";
  protected final String TEXT_388 = ")";
  protected final String TEXT_389 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_390 = ".index(";
  protected final String TEXT_391 = ")" + NL + "    @";
  protected final String TEXT_392 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_393 = ".";
  protected final String TEXT_394 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_395 = ".";
  protected final String TEXT_396 = "(self)" + NL + "      @";
  protected final String TEXT_397 = ".insert(oldIndex,";
  protected final String TEXT_398 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_399 = NL + "    was_removed" + NL + "  end";
  protected final String TEXT_400 = NL + "  def ";
  protected final String TEXT_401 = "(";
  protected final String TEXT_402 = ")" + NL + "    was_set = false";
  protected final String TEXT_403 = NL + "    @";
  protected final String TEXT_404 = " = ";
  protected final String TEXT_405 = NL + "    was_set = true";
  protected final String TEXT_406 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_407 = NL + "  def ";
  protected final String TEXT_408 = "(";
  protected final String TEXT_409 = ")" + NL + "    was_set = false";
  protected final String TEXT_410 = NL + "    unless ";
  protected final String TEXT_411 = ".nil?" + NL + "      @";
  protected final String TEXT_412 = " = ";
  protected final String TEXT_413 = NL + "      was_set = true" + NL + "    end";
  protected final String TEXT_414 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_415 = NL + "  def ";
  protected final String TEXT_416 = "(";
  protected final String TEXT_417 = ")" + NL + "    was_set = false";
  protected final String TEXT_418 = NL + "    if !@";
  protected final String TEXT_419 = ".nil? and !@";
  protected final String TEXT_420 = ".eql?(";
  protected final String TEXT_421 = ") and self.eql?(@";
  protected final String TEXT_422 = ".";
  protected final String TEXT_423 = ")" + NL + "      #Unable to ";
  protected final String TEXT_424 = ", as existing @";
  protected final String TEXT_425 = " would become an orphan";
  protected final String TEXT_426 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_427 = " = ";
  protected final String TEXT_428 = NL + "    ";
  protected final String TEXT_429 = " = !";
  protected final String TEXT_430 = ".nil? ? ";
  protected final String TEXT_431 = ".";
  protected final String TEXT_432 = " : nil" + NL + "" + NL + "    unless self.eql?(";
  protected final String TEXT_433 = ")" + NL + "      unless ";
  protected final String TEXT_434 = ".nil?";
  protected final String TEXT_435 = NL + "        ";
  protected final String TEXT_436 = ".instance_variable_set(\"@";
  protected final String TEXT_437 = "\",nil)" + NL + "      end" + NL + "      unless @";
  protected final String TEXT_438 = ".nil?" + NL + "        @";
  protected final String TEXT_439 = ".";
  protected final String TEXT_440 = "(self)" + NL + "      end" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_441 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_442 = NL + "  def ";
  protected final String TEXT_443 = "(";
  protected final String TEXT_444 = ")" + NL + "    was_set = false";
  protected final String TEXT_445 = NL + "    if ";
  protected final String TEXT_446 = ".nil?" + NL + "      #Unable to ";
  protected final String TEXT_447 = " to nil, as ";
  protected final String TEXT_448 = " must always be associated to a @";
  protected final String TEXT_449 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_450 = NL + "    ";
  protected final String TEXT_451 = " = ";
  protected final String TEXT_452 = ".";
  protected final String TEXT_453 = NL + "    if !";
  protected final String TEXT_454 = ".nil? and !self.eql?(";
  protected final String TEXT_455 = ")" + NL + "      #Unable to ";
  protected final String TEXT_456 = ", the current @";
  protected final String TEXT_457 = " already has a ";
  protected final String TEXT_458 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_459 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_460 = NL + "    ";
  protected final String TEXT_461 = " = @";
  protected final String TEXT_462 = NL + "    @";
  protected final String TEXT_463 = " = ";
  protected final String TEXT_464 = NL + "    @";
  protected final String TEXT_465 = ".";
  protected final String TEXT_466 = "(self)" + NL + "" + NL + "    unless ";
  protected final String TEXT_467 = ".nil?";
  protected final String TEXT_468 = NL + "      ";
  protected final String TEXT_469 = ".";
  protected final String TEXT_470 = "(nil)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_471 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_472 = NL + "  def ";
  protected final String TEXT_473 = "(";
  protected final String TEXT_474 = ")" + NL + "    was_added = false";
  protected final String TEXT_475 = NL + "    ";
  protected final String TEXT_476 = " = ";
  protected final String TEXT_477 = ".";
  protected final String TEXT_478 = NL + "    ";
  protected final String TEXT_479 = " = (!";
  protected final String TEXT_480 = ".nil? and !";
  protected final String TEXT_481 = ".eql?(self))" + NL + "" + NL + "    if ";
  protected final String TEXT_482 = " and ";
  protected final String TEXT_483 = ".";
  protected final String TEXT_484 = " <= ";
  protected final String TEXT_485 = ".";
  protected final String TEXT_486 = NL + "      return was_added" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_487 = NL + "      ";
  protected final String TEXT_488 = ".";
  protected final String TEXT_489 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_490 = " << ";
  protected final String TEXT_491 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_492 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_493 = "(";
  protected final String TEXT_494 = ")" + NL + "    was_removed = false";
  protected final String TEXT_495 = NL + "    # Unable to remove ";
  protected final String TEXT_496 = ", as it must always have a ";
  protected final String TEXT_497 = NL + "    if ";
  protected final String TEXT_498 = ".";
  protected final String TEXT_499 = ".eql?(self)";
  protected final String TEXT_500 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    # ";
  protected final String TEXT_501 = " already at minimum (";
  protected final String TEXT_502 = ")" + NL + "    if ";
  protected final String TEXT_503 = " <= ";
  protected final String TEXT_504 = ".";
  protected final String TEXT_505 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_506 = ".delete(";
  protected final String TEXT_507 = ")" + NL + "    was_removed = true";
  protected final String TEXT_508 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_509 = NL + "  def ";
  protected final String TEXT_510 = "(";
  protected final String TEXT_511 = ")" + NL + "    was_added = false";
  protected final String TEXT_512 = NL + "    if ";
  protected final String TEXT_513 = " >= ";
  protected final String TEXT_514 = ".";
  protected final String TEXT_515 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_516 = NL + "    ";
  protected final String TEXT_517 = " = ";
  protected final String TEXT_518 = ".";
  protected final String TEXT_519 = NL + "    ";
  protected final String TEXT_520 = " = (!";
  protected final String TEXT_521 = ".nil? and !";
  protected final String TEXT_522 = ".eql?(self))" + NL + "" + NL + "    if ";
  protected final String TEXT_523 = " and ";
  protected final String TEXT_524 = ".";
  protected final String TEXT_525 = " <= ";
  protected final String TEXT_526 = ".";
  protected final String TEXT_527 = NL + "      return was_added" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_528 = NL + "      ";
  protected final String TEXT_529 = ".";
  protected final String TEXT_530 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_531 = " << ";
  protected final String TEXT_532 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_533 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_534 = "(";
  protected final String TEXT_535 = ")" + NL + "    was_removed = false";
  protected final String TEXT_536 = NL + "    # Unable to remove ";
  protected final String TEXT_537 = ", as it must always have a ";
  protected final String TEXT_538 = NL + "    if ";
  protected final String TEXT_539 = ".";
  protected final String TEXT_540 = ".eql?(self)";
  protected final String TEXT_541 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    # ";
  protected final String TEXT_542 = " already at minimum (";
  protected final String TEXT_543 = ")" + NL + "    if ";
  protected final String TEXT_544 = " <= ";
  protected final String TEXT_545 = ".";
  protected final String TEXT_546 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_547 = ".delete(";
  protected final String TEXT_548 = ")" + NL + "    was_removed = true";
  protected final String TEXT_549 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_550 = NL + "  def ";
  protected final String TEXT_551 = "(";
  protected final String TEXT_552 = ")" + NL + "    was_added = false";
  protected final String TEXT_553 = NL + "    if ";
  protected final String TEXT_554 = " >= ";
  protected final String TEXT_555 = ".";
  protected final String TEXT_556 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_557 = NL + "    ";
  protected final String TEXT_558 = " = ";
  protected final String TEXT_559 = ".";
  protected final String TEXT_560 = NL + "    ";
  protected final String TEXT_561 = " = (!";
  protected final String TEXT_562 = ".nil? and !";
  protected final String TEXT_563 = ".eql?(self))" + NL + "    if ";
  protected final String TEXT_564 = NL + "      ";
  protected final String TEXT_565 = ".";
  protected final String TEXT_566 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_567 = " << ";
  protected final String TEXT_568 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_569 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_570 = "(";
  protected final String TEXT_571 = ")" + NL + "    was_removed = false";
  protected final String TEXT_572 = NL + "    # Unable to remove ";
  protected final String TEXT_573 = ", as it must always have a ";
  protected final String TEXT_574 = NL + "    unless ";
  protected final String TEXT_575 = ".";
  protected final String TEXT_576 = ".eql?(self)" + NL + "      @";
  protected final String TEXT_577 = ".delete(";
  protected final String TEXT_578 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_579 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_580 = NL + "  def ";
  protected final String TEXT_581 = "(";
  protected final String TEXT_582 = ")" + NL + "    was_set = false";
  protected final String TEXT_583 = NL + "    ";
  protected final String TEXT_584 = " = []";
  protected final String TEXT_585 = NL + "    ";
  protected final String TEXT_586 = ".each do |";
  protected final String TEXT_587 = "|" + NL + "      next if (";
  protected final String TEXT_588 = ".include?(";
  protected final String TEXT_589 = "))";
  protected final String TEXT_590 = NL + "      ";
  protected final String TEXT_591 = " << ";
  protected final String TEXT_592 = NL + "    end" + NL + "" + NL + "    if (";
  protected final String TEXT_593 = ".size != ";
  protected final String TEXT_594 = ".size or ";
  protected final String TEXT_595 = ".size() > ";
  protected final String TEXT_596 = ".";
  protected final String TEXT_597 = ")";
  protected final String TEXT_598 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_599 = NL + "    ";
  protected final String TEXT_600 = " = @";
  protected final String TEXT_601 = ".dup" + NL + "    @";
  protected final String TEXT_602 = ".clear";
  protected final String TEXT_603 = NL + "    ";
  protected final String TEXT_604 = ".each do |";
  protected final String TEXT_605 = "|" + NL + "      @";
  protected final String TEXT_606 = " << ";
  protected final String TEXT_607 = NL + "      if (";
  protected final String TEXT_608 = ".include?(";
  protected final String TEXT_609 = "))";
  protected final String TEXT_610 = NL + "        ";
  protected final String TEXT_611 = ".delete(";
  protected final String TEXT_612 = ")" + NL + "      else";
  protected final String TEXT_613 = NL + "        ";
  protected final String TEXT_614 = ".";
  protected final String TEXT_615 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_616 = NL + "    ";
  protected final String TEXT_617 = ".each do |";
  protected final String TEXT_618 = "|";
  protected final String TEXT_619 = NL + "      ";
  protected final String TEXT_620 = ".";
  protected final String TEXT_621 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_622 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_623 = NL + "  def ";
  protected final String TEXT_624 = "(";
  protected final String TEXT_625 = ")" + NL + "    was_added = false";
  protected final String TEXT_626 = NL + "    ";
  protected final String TEXT_627 = " = ";
  protected final String TEXT_628 = ".";
  protected final String TEXT_629 = NL + "    ";
  protected final String TEXT_630 = " = (!";
  protected final String TEXT_631 = ".nil? and !";
  protected final String TEXT_632 = ".eql?(self))" + NL + "    if ";
  protected final String TEXT_633 = NL + "      ";
  protected final String TEXT_634 = ".";
  protected final String TEXT_635 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_636 = " << ";
  protected final String TEXT_637 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_638 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_639 = "(";
  protected final String TEXT_640 = ")" + NL + "    was_removed = false";
  protected final String TEXT_641 = NL + "    # Unable to remove ";
  protected final String TEXT_642 = ", as it must always have a ";
  protected final String TEXT_643 = NL + "    unless ";
  protected final String TEXT_644 = ".";
  protected final String TEXT_645 = ".eql?(self)" + NL + "      @";
  protected final String TEXT_646 = ".delete(";
  protected final String TEXT_647 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_648 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_649 = NL + "  def ";
  protected final String TEXT_650 = "(";
  protected final String TEXT_651 = ")" + NL + "    was_set = false";
  protected final String TEXT_652 = NL + "    if ";
  protected final String TEXT_653 = ".nil?";
  protected final String TEXT_654 = NL + "      ";
  protected final String TEXT_655 = " = @";
  protected final String TEXT_656 = NL + "      @";
  protected final String TEXT_657 = " = nil" + NL + "      " + NL + "      if !";
  protected final String TEXT_658 = ".nil? and !";
  protected final String TEXT_659 = ".";
  protected final String TEXT_660 = ".nil?";
  protected final String TEXT_661 = NL + "        ";
  protected final String TEXT_662 = ".";
  protected final String TEXT_663 = "(nil)" + NL + "      end" + NL + "      was_set = true";
  protected final String TEXT_664 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_665 = NL + "    ";
  protected final String TEXT_666 = " = self.";
  protected final String TEXT_667 = NL + "    if !";
  protected final String TEXT_668 = ".nil? and !";
  protected final String TEXT_669 = ".eql?(";
  protected final String TEXT_670 = ")";
  protected final String TEXT_671 = NL + "      ";
  protected final String TEXT_672 = ".";
  protected final String TEXT_673 = "(nil)" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_674 = " = ";
  protected final String TEXT_675 = NL + "    ";
  protected final String TEXT_676 = " = ";
  protected final String TEXT_677 = ".";
  protected final String TEXT_678 = NL + NL + "    unless self.eql?(";
  protected final String TEXT_679 = ")";
  protected final String TEXT_680 = NL + "      ";
  protected final String TEXT_681 = ".";
  protected final String TEXT_682 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_683 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_684 = NL + "  def ";
  protected final String TEXT_685 = "(";
  protected final String TEXT_686 = ")" + NL + "    was_removed = false";
  protected final String TEXT_687 = NL + "    unless @";
  protected final String TEXT_688 = ".include?(";
  protected final String TEXT_689 = ")";
  protected final String TEXT_690 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_691 = " <= ";
  protected final String TEXT_692 = ".";
  protected final String TEXT_693 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_694 = ".index(";
  protected final String TEXT_695 = ")" + NL + "    @";
  protected final String TEXT_696 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_697 = ".";
  protected final String TEXT_698 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_699 = ".";
  protected final String TEXT_700 = "(self)" + NL + "      @";
  protected final String TEXT_701 = ".insert(oldIndex,";
  protected final String TEXT_702 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_703 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_704 = NL + "  def ";
  protected final String TEXT_705 = "(";
  protected final String TEXT_706 = ")" + NL + "    was_removed = false";
  protected final String TEXT_707 = NL + "    unless @";
  protected final String TEXT_708 = ".include?(";
  protected final String TEXT_709 = ")";
  protected final String TEXT_710 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_711 = " <= ";
  protected final String TEXT_712 = ".";
  protected final String TEXT_713 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_714 = ".index(";
  protected final String TEXT_715 = ")" + NL + "    @";
  protected final String TEXT_716 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_717 = ".";
  protected final String TEXT_718 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_719 = ".";
  protected final String TEXT_720 = "(self)" + NL + "      @";
  protected final String TEXT_721 = ".insert(oldIndex,";
  protected final String TEXT_722 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_723 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_724 = NL + "  def ";
  protected final String TEXT_725 = "(";
  protected final String TEXT_726 = ")" + NL + "    was_set = false";
  protected final String TEXT_727 = NL + "    if !";
  protected final String TEXT_728 = ".nil? and ";
  protected final String TEXT_729 = ".";
  protected final String TEXT_730 = " >= ";
  protected final String TEXT_731 = ".";
  protected final String TEXT_732 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_733 = NL + "    ";
  protected final String TEXT_734 = " = @";
  protected final String TEXT_735 = NL + "    @";
  protected final String TEXT_736 = " = ";
  protected final String TEXT_737 = NL + "    if !";
  protected final String TEXT_738 = ".nil? and !";
  protected final String TEXT_739 = ".eql?(";
  protected final String TEXT_740 = ")";
  protected final String TEXT_741 = NL + "      ";
  protected final String TEXT_742 = ".";
  protected final String TEXT_743 = "(self)" + NL + "    end" + NL + "    unless ";
  protected final String TEXT_744 = ".nil?";
  protected final String TEXT_745 = NL + "      ";
  protected final String TEXT_746 = ".";
  protected final String TEXT_747 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_748 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_749 = NL + "  def ";
  protected final String TEXT_750 = "(";
  protected final String TEXT_751 = ")" + NL + "    was_set = false";
  protected final String TEXT_752 = NL + "    if ";
  protected final String TEXT_753 = ".nil?";
  protected final String TEXT_754 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_755 = NL + "    ";
  protected final String TEXT_756 = " = @";
  protected final String TEXT_757 = NL + "    @";
  protected final String TEXT_758 = " = ";
  protected final String TEXT_759 = NL + "    if !";
  protected final String TEXT_760 = ".nil? and !";
  protected final String TEXT_761 = ".eql?(";
  protected final String TEXT_762 = ")";
  protected final String TEXT_763 = NL + "      ";
  protected final String TEXT_764 = ".";
  protected final String TEXT_765 = "(self)" + NL + "    end" + NL + "    @";
  protected final String TEXT_766 = ".";
  protected final String TEXT_767 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_768 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_769 = NL + "  def ";
  protected final String TEXT_770 = "(";
  protected final String TEXT_771 = ")" + NL + "    was_set = false";
  protected final String TEXT_772 = NL + "    # Must provide @";
  protected final String TEXT_773 = " to ";
  protected final String TEXT_774 = NL + "    if ";
  protected final String TEXT_775 = ".nil?";
  protected final String TEXT_776 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    # @";
  protected final String TEXT_777 = " already at maximum (";
  protected final String TEXT_778 = ")" + NL + "    if ";
  protected final String TEXT_779 = ".";
  protected final String TEXT_780 = " >= ";
  protected final String TEXT_781 = ".";
  protected final String TEXT_782 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_783 = NL + "    ";
  protected final String TEXT_784 = " = @";
  protected final String TEXT_785 = NL + "    @";
  protected final String TEXT_786 = " = ";
  protected final String TEXT_787 = NL + "    if !";
  protected final String TEXT_788 = ".nil? and !";
  protected final String TEXT_789 = ".eql?(";
  protected final String TEXT_790 = ")" + NL + "      didRemove = ";
  protected final String TEXT_791 = ".";
  protected final String TEXT_792 = "(self)" + NL + "      unless didRemove" + NL + "        @";
  protected final String TEXT_793 = " = ";
  protected final String TEXT_794 = NL + "        return was_set" + NL + "      end" + NL + "    end" + NL + "    @";
  protected final String TEXT_795 = ".";
  protected final String TEXT_796 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_797 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_798 = NL + "  def ";
  protected final String TEXT_799 = "(";
  protected final String TEXT_800 = ")" + NL + "    was_set = false";
  protected final String TEXT_801 = NL + "    # Must provide @";
  protected final String TEXT_802 = " to ";
  protected final String TEXT_803 = NL + "    if ";
  protected final String TEXT_804 = ".nil?";
  protected final String TEXT_805 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    if !@";
  protected final String TEXT_806 = ".nil? and @";
  protected final String TEXT_807 = ".";
  protected final String TEXT_808 = " <= ";
  protected final String TEXT_809 = ".";
  protected final String TEXT_810 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_811 = NL + "    ";
  protected final String TEXT_812 = " = @";
  protected final String TEXT_813 = NL + "    @";
  protected final String TEXT_814 = " = ";
  protected final String TEXT_815 = NL + "    if !";
  protected final String TEXT_816 = ".nil? and !";
  protected final String TEXT_817 = ".eql?(";
  protected final String TEXT_818 = ")" + NL + "      didRemove = ";
  protected final String TEXT_819 = ".";
  protected final String TEXT_820 = "(self)" + NL + "      unless didRemove" + NL + "        @";
  protected final String TEXT_821 = " = ";
  protected final String TEXT_822 = NL + "        return was_set" + NL + "      end" + NL + "    end" + NL + "    @";
  protected final String TEXT_823 = ".";
  protected final String TEXT_824 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_825 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_826 = NL + "  def ";
  protected final String TEXT_827 = "(";
  protected final String TEXT_828 = ")" + NL + "    was_added = false";
  protected final String TEXT_829 = NL + "    ";
  protected final String TEXT_830 = " = ";
  protected final String TEXT_831 = ".";
  protected final String TEXT_832 = NL + "    if ";
  protected final String TEXT_833 = ".nil?";
  protected final String TEXT_834 = NL + "      ";
  protected final String TEXT_835 = ".";
  protected final String TEXT_836 = "(self)" + NL + "    elsif !";
  protected final String TEXT_837 = ".eql?(self)";
  protected final String TEXT_838 = NL + "      ";
  protected final String TEXT_839 = ".";
  protected final String TEXT_840 = "(";
  protected final String TEXT_841 = ")";
  protected final String TEXT_842 = NL + "      ";
  protected final String TEXT_843 = "(";
  protected final String TEXT_844 = ")" + NL + "    else" + NL + "      @";
  protected final String TEXT_845 = " << ";
  protected final String TEXT_846 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_847 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_848 = "(";
  protected final String TEXT_849 = ")" + NL + "    was_removed = false";
  protected final String TEXT_850 = NL + "    if @";
  protected final String TEXT_851 = ".include?(";
  protected final String TEXT_852 = ")" + NL + "      @";
  protected final String TEXT_853 = ".delete(";
  protected final String TEXT_854 = ")";
  protected final String TEXT_855 = NL + "      ";
  protected final String TEXT_856 = ".";
  protected final String TEXT_857 = "(nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_858 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_859 = NL + "  def ";
  protected final String TEXT_860 = "(";
  protected final String TEXT_861 = ")" + NL + "    was_set = false";
  protected final String TEXT_862 = NL + "    ";
  protected final String TEXT_863 = " = @";
  protected final String TEXT_864 = NL + "    @";
  protected final String TEXT_865 = " = ";
  protected final String TEXT_866 = NL + "    if !";
  protected final String TEXT_867 = ".nil? and !";
  protected final String TEXT_868 = ".eql?(";
  protected final String TEXT_869 = ")";
  protected final String TEXT_870 = NL + "      ";
  protected final String TEXT_871 = ".";
  protected final String TEXT_872 = "(self)" + NL + "    end" + NL + "    unless ";
  protected final String TEXT_873 = ".nil?";
  protected final String TEXT_874 = NL + "      ";
  protected final String TEXT_875 = ".";
  protected final String TEXT_876 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_877 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_878 = NL + "  def ";
  protected final String TEXT_879 = "(";
  protected final String TEXT_880 = ")" + NL + "    was_added = false";
  protected final String TEXT_881 = NL + "    if ";
  protected final String TEXT_882 = " >= ";
  protected final String TEXT_883 = ".";
  protected final String TEXT_884 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_885 = NL + "    ";
  protected final String TEXT_886 = " = ";
  protected final String TEXT_887 = ".";
  protected final String TEXT_888 = NL + "    if ";
  protected final String TEXT_889 = ".nil?";
  protected final String TEXT_890 = NL + "      ";
  protected final String TEXT_891 = ".";
  protected final String TEXT_892 = "(self)" + NL + "    elsif !";
  protected final String TEXT_893 = ".eql?(self)";
  protected final String TEXT_894 = NL + "      ";
  protected final String TEXT_895 = ".";
  protected final String TEXT_896 = "(";
  protected final String TEXT_897 = ")";
  protected final String TEXT_898 = NL + "      ";
  protected final String TEXT_899 = "(";
  protected final String TEXT_900 = ")" + NL + "    else" + NL + "      @";
  protected final String TEXT_901 = " << ";
  protected final String TEXT_902 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_903 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_904 = "(";
  protected final String TEXT_905 = ")" + NL + "    was_removed = false";
  protected final String TEXT_906 = NL + "    if @";
  protected final String TEXT_907 = ".include?(";
  protected final String TEXT_908 = ")" + NL + "      @";
  protected final String TEXT_909 = ".delete(";
  protected final String TEXT_910 = ")";
  protected final String TEXT_911 = NL + "      ";
  protected final String TEXT_912 = ".";
  protected final String TEXT_913 = "(nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_914 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_915 = NL + "  def ";
  protected final String TEXT_916 = "(";
  protected final String TEXT_917 = ")" + NL + "    was_added = false";
  protected final String TEXT_918 = NL + "    if ";
  protected final String TEXT_919 = " < ";
  protected final String TEXT_920 = ".";
  protected final String TEXT_921 = NL + "      @";
  protected final String TEXT_922 = " << ";
  protected final String TEXT_923 = NL + "      was_added = true" + NL + "    end";
  protected final String TEXT_924 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_925 = "(";
  protected final String TEXT_926 = ")" + NL + "    was_removed = false";
  protected final String TEXT_927 = NL + "    unless @";
  protected final String TEXT_928 = ".include?(";
  protected final String TEXT_929 = ")";
  protected final String TEXT_930 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_931 = " <= ";
  protected final String TEXT_932 = ".";
  protected final String TEXT_933 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_934 = ".delete(";
  protected final String TEXT_935 = ")" + NL + "    was_removed = true";
  protected final String TEXT_936 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_937 = NL + "  def ";
  protected final String TEXT_938 = "(";
  protected final String TEXT_939 = ")" + NL + "    was_added = false";
  protected final String TEXT_940 = NL + "    if ";
  protected final String TEXT_941 = " >= ";
  protected final String TEXT_942 = ".";
  protected final String TEXT_943 = NL + "      return was_added" + NL + "    end";
  protected final String TEXT_944 = NL + "    ";
  protected final String TEXT_945 = " = ";
  protected final String TEXT_946 = ".";
  protected final String TEXT_947 = NL + "    if !";
  protected final String TEXT_948 = ".nil? and ";
  protected final String TEXT_949 = ".";
  protected final String TEXT_950 = " <= ";
  protected final String TEXT_951 = ".";
  protected final String TEXT_952 = NL + "      return was_added" + NL + "    elsif !";
  protected final String TEXT_953 = ".nil?";
  protected final String TEXT_954 = NL + "      ";
  protected final String TEXT_955 = ".instance_variable_get(\"@";
  protected final String TEXT_956 = "\").delete(";
  protected final String TEXT_957 = ")" + NL + "    end" + NL + "    @";
  protected final String TEXT_958 = " << ";
  protected final String TEXT_959 = NL + "    ";
  protected final String TEXT_960 = ".instance_variable_set(\"@";
  protected final String TEXT_961 = "\",self)" + NL + "    was_added = true";
  protected final String TEXT_962 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_963 = "(";
  protected final String TEXT_964 = ")" + NL + "    was_removed = false";
  protected final String TEXT_965 = NL + "    if @";
  protected final String TEXT_966 = ".include?(";
  protected final String TEXT_967 = ") and ";
  protected final String TEXT_968 = " > ";
  protected final String TEXT_969 = ".";
  protected final String TEXT_970 = NL + "      @";
  protected final String TEXT_971 = ".delete(";
  protected final String TEXT_972 = ")";
  protected final String TEXT_973 = NL + "      ";
  protected final String TEXT_974 = ".instance_variable_set(\"@";
  protected final String TEXT_975 = "\",nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_976 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_977 = NL + "  def ";
  protected final String TEXT_978 = "(";
  protected final String TEXT_979 = ")" + NL + "    was_set = false";
  protected final String TEXT_980 = NL + "    ";
  protected final String TEXT_981 = " = []";
  protected final String TEXT_982 = NL + "    ";
  protected final String TEXT_983 = ".each do |";
  protected final String TEXT_984 = "|" + NL + "      if ";
  protected final String TEXT_985 = ".include?(";
  protected final String TEXT_986 = ")";
  protected final String TEXT_987 = NL + "        return was_set" + NL + "      elsif !";
  protected final String TEXT_988 = ".";
  protected final String TEXT_989 = ".nil? and !";
  protected final String TEXT_990 = ".";
  protected final String TEXT_991 = ".eql?(self)";
  protected final String TEXT_992 = NL + "        return was_set" + NL + "      end";
  protected final String TEXT_993 = NL + "      ";
  protected final String TEXT_994 = " << ";
  protected final String TEXT_995 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_996 = ".size != ";
  protected final String TEXT_997 = ".";
  protected final String TEXT_998 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_999 = NL + "    ";
  protected final String TEXT_1000 = ".each do |";
  protected final String TEXT_1001 = "|" + NL + "      @";
  protected final String TEXT_1002 = ".delete(";
  protected final String TEXT_1003 = ")" + NL + "    end" + NL + "    " + NL + "    @";
  protected final String TEXT_1004 = ".each do |orphan|" + NL + "      orphan.instance_variable_set(\"@";
  protected final String TEXT_1005 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_1006 = ".clear";
  protected final String TEXT_1007 = NL + "    ";
  protected final String TEXT_1008 = ".each do |";
  protected final String TEXT_1009 = "|";
  protected final String TEXT_1010 = NL + "      ";
  protected final String TEXT_1011 = ".instance_variable_set(\"@";
  protected final String TEXT_1012 = "\",self)" + NL + "      @";
  protected final String TEXT_1013 = " << ";
  protected final String TEXT_1014 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1015 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1016 = NL + "  def ";
  protected final String TEXT_1017 = "(";
  protected final String TEXT_1018 = ")" + NL + "    was_added = false";
  protected final String TEXT_1019 = NL + "    @";
  protected final String TEXT_1020 = " << ";
  protected final String TEXT_1021 = NL + "    was_added = true";
  protected final String TEXT_1022 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1023 = "(";
  protected final String TEXT_1024 = ")" + NL + "    was_removed = false";
  protected final String TEXT_1025 = NL + "    if @";
  protected final String TEXT_1026 = ".include?(";
  protected final String TEXT_1027 = ")" + NL + "      @";
  protected final String TEXT_1028 = ".delete(";
  protected final String TEXT_1029 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_1030 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_1031 = NL + "  def ";
  protected final String TEXT_1032 = "(";
  protected final String TEXT_1033 = ")" + NL + "    was_added = false";
  protected final String TEXT_1034 = NL + "    if ";
  protected final String TEXT_1035 = " < ";
  protected final String TEXT_1036 = ".";
  protected final String TEXT_1037 = NL + "      @";
  protected final String TEXT_1038 = " << ";
  protected final String TEXT_1039 = NL + "      was_added = true" + NL + "    end";
  protected final String TEXT_1040 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1041 = "(";
  protected final String TEXT_1042 = ")" + NL + "    was_removed = false";
  protected final String TEXT_1043 = NL + "    if @";
  protected final String TEXT_1044 = ".include?(";
  protected final String TEXT_1045 = ")" + NL + "      @";
  protected final String TEXT_1046 = ".delete(";
  protected final String TEXT_1047 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_1048 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_1049 = NL + "  def ";
  protected final String TEXT_1050 = "(";
  protected final String TEXT_1051 = ")" + NL + "    was_added = false";
  protected final String TEXT_1052 = NL + "    @";
  protected final String TEXT_1053 = " << ";
  protected final String TEXT_1054 = NL + "    was_added = true";
  protected final String TEXT_1055 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1056 = "(";
  protected final String TEXT_1057 = ")" + NL + "    was_removed = false";
  protected final String TEXT_1058 = NL + "    unless @";
  protected final String TEXT_1059 = ".include?(";
  protected final String TEXT_1060 = ")";
  protected final String TEXT_1061 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1062 = " <= ";
  protected final String TEXT_1063 = ".";
  protected final String TEXT_1064 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1065 = ".delete(";
  protected final String TEXT_1066 = ")" + NL + "    was_removed = true";
  protected final String TEXT_1067 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_1068 = NL + "  def ";
  protected final String TEXT_1069 = "(";
  protected final String TEXT_1070 = ")" + NL + "    was_set = false";
  protected final String TEXT_1071 = NL + "    ";
  protected final String TEXT_1072 = " = []";
  protected final String TEXT_1073 = NL + "    ";
  protected final String TEXT_1074 = ".each do |";
  protected final String TEXT_1075 = "|" + NL + "      next if (";
  protected final String TEXT_1076 = ".include?(";
  protected final String TEXT_1077 = "))";
  protected final String TEXT_1078 = NL + "      ";
  protected final String TEXT_1079 = " << ";
  protected final String TEXT_1080 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1081 = ".size != ";
  protected final String TEXT_1082 = ".size or ";
  protected final String TEXT_1083 = ".size() != ";
  protected final String TEXT_1084 = ".";
  protected final String TEXT_1085 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1086 = ".clear";
  protected final String TEXT_1087 = NL + "    ";
  protected final String TEXT_1088 = ".each do |";
  protected final String TEXT_1089 = "|" + NL + "      @";
  protected final String TEXT_1090 = " << ";
  protected final String TEXT_1091 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1092 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1093 = NL + "  def ";
  protected final String TEXT_1094 = "(";
  protected final String TEXT_1095 = ")" + NL + "    was_set = false";
  protected final String TEXT_1096 = NL + "    ";
  protected final String TEXT_1097 = " = []";
  protected final String TEXT_1098 = NL + "    ";
  protected final String TEXT_1099 = ".each do |";
  protected final String TEXT_1100 = "|" + NL + "      next if (";
  protected final String TEXT_1101 = ".include?(";
  protected final String TEXT_1102 = "))";
  protected final String TEXT_1103 = NL + "      ";
  protected final String TEXT_1104 = " << ";
  protected final String TEXT_1105 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1106 = ".size != ";
  protected final String TEXT_1107 = ".size";
  protected final String TEXT_1108 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1109 = ".clear";
  protected final String TEXT_1110 = NL + "    ";
  protected final String TEXT_1111 = ".each do |";
  protected final String TEXT_1112 = "|" + NL + "      @";
  protected final String TEXT_1113 = " << ";
  protected final String TEXT_1114 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1115 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1116 = NL + "  def ";
  protected final String TEXT_1117 = "(";
  protected final String TEXT_1118 = ")" + NL + "    #" + NL + "    # self source of self source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    # self set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    # it's not required (No upper bound)" + NL + "    #   " + NL + "    " + NL + "    wasSet = false" + NL + "    ";
  protected final String TEXT_1119 = NL + "    ";
  protected final String TEXT_1120 = " = ";
  protected final String TEXT_1121 = ";" + NL + "\t" + NL + "    if ";
  protected final String TEXT_1122 = ".nil?" + NL + "      if !";
  protected final String TEXT_1123 = ".nil" + NL + "        if ";
  protected final String TEXT_1124 = ".";
  protected final String TEXT_1125 = "(self)";
  protected final String TEXT_1126 = NL + "          ";
  protected final String TEXT_1127 = " = ";
  protected final String TEXT_1128 = NL + "          wasSet = true" + NL + "        end" + NL + "      end" + NL + "    elsif ";
  protected final String TEXT_1129 = " != null" + NL + "      if ";
  protected final String TEXT_1130 = " == null" + NL + "        if ";
  protected final String TEXT_1131 = ".";
  protected final String TEXT_1132 = "() < ";
  protected final String TEXT_1133 = ".";
  protected final String TEXT_1134 = "()";
  protected final String TEXT_1135 = NL + "          ";
  protected final String TEXT_1136 = ".";
  protected final String TEXT_1137 = "(self);";
  protected final String TEXT_1138 = NL + "          ";
  protected final String TEXT_1139 = " = ";
  protected final String TEXT_1140 = ";  # ";
  protected final String TEXT_1141 = " == null" + NL + "          wasSet = true;" + NL + "        end" + NL + "      else" + NL + "        if ";
  protected final String TEXT_1142 = ".";
  protected final String TEXT_1143 = "() < ";
  protected final String TEXT_1144 = ".";
  protected final String TEXT_1145 = "()";
  protected final String TEXT_1146 = NL + "          ";
  protected final String TEXT_1147 = ".";
  protected final String TEXT_1148 = "(self);";
  protected final String TEXT_1149 = NL + "          ";
  protected final String TEXT_1150 = ".";
  protected final String TEXT_1151 = "(self);";
  protected final String TEXT_1152 = NL + "          ";
  protected final String TEXT_1153 = " = ";
  protected final String TEXT_1154 = ";" + NL + "          wasSet = true;" + NL + "        end" + NL + "      end" + NL + "    end" + NL + "    " + NL + "    if wasSet == true";
  protected final String TEXT_1155 = NL + "      ";
  protected final String TEXT_1156 = " = ";
  protected final String TEXT_1157 = ";" + NL + "    end" + NL + "    " + NL + "    return wasSet;" + NL + "  end" + NL + "  ";
  protected final String TEXT_1158 = NL + "#  def ";
  protected final String TEXT_1159 = NL + "#  " + NL + "#    #" + NL + "#    # The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "#    # (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "#    #   method ";
  protected final String TEXT_1160 = NL + "#    # Currently this will not compile due to Issue351 - the template code is fine." + NL + "#    #" + NL + "#    wasSet = false" + NL + "#" + NL + "#    ";
  protected final String TEXT_1161 = " = ";
  protected final String TEXT_1162 = NL + "#\t" + NL + "#    if ";
  protected final String TEXT_1163 = " == null" + NL + "#      if ";
  protected final String TEXT_1164 = " != null" + NL + "#        if ";
  protected final String TEXT_1165 = ".";
  protected final String TEXT_1166 = "(self)" + NL + "#          ";
  protected final String TEXT_1167 = " = ";
  protected final String TEXT_1168 = NL + "#          wasSet = true" + NL + "#        end" + NL + "#      end" + NL + "#    else if ";
  protected final String TEXT_1169 = " != null" + NL + "#      if ";
  protected final String TEXT_1170 = " == null" + NL + "#        if ";
  protected final String TEXT_1171 = ".";
  protected final String TEXT_1172 = " < ";
  protected final String TEXT_1173 = ".";
  protected final String TEXT_1174 = NL + "#          ";
  protected final String TEXT_1175 = ".";
  protected final String TEXT_1176 = "(self)" + NL + "#          ";
  protected final String TEXT_1177 = " = ";
  protected final String TEXT_1178 = "  # ";
  protected final String TEXT_1179 = " == null" + NL + "#          wasSet = true" + NL + "#        end" + NL + "#      else" + NL + "#        if     ";
  protected final String TEXT_1180 = ".";
  protected final String TEXT_1181 = " < ";
  protected final String TEXT_1182 = ".";
  protected final String TEXT_1183 = "()" + NL + "#            && ";
  protected final String TEXT_1184 = ".";
  protected final String TEXT_1185 = " > ";
  protected final String TEXT_1186 = ".";
  protected final String TEXT_1187 = "()" + NL + "#          ";
  protected final String TEXT_1188 = ".";
  protected final String TEXT_1189 = "(self)" + NL + "#          ";
  protected final String TEXT_1190 = ".";
  protected final String TEXT_1191 = "(self)" + NL + "#          ";
  protected final String TEXT_1192 = " = ";
  protected final String TEXT_1193 = NL + "#          wasSet = true" + NL + "#        end" + NL + "#      end" + NL + "#    end" + NL + "#    " + NL + "#    if wasSet" + NL + "#      ";
  protected final String TEXT_1194 = " = ";
  protected final String TEXT_1195 = NL + "#    end" + NL + "#    " + NL + "#    return wasSet" + NL + "#  end";
  protected final String TEXT_1196 = NL + "  def ";
  protected final String TEXT_1197 = "(";
  protected final String TEXT_1198 = ")" + NL + "    was_set = false";
  protected final String TEXT_1199 = NL + "    ";
  protected final String TEXT_1200 = " = []";
  protected final String TEXT_1201 = NL + "    ";
  protected final String TEXT_1202 = ".each do |";
  protected final String TEXT_1203 = "|" + NL + "      next if (";
  protected final String TEXT_1204 = ".include?(";
  protected final String TEXT_1205 = ")) ";
  protected final String TEXT_1206 = NL + "      ";
  protected final String TEXT_1207 = " << ";
  protected final String TEXT_1208 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1209 = ".size != ";
  protected final String TEXT_1210 = ".length or ";
  protected final String TEXT_1211 = ".size < ";
  protected final String TEXT_1212 = ".";
  protected final String TEXT_1213 = " or ";
  protected final String TEXT_1214 = ".size() > ";
  protected final String TEXT_1215 = ".";
  protected final String TEXT_1216 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1217 = NL + "    ";
  protected final String TEXT_1218 = " = @";
  protected final String TEXT_1219 = ".dup" + NL + "    @";
  protected final String TEXT_1220 = ".clear";
  protected final String TEXT_1221 = NL + "    ";
  protected final String TEXT_1222 = ".each do |";
  protected final String TEXT_1223 = "|" + NL + "      @";
  protected final String TEXT_1224 = " << ";
  protected final String TEXT_1225 = NL + "      if ";
  protected final String TEXT_1226 = ".include?(";
  protected final String TEXT_1227 = ")";
  protected final String TEXT_1228 = NL + "        ";
  protected final String TEXT_1229 = ".delete(";
  protected final String TEXT_1230 = ")" + NL + "      else";
  protected final String TEXT_1231 = NL + "        ";
  protected final String TEXT_1232 = ".";
  protected final String TEXT_1233 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_1234 = NL + "    ";
  protected final String TEXT_1235 = ".each do |";
  protected final String TEXT_1236 = "|";
  protected final String TEXT_1237 = NL + "      ";
  protected final String TEXT_1238 = ".";
  protected final String TEXT_1239 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1240 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1241 = NL + "  def ";
  protected final String TEXT_1242 = "(";
  protected final String TEXT_1243 = ")" + NL + "    was_set = false";
  protected final String TEXT_1244 = NL + "    ";
  protected final String TEXT_1245 = " = []";
  protected final String TEXT_1246 = NL + "    ";
  protected final String TEXT_1247 = ".each do |";
  protected final String TEXT_1248 = "|" + NL + "      next if (";
  protected final String TEXT_1249 = ".include?(";
  protected final String TEXT_1250 = "))";
  protected final String TEXT_1251 = NL + "      ";
  protected final String TEXT_1252 = " << ";
  protected final String TEXT_1253 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1254 = ".size != ";
  protected final String TEXT_1255 = ".size or ";
  protected final String TEXT_1256 = ".size < ";
  protected final String TEXT_1257 = ".";
  protected final String TEXT_1258 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1259 = NL + "    ";
  protected final String TEXT_1260 = " = @";
  protected final String TEXT_1261 = ".dup" + NL + "    @";
  protected final String TEXT_1262 = ".clear";
  protected final String TEXT_1263 = NL + "    ";
  protected final String TEXT_1264 = ".each do |";
  protected final String TEXT_1265 = "|" + NL + "      @";
  protected final String TEXT_1266 = " << ";
  protected final String TEXT_1267 = NL + "      if ";
  protected final String TEXT_1268 = ".include?(";
  protected final String TEXT_1269 = ")";
  protected final String TEXT_1270 = NL + "        ";
  protected final String TEXT_1271 = ".delete(";
  protected final String TEXT_1272 = ")" + NL + "      else";
  protected final String TEXT_1273 = NL + "        ";
  protected final String TEXT_1274 = ".";
  protected final String TEXT_1275 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_1276 = NL + "    ";
  protected final String TEXT_1277 = ".each do |";
  protected final String TEXT_1278 = "|";
  protected final String TEXT_1279 = NL + "      ";
  protected final String TEXT_1280 = ".";
  protected final String TEXT_1281 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1282 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1283 = NL + "  def ";
  protected final String TEXT_1284 = "(";
  protected final String TEXT_1285 = ")" + NL + "    was_set = false";
  protected final String TEXT_1286 = NL + "    ";
  protected final String TEXT_1287 = " = []";
  protected final String TEXT_1288 = NL + "    ";
  protected final String TEXT_1289 = ".each do |";
  protected final String TEXT_1290 = "|" + NL + "      next if (";
  protected final String TEXT_1291 = ".include?(";
  protected final String TEXT_1292 = "))";
  protected final String TEXT_1293 = NL + "      ";
  protected final String TEXT_1294 = " << ";
  protected final String TEXT_1295 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1296 = ".size != ";
  protected final String TEXT_1297 = ".size or ";
  protected final String TEXT_1298 = ".size < ";
  protected final String TEXT_1299 = ".";
  protected final String TEXT_1300 = " or ";
  protected final String TEXT_1301 = ".size > ";
  protected final String TEXT_1302 = ".";
  protected final String TEXT_1303 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1304 = ".clear";
  protected final String TEXT_1305 = NL + "    ";
  protected final String TEXT_1306 = ".each do |";
  protected final String TEXT_1307 = "|" + NL + "      @";
  protected final String TEXT_1308 = " << ";
  protected final String TEXT_1309 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1310 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1311 = NL + "  def ";
  protected final String TEXT_1312 = "(";
  protected final String TEXT_1313 = ")" + NL + "    was_set = false";
  protected final String TEXT_1314 = NL + "    if ";
  protected final String TEXT_1315 = ".length < ";
  protected final String TEXT_1316 = ".";
  protected final String TEXT_1317 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1318 = NL + "    ";
  protected final String TEXT_1319 = " = []";
  protected final String TEXT_1320 = NL + "    ";
  protected final String TEXT_1321 = " = {}";
  protected final String TEXT_1322 = NL + "    ";
  protected final String TEXT_1323 = ".each do |";
  protected final String TEXT_1324 = "|" + NL + "      if ";
  protected final String TEXT_1325 = ".include?(";
  protected final String TEXT_1326 = ")";
  protected final String TEXT_1327 = NL + "        return was_set" + NL + "      elsif !";
  protected final String TEXT_1328 = ".";
  protected final String TEXT_1329 = ".nil? and !";
  protected final String TEXT_1330 = ".";
  protected final String TEXT_1331 = ".eql?(self)";
  protected final String TEXT_1332 = NL + "        ";
  protected final String TEXT_1333 = " = ";
  protected final String TEXT_1334 = ".";
  protected final String TEXT_1335 = NL + "        unless ";
  protected final String TEXT_1336 = ".has_key?(";
  protected final String TEXT_1337 = ")";
  protected final String TEXT_1338 = NL + "          ";
  protected final String TEXT_1339 = "[";
  protected final String TEXT_1340 = "] = ";
  protected final String TEXT_1341 = ".";
  protected final String TEXT_1342 = NL + "        end" + NL + "        currentCount = ";
  protected final String TEXT_1343 = "[";
  protected final String TEXT_1344 = "]" + NL + "        nextCount = currentCount - 1" + NL + "        if nextCount < ";
  protected final String TEXT_1345 = NL + "          return was_set" + NL + "        end";
  protected final String TEXT_1346 = NL + "        ";
  protected final String TEXT_1347 = "[";
  protected final String TEXT_1348 = "] = nextCount" + NL + "      end";
  protected final String TEXT_1349 = NL + "      ";
  protected final String TEXT_1350 = " << ";
  protected final String TEXT_1351 = NL + "    end" + NL;
  protected final String TEXT_1352 = NL + "    ";
  protected final String TEXT_1353 = ".each do |";
  protected final String TEXT_1354 = "|" + NL + "      @";
  protected final String TEXT_1355 = ".delete(";
  protected final String TEXT_1356 = ")" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1357 = ".each do |orphan|" + NL + "      orphan.instance_variable_set(\"@";
  protected final String TEXT_1358 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_1359 = ".clear";
  protected final String TEXT_1360 = NL + "    ";
  protected final String TEXT_1361 = ".each do |";
  protected final String TEXT_1362 = "|" + NL + "      unless ";
  protected final String TEXT_1363 = ".";
  protected final String TEXT_1364 = ".nil?";
  protected final String TEXT_1365 = NL + "        ";
  protected final String TEXT_1366 = ".";
  protected final String TEXT_1367 = ".instance_variable_get(\"@";
  protected final String TEXT_1368 = "\").delete(";
  protected final String TEXT_1369 = ")" + NL + "      end";
  protected final String TEXT_1370 = NL + "      ";
  protected final String TEXT_1371 = ".instance_variable_set(\"@";
  protected final String TEXT_1372 = "\",self)" + NL + "      @";
  protected final String TEXT_1373 = " << ";
  protected final String TEXT_1374 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1375 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1376 = NL + "  def ";
  protected final String TEXT_1377 = "(";
  protected final String TEXT_1378 = ")" + NL + "    was_set = false";
  protected final String TEXT_1379 = NL + "    ";
  protected final String TEXT_1380 = " = []";
  protected final String TEXT_1381 = NL + "    ";
  protected final String TEXT_1382 = ".each do |";
  protected final String TEXT_1383 = "|" + NL + "      next if (";
  protected final String TEXT_1384 = ".include?(";
  protected final String TEXT_1385 = "))";
  protected final String TEXT_1386 = NL + "      ";
  protected final String TEXT_1387 = " << ";
  protected final String TEXT_1388 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1389 = ".size != ";
  protected final String TEXT_1390 = ".size or ";
  protected final String TEXT_1391 = ".size() > ";
  protected final String TEXT_1392 = ".";
  protected final String TEXT_1393 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1394 = ".clear";
  protected final String TEXT_1395 = NL + "    ";
  protected final String TEXT_1396 = ".each do |";
  protected final String TEXT_1397 = "|" + NL + "      @";
  protected final String TEXT_1398 = " << ";
  protected final String TEXT_1399 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1400 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1401 = NL + "  def ";
  protected final String TEXT_1402 = "(";
  protected final String TEXT_1403 = ")" + NL + "    was_set = false";
  protected final String TEXT_1404 = NL + "    ";
  protected final String TEXT_1405 = " = []";
  protected final String TEXT_1406 = NL + "    ";
  protected final String TEXT_1407 = ".each do |";
  protected final String TEXT_1408 = "|" + NL + "      next if (";
  protected final String TEXT_1409 = ".include?(";
  protected final String TEXT_1410 = "))";
  protected final String TEXT_1411 = NL + "      ";
  protected final String TEXT_1412 = " << ";
  protected final String TEXT_1413 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1414 = ".size != ";
  protected final String TEXT_1415 = ".size or ";
  protected final String TEXT_1416 = ".size() < ";
  protected final String TEXT_1417 = ".";
  protected final String TEXT_1418 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1419 = ".clear";
  protected final String TEXT_1420 = NL + "    ";
  protected final String TEXT_1421 = ".each do |";
  protected final String TEXT_1422 = "|" + NL + "      @";
  protected final String TEXT_1423 = " << ";
  protected final String TEXT_1424 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1425 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1426 = NL;
  protected final String TEXT_1427 = NL + "  def ";
  protected final String TEXT_1428 = "(";
  protected final String TEXT_1429 = ", index)" + NL + "    was_added = false" + NL + "    if ";
  protected final String TEXT_1430 = "(";
  protected final String TEXT_1431 = ")" + NL + "      if(index < 0)" + NL + "        index = 0" + NL + "      end" + NL + "      if(index > ";
  protected final String TEXT_1432 = "())" + NL + "        index = ";
  protected final String TEXT_1433 = "() - 1" + NL + "      end" + NL + "      @";
  protected final String TEXT_1434 = ".delete(";
  protected final String TEXT_1435 = ")" + NL + "      @";
  protected final String TEXT_1436 = ".insert(index, ";
  protected final String TEXT_1437 = ")" + NL + "      was_added = true" + NL + "    end" + NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1438 = "(";
  protected final String TEXT_1439 = ", index)" + NL + "    was_added = false" + NL + "    if @";
  protected final String TEXT_1440 = ".include?(";
  protected final String TEXT_1441 = ")" + NL + "      if(index < 0)" + NL + "        index = 0" + NL + "      end" + NL + "      if(index > ";
  protected final String TEXT_1442 = "())" + NL + "        index = ";
  protected final String TEXT_1443 = "() - 1" + NL + "      end" + NL + "      @";
  protected final String TEXT_1444 = ".delete(";
  protected final String TEXT_1445 = ")" + NL + "      @";
  protected final String TEXT_1446 = ".insert(index, ";
  protected final String TEXT_1447 = ")" + NL + "      was_added = true" + NL + "    else" + NL + "      was_added = ";
  protected final String TEXT_1448 = "(";
  protected final String TEXT_1449 = ", index)" + NL + "    end" + NL + "    was_added" + NL + "  end" + NL;
  protected final String TEXT_1450 = NL + "  def eql?(obj)" + NL + "    return false if obj.nil?" + NL + "    return false unless self.class == obj.class" + NL + "" + NL + "    compareTo = obj";
  protected final String TEXT_1451 = NL + "    ";
  protected final String TEXT_1452 = NL + "    true" + NL + "  end" + NL + "" + NL + "  def hash" + NL + "    return @cachedHashCode unless @cachedHashCode == -1" + NL + "    @cachedHashCode = 17";
  protected final String TEXT_1453 = NL + "    ";
  protected final String TEXT_1454 = NL + "    ";
  protected final String TEXT_1455 = NL + "    @cachedHashCode" + NL + "  end" + NL;
  protected final String TEXT_1456 = NL + "  def ";
  protected final String TEXT_1457 = NL + "    ";
  protected final String TEXT_1458 = NL + "  end" + NL;
  protected final String TEXT_1459 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1460 = NL + "    ";
  protected final String TEXT_1461 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1462 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    def run()" + NL + "    {" + NL + "      try" + NL + "      {";
  protected final String TEXT_1463 = NL + "        ";
  protected final String TEXT_1464 = NL + "      }" + NL + "      catch (InterruptedException e)" + NL + "      {" + NL + "        e.printStackTrace();" + NL + "      }" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1465 = NL + "  def ";
  protected final String TEXT_1466 = NL + "    ";
  protected final String TEXT_1467 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1468 = "\",";
  protected final String TEXT_1469 = ")" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1470 = NL + "    ";
  protected final String TEXT_1471 = ".stop()" + NL + "  end" + NL;
  protected final String TEXT_1472 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1473 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1474 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    def stop" + NL + "      timer.cancel();" + NL + "    end" + NL + "    " + NL + "    def run";
  protected final String TEXT_1475 = NL + "      if (\"";
  protected final String TEXT_1476 = "\".eql?(timeoutMethodName))" + NL + "      {" + NL + "        shouldRestart = !controller.";
  protected final String TEXT_1477 = NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1478 = NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1479 = NL + "    end" + NL + "  }" + NL;
  protected final String TEXT_1480 = NL + "    @";
  protected final String TEXT_1481 = " = nil";
  protected final String TEXT_1482 = NL + "    @";
  protected final String TEXT_1483 = ".clear";
  protected final String TEXT_1484 = NL + "    ";
  protected final String TEXT_1485 = " = @";
  protected final String TEXT_1486 = NL + "    @";
  protected final String TEXT_1487 = " = nil" + NL + "    unless ";
  protected final String TEXT_1488 = ".nil?";
  protected final String TEXT_1489 = NL + "      ";
  protected final String TEXT_1490 = ".delete" + NL + "    end";
  protected final String TEXT_1491 = NL + "    unless @";
  protected final String TEXT_1492 = ".nil?" + NL + "      @";
  protected final String TEXT_1493 = ".";
  protected final String TEXT_1494 = "(nil)" + NL + "    end";
  protected final String TEXT_1495 = NL + "    ";
  protected final String TEXT_1496 = " = @";
  protected final String TEXT_1497 = NL + "    @";
  protected final String TEXT_1498 = " = nil" + NL + "    unless ";
  protected final String TEXT_1499 = ".nil?";
  protected final String TEXT_1500 = NL + "      ";
  protected final String TEXT_1501 = ".";
  protected final String TEXT_1502 = "(nil)" + NL + "    end";
  protected final String TEXT_1503 = NL + "    ";
  protected final String TEXT_1504 = " = @";
  protected final String TEXT_1505 = NL + "    @";
  protected final String TEXT_1506 = " = nil" + NL + "    unless ";
  protected final String TEXT_1507 = ".nil?";
  protected final String TEXT_1508 = NL + "      ";
  protected final String TEXT_1509 = ".delete" + NL + "    end";
  protected final String TEXT_1510 = NL + "    unless @";
  protected final String TEXT_1511 = ".nil?" + NL + "      @";
  protected final String TEXT_1512 = ".";
  protected final String TEXT_1513 = "(self)" + NL + "    end";
  protected final String TEXT_1514 = NL + "    unless @";
  protected final String TEXT_1515 = ".nil?" + NL + "      @";
  protected final String TEXT_1516 = ".delete" + NL + "    end";
  protected final String TEXT_1517 = NL + "    unless @";
  protected final String TEXT_1518 = ".nil?" + NL + "      if @";
  protected final String TEXT_1519 = ".";
  protected final String TEXT_1520 = " <= ";
  protected final String TEXT_1521 = NL + "        @";
  protected final String TEXT_1522 = ".delete" + NL + "      else" + NL + "        @";
  protected final String TEXT_1523 = ".";
  protected final String TEXT_1524 = "(self)" + NL + "      end" + NL + "    end";
  protected final String TEXT_1525 = NL + "    @";
  protected final String TEXT_1526 = " = @";
  protected final String TEXT_1527 = NL + "    @";
  protected final String TEXT_1528 = " = nil" + NL + "    @";
  protected final String TEXT_1529 = ".";
  protected final String TEXT_1530 = "(self)";
  protected final String TEXT_1531 = NL + "    @";
  protected final String TEXT_1532 = ".each do |";
  protected final String TEXT_1533 = "|";
  protected final String TEXT_1534 = NL + "      ";
  protected final String TEXT_1535 = ".instance_variable_set(\"@";
  protected final String TEXT_1536 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_1537 = ".clear";
  protected final String TEXT_1538 = NL + "    ";
  protected final String TEXT_1539 = " = @";
  protected final String TEXT_1540 = ".dup" + NL + "    @";
  protected final String TEXT_1541 = ".clear";
  protected final String TEXT_1542 = NL + "    ";
  protected final String TEXT_1543 = ".each do |";
  protected final String TEXT_1544 = "|" + NL + "      if ";
  protected final String TEXT_1545 = ".";
  protected final String TEXT_1546 = " <= ";
  protected final String TEXT_1547 = ".";
  protected final String TEXT_1548 = NL + "        ";
  protected final String TEXT_1549 = ".delete" + NL + "      else";
  protected final String TEXT_1550 = NL + "        ";
  protected final String TEXT_1551 = ".";
  protected final String TEXT_1552 = "(self)" + NL + "      end" + NL + "    end";
  protected final String TEXT_1553 = NL + "    ";
  protected final String TEXT_1554 = " = @";
  protected final String TEXT_1555 = ".dup" + NL + "    @";
  protected final String TEXT_1556 = ".clear";
  protected final String TEXT_1557 = NL + "    ";
  protected final String TEXT_1558 = ".each do |";
  protected final String TEXT_1559 = "|";
  protected final String TEXT_1560 = NL + "      ";
  protected final String TEXT_1561 = ".";
  protected final String TEXT_1562 = "(self)" + NL + "    end";
  protected final String TEXT_1563 = NL + "    @";
  protected final String TEXT_1564 = ".each do |";
  protected final String TEXT_1565 = "|";
  protected final String TEXT_1566 = NL + "      ";
  protected final String TEXT_1567 = ".delete" + NL + "    end";
  protected final String TEXT_1568 = NL + "    @";
  protected final String TEXT_1569 = ".each do |";
  protected final String TEXT_1570 = "|";
  protected final String TEXT_1571 = NL + "      ";
  protected final String TEXT_1572 = ".";
  protected final String TEXT_1573 = "(nil)" + NL + "    end";
  protected final String TEXT_1574 = NL + NL;
  protected final String TEXT_1575 = NL + "  #------------------------" + NL + "  # DEVELOPER CODE - PROVIDED AS-IS" + NL + "  #------------------------" + NL + "  ";
  protected final String TEXT_1576 = NL + "  ";
  protected final String TEXT_1577 = NL + "end";
  protected final String TEXT_1578 = NL;

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
  RubyGenerator gen = new RubyGenerator();
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
    append(stringBuffer, "require '{0}'",depend.getName());
  }
  
  for (String anImport : gClass.getMultiLookup("import"))
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "require '{0}'",anImport);
  }

    stringBuffer.append(TEXT_4);
     if (uClass.numberOfComments() > 0) { if(!uClass.getComments().get(0).getIsInline()) {append(stringBuffer, "\n{0}", Comment.format("RubyMultiline",uClass.getComments()));} else { append(stringBuffer, "\n{0}", Comment.format("Hash",uClass.getComments()));} } 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(uClass.getName());
    stringBuffer.append( gen.translate("isA",uClass) );
    stringBuffer.append(TEXT_6);
    

  if (uClass.getIsSingleton())
  {
    append(stringBuffer, "  include Singleton");
  }

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
      appendln(stringBuffer, "  #------------------------");
      appendln(stringBuffer, "  # STATIC VARIABLES");
      appendln(stringBuffer, "  #------------------------");
      isFirst = false;
    }
  
    if (av.isConstant())
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  {0} = {1};", gen.translate("attributeConstant",av), gen.translate("parameterValue",av));
    }
    else if (av.getIsAutounique())
    {
      String defaultValue = av.getValue() == null ? "1" : av.getValue();
      appendln(stringBuffer, "");
      append(stringBuffer, "  @@{0} = {1}", gen.translate("parameterNext",av), defaultValue);
    }
    else if (av.getIsUnique())
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  class << self; attr_accessor :{0} end", gen.translate("uniqueMap", av));
      appendln(stringBuffer, "");
      append(stringBuffer, "  @{0} = Hash.new", gen.translate("uniqueMap", av));
    }
  }
  

    
  
  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
    if (av.isConstant() || av.getIsAutounique() || av.getIsDerived())
    {
      continue;
    }
    String attribute = av.getIsList() ? gen.translate("attributeMany",av) : gen.translate("attributeOne",av);
 
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer, "  #------------------------");
      appendln(stringBuffer, "  # MEMBER VARIABLES");
      append(stringBuffer, "  #------------------------");
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer,"  #{0} Attributes - for documentation purposes", uClass.getName());
      
      if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("RubyMultiline Internal", av.getComments())); }
      
      append(stringBuffer,"  #attr_reader :{0}",attribute);
      isFirst = false;
    }
    else
    {
      append(stringBuffer,", :{0}",attribute);
    }
  }
  
  boolean isFirstAutounique = true;
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
      appendln(stringBuffer, "  #------------------------");
      appendln(stringBuffer, "  # MEMBER VARIABLES");
      append(stringBuffer, "  #------------------------");
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      isFirst = false;
    }
    
    if (isFirstAutounique)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      append(stringBuffer,"  #Autounique Attributes - for documentation purposes");
      isFirstAutounique = false;
    }
    appendln(stringBuffer, "");
    String attribute = av.getIsList() ? gen.translate("attributeMany",av) : gen.translate("attributeOne",av);
    append(stringBuffer, "  #attr_reader {0};", attribute);
  }


    
  boolean isFirstStateMachine = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    List<StateMachine> allNested = sm.getNestedStateMachines();

    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer, "  #------------------------");
      appendln(stringBuffer, "  # MEMBER VARIABLES");
      append(stringBuffer, "  #------------------------");
      isFirst = false;
    }

    if (isFirstStateMachine)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      append(stringBuffer,"  #{0} State Machines", uClass.getName());
      isFirstStateMachine = false;
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

    
{
  boolean isFirstDoActivity = true;
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    for (State state : sm.getStates())
    {
      if (state.getActivity() == null)
      {
        continue;
      }

      if (isFirstDoActivity)
      {
        appendln(stringBuffer, "");
        appendln(stringBuffer, "");
        append(stringBuffer,"  #{0} Do Activity Threads", uClass.getName());
        isFirstDoActivity = false;
      }
      append(stringBuffer, "\n  #attr_reader {0};", gen.translate("doActivityThread",state));
    }
  }
}

    

  boolean isFirstAssociation = true;
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
    if (!av.getIsNavigable())
    {
      continue;
    }
    
    String attribute = av.isOne() ? gen.translate("attributeOne",av) : gen.translate("attributeMany",av);
 
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer, "  #------------------------");
      appendln(stringBuffer, "  # MEMBER VARIABLES");
      append(stringBuffer, "  #------------------------");
      isFirst = false;
    }
    
    if (isFirstAssociation)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer,"  #{0} Associations - for documentation purposes", uClass.getName());
      
      if (av.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("RubyMultiline Internal", av.getComments())); }
      
      append(stringBuffer,"  #attr_reader :{0}",attribute);
      isFirstAssociation = false;
    }
    else
    {
      append(stringBuffer,", :{0}",attribute);
    }
  }

    
// NO OUTPUT REQUIRED, SEE members_AllHelpers from other implementations if this changes

    stringBuffer.append(TEXT_7);
     if (!uClass.getIsSingleton()) { 
    stringBuffer.append(TEXT_8);
    

  String customConstructorPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","constructor"));
  String customConstructorPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","constructor"));

  appendln(stringBuffer, "");

  String accessibility = uClass.getIsSingleton() ? "private" : "public";
  append(stringBuffer,"  def initialize({0})",new Object[] {gClass.getLookup("constructorSignature")});

  String extraNote = null;
    
  if (!uClass.isRoot())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    super({0})", gClass.getParentClass().getLookup("constructorSignature_caller"));
  }

  append(stringBuffer, "\n    @initialized = false");
  append(stringBuffer, "\n    @deleted = false");
  
  if (customConstructorPrefixCode != null)
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPrefixCode, "    "));
  }
  
  if (uClass.getKey().isProvided())
  {
    appendln(stringBuffer, "");
    append(stringBuffer, "    @cachedHashCode = -1");
  }
  
  for(String memberId : uClass.getKey().getMembers())
  {
    Attribute av = uClass.getAttribute(memberId);
    AssociationVariable as = uClass.getAssociationVariable(memberId);
    if (av != null  && !av.isImmutable())
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "    @{0} = true", gen.translate("attributeCanSet",av));
    }
    else if (as != null)
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "    @{0} = true", gen.translate("associationCanSet",as));
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
      
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_10);
    
    }
    else if ("defaulted".equals(av.getModifier()))
    {
      
    stringBuffer.append(TEXT_11);
    stringBuffer.append(gen.translate("resetMethod",av));
     
    }
    else if (av.isImmutable() && av.getIsLazy())
    {
      
    
  String parameterLookup = null; // av.getValue() == null ? "parameterOne" : "parameterValue";
  String defaultValue = null;
  
 
  if(av.getValue() == null)
  {
     // Try to assign a null value or 0 value if we recognize
     // one of Umple's built in data types. (http://cruise.site.uottawa.ca/umple/UmpleBuiltinDataTypes.html)

     if(av.getType().equals("String") || av.getType().equals("Date") || av.getType().equals("Time"))
     {
  	   defaultValue = "nil";
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
    stringBuffer.append(TEXT_12);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(defaultValue);
    } 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_15);
    
    }
    else if (av.isImmutable())
    {
      
    
  String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_16);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(gen.translate(parameterLookup,av));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(gen.translate("attributeCanSet",av));
    stringBuffer.append(TEXT_19);
     
    }
    else if(av.getIsLazy())
    {
       
    
  String parameterLookup = null; // av.getValue() == null ? "parameterOne" : "parameterValue";
  String defaultValue = null;
  
 
  if(av.getValue() == null)
  {
     // Try to assign a null value or 0 value if we recognize
     // one of Umple's built in data types. (http://cruise.site.uottawa.ca/umple/UmpleBuiltinDataTypes.html)

     if(av.getType().equals("String") || av.getType().equals("Date") || av.getType().equals("Time"))
     {
  	   defaultValue = "nil";
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
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(defaultValue);
    } 
    
    }
    else
    {
       
    
  if(!av.getIsLazy()){
    String parameterLookup = av.getValue() == null ? "parameterOne" : "parameterValue";

    stringBuffer.append(TEXT_22);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gen.translate(parameterLookup,av));
     } 
    
    }
  }

  for (Attribute av : uClass.getAttributes())
  {
    if (av.getIsAutounique())
    {
      
    stringBuffer.append(TEXT_24);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(gen.translate("parameterNext",av));
    stringBuffer.append(TEXT_27);
    
    }
    else if (av.getIsUnique())
    {
      
    stringBuffer.append(TEXT_28);
    stringBuffer.append(av.getName());
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
    append(stringBuffer, "\n    @{0} = true", gen.translate("associationCanSet",av));
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
        
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_40);
    
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
  

    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_50);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        
     String requiredNumber = "" + av.getMultiplicity().getUpperBound(); 
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.translate("didAddMany",av));
    
      }
      else if (av.isMany() && av.isImmutable())
      {
        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("didAddMany",av));
    
      }
      else if (av.isMany())
      {
        
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_69);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_71);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_78);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_80);
    
    }
    else if (av.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(gen.translate("didAdd",av));
    
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
    append(stringBuffer, "    @{0} = []", gen.translate("associationMany",av));
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
  

    stringBuffer.append(TEXT_89);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_98);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.translate("parameterOne",av));
    
  }
  else
  {
    appendln(stringBuffer,"");
    append(stringBuffer, "    @{0} = nil", gen.translate("associationOne",av));
  }

    
    }
  }
  
  for(StateMachine sm : uClass.getStateMachines())
  {
    State state = sm.getStartState();
    if (state == null)
    {
      continue;
    }
    
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_105);
    
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_106);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_110);
    
    }
  }
  
  if (customConstructorPostfixCode != null)
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPostfixCode, "    "));
  }

  appendln(stringBuffer, "\n    @initialized = true");
  append(stringBuffer, "  end");

    stringBuffer.append(TEXT_111);
     } 
    stringBuffer.append(TEXT_112);
    
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
        
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_115);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_116);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_119);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_120);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_121);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_123);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_124);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_126);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_127);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_128);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_129);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_131);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_132);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_133);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_135);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("parameterOne",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_138);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_140);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_143);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_144);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_145);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_147);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_148);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_150);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_151);
    
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
      
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_153);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_156);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(gen.translate("getManyMethod",av));
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_159);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_164);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(gen.translate("numberOfMethod",av));
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_168);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_169);
    stringBuffer.append(gen.translate("hasManyMethod",av));
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_171);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_172);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_174);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_175);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_177);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_178);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_180);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_181);
    stringBuffer.append( gen.translate("parameterValue",av) );
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_182);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_183);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_185);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_186);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_187);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_188);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(gen.translate("attributeOne",av));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_190);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_191);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_192);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_194);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_197);
    stringBuffer.append( gen.translate("parameterValue",av) );
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_198);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_199);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_201);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_202);
    
      }
      
      if (av.getIsUnique())
      {
        if (customGetUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_203);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_206);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_207);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(gen.translate("getUniqueMap",av));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(TEXT_211);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customGetUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customGetUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_212);
    stringBuffer.append(gen.translate("parameterGetUnique",av));
    stringBuffer.append(TEXT_213);
    
        } 
        else 
        {
          
    stringBuffer.append(TEXT_214);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_217);
     if (customGetUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_218);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("uniqueMap",av));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_221);
    
        }
        if (customHasUniquePostfixCode != null)
        {
          
    stringBuffer.append(TEXT_222);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_225);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_226);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(TEXT_230);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
     if (customHasUniquePostfixCode != null) { append(stringBuffer, "{0}\n",GeneratorHelper.doIndent(customHasUniquePostfixCode, "    ")); } 

    stringBuffer.append(TEXT_231);
    stringBuffer.append(gen.translate("parameterHasUnique",av));
    stringBuffer.append(TEXT_232);
    
        }
        else
        {
          
    stringBuffer.append(TEXT_233);
    stringBuffer.append(av.getUmpleClass().getName());
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("hasUniqueMethod",av));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(gen.translate("parameterOne", av));
    stringBuffer.append(TEXT_236);
     if (customHasUniquePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasUniquePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_237);
    stringBuffer.append( (traceItem!=null?traceItem.trace(gen, av,"at_g", uClass)+"\n":"")
);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(gen.translate("getUniqueMethod",av));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_240);
    
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
        
    stringBuffer.append(TEXT_241);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_242);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(gen.translate("attributeOne",av));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_244);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_245);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_246);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_247);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_248);
    
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
      
    stringBuffer.append(TEXT_249);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_250);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_251);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_252);
    stringBuffer.append( gen.translate("parameterValue",av) );
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_253);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_254);
    
    }
    else if (av.getIsDerived())
    {
      
    stringBuffer.append(TEXT_255);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_256);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_258);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_259);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_260);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_261);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(gen.translate("attributeOne",av));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_263);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_264);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_265);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_266);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_267);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_268);
    
    }
      
    appendln(stringBuffer, "");
  }


    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    
    
// NOT IMPLEMENTED YET

     
  }
  
  for(StateMachine sm : uClass.getAllStateMachines())
  {
    
    stringBuffer.append(TEXT_269);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_271);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_272);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for(Event e : uClass.getEvents())
  {
    
    
  StringBuffer allCases = new StringBuffer();

  for(StateMachine sm : uClass.getStateMachines(e))
  {
    allCases.append(StringFormatter.format("    switch ({0})\n",gen.translate("stateMachineOne",sm)));
    allCases.append(StringFormatter.format("    {\n"));
    
    for(State state : sm.getStates())
    {
  
      List<Transition> allT = state.getTransitionsFor(e);
  
      if (allT.size() == 0)
      {
        continue;
      }

      allCases.append(StringFormatter.format("      case {0}:\n",gen.translate("stateOne",state)));

      boolean hasExitAction = false;
      for(Action action : state.getActions())
      {
        if ("exit".equals(action.getActionType()))
        {
          hasExitAction = true;
          break;
        }
      }
  
      boolean needsBreak = true;
      for (Transition t : allT)
      {
        State nextState = t.getNextState();
        String tabSpace = t.getGuard() == null ? "        " : "          ";
        String condition = t.getGuard()!=null?t.getGuard().getCondition(gen):"if ()\n{"; 
        if (!"if ()\n{".equals(condition))
        {
          allCases.append(GeneratorHelper.doIndent(condition, "        ")+"\n");
        }
        if (hasExitAction)
        {
          allCases.append(StringFormatter.format("{0}{1};\n",tabSpace,gen.translate("exitMethod",sm)));
        }
        if (t.getAction() != null)
        {
          Action a1= t.getAction();
          allCases.append(StringFormatter.format("{0}{1}\n",tabSpace,a1.getActionCode()));
        }

        allCases.append(StringFormatter.format("{0}{1}({2}.{3});\n",tabSpace,gen.translate("setMethod",sm),gen.translate("type",sm),gen.translate("stateOne",nextState)));
        allCases.append(StringFormatter.format("{0}wasEventProcessed = true\n",tabSpace));
        allCases.append(StringFormatter.format("{0}break;\n",tabSpace));

        if (!"if ()\n{".equals(condition))
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
    allCases.append(StringFormatter.format("    }\n\n"));
  }
  

  String outputCases = allCases.toString().trim();

    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(TEXT_275);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_276);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    stringBuffer.append(TEXT_277);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_278);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_279);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(TEXT_281);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_282);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_283);
    
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
          if (!isFirstEntry)
          {
            entryActions.append("\n      ");
          }
          entryActions.append(StringFormatter.format("case {0}:",gen.translate("stateOne",state)));
        }
        hasEntry = true;
        hasThisEntry = true;
        isFirstEntry = false;
        entryActions.append("\n        " + action.getActionCode());
      }
      else if ("exit".equals(action.getActionType()))
      {
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
        exitActions.append("\n        " + action.getActionCode());
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
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_285);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(TEXT_287);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_288);
     } 
    stringBuffer.append(TEXT_289);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_290);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_291);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(TEXT_293);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_294);
    stringBuffer.append( gen.translate("parameterOne",sm) );
     if (hasEntry) { 
    stringBuffer.append(TEXT_295);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(TEXT_297);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_298);
     } 
    stringBuffer.append(TEXT_299);
    
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
      
    stringBuffer.append(TEXT_300);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("associationOne",av));
     } else { 
    stringBuffer.append(TEXT_302);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(gen.translate("associationOne",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("parameterOne",av));
     } 
    stringBuffer.append(TEXT_305);
     
  if(av.getMultiplicity().getLowerBound() == 0) {
  
    stringBuffer.append(TEXT_306);
    stringBuffer.append(gen.translate("hasMethod",av));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_308);
     } 
    stringBuffer.append(TEXT_309);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_311);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_312);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_314);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_315);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("getManyMethod",av));
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_317);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_319);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(gen.translate("numberOfMethod",av));
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_323);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_324);
    stringBuffer.append(gen.translate("hasManyMethod",av));
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_325);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_326);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_329);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_332);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_333);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_334);
    
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
      
    stringBuffer.append(TEXT_335);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_336);
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
      
    
      
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_338);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     } else { 
    stringBuffer.append(TEXT_341);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_347);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_350);
     } else { 
    stringBuffer.append(TEXT_351);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_352);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_353);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_356);
     } else { 
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_358);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_359);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    
    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_362);
     } else { 
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_364);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_365);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_366);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_368);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_369);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_372);
     } 
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_381);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_382);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
      
    stringBuffer.append(TEXT_383);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_385);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_388);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_398);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_399);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_402);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_405);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_406);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_409);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_410);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_413);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_414);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_417);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_425);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_440);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_441);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_444);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_449);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_452);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_458);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_459);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_470);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_471);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_472);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_474);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_485);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_491);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_494);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_495);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_499);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_502);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_505);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_507);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_508);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_509);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_511);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_515);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_532);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_535);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_540);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_548);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_549);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_550);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_552);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_555);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_556);
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
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_571);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_578);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_579);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_582);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_589);
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
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_597);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_598);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_621);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_622);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_623);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_625);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_637);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_639);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_640);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_647);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_648);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_651);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_653);
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
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_663);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_664);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_682);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_683);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_686);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_689);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_693);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_701);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_702);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_703);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_704);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_706);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_707);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_709);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(gen.translate("associationMany",av));
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
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_723);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_724);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_726);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_732);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_742);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_747);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_748);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_749);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_751);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_753);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_754);
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
    stringBuffer.append(TEXT_763);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_767);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_768);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_771);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_775);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_778);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_781);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_782);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("parameterExisting",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_794);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_796);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_797);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_799);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_800);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_804);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
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
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_810);
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
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_822);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_824);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_825);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_826);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_828);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_829);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(TEXT_842);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_846);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_849);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_850);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(TEXT_855);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_857);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_858);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_861);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
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
    stringBuffer.append(TEXT_870);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_876);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_877);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_880);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_884);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(TEXT_894);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_897);
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_902);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_903);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_905);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_906);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_913);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_914);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_917);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_923);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_926);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_929);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_932);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_935);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_936);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_939);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_943);
     } 
    stringBuffer.append(TEXT_944);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_951);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_961);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_962);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_964);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_975);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_976);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_977);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_979);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(TEXT_982);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_986);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_991);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_992);
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_996);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_998);
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_1014);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1015);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1018);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1021);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1024);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1029);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1030);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1033);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1039);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1042);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1047);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1048);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1051);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1054);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1057);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1060);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1066);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1067);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1070);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1091);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1092);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1095);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1107);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1114);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1115);
    
    }
  else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1157);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1195);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1198);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1239);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1240);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1243);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1281);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1282);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1285);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1309);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1310);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" or {0}.size > {2}.{1}", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av),uClass.getName());

    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1313);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(orCheckMaxBound);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1326);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1374);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1375);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1378);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1385);
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
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1399);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1400);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1403);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1408);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(TEXT_1411);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1424);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1425);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
    }
    
    if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
    {
      
    stringBuffer.append(TEXT_1426);
    
      sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
    }
    else if(includeFile3 == "association_AddIndexControlFunctions.jet")
    {
      
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1443);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1449);
    
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
      canSet.append(StringFormatter.format("    @{0} = false\n",gen.translate("attributeCanSet",av)));
      if (av.getIsList())
      {
        checks.append(StringFormatter.format("    return false unless @{0}.size == compareTo.instance_variable_get(\"@{0}\").size\n",gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("    @{0}.each do |me|\n",gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("      them = compareTo.instance_variable_get(\"@{0}\").get(i)\n",gen.translate("attributeMany",av)));
        checks.append(StringFormatter.format("      return false if (me.nil? and !them.nil?)\n"));
        checks.append(StringFormatter.format("      return false if (!me.nil? and !me.eql?(them))\n"));
        checks.append(StringFormatter.format("    end\n"));
      }
      else if ("Integer".equals(av.getType()) || "Boolean".equals(av.getType()) || "Double".equals(av.getType()))
      {
        checks.append(StringFormatter.format("    return false unless @{0} == compareTo.instance_variable_get(\"@{0}\")\n",gen.translate("attributeOne",av)));
      }
      else
      {
        checks.append(StringFormatter.format("    return false if (@{0}.nil? and !compareTo.instance_variable_get(\"@{0}\").nil?)\n",gen.translate("attributeOne",av)));
        checks.append(StringFormatter.format("    return false if (!@{0}.nil? and !@{0}.eql?(compareTo.instance_variable_get(\"@{0}\")))\n",gen.translate("attributeOne",av)));
      }
      checks.append("\n");
    }
    else if (as != null)
    {
      canSet.append(StringFormatter.format("    @{0} = false\n",gen.translate("associationCanSet",as)));
      if (as.isMany())
      {
        checks.append(StringFormatter.format("    return false unless @{0}.size == compareTo.instance_variable_get(\"@{0}\").size\n",gen.translate("associationMany",as)));
        checks.append(StringFormatter.format("    @{0}.each do |me|\n",gen.translate("attributeMany",as)));
        checks.append(StringFormatter.format("      them = compareTo.instance_variable_get(\"@{0}\").get(i)\n",gen.translate("associationMany",as)));
        checks.append(StringFormatter.format("      return false if (me.nil? and !them.nil?)\n"));
        checks.append(StringFormatter.format("      return false if (!me.nil? and !me.eql?(them))\n"));
        checks.append(StringFormatter.format("    end\n"));
      }
      else
      {
        checks.append(StringFormatter.format("    return false if (@{0}.nil? and !compareTo.instance_variable_get(\"@{0}\").nil?)\n",gen.translate("attributeOne",as)));
        checks.append(StringFormatter.format("    return false if (!@{0}.nil? and !@{0}.eql?(compareTo.instance_variable_get(\"@{0}\")))\n",gen.translate("attributeOne",as)));
      }
      checks.append("\n");
    }
    
    if (av != null)
    {
      if ("Integer".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    @cachedHashCode = @cachedHashCode * 23 + @{0}\n",gen.translate("attributeOne",av)));
      }
      else if ("Double".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    @cachedHashCode = @cachedHashCode * 23 + @{0}.hash\n",gen.translate("attributeOne",av)));
      }
      else if ("Boolean".equals(av.getType()) && !av.getIsList())
      {
        hash.append(StringFormatter.format("    @cachedHashCode = @cachedHashCode * 23 + (@{0} ? 1 : 0)\n",gen.translate("attributeOne",av)));
      }
      else
      {
        String attributeType = av.getIsList() ? "attributeMany" : "attributeOne";
        hash.append(StringFormatter.format("    if (!@{0}.nil?)\n",gen.translate(attributeType,av)));
        hash.append(StringFormatter.format("      @cachedHashCode = @cachedHashCode * 23 + @{0}.hash\n",gen.translate(attributeType,av)));
        hash.append(StringFormatter.format("    else\n"));
        hash.append(StringFormatter.format("      @cachedHashCode = @cachedHashCode * 23\n"));
        hash.append(StringFormatter.format("    end\n"));
      }
      hash.append("\n");
    }
    else if (as != null)
    {
      String attributeType = as.isOne() ? "attributeOne" : "attributeMany";
      hash.append(StringFormatter.format("    if (!@{0}.nil?)\n",gen.translate(attributeType,as)));
      hash.append(StringFormatter.format("      @cachedHashCode = @cachedHashCode * 23 + @{0}.hash\n",gen.translate(attributeType,as)));
      hash.append(StringFormatter.format("    else\n"));
      hash.append(StringFormatter.format("      @cachedHashCode = @cachedHashCode * 23\n"));
      hash.append(StringFormatter.format("    end\n"));
    }
  }


    stringBuffer.append(TEXT_1450);
    stringBuffer.append(TEXT_1451);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(TEXT_1453);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1454);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1455);
     } 
    
{ 
  boolean hasActivities = false;
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (State state : sm.getStates())
    {
      if (state.getActivity() != null)
      {
        hasActivities = true;
        
    stringBuffer.append(TEXT_1456);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1457);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1458);
    
      }
    }
  } 
  if (hasActivities)
  {
    
       
  StringBuffer output = new StringBuffer();

  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
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
        output.append(StringFormatter.format(" (\"{0}\".eql?(doActivityMethodName))\n",gen.translate("doActivityMethod",state)));
        output.append(StringFormatter.format("        {\n"));
        output.append(StringFormatter.format("          controller.{0}\n",gen.translate("doActivityMethod",state)));
        output.append(StringFormatter.format("        }"));
      }
    }
  }

    stringBuffer.append(TEXT_1459);
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(TEXT_1463);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1464);
    
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
        
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1466);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1467);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1468);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1469);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1470);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1471);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1472);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1473);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1474);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1475);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1476);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1477);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1478);
    
      }
    }
  }

    stringBuffer.append(TEXT_1479);
    
  }
}

    

  appendln(stringBuffer,"");
  append(stringBuffer,"  def delete");

  append(stringBuffer, "\n    @deleted = true");

  String customDeletePrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before","delete"));
  String customDeletePostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after","delete"));

  if (customDeletePrefixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customDeletePrefixCode, "    "));
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
        
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1481);
    
      }
      else if (av.isMany())
      {
        
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1483);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1490);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1494);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1502);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1503);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1509);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1513);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1516);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1524);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1530);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1533);
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1537);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1538);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1543);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1544);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1546);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1552);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1558);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1561);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1562);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1565);
    stringBuffer.append(TEXT_1566);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1567);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1570);
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1572);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1573);
    
    }
    else
    {
      continue;
    }
  }
  
  if (!uClass.isRoot() && !"external".equals(uClass.getExtendsClass().getModifier()))
  {
    appendln(stringBuffer,"");
    append(stringBuffer, "    super");
  }

  if (customDeletePostfixCode != null) 
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customDeletePostfixCode, "    "));
  }

  appendln(stringBuffer, "");
  appendln(stringBuffer, "  end");


     if (uClass.hasMethods()) { 
    
  if (uClass.hasMethods())
  {
  	for (Method aMethod : uClass.getMethods()) 
  	{
      String methodName = aMethod.getName();
      String methodType = aMethod.getType();
      String customPreconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Precondition"));
      String customPostconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Postcondition"));
      customPostconditionCode = customPostconditionCode==null?"":customPostconditionCode;
        
      String methodBody = (aMethod.getMethodBody() != null) ? aMethod.getMethodBody().getExtraCode() : "";
      String properMethodBody = "    " + methodBody;
    		
    		/*String lines[] = properMethodBody.split("\n");
    		properMethodBody = "";
    		int lineNumber = 0;
    		
		    for (String line : lines)
		    {
		    	int startIndex = 0;
				
				// Go through each line ensuring there are at most 4 spaces for the prefix.
				for (int i = 0; i < line.length(); i++)
				{
					char letter = line.charAt(i);
					// Remove these letters until the actual content is found in the line.
					if (letter == ' ' || letter == '\t')
					{
						startIndex++;
					}
					// Line content found, start the line from here.
					else
					{
						line = line.substring(startIndex);
						properMethodBody += "    " + line + "\n";
						break;
					}
				}
		    }*/
    		
      String finalParams = "";
      StringBuilder parameters = new StringBuilder();
      if (aMethod.hasMethodParameters())
      {
        for (MethodParameter aMethodParam : aMethod.getMethodParameters()) 
        {
          String paramName = aMethodParam.getName();
          String aSingleParameter = paramName;
          parameters.append(aSingleParameter + ", ");
        }
        finalParams = parameters.toString().substring(0, parameters.toString().length()-2);
      }
        
      appendln(stringBuffer, "");
      	
      if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("RubyMultiline Internal", aMethod.getComments())); }
    	
      append(stringBuffer, "  def {0} ({1})\n", methodName, finalParams);
      
      if(!"".equals(customPostconditionCode))
      {
        if(!"".equals(methodType)&&!"void".equals(methodType)){
          append(stringBuffer, "    result = {0}_original({1})\n", methodName, finalParams);
        }
        else {
          append(stringBuffer, "    {0}_original({1})\n", methodName, finalParams);
        }
        appendln(stringBuffer, GeneratorHelper.doIndent(customPostconditionCode, "    "));
        if(!"".equals(methodType)&&!"void".equals(methodType)){
          append(stringBuffer, "    return result\n");
        }          
        appendln(stringBuffer, "  end");
        append(stringBuffer, "\n  def {0}_original({1})\n", methodName, finalParams);
      }
    	
      if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
    	
      appendln(stringBuffer, properMethodBody);
    	
	  appendln(stringBuffer, "  end");
  	}
  }

    stringBuffer.append(TEXT_1574);
     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_1575);
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(gen.translate("packageDefinitionEnd",uClass));
    return stringBuffer.toString();
  }
}