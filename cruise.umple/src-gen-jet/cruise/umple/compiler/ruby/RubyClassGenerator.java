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
  protected final String TEXT_1 = "# PLEASE DO NOT EDIT THIS CODE" + NL + "# This code was generated using the UMPLE 1.18.0.3036 modeling language!" + NL + "# NOTE: Ruby generator is experimental and is missing some features available in" + NL + "# in other Umple generated languages like Java or PHP";
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
  protected final String TEXT_28 = NL + "    unless ";
  protected final String TEXT_29 = "(";
  protected final String TEXT_30 = ")" + NL + "      raise \"Unable to create ";
  protected final String TEXT_31 = " due to ";
  protected final String TEXT_32 = "\" " + NL + "    end";
  protected final String TEXT_33 = NL + "    ";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = ")";
  protected final String TEXT_36 = NL + "    @";
  protected final String TEXT_37 = " = []";
  protected final String TEXT_38 = NL + "    ";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = "(";
  protected final String TEXT_41 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_42 = ", must have ";
  protected final String TEXT_43 = " @";
  protected final String TEXT_44 = "\" unless ";
  protected final String TEXT_45 = " ";
  protected final String TEXT_46 = NL + "    @";
  protected final String TEXT_47 = " = []";
  protected final String TEXT_48 = NL + "    ";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = "(";
  protected final String TEXT_51 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_52 = ", must have ";
  protected final String TEXT_53 = " or fewer @";
  protected final String TEXT_54 = ", no duplicates\" unless ";
  protected final String TEXT_55 = NL + "    @";
  protected final String TEXT_56 = " = []";
  protected final String TEXT_57 = NL + "    ";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = "(";
  protected final String TEXT_60 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_61 = ", must not have duplicate @";
  protected final String TEXT_62 = "\" unless ";
  protected final String TEXT_63 = NL + "    @";
  protected final String TEXT_64 = " = []";
  protected final String TEXT_65 = NL + "    @";
  protected final String TEXT_66 = " = nil";
  protected final String TEXT_67 = NL + "    @";
  protected final String TEXT_68 = " = nil" + NL + "    unless ";
  protected final String TEXT_69 = ".nil?" + NL + "      @";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = NL + "      ";
  protected final String TEXT_72 = ".instance_variable_set(\"@";
  protected final String TEXT_73 = "\",self)" + NL + "    end";
  protected final String TEXT_74 = NL + "    @";
  protected final String TEXT_75 = " = []";
  protected final String TEXT_76 = NL + "    @";
  protected final String TEXT_77 = " = nil";
  protected final String TEXT_78 = NL + "    ";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_82 = " due to @";
  protected final String TEXT_83 = "\" unless ";
  protected final String TEXT_84 = NL + "    @";
  protected final String TEXT_85 = " = []";
  protected final String TEXT_86 = NL + "    ";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = "(";
  protected final String TEXT_89 = ")" + NL + "    raise \"Unable to create ";
  protected final String TEXT_90 = ", must have ";
  protected final String TEXT_91 = " @";
  protected final String TEXT_92 = "\" unless ";
  protected final String TEXT_93 = " ";
  protected final String TEXT_94 = "@";
  protected final String TEXT_95 = " = []" + NL + "    @";
  protected final String TEXT_96 = " << ";
  protected final String TEXT_97 = NL + "    ";
  protected final String TEXT_98 = "(";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ")";
  protected final String TEXT_101 = NL + "    ";
  protected final String TEXT_102 = "(";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = ")  if ";
  protected final String TEXT_105 = ".nil?";
  protected final String TEXT_106 = NL;
  protected final String TEXT_107 = NL + "  #------------------------" + NL + "  # INTERFACE" + NL + "  #------------------------" + NL;
  protected final String TEXT_108 = NL + "  def ";
  protected final String TEXT_109 = "(";
  protected final String TEXT_110 = ")" + NL + "    was_set = false";
  protected final String TEXT_111 = NL + "    @";
  protected final String TEXT_112 = " = false" + NL + "    @";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = NL + "    was_set = true";
  protected final String TEXT_115 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_116 = NL + "  def ";
  protected final String TEXT_117 = "(";
  protected final String TEXT_118 = ")" + NL + "    was_set = false";
  protected final String TEXT_119 = NL + "    @";
  protected final String TEXT_120 = " = ";
  protected final String TEXT_121 = NL + "    was_set = true";
  protected final String TEXT_122 = NL + "    was_set" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_123 = NL + "    wasReset = false";
  protected final String TEXT_124 = NL + "    @";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = NL + "    wasReset = true";
  protected final String TEXT_127 = NL + "    wasReset" + NL + "  end" + NL;
  protected final String TEXT_128 = NL + "  def ";
  protected final String TEXT_129 = "(";
  protected final String TEXT_130 = ")" + NL + "    was_added = false";
  protected final String TEXT_131 = NL + "    was_added = ";
  protected final String TEXT_132 = " << ";
  protected final String TEXT_133 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_134 = "(";
  protected final String TEXT_135 = ")" + NL + "    was_removed = false";
  protected final String TEXT_136 = NL + "    was_removed = ";
  protected final String TEXT_137 = ".delete(";
  protected final String TEXT_138 = ")";
  protected final String TEXT_139 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_140 = NL + "  def ";
  protected final String TEXT_141 = "(";
  protected final String TEXT_142 = ")" + NL + "    was_set = false";
  protected final String TEXT_143 = NL + "    @";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = NL + "    was_set = true";
  protected final String TEXT_146 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_147 = NL + "  def ";
  protected final String TEXT_148 = "(index)";
  protected final String TEXT_149 = NL + "    ";
  protected final String TEXT_150 = " = ";
  protected final String TEXT_151 = "[index]";
  protected final String TEXT_152 = NL + "    ";
  protected final String TEXT_153 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_154 = NL + "    ";
  protected final String TEXT_155 = "[] ";
  protected final String TEXT_156 = " = ";
  protected final String TEXT_157 = ".toArray(new ";
  protected final String TEXT_158 = "[";
  protected final String TEXT_159 = ".size])";
  protected final String TEXT_160 = NL + "    ";
  protected final String TEXT_161 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_162 = NL + "    number = ";
  protected final String TEXT_163 = ".size";
  protected final String TEXT_164 = NL + "    number;" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_165 = NL + "    has = ";
  protected final String TEXT_166 = ".size > 0";
  protected final String TEXT_167 = NL + "    has" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_168 = "(";
  protected final String TEXT_169 = ")";
  protected final String TEXT_170 = NL + "    index = ";
  protected final String TEXT_171 = ".index(";
  protected final String TEXT_172 = ")" + NL + "    index = -1 if index.nil?";
  protected final String TEXT_173 = NL + "    index" + NL + "  end" + NL;
  protected final String TEXT_174 = NL + "  def ";
  protected final String TEXT_175 = NL + "    ";
  protected final String TEXT_176 = " = ";
  protected final String TEXT_177 = NL + "    ";
  protected final String TEXT_178 = NL + "  end";
  protected final String TEXT_179 = NL + "  def ";
  protected final String TEXT_180 = NL + "    ";
  protected final String TEXT_181 = NL + "  end";
  protected final String TEXT_182 = NL + "  def ";
  protected final String TEXT_183 = NL + "    ";
  protected final String TEXT_184 = " = @";
  protected final String TEXT_185 = NL + "    ";
  protected final String TEXT_186 = NL + "  end";
  protected final String TEXT_187 = NL + "  def ";
  protected final String TEXT_188 = NL + "    @";
  protected final String TEXT_189 = NL + "  end";
  protected final String TEXT_190 = NL + "  def ";
  protected final String TEXT_191 = NL + "    ";
  protected final String TEXT_192 = " = ";
  protected final String TEXT_193 = NL + "    ";
  protected final String TEXT_194 = NL + "  end" + NL;
  protected final String TEXT_195 = NL + "  def ";
  protected final String TEXT_196 = NL + "    ";
  protected final String TEXT_197 = NL + "  end" + NL;
  protected final String TEXT_198 = NL + "  def ";
  protected final String TEXT_199 = NL + "    ";
  protected final String TEXT_200 = " = @";
  protected final String TEXT_201 = NL + "    ";
  protected final String TEXT_202 = NL + "  end";
  protected final String TEXT_203 = NL + "  def ";
  protected final String TEXT_204 = NL + "    @";
  protected final String TEXT_205 = NL + "  end";
  protected final String TEXT_206 = NL + "  def ";
  protected final String TEXT_207 = "?";
  protected final String TEXT_208 = NL + "    ";
  protected final String TEXT_209 = " = ";
  protected final String TEXT_210 = NL + "    ";
  protected final String TEXT_211 = NL + "  end";
  protected final String TEXT_212 = NL + "  def ";
  protected final String TEXT_213 = "?";
  protected final String TEXT_214 = NL + "    @";
  protected final String TEXT_215 = NL + "  end";
  protected final String TEXT_216 = NL + "  def ";
  protected final String TEXT_217 = "?";
  protected final String TEXT_218 = NL + "    ";
  protected final String TEXT_219 = " = @";
  protected final String TEXT_220 = NL + "    ";
  protected final String TEXT_221 = NL + "  end";
  protected final String TEXT_222 = NL + "  def ";
  protected final String TEXT_223 = "?";
  protected final String TEXT_224 = NL + "    @";
  protected final String TEXT_225 = NL + "  end";
  protected final String TEXT_226 = NL + "  public ";
  protected final String TEXT_227 = " ";
  protected final String TEXT_228 = NL + "    ";
  protected final String TEXT_229 = NL + "  end" + NL;
  protected final String TEXT_230 = NL + "  def ";
  protected final String TEXT_231 = NL + "  {" + NL + "    wasEventProcessed = false;" + NL;
  protected final String TEXT_232 = NL + "    ";
  protected final String TEXT_233 = NL + NL + "    return wasEventProcessed;" + NL + "  }" + NL;
  protected final String TEXT_234 = NL + "  def ";
  protected final String TEXT_235 = "(";
  protected final String TEXT_236 = " ";
  protected final String TEXT_237 = ")" + NL + "  {";
  protected final String TEXT_238 = NL + "    ";
  protected final String TEXT_239 = " = ";
  protected final String TEXT_240 = NL + "    return true;" + NL + "  }" + NL;
  protected final String TEXT_241 = NL + "  def ";
  protected final String TEXT_242 = NL + "    switch(";
  protected final String TEXT_243 = ")";
  protected final String TEXT_244 = NL + "      ";
  protected final String TEXT_245 = NL + "    end" + NL + "  end" + NL;
  protected final String TEXT_246 = NL + "  private void ";
  protected final String TEXT_247 = "(";
  protected final String TEXT_248 = " ";
  protected final String TEXT_249 = ")" + NL + "  {";
  protected final String TEXT_250 = NL + "    ";
  protected final String TEXT_251 = " = ";
  protected final String TEXT_252 = NL + NL + "    // entry actions and do activities" + NL + "    switch(";
  protected final String TEXT_253 = ")" + NL + "    {";
  protected final String TEXT_254 = NL + "      ";
  protected final String TEXT_255 = NL + "    }";
  protected final String TEXT_256 = NL + "  }" + NL;
  protected final String TEXT_257 = NL + "  def ";
  protected final String TEXT_258 = NL + "    @";
  protected final String TEXT_259 = NL + "    ";
  protected final String TEXT_260 = " = @";
  protected final String TEXT_261 = NL + "    ";
  protected final String TEXT_262 = NL + "  end" + NL;
  protected final String TEXT_263 = NL + "  def ";
  protected final String TEXT_264 = "(index)";
  protected final String TEXT_265 = NL + "    ";
  protected final String TEXT_266 = " = @";
  protected final String TEXT_267 = "[index]";
  protected final String TEXT_268 = NL + "    ";
  protected final String TEXT_269 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_270 = NL + "    ";
  protected final String TEXT_271 = " = @";
  protected final String TEXT_272 = ".dup";
  protected final String TEXT_273 = NL + "    ";
  protected final String TEXT_274 = NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_275 = NL + "    number = @";
  protected final String TEXT_276 = ".size";
  protected final String TEXT_277 = NL + "    number" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_278 = NL + "    has = @";
  protected final String TEXT_279 = ".size > 0";
  protected final String TEXT_280 = NL + "    has" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_281 = "(";
  protected final String TEXT_282 = ")";
  protected final String TEXT_283 = NL + "    index = @";
  protected final String TEXT_284 = ".index(";
  protected final String TEXT_285 = ")" + NL + "    index = -1 if index.nil?";
  protected final String TEXT_286 = NL + "    index" + NL + "  end" + NL;
  protected final String TEXT_287 = "UNABLE TO UNDERSAND association variable (see association_Get_All.jet)";
  protected final String TEXT_288 = "//FIXME - FOUND UNKNOWN ASSOCIATION RELATIONSHIP ";
  protected final String TEXT_289 = " : ";
  protected final String TEXT_290 = NL + "  def ";
  protected final String TEXT_291 = NL + "    is_valid = ";
  protected final String TEXT_292 = " >= ";
  protected final String TEXT_293 = ".";
  protected final String TEXT_294 = NL + "    is_valid = ";
  protected final String TEXT_295 = " >= ";
  protected final String TEXT_296 = ".";
  protected final String TEXT_297 = " and ";
  protected final String TEXT_298 = " <= ";
  protected final String TEXT_299 = ".";
  protected final String TEXT_300 = NL + "    is_valid" + NL + "  end";
  protected final String TEXT_301 = NL + "  def self.";
  protected final String TEXT_302 = NL + "    ";
  protected final String TEXT_303 = NL + "  end";
  protected final String TEXT_304 = NL + "  def self.";
  protected final String TEXT_305 = NL + "    minimum = ";
  protected final String TEXT_306 = NL + "    minimum" + NL + "  end";
  protected final String TEXT_307 = NL + "  def self.";
  protected final String TEXT_308 = NL + "    ";
  protected final String TEXT_309 = NL + "  end";
  protected final String TEXT_310 = NL + "  def self.";
  protected final String TEXT_311 = NL + "    minimum = ";
  protected final String TEXT_312 = NL + "    minimum" + NL + "  end";
  protected final String TEXT_313 = NL + "  def self.";
  protected final String TEXT_314 = NL + "    ";
  protected final String TEXT_315 = NL + "  end";
  protected final String TEXT_316 = NL + "  def self.";
  protected final String TEXT_317 = NL + "    maximum = ";
  protected final String TEXT_318 = NL + "    maximum" + NL + "  end";
  protected final String TEXT_319 = NL + "  def ";
  protected final String TEXT_320 = "(";
  protected final String TEXT_321 = ")" + NL + "    was_added = false";
  protected final String TEXT_322 = NL + "    if ";
  protected final String TEXT_323 = " >= ";
  protected final String TEXT_324 = ".";
  protected final String TEXT_325 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_326 = NL + "    @";
  protected final String TEXT_327 = " << ";
  protected final String TEXT_328 = NL + "    if ";
  protected final String TEXT_329 = ".";
  protected final String TEXT_330 = "(self) != -1" + NL + "      was_added = true" + NL + "    else" + NL + "      was_added = ";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = "(self)" + NL + "      unless was_added" + NL + "        @";
  protected final String TEXT_333 = ".delete(";
  protected final String TEXT_334 = ")" + NL + "      end" + NL + "    end";
  protected final String TEXT_335 = NL + "    was_added" + NL + "  end";
  protected final String TEXT_336 = NL + "  def ";
  protected final String TEXT_337 = "(";
  protected final String TEXT_338 = ")" + NL + "    was_removed = false";
  protected final String TEXT_339 = NL + "    unless @";
  protected final String TEXT_340 = ".include?(";
  protected final String TEXT_341 = ")";
  protected final String TEXT_342 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_343 = ".index(";
  protected final String TEXT_344 = ")" + NL + "    @";
  protected final String TEXT_345 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_346 = ".";
  protected final String TEXT_347 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_348 = ".";
  protected final String TEXT_349 = "(self)" + NL + "      @";
  protected final String TEXT_350 = ".insert(oldIndex,";
  protected final String TEXT_351 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_352 = NL + "    was_removed" + NL + "  end";
  protected final String TEXT_353 = NL + "  def ";
  protected final String TEXT_354 = "(";
  protected final String TEXT_355 = ")" + NL + "    was_set = false";
  protected final String TEXT_356 = NL + "    @";
  protected final String TEXT_357 = " = ";
  protected final String TEXT_358 = NL + "    was_set = true";
  protected final String TEXT_359 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_360 = NL + "  def ";
  protected final String TEXT_361 = "(";
  protected final String TEXT_362 = ")" + NL + "    was_set = false";
  protected final String TEXT_363 = NL + "    unless ";
  protected final String TEXT_364 = ".nil?" + NL + "      @";
  protected final String TEXT_365 = " = ";
  protected final String TEXT_366 = NL + "      was_set = true" + NL + "    end";
  protected final String TEXT_367 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_368 = NL + "  def ";
  protected final String TEXT_369 = "(";
  protected final String TEXT_370 = ")" + NL + "    was_set = false";
  protected final String TEXT_371 = NL + "    if !@";
  protected final String TEXT_372 = ".nil? and !@";
  protected final String TEXT_373 = ".eql?(";
  protected final String TEXT_374 = ") and self.eql?(@";
  protected final String TEXT_375 = ".";
  protected final String TEXT_376 = ")" + NL + "      #Unable to ";
  protected final String TEXT_377 = ", as existing @";
  protected final String TEXT_378 = " would become an orphan";
  protected final String TEXT_379 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_380 = " = ";
  protected final String TEXT_381 = NL + "    ";
  protected final String TEXT_382 = " = !";
  protected final String TEXT_383 = ".nil? ? ";
  protected final String TEXT_384 = ".";
  protected final String TEXT_385 = " : nil" + NL + "" + NL + "    unless self.eql?(";
  protected final String TEXT_386 = ")" + NL + "      unless ";
  protected final String TEXT_387 = ".nil?";
  protected final String TEXT_388 = NL + "        ";
  protected final String TEXT_389 = ".instance_variable_set(\"@";
  protected final String TEXT_390 = "\",nil)" + NL + "      end" + NL + "      unless @";
  protected final String TEXT_391 = ".nil?" + NL + "        @";
  protected final String TEXT_392 = ".";
  protected final String TEXT_393 = "(self)" + NL + "      end" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_394 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_395 = NL + "  def ";
  protected final String TEXT_396 = "(";
  protected final String TEXT_397 = ")" + NL + "    was_set = false";
  protected final String TEXT_398 = NL + "    if ";
  protected final String TEXT_399 = ".nil?" + NL + "      #Unable to ";
  protected final String TEXT_400 = " to nil, as ";
  protected final String TEXT_401 = " must always be associated to a @";
  protected final String TEXT_402 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_403 = NL + "    ";
  protected final String TEXT_404 = " = ";
  protected final String TEXT_405 = ".";
  protected final String TEXT_406 = NL + "    if !";
  protected final String TEXT_407 = ".nil? and !self.eql?(";
  protected final String TEXT_408 = ")" + NL + "      #Unable to ";
  protected final String TEXT_409 = ", the current @";
  protected final String TEXT_410 = " already has a ";
  protected final String TEXT_411 = ", which would be orphaned if it were re-assigned";
  protected final String TEXT_412 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_413 = NL + "    ";
  protected final String TEXT_414 = " = @";
  protected final String TEXT_415 = NL + "    @";
  protected final String TEXT_416 = " = ";
  protected final String TEXT_417 = NL + "    @";
  protected final String TEXT_418 = ".";
  protected final String TEXT_419 = "(self)" + NL + "" + NL + "    unless ";
  protected final String TEXT_420 = ".nil?";
  protected final String TEXT_421 = NL + "      ";
  protected final String TEXT_422 = ".";
  protected final String TEXT_423 = "(nil)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_424 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_425 = NL + "  def ";
  protected final String TEXT_426 = "(";
  protected final String TEXT_427 = ")" + NL + "    was_added = false";
  protected final String TEXT_428 = NL + "    ";
  protected final String TEXT_429 = " = ";
  protected final String TEXT_430 = ".";
  protected final String TEXT_431 = NL + "    ";
  protected final String TEXT_432 = " = (!";
  protected final String TEXT_433 = ".nil? and !";
  protected final String TEXT_434 = ".eql?(self))" + NL + "" + NL + "    if ";
  protected final String TEXT_435 = " and ";
  protected final String TEXT_436 = ".";
  protected final String TEXT_437 = " <= ";
  protected final String TEXT_438 = ".";
  protected final String TEXT_439 = NL + "      return was_added" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_440 = NL + "      ";
  protected final String TEXT_441 = ".";
  protected final String TEXT_442 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_443 = " << ";
  protected final String TEXT_444 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_445 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_446 = "(";
  protected final String TEXT_447 = ")" + NL + "    was_removed = false";
  protected final String TEXT_448 = NL + "    # Unable to remove ";
  protected final String TEXT_449 = ", as it must always have a ";
  protected final String TEXT_450 = NL + "    if ";
  protected final String TEXT_451 = ".";
  protected final String TEXT_452 = ".eql?(self)";
  protected final String TEXT_453 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    # ";
  protected final String TEXT_454 = " already at minimum (";
  protected final String TEXT_455 = ")" + NL + "    if ";
  protected final String TEXT_456 = " <= ";
  protected final String TEXT_457 = ".";
  protected final String TEXT_458 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_459 = ".delete(";
  protected final String TEXT_460 = ")" + NL + "    was_removed = true";
  protected final String TEXT_461 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_462 = NL + "  def ";
  protected final String TEXT_463 = "(";
  protected final String TEXT_464 = ")" + NL + "    was_added = false";
  protected final String TEXT_465 = NL + "    if ";
  protected final String TEXT_466 = " >= ";
  protected final String TEXT_467 = ".";
  protected final String TEXT_468 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_469 = NL + "    ";
  protected final String TEXT_470 = " = ";
  protected final String TEXT_471 = ".";
  protected final String TEXT_472 = NL + "    ";
  protected final String TEXT_473 = " = (!";
  protected final String TEXT_474 = ".nil? and !";
  protected final String TEXT_475 = ".eql?(self))" + NL + "" + NL + "    if ";
  protected final String TEXT_476 = " and ";
  protected final String TEXT_477 = ".";
  protected final String TEXT_478 = " <= ";
  protected final String TEXT_479 = ".";
  protected final String TEXT_480 = NL + "      return was_added" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_481 = NL + "      ";
  protected final String TEXT_482 = ".";
  protected final String TEXT_483 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_484 = " << ";
  protected final String TEXT_485 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_486 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_487 = "(";
  protected final String TEXT_488 = ")" + NL + "    was_removed = false";
  protected final String TEXT_489 = NL + "    # Unable to remove ";
  protected final String TEXT_490 = ", as it must always have a ";
  protected final String TEXT_491 = NL + "    if ";
  protected final String TEXT_492 = ".";
  protected final String TEXT_493 = ".eql?(self)";
  protected final String TEXT_494 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    # ";
  protected final String TEXT_495 = " already at minimum (";
  protected final String TEXT_496 = ")" + NL + "    if ";
  protected final String TEXT_497 = " <= ";
  protected final String TEXT_498 = ".";
  protected final String TEXT_499 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_500 = ".delete(";
  protected final String TEXT_501 = ")" + NL + "    was_removed = true";
  protected final String TEXT_502 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_503 = NL + "  def ";
  protected final String TEXT_504 = "(";
  protected final String TEXT_505 = ")" + NL + "    was_added = false";
  protected final String TEXT_506 = NL + "    if ";
  protected final String TEXT_507 = " >= ";
  protected final String TEXT_508 = ".";
  protected final String TEXT_509 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_510 = NL + "    ";
  protected final String TEXT_511 = " = ";
  protected final String TEXT_512 = ".";
  protected final String TEXT_513 = NL + "    ";
  protected final String TEXT_514 = " = (!";
  protected final String TEXT_515 = ".nil? and !";
  protected final String TEXT_516 = ".eql?(self))" + NL + "    if ";
  protected final String TEXT_517 = NL + "      ";
  protected final String TEXT_518 = ".";
  protected final String TEXT_519 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_520 = " << ";
  protected final String TEXT_521 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_522 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_523 = "(";
  protected final String TEXT_524 = ")" + NL + "    was_removed = false";
  protected final String TEXT_525 = NL + "    # Unable to remove ";
  protected final String TEXT_526 = ", as it must always have a ";
  protected final String TEXT_527 = NL + "    unless ";
  protected final String TEXT_528 = ".";
  protected final String TEXT_529 = ".eql?(self)" + NL + "      @";
  protected final String TEXT_530 = ".delete(";
  protected final String TEXT_531 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_532 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_533 = NL + "  def ";
  protected final String TEXT_534 = "(";
  protected final String TEXT_535 = ")" + NL + "    was_set = false";
  protected final String TEXT_536 = NL + "    ";
  protected final String TEXT_537 = " = []";
  protected final String TEXT_538 = NL + "    ";
  protected final String TEXT_539 = ".each do |";
  protected final String TEXT_540 = "|" + NL + "      next if (";
  protected final String TEXT_541 = ".include?(";
  protected final String TEXT_542 = "))";
  protected final String TEXT_543 = NL + "      ";
  protected final String TEXT_544 = " << ";
  protected final String TEXT_545 = NL + "    end" + NL + "" + NL + "    if (";
  protected final String TEXT_546 = ".size != ";
  protected final String TEXT_547 = ".size or ";
  protected final String TEXT_548 = ".size() > ";
  protected final String TEXT_549 = ".";
  protected final String TEXT_550 = ")";
  protected final String TEXT_551 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_552 = NL + "    ";
  protected final String TEXT_553 = " = @";
  protected final String TEXT_554 = ".dup" + NL + "    @";
  protected final String TEXT_555 = ".clear";
  protected final String TEXT_556 = NL + "    ";
  protected final String TEXT_557 = ".each do |";
  protected final String TEXT_558 = "|" + NL + "      @";
  protected final String TEXT_559 = " << ";
  protected final String TEXT_560 = NL + "      if (";
  protected final String TEXT_561 = ".include?(";
  protected final String TEXT_562 = "))";
  protected final String TEXT_563 = NL + "        ";
  protected final String TEXT_564 = ".delete(";
  protected final String TEXT_565 = ")" + NL + "      else";
  protected final String TEXT_566 = NL + "        ";
  protected final String TEXT_567 = ".";
  protected final String TEXT_568 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_569 = NL + "    ";
  protected final String TEXT_570 = ".each do |";
  protected final String TEXT_571 = "|";
  protected final String TEXT_572 = NL + "      ";
  protected final String TEXT_573 = ".";
  protected final String TEXT_574 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_575 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_576 = NL + "  def ";
  protected final String TEXT_577 = "(";
  protected final String TEXT_578 = ")" + NL + "    was_added = false";
  protected final String TEXT_579 = NL + "    ";
  protected final String TEXT_580 = " = ";
  protected final String TEXT_581 = ".";
  protected final String TEXT_582 = NL + "    ";
  protected final String TEXT_583 = " = (!";
  protected final String TEXT_584 = ".nil? and !";
  protected final String TEXT_585 = ".eql?(self))" + NL + "    if ";
  protected final String TEXT_586 = NL + "      ";
  protected final String TEXT_587 = ".";
  protected final String TEXT_588 = "(self)" + NL + "    else" + NL + "      @";
  protected final String TEXT_589 = " << ";
  protected final String TEXT_590 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_591 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_592 = "(";
  protected final String TEXT_593 = ")" + NL + "    was_removed = false";
  protected final String TEXT_594 = NL + "    # Unable to remove ";
  protected final String TEXT_595 = ", as it must always have a ";
  protected final String TEXT_596 = NL + "    unless ";
  protected final String TEXT_597 = ".";
  protected final String TEXT_598 = ".eql?(self)" + NL + "      @";
  protected final String TEXT_599 = ".delete(";
  protected final String TEXT_600 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_601 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_602 = NL + "  def ";
  protected final String TEXT_603 = "(";
  protected final String TEXT_604 = ")" + NL + "    was_set = false";
  protected final String TEXT_605 = NL + "    if ";
  protected final String TEXT_606 = ".nil?";
  protected final String TEXT_607 = NL + "      ";
  protected final String TEXT_608 = " = @";
  protected final String TEXT_609 = NL + "      @";
  protected final String TEXT_610 = " = nil" + NL + "      " + NL + "      if !";
  protected final String TEXT_611 = ".nil? and !";
  protected final String TEXT_612 = ".";
  protected final String TEXT_613 = ".nil?";
  protected final String TEXT_614 = NL + "        ";
  protected final String TEXT_615 = ".";
  protected final String TEXT_616 = "(nil)" + NL + "      end" + NL + "      was_set = true";
  protected final String TEXT_617 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_618 = NL + "    ";
  protected final String TEXT_619 = " = self.";
  protected final String TEXT_620 = NL + "    if !";
  protected final String TEXT_621 = ".nil? and !";
  protected final String TEXT_622 = ".eql?(";
  protected final String TEXT_623 = ")";
  protected final String TEXT_624 = NL + "      ";
  protected final String TEXT_625 = ".";
  protected final String TEXT_626 = "(nil)" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_627 = " = ";
  protected final String TEXT_628 = NL + "    ";
  protected final String TEXT_629 = " = ";
  protected final String TEXT_630 = ".";
  protected final String TEXT_631 = NL + NL + "    unless self.eql?(";
  protected final String TEXT_632 = ")";
  protected final String TEXT_633 = NL + "      ";
  protected final String TEXT_634 = ".";
  protected final String TEXT_635 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_636 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_637 = NL + "  def ";
  protected final String TEXT_638 = "(";
  protected final String TEXT_639 = ")" + NL + "    was_removed = false";
  protected final String TEXT_640 = NL + "    unless @";
  protected final String TEXT_641 = ".include?(";
  protected final String TEXT_642 = ")";
  protected final String TEXT_643 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_644 = " <= ";
  protected final String TEXT_645 = ".";
  protected final String TEXT_646 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_647 = ".index(";
  protected final String TEXT_648 = ")" + NL + "    @";
  protected final String TEXT_649 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_650 = ".";
  protected final String TEXT_651 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_652 = ".";
  protected final String TEXT_653 = "(self)" + NL + "      @";
  protected final String TEXT_654 = ".insert(oldIndex,";
  protected final String TEXT_655 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_656 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_657 = NL + "  def ";
  protected final String TEXT_658 = "(";
  protected final String TEXT_659 = ")" + NL + "    was_removed = false";
  protected final String TEXT_660 = NL + "    unless @";
  protected final String TEXT_661 = ".include?(";
  protected final String TEXT_662 = ")";
  protected final String TEXT_663 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_664 = " <= ";
  protected final String TEXT_665 = ".";
  protected final String TEXT_666 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    oldIndex = @";
  protected final String TEXT_667 = ".index(";
  protected final String TEXT_668 = ")" + NL + "    @";
  protected final String TEXT_669 = ".delete_at(oldIndex)" + NL + "    if ";
  protected final String TEXT_670 = ".";
  protected final String TEXT_671 = "(self) == -1" + NL + "      was_removed = true" + NL + "    else" + NL + "      was_removed = ";
  protected final String TEXT_672 = ".";
  protected final String TEXT_673 = "(self)" + NL + "      @";
  protected final String TEXT_674 = ".insert(oldIndex,";
  protected final String TEXT_675 = ") unless was_removed" + NL + "    end";
  protected final String TEXT_676 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_677 = NL + "  def ";
  protected final String TEXT_678 = "(";
  protected final String TEXT_679 = ")" + NL + "    was_set = false";
  protected final String TEXT_680 = NL + "    if !";
  protected final String TEXT_681 = ".nil? and ";
  protected final String TEXT_682 = ".";
  protected final String TEXT_683 = " >= ";
  protected final String TEXT_684 = ".";
  protected final String TEXT_685 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_686 = NL + "    ";
  protected final String TEXT_687 = " = @";
  protected final String TEXT_688 = NL + "    @";
  protected final String TEXT_689 = " = ";
  protected final String TEXT_690 = NL + "    if !";
  protected final String TEXT_691 = ".nil? and !";
  protected final String TEXT_692 = ".eql?(";
  protected final String TEXT_693 = ")";
  protected final String TEXT_694 = NL + "      ";
  protected final String TEXT_695 = ".";
  protected final String TEXT_696 = "(self)" + NL + "    end" + NL + "    unless ";
  protected final String TEXT_697 = ".nil?";
  protected final String TEXT_698 = NL + "      ";
  protected final String TEXT_699 = ".";
  protected final String TEXT_700 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_701 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_702 = NL + "  def ";
  protected final String TEXT_703 = "(";
  protected final String TEXT_704 = ")" + NL + "    was_set = false";
  protected final String TEXT_705 = NL + "    if ";
  protected final String TEXT_706 = ".nil?";
  protected final String TEXT_707 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_708 = NL + "    ";
  protected final String TEXT_709 = " = @";
  protected final String TEXT_710 = NL + "    @";
  protected final String TEXT_711 = " = ";
  protected final String TEXT_712 = NL + "    if !";
  protected final String TEXT_713 = ".nil? and !";
  protected final String TEXT_714 = ".eql?(";
  protected final String TEXT_715 = ")";
  protected final String TEXT_716 = NL + "      ";
  protected final String TEXT_717 = ".";
  protected final String TEXT_718 = "(self)" + NL + "    end" + NL + "    @";
  protected final String TEXT_719 = ".";
  protected final String TEXT_720 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_721 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_722 = NL + "  def ";
  protected final String TEXT_723 = "(";
  protected final String TEXT_724 = ")" + NL + "    was_set = false";
  protected final String TEXT_725 = NL + "    # Must provide @";
  protected final String TEXT_726 = " to ";
  protected final String TEXT_727 = NL + "    if ";
  protected final String TEXT_728 = ".nil?";
  protected final String TEXT_729 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    # @";
  protected final String TEXT_730 = " already at maximum (";
  protected final String TEXT_731 = ")" + NL + "    if ";
  protected final String TEXT_732 = ".";
  protected final String TEXT_733 = " >= ";
  protected final String TEXT_734 = ".";
  protected final String TEXT_735 = NL + "      return was_set" + NL + "    end" + NL + "    ";
  protected final String TEXT_736 = NL + "    ";
  protected final String TEXT_737 = " = @";
  protected final String TEXT_738 = NL + "    @";
  protected final String TEXT_739 = " = ";
  protected final String TEXT_740 = NL + "    if !";
  protected final String TEXT_741 = ".nil? and !";
  protected final String TEXT_742 = ".eql?(";
  protected final String TEXT_743 = ")" + NL + "      didRemove = ";
  protected final String TEXT_744 = ".";
  protected final String TEXT_745 = "(self)" + NL + "      unless didRemove" + NL + "        @";
  protected final String TEXT_746 = " = ";
  protected final String TEXT_747 = NL + "        return was_set" + NL + "      end" + NL + "    end" + NL + "    @";
  protected final String TEXT_748 = ".";
  protected final String TEXT_749 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_750 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_751 = NL + "  def ";
  protected final String TEXT_752 = "(";
  protected final String TEXT_753 = ")" + NL + "    was_set = false";
  protected final String TEXT_754 = NL + "    # Must provide @";
  protected final String TEXT_755 = " to ";
  protected final String TEXT_756 = NL + "    if ";
  protected final String TEXT_757 = ".nil?";
  protected final String TEXT_758 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    if !@";
  protected final String TEXT_759 = ".nil? and @";
  protected final String TEXT_760 = ".";
  protected final String TEXT_761 = " <= ";
  protected final String TEXT_762 = ".";
  protected final String TEXT_763 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_764 = NL + "    ";
  protected final String TEXT_765 = " = @";
  protected final String TEXT_766 = NL + "    @";
  protected final String TEXT_767 = " = ";
  protected final String TEXT_768 = NL + "    if !";
  protected final String TEXT_769 = ".nil? and !";
  protected final String TEXT_770 = ".eql?(";
  protected final String TEXT_771 = ")" + NL + "      didRemove = ";
  protected final String TEXT_772 = ".";
  protected final String TEXT_773 = "(self)" + NL + "      unless didRemove" + NL + "        @";
  protected final String TEXT_774 = " = ";
  protected final String TEXT_775 = NL + "        return was_set" + NL + "      end" + NL + "    end" + NL + "    @";
  protected final String TEXT_776 = ".";
  protected final String TEXT_777 = "(self)" + NL + "    was_set = true";
  protected final String TEXT_778 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_779 = NL + "  def ";
  protected final String TEXT_780 = "(";
  protected final String TEXT_781 = ")" + NL + "    was_added = false";
  protected final String TEXT_782 = NL + "    ";
  protected final String TEXT_783 = " = ";
  protected final String TEXT_784 = ".";
  protected final String TEXT_785 = NL + "    if ";
  protected final String TEXT_786 = ".nil?";
  protected final String TEXT_787 = NL + "      ";
  protected final String TEXT_788 = ".";
  protected final String TEXT_789 = "(self)" + NL + "    elsif !";
  protected final String TEXT_790 = ".eql?(self)";
  protected final String TEXT_791 = NL + "      ";
  protected final String TEXT_792 = ".";
  protected final String TEXT_793 = "(";
  protected final String TEXT_794 = ")";
  protected final String TEXT_795 = NL + "      ";
  protected final String TEXT_796 = "(";
  protected final String TEXT_797 = ")" + NL + "    else" + NL + "      @";
  protected final String TEXT_798 = " << ";
  protected final String TEXT_799 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_800 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_801 = "(";
  protected final String TEXT_802 = ")" + NL + "    was_removed = false";
  protected final String TEXT_803 = NL + "    if @";
  protected final String TEXT_804 = ".include?(";
  protected final String TEXT_805 = ")" + NL + "      @";
  protected final String TEXT_806 = ".delete(";
  protected final String TEXT_807 = ")";
  protected final String TEXT_808 = NL + "      ";
  protected final String TEXT_809 = ".";
  protected final String TEXT_810 = "(nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_811 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_812 = NL + "  def ";
  protected final String TEXT_813 = "(";
  protected final String TEXT_814 = ")" + NL + "    was_set = false";
  protected final String TEXT_815 = NL + "    ";
  protected final String TEXT_816 = " = @";
  protected final String TEXT_817 = NL + "    @";
  protected final String TEXT_818 = " = ";
  protected final String TEXT_819 = NL + "    if !";
  protected final String TEXT_820 = ".nil? and !";
  protected final String TEXT_821 = ".eql?(";
  protected final String TEXT_822 = ")";
  protected final String TEXT_823 = NL + "      ";
  protected final String TEXT_824 = ".";
  protected final String TEXT_825 = "(self)" + NL + "    end" + NL + "    unless ";
  protected final String TEXT_826 = ".nil?";
  protected final String TEXT_827 = NL + "      ";
  protected final String TEXT_828 = ".";
  protected final String TEXT_829 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_830 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_831 = NL + "  def ";
  protected final String TEXT_832 = "(";
  protected final String TEXT_833 = ")" + NL + "    was_added = false";
  protected final String TEXT_834 = NL + "    if ";
  protected final String TEXT_835 = " >= ";
  protected final String TEXT_836 = ".";
  protected final String TEXT_837 = NL + "      return was_added" + NL + "    end" + NL;
  protected final String TEXT_838 = NL + "    ";
  protected final String TEXT_839 = " = ";
  protected final String TEXT_840 = ".";
  protected final String TEXT_841 = NL + "    if ";
  protected final String TEXT_842 = ".nil?";
  protected final String TEXT_843 = NL + "      ";
  protected final String TEXT_844 = ".";
  protected final String TEXT_845 = "(self)" + NL + "    elsif !";
  protected final String TEXT_846 = ".eql?(self)";
  protected final String TEXT_847 = NL + "      ";
  protected final String TEXT_848 = ".";
  protected final String TEXT_849 = "(";
  protected final String TEXT_850 = ")";
  protected final String TEXT_851 = NL + "      ";
  protected final String TEXT_852 = "(";
  protected final String TEXT_853 = ")" + NL + "    else" + NL + "      @";
  protected final String TEXT_854 = " << ";
  protected final String TEXT_855 = NL + "    end" + NL + "    was_added = true";
  protected final String TEXT_856 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_857 = "(";
  protected final String TEXT_858 = ")" + NL + "    was_removed = false";
  protected final String TEXT_859 = NL + "    if @";
  protected final String TEXT_860 = ".include?(";
  protected final String TEXT_861 = ")" + NL + "      @";
  protected final String TEXT_862 = ".delete(";
  protected final String TEXT_863 = ")";
  protected final String TEXT_864 = NL + "      ";
  protected final String TEXT_865 = ".";
  protected final String TEXT_866 = "(nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_867 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_868 = NL + "  def ";
  protected final String TEXT_869 = "(";
  protected final String TEXT_870 = ")" + NL + "    was_added = false";
  protected final String TEXT_871 = NL + "    if ";
  protected final String TEXT_872 = " < ";
  protected final String TEXT_873 = ".";
  protected final String TEXT_874 = NL + "      @";
  protected final String TEXT_875 = " << ";
  protected final String TEXT_876 = NL + "      was_added = true" + NL + "    end";
  protected final String TEXT_877 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_878 = "(";
  protected final String TEXT_879 = ")" + NL + "    was_removed = false";
  protected final String TEXT_880 = NL + "    unless @";
  protected final String TEXT_881 = ".include?(";
  protected final String TEXT_882 = ")";
  protected final String TEXT_883 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_884 = " <= ";
  protected final String TEXT_885 = ".";
  protected final String TEXT_886 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_887 = ".delete(";
  protected final String TEXT_888 = ")" + NL + "    was_removed = true";
  protected final String TEXT_889 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_890 = NL + "  def ";
  protected final String TEXT_891 = "(";
  protected final String TEXT_892 = ")" + NL + "    was_added = false";
  protected final String TEXT_893 = NL + "    if ";
  protected final String TEXT_894 = " >= ";
  protected final String TEXT_895 = ".";
  protected final String TEXT_896 = NL + "      return was_added" + NL + "    end";
  protected final String TEXT_897 = NL + "    ";
  protected final String TEXT_898 = " = ";
  protected final String TEXT_899 = ".";
  protected final String TEXT_900 = NL + "    if !";
  protected final String TEXT_901 = ".nil? and ";
  protected final String TEXT_902 = ".";
  protected final String TEXT_903 = " <= ";
  protected final String TEXT_904 = ".";
  protected final String TEXT_905 = NL + "      return was_added" + NL + "    elsif !";
  protected final String TEXT_906 = ".nil?";
  protected final String TEXT_907 = NL + "      ";
  protected final String TEXT_908 = ".instance_variable_get(\"@";
  protected final String TEXT_909 = "\").delete(";
  protected final String TEXT_910 = ")" + NL + "    end" + NL + "    @";
  protected final String TEXT_911 = " << ";
  protected final String TEXT_912 = NL + "    ";
  protected final String TEXT_913 = ".instance_variable_set(\"@";
  protected final String TEXT_914 = "\",self)" + NL + "    was_added = true";
  protected final String TEXT_915 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_916 = "(";
  protected final String TEXT_917 = ")" + NL + "    was_removed = false";
  protected final String TEXT_918 = NL + "    if @";
  protected final String TEXT_919 = ".include?(";
  protected final String TEXT_920 = ") and ";
  protected final String TEXT_921 = " > ";
  protected final String TEXT_922 = ".";
  protected final String TEXT_923 = NL + "      @";
  protected final String TEXT_924 = ".delete(";
  protected final String TEXT_925 = ")";
  protected final String TEXT_926 = NL + "      ";
  protected final String TEXT_927 = ".instance_variable_set(\"@";
  protected final String TEXT_928 = "\",nil)" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_929 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_930 = NL + "  def ";
  protected final String TEXT_931 = "(";
  protected final String TEXT_932 = ")" + NL + "    was_set = false";
  protected final String TEXT_933 = NL + "    ";
  protected final String TEXT_934 = " = []";
  protected final String TEXT_935 = NL + "    ";
  protected final String TEXT_936 = ".each do |";
  protected final String TEXT_937 = "|" + NL + "      if ";
  protected final String TEXT_938 = ".include?(";
  protected final String TEXT_939 = ")";
  protected final String TEXT_940 = NL + "        return was_set" + NL + "      elsif !";
  protected final String TEXT_941 = ".";
  protected final String TEXT_942 = ".nil? and !";
  protected final String TEXT_943 = ".";
  protected final String TEXT_944 = ".eql?(self)";
  protected final String TEXT_945 = NL + "        return was_set" + NL + "      end";
  protected final String TEXT_946 = NL + "      ";
  protected final String TEXT_947 = " << ";
  protected final String TEXT_948 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_949 = ".size != ";
  protected final String TEXT_950 = ".";
  protected final String TEXT_951 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_952 = NL + "    ";
  protected final String TEXT_953 = ".each do |";
  protected final String TEXT_954 = "|" + NL + "      @";
  protected final String TEXT_955 = ".delete(";
  protected final String TEXT_956 = ")" + NL + "    end" + NL + "    " + NL + "    @";
  protected final String TEXT_957 = ".each do |orphan|" + NL + "      orphan.instance_variable_set(\"@";
  protected final String TEXT_958 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_959 = ".clear";
  protected final String TEXT_960 = NL + "    ";
  protected final String TEXT_961 = ".each do |";
  protected final String TEXT_962 = "|";
  protected final String TEXT_963 = NL + "      ";
  protected final String TEXT_964 = ".instance_variable_set(\"@";
  protected final String TEXT_965 = "\",self)" + NL + "      @";
  protected final String TEXT_966 = " << ";
  protected final String TEXT_967 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_968 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_969 = NL + "  def ";
  protected final String TEXT_970 = "(";
  protected final String TEXT_971 = ")" + NL + "    was_added = false";
  protected final String TEXT_972 = NL + "    @";
  protected final String TEXT_973 = " << ";
  protected final String TEXT_974 = NL + "    was_added = true";
  protected final String TEXT_975 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_976 = "(";
  protected final String TEXT_977 = ")" + NL + "    was_removed = false";
  protected final String TEXT_978 = NL + "    if @";
  protected final String TEXT_979 = ".include?(";
  protected final String TEXT_980 = ")" + NL + "      @";
  protected final String TEXT_981 = ".delete(";
  protected final String TEXT_982 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_983 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_984 = NL + "  def ";
  protected final String TEXT_985 = "(";
  protected final String TEXT_986 = ")" + NL + "    was_added = false";
  protected final String TEXT_987 = NL + "    if ";
  protected final String TEXT_988 = " < ";
  protected final String TEXT_989 = ".";
  protected final String TEXT_990 = NL + "      @";
  protected final String TEXT_991 = " << ";
  protected final String TEXT_992 = NL + "      was_added = true" + NL + "    end";
  protected final String TEXT_993 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_994 = "(";
  protected final String TEXT_995 = ")" + NL + "    was_removed = false";
  protected final String TEXT_996 = NL + "    if @";
  protected final String TEXT_997 = ".include?(";
  protected final String TEXT_998 = ")" + NL + "      @";
  protected final String TEXT_999 = ".delete(";
  protected final String TEXT_1000 = ")" + NL + "      was_removed = true" + NL + "    end";
  protected final String TEXT_1001 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_1002 = NL + "  def ";
  protected final String TEXT_1003 = "(";
  protected final String TEXT_1004 = ")" + NL + "    was_added = false";
  protected final String TEXT_1005 = NL + "    @";
  protected final String TEXT_1006 = " << ";
  protected final String TEXT_1007 = NL + "    was_added = true";
  protected final String TEXT_1008 = NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1009 = "(";
  protected final String TEXT_1010 = ")" + NL + "    was_removed = false";
  protected final String TEXT_1011 = NL + "    unless @";
  protected final String TEXT_1012 = ".include?(";
  protected final String TEXT_1013 = ")";
  protected final String TEXT_1014 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1015 = " <= ";
  protected final String TEXT_1016 = ".";
  protected final String TEXT_1017 = NL + "      return was_removed" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1018 = ".delete(";
  protected final String TEXT_1019 = ")" + NL + "    was_removed = true";
  protected final String TEXT_1020 = NL + "    was_removed" + NL + "  end" + NL;
  protected final String TEXT_1021 = NL + "  def ";
  protected final String TEXT_1022 = "(";
  protected final String TEXT_1023 = ")" + NL + "    was_set = false";
  protected final String TEXT_1024 = NL + "    ";
  protected final String TEXT_1025 = " = []";
  protected final String TEXT_1026 = NL + "    ";
  protected final String TEXT_1027 = ".each do |";
  protected final String TEXT_1028 = "|" + NL + "      next if (";
  protected final String TEXT_1029 = ".include?(";
  protected final String TEXT_1030 = "))";
  protected final String TEXT_1031 = NL + "      ";
  protected final String TEXT_1032 = " << ";
  protected final String TEXT_1033 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1034 = ".size != ";
  protected final String TEXT_1035 = ".size or ";
  protected final String TEXT_1036 = ".size() != ";
  protected final String TEXT_1037 = ".";
  protected final String TEXT_1038 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1039 = ".clear";
  protected final String TEXT_1040 = NL + "    ";
  protected final String TEXT_1041 = ".each do |";
  protected final String TEXT_1042 = "|" + NL + "      @";
  protected final String TEXT_1043 = " << ";
  protected final String TEXT_1044 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1045 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1046 = NL + "  def ";
  protected final String TEXT_1047 = "(";
  protected final String TEXT_1048 = ")" + NL + "    was_set = false";
  protected final String TEXT_1049 = NL + "    ";
  protected final String TEXT_1050 = " = []";
  protected final String TEXT_1051 = NL + "    ";
  protected final String TEXT_1052 = ".each do |";
  protected final String TEXT_1053 = "|" + NL + "      next if (";
  protected final String TEXT_1054 = ".include?(";
  protected final String TEXT_1055 = "))";
  protected final String TEXT_1056 = NL + "      ";
  protected final String TEXT_1057 = " << ";
  protected final String TEXT_1058 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1059 = ".size != ";
  protected final String TEXT_1060 = ".size";
  protected final String TEXT_1061 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1062 = ".clear";
  protected final String TEXT_1063 = NL + "    ";
  protected final String TEXT_1064 = ".each do |";
  protected final String TEXT_1065 = "|" + NL + "      @";
  protected final String TEXT_1066 = " << ";
  protected final String TEXT_1067 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1068 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1069 = NL + "  def ";
  protected final String TEXT_1070 = "(";
  protected final String TEXT_1071 = ")" + NL + "    #" + NL + "    # self source of self source generation is association_SetOptionalOneToMandatoryMany.jet" + NL + "    # self set file assumes the generation of a maximumNumberOfXXX method does not exist because " + NL + "    # it's not required (No upper bound)" + NL + "    #   " + NL + "    " + NL + "    wasSet = false" + NL + "    ";
  protected final String TEXT_1072 = NL + "    ";
  protected final String TEXT_1073 = " = ";
  protected final String TEXT_1074 = ";" + NL + "\t" + NL + "    if ";
  protected final String TEXT_1075 = ".nil?" + NL + "      if !";
  protected final String TEXT_1076 = ".nil" + NL + "        if ";
  protected final String TEXT_1077 = ".";
  protected final String TEXT_1078 = "(self)";
  protected final String TEXT_1079 = NL + "          ";
  protected final String TEXT_1080 = " = ";
  protected final String TEXT_1081 = NL + "          wasSet = true" + NL + "        end" + NL + "      end" + NL + "    elsif ";
  protected final String TEXT_1082 = " != null" + NL + "      if ";
  protected final String TEXT_1083 = " == null" + NL + "        if ";
  protected final String TEXT_1084 = ".";
  protected final String TEXT_1085 = "() < ";
  protected final String TEXT_1086 = ".";
  protected final String TEXT_1087 = "()";
  protected final String TEXT_1088 = NL + "          ";
  protected final String TEXT_1089 = ".";
  protected final String TEXT_1090 = "(self);";
  protected final String TEXT_1091 = NL + "          ";
  protected final String TEXT_1092 = " = ";
  protected final String TEXT_1093 = ";  # ";
  protected final String TEXT_1094 = " == null" + NL + "          wasSet = true;" + NL + "        end" + NL + "      else" + NL + "        if ";
  protected final String TEXT_1095 = ".";
  protected final String TEXT_1096 = "() < ";
  protected final String TEXT_1097 = ".";
  protected final String TEXT_1098 = "()";
  protected final String TEXT_1099 = NL + "          ";
  protected final String TEXT_1100 = ".";
  protected final String TEXT_1101 = "(self);";
  protected final String TEXT_1102 = NL + "          ";
  protected final String TEXT_1103 = ".";
  protected final String TEXT_1104 = "(self);";
  protected final String TEXT_1105 = NL + "          ";
  protected final String TEXT_1106 = " = ";
  protected final String TEXT_1107 = ";" + NL + "          wasSet = true;" + NL + "        end" + NL + "      end" + NL + "    end" + NL + "    " + NL + "    if wasSet == true";
  protected final String TEXT_1108 = NL + "      ";
  protected final String TEXT_1109 = " = ";
  protected final String TEXT_1110 = ";" + NL + "    end" + NL + "    " + NL + "    return wasSet;" + NL + "  end" + NL + "  ";
  protected final String TEXT_1111 = NL + "#  def ";
  protected final String TEXT_1112 = NL + "#  " + NL + "#    #" + NL + "#    # The source of the code generation is association_SetOptionalOneToMN.jet" + NL + "#    # (this) set file assumes the generation of a maximumNumberOfXXX " + NL + "#    #   method ";
  protected final String TEXT_1113 = NL + "#    # Currently this will not compile due to Issue351 - the template code is fine." + NL + "#    #" + NL + "#    wasSet = false" + NL + "#" + NL + "#    ";
  protected final String TEXT_1114 = " = ";
  protected final String TEXT_1115 = NL + "#\t" + NL + "#    if ";
  protected final String TEXT_1116 = " == null" + NL + "#      if ";
  protected final String TEXT_1117 = " != null" + NL + "#        if ";
  protected final String TEXT_1118 = ".";
  protected final String TEXT_1119 = "(self)" + NL + "#          ";
  protected final String TEXT_1120 = " = ";
  protected final String TEXT_1121 = NL + "#          wasSet = true" + NL + "#        end" + NL + "#      end" + NL + "#    else if ";
  protected final String TEXT_1122 = " != null" + NL + "#      if ";
  protected final String TEXT_1123 = " == null" + NL + "#        if ";
  protected final String TEXT_1124 = ".";
  protected final String TEXT_1125 = " < ";
  protected final String TEXT_1126 = ".";
  protected final String TEXT_1127 = NL + "#          ";
  protected final String TEXT_1128 = ".";
  protected final String TEXT_1129 = "(self)" + NL + "#          ";
  protected final String TEXT_1130 = " = ";
  protected final String TEXT_1131 = "  # ";
  protected final String TEXT_1132 = " == null" + NL + "#          wasSet = true" + NL + "#        end" + NL + "#      else" + NL + "#        if     ";
  protected final String TEXT_1133 = ".";
  protected final String TEXT_1134 = " < ";
  protected final String TEXT_1135 = ".";
  protected final String TEXT_1136 = "()" + NL + "#            && ";
  protected final String TEXT_1137 = ".";
  protected final String TEXT_1138 = " > ";
  protected final String TEXT_1139 = ".";
  protected final String TEXT_1140 = "()" + NL + "#          ";
  protected final String TEXT_1141 = ".";
  protected final String TEXT_1142 = "(self)" + NL + "#          ";
  protected final String TEXT_1143 = ".";
  protected final String TEXT_1144 = "(self)" + NL + "#          ";
  protected final String TEXT_1145 = " = ";
  protected final String TEXT_1146 = NL + "#          wasSet = true" + NL + "#        end" + NL + "#      end" + NL + "#    end" + NL + "#    " + NL + "#    if wasSet" + NL + "#      ";
  protected final String TEXT_1147 = " = ";
  protected final String TEXT_1148 = NL + "#    end" + NL + "#    " + NL + "#    return wasSet" + NL + "#  end";
  protected final String TEXT_1149 = NL + "  def ";
  protected final String TEXT_1150 = "(";
  protected final String TEXT_1151 = ")" + NL + "    was_set = false";
  protected final String TEXT_1152 = NL + "    ";
  protected final String TEXT_1153 = " = []";
  protected final String TEXT_1154 = NL + "    ";
  protected final String TEXT_1155 = ".each do |";
  protected final String TEXT_1156 = "|" + NL + "      next if (";
  protected final String TEXT_1157 = ".include?(";
  protected final String TEXT_1158 = ")) ";
  protected final String TEXT_1159 = NL + "      ";
  protected final String TEXT_1160 = " << ";
  protected final String TEXT_1161 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1162 = ".size != ";
  protected final String TEXT_1163 = ".length or ";
  protected final String TEXT_1164 = ".size < ";
  protected final String TEXT_1165 = ".";
  protected final String TEXT_1166 = " or ";
  protected final String TEXT_1167 = ".size() > ";
  protected final String TEXT_1168 = ".";
  protected final String TEXT_1169 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1170 = NL + "    ";
  protected final String TEXT_1171 = " = @";
  protected final String TEXT_1172 = ".dup" + NL + "    @";
  protected final String TEXT_1173 = ".clear";
  protected final String TEXT_1174 = NL + "    ";
  protected final String TEXT_1175 = ".each do |";
  protected final String TEXT_1176 = "|" + NL + "      @";
  protected final String TEXT_1177 = " << ";
  protected final String TEXT_1178 = NL + "      if ";
  protected final String TEXT_1179 = ".include?(";
  protected final String TEXT_1180 = ")";
  protected final String TEXT_1181 = NL + "        ";
  protected final String TEXT_1182 = ".delete(";
  protected final String TEXT_1183 = ")" + NL + "      else";
  protected final String TEXT_1184 = NL + "        ";
  protected final String TEXT_1185 = ".";
  protected final String TEXT_1186 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_1187 = NL + "    ";
  protected final String TEXT_1188 = ".each do |";
  protected final String TEXT_1189 = "|";
  protected final String TEXT_1190 = NL + "      ";
  protected final String TEXT_1191 = ".";
  protected final String TEXT_1192 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1193 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1194 = NL + "  def ";
  protected final String TEXT_1195 = "(";
  protected final String TEXT_1196 = ")" + NL + "    was_set = false";
  protected final String TEXT_1197 = NL + "    ";
  protected final String TEXT_1198 = " = []";
  protected final String TEXT_1199 = NL + "    ";
  protected final String TEXT_1200 = ".each do |";
  protected final String TEXT_1201 = "|" + NL + "      next if (";
  protected final String TEXT_1202 = ".include?(";
  protected final String TEXT_1203 = "))";
  protected final String TEXT_1204 = NL + "      ";
  protected final String TEXT_1205 = " << ";
  protected final String TEXT_1206 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1207 = ".size != ";
  protected final String TEXT_1208 = ".size or ";
  protected final String TEXT_1209 = ".size < ";
  protected final String TEXT_1210 = ".";
  protected final String TEXT_1211 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1212 = NL + "    ";
  protected final String TEXT_1213 = " = @";
  protected final String TEXT_1214 = ".dup" + NL + "    @";
  protected final String TEXT_1215 = ".clear";
  protected final String TEXT_1216 = NL + "    ";
  protected final String TEXT_1217 = ".each do |";
  protected final String TEXT_1218 = "|" + NL + "      @";
  protected final String TEXT_1219 = " << ";
  protected final String TEXT_1220 = NL + "      if ";
  protected final String TEXT_1221 = ".include?(";
  protected final String TEXT_1222 = ")";
  protected final String TEXT_1223 = NL + "        ";
  protected final String TEXT_1224 = ".delete(";
  protected final String TEXT_1225 = ")" + NL + "      else";
  protected final String TEXT_1226 = NL + "        ";
  protected final String TEXT_1227 = ".";
  protected final String TEXT_1228 = "(self)" + NL + "      end" + NL + "    end" + NL;
  protected final String TEXT_1229 = NL + "    ";
  protected final String TEXT_1230 = ".each do |";
  protected final String TEXT_1231 = "|";
  protected final String TEXT_1232 = NL + "      ";
  protected final String TEXT_1233 = ".";
  protected final String TEXT_1234 = "(self)" + NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1235 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1236 = NL + "  def ";
  protected final String TEXT_1237 = "(";
  protected final String TEXT_1238 = ")" + NL + "    was_set = false";
  protected final String TEXT_1239 = NL + "    ";
  protected final String TEXT_1240 = " = []";
  protected final String TEXT_1241 = NL + "    ";
  protected final String TEXT_1242 = ".each do |";
  protected final String TEXT_1243 = "|" + NL + "      next if (";
  protected final String TEXT_1244 = ".include?(";
  protected final String TEXT_1245 = "))";
  protected final String TEXT_1246 = NL + "      ";
  protected final String TEXT_1247 = " << ";
  protected final String TEXT_1248 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1249 = ".size != ";
  protected final String TEXT_1250 = ".size or ";
  protected final String TEXT_1251 = ".size < ";
  protected final String TEXT_1252 = ".";
  protected final String TEXT_1253 = " or ";
  protected final String TEXT_1254 = ".size > ";
  protected final String TEXT_1255 = ".";
  protected final String TEXT_1256 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1257 = ".clear";
  protected final String TEXT_1258 = NL + "    ";
  protected final String TEXT_1259 = ".each do |";
  protected final String TEXT_1260 = "|" + NL + "      @";
  protected final String TEXT_1261 = " << ";
  protected final String TEXT_1262 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1263 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1264 = NL + "  def ";
  protected final String TEXT_1265 = "(";
  protected final String TEXT_1266 = ")" + NL + "    was_set = false";
  protected final String TEXT_1267 = NL + "    if ";
  protected final String TEXT_1268 = ".length < ";
  protected final String TEXT_1269 = ".";
  protected final String TEXT_1270 = NL + "      return was_set" + NL + "    end" + NL;
  protected final String TEXT_1271 = NL + "    ";
  protected final String TEXT_1272 = " = []";
  protected final String TEXT_1273 = NL + "    ";
  protected final String TEXT_1274 = " = {}";
  protected final String TEXT_1275 = NL + "    ";
  protected final String TEXT_1276 = ".each do |";
  protected final String TEXT_1277 = "|" + NL + "      if ";
  protected final String TEXT_1278 = ".include?(";
  protected final String TEXT_1279 = ")";
  protected final String TEXT_1280 = NL + "        return was_set" + NL + "      elsif !";
  protected final String TEXT_1281 = ".";
  protected final String TEXT_1282 = ".nil? and !";
  protected final String TEXT_1283 = ".";
  protected final String TEXT_1284 = ".eql?(self)";
  protected final String TEXT_1285 = NL + "        ";
  protected final String TEXT_1286 = " = ";
  protected final String TEXT_1287 = ".";
  protected final String TEXT_1288 = NL + "        unless ";
  protected final String TEXT_1289 = ".has_key?(";
  protected final String TEXT_1290 = ")";
  protected final String TEXT_1291 = NL + "          ";
  protected final String TEXT_1292 = "[";
  protected final String TEXT_1293 = "] = ";
  protected final String TEXT_1294 = ".";
  protected final String TEXT_1295 = NL + "        end" + NL + "        currentCount = ";
  protected final String TEXT_1296 = "[";
  protected final String TEXT_1297 = "]" + NL + "        nextCount = currentCount - 1" + NL + "        if nextCount < ";
  protected final String TEXT_1298 = NL + "          return was_set" + NL + "        end";
  protected final String TEXT_1299 = NL + "        ";
  protected final String TEXT_1300 = "[";
  protected final String TEXT_1301 = "] = nextCount" + NL + "      end";
  protected final String TEXT_1302 = NL + "      ";
  protected final String TEXT_1303 = " << ";
  protected final String TEXT_1304 = NL + "    end" + NL;
  protected final String TEXT_1305 = NL + "    ";
  protected final String TEXT_1306 = ".each do |";
  protected final String TEXT_1307 = "|" + NL + "      @";
  protected final String TEXT_1308 = ".delete(";
  protected final String TEXT_1309 = ")" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1310 = ".each do |orphan|" + NL + "      orphan.instance_variable_set(\"@";
  protected final String TEXT_1311 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_1312 = ".clear";
  protected final String TEXT_1313 = NL + "    ";
  protected final String TEXT_1314 = ".each do |";
  protected final String TEXT_1315 = "|" + NL + "      unless ";
  protected final String TEXT_1316 = ".";
  protected final String TEXT_1317 = ".nil?";
  protected final String TEXT_1318 = NL + "        ";
  protected final String TEXT_1319 = ".";
  protected final String TEXT_1320 = ".instance_variable_get(\"@";
  protected final String TEXT_1321 = "\").delete(";
  protected final String TEXT_1322 = ")" + NL + "      end";
  protected final String TEXT_1323 = NL + "      ";
  protected final String TEXT_1324 = ".instance_variable_set(\"@";
  protected final String TEXT_1325 = "\",self)" + NL + "      @";
  protected final String TEXT_1326 = " << ";
  protected final String TEXT_1327 = NL + "    end" + NL + "    was_set = true";
  protected final String TEXT_1328 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1329 = NL + "  def ";
  protected final String TEXT_1330 = "(";
  protected final String TEXT_1331 = ")" + NL + "    was_set = false";
  protected final String TEXT_1332 = NL + "    ";
  protected final String TEXT_1333 = " = []";
  protected final String TEXT_1334 = NL + "    ";
  protected final String TEXT_1335 = ".each do |";
  protected final String TEXT_1336 = "|" + NL + "      next if (";
  protected final String TEXT_1337 = ".include?(";
  protected final String TEXT_1338 = "))";
  protected final String TEXT_1339 = NL + "      ";
  protected final String TEXT_1340 = " << ";
  protected final String TEXT_1341 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1342 = ".size != ";
  protected final String TEXT_1343 = ".size or ";
  protected final String TEXT_1344 = ".size() > ";
  protected final String TEXT_1345 = ".";
  protected final String TEXT_1346 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1347 = ".clear";
  protected final String TEXT_1348 = NL + "    ";
  protected final String TEXT_1349 = ".each do |";
  protected final String TEXT_1350 = "|" + NL + "      @";
  protected final String TEXT_1351 = " << ";
  protected final String TEXT_1352 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1353 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1354 = NL + "  def ";
  protected final String TEXT_1355 = "(";
  protected final String TEXT_1356 = ")" + NL + "    was_set = false";
  protected final String TEXT_1357 = NL + "    ";
  protected final String TEXT_1358 = " = []";
  protected final String TEXT_1359 = NL + "    ";
  protected final String TEXT_1360 = ".each do |";
  protected final String TEXT_1361 = "|" + NL + "      next if (";
  protected final String TEXT_1362 = ".include?(";
  protected final String TEXT_1363 = "))";
  protected final String TEXT_1364 = NL + "      ";
  protected final String TEXT_1365 = " << ";
  protected final String TEXT_1366 = NL + "    end" + NL + "" + NL + "    if ";
  protected final String TEXT_1367 = ".size != ";
  protected final String TEXT_1368 = ".size or ";
  protected final String TEXT_1369 = ".size() < ";
  protected final String TEXT_1370 = ".";
  protected final String TEXT_1371 = NL + "      return was_set" + NL + "    end" + NL + "" + NL + "    @";
  protected final String TEXT_1372 = ".clear";
  protected final String TEXT_1373 = NL + "    ";
  protected final String TEXT_1374 = ".each do |";
  protected final String TEXT_1375 = "|" + NL + "      @";
  protected final String TEXT_1376 = " << ";
  protected final String TEXT_1377 = NL + "    end" + NL + "" + NL + "    was_set = true";
  protected final String TEXT_1378 = NL + "    was_set" + NL + "  end" + NL;
  protected final String TEXT_1379 = NL;
  protected final String TEXT_1380 = NL + "  def ";
  protected final String TEXT_1381 = "(";
  protected final String TEXT_1382 = ", index)" + NL + "    was_added = false" + NL + "    if ";
  protected final String TEXT_1383 = "(";
  protected final String TEXT_1384 = ")" + NL + "      if(index < 0)" + NL + "        index = 0" + NL + "      end" + NL + "      if(index > ";
  protected final String TEXT_1385 = "())" + NL + "        index = ";
  protected final String TEXT_1386 = "() - 1" + NL + "      end" + NL + "      @";
  protected final String TEXT_1387 = ".delete(";
  protected final String TEXT_1388 = ")" + NL + "      @";
  protected final String TEXT_1389 = ".insert(index, ";
  protected final String TEXT_1390 = ")" + NL + "      was_added = true" + NL + "    end" + NL + "    was_added" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1391 = "(";
  protected final String TEXT_1392 = ", index)" + NL + "    was_added = false" + NL + "    if @";
  protected final String TEXT_1393 = ".include?(";
  protected final String TEXT_1394 = ")" + NL + "      if(index < 0)" + NL + "        index = 0" + NL + "      end" + NL + "      if(index > ";
  protected final String TEXT_1395 = "())" + NL + "        index = ";
  protected final String TEXT_1396 = "() - 1" + NL + "      end" + NL + "      @";
  protected final String TEXT_1397 = ".delete(";
  protected final String TEXT_1398 = ")" + NL + "      @";
  protected final String TEXT_1399 = ".insert(index, ";
  protected final String TEXT_1400 = ")" + NL + "      was_added = true" + NL + "    else" + NL + "      was_added = ";
  protected final String TEXT_1401 = "(";
  protected final String TEXT_1402 = ", index)" + NL + "    end" + NL + "    was_added" + NL + "  end" + NL;
  protected final String TEXT_1403 = NL + "  def eql?(obj)" + NL + "    return false if obj.nil?" + NL + "    return false unless self.class == obj.class" + NL + "" + NL + "    compareTo = obj";
  protected final String TEXT_1404 = NL + "    ";
  protected final String TEXT_1405 = NL + "    true" + NL + "  end" + NL + "" + NL + "  def hash" + NL + "    return @cachedHashCode unless @cachedHashCode == -1" + NL + "    @cachedHashCode = 17";
  protected final String TEXT_1406 = NL + "    ";
  protected final String TEXT_1407 = NL + "    ";
  protected final String TEXT_1408 = NL + "    @cachedHashCode" + NL + "  end" + NL;
  protected final String TEXT_1409 = NL + "  def ";
  protected final String TEXT_1410 = NL + "    ";
  protected final String TEXT_1411 = NL + "  end" + NL;
  protected final String TEXT_1412 = NL + "  private static class DoActivityThread extends Thread" + NL + "  {";
  protected final String TEXT_1413 = NL + "    ";
  protected final String TEXT_1414 = " controller;" + NL + "    String doActivityMethodName;" + NL + "    " + NL + "    public DoActivityThread(";
  protected final String TEXT_1415 = " aController,String aDoActivityMethodName)" + NL + "    {" + NL + "      controller = aController;" + NL + "      doActivityMethodName = aDoActivityMethodName;" + NL + "      start();" + NL + "    }" + NL + "    " + NL + "    def run()" + NL + "    {" + NL + "      try" + NL + "      {";
  protected final String TEXT_1416 = NL + "        ";
  protected final String TEXT_1417 = NL + "      }" + NL + "      catch (InterruptedException e)" + NL + "      {" + NL + "        e.printStackTrace();" + NL + "      }" + NL + "    }" + NL + "  }" + NL;
  protected final String TEXT_1418 = NL + "  def ";
  protected final String TEXT_1419 = NL + "    ";
  protected final String TEXT_1420 = " = new TimedEventHandler(this,\"";
  protected final String TEXT_1421 = "\",";
  protected final String TEXT_1422 = ")" + NL + "  end" + NL + "" + NL + "  def ";
  protected final String TEXT_1423 = NL + "    ";
  protected final String TEXT_1424 = ".stop()" + NL + "  end" + NL;
  protected final String TEXT_1425 = NL + "  public static class TimedEventHandler extends TimerTask  " + NL + "  {" + NL + "    private ";
  protected final String TEXT_1426 = " controller;" + NL + "    private String timeoutMethodName;" + NL + "    private double howLongInSeconds;" + NL + "    private Timer timer;" + NL + "    " + NL + "    public TimedEventHandler(";
  protected final String TEXT_1427 = " aController, String aTimeoutMethodName, double aHowLongInSeconds)" + NL + "    {" + NL + "      controller = aController;" + NL + "      timeoutMethodName = aTimeoutMethodName;" + NL + "      howLongInSeconds = aHowLongInSeconds;" + NL + "      timer = new Timer();" + NL + "      timer.schedule(this, (long)howLongInSeconds*1000);" + NL + "    }" + NL + "    " + NL + "    def stop" + NL + "      timer.cancel();" + NL + "    end" + NL + "    " + NL + "    def run";
  protected final String TEXT_1428 = NL + "      if (\"";
  protected final String TEXT_1429 = "\".eql?(timeoutMethodName))" + NL + "      {" + NL + "        shouldRestart = !controller.";
  protected final String TEXT_1430 = NL + "        if (shouldRestart)" + NL + "        {" + NL + "          controller.";
  protected final String TEXT_1431 = NL + "        }" + NL + "        return;" + NL + "      }";
  protected final String TEXT_1432 = NL + "    end" + NL + "  }" + NL;
  protected final String TEXT_1433 = NL + "    @";
  protected final String TEXT_1434 = " = nil";
  protected final String TEXT_1435 = NL + "    @";
  protected final String TEXT_1436 = ".clear";
  protected final String TEXT_1437 = NL + "    ";
  protected final String TEXT_1438 = " = @";
  protected final String TEXT_1439 = NL + "    @";
  protected final String TEXT_1440 = " = nil" + NL + "    unless ";
  protected final String TEXT_1441 = ".nil?";
  protected final String TEXT_1442 = NL + "      ";
  protected final String TEXT_1443 = ".delete" + NL + "    end";
  protected final String TEXT_1444 = NL + "    unless @";
  protected final String TEXT_1445 = ".nil?" + NL + "      @";
  protected final String TEXT_1446 = ".";
  protected final String TEXT_1447 = "(nil)" + NL + "    end";
  protected final String TEXT_1448 = NL + "    ";
  protected final String TEXT_1449 = " = @";
  protected final String TEXT_1450 = NL + "    @";
  protected final String TEXT_1451 = " = nil" + NL + "    unless ";
  protected final String TEXT_1452 = ".nil?";
  protected final String TEXT_1453 = NL + "      ";
  protected final String TEXT_1454 = ".";
  protected final String TEXT_1455 = "(nil)" + NL + "    end";
  protected final String TEXT_1456 = NL + "    ";
  protected final String TEXT_1457 = " = @";
  protected final String TEXT_1458 = NL + "    @";
  protected final String TEXT_1459 = " = nil" + NL + "    unless ";
  protected final String TEXT_1460 = ".nil?";
  protected final String TEXT_1461 = NL + "      ";
  protected final String TEXT_1462 = ".delete" + NL + "    end";
  protected final String TEXT_1463 = NL + "    unless @";
  protected final String TEXT_1464 = ".nil?" + NL + "      @";
  protected final String TEXT_1465 = ".";
  protected final String TEXT_1466 = "(self)" + NL + "    end";
  protected final String TEXT_1467 = NL + "    unless @";
  protected final String TEXT_1468 = ".nil?" + NL + "      @";
  protected final String TEXT_1469 = ".delete" + NL + "    end";
  protected final String TEXT_1470 = NL + "    unless @";
  protected final String TEXT_1471 = ".nil?" + NL + "      if @";
  protected final String TEXT_1472 = ".";
  protected final String TEXT_1473 = " <= ";
  protected final String TEXT_1474 = NL + "        @";
  protected final String TEXT_1475 = ".delete" + NL + "      else" + NL + "        @";
  protected final String TEXT_1476 = ".";
  protected final String TEXT_1477 = "(self)" + NL + "      end" + NL + "    end";
  protected final String TEXT_1478 = NL + "    @";
  protected final String TEXT_1479 = " = @";
  protected final String TEXT_1480 = NL + "    @";
  protected final String TEXT_1481 = " = nil" + NL + "    @";
  protected final String TEXT_1482 = ".";
  protected final String TEXT_1483 = "(self)";
  protected final String TEXT_1484 = NL + "    @";
  protected final String TEXT_1485 = ".each do |";
  protected final String TEXT_1486 = "|";
  protected final String TEXT_1487 = NL + "      ";
  protected final String TEXT_1488 = ".instance_variable_set(\"@";
  protected final String TEXT_1489 = "\",nil)" + NL + "    end" + NL + "    @";
  protected final String TEXT_1490 = ".clear";
  protected final String TEXT_1491 = NL + "    ";
  protected final String TEXT_1492 = " = @";
  protected final String TEXT_1493 = ".dup" + NL + "    @";
  protected final String TEXT_1494 = ".clear";
  protected final String TEXT_1495 = NL + "    ";
  protected final String TEXT_1496 = ".each do |";
  protected final String TEXT_1497 = "|" + NL + "      if ";
  protected final String TEXT_1498 = ".";
  protected final String TEXT_1499 = " <= ";
  protected final String TEXT_1500 = ".";
  protected final String TEXT_1501 = NL + "        ";
  protected final String TEXT_1502 = ".delete" + NL + "      else";
  protected final String TEXT_1503 = NL + "        ";
  protected final String TEXT_1504 = ".";
  protected final String TEXT_1505 = "(self)" + NL + "      end" + NL + "    end";
  protected final String TEXT_1506 = NL + "    ";
  protected final String TEXT_1507 = " = @";
  protected final String TEXT_1508 = ".dup" + NL + "    @";
  protected final String TEXT_1509 = ".clear";
  protected final String TEXT_1510 = NL + "    ";
  protected final String TEXT_1511 = ".each do |";
  protected final String TEXT_1512 = "|";
  protected final String TEXT_1513 = NL + "      ";
  protected final String TEXT_1514 = ".";
  protected final String TEXT_1515 = "(self)" + NL + "    end";
  protected final String TEXT_1516 = NL + "    @";
  protected final String TEXT_1517 = ".each do |";
  protected final String TEXT_1518 = "|";
  protected final String TEXT_1519 = NL + "      ";
  protected final String TEXT_1520 = ".delete" + NL + "    end";
  protected final String TEXT_1521 = NL + "    @";
  protected final String TEXT_1522 = ".each do |";
  protected final String TEXT_1523 = "|";
  protected final String TEXT_1524 = NL + "      ";
  protected final String TEXT_1525 = ".";
  protected final String TEXT_1526 = "(nil)" + NL + "    end";
  protected final String TEXT_1527 = NL + NL;
  protected final String TEXT_1528 = NL + "  #------------------------" + NL + "  # DEVELOPER CODE - PROVIDED AS-IS" + NL + "  #------------------------" + NL + "  ";
  protected final String TEXT_1529 = NL + "  ";
  protected final String TEXT_1530 = NL + "end";
  protected final String TEXT_1531 = NL;

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
  
    if (!av.isConstant() && !av.getIsAutounique())
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
    if (av.getIsAutounique() || av.isConstant() || "theInstance".equals(gen.translate("attributeOne",av)) || av.getIsDerived())
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
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_32);
    
      }
      else if (av.isOptionalOne() && av.isImmutable())
      {
        
    stringBuffer.append(TEXT_33);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_35);
    
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
  

    stringBuffer.append(TEXT_36);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_45);
    
      }
      else if (av.isOptionalN() && av.isImmutable())
      {
        
     String requiredNumber = "" + av.getMultiplicity().getUpperBound(); 
    stringBuffer.append(TEXT_46);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(gen.translate("didAddMany",av));
    
      }
      else if (av.isMany() && av.isImmutable())
      {
        
    stringBuffer.append(TEXT_55);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(gen.translate("didAddMany",av));
    
      }
      else if (av.isMany())
      {
        
    stringBuffer.append(TEXT_63);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_64);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_65);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_66);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_67);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_73);
    
    }
    else if ((av.isMN() || av.isN()) && (relatedAssociation.isMandatory() || relatedAssociation.isOptionalN()))
    {
      
    stringBuffer.append(TEXT_74);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_75);
    
    }
    else if (av.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_76);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(gen.translate("didAdd",av));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_83);
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
  

    stringBuffer.append(TEXT_84);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(gen.translate("parameterAll",av));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(gen.relatedTranslate("type",av));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(requiredNumber);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(gen.translate("didAddMany",av));
    stringBuffer.append(TEXT_93);
    
  }
  else if (av.getMultiplicity().getLowerBound() > 0)
  {
    
    stringBuffer.append(TEXT_94);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_96);
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
    
    stringBuffer.append(TEXT_97);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(gen.translate("stateOne",state));
    stringBuffer.append(TEXT_100);
    
    for (StateMachine nestedSm : sm.getNestedStateMachines())
    {
      
    stringBuffer.append(TEXT_101);
    stringBuffer.append(gen.translate("setMethod",nestedSm));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(gen.translate("type",nestedSm));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(gen.translate("stateNull",nestedSm));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(gen.translate("stateMachineOne",sm));
    stringBuffer.append(TEXT_105);
    
    }
  }
  
  if (customConstructorPostfixCode != null)
  {
    append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customConstructorPostfixCode, "    "));
  }

  appendln(stringBuffer, "\n    @initialized = true");
  append(stringBuffer, "  end");

    stringBuffer.append(TEXT_106);
     } 
    stringBuffer.append(TEXT_107);
    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
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
    
    if (av.isImmutable())
    {
      if (av.getIsLazy())
      {
        
    stringBuffer.append(TEXT_108);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_110);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_111);
    stringBuffer.append( gen.translate("attributeCanSet",av) );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_114);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_115);
    
      }
    }
    else if (av.getModifier().equals("defaulted"))
    {
      
    stringBuffer.append(TEXT_116);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_118);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_119);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_121);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_122);
    stringBuffer.append(gen.translate("resetMethod",av));
    stringBuffer.append(TEXT_123);
     if (customResetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_124);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
    stringBuffer.append(TEXT_126);
     if (customResetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customResetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_127);
    
    }
    else if (av.getIsList())
    {
      
    stringBuffer.append(TEXT_128);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_130);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_131);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(gen.translate("parameterOne",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_133);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_135);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_138);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_139);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_140);
    stringBuffer.append( gen.translate("setMethod",av) );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_142);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_143);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_145);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_146);
    
    }
  }

    
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
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
      
    stringBuffer.append(TEXT_147);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_148);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_149);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_151);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_152);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(gen.translate("getManyMethod",av));
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_154);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_159);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_160);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(gen.translate("numberOfMethod",av));
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_162);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_163);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_164);
    stringBuffer.append(gen.translate("hasManyMethod",av));
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_165);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_166);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_167);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_169);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_170);
    stringBuffer.append(gen.translate("attributeMany",av));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_172);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_173);
    
    }
    else 
    {

      if (av.getIsDerived() && customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_174);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_175);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_176);
    stringBuffer.append( gen.translate("parameterValue",av) );
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_177);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_178);
    
      }
      else if (av.getIsDerived())
      {
        
    stringBuffer.append(TEXT_179);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_180);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_181);
    
      }
      else if (customGetPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_182);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_183);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(gen.translate("attributeOne",av));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_185);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_186);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_187);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_188);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_189);
    
      }
      
      appendln(stringBuffer, "");
      
      if (av.getModifier().equals("defaulted") && customGetDefaultPostfixCode != null)
      {
        
    stringBuffer.append(TEXT_190);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_191);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_192);
    stringBuffer.append( gen.translate("parameterValue",av) );
     if (customGetDefaultPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_193);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_194);
    
      }
      else if (av.getModifier().equals("defaulted"))
      {
        
    stringBuffer.append(TEXT_195);
    stringBuffer.append(gen.translate("getDefaultMethod",av));
     if (customGetDefaultPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetDefaultPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_196);
    stringBuffer.append( gen.translate("parameterValue",av) );
    stringBuffer.append(TEXT_197);
    
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
        
    stringBuffer.append(TEXT_198);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_199);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(gen.translate("attributeOne",av));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_201);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_202);
    
      }
      else
      {
        
    stringBuffer.append(TEXT_203);
    stringBuffer.append( gen.translate("getMethod",av) );
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_204);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_205);
    
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

    String customGetPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("isMethod",av)));
    String customGetPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("isMethod",av)));
    
    if (av.getIsDerived() && customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_206);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_207);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_208);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_209);
    stringBuffer.append( gen.translate("parameterValue",av) );
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_210);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_211);
    
    }
    else if (av.getIsDerived())
    {
      
    stringBuffer.append(TEXT_212);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_213);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_214);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_215);
    
    }
    else if (customGetPostfixCode != null)
    {
      
    stringBuffer.append(TEXT_216);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_217);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_218);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(gen.translate("attributeOne",av));
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_220);
    stringBuffer.append( gen.translate("parameterOne",av) );
    stringBuffer.append(TEXT_221);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_222);
    stringBuffer.append( gen.translate("isMethod",av) );
    stringBuffer.append(TEXT_223);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_224);
    stringBuffer.append(gen.translate("attributeOne",av));
    stringBuffer.append(TEXT_225);
    
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
    
    stringBuffer.append(TEXT_226);
    stringBuffer.append(gen.translate("type",sm));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(gen.translate("getMethod",sm));
    stringBuffer.append(TEXT_228);
    stringBuffer.append( gen.translate("stateOne",sm) );
    stringBuffer.append(TEXT_229);
    
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

    stringBuffer.append(TEXT_230);
    stringBuffer.append(gen.translate("eventMethod",e));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(TEXT_232);
    stringBuffer.append( outputCases );
    stringBuffer.append(TEXT_233);
    
  }
}

    
{
  // GENERIC FILE - EDIT IN UmpleToTemplate project, then run "ant -f build.codegen.xml to move into the appropriate projects
  for (StateMachine sm : uClass.getAllStateMachines())  
  {

    if (sm.getType() == "Simple" && sm.numberOfStates() > 0)
    {
      
    stringBuffer.append(TEXT_234);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_235);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_236);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(TEXT_238);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_239);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_240);
    
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
    stringBuffer.append(TEXT_241);
    stringBuffer.append(gen.translate("exitMethod",sm));
    stringBuffer.append(TEXT_242);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(TEXT_244);
    stringBuffer.append( exitActions );
    stringBuffer.append(TEXT_245);
     } 
    stringBuffer.append(TEXT_246);
    stringBuffer.append(gen.translate("setMethod",sm));
    stringBuffer.append(TEXT_247);
    stringBuffer.append( gen.translate("type",sm) );
    stringBuffer.append(TEXT_248);
    stringBuffer.append( gen.translate("parameterOne",sm) );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(TEXT_250);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_251);
    stringBuffer.append( gen.translate("parameterOne",sm) );
     if (hasEntry) { 
    stringBuffer.append(TEXT_252);
    stringBuffer.append( gen.translate("stateMachineOne",sm) );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(TEXT_254);
    stringBuffer.append( entryActions );
    stringBuffer.append(TEXT_255);
     } 
    stringBuffer.append(TEXT_256);
    
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
      
    stringBuffer.append(TEXT_257);
    stringBuffer.append(gen.translate("getMethod",av));
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
     if (customGetPostfixCode == null) { 
    stringBuffer.append(TEXT_258);
    stringBuffer.append(gen.translate("associationOne",av));
     } else { 
    stringBuffer.append(TEXT_259);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(gen.translate("associationOne",av));
     append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); 
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_261);
    stringBuffer.append(gen.translate("parameterOne",av));
     } 
    stringBuffer.append(TEXT_262);
    
    }
    else if (av.isMany())
    {
      
    stringBuffer.append(TEXT_263);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_264);
     if (customGetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_265);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_267);
     if (customGetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_268);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(gen.translate("getManyMethod",av));
     if (customGetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_270);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_272);
     if (customGetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customGetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_273);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(gen.translate("numberOfMethod",av));
     if (customNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_275);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_276);
     if (customNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_277);
    stringBuffer.append(gen.translate("hasManyMethod",av));
     if (customHasManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_278);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_279);
     if (customHasManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customHasManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_280);
    stringBuffer.append(gen.translate("indexOfMethod",av));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_282);
     if (customIndexOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_283);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_285);
     if (customIndexOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIndexOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_286);
    
    }
    else
    {
      
    stringBuffer.append(TEXT_287);
    
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
      
    stringBuffer.append(TEXT_288);
    stringBuffer.append(av);
    stringBuffer.append(TEXT_289);
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
      
    stringBuffer.append(TEXT_290);
    stringBuffer.append(gen.translate("isNumberOfValidMethod",av));
     if (customIsNumberOfValidPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPrefixCode, "    ")); } 
     if (av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_291);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_293);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     } else { 
    stringBuffer.append(TEXT_294);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_296);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_299);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     } 
     if (customIsNumberOfValidPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customIsNumberOfValidPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_300);
    
    }
    
    if (hasRequiredNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customRequiredNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("requiredNumberOfMethod",av)));
    String customRequiredNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("requiredNumberOfMethod",av)));

     if (customRequiredNumberOfPrefixCode == null && customRequiredNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_301);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_303);
     } else { 
    stringBuffer.append(TEXT_304);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
     if (customRequiredNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_305);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customRequiredNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRequiredNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_306);
     } 
    
    }

    if (hasMinimumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMinimumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("minimumNumberOfMethod",av)));
    String customMinimumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("minimumNumberOfMethod",av)));

     if (customMinimumNumberOfPrefixCode == null && customMinimumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_307);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_309);
     } else { 
    stringBuffer.append(TEXT_310);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customMinimumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_311);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customMinimumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMinimumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_312);
     } 
    
    }
    
    if (hasMaximumNumberOfMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    
    String customMaximumNumberOfPrefixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", gen.translate("maximumNumberOfMethod",av)));
    String customMaximumNumberOfPostfixCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("after", gen.translate("maximumNumberOfMethod",av)));

     if (customMaximumNumberOfPrefixCode == null && customMaximumNumberOfPostfixCode == null) { 
    stringBuffer.append(TEXT_313);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_315);
     } else { 
    stringBuffer.append(TEXT_316);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customMaximumNumberOfPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_317);
    stringBuffer.append(av.getMultiplicity().getUpperBound());
     if (customMaximumNumberOfPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customMaximumNumberOfPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_318);
     } 
    
    }
    
    if (hasAddManyToManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_319);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_321);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.getMultiplicity().isUpperBoundMany()) { 
    stringBuffer.append(TEXT_322);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_324);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_325);
     } 
    stringBuffer.append(TEXT_326);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_334);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_335);
    
    }
    
    if (hasRemoveManyTemplateMethod)
    {
      if (addNewLine) { appendln(stringBuffer,""); }
      addNewLine = true;
      
    stringBuffer.append(TEXT_336);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_338);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_339);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_341);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_342);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_351);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_352);
    
    }

    if (addNewLine) { appendln(stringBuffer,""); }
    addNewLine = true;
    
    // How do you dynamically include a file in JET?!?
    if (includeFile == "association_SetUnidirectionalOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_353);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_355);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_356);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_358);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_359);
    
    }
    else if (includeFile == "association_SetUnidirectionalOne.jet")
    {
      
    stringBuffer.append(TEXT_360);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_362);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_363);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_366);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_367);
    
    }
    else if (includeFile == "association_SetOptionalOneToOne.jet")
    {
      
    stringBuffer.append(TEXT_368);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_370);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_371);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_378);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "      ")); } 
    stringBuffer.append(TEXT_379);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(gen.relatedTranslate("parameterOld",av));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_393);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_394);
    
    }
    else if (includeFile == "association_SetOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_395);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_397);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_398);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(gen.translate("associationOne",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_402);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_411);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_412);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_423);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_424);
    
    }
    else if (includeFile == "association_AddMandatoryManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_425);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_427);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_428);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_438);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_439);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_441);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_442);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_444);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_445);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_447);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_448);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_452);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_453);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_455);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_457);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_458);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_460);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_461);
    
    }
    else if (includeFile == "association_AddMNToOnlyOne.jet")
    {
      
    stringBuffer.append(TEXT_462);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_464);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_465);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_467);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_468);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_471);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_473);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_474);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_477);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_479);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_480);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_485);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_486);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_488);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_489);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_493);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_494);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_496);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_498);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_499);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_501);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_502);
    
    }
    else if (includeFile == "association_AddOptionalNToOne.jet")
    {
      
    stringBuffer.append(TEXT_503);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_505);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_506);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_508);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_509);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_521);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_522);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_524);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_525);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_531);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_532);
    
    }
    else if (includeFile == "association_SetOptionalNToMany.jet")
    {
      
    stringBuffer.append(TEXT_533);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_535);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_536);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_549);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_550);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_551);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_574);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_575);
    
    }
    else if (includeFile == "association_AddManyToOne.jet")
    {
      
    stringBuffer.append(TEXT_576);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_578);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_579);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(gen.relatedTranslate("parameterIsNew",av));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_590);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_591);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_593);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_594);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_600);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_601);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_602);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_604);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_605);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_616);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_617);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(gen.translate("getMethod",av));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(gen.translate("parameterCurrent",av));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_635);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_636);
    
    }
    else if (includeFile == "association_AddMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_637);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_639);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_640);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_642);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_643);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_645);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_646);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_648);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_655);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_656);
    
    }
    else if (includeFile == "association_AddMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_657);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_659);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_660);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_662);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_663);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_665);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_666);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(gen.relatedTranslate("indexOfMethod",av));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_675);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_676);
    
    }
    else if (includeFile == "association_SetOptionalOneToOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_677);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_679);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_680);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_685);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_690);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_700);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_701);
    
    }
    else if (includeFile == "association_SetOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_702);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_704);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_705);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_706);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_707);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_720);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_721);
    
    }
    else if (includeFile == "association_SetOneToAtMostN.jet")
    {
      
    stringBuffer.append(TEXT_722);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_724);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_725);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_728);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_729);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(relatedAssociation.getMultiplicity().getUpperBound());
    stringBuffer.append(TEXT_731);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_735);
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
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(gen.translate("parameterExisting",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_747);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_749);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_750);
    
    }
    else if (includeFile == "association_SetOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_751);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_753);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_754);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_757);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_758);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_763);
    stringBuffer.append(TEXT_764);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(gen.translate("parameterExisting",av));
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_775);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_777);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_778);
    
    }
    else if (includeFile == "association_AddManyToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_779);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_781);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_782);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(TEXT_787);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(TEXT_791);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(TEXT_795);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_799);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_800);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_802);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_803);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(TEXT_808);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_810);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_811);
    
    }
    else if (includeFile == "association_SetOptionalOneToMany.jet")
    {
      
    stringBuffer.append(TEXT_812);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_814);
     if (customSetPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_815);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_828);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_829);
     if (customSetPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_830);
    
    }
    else if (includeFile == "association_AddOptionalNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_831);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_833);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_834);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_836);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_837);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_840);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(TEXT_843);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_845);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_846);
    stringBuffer.append(TEXT_847);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_855);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_856);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_858);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_859);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(TEXT_864);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_866);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_867);
    
    }
    else if (includeFile == "association_AddUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_868);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_870);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_871);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_873);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_876);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_877);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_879);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_880);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_882);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_883);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_885);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_886);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_888);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_889);
    
    }
    else if (includeFile == "association_AddMNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_890);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_892);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
     if (!av.isStar()) { 
    stringBuffer.append(TEXT_893);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_895);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_896);
     } 
    stringBuffer.append(TEXT_897);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_902);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_904);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_905);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(TEXT_907);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_910);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_914);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_915);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_917);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_918);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_922);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(TEXT_926);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_927);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_928);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_929);
    
    }
    else if (includeFile == "association_SetNToOptionalOne.jet")
    {
      
    stringBuffer.append(TEXT_930);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_932);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_933);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(TEXT_935);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_939);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_940);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_944);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_945);
    stringBuffer.append(TEXT_946);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_950);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_951);
    stringBuffer.append(TEXT_952);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(TEXT_960);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(TEXT_963);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(gen.translate("associationNew",av));
    stringBuffer.append(TEXT_967);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_968);
    
    }
    else if (includeFile == "association_AddUnidirectionalMany.jet")
    {
      
    stringBuffer.append(TEXT_969);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_971);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_972);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_974);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_975);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_977);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_978);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_982);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_983);
    
    }
    else if (includeFile == "association_AddUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_984);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_986);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_987);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_989);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_992);
     if (customAddPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_993);
    stringBuffer.append(gen.translate("removeMethod",av));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_995);
     if (customRemovePrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePrefixCode, "    ")); } 
    stringBuffer.append(TEXT_996);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1000);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1001);
    
    }
    else if (includeFile == "association_AddUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1004);
     if (customAddPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customAddPrefixCode, "    ")); } 
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
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1013);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1019);
     if (customRemovePostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customRemovePostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1020);
    
    }
    else if (includeFile == "association_SetUnidirectionalN.jet")
    {
      
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1023);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(gen.translate("requiredNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1044);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1045);
    
    }
    else if (includeFile == "association_SetUnidirectionalMany.jet")
    {
    	
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1048);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1060);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1067);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1068);
    
    }
	else if (includeFile == "association_SetOptionalOneToMandatoryMany.jet")
    {
      
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1110);
    
    }
    else if (includeFile == "association_SetOptionalOneToMandatoryMN.jet")
    {
      
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(gen.translate("setMethod",av));
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(gen.relatedTranslate("maximumNumberOfMethod",av));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1148);
    
    }
    else if (includeFile != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile);
    }
    
    if (includeFile2 == "association_SetMNToMany.jet")
    {
      
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1151);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1192);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1193);
    
    }
    else if (includeFile2 == "association_SetMStarToMany.jet")
    {
      
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1196);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(gen.translate("parameterNew",av));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(gen.relatedTranslate("addMethod",av));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(gen.translate("parameterOldMany",av));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(gen.translate("parameterOld",av));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1234);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1235);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMN.jet")
    {
      
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1238);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1262);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1263);
    
    }
    else if (includeFile2 == "association_SetMNToOptionalOne.jet")
    {
      
    
  String existingToNewMap = StringFormatter.format("{0}ToNew{1}", relatedAssociation.getName(), av.getUpperCaseName());
  String orCheckMaxBound = av.isStar() ? "" : StringFormatter.format(" or {0}.size > {2}.{1}", gen.translate("parameterMany",av), gen.translate("maximumNumberOfMethod",av),uClass.getName());

    stringBuffer.append(TEXT_1264);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1266);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
    stringBuffer.append(orCheckMaxBound);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1279);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "        ")); } 
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(av.getMultiplicity().getLowerBound());
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "          ")); } 
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(existingToNewMap);
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(gen.relatedTranslate("parameterExisting",av));
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(gen.translate("parameterCheckNewMany",av));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(gen.relatedTranslate("getMethod",av));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1327);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1328);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalOptionalN.jet")
    {
      
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1331);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(gen.translate("maximumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1352);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1353);
    
    }
    else if (includeFile2 == "association_SetUnidirectionalMStar.jet")
    {
      
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(gen.translate("setManyMethod",av));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1356);
     if (customSetManyPrefixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPrefixCode, "    ")); } 
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1367);
    stringBuffer.append(gen.translate("parameterMany",av));
    stringBuffer.append(TEXT_1368);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(uClass.getName());
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(gen.translate("minimumNumberOfMethod",av));
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "      ")); } 
    stringBuffer.append(TEXT_1371);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(TEXT_1373);
    stringBuffer.append(gen.translate("parameterVerifiedMany",av));
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1377);
     if (customSetManyPostfixCode != null) { append(stringBuffer, "\n{0}",GeneratorHelper.doIndent(customSetManyPostfixCode, "    ")); } 
    stringBuffer.append(TEXT_1378);
    
    }
    else if (includeFile2 != null)
    {
      appendln(stringBuffer,"You forgot to include {0}",includeFile2);
    }
    
    if(includeFile3 == "association_Sort.jet" && !sortMethodAdded)
    {
      
    stringBuffer.append(TEXT_1379);
    
      sortMethodAdded = true; //after the sort method has been added, this boolean stops it from being added again
    }
    else if(includeFile3 == "association_AddIndexControlFunctions.jet")
    {
      
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(gen.translate("addMethod",av));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1388);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(gen.translate("addOrMoveAtMethod",av));
    stringBuffer.append(TEXT_1391);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(gen.translate("numberOfMethod",av));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(gen.translate("addAtMethod",av));
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1402);
    
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


    stringBuffer.append(TEXT_1403);
    stringBuffer.append(TEXT_1404);
    stringBuffer.append( checks.toString().trim() );
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(TEXT_1406);
    stringBuffer.append( hash.toString().trim() );
    stringBuffer.append(TEXT_1407);
    stringBuffer.append( canSet.toString().trim() );
    stringBuffer.append(TEXT_1408);
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
        
    stringBuffer.append(TEXT_1409);
    stringBuffer.append( gen.translate("doActivityMethod",state));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append( state.getActivity().getActivityCode() );
    stringBuffer.append(TEXT_1411);
    
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

    stringBuffer.append(TEXT_1412);
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(gen.translate("type",uClass));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(TEXT_1416);
    stringBuffer.append( output );
    stringBuffer.append(TEXT_1417);
    
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
        
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1419);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1420);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1421);
    stringBuffer.append( e.getTimerInSeconds() );
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(gen.translate("eventStopMethod",e) );
    stringBuffer.append(TEXT_1423);
    stringBuffer.append( gen.translate("eventHandler",e) );
    stringBuffer.append(TEXT_1424);
    
      }
    }
  }
  if (hasTimedEvents)
  {
    
    
 


    stringBuffer.append(TEXT_1425);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1426);
    stringBuffer.append( gen.translate("type",uClass) );
    stringBuffer.append(TEXT_1427);
    
  for(StateMachine sm : uClass.getStateMachines())
  {
    for (Event e : sm.getEvents())
    {
      if (e.getIsTimer())
      {
        
    stringBuffer.append(TEXT_1428);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1429);
    stringBuffer.append( gen.translate("eventMethod",e) );
    stringBuffer.append(TEXT_1430);
    stringBuffer.append( gen.translate("eventStartMethod",e) );
    stringBuffer.append(TEXT_1431);
    
      }
    }
  }

    stringBuffer.append(TEXT_1432);
    
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
        
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1434);
    
      }
      else if (av.isMany())
      {
        
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1436);
    
      }
      continue;
    }
    
    if (av.isOnlyOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1443);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1447);
    
    }
    else if (av.isOnlyOne() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1450);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1455);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(gen.translate("parameterExisting",av));
    stringBuffer.append(TEXT_1462);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isOptionalMany())
    {
      
    stringBuffer.append(TEXT_1463);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1466);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isN())
    {
      
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1469);
    
    }
    else if (av.isOptionalOne() && relatedAssociation.isMN())
    {
      
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(relatedAssociation.getMultiplicity().getLowerBound());
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1475);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1477);
    
    }
    else if (av.isOne() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(gen.translate("associationOne",av));
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(gen.translate("removeParameterOne",av));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1483);
    
    }
    else if (av.isMandatory() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(gen.relatedTranslate("associationOne",av));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1490);
    
    }
    else if (av.isMany() && (relatedAssociation.isMN() || relatedAssociation.isN()))
    {
      
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1494);
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(gen.relatedTranslate("numberOfMethod",av));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(gen.translate("type",av));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(gen.relatedTranslate("minimumNumberOfMethod",av));
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(TEXT_1503);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1505);
    
    }
    else if (av.isMany() && relatedAssociation.isMany())
    {
      
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(TEXT_1510);
    stringBuffer.append(gen.translate("parameterCopyOfMany",av));
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(gen.relatedTranslate("removeMethod",av));
    stringBuffer.append(TEXT_1515);
    
    }
    else if (av.isMany() && relatedAssociation.isOnlyOne())
    {
      
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1517);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1520);
    
    }
    else if (av.isMany() && relatedAssociation.isOptionalOne())
    {
      
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(gen.translate("associationMany",av));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(gen.translate("parameterOne",av));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(gen.relatedTranslate("setMethod",av));
    stringBuffer.append(TEXT_1526);
    
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
    		String customPreconditionCode = GeneratorHelper.toCode(uClass.getApplicableCodeInjections("before", aMethod.getName()+"Precondition"));
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
    		
    		String paramName="";
    	    String parameters = "";
    		if (aMethod.hasMethodParameters())
    		{
    			for (MethodParameter aMethodParam : aMethod.getMethodParameters()) 
    			{
    				paramName = aMethodParam.getName();
        			parameters += paramName + ",";
    			}
    			String finalParams = parameters.substring(0, parameters.length()-1);
    			appendln(stringBuffer, "");
    			
    			if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("RubyMultiline Internal", aMethod.getComments())); }
    			
    			append(stringBuffer, "  def {0} ({1})\n", methodName, finalParams);	
    			
    			if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
    			
    			appendln(stringBuffer, properMethodBody);
    			
				appendln(stringBuffer, "  end");
    			
    		}
    		else{
    			appendln(stringBuffer, "");
    			
    			if (aMethod.numberOfComments() > 0) { append(stringBuffer, "\n  {0}\n", Comment.format("RubyMultiline Internal", aMethod.getComments())); }
    			
    			append(stringBuffer, "  def {0}()\n", methodName);
    			
    			if (customPreconditionCode != null) { append(stringBuffer, "\n{0}\n",GeneratorHelper.doIndent(customPreconditionCode, "    "));}
    			
    			appendln(stringBuffer, properMethodBody);
    			
    			appendln(stringBuffer, "  end");
    		}
    	}
    }

    stringBuffer.append(TEXT_1527);
     } 
     if (uClass.getExtraCode() != null && uClass.getExtraCode().length() > 0) { 
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(uClass.getExtraCode());
     } 
    stringBuffer.append(TEXT_1530);
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(gen.translate("packageDefinitionEnd",uClass));
    return stringBuffer.toString();
  }
}